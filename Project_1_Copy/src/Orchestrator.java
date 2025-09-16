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
  private BottleTwin bEight_thread_10;//sysj\Orchestrator.sysj line: 212, column: 4
  private BottleTwin bZero_thread_11;//sysj\Orchestrator.sysj line: 236, column: 4
  private BottleTwin bFive_thread_11;//sysj\Orchestrator.sysj line: 237, column: 4
  private BottleTwin bOne_thread_12;//sysj\Orchestrator.sysj line: 262, column: 4
  private BottleTwin bTwo_thread_12;//sysj\Orchestrator.sysj line: 263, column: 4
  private BottleTwin bThree_thread_12;//sysj\Orchestrator.sysj line: 264, column: 4
  private BottleTwin bFour_thread_12;//sysj\Orchestrator.sysj line: 265, column: 4
  private BottleTwin bFive_thread_12;//sysj\Orchestrator.sysj line: 266, column: 4
  private BottleTwin bSix_thread_12;//sysj\Orchestrator.sysj line: 267, column: 4
  private BottleTwin bSeven_thread_13;//sysj\Orchestrator.sysj line: 290, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 346, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 343, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 365, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 362, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 388, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 385, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 408, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 405, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 427, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 424, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 446, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 443, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 465, column: 5
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 462, column: 4
  private int id_thread_23;//sysj\Orchestrator.sysj line: 484, column: 5
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 481, column: 4
  private int id_thread_24;//sysj\Orchestrator.sysj line: 503, column: 5
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 500, column: 4
  private BottleTwin b_thread_25;//sysj\Orchestrator.sysj line: 520, column: 4
  private int id_thread_25;//sysj\Orchestrator.sysj line: 522, column: 5
  private int S6792 = 1;
  private int S4638 = 1;
  private int S4582 = 1;
  private int S4583 = 1;
  private int S4700 = 1;
  private int S4642 = 1;
  private int S4734 = 1;
  private int S4708 = 1;
  private int S4704 = 1;
  private int S4768 = 1;
  private int S4742 = 1;
  private int S4738 = 1;
  private int S4802 = 1;
  private int S4776 = 1;
  private int S4772 = 1;
  private int S4836 = 1;
  private int S4810 = 1;
  private int S4806 = 1;
  private int S4886 = 1;
  private int S4848 = 1;
  private int S4842 = 1;
  private int S4840 = 1;
  private int S4936 = 1;
  private int S4898 = 1;
  private int S4892 = 1;
  private int S4950 = 1;
  private int S4938 = 1;
  private int S4976 = 1;
  private int S4952 = 1;
  private int S4996 = 1;
  private int S4978 = 1;
  private int S5010 = 1;
  private int S4998 = 1;
  private int S5030 = 1;
  private int S5012 = 1;
  private int S5050 = 1;
  private int S5032 = 1;
  private int S5224 = 1;
  private int S5051 = 1;
  private int S5072 = 1;
  private int S5398 = 1;
  private int S5225 = 1;
  private int S5246 = 1;
  private int S5572 = 1;
  private int S5399 = 1;
  private int S5420 = 1;
  private int S5746 = 1;
  private int S5573 = 1;
  private int S5594 = 1;
  private int S5920 = 1;
  private int S5747 = 1;
  private int S5768 = 1;
  private int S6094 = 1;
  private int S5921 = 1;
  private int S5942 = 1;
  private int S6268 = 1;
  private int S6095 = 1;
  private int S6116 = 1;
  private int S6442 = 1;
  private int S6269 = 1;
  private int S6290 = 1;
  private int S6616 = 1;
  private int S6443 = 1;
  private int S6464 = 1;
  private int S6790 = 1;
  private int S6617 = 1;
  private int S6638 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread6842(int [] tdone, int [] ends){
        switch(S6790){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S6617){
          case 0 : 
            S6617=0;
            b_thread_25 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 520, column: 4
            S6617=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 521, column: 8
              S6638=0;
              id_thread_25 = b_thread_25.ID;//sysj\Orchestrator.sysj line: 522, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 524, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_25);//sysj\Orchestrator.sysj line: 524, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 525, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 525, column: 6
              System.out.println("Emitted bottlePos9");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S6638=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 528, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 528, column: 5
              System.out.println("Emitted bottlePos9B");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S6638){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 523, column: 11
                  S6617=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 525, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 525, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 529, column: 11
                  S6617=0;
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

  public void thread6841(int [] tdone, int [] ends){
        switch(S6616){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S6443){
          case 0 : 
            S6443=0;
            S6443=1;
            if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 502, column: 8
              S6464=0;
              id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 503, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 505, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 505, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 506, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 506, column: 6
              System.out.println("Emitted bottlePos8");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S6464=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 509, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 509, column: 5
              System.out.println("Emitted bottlePos8B");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S6464){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 504, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 500, column: 4
                  S6443=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 506, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 506, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 510, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 500, column: 4
                  S6443=0;
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

  public void thread6840(int [] tdone, int [] ends){
        switch(S6442){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S6269){
          case 0 : 
            S6269=0;
            S6269=1;
            if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 483, column: 8
              S6290=0;
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 484, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 486, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 486, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 487, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 487, column: 6
              System.out.println("Emitted bottlePos7");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S6290=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 490, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 490, column: 5
              System.out.println("Emitted bottlePos7B");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S6290){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 485, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 481, column: 4
                  S6269=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 487, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 487, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 491, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 481, column: 4
                  S6269=0;
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

  public void thread6839(int [] tdone, int [] ends){
        switch(S6268){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S6095){
          case 0 : 
            S6095=0;
            S6095=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 464, column: 8
              S6116=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 465, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 467, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 467, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 468, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 468, column: 6
              System.out.println("Emitted bottlePos6");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S6116=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 471, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 471, column: 5
              System.out.println("Emitted bottlePos6B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S6116){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 466, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
                  S6095=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 468, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 468, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 472, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
                  S6095=0;
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

  public void thread6838(int [] tdone, int [] ends){
        switch(S6094){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5921){
          case 0 : 
            S5921=0;
            S5921=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 445, column: 8
              S5942=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 446, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 448, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 448, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 449, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 449, column: 6
              System.out.println("Emitted bottlePos5");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5942=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 452, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 452, column: 5
              System.out.println("Emitted bottlePos5B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S5942){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 447, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
                  S5921=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 449, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 449, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 453, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
                  S5921=0;
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

  public void thread6837(int [] tdone, int [] ends){
        switch(S5920){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5747){
          case 0 : 
            S5747=0;
            S5747=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 426, column: 8
              S5768=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 427, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 429, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 429, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 430, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 430, column: 6
              System.out.println("Emitted bottlePos4");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5768=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 433, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 433, column: 5
              System.out.println("Emitted bottlePos4B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5768){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 428, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
                  S5747=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 430, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 430, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 434, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
                  S5747=0;
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

  public void thread6836(int [] tdone, int [] ends){
        switch(S5746){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5573){
          case 0 : 
            S5573=0;
            S5573=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 407, column: 8
              S5594=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 408, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 410, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 410, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 411, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 411, column: 6
              System.out.println("Emitted bottlePos3");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S5594=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 414, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 414, column: 5
              System.out.println("Emitted bottlePos3B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S5594){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 409, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
                  S5573=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 411, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 411, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 415, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
                  S5573=0;
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

  public void thread6835(int [] tdone, int [] ends){
        switch(S5572){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5399){
          case 0 : 
            S5399=0;
            S5399=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 387, column: 8
              S5420=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 388, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 390, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 390, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 391, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 391, column: 6
              System.out.println("Emitted bottlePos2");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5420=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 394, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 394, column: 5
              System.out.println("Emitted bottlePos2B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S5420){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 389, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
                  S5399=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 391, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 391, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 395, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
                  S5399=0;
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

  public void thread6834(int [] tdone, int [] ends){
        switch(S5398){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5225){
          case 0 : 
            S5225=0;
            S5225=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 364, column: 8
              S5246=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 365, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 367, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 367, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 369, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 369, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 370, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 370, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5246=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 375, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 375, column: 5
              System.out.println("Emitted bottlePos1B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5246){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 366, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
                  S5225=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 369, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 369, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 370, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 370, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 376, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
                  S5225=0;
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

  public void thread6833(int [] tdone, int [] ends){
        switch(S5224){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5051){
          case 0 : 
            S5051=0;
            S5051=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 345, column: 8
              S5072=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 346, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 348, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 348, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 349, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 349, column: 6
              System.out.println("Emitted bottlePos0");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5072=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 352, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 352, column: 5
              System.out.println("Emitted bottlePos0B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5072){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
                  S5051=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 349, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 349, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 353, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
                  S5051=0;
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

  public void thread6832(int [] tdone, int [] ends){
        switch(S5050){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5032){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 324, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 326, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S5032=1;
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
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 327, column: 10
              S5032=2;
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
            S5032=2;
            S5032=3;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 3 : 
            S5032=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 330, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S5032=4;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 332, column: 10
              S5032=0;
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

  public void thread6831(int [] tdone, int [] ends){
        switch(S5030){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S5012){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 307, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 309, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S5012=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 310, column: 10
              S5012=2;
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
            S5012=2;
            S5012=3;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 3 : 
            S5012=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 313, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S5012=4;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 315, column: 10
              S5012=0;
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

  public void thread6830(int [] tdone, int [] ends){
        switch(S5010){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S4998){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 288, column: 10
              bSeven_thread_13 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 290, column: 4
              S4998=1;
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
            S4998=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 292, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 292, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 293, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_13);//sysj\Orchestrator.sysj line: 293, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S4998=2;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 2 : 
            S4998=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 296, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S4998=3;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 297, column: 10
              S4998=0;
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

  public void thread6829(int [] tdone, int [] ends){
        switch(S4996){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4978){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 257, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 260, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S4978=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 261, column: 10
              bOne_thread_12 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 262, column: 4
              bTwo_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 263, column: 4
              bThree_thread_12 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 264, column: 4
              bFour_thread_12 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 265, column: 4
              bFive_thread_12 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 266, column: 4
              bSix_thread_12 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 267, column: 4
              S4978=2;
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
            S4978=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 269, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_12);//sysj\Orchestrator.sysj line: 269, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 270, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_12);//sysj\Orchestrator.sysj line: 270, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 271, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_12);//sysj\Orchestrator.sysj line: 271, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 272, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_12);//sysj\Orchestrator.sysj line: 272, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 273, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_12);//sysj\Orchestrator.sysj line: 273, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 274, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_12);//sysj\Orchestrator.sysj line: 274, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S4978=3;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 3 : 
            S4978=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 277, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S4978=4;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 278, column: 10
              S4978=0;
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

  public void thread6828(int [] tdone, int [] ends){
        switch(S4976){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4952){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 230, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 233, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S4952=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 234, column: 10
              bZero_thread_11 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 236, column: 4
              bFive_thread_11 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 237, column: 4
              S4952=2;
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
            S4952=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 239, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 239, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 240, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 240, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 241, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_11);//sysj\Orchestrator.sysj line: 241, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 242, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_11);//sysj\Orchestrator.sysj line: 242, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S4952=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            S4952=3;
            S4952=4;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 4 : 
            if(!posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 245, column: 10
              conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 246, column: 4
              currsigs.addElement(conveyorFinish_1);
              System.out.println("Emitted conveyorFinish_1");
              S4952=5;
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
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 247, column: 10
              S4952=0;
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

  public void thread6827(int [] tdone, int [] ends){
        switch(S4950){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4938){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 210, column: 10
              bEight_thread_10 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 212, column: 4
              S4938=1;
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
            S4938=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 214, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 214, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 215, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_10);//sysj\Orchestrator.sysj line: 215, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S4938=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S4938=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 218, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S4938=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 219, column: 10
              S4938=0;
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

  public void thread6826(int [] tdone, int [] ends){
        switch(S4936){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4898){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 191, column: 10
              S4898=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 192, column: 12
                S4892=0;
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
                S4892=1;
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
            switch(S4892){
              case 0 : 
                S4898=0;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S4898=0;
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

  public void thread6825(int [] tdone, int [] ends){
        switch(S4886){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4848){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 173, column: 10
              S4848=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 174, column: 12
                S4842=0;
                b_thread_8 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 175, column: 5
                S4840=0;
                if(!b_thread_8.isFilled){//sysj\Orchestrator.sysj line: 176, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 177, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S4840=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S4840=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
              }
              else {
                S4842=1;
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
            switch(S4842){
              case 0 : 
                switch(S4840){
                  case 0 : 
                    S4848=0;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                    break;
                  
                  case 1 : 
                    S4840=1;
                    S4848=0;
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
                S4848=0;
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

  public void thread6824(int [] tdone, int [] ends){
        switch(S4836){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4810){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 158, column: 10
              S4810=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 159, column: 12
                S4806=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 160, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4806=1;
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
            switch(S4806){
              case 0 : 
                S4810=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 164, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S4810=0;
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

  public void thread6823(int [] tdone, int [] ends){
        switch(S4802){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4776){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 141, column: 10
              S4776=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 143, column: 12
                S4772=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 144, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S4772=1;
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
            switch(S4772){
              case 0 : 
                S4776=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S4776=0;
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

  public void thread6822(int [] tdone, int [] ends){
        switch(S4768){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4742){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 126, column: 10
              S4742=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 127, column: 12
                S4738=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 128, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S4738=1;
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
            switch(S4738){
              case 0 : 
                S4742=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 132, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S4742=0;
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

  public void thread6821(int [] tdone, int [] ends){
        switch(S4734){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4708){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 111, column: 10
              S4708=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 12
                S4704=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 113, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S4704=1;
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
            switch(S4704){
              case 0 : 
                S4708=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 117, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S4708=0;
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

  public void thread6820(int [] tdone, int [] ends){
        switch(S4700){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4642){
          case 0 : 
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
              S4642=1;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 50, column: 10
              checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
              currsigs.addElement(checkCapLoader_1);
              System.out.println("Emitted checkCapLoader_1");
              S4642=2;
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
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S4642=3;
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
          
          case 3 : 
            S4642=3;
            S4642=4;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            S4642=4;
            checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 4
            currsigs.addElement(checkFiller_1);
            System.out.println("Emitted checkFiller_1");
            S4642=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S4642=6;
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
            S4642=6;
            S4642=7;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 7 : 
            S4642=7;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 64, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4642=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 65, column: 10
              S4642=9;
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
          
          case 9 : 
            S4642=9;
            S4642=10;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 10 : 
            S4642=10;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 73, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S4642=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 74, column: 10
              S4642=12;
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
          
          case 12 : 
            S4642=12;
            S4642=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            S4642=13;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 78, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S4642=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 79, column: 10
              S4642=15;
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
          
          case 15 : 
            S4642=15;
            S4642=16;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 16 : 
            S4642=16;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 83, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4642=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 84, column: 10
              S4642=18;
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
          
          case 18 : 
            S4642=18;
            S4642=19;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 19 : 
            S4642=19;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S4642=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 89, column: 10
              S4642=21;
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
          
          case 21 : 
            S4642=21;
            S4642=22;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 22 : 
            S4642=22;
            checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 96, column: 4
            currsigs.addElement(checkRotTable_1);
            System.out.println("Emitted checkRotTable_1");
            S4642=23;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 23 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 97, column: 10
              S4642=24;
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
          
          case 24 : 
            S4642=24;
            S4642=25;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 25 : 
            S4642=25;
            S4642=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6819(int [] tdone, int [] ends){
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

  public void thread6817(int [] tdone, int [] ends){
        S6790=1;
    S6617=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread6816(int [] tdone, int [] ends){
        S6616=1;
    b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 500, column: 4
    S6443=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread6815(int [] tdone, int [] ends){
        S6442=1;
    b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 481, column: 4
    S6269=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread6814(int [] tdone, int [] ends){
        S6268=1;
    b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 462, column: 4
    S6095=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread6813(int [] tdone, int [] ends){
        S6094=1;
    b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 443, column: 4
    S5921=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread6812(int [] tdone, int [] ends){
        S5920=1;
    b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 424, column: 4
    S5747=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread6811(int [] tdone, int [] ends){
        S5746=1;
    b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 405, column: 4
    S5573=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread6810(int [] tdone, int [] ends){
        S5572=1;
    b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
    S5399=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread6809(int [] tdone, int [] ends){
        S5398=1;
    b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
    S5225=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread6808(int [] tdone, int [] ends){
        S5224=1;
    b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
    S5051=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread6807(int [] tdone, int [] ends){
        S5050=1;
    S5032=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread6806(int [] tdone, int [] ends){
        S5030=1;
    S5012=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread6805(int [] tdone, int [] ends){
        S5010=1;
    S4998=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread6804(int [] tdone, int [] ends){
        S4996=1;
    S4978=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread6803(int [] tdone, int [] ends){
        S4976=1;
    S4952=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread6802(int [] tdone, int [] ends){
        S4950=1;
    S4938=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread6801(int [] tdone, int [] ends){
        S4936=1;
    S4898=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread6800(int [] tdone, int [] ends){
        S4886=1;
    S4848=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread6799(int [] tdone, int [] ends){
        S4836=1;
    S4810=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread6798(int [] tdone, int [] ends){
        S4802=1;
    S4776=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread6797(int [] tdone, int [] ends){
        S4768=1;
    S4742=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6796(int [] tdone, int [] ends){
        S4734=1;
    S4708=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread6795(int [] tdone, int [] ends){
        S4700=1;
    S4642=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6794(int [] tdone, int [] ends){
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
      switch(S6792){
        case 0 : 
          S6792=0;
          break RUN;
        
        case 1 : 
          S6792=2;
          S6792=2;
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
          thread6794(tdone,ends);
          thread6795(tdone,ends);
          thread6796(tdone,ends);
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
          int biggest6818 = 0;
          if(ends[2]>=biggest6818){
            biggest6818=ends[2];
          }
          if(ends[3]>=biggest6818){
            biggest6818=ends[3];
          }
          if(ends[4]>=biggest6818){
            biggest6818=ends[4];
          }
          if(ends[5]>=biggest6818){
            biggest6818=ends[5];
          }
          if(ends[6]>=biggest6818){
            biggest6818=ends[6];
          }
          if(ends[7]>=biggest6818){
            biggest6818=ends[7];
          }
          if(ends[8]>=biggest6818){
            biggest6818=ends[8];
          }
          if(ends[9]>=biggest6818){
            biggest6818=ends[9];
          }
          if(ends[10]>=biggest6818){
            biggest6818=ends[10];
          }
          if(ends[11]>=biggest6818){
            biggest6818=ends[11];
          }
          if(ends[12]>=biggest6818){
            biggest6818=ends[12];
          }
          if(ends[13]>=biggest6818){
            biggest6818=ends[13];
          }
          if(ends[14]>=biggest6818){
            biggest6818=ends[14];
          }
          if(ends[15]>=biggest6818){
            biggest6818=ends[15];
          }
          if(ends[16]>=biggest6818){
            biggest6818=ends[16];
          }
          if(ends[17]>=biggest6818){
            biggest6818=ends[17];
          }
          if(ends[18]>=biggest6818){
            biggest6818=ends[18];
          }
          if(ends[19]>=biggest6818){
            biggest6818=ends[19];
          }
          if(ends[20]>=biggest6818){
            biggest6818=ends[20];
          }
          if(ends[21]>=biggest6818){
            biggest6818=ends[21];
          }
          if(ends[22]>=biggest6818){
            biggest6818=ends[22];
          }
          if(ends[23]>=biggest6818){
            biggest6818=ends[23];
          }
          if(ends[24]>=biggest6818){
            biggest6818=ends[24];
          }
          if(ends[25]>=biggest6818){
            biggest6818=ends[25];
          }
          if(biggest6818 == 1){
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
          thread6819(tdone,ends);
          thread6820(tdone,ends);
          thread6821(tdone,ends);
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
          int biggest6843 = 0;
          if(ends[2]>=biggest6843){
            biggest6843=ends[2];
          }
          if(ends[3]>=biggest6843){
            biggest6843=ends[3];
          }
          if(ends[4]>=biggest6843){
            biggest6843=ends[4];
          }
          if(ends[5]>=biggest6843){
            biggest6843=ends[5];
          }
          if(ends[6]>=biggest6843){
            biggest6843=ends[6];
          }
          if(ends[7]>=biggest6843){
            biggest6843=ends[7];
          }
          if(ends[8]>=biggest6843){
            biggest6843=ends[8];
          }
          if(ends[9]>=biggest6843){
            biggest6843=ends[9];
          }
          if(ends[10]>=biggest6843){
            biggest6843=ends[10];
          }
          if(ends[11]>=biggest6843){
            biggest6843=ends[11];
          }
          if(ends[12]>=biggest6843){
            biggest6843=ends[12];
          }
          if(ends[13]>=biggest6843){
            biggest6843=ends[13];
          }
          if(ends[14]>=biggest6843){
            biggest6843=ends[14];
          }
          if(ends[15]>=biggest6843){
            biggest6843=ends[15];
          }
          if(ends[16]>=biggest6843){
            biggest6843=ends[16];
          }
          if(ends[17]>=biggest6843){
            biggest6843=ends[17];
          }
          if(ends[18]>=biggest6843){
            biggest6843=ends[18];
          }
          if(ends[19]>=biggest6843){
            biggest6843=ends[19];
          }
          if(ends[20]>=biggest6843){
            biggest6843=ends[20];
          }
          if(ends[21]>=biggest6843){
            biggest6843=ends[21];
          }
          if(ends[22]>=biggest6843){
            biggest6843=ends[22];
          }
          if(ends[23]>=biggest6843){
            biggest6843=ends[23];
          }
          if(ends[24]>=biggest6843){
            biggest6843=ends[24];
          }
          if(ends[25]>=biggest6843){
            biggest6843=ends[25];
          }
          if(biggest6843 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6843 == 0){
            S6792=0;
            active[1]=0;
            ends[1]=0;
            S6792=0;
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
