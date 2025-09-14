import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

public class rotController extends ClockDomain{
  public rotController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal turn = new Signal("turn", Signal.INPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private int S2077 = 1;
  private int S2013 = 1;
  
  private int[] ends = new int[21];
  private int[] tdone = new int[21];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2077){
        case 0 : 
          S2077=0;
          break RUN;
        
        case 1 : 
          S2077=2;
          S2077=2;
          System.out.println("Controller startedh");//sysj\controller.sysj line: 270, column: 5
          S2013=0;
          active[14]=1;
          ends[14]=1;
          break RUN;
        
        case 2 : 
          switch(S2013){
            case 0 : 
              if(turn.getprestatus()){//sysj\controller.sysj line: 274, column: 10
                S2013=1;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 277, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
              else {
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
            
            case 1 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 276, column: 10
                S2013=2;
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 277, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
            
            case 2 : 
              if(!turn.getprestatus()){//sysj\controller.sysj line: 279, column: 10
                S2013=0;
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
              else {
                active[14]=1;
                ends[14]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[14] != 0){
      int index = 14;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        if(!df){
          turn.gethook();
          tableAlignedWithSensorC.gethook();
          df = true;
        }
        runClockDomain();
      }
      turn.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = turn.getStatus() ? turn.setprepresent() : turn.setpreclear();
      turn.setpreval(turn.getValue());
      turn.setClear();
      dummyint = tableAlignedWithSensorC.getStatus() ? tableAlignedWithSensorC.setprepresent() : tableAlignedWithSensorC.setpreclear();
      tableAlignedWithSensorC.setpreval(tableAlignedWithSensorC.getValue());
      tableAlignedWithSensorC.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        turn.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[14] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
