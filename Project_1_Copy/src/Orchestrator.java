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
  private int S6387 = 1;
  private int S3992 = 1;
  private int S3936 = 1;
  private int S3937 = 1;
  private int S4207 = 1;
  private int S3995 = 1;
  private int S3999 = 1;
  private int S3998 = 1;
  private int S4003 = 1;
  private int S4002 = 1;
  private int S4007 = 1;
  private int S4006 = 1;
  private int S4011 = 1;
  private int S4010 = 1;
  private int S4015 = 1;
  private int S4014 = 1;
  private int S4041 = 1;
  private int S4040 = 1;
  private int S4045 = 1;
  private int S4044 = 1;
  private int S4241 = 1;
  private int S4215 = 1;
  private int S4211 = 1;
  private int S4275 = 1;
  private int S4249 = 1;
  private int S4245 = 1;
  private int S4309 = 1;
  private int S4283 = 1;
  private int S4279 = 1;
  private int S4343 = 1;
  private int S4317 = 1;
  private int S4313 = 1;
  private int S4393 = 1;
  private int S4355 = 1;
  private int S4349 = 1;
  private int S4347 = 1;
  private int S4443 = 1;
  private int S4405 = 1;
  private int S4399 = 1;
  private int S4493 = 1;
  private int S4455 = 1;
  private int S4449 = 1;
  private int S4519 = 1;
  private int S4495 = 1;
  private int S4539 = 1;
  private int S4521 = 1;
  private int S4559 = 1;
  private int S4541 = 1;
  private int S4585 = 1;
  private int S4561 = 1;
  private int S4605 = 1;
  private int S4587 = 1;
  private int S4625 = 1;
  private int S4607 = 1;
  private int S4645 = 1;
  private int S4627 = 1;
  private int S4819 = 1;
  private int S4646 = 1;
  private int S4667 = 1;
  private int S4993 = 1;
  private int S4820 = 1;
  private int S4841 = 1;
  private int S5167 = 1;
  private int S4994 = 1;
  private int S5015 = 1;
  private int S5341 = 1;
  private int S5168 = 1;
  private int S5189 = 1;
  private int S5515 = 1;
  private int S5342 = 1;
  private int S5363 = 1;
  private int S5689 = 1;
  private int S5516 = 1;
  private int S5537 = 1;
  private int S5863 = 1;
  private int S5690 = 1;
  private int S5711 = 1;
  private int S6037 = 1;
  private int S5864 = 1;
  private int S5885 = 1;
  private int S6211 = 1;
  private int S6038 = 1;
  private int S6059 = 1;
  private int S6385 = 1;
  private int S6212 = 1;
  private int S6233 = 1;
  
  private int[] ends = new int[35];
  private int[] tdone = new int[35];
  
  public void thread6459(int [] tdone, int [] ends){
        switch(S6385){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S6212){
          case 0 : 
            S6212=0;
            b_thread_34 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 590, column: 4
            S6212=1;
            if(b_thread_34 != null){//sysj\Orchestrator.sysj line: 591, column: 8
              S6233=0;
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
              S6233=1;
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
            switch(S6233){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 593, column: 11
                  S6212=0;
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
                  S6212=0;
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

  public void thread6458(int [] tdone, int [] ends){
        switch(S6211){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S6038){
          case 0 : 
            S6038=0;
            S6038=1;
            if(b_thread_33 != null){//sysj\Orchestrator.sysj line: 572, column: 8
              S6059=0;
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
              S6059=1;
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
            switch(S6059){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 574, column: 11
                  b_thread_33 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 570, column: 4
                  S6038=0;
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
                  S6038=0;
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

  public void thread6457(int [] tdone, int [] ends){
        switch(S6037){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S5864){
          case 0 : 
            S5864=0;
            S5864=1;
            if(b_thread_32 != null){//sysj\Orchestrator.sysj line: 553, column: 8
              S5885=0;
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
              S5885=1;
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
            switch(S5885){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 555, column: 11
                  b_thread_32 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 551, column: 4
                  S5864=0;
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
                  S5864=0;
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

  public void thread6456(int [] tdone, int [] ends){
        switch(S5863){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S5690){
          case 0 : 
            S5690=0;
            S5690=1;
            if(b_thread_31 != null){//sysj\Orchestrator.sysj line: 534, column: 8
              S5711=0;
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
              S5711=1;
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
            switch(S5711){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 536, column: 11
                  b_thread_31 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 532, column: 4
                  S5690=0;
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
                  S5690=0;
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

  public void thread6455(int [] tdone, int [] ends){
        switch(S5689){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S5516){
          case 0 : 
            S5516=0;
            S5516=1;
            if(b_thread_30 != null){//sysj\Orchestrator.sysj line: 515, column: 8
              S5537=0;
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
              S5537=1;
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
            switch(S5537){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 517, column: 11
                  b_thread_30 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 513, column: 4
                  S5516=0;
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
                  S5516=0;
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

  public void thread6454(int [] tdone, int [] ends){
        switch(S5515){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S5342){
          case 0 : 
            S5342=0;
            S5342=1;
            if(b_thread_29 != null){//sysj\Orchestrator.sysj line: 496, column: 8
              S5363=0;
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
              S5363=1;
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
            switch(S5363){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 498, column: 11
                  b_thread_29 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 494, column: 4
                  S5342=0;
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
                  S5342=0;
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

  public void thread6453(int [] tdone, int [] ends){
        switch(S5341){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S5168){
          case 0 : 
            S5168=0;
            S5168=1;
            if(b_thread_28 != null){//sysj\Orchestrator.sysj line: 477, column: 8
              S5189=0;
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
              S5189=1;
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
            switch(S5189){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 479, column: 11
                  b_thread_28 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 475, column: 4
                  S5168=0;
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
                  S5168=0;
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

  public void thread6452(int [] tdone, int [] ends){
        switch(S5167){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S4994){
          case 0 : 
            S4994=0;
            S4994=1;
            if(b_thread_27 != null){//sysj\Orchestrator.sysj line: 457, column: 8
              S5015=0;
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
              S5015=1;
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
            switch(S5015){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 459, column: 11
                  b_thread_27 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 455, column: 4
                  S4994=0;
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
                  S4994=0;
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

  public void thread6451(int [] tdone, int [] ends){
        switch(S4993){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S4820){
          case 0 : 
            S4820=0;
            S4820=1;
            if(b_thread_26 != null){//sysj\Orchestrator.sysj line: 434, column: 8
              S4841=0;
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
              S4841=1;
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
            switch(S4841){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 436, column: 11
                  b_thread_26 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
                  S4820=0;
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
                  S4820=0;
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

  public void thread6450(int [] tdone, int [] ends){
        switch(S4819){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S4646){
          case 0 : 
            S4646=0;
            S4646=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 415, column: 8
              S4667=0;
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
              S4667=1;
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
            switch(S4667){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 417, column: 11
                  b_thread_25 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
                  S4646=0;
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
                  S4646=0;
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

  public void thread6449(int [] tdone, int [] ends){
        switch(S4645){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S4627){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 394, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 396, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S4627=1;
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
              S4627=2;
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
            S4627=2;
            S4627=3;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 3 : 
            S4627=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 400, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S4627=4;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 402, column: 10
              S4627=0;
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

  public void thread6448(int [] tdone, int [] ends){
        switch(S4625){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S4607){
          case 0 : 
            if(startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 377, column: 10
              startCapping.setPresent();//sysj\Orchestrator.sysj line: 379, column: 4
              currsigs.addElement(startCapping);
              System.out.println("Emitted startCapping");
              S4607=1;
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
              S4607=2;
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
            S4607=2;
            S4607=3;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 3 : 
            S4607=3;
            capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 383, column: 4
            currsigs.addElement(capperFinish_1);
            System.out.println("Emitted capperFinish_1");
            S4607=4;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 4 : 
            if(!startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 385, column: 10
              S4607=0;
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

  public void thread6447(int [] tdone, int [] ends){
        switch(S4605){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S4587){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 360, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 362, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S4587=1;
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
              S4587=2;
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
            S4587=2;
            S4587=3;
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
            break;
          
          case 3 : 
            S4587=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 366, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S4587=4;
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 368, column: 10
              S4587=0;
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

  public void thread6446(int [] tdone, int [] ends){
        switch(S4585){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S4561){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 339, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 341, column: 4
              currsigs.addElement(startBottleUnloading);
              System.out.println("Emitted startBottleUnloading");
              S4561=1;
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
              S4561=2;
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
            S4561=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 345, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 345, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 346, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_21);//sysj\Orchestrator.sysj line: 346, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S4561=3;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 10
              S4561=4;
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
            S4561=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 349, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S4561=5;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 350, column: 10
              S4561=0;
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

  public void thread6445(int [] tdone, int [] ends){
        switch(S4559){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S4541){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 308, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 311, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S4541=1;
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
              S4541=2;
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
            S4541=2;
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
            S4541=3;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 3 : 
            S4541=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 328, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S4541=4;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 329, column: 10
              S4541=0;
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

  public void thread6444(int [] tdone, int [] ends){
        switch(S4539){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S4521){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 281, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 284, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S4521=1;
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
              S4521=2;
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
            S4521=2;
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
            S4521=3;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 3 : 
            S4521=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 297, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S4521=4;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 298, column: 10
              S4521=0;
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

  public void thread6443(int [] tdone, int [] ends){
        switch(S4519){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S4495){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 256, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 258, column: 4
              currsigs.addElement(startBottleLoading);
              System.out.println("Emitted startBottleLoading");
              S4495=1;
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
              S4495=2;
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
            S4495=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 263, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 264, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_18);//sysj\Orchestrator.sysj line: 264, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S4495=3;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 266, column: 10
              S4495=4;
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
            S4495=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 269, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S4495=5;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 270, column: 10
              S4495=0;
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

  public void thread6442(int [] tdone, int [] ends){
        switch(S4493){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S4455){
          case 0 : 
            if(checkCapper_1.getprestatus()){//sysj\Orchestrator.sysj line: 236, column: 10
              S4455=1;
              if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 12
                S4449=0;
                b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 5
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
                S4449=1;
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
            switch(S4449){
              case 0 : 
                S4455=0;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
                break;
              
              case 1 : 
                capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 247, column: 4
                currsigs.addElement(capperFinish_1);
                System.out.println("Emitted capperFinish_1");
                S4455=0;
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

  public void thread6441(int [] tdone, int [] ends){
        switch(S4443){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S4405){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 216, column: 10
              S4405=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 12
                S4399=0;
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
                S4399=1;
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
            switch(S4399){
              case 0 : 
                S4405=0;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 227, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S4405=0;
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

  public void thread6440(int [] tdone, int [] ends){
        switch(S4393){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S4355){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 196, column: 10
              S4355=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 197, column: 12
                S4349=0;
                b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 198, column: 5
                S4347=0;
                if(!b_thread_15.isFilled){//sysj\Orchestrator.sysj line: 199, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S4347=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 202, column: 6
                  currsigs.addElement(fillerFinish_1);
                  System.out.println("Emitted fillerFinish_1");
                  S4347=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S4349=1;
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
            switch(S4349){
              case 0 : 
                switch(S4347){
                  case 0 : 
                    S4355=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                    break;
                  
                  case 1 : 
                    S4347=1;
                    S4355=0;
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
                S4355=0;
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

  public void thread6439(int [] tdone, int [] ends){
        switch(S4343){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4317){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 181, column: 10
              S4317=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 182, column: 12
                S4313=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 183, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S4313=1;
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
            switch(S4313){
              case 0 : 
                S4317=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S4317=0;
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

  public void thread6438(int [] tdone, int [] ends){
        switch(S4309){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S4283){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 164, column: 10
              S4283=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 166, column: 12
                S4279=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 167, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S4279=1;
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
            switch(S4279){
              case 0 : 
                S4283=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 171, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S4283=0;
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

  public void thread6437(int [] tdone, int [] ends){
        switch(S4275){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4249){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 149, column: 10
              S4249=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 150, column: 12
                S4245=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 151, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S4245=1;
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
            switch(S4245){
              case 0 : 
                S4249=0;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 155, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S4249=0;
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

  public void thread6436(int [] tdone, int [] ends){
        switch(S4241){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4215){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 134, column: 10
              S4215=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 135, column: 12
                S4211=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 136, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S4211=1;
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
            switch(S4211){
              case 0 : 
                S4215=0;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 140, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S4215=0;
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

  public void thread6434(int [] tdone, int [] ends){
        switch(S4045){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4044){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 110, column: 11
              S4044=1;
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
            S4044=1;
            S4044=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S4044=2;
            S4045=0;
            active[10]=0;
            ends[10]=0;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6433(int [] tdone, int [] ends){
        switch(S4041){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4040){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 11
              S4040=1;
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
            S4040=1;
            S4040=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S4040=2;
            S4041=0;
            active[9]=0;
            ends[9]=0;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6431(int [] tdone, int [] ends){
        S4045=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 109, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S4044=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread6430(int [] tdone, int [] ends){
        S4041=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 101, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S4040=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread6428(int [] tdone, int [] ends){
        switch(S4015){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4014){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 90, column: 11
              S4014=1;
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
            S4014=1;
            S4014=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S4014=2;
            S4015=0;
            active[8]=0;
            ends[8]=0;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6427(int [] tdone, int [] ends){
        switch(S4011){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4010){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 83, column: 11
              S4010=1;
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
            S4010=1;
            S4010=2;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            S4010=2;
            S4011=0;
            active[7]=0;
            ends[7]=0;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6426(int [] tdone, int [] ends){
        switch(S4007){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4006){
          case 0 : 
            if(capperFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 11
              S4006=1;
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
            S4006=1;
            S4006=2;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            S4006=2;
            S4007=0;
            active[6]=0;
            ends[6]=0;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6425(int [] tdone, int [] ends){
        switch(S4003){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4002){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 67, column: 11
              S4002=1;
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
            S4002=1;
            S4002=2;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 2 : 
            S4002=2;
            S4003=0;
            active[5]=0;
            ends[5]=0;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6424(int [] tdone, int [] ends){
        switch(S3999){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3998){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 11
              S3998=1;
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
            S3998=1;
            S3998=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S3998=2;
            S3999=0;
            active[4]=0;
            ends[4]=0;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6422(int [] tdone, int [] ends){
        S4015=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S4014=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread6421(int [] tdone, int [] ends){
        S4011=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 82, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S4010=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread6420(int [] tdone, int [] ends){
        S4007=1;
    checkCapper_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 5
    currsigs.addElement(checkCapper_1);
    System.out.println("Emitted checkCapper_1");
    S4006=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread6419(int [] tdone, int [] ends){
        S4003=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 66, column: 5
    currsigs.addElement(checkFiller_1);
    System.out.println("Emitted checkFiller_1");
    S4002=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6418(int [] tdone, int [] ends){
        S3999=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 5
    currsigs.addElement(checkCapLoader_1);
    System.out.println("Emitted checkCapLoader_1");
    S3998=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread6417(int [] tdone, int [] ends){
        switch(S4207){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3995){
          case 0 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S3995=1;
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
            S3995=1;
            S3995=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S3995=2;
            S3995=3;
            thread6418(tdone,ends);
            thread6419(tdone,ends);
            thread6420(tdone,ends);
            thread6421(tdone,ends);
            thread6422(tdone,ends);
            int biggest6423 = 0;
            if(ends[4]>=biggest6423){
              biggest6423=ends[4];
            }
            if(ends[5]>=biggest6423){
              biggest6423=ends[5];
            }
            if(ends[6]>=biggest6423){
              biggest6423=ends[6];
            }
            if(ends[7]>=biggest6423){
              biggest6423=ends[7];
            }
            if(ends[8]>=biggest6423){
              biggest6423=ends[8];
            }
            if(biggest6423 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            thread6424(tdone,ends);
            thread6425(tdone,ends);
            thread6426(tdone,ends);
            thread6427(tdone,ends);
            thread6428(tdone,ends);
            int biggest6429 = 0;
            if(ends[4]>=biggest6429){
              biggest6429=ends[4];
            }
            if(ends[5]>=biggest6429){
              biggest6429=ends[5];
            }
            if(ends[6]>=biggest6429){
              biggest6429=ends[6];
            }
            if(ends[7]>=biggest6429){
              biggest6429=ends[7];
            }
            if(ends[8]>=biggest6429){
              biggest6429=ends[8];
            }
            if(biggest6429 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest6429 == 0){
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 95, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S3995=4;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 96, column: 10
              S3995=5;
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
            S3995=5;
            S3995=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            S3995=6;
            S3995=7;
            thread6430(tdone,ends);
            thread6431(tdone,ends);
            int biggest6432 = 0;
            if(ends[9]>=biggest6432){
              biggest6432=ends[9];
            }
            if(ends[10]>=biggest6432){
              biggest6432=ends[10];
            }
            if(biggest6432 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 7 : 
            thread6433(tdone,ends);
            thread6434(tdone,ends);
            int biggest6435 = 0;
            if(ends[9]>=biggest6435){
              biggest6435=ends[9];
            }
            if(ends[10]>=biggest6435){
              biggest6435=ends[10];
            }
            if(biggest6435 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest6435 == 0){
              S3995=8;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 8 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 116, column: 10
              S3995=9;
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
              S3995=10;
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
              S3995=11;
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
            S3995=11;
            S3995=12;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 12 : 
            S3995=12;
            S3995=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 124, column: 10
              S3995=14;
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
              S3995=0;
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

  public void thread6416(int [] tdone, int [] ends){
        switch(S3992){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3936){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S3936=1;
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
                S3937=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S3936=0;
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
            switch(S3937){
              case 0 : 
                S3937=0;
                S3937=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S3937=1;
                S3937=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S3937=3;
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
                  S3936=0;
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

  public void thread6414(int [] tdone, int [] ends){
        S6385=1;
    S6212=0;
    active[34]=1;
    ends[34]=1;
    tdone[34]=1;
  }

  public void thread6413(int [] tdone, int [] ends){
        S6211=1;
    b_thread_33 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 570, column: 4
    S6038=0;
    active[33]=1;
    ends[33]=1;
    tdone[33]=1;
  }

  public void thread6412(int [] tdone, int [] ends){
        S6037=1;
    b_thread_32 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 551, column: 4
    S5864=0;
    active[32]=1;
    ends[32]=1;
    tdone[32]=1;
  }

  public void thread6411(int [] tdone, int [] ends){
        S5863=1;
    b_thread_31 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 532, column: 4
    S5690=0;
    active[31]=1;
    ends[31]=1;
    tdone[31]=1;
  }

  public void thread6410(int [] tdone, int [] ends){
        S5689=1;
    b_thread_30 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 513, column: 4
    S5516=0;
    active[30]=1;
    ends[30]=1;
    tdone[30]=1;
  }

  public void thread6409(int [] tdone, int [] ends){
        S5515=1;
    b_thread_29 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 494, column: 4
    S5342=0;
    active[29]=1;
    ends[29]=1;
    tdone[29]=1;
  }

  public void thread6408(int [] tdone, int [] ends){
        S5341=1;
    b_thread_28 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 475, column: 4
    S5168=0;
    active[28]=1;
    ends[28]=1;
    tdone[28]=1;
  }

  public void thread6407(int [] tdone, int [] ends){
        S5167=1;
    b_thread_27 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 455, column: 4
    S4994=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread6406(int [] tdone, int [] ends){
        S4993=1;
    b_thread_26 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
    S4820=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread6405(int [] tdone, int [] ends){
        S4819=1;
    b_thread_25 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
    S4646=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread6404(int [] tdone, int [] ends){
        S4645=1;
    S4627=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread6403(int [] tdone, int [] ends){
        S4625=1;
    S4607=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread6402(int [] tdone, int [] ends){
        S4605=1;
    S4587=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread6401(int [] tdone, int [] ends){
        S4585=1;
    S4561=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread6400(int [] tdone, int [] ends){
        S4559=1;
    S4541=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread6399(int [] tdone, int [] ends){
        S4539=1;
    S4521=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread6398(int [] tdone, int [] ends){
        S4519=1;
    S4495=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread6397(int [] tdone, int [] ends){
        S4493=1;
    S4455=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread6396(int [] tdone, int [] ends){
        S4443=1;
    S4405=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread6395(int [] tdone, int [] ends){
        S4393=1;
    S4355=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread6394(int [] tdone, int [] ends){
        S4343=1;
    S4317=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread6393(int [] tdone, int [] ends){
        S4309=1;
    S4283=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread6392(int [] tdone, int [] ends){
        S4275=1;
    S4249=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread6391(int [] tdone, int [] ends){
        S4241=1;
    S4215=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread6390(int [] tdone, int [] ends){
        S4207=1;
    checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
    currsigs.addElement(checkConveyor_1);
    System.out.println("Emitted checkConveyor_1");
    S3995=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6389(int [] tdone, int [] ends){
        S3992=1;
    S3936=0;
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
      switch(S6387){
        case 0 : 
          S6387=0;
          break RUN;
        
        case 1 : 
          S6387=2;
          S6387=2;
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
          thread6389(tdone,ends);
          thread6390(tdone,ends);
          thread6391(tdone,ends);
          thread6392(tdone,ends);
          thread6393(tdone,ends);
          thread6394(tdone,ends);
          thread6395(tdone,ends);
          thread6396(tdone,ends);
          thread6397(tdone,ends);
          thread6398(tdone,ends);
          thread6399(tdone,ends);
          thread6400(tdone,ends);
          thread6401(tdone,ends);
          thread6402(tdone,ends);
          thread6403(tdone,ends);
          thread6404(tdone,ends);
          thread6405(tdone,ends);
          thread6406(tdone,ends);
          thread6407(tdone,ends);
          thread6408(tdone,ends);
          thread6409(tdone,ends);
          thread6410(tdone,ends);
          thread6411(tdone,ends);
          thread6412(tdone,ends);
          thread6413(tdone,ends);
          thread6414(tdone,ends);
          int biggest6415 = 0;
          if(ends[2]>=biggest6415){
            biggest6415=ends[2];
          }
          if(ends[3]>=biggest6415){
            biggest6415=ends[3];
          }
          if(ends[11]>=biggest6415){
            biggest6415=ends[11];
          }
          if(ends[12]>=biggest6415){
            biggest6415=ends[12];
          }
          if(ends[13]>=biggest6415){
            biggest6415=ends[13];
          }
          if(ends[14]>=biggest6415){
            biggest6415=ends[14];
          }
          if(ends[15]>=biggest6415){
            biggest6415=ends[15];
          }
          if(ends[16]>=biggest6415){
            biggest6415=ends[16];
          }
          if(ends[17]>=biggest6415){
            biggest6415=ends[17];
          }
          if(ends[18]>=biggest6415){
            biggest6415=ends[18];
          }
          if(ends[19]>=biggest6415){
            biggest6415=ends[19];
          }
          if(ends[20]>=biggest6415){
            biggest6415=ends[20];
          }
          if(ends[21]>=biggest6415){
            biggest6415=ends[21];
          }
          if(ends[22]>=biggest6415){
            biggest6415=ends[22];
          }
          if(ends[23]>=biggest6415){
            biggest6415=ends[23];
          }
          if(ends[24]>=biggest6415){
            biggest6415=ends[24];
          }
          if(ends[25]>=biggest6415){
            biggest6415=ends[25];
          }
          if(ends[26]>=biggest6415){
            biggest6415=ends[26];
          }
          if(ends[27]>=biggest6415){
            biggest6415=ends[27];
          }
          if(ends[28]>=biggest6415){
            biggest6415=ends[28];
          }
          if(ends[29]>=biggest6415){
            biggest6415=ends[29];
          }
          if(ends[30]>=biggest6415){
            biggest6415=ends[30];
          }
          if(ends[31]>=biggest6415){
            biggest6415=ends[31];
          }
          if(ends[32]>=biggest6415){
            biggest6415=ends[32];
          }
          if(ends[33]>=biggest6415){
            biggest6415=ends[33];
          }
          if(ends[34]>=biggest6415){
            biggest6415=ends[34];
          }
          if(biggest6415 == 1){
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
          thread6416(tdone,ends);
          thread6417(tdone,ends);
          thread6436(tdone,ends);
          thread6437(tdone,ends);
          thread6438(tdone,ends);
          thread6439(tdone,ends);
          thread6440(tdone,ends);
          thread6441(tdone,ends);
          thread6442(tdone,ends);
          thread6443(tdone,ends);
          thread6444(tdone,ends);
          thread6445(tdone,ends);
          thread6446(tdone,ends);
          thread6447(tdone,ends);
          thread6448(tdone,ends);
          thread6449(tdone,ends);
          thread6450(tdone,ends);
          thread6451(tdone,ends);
          thread6452(tdone,ends);
          thread6453(tdone,ends);
          thread6454(tdone,ends);
          thread6455(tdone,ends);
          thread6456(tdone,ends);
          thread6457(tdone,ends);
          thread6458(tdone,ends);
          thread6459(tdone,ends);
          int biggest6460 = 0;
          if(ends[2]>=biggest6460){
            biggest6460=ends[2];
          }
          if(ends[3]>=biggest6460){
            biggest6460=ends[3];
          }
          if(ends[11]>=biggest6460){
            biggest6460=ends[11];
          }
          if(ends[12]>=biggest6460){
            biggest6460=ends[12];
          }
          if(ends[13]>=biggest6460){
            biggest6460=ends[13];
          }
          if(ends[14]>=biggest6460){
            biggest6460=ends[14];
          }
          if(ends[15]>=biggest6460){
            biggest6460=ends[15];
          }
          if(ends[16]>=biggest6460){
            biggest6460=ends[16];
          }
          if(ends[17]>=biggest6460){
            biggest6460=ends[17];
          }
          if(ends[18]>=biggest6460){
            biggest6460=ends[18];
          }
          if(ends[19]>=biggest6460){
            biggest6460=ends[19];
          }
          if(ends[20]>=biggest6460){
            biggest6460=ends[20];
          }
          if(ends[21]>=biggest6460){
            biggest6460=ends[21];
          }
          if(ends[22]>=biggest6460){
            biggest6460=ends[22];
          }
          if(ends[23]>=biggest6460){
            biggest6460=ends[23];
          }
          if(ends[24]>=biggest6460){
            biggest6460=ends[24];
          }
          if(ends[25]>=biggest6460){
            biggest6460=ends[25];
          }
          if(ends[26]>=biggest6460){
            biggest6460=ends[26];
          }
          if(ends[27]>=biggest6460){
            biggest6460=ends[27];
          }
          if(ends[28]>=biggest6460){
            biggest6460=ends[28];
          }
          if(ends[29]>=biggest6460){
            biggest6460=ends[29];
          }
          if(ends[30]>=biggest6460){
            biggest6460=ends[30];
          }
          if(ends[31]>=biggest6460){
            biggest6460=ends[31];
          }
          if(ends[32]>=biggest6460){
            biggest6460=ends[32];
          }
          if(ends[33]>=biggest6460){
            biggest6460=ends[33];
          }
          if(ends[34]>=biggest6460){
            biggest6460=ends[34];
          }
          if(biggest6460 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6460 == 0){
            S6387=0;
            active[1]=0;
            ends[1]=0;
            S6387=0;
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
