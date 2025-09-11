import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTableController extends ClockDomain{
  public RotaryTableController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableRequest = new Signal("rotaryTableRequest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private int S77 = 1;
  private int S13 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S77){
        case 0 : 
          S77=0;
          break RUN;
        
        case 1 : 
          S77=2;
          S77=2;
          System.out.println("Rotary table controller started");//sysj\controller.sysj line: 35, column: 5
          S13=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S13){
            case 0 : 
              if(enable.getprestatus()){//sysj\controller.sysj line: 39, column: 10
                S13=1;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 41, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 40, column: 10
                S13=2;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 41, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              if(!enable.getprestatus()){//sysj\controller.sysj line: 43, column: 10
                S13=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[3] != 0){
      int index = 3;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        if(!df){
          rotaryTableRequest.gethook();
          enable.gethook();
          tableAlignedWithSensorC.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableRequest.setpreclear();
      enable.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableRequest.getStatus() ? rotaryTableRequest.setprepresent() : rotaryTableRequest.setpreclear();
      rotaryTableRequest.setpreval(rotaryTableRequest.getValue());
      rotaryTableRequest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = tableAlignedWithSensorC.getStatus() ? tableAlignedWithSensorC.setprepresent() : tableAlignedWithSensorC.setpreclear();
      tableAlignedWithSensorC.setpreval(tableAlignedWithSensorC.getValue());
      tableAlignedWithSensorC.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        rotaryTableRequest.gethook();
        enable.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
