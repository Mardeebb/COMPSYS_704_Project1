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
  public Signal capped = new Signal("capped", Signal.INPUT);
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.INPUT);
  public Signal bottleUnloaded = new Signal("bottleUnloaded", Signal.INPUT);
  public Signal bottleLoaderRelease = new Signal("bottleLoaderRelease", Signal.INPUT);
  public Signal bottleUnloaderRelease = new Signal("bottleUnloaderRelease", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal startConveyor = new Signal("startConveyor", Signal.OUTPUT);
  public Signal startRotTable = new Signal("startRotTable", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
  public Signal startCapLoading = new Signal("startCapLoading", Signal.OUTPUT);
  public Signal startCapping = new Signal("startCapping", Signal.OUTPUT);
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
  private Signal startCapperThread_1;
  private Signal checkRobotLoader_1;
  private Signal checkConveyor_1;
  private Signal checkRotTable_1;
  private Signal checkRobotUnloader_1;
  private Signal checkFiller_1;
  private Signal checkCapLoader_1;
  private Signal checkCapper_1;
  private Signal robotLoaderFinish_1;
  private Signal conveyorFinish_1;
  private Signal rotTableFinish_1;
  private Signal robotUnloaderFinish_1;
  private Signal fillerFinish_1;
  private Signal capLoaderFinish_1;
  private Signal capperFinish_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 23, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 198, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 218, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 238, column: 5
  private BottleTwin bEight_thread_18;//sysj\Orchestrator.sysj line: 261, column: 4
  private BottleTwin bZero_thread_19;//sysj\Orchestrator.sysj line: 287, column: 4
  private BottleTwin bFive_thread_19;//sysj\Orchestrator.sysj line: 288, column: 4
  private BottleTwin bOne_thread_20;//sysj\Orchestrator.sysj line: 313, column: 4
  private BottleTwin bTwo_thread_20;//sysj\Orchestrator.sysj line: 314, column: 4
  private BottleTwin bThree_thread_20;//sysj\Orchestrator.sysj line: 315, column: 4
  private BottleTwin bFour_thread_20;//sysj\Orchestrator.sysj line: 316, column: 4
  private BottleTwin bFive_thread_20;//sysj\Orchestrator.sysj line: 317, column: 4
  private BottleTwin bSix_thread_20;//sysj\Orchestrator.sysj line: 318, column: 4
  private BottleTwin bSeven_thread_21;//sysj\Orchestrator.sysj line: 343, column: 4
  private int id_thread_25;//sysj\Orchestrator.sysj line: 416, column: 5
  private BottleTwin b_thread_25;//sysj\Orchestrator.sysj line: 413, column: 4
  private int id_thread_26;//sysj\Orchestrator.sysj line: 435, column: 5
  private BottleTwin b_thread_26;//sysj\Orchestrator.sysj line: 432, column: 4
  private int id_thread_27;//sysj\Orchestrator.sysj line: 458, column: 5
  private BottleTwin b_thread_27;//sysj\Orchestrator.sysj line: 455, column: 4
  private int id_thread_28;//sysj\Orchestrator.sysj line: 478, column: 5
  private BottleTwin b_thread_28;//sysj\Orchestrator.sysj line: 475, column: 4
  private int id_thread_29;//sysj\Orchestrator.sysj line: 497, column: 5
  private BottleTwin b_thread_29;//sysj\Orchestrator.sysj line: 494, column: 4
  private int id_thread_30;//sysj\Orchestrator.sysj line: 516, column: 5
  private BottleTwin b_thread_30;//sysj\Orchestrator.sysj line: 513, column: 4
  private int id_thread_31;//sysj\Orchestrator.sysj line: 535, column: 5
  private BottleTwin b_thread_31;//sysj\Orchestrator.sysj line: 532, column: 4
  private int id_thread_32;//sysj\Orchestrator.sysj line: 554, column: 5
  private BottleTwin b_thread_32;//sysj\Orchestrator.sysj line: 551, column: 4
  private int id_thread_33;//sysj\Orchestrator.sysj line: 573, column: 5
  private BottleTwin b_thread_33;//sysj\Orchestrator.sysj line: 570, column: 4
  private BottleTwin b_thread_34;//sysj\Orchestrator.sysj line: 590, column: 4
  private int id_thread_34;//sysj\Orchestrator.sysj line: 592, column: 5
  private int S5157 = 1;
  private int S2762 = 1;
  private int S2706 = 1;
  private int S2707 = 1;
  private int S2977 = 1;
  private int S2765 = 1;
  private int S2769 = 1;
  private int S2768 = 1;
  private int S2773 = 1;
  private int S2772 = 1;
  private int S2777 = 1;
  private int S2776 = 1;
  private int S2781 = 1;
  private int S2780 = 1;
  private int S2785 = 1;
  private int S2784 = 1;
  private int S2811 = 1;
  private int S2810 = 1;
  private int S2815 = 1;
  private int S2814 = 1;
  private int S3011 = 1;
  private int S2985 = 1;
  private int S2981 = 1;
  private int S3045 = 1;
  private int S3019 = 1;
  private int S3015 = 1;
  private int S3079 = 1;
  private int S3053 = 1;
  private int S3049 = 1;
  private int S3113 = 1;
  private int S3087 = 1;
  private int S3083 = 1;
  private int S3163 = 1;
  private int S3125 = 1;
  private int S3119 = 1;
  private int S3117 = 1;
  private int S3213 = 1;
  private int S3175 = 1;
  private int S3169 = 1;
  private int S3263 = 1;
  private int S3225 = 1;
  private int S3219 = 1;
  private int S3289 = 1;
  private int S3265 = 1;
  private int S3309 = 1;
  private int S3291 = 1;
  private int S3329 = 1;
  private int S3311 = 1;
  private int S3355 = 1;
  private int S3331 = 1;
  private int S3375 = 1;
  private int S3357 = 1;
  private int S3395 = 1;
  private int S3377 = 1;
  private int S3415 = 1;
  private int S3397 = 1;
  private int S3589 = 1;
  private int S3416 = 1;
  private int S3437 = 1;
  private int S3763 = 1;
  private int S3590 = 1;
  private int S3611 = 1;
  private int S3937 = 1;
  private int S3764 = 1;
  private int S3785 = 1;
  private int S4111 = 1;
  private int S3938 = 1;
  private int S3959 = 1;
  private int S4285 = 1;
  private int S4112 = 1;
  private int S4133 = 1;
  private int S4459 = 1;
  private int S4286 = 1;
  private int S4307 = 1;
  private int S4633 = 1;
  private int S4460 = 1;
  private int S4481 = 1;
  private int S4807 = 1;
  private int S4634 = 1;
  private int S4655 = 1;
  private int S4981 = 1;
  private int S4808 = 1;
  private int S4829 = 1;
  private int S5155 = 1;
  private int S4982 = 1;
  private int S5003 = 1;
  
  private int[] ends = new int[35];
  private int[] tdone = new int[35];
  
  public void thread5229(int [] tdone, int [] ends){
        switch(S5155){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S4982){
          case 0 : 
            S4982=0;
            b_thread_34 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 590, column: 4
            S4982=1;
            if(b_thread_34 != null){//sysj\Orchestrator.sysj line: 591, column: 8
              S5003=0;
              id_thread_34 = b_thread_34.ID;//sysj\Orchestrator.sysj line: 592, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 594, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_34);//sysj\Orchestrator.sysj line: 594, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 595, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_34);//sysj\Orchestrator.sysj line: 595, column: 6
              System.out.println("Emitted bottlePos9");
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            else {
              S5003=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 598, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 598, column: 5
              System.out.println("Emitted bottlePos9B");
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            break;
          
          case 1 : 
            switch(S5003){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 593, column: 11
                  S4982=0;
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 595, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_34);//sysj\Orchestrator.sysj line: 595, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 599, column: 11
                  S4982=0;
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                else {
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5228(int [] tdone, int [] ends){
        switch(S4981){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S4808){
          case 0 : 
            S4808=0;
            S4808=1;
            if(b_thread_33 != null){//sysj\Orchestrator.sysj line: 572, column: 8
              S4829=0;
              id_thread_33 = b_thread_33.ID;//sysj\Orchestrator.sysj line: 573, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 575, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_33);//sysj\Orchestrator.sysj line: 575, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 576, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_33);//sysj\Orchestrator.sysj line: 576, column: 6
              System.out.println("Emitted bottlePos8");
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            else {
              S4829=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 579, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 579, column: 5
              System.out.println("Emitted bottlePos8B");
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            break;
          
          case 1 : 
            switch(S4829){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 574, column: 11
                  b_thread_33 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 570, column: 4
                  S4808=0;
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 576, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_33);//sysj\Orchestrator.sysj line: 576, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 580, column: 11
                  b_thread_33 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 570, column: 4
                  S4808=0;
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                else {
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5227(int [] tdone, int [] ends){
        switch(S4807){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S4634){
          case 0 : 
            S4634=0;
            S4634=1;
            if(b_thread_32 != null){//sysj\Orchestrator.sysj line: 553, column: 8
              S4655=0;
              id_thread_32 = b_thread_32.ID;//sysj\Orchestrator.sysj line: 554, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 556, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_32);//sysj\Orchestrator.sysj line: 556, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 557, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_32);//sysj\Orchestrator.sysj line: 557, column: 6
              System.out.println("Emitted bottlePos7");
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S4655=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 560, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 560, column: 5
              System.out.println("Emitted bottlePos7B");
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
          case 1 : 
            switch(S4655){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 555, column: 11
                  b_thread_32 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 551, column: 4
                  S4634=0;
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 557, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_32);//sysj\Orchestrator.sysj line: 557, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 561, column: 11
                  b_thread_32 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 551, column: 4
                  S4634=0;
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                else {
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5226(int [] tdone, int [] ends){
        switch(S4633){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S4460){
          case 0 : 
            S4460=0;
            S4460=1;
            if(b_thread_31 != null){//sysj\Orchestrator.sysj line: 534, column: 8
              S4481=0;
              id_thread_31 = b_thread_31.ID;//sysj\Orchestrator.sysj line: 535, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 537, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_31);//sysj\Orchestrator.sysj line: 537, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 538, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_31);//sysj\Orchestrator.sysj line: 538, column: 6
              System.out.println("Emitted bottlePos6");
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S4481=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 541, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 541, column: 5
              System.out.println("Emitted bottlePos6B");
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
          case 1 : 
            switch(S4481){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 536, column: 11
                  b_thread_31 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 532, column: 4
                  S4460=0;
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 538, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_31);//sysj\Orchestrator.sysj line: 538, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 542, column: 11
                  b_thread_31 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 532, column: 4
                  S4460=0;
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5225(int [] tdone, int [] ends){
        switch(S4459){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S4286){
          case 0 : 
            S4286=0;
            S4286=1;
            if(b_thread_30 != null){//sysj\Orchestrator.sysj line: 515, column: 8
              S4307=0;
              id_thread_30 = b_thread_30.ID;//sysj\Orchestrator.sysj line: 516, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 518, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_30);//sysj\Orchestrator.sysj line: 518, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 519, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_30);//sysj\Orchestrator.sysj line: 519, column: 6
              System.out.println("Emitted bottlePos5");
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S4307=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 522, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 522, column: 5
              System.out.println("Emitted bottlePos5B");
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
          case 1 : 
            switch(S4307){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 517, column: 11
                  b_thread_30 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 513, column: 4
                  S4286=0;
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 519, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_30);//sysj\Orchestrator.sysj line: 519, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 523, column: 11
                  b_thread_30 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 513, column: 4
                  S4286=0;
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5224(int [] tdone, int [] ends){
        switch(S4285){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S4112){
          case 0 : 
            S4112=0;
            S4112=1;
            if(b_thread_29 != null){//sysj\Orchestrator.sysj line: 496, column: 8
              S4133=0;
              id_thread_29 = b_thread_29.ID;//sysj\Orchestrator.sysj line: 497, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 499, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_29);//sysj\Orchestrator.sysj line: 499, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 500, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_29);//sysj\Orchestrator.sysj line: 500, column: 6
              System.out.println("Emitted bottlePos4");
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S4133=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 503, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 503, column: 5
              System.out.println("Emitted bottlePos4B");
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
          case 1 : 
            switch(S4133){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 498, column: 11
                  b_thread_29 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 494, column: 4
                  S4112=0;
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 500, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_29);//sysj\Orchestrator.sysj line: 500, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 504, column: 11
                  b_thread_29 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 494, column: 4
                  S4112=0;
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5223(int [] tdone, int [] ends){
        switch(S4111){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S3938){
          case 0 : 
            S3938=0;
            S3938=1;
            if(b_thread_28 != null){//sysj\Orchestrator.sysj line: 477, column: 8
              S3959=0;
              id_thread_28 = b_thread_28.ID;//sysj\Orchestrator.sysj line: 478, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 480, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_28);//sysj\Orchestrator.sysj line: 480, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 481, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_28);//sysj\Orchestrator.sysj line: 481, column: 6
              System.out.println("Emitted bottlePos3");
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S3959=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 484, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 484, column: 5
              System.out.println("Emitted bottlePos3B");
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
          case 1 : 
            switch(S3959){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 479, column: 11
                  b_thread_28 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 475, column: 4
                  S3938=0;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 481, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_28);//sysj\Orchestrator.sysj line: 481, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 485, column: 11
                  b_thread_28 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 475, column: 4
                  S3938=0;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5222(int [] tdone, int [] ends){
        switch(S3937){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S3764){
          case 0 : 
            S3764=0;
            S3764=1;
            if(b_thread_27 != null){//sysj\Orchestrator.sysj line: 457, column: 8
              S3785=0;
              id_thread_27 = b_thread_27.ID;//sysj\Orchestrator.sysj line: 458, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 460, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_27);//sysj\Orchestrator.sysj line: 460, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 461, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_27);//sysj\Orchestrator.sysj line: 461, column: 6
              System.out.println("Emitted bottlePos2");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              S3785=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 464, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 464, column: 5
              System.out.println("Emitted bottlePos2B");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 1 : 
            switch(S3785){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 459, column: 11
                  b_thread_27 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 455, column: 4
                  S3764=0;
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 461, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_27);//sysj\Orchestrator.sysj line: 461, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 465, column: 11
                  b_thread_27 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 455, column: 4
                  S3764=0;
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                else {
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5221(int [] tdone, int [] ends){
        switch(S3763){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S3590){
          case 0 : 
            S3590=0;
            S3590=1;
            if(b_thread_26 != null){//sysj\Orchestrator.sysj line: 434, column: 8
              S3611=0;
              id_thread_26 = b_thread_26.ID;//sysj\Orchestrator.sysj line: 435, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 437, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_26);//sysj\Orchestrator.sysj line: 437, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 439, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 439, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 440, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 440, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S3611=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 445, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 445, column: 5
              System.out.println("Emitted bottlePos1B");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 1 : 
            switch(S3611){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 436, column: 11
                  b_thread_26 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
                  S3590=0;
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 439, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 439, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 440, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 440, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 446, column: 11
                  b_thread_26 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
                  S3590=0;
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                else {
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5220(int [] tdone, int [] ends){
        switch(S3589){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S3416){
          case 0 : 
            S3416=0;
            S3416=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 415, column: 8
              S3437=0;
              id_thread_25 = b_thread_25.ID;//sysj\Orchestrator.sysj line: 416, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 418, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_25);//sysj\Orchestrator.sysj line: 418, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 419, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 419, column: 6
              System.out.println("Emitted bottlePos0");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S3437=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 422, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 422, column: 5
              System.out.println("Emitted bottlePos0B");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S3437){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 417, column: 11
                  b_thread_25 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
                  S3416=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 419, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 419, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 423, column: 11
                  b_thread_25 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
                  S3416=0;
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

  public void thread5219(int [] tdone, int [] ends){
        switch(S3415){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3397){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 394, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 396, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S3397=1;
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
          
          case 1 : 
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 397, column: 10
              S3397=2;
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
          
          case 2 : 
            S3397=2;
            S3397=3;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 3 : 
            S3397=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 400, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S3397=4;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 402, column: 10
              S3397=0;
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
  }

  public void thread5218(int [] tdone, int [] ends){
        switch(S3395){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3377){
          case 0 : 
            if(startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 377, column: 10
              startCapping.setPresent();//sysj\Orchestrator.sysj line: 379, column: 4
              currsigs.addElement(startCapping);
              System.out.println("Emitted startCapping");
              S3377=1;
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
          
          case 1 : 
            if(capped.getprestatus()){//sysj\Orchestrator.sysj line: 380, column: 10
              S3377=2;
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
          
          case 2 : 
            S3377=2;
            S3377=3;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 3 : 
            S3377=3;
            capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 383, column: 4
            currsigs.addElement(capperFinish_1);
            System.out.println("Emitted capperFinish_1");
            S3377=4;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 4 : 
            if(!startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 385, column: 10
              S3377=0;
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
  }

  public void thread5217(int [] tdone, int [] ends){
        switch(S3375){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S3357){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 360, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 362, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S3357=1;
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
          
          case 1 : 
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 363, column: 10
              S3357=2;
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
          
          case 2 : 
            S3357=2;
            S3357=3;
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
            break;
          
          case 3 : 
            S3357=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 366, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S3357=4;
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 368, column: 10
              S3357=0;
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
  }

  public void thread5216(int [] tdone, int [] ends){
        switch(S3355){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S3331){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 339, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 341, column: 4
              currsigs.addElement(startBottleUnloading);
              System.out.println("Emitted startBottleUnloading");
              S3331=1;
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
          
          case 1 : 
            if(bottleUnloaded.getprestatus()){//sysj\Orchestrator.sysj line: 342, column: 10
              bSeven_thread_21 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
              S3331=2;
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
          
          case 2 : 
            S3331=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 345, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 345, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 346, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_21);//sysj\Orchestrator.sysj line: 346, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S3331=3;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 10
              S3331=4;
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
          
          case 4 : 
            S3331=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 349, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S3331=5;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 350, column: 10
              S3331=0;
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
  }

  public void thread5215(int [] tdone, int [] ends){
        switch(S3329){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S3311){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 308, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 311, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S3311=1;
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
          
          case 1 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 312, column: 10
              bOne_thread_20 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 313, column: 4
              bTwo_thread_20 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 314, column: 4
              bThree_thread_20 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 315, column: 4
              bFour_thread_20 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 316, column: 4
              bFive_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 317, column: 4
              bSix_thread_20 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 318, column: 4
              S3311=2;
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
          
          case 2 : 
            S3311=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 320, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_20);//sysj\Orchestrator.sysj line: 320, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 321, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_20);//sysj\Orchestrator.sysj line: 321, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 322, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_20);//sysj\Orchestrator.sysj line: 322, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 323, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_20);//sysj\Orchestrator.sysj line: 323, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 324, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_20);//sysj\Orchestrator.sysj line: 324, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 325, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_20);//sysj\Orchestrator.sysj line: 325, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S3311=3;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 3 : 
            S3311=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 328, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S3311=4;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 329, column: 10
              S3311=0;
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
  }

  public void thread5214(int [] tdone, int [] ends){
        switch(S3309){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S3291){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 281, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 284, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S3291=1;
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
          
          case 1 : 
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 285, column: 10
              bZero_thread_19 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 287, column: 4
              bFive_thread_19 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 288, column: 4
              S3291=2;
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
          
          case 2 : 
            S3291=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 291, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 291, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 292, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 292, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 293, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_19);//sysj\Orchestrator.sysj line: 293, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 294, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_19);//sysj\Orchestrator.sysj line: 294, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S3291=3;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 3 : 
            S3291=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 297, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S3291=4;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 298, column: 10
              S3291=0;
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
  }

  public void thread5213(int [] tdone, int [] ends){
        switch(S3289){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S3265){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 256, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 258, column: 4
              currsigs.addElement(startBottleLoading);
              System.out.println("Emitted startBottleLoading");
              S3265=1;
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
          
          case 1 : 
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 259, column: 10
              bEight_thread_18 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 261, column: 4
              S3265=2;
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
          
          case 2 : 
            S3265=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 263, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 264, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_18);//sysj\Orchestrator.sysj line: 264, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S3265=3;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 266, column: 10
              S3265=4;
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
          
          case 4 : 
            S3265=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 269, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S3265=5;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 270, column: 10
              S3265=0;
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
  }

  public void thread5212(int [] tdone, int [] ends){
        switch(S3263){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S3225){
          case 0 : 
            if(checkCapper_1.getprestatus()){//sysj\Orchestrator.sysj line: 236, column: 10
              S3225=1;
              if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 12
                S3219=0;
                b_thread_17 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 5
                if(!b_thread_17.isCapped){//sysj\Orchestrator.sysj line: 239, column: 8
                  startCapperThread_1.setPresent();//sysj\Orchestrator.sysj line: 240, column: 6
                  currsigs.addElement(startCapperThread_1);
                  System.out.println("Emitted startCapperThread_1");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 242, column: 6
                  currsigs.addElement(capperFinish_1);
                  System.out.println("Emitted capperFinish_1");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
              else {
                S3219=1;
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
            switch(S3219){
              case 0 : 
                S3225=0;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
                break;
              
              case 1 : 
                capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 247, column: 4
                currsigs.addElement(capperFinish_1);
                System.out.println("Emitted capperFinish_1");
                S3225=0;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5211(int [] tdone, int [] ends){
        switch(S3213){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S3175){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 216, column: 10
              S3175=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 12
                S3169=0;
                b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 5
                if(!b_thread_16.isCapOn && !b_thread_16.isCapped){//sysj\Orchestrator.sysj line: 219, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 220, column: 6
                  currsigs.addElement(startCapLoaderThread_1);
                  System.out.println("Emitted startCapLoaderThread_1");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 6
                  currsigs.addElement(capLoaderFinish_1);
                  System.out.println("Emitted capLoaderFinish_1");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
              }
              else {
                S3169=1;
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
            switch(S3169){
              case 0 : 
                S3175=0;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 227, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S3175=0;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5210(int [] tdone, int [] ends){
        switch(S3163){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S3125){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 196, column: 10
              S3125=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 197, column: 12
                S3119=0;
                b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 198, column: 5
                S3117=0;
                if(!b_thread_15.isFilled){//sysj\Orchestrator.sysj line: 199, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S3117=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 202, column: 6
                  currsigs.addElement(fillerFinish_1);
                  System.out.println("Emitted fillerFinish_1");
                  S3117=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S3119=1;
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
            switch(S3119){
              case 0 : 
                switch(S3117){
                  case 0 : 
                    S3125=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                    break;
                  
                  case 1 : 
                    S3117=1;
                    S3125=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                    break;
                  
                }
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 207, column: 5
                currsigs.addElement(fillerFinish_1);
                System.out.println("Emitted fillerFinish_1");
                S3125=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5209(int [] tdone, int [] ends){
        switch(S3113){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3087){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 181, column: 10
              S3087=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 182, column: 12
                S3083=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 183, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S3083=1;
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
            switch(S3083){
              case 0 : 
                S3087=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S3087=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5208(int [] tdone, int [] ends){
        switch(S3079){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3053){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 164, column: 10
              S3053=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 166, column: 12
                S3049=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 167, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S3049=1;
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
            switch(S3049){
              case 0 : 
                S3053=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 171, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S3053=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5207(int [] tdone, int [] ends){
        switch(S3045){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3019){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 149, column: 10
              S3019=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 150, column: 12
                S3015=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 151, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S3015=1;
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
            switch(S3015){
              case 0 : 
                S3019=0;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 155, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S3019=0;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5206(int [] tdone, int [] ends){
        switch(S3011){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S2985){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 134, column: 10
              S2985=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 135, column: 12
                S2981=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 136, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S2981=1;
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
            switch(S2981){
              case 0 : 
                S2985=0;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 140, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S2985=0;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread5204(int [] tdone, int [] ends){
        switch(S2815){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S2814){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 110, column: 11
              S2814=1;
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
            S2814=1;
            S2814=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S2814=2;
            S2815=0;
            active[10]=0;
            ends[10]=0;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5203(int [] tdone, int [] ends){
        switch(S2811){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2810){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 11
              S2810=1;
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
            S2810=1;
            S2810=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S2810=2;
            S2811=0;
            active[9]=0;
            ends[9]=0;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5201(int [] tdone, int [] ends){
        S2815=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 109, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S2814=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread5200(int [] tdone, int [] ends){
        S2811=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 101, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S2810=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread5198(int [] tdone, int [] ends){
        switch(S2785){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2784){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 90, column: 11
              S2784=1;
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
            S2784=1;
            S2784=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S2784=2;
            S2785=0;
            active[8]=0;
            ends[8]=0;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5197(int [] tdone, int [] ends){
        switch(S2781){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S2780){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 83, column: 11
              S2780=1;
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
            S2780=1;
            S2780=2;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            S2780=2;
            S2781=0;
            active[7]=0;
            ends[7]=0;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5196(int [] tdone, int [] ends){
        switch(S2777){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S2776){
          case 0 : 
            if(capperFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 11
              S2776=1;
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
            S2776=1;
            S2776=2;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            S2776=2;
            S2777=0;
            active[6]=0;
            ends[6]=0;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5195(int [] tdone, int [] ends){
        switch(S2773){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2772){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 67, column: 11
              S2772=1;
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
            S2772=1;
            S2772=2;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 2 : 
            S2772=2;
            S2773=0;
            active[5]=0;
            ends[5]=0;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5194(int [] tdone, int [] ends){
        switch(S2769){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2768){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 11
              S2768=1;
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
            S2768=1;
            S2768=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S2768=2;
            S2769=0;
            active[4]=0;
            ends[4]=0;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread5192(int [] tdone, int [] ends){
        S2785=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S2784=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread5191(int [] tdone, int [] ends){
        S2781=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 82, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S2780=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread5190(int [] tdone, int [] ends){
        S2777=1;
    checkCapper_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 5
    currsigs.addElement(checkCapper_1);
    System.out.println("Emitted checkCapper_1");
    S2776=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread5189(int [] tdone, int [] ends){
        S2773=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 66, column: 5
    currsigs.addElement(checkFiller_1);
    System.out.println("Emitted checkFiller_1");
    S2772=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread5188(int [] tdone, int [] ends){
        S2769=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 5
    currsigs.addElement(checkCapLoader_1);
    System.out.println("Emitted checkCapLoader_1");
    S2768=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread5187(int [] tdone, int [] ends){
        switch(S2977){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2765){
          case 0 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S2765=1;
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
            S2765=1;
            S2765=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S2765=2;
            S2765=3;
            thread5188(tdone,ends);
            thread5189(tdone,ends);
            thread5190(tdone,ends);
            thread5191(tdone,ends);
            thread5192(tdone,ends);
            int biggest5193 = 0;
            if(ends[4]>=biggest5193){
              biggest5193=ends[4];
            }
            if(ends[5]>=biggest5193){
              biggest5193=ends[5];
            }
            if(ends[6]>=biggest5193){
              biggest5193=ends[6];
            }
            if(ends[7]>=biggest5193){
              biggest5193=ends[7];
            }
            if(ends[8]>=biggest5193){
              biggest5193=ends[8];
            }
            if(biggest5193 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            thread5194(tdone,ends);
            thread5195(tdone,ends);
            thread5196(tdone,ends);
            thread5197(tdone,ends);
            thread5198(tdone,ends);
            int biggest5199 = 0;
            if(ends[4]>=biggest5199){
              biggest5199=ends[4];
            }
            if(ends[5]>=biggest5199){
              biggest5199=ends[5];
            }
            if(ends[6]>=biggest5199){
              biggest5199=ends[6];
            }
            if(ends[7]>=biggest5199){
              biggest5199=ends[7];
            }
            if(ends[8]>=biggest5199){
              biggest5199=ends[8];
            }
            if(biggest5199 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest5199 == 0){
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 95, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S2765=4;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 96, column: 10
              S2765=5;
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
          
          case 5 : 
            S2765=5;
            S2765=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            S2765=6;
            S2765=7;
            thread5200(tdone,ends);
            thread5201(tdone,ends);
            int biggest5202 = 0;
            if(ends[9]>=biggest5202){
              biggest5202=ends[9];
            }
            if(ends[10]>=biggest5202){
              biggest5202=ends[10];
            }
            if(biggest5202 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 7 : 
            thread5203(tdone,ends);
            thread5204(tdone,ends);
            int biggest5205 = 0;
            if(ends[9]>=biggest5205){
              biggest5205=ends[9];
            }
            if(ends[10]>=biggest5205){
              biggest5205=ends[10];
            }
            if(biggest5205 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest5205 == 0){
              S2765=8;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 8 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 116, column: 10
              S2765=9;
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 117, column: 10
              checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 119, column: 4
              currsigs.addElement(checkRotTable_1);
              System.out.println("Emitted checkRotTable_1");
              S2765=10;
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
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 120, column: 10
              S2765=11;
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
          
          case 11 : 
            S2765=11;
            S2765=12;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 12 : 
            S2765=12;
            S2765=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 124, column: 10
              S2765=14;
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
          
          case 14 : 
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 125, column: 10
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S2765=0;
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

  public void thread5186(int [] tdone, int [] ends){
        switch(S2762){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2706){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S2706=1;
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
                S2707=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S2706=0;
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
            switch(S2707){
              case 0 : 
                S2707=0;
                S2707=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S2707=1;
                S2707=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S2707=3;
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
                  S2706=0;
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

  public void thread5184(int [] tdone, int [] ends){
        S5155=1;
    S4982=0;
    active[34]=1;
    ends[34]=1;
    tdone[34]=1;
  }

  public void thread5183(int [] tdone, int [] ends){
        S4981=1;
    b_thread_33 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 570, column: 4
    S4808=0;
    active[33]=1;
    ends[33]=1;
    tdone[33]=1;
  }

  public void thread5182(int [] tdone, int [] ends){
        S4807=1;
    b_thread_32 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 551, column: 4
    S4634=0;
    active[32]=1;
    ends[32]=1;
    tdone[32]=1;
  }

  public void thread5181(int [] tdone, int [] ends){
        S4633=1;
    b_thread_31 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 532, column: 4
    S4460=0;
    active[31]=1;
    ends[31]=1;
    tdone[31]=1;
  }

  public void thread5180(int [] tdone, int [] ends){
        S4459=1;
    b_thread_30 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 513, column: 4
    S4286=0;
    active[30]=1;
    ends[30]=1;
    tdone[30]=1;
  }

  public void thread5179(int [] tdone, int [] ends){
        S4285=1;
    b_thread_29 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 494, column: 4
    S4112=0;
    active[29]=1;
    ends[29]=1;
    tdone[29]=1;
  }

  public void thread5178(int [] tdone, int [] ends){
        S4111=1;
    b_thread_28 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 475, column: 4
    S3938=0;
    active[28]=1;
    ends[28]=1;
    tdone[28]=1;
  }

  public void thread5177(int [] tdone, int [] ends){
        S3937=1;
    b_thread_27 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 455, column: 4
    S3764=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread5176(int [] tdone, int [] ends){
        S3763=1;
    b_thread_26 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
    S3590=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread5175(int [] tdone, int [] ends){
        S3589=1;
    b_thread_25 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
    S3416=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread5174(int [] tdone, int [] ends){
        S3415=1;
    S3397=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread5173(int [] tdone, int [] ends){
        S3395=1;
    S3377=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread5172(int [] tdone, int [] ends){
        S3375=1;
    S3357=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread5171(int [] tdone, int [] ends){
        S3355=1;
    S3331=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread5170(int [] tdone, int [] ends){
        S3329=1;
    S3311=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread5169(int [] tdone, int [] ends){
        S3309=1;
    S3291=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread5168(int [] tdone, int [] ends){
        S3289=1;
    S3265=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread5167(int [] tdone, int [] ends){
        S3263=1;
    S3225=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread5166(int [] tdone, int [] ends){
        S3213=1;
    S3175=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread5165(int [] tdone, int [] ends){
        S3163=1;
    S3125=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread5164(int [] tdone, int [] ends){
        S3113=1;
    S3087=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread5163(int [] tdone, int [] ends){
        S3079=1;
    S3053=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread5162(int [] tdone, int [] ends){
        S3045=1;
    S3019=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread5161(int [] tdone, int [] ends){
        S3011=1;
    S2985=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread5160(int [] tdone, int [] ends){
        S2977=1;
    checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
    currsigs.addElement(checkConveyor_1);
    System.out.println("Emitted checkConveyor_1");
    S2765=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread5159(int [] tdone, int [] ends){
        S2762=1;
    S2706=0;
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
      switch(S5157){
        case 0 : 
          S5157=0;
          break RUN;
        
        case 1 : 
          S5157=2;
          S5157=2;
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
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread5159(tdone,ends);
          thread5160(tdone,ends);
          thread5161(tdone,ends);
          thread5162(tdone,ends);
          thread5163(tdone,ends);
          thread5164(tdone,ends);
          thread5165(tdone,ends);
          thread5166(tdone,ends);
          thread5167(tdone,ends);
          thread5168(tdone,ends);
          thread5169(tdone,ends);
          thread5170(tdone,ends);
          thread5171(tdone,ends);
          thread5172(tdone,ends);
          thread5173(tdone,ends);
          thread5174(tdone,ends);
          thread5175(tdone,ends);
          thread5176(tdone,ends);
          thread5177(tdone,ends);
          thread5178(tdone,ends);
          thread5179(tdone,ends);
          thread5180(tdone,ends);
          thread5181(tdone,ends);
          thread5182(tdone,ends);
          thread5183(tdone,ends);
          thread5184(tdone,ends);
          int biggest5185 = 0;
          if(ends[2]>=biggest5185){
            biggest5185=ends[2];
          }
          if(ends[3]>=biggest5185){
            biggest5185=ends[3];
          }
          if(ends[11]>=biggest5185){
            biggest5185=ends[11];
          }
          if(ends[12]>=biggest5185){
            biggest5185=ends[12];
          }
          if(ends[13]>=biggest5185){
            biggest5185=ends[13];
          }
          if(ends[14]>=biggest5185){
            biggest5185=ends[14];
          }
          if(ends[15]>=biggest5185){
            biggest5185=ends[15];
          }
          if(ends[16]>=biggest5185){
            biggest5185=ends[16];
          }
          if(ends[17]>=biggest5185){
            biggest5185=ends[17];
          }
          if(ends[18]>=biggest5185){
            biggest5185=ends[18];
          }
          if(ends[19]>=biggest5185){
            biggest5185=ends[19];
          }
          if(ends[20]>=biggest5185){
            biggest5185=ends[20];
          }
          if(ends[21]>=biggest5185){
            biggest5185=ends[21];
          }
          if(ends[22]>=biggest5185){
            biggest5185=ends[22];
          }
          if(ends[23]>=biggest5185){
            biggest5185=ends[23];
          }
          if(ends[24]>=biggest5185){
            biggest5185=ends[24];
          }
          if(ends[25]>=biggest5185){
            biggest5185=ends[25];
          }
          if(ends[26]>=biggest5185){
            biggest5185=ends[26];
          }
          if(ends[27]>=biggest5185){
            biggest5185=ends[27];
          }
          if(ends[28]>=biggest5185){
            biggest5185=ends[28];
          }
          if(ends[29]>=biggest5185){
            biggest5185=ends[29];
          }
          if(ends[30]>=biggest5185){
            biggest5185=ends[30];
          }
          if(ends[31]>=biggest5185){
            biggest5185=ends[31];
          }
          if(ends[32]>=biggest5185){
            biggest5185=ends[32];
          }
          if(ends[33]>=biggest5185){
            biggest5185=ends[33];
          }
          if(ends[34]>=biggest5185){
            biggest5185=ends[34];
          }
          if(biggest5185 == 1){
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
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread5186(tdone,ends);
          thread5187(tdone,ends);
          thread5206(tdone,ends);
          thread5207(tdone,ends);
          thread5208(tdone,ends);
          thread5209(tdone,ends);
          thread5210(tdone,ends);
          thread5211(tdone,ends);
          thread5212(tdone,ends);
          thread5213(tdone,ends);
          thread5214(tdone,ends);
          thread5215(tdone,ends);
          thread5216(tdone,ends);
          thread5217(tdone,ends);
          thread5218(tdone,ends);
          thread5219(tdone,ends);
          thread5220(tdone,ends);
          thread5221(tdone,ends);
          thread5222(tdone,ends);
          thread5223(tdone,ends);
          thread5224(tdone,ends);
          thread5225(tdone,ends);
          thread5226(tdone,ends);
          thread5227(tdone,ends);
          thread5228(tdone,ends);
          thread5229(tdone,ends);
          int biggest5230 = 0;
          if(ends[2]>=biggest5230){
            biggest5230=ends[2];
          }
          if(ends[3]>=biggest5230){
            biggest5230=ends[3];
          }
          if(ends[11]>=biggest5230){
            biggest5230=ends[11];
          }
          if(ends[12]>=biggest5230){
            biggest5230=ends[12];
          }
          if(ends[13]>=biggest5230){
            biggest5230=ends[13];
          }
          if(ends[14]>=biggest5230){
            biggest5230=ends[14];
          }
          if(ends[15]>=biggest5230){
            biggest5230=ends[15];
          }
          if(ends[16]>=biggest5230){
            biggest5230=ends[16];
          }
          if(ends[17]>=biggest5230){
            biggest5230=ends[17];
          }
          if(ends[18]>=biggest5230){
            biggest5230=ends[18];
          }
          if(ends[19]>=biggest5230){
            biggest5230=ends[19];
          }
          if(ends[20]>=biggest5230){
            biggest5230=ends[20];
          }
          if(ends[21]>=biggest5230){
            biggest5230=ends[21];
          }
          if(ends[22]>=biggest5230){
            biggest5230=ends[22];
          }
          if(ends[23]>=biggest5230){
            biggest5230=ends[23];
          }
          if(ends[24]>=biggest5230){
            biggest5230=ends[24];
          }
          if(ends[25]>=biggest5230){
            biggest5230=ends[25];
          }
          if(ends[26]>=biggest5230){
            biggest5230=ends[26];
          }
          if(ends[27]>=biggest5230){
            biggest5230=ends[27];
          }
          if(ends[28]>=biggest5230){
            biggest5230=ends[28];
          }
          if(ends[29]>=biggest5230){
            biggest5230=ends[29];
          }
          if(ends[30]>=biggest5230){
            biggest5230=ends[30];
          }
          if(ends[31]>=biggest5230){
            biggest5230=ends[31];
          }
          if(ends[32]>=biggest5230){
            biggest5230=ends[32];
          }
          if(ends[33]>=biggest5230){
            biggest5230=ends[33];
          }
          if(ends[34]>=biggest5230){
            biggest5230=ends[34];
          }
          if(biggest5230 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest5230 == 0){
            S5157=0;
            active[1]=0;
            ends[1]=0;
            S5157=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    startCapperThread_1 = new Signal();
    checkRobotLoader_1 = new Signal();
    checkConveyor_1 = new Signal();
    checkRotTable_1 = new Signal();
    checkRobotUnloader_1 = new Signal();
    checkFiller_1 = new Signal();
    checkCapLoader_1 = new Signal();
    checkCapper_1 = new Signal();
    robotLoaderFinish_1 = new Signal();
    conveyorFinish_1 = new Signal();
    rotTableFinish_1 = new Signal();
    robotUnloaderFinish_1 = new Signal();
    fillerFinish_1 = new Signal();
    capLoaderFinish_1 = new Signal();
    capperFinish_1 = new Signal();
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
          capped.gethook();
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
      capped.setpreclear();
      bottleLoaded.setpreclear();
      bottleUnloaded.setpreclear();
      bottleLoaderRelease.setpreclear();
      bottleUnloaderRelease.setpreclear();
      recieveTwin.setpreclear();
      startConveyor.setpreclear();
      startRotTable.setpreclear();
      startFilling.setpreclear();
      startCapLoading.setpreclear();
      startCapping.setpreclear();
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
      startCapperThread_1.setpreclear();
      checkRobotLoader_1.setpreclear();
      checkConveyor_1.setpreclear();
      checkRotTable_1.setpreclear();
      checkRobotUnloader_1.setpreclear();
      checkFiller_1.setpreclear();
      checkCapLoader_1.setpreclear();
      checkCapper_1.setpreclear();
      robotLoaderFinish_1.setpreclear();
      conveyorFinish_1.setpreclear();
      rotTableFinish_1.setpreclear();
      robotUnloaderFinish_1.setpreclear();
      fillerFinish_1.setpreclear();
      capLoaderFinish_1.setpreclear();
      capperFinish_1.setpreclear();
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
      dummyint = capped.getStatus() ? capped.setprepresent() : capped.setpreclear();
      capped.setpreval(capped.getValue());
      capped.setClear();
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
      startCapping.sethook();
      startCapping.setClear();
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
      startCapperThread_1.setClear();
      checkRobotLoader_1.setClear();
      checkConveyor_1.setClear();
      checkRotTable_1.setClear();
      checkRobotUnloader_1.setClear();
      checkFiller_1.setClear();
      checkCapLoader_1.setClear();
      checkCapper_1.setClear();
      robotLoaderFinish_1.setClear();
      conveyorFinish_1.setClear();
      rotTableFinish_1.setClear();
      robotUnloaderFinish_1.setClear();
      fillerFinish_1.setClear();
      capLoaderFinish_1.setClear();
      capperFinish_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        enable.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capLoaded.gethook();
        capped.gethook();
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
