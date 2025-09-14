import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

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
  public Signal capperStart = new Signal("capperStart", Signal.INPUT);
  public Signal gripperGripped = new Signal("gripperGripped", Signal.INPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private Signal releaseCap_1;
  private Signal raiseGripper_1;
  private Signal unclampBottle_1;
  private long __start_thread_3;//sysj\capperController.sysj line: 28, column: 4
  private int S2276 = 1;
  private int S1655 = 1;
  private int S1798 = 1;
  private int S1702 = 1;
  private int S1845 = 1;
  private int S1805 = 1;
  private int S1801 = 1;
  private int S1804 = 1;
  private int S1949 = 1;
  private int S1863 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2295(int [] tdone, int [] ends){
        switch(S1949){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1863){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\capperController.sysj line: 54, column: 11
              S1863=1;
              System.out.println("Twist");//sysj\capperController.sysj line: 57, column: 6
              gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 58, column: 6
              currsigs.addElement(gripperTurnExtend);
              System.out.println("Emitted gripperTurnExtend");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\capperController.sysj line: 56, column: 11
              releaseCap_1.setPresent();//sysj\capperController.sysj line: 61, column: 5
              currsigs.addElement(releaseCap_1);
              System.out.println("Emitted releaseCap_1");
              S1863=2;
              System.out.println("retract");//sysj\capperController.sysj line: 63, column: 6
              gripperTurnRetract.setPresent();//sysj\capperController.sysj line: 64, column: 6
              currsigs.addElement(gripperTurnRetract);
              System.out.println("Emitted gripperTurnRetract");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 58, column: 6
              currsigs.addElement(gripperTurnExtend);
              System.out.println("Emitted gripperTurnExtend");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\capperController.sysj line: 62, column: 12
              raiseGripper_1.setPresent();//sysj\capperController.sysj line: 66, column: 5
              currsigs.addElement(raiseGripper_1);
              System.out.println("Emitted raiseGripper_1");
              System.err.println("raise the gripper");//sysj\capperController.sysj line: 67, column: 5
              unclampBottle_1.setPresent();//sysj\capperController.sysj line: 68, column: 5
              currsigs.addElement(unclampBottle_1);
              System.out.println("Emitted unclampBottle_1");
              S1863=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\capperController.sysj line: 64, column: 6
              currsigs.addElement(gripperTurnRetract);
              System.out.println("Emitted gripperTurnRetract");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2293(int [] tdone, int [] ends){
        S1804=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2292(int [] tdone, int [] ends){
        S1801=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2290(int [] tdone, int [] ends){
        switch(S1804){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\capperController.sysj line: 43, column: 45
          S1804=0;
          active[6]=0;
          ends[6]=0;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread2289(int [] tdone, int [] ends){
        switch(S1801){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\capperController.sysj line: 43, column: 12
          S1801=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread2288(int [] tdone, int [] ends){
        switch(S1845){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1805){
          case 0 : 
            thread2289(tdone,ends);
            thread2290(tdone,ends);
            int biggest2291 = 0;
            if(ends[5]>=biggest2291){
              biggest2291=ends[5];
            }
            if(ends[6]>=biggest2291){
              biggest2291=ends[6];
            }
            if(biggest2291 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest2291 == 0){
              System.out.println("gripped the cap");//sysj\capperController.sysj line: 44, column: 5
              S1805=1;
              capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 46, column: 6
              currsigs.addElement(capGripperPos5Extend);
              System.out.println("Emitted capGripperPos5Extend");
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_1.getprestatus()){//sysj\capperController.sysj line: 45, column: 11
              S1805=0;
              thread2292(tdone,ends);
              thread2293(tdone,ends);
              int biggest2294 = 0;
              if(ends[5]>=biggest2294){
                biggest2294=ends[5];
              }
              if(ends[6]>=biggest2294){
                biggest2294=ends[6];
              }
              if(biggest2294 == 1){
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 46, column: 6
              currsigs.addElement(capGripperPos5Extend);
              System.out.println("Emitted capGripperPos5Extend");
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2287(int [] tdone, int [] ends){
        switch(S1798){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1702){
          case 0 : 
            if(com.systemj.Timer.getMs() - __start_thread_3 >= (4) * 1000){//sysj\capperController.sysj line: 28, column: 4
              ends[3]=2;
              ;//sysj\capperController.sysj line: 28, column: 4
              S1702=1;
              System.err.println("gripper lowered");//sysj\capperController.sysj line: 32, column: 6
              cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 33, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              System.out.println("Emitted cylPos5ZAxisExtend");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(raiseGripper_1.getprestatus()){//sysj\capperController.sysj line: 31, column: 11
              System.err.println("lifted");//sysj\capperController.sysj line: 35, column: 5
              S1702=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 33, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              System.out.println("Emitted cylPos5ZAxisExtend");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S1702=2;
            S1702=0;
            __start_thread_3 = com.systemj.Timer.getMs();//sysj\capperController.sysj line: 28, column: 4
            if(com.systemj.Timer.getMs() - __start_thread_3 >= (4) * 1000){//sysj\capperController.sysj line: 28, column: 4
              ends[3]=2;
              ;//sysj\capperController.sysj line: 28, column: 4
              S1702=1;
              System.err.println("gripper lowered");//sysj\capperController.sysj line: 32, column: 6
              cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 33, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              System.out.println("Emitted cylPos5ZAxisExtend");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2286(int [] tdone, int [] ends){
        switch(S1655){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(unclampBottle_1.getprestatus()){//sysj\capperController.sysj line: 19, column: 11
          System.out.println("Bottle clamped");//sysj\capperController.sysj line: 20, column: 6
          cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 21, column: 6
          currsigs.addElement(cylClampBottleExtend);
          System.out.println("Emitted cylClampBottleExtend");
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 21, column: 6
          currsigs.addElement(cylClampBottleExtend);
          System.out.println("Emitted cylClampBottleExtend");
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread2284(int [] tdone, int [] ends){
        S1949=1;
    S1863=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2282(int [] tdone, int [] ends){
        S1804=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2281(int [] tdone, int [] ends){
        S1801=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2280(int [] tdone, int [] ends){
        S1845=1;
    S1805=0;
    thread2281(tdone,ends);
    thread2282(tdone,ends);
    int biggest2283 = 0;
    if(ends[5]>=biggest2283){
      biggest2283=ends[5];
    }
    if(ends[6]>=biggest2283){
      biggest2283=ends[6];
    }
    if(biggest2283 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2279(int [] tdone, int [] ends){
        S1798=1;
    S1702=0;
    __start_thread_3 = com.systemj.Timer.getMs();//sysj\capperController.sysj line: 28, column: 4
    if(com.systemj.Timer.getMs() - __start_thread_3 >= (4) * 1000){//sysj\capperController.sysj line: 28, column: 4
      ends[3]=2;
      ;//sysj\capperController.sysj line: 28, column: 4
      S1702=1;
      System.err.println("gripper lowered");//sysj\capperController.sysj line: 32, column: 6
      cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 33, column: 6
      currsigs.addElement(cylPos5ZAxisExtend);
      System.out.println("Emitted cylPos5ZAxisExtend");
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread2278(int [] tdone, int [] ends){
        S1655=1;
    System.out.println("Bottle clamped");//sysj\capperController.sysj line: 20, column: 6
    cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 21, column: 6
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2276){
        case 0 : 
          S2276=0;
          break RUN;
        
        case 1 : 
          S2276=2;
          S2276=2;
          System.out.println("Capper CD");//sysj\capperController.sysj line: 11, column: 2
          releaseCap_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          raiseGripper_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          unclampBottle_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          thread2278(tdone,ends);
          thread2279(tdone,ends);
          thread2280(tdone,ends);
          thread2284(tdone,ends);
          int biggest2285 = 0;
          if(ends[2]>=biggest2285){
            biggest2285=ends[2];
          }
          if(ends[3]>=biggest2285){
            biggest2285=ends[3];
          }
          if(ends[4]>=biggest2285){
            biggest2285=ends[4];
          }
          if(ends[7]>=biggest2285){
            biggest2285=ends[7];
          }
          if(biggest2285 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          releaseCap_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          raiseGripper_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          unclampBottle_1.setClear();//sysj\capperController.sysj line: 13, column: 3
          thread2286(tdone,ends);
          thread2287(tdone,ends);
          thread2288(tdone,ends);
          thread2295(tdone,ends);
          int biggest2296 = 0;
          if(ends[2]>=biggest2296){
            biggest2296=ends[2];
          }
          if(ends[3]>=biggest2296){
            biggest2296=ends[3];
          }
          if(ends[4]>=biggest2296){
            biggest2296=ends[4];
          }
          if(ends[7]>=biggest2296){
            biggest2296=ends[7];
          }
          if(biggest2296 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2296 == 0){
            S2276=0;
            active[1]=0;
            ends[1]=0;
            S2276=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_1 = new Signal();
    raiseGripper_1 = new Signal();
    unclampBottle_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          capperStart.gethook();
          gripperGripped.gethook();
          cylClamped.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      capperStart.setpreclear();
      gripperGripped.setpreclear();
      cylClamped.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      releaseCap_1.setpreclear();
      raiseGripper_1.setpreclear();
      unclampBottle_1.setpreclear();
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
      dummyint = capperStart.getStatus() ? capperStart.setprepresent() : capperStart.setpreclear();
      capperStart.setpreval(capperStart.getValue());
      capperStart.setClear();
      dummyint = gripperGripped.getStatus() ? gripperGripped.setprepresent() : gripperGripped.setpreclear();
      gripperGripped.setpreval(gripperGripped.getValue());
      gripperGripped.setClear();
      dummyint = cylClamped.getStatus() ? cylClamped.setprepresent() : cylClamped.setpreclear();
      cylClamped.setpreval(cylClamped.getValue());
      cylClamped.setClear();
      cylPos5ZAxisExtend.sethook();
      cylPos5ZAxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      releaseCap_1.setClear();
      raiseGripper_1.setClear();
      unclampBottle_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
        capperStart.gethook();
        gripperGripped.gethook();
        cylClamped.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
