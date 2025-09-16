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
  private int S3854 = 1;
  private int S3573 = 1;
  private int S3557 = 1;
  private int S3686 = 1;
  private int S3590 = 1;
  private int S3718 = 1;
  private int S3696 = 1;
  private int S3786 = 1;
  private int S3727 = 1;
  private int S3818 = 1;
  private int S3796 = 1;
  private int S3852 = 1;
  private int S3826 = 1;
  private int S3820 = 1;
  private int S3834 = 1;
  private int S3842 = 1;
  private int S3850 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread3877(int [] tdone, int [] ends){
        switch(S3850){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\capperPlant.sysj line: 92, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\capperPlant.sysj line: 92, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread3876(int [] tdone, int [] ends){
        switch(S3842){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\capperPlant.sysj line: 90, column: 25
          gripperTurnHomePosE.setPresent();//sysj\capperPlant.sysj line: 90, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread3875(int [] tdone, int [] ends){
        switch(S3834){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\capperPlant.sysj line: 88, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\capperPlant.sysj line: 88, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread3874(int [] tdone, int [] ends){
        switch(S3826){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S3820){
          case 0 : 
            S3820=0;
            if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 86, column: 25
              gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 86, column: 46
              currsigs.addElement(gripperZAxisLoweredE);
              System.out.println("Emitted gripperZAxisLoweredE");
              S3820=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S3820=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            S3820=1;
            S3820=0;
            if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 86, column: 25
              gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 86, column: 46
              currsigs.addElement(gripperZAxisLoweredE);
              System.out.println("Emitted gripperZAxisLoweredE");
              S3820=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S3820=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3873(int [] tdone, int [] ends){
        switch(S3852){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread3874(tdone,ends);
        thread3875(tdone,ends);
        thread3876(tdone,ends);
        thread3877(tdone,ends);
        int biggest3878 = 0;
        if(ends[8]>=biggest3878){
          biggest3878=ends[8];
        }
        if(ends[9]>=biggest3878){
          biggest3878=ends[9];
        }
        if(ends[10]>=biggest3878){
          biggest3878=ends[10];
        }
        if(ends[11]>=biggest3878){
          biggest3878=ends[11];
        }
        if(biggest3878 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest3878 == 0){
          S3852=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread3872(int [] tdone, int [] ends){
        switch(S3818){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S3796){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\capperPlant.sysj line: 76, column: 10
              S3796=1;
              cylClamped.setPresent();//sysj\capperPlant.sysj line: 79, column: 5
              currsigs.addElement(cylClamped);
              System.out.println("Emitted cylClamped");
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
          
          case 1 : 
            if(!cylClampBottleExtend.getprestatus()){//sysj\capperPlant.sysj line: 78, column: 10
              S3796=2;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              cylClamped.setPresent();//sysj\capperPlant.sysj line: 79, column: 5
              currsigs.addElement(cylClamped);
              System.out.println("Emitted cylClamped");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 2 : 
            S3796=2;
            S3796=0;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3871(int [] tdone, int [] ends){
        switch(S3786){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3727){
          case 0 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 60, column: 12
              S3727=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 61, column: 6
              currsigs.addElement(gripperTurnFinalPos);
              System.out.println("Emitted gripperTurnFinalPos");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 64, column: 10
              S3727=2;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\capperPlant.sysj line: 65, column: 13
                gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 67, column: 6
                currsigs.addElement(gripperTurnHomePos);
                System.out.println("Emitted gripperTurnHomePos");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S3727=3;
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
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 66, column: 11
              S3727=3;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 67, column: 6
              currsigs.addElement(gripperTurnHomePos);
              System.out.println("Emitted gripperTurnHomePos");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 70, column: 10
              S3727=0;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\capperPlant.sysj line: 59, column: 13
                gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 61, column: 6
                currsigs.addElement(gripperTurnFinalPos);
                System.out.println("Emitted gripperTurnFinalPos");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S3727=1;
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
          
        }
        break;
      
    }
  }

  public void thread3870(int [] tdone, int [] ends){
        switch(S3718){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3696){
          case 0 : 
            if(capGripperPos5Extend.getprestatus()){//sysj\capperPlant.sysj line: 49, column: 10
              S3696=1;
              gripperGripped.setPresent();//sysj\capperPlant.sysj line: 51, column: 5
              currsigs.addElement(gripperGripped);
              System.out.println("Emitted gripperGripped");
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
          
          case 1 : 
            if(!capGripperPos5Extend.getprestatus()){//sysj\capperPlant.sysj line: 50, column: 10
              S3696=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperGripped.setPresent();//sysj\capperPlant.sysj line: 51, column: 5
              currsigs.addElement(gripperGripped);
              System.out.println("Emitted gripperGripped");
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S3696=2;
            S3696=0;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3869(int [] tdone, int [] ends){
        switch(S3686){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3590){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 32, column: 10
              S3590=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 34, column: 5
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 36, column: 10
              System.err.println("Check lower");//sysj\capperPlant.sysj line: 38, column: 4
              S3590=2;
              System.err.println("Gripper lowered");//sysj\capperPlant.sysj line: 40, column: 5
              gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 41, column: 5
              currsigs.addElement(gripperZAxisLowered);
              System.out.println("Emitted gripperZAxisLowered");
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
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\capperPlant.sysj line: 39, column: 10
              S3590=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 41, column: 5
              currsigs.addElement(gripperZAxisLowered);
              System.out.println("Emitted gripperZAxisLowered");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 43, column: 10
              System.err.println("Check lift");//sysj\capperPlant.sysj line: 31, column: 4
              S3590=0;
              System.err.println("Gripper Lifted");//sysj\capperPlant.sysj line: 33, column: 5
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 34, column: 5
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
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

  public void thread3868(int [] tdone, int [] ends){
        switch(S3573){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3557){
          case 0 : 
            bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 23, column: 5
            currsigs.addElement(bottleAtPos4);
            System.out.println("Emitted bottleAtPos4");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            S3557=1;
            System.err.println("Bottle at pos 4");//sysj\capperPlant.sysj line: 22, column: 5
            S3557=0;
            bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 23, column: 5
            currsigs.addElement(bottleAtPos4);
            System.out.println("Emitted bottleAtPos4");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3865(int [] tdone, int [] ends){
        S3850=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\capperPlant.sysj line: 92, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\capperPlant.sysj line: 92, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread3864(int [] tdone, int [] ends){
        S3842=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\capperPlant.sysj line: 90, column: 25
      gripperTurnHomePosE.setPresent();//sysj\capperPlant.sysj line: 90, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread3863(int [] tdone, int [] ends){
        S3834=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\capperPlant.sysj line: 88, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\capperPlant.sysj line: 88, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread3862(int [] tdone, int [] ends){
        S3826=1;
    S3820=0;
    if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 86, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 86, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      System.out.println("Emitted gripperZAxisLoweredE");
      S3820=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S3820=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread3861(int [] tdone, int [] ends){
        S3852=1;
    thread3862(tdone,ends);
    thread3863(tdone,ends);
    thread3864(tdone,ends);
    thread3865(tdone,ends);
    int biggest3866 = 0;
    if(ends[8]>=biggest3866){
      biggest3866=ends[8];
    }
    if(ends[9]>=biggest3866){
      biggest3866=ends[9];
    }
    if(ends[10]>=biggest3866){
      biggest3866=ends[10];
    }
    if(ends[11]>=biggest3866){
      biggest3866=ends[11];
    }
    if(biggest3866 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread3860(int [] tdone, int [] ends){
        S3818=1;
    S3796=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3859(int [] tdone, int [] ends){
        S3786=1;
    S3727=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\capperPlant.sysj line: 59, column: 13
      gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 61, column: 6
      currsigs.addElement(gripperTurnFinalPos);
      System.out.println("Emitted gripperTurnFinalPos");
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S3727=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread3858(int [] tdone, int [] ends){
        S3718=1;
    S3696=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3857(int [] tdone, int [] ends){
        S3686=1;
    System.err.println("Check lift");//sysj\capperPlant.sysj line: 31, column: 4
    S3590=0;
    System.err.println("Gripper Lifted");//sysj\capperPlant.sysj line: 33, column: 5
    gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 34, column: 5
    currsigs.addElement(gripperZAxisLifted);
    System.out.println("Emitted gripperZAxisLifted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3856(int [] tdone, int [] ends){
        S3573=1;
    System.err.println("Bottle at pos 4");//sysj\capperPlant.sysj line: 22, column: 5
    S3557=0;
    bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 23, column: 5
    currsigs.addElement(bottleAtPos4);
    System.out.println("Emitted bottleAtPos4");
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
      switch(S3854){
        case 0 : 
          S3854=0;
          break RUN;
        
        case 1 : 
          S3854=2;
          S3854=2;
          thread3856(tdone,ends);
          thread3857(tdone,ends);
          thread3858(tdone,ends);
          thread3859(tdone,ends);
          thread3860(tdone,ends);
          thread3861(tdone,ends);
          int biggest3867 = 0;
          if(ends[2]>=biggest3867){
            biggest3867=ends[2];
          }
          if(ends[3]>=biggest3867){
            biggest3867=ends[3];
          }
          if(ends[4]>=biggest3867){
            biggest3867=ends[4];
          }
          if(ends[5]>=biggest3867){
            biggest3867=ends[5];
          }
          if(ends[6]>=biggest3867){
            biggest3867=ends[6];
          }
          if(ends[7]>=biggest3867){
            biggest3867=ends[7];
          }
          if(biggest3867 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread3868(tdone,ends);
          thread3869(tdone,ends);
          thread3870(tdone,ends);
          thread3871(tdone,ends);
          thread3872(tdone,ends);
          thread3873(tdone,ends);
          int biggest3879 = 0;
          if(ends[2]>=biggest3879){
            biggest3879=ends[2];
          }
          if(ends[3]>=biggest3879){
            biggest3879=ends[3];
          }
          if(ends[4]>=biggest3879){
            biggest3879=ends[4];
          }
          if(ends[5]>=biggest3879){
            biggest3879=ends[5];
          }
          if(ends[6]>=biggest3879){
            biggest3879=ends[6];
          }
          if(ends[7]>=biggest3879){
            biggest3879=ends[7];
          }
          if(biggest3879 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3879 == 0){
            S3854=0;
            active[1]=0;
            ends[1]=0;
            S3854=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
