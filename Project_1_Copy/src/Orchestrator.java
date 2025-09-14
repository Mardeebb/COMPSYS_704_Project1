import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\Orchestrator.sysj line: 1, column: 1

public class Orchestrator extends ClockDomain{
  public Orchestrator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal newBottleTwin = new Signal("newBottleTwin", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal conveyorMoved = new Signal("conveyorMoved", Signal.INPUT);
  public Signal rotTableTurned = new Signal("rotTableTurned", Signal.INPUT);
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal capOn = new Signal("capOn", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal moveConveyor = new Signal("moveConveyor", Signal.OUTPUT);
  public Signal turnRotTable = new Signal("turnRotTable", Signal.OUTPUT);
  public Signal fillerBottleOut = new Signal("fillerBottleOut", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
  public Signal startCapOn = new Signal("startCapOn", Signal.OUTPUT);
  public Signal bottlePos0 = new Signal("bottlePos0", Signal.OUTPUT);
  public Signal bottlePos1 = new Signal("bottlePos1", Signal.OUTPUT);
  public Signal bottlePos2 = new Signal("bottlePos2", Signal.OUTPUT);
  public Signal bottlePos3 = new Signal("bottlePos3", Signal.OUTPUT);
  public Signal bottlePos4 = new Signal("bottlePos4", Signal.OUTPUT);
  public Signal bottlePos5 = new Signal("bottlePos5", Signal.OUTPUT);
  public Signal bottlePos6 = new Signal("bottlePos6", Signal.OUTPUT);
  public Signal bottlePos7 = new Signal("bottlePos7", Signal.OUTPUT);
  public Signal bottlePos8 = new Signal("bottlePos8", Signal.OUTPUT);
  private Signal posZero_1;
  private Signal posOne_1;
  private Signal posTwo_1;
  private Signal posThree_1;
  private Signal posFour_1;
  private Signal posFive_1;
  private Signal posSix_1;
  private Signal posSeven_1;
  private Signal posEight_1;
  private Signal posZeroLeft_1;
  private Signal posOneLeft_1;
  private Signal posTwoLeft_1;
  private Signal posThreeLeft_1;
  private Signal posFourLeft_1;
  private Signal posFiveLeft_1;
  private Signal posSixLeft_1;
  private Signal posSevenLeft_1;
  private Signal posEightLeft_1;
  private Signal rotTurn_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 22, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 24, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 25, column: 5
  private BottleTwin b_thread_3;//sysj\Orchestrator.sysj line: 48, column: 4
  private BottleTwin b1_thread_6;//sysj\Orchestrator.sysj line: 77, column: 4
  private BottleTwin b2_thread_6;//sysj\Orchestrator.sysj line: 78, column: 4
  private BottleTwin b3_thread_6;//sysj\Orchestrator.sysj line: 79, column: 4
  private BottleTwin b4_thread_6;//sysj\Orchestrator.sysj line: 80, column: 4
  private BottleTwin b5_thread_6;//sysj\Orchestrator.sysj line: 81, column: 4
  private BottleTwin b6_thread_6;//sysj\Orchestrator.sysj line: 82, column: 4
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 133, column: 4
  private BottleTwin b_thread_10;//sysj\Orchestrator.sysj line: 146, column: 4
  private BottleTwin b_thread_11;//sysj\Orchestrator.sysj line: 159, column: 4
  private BottleTwin b_thread_12;//sysj\Orchestrator.sysj line: 173, column: 4
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 186, column: 4
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 199, column: 4
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 212, column: 4
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 225, column: 4
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 238, column: 4
  private int S3671 = 1;
  private int S3288 = 1;
  private int S3213 = 1;
  private int S3214 = 1;
  private int S3489 = 1;
  private int S3488 = 1;
  private int S3322 = 1;
  private int S3292 = 1;
  private int S3295 = 1;
  private int S3298 = 1;
  private int S3509 = 1;
  private int S3493 = 1;
  private int S3523 = 1;
  private int S3511 = 1;
  private int S3543 = 1;
  private int S3527 = 1;
  private int S3557 = 1;
  private int S3545 = 1;
  private int S3571 = 1;
  private int S3559 = 1;
  private int S3585 = 1;
  private int S3573 = 1;
  private int S3599 = 1;
  private int S3587 = 1;
  private int S3613 = 1;
  private int S3601 = 1;
  private int S3627 = 1;
  private int S3615 = 1;
  private int S3641 = 1;
  private int S3629 = 1;
  private int S3655 = 1;
  private int S3643 = 1;
  private int S3669 = 1;
  private int S3657 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread3707(int [] tdone, int [] ends){
        switch(S3669){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S3657){
          case 0 : 
            if(posEight_1.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 10
              b_thread_17 = (BottleTwin)(posEight_1.getpreval() == null ? null : ((BottleTwin)posEight_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 4
              if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 239, column: 8
                bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 240, column: 4
                currsigs.addElement(bottlePos8);
                bottlePos8.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 240, column: 4
                System.out.println("Emitted bottlePos8");
                S3657=1;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
              else {
                S3657=1;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
            }
            else {
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            S3657=1;
            S3657=0;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3706(int [] tdone, int [] ends){
        switch(S3655){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S3643){
          case 0 : 
            if(posSeven_1.getprestatus()){//sysj\Orchestrator.sysj line: 224, column: 10
              b_thread_16 = (BottleTwin)(posSeven_1.getpreval() == null ? null : ((BottleTwin)posSeven_1.getpreval()));//sysj\Orchestrator.sysj line: 225, column: 4
              if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 226, column: 8
                bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 227, column: 4
                currsigs.addElement(bottlePos7);
                bottlePos7.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 227, column: 4
                System.out.println("Emitted bottlePos7");
                S3643=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
              else {
                S3643=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
            }
            else {
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            S3643=1;
            S3643=0;
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3705(int [] tdone, int [] ends){
        switch(S3641){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S3629){
          case 0 : 
            if(posSix_1.getprestatus()){//sysj\Orchestrator.sysj line: 211, column: 10
              b_thread_15 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 212, column: 4
              if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 213, column: 8
                bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 214, column: 4
                currsigs.addElement(bottlePos6);
                bottlePos6.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 214, column: 4
                System.out.println("Emitted bottlePos6");
                S3629=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S3629=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            S3629=1;
            S3629=0;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3704(int [] tdone, int [] ends){
        switch(S3627){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3615){
          case 0 : 
            if(posFive_1.getprestatus()){//sysj\Orchestrator.sysj line: 198, column: 10
              b_thread_14 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 199, column: 4
              if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 200, column: 8
                bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 201, column: 4
                currsigs.addElement(bottlePos5);
                bottlePos5.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 201, column: 4
                System.out.println("Emitted bottlePos5");
                S3615=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S3615=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            S3615=1;
            S3615=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3703(int [] tdone, int [] ends){
        switch(S3613){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3601){
          case 0 : 
            if(posFour_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 10
              b_thread_13 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 186, column: 4
              if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 187, column: 8
                bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 188, column: 4
                currsigs.addElement(bottlePos4);
                bottlePos4.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 188, column: 4
                System.out.println("Emitted bottlePos4");
                S3601=1;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S3601=1;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            S3601=1;
            S3601=0;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3702(int [] tdone, int [] ends){
        switch(S3599){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3587){
          case 0 : 
            if(posThree_1.getprestatus()){//sysj\Orchestrator.sysj line: 172, column: 10
              b_thread_12 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 173, column: 4
              if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 174, column: 8
                bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 175, column: 4
                currsigs.addElement(bottlePos3);
                bottlePos3.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 175, column: 4
                System.out.println("Emitted bottlePos3");
                S3587=1;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S3587=1;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            S3587=1;
            S3587=0;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3701(int [] tdone, int [] ends){
        switch(S3585){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S3573){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 158, column: 10
              b_thread_11 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 159, column: 4
              if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 160, column: 8
                bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 161, column: 4
                currsigs.addElement(bottlePos2);
                bottlePos2.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 161, column: 4
                System.out.println("Emitted bottlePos2");
                S3573=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S3573=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            S3573=1;
            S3573=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3700(int [] tdone, int [] ends){
        switch(S3571){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S3559){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 145, column: 10
              b_thread_10 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 146, column: 4
              if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 147, column: 8
                bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 5
                currsigs.addElement(bottlePos1);
                bottlePos1.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 148, column: 5
                System.out.println("Emitted bottlePos1");
                S3559=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
              else {
                S3559=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            S3559=1;
            S3559=0;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3699(int [] tdone, int [] ends){
        switch(S3557){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S3545){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 132, column: 10
              b_thread_9 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 133, column: 4
              S3545=1;
              if(b_thread_9 != null){//sysj\Orchestrator.sysj line: 134, column: 8
                bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 135, column: 5
                currsigs.addElement(bottlePos0);
                bottlePos0.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 135, column: 5
                System.out.println("Emitted bottlePos0");
                S3545=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                S3545=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            S3545=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S3545=2;
            S3545=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3698(int [] tdone, int [] ends){
        switch(S3543){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S3527){
          case 0 : 
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 10
              S3527=1;
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
          
          case 1 : 
            if(rotTurn_1.getprestatus()){//sysj\Orchestrator.sysj line: 113, column: 10
              startCapOn.setPresent();//sysj\Orchestrator.sysj line: 114, column: 4
              currsigs.addElement(startCapOn);
              System.out.println("Emitted startCapOn");
              S3527=2;
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
          
          case 2 : 
            if(capOn.getprestatus()){//sysj\Orchestrator.sysj line: 115, column: 10
              S3527=0;
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
        break;
      
    }
  }

  public void thread3697(int [] tdone, int [] ends){
        switch(S3523){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S3511){
          case 0 : 
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 101, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 102, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S3511=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 103, column: 10
              S3511=0;
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
        break;
      
    }
  }

  public void thread3696(int [] tdone, int [] ends){
        switch(S3509){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S3493){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 71, column: 10
              S3493=1;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 72, column: 10
              turnRotTable.setPresent();//sysj\Orchestrator.sysj line: 74, column: 4
              currsigs.addElement(turnRotTable);
              System.out.println("Emitted turnRotTable");
              S3493=2;
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
          
          case 2 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 10
              fillerBottleOut.setPresent();//sysj\Orchestrator.sysj line: 76, column: 4
              currsigs.addElement(fillerBottleOut);
              System.out.println("Emitted fillerBottleOut");
              b1_thread_6 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 77, column: 4
              b2_thread_6 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 78, column: 4
              b3_thread_6 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 79, column: 4
              b4_thread_6 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 80, column: 4
              b5_thread_6 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 81, column: 4
              b6_thread_6 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 82, column: 4
              posOne_1.setPresent();//sysj\Orchestrator.sysj line: 84, column: 4
              currsigs.addElement(posOne_1);
              posOne_1.setValue(b6_thread_6);//sysj\Orchestrator.sysj line: 84, column: 4
              System.out.println("Emitted posOne_1");
              posTwo_1.setPresent();//sysj\Orchestrator.sysj line: 85, column: 4
              currsigs.addElement(posTwo_1);
              posTwo_1.setValue(b1_thread_6);//sysj\Orchestrator.sysj line: 85, column: 4
              System.out.println("Emitted posTwo_1");
              posThree_1.setPresent();//sysj\Orchestrator.sysj line: 86, column: 4
              currsigs.addElement(posThree_1);
              posThree_1.setValue(b2_thread_6);//sysj\Orchestrator.sysj line: 86, column: 4
              System.out.println("Emitted posThree_1");
              posFour_1.setPresent();//sysj\Orchestrator.sysj line: 87, column: 4
              currsigs.addElement(posFour_1);
              posFour_1.setValue(b3_thread_6);//sysj\Orchestrator.sysj line: 87, column: 4
              System.out.println("Emitted posFour_1");
              posFive_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
              currsigs.addElement(posFive_1);
              posFive_1.setValue(b4_thread_6);//sysj\Orchestrator.sysj line: 88, column: 4
              System.out.println("Emitted posFive_1");
              posSix_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 4
              currsigs.addElement(posSix_1);
              posSix_1.setValue(b5_thread_6);//sysj\Orchestrator.sysj line: 89, column: 4
              System.out.println("Emitted posSix_1");
              S3493=3;
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
          
          case 3 : 
            S3493=3;
            rotTurn_1.setPresent();//sysj\Orchestrator.sysj line: 91, column: 4
            currsigs.addElement(rotTurn_1);
            System.out.println("Emitted rotTurn_1");
            S3493=0;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3694(int [] tdone, int [] ends){
        switch(S3298){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 15
          S3298=0;
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

  public void thread3693(int [] tdone, int [] ends){
        switch(S3295){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 55, column: 15
          S3295=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread3691(int [] tdone, int [] ends){
        S3298=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3690(int [] tdone, int [] ends){
        S3295=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3689(int [] tdone, int [] ends){
        switch(S3489){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3488){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 46, column: 9
              S3488=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
              S3322=0;
              if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                currsigs.addElement(moveConveyor);
                System.out.println("Emitted moveConveyor");
                S3292=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S3322=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            switch(S3322){
              case 0 : 
                switch(S3292){
                  case 0 : 
                    if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 51, column: 11
                      posOne_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                      currsigs.addElement(posOne_1);
                      posOne_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 52, column: 5
                      System.out.println("Emitted posOne_1");
                      posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 5
                      currsigs.addElement(posZeroLeft_1);
                      System.out.println("Emitted posZeroLeft_1");
                      S3292=1;
                      thread3690(tdone,ends);
                      thread3691(tdone,ends);
                      int biggest3692 = 0;
                      if(ends[4]>=biggest3692){
                        biggest3692=ends[4];
                      }
                      if(ends[5]>=biggest3692){
                        biggest3692=ends[5];
                      }
                      if(biggest3692 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    break;
                  
                  case 1 : 
                    thread3693(tdone,ends);
                    thread3694(tdone,ends);
                    int biggest3695 = 0;
                    if(ends[4]>=biggest3695){
                      biggest3695=ends[4];
                    }
                    if(ends[5]>=biggest3695){
                      biggest3695=ends[5];
                    }
                    if(biggest3695 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest3695 == 0){
                      S3322=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                S3322=1;
                b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
                S3322=0;
                if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S3292=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S3322=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3688(int [] tdone, int [] ends){
        switch(S3288){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3213){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 19, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 20, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 22, column: 4
              S3213=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 23, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 24, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 25, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 28, column: 8
                S3214=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
                S3213=0;
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
            switch(S3214){
              case 0 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 29, column: 14
                  posZero_1.setPresent();//sysj\Orchestrator.sysj line: 33, column: 5
                  currsigs.addElement(posZero_1);
                  posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 33, column: 5
                  System.out.println("Emitted posZero_1");
                  S3214=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                if(posZeroLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S3214=2;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 2 : 
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 35, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 37, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
                  S3213=0;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3686(int [] tdone, int [] ends){
        S3669=1;
    S3657=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread3685(int [] tdone, int [] ends){
        S3655=1;
    S3643=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread3684(int [] tdone, int [] ends){
        S3641=1;
    S3629=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread3683(int [] tdone, int [] ends){
        S3627=1;
    S3615=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread3682(int [] tdone, int [] ends){
        S3613=1;
    S3601=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread3681(int [] tdone, int [] ends){
        S3599=1;
    S3587=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread3680(int [] tdone, int [] ends){
        S3585=1;
    S3573=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3679(int [] tdone, int [] ends){
        S3571=1;
    S3559=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3678(int [] tdone, int [] ends){
        S3557=1;
    S3545=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3677(int [] tdone, int [] ends){
        S3543=1;
    S3527=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3676(int [] tdone, int [] ends){
        S3523=1;
    S3511=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3675(int [] tdone, int [] ends){
        S3509=1;
    S3493=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3674(int [] tdone, int [] ends){
        S3489=1;
    S3488=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3673(int [] tdone, int [] ends){
        S3288=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
    S3213=0;
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
      switch(S3671){
        case 0 : 
          S3671=0;
          break RUN;
        
        case 1 : 
          S3671=2;
          S3671=2;
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          rotTurn_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          thread3673(tdone,ends);
          thread3674(tdone,ends);
          thread3675(tdone,ends);
          thread3676(tdone,ends);
          thread3677(tdone,ends);
          thread3678(tdone,ends);
          thread3679(tdone,ends);
          thread3680(tdone,ends);
          thread3681(tdone,ends);
          thread3682(tdone,ends);
          thread3683(tdone,ends);
          thread3684(tdone,ends);
          thread3685(tdone,ends);
          thread3686(tdone,ends);
          int biggest3687 = 0;
          if(ends[2]>=biggest3687){
            biggest3687=ends[2];
          }
          if(ends[3]>=biggest3687){
            biggest3687=ends[3];
          }
          if(ends[6]>=biggest3687){
            biggest3687=ends[6];
          }
          if(ends[7]>=biggest3687){
            biggest3687=ends[7];
          }
          if(ends[8]>=biggest3687){
            biggest3687=ends[8];
          }
          if(ends[9]>=biggest3687){
            biggest3687=ends[9];
          }
          if(ends[10]>=biggest3687){
            biggest3687=ends[10];
          }
          if(ends[11]>=biggest3687){
            biggest3687=ends[11];
          }
          if(ends[12]>=biggest3687){
            biggest3687=ends[12];
          }
          if(ends[13]>=biggest3687){
            biggest3687=ends[13];
          }
          if(ends[14]>=biggest3687){
            biggest3687=ends[14];
          }
          if(ends[15]>=biggest3687){
            biggest3687=ends[15];
          }
          if(ends[16]>=biggest3687){
            biggest3687=ends[16];
          }
          if(ends[17]>=biggest3687){
            biggest3687=ends[17];
          }
          if(biggest3687 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          rotTurn_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          thread3688(tdone,ends);
          thread3689(tdone,ends);
          thread3696(tdone,ends);
          thread3697(tdone,ends);
          thread3698(tdone,ends);
          thread3699(tdone,ends);
          thread3700(tdone,ends);
          thread3701(tdone,ends);
          thread3702(tdone,ends);
          thread3703(tdone,ends);
          thread3704(tdone,ends);
          thread3705(tdone,ends);
          thread3706(tdone,ends);
          thread3707(tdone,ends);
          int biggest3708 = 0;
          if(ends[2]>=biggest3708){
            biggest3708=ends[2];
          }
          if(ends[3]>=biggest3708){
            biggest3708=ends[3];
          }
          if(ends[6]>=biggest3708){
            biggest3708=ends[6];
          }
          if(ends[7]>=biggest3708){
            biggest3708=ends[7];
          }
          if(ends[8]>=biggest3708){
            biggest3708=ends[8];
          }
          if(ends[9]>=biggest3708){
            biggest3708=ends[9];
          }
          if(ends[10]>=biggest3708){
            biggest3708=ends[10];
          }
          if(ends[11]>=biggest3708){
            biggest3708=ends[11];
          }
          if(ends[12]>=biggest3708){
            biggest3708=ends[12];
          }
          if(ends[13]>=biggest3708){
            biggest3708=ends[13];
          }
          if(ends[14]>=biggest3708){
            biggest3708=ends[14];
          }
          if(ends[15]>=biggest3708){
            biggest3708=ends[15];
          }
          if(ends[16]>=biggest3708){
            biggest3708=ends[16];
          }
          if(ends[17]>=biggest3708){
            biggest3708=ends[17];
          }
          if(biggest3708 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3708 == 0){
            S3671=0;
            active[1]=0;
            ends[1]=0;
            S3671=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posZero_1 = new Signal();
    posOne_1 = new Signal();
    posTwo_1 = new Signal();
    posThree_1 = new Signal();
    posFour_1 = new Signal();
    posFive_1 = new Signal();
    posSix_1 = new Signal();
    posSeven_1 = new Signal();
    posEight_1 = new Signal();
    posZeroLeft_1 = new Signal();
    posOneLeft_1 = new Signal();
    posTwoLeft_1 = new Signal();
    posThreeLeft_1 = new Signal();
    posFourLeft_1 = new Signal();
    posFiveLeft_1 = new Signal();
    posSixLeft_1 = new Signal();
    posSevenLeft_1 = new Signal();
    posEightLeft_1 = new Signal();
    rotTurn_1 = new Signal();
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
          newBottleTwin.gethook();
          request.gethook();
          conveyorMoved.gethook();
          rotTableTurned.gethook();
          filled.gethook();
          capOn.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      conveyorMoved.setpreclear();
      rotTableTurned.setpreclear();
      filled.setpreclear();
      capOn.setpreclear();
      recieveTwin.setpreclear();
      moveConveyor.setpreclear();
      turnRotTable.setpreclear();
      fillerBottleOut.setpreclear();
      startFilling.setpreclear();
      startCapOn.setpreclear();
      bottlePos0.setpreclear();
      bottlePos1.setpreclear();
      bottlePos2.setpreclear();
      bottlePos3.setpreclear();
      bottlePos4.setpreclear();
      bottlePos5.setpreclear();
      bottlePos6.setpreclear();
      bottlePos7.setpreclear();
      bottlePos8.setpreclear();
      posZero_1.setpreclear();
      posOne_1.setpreclear();
      posTwo_1.setpreclear();
      posThree_1.setpreclear();
      posFour_1.setpreclear();
      posFive_1.setpreclear();
      posSix_1.setpreclear();
      posSeven_1.setpreclear();
      posEight_1.setpreclear();
      posZeroLeft_1.setpreclear();
      posOneLeft_1.setpreclear();
      posTwoLeft_1.setpreclear();
      posThreeLeft_1.setpreclear();
      posFourLeft_1.setpreclear();
      posFiveLeft_1.setpreclear();
      posSixLeft_1.setpreclear();
      posSevenLeft_1.setpreclear();
      posEightLeft_1.setpreclear();
      rotTurn_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = newBottleTwin.getStatus() ? newBottleTwin.setprepresent() : newBottleTwin.setpreclear();
      newBottleTwin.setpreval(newBottleTwin.getValue());
      newBottleTwin.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = conveyorMoved.getStatus() ? conveyorMoved.setprepresent() : conveyorMoved.setpreclear();
      conveyorMoved.setpreval(conveyorMoved.getValue());
      conveyorMoved.setClear();
      dummyint = rotTableTurned.getStatus() ? rotTableTurned.setprepresent() : rotTableTurned.setpreclear();
      rotTableTurned.setpreval(rotTableTurned.getValue());
      rotTableTurned.setClear();
      dummyint = filled.getStatus() ? filled.setprepresent() : filled.setpreclear();
      filled.setpreval(filled.getValue());
      filled.setClear();
      dummyint = capOn.getStatus() ? capOn.setprepresent() : capOn.setpreclear();
      capOn.setpreval(capOn.getValue());
      capOn.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      moveConveyor.sethook();
      moveConveyor.setClear();
      turnRotTable.sethook();
      turnRotTable.setClear();
      fillerBottleOut.sethook();
      fillerBottleOut.setClear();
      startFilling.sethook();
      startFilling.setClear();
      startCapOn.sethook();
      startCapOn.setClear();
      bottlePos0.sethook();
      bottlePos0.setClear();
      bottlePos1.sethook();
      bottlePos1.setClear();
      bottlePos2.sethook();
      bottlePos2.setClear();
      bottlePos3.sethook();
      bottlePos3.setClear();
      bottlePos4.sethook();
      bottlePos4.setClear();
      bottlePos5.sethook();
      bottlePos5.setClear();
      bottlePos6.sethook();
      bottlePos6.setClear();
      bottlePos7.sethook();
      bottlePos7.setClear();
      bottlePos8.sethook();
      bottlePos8.setClear();
      posZero_1.setClear();
      posOne_1.setClear();
      posTwo_1.setClear();
      posThree_1.setClear();
      posFour_1.setClear();
      posFive_1.setClear();
      posSix_1.setClear();
      posSeven_1.setClear();
      posEight_1.setClear();
      posZeroLeft_1.setClear();
      posOneLeft_1.setClear();
      posTwoLeft_1.setClear();
      posThreeLeft_1.setClear();
      posFourLeft_1.setClear();
      posFiveLeft_1.setClear();
      posSixLeft_1.setClear();
      posSevenLeft_1.setClear();
      posEightLeft_1.setClear();
      rotTurn_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capOn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
