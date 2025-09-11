import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

public class rController extends ClockDomain{
  public rController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private BottleTwin b_thread_4;//sysj\controller.sysj line: 186, column: 4
  private int ID_thread_4;//sysj\controller.sysj line: 187, column: 4
  private String name_thread_4;//sysj\controller.sysj line: 188, column: 4
  private int S174 = 1;
  private int S102 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S174){
        case 0 : 
          S174=0;
          break RUN;
        
        case 1 : 
          S174=2;
          S174=2;
          System.out.println("Controller startedh");//sysj\controller.sysj line: 181, column: 5
          S102=0;
          active[4]=1;
          ends[4]=1;
          break RUN;
        
        case 2 : 
          switch(S102){
            case 0 : 
              if(enable.getprestatus()){//sysj\controller.sysj line: 185, column: 10
                b_thread_4 = (BottleTwin)(enable.getpreval() == null ? null : ((BottleTwin)enable.getpreval()));//sysj\controller.sysj line: 186, column: 4
                ID_thread_4 = b_thread_4.ID;//sysj\controller.sysj line: 187, column: 4
                name_thread_4 = b_thread_4.name;//sysj\controller.sysj line: 188, column: 4
                System.out.println("fffffffffffffffffffffffffffffffffffff " + b_thread_4);//sysj\controller.sysj line: 189, column: 7
                System.out.println("fffffffffffffffffffffffffffffffffffff " + ID_thread_4);//sysj\controller.sysj line: 190, column: 7
                System.out.println("fffffffffffffffffffffffffffffffffffff " + name_thread_4);//sysj\controller.sysj line: 191, column: 7
                S102=1;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 194, column: 5
                currsigs.addElement(rotaryTableTrigger);
                System.out.println("Emitted rotaryTableTrigger");
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
              else {
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
            
            case 1 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 193, column: 10
                S102=2;
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 194, column: 5
                currsigs.addElement(rotaryTableTrigger);
                System.out.println("Emitted rotaryTableTrigger");
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
            
            case 2 : 
              if(!enable.getprestatus()){//sysj\controller.sysj line: 196, column: 10
                S102=0;
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
              else {
                active[4]=1;
                ends[4]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[4] != 0){
      int index = 4;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[4]!=0 || suspended[4]!=0 || active[4]!=1);
      else{
        if(!df){
          enable.gethook();
          tableAlignedWithSensorC.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = tableAlignedWithSensorC.getStatus() ? tableAlignedWithSensorC.setprepresent() : tableAlignedWithSensorC.setpreclear();
      tableAlignedWithSensorC.setpreval(tableAlignedWithSensorC.getValue());
      tableAlignedWithSensorC.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[4]!=0 || suspended[4]!=0 || active[4]!=1);
      else{
        enable.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[4] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
