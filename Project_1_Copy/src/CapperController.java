import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetracted = new Signal("gripperTurnRetracted", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S605 = 1;
  private int S125 = 1;
  private int S130 = 1;
  private int S135 = 1;
  private int S152 = 1;
  private int S157 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread1407(int [] tdone, int [] ends){
        switch(S157){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 206, column: 43
        currsigs.addElement(gripperTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread1406(int [] tdone, int [] ends){
        switch(S152){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 206, column: 8
        currsigs.addElement(capGripperPos5Extend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread1404(int [] tdone, int [] ends){
        S157=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 206, column: 43
    currsigs.addElement(gripperTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1403(int [] tdone, int [] ends){
        S152=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 206, column: 8
    currsigs.addElement(capGripperPos5Extend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1401(int [] tdone, int [] ends){
        switch(S135){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\controller.sysj line: 198, column: 42
        currsigs.addElement(cylPos5ZaxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1400(int [] tdone, int [] ends){
        switch(S130){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 198, column: 7
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread1398(int [] tdone, int [] ends){
        S135=1;
    cylPos5ZaxisExtend.setPresent();//sysj\controller.sysj line: 198, column: 42
    currsigs.addElement(cylPos5ZaxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1397(int [] tdone, int [] ends){
        S130=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 198, column: 7
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S605){
        case 0 : 
          S605=0;
          break RUN;
        
        case 1 : 
          S605=2;
          S605=2;
          System.out.println("Capper CD");//sysj\controller.sysj line: 188, column: 2
          S125=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S125){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 193, column: 11
                S125=1;
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
              S125=1;
              S125=2;
              thread1397(tdone,ends);
              thread1398(tdone,ends);
              int biggest1399 = 0;
              if(ends[4]>=biggest1399){
                biggest1399=ends[4];
              }
              if(ends[5]>=biggest1399){
                biggest1399=ends[5];
              }
              if(biggest1399 == 1){
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 197, column: 11
                S125=3;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1400(tdone,ends);
                thread1401(tdone,ends);
                int biggest1402 = 0;
                if(ends[4]>=biggest1402){
                  biggest1402=ends[4];
                }
                if(ends[5]>=biggest1402){
                  biggest1402=ends[5];
                }
                if(biggest1402 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1402 == 0){
                  S125=3;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S125=3;
              S125=4;
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 204, column: 13
                thread1403(tdone,ends);
                thread1404(tdone,ends);
                int biggest1405 = 0;
                if(ends[6]>=biggest1405){
                  biggest1405=ends[6];
                }
                if(ends[7]>=biggest1405){
                  biggest1405=ends[7];
                }
                if(biggest1405 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                S125=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 4 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 205, column: 12
                S125=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1406(tdone,ends);
                thread1407(tdone,ends);
                int biggest1408 = 0;
                if(ends[6]>=biggest1408){
                  biggest1408=ends[6];
                }
                if(ends[7]>=biggest1408){
                  biggest1408=ends[7];
                }
                if(biggest1408 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1408 == 0){
                  S125=0;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetracted.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      cylPos5ZaxisExtend.sethook();
      cylPos5ZaxisExtend.setClear();
      gripperTurnRetracted.sethook();
      gripperTurnRetracted.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
