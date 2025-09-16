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
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
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
  public Signal gripperGripped = new Signal("gripperGripped", Signal.OUTPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.OUTPUT);
  private int S3182 = 1;
  private int S2901 = 1;
  private int S2863 = 1;
  private int S3014 = 1;
  private int S2918 = 1;
  private int S3046 = 1;
  private int S3024 = 1;
  private int S3114 = 1;
  private int S3055 = 1;
  private int S3146 = 1;
  private int S3124 = 1;
  private int S3180 = 1;
  private int S3154 = 1;
  private int S3162 = 1;
  private int S3170 = 1;
  private int S3178 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void thread3773(int [] tdone, int [] ends){
        switch(S3178){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 204, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 204, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread3772(int [] tdone, int [] ends){
        switch(S3170){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 202, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 202, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread3771(int [] tdone, int [] ends){
        switch(S3162){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 200, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 200, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread3770(int [] tdone, int [] ends){
        switch(S3154){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 198, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 198, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread3769(int [] tdone, int [] ends){
        switch(S3180){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        thread3770(tdone,ends);
        thread3771(tdone,ends);
        thread3772(tdone,ends);
        thread3773(tdone,ends);
        int biggest3774 = 0;
        if(ends[9]>=biggest3774){
          biggest3774=ends[9];
        }
        if(ends[10]>=biggest3774){
          biggest3774=ends[10];
        }
        if(ends[11]>=biggest3774){
          biggest3774=ends[11];
        }
        if(ends[12]>=biggest3774){
          biggest3774=ends[12];
        }
        if(biggest3774 == 1){
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        //FINXME code
        if(biggest3774 == 0){
          S3180=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread3768(int [] tdone, int [] ends){
        switch(S3146){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S3124){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 188, column: 10
              S3124=1;
              cylClamped.setPresent();//sysj\plant.sysj line: 191, column: 5
              currsigs.addElement(cylClamped);
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
            if(!cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 190, column: 10
              S3124=2;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              cylClamped.setPresent();//sysj\plant.sysj line: 191, column: 5
              currsigs.addElement(cylClamped);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            S3124=2;
            S3124=0;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3767(int [] tdone, int [] ends){
        switch(S3114){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S3055){
          case 0 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 172, column: 12
              S3055=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
              currsigs.addElement(gripperTurnFinalPos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 176, column: 10
              S3055=2;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 177, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 179, column: 6
                currsigs.addElement(gripperTurnHomePos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S3055=3;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 178, column: 11
              S3055=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 179, column: 6
              currsigs.addElement(gripperTurnHomePos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 182, column: 10
              S3055=0;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 171, column: 13
                gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
                currsigs.addElement(gripperTurnFinalPos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S3055=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3766(int [] tdone, int [] ends){
        switch(S3046){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3024){
          case 0 : 
            if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 161, column: 10
              S3024=1;
              gripperGripped.setPresent();//sysj\plant.sysj line: 163, column: 5
              currsigs.addElement(gripperGripped);
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
            if(!capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 162, column: 10
              S3024=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperGripped.setPresent();//sysj\plant.sysj line: 163, column: 5
              currsigs.addElement(gripperGripped);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S3024=2;
            S3024=0;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3765(int [] tdone, int [] ends){
        switch(S3014){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2918){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 144, column: 10
              S2918=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 146, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 148, column: 10
              System.err.println("Check lower");//sysj\plant.sysj line: 150, column: 4
              S2918=2;
              System.err.println("Gripper lowered");//sysj\plant.sysj line: 152, column: 5
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 153, column: 5
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
          
          case 2 : 
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 151, column: 10
              S2918=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 153, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 155, column: 10
              System.err.println("Check lift");//sysj\plant.sysj line: 143, column: 4
              S2918=0;
              System.err.println("Gripper Lifted");//sysj\plant.sysj line: 145, column: 5
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 146, column: 5
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
          
        }
        break;
      
    }
  }

  public void thread3764(int [] tdone, int [] ends){
        switch(S2901){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2863){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 132, column: 10
              S2863=1;
              System.err.println("Bottle at pos 4");//sysj\plant.sysj line: 134, column: 5
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 135, column: 5
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 133, column: 10
              S2863=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 135, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S2863=2;
            S2863=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3761(int [] tdone, int [] ends){
        S3178=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 204, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 204, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread3760(int [] tdone, int [] ends){
        S3170=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 202, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 202, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread3759(int [] tdone, int [] ends){
        S3162=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 200, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 200, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread3758(int [] tdone, int [] ends){
        S3154=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 198, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 198, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread3757(int [] tdone, int [] ends){
        S3180=1;
    thread3758(tdone,ends);
    thread3759(tdone,ends);
    thread3760(tdone,ends);
    thread3761(tdone,ends);
    int biggest3762 = 0;
    if(ends[9]>=biggest3762){
      biggest3762=ends[9];
    }
    if(ends[10]>=biggest3762){
      biggest3762=ends[10];
    }
    if(ends[11]>=biggest3762){
      biggest3762=ends[11];
    }
    if(ends[12]>=biggest3762){
      biggest3762=ends[12];
    }
    if(biggest3762 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread3756(int [] tdone, int [] ends){
        S3146=1;
    S3124=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3755(int [] tdone, int [] ends){
        S3114=1;
    S3055=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 171, column: 13
      gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
      currsigs.addElement(gripperTurnFinalPos);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S3055=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread3754(int [] tdone, int [] ends){
        S3046=1;
    S3024=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3753(int [] tdone, int [] ends){
        S3014=1;
    System.err.println("Check lift");//sysj\plant.sysj line: 143, column: 4
    S2918=0;
    System.err.println("Gripper Lifted");//sysj\plant.sysj line: 145, column: 5
    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 146, column: 5
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3752(int [] tdone, int [] ends){
        S2901=1;
    S2863=0;
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
      switch(S3182){
        case 0 : 
          S3182=0;
          break RUN;
        
        case 1 : 
          S3182=2;
          S3182=2;
          thread3752(tdone,ends);
          thread3753(tdone,ends);
          thread3754(tdone,ends);
          thread3755(tdone,ends);
          thread3756(tdone,ends);
          thread3757(tdone,ends);
          int biggest3763 = 0;
          if(ends[3]>=biggest3763){
            biggest3763=ends[3];
          }
          if(ends[4]>=biggest3763){
            biggest3763=ends[4];
          }
          if(ends[5]>=biggest3763){
            biggest3763=ends[5];
          }
          if(ends[6]>=biggest3763){
            biggest3763=ends[6];
          }
          if(ends[7]>=biggest3763){
            biggest3763=ends[7];
          }
          if(ends[8]>=biggest3763){
            biggest3763=ends[8];
          }
          if(biggest3763 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          thread3764(tdone,ends);
          thread3765(tdone,ends);
          thread3766(tdone,ends);
          thread3767(tdone,ends);
          thread3768(tdone,ends);
          thread3769(tdone,ends);
          int biggest3775 = 0;
          if(ends[3]>=biggest3775){
            biggest3775=ends[3];
          }
          if(ends[4]>=biggest3775){
            biggest3775=ends[4];
          }
          if(ends[5]>=biggest3775){
            biggest3775=ends[5];
          }
          if(ends[6]>=biggest3775){
            biggest3775=ends[6];
          }
          if(ends[7]>=biggest3775){
            biggest3775=ends[7];
          }
          if(ends[8]>=biggest3775){
            biggest3775=ends[8];
          }
          if(biggest3775 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3775 == 0){
            S3182=0;
            active[2]=0;
            ends[2]=0;
            S3182=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
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
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        cylPos5ZAxisExtend.gethook();
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
