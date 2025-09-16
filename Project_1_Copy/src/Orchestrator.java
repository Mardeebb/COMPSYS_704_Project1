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
  public Signal capLoaded = new Signal("capLoaded", Signal.INPUT);
  public Signal capOn = new Signal("capOn", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal startConveyor = new Signal("startConveyor", Signal.OUTPUT);
  public Signal startRotTable = new Signal("startRotTable", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
  public Signal startCapLoading = new Signal("startCapLoading", Signal.OUTPUT);
  public Signal bottlePos0 = new Signal("bottlePos0", Signal.OUTPUT);
  public Signal bottlePos1 = new Signal("bottlePos1", Signal.OUTPUT);
  public Signal bottlePos2 = new Signal("bottlePos2", Signal.OUTPUT);
  public Signal bottlePos3 = new Signal("bottlePos3", Signal.OUTPUT);
  public Signal bottlePos4 = new Signal("bottlePos4", Signal.OUTPUT);
  public Signal bottlePos5 = new Signal("bottlePos5", Signal.OUTPUT);
  public Signal bottlePos6 = new Signal("bottlePos6", Signal.OUTPUT);
  public Signal bottlePos7 = new Signal("bottlePos7", Signal.OUTPUT);
  public Signal bottlePos8 = new Signal("bottlePos8", Signal.OUTPUT);
  public Signal bottlePos9 = new Signal("bottlePos9", Signal.OUTPUT);
  public Signal bottlePos1Rot = new Signal("bottlePos1Rot", Signal.OUTPUT);
  public Signal bottlePos0B = new Signal("bottlePos0B", Signal.OUTPUT);
  public Signal bottlePos1B = new Signal("bottlePos1B", Signal.OUTPUT);
  public Signal bottlePos2B = new Signal("bottlePos2B", Signal.OUTPUT);
  public Signal bottlePos3B = new Signal("bottlePos3B", Signal.OUTPUT);
  public Signal bottlePos4B = new Signal("bottlePos4B", Signal.OUTPUT);
  public Signal bottlePos5B = new Signal("bottlePos5B", Signal.OUTPUT);
  public Signal bottlePos6B = new Signal("bottlePos6B", Signal.OUTPUT);
  public Signal bottlePos7B = new Signal("bottlePos7B", Signal.OUTPUT);
  public Signal bottlePos8B = new Signal("bottlePos8B", Signal.OUTPUT);
  public Signal bottlePos9B = new Signal("bottlePos9B", Signal.OUTPUT);
  private Signal posZeroUpdate_1;
  private Signal posOneUpdate_1;
  private Signal posTwoUpdate_1;
  private Signal posThreeUpdate_1;
  private Signal posFourUpdate_1;
  private Signal posFiveUpdate_1;
  private Signal posSixUpdate_1;
  private Signal posSevenUpdate_1;
  private Signal posEightUpdate_1;
  private Signal posNineUpdate_1;
  private Signal filling_1;
  private Signal capLoading_1;
  private Signal startRobotLoaderThread_1;
  private Signal startConveyorThread_1;
  private Signal startRotThread_1;
  private Signal startCapLoaderThread_1;
  private Signal startRobotUnloaderThread_1;
  private Signal startFillerThread_1;
  private Signal checkRobotLoader_1;
  private Signal checkConveyor_1;
  private Signal checkRotTable_1;
  private Signal checkRobotUnloader_1;
  private Signal checkFiller_1;
  private Signal robotLoaderFinish_1;
  private Signal conveyorFinish_1;
  private Signal rotTableFinish_1;
  private Signal robotUnloaderFinish_1;
  private Signal fillerFinish_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 23, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin b_thread_8;//sysj\Orchestrator.sysj line: 171, column: 5
  private BottleTwin bEight_thread_9;//sysj\Orchestrator.sysj line: 190, column: 4
  private BottleTwin bZero_thread_10;//sysj\Orchestrator.sysj line: 214, column: 4
  private BottleTwin bFive_thread_10;//sysj\Orchestrator.sysj line: 215, column: 4
  private BottleTwin bOne_thread_11;//sysj\Orchestrator.sysj line: 240, column: 4
  private BottleTwin bTwo_thread_11;//sysj\Orchestrator.sysj line: 241, column: 4
  private BottleTwin bThree_thread_11;//sysj\Orchestrator.sysj line: 242, column: 4
  private BottleTwin bFour_thread_11;//sysj\Orchestrator.sysj line: 243, column: 4
  private BottleTwin bFive_thread_11;//sysj\Orchestrator.sysj line: 244, column: 4
  private BottleTwin bSix_thread_11;//sysj\Orchestrator.sysj line: 245, column: 4
  private BottleTwin bSeven_thread_12;//sysj\Orchestrator.sysj line: 268, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 308, column: 5
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 305, column: 4
  private int id_thread_15;//sysj\Orchestrator.sysj line: 327, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 324, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 350, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 347, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 370, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 367, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 389, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 386, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 408, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 405, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 427, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 424, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 446, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 443, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 465, column: 5
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 462, column: 4
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 482, column: 4
  private int id_thread_23;//sysj\Orchestrator.sysj line: 484, column: 5
  private int S2836 = 1;
  private int S767 = 1;
  private int S711 = 1;
  private int S712 = 1;
  private int S814 = 1;
  private int S770 = 1;
  private int S848 = 1;
  private int S822 = 1;
  private int S818 = 1;
  private int S882 = 1;
  private int S856 = 1;
  private int S852 = 1;
  private int S916 = 1;
  private int S890 = 1;
  private int S886 = 1;
  private int S950 = 1;
  private int S924 = 1;
  private int S920 = 1;
  private int S1000 = 1;
  private int S962 = 1;
  private int S956 = 1;
  private int S1014 = 1;
  private int S1002 = 1;
  private int S1040 = 1;
  private int S1016 = 1;
  private int S1060 = 1;
  private int S1042 = 1;
  private int S1074 = 1;
  private int S1062 = 1;
  private int S1094 = 1;
  private int S1076 = 1;
  private int S1268 = 1;
  private int S1095 = 1;
  private int S1116 = 1;
  private int S1442 = 1;
  private int S1269 = 1;
  private int S1290 = 1;
  private int S1616 = 1;
  private int S1443 = 1;
  private int S1464 = 1;
  private int S1790 = 1;
  private int S1617 = 1;
  private int S1638 = 1;
  private int S1964 = 1;
  private int S1791 = 1;
  private int S1812 = 1;
  private int S2138 = 1;
  private int S1965 = 1;
  private int S1986 = 1;
  private int S2312 = 1;
  private int S2139 = 1;
  private int S2160 = 1;
  private int S2486 = 1;
  private int S2313 = 1;
  private int S2334 = 1;
  private int S2660 = 1;
  private int S2487 = 1;
  private int S2508 = 1;
  private int S2834 = 1;
  private int S2661 = 1;
  private int S2682 = 1;
  
  private int[] ends = new int[24];
  private int[] tdone = new int[24];
  
  public void thread2882(int [] tdone, int [] ends){
        switch(S2834){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S2661){
          case 0 : 
            S2661=0;
            b_thread_23 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 482, column: 4
            S2661=1;
            if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 483, column: 8
              S2682=0;
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 484, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 486, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 486, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 487, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 487, column: 6
              System.out.println("Emitted bottlePos9");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S2682=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 490, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 490, column: 5
              System.out.println("Emitted bottlePos9B");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S2682){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 485, column: 11
                  S2661=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 487, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 487, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 491, column: 11
                  S2661=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2881(int [] tdone, int [] ends){
        switch(S2660){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S2487){
          case 0 : 
            S2487=0;
            S2487=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 464, column: 8
              S2508=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 465, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 467, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 467, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 468, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 468, column: 6
              System.out.println("Emitted bottlePos8");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S2508=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 471, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 471, column: 5
              System.out.println("Emitted bottlePos8B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S2508){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 466, column: 11
                  b_thread_22 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
                  S2487=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 468, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 468, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 472, column: 11
                  b_thread_22 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
                  S2487=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2880(int [] tdone, int [] ends){
        switch(S2486){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2313){
          case 0 : 
            S2313=0;
            S2313=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 445, column: 8
              S2334=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 446, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 448, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 448, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 449, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 449, column: 6
              System.out.println("Emitted bottlePos7");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2334=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 452, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 452, column: 5
              System.out.println("Emitted bottlePos7B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S2334){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 447, column: 11
                  b_thread_21 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
                  S2313=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 449, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 449, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 453, column: 11
                  b_thread_21 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
                  S2313=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2879(int [] tdone, int [] ends){
        switch(S2312){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2139){
          case 0 : 
            S2139=0;
            S2139=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 426, column: 8
              S2160=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 427, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 429, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 429, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 430, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 430, column: 6
              System.out.println("Emitted bottlePos6");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2160=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 433, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 433, column: 5
              System.out.println("Emitted bottlePos6B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2160){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 428, column: 11
                  b_thread_20 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
                  S2139=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 430, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 430, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 434, column: 11
                  b_thread_20 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
                  S2139=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2878(int [] tdone, int [] ends){
        switch(S2138){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1965){
          case 0 : 
            S1965=0;
            S1965=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 407, column: 8
              S1986=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 408, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 410, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 410, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 411, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 411, column: 6
              System.out.println("Emitted bottlePos5");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S1986=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 414, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 414, column: 5
              System.out.println("Emitted bottlePos5B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S1986){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 409, column: 11
                  b_thread_19 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
                  S1965=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 411, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 411, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 415, column: 11
                  b_thread_19 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
                  S1965=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2877(int [] tdone, int [] ends){
        switch(S1964){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1791){
          case 0 : 
            S1791=0;
            S1791=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 388, column: 8
              S1812=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 389, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 391, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 391, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 392, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 392, column: 6
              System.out.println("Emitted bottlePos4");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S1812=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 395, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 395, column: 5
              System.out.println("Emitted bottlePos4B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S1812){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 390, column: 11
                  b_thread_18 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 386, column: 4
                  S1791=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 392, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 392, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 396, column: 11
                  b_thread_18 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 386, column: 4
                  S1791=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2876(int [] tdone, int [] ends){
        switch(S1790){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1617){
          case 0 : 
            S1617=0;
            S1617=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 369, column: 8
              S1638=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 370, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 372, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 372, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 373, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 373, column: 6
              System.out.println("Emitted bottlePos3");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1638=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 376, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 376, column: 5
              System.out.println("Emitted bottlePos3B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S1638){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 11
                  b_thread_17 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
                  S1617=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 373, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 373, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 377, column: 11
                  b_thread_17 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
                  S1617=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2875(int [] tdone, int [] ends){
        switch(S1616){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1443){
          case 0 : 
            S1443=0;
            S1443=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 349, column: 8
              S1464=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 350, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 352, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 352, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 353, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 353, column: 6
              System.out.println("Emitted bottlePos2");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1464=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 356, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 356, column: 5
              System.out.println("Emitted bottlePos2B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S1464){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 351, column: 11
                  b_thread_16 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 347, column: 4
                  S1443=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 353, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 353, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 357, column: 11
                  b_thread_16 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 347, column: 4
                  S1443=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2874(int [] tdone, int [] ends){
        switch(S1442){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1269){
          case 0 : 
            S1269=0;
            S1269=1;
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 326, column: 8
              S1290=0;
              id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 327, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 329, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 329, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 331, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 332, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 332, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1290=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 337, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 337, column: 5
              System.out.println("Emitted bottlePos1B");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S1290){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 328, column: 11
                  b_thread_15 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 324, column: 4
                  S1269=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 331, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 332, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 332, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 338, column: 11
                  b_thread_15 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 324, column: 4
                  S1269=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2873(int [] tdone, int [] ends){
        switch(S1268){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1095){
          case 0 : 
            S1095=0;
            S1095=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 307, column: 8
              S1116=0;
              id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 308, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 310, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 310, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 311, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 311, column: 6
              System.out.println("Emitted bottlePos0");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S1116=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 314, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 314, column: 5
              System.out.println("Emitted bottlePos0B");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S1116){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 309, column: 11
                  b_thread_14 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 4
                  S1095=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 311, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 311, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 315, column: 11
                  b_thread_14 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 4
                  S1095=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2872(int [] tdone, int [] ends){
        switch(S1094){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1076){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 285, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 287, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S1076=1;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 288, column: 10
              S1076=2;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            S1076=2;
            S1076=3;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 3 : 
            S1076=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 291, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S1076=4;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 293, column: 10
              S1076=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2871(int [] tdone, int [] ends){
        switch(S1074){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1062){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 266, column: 10
              bSeven_thread_12 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 268, column: 4
              S1062=1;
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
          
          case 1 : 
            S1062=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 270, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 270, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 271, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_12);//sysj\Orchestrator.sysj line: 271, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S1062=2;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            S1062=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 274, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S1062=3;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 275, column: 10
              S1062=0;
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
        break;
      
    }
  }

  public void thread2870(int [] tdone, int [] ends){
        switch(S1060){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1042){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 235, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 238, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S1042=1;
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
          
          case 1 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 239, column: 10
              bOne_thread_11 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 240, column: 4
              bTwo_thread_11 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 241, column: 4
              bThree_thread_11 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 242, column: 4
              bFour_thread_11 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 243, column: 4
              bFive_thread_11 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 244, column: 4
              bSix_thread_11 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 245, column: 4
              S1042=2;
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
          
          case 2 : 
            S1042=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 247, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_11);//sysj\Orchestrator.sysj line: 247, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 248, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_11);//sysj\Orchestrator.sysj line: 248, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 249, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_11);//sysj\Orchestrator.sysj line: 249, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 250, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_11);//sysj\Orchestrator.sysj line: 250, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 251, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_11);//sysj\Orchestrator.sysj line: 251, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 252, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_11);//sysj\Orchestrator.sysj line: 252, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S1042=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            S1042=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 255, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S1042=4;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 256, column: 10
              S1042=0;
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
        break;
      
    }
  }

  public void thread2869(int [] tdone, int [] ends){
        switch(S1040){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1016){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 208, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 211, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S1016=1;
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
          
          case 1 : 
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 212, column: 10
              bZero_thread_10 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 214, column: 4
              bFive_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 215, column: 4
              S1016=2;
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
          
          case 2 : 
            S1016=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 217, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 217, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 218, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 218, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 219, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_10);//sysj\Orchestrator.sysj line: 219, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 220, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_10);//sysj\Orchestrator.sysj line: 220, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S1016=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            S1016=3;
            S1016=4;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 4 : 
            if(!posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 223, column: 10
              conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 224, column: 4
              currsigs.addElement(conveyorFinish_1);
              System.out.println("Emitted conveyorFinish_1");
              S1016=5;
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
          
          case 5 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 225, column: 10
              S1016=0;
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
        break;
      
    }
  }

  public void thread2868(int [] tdone, int [] ends){
        switch(S1014){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1002){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 188, column: 10
              bEight_thread_9 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 190, column: 4
              S1002=1;
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
            S1002=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 192, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 192, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 193, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_9);//sysj\Orchestrator.sysj line: 193, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S1002=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S1002=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 196, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S1002=3;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 197, column: 10
              S1002=0;
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

  public void thread2867(int [] tdone, int [] ends){
        switch(S1000){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S962){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 169, column: 10
              S962=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 170, column: 12
                S956=0;
                b_thread_8 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 171, column: 5
                if(!b_thread_8.isFilled){//sysj\Orchestrator.sysj line: 172, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 173, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
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
              else {
                S956=1;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            switch(S956){
              case 0 : 
                S962=0;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 178, column: 5
                currsigs.addElement(fillerFinish_1);
                System.out.println("Emitted fillerFinish_1");
                S962=0;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2866(int [] tdone, int [] ends){
        switch(S950){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S924){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 154, column: 10
              S924=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 155, column: 12
                S920=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 156, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S920=1;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            switch(S920){
              case 0 : 
                S924=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 160, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S924=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2865(int [] tdone, int [] ends){
        switch(S916){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S890){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 137, column: 10
              S890=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 139, column: 12
                S886=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 140, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S886=1;
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
          
          case 1 : 
            switch(S886){
              case 0 : 
                S890=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 144, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S890=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2864(int [] tdone, int [] ends){
        switch(S882){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S856){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 122, column: 10
              S856=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 123, column: 12
                S852=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 124, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S852=1;
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
          
          case 1 : 
            switch(S852){
              case 0 : 
                S856=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 128, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S856=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2863(int [] tdone, int [] ends){
        switch(S848){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S822){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 107, column: 10
              S822=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 108, column: 12
                S818=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 109, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S818=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            switch(S818){
              case 0 : 
                S822=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 113, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S822=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2862(int [] tdone, int [] ends){
        switch(S814){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S770){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 54, column: 10
              System.err.println("fffFffffffffffffffffffffffffffffffffffffffff ");//sysj\Orchestrator.sysj line: 55, column: 7
              S770=1;
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
            S770=1;
            S770=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S770=2;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 60, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S770=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 61, column: 10
              S770=4;
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
          
          case 4 : 
            S770=4;
            S770=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            S770=5;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 69, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S770=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 70, column: 10
              S770=7;
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
          
          case 7 : 
            S770=7;
            S770=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            S770=8;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S770=9;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 9 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 10
              S770=10;
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
          
          case 10 : 
            S770=10;
            S770=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            S770=11;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 79, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S770=12;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 12 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 80, column: 10
              S770=13;
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
          
          case 13 : 
            S770=13;
            S770=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            S770=14;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 84, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S770=15;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 15 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 85, column: 10
              S770=16;
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
          
          case 16 : 
            S770=16;
            S770=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            S770=17;
            checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 92, column: 4
            currsigs.addElement(checkRotTable_1);
            System.out.println("Emitted checkRotTable_1");
            S770=18;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 18 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 93, column: 10
              S770=19;
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
          
          case 19 : 
            S770=19;
            S770=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            S770=20;
            checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 4
            currsigs.addElement(checkFiller_1);
            System.out.println("Emitted checkFiller_1");
            S770=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2861(int [] tdone, int [] ends){
        switch(S767){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S711){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S711=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 25, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 26, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 27, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 28, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 29, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 30, column: 8
                posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 31, column: 5
                currsigs.addElement(posEightUpdate_1);
                posEightUpdate_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 31, column: 5
                System.out.println("Emitted posEightUpdate_1");
                S712=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S711=0;
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
            switch(S712){
              case 0 : 
                S712=0;
                S712=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S712=1;
                S712=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S712=3;
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
              
              case 3 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 38, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 39, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  S711=0;
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

  public void thread2859(int [] tdone, int [] ends){
        S2834=1;
    S2661=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread2858(int [] tdone, int [] ends){
        S2660=1;
    b_thread_22 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
    S2487=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread2857(int [] tdone, int [] ends){
        S2486=1;
    b_thread_21 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
    S2313=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2856(int [] tdone, int [] ends){
        S2312=1;
    b_thread_20 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
    S2139=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2855(int [] tdone, int [] ends){
        S2138=1;
    b_thread_19 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
    S1965=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2854(int [] tdone, int [] ends){
        S1964=1;
    b_thread_18 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 386, column: 4
    S1791=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2853(int [] tdone, int [] ends){
        S1790=1;
    b_thread_17 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
    S1617=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2852(int [] tdone, int [] ends){
        S1616=1;
    b_thread_16 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 347, column: 4
    S1443=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2851(int [] tdone, int [] ends){
        S1442=1;
    b_thread_15 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 324, column: 4
    S1269=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2850(int [] tdone, int [] ends){
        S1268=1;
    b_thread_14 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 4
    S1095=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2849(int [] tdone, int [] ends){
        S1094=1;
    S1076=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2848(int [] tdone, int [] ends){
        S1074=1;
    S1062=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2847(int [] tdone, int [] ends){
        S1060=1;
    S1042=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2846(int [] tdone, int [] ends){
        S1040=1;
    S1016=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2845(int [] tdone, int [] ends){
        S1014=1;
    S1002=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2844(int [] tdone, int [] ends){
        S1000=1;
    S962=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2843(int [] tdone, int [] ends){
        S950=1;
    S924=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2842(int [] tdone, int [] ends){
        S916=1;
    S890=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2841(int [] tdone, int [] ends){
        S882=1;
    S856=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2840(int [] tdone, int [] ends){
        S848=1;
    S822=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2839(int [] tdone, int [] ends){
        S814=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 4
    currsigs.addElement(checkFiller_1);
    System.out.println("Emitted checkFiller_1");
    S770=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2838(int [] tdone, int [] ends){
        S767=1;
    S711=0;
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
      switch(S2836){
        case 0 : 
          S2836=0;
          break RUN;
        
        case 1 : 
          S2836=2;
          S2836=2;
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2838(tdone,ends);
          thread2839(tdone,ends);
          thread2840(tdone,ends);
          thread2841(tdone,ends);
          thread2842(tdone,ends);
          thread2843(tdone,ends);
          thread2844(tdone,ends);
          thread2845(tdone,ends);
          thread2846(tdone,ends);
          thread2847(tdone,ends);
          thread2848(tdone,ends);
          thread2849(tdone,ends);
          thread2850(tdone,ends);
          thread2851(tdone,ends);
          thread2852(tdone,ends);
          thread2853(tdone,ends);
          thread2854(tdone,ends);
          thread2855(tdone,ends);
          thread2856(tdone,ends);
          thread2857(tdone,ends);
          thread2858(tdone,ends);
          thread2859(tdone,ends);
          int biggest2860 = 0;
          if(ends[2]>=biggest2860){
            biggest2860=ends[2];
          }
          if(ends[3]>=biggest2860){
            biggest2860=ends[3];
          }
          if(ends[4]>=biggest2860){
            biggest2860=ends[4];
          }
          if(ends[5]>=biggest2860){
            biggest2860=ends[5];
          }
          if(ends[6]>=biggest2860){
            biggest2860=ends[6];
          }
          if(ends[7]>=biggest2860){
            biggest2860=ends[7];
          }
          if(ends[8]>=biggest2860){
            biggest2860=ends[8];
          }
          if(ends[9]>=biggest2860){
            biggest2860=ends[9];
          }
          if(ends[10]>=biggest2860){
            biggest2860=ends[10];
          }
          if(ends[11]>=biggest2860){
            biggest2860=ends[11];
          }
          if(ends[12]>=biggest2860){
            biggest2860=ends[12];
          }
          if(ends[13]>=biggest2860){
            biggest2860=ends[13];
          }
          if(ends[14]>=biggest2860){
            biggest2860=ends[14];
          }
          if(ends[15]>=biggest2860){
            biggest2860=ends[15];
          }
          if(ends[16]>=biggest2860){
            biggest2860=ends[16];
          }
          if(ends[17]>=biggest2860){
            biggest2860=ends[17];
          }
          if(ends[18]>=biggest2860){
            biggest2860=ends[18];
          }
          if(ends[19]>=biggest2860){
            biggest2860=ends[19];
          }
          if(ends[20]>=biggest2860){
            biggest2860=ends[20];
          }
          if(ends[21]>=biggest2860){
            biggest2860=ends[21];
          }
          if(ends[22]>=biggest2860){
            biggest2860=ends[22];
          }
          if(ends[23]>=biggest2860){
            biggest2860=ends[23];
          }
          if(biggest2860 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 14, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2861(tdone,ends);
          thread2862(tdone,ends);
          thread2863(tdone,ends);
          thread2864(tdone,ends);
          thread2865(tdone,ends);
          thread2866(tdone,ends);
          thread2867(tdone,ends);
          thread2868(tdone,ends);
          thread2869(tdone,ends);
          thread2870(tdone,ends);
          thread2871(tdone,ends);
          thread2872(tdone,ends);
          thread2873(tdone,ends);
          thread2874(tdone,ends);
          thread2875(tdone,ends);
          thread2876(tdone,ends);
          thread2877(tdone,ends);
          thread2878(tdone,ends);
          thread2879(tdone,ends);
          thread2880(tdone,ends);
          thread2881(tdone,ends);
          thread2882(tdone,ends);
          int biggest2883 = 0;
          if(ends[2]>=biggest2883){
            biggest2883=ends[2];
          }
          if(ends[3]>=biggest2883){
            biggest2883=ends[3];
          }
          if(ends[4]>=biggest2883){
            biggest2883=ends[4];
          }
          if(ends[5]>=biggest2883){
            biggest2883=ends[5];
          }
          if(ends[6]>=biggest2883){
            biggest2883=ends[6];
          }
          if(ends[7]>=biggest2883){
            biggest2883=ends[7];
          }
          if(ends[8]>=biggest2883){
            biggest2883=ends[8];
          }
          if(ends[9]>=biggest2883){
            biggest2883=ends[9];
          }
          if(ends[10]>=biggest2883){
            biggest2883=ends[10];
          }
          if(ends[11]>=biggest2883){
            biggest2883=ends[11];
          }
          if(ends[12]>=biggest2883){
            biggest2883=ends[12];
          }
          if(ends[13]>=biggest2883){
            biggest2883=ends[13];
          }
          if(ends[14]>=biggest2883){
            biggest2883=ends[14];
          }
          if(ends[15]>=biggest2883){
            biggest2883=ends[15];
          }
          if(ends[16]>=biggest2883){
            biggest2883=ends[16];
          }
          if(ends[17]>=biggest2883){
            biggest2883=ends[17];
          }
          if(ends[18]>=biggest2883){
            biggest2883=ends[18];
          }
          if(ends[19]>=biggest2883){
            biggest2883=ends[19];
          }
          if(ends[20]>=biggest2883){
            biggest2883=ends[20];
          }
          if(ends[21]>=biggest2883){
            biggest2883=ends[21];
          }
          if(ends[22]>=biggest2883){
            biggest2883=ends[22];
          }
          if(ends[23]>=biggest2883){
            biggest2883=ends[23];
          }
          if(biggest2883 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2883 == 0){
            S2836=0;
            active[1]=0;
            ends[1]=0;
            S2836=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posZeroUpdate_1 = new Signal();
    posOneUpdate_1 = new Signal();
    posTwoUpdate_1 = new Signal();
    posThreeUpdate_1 = new Signal();
    posFourUpdate_1 = new Signal();
    posFiveUpdate_1 = new Signal();
    posSixUpdate_1 = new Signal();
    posSevenUpdate_1 = new Signal();
    posEightUpdate_1 = new Signal();
    posNineUpdate_1 = new Signal();
    filling_1 = new Signal();
    capLoading_1 = new Signal();
    startRobotLoaderThread_1 = new Signal();
    startConveyorThread_1 = new Signal();
    startRotThread_1 = new Signal();
    startCapLoaderThread_1 = new Signal();
    startRobotUnloaderThread_1 = new Signal();
    startFillerThread_1 = new Signal();
    checkRobotLoader_1 = new Signal();
    checkConveyor_1 = new Signal();
    checkRotTable_1 = new Signal();
    checkRobotUnloader_1 = new Signal();
    checkFiller_1 = new Signal();
    robotLoaderFinish_1 = new Signal();
    conveyorFinish_1 = new Signal();
    rotTableFinish_1 = new Signal();
    robotUnloaderFinish_1 = new Signal();
    fillerFinish_1 = new Signal();
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
          capLoaded.gethook();
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
      capLoaded.setpreclear();
      capOn.setpreclear();
      recieveTwin.setpreclear();
      startConveyor.setpreclear();
      startRotTable.setpreclear();
      startFilling.setpreclear();
      startCapLoading.setpreclear();
      bottlePos0.setpreclear();
      bottlePos1.setpreclear();
      bottlePos2.setpreclear();
      bottlePos3.setpreclear();
      bottlePos4.setpreclear();
      bottlePos5.setpreclear();
      bottlePos6.setpreclear();
      bottlePos7.setpreclear();
      bottlePos8.setpreclear();
      bottlePos9.setpreclear();
      bottlePos1Rot.setpreclear();
      bottlePos0B.setpreclear();
      bottlePos1B.setpreclear();
      bottlePos2B.setpreclear();
      bottlePos3B.setpreclear();
      bottlePos4B.setpreclear();
      bottlePos5B.setpreclear();
      bottlePos6B.setpreclear();
      bottlePos7B.setpreclear();
      bottlePos8B.setpreclear();
      bottlePos9B.setpreclear();
      posZeroUpdate_1.setpreclear();
      posOneUpdate_1.setpreclear();
      posTwoUpdate_1.setpreclear();
      posThreeUpdate_1.setpreclear();
      posFourUpdate_1.setpreclear();
      posFiveUpdate_1.setpreclear();
      posSixUpdate_1.setpreclear();
      posSevenUpdate_1.setpreclear();
      posEightUpdate_1.setpreclear();
      posNineUpdate_1.setpreclear();
      filling_1.setpreclear();
      capLoading_1.setpreclear();
      startRobotLoaderThread_1.setpreclear();
      startConveyorThread_1.setpreclear();
      startRotThread_1.setpreclear();
      startCapLoaderThread_1.setpreclear();
      startRobotUnloaderThread_1.setpreclear();
      startFillerThread_1.setpreclear();
      checkRobotLoader_1.setpreclear();
      checkConveyor_1.setpreclear();
      checkRotTable_1.setpreclear();
      checkRobotUnloader_1.setpreclear();
      checkFiller_1.setpreclear();
      robotLoaderFinish_1.setpreclear();
      conveyorFinish_1.setpreclear();
      rotTableFinish_1.setpreclear();
      robotUnloaderFinish_1.setpreclear();
      fillerFinish_1.setpreclear();
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
      dummyint = capLoaded.getStatus() ? capLoaded.setprepresent() : capLoaded.setpreclear();
      capLoaded.setpreval(capLoaded.getValue());
      capLoaded.setClear();
      dummyint = capOn.getStatus() ? capOn.setprepresent() : capOn.setpreclear();
      capOn.setpreval(capOn.getValue());
      capOn.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      startConveyor.sethook();
      startConveyor.setClear();
      startRotTable.sethook();
      startRotTable.setClear();
      startFilling.sethook();
      startFilling.setClear();
      startCapLoading.sethook();
      startCapLoading.setClear();
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
      bottlePos9.sethook();
      bottlePos9.setClear();
      bottlePos1Rot.sethook();
      bottlePos1Rot.setClear();
      bottlePos0B.sethook();
      bottlePos0B.setClear();
      bottlePos1B.sethook();
      bottlePos1B.setClear();
      bottlePos2B.sethook();
      bottlePos2B.setClear();
      bottlePos3B.sethook();
      bottlePos3B.setClear();
      bottlePos4B.sethook();
      bottlePos4B.setClear();
      bottlePos5B.sethook();
      bottlePos5B.setClear();
      bottlePos6B.sethook();
      bottlePos6B.setClear();
      bottlePos7B.sethook();
      bottlePos7B.setClear();
      bottlePos8B.sethook();
      bottlePos8B.setClear();
      bottlePos9B.sethook();
      bottlePos9B.setClear();
      posZeroUpdate_1.setClear();
      posOneUpdate_1.setClear();
      posTwoUpdate_1.setClear();
      posThreeUpdate_1.setClear();
      posFourUpdate_1.setClear();
      posFiveUpdate_1.setClear();
      posSixUpdate_1.setClear();
      posSevenUpdate_1.setClear();
      posEightUpdate_1.setClear();
      posNineUpdate_1.setClear();
      filling_1.setClear();
      capLoading_1.setClear();
      startRobotLoaderThread_1.setClear();
      startConveyorThread_1.setClear();
      startRotThread_1.setClear();
      startCapLoaderThread_1.setClear();
      startRobotUnloaderThread_1.setClear();
      startFillerThread_1.setClear();
      checkRobotLoader_1.setClear();
      checkConveyor_1.setClear();
      checkRotTable_1.setClear();
      checkRobotUnloader_1.setClear();
      checkFiller_1.setClear();
      robotLoaderFinish_1.setClear();
      conveyorFinish_1.setClear();
      rotTableFinish_1.setClear();
      robotUnloaderFinish_1.setClear();
      fillerFinish_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capLoaded.gethook();
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
