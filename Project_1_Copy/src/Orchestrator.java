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
  public Signal bottleRemoved = new Signal("bottleRemoved", Signal.INPUT);
  public Signal introduceFault = new Signal("introduceFault", Signal.INPUT);
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
  public Signal startRemover = new Signal("startRemover", Signal.OUTPUT);
  public Signal faultUpdate = new Signal("faultUpdate", Signal.OUTPUT);
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
  private Signal fault_1;
  private Signal stop_1;
  private Signal pauseFaultCheck_1;
  private Signal faultSolved_1;
  private Signal addFault_1;
  private int location_thread_4;//sysj\Orchestrator.sysj line: 33, column: 4
  private int location_thread_5;//sysj\Orchestrator.sysj line: 54, column: 4
  private BottleTwin b_thread_5;//sysj\Orchestrator.sysj line: 57, column: 6
  private BottleTwin b_thread_6;//sysj\Orchestrator.sysj line: 76, column: 4
  private int ID_thread_6;//sysj\Orchestrator.sysj line: 79, column: 5
  private String name_thread_6;//sysj\Orchestrator.sysj line: 80, column: 5
  private int pos_thread_7;//sysj\Orchestrator.sysj line: 110, column: 6
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 218, column: 6
  private boolean faulty_thread_15;//sysj\Orchestrator.sysj line: 220, column: 7
  private int id_thread_15;//sysj\Orchestrator.sysj line: 223, column: 8
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 238, column: 6
  private boolean faulty_thread_16;//sysj\Orchestrator.sysj line: 240, column: 7
  private int id_thread_16;//sysj\Orchestrator.sysj line: 243, column: 8
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 261, column: 6
  private boolean faulty_thread_17;//sysj\Orchestrator.sysj line: 263, column: 7
  private int id_thread_17;//sysj\Orchestrator.sysj line: 266, column: 8
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 283, column: 6
  private boolean faulty_thread_18;//sysj\Orchestrator.sysj line: 285, column: 7
  private int id_thread_18;//sysj\Orchestrator.sysj line: 288, column: 8
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 305, column: 6
  private boolean faulty_thread_19;//sysj\Orchestrator.sysj line: 307, column: 7
  private int id_thread_19;//sysj\Orchestrator.sysj line: 310, column: 8
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 327, column: 6
  private boolean faulty_thread_20;//sysj\Orchestrator.sysj line: 329, column: 7
  private int id_thread_20;//sysj\Orchestrator.sysj line: 332, column: 8
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 350, column: 6
  private boolean faulty_thread_21;//sysj\Orchestrator.sysj line: 352, column: 7
  private int id_thread_21;//sysj\Orchestrator.sysj line: 355, column: 8
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 372, column: 6
  private boolean faulty_thread_22;//sysj\Orchestrator.sysj line: 374, column: 7
  private int id_thread_22;//sysj\Orchestrator.sysj line: 377, column: 8
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 394, column: 6
  private boolean faulty_thread_23;//sysj\Orchestrator.sysj line: 396, column: 7
  private int id_thread_23;//sysj\Orchestrator.sysj line: 399, column: 8
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 416, column: 6
  private boolean faulty_thread_24;//sysj\Orchestrator.sysj line: 418, column: 7
  private int id_thread_24;//sysj\Orchestrator.sysj line: 421, column: 8
  private BottleTwin b_thread_29;//sysj\Orchestrator.sysj line: 501, column: 5
  private BottleTwin b_thread_30;//sysj\Orchestrator.sysj line: 521, column: 5
  private BottleTwin b_thread_31;//sysj\Orchestrator.sysj line: 541, column: 5
  private BottleTwin bEight_thread_32;//sysj\Orchestrator.sysj line: 564, column: 4
  private BottleTwin bZero_thread_33;//sysj\Orchestrator.sysj line: 590, column: 4
  private BottleTwin bFive_thread_33;//sysj\Orchestrator.sysj line: 591, column: 4
  private BottleTwin bOne_thread_34;//sysj\Orchestrator.sysj line: 616, column: 4
  private BottleTwin bTwo_thread_34;//sysj\Orchestrator.sysj line: 617, column: 4
  private BottleTwin bThree_thread_34;//sysj\Orchestrator.sysj line: 618, column: 4
  private BottleTwin bFour_thread_34;//sysj\Orchestrator.sysj line: 619, column: 4
  private BottleTwin bFive_thread_34;//sysj\Orchestrator.sysj line: 620, column: 4
  private BottleTwin bSix_thread_34;//sysj\Orchestrator.sysj line: 621, column: 4
  private BottleTwin bSeven_thread_35;//sysj\Orchestrator.sysj line: 646, column: 4
  private int id_thread_39;//sysj\Orchestrator.sysj line: 719, column: 5
  private BottleTwin b_thread_39;//sysj\Orchestrator.sysj line: 716, column: 4
  private int id_thread_40;//sysj\Orchestrator.sysj line: 738, column: 5
  private BottleTwin b_thread_40;//sysj\Orchestrator.sysj line: 735, column: 4
  private int id_thread_41;//sysj\Orchestrator.sysj line: 761, column: 5
  private BottleTwin b_thread_41;//sysj\Orchestrator.sysj line: 758, column: 4
  private int id_thread_42;//sysj\Orchestrator.sysj line: 781, column: 5
  private BottleTwin b_thread_42;//sysj\Orchestrator.sysj line: 778, column: 4
  private int id_thread_43;//sysj\Orchestrator.sysj line: 800, column: 5
  private BottleTwin b_thread_43;//sysj\Orchestrator.sysj line: 797, column: 4
  private int id_thread_44;//sysj\Orchestrator.sysj line: 819, column: 5
  private BottleTwin b_thread_44;//sysj\Orchestrator.sysj line: 816, column: 4
  private int id_thread_45;//sysj\Orchestrator.sysj line: 838, column: 5
  private BottleTwin b_thread_45;//sysj\Orchestrator.sysj line: 835, column: 4
  private int id_thread_46;//sysj\Orchestrator.sysj line: 857, column: 5
  private BottleTwin b_thread_46;//sysj\Orchestrator.sysj line: 854, column: 4
  private int id_thread_47;//sysj\Orchestrator.sysj line: 876, column: 5
  private BottleTwin b_thread_47;//sysj\Orchestrator.sysj line: 873, column: 4
  private BottleTwin b_thread_48;//sysj\Orchestrator.sysj line: 893, column: 4
  private int id_thread_48;//sysj\Orchestrator.sysj line: 895, column: 5
  private int S7476 = 1;
  private int S3910 = 1;
  private int S3909 = 1;
  private int S3886 = 1;
  private int S3894 = 1;
  private int S3887 = 1;
  private int S3892 = 1;
  private int S4020 = 1;
  private int S3914 = 1;
  private int S4078 = 1;
  private int S4022 = 1;
  private int S4023 = 1;
  private int S4668 = 1;
  private int S4079 = 1;
  private int S4089 = 1;
  private int S4088 = 1;
  private int S4093 = 1;
  private int S4092 = 1;
  private int S4097 = 1;
  private int S4096 = 1;
  private int S4101 = 1;
  private int S4100 = 1;
  private int S4105 = 1;
  private int S4104 = 1;
  private int S4135 = 1;
  private int S4134 = 1;
  private int S4139 = 1;
  private int S4138 = 1;
  private int S4750 = 1;
  private int S4683 = 1;
  private int S4800 = 1;
  private int S4850 = 1;
  private int S4900 = 1;
  private int S4950 = 1;
  private int S5032 = 1;
  private int S4965 = 1;
  private int S5114 = 1;
  private int S5047 = 1;
  private int S5196 = 1;
  private int S5129 = 1;
  private int S5246 = 1;
  private int S5296 = 1;
  private int S5330 = 1;
  private int S5304 = 1;
  private int S5300 = 1;
  private int S5364 = 1;
  private int S5338 = 1;
  private int S5334 = 1;
  private int S5398 = 1;
  private int S5372 = 1;
  private int S5368 = 1;
  private int S5432 = 1;
  private int S5406 = 1;
  private int S5402 = 1;
  private int S5482 = 1;
  private int S5444 = 1;
  private int S5438 = 1;
  private int S5532 = 1;
  private int S5494 = 1;
  private int S5488 = 1;
  private int S5582 = 1;
  private int S5544 = 1;
  private int S5538 = 1;
  private int S5608 = 1;
  private int S5584 = 1;
  private int S5628 = 1;
  private int S5610 = 1;
  private int S5648 = 1;
  private int S5630 = 1;
  private int S5674 = 1;
  private int S5650 = 1;
  private int S5694 = 1;
  private int S5676 = 1;
  private int S5714 = 1;
  private int S5696 = 1;
  private int S5734 = 1;
  private int S5716 = 1;
  private int S5908 = 1;
  private int S5735 = 1;
  private int S5756 = 1;
  private int S6082 = 1;
  private int S5909 = 1;
  private int S5930 = 1;
  private int S6256 = 1;
  private int S6083 = 1;
  private int S6104 = 1;
  private int S6430 = 1;
  private int S6257 = 1;
  private int S6278 = 1;
  private int S6604 = 1;
  private int S6431 = 1;
  private int S6452 = 1;
  private int S6778 = 1;
  private int S6605 = 1;
  private int S6626 = 1;
  private int S6952 = 1;
  private int S6779 = 1;
  private int S6800 = 1;
  private int S7126 = 1;
  private int S6953 = 1;
  private int S6974 = 1;
  private int S7300 = 1;
  private int S7127 = 1;
  private int S7148 = 1;
  private int S7474 = 1;
  private int S7301 = 1;
  private int S7322 = 1;
  
  private int[] ends = new int[49];
  private int[] tdone = new int[49];
  
  public void thread7578(int [] tdone, int [] ends){
        switch(S7474){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        switch(S7301){
          case 0 : 
            S7301=0;
            b_thread_48 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 893, column: 4
            S7301=1;
            if(b_thread_48 != null){//sysj\Orchestrator.sysj line: 894, column: 8
              S7322=0;
              id_thread_48 = b_thread_48.ID;//sysj\Orchestrator.sysj line: 895, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 897, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_48);//sysj\Orchestrator.sysj line: 897, column: 6
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 898, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_48);//sysj\Orchestrator.sysj line: 898, column: 6
              active[48]=1;
              ends[48]=1;
              tdone[48]=1;
            }
            else {
              S7322=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 901, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 901, column: 5
              active[48]=1;
              ends[48]=1;
              tdone[48]=1;
            }
            break;
          
          case 1 : 
            switch(S7322){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 896, column: 11
                  S7301=0;
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 898, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_48);//sysj\Orchestrator.sysj line: 898, column: 6
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 902, column: 11
                  S7301=0;
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                else {
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7577(int [] tdone, int [] ends){
        switch(S7300){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        switch(S7127){
          case 0 : 
            S7127=0;
            S7127=1;
            if(b_thread_47 != null){//sysj\Orchestrator.sysj line: 875, column: 8
              S7148=0;
              id_thread_47 = b_thread_47.ID;//sysj\Orchestrator.sysj line: 876, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 878, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_47);//sysj\Orchestrator.sysj line: 878, column: 6
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 879, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_47);//sysj\Orchestrator.sysj line: 879, column: 6
              active[47]=1;
              ends[47]=1;
              tdone[47]=1;
            }
            else {
              S7148=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 882, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 882, column: 5
              active[47]=1;
              ends[47]=1;
              tdone[47]=1;
            }
            break;
          
          case 1 : 
            switch(S7148){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 877, column: 11
                  b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 873, column: 4
                  S7127=0;
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 879, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_47);//sysj\Orchestrator.sysj line: 879, column: 6
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 883, column: 11
                  b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 873, column: 4
                  S7127=0;
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                else {
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7576(int [] tdone, int [] ends){
        switch(S7126){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        switch(S6953){
          case 0 : 
            S6953=0;
            S6953=1;
            if(b_thread_46 != null){//sysj\Orchestrator.sysj line: 856, column: 8
              S6974=0;
              id_thread_46 = b_thread_46.ID;//sysj\Orchestrator.sysj line: 857, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 859, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_46);//sysj\Orchestrator.sysj line: 859, column: 6
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 860, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_46);//sysj\Orchestrator.sysj line: 860, column: 6
              active[46]=1;
              ends[46]=1;
              tdone[46]=1;
            }
            else {
              S6974=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 863, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 863, column: 5
              active[46]=1;
              ends[46]=1;
              tdone[46]=1;
            }
            break;
          
          case 1 : 
            switch(S6974){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 858, column: 11
                  b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 854, column: 4
                  S6953=0;
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 860, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_46);//sysj\Orchestrator.sysj line: 860, column: 6
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 864, column: 11
                  b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 854, column: 4
                  S6953=0;
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                else {
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7575(int [] tdone, int [] ends){
        switch(S6952){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        switch(S6779){
          case 0 : 
            S6779=0;
            S6779=1;
            if(b_thread_45 != null){//sysj\Orchestrator.sysj line: 837, column: 8
              S6800=0;
              id_thread_45 = b_thread_45.ID;//sysj\Orchestrator.sysj line: 838, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 840, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_45);//sysj\Orchestrator.sysj line: 840, column: 6
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 841, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_45);//sysj\Orchestrator.sysj line: 841, column: 6
              active[45]=1;
              ends[45]=1;
              tdone[45]=1;
            }
            else {
              S6800=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 844, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 844, column: 5
              active[45]=1;
              ends[45]=1;
              tdone[45]=1;
            }
            break;
          
          case 1 : 
            switch(S6800){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 839, column: 11
                  b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 835, column: 4
                  S6779=0;
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 841, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_45);//sysj\Orchestrator.sysj line: 841, column: 6
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 845, column: 11
                  b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 835, column: 4
                  S6779=0;
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                else {
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7574(int [] tdone, int [] ends){
        switch(S6778){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        switch(S6605){
          case 0 : 
            S6605=0;
            S6605=1;
            if(b_thread_44 != null){//sysj\Orchestrator.sysj line: 818, column: 8
              S6626=0;
              id_thread_44 = b_thread_44.ID;//sysj\Orchestrator.sysj line: 819, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 821, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_44);//sysj\Orchestrator.sysj line: 821, column: 6
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 822, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_44);//sysj\Orchestrator.sysj line: 822, column: 6
              active[44]=1;
              ends[44]=1;
              tdone[44]=1;
            }
            else {
              S6626=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 825, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 825, column: 5
              active[44]=1;
              ends[44]=1;
              tdone[44]=1;
            }
            break;
          
          case 1 : 
            switch(S6626){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 820, column: 11
                  b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 816, column: 4
                  S6605=0;
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 822, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_44);//sysj\Orchestrator.sysj line: 822, column: 6
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 826, column: 11
                  b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 816, column: 4
                  S6605=0;
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                else {
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7573(int [] tdone, int [] ends){
        switch(S6604){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        switch(S6431){
          case 0 : 
            S6431=0;
            S6431=1;
            if(b_thread_43 != null){//sysj\Orchestrator.sysj line: 799, column: 8
              S6452=0;
              id_thread_43 = b_thread_43.ID;//sysj\Orchestrator.sysj line: 800, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 802, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_43);//sysj\Orchestrator.sysj line: 802, column: 6
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 803, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_43);//sysj\Orchestrator.sysj line: 803, column: 6
              active[43]=1;
              ends[43]=1;
              tdone[43]=1;
            }
            else {
              S6452=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 806, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 806, column: 5
              active[43]=1;
              ends[43]=1;
              tdone[43]=1;
            }
            break;
          
          case 1 : 
            switch(S6452){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 801, column: 11
                  b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 797, column: 4
                  S6431=0;
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 803, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_43);//sysj\Orchestrator.sysj line: 803, column: 6
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 807, column: 11
                  b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 797, column: 4
                  S6431=0;
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                else {
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7572(int [] tdone, int [] ends){
        switch(S6430){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        switch(S6257){
          case 0 : 
            S6257=0;
            S6257=1;
            if(b_thread_42 != null){//sysj\Orchestrator.sysj line: 780, column: 8
              S6278=0;
              id_thread_42 = b_thread_42.ID;//sysj\Orchestrator.sysj line: 781, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 783, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_42);//sysj\Orchestrator.sysj line: 783, column: 6
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 784, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_42);//sysj\Orchestrator.sysj line: 784, column: 6
              active[42]=1;
              ends[42]=1;
              tdone[42]=1;
            }
            else {
              S6278=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 787, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 787, column: 5
              active[42]=1;
              ends[42]=1;
              tdone[42]=1;
            }
            break;
          
          case 1 : 
            switch(S6278){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 782, column: 11
                  b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 778, column: 4
                  S6257=0;
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 784, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_42);//sysj\Orchestrator.sysj line: 784, column: 6
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 788, column: 11
                  b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 778, column: 4
                  S6257=0;
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                else {
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7571(int [] tdone, int [] ends){
        switch(S6256){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        switch(S6083){
          case 0 : 
            S6083=0;
            S6083=1;
            if(b_thread_41 != null){//sysj\Orchestrator.sysj line: 760, column: 8
              S6104=0;
              id_thread_41 = b_thread_41.ID;//sysj\Orchestrator.sysj line: 761, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 763, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_41);//sysj\Orchestrator.sysj line: 763, column: 6
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 764, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_41);//sysj\Orchestrator.sysj line: 764, column: 6
              active[41]=1;
              ends[41]=1;
              tdone[41]=1;
            }
            else {
              S6104=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 767, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 767, column: 5
              active[41]=1;
              ends[41]=1;
              tdone[41]=1;
            }
            break;
          
          case 1 : 
            switch(S6104){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 762, column: 11
                  b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 758, column: 4
                  S6083=0;
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 764, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_41);//sysj\Orchestrator.sysj line: 764, column: 6
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 768, column: 11
                  b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 758, column: 4
                  S6083=0;
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                else {
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7570(int [] tdone, int [] ends){
        switch(S6082){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        switch(S5909){
          case 0 : 
            S5909=0;
            S5909=1;
            if(b_thread_40 != null){//sysj\Orchestrator.sysj line: 737, column: 8
              S5930=0;
              id_thread_40 = b_thread_40.ID;//sysj\Orchestrator.sysj line: 738, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 740, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_40);//sysj\Orchestrator.sysj line: 740, column: 6
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 742, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 742, column: 7
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 743, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 743, column: 7
              active[40]=1;
              ends[40]=1;
              tdone[40]=1;
            }
            else {
              S5930=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 748, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 748, column: 5
              active[40]=1;
              ends[40]=1;
              tdone[40]=1;
            }
            break;
          
          case 1 : 
            switch(S5930){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 739, column: 11
                  b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 735, column: 4
                  S5909=0;
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 742, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 742, column: 7
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 743, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 743, column: 7
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 749, column: 11
                  b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 735, column: 4
                  S5909=0;
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                else {
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7569(int [] tdone, int [] ends){
        switch(S5908){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        switch(S5735){
          case 0 : 
            S5735=0;
            S5735=1;
            if(b_thread_39 != null){//sysj\Orchestrator.sysj line: 718, column: 8
              S5756=0;
              id_thread_39 = b_thread_39.ID;//sysj\Orchestrator.sysj line: 719, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 721, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_39);//sysj\Orchestrator.sysj line: 721, column: 6
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 722, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_39);//sysj\Orchestrator.sysj line: 722, column: 6
              active[39]=1;
              ends[39]=1;
              tdone[39]=1;
            }
            else {
              S5756=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 725, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 725, column: 5
              active[39]=1;
              ends[39]=1;
              tdone[39]=1;
            }
            break;
          
          case 1 : 
            switch(S5756){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 720, column: 11
                  b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 716, column: 4
                  S5735=0;
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 722, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_39);//sysj\Orchestrator.sysj line: 722, column: 6
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 726, column: 11
                  b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 716, column: 4
                  S5735=0;
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                else {
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7568(int [] tdone, int [] ends){
        switch(S5734){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        switch(S5716){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 697, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 699, column: 4
              currsigs.addElement(startCapLoading);
              S5716=1;
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            else {
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            break;
          
          case 1 : 
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 700, column: 10
              S5716=2;
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            else {
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            break;
          
          case 2 : 
            S5716=2;
            S5716=3;
            active[38]=1;
            ends[38]=1;
            tdone[38]=1;
            break;
          
          case 3 : 
            S5716=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 703, column: 4
            currsigs.addElement(capLoaderFinish_1);
            S5716=4;
            active[38]=1;
            ends[38]=1;
            tdone[38]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 705, column: 10
              S5716=0;
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            else {
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7567(int [] tdone, int [] ends){
        switch(S5714){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        switch(S5696){
          case 0 : 
            if(startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 680, column: 10
              startCapping.setPresent();//sysj\Orchestrator.sysj line: 682, column: 4
              currsigs.addElement(startCapping);
              S5696=1;
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            else {
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            break;
          
          case 1 : 
            if(capped.getprestatus()){//sysj\Orchestrator.sysj line: 683, column: 10
              S5696=2;
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            else {
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            break;
          
          case 2 : 
            S5696=2;
            S5696=3;
            active[37]=1;
            ends[37]=1;
            tdone[37]=1;
            break;
          
          case 3 : 
            S5696=3;
            capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 686, column: 4
            currsigs.addElement(capperFinish_1);
            S5696=4;
            active[37]=1;
            ends[37]=1;
            tdone[37]=1;
            break;
          
          case 4 : 
            if(!startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 688, column: 10
              S5696=0;
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            else {
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7566(int [] tdone, int [] ends){
        switch(S5694){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        switch(S5676){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 663, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 665, column: 4
              currsigs.addElement(startFilling);
              S5676=1;
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            else {
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            break;
          
          case 1 : 
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 666, column: 10
              S5676=2;
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            else {
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            break;
          
          case 2 : 
            S5676=2;
            S5676=3;
            active[36]=1;
            ends[36]=1;
            tdone[36]=1;
            break;
          
          case 3 : 
            S5676=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 669, column: 4
            currsigs.addElement(fillerFinish_1);
            S5676=4;
            active[36]=1;
            ends[36]=1;
            tdone[36]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 671, column: 10
              S5676=0;
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            else {
              active[36]=1;
              ends[36]=1;
              tdone[36]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7565(int [] tdone, int [] ends){
        switch(S5674){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        switch(S5650){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 642, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 644, column: 4
              currsigs.addElement(startBottleUnloading);
              S5650=1;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            else {
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            break;
          
          case 1 : 
            if(bottleUnloaded.getprestatus()){//sysj\Orchestrator.sysj line: 645, column: 10
              bSeven_thread_35 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 646, column: 4
              S5650=2;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            else {
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            break;
          
          case 2 : 
            S5650=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 648, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 648, column: 4
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 649, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_35);//sysj\Orchestrator.sysj line: 649, column: 4
            S5650=3;
            active[35]=1;
            ends[35]=1;
            tdone[35]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 650, column: 10
              S5650=4;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            else {
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            break;
          
          case 4 : 
            S5650=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 652, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            S5650=5;
            active[35]=1;
            ends[35]=1;
            tdone[35]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 653, column: 10
              S5650=0;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            else {
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7564(int [] tdone, int [] ends){
        switch(S5648){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S5630){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 611, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 614, column: 4
              currsigs.addElement(startRotTable);
              S5630=1;
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
          
          case 1 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 615, column: 10
              bOne_thread_34 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 616, column: 4
              bTwo_thread_34 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 617, column: 4
              bThree_thread_34 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 618, column: 4
              bFour_thread_34 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 619, column: 4
              bFive_thread_34 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 620, column: 4
              bSix_thread_34 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 621, column: 4
              S5630=2;
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
          
          case 2 : 
            S5630=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 623, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_34);//sysj\Orchestrator.sysj line: 623, column: 4
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 624, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_34);//sysj\Orchestrator.sysj line: 624, column: 4
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 625, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_34);//sysj\Orchestrator.sysj line: 625, column: 4
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 626, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_34);//sysj\Orchestrator.sysj line: 626, column: 4
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 627, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_34);//sysj\Orchestrator.sysj line: 627, column: 4
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 628, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_34);//sysj\Orchestrator.sysj line: 628, column: 4
            S5630=3;
            active[34]=1;
            ends[34]=1;
            tdone[34]=1;
            break;
          
          case 3 : 
            S5630=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 631, column: 4
            currsigs.addElement(rotTableFinish_1);
            S5630=4;
            active[34]=1;
            ends[34]=1;
            tdone[34]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 632, column: 10
              S5630=0;
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
  }

  public void thread7563(int [] tdone, int [] ends){
        switch(S5628){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S5610){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 584, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 587, column: 4
              currsigs.addElement(startConveyor);
              S5610=1;
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
          
          case 1 : 
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 588, column: 10
              bZero_thread_33 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 590, column: 4
              bFive_thread_33 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 591, column: 4
              S5610=2;
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
          
          case 2 : 
            S5610=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 594, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 594, column: 4
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 595, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 595, column: 4
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 596, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_33);//sysj\Orchestrator.sysj line: 596, column: 4
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 597, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_33);//sysj\Orchestrator.sysj line: 597, column: 4
            S5610=3;
            active[33]=1;
            ends[33]=1;
            tdone[33]=1;
            break;
          
          case 3 : 
            S5610=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 600, column: 4
            currsigs.addElement(conveyorFinish_1);
            S5610=4;
            active[33]=1;
            ends[33]=1;
            tdone[33]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 601, column: 10
              S5610=0;
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
  }

  public void thread7562(int [] tdone, int [] ends){
        switch(S5608){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S5584){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 559, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 561, column: 4
              currsigs.addElement(startBottleLoading);
              S5584=1;
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
          
          case 1 : 
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 562, column: 10
              bEight_thread_32 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 564, column: 4
              S5584=2;
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
          
          case 2 : 
            S5584=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 566, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 566, column: 4
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 567, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_32);//sysj\Orchestrator.sysj line: 567, column: 4
            S5584=3;
            active[32]=1;
            ends[32]=1;
            tdone[32]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 569, column: 10
              S5584=4;
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
          
          case 4 : 
            S5584=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 572, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            S5584=5;
            active[32]=1;
            ends[32]=1;
            tdone[32]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 573, column: 10
              S5584=0;
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
  }

  public void thread7561(int [] tdone, int [] ends){
        switch(S5582){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S5544){
          case 0 : 
            if(checkCapper_1.getprestatus()){//sysj\Orchestrator.sysj line: 539, column: 10
              S5544=1;
              if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 540, column: 12
                S5538=0;
                b_thread_31 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 541, column: 5
                if(!b_thread_31.isCapped){//sysj\Orchestrator.sysj line: 542, column: 8
                  startCapperThread_1.setPresent();//sysj\Orchestrator.sysj line: 543, column: 6
                  currsigs.addElement(startCapperThread_1);
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 545, column: 6
                  currsigs.addElement(capperFinish_1);
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
              }
              else {
                S5538=1;
                active[31]=1;
                ends[31]=1;
                tdone[31]=1;
              }
            }
            else {
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
          case 1 : 
            switch(S5538){
              case 0 : 
                S5544=0;
                active[31]=1;
                ends[31]=1;
                tdone[31]=1;
                break;
              
              case 1 : 
                capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 550, column: 4
                currsigs.addElement(capperFinish_1);
                S5544=0;
                active[31]=1;
                ends[31]=1;
                tdone[31]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7560(int [] tdone, int [] ends){
        switch(S5532){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S5494){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 519, column: 10
              S5494=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 520, column: 12
                S5488=0;
                b_thread_30 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 521, column: 5
                if(!b_thread_30.isCapOn && !b_thread_30.isCapped){//sysj\Orchestrator.sysj line: 522, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 523, column: 6
                  currsigs.addElement(startCapLoaderThread_1);
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 525, column: 6
                  currsigs.addElement(capLoaderFinish_1);
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
              }
              else {
                S5488=1;
                active[30]=1;
                ends[30]=1;
                tdone[30]=1;
              }
            }
            else {
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
          case 1 : 
            switch(S5488){
              case 0 : 
                S5494=0;
                active[30]=1;
                ends[30]=1;
                tdone[30]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 530, column: 5
                currsigs.addElement(capLoaderFinish_1);
                S5494=0;
                active[30]=1;
                ends[30]=1;
                tdone[30]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7559(int [] tdone, int [] ends){
        switch(S5482){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S5444){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 499, column: 10
              S5444=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 500, column: 12
                S5438=0;
                b_thread_29 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 501, column: 5
                if(!b_thread_29.isFilled){//sysj\Orchestrator.sysj line: 502, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 503, column: 6
                  currsigs.addElement(startFillerThread_1);
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 505, column: 6
                  currsigs.addElement(fillerFinish_1);
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
              }
              else {
                S5438=1;
                active[29]=1;
                ends[29]=1;
                tdone[29]=1;
              }
            }
            else {
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
          case 1 : 
            switch(S5438){
              case 0 : 
                S5444=0;
                active[29]=1;
                ends[29]=1;
                tdone[29]=1;
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 510, column: 5
                currsigs.addElement(fillerFinish_1);
                S5444=0;
                active[29]=1;
                ends[29]=1;
                tdone[29]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7558(int [] tdone, int [] ends){
        switch(S5432){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S5406){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 484, column: 10
              S5406=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 485, column: 12
                S5402=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 486, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
              }
              else {
                S5402=1;
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
              }
            }
            else {
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
          case 1 : 
            switch(S5402){
              case 0 : 
                S5406=0;
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 490, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                S5406=0;
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7557(int [] tdone, int [] ends){
        switch(S5398){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S5372){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 467, column: 10
              S5372=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 469, column: 12
                S5368=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 470, column: 5
                currsigs.addElement(startRotThread_1);
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
              else {
                S5368=1;
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 1 : 
            switch(S5368){
              case 0 : 
                S5372=0;
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 474, column: 5
                currsigs.addElement(rotTableFinish_1);
                S5372=0;
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7556(int [] tdone, int [] ends){
        switch(S5364){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S5338){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 452, column: 10
              S5338=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 453, column: 12
                S5334=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 454, column: 5
                currsigs.addElement(startConveyorThread_1);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S5334=1;
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 1 : 
            switch(S5334){
              case 0 : 
                S5338=0;
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 458, column: 5
                currsigs.addElement(conveyorFinish_1);
                S5338=0;
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7555(int [] tdone, int [] ends){
        switch(S5330){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S5304){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 437, column: 10
              S5304=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 438, column: 12
                S5300=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 439, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S5300=1;
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
            }
            else {
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S5300){
              case 0 : 
                S5304=0;
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 443, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                S5304=0;
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7554(int [] tdone, int [] ends){
        switch(S5296){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(bottlePos9.getprestatus()){//sysj\Orchestrator.sysj line: 415, column: 13
          b_thread_24 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 416, column: 6
          if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 417, column: 10
            faulty_thread_24 = b_thread_24.Faulty;//sysj\Orchestrator.sysj line: 418, column: 7
            if(faulty_thread_24){//sysj\Orchestrator.sysj line: 419, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 420, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(9);//sysj\Orchestrator.sysj line: 420, column: 8
              id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 421, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 422, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 422, column: 8
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
          }
          else {
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
          }
        }
        else {
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        break;
      
    }
  }

  public void thread7553(int [] tdone, int [] ends){
        switch(S5246){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 393, column: 13
          b_thread_23 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 394, column: 6
          if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 395, column: 10
            faulty_thread_23 = b_thread_23.Faulty;//sysj\Orchestrator.sysj line: 396, column: 7
            if(faulty_thread_23){//sysj\Orchestrator.sysj line: 397, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 398, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(8);//sysj\Orchestrator.sysj line: 398, column: 8
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 399, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 400, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 400, column: 8
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
          }
          else {
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
          }
        }
        else {
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        break;
      
    }
  }

  public void thread7552(int [] tdone, int [] ends){
        switch(S5196){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        if(pauseFaultCheck_1.getprestatus()){//sysj\Orchestrator.sysj line: 370, column: 10
          if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 13
            b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 6
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 373, column: 10
              faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 374, column: 7
              if(faulty_thread_22){//sysj\Orchestrator.sysj line: 375, column: 7
                fault_1.setPresent();//sysj\Orchestrator.sysj line: 376, column: 8
                currsigs.addElement(fault_1);
                fault_1.setValue(7);//sysj\Orchestrator.sysj line: 376, column: 8
                id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 377, column: 8
                faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 378, column: 8
                currsigs.addElement(faultUpdate);
                faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 378, column: 8
                S5129=0;
                active[22]=1;
                ends[22]=1;
                tdone[22]=1;
              }
              else {
                S5129=0;
                active[22]=1;
                ends[22]=1;
                tdone[22]=1;
              }
            }
            else {
              S5129=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
          }
          else {
            S5129=0;
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
          }
        }
        else {
          switch(S5129){
            case 0 : 
              S5129=0;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 13
                b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 6
                if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 373, column: 10
                  faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 374, column: 7
                  if(faulty_thread_22){//sysj\Orchestrator.sysj line: 375, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 376, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(7);//sysj\Orchestrator.sysj line: 376, column: 8
                    id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 377, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 378, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 378, column: 8
                    S5129=0;
                    active[22]=1;
                    ends[22]=1;
                    tdone[22]=1;
                  }
                  else {
                    S5129=0;
                    active[22]=1;
                    ends[22]=1;
                    tdone[22]=1;
                  }
                }
                else {
                  S5129=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
              }
              else {
                S5129=0;
                active[22]=1;
                ends[22]=1;
                tdone[22]=1;
              }
              break;
            
            case 1 : 
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 13
                b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 6
                if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 373, column: 10
                  faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 374, column: 7
                  if(faulty_thread_22){//sysj\Orchestrator.sysj line: 375, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 376, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(7);//sysj\Orchestrator.sysj line: 376, column: 8
                    id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 377, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 378, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 378, column: 8
                    S5129=0;
                    active[22]=1;
                    ends[22]=1;
                    tdone[22]=1;
                  }
                  else {
                    S5129=0;
                    active[22]=1;
                    ends[22]=1;
                    tdone[22]=1;
                  }
                }
                else {
                  S5129=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
              }
              else {
                S5129=0;
                active[22]=1;
                ends[22]=1;
                tdone[22]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread7551(int [] tdone, int [] ends){
        switch(S5114){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        if(pauseFaultCheck_1.getprestatus()){//sysj\Orchestrator.sysj line: 348, column: 10
          if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 349, column: 13
            b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 350, column: 6
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 351, column: 10
              faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 352, column: 7
              if(faulty_thread_21){//sysj\Orchestrator.sysj line: 353, column: 7
                fault_1.setPresent();//sysj\Orchestrator.sysj line: 354, column: 8
                currsigs.addElement(fault_1);
                fault_1.setValue(6);//sysj\Orchestrator.sysj line: 354, column: 8
                id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 355, column: 8
                faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 356, column: 8
                currsigs.addElement(faultUpdate);
                faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 356, column: 8
                S5047=0;
                active[21]=1;
                ends[21]=1;
                tdone[21]=1;
              }
              else {
                S5047=0;
                active[21]=1;
                ends[21]=1;
                tdone[21]=1;
              }
            }
            else {
              S5047=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
          }
          else {
            S5047=0;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
        }
        else {
          switch(S5047){
            case 0 : 
              S5047=0;
              if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 349, column: 13
                b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 350, column: 6
                if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 351, column: 10
                  faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 352, column: 7
                  if(faulty_thread_21){//sysj\Orchestrator.sysj line: 353, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 354, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(6);//sysj\Orchestrator.sysj line: 354, column: 8
                    id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 355, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 356, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 356, column: 8
                    S5047=0;
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S5047=0;
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                }
                else {
                  S5047=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
              }
              else {
                S5047=0;
                active[21]=1;
                ends[21]=1;
                tdone[21]=1;
              }
              break;
            
            case 1 : 
              if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 349, column: 13
                b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 350, column: 6
                if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 351, column: 10
                  faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 352, column: 7
                  if(faulty_thread_21){//sysj\Orchestrator.sysj line: 353, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 354, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(6);//sysj\Orchestrator.sysj line: 354, column: 8
                    id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 355, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 356, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 356, column: 8
                    S5047=0;
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S5047=0;
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                }
                else {
                  S5047=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
              }
              else {
                S5047=0;
                active[21]=1;
                ends[21]=1;
                tdone[21]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread7550(int [] tdone, int [] ends){
        switch(S5032){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(pauseFaultCheck_1.getprestatus()){//sysj\Orchestrator.sysj line: 325, column: 10
          if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 326, column: 13
            b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 327, column: 6
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 328, column: 10
              faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 329, column: 7
              if(faulty_thread_20){//sysj\Orchestrator.sysj line: 330, column: 7
                fault_1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 8
                currsigs.addElement(fault_1);
                fault_1.setValue(5);//sysj\Orchestrator.sysj line: 331, column: 8
                id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 332, column: 8
                faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 333, column: 8
                currsigs.addElement(faultUpdate);
                faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 333, column: 8
                S4965=0;
                active[20]=1;
                ends[20]=1;
                tdone[20]=1;
              }
              else {
                S4965=0;
                active[20]=1;
                ends[20]=1;
                tdone[20]=1;
              }
            }
            else {
              S4965=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
          }
          else {
            S4965=0;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
          }
        }
        else {
          switch(S4965){
            case 0 : 
              S4965=0;
              if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 326, column: 13
                b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 327, column: 6
                if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 328, column: 10
                  faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 329, column: 7
                  if(faulty_thread_20){//sysj\Orchestrator.sysj line: 330, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(5);//sysj\Orchestrator.sysj line: 331, column: 8
                    id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 332, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 333, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 333, column: 8
                    S4965=0;
                    active[20]=1;
                    ends[20]=1;
                    tdone[20]=1;
                  }
                  else {
                    S4965=0;
                    active[20]=1;
                    ends[20]=1;
                    tdone[20]=1;
                  }
                }
                else {
                  S4965=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
              }
              else {
                S4965=0;
                active[20]=1;
                ends[20]=1;
                tdone[20]=1;
              }
              break;
            
            case 1 : 
              if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 326, column: 13
                b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 327, column: 6
                if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 328, column: 10
                  faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 329, column: 7
                  if(faulty_thread_20){//sysj\Orchestrator.sysj line: 330, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(5);//sysj\Orchestrator.sysj line: 331, column: 8
                    id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 332, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 333, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 333, column: 8
                    S4965=0;
                    active[20]=1;
                    ends[20]=1;
                    tdone[20]=1;
                  }
                  else {
                    S4965=0;
                    active[20]=1;
                    ends[20]=1;
                    tdone[20]=1;
                  }
                }
                else {
                  S4965=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
              }
              else {
                S4965=0;
                active[20]=1;
                ends[20]=1;
                tdone[20]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread7549(int [] tdone, int [] ends){
        switch(S4950){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 13
          b_thread_19 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 6
          if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 306, column: 10
            faulty_thread_19 = b_thread_19.Faulty;//sysj\Orchestrator.sysj line: 307, column: 7
            if(faulty_thread_19){//sysj\Orchestrator.sysj line: 308, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 309, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(4);//sysj\Orchestrator.sysj line: 309, column: 8
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 310, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 311, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 311, column: 8
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
          }
          else {
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
          }
        }
        else {
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
        break;
      
    }
  }

  public void thread7548(int [] tdone, int [] ends){
        switch(S4900){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 282, column: 13
          b_thread_18 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 283, column: 6
          if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 284, column: 10
            faulty_thread_18 = b_thread_18.Faulty;//sysj\Orchestrator.sysj line: 285, column: 7
            if(faulty_thread_18){//sysj\Orchestrator.sysj line: 286, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 287, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(3);//sysj\Orchestrator.sysj line: 287, column: 8
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 288, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 289, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 289, column: 8
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
          }
          else {
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
          }
        }
        else {
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        break;
      
    }
  }

  public void thread7547(int [] tdone, int [] ends){
        switch(S4850){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 260, column: 13
          b_thread_17 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 261, column: 6
          if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 262, column: 10
            faulty_thread_17 = b_thread_17.Faulty;//sysj\Orchestrator.sysj line: 263, column: 7
            if(faulty_thread_17){//sysj\Orchestrator.sysj line: 264, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 265, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(2);//sysj\Orchestrator.sysj line: 265, column: 8
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 266, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 267, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 267, column: 8
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
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
        }
        else {
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        break;
      
    }
  }

  public void thread7546(int [] tdone, int [] ends){
        switch(S4800){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 13
          b_thread_16 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 6
          if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 239, column: 10
            faulty_thread_16 = b_thread_16.Faulty;//sysj\Orchestrator.sysj line: 240, column: 7
            if(faulty_thread_16){//sysj\Orchestrator.sysj line: 241, column: 7
              fault_1.setPresent();//sysj\Orchestrator.sysj line: 242, column: 8
              currsigs.addElement(fault_1);
              fault_1.setValue(1);//sysj\Orchestrator.sysj line: 242, column: 8
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 243, column: 8
              faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 244, column: 8
              currsigs.addElement(faultUpdate);
              faultUpdate.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 244, column: 8
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
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
        }
        else {
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread7545(int [] tdone, int [] ends){
        switch(S4750){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(pauseFaultCheck_1.getprestatus()){//sysj\Orchestrator.sysj line: 216, column: 10
          if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 13
            b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 6
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 219, column: 10
              faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 220, column: 7
              if(faulty_thread_15){//sysj\Orchestrator.sysj line: 221, column: 7
                fault_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 8
                currsigs.addElement(fault_1);
                fault_1.setValue(0);//sysj\Orchestrator.sysj line: 222, column: 8
                id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 223, column: 8
                faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 224, column: 8
                currsigs.addElement(faultUpdate);
                faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 224, column: 8
                S4683=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S4683=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S4683=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
          }
          else {
            S4683=0;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
          }
        }
        else {
          switch(S4683){
            case 0 : 
              S4683=0;
              if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 13
                b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 6
                if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 219, column: 10
                  faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 220, column: 7
                  if(faulty_thread_15){//sysj\Orchestrator.sysj line: 221, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(0);//sysj\Orchestrator.sysj line: 222, column: 8
                    id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 223, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 224, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 224, column: 8
                    S4683=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S4683=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                else {
                  S4683=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S4683=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              break;
            
            case 1 : 
              if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 13
                b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 6
                if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 219, column: 10
                  faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 220, column: 7
                  if(faulty_thread_15){//sysj\Orchestrator.sysj line: 221, column: 7
                    fault_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 8
                    currsigs.addElement(fault_1);
                    fault_1.setValue(0);//sysj\Orchestrator.sysj line: 222, column: 8
                    id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 223, column: 8
                    faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 224, column: 8
                    currsigs.addElement(faultUpdate);
                    faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 224, column: 8
                    S4683=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S4683=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                else {
                  S4683=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S4683=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread7543(int [] tdone, int [] ends){
        switch(S4139){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4138){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 182, column: 12
              S4138=1;
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
            S4138=1;
            S4138=2;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 2 : 
            S4138=2;
            S4139=0;
            active[14]=0;
            ends[14]=0;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7542(int [] tdone, int [] ends){
        switch(S4135){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S4134){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 174, column: 12
              S4134=1;
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
            S4134=1;
            S4134=2;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 2 : 
            S4134=2;
            S4135=0;
            active[13]=0;
            ends[13]=0;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7540(int [] tdone, int [] ends){
        S4139=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 181, column: 6
    currsigs.addElement(checkRobotUnloader_1);
    S4138=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread7539(int [] tdone, int [] ends){
        S4135=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 173, column: 6
    currsigs.addElement(checkRobotLoader_1);
    S4134=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread7537(int [] tdone, int [] ends){
        switch(S4105){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4104){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 153, column: 12
              S4104=1;
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
            S4104=1;
            S4104=2;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            S4104=2;
            S4105=0;
            active[12]=0;
            ends[12]=0;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7536(int [] tdone, int [] ends){
        switch(S4101){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4100){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 146, column: 12
              S4100=1;
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
            S4100=1;
            S4100=2;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            S4100=2;
            S4101=0;
            active[11]=0;
            ends[11]=0;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7535(int [] tdone, int [] ends){
        switch(S4097){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4096){
          case 0 : 
            if(capperFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 138, column: 12
              S4096=1;
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
            S4096=1;
            S4096=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S4096=2;
            S4097=0;
            active[10]=0;
            ends[10]=0;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7534(int [] tdone, int [] ends){
        switch(S4093){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4092){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 130, column: 12
              S4092=1;
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
            S4092=1;
            S4092=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S4092=2;
            S4093=0;
            active[9]=0;
            ends[9]=0;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7533(int [] tdone, int [] ends){
        switch(S4089){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4088){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 122, column: 12
              S4088=1;
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
            S4088=1;
            S4088=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S4088=2;
            S4089=0;
            active[8]=0;
            ends[8]=0;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7531(int [] tdone, int [] ends){
        S4105=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 152, column: 6
    currsigs.addElement(checkRobotUnloader_1);
    S4104=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread7530(int [] tdone, int [] ends){
        S4101=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 145, column: 6
    currsigs.addElement(checkRobotLoader_1);
    S4100=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread7529(int [] tdone, int [] ends){
        S4097=1;
    checkCapper_1.setPresent();//sysj\Orchestrator.sysj line: 137, column: 6
    currsigs.addElement(checkCapper_1);
    S4096=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread7528(int [] tdone, int [] ends){
        S4093=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 129, column: 6
    currsigs.addElement(checkFiller_1);
    S4092=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread7527(int [] tdone, int [] ends){
        S4089=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 121, column: 6
    currsigs.addElement(checkCapLoader_1);
    S4088=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7526(int [] tdone, int [] ends){
        switch(S4668){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(stop_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 10
          addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
          currsigs.addElement(addFault_1);
          S4079=0;
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          switch(S4079){
            case 0 : 
              S4079=0;
              S4079=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 1 : 
              S4079=1;
              if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 109, column: 13
                pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 110, column: 6
                stop_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 6
                currsigs.addElement(stop_1);
                stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 111, column: 6
                S4079=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4079=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 2 : 
              S4079=2;
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 115, column: 5
              currsigs.addElement(checkConveyor_1);
              S4079=3;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 3 : 
              if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 116, column: 11
                S4079=4;
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
            
            case 4 : 
              S4079=4;
              S4079=5;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 5 : 
              S4079=5;
              S4079=6;
              thread7527(tdone,ends);
              thread7528(tdone,ends);
              thread7529(tdone,ends);
              thread7530(tdone,ends);
              thread7531(tdone,ends);
              int biggest7532 = 0;
              if(ends[8]>=biggest7532){
                biggest7532=ends[8];
              }
              if(ends[9]>=biggest7532){
                biggest7532=ends[9];
              }
              if(ends[10]>=biggest7532){
                biggest7532=ends[10];
              }
              if(ends[11]>=biggest7532){
                biggest7532=ends[11];
              }
              if(ends[12]>=biggest7532){
                biggest7532=ends[12];
              }
              if(biggest7532 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 6 : 
              thread7533(tdone,ends);
              thread7534(tdone,ends);
              thread7535(tdone,ends);
              thread7536(tdone,ends);
              thread7537(tdone,ends);
              int biggest7538 = 0;
              if(ends[8]>=biggest7538){
                biggest7538=ends[8];
              }
              if(ends[9]>=biggest7538){
                biggest7538=ends[9];
              }
              if(ends[10]>=biggest7538){
                biggest7538=ends[10];
              }
              if(ends[11]>=biggest7538){
                biggest7538=ends[11];
              }
              if(ends[12]>=biggest7538){
                biggest7538=ends[12];
              }
              if(biggest7538 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              //FINXME code
              if(biggest7538 == 0){
                addFault_1.setPresent();//sysj\Orchestrator.sysj line: 158, column: 5
                currsigs.addElement(addFault_1);
                S4079=7;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 7 : 
              S4079=7;
              S4079=8;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 8 : 
              S4079=8;
              if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 161, column: 13
                pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 162, column: 6
                stop_1.setPresent();//sysj\Orchestrator.sysj line: 163, column: 6
                currsigs.addElement(stop_1);
                stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 163, column: 6
                S4079=9;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4079=9;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 9 : 
              S4079=9;
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 167, column: 5
              currsigs.addElement(checkConveyor_1);
              S4079=10;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 10 : 
              if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 168, column: 11
                S4079=11;
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
            
            case 11 : 
              S4079=11;
              S4079=12;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 12 : 
              S4079=12;
              S4079=13;
              thread7539(tdone,ends);
              thread7540(tdone,ends);
              int biggest7541 = 0;
              if(ends[13]>=biggest7541){
                biggest7541=ends[13];
              }
              if(ends[14]>=biggest7541){
                biggest7541=ends[14];
              }
              if(biggest7541 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 13 : 
              thread7542(tdone,ends);
              thread7543(tdone,ends);
              int biggest7544 = 0;
              if(ends[13]>=biggest7544){
                biggest7544=ends[13];
              }
              if(ends[14]>=biggest7544){
                biggest7544=ends[14];
              }
              if(biggest7544 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              //FINXME code
              if(biggest7544 == 0){
                addFault_1.setPresent();//sysj\Orchestrator.sysj line: 186, column: 5
                currsigs.addElement(addFault_1);
                S4079=14;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 14 : 
              S4079=14;
              S4079=15;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 15 : 
              S4079=15;
              if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 190, column: 13
                pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 191, column: 6
                stop_1.setPresent();//sysj\Orchestrator.sysj line: 192, column: 6
                currsigs.addElement(stop_1);
                stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 192, column: 6
                S4079=16;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S4079=16;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 16 : 
              S4079=16;
              S4079=17;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 17 : 
              if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 196, column: 11
                S4079=18;
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
            
            case 18 : 
              if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 197, column: 11
                checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 199, column: 5
                currsigs.addElement(checkRotTable_1);
                S4079=19;
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
            
            case 19 : 
              if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 200, column: 11
                S4079=20;
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
            
            case 20 : 
              S4079=20;
              S4079=21;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 21 : 
              S4079=21;
              S4079=22;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 22 : 
              if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 204, column: 11
                S4079=23;
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
            
            case 23 : 
              if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 205, column: 11
                addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
                currsigs.addElement(addFault_1);
                S4079=0;
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
            
            case 24 : 
              addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
              currsigs.addElement(addFault_1);
              S4079=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 25 : 
              addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
              currsigs.addElement(addFault_1);
              S4079=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 26 : 
              addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
              currsigs.addElement(addFault_1);
              S4079=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread7525(int [] tdone, int [] ends){
        switch(S4078){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4022){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 74, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 75, column: 7
              b_thread_6 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 76, column: 4
              S4022=1;
              if(b_thread_6 != null){//sysj\Orchestrator.sysj line: 78, column: 7
                ID_thread_6 = b_thread_6.ID;//sysj\Orchestrator.sysj line: 79, column: 5
                name_thread_6 = b_thread_6.name;//sysj\Orchestrator.sysj line: 80, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_6);//sysj\Orchestrator.sysj line: 81, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_6);//sysj\Orchestrator.sysj line: 82, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_6);//sysj\Orchestrator.sysj line: 83, column: 8
                posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 84, column: 5
                currsigs.addElement(posEightUpdate_1);
                posEightUpdate_1.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 84, column: 5
                S4023=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S4022=0;
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
            switch(S4023){
              case 0 : 
                S4023=0;
                S4023=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                S4023=1;
                S4023=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 87, column: 11
                  S4023=3;
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
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 91, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 92, column: 5
                  currsigs.addElement(recieveTwin);
                  S4022=0;
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
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7524(int [] tdone, int [] ends){
        switch(S4020){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3914){
          case 0 : 
            if(introduceFault.getprestatus()){//sysj\Orchestrator.sysj line: 52, column: 10
              S3914=1;
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
            if(addFault_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              location_thread_5 = (int)(introduceFault.getpreval() == null ? 0 : ((Integer)introduceFault.getpreval()).intValue());//sysj\Orchestrator.sysj line: 54, column: 4
              if(location_thread_5 == 1){//sysj\Orchestrator.sysj line: 55, column: 7
                if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 56, column: 13
                  b_thread_5 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 57, column: 6
                  if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 58, column: 10
                    b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 59, column: 7
                    posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 60, column: 7
                    currsigs.addElement(posOneUpdate_1);
                    posOneUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 60, column: 7
                    S3914=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    S3914=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                }
                else {
                  S3914=0;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                S3914=0;
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

  public void thread7522(int [] tdone, int [] ends){
        switch(S3894){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3887){
          case 0 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 36, column: 10
              S3887=1;
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 37, column: 10
              S3887=2;
              if(location_thread_4 == 1){//sysj\Orchestrator.sysj line: 38, column: 7
                posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 39, column: 5
                currsigs.addElement(posOneUpdate_1);
                posOneUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 39, column: 5
                faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 42, column: 4
                currsigs.addElement(faultSolved_1);
                S3894=0;
                active[4]=0;
                ends[4]=0;
                tdone[4]=1;
              }
              else {
                faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 42, column: 4
                currsigs.addElement(faultSolved_1);
                S3894=0;
                active[4]=0;
                ends[4]=0;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            switch(S3892){
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7521(int [] tdone, int [] ends){
        switch(S3886){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 26, column: 10
          S3886=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          pauseFaultCheck_1.setPresent();//sysj\Orchestrator.sysj line: 27, column: 5
          currsigs.addElement(pauseFaultCheck_1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread7519(int [] tdone, int [] ends){
        S3894=1;
    location_thread_4 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 33, column: 4
    startRemover.setPresent();//sysj\Orchestrator.sysj line: 34, column: 4
    currsigs.addElement(startRemover);
    startRemover.setValue(location_thread_4);//sysj\Orchestrator.sysj line: 34, column: 4
    S3887=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread7518(int [] tdone, int [] ends){
        S3886=1;
    pauseFaultCheck_1.setPresent();//sysj\Orchestrator.sysj line: 27, column: 5
    currsigs.addElement(pauseFaultCheck_1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7517(int [] tdone, int [] ends){
        switch(S3910){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3909){
          case 0 : 
            if(stop_1.getprestatus()){//sysj\Orchestrator.sysj line: 23, column: 9
              S3909=1;
              thread7518(tdone,ends);
              thread7519(tdone,ends);
              int biggest7520 = 0;
              if(ends[3]>=biggest7520){
                biggest7520=ends[3];
              }
              if(ends[4]>=biggest7520){
                biggest7520=ends[4];
              }
              if(biggest7520 == 1){
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
            thread7521(tdone,ends);
            thread7522(tdone,ends);
            int biggest7523 = 0;
            if(ends[3]>=biggest7523){
              biggest7523=ends[3];
            }
            if(ends[4]>=biggest7523){
              biggest7523=ends[4];
            }
            if(biggest7523 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            //FINXME code
            if(biggest7523 == 0){
              S3910=0;
              active[2]=0;
              ends[2]=0;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7515(int [] tdone, int [] ends){
        S7474=1;
    S7301=0;
    active[48]=1;
    ends[48]=1;
    tdone[48]=1;
  }

  public void thread7514(int [] tdone, int [] ends){
        S7300=1;
    b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 873, column: 4
    S7127=0;
    active[47]=1;
    ends[47]=1;
    tdone[47]=1;
  }

  public void thread7513(int [] tdone, int [] ends){
        S7126=1;
    b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 854, column: 4
    S6953=0;
    active[46]=1;
    ends[46]=1;
    tdone[46]=1;
  }

  public void thread7512(int [] tdone, int [] ends){
        S6952=1;
    b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 835, column: 4
    S6779=0;
    active[45]=1;
    ends[45]=1;
    tdone[45]=1;
  }

  public void thread7511(int [] tdone, int [] ends){
        S6778=1;
    b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 816, column: 4
    S6605=0;
    active[44]=1;
    ends[44]=1;
    tdone[44]=1;
  }

  public void thread7510(int [] tdone, int [] ends){
        S6604=1;
    b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 797, column: 4
    S6431=0;
    active[43]=1;
    ends[43]=1;
    tdone[43]=1;
  }

  public void thread7509(int [] tdone, int [] ends){
        S6430=1;
    b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 778, column: 4
    S6257=0;
    active[42]=1;
    ends[42]=1;
    tdone[42]=1;
  }

  public void thread7508(int [] tdone, int [] ends){
        S6256=1;
    b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 758, column: 4
    S6083=0;
    active[41]=1;
    ends[41]=1;
    tdone[41]=1;
  }

  public void thread7507(int [] tdone, int [] ends){
        S6082=1;
    b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 735, column: 4
    S5909=0;
    active[40]=1;
    ends[40]=1;
    tdone[40]=1;
  }

  public void thread7506(int [] tdone, int [] ends){
        S5908=1;
    b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 716, column: 4
    S5735=0;
    active[39]=1;
    ends[39]=1;
    tdone[39]=1;
  }

  public void thread7505(int [] tdone, int [] ends){
        S5734=1;
    S5716=0;
    active[38]=1;
    ends[38]=1;
    tdone[38]=1;
  }

  public void thread7504(int [] tdone, int [] ends){
        S5714=1;
    S5696=0;
    active[37]=1;
    ends[37]=1;
    tdone[37]=1;
  }

  public void thread7503(int [] tdone, int [] ends){
        S5694=1;
    S5676=0;
    active[36]=1;
    ends[36]=1;
    tdone[36]=1;
  }

  public void thread7502(int [] tdone, int [] ends){
        S5674=1;
    S5650=0;
    active[35]=1;
    ends[35]=1;
    tdone[35]=1;
  }

  public void thread7501(int [] tdone, int [] ends){
        S5648=1;
    S5630=0;
    active[34]=1;
    ends[34]=1;
    tdone[34]=1;
  }

  public void thread7500(int [] tdone, int [] ends){
        S5628=1;
    S5610=0;
    active[33]=1;
    ends[33]=1;
    tdone[33]=1;
  }

  public void thread7499(int [] tdone, int [] ends){
        S5608=1;
    S5584=0;
    active[32]=1;
    ends[32]=1;
    tdone[32]=1;
  }

  public void thread7498(int [] tdone, int [] ends){
        S5582=1;
    S5544=0;
    active[31]=1;
    ends[31]=1;
    tdone[31]=1;
  }

  public void thread7497(int [] tdone, int [] ends){
        S5532=1;
    S5494=0;
    active[30]=1;
    ends[30]=1;
    tdone[30]=1;
  }

  public void thread7496(int [] tdone, int [] ends){
        S5482=1;
    S5444=0;
    active[29]=1;
    ends[29]=1;
    tdone[29]=1;
  }

  public void thread7495(int [] tdone, int [] ends){
        S5432=1;
    S5406=0;
    active[28]=1;
    ends[28]=1;
    tdone[28]=1;
  }

  public void thread7494(int [] tdone, int [] ends){
        S5398=1;
    S5372=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread7493(int [] tdone, int [] ends){
        S5364=1;
    S5338=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread7492(int [] tdone, int [] ends){
        S5330=1;
    S5304=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread7491(int [] tdone, int [] ends){
        S5296=1;
    if(bottlePos9.getprestatus()){//sysj\Orchestrator.sysj line: 415, column: 13
      b_thread_24 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 416, column: 6
      if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 417, column: 10
        faulty_thread_24 = b_thread_24.Faulty;//sysj\Orchestrator.sysj line: 418, column: 7
        if(faulty_thread_24){//sysj\Orchestrator.sysj line: 419, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 420, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(9);//sysj\Orchestrator.sysj line: 420, column: 8
          id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 421, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 422, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 422, column: 8
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        else {
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
      }
      else {
        active[24]=1;
        ends[24]=1;
        tdone[24]=1;
      }
    }
    else {
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread7490(int [] tdone, int [] ends){
        S5246=1;
    if(bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 393, column: 13
      b_thread_23 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 394, column: 6
      if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 395, column: 10
        faulty_thread_23 = b_thread_23.Faulty;//sysj\Orchestrator.sysj line: 396, column: 7
        if(faulty_thread_23){//sysj\Orchestrator.sysj line: 397, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 398, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(8);//sysj\Orchestrator.sysj line: 398, column: 8
          id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 399, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 400, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 400, column: 8
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        else {
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
      }
      else {
        active[23]=1;
        ends[23]=1;
        tdone[23]=1;
      }
    }
    else {
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread7489(int [] tdone, int [] ends){
        S5196=1;
    if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 371, column: 13
      b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 6
      if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 373, column: 10
        faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 374, column: 7
        if(faulty_thread_22){//sysj\Orchestrator.sysj line: 375, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 376, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(7);//sysj\Orchestrator.sysj line: 376, column: 8
          id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 377, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 378, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 378, column: 8
          S5129=0;
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        else {
          S5129=0;
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
      }
      else {
        S5129=0;
        active[22]=1;
        ends[22]=1;
        tdone[22]=1;
      }
    }
    else {
      S5129=0;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread7488(int [] tdone, int [] ends){
        S5114=1;
    if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 349, column: 13
      b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 350, column: 6
      if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 351, column: 10
        faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 352, column: 7
        if(faulty_thread_21){//sysj\Orchestrator.sysj line: 353, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 354, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(6);//sysj\Orchestrator.sysj line: 354, column: 8
          id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 355, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 356, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 356, column: 8
          S5047=0;
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S5047=0;
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
      }
      else {
        S5047=0;
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
    }
    else {
      S5047=0;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread7487(int [] tdone, int [] ends){
        S5032=1;
    if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 326, column: 13
      b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 327, column: 6
      if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 328, column: 10
        faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 329, column: 7
        if(faulty_thread_20){//sysj\Orchestrator.sysj line: 330, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 331, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(5);//sysj\Orchestrator.sysj line: 331, column: 8
          id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 332, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 333, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 333, column: 8
          S4965=0;
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        else {
          S4965=0;
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
      }
      else {
        S4965=0;
        active[20]=1;
        ends[20]=1;
        tdone[20]=1;
      }
    }
    else {
      S4965=0;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread7486(int [] tdone, int [] ends){
        S4950=1;
    if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 13
      b_thread_19 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 6
      if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 306, column: 10
        faulty_thread_19 = b_thread_19.Faulty;//sysj\Orchestrator.sysj line: 307, column: 7
        if(faulty_thread_19){//sysj\Orchestrator.sysj line: 308, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 309, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(4);//sysj\Orchestrator.sysj line: 309, column: 8
          id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 310, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 311, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 311, column: 8
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
        else {
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
      }
      else {
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
      }
    }
    else {
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread7485(int [] tdone, int [] ends){
        S4900=1;
    if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 282, column: 13
      b_thread_18 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 283, column: 6
      if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 284, column: 10
        faulty_thread_18 = b_thread_18.Faulty;//sysj\Orchestrator.sysj line: 285, column: 7
        if(faulty_thread_18){//sysj\Orchestrator.sysj line: 286, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 287, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(3);//sysj\Orchestrator.sysj line: 287, column: 8
          id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 288, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 289, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 289, column: 8
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        else {
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
      }
      else {
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
      }
    }
    else {
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread7484(int [] tdone, int [] ends){
        S4850=1;
    if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 260, column: 13
      b_thread_17 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 261, column: 6
      if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 262, column: 10
        faulty_thread_17 = b_thread_17.Faulty;//sysj\Orchestrator.sysj line: 263, column: 7
        if(faulty_thread_17){//sysj\Orchestrator.sysj line: 264, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 265, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(2);//sysj\Orchestrator.sysj line: 265, column: 8
          id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 266, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 267, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 267, column: 8
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        else {
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
    }
    else {
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread7483(int [] tdone, int [] ends){
        S4800=1;
    if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 13
      b_thread_16 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 6
      if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 239, column: 10
        faulty_thread_16 = b_thread_16.Faulty;//sysj\Orchestrator.sysj line: 240, column: 7
        if(faulty_thread_16){//sysj\Orchestrator.sysj line: 241, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 242, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(1);//sysj\Orchestrator.sysj line: 242, column: 8
          id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 243, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 244, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 244, column: 8
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        else {
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
    }
    else {
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread7482(int [] tdone, int [] ends){
        S4750=1;
    if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 217, column: 13
      b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 6
      if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 219, column: 10
        faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 220, column: 7
        if(faulty_thread_15){//sysj\Orchestrator.sysj line: 221, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(0);//sysj\Orchestrator.sysj line: 222, column: 8
          id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 223, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 224, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 224, column: 8
          S4683=0;
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          S4683=0;
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
      }
      else {
        S4683=0;
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
      }
    }
    else {
      S4683=0;
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread7481(int [] tdone, int [] ends){
        S4668=1;
    addFault_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
    currsigs.addElement(addFault_1);
    S4079=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7480(int [] tdone, int [] ends){
        S4078=1;
    S4022=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread7479(int [] tdone, int [] ends){
        S4020=1;
    S3914=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7478(int [] tdone, int [] ends){
        S3910=1;
    S3909=0;
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
      switch(S7476){
        case 0 : 
          S7476=0;
          break RUN;
        
        case 1 : 
          S7476=2;
          S7476=2;
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          fault_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          stop_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          pauseFaultCheck_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          faultSolved_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          addFault_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          thread7478(tdone,ends);
          thread7479(tdone,ends);
          thread7480(tdone,ends);
          thread7481(tdone,ends);
          thread7482(tdone,ends);
          thread7483(tdone,ends);
          thread7484(tdone,ends);
          thread7485(tdone,ends);
          thread7486(tdone,ends);
          thread7487(tdone,ends);
          thread7488(tdone,ends);
          thread7489(tdone,ends);
          thread7490(tdone,ends);
          thread7491(tdone,ends);
          thread7492(tdone,ends);
          thread7493(tdone,ends);
          thread7494(tdone,ends);
          thread7495(tdone,ends);
          thread7496(tdone,ends);
          thread7497(tdone,ends);
          thread7498(tdone,ends);
          thread7499(tdone,ends);
          thread7500(tdone,ends);
          thread7501(tdone,ends);
          thread7502(tdone,ends);
          thread7503(tdone,ends);
          thread7504(tdone,ends);
          thread7505(tdone,ends);
          thread7506(tdone,ends);
          thread7507(tdone,ends);
          thread7508(tdone,ends);
          thread7509(tdone,ends);
          thread7510(tdone,ends);
          thread7511(tdone,ends);
          thread7512(tdone,ends);
          thread7513(tdone,ends);
          thread7514(tdone,ends);
          thread7515(tdone,ends);
          int biggest7516 = 0;
          if(ends[2]>=biggest7516){
            biggest7516=ends[2];
          }
          if(ends[5]>=biggest7516){
            biggest7516=ends[5];
          }
          if(ends[6]>=biggest7516){
            biggest7516=ends[6];
          }
          if(ends[7]>=biggest7516){
            biggest7516=ends[7];
          }
          if(ends[15]>=biggest7516){
            biggest7516=ends[15];
          }
          if(ends[16]>=biggest7516){
            biggest7516=ends[16];
          }
          if(ends[17]>=biggest7516){
            biggest7516=ends[17];
          }
          if(ends[18]>=biggest7516){
            biggest7516=ends[18];
          }
          if(ends[19]>=biggest7516){
            biggest7516=ends[19];
          }
          if(ends[20]>=biggest7516){
            biggest7516=ends[20];
          }
          if(ends[21]>=biggest7516){
            biggest7516=ends[21];
          }
          if(ends[22]>=biggest7516){
            biggest7516=ends[22];
          }
          if(ends[23]>=biggest7516){
            biggest7516=ends[23];
          }
          if(ends[24]>=biggest7516){
            biggest7516=ends[24];
          }
          if(ends[25]>=biggest7516){
            biggest7516=ends[25];
          }
          if(ends[26]>=biggest7516){
            biggest7516=ends[26];
          }
          if(ends[27]>=biggest7516){
            biggest7516=ends[27];
          }
          if(ends[28]>=biggest7516){
            biggest7516=ends[28];
          }
          if(ends[29]>=biggest7516){
            biggest7516=ends[29];
          }
          if(ends[30]>=biggest7516){
            biggest7516=ends[30];
          }
          if(ends[31]>=biggest7516){
            biggest7516=ends[31];
          }
          if(ends[32]>=biggest7516){
            biggest7516=ends[32];
          }
          if(ends[33]>=biggest7516){
            biggest7516=ends[33];
          }
          if(ends[34]>=biggest7516){
            biggest7516=ends[34];
          }
          if(ends[35]>=biggest7516){
            biggest7516=ends[35];
          }
          if(ends[36]>=biggest7516){
            biggest7516=ends[36];
          }
          if(ends[37]>=biggest7516){
            biggest7516=ends[37];
          }
          if(ends[38]>=biggest7516){
            biggest7516=ends[38];
          }
          if(ends[39]>=biggest7516){
            biggest7516=ends[39];
          }
          if(ends[40]>=biggest7516){
            biggest7516=ends[40];
          }
          if(ends[41]>=biggest7516){
            biggest7516=ends[41];
          }
          if(ends[42]>=biggest7516){
            biggest7516=ends[42];
          }
          if(ends[43]>=biggest7516){
            biggest7516=ends[43];
          }
          if(ends[44]>=biggest7516){
            biggest7516=ends[44];
          }
          if(ends[45]>=biggest7516){
            biggest7516=ends[45];
          }
          if(ends[46]>=biggest7516){
            biggest7516=ends[46];
          }
          if(ends[47]>=biggest7516){
            biggest7516=ends[47];
          }
          if(ends[48]>=biggest7516){
            biggest7516=ends[48];
          }
          if(biggest7516 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          fault_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          stop_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          pauseFaultCheck_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          faultSolved_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          addFault_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          thread7517(tdone,ends);
          thread7524(tdone,ends);
          thread7525(tdone,ends);
          thread7526(tdone,ends);
          thread7545(tdone,ends);
          thread7546(tdone,ends);
          thread7547(tdone,ends);
          thread7548(tdone,ends);
          thread7549(tdone,ends);
          thread7550(tdone,ends);
          thread7551(tdone,ends);
          thread7552(tdone,ends);
          thread7553(tdone,ends);
          thread7554(tdone,ends);
          thread7555(tdone,ends);
          thread7556(tdone,ends);
          thread7557(tdone,ends);
          thread7558(tdone,ends);
          thread7559(tdone,ends);
          thread7560(tdone,ends);
          thread7561(tdone,ends);
          thread7562(tdone,ends);
          thread7563(tdone,ends);
          thread7564(tdone,ends);
          thread7565(tdone,ends);
          thread7566(tdone,ends);
          thread7567(tdone,ends);
          thread7568(tdone,ends);
          thread7569(tdone,ends);
          thread7570(tdone,ends);
          thread7571(tdone,ends);
          thread7572(tdone,ends);
          thread7573(tdone,ends);
          thread7574(tdone,ends);
          thread7575(tdone,ends);
          thread7576(tdone,ends);
          thread7577(tdone,ends);
          thread7578(tdone,ends);
          int biggest7579 = 0;
          if(ends[2]>=biggest7579){
            biggest7579=ends[2];
          }
          if(ends[5]>=biggest7579){
            biggest7579=ends[5];
          }
          if(ends[6]>=biggest7579){
            biggest7579=ends[6];
          }
          if(ends[7]>=biggest7579){
            biggest7579=ends[7];
          }
          if(ends[15]>=biggest7579){
            biggest7579=ends[15];
          }
          if(ends[16]>=biggest7579){
            biggest7579=ends[16];
          }
          if(ends[17]>=biggest7579){
            biggest7579=ends[17];
          }
          if(ends[18]>=biggest7579){
            biggest7579=ends[18];
          }
          if(ends[19]>=biggest7579){
            biggest7579=ends[19];
          }
          if(ends[20]>=biggest7579){
            biggest7579=ends[20];
          }
          if(ends[21]>=biggest7579){
            biggest7579=ends[21];
          }
          if(ends[22]>=biggest7579){
            biggest7579=ends[22];
          }
          if(ends[23]>=biggest7579){
            biggest7579=ends[23];
          }
          if(ends[24]>=biggest7579){
            biggest7579=ends[24];
          }
          if(ends[25]>=biggest7579){
            biggest7579=ends[25];
          }
          if(ends[26]>=biggest7579){
            biggest7579=ends[26];
          }
          if(ends[27]>=biggest7579){
            biggest7579=ends[27];
          }
          if(ends[28]>=biggest7579){
            biggest7579=ends[28];
          }
          if(ends[29]>=biggest7579){
            biggest7579=ends[29];
          }
          if(ends[30]>=biggest7579){
            biggest7579=ends[30];
          }
          if(ends[31]>=biggest7579){
            biggest7579=ends[31];
          }
          if(ends[32]>=biggest7579){
            biggest7579=ends[32];
          }
          if(ends[33]>=biggest7579){
            biggest7579=ends[33];
          }
          if(ends[34]>=biggest7579){
            biggest7579=ends[34];
          }
          if(ends[35]>=biggest7579){
            biggest7579=ends[35];
          }
          if(ends[36]>=biggest7579){
            biggest7579=ends[36];
          }
          if(ends[37]>=biggest7579){
            biggest7579=ends[37];
          }
          if(ends[38]>=biggest7579){
            biggest7579=ends[38];
          }
          if(ends[39]>=biggest7579){
            biggest7579=ends[39];
          }
          if(ends[40]>=biggest7579){
            biggest7579=ends[40];
          }
          if(ends[41]>=biggest7579){
            biggest7579=ends[41];
          }
          if(ends[42]>=biggest7579){
            biggest7579=ends[42];
          }
          if(ends[43]>=biggest7579){
            biggest7579=ends[43];
          }
          if(ends[44]>=biggest7579){
            biggest7579=ends[44];
          }
          if(ends[45]>=biggest7579){
            biggest7579=ends[45];
          }
          if(ends[46]>=biggest7579){
            biggest7579=ends[46];
          }
          if(ends[47]>=biggest7579){
            biggest7579=ends[47];
          }
          if(ends[48]>=biggest7579){
            biggest7579=ends[48];
          }
          if(biggest7579 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7579 == 0){
            S7476=0;
            active[1]=0;
            ends[1]=0;
            S7476=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    fault_1 = new Signal();
    stop_1 = new Signal();
    pauseFaultCheck_1 = new Signal();
    faultSolved_1 = new Signal();
    addFault_1 = new Signal();
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
          bottleRemoved.gethook();
          introduceFault.gethook();
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
      bottleRemoved.setpreclear();
      introduceFault.setpreclear();
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
      startRemover.setpreclear();
      faultUpdate.setpreclear();
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
      fault_1.setpreclear();
      stop_1.setpreclear();
      pauseFaultCheck_1.setpreclear();
      faultSolved_1.setpreclear();
      addFault_1.setpreclear();
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
      dummyint = bottleRemoved.getStatus() ? bottleRemoved.setprepresent() : bottleRemoved.setpreclear();
      bottleRemoved.setpreval(bottleRemoved.getValue());
      bottleRemoved.setClear();
      dummyint = introduceFault.getStatus() ? introduceFault.setprepresent() : introduceFault.setpreclear();
      introduceFault.setpreval(introduceFault.getValue());
      introduceFault.setClear();
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
      startRemover.sethook();
      startRemover.setClear();
      faultUpdate.sethook();
      faultUpdate.setClear();
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
      fault_1.setClear();
      stop_1.setClear();
      pauseFaultCheck_1.setClear();
      faultSolved_1.setClear();
      addFault_1.setClear();
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
        bottleRemoved.gethook();
        introduceFault.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
