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
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.INPUT);
  public Signal bottleUnloaded = new Signal("bottleUnloaded", Signal.INPUT);
  public Signal bottleLoaderRelease = new Signal("bottleLoaderRelease", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal startConveyor = new Signal("startConveyor", Signal.OUTPUT);
  public Signal startRotTable = new Signal("startRotTable", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
  public Signal startCapLoading = new Signal("startCapLoading", Signal.OUTPUT);
  public Signal startBottleLoading = new Signal("startBottleLoading", Signal.OUTPUT);
  public Signal startBottleUnloading = new Signal("startBottleUnloading", Signal.OUTPUT);
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
  private Signal checkCapLoader_1;
  private Signal robotLoaderFinish_1;
  private Signal conveyorFinish_1;
  private Signal rotTableFinish_1;
  private Signal robotUnloaderFinish_1;
  private Signal fillerFinish_1;
  private Signal capLoaderFinish_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 23, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin b_thread_8;//sysj\Orchestrator.sysj line: 175, column: 5
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 193, column: 5
  private BottleTwin bEight_thread_10;//sysj\Orchestrator.sysj line: 215, column: 4
  private BottleTwin bZero_thread_11;//sysj\Orchestrator.sysj line: 241, column: 4
  private BottleTwin bFive_thread_11;//sysj\Orchestrator.sysj line: 242, column: 4
  private BottleTwin bOne_thread_12;//sysj\Orchestrator.sysj line: 267, column: 4
  private BottleTwin bTwo_thread_12;//sysj\Orchestrator.sysj line: 268, column: 4
  private BottleTwin bThree_thread_12;//sysj\Orchestrator.sysj line: 269, column: 4
  private BottleTwin bFour_thread_12;//sysj\Orchestrator.sysj line: 270, column: 4
  private BottleTwin bFive_thread_12;//sysj\Orchestrator.sysj line: 271, column: 4
  private BottleTwin bSix_thread_12;//sysj\Orchestrator.sysj line: 272, column: 4
  private BottleTwin bSeven_thread_13;//sysj\Orchestrator.sysj line: 295, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 351, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 348, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 370, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 367, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 393, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 390, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 413, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 410, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 432, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 429, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 451, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 448, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 470, column: 5
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 467, column: 4
  private int id_thread_23;//sysj\Orchestrator.sysj line: 489, column: 5
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 486, column: 4
  private int id_thread_24;//sysj\Orchestrator.sysj line: 508, column: 5
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 505, column: 4
  private BottleTwin b_thread_25;//sysj\Orchestrator.sysj line: 525, column: 4
  private int id_thread_25;//sysj\Orchestrator.sysj line: 527, column: 5
  private int S6795 = 1;
  private int S4638 = 1;
  private int S4582 = 1;
  private int S4583 = 1;
  private int S4691 = 1;
  private int S4641 = 1;
  private int S4725 = 1;
  private int S4699 = 1;
  private int S4695 = 1;
  private int S4759 = 1;
  private int S4733 = 1;
  private int S4729 = 1;
  private int S4793 = 1;
  private int S4767 = 1;
  private int S4763 = 1;
  private int S4827 = 1;
  private int S4801 = 1;
  private int S4797 = 1;
  private int S4877 = 1;
  private int S4839 = 1;
  private int S4833 = 1;
  private int S4831 = 1;
  private int S4927 = 1;
  private int S4889 = 1;
  private int S4883 = 1;
  private int S4953 = 1;
  private int S4929 = 1;
  private int S4979 = 1;
  private int S4955 = 1;
  private int S4999 = 1;
  private int S4981 = 1;
  private int S5013 = 1;
  private int S5001 = 1;
  private int S5033 = 1;
  private int S5015 = 1;
  private int S5053 = 1;
  private int S5035 = 1;
  private int S5227 = 1;
  private int S5054 = 1;
  private int S5075 = 1;
  private int S5401 = 1;
  private int S5228 = 1;
  private int S5249 = 1;
  private int S5575 = 1;
  private int S5402 = 1;
  private int S5423 = 1;
  private int S5749 = 1;
  private int S5576 = 1;
  private int S5597 = 1;
  private int S5923 = 1;
  private int S5750 = 1;
  private int S5771 = 1;
  private int S6097 = 1;
  private int S5924 = 1;
  private int S5945 = 1;
  private int S6271 = 1;
  private int S6098 = 1;
  private int S6119 = 1;
  private int S6445 = 1;
  private int S6272 = 1;
  private int S6293 = 1;
  private int S6619 = 1;
  private int S6446 = 1;
  private int S6467 = 1;
  private int S6793 = 1;
  private int S6620 = 1;
  private int S6641 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread6845(int [] tdone, int [] ends){
        switch(S6793){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S6620){
          case 0 : 
            S6620=0;
            b_thread_25 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 525, column: 4
            S6620=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 526, column: 8
              S6641=0;
              id_thread_25 = b_thread_25.ID;//sysj\Orchestrator.sysj line: 527, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 529, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_25);//sysj\Orchestrator.sysj line: 529, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 530, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 530, column: 6
              System.out.println("Emitted bottlePos9");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S6641=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 533, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 533, column: 5
              System.out.println("Emitted bottlePos9B");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S6641){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 528, column: 11
                  S6620=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 530, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 530, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 534, column: 11
                  S6620=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6844(int [] tdone, int [] ends){
        switch(S6619){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S6446){
          case 0 : 
            S6446=0;
            S6446=1;
            if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 507, column: 8
              S6467=0;
              id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 508, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 510, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 510, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 511, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 511, column: 6
              System.out.println("Emitted bottlePos8");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S6467=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 514, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 514, column: 5
              System.out.println("Emitted bottlePos8B");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S6467){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 509, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 505, column: 4
                  S6446=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 511, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 511, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 515, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 505, column: 4
                  S6446=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6843(int [] tdone, int [] ends){
        switch(S6445){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S6272){
          case 0 : 
            S6272=0;
            S6272=1;
            if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 488, column: 8
              S6293=0;
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 489, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 491, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 491, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 492, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 492, column: 6
              System.out.println("Emitted bottlePos7");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S6293=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 495, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 495, column: 5
              System.out.println("Emitted bottlePos7B");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S6293){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 490, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 486, column: 4
                  S6272=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 492, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 492, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 496, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 486, column: 4
                  S6272=0;
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

  public void thread6842(int [] tdone, int [] ends){
        switch(S6271){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S6098){
          case 0 : 
            S6098=0;
            S6098=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 469, column: 8
              S6119=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 470, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 472, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 472, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 473, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 473, column: 6
              System.out.println("Emitted bottlePos6");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S6119=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 476, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 476, column: 5
              System.out.println("Emitted bottlePos6B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S6119){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 471, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 467, column: 4
                  S6098=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 473, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 473, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 477, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 467, column: 4
                  S6098=0;
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

  public void thread6841(int [] tdone, int [] ends){
        switch(S6097){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5924){
          case 0 : 
            S5924=0;
            S5924=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 450, column: 8
              S5945=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 451, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 453, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 453, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 454, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 454, column: 6
              System.out.println("Emitted bottlePos5");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5945=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 457, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 457, column: 5
              System.out.println("Emitted bottlePos5B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S5945){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 452, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 448, column: 4
                  S5924=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 454, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 454, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 458, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 448, column: 4
                  S5924=0;
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

  public void thread6840(int [] tdone, int [] ends){
        switch(S5923){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5750){
          case 0 : 
            S5750=0;
            S5750=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 431, column: 8
              S5771=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 432, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 434, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 434, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 435, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 435, column: 6
              System.out.println("Emitted bottlePos4");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5771=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 438, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 438, column: 5
              System.out.println("Emitted bottlePos4B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5771){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 433, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 429, column: 4
                  S5750=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 435, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 435, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 439, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 429, column: 4
                  S5750=0;
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

  public void thread6839(int [] tdone, int [] ends){
        switch(S5749){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5576){
          case 0 : 
            S5576=0;
            S5576=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 412, column: 8
              S5597=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 413, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 415, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 415, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 416, column: 6
              System.out.println("Emitted bottlePos3");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S5597=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 419, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 419, column: 5
              System.out.println("Emitted bottlePos3B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S5597){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 414, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
                  S5576=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 416, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 420, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
                  S5576=0;
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

  public void thread6838(int [] tdone, int [] ends){
        switch(S5575){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5402){
          case 0 : 
            S5402=0;
            S5402=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 392, column: 8
              S5423=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 393, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 395, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 395, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 396, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 396, column: 6
              System.out.println("Emitted bottlePos2");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5423=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 399, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 399, column: 5
              System.out.println("Emitted bottlePos2B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S5423){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 394, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 390, column: 4
                  S5402=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 396, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 396, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 400, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 390, column: 4
                  S5402=0;
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

  public void thread6837(int [] tdone, int [] ends){
        switch(S5401){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5228){
          case 0 : 
            S5228=0;
            S5228=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 369, column: 8
              S5249=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 370, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 372, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 372, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 374, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 374, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 375, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 375, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5249=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 380, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 380, column: 5
              System.out.println("Emitted bottlePos1B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5249){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
                  S5228=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 374, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 374, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 375, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 375, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 381, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
                  S5228=0;
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

  public void thread6836(int [] tdone, int [] ends){
        switch(S5227){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5054){
          case 0 : 
            S5054=0;
            S5054=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 350, column: 8
              S5075=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 351, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 353, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 353, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 354, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 354, column: 6
              System.out.println("Emitted bottlePos0");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5075=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 357, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 357, column: 5
              System.out.println("Emitted bottlePos0B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5075){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 352, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 348, column: 4
                  S5054=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 354, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 354, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 358, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 348, column: 4
                  S5054=0;
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

  public void thread6835(int [] tdone, int [] ends){
        switch(S5053){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5035){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 329, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 331, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S5035=1;
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
          
          case 1 : 
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 332, column: 10
              S5035=2;
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
          
          case 2 : 
            S5035=2;
            S5035=3;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 3 : 
            S5035=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 335, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S5035=4;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 337, column: 10
              S5035=0;
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
  }

  public void thread6834(int [] tdone, int [] ends){
        switch(S5033){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S5015){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 312, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 314, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S5015=1;
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
          
          case 1 : 
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 315, column: 10
              S5015=2;
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
          
          case 2 : 
            S5015=2;
            S5015=3;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 3 : 
            S5015=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 318, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S5015=4;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 320, column: 10
              S5015=0;
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
  }

  public void thread6833(int [] tdone, int [] ends){
        switch(S5013){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S5001){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 293, column: 10
              bSeven_thread_13 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 295, column: 4
              S5001=1;
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
            S5001=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 297, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 297, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 298, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_13);//sysj\Orchestrator.sysj line: 298, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S5001=2;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 2 : 
            S5001=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 301, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S5001=3;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 302, column: 10
              S5001=0;
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

  public void thread6832(int [] tdone, int [] ends){
        switch(S4999){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4981){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 262, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 265, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S4981=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 266, column: 10
              bOne_thread_12 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 267, column: 4
              bTwo_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 268, column: 4
              bThree_thread_12 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 269, column: 4
              bFour_thread_12 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 270, column: 4
              bFive_thread_12 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 271, column: 4
              bSix_thread_12 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 272, column: 4
              S4981=2;
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
          
          case 2 : 
            S4981=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 274, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_12);//sysj\Orchestrator.sysj line: 274, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 275, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_12);//sysj\Orchestrator.sysj line: 275, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 276, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_12);//sysj\Orchestrator.sysj line: 276, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 277, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_12);//sysj\Orchestrator.sysj line: 277, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 278, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_12);//sysj\Orchestrator.sysj line: 278, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 279, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_12);//sysj\Orchestrator.sysj line: 279, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S4981=3;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 3 : 
            S4981=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 282, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S4981=4;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 283, column: 10
              S4981=0;
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

  public void thread6831(int [] tdone, int [] ends){
        switch(S4979){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4955){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 235, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 238, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S4955=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 239, column: 10
              bZero_thread_11 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 241, column: 4
              bFive_thread_11 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 242, column: 4
              S4955=2;
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
            S4955=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 244, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 244, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 245, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 245, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 246, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_11);//sysj\Orchestrator.sysj line: 246, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 247, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_11);//sysj\Orchestrator.sysj line: 247, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S4955=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            S4955=3;
            S4955=4;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 4 : 
            if(!posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 250, column: 10
              conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 251, column: 4
              currsigs.addElement(conveyorFinish_1);
              System.out.println("Emitted conveyorFinish_1");
              S4955=5;
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
          
          case 5 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 252, column: 10
              S4955=0;
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

  public void thread6830(int [] tdone, int [] ends){
        switch(S4953){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4929){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 210, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 212, column: 4
              currsigs.addElement(startBottleLoading);
              System.out.println("Emitted startBottleLoading");
              S4929=1;
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
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 213, column: 10
              bEight_thread_10 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 215, column: 4
              S4929=2;
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
            S4929=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 217, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 217, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 218, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_10);//sysj\Orchestrator.sysj line: 218, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S4929=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 220, column: 10
              S4929=4;
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
          
          case 4 : 
            S4929=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 223, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S4929=5;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 224, column: 10
              S4929=0;
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

  public void thread6829(int [] tdone, int [] ends){
        switch(S4927){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4889){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 191, column: 10
              S4889=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 192, column: 12
                S4883=0;
                b_thread_9 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 193, column: 5
                if(!b_thread_9.isCapOn && !b_thread_9.isCapped){//sysj\Orchestrator.sysj line: 194, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 195, column: 6
                  currsigs.addElement(startCapLoaderThread_1);
                  System.out.println("Emitted startCapLoaderThread_1");
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
              else {
                S4883=1;
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
            switch(S4883){
              case 0 : 
                S4889=0;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S4889=0;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6828(int [] tdone, int [] ends){
        switch(S4877){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4839){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 173, column: 10
              S4839=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 174, column: 12
                S4833=0;
                b_thread_8 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 175, column: 5
                S4831=0;
                if(!b_thread_8.isFilled){//sysj\Orchestrator.sysj line: 176, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 177, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S4831=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S4831=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
              }
              else {
                S4833=1;
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
            switch(S4833){
              case 0 : 
                switch(S4831){
                  case 0 : 
                    S4839=0;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                    break;
                  
                  case 1 : 
                    S4831=1;
                    S4839=0;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                    break;
                  
                }
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 182, column: 5
                currsigs.addElement(fillerFinish_1);
                System.out.println("Emitted fillerFinish_1");
                S4839=0;
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

  public void thread6827(int [] tdone, int [] ends){
        switch(S4827){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4801){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 158, column: 10
              S4801=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 159, column: 12
                S4797=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 160, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4797=1;
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
            switch(S4797){
              case 0 : 
                S4801=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 164, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S4801=0;
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

  public void thread6826(int [] tdone, int [] ends){
        switch(S4793){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4767){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 141, column: 10
              S4767=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 143, column: 12
                S4763=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 144, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S4763=1;
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
            switch(S4763){
              case 0 : 
                S4767=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S4767=0;
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

  public void thread6825(int [] tdone, int [] ends){
        switch(S4759){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4733){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 126, column: 10
              S4733=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 127, column: 12
                S4729=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 128, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S4729=1;
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
            switch(S4729){
              case 0 : 
                S4733=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 132, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S4733=0;
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

  public void thread6824(int [] tdone, int [] ends){
        switch(S4725){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4699){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 111, column: 10
              S4699=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 12
                S4695=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 113, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S4695=1;
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
            switch(S4695){
              case 0 : 
                S4699=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 117, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S4699=0;
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

  public void thread6823(int [] tdone, int [] ends){
        switch(S4691){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4641){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S4641=1;
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
            S4641=1;
            S4641=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S4641=2;
            checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 4
            currsigs.addElement(checkFiller_1);
            System.out.println("Emitted checkFiller_1");
            S4641=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S4641=4;
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
            S4641=4;
            S4641=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            S4641=5;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 64, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4641=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 65, column: 10
              S4641=7;
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
            S4641=7;
            S4641=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            S4641=8;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 73, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S4641=9;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 9 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 74, column: 10
              S4641=10;
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
            S4641=10;
            S4641=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            S4641=11;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 78, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S4641=12;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 12 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 79, column: 10
              S4641=13;
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
            S4641=13;
            S4641=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            S4641=14;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 83, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4641=15;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 15 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 84, column: 10
              S4641=16;
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
            S4641=16;
            S4641=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            S4641=17;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S4641=18;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 18 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 89, column: 10
              S4641=19;
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
            S4641=19;
            S4641=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            S4641=20;
            checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 96, column: 4
            currsigs.addElement(checkRotTable_1);
            System.out.println("Emitted checkRotTable_1");
            S4641=21;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 21 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 97, column: 10
              S4641=22;
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
          
          case 22 : 
            S4641=22;
            S4641=23;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 23 : 
            S4641=23;
            checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
            currsigs.addElement(checkCapLoader_1);
            System.out.println("Emitted checkCapLoader_1");
            S4641=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6822(int [] tdone, int [] ends){
        switch(S4638){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S4582){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S4582=1;
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
                S4583=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S4582=0;
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
            switch(S4583){
              case 0 : 
                S4583=0;
                S4583=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S4583=1;
                S4583=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S4583=3;
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
                  S4582=0;
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

  public void thread6820(int [] tdone, int [] ends){
        S6793=1;
    S6620=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread6819(int [] tdone, int [] ends){
        S6619=1;
    b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 505, column: 4
    S6446=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread6818(int [] tdone, int [] ends){
        S6445=1;
    b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 486, column: 4
    S6272=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread6817(int [] tdone, int [] ends){
        S6271=1;
    b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 467, column: 4
    S6098=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread6816(int [] tdone, int [] ends){
        S6097=1;
    b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 448, column: 4
    S5924=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread6815(int [] tdone, int [] ends){
        S5923=1;
    b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 429, column: 4
    S5750=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread6814(int [] tdone, int [] ends){
        S5749=1;
    b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
    S5576=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread6813(int [] tdone, int [] ends){
        S5575=1;
    b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 390, column: 4
    S5402=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread6812(int [] tdone, int [] ends){
        S5401=1;
    b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 367, column: 4
    S5228=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread6811(int [] tdone, int [] ends){
        S5227=1;
    b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 348, column: 4
    S5054=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread6810(int [] tdone, int [] ends){
        S5053=1;
    S5035=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread6809(int [] tdone, int [] ends){
        S5033=1;
    S5015=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread6808(int [] tdone, int [] ends){
        S5013=1;
    S5001=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread6807(int [] tdone, int [] ends){
        S4999=1;
    S4981=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread6806(int [] tdone, int [] ends){
        S4979=1;
    S4955=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread6805(int [] tdone, int [] ends){
        S4953=1;
    S4929=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread6804(int [] tdone, int [] ends){
        S4927=1;
    S4889=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread6803(int [] tdone, int [] ends){
        S4877=1;
    S4839=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread6802(int [] tdone, int [] ends){
        S4827=1;
    S4801=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread6801(int [] tdone, int [] ends){
        S4793=1;
    S4767=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread6800(int [] tdone, int [] ends){
        S4759=1;
    S4733=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6799(int [] tdone, int [] ends){
        S4725=1;
    S4699=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread6798(int [] tdone, int [] ends){
        S4691=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
    currsigs.addElement(checkCapLoader_1);
    System.out.println("Emitted checkCapLoader_1");
    S4641=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6797(int [] tdone, int [] ends){
        S4638=1;
    S4582=0;
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
      switch(S6795){
        case 0 : 
          S6795=0;
          break RUN;
        
        case 1 : 
          S6795=2;
          S6795=2;
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
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread6797(tdone,ends);
          thread6798(tdone,ends);
          thread6799(tdone,ends);
          thread6800(tdone,ends);
          thread6801(tdone,ends);
          thread6802(tdone,ends);
          thread6803(tdone,ends);
          thread6804(tdone,ends);
          thread6805(tdone,ends);
          thread6806(tdone,ends);
          thread6807(tdone,ends);
          thread6808(tdone,ends);
          thread6809(tdone,ends);
          thread6810(tdone,ends);
          thread6811(tdone,ends);
          thread6812(tdone,ends);
          thread6813(tdone,ends);
          thread6814(tdone,ends);
          thread6815(tdone,ends);
          thread6816(tdone,ends);
          thread6817(tdone,ends);
          thread6818(tdone,ends);
          thread6819(tdone,ends);
          thread6820(tdone,ends);
          int biggest6821 = 0;
          if(ends[2]>=biggest6821){
            biggest6821=ends[2];
          }
          if(ends[3]>=biggest6821){
            biggest6821=ends[3];
          }
          if(ends[4]>=biggest6821){
            biggest6821=ends[4];
          }
          if(ends[5]>=biggest6821){
            biggest6821=ends[5];
          }
          if(ends[6]>=biggest6821){
            biggest6821=ends[6];
          }
          if(ends[7]>=biggest6821){
            biggest6821=ends[7];
          }
          if(ends[8]>=biggest6821){
            biggest6821=ends[8];
          }
          if(ends[9]>=biggest6821){
            biggest6821=ends[9];
          }
          if(ends[10]>=biggest6821){
            biggest6821=ends[10];
          }
          if(ends[11]>=biggest6821){
            biggest6821=ends[11];
          }
          if(ends[12]>=biggest6821){
            biggest6821=ends[12];
          }
          if(ends[13]>=biggest6821){
            biggest6821=ends[13];
          }
          if(ends[14]>=biggest6821){
            biggest6821=ends[14];
          }
          if(ends[15]>=biggest6821){
            biggest6821=ends[15];
          }
          if(ends[16]>=biggest6821){
            biggest6821=ends[16];
          }
          if(ends[17]>=biggest6821){
            biggest6821=ends[17];
          }
          if(ends[18]>=biggest6821){
            biggest6821=ends[18];
          }
          if(ends[19]>=biggest6821){
            biggest6821=ends[19];
          }
          if(ends[20]>=biggest6821){
            biggest6821=ends[20];
          }
          if(ends[21]>=biggest6821){
            biggest6821=ends[21];
          }
          if(ends[22]>=biggest6821){
            biggest6821=ends[22];
          }
          if(ends[23]>=biggest6821){
            biggest6821=ends[23];
          }
          if(ends[24]>=biggest6821){
            biggest6821=ends[24];
          }
          if(ends[25]>=biggest6821){
            biggest6821=ends[25];
          }
          if(biggest6821 == 1){
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
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread6822(tdone,ends);
          thread6823(tdone,ends);
          thread6824(tdone,ends);
          thread6825(tdone,ends);
          thread6826(tdone,ends);
          thread6827(tdone,ends);
          thread6828(tdone,ends);
          thread6829(tdone,ends);
          thread6830(tdone,ends);
          thread6831(tdone,ends);
          thread6832(tdone,ends);
          thread6833(tdone,ends);
          thread6834(tdone,ends);
          thread6835(tdone,ends);
          thread6836(tdone,ends);
          thread6837(tdone,ends);
          thread6838(tdone,ends);
          thread6839(tdone,ends);
          thread6840(tdone,ends);
          thread6841(tdone,ends);
          thread6842(tdone,ends);
          thread6843(tdone,ends);
          thread6844(tdone,ends);
          thread6845(tdone,ends);
          int biggest6846 = 0;
          if(ends[2]>=biggest6846){
            biggest6846=ends[2];
          }
          if(ends[3]>=biggest6846){
            biggest6846=ends[3];
          }
          if(ends[4]>=biggest6846){
            biggest6846=ends[4];
          }
          if(ends[5]>=biggest6846){
            biggest6846=ends[5];
          }
          if(ends[6]>=biggest6846){
            biggest6846=ends[6];
          }
          if(ends[7]>=biggest6846){
            biggest6846=ends[7];
          }
          if(ends[8]>=biggest6846){
            biggest6846=ends[8];
          }
          if(ends[9]>=biggest6846){
            biggest6846=ends[9];
          }
          if(ends[10]>=biggest6846){
            biggest6846=ends[10];
          }
          if(ends[11]>=biggest6846){
            biggest6846=ends[11];
          }
          if(ends[12]>=biggest6846){
            biggest6846=ends[12];
          }
          if(ends[13]>=biggest6846){
            biggest6846=ends[13];
          }
          if(ends[14]>=biggest6846){
            biggest6846=ends[14];
          }
          if(ends[15]>=biggest6846){
            biggest6846=ends[15];
          }
          if(ends[16]>=biggest6846){
            biggest6846=ends[16];
          }
          if(ends[17]>=biggest6846){
            biggest6846=ends[17];
          }
          if(ends[18]>=biggest6846){
            biggest6846=ends[18];
          }
          if(ends[19]>=biggest6846){
            biggest6846=ends[19];
          }
          if(ends[20]>=biggest6846){
            biggest6846=ends[20];
          }
          if(ends[21]>=biggest6846){
            biggest6846=ends[21];
          }
          if(ends[22]>=biggest6846){
            biggest6846=ends[22];
          }
          if(ends[23]>=biggest6846){
            biggest6846=ends[23];
          }
          if(ends[24]>=biggest6846){
            biggest6846=ends[24];
          }
          if(ends[25]>=biggest6846){
            biggest6846=ends[25];
          }
          if(biggest6846 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6846 == 0){
            S6795=0;
            active[1]=0;
            ends[1]=0;
            S6795=0;
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
    checkCapLoader_1 = new Signal();
    robotLoaderFinish_1 = new Signal();
    conveyorFinish_1 = new Signal();
    rotTableFinish_1 = new Signal();
    robotUnloaderFinish_1 = new Signal();
    fillerFinish_1 = new Signal();
    capLoaderFinish_1 = new Signal();
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
          bottleLoaded.gethook();
          bottleUnloaded.gethook();
          bottleLoaderRelease.gethook();
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
      bottleLoaded.setpreclear();
      bottleUnloaded.setpreclear();
      bottleLoaderRelease.setpreclear();
      recieveTwin.setpreclear();
      startConveyor.setpreclear();
      startRotTable.setpreclear();
      startFilling.setpreclear();
      startCapLoading.setpreclear();
      startBottleLoading.setpreclear();
      startBottleUnloading.setpreclear();
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
      checkCapLoader_1.setpreclear();
      robotLoaderFinish_1.setpreclear();
      conveyorFinish_1.setpreclear();
      rotTableFinish_1.setpreclear();
      robotUnloaderFinish_1.setpreclear();
      fillerFinish_1.setpreclear();
      capLoaderFinish_1.setpreclear();
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
      dummyint = bottleLoaded.getStatus() ? bottleLoaded.setprepresent() : bottleLoaded.setpreclear();
      bottleLoaded.setpreval(bottleLoaded.getValue());
      bottleLoaded.setClear();
      dummyint = bottleUnloaded.getStatus() ? bottleUnloaded.setprepresent() : bottleUnloaded.setpreclear();
      bottleUnloaded.setpreval(bottleUnloaded.getValue());
      bottleUnloaded.setClear();
      dummyint = bottleLoaderRelease.getStatus() ? bottleLoaderRelease.setprepresent() : bottleLoaderRelease.setpreclear();
      bottleLoaderRelease.setpreval(bottleLoaderRelease.getValue());
      bottleLoaderRelease.setClear();
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
      startBottleLoading.sethook();
      startBottleLoading.setClear();
      startBottleUnloading.sethook();
      startBottleUnloading.setClear();
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
      checkCapLoader_1.setClear();
      robotLoaderFinish_1.setClear();
      conveyorFinish_1.setClear();
      rotTableFinish_1.setClear();
      robotUnloaderFinish_1.setClear();
      fillerFinish_1.setClear();
      capLoaderFinish_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capLoaded.gethook();
        bottleLoaded.gethook();
        bottleUnloaded.gethook();
        bottleLoaderRelease.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
