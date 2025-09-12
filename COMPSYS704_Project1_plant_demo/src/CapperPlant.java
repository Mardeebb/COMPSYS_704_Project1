import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal gripperTurnRetracted = new Signal("gripperTurnRetracted", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  private int S552 = 1;
  private int S403 = 1;
  private int S381 = 1;
  private int S516 = 1;
  private int S410 = 1;
  private int S550 = 1;
  private int S524 = 1;
  private int S532 = 1;
  private int S540 = 1;
  private int S548 = 1;
  
  private int[] ends = new int[13];
  private int[] tdone = new int[13];
  
  public void thread617(int [] tdone, int [] ends){
        switch(S548){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 166, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 166, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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
  }

  public void thread616(int [] tdone, int [] ends){
        switch(S540){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 164, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 164, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          active[8]=1;
          ends[8]=1;
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

  public void thread615(int [] tdone, int [] ends){
        switch(S532){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 162, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 162, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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
      
    }
  }

  public void thread614(int [] tdone, int [] ends){
        switch(S524){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 160, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 160, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
          active[6]=1;
          ends[6]=1;
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

  public void thread613(int [] tdone, int [] ends){
        switch(S550){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        thread614(tdone,ends);
        thread615(tdone,ends);
        thread616(tdone,ends);
        thread617(tdone,ends);
        int biggest618 = 0;
        if(ends[6]>=biggest618){
          biggest618=ends[6];
        }
        if(ends[7]>=biggest618){
          biggest618=ends[7];
        }
        if(ends[8]>=biggest618){
          biggest618=ends[8];
        }
        if(ends[9]>=biggest618){
          biggest618=ends[9];
        }
        if(biggest618 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest618 == 0){
          S550=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread612(int [] tdone, int [] ends){
        switch(S516){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S410){
          case 0 : 
            if(!cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 138, column: 10
              S410=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 139, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 142, column: 10
              S410=2;
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 144, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            if(cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 143, column: 10
              S410=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 144, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 146, column: 10
              S410=4;
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 148, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 4 : 
            if(capGripperPos5Extend.getprestatus() && cylClampBottleExtend.getprestatus() && gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 147, column: 10
              S410=5;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 148, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 151, column: 10
              S410=6;
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 153, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 6 : 
            if(!capGripperPos5Extend.getprestatus() && !cylClampBottleExtend.getprestatus() && gripperTurnRetracted.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 152, column: 11
              S410=7;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 153, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 7 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 155, column: 10
              S410=0;
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 139, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread611(int [] tdone, int [] ends){
        switch(S403){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S381){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 128, column: 10
              S381=1;
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 130, column: 5
              currsigs.addElement(bottleAtPos4);
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 129, column: 10
              S381=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 130, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S381=2;
            S381=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread608(int [] tdone, int [] ends){
        S548=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 166, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 166, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread607(int [] tdone, int [] ends){
        S540=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 164, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 164, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread606(int [] tdone, int [] ends){
        S532=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 162, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 162, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread605(int [] tdone, int [] ends){
        S524=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 160, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 160, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread604(int [] tdone, int [] ends){
        S550=1;
    thread605(tdone,ends);
    thread606(tdone,ends);
    thread607(tdone,ends);
    thread608(tdone,ends);
    int biggest609 = 0;
    if(ends[6]>=biggest609){
      biggest609=ends[6];
    }
    if(ends[7]>=biggest609){
      biggest609=ends[7];
    }
    if(ends[8]>=biggest609){
      biggest609=ends[8];
    }
    if(ends[9]>=biggest609){
      biggest609=ends[9];
    }
    if(biggest609 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread603(int [] tdone, int [] ends){
        S516=1;
    S410=0;
    gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 139, column: 5
    currsigs.addElement(gripperZAxisLowered);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread602(int [] tdone, int [] ends){
        S403=1;
    S381=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S552){
        case 0 : 
          S552=0;
          break RUN;
        
        case 1 : 
          S552=2;
          S552=2;
          thread602(tdone,ends);
          thread603(tdone,ends);
          thread604(tdone,ends);
          int biggest610 = 0;
          if(ends[3]>=biggest610){
            biggest610=ends[3];
          }
          if(ends[4]>=biggest610){
            biggest610=ends[4];
          }
          if(ends[5]>=biggest610){
            biggest610=ends[5];
          }
          if(biggest610 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          thread611(tdone,ends);
          thread612(tdone,ends);
          thread613(tdone,ends);
          int biggest619 = 0;
          if(ends[3]>=biggest619){
            biggest619=ends[3];
          }
          if(ends[4]>=biggest619){
            biggest619=ends[4];
          }
          if(ends[5]>=biggest619){
            biggest619=ends[5];
          }
          if(biggest619 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest619 == 0){
            S552=0;
            active[2]=0;
            ends[2]=0;
            S552=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        if(!df){
          cylPos5ZaxisExtend.gethook();
          gripperTurnRetracted.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetracted.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      enable.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZaxisExtend.getStatus() ? cylPos5ZaxisExtend.setprepresent() : cylPos5ZaxisExtend.setpreclear();
      cylPos5ZaxisExtend.setpreval(cylPos5ZaxisExtend.getValue());
      cylPos5ZaxisExtend.setClear();
      dummyint = gripperTurnRetracted.getStatus() ? gripperTurnRetracted.setprepresent() : gripperTurnRetracted.setpreclear();
      gripperTurnRetracted.setpreval(gripperTurnRetracted.getValue());
      gripperTurnRetracted.setClear();
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
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        cylPos5ZaxisExtend.gethook();
        gripperTurnRetracted.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
