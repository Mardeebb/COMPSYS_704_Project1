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
  private long __start_thread_5;//sysj\controller.sysj line: 208, column: 6
  private long __start_thread_9;//sysj\controller.sysj line: 230, column: 7
  private int S7015 = 1;
  private int S1273 = 1;
  private int S152 = 1;
  private int S339 = 1;
  private int S161 = 1;
  private int S163 = 1;
  private int S386 = 1;
  private int S346 = 1;
  private int S342 = 1;
  private int S345 = 1;
  private int S698 = 1;
  private int S404 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread7832(int [] tdone, int [] ends){
        S698=1;
    S404=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread7830(int [] tdone, int [] ends){
        S345=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7829(int [] tdone, int [] ends){
        S342=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7828(int [] tdone, int [] ends){
        S386=1;
    S346=0;
    thread7829(tdone,ends);
    thread7830(tdone,ends);
    int biggest7831 = 0;
    if(ends[7]>=biggest7831){
      biggest7831=ends[7];
    }
    if(ends[8]>=biggest7831){
      biggest7831=ends[8];
    }
    if(biggest7831 == 1){
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7827(int [] tdone, int [] ends){
        S339=1;
    S161=0;
    System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 8
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7826(int [] tdone, int [] ends){
        S152=1;
    System.out.println("Bottle clamped");//sysj\controller.sysj line: 200, column: 8
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 201, column: 8
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread7824(int [] tdone, int [] ends){
        switch(S698){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S404){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\controller.sysj line: 231, column: 14
              S404=1;
              System.out.println("Twist");//sysj\controller.sysj line: 234, column: 9
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 235, column: 9
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
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 233, column: 14
              releaseCap_3.setPresent();//sysj\controller.sysj line: 238, column: 8
              currsigs.addElement(releaseCap_3);
              S404=2;
              System.out.println("retract");//sysj\controller.sysj line: 240, column: 9
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 241, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 235, column: 9
              currsigs.addElement(gripperTurnExtend);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 239, column: 15
              S404=3;
              __start_thread_9 = com.systemj.Timer.getMs();//sysj\controller.sysj line: 230, column: 7
              if(com.systemj.Timer.getMs() - __start_thread_9 >= (3) * 1000){//sysj\controller.sysj line: 230, column: 7
                ends[9]=2;
                ;//sysj\controller.sysj line: 230, column: 7
                raiseGripper_3.setPresent();//sysj\controller.sysj line: 244, column: 8
                currsigs.addElement(raiseGripper_3);
                System.err.println("raise the gripper");//sysj\controller.sysj line: 245, column: 8
                unclampBottle_3.setPresent();//sysj\controller.sysj line: 246, column: 8
                currsigs.addElement(unclampBottle_3);
                S404=0;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 241, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 3 : 
            if(com.systemj.Timer.getMs() - __start_thread_9 >= (3) * 1000){//sysj\controller.sysj line: 230, column: 7
              ends[9]=2;
              ;//sysj\controller.sysj line: 230, column: 7
              raiseGripper_3.setPresent();//sysj\controller.sysj line: 244, column: 8
              currsigs.addElement(raiseGripper_3);
              System.err.println("raise the gripper");//sysj\controller.sysj line: 245, column: 8
              unclampBottle_3.setPresent();//sysj\controller.sysj line: 246, column: 8
              currsigs.addElement(unclampBottle_3);
              S404=0;
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
          
        }
        break;
      
    }
  }

  public void thread7822(int [] tdone, int [] ends){
        S345=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7821(int [] tdone, int [] ends){
        S342=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7819(int [] tdone, int [] ends){
        switch(S345){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\controller.sysj line: 220, column: 47
          S345=0;
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

  public void thread7818(int [] tdone, int [] ends){
        switch(S342){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 220, column: 14
          S342=0;
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

  public void thread7817(int [] tdone, int [] ends){
        switch(S386){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S346){
          case 0 : 
            thread7818(tdone,ends);
            thread7819(tdone,ends);
            int biggest7820 = 0;
            if(ends[7]>=biggest7820){
              biggest7820=ends[7];
            }
            if(ends[8]>=biggest7820){
              biggest7820=ends[8];
            }
            if(biggest7820 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest7820 == 0){
              System.out.println("gripped the cap");//sysj\controller.sysj line: 221, column: 7
              S346=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 223, column: 8
              currsigs.addElement(capGripperPos5Extend);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_3.getprestatus()){//sysj\controller.sysj line: 222, column: 13
              S346=0;
              thread7821(tdone,ends);
              thread7822(tdone,ends);
              int biggest7823 = 0;
              if(ends[7]>=biggest7823){
                biggest7823=ends[7];
              }
              if(ends[8]>=biggest7823){
                biggest7823=ends[8];
              }
              if(biggest7823 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 223, column: 8
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

  public void thread7816(int [] tdone, int [] ends){
        switch(S339){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S161){
          case 0 : 
            if(raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 209, column: 13
              System.err.println("lifted");//sysj\controller.sysj line: 213, column: 7
              S161=1;
              __start_thread_5 = com.systemj.Timer.getMs();//sysj\controller.sysj line: 208, column: 6
              S163=0;
              if(com.systemj.Timer.getMs() - __start_thread_5 >= (3) * 1000){//sysj\controller.sysj line: 208, column: 6
                ends[5]=2;
                ;//sysj\controller.sysj line: 208, column: 6
                S161=0;
                System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 8
                cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
                currsigs.addElement(cylPos5ZAxisExtend);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S163=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
              currsigs.addElement(cylPos5ZAxisExtend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            switch(S163){
              case 0 : 
                S163=0;
                if(com.systemj.Timer.getMs() - __start_thread_5 >= (3) * 1000){//sysj\controller.sysj line: 208, column: 6
                  ends[5]=2;
                  ;//sysj\controller.sysj line: 208, column: 6
                  S161=0;
                  System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 8
                  cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
                  currsigs.addElement(cylPos5ZAxisExtend);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S163=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                break;
              
              case 1 : 
                S163=1;
                S163=0;
                if(com.systemj.Timer.getMs() - __start_thread_5 >= (3) * 1000){//sysj\controller.sysj line: 208, column: 6
                  ends[5]=2;
                  ;//sysj\controller.sysj line: 208, column: 6
                  S161=0;
                  System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 8
                  cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
                  currsigs.addElement(cylPos5ZAxisExtend);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S163=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7815(int [] tdone, int [] ends){
        switch(S152){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 199, column: 13
          System.out.println("Bottle clamped");//sysj\controller.sysj line: 200, column: 8
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 201, column: 8
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 201, column: 8
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread7813(int [] tdone, int [] ends){
        S698=1;
    S404=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread7811(int [] tdone, int [] ends){
        S345=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7810(int [] tdone, int [] ends){
        S342=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7809(int [] tdone, int [] ends){
        S386=1;
    S346=0;
    thread7810(tdone,ends);
    thread7811(tdone,ends);
    int biggest7812 = 0;
    if(ends[7]>=biggest7812){
      biggest7812=ends[7];
    }
    if(ends[8]>=biggest7812){
      biggest7812=ends[8];
    }
    if(biggest7812 == 1){
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7808(int [] tdone, int [] ends){
        S339=1;
    S161=0;
    System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 8
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 8
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7807(int [] tdone, int [] ends){
        S152=1;
    System.out.println("Bottle clamped");//sysj\controller.sysj line: 200, column: 8
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 201, column: 8
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
      switch(S7015){
        case 0 : 
          S7015=0;
          break RUN;
        
        case 1 : 
          S7015=2;
          S7015=2;
          System.out.println("Capper CD");//sysj\controller.sysj line: 189, column: 2
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          S1273=0;
          if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 193, column: 12
            System.out.println("Capper doing work");//sysj\controller.sysj line: 194, column: 5
            thread7807(tdone,ends);
            thread7808(tdone,ends);
            thread7809(tdone,ends);
            thread7813(tdone,ends);
            int biggest7814 = 0;
            if(ends[4]>=biggest7814){
              biggest7814=ends[4];
            }
            if(ends[5]>=biggest7814){
              biggest7814=ends[5];
            }
            if(ends[6]>=biggest7814){
              biggest7814=ends[6];
            }
            if(ends[9]>=biggest7814){
              biggest7814=ends[9];
            }
            if(biggest7814 == 1){
              active[3]=1;
              ends[3]=1;
              break RUN;
            }
          }
          else {
            S1273=1;
            active[3]=1;
            ends[3]=1;
            break RUN;
          }
        
        case 2 : 
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          switch(S1273){
            case 0 : 
              thread7815(tdone,ends);
              thread7816(tdone,ends);
              thread7817(tdone,ends);
              thread7824(tdone,ends);
              int biggest7825 = 0;
              if(ends[4]>=biggest7825){
                biggest7825=ends[4];
              }
              if(ends[5]>=biggest7825){
                biggest7825=ends[5];
              }
              if(ends[6]>=biggest7825){
                biggest7825=ends[6];
              }
              if(ends[9]>=biggest7825){
                biggest7825=ends[9];
              }
              if(biggest7825 == 1){
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              //FINXME code
              if(biggest7825 == 0){
                S1273=1;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              S1273=1;
              S1273=0;
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 193, column: 12
                System.out.println("Capper doing work");//sysj\controller.sysj line: 194, column: 5
                thread7826(tdone,ends);
                thread7827(tdone,ends);
                thread7828(tdone,ends);
                thread7832(tdone,ends);
                int biggest7833 = 0;
                if(ends[4]>=biggest7833){
                  biggest7833=ends[4];
                }
                if(ends[5]>=biggest7833){
                  biggest7833=ends[5];
                }
                if(ends[6]>=biggest7833){
                  biggest7833=ends[6];
                }
                if(ends[9]>=biggest7833){
                  biggest7833=ends[9];
                }
                if(biggest7833 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                S1273=1;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
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
