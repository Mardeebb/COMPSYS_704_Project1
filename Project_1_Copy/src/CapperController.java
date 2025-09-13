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
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S595 = 1;
  private int S146 = 1;
  private int S128 = 1;
  private int S133 = 1;
  private int S151 = 1;
  private int S156 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread1397(int [] tdone, int [] ends){
        switch(S156){
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

  public void thread1396(int [] tdone, int [] ends){
        switch(S151){
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

  public void thread1394(int [] tdone, int [] ends){
        S156=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 206, column: 43
    currsigs.addElement(gripperTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1393(int [] tdone, int [] ends){
        S151=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 206, column: 8
    currsigs.addElement(capGripperPos5Extend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1391(int [] tdone, int [] ends){
        switch(S133){
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

  public void thread1390(int [] tdone, int [] ends){
        switch(S128){
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

  public void thread1388(int [] tdone, int [] ends){
        S133=1;
    cylPos5ZaxisExtend.setPresent();//sysj\controller.sysj line: 198, column: 42
    currsigs.addElement(cylPos5ZaxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1387(int [] tdone, int [] ends){
        S128=1;
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
      switch(S595){
        case 0 : 
          S595=0;
          break RUN;
        
        case 1 : 
          S595=2;
          S595=2;
          System.out.println("Capper CD");//sysj\controller.sysj line: 188, column: 2
          S146=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S146){
            case 0 : 
              S146=0;
              S146=1;
              thread1387(tdone,ends);
              thread1388(tdone,ends);
              int biggest1389 = 0;
              if(ends[4]>=biggest1389){
                biggest1389=ends[4];
              }
              if(ends[5]>=biggest1389){
                biggest1389=ends[5];
              }
              if(biggest1389 == 1){
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 197, column: 11
                S146=2;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1390(tdone,ends);
                thread1391(tdone,ends);
                int biggest1392 = 0;
                if(ends[4]>=biggest1392){
                  biggest1392=ends[4];
                }
                if(ends[5]>=biggest1392){
                  biggest1392=ends[5];
                }
                if(biggest1392 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1392 == 0){
                  S146=2;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 2 : 
              S146=2;
              S146=3;
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 204, column: 13
                thread1393(tdone,ends);
                thread1394(tdone,ends);
                int biggest1395 = 0;
                if(ends[6]>=biggest1395){
                  biggest1395=ends[6];
                }
                if(ends[7]>=biggest1395){
                  biggest1395=ends[7];
                }
                if(biggest1395 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                S146=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 205, column: 12
                S146=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1396(tdone,ends);
                thread1397(tdone,ends);
                int biggest1398 = 0;
                if(ends[6]>=biggest1398){
                  biggest1398=ends[6];
                }
                if(ends[7]>=biggest1398){
                  biggest1398=ends[7];
                }
                if(biggest1398 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1398 == 0){
                  S146=0;
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
      gripperTurnRetract.setpreclear();
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
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
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
