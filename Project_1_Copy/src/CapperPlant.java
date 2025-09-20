import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\capperPlant.sysj line: 1, column: 1

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal gripperGripped = new Signal("gripperGripped", Signal.OUTPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.OUTPUT);
  public Signal capID = new Signal("capID", Signal.OUTPUT);
  private Signal bottle_1;
  private Signal grip_1;
  private BottleTwin b_thread_2;//sysj\capperPlant.sysj line: 25, column: 4
  private BottleTwin b_thread_4;//sysj\capperPlant.sysj line: 85, column: 4
  private int id_thread_4;//sysj\capperPlant.sysj line: 86, column: 4
  private int S2086 = 1;
  private int S1921 = 1;
  private int S1903 = 1;
  private int S2043 = 1;
  private int S1925 = 1;
  private int S2084 = 1;
  private int S2048 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread2094(int [] tdone, int [] ends){
        switch(S2084){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2048){
          case 0 : 
            if(gripperTurnExtend.getprestatus()){//sysj\capperPlant.sysj line: 73, column: 10
              S2048=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 74, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S2048=1;
            b_thread_4 = (BottleTwin)(bottle_1.getpreval() == null ? null : ((BottleTwin)bottle_1.getpreval()));//sysj\capperPlant.sysj line: 85, column: 4
            id_thread_4 = b_thread_4.ID;//sysj\capperPlant.sysj line: 86, column: 4
            capID.setPresent();//sysj\capperPlant.sysj line: 87, column: 4
            currsigs.addElement(capID);
            capID.setValue(id_thread_4);//sysj\capperPlant.sysj line: 87, column: 4
            S2048=2;
            gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 90, column: 5
            currsigs.addElement(gripperTurnFinalPos);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            if(gripperTurnRetract.getprestatus()){//sysj\capperPlant.sysj line: 89, column: 10
              S2048=0;
              gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 74, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 90, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2093(int [] tdone, int [] ends){
        switch(S2043){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1925){
          case 0 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 38, column: 10
              S1925=1;
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
            if(enable.getprestatus()){//sysj\capperPlant.sysj line: 39, column: 10
              S1925=2;
              gripperZAxisLiftedE.setPresent();//sysj\capperPlant.sysj line: 42, column: 5
              currsigs.addElement(gripperZAxisLiftedE);
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 43, column: 5
              currsigs.addElement(gripperZAxisLifted);
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
          
          case 2 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\capperPlant.sysj line: 41, column: 10
              S1925=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 43, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            S1925=3;
            S1925=4;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 46, column: 11
              S1925=5;
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
          
          case 5 : 
            if(enable.getprestatus()){//sysj\capperPlant.sysj line: 47, column: 11
              S1925=6;
              gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 49, column: 5
              currsigs.addElement(gripperZAxisLoweredE);
              gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 50, column: 5
              currsigs.addElement(gripperZAxisLowered);
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
          
          case 6 : 
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\capperPlant.sysj line: 48, column: 10
              S1925=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 50, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2092(int [] tdone, int [] ends){
        switch(S1921){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1903){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\capperPlant.sysj line: 24, column: 10
              b_thread_2 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\capperPlant.sysj line: 25, column: 4
              if(b_thread_2 != null){//sysj\capperPlant.sysj line: 26, column: 7
                bottle_1.setPresent();//sysj\capperPlant.sysj line: 27, column: 5
                currsigs.addElement(bottle_1);
                bottle_1.setValue(b_thread_2);//sysj\capperPlant.sysj line: 27, column: 5
                bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 28, column: 14
                currsigs.addElement(bottleAtPos4);
                S1903=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S1903=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            S1903=1;
            S1903=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2090(int [] tdone, int [] ends){
        S2084=1;
    S2048=0;
    gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 74, column: 5
    currsigs.addElement(gripperTurnHomePos);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2089(int [] tdone, int [] ends){
        S2043=1;
    S1925=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2088(int [] tdone, int [] ends){
        S1921=1;
    S1903=0;
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
      switch(S2086){
        case 0 : 
          S2086=0;
          break RUN;
        
        case 1 : 
          S2086=2;
          S2086=2;
          bottle_1.setClear();//sysj\capperPlant.sysj line: 19, column: 2
          grip_1.setClear();//sysj\capperPlant.sysj line: 20, column: 2
          thread2088(tdone,ends);
          thread2089(tdone,ends);
          thread2090(tdone,ends);
          int biggest2091 = 0;
          if(ends[2]>=biggest2091){
            biggest2091=ends[2];
          }
          if(ends[3]>=biggest2091){
            biggest2091=ends[3];
          }
          if(ends[4]>=biggest2091){
            biggest2091=ends[4];
          }
          if(biggest2091 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottle_1.setClear();//sysj\capperPlant.sysj line: 19, column: 2
          grip_1.setClear();//sysj\capperPlant.sysj line: 20, column: 2
          thread2092(tdone,ends);
          thread2093(tdone,ends);
          thread2094(tdone,ends);
          int biggest2095 = 0;
          if(ends[2]>=biggest2095){
            biggest2095=ends[2];
          }
          if(ends[3]>=biggest2095){
            biggest2095=ends[3];
          }
          if(ends[4]>=biggest2095){
            biggest2095=ends[4];
          }
          if(biggest2095 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2095 == 0){
            S2086=0;
            active[1]=0;
            ends[1]=0;
            S2086=0;
            break RUN;
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
    bottle_1 = new Signal();
    grip_1 = new Signal();
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
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
          bottleIn.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      enable.setpreclear();
      bottleIn.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      gripperGripped.setpreclear();
      cylClamped.setpreclear();
      capID.setpreclear();
      bottle_1.setpreclear();
      grip_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZAxisExtend.getStatus() ? cylPos5ZAxisExtend.setprepresent() : cylPos5ZAxisExtend.setpreclear();
      cylPos5ZAxisExtend.setpreval(cylPos5ZAxisExtend.getValue());
      cylPos5ZAxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleIn.getStatus() ? bottleIn.setprepresent() : bottleIn.setpreclear();
      bottleIn.setpreval(bottleIn.getValue());
      bottleIn.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      gripperZAxisLoweredE.sethook();
      gripperZAxisLoweredE.setClear();
      gripperZAxisLiftedE.sethook();
      gripperZAxisLiftedE.setClear();
      gripperTurnHomePosE.sethook();
      gripperTurnHomePosE.setClear();
      gripperTurnFinalPosE.sethook();
      gripperTurnFinalPosE.setClear();
      gripperGripped.sethook();
      gripperGripped.setClear();
      cylClamped.sethook();
      cylClamped.setClear();
      capID.sethook();
      capID.setClear();
      bottle_1.setClear();
      grip_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        cylPos5ZAxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
