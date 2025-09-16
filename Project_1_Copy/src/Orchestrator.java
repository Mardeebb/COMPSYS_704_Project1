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
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal conveyorMoved = new Signal("conveyorMoved", Signal.INPUT);
  public Signal rotTableTurned = new Signal("rotTableTurned", Signal.INPUT);
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal capLoaded = new Signal("capLoaded", Signal.INPUT);
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.INPUT);
  public Signal bottleUnloaded = new Signal("bottleUnloaded", Signal.INPUT);
  public Signal bottleLoaderRelease = new Signal("bottleLoaderRelease", Signal.INPUT);
  public Signal bottleUnloaderRelease = new Signal("bottleUnloaderRelease", Signal.INPUT);
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
  private BottleTwin b_thread_8;//sysj\Orchestrator.sysj line: 194, column: 5
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 212, column: 5
  private BottleTwin bEight_thread_10;//sysj\Orchestrator.sysj line: 234, column: 4
  private BottleTwin bZero_thread_11;//sysj\Orchestrator.sysj line: 260, column: 4
  private BottleTwin bFive_thread_11;//sysj\Orchestrator.sysj line: 261, column: 4
  private BottleTwin bOne_thread_12;//sysj\Orchestrator.sysj line: 285, column: 4
  private BottleTwin bTwo_thread_12;//sysj\Orchestrator.sysj line: 286, column: 4
  private BottleTwin bThree_thread_12;//sysj\Orchestrator.sysj line: 287, column: 4
  private BottleTwin bFour_thread_12;//sysj\Orchestrator.sysj line: 288, column: 4
  private BottleTwin bFive_thread_12;//sysj\Orchestrator.sysj line: 289, column: 4
  private BottleTwin bSix_thread_12;//sysj\Orchestrator.sysj line: 290, column: 4
  private BottleTwin bSeven_thread_13;//sysj\Orchestrator.sysj line: 315, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 371, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 368, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 390, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 387, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 413, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 410, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 433, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 430, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 452, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 449, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 471, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 468, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 490, column: 5
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 487, column: 4
  private int id_thread_23;//sysj\Orchestrator.sysj line: 509, column: 5
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 506, column: 4
  private int id_thread_24;//sysj\Orchestrator.sysj line: 528, column: 5
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 525, column: 4
  private BottleTwin b_thread_25;//sysj\Orchestrator.sysj line: 545, column: 4
  private int id_thread_25;//sysj\Orchestrator.sysj line: 547, column: 5
  private int S6754 = 1;
  private int S4543 = 1;
  private int S4487 = 1;
  private int S4488 = 1;
  private int S4644 = 1;
  private int S4546 = 1;
  private int S4678 = 1;
  private int S4652 = 1;
  private int S4648 = 1;
  private int S4712 = 1;
  private int S4686 = 1;
  private int S4682 = 1;
  private int S4746 = 1;
  private int S4720 = 1;
  private int S4716 = 1;
  private int S4780 = 1;
  private int S4754 = 1;
  private int S4750 = 1;
  private int S4830 = 1;
  private int S4792 = 1;
  private int S4786 = 1;
  private int S4784 = 1;
  private int S4880 = 1;
  private int S4842 = 1;
  private int S4836 = 1;
  private int S4906 = 1;
  private int S4882 = 1;
  private int S4926 = 1;
  private int S4908 = 1;
  private int S4946 = 1;
  private int S4928 = 1;
  private int S4972 = 1;
  private int S4948 = 1;
  private int S4992 = 1;
  private int S4974 = 1;
  private int S5012 = 1;
  private int S4994 = 1;
  private int S5186 = 1;
  private int S5013 = 1;
  private int S5034 = 1;
  private int S5360 = 1;
  private int S5187 = 1;
  private int S5208 = 1;
  private int S5534 = 1;
  private int S5361 = 1;
  private int S5382 = 1;
  private int S5708 = 1;
  private int S5535 = 1;
  private int S5556 = 1;
  private int S5882 = 1;
  private int S5709 = 1;
  private int S5730 = 1;
  private int S6056 = 1;
  private int S5883 = 1;
  private int S5904 = 1;
  private int S6230 = 1;
  private int S6057 = 1;
  private int S6078 = 1;
  private int S6404 = 1;
  private int S6231 = 1;
  private int S6252 = 1;
  private int S6578 = 1;
  private int S6405 = 1;
  private int S6426 = 1;
  private int S6752 = 1;
  private int S6579 = 1;
  private int S6600 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread6804(int [] tdone, int [] ends){
        switch(S6752){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S6579){
          case 0 : 
            S6579=0;
            b_thread_25 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 545, column: 4
            S6579=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 546, column: 8
              S6600=0;
              id_thread_25 = b_thread_25.ID;//sysj\Orchestrator.sysj line: 547, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 549, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_25);//sysj\Orchestrator.sysj line: 549, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 550, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 550, column: 6
              System.out.println("Emitted bottlePos9");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S6600=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 553, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 553, column: 5
              System.out.println("Emitted bottlePos9B");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S6600){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 548, column: 11
                  S6579=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 550, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 550, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 554, column: 11
                  S6579=0;
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

  public void thread6803(int [] tdone, int [] ends){
        switch(S6578){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S6405){
          case 0 : 
            S6405=0;
            S6405=1;
            if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 527, column: 8
              S6426=0;
              id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 528, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 530, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 530, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 531, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 531, column: 6
              System.out.println("Emitted bottlePos8");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S6426=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 534, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 534, column: 5
              System.out.println("Emitted bottlePos8B");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S6426){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 529, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 525, column: 4
                  S6405=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 531, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 531, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 535, column: 11
                  b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 525, column: 4
                  S6405=0;
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

  public void thread6802(int [] tdone, int [] ends){
        switch(S6404){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S6231){
          case 0 : 
            S6231=0;
            S6231=1;
            if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 508, column: 8
              S6252=0;
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 509, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 511, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 511, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 512, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 512, column: 6
              System.out.println("Emitted bottlePos7");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S6252=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 515, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 515, column: 5
              System.out.println("Emitted bottlePos7B");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S6252){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 510, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 506, column: 4
                  S6231=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 512, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 512, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 516, column: 11
                  b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 506, column: 4
                  S6231=0;
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

  public void thread6801(int [] tdone, int [] ends){
        switch(S6230){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S6057){
          case 0 : 
            S6057=0;
            S6057=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 489, column: 8
              S6078=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 490, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 492, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 492, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 493, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 493, column: 6
              System.out.println("Emitted bottlePos6");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S6078=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 496, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 496, column: 5
              System.out.println("Emitted bottlePos6B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S6078){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 491, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 487, column: 4
                  S6057=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 493, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 493, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 497, column: 11
                  b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 487, column: 4
                  S6057=0;
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

  public void thread6800(int [] tdone, int [] ends){
        switch(S6056){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5883){
          case 0 : 
            S5883=0;
            S5883=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 470, column: 8
              S5904=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 471, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 473, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 473, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 474, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 474, column: 6
              System.out.println("Emitted bottlePos5");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5904=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 477, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 477, column: 5
              System.out.println("Emitted bottlePos5B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S5904){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 472, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 468, column: 4
                  S5883=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 474, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 474, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 478, column: 11
                  b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 468, column: 4
                  S5883=0;
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

  public void thread6799(int [] tdone, int [] ends){
        switch(S5882){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5709){
          case 0 : 
            S5709=0;
            S5709=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 451, column: 8
              S5730=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 452, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 454, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 454, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 455, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 455, column: 6
              System.out.println("Emitted bottlePos4");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5730=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 458, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 458, column: 5
              System.out.println("Emitted bottlePos4B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5730){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 453, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 449, column: 4
                  S5709=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 455, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 455, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 459, column: 11
                  b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 449, column: 4
                  S5709=0;
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

  public void thread6798(int [] tdone, int [] ends){
        switch(S5708){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5535){
          case 0 : 
            S5535=0;
            S5535=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 432, column: 8
              S5556=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 433, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 435, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 435, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 436, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 436, column: 6
              System.out.println("Emitted bottlePos3");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S5556=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 439, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 439, column: 5
              System.out.println("Emitted bottlePos3B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S5556){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 434, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 430, column: 4
                  S5535=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 436, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 436, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 440, column: 11
                  b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 430, column: 4
                  S5535=0;
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

  public void thread6797(int [] tdone, int [] ends){
        switch(S5534){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5361){
          case 0 : 
            S5361=0;
            S5361=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 412, column: 8
              S5382=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 413, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 415, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 415, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 416, column: 6
              System.out.println("Emitted bottlePos2");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5382=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 419, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 419, column: 5
              System.out.println("Emitted bottlePos2B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S5382){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 414, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
                  S5361=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 416, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 420, column: 11
                  b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
                  S5361=0;
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

  public void thread6796(int [] tdone, int [] ends){
        switch(S5360){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5187){
          case 0 : 
            S5187=0;
            S5187=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 389, column: 8
              S5208=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 390, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 392, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 392, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 394, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 394, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 395, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 395, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5208=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 400, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 400, column: 5
              System.out.println("Emitted bottlePos1B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5208){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 391, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 387, column: 4
                  S5187=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 394, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 394, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 395, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 395, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 401, column: 11
                  b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 387, column: 4
                  S5187=0;
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

  public void thread6795(int [] tdone, int [] ends){
        switch(S5186){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5013){
          case 0 : 
            S5013=0;
            S5013=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 370, column: 8
              S5034=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 371, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 373, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 373, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 374, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 374, column: 6
              System.out.println("Emitted bottlePos0");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5034=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 377, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 377, column: 5
              System.out.println("Emitted bottlePos0B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5034){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 372, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 368, column: 4
                  S5013=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 374, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 374, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 378, column: 11
                  b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 368, column: 4
                  S5013=0;
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

  public void thread6794(int [] tdone, int [] ends){
        switch(S5012){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S4994){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 349, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 351, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S4994=1;
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
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 352, column: 10
              S4994=2;
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
            S4994=2;
            S4994=3;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 3 : 
            S4994=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 355, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S4994=4;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 357, column: 10
              S4994=0;
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

  public void thread6793(int [] tdone, int [] ends){
        switch(S4992){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4974){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 332, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 334, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S4974=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 335, column: 10
              S4974=2;
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
            S4974=2;
            S4974=3;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 3 : 
            S4974=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 338, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S4974=4;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 340, column: 10
              S4974=0;
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

  public void thread6792(int [] tdone, int [] ends){
        switch(S4972){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S4948){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 311, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 313, column: 4
              currsigs.addElement(startBottleUnloading);
              System.out.println("Emitted startBottleUnloading");
              S4948=1;
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
            if(bottleUnloaded.getprestatus()){//sysj\Orchestrator.sysj line: 314, column: 10
              bSeven_thread_13 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 315, column: 4
              S4948=2;
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
            S4948=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 317, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 317, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 318, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_13);//sysj\Orchestrator.sysj line: 318, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S4948=3;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 319, column: 10
              S4948=4;
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
          
          case 4 : 
            S4948=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 321, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S4948=5;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 322, column: 10
              S4948=0;
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

  public void thread6791(int [] tdone, int [] ends){
        switch(S4946){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4928){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 280, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 283, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S4928=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 284, column: 10
              bOne_thread_12 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 285, column: 4
              bTwo_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 286, column: 4
              bThree_thread_12 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 287, column: 4
              bFour_thread_12 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 288, column: 4
              bFive_thread_12 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 289, column: 4
              bSix_thread_12 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 290, column: 4
              S4928=2;
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
            S4928=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 292, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_12);//sysj\Orchestrator.sysj line: 292, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 293, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_12);//sysj\Orchestrator.sysj line: 293, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 294, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_12);//sysj\Orchestrator.sysj line: 294, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 295, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_12);//sysj\Orchestrator.sysj line: 295, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 296, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_12);//sysj\Orchestrator.sysj line: 296, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 297, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_12);//sysj\Orchestrator.sysj line: 297, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S4928=3;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 3 : 
            S4928=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 300, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S4928=4;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 301, column: 10
              S4928=0;
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

  public void thread6790(int [] tdone, int [] ends){
        switch(S4926){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4908){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 254, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 257, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S4908=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 258, column: 10
              bZero_thread_11 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 260, column: 4
              bFive_thread_11 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 261, column: 4
              S4908=2;
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
            S4908=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 263, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 264, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 264, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 265, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_11);//sysj\Orchestrator.sysj line: 265, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 266, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_11);//sysj\Orchestrator.sysj line: 266, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S4908=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            S4908=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 269, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S4908=4;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 270, column: 10
              S4908=0;
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

  public void thread6789(int [] tdone, int [] ends){
        switch(S4906){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4882){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 229, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 231, column: 4
              currsigs.addElement(startBottleLoading);
              System.out.println("Emitted startBottleLoading");
              S4882=1;
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
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 232, column: 10
              bEight_thread_10 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 234, column: 4
              S4882=2;
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
            S4882=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 236, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 236, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 237, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_10);//sysj\Orchestrator.sysj line: 237, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S4882=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 239, column: 10
              S4882=4;
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
            S4882=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 242, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S4882=5;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 243, column: 10
              S4882=0;
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

  public void thread6788(int [] tdone, int [] ends){
        switch(S4880){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4842){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 210, column: 10
              S4842=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 211, column: 12
                S4836=0;
                b_thread_9 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 212, column: 5
                if(!b_thread_9.isCapOn && !b_thread_9.isCapped){//sysj\Orchestrator.sysj line: 213, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 214, column: 6
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
                S4836=1;
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
            switch(S4836){
              case 0 : 
                S4842=0;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 219, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S4842=0;
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

  public void thread6787(int [] tdone, int [] ends){
        switch(S4830){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4792){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 192, column: 10
              S4792=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 193, column: 12
                S4786=0;
                b_thread_8 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 194, column: 5
                S4784=0;
                if(!b_thread_8.isFilled){//sysj\Orchestrator.sysj line: 195, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 196, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S4784=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
                else {
                  S4784=1;
                  active[8]=1;
                  ends[8]=1;
                  tdone[8]=1;
                }
              }
              else {
                S4786=1;
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
            switch(S4786){
              case 0 : 
                switch(S4784){
                  case 0 : 
                    S4792=0;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                    break;
                  
                  case 1 : 
                    S4784=1;
                    S4792=0;
                    active[8]=1;
                    ends[8]=1;
                    tdone[8]=1;
                    break;
                  
                }
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 201, column: 5
                currsigs.addElement(fillerFinish_1);
                System.out.println("Emitted fillerFinish_1");
                S4792=0;
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

  public void thread6786(int [] tdone, int [] ends){
        switch(S4780){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4754){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 177, column: 10
              S4754=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 178, column: 12
                S4750=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 179, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4750=1;
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
            switch(S4750){
              case 0 : 
                S4754=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 183, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S4754=0;
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

  public void thread6785(int [] tdone, int [] ends){
        switch(S4746){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4720){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 160, column: 10
              S4720=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 162, column: 12
                S4716=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 163, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S4716=1;
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
            switch(S4716){
              case 0 : 
                S4720=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 167, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S4720=0;
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

  public void thread6784(int [] tdone, int [] ends){
        switch(S4712){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4686){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 145, column: 10
              S4686=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 146, column: 12
                S4682=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 147, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S4682=1;
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
            switch(S4682){
              case 0 : 
                S4686=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 151, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S4686=0;
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

  public void thread6783(int [] tdone, int [] ends){
        switch(S4678){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4652){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 130, column: 10
              S4652=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 131, column: 12
                S4648=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 132, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S4648=1;
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
            switch(S4648){
              case 0 : 
                S4652=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 136, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S4652=0;
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

  public void thread6782(int [] tdone, int [] ends){
        switch(S4644){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4546){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S4546=1;
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
            S4546=1;
            S4546=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S4546=2;
            checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 4
            currsigs.addElement(checkFiller_1);
            System.out.println("Emitted checkFiller_1");
            S4546=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S4546=4;
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
            S4546=4;
            S4546=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            S4546=5;
            S4546=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 67, column: 10
              S4546=7;
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 68, column: 10
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 70, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S4546=8;
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
          
          case 8 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 71, column: 10
              S4546=9;
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
            S4546=9;
            S4546=10;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 10 : 
            S4546=10;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 78, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S4546=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 79, column: 10
              S4546=12;
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
            S4546=12;
            S4546=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            S4546=13;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 83, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4546=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 84, column: 10
              S4546=15;
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
            S4546=15;
            S4546=16;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 16 : 
            S4546=16;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4546=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 89, column: 10
              S4546=18;
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
            S4546=18;
            S4546=19;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 19 : 
            S4546=19;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 93, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S4546=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 94, column: 10
              S4546=21;
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
            S4546=21;
            S4546=22;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 22 : 
            S4546=22;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 98, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S4546=23;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 23 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 99, column: 10
              S4546=24;
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
            S4546=24;
            S4546=25;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 25 : 
            S4546=25;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 103, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S4546=26;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 26 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 104, column: 10
              S4546=27;
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
          
          case 27 : 
            S4546=27;
            S4546=28;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 28 : 
            S4546=28;
            S4546=29;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 29 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 108, column: 10
              S4546=30;
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
          
          case 30 : 
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 109, column: 10
              checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 113, column: 4
              currsigs.addElement(checkRotTable_1);
              System.out.println("Emitted checkRotTable_1");
              S4546=31;
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
          
          case 31 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 114, column: 10
              S4546=32;
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
          
          case 32 : 
            S4546=32;
            S4546=33;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 33 : 
            S4546=33;
            S4546=34;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 34 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 118, column: 10
              S4546=35;
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
          
          case 35 : 
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 119, column: 10
              checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
              currsigs.addElement(checkCapLoader_1);
              System.out.println("Emitted checkCapLoader_1");
              S4546=0;
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

  public void thread6781(int [] tdone, int [] ends){
        switch(S4543){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S4487){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S4487=1;
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
                S4488=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S4487=0;
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
            switch(S4488){
              case 0 : 
                S4488=0;
                S4488=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S4488=1;
                S4488=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S4488=3;
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
                  S4487=0;
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

  public void thread6779(int [] tdone, int [] ends){
        S6752=1;
    S6579=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread6778(int [] tdone, int [] ends){
        S6578=1;
    b_thread_24 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 525, column: 4
    S6405=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread6777(int [] tdone, int [] ends){
        S6404=1;
    b_thread_23 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 506, column: 4
    S6231=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread6776(int [] tdone, int [] ends){
        S6230=1;
    b_thread_22 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 487, column: 4
    S6057=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread6775(int [] tdone, int [] ends){
        S6056=1;
    b_thread_21 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 468, column: 4
    S5883=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread6774(int [] tdone, int [] ends){
        S5882=1;
    b_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 449, column: 4
    S5709=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread6773(int [] tdone, int [] ends){
        S5708=1;
    b_thread_19 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 430, column: 4
    S5535=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread6772(int [] tdone, int [] ends){
        S5534=1;
    b_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 410, column: 4
    S5361=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread6771(int [] tdone, int [] ends){
        S5360=1;
    b_thread_17 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 387, column: 4
    S5187=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread6770(int [] tdone, int [] ends){
        S5186=1;
    b_thread_16 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 368, column: 4
    S5013=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread6769(int [] tdone, int [] ends){
        S5012=1;
    S4994=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread6768(int [] tdone, int [] ends){
        S4992=1;
    S4974=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread6767(int [] tdone, int [] ends){
        S4972=1;
    S4948=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread6766(int [] tdone, int [] ends){
        S4946=1;
    S4928=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread6765(int [] tdone, int [] ends){
        S4926=1;
    S4908=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread6764(int [] tdone, int [] ends){
        S4906=1;
    S4882=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread6763(int [] tdone, int [] ends){
        S4880=1;
    S4842=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread6762(int [] tdone, int [] ends){
        S4830=1;
    S4792=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread6761(int [] tdone, int [] ends){
        S4780=1;
    S4754=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread6760(int [] tdone, int [] ends){
        S4746=1;
    S4720=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread6759(int [] tdone, int [] ends){
        S4712=1;
    S4686=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6758(int [] tdone, int [] ends){
        S4678=1;
    S4652=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread6757(int [] tdone, int [] ends){
        S4644=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
    currsigs.addElement(checkCapLoader_1);
    System.out.println("Emitted checkCapLoader_1");
    S4546=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6756(int [] tdone, int [] ends){
        S4543=1;
    S4487=0;
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
      switch(S6754){
        case 0 : 
          S6754=0;
          break RUN;
        
        case 1 : 
          S6754=2;
          S6754=2;
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
          thread6756(tdone,ends);
          thread6757(tdone,ends);
          thread6758(tdone,ends);
          thread6759(tdone,ends);
          thread6760(tdone,ends);
          thread6761(tdone,ends);
          thread6762(tdone,ends);
          thread6763(tdone,ends);
          thread6764(tdone,ends);
          thread6765(tdone,ends);
          thread6766(tdone,ends);
          thread6767(tdone,ends);
          thread6768(tdone,ends);
          thread6769(tdone,ends);
          thread6770(tdone,ends);
          thread6771(tdone,ends);
          thread6772(tdone,ends);
          thread6773(tdone,ends);
          thread6774(tdone,ends);
          thread6775(tdone,ends);
          thread6776(tdone,ends);
          thread6777(tdone,ends);
          thread6778(tdone,ends);
          thread6779(tdone,ends);
          int biggest6780 = 0;
          if(ends[2]>=biggest6780){
            biggest6780=ends[2];
          }
          if(ends[3]>=biggest6780){
            biggest6780=ends[3];
          }
          if(ends[4]>=biggest6780){
            biggest6780=ends[4];
          }
          if(ends[5]>=biggest6780){
            biggest6780=ends[5];
          }
          if(ends[6]>=biggest6780){
            biggest6780=ends[6];
          }
          if(ends[7]>=biggest6780){
            biggest6780=ends[7];
          }
          if(ends[8]>=biggest6780){
            biggest6780=ends[8];
          }
          if(ends[9]>=biggest6780){
            biggest6780=ends[9];
          }
          if(ends[10]>=biggest6780){
            biggest6780=ends[10];
          }
          if(ends[11]>=biggest6780){
            biggest6780=ends[11];
          }
          if(ends[12]>=biggest6780){
            biggest6780=ends[12];
          }
          if(ends[13]>=biggest6780){
            biggest6780=ends[13];
          }
          if(ends[14]>=biggest6780){
            biggest6780=ends[14];
          }
          if(ends[15]>=biggest6780){
            biggest6780=ends[15];
          }
          if(ends[16]>=biggest6780){
            biggest6780=ends[16];
          }
          if(ends[17]>=biggest6780){
            biggest6780=ends[17];
          }
          if(ends[18]>=biggest6780){
            biggest6780=ends[18];
          }
          if(ends[19]>=biggest6780){
            biggest6780=ends[19];
          }
          if(ends[20]>=biggest6780){
            biggest6780=ends[20];
          }
          if(ends[21]>=biggest6780){
            biggest6780=ends[21];
          }
          if(ends[22]>=biggest6780){
            biggest6780=ends[22];
          }
          if(ends[23]>=biggest6780){
            biggest6780=ends[23];
          }
          if(ends[24]>=biggest6780){
            biggest6780=ends[24];
          }
          if(ends[25]>=biggest6780){
            biggest6780=ends[25];
          }
          if(biggest6780 == 1){
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
          thread6781(tdone,ends);
          thread6782(tdone,ends);
          thread6783(tdone,ends);
          thread6784(tdone,ends);
          thread6785(tdone,ends);
          thread6786(tdone,ends);
          thread6787(tdone,ends);
          thread6788(tdone,ends);
          thread6789(tdone,ends);
          thread6790(tdone,ends);
          thread6791(tdone,ends);
          thread6792(tdone,ends);
          thread6793(tdone,ends);
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
          int biggest6805 = 0;
          if(ends[2]>=biggest6805){
            biggest6805=ends[2];
          }
          if(ends[3]>=biggest6805){
            biggest6805=ends[3];
          }
          if(ends[4]>=biggest6805){
            biggest6805=ends[4];
          }
          if(ends[5]>=biggest6805){
            biggest6805=ends[5];
          }
          if(ends[6]>=biggest6805){
            biggest6805=ends[6];
          }
          if(ends[7]>=biggest6805){
            biggest6805=ends[7];
          }
          if(ends[8]>=biggest6805){
            biggest6805=ends[8];
          }
          if(ends[9]>=biggest6805){
            biggest6805=ends[9];
          }
          if(ends[10]>=biggest6805){
            biggest6805=ends[10];
          }
          if(ends[11]>=biggest6805){
            biggest6805=ends[11];
          }
          if(ends[12]>=biggest6805){
            biggest6805=ends[12];
          }
          if(ends[13]>=biggest6805){
            biggest6805=ends[13];
          }
          if(ends[14]>=biggest6805){
            biggest6805=ends[14];
          }
          if(ends[15]>=biggest6805){
            biggest6805=ends[15];
          }
          if(ends[16]>=biggest6805){
            biggest6805=ends[16];
          }
          if(ends[17]>=biggest6805){
            biggest6805=ends[17];
          }
          if(ends[18]>=biggest6805){
            biggest6805=ends[18];
          }
          if(ends[19]>=biggest6805){
            biggest6805=ends[19];
          }
          if(ends[20]>=biggest6805){
            biggest6805=ends[20];
          }
          if(ends[21]>=biggest6805){
            biggest6805=ends[21];
          }
          if(ends[22]>=biggest6805){
            biggest6805=ends[22];
          }
          if(ends[23]>=biggest6805){
            biggest6805=ends[23];
          }
          if(ends[24]>=biggest6805){
            biggest6805=ends[24];
          }
          if(ends[25]>=biggest6805){
            biggest6805=ends[25];
          }
          if(biggest6805 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6805 == 0){
            S6754=0;
            active[1]=0;
            ends[1]=0;
            S6754=0;
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
          enable.gethook();
          conveyorMoved.gethook();
          rotTableTurned.gethook();
          filled.gethook();
          capLoaded.gethook();
          bottleLoaded.gethook();
          bottleUnloaded.gethook();
          bottleLoaderRelease.gethook();
          bottleUnloaderRelease.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      enable.setpreclear();
      conveyorMoved.setpreclear();
      rotTableTurned.setpreclear();
      filled.setpreclear();
      capLoaded.setpreclear();
      bottleLoaded.setpreclear();
      bottleUnloaded.setpreclear();
      bottleLoaderRelease.setpreclear();
      bottleUnloaderRelease.setpreclear();
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
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
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
      dummyint = bottleUnloaderRelease.getStatus() ? bottleUnloaderRelease.setprepresent() : bottleUnloaderRelease.setpreclear();
      bottleUnloaderRelease.setpreval(bottleUnloaderRelease.getValue());
      bottleUnloaderRelease.setClear();
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
        enable.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capLoaded.gethook();
        bottleLoaded.gethook();
        bottleUnloaded.gethook();
        bottleLoaderRelease.gethook();
        bottleUnloaderRelease.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
