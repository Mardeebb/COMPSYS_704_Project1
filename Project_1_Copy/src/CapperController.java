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
  private long __start_thread_5;//sysj\controller.sysj line: 206, column: 4
  private int S773 = 1;
  private int S152 = 1;
  private int S295 = 1;
  private int S199 = 1;
  private int S342 = 1;
  private int S302 = 1;
  private int S298 = 1;
  private int S301 = 1;
  private int S446 = 1;
  private int S360 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread1582(int [] tdone, int [] ends){
        switch(S446){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S360){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\controller.sysj line: 232, column: 11
              S360=1;
              System.out.println("Twist");//sysj\controller.sysj line: 235, column: 6
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 236, column: 6
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
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 234, column: 11
              releaseCap_3.setPresent();//sysj\controller.sysj line: 239, column: 5
              currsigs.addElement(releaseCap_3);
              raiseGripper_3.setPresent();//sysj\controller.sysj line: 240, column: 5
              currsigs.addElement(raiseGripper_3);
              System.err.println("raise the gripper");//sysj\controller.sysj line: 241, column: 5
              S360=2;
              System.out.println("retract");//sysj\controller.sysj line: 243, column: 6
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 244, column: 6
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 236, column: 6
              currsigs.addElement(gripperTurnExtend);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 242, column: 12
              unclampBottle_3.setPresent();//sysj\controller.sysj line: 246, column: 5
              currsigs.addElement(unclampBottle_3);
              S360=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 244, column: 6
              currsigs.addElement(gripperTurnRetract);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1580(int [] tdone, int [] ends){
        S301=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1579(int [] tdone, int [] ends){
        S298=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1577(int [] tdone, int [] ends){
        switch(S301){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\controller.sysj line: 221, column: 45
          S301=0;
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

  public void thread1576(int [] tdone, int [] ends){
        switch(S298){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 221, column: 12
          S298=0;
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

  public void thread1575(int [] tdone, int [] ends){
        switch(S342){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S302){
          case 0 : 
            thread1576(tdone,ends);
            thread1577(tdone,ends);
            int biggest1578 = 0;
            if(ends[7]>=biggest1578){
              biggest1578=ends[7];
            }
            if(ends[8]>=biggest1578){
              biggest1578=ends[8];
            }
            if(biggest1578 == 1){
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            //FINXME code
            if(biggest1578 == 0){
              System.out.println("gripped the cap");//sysj\controller.sysj line: 222, column: 5
              S302=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 224, column: 6
              currsigs.addElement(capGripperPos5Extend);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_3.getprestatus()){//sysj\controller.sysj line: 223, column: 11
              S302=0;
              thread1579(tdone,ends);
              thread1580(tdone,ends);
              int biggest1581 = 0;
              if(ends[7]>=biggest1581){
                biggest1581=ends[7];
              }
              if(ends[8]>=biggest1581){
                biggest1581=ends[8];
              }
              if(biggest1581 == 1){
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 224, column: 6
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

  public void thread1574(int [] tdone, int [] ends){
        switch(S295){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S199){
          case 0 : 
            if(com.systemj.Timer.getMs() - __start_thread_5 >= (4) * 1000){//sysj\controller.sysj line: 206, column: 4
              ends[5]=2;
              ;//sysj\controller.sysj line: 206, column: 4
              S199=1;
              System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 6
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 209, column: 11
              System.err.println("lifted");//sysj\controller.sysj line: 213, column: 5
              S199=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S199=2;
            S199=0;
            __start_thread_5 = com.systemj.Timer.getMs();//sysj\controller.sysj line: 206, column: 4
            if(com.systemj.Timer.getMs() - __start_thread_5 >= (4) * 1000){//sysj\controller.sysj line: 206, column: 4
              ends[5]=2;
              ;//sysj\controller.sysj line: 206, column: 4
              S199=1;
              System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 6
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 6
              currsigs.addElement(cylPos5ZAxisExtend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1573(int [] tdone, int [] ends){
        switch(S152){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 197, column: 11
          System.out.println("Bottle clamped");//sysj\controller.sysj line: 198, column: 6
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 199, column: 6
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 199, column: 6
          currsigs.addElement(cylClampBottleExtend);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread1571(int [] tdone, int [] ends){
        S446=1;
    S360=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1569(int [] tdone, int [] ends){
        S301=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1568(int [] tdone, int [] ends){
        S298=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1567(int [] tdone, int [] ends){
        S342=1;
    S302=0;
    thread1568(tdone,ends);
    thread1569(tdone,ends);
    int biggest1570 = 0;
    if(ends[7]>=biggest1570){
      biggest1570=ends[7];
    }
    if(ends[8]>=biggest1570){
      biggest1570=ends[8];
    }
    if(biggest1570 == 1){
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread1566(int [] tdone, int [] ends){
        S295=1;
    S199=0;
    __start_thread_5 = com.systemj.Timer.getMs();//sysj\controller.sysj line: 206, column: 4
    if(com.systemj.Timer.getMs() - __start_thread_5 >= (4) * 1000){//sysj\controller.sysj line: 206, column: 4
      ends[5]=2;
      ;//sysj\controller.sysj line: 206, column: 4
      S199=1;
      System.err.println("gripper lowered");//sysj\controller.sysj line: 210, column: 6
      cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 211, column: 6
      currsigs.addElement(cylPos5ZAxisExtend);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread1565(int [] tdone, int [] ends){
        S152=1;
    System.out.println("Bottle clamped");//sysj\controller.sysj line: 198, column: 6
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 199, column: 6
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
      switch(S773){
        case 0 : 
          S773=0;
          break RUN;
        
        case 1 : 
          S773=2;
          S773=2;
          System.out.println("Capper CD");//sysj\controller.sysj line: 189, column: 2
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          thread1565(tdone,ends);
          thread1566(tdone,ends);
          thread1567(tdone,ends);
          thread1571(tdone,ends);
          int biggest1572 = 0;
          if(ends[4]>=biggest1572){
            biggest1572=ends[4];
          }
          if(ends[5]>=biggest1572){
            biggest1572=ends[5];
          }
          if(ends[6]>=biggest1572){
            biggest1572=ends[6];
          }
          if(ends[9]>=biggest1572){
            biggest1572=ends[9];
          }
          if(biggest1572 == 1){
            active[3]=1;
            ends[3]=1;
            break RUN;
          }
        
        case 2 : 
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          thread1573(tdone,ends);
          thread1574(tdone,ends);
          thread1575(tdone,ends);
          thread1582(tdone,ends);
          int biggest1583 = 0;
          if(ends[4]>=biggest1583){
            biggest1583=ends[4];
          }
          if(ends[5]>=biggest1583){
            biggest1583=ends[5];
          }
          if(ends[6]>=biggest1583){
            biggest1583=ends[6];
          }
          if(ends[9]>=biggest1583){
            biggest1583=ends[9];
          }
          if(biggest1583 == 1){
            active[3]=1;
            ends[3]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1583 == 0){
            S773=0;
            active[3]=0;
            ends[3]=0;
            S773=0;
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
