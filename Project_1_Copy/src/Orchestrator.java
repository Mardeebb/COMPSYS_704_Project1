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
  public Signal capperBottleOut = new Signal("capperBottleOut", Signal.OUTPUT);
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
  private Signal filling_1;
  private Signal capLoading_1;
  private Signal startRotThread_1;
  private Signal startCapLoaderThread_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 24, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin b_thread_3;//sysj\Orchestrator.sysj line: 50, column: 4
  private BottleTwin b1_thread_6;//sysj\Orchestrator.sysj line: 79, column: 4
  private BottleTwin b2_thread_6;//sysj\Orchestrator.sysj line: 80, column: 4
  private BottleTwin b3_thread_6;//sysj\Orchestrator.sysj line: 81, column: 4
  private BottleTwin b4_thread_6;//sysj\Orchestrator.sysj line: 82, column: 4
  private BottleTwin b5_thread_6;//sysj\Orchestrator.sysj line: 83, column: 4
  private BottleTwin b6_thread_6;//sysj\Orchestrator.sysj line: 84, column: 4
  private BottleTwin b3_thread_8;//sysj\Orchestrator.sysj line: 122, column: 4
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 147, column: 4
  private BottleTwin b_thread_10;//sysj\Orchestrator.sysj line: 160, column: 4
  private BottleTwin b_thread_11;//sysj\Orchestrator.sysj line: 173, column: 4
  private BottleTwin b_thread_12;//sysj\Orchestrator.sysj line: 187, column: 4
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 200, column: 4
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 213, column: 4
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 226, column: 4
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 239, column: 4
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 252, column: 4
  private int S3149 = 1;
  private int S2664 = 1;
  private int S2589 = 1;
  private int S2590 = 1;
  private int S2931 = 1;
  private int S2930 = 1;
  private int S2681 = 1;
  private int S2668 = 1;
  private int S2671 = 1;
  private int S2674 = 1;
  private int S2957 = 1;
  private int S2935 = 1;
  private int S2989 = 1;
  private int S2959 = 1;
  private int S3021 = 1;
  private int S2991 = 1;
  private int S3035 = 1;
  private int S3023 = 1;
  private int S3049 = 1;
  private int S3037 = 1;
  private int S3063 = 1;
  private int S3051 = 1;
  private int S3077 = 1;
  private int S3065 = 1;
  private int S3091 = 1;
  private int S3079 = 1;
  private int S3105 = 1;
  private int S3093 = 1;
  private int S3119 = 1;
  private int S3107 = 1;
  private int S3133 = 1;
  private int S3121 = 1;
  private int S3147 = 1;
  private int S3135 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread3185(int [] tdone, int [] ends){
        switch(S3147){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S3135){
          case 0 : 
            if(posEight_1.getprestatus()){//sysj\Orchestrator.sysj line: 251, column: 10
              b_thread_17 = (BottleTwin)(posEight_1.getpreval() == null ? null : ((BottleTwin)posEight_1.getpreval()));//sysj\Orchestrator.sysj line: 252, column: 4
              if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 253, column: 8
                bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 254, column: 4
                currsigs.addElement(bottlePos8);
                bottlePos8.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 254, column: 4
                System.out.println("Emitted bottlePos8");
                S3135=1;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
              else {
                S3135=1;
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
            S3135=1;
            S3135=0;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3184(int [] tdone, int [] ends){
        switch(S3133){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S3121){
          case 0 : 
            if(posSeven_1.getprestatus()){//sysj\Orchestrator.sysj line: 238, column: 10
              b_thread_16 = (BottleTwin)(posSeven_1.getpreval() == null ? null : ((BottleTwin)posSeven_1.getpreval()));//sysj\Orchestrator.sysj line: 239, column: 4
              if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 240, column: 8
                bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 241, column: 4
                currsigs.addElement(bottlePos7);
                bottlePos7.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 241, column: 4
                System.out.println("Emitted bottlePos7");
                S3121=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
              else {
                S3121=1;
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
            S3121=1;
            S3121=0;
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3183(int [] tdone, int [] ends){
        switch(S3119){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S3107){
          case 0 : 
            if(posSix_1.getprestatus()){//sysj\Orchestrator.sysj line: 225, column: 10
              b_thread_15 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 226, column: 4
              if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 227, column: 8
                bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 228, column: 4
                currsigs.addElement(bottlePos6);
                bottlePos6.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 228, column: 4
                System.out.println("Emitted bottlePos6");
                S3107=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S3107=1;
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
            S3107=1;
            S3107=0;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3182(int [] tdone, int [] ends){
        switch(S3105){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3093){
          case 0 : 
            if(posFive_1.getprestatus()){//sysj\Orchestrator.sysj line: 212, column: 10
              b_thread_14 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 213, column: 4
              if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 214, column: 8
                bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 215, column: 4
                currsigs.addElement(bottlePos5);
                bottlePos5.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 215, column: 4
                System.out.println("Emitted bottlePos5");
                S3093=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S3093=1;
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
            S3093=1;
            S3093=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3181(int [] tdone, int [] ends){
        switch(S3091){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3079){
          case 0 : 
            if(posFour_1.getprestatus()){//sysj\Orchestrator.sysj line: 199, column: 10
              b_thread_13 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 200, column: 4
              if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 201, column: 8
                bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 202, column: 4
                currsigs.addElement(bottlePos4);
                bottlePos4.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 202, column: 4
                System.out.println("Emitted bottlePos4");
                S3079=1;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S3079=1;
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
            S3079=1;
            S3079=0;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3180(int [] tdone, int [] ends){
        switch(S3077){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3065){
          case 0 : 
            if(posThree_1.getprestatus()){//sysj\Orchestrator.sysj line: 186, column: 10
              b_thread_12 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 187, column: 4
              if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 188, column: 8
                bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 189, column: 4
                currsigs.addElement(bottlePos3);
                bottlePos3.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 189, column: 4
                System.out.println("Emitted bottlePos3");
                S3065=1;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S3065=1;
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
            S3065=1;
            S3065=0;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3179(int [] tdone, int [] ends){
        switch(S3063){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S3051){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 172, column: 10
              b_thread_11 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 173, column: 4
              if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 174, column: 8
                bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 175, column: 4
                currsigs.addElement(bottlePos2);
                bottlePos2.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 175, column: 4
                System.out.println("Emitted bottlePos2");
                S3051=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S3051=1;
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
            S3051=1;
            S3051=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3178(int [] tdone, int [] ends){
        switch(S3049){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S3037){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 159, column: 10
              b_thread_10 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 160, column: 4
              if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 161, column: 8
                bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 162, column: 5
                currsigs.addElement(bottlePos1);
                bottlePos1.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 162, column: 5
                System.out.println("Emitted bottlePos1");
                S3037=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
              else {
                S3037=1;
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
            S3037=1;
            S3037=0;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3177(int [] tdone, int [] ends){
        switch(S3035){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S3023){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 146, column: 10
              b_thread_9 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 147, column: 4
              S3023=1;
              if(b_thread_9 != null){//sysj\Orchestrator.sysj line: 148, column: 8
                bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 149, column: 5
                currsigs.addElement(bottlePos0);
                bottlePos0.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 149, column: 5
                System.out.println("Emitted bottlePos0");
                S3023=2;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                S3023=2;
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
            S3023=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S3023=2;
            S3023=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3176(int [] tdone, int [] ends){
        switch(S3021){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2991){
          case 0 : 
            if(posThree_1.getprestatus()){//sysj\Orchestrator.sysj line: 121, column: 10
              b3_thread_8 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 122, column: 4
              if(b3_thread_8 == null) {//sysj\Orchestrator.sysj line: 123, column: 19
                break ;//sysj\Orchestrator.sysj line: 124, column: 5
              }
              startCapOn.setPresent();//sysj\Orchestrator.sysj line: 126, column: 4
              currsigs.addElement(startCapOn);
              System.out.println("Emitted startCapOn");
              S2991=1;
              capLoading_1.setPresent();//sysj\Orchestrator.sysj line: 128, column: 5
              currsigs.addElement(capLoading_1);
              System.out.println("Emitted capLoading_1");
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
            if(capOn.getprestatus()){//sysj\Orchestrator.sysj line: 127, column: 10
              S2991=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              capLoading_1.setPresent();//sysj\Orchestrator.sysj line: 128, column: 5
              currsigs.addElement(capLoading_1);
              System.out.println("Emitted capLoading_1");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3175(int [] tdone, int [] ends){
        switch(S2989){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S2959){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 108, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 109, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S2959=1;
              filling_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 5
              currsigs.addElement(filling_1);
              System.out.println("Emitted filling_1");
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 110, column: 10
              S2959=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              filling_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 5
              currsigs.addElement(filling_1);
              System.out.println("Emitted filling_1");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3174(int [] tdone, int [] ends){
        switch(S2957){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S2935){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 74, column: 10
              S2935=1;
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
            if(!filling_1.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 10
              S2935=2;
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
            if(!capLoading_1.getprestatus()){//sysj\Orchestrator.sysj line: 76, column: 10
              turnRotTable.setPresent();//sysj\Orchestrator.sysj line: 78, column: 4
              currsigs.addElement(turnRotTable);
              System.out.println("Emitted turnRotTable");
              b1_thread_6 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 79, column: 4
              b2_thread_6 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 80, column: 4
              b3_thread_6 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 81, column: 4
              b4_thread_6 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 82, column: 4
              b5_thread_6 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 83, column: 4
              b6_thread_6 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 84, column: 4
              posOne_1.setPresent();//sysj\Orchestrator.sysj line: 85, column: 4
              currsigs.addElement(posOne_1);
              posOne_1.setValue(b6_thread_6);//sysj\Orchestrator.sysj line: 85, column: 4
              System.out.println("Emitted posOne_1");
              posTwo_1.setPresent();//sysj\Orchestrator.sysj line: 86, column: 4
              currsigs.addElement(posTwo_1);
              posTwo_1.setValue(b1_thread_6);//sysj\Orchestrator.sysj line: 86, column: 4
              System.out.println("Emitted posTwo_1");
              posThree_1.setPresent();//sysj\Orchestrator.sysj line: 87, column: 4
              currsigs.addElement(posThree_1);
              posThree_1.setValue(b2_thread_6);//sysj\Orchestrator.sysj line: 87, column: 4
              System.out.println("Emitted posThree_1");
              posFour_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
              currsigs.addElement(posFour_1);
              posFour_1.setValue(b3_thread_6);//sysj\Orchestrator.sysj line: 88, column: 4
              System.out.println("Emitted posFour_1");
              posFive_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 4
              currsigs.addElement(posFive_1);
              posFive_1.setValue(b4_thread_6);//sysj\Orchestrator.sysj line: 89, column: 4
              System.out.println("Emitted posFive_1");
              posSix_1.setPresent();//sysj\Orchestrator.sysj line: 90, column: 4
              currsigs.addElement(posSix_1);
              posSix_1.setValue(null);//sysj\Orchestrator.sysj line: 90, column: 4
              System.out.println("Emitted posSix_1");
              S2935=3;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 92, column: 10
              fillerBottleOut.setPresent();//sysj\Orchestrator.sysj line: 93, column: 4
              currsigs.addElement(fillerBottleOut);
              System.out.println("Emitted fillerBottleOut");
              capperBottleOut.setPresent();//sysj\Orchestrator.sysj line: 94, column: 4
              currsigs.addElement(capperBottleOut);
              System.out.println("Emitted capperBottleOut");
              S2935=4;
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
          
          case 4 : 
            S2935=4;
            rotTurn_1.setPresent();//sysj\Orchestrator.sysj line: 98, column: 4
            currsigs.addElement(rotTurn_1);
            System.out.println("Emitted rotTurn_1");
            S2935=0;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3172(int [] tdone, int [] ends){
        switch(S2674){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 61, column: 15
          S2674=0;
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

  public void thread3171(int [] tdone, int [] ends){
        switch(S2671){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 57, column: 15
          S2671=0;
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

  public void thread3169(int [] tdone, int [] ends){
        S2674=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3168(int [] tdone, int [] ends){
        S2671=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3167(int [] tdone, int [] ends){
        switch(S2931){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2930){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 48, column: 9
              S2930=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 50, column: 4
              if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 51, column: 8
                S2681=0;
                moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                currsigs.addElement(moveConveyor);
                System.out.println("Emitted moveConveyor");
                S2668=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2681=1;
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
            switch(S2681){
              case 0 : 
                switch(S2668){
                  case 0 : 
                    if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 11
                      posOne_1.setPresent();//sysj\Orchestrator.sysj line: 54, column: 5
                      currsigs.addElement(posOne_1);
                      posOne_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 54, column: 5
                      System.out.println("Emitted posOne_1");
                      posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 55, column: 5
                      currsigs.addElement(posZeroLeft_1);
                      System.out.println("Emitted posZeroLeft_1");
                      S2668=1;
                      thread3168(tdone,ends);
                      thread3169(tdone,ends);
                      int biggest3170 = 0;
                      if(ends[4]>=biggest3170){
                        biggest3170=ends[4];
                      }
                      if(ends[5]>=biggest3170){
                        biggest3170=ends[5];
                      }
                      if(biggest3170 == 1){
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
                    thread3171(tdone,ends);
                    thread3172(tdone,ends);
                    int biggest3173 = 0;
                    if(ends[4]>=biggest3173){
                      biggest3173=ends[4];
                    }
                    if(ends[5]>=biggest3173){
                      biggest3173=ends[5];
                    }
                    if(biggest3173 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest3173 == 0){
                      b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 50, column: 4
                      if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 51, column: 8
                        S2681=0;
                        moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                        currsigs.addElement(moveConveyor);
                        System.out.println("Emitted moveConveyor");
                        S2668=0;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S2681=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                S2681=1;
                b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 50, column: 4
                if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 51, column: 8
                  S2681=0;
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S2668=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S2681=1;
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

  public void thread3166(int [] tdone, int [] ends){
        switch(S2664){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2589){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 24, column: 4
              S2589=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 25, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 26, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 27, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 28, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 29, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 30, column: 8
                posZero_1.setPresent();//sysj\Orchestrator.sysj line: 34, column: 5
                currsigs.addElement(posZero_1);
                posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 34, column: 5
                System.out.println("Emitted posZero_1");
                S2590=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 19, column: 7
                S2589=0;
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
            switch(S2590){
              case 0 : 
                if(posZeroLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 35, column: 11
                  S2590=1;
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
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 36, column: 11
                  S2590=2;
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
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 38, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 39, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 19, column: 7
                  S2589=0;
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

  public void thread3164(int [] tdone, int [] ends){
        S3147=1;
    S3135=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread3163(int [] tdone, int [] ends){
        S3133=1;
    S3121=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread3162(int [] tdone, int [] ends){
        S3119=1;
    S3107=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread3161(int [] tdone, int [] ends){
        S3105=1;
    S3093=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread3160(int [] tdone, int [] ends){
        S3091=1;
    S3079=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread3159(int [] tdone, int [] ends){
        S3077=1;
    S3065=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread3158(int [] tdone, int [] ends){
        S3063=1;
    S3051=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3157(int [] tdone, int [] ends){
        S3049=1;
    S3037=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3156(int [] tdone, int [] ends){
        S3035=1;
    S3023=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3155(int [] tdone, int [] ends){
        S3021=1;
    S2991=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3154(int [] tdone, int [] ends){
        S2989=1;
    S2959=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3153(int [] tdone, int [] ends){
        S2957=1;
    S2935=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3152(int [] tdone, int [] ends){
        S2931=1;
    S2930=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3151(int [] tdone, int [] ends){
        S2664=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 19, column: 7
    S2589=0;
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
      switch(S3149){
        case 0 : 
          S3149=0;
          break RUN;
        
        case 1 : 
          S3149=2;
          S3149=2;
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
          filling_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          thread3151(tdone,ends);
          thread3152(tdone,ends);
          thread3153(tdone,ends);
          thread3154(tdone,ends);
          thread3155(tdone,ends);
          thread3156(tdone,ends);
          thread3157(tdone,ends);
          thread3158(tdone,ends);
          thread3159(tdone,ends);
          thread3160(tdone,ends);
          thread3161(tdone,ends);
          thread3162(tdone,ends);
          thread3163(tdone,ends);
          thread3164(tdone,ends);
          int biggest3165 = 0;
          if(ends[2]>=biggest3165){
            biggest3165=ends[2];
          }
          if(ends[3]>=biggest3165){
            biggest3165=ends[3];
          }
          if(ends[6]>=biggest3165){
            biggest3165=ends[6];
          }
          if(ends[7]>=biggest3165){
            biggest3165=ends[7];
          }
          if(ends[8]>=biggest3165){
            biggest3165=ends[8];
          }
          if(ends[9]>=biggest3165){
            biggest3165=ends[9];
          }
          if(ends[10]>=biggest3165){
            biggest3165=ends[10];
          }
          if(ends[11]>=biggest3165){
            biggest3165=ends[11];
          }
          if(ends[12]>=biggest3165){
            biggest3165=ends[12];
          }
          if(ends[13]>=biggest3165){
            biggest3165=ends[13];
          }
          if(ends[14]>=biggest3165){
            biggest3165=ends[14];
          }
          if(ends[15]>=biggest3165){
            biggest3165=ends[15];
          }
          if(ends[16]>=biggest3165){
            biggest3165=ends[16];
          }
          if(ends[17]>=biggest3165){
            biggest3165=ends[17];
          }
          if(biggest3165 == 1){
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
          filling_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          thread3166(tdone,ends);
          thread3167(tdone,ends);
          thread3174(tdone,ends);
          thread3175(tdone,ends);
          thread3176(tdone,ends);
          thread3177(tdone,ends);
          thread3178(tdone,ends);
          thread3179(tdone,ends);
          thread3180(tdone,ends);
          thread3181(tdone,ends);
          thread3182(tdone,ends);
          thread3183(tdone,ends);
          thread3184(tdone,ends);
          thread3185(tdone,ends);
          int biggest3186 = 0;
          if(ends[2]>=biggest3186){
            biggest3186=ends[2];
          }
          if(ends[3]>=biggest3186){
            biggest3186=ends[3];
          }
          if(ends[6]>=biggest3186){
            biggest3186=ends[6];
          }
          if(ends[7]>=biggest3186){
            biggest3186=ends[7];
          }
          if(ends[8]>=biggest3186){
            biggest3186=ends[8];
          }
          if(ends[9]>=biggest3186){
            biggest3186=ends[9];
          }
          if(ends[10]>=biggest3186){
            biggest3186=ends[10];
          }
          if(ends[11]>=biggest3186){
            biggest3186=ends[11];
          }
          if(ends[12]>=biggest3186){
            biggest3186=ends[12];
          }
          if(ends[13]>=biggest3186){
            biggest3186=ends[13];
          }
          if(ends[14]>=biggest3186){
            biggest3186=ends[14];
          }
          if(ends[15]>=biggest3186){
            biggest3186=ends[15];
          }
          if(ends[16]>=biggest3186){
            biggest3186=ends[16];
          }
          if(ends[17]>=biggest3186){
            biggest3186=ends[17];
          }
          if(biggest3186 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3186 == 0){
            S3149=0;
            active[1]=0;
            ends[1]=0;
            S3149=0;
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
    filling_1 = new Signal();
    capLoading_1 = new Signal();
    startRotThread_1 = new Signal();
    startCapLoaderThread_1 = new Signal();
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
      capperBottleOut.setpreclear();
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
      filling_1.setpreclear();
      capLoading_1.setpreclear();
      startRotThread_1.setpreclear();
      startCapLoaderThread_1.setpreclear();
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
      capperBottleOut.sethook();
      capperBottleOut.setClear();
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
      filling_1.setClear();
      capLoading_1.setClear();
      startRotThread_1.setClear();
      startCapLoaderThread_1.setClear();
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
