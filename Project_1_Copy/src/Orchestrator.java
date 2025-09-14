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
  private int S3021 = 1;
  private int S2638 = 1;
  private int S2563 = 1;
  private int S2564 = 1;
  private int S2839 = 1;
  private int S2838 = 1;
  private int S2672 = 1;
  private int S2642 = 1;
  private int S2645 = 1;
  private int S2648 = 1;
  private int S2859 = 1;
  private int S2843 = 1;
  private int S2873 = 1;
  private int S2861 = 1;
  private int S2893 = 1;
  private int S2877 = 1;
  private int S2907 = 1;
  private int S2895 = 1;
  private int S2921 = 1;
  private int S2909 = 1;
  private int S2935 = 1;
  private int S2923 = 1;
  private int S2949 = 1;
  private int S2937 = 1;
  private int S2963 = 1;
  private int S2951 = 1;
  private int S2977 = 1;
  private int S2965 = 1;
  private int S2991 = 1;
  private int S2979 = 1;
  private int S3005 = 1;
  private int S2993 = 1;
  private int S3019 = 1;
  private int S3007 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread3057(int [] tdone, int [] ends){
        switch(S3019){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S3007){
          case 0 : 
            if(posEight_1.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 10
              b_thread_17 = (BottleTwin)(posEight_1.getpreval() == null ? null : ((BottleTwin)posEight_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 4
              if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 239, column: 8
                bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 240, column: 4
                currsigs.addElement(bottlePos8);
                bottlePos8.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 240, column: 4
                System.out.println("Emitted bottlePos8");
                S3007=1;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
              else {
                S3007=1;
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
            S3007=1;
            S3007=0;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3056(int [] tdone, int [] ends){
        switch(S3005){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S2993){
          case 0 : 
            if(posSeven_1.getprestatus()){//sysj\Orchestrator.sysj line: 224, column: 10
              b_thread_16 = (BottleTwin)(posSeven_1.getpreval() == null ? null : ((BottleTwin)posSeven_1.getpreval()));//sysj\Orchestrator.sysj line: 225, column: 4
              if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 226, column: 8
                bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 227, column: 4
                currsigs.addElement(bottlePos7);
                bottlePos7.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 227, column: 4
                System.out.println("Emitted bottlePos7");
                S2993=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
              else {
                S2993=1;
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
            S2993=1;
            S2993=0;
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3055(int [] tdone, int [] ends){
        switch(S2991){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S2979){
          case 0 : 
            if(posSix_1.getprestatus()){//sysj\Orchestrator.sysj line: 211, column: 10
              b_thread_15 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 212, column: 4
              if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 213, column: 8
                bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 214, column: 4
                currsigs.addElement(bottlePos6);
                bottlePos6.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 214, column: 4
                System.out.println("Emitted bottlePos6");
                S2979=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S2979=1;
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
            S2979=1;
            S2979=0;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3054(int [] tdone, int [] ends){
        switch(S2977){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S2965){
          case 0 : 
            if(posFive_1.getprestatus()){//sysj\Orchestrator.sysj line: 198, column: 10
              b_thread_14 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 199, column: 4
              if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 200, column: 8
                bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 201, column: 4
                currsigs.addElement(bottlePos5);
                bottlePos5.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 201, column: 4
                System.out.println("Emitted bottlePos5");
                S2965=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S2965=1;
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
            S2965=1;
            S2965=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3053(int [] tdone, int [] ends){
        switch(S2963){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S2951){
          case 0 : 
            if(posFour_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 10
              b_thread_13 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 186, column: 4
              if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 187, column: 8
                bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 188, column: 4
                currsigs.addElement(bottlePos4);
                bottlePos4.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 188, column: 4
                System.out.println("Emitted bottlePos4");
                S2951=1;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S2951=1;
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
            S2951=1;
            S2951=0;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3052(int [] tdone, int [] ends){
        switch(S2949){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S2937){
          case 0 : 
            if(posThree_1.getprestatus()){//sysj\Orchestrator.sysj line: 172, column: 10
              b_thread_12 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 173, column: 4
              if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 174, column: 8
                bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 175, column: 4
                currsigs.addElement(bottlePos3);
                bottlePos3.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 175, column: 4
                System.out.println("Emitted bottlePos3");
                S2937=1;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S2937=1;
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
            S2937=1;
            S2937=0;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3051(int [] tdone, int [] ends){
        switch(S2935){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S2923){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 158, column: 10
              b_thread_11 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 159, column: 4
              if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 160, column: 8
                bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 161, column: 4
                currsigs.addElement(bottlePos2);
                bottlePos2.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 161, column: 4
                System.out.println("Emitted bottlePos2");
                S2923=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S2923=1;
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
            S2923=1;
            S2923=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3050(int [] tdone, int [] ends){
        switch(S2921){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S2909){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 145, column: 10
              b_thread_10 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 146, column: 4
              if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 147, column: 8
                bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 5
                currsigs.addElement(bottlePos1);
                bottlePos1.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 148, column: 5
                System.out.println("Emitted bottlePos1");
                S2909=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
              else {
                S2909=1;
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
            S2909=1;
            S2909=0;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3049(int [] tdone, int [] ends){
        switch(S2907){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2895){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 132, column: 10
              b_thread_9 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 133, column: 4
              S2895=1;
              if(b_thread_9 != null){//sysj\Orchestrator.sysj line: 134, column: 8
                bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 135, column: 5
                currsigs.addElement(bottlePos0);
                bottlePos0.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 135, column: 5
                System.out.println("Emitted bottlePos0");
                S2895=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                S2895=2;
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
            S2895=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S2895=2;
            S2895=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3048(int [] tdone, int [] ends){
        switch(S2893){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2877){
          case 0 : 
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 10
              S2877=1;
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
              S2877=2;
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
              S2877=0;
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

  public void thread3047(int [] tdone, int [] ends){
        switch(S2873){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S2861){
          case 0 : 
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 101, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 102, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S2861=1;
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
              S2861=0;
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

  public void thread3046(int [] tdone, int [] ends){
        switch(S2859){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S2843){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 71, column: 10
              S2843=1;
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
              S2843=2;
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
              S2843=3;
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
            S2843=3;
            rotTurn_1.setPresent();//sysj\Orchestrator.sysj line: 91, column: 4
            currsigs.addElement(rotTurn_1);
            System.out.println("Emitted rotTurn_1");
            S2843=0;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3044(int [] tdone, int [] ends){
        switch(S2648){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 15
          S2648=0;
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

  public void thread3043(int [] tdone, int [] ends){
        switch(S2645){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 55, column: 15
          S2645=0;
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

  public void thread3041(int [] tdone, int [] ends){
        S2648=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3040(int [] tdone, int [] ends){
        S2645=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3039(int [] tdone, int [] ends){
        switch(S2839){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2838){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 46, column: 9
              S2838=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
              S2672=0;
              if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                currsigs.addElement(moveConveyor);
                System.out.println("Emitted moveConveyor");
                S2642=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2672=1;
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
            switch(S2672){
              case 0 : 
                switch(S2642){
                  case 0 : 
                    if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 51, column: 11
                      posOne_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                      currsigs.addElement(posOne_1);
                      posOne_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 52, column: 5
                      System.out.println("Emitted posOne_1");
                      posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 5
                      currsigs.addElement(posZeroLeft_1);
                      System.out.println("Emitted posZeroLeft_1");
                      S2642=1;
                      thread3040(tdone,ends);
                      thread3041(tdone,ends);
                      int biggest3042 = 0;
                      if(ends[4]>=biggest3042){
                        biggest3042=ends[4];
                      }
                      if(ends[5]>=biggest3042){
                        biggest3042=ends[5];
                      }
                      if(biggest3042 == 1){
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
                    thread3043(tdone,ends);
                    thread3044(tdone,ends);
                    int biggest3045 = 0;
                    if(ends[4]>=biggest3045){
                      biggest3045=ends[4];
                    }
                    if(ends[5]>=biggest3045){
                      biggest3045=ends[5];
                    }
                    if(biggest3045 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest3045 == 0){
                      S2672=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                S2672=1;
                b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
                S2672=0;
                if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S2642=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S2672=1;
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

  public void thread3038(int [] tdone, int [] ends){
        switch(S2638){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2563){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 19, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 20, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 22, column: 4
              S2563=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 23, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 24, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 25, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 28, column: 8
                S2564=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
                S2563=0;
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
            switch(S2564){
              case 0 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 29, column: 14
                  posZero_1.setPresent();//sysj\Orchestrator.sysj line: 33, column: 5
                  currsigs.addElement(posZero_1);
                  posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 33, column: 5
                  System.out.println("Emitted posZero_1");
                  S2564=1;
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
                  S2564=2;
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
                  S2563=0;
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

  public void thread3036(int [] tdone, int [] ends){
        S3019=1;
    S3007=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread3035(int [] tdone, int [] ends){
        S3005=1;
    S2993=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread3034(int [] tdone, int [] ends){
        S2991=1;
    S2979=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread3033(int [] tdone, int [] ends){
        S2977=1;
    S2965=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread3032(int [] tdone, int [] ends){
        S2963=1;
    S2951=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread3031(int [] tdone, int [] ends){
        S2949=1;
    S2937=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread3030(int [] tdone, int [] ends){
        S2935=1;
    S2923=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3029(int [] tdone, int [] ends){
        S2921=1;
    S2909=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3028(int [] tdone, int [] ends){
        S2907=1;
    S2895=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3027(int [] tdone, int [] ends){
        S2893=1;
    S2877=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3026(int [] tdone, int [] ends){
        S2873=1;
    S2861=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3025(int [] tdone, int [] ends){
        S2859=1;
    S2843=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3024(int [] tdone, int [] ends){
        S2839=1;
    S2838=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3023(int [] tdone, int [] ends){
        S2638=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
    S2563=0;
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
      switch(S3021){
        case 0 : 
          S3021=0;
          break RUN;
        
        case 1 : 
          S3021=2;
          S3021=2;
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
          thread3023(tdone,ends);
          thread3024(tdone,ends);
          thread3025(tdone,ends);
          thread3026(tdone,ends);
          thread3027(tdone,ends);
          thread3028(tdone,ends);
          thread3029(tdone,ends);
          thread3030(tdone,ends);
          thread3031(tdone,ends);
          thread3032(tdone,ends);
          thread3033(tdone,ends);
          thread3034(tdone,ends);
          thread3035(tdone,ends);
          thread3036(tdone,ends);
          int biggest3037 = 0;
          if(ends[2]>=biggest3037){
            biggest3037=ends[2];
          }
          if(ends[3]>=biggest3037){
            biggest3037=ends[3];
          }
          if(ends[6]>=biggest3037){
            biggest3037=ends[6];
          }
          if(ends[7]>=biggest3037){
            biggest3037=ends[7];
          }
          if(ends[8]>=biggest3037){
            biggest3037=ends[8];
          }
          if(ends[9]>=biggest3037){
            biggest3037=ends[9];
          }
          if(ends[10]>=biggest3037){
            biggest3037=ends[10];
          }
          if(ends[11]>=biggest3037){
            biggest3037=ends[11];
          }
          if(ends[12]>=biggest3037){
            biggest3037=ends[12];
          }
          if(ends[13]>=biggest3037){
            biggest3037=ends[13];
          }
          if(ends[14]>=biggest3037){
            biggest3037=ends[14];
          }
          if(ends[15]>=biggest3037){
            biggest3037=ends[15];
          }
          if(ends[16]>=biggest3037){
            biggest3037=ends[16];
          }
          if(ends[17]>=biggest3037){
            biggest3037=ends[17];
          }
          if(biggest3037 == 1){
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
          thread3038(tdone,ends);
          thread3039(tdone,ends);
          thread3046(tdone,ends);
          thread3047(tdone,ends);
          thread3048(tdone,ends);
          thread3049(tdone,ends);
          thread3050(tdone,ends);
          thread3051(tdone,ends);
          thread3052(tdone,ends);
          thread3053(tdone,ends);
          thread3054(tdone,ends);
          thread3055(tdone,ends);
          thread3056(tdone,ends);
          thread3057(tdone,ends);
          int biggest3058 = 0;
          if(ends[2]>=biggest3058){
            biggest3058=ends[2];
          }
          if(ends[3]>=biggest3058){
            biggest3058=ends[3];
          }
          if(ends[6]>=biggest3058){
            biggest3058=ends[6];
          }
          if(ends[7]>=biggest3058){
            biggest3058=ends[7];
          }
          if(ends[8]>=biggest3058){
            biggest3058=ends[8];
          }
          if(ends[9]>=biggest3058){
            biggest3058=ends[9];
          }
          if(ends[10]>=biggest3058){
            biggest3058=ends[10];
          }
          if(ends[11]>=biggest3058){
            biggest3058=ends[11];
          }
          if(ends[12]>=biggest3058){
            biggest3058=ends[12];
          }
          if(ends[13]>=biggest3058){
            biggest3058=ends[13];
          }
          if(ends[14]>=biggest3058){
            biggest3058=ends[14];
          }
          if(ends[15]>=biggest3058){
            biggest3058=ends[15];
          }
          if(ends[16]>=biggest3058){
            biggest3058=ends[16];
          }
          if(ends[17]>=biggest3058){
            biggest3058=ends[17];
          }
          if(biggest3058 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3058 == 0){
            S3021=0;
            active[1]=0;
            ends[1]=0;
            S3021=0;
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
