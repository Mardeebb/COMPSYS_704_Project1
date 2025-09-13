import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
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
  private int S1556 = 1;
  private int S1444 = 1;
  private int S1422 = 1;
  private int S1497 = 1;
  private int S1461 = 1;
  private int S1520 = 1;
  private int S1506 = 1;
  private int S1554 = 1;
  private int S1528 = 1;
  private int S1536 = 1;
  private int S1544 = 1;
  private int S1552 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread2099(int [] tdone, int [] ends){
        switch(S1552){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 177, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 177, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread2098(int [] tdone, int [] ends){
        switch(S1544){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 175, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 175, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread2097(int [] tdone, int [] ends){
        switch(S1536){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 173, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 173, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread2096(int [] tdone, int [] ends){
        switch(S1528){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 171, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 171, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread2095(int [] tdone, int [] ends){
        switch(S1554){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        thread2096(tdone,ends);
        thread2097(tdone,ends);
        thread2098(tdone,ends);
        thread2099(tdone,ends);
        int biggest2100 = 0;
        if(ends[7]>=biggest2100){
          biggest2100=ends[7];
        }
        if(ends[8]>=biggest2100){
          biggest2100=ends[8];
        }
        if(ends[9]>=biggest2100){
          biggest2100=ends[9];
        }
        if(ends[10]>=biggest2100){
          biggest2100=ends[10];
        }
        if(biggest2100 == 1){
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        //FINXME code
        if(biggest2100 == 0){
          S1554=0;
          active[6]=0;
          ends[6]=0;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread2094(int [] tdone, int [] ends){
        switch(S1520){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1506){
          case 0 : 
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 157, column: 10
              S1506=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 158, column: 5
              currsigs.addElement(gripperTurnHomePos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 161, column: 9
              S1506=2;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 162, column: 12
                gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 164, column: 5
                currsigs.addElement(gripperTurnFinalPos);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S1506=3;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 163, column: 11
              S1506=3;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 164, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 167, column: 9
              S1520=0;
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
        break;
      
    }
  }

  public void thread2093(int [] tdone, int [] ends){
        switch(S1497){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1461){
          case 0 : 
            if(!cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 141, column: 10
              S1461=1;
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 149, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 143, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 148, column: 10
              S1461=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 149, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S1461=2;
            S1461=0;
            System.err.println("Emitting");//sysj\plant.sysj line: 142, column: 5
            gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 143, column: 5
            currsigs.addElement(gripperZAxisLowered);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2092(int [] tdone, int [] ends){
        switch(S1444){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1422){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 131, column: 10
              S1422=1;
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 133, column: 5
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 132, column: 10
              S1422=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 133, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S1422=2;
            S1422=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2089(int [] tdone, int [] ends){
        S1552=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 177, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 177, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2088(int [] tdone, int [] ends){
        S1544=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 175, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 175, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread2087(int [] tdone, int [] ends){
        S1536=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 173, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 173, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread2086(int [] tdone, int [] ends){
        S1528=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 171, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 171, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread2085(int [] tdone, int [] ends){
        S1554=1;
    thread2086(tdone,ends);
    thread2087(tdone,ends);
    thread2088(tdone,ends);
    thread2089(tdone,ends);
    int biggest2090 = 0;
    if(ends[7]>=biggest2090){
      biggest2090=ends[7];
    }
    if(ends[8]>=biggest2090){
      biggest2090=ends[8];
    }
    if(ends[9]>=biggest2090){
      biggest2090=ends[9];
    }
    if(ends[10]>=biggest2090){
      biggest2090=ends[10];
    }
    if(biggest2090 == 1){
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2084(int [] tdone, int [] ends){
        S1520=1;
    S1506=0;
    if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 156, column: 12
      gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 158, column: 5
      currsigs.addElement(gripperTurnHomePos);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S1506=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2083(int [] tdone, int [] ends){
        S1497=1;
    S1461=0;
    System.err.println("Emitting");//sysj\plant.sysj line: 142, column: 5
    gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 143, column: 5
    currsigs.addElement(gripperZAxisLowered);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2082(int [] tdone, int [] ends){
        S1444=1;
    S1422=0;
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
      switch(S1556){
        case 0 : 
          S1556=0;
          break RUN;
        
        case 1 : 
          S1556=2;
          S1556=2;
          thread2082(tdone,ends);
          thread2083(tdone,ends);
          thread2084(tdone,ends);
          thread2085(tdone,ends);
          int biggest2091 = 0;
          if(ends[3]>=biggest2091){
            biggest2091=ends[3];
          }
          if(ends[4]>=biggest2091){
            biggest2091=ends[4];
          }
          if(ends[5]>=biggest2091){
            biggest2091=ends[5];
          }
          if(ends[6]>=biggest2091){
            biggest2091=ends[6];
          }
          if(biggest2091 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          thread2092(tdone,ends);
          thread2093(tdone,ends);
          thread2094(tdone,ends);
          thread2095(tdone,ends);
          int biggest2101 = 0;
          if(ends[3]>=biggest2101){
            biggest2101=ends[3];
          }
          if(ends[4]>=biggest2101){
            biggest2101=ends[4];
          }
          if(ends[5]>=biggest2101){
            biggest2101=ends[5];
          }
          if(ends[6]>=biggest2101){
            biggest2101=ends[6];
          }
          if(biggest2101 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2101 == 0){
            S1556=0;
            active[2]=0;
            ends[2]=0;
            S1556=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
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
        gripperTurnRetract.gethook();
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
