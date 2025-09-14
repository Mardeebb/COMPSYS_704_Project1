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
  public Signal gripperGripped = new Signal("gripperGripped", Signal.INPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private Signal releaseCap_3;
  private Signal raiseGripper_3;
  private Signal unclampBottle_3;
  private int S1373 = 1;
  private int S129 = 1;
  private int S155 = 1;
  private int S184 = 1;
  private int S164 = 1;
  private int S231 = 1;
  private int S191 = 1;
  private int S187 = 1;
  private int S190 = 1;
  private int S335 = 1;
  private int S249 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread2182(int [] tdone, int [] ends){
        switch(S335){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S249){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\controller.sysj line: 232, column: 14
              S249=1;
              System.out.println("Twist");//sysj\controller.sysj line: 235, column: 9
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 236, column: 9
              currsigs.addElement(gripperTurnExtend);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 234, column: 14
              releaseCap_3.setPresent();//sysj\controller.sysj line: 239, column: 8
              currsigs.addElement(releaseCap_3);
              S249=2;
              System.out.println("retract");//sysj\controller.sysj line: 241, column: 9
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 242, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 236, column: 9
              currsigs.addElement(gripperTurnExtend);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 240, column: 15
              S249=3;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 242, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 3 : 
            S249=3;
            raiseGripper_3.setPresent();//sysj\controller.sysj line: 245, column: 8
            currsigs.addElement(raiseGripper_3);
            System.err.println("raise the gripper");//sysj\controller.sysj line: 246, column: 8
            unclampBottle_3.setPresent();//sysj\controller.sysj line: 247, column: 8
            currsigs.addElement(unclampBottle_3);
            S249=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2180(int [] tdone, int [] ends){
        S190=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2179(int [] tdone, int [] ends){
        S187=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2177(int [] tdone, int [] ends){
        switch(S190){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\controller.sysj line: 221, column: 47
          S190=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread2176(int [] tdone, int [] ends){
        switch(S187){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 221, column: 14
          S187=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread2175(int [] tdone, int [] ends){
        switch(S231){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S191){
          case 0 : 
            thread2176(tdone,ends);
            thread2177(tdone,ends);
            int biggest2178 = 0;
            if(ends[7]>=biggest2178){
              biggest2178=ends[7];
            }
            if(ends[8]>=biggest2178){
              biggest2178=ends[8];
            }
            if(biggest2178 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest2178 == 0){
              System.out.println("gripped the cap");//sysj\controller.sysj line: 222, column: 7
              S191=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 224, column: 8
              currsigs.addElement(capGripperPos5Extend);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_3.getprestatus()){//sysj\controller.sysj line: 223, column: 13
              S191=0;
              thread2179(tdone,ends);
              thread2180(tdone,ends);
              int biggest2181 = 0;
              if(ends[7]>=biggest2181){
                biggest2181=ends[7];
              }
              if(ends[8]>=biggest2181){
                biggest2181=ends[8];
              }
              if(biggest2181 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 224, column: 8
              currsigs.addElement(capGripperPos5Extend);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2174(int [] tdone, int [] ends){
        switch(S184){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S164){
          case 0 : 
            if(raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 210, column: 13
              System.err.println("lifted");//sysj\controller.sysj line: 214, column: 7
              S164=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 212, column: 8
              currsigs.addElement(cylPos5ZAxisExtend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S164=1;
            S164=0;
            System.err.println("gripper lowered");//sysj\controller.sysj line: 211, column: 8
            cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 212, column: 8
            currsigs.addElement(cylPos5ZAxisExtend);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2173(int [] tdone, int [] ends){
        switch(S155){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 200, column: 13
          System.out.println("Bottle clamped");//sysj\controller.sysj line: 201, column: 8
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 202, column: 8
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 202, column: 8
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2171(int [] tdone, int [] ends){
        S335=1;
    S249=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2169(int [] tdone, int [] ends){
        S190=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2168(int [] tdone, int [] ends){
        S187=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2167(int [] tdone, int [] ends){
        S231=1;
    S191=0;
    thread2168(tdone,ends);
    thread2169(tdone,ends);
    int biggest2170 = 0;
    if(ends[7]>=biggest2170){
      biggest2170=ends[7];
    }
    if(ends[8]>=biggest2170){
      biggest2170=ends[8];
    }
    if(biggest2170 == 1){
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2166(int [] tdone, int [] ends){
        S184=1;
    S164=0;
    System.err.println("gripper lowered");//sysj\controller.sysj line: 211, column: 8
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 212, column: 8
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2165(int [] tdone, int [] ends){
        S155=1;
    System.out.println("Bottle clamped");//sysj\controller.sysj line: 201, column: 8
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 202, column: 8
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
      switch(S1373){
        case 0 : 
          S1373=0;
          break RUN;
        
        case 1 : 
          S1373=2;
          S1373=2;
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          System.out.println("waiting");//sysj\controller.sysj line: 193, column: 4
          S129=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          switch(S129){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 194, column: 10
                System.out.println("Capper doing work");//sysj\controller.sysj line: 195, column: 5
                S129=1;
                thread2165(tdone,ends);
                thread2166(tdone,ends);
                thread2167(tdone,ends);
                thread2171(tdone,ends);
                int biggest2172 = 0;
                if(ends[4]>=biggest2172){
                  biggest2172=ends[4];
                }
                if(ends[5]>=biggest2172){
                  biggest2172=ends[5];
                }
                if(ends[6]>=biggest2172){
                  biggest2172=ends[6];
                }
                if(ends[9]>=biggest2172){
                  biggest2172=ends[9];
                }
                if(biggest2172 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              thread2173(tdone,ends);
              thread2174(tdone,ends);
              thread2175(tdone,ends);
              thread2182(tdone,ends);
              int biggest2183 = 0;
              if(ends[4]>=biggest2183){
                biggest2183=ends[4];
              }
              if(ends[5]>=biggest2183){
                biggest2183=ends[5];
              }
              if(ends[6]>=biggest2183){
                biggest2183=ends[6];
              }
              if(ends[9]>=biggest2183){
                biggest2183=ends[9];
              }
              if(biggest2183 == 1){
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2183 == 0){
                S129=2;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              S129=2;
              System.out.println("waiting");//sysj\controller.sysj line: 193, column: 4
              S129=0;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_3 = new Signal();
    raiseGripper_3 = new Signal();
    unclampBottle_3 = new Signal();
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
      gripperGripped.setpreclear();
      cylClamped.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      releaseCap_3.setpreclear();
      raiseGripper_3.setpreclear();
      unclampBottle_3.setpreclear();
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
      releaseCap_3.setClear();
      raiseGripper_3.setClear();
      unclampBottle_3.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
        gripperGripped.gethook();
        cylClamped.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
