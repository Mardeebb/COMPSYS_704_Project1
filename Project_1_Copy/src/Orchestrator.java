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
  public Signal showStartRemover = new Signal("showStartRemover", Signal.OUTPUT);
  public Signal showStopRemover = new Signal("showStopRemover", Signal.OUTPUT);
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
  private int location_thread_4;//sysj\Orchestrator.sysj line: 36, column: 5
  private int location_thread_5;//sysj\Orchestrator.sysj line: 88, column: 4
  private BottleTwin b_thread_5;//sysj\Orchestrator.sysj line: 91, column: 6
  private BottleTwin b_thread_6;//sysj\Orchestrator.sysj line: 155, column: 4
  private int ID_thread_6;//sysj\Orchestrator.sysj line: 158, column: 5
  private String name_thread_6;//sysj\Orchestrator.sysj line: 159, column: 5
  private int pos_thread_7;//sysj\Orchestrator.sysj line: 186, column: 6
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 282, column: 6
  private boolean faulty_thread_15;//sysj\Orchestrator.sysj line: 284, column: 7
  private int id_thread_15;//sysj\Orchestrator.sysj line: 287, column: 8
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 305, column: 6
  private boolean faulty_thread_16;//sysj\Orchestrator.sysj line: 307, column: 7
  private int id_thread_16;//sysj\Orchestrator.sysj line: 312, column: 8
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 332, column: 6
  private boolean faulty_thread_17;//sysj\Orchestrator.sysj line: 334, column: 7
  private int id_thread_17;//sysj\Orchestrator.sysj line: 337, column: 8
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 356, column: 6
  private boolean faulty_thread_18;//sysj\Orchestrator.sysj line: 358, column: 7
  private int id_thread_18;//sysj\Orchestrator.sysj line: 361, column: 8
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 380, column: 6
  private boolean faulty_thread_19;//sysj\Orchestrator.sysj line: 382, column: 7
  private int id_thread_19;//sysj\Orchestrator.sysj line: 385, column: 8
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 404, column: 6
  private boolean faulty_thread_20;//sysj\Orchestrator.sysj line: 406, column: 7
  private int id_thread_20;//sysj\Orchestrator.sysj line: 409, column: 8
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 429, column: 6
  private boolean faulty_thread_21;//sysj\Orchestrator.sysj line: 431, column: 7
  private int id_thread_21;//sysj\Orchestrator.sysj line: 434, column: 8
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 454, column: 6
  private boolean faulty_thread_22;//sysj\Orchestrator.sysj line: 456, column: 7
  private int id_thread_22;//sysj\Orchestrator.sysj line: 459, column: 8
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 478, column: 6
  private boolean faulty_thread_23;//sysj\Orchestrator.sysj line: 480, column: 7
  private int id_thread_23;//sysj\Orchestrator.sysj line: 483, column: 8
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 502, column: 6
  private boolean faulty_thread_24;//sysj\Orchestrator.sysj line: 504, column: 7
  private int id_thread_24;//sysj\Orchestrator.sysj line: 507, column: 8
  private BottleTwin b_thread_29;//sysj\Orchestrator.sysj line: 590, column: 5
  private BottleTwin b_thread_30;//sysj\Orchestrator.sysj line: 610, column: 5
  private BottleTwin b_thread_31;//sysj\Orchestrator.sysj line: 630, column: 5
  private BottleTwin bEight_thread_32;//sysj\Orchestrator.sysj line: 653, column: 4
  private BottleTwin bZero_thread_33;//sysj\Orchestrator.sysj line: 679, column: 4
  private BottleTwin bFive_thread_33;//sysj\Orchestrator.sysj line: 680, column: 4
  private BottleTwin bOne_thread_34;//sysj\Orchestrator.sysj line: 705, column: 4
  private BottleTwin bTwo_thread_34;//sysj\Orchestrator.sysj line: 706, column: 4
  private BottleTwin bThree_thread_34;//sysj\Orchestrator.sysj line: 707, column: 4
  private BottleTwin bFour_thread_34;//sysj\Orchestrator.sysj line: 708, column: 4
  private BottleTwin bFive_thread_34;//sysj\Orchestrator.sysj line: 709, column: 4
  private BottleTwin bSix_thread_34;//sysj\Orchestrator.sysj line: 710, column: 4
  private BottleTwin bSeven_thread_35;//sysj\Orchestrator.sysj line: 735, column: 4
  private int id_thread_39;//sysj\Orchestrator.sysj line: 808, column: 5
  private BottleTwin b_thread_39;//sysj\Orchestrator.sysj line: 805, column: 4
  private int id_thread_40;//sysj\Orchestrator.sysj line: 827, column: 5
  private BottleTwin b_thread_40;//sysj\Orchestrator.sysj line: 824, column: 4
  private int id_thread_41;//sysj\Orchestrator.sysj line: 850, column: 5
  private BottleTwin b_thread_41;//sysj\Orchestrator.sysj line: 847, column: 4
  private int id_thread_42;//sysj\Orchestrator.sysj line: 870, column: 5
  private BottleTwin b_thread_42;//sysj\Orchestrator.sysj line: 867, column: 4
  private int id_thread_43;//sysj\Orchestrator.sysj line: 889, column: 5
  private BottleTwin b_thread_43;//sysj\Orchestrator.sysj line: 886, column: 4
  private int id_thread_44;//sysj\Orchestrator.sysj line: 908, column: 5
  private BottleTwin b_thread_44;//sysj\Orchestrator.sysj line: 905, column: 4
  private int id_thread_45;//sysj\Orchestrator.sysj line: 927, column: 5
  private BottleTwin b_thread_45;//sysj\Orchestrator.sysj line: 924, column: 4
  private int id_thread_46;//sysj\Orchestrator.sysj line: 946, column: 5
  private BottleTwin b_thread_46;//sysj\Orchestrator.sysj line: 943, column: 4
  private int id_thread_47;//sysj\Orchestrator.sysj line: 965, column: 5
  private BottleTwin b_thread_47;//sysj\Orchestrator.sysj line: 962, column: 4
  private BottleTwin b_thread_48;//sysj\Orchestrator.sysj line: 982, column: 4
  private int id_thread_48;//sysj\Orchestrator.sysj line: 984, column: 5
  private int S9341 = 1;
  private int S4079 = 1;
  private int S3945 = 1;
  private int S3886 = 1;
  private int S3912 = 1;
  private int S3889 = 1;
  private int S5887 = 1;
  private int S5945 = 1;
  private int S5889 = 1;
  private int S5890 = 1;
  private int S6451 = 1;
  private int S5951 = 1;
  private int S5959 = 1;
  private int S5958 = 1;
  private int S5963 = 1;
  private int S5962 = 1;
  private int S5967 = 1;
  private int S5966 = 1;
  private int S5971 = 1;
  private int S5970 = 1;
  private int S5975 = 1;
  private int S5974 = 1;
  private int S6010 = 1;
  private int S6009 = 1;
  private int S6014 = 1;
  private int S6013 = 1;
  private int S6522 = 1;
  private int S6474 = 1;
  private int S6593 = 1;
  private int S6545 = 1;
  private int S6664 = 1;
  private int S6616 = 1;
  private int S6735 = 1;
  private int S6687 = 1;
  private int S6806 = 1;
  private int S6758 = 1;
  private int S6877 = 1;
  private int S6829 = 1;
  private int S6948 = 1;
  private int S6900 = 1;
  private int S7019 = 1;
  private int S6971 = 1;
  private int S7090 = 1;
  private int S7042 = 1;
  private int S7161 = 1;
  private int S7113 = 1;
  private int S7195 = 1;
  private int S7169 = 1;
  private int S7165 = 1;
  private int S7229 = 1;
  private int S7203 = 1;
  private int S7199 = 1;
  private int S7263 = 1;
  private int S7237 = 1;
  private int S7233 = 1;
  private int S7297 = 1;
  private int S7271 = 1;
  private int S7267 = 1;
  private int S7347 = 1;
  private int S7309 = 1;
  private int S7303 = 1;
  private int S7397 = 1;
  private int S7359 = 1;
  private int S7353 = 1;
  private int S7447 = 1;
  private int S7409 = 1;
  private int S7403 = 1;
  private int S7473 = 1;
  private int S7449 = 1;
  private int S7493 = 1;
  private int S7475 = 1;
  private int S7513 = 1;
  private int S7495 = 1;
  private int S7539 = 1;
  private int S7515 = 1;
  private int S7559 = 1;
  private int S7541 = 1;
  private int S7579 = 1;
  private int S7561 = 1;
  private int S7599 = 1;
  private int S7581 = 1;
  private int S7773 = 1;
  private int S7600 = 1;
  private int S7621 = 1;
  private int S7947 = 1;
  private int S7774 = 1;
  private int S7795 = 1;
  private int S8121 = 1;
  private int S7948 = 1;
  private int S7969 = 1;
  private int S8295 = 1;
  private int S8122 = 1;
  private int S8143 = 1;
  private int S8469 = 1;
  private int S8296 = 1;
  private int S8317 = 1;
  private int S8643 = 1;
  private int S8470 = 1;
  private int S8491 = 1;
  private int S8817 = 1;
  private int S8644 = 1;
  private int S8665 = 1;
  private int S8991 = 1;
  private int S8818 = 1;
  private int S8839 = 1;
  private int S9165 = 1;
  private int S8992 = 1;
  private int S9013 = 1;
  private int S9339 = 1;
  private int S9166 = 1;
  private int S9187 = 1;
  
  private int[] ends = new int[49];
  private int[] tdone = new int[49];
  
  public void thread9443(int [] tdone, int [] ends){
        switch(S9339){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        switch(S9166){
          case 0 : 
            S9166=0;
            b_thread_48 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 982, column: 4
            S9166=1;
            if(b_thread_48 != null){//sysj\Orchestrator.sysj line: 983, column: 8
              S9187=0;
              id_thread_48 = b_thread_48.ID;//sysj\Orchestrator.sysj line: 984, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 986, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_48);//sysj\Orchestrator.sysj line: 986, column: 6
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 987, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_48);//sysj\Orchestrator.sysj line: 987, column: 6
              active[48]=1;
              ends[48]=1;
              tdone[48]=1;
            }
            else {
              S9187=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 990, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 990, column: 5
              active[48]=1;
              ends[48]=1;
              tdone[48]=1;
            }
            break;
          
          case 1 : 
            switch(S9187){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 985, column: 11
                  S9166=0;
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 987, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_48);//sysj\Orchestrator.sysj line: 987, column: 6
                  active[48]=1;
                  ends[48]=1;
                  tdone[48]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 991, column: 11
                  S9166=0;
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

  public void thread9442(int [] tdone, int [] ends){
        switch(S9165){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        switch(S8992){
          case 0 : 
            S8992=0;
            S8992=1;
            if(b_thread_47 != null){//sysj\Orchestrator.sysj line: 964, column: 8
              S9013=0;
              id_thread_47 = b_thread_47.ID;//sysj\Orchestrator.sysj line: 965, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 967, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_47);//sysj\Orchestrator.sysj line: 967, column: 6
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 968, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_47);//sysj\Orchestrator.sysj line: 968, column: 6
              active[47]=1;
              ends[47]=1;
              tdone[47]=1;
            }
            else {
              S9013=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 971, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 971, column: 5
              active[47]=1;
              ends[47]=1;
              tdone[47]=1;
            }
            break;
          
          case 1 : 
            switch(S9013){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 966, column: 11
                  b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 962, column: 4
                  S8992=0;
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 968, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_47);//sysj\Orchestrator.sysj line: 968, column: 6
                  active[47]=1;
                  ends[47]=1;
                  tdone[47]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 972, column: 11
                  b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 962, column: 4
                  S8992=0;
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

  public void thread9441(int [] tdone, int [] ends){
        switch(S8991){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        switch(S8818){
          case 0 : 
            S8818=0;
            S8818=1;
            if(b_thread_46 != null){//sysj\Orchestrator.sysj line: 945, column: 8
              S8839=0;
              id_thread_46 = b_thread_46.ID;//sysj\Orchestrator.sysj line: 946, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 948, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_46);//sysj\Orchestrator.sysj line: 948, column: 6
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 949, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_46);//sysj\Orchestrator.sysj line: 949, column: 6
              active[46]=1;
              ends[46]=1;
              tdone[46]=1;
            }
            else {
              S8839=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 952, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 952, column: 5
              active[46]=1;
              ends[46]=1;
              tdone[46]=1;
            }
            break;
          
          case 1 : 
            switch(S8839){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 947, column: 11
                  b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 943, column: 4
                  S8818=0;
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 949, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_46);//sysj\Orchestrator.sysj line: 949, column: 6
                  active[46]=1;
                  ends[46]=1;
                  tdone[46]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 953, column: 11
                  b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 943, column: 4
                  S8818=0;
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

  public void thread9440(int [] tdone, int [] ends){
        switch(S8817){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        switch(S8644){
          case 0 : 
            S8644=0;
            S8644=1;
            if(b_thread_45 != null){//sysj\Orchestrator.sysj line: 926, column: 8
              S8665=0;
              id_thread_45 = b_thread_45.ID;//sysj\Orchestrator.sysj line: 927, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 929, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_45);//sysj\Orchestrator.sysj line: 929, column: 6
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 930, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_45);//sysj\Orchestrator.sysj line: 930, column: 6
              active[45]=1;
              ends[45]=1;
              tdone[45]=1;
            }
            else {
              S8665=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 933, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 933, column: 5
              active[45]=1;
              ends[45]=1;
              tdone[45]=1;
            }
            break;
          
          case 1 : 
            switch(S8665){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 928, column: 11
                  b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 924, column: 4
                  S8644=0;
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 930, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_45);//sysj\Orchestrator.sysj line: 930, column: 6
                  active[45]=1;
                  ends[45]=1;
                  tdone[45]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 934, column: 11
                  b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 924, column: 4
                  S8644=0;
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

  public void thread9439(int [] tdone, int [] ends){
        switch(S8643){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        switch(S8470){
          case 0 : 
            S8470=0;
            S8470=1;
            if(b_thread_44 != null){//sysj\Orchestrator.sysj line: 907, column: 8
              S8491=0;
              id_thread_44 = b_thread_44.ID;//sysj\Orchestrator.sysj line: 908, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 910, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_44);//sysj\Orchestrator.sysj line: 910, column: 6
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 911, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_44);//sysj\Orchestrator.sysj line: 911, column: 6
              active[44]=1;
              ends[44]=1;
              tdone[44]=1;
            }
            else {
              S8491=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 914, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 914, column: 5
              active[44]=1;
              ends[44]=1;
              tdone[44]=1;
            }
            break;
          
          case 1 : 
            switch(S8491){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 909, column: 11
                  b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 905, column: 4
                  S8470=0;
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 911, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_44);//sysj\Orchestrator.sysj line: 911, column: 6
                  active[44]=1;
                  ends[44]=1;
                  tdone[44]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 915, column: 11
                  b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 905, column: 4
                  S8470=0;
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

  public void thread9438(int [] tdone, int [] ends){
        switch(S8469){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        switch(S8296){
          case 0 : 
            S8296=0;
            S8296=1;
            if(b_thread_43 != null){//sysj\Orchestrator.sysj line: 888, column: 8
              S8317=0;
              id_thread_43 = b_thread_43.ID;//sysj\Orchestrator.sysj line: 889, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 891, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_43);//sysj\Orchestrator.sysj line: 891, column: 6
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 892, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_43);//sysj\Orchestrator.sysj line: 892, column: 6
              active[43]=1;
              ends[43]=1;
              tdone[43]=1;
            }
            else {
              S8317=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 895, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 895, column: 5
              active[43]=1;
              ends[43]=1;
              tdone[43]=1;
            }
            break;
          
          case 1 : 
            switch(S8317){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 890, column: 11
                  b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 886, column: 4
                  S8296=0;
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 892, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_43);//sysj\Orchestrator.sysj line: 892, column: 6
                  active[43]=1;
                  ends[43]=1;
                  tdone[43]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 896, column: 11
                  b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 886, column: 4
                  S8296=0;
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

  public void thread9437(int [] tdone, int [] ends){
        switch(S8295){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        switch(S8122){
          case 0 : 
            S8122=0;
            S8122=1;
            if(b_thread_42 != null){//sysj\Orchestrator.sysj line: 869, column: 8
              S8143=0;
              id_thread_42 = b_thread_42.ID;//sysj\Orchestrator.sysj line: 870, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 872, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_42);//sysj\Orchestrator.sysj line: 872, column: 6
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 873, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_42);//sysj\Orchestrator.sysj line: 873, column: 6
              active[42]=1;
              ends[42]=1;
              tdone[42]=1;
            }
            else {
              S8143=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 876, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 876, column: 5
              active[42]=1;
              ends[42]=1;
              tdone[42]=1;
            }
            break;
          
          case 1 : 
            switch(S8143){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 871, column: 11
                  b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 867, column: 4
                  S8122=0;
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 873, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_42);//sysj\Orchestrator.sysj line: 873, column: 6
                  active[42]=1;
                  ends[42]=1;
                  tdone[42]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 877, column: 11
                  b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 867, column: 4
                  S8122=0;
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

  public void thread9436(int [] tdone, int [] ends){
        switch(S8121){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        switch(S7948){
          case 0 : 
            S7948=0;
            S7948=1;
            if(b_thread_41 != null){//sysj\Orchestrator.sysj line: 849, column: 8
              S7969=0;
              id_thread_41 = b_thread_41.ID;//sysj\Orchestrator.sysj line: 850, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 852, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_41);//sysj\Orchestrator.sysj line: 852, column: 6
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 853, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_41);//sysj\Orchestrator.sysj line: 853, column: 6
              active[41]=1;
              ends[41]=1;
              tdone[41]=1;
            }
            else {
              S7969=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 856, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 856, column: 5
              active[41]=1;
              ends[41]=1;
              tdone[41]=1;
            }
            break;
          
          case 1 : 
            switch(S7969){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 851, column: 11
                  b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 847, column: 4
                  S7948=0;
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 853, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_41);//sysj\Orchestrator.sysj line: 853, column: 6
                  active[41]=1;
                  ends[41]=1;
                  tdone[41]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 857, column: 11
                  b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 847, column: 4
                  S7948=0;
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

  public void thread9435(int [] tdone, int [] ends){
        switch(S7947){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        switch(S7774){
          case 0 : 
            S7774=0;
            S7774=1;
            if(b_thread_40 != null){//sysj\Orchestrator.sysj line: 826, column: 8
              S7795=0;
              id_thread_40 = b_thread_40.ID;//sysj\Orchestrator.sysj line: 827, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 829, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_40);//sysj\Orchestrator.sysj line: 829, column: 6
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 831, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 831, column: 7
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 832, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 832, column: 7
              active[40]=1;
              ends[40]=1;
              tdone[40]=1;
            }
            else {
              S7795=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 837, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 837, column: 5
              active[40]=1;
              ends[40]=1;
              tdone[40]=1;
            }
            break;
          
          case 1 : 
            switch(S7795){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 828, column: 11
                  b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 824, column: 4
                  S7774=0;
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 831, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 831, column: 7
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 832, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_40);//sysj\Orchestrator.sysj line: 832, column: 7
                  active[40]=1;
                  ends[40]=1;
                  tdone[40]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 838, column: 11
                  b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 824, column: 4
                  S7774=0;
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

  public void thread9434(int [] tdone, int [] ends){
        switch(S7773){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        switch(S7600){
          case 0 : 
            S7600=0;
            S7600=1;
            if(b_thread_39 != null){//sysj\Orchestrator.sysj line: 807, column: 8
              S7621=0;
              id_thread_39 = b_thread_39.ID;//sysj\Orchestrator.sysj line: 808, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 810, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_39);//sysj\Orchestrator.sysj line: 810, column: 6
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 811, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_39);//sysj\Orchestrator.sysj line: 811, column: 6
              active[39]=1;
              ends[39]=1;
              tdone[39]=1;
            }
            else {
              S7621=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 814, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 814, column: 5
              active[39]=1;
              ends[39]=1;
              tdone[39]=1;
            }
            break;
          
          case 1 : 
            switch(S7621){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 809, column: 11
                  b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 805, column: 4
                  S7600=0;
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 811, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_39);//sysj\Orchestrator.sysj line: 811, column: 6
                  active[39]=1;
                  ends[39]=1;
                  tdone[39]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 815, column: 11
                  b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 805, column: 4
                  S7600=0;
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

  public void thread9433(int [] tdone, int [] ends){
        switch(S7599){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        switch(S7581){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 786, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 788, column: 4
              currsigs.addElement(startCapLoading);
              S7581=1;
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
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 789, column: 10
              S7581=2;
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
            S7581=2;
            S7581=3;
            active[38]=1;
            ends[38]=1;
            tdone[38]=1;
            break;
          
          case 3 : 
            S7581=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 792, column: 4
            currsigs.addElement(capLoaderFinish_1);
            S7581=4;
            active[38]=1;
            ends[38]=1;
            tdone[38]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 794, column: 10
              S7581=0;
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

  public void thread9432(int [] tdone, int [] ends){
        switch(S7579){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        switch(S7561){
          case 0 : 
            if(startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 769, column: 10
              startCapping.setPresent();//sysj\Orchestrator.sysj line: 771, column: 4
              currsigs.addElement(startCapping);
              S7561=1;
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
            if(capped.getprestatus()){//sysj\Orchestrator.sysj line: 772, column: 10
              S7561=2;
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
            S7561=2;
            S7561=3;
            active[37]=1;
            ends[37]=1;
            tdone[37]=1;
            break;
          
          case 3 : 
            S7561=3;
            capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 775, column: 4
            currsigs.addElement(capperFinish_1);
            S7561=4;
            active[37]=1;
            ends[37]=1;
            tdone[37]=1;
            break;
          
          case 4 : 
            if(!startCapperThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 777, column: 10
              S7561=0;
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

  public void thread9431(int [] tdone, int [] ends){
        switch(S7559){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        switch(S7541){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 752, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 754, column: 4
              currsigs.addElement(startFilling);
              S7541=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 755, column: 10
              S7541=2;
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
            S7541=2;
            S7541=3;
            active[36]=1;
            ends[36]=1;
            tdone[36]=1;
            break;
          
          case 3 : 
            S7541=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 758, column: 4
            currsigs.addElement(fillerFinish_1);
            S7541=4;
            active[36]=1;
            ends[36]=1;
            tdone[36]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 760, column: 10
              S7541=0;
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

  public void thread9430(int [] tdone, int [] ends){
        switch(S7539){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        switch(S7515){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 731, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 733, column: 4
              currsigs.addElement(startBottleUnloading);
              S7515=1;
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
            if(bottleUnloaded.getprestatus()){//sysj\Orchestrator.sysj line: 734, column: 10
              bSeven_thread_35 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 735, column: 4
              S7515=2;
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
            S7515=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 737, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 737, column: 4
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 738, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_35);//sysj\Orchestrator.sysj line: 738, column: 4
            S7515=3;
            active[35]=1;
            ends[35]=1;
            tdone[35]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 739, column: 10
              S7515=4;
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
            S7515=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 741, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            S7515=5;
            active[35]=1;
            ends[35]=1;
            tdone[35]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 742, column: 10
              S7515=0;
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

  public void thread9429(int [] tdone, int [] ends){
        switch(S7513){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S7495){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 700, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 703, column: 4
              currsigs.addElement(startRotTable);
              S7495=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 704, column: 10
              bOne_thread_34 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 705, column: 4
              bTwo_thread_34 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 706, column: 4
              bThree_thread_34 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 707, column: 4
              bFour_thread_34 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 708, column: 4
              bFive_thread_34 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 709, column: 4
              bSix_thread_34 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 710, column: 4
              S7495=2;
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
            S7495=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 712, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_34);//sysj\Orchestrator.sysj line: 712, column: 4
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 713, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_34);//sysj\Orchestrator.sysj line: 713, column: 4
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 714, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_34);//sysj\Orchestrator.sysj line: 714, column: 4
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 715, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_34);//sysj\Orchestrator.sysj line: 715, column: 4
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 716, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_34);//sysj\Orchestrator.sysj line: 716, column: 4
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 717, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_34);//sysj\Orchestrator.sysj line: 717, column: 4
            S7495=3;
            active[34]=1;
            ends[34]=1;
            tdone[34]=1;
            break;
          
          case 3 : 
            S7495=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 720, column: 4
            currsigs.addElement(rotTableFinish_1);
            S7495=4;
            active[34]=1;
            ends[34]=1;
            tdone[34]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 721, column: 10
              S7495=0;
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

  public void thread9428(int [] tdone, int [] ends){
        switch(S7493){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S7475){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 673, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 676, column: 4
              currsigs.addElement(startConveyor);
              S7475=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 677, column: 10
              bZero_thread_33 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 679, column: 4
              bFive_thread_33 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 680, column: 4
              S7475=2;
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
            S7475=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 683, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 683, column: 4
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 684, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 684, column: 4
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 685, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_33);//sysj\Orchestrator.sysj line: 685, column: 4
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 686, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_33);//sysj\Orchestrator.sysj line: 686, column: 4
            S7475=3;
            active[33]=1;
            ends[33]=1;
            tdone[33]=1;
            break;
          
          case 3 : 
            S7475=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 689, column: 4
            currsigs.addElement(conveyorFinish_1);
            S7475=4;
            active[33]=1;
            ends[33]=1;
            tdone[33]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 690, column: 10
              S7475=0;
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

  public void thread9427(int [] tdone, int [] ends){
        switch(S7473){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S7449){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 648, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 650, column: 4
              currsigs.addElement(startBottleLoading);
              S7449=1;
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
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 651, column: 10
              bEight_thread_32 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 653, column: 4
              S7449=2;
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
            S7449=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 655, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 655, column: 4
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 656, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_32);//sysj\Orchestrator.sysj line: 656, column: 4
            S7449=3;
            active[32]=1;
            ends[32]=1;
            tdone[32]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 658, column: 10
              S7449=4;
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
            S7449=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 661, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            S7449=5;
            active[32]=1;
            ends[32]=1;
            tdone[32]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 662, column: 10
              S7449=0;
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

  public void thread9426(int [] tdone, int [] ends){
        switch(S7447){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S7409){
          case 0 : 
            if(checkCapper_1.getprestatus()){//sysj\Orchestrator.sysj line: 628, column: 10
              S7409=1;
              if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 629, column: 12
                S7403=0;
                b_thread_31 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 630, column: 5
                if(!b_thread_31.isCapped){//sysj\Orchestrator.sysj line: 631, column: 8
                  startCapperThread_1.setPresent();//sysj\Orchestrator.sysj line: 632, column: 6
                  currsigs.addElement(startCapperThread_1);
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 634, column: 6
                  currsigs.addElement(capperFinish_1);
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
              }
              else {
                S7403=1;
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
            switch(S7403){
              case 0 : 
                S7409=0;
                active[31]=1;
                ends[31]=1;
                tdone[31]=1;
                break;
              
              case 1 : 
                capperFinish_1.setPresent();//sysj\Orchestrator.sysj line: 639, column: 4
                currsigs.addElement(capperFinish_1);
                S7409=0;
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

  public void thread9425(int [] tdone, int [] ends){
        switch(S7397){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S7359){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 608, column: 10
              S7359=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 609, column: 12
                S7353=0;
                b_thread_30 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 610, column: 5
                if(!b_thread_30.isCapOn && !b_thread_30.isCapped){//sysj\Orchestrator.sysj line: 611, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 612, column: 6
                  currsigs.addElement(startCapLoaderThread_1);
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 614, column: 6
                  currsigs.addElement(capLoaderFinish_1);
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
              }
              else {
                S7353=1;
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
            switch(S7353){
              case 0 : 
                S7359=0;
                active[30]=1;
                ends[30]=1;
                tdone[30]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 619, column: 5
                currsigs.addElement(capLoaderFinish_1);
                S7359=0;
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

  public void thread9424(int [] tdone, int [] ends){
        switch(S7347){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S7309){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 588, column: 10
              S7309=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 589, column: 12
                S7303=0;
                b_thread_29 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 590, column: 5
                if(!b_thread_29.isFilled){//sysj\Orchestrator.sysj line: 591, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 592, column: 6
                  currsigs.addElement(startFillerThread_1);
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 594, column: 6
                  currsigs.addElement(fillerFinish_1);
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
              }
              else {
                S7303=1;
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
            switch(S7303){
              case 0 : 
                S7309=0;
                active[29]=1;
                ends[29]=1;
                tdone[29]=1;
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 599, column: 5
                currsigs.addElement(fillerFinish_1);
                S7309=0;
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

  public void thread9423(int [] tdone, int [] ends){
        switch(S7297){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S7271){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 573, column: 10
              S7271=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 574, column: 12
                S7267=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 575, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
              }
              else {
                S7267=1;
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
            switch(S7267){
              case 0 : 
                S7271=0;
                active[28]=1;
                ends[28]=1;
                tdone[28]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 579, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                S7271=0;
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

  public void thread9422(int [] tdone, int [] ends){
        switch(S7263){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S7237){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 556, column: 10
              S7237=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 558, column: 12
                S7233=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 559, column: 5
                currsigs.addElement(startRotThread_1);
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
              else {
                S7233=1;
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
            switch(S7233){
              case 0 : 
                S7237=0;
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 563, column: 5
                currsigs.addElement(rotTableFinish_1);
                S7237=0;
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

  public void thread9421(int [] tdone, int [] ends){
        switch(S7229){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S7203){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 541, column: 10
              S7203=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 542, column: 12
                S7199=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 543, column: 5
                currsigs.addElement(startConveyorThread_1);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S7199=1;
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
            switch(S7199){
              case 0 : 
                S7203=0;
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 547, column: 5
                currsigs.addElement(conveyorFinish_1);
                S7203=0;
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

  public void thread9420(int [] tdone, int [] ends){
        switch(S7195){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S7169){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 526, column: 10
              S7169=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 527, column: 12
                S7165=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 528, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S7165=1;
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
            switch(S7165){
              case 0 : 
                S7169=0;
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 532, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                S7169=0;
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

  public void thread9419(int [] tdone, int [] ends){
        switch(S7161){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S7113){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 509, column: 14
              S7113=1;
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
            S7113=1;
            S7113=0;
            if(bottlePos9.getprestatus()){//sysj\Orchestrator.sysj line: 501, column: 13
              b_thread_24 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 502, column: 6
              if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 503, column: 10
                faulty_thread_24 = b_thread_24.Faulty;//sysj\Orchestrator.sysj line: 504, column: 7
                if(faulty_thread_24){//sysj\Orchestrator.sysj line: 505, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 506, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(9);//sysj\Orchestrator.sysj line: 506, column: 8
                  id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 507, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 508, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 508, column: 8
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  S7113=1;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
              }
              else {
                S7113=1;
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
            }
            else {
              S7113=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9418(int [] tdone, int [] ends){
        switch(S7090){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S7042){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 485, column: 14
              S7042=1;
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
            S7042=1;
            S7042=0;
            if(bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 477, column: 13
              b_thread_23 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 478, column: 6
              if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 479, column: 10
                faulty_thread_23 = b_thread_23.Faulty;//sysj\Orchestrator.sysj line: 480, column: 7
                if(faulty_thread_23){//sysj\Orchestrator.sysj line: 481, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 482, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(8);//sysj\Orchestrator.sysj line: 482, column: 8
                  id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 483, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 484, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 484, column: 8
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  S7042=1;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
              }
              else {
                S7042=1;
                active[23]=1;
                ends[23]=1;
                tdone[23]=1;
              }
            }
            else {
              S7042=1;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9417(int [] tdone, int [] ends){
        switch(S7019){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S6971){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 461, column: 14
              S6971=1;
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
            S6971=1;
            S6971=0;
            if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 453, column: 13
              b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 454, column: 6
              if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 455, column: 10
                faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 456, column: 7
                if(faulty_thread_22){//sysj\Orchestrator.sysj line: 457, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 458, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(7);//sysj\Orchestrator.sysj line: 458, column: 8
                  id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 459, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 460, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 460, column: 8
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  S6971=1;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
              }
              else {
                S6971=1;
                active[22]=1;
                ends[22]=1;
                tdone[22]=1;
              }
            }
            else {
              S6971=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9416(int [] tdone, int [] ends){
        switch(S6948){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S6900){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 436, column: 14
              S6900=1;
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
            S6900=1;
            S6900=0;
            if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 428, column: 13
              b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 429, column: 6
              if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 430, column: 10
                faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 431, column: 7
                if(faulty_thread_21){//sysj\Orchestrator.sysj line: 432, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 433, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(6);//sysj\Orchestrator.sysj line: 433, column: 8
                  id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 434, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 435, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 435, column: 8
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  S6900=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
              }
              else {
                S6900=1;
                active[21]=1;
                ends[21]=1;
                tdone[21]=1;
              }
            }
            else {
              S6900=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9415(int [] tdone, int [] ends){
        switch(S6877){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S6829){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 411, column: 14
              S6829=1;
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
            S6829=1;
            S6829=0;
            if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 403, column: 13
              b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 404, column: 6
              if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 405, column: 10
                faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 406, column: 7
                if(faulty_thread_20){//sysj\Orchestrator.sysj line: 407, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 408, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(5);//sysj\Orchestrator.sysj line: 408, column: 8
                  id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 409, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 410, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 410, column: 8
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  S6829=1;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
              }
              else {
                S6829=1;
                active[20]=1;
                ends[20]=1;
                tdone[20]=1;
              }
            }
            else {
              S6829=1;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9414(int [] tdone, int [] ends){
        switch(S6806){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S6758){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 387, column: 14
              S6758=1;
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
            S6758=1;
            S6758=0;
            if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 379, column: 13
              b_thread_19 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 380, column: 6
              if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 381, column: 10
                faulty_thread_19 = b_thread_19.Faulty;//sysj\Orchestrator.sysj line: 382, column: 7
                if(faulty_thread_19){//sysj\Orchestrator.sysj line: 383, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 384, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(4);//sysj\Orchestrator.sysj line: 384, column: 8
                  id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 385, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 386, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 386, column: 8
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S6758=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
              }
              else {
                S6758=1;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
            }
            else {
              S6758=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9413(int [] tdone, int [] ends){
        switch(S6735){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S6687){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 363, column: 14
              S6687=1;
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
            S6687=1;
            S6687=0;
            if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 355, column: 13
              b_thread_18 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 356, column: 6
              if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 357, column: 10
                faulty_thread_18 = b_thread_18.Faulty;//sysj\Orchestrator.sysj line: 358, column: 7
                if(faulty_thread_18){//sysj\Orchestrator.sysj line: 359, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 360, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(3);//sysj\Orchestrator.sysj line: 360, column: 8
                  id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 361, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 362, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 362, column: 8
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  S6687=1;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
              }
              else {
                S6687=1;
                active[18]=1;
                ends[18]=1;
                tdone[18]=1;
              }
            }
            else {
              S6687=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9412(int [] tdone, int [] ends){
        switch(S6664){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S6616){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 339, column: 14
              S6616=1;
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
          
          case 1 : 
            S6616=1;
            S6616=0;
            if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 331, column: 13
              b_thread_17 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 332, column: 6
              if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 333, column: 10
                faulty_thread_17 = b_thread_17.Faulty;//sysj\Orchestrator.sysj line: 334, column: 7
                if(faulty_thread_17){//sysj\Orchestrator.sysj line: 335, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 336, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(2);//sysj\Orchestrator.sysj line: 336, column: 8
                  id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 337, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 338, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 338, column: 8
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  S6616=1;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
              else {
                S6616=1;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
            }
            else {
              S6616=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9411(int [] tdone, int [] ends){
        switch(S6593){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S6545){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 314, column: 14
              S6545=1;
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
          
          case 1 : 
            S6545=1;
            S6545=0;
            if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 13
              b_thread_16 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 6
              if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 306, column: 10
                faulty_thread_16 = b_thread_16.Faulty;//sysj\Orchestrator.sysj line: 307, column: 7
                if(faulty_thread_16){//sysj\Orchestrator.sysj line: 308, column: 7
                  System.err.println("fault pos1");//sysj\Orchestrator.sysj line: 309, column: 11
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 311, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(1);//sysj\Orchestrator.sysj line: 311, column: 8
                  id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 312, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 313, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 313, column: 8
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  S6545=1;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
              }
              else {
                S6545=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
            }
            else {
              S6545=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9410(int [] tdone, int [] ends){
        switch(S6522){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S6474){
          case 0 : 
            if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 289, column: 14
              S6474=1;
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
            S6474=1;
            S6474=0;
            if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 281, column: 13
              b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 282, column: 6
              if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 283, column: 10
                faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 284, column: 7
                if(faulty_thread_15){//sysj\Orchestrator.sysj line: 285, column: 7
                  fault_1.setPresent();//sysj\Orchestrator.sysj line: 286, column: 8
                  currsigs.addElement(fault_1);
                  fault_1.setValue(0);//sysj\Orchestrator.sysj line: 286, column: 8
                  id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 287, column: 8
                  faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 288, column: 8
                  currsigs.addElement(faultUpdate);
                  faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 288, column: 8
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S6474=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S6474=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S6474=1;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9408(int [] tdone, int [] ends){
        switch(S6014){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S6013){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 258, column: 12
              S6013=1;
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
            S6013=1;
            S6013=2;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 2 : 
            S6013=2;
            S6014=0;
            active[14]=0;
            ends[14]=0;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9407(int [] tdone, int [] ends){
        switch(S6010){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S6009){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 250, column: 12
              S6009=1;
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
            S6009=1;
            S6009=2;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 2 : 
            S6009=2;
            S6010=0;
            active[13]=0;
            ends[13]=0;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9405(int [] tdone, int [] ends){
        S6014=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 257, column: 6
    currsigs.addElement(checkRobotUnloader_1);
    S6013=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread9404(int [] tdone, int [] ends){
        S6010=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 249, column: 6
    currsigs.addElement(checkRobotLoader_1);
    S6009=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread9402(int [] tdone, int [] ends){
        switch(S5975){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S5974){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 230, column: 12
              S5974=1;
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
            S5974=1;
            S5974=2;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            S5974=2;
            S5975=0;
            active[12]=0;
            ends[12]=0;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9401(int [] tdone, int [] ends){
        switch(S5971){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S5970){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 223, column: 12
              S5970=1;
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
            S5970=1;
            S5970=2;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            S5970=2;
            S5971=0;
            active[11]=0;
            ends[11]=0;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9400(int [] tdone, int [] ends){
        switch(S5967){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S5966){
          case 0 : 
            if(capperFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 215, column: 12
              S5966=1;
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
            S5966=1;
            S5966=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S5966=2;
            S5967=0;
            active[10]=0;
            ends[10]=0;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9399(int [] tdone, int [] ends){
        switch(S5963){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S5962){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 207, column: 12
              S5962=1;
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
            S5962=1;
            S5962=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S5962=2;
            S5963=0;
            active[9]=0;
            ends[9]=0;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9398(int [] tdone, int [] ends){
        switch(S5959){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S5958){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 199, column: 12
              S5958=1;
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
            S5958=1;
            S5958=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S5958=2;
            S5959=0;
            active[8]=0;
            ends[8]=0;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9396(int [] tdone, int [] ends){
        S5975=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 229, column: 6
    currsigs.addElement(checkRobotUnloader_1);
    S5974=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread9395(int [] tdone, int [] ends){
        S5971=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 222, column: 6
    currsigs.addElement(checkRobotLoader_1);
    S5970=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread9394(int [] tdone, int [] ends){
        S5967=1;
    checkCapper_1.setPresent();//sysj\Orchestrator.sysj line: 214, column: 6
    currsigs.addElement(checkCapper_1);
    S5966=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread9393(int [] tdone, int [] ends){
        S5963=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 206, column: 6
    currsigs.addElement(checkFiller_1);
    S5962=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread9392(int [] tdone, int [] ends){
        S5959=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 198, column: 6
    currsigs.addElement(checkCapLoader_1);
    S5958=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread9391(int [] tdone, int [] ends){
        switch(S6451){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(fault_1.getprestatus() || pauseFaultCheck_1.getprestatus()){//sysj\Orchestrator.sysj line: 181, column: 10
          if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 13
            pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 186, column: 6
            stop_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
            currsigs.addElement(stop_1);
            stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 187, column: 6
            S5951=0;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
          else {
            S5951=0;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
          }
        }
        else {
          switch(S5951){
            case 0 : 
              if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 189, column: 11
                S5951=1;
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
              if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 190, column: 11
                checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 192, column: 5
                currsigs.addElement(checkConveyor_1);
                S5951=2;
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
            
            case 2 : 
              if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 193, column: 11
                S5951=3;
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
            
            case 3 : 
              S5951=3;
              S5951=4;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 4 : 
              S5951=4;
              S5951=5;
              thread9392(tdone,ends);
              thread9393(tdone,ends);
              thread9394(tdone,ends);
              thread9395(tdone,ends);
              thread9396(tdone,ends);
              int biggest9397 = 0;
              if(ends[8]>=biggest9397){
                biggest9397=ends[8];
              }
              if(ends[9]>=biggest9397){
                biggest9397=ends[9];
              }
              if(ends[10]>=biggest9397){
                biggest9397=ends[10];
              }
              if(ends[11]>=biggest9397){
                biggest9397=ends[11];
              }
              if(ends[12]>=biggest9397){
                biggest9397=ends[12];
              }
              if(biggest9397 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 5 : 
              thread9398(tdone,ends);
              thread9399(tdone,ends);
              thread9400(tdone,ends);
              thread9401(tdone,ends);
              thread9402(tdone,ends);
              int biggest9403 = 0;
              if(ends[8]>=biggest9403){
                biggest9403=ends[8];
              }
              if(ends[9]>=biggest9403){
                biggest9403=ends[9];
              }
              if(ends[10]>=biggest9403){
                biggest9403=ends[10];
              }
              if(ends[11]>=biggest9403){
                biggest9403=ends[11];
              }
              if(ends[12]>=biggest9403){
                biggest9403=ends[12];
              }
              if(biggest9403 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              //FINXME code
              if(biggest9403 == 0){
                if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 236, column: 13
                  pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 237, column: 6
                  stop_1.setPresent();//sysj\Orchestrator.sysj line: 238, column: 6
                  currsigs.addElement(stop_1);
                  stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 238, column: 6
                  S5951=6;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S5951=6;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              break;
            
            case 6 : 
              if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 240, column: 11
                S5951=7;
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
            
            case 7 : 
              if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 241, column: 11
                checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 243, column: 5
                currsigs.addElement(checkConveyor_1);
                S5951=8;
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
            
            case 8 : 
              if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 244, column: 11
                S5951=9;
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
            
            case 9 : 
              S5951=9;
              S5951=10;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 10 : 
              S5951=10;
              S5951=11;
              thread9404(tdone,ends);
              thread9405(tdone,ends);
              int biggest9406 = 0;
              if(ends[13]>=biggest9406){
                biggest9406=ends[13];
              }
              if(ends[14]>=biggest9406){
                biggest9406=ends[14];
              }
              if(biggest9406 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 11 : 
              thread9407(tdone,ends);
              thread9408(tdone,ends);
              int biggest9409 = 0;
              if(ends[13]>=biggest9409){
                biggest9409=ends[13];
              }
              if(ends[14]>=biggest9409){
                biggest9409=ends[14];
              }
              if(biggest9409 == 1){
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              //FINXME code
              if(biggest9409 == 0){
                checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 264, column: 5
                currsigs.addElement(checkRotTable_1);
                S5951=12;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 12 : 
              if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 265, column: 11
                S5951=13;
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
            
            case 13 : 
              S5951=13;
              S5951=14;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 14 : 
              S5951=14;
              S5951=15;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
              break;
            
            case 15 : 
              if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 269, column: 11
                S5951=16;
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
            
            case 16 : 
              if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 270, column: 11
                if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 13
                  pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 186, column: 6
                  stop_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
                  currsigs.addElement(stop_1);
                  stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 187, column: 6
                  S5951=0;
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  S5951=0;
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
            
            case 17 : 
              if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 13
                pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 186, column: 6
                stop_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
                currsigs.addElement(stop_1);
                stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 187, column: 6
                S5951=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S5951=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
            case 18 : 
              if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 13
                pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 186, column: 6
                stop_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
                currsigs.addElement(stop_1);
                stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 187, column: 6
                S5951=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S5951=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread9390(int [] tdone, int [] ends){
        switch(S5945){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S5889){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 153, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 154, column: 7
              b_thread_6 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 155, column: 4
              S5889=1;
              if(b_thread_6 != null){//sysj\Orchestrator.sysj line: 157, column: 7
                ID_thread_6 = b_thread_6.ID;//sysj\Orchestrator.sysj line: 158, column: 5
                name_thread_6 = b_thread_6.name;//sysj\Orchestrator.sysj line: 159, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_6);//sysj\Orchestrator.sysj line: 160, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_6);//sysj\Orchestrator.sysj line: 161, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_6);//sysj\Orchestrator.sysj line: 162, column: 8
                posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 163, column: 5
                currsigs.addElement(posEightUpdate_1);
                posEightUpdate_1.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 163, column: 5
                S5890=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S5889=0;
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
            switch(S5890){
              case 0 : 
                S5890=0;
                S5890=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                S5890=1;
                S5890=2;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 166, column: 11
                  S5890=3;
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
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 170, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 171, column: 5
                  currsigs.addElement(recieveTwin);
                  S5889=0;
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

  public void thread9389(int [] tdone, int [] ends){
        switch(S5887){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(introduceFault.getprestatus()){//sysj\Orchestrator.sysj line: 86, column: 10
          location_thread_5 = (int)(introduceFault.getpreval() == null ? 0 : ((Integer)introduceFault.getpreval()).intValue());//sysj\Orchestrator.sysj line: 88, column: 4
          if(location_thread_5 == 1){//sysj\Orchestrator.sysj line: 89, column: 7
            if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 90, column: 13
              b_thread_5 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 91, column: 6
              if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 92, column: 10
                b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 93, column: 7
                posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 94, column: 7
                currsigs.addElement(posOneUpdate_1);
                posOneUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 94, column: 7
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
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
          }
          else {
            if(location_thread_5 == 2){//sysj\Orchestrator.sysj line: 98, column: 13
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 99, column: 13
                b_thread_5 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 100, column: 6
                if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 101, column: 10
                  b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 102, column: 7
                  posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 103, column: 7
                  currsigs.addElement(posTwoUpdate_1);
                  posTwoUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 103, column: 7
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
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
            }
            else {
              if(location_thread_5 == 3){//sysj\Orchestrator.sysj line: 107, column: 13
                if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 108, column: 13
                  b_thread_5 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 109, column: 6
                  if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 110, column: 10
                    b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 111, column: 7
                    posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 112, column: 7
                    currsigs.addElement(posThreeUpdate_1);
                    posThreeUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 112, column: 7
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
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
              }
              else {
                if(location_thread_5 == 4){//sysj\Orchestrator.sysj line: 116, column: 13
                  if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 117, column: 13
                    b_thread_5 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 118, column: 6
                    if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 119, column: 10
                      b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 120, column: 7
                      posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 121, column: 7
                      currsigs.addElement(posFourUpdate_1);
                      posFourUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 121, column: 7
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
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
                }
                else {
                  if(location_thread_5 == 5){//sysj\Orchestrator.sysj line: 125, column: 13
                    if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 126, column: 13
                      b_thread_5 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 127, column: 6
                      if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 128, column: 10
                        b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 129, column: 7
                        posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 130, column: 7
                        currsigs.addElement(posFiveUpdate_1);
                        posFiveUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 130, column: 7
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
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
                  }
                  else {
                    if(location_thread_5 == 6){//sysj\Orchestrator.sysj line: 134, column: 13
                      if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 135, column: 13
                        b_thread_5 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 136, column: 6
                        if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 137, column: 10
                          b_thread_5.Faulty = true;//sysj\Orchestrator.sysj line: 138, column: 7
                          posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 139, column: 7
                          currsigs.addElement(posSixUpdate_1);
                          posSixUpdate_1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 139, column: 7
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
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
                    }
                    else {
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                }
              }
            }
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread9387(int [] tdone, int [] ends){
        switch(S3912){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3889){
          case 0 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 37, column: 11
              S3889=1;
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 38, column: 11
              startRemover.setPresent();//sysj\Orchestrator.sysj line: 41, column: 5
              currsigs.addElement(startRemover);
              startRemover.setValue(location_thread_4);//sysj\Orchestrator.sysj line: 41, column: 5
              showStartRemover.setPresent();//sysj\Orchestrator.sysj line: 42, column: 5
              currsigs.addElement(showStartRemover);
              System.err.println("Start Remover");//sysj\Orchestrator.sysj line: 43, column: 8
              System.err.println(location_thread_4);//sysj\Orchestrator.sysj line: 44, column: 8
              S3889=2;
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
          
          case 2 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 47, column: 11
              S3889=3;
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
          
          case 3 : 
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 48, column: 11
              showStopRemover.setPresent();//sysj\Orchestrator.sysj line: 49, column: 5
              currsigs.addElement(showStopRemover);
              if(location_thread_4 == 1){//sysj\Orchestrator.sysj line: 50, column: 8
                posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 51, column: 6
                currsigs.addElement(posOneUpdate_1);
                posOneUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 51, column: 6
                faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                currsigs.addElement(faultSolved_1);
                S3912=0;
                active[4]=0;
                ends[4]=0;
                tdone[4]=1;
              }
              else {
                if(location_thread_4 == 2){//sysj\Orchestrator.sysj line: 53, column: 13
                  posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 54, column: 6
                  currsigs.addElement(posTwoUpdate_1);
                  posTwoUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 54, column: 6
                  faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                  currsigs.addElement(faultSolved_1);
                  S3912=0;
                  active[4]=0;
                  ends[4]=0;
                  tdone[4]=1;
                }
                else {
                  if(location_thread_4 == 3){//sysj\Orchestrator.sysj line: 56, column: 13
                    posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 57, column: 6
                    currsigs.addElement(posThreeUpdate_1);
                    posThreeUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 57, column: 6
                    faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                    currsigs.addElement(faultSolved_1);
                    S3912=0;
                    active[4]=0;
                    ends[4]=0;
                    tdone[4]=1;
                  }
                  else {
                    if(location_thread_4 == 4){//sysj\Orchestrator.sysj line: 59, column: 13
                      posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 60, column: 6
                      currsigs.addElement(posFourUpdate_1);
                      posFourUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 60, column: 6
                      faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                      currsigs.addElement(faultSolved_1);
                      S3912=0;
                      active[4]=0;
                      ends[4]=0;
                      tdone[4]=1;
                    }
                    else {
                      if(location_thread_4 == 5){//sysj\Orchestrator.sysj line: 62, column: 13
                        posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 63, column: 6
                        currsigs.addElement(posFiveUpdate_1);
                        posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 63, column: 6
                        faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                        currsigs.addElement(faultSolved_1);
                        S3912=0;
                        active[4]=0;
                        ends[4]=0;
                        tdone[4]=1;
                      }
                      else {
                        if(location_thread_4 == 6){//sysj\Orchestrator.sysj line: 65, column: 13
                          posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 66, column: 6
                          currsigs.addElement(posSixUpdate_1);
                          posSixUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 66, column: 6
                          faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                          currsigs.addElement(faultSolved_1);
                          S3912=0;
                          active[4]=0;
                          ends[4]=0;
                          tdone[4]=1;
                        }
                        else {
                          if(location_thread_4 == 7){//sysj\Orchestrator.sysj line: 68, column: 13
                            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 69, column: 6
                            currsigs.addElement(posSevenUpdate_1);
                            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 69, column: 6
                            faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                            currsigs.addElement(faultSolved_1);
                            S3912=0;
                            active[4]=0;
                            ends[4]=0;
                            tdone[4]=1;
                          }
                          else {
                            if(location_thread_4 == 8){//sysj\Orchestrator.sysj line: 71, column: 13
                              posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 72, column: 6
                              currsigs.addElement(posEightUpdate_1);
                              posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 72, column: 6
                              faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                              currsigs.addElement(faultSolved_1);
                              S3912=0;
                              active[4]=0;
                              ends[4]=0;
                              tdone[4]=1;
                            }
                            else {
                              faultSolved_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 5
                              currsigs.addElement(faultSolved_1);
                              S3912=0;
                              active[4]=0;
                              ends[4]=0;
                              tdone[4]=1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9386(int [] tdone, int [] ends){
        switch(S3886){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(faultSolved_1.getprestatus()){//sysj\Orchestrator.sysj line: 29, column: 11
          S3886=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          pauseFaultCheck_1.setPresent();//sysj\Orchestrator.sysj line: 30, column: 6
          currsigs.addElement(pauseFaultCheck_1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread9384(int [] tdone, int [] ends){
        S3912=1;
    location_thread_4 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 36, column: 5
    S3889=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread9383(int [] tdone, int [] ends){
        S3886=1;
    pauseFaultCheck_1.setPresent();//sysj\Orchestrator.sysj line: 30, column: 6
    currsigs.addElement(pauseFaultCheck_1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread9382(int [] tdone, int [] ends){
        switch(S4079){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3945){
          case 0 : 
            if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 26, column: 10
              S3945=1;
              thread9383(tdone,ends);
              thread9384(tdone,ends);
              int biggest9385 = 0;
              if(ends[3]>=biggest9385){
                biggest9385=ends[3];
              }
              if(ends[4]>=biggest9385){
                biggest9385=ends[4];
              }
              if(biggest9385 == 1){
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
            thread9386(tdone,ends);
            thread9387(tdone,ends);
            int biggest9388 = 0;
            if(ends[3]>=biggest9388){
              biggest9388=ends[3];
            }
            if(ends[4]>=biggest9388){
              biggest9388=ends[4];
            }
            if(biggest9388 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            //FINXME code
            if(biggest9388 == 0){
              S3945=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S3945=2;
            S3945=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread9380(int [] tdone, int [] ends){
        S9339=1;
    S9166=0;
    active[48]=1;
    ends[48]=1;
    tdone[48]=1;
  }

  public void thread9379(int [] tdone, int [] ends){
        S9165=1;
    b_thread_47 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 962, column: 4
    S8992=0;
    active[47]=1;
    ends[47]=1;
    tdone[47]=1;
  }

  public void thread9378(int [] tdone, int [] ends){
        S8991=1;
    b_thread_46 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 943, column: 4
    S8818=0;
    active[46]=1;
    ends[46]=1;
    tdone[46]=1;
  }

  public void thread9377(int [] tdone, int [] ends){
        S8817=1;
    b_thread_45 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 924, column: 4
    S8644=0;
    active[45]=1;
    ends[45]=1;
    tdone[45]=1;
  }

  public void thread9376(int [] tdone, int [] ends){
        S8643=1;
    b_thread_44 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 905, column: 4
    S8470=0;
    active[44]=1;
    ends[44]=1;
    tdone[44]=1;
  }

  public void thread9375(int [] tdone, int [] ends){
        S8469=1;
    b_thread_43 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 886, column: 4
    S8296=0;
    active[43]=1;
    ends[43]=1;
    tdone[43]=1;
  }

  public void thread9374(int [] tdone, int [] ends){
        S8295=1;
    b_thread_42 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 867, column: 4
    S8122=0;
    active[42]=1;
    ends[42]=1;
    tdone[42]=1;
  }

  public void thread9373(int [] tdone, int [] ends){
        S8121=1;
    b_thread_41 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 847, column: 4
    S7948=0;
    active[41]=1;
    ends[41]=1;
    tdone[41]=1;
  }

  public void thread9372(int [] tdone, int [] ends){
        S7947=1;
    b_thread_40 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 824, column: 4
    S7774=0;
    active[40]=1;
    ends[40]=1;
    tdone[40]=1;
  }

  public void thread9371(int [] tdone, int [] ends){
        S7773=1;
    b_thread_39 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 805, column: 4
    S7600=0;
    active[39]=1;
    ends[39]=1;
    tdone[39]=1;
  }

  public void thread9370(int [] tdone, int [] ends){
        S7599=1;
    S7581=0;
    active[38]=1;
    ends[38]=1;
    tdone[38]=1;
  }

  public void thread9369(int [] tdone, int [] ends){
        S7579=1;
    S7561=0;
    active[37]=1;
    ends[37]=1;
    tdone[37]=1;
  }

  public void thread9368(int [] tdone, int [] ends){
        S7559=1;
    S7541=0;
    active[36]=1;
    ends[36]=1;
    tdone[36]=1;
  }

  public void thread9367(int [] tdone, int [] ends){
        S7539=1;
    S7515=0;
    active[35]=1;
    ends[35]=1;
    tdone[35]=1;
  }

  public void thread9366(int [] tdone, int [] ends){
        S7513=1;
    S7495=0;
    active[34]=1;
    ends[34]=1;
    tdone[34]=1;
  }

  public void thread9365(int [] tdone, int [] ends){
        S7493=1;
    S7475=0;
    active[33]=1;
    ends[33]=1;
    tdone[33]=1;
  }

  public void thread9364(int [] tdone, int [] ends){
        S7473=1;
    S7449=0;
    active[32]=1;
    ends[32]=1;
    tdone[32]=1;
  }

  public void thread9363(int [] tdone, int [] ends){
        S7447=1;
    S7409=0;
    active[31]=1;
    ends[31]=1;
    tdone[31]=1;
  }

  public void thread9362(int [] tdone, int [] ends){
        S7397=1;
    S7359=0;
    active[30]=1;
    ends[30]=1;
    tdone[30]=1;
  }

  public void thread9361(int [] tdone, int [] ends){
        S7347=1;
    S7309=0;
    active[29]=1;
    ends[29]=1;
    tdone[29]=1;
  }

  public void thread9360(int [] tdone, int [] ends){
        S7297=1;
    S7271=0;
    active[28]=1;
    ends[28]=1;
    tdone[28]=1;
  }

  public void thread9359(int [] tdone, int [] ends){
        S7263=1;
    S7237=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread9358(int [] tdone, int [] ends){
        S7229=1;
    S7203=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread9357(int [] tdone, int [] ends){
        S7195=1;
    S7169=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread9356(int [] tdone, int [] ends){
        S7161=1;
    S7113=0;
    if(bottlePos9.getprestatus()){//sysj\Orchestrator.sysj line: 501, column: 13
      b_thread_24 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 502, column: 6
      if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 503, column: 10
        faulty_thread_24 = b_thread_24.Faulty;//sysj\Orchestrator.sysj line: 504, column: 7
        if(faulty_thread_24){//sysj\Orchestrator.sysj line: 505, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 506, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(9);//sysj\Orchestrator.sysj line: 506, column: 8
          id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 507, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 508, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 508, column: 8
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        else {
          S7113=1;
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
      }
      else {
        S7113=1;
        active[24]=1;
        ends[24]=1;
        tdone[24]=1;
      }
    }
    else {
      S7113=1;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread9355(int [] tdone, int [] ends){
        S7090=1;
    S7042=0;
    if(bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 477, column: 13
      b_thread_23 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 478, column: 6
      if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 479, column: 10
        faulty_thread_23 = b_thread_23.Faulty;//sysj\Orchestrator.sysj line: 480, column: 7
        if(faulty_thread_23){//sysj\Orchestrator.sysj line: 481, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 482, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(8);//sysj\Orchestrator.sysj line: 482, column: 8
          id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 483, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 484, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 484, column: 8
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        else {
          S7042=1;
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
      }
      else {
        S7042=1;
        active[23]=1;
        ends[23]=1;
        tdone[23]=1;
      }
    }
    else {
      S7042=1;
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread9354(int [] tdone, int [] ends){
        S7019=1;
    S6971=0;
    if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 453, column: 13
      b_thread_22 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 454, column: 6
      if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 455, column: 10
        faulty_thread_22 = b_thread_22.Faulty;//sysj\Orchestrator.sysj line: 456, column: 7
        if(faulty_thread_22){//sysj\Orchestrator.sysj line: 457, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 458, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(7);//sysj\Orchestrator.sysj line: 458, column: 8
          id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 459, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 460, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 460, column: 8
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        else {
          S6971=1;
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
      }
      else {
        S6971=1;
        active[22]=1;
        ends[22]=1;
        tdone[22]=1;
      }
    }
    else {
      S6971=1;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread9353(int [] tdone, int [] ends){
        S6948=1;
    S6900=0;
    if(bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 428, column: 13
      b_thread_21 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 429, column: 6
      if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 430, column: 10
        faulty_thread_21 = b_thread_21.Faulty;//sysj\Orchestrator.sysj line: 431, column: 7
        if(faulty_thread_21){//sysj\Orchestrator.sysj line: 432, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 433, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(6);//sysj\Orchestrator.sysj line: 433, column: 8
          id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 434, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 435, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 435, column: 8
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S6900=1;
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
      }
      else {
        S6900=1;
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
    }
    else {
      S6900=1;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread9352(int [] tdone, int [] ends){
        S6877=1;
    S6829=0;
    if(bottlePos5.getprestatus()){//sysj\Orchestrator.sysj line: 403, column: 13
      b_thread_20 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 404, column: 6
      if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 405, column: 10
        faulty_thread_20 = b_thread_20.Faulty;//sysj\Orchestrator.sysj line: 406, column: 7
        if(faulty_thread_20){//sysj\Orchestrator.sysj line: 407, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 408, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(5);//sysj\Orchestrator.sysj line: 408, column: 8
          id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 409, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 410, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 410, column: 8
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        else {
          S6829=1;
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
      }
      else {
        S6829=1;
        active[20]=1;
        ends[20]=1;
        tdone[20]=1;
      }
    }
    else {
      S6829=1;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread9351(int [] tdone, int [] ends){
        S6806=1;
    S6758=0;
    if(bottlePos4.getprestatus()){//sysj\Orchestrator.sysj line: 379, column: 13
      b_thread_19 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 380, column: 6
      if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 381, column: 10
        faulty_thread_19 = b_thread_19.Faulty;//sysj\Orchestrator.sysj line: 382, column: 7
        if(faulty_thread_19){//sysj\Orchestrator.sysj line: 383, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 384, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(4);//sysj\Orchestrator.sysj line: 384, column: 8
          id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 385, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 386, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 386, column: 8
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
        else {
          S6758=1;
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
      }
      else {
        S6758=1;
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
      }
    }
    else {
      S6758=1;
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread9350(int [] tdone, int [] ends){
        S6735=1;
    S6687=0;
    if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 355, column: 13
      b_thread_18 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 356, column: 6
      if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 357, column: 10
        faulty_thread_18 = b_thread_18.Faulty;//sysj\Orchestrator.sysj line: 358, column: 7
        if(faulty_thread_18){//sysj\Orchestrator.sysj line: 359, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 360, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(3);//sysj\Orchestrator.sysj line: 360, column: 8
          id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 361, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 362, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 362, column: 8
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        else {
          S6687=1;
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
      }
      else {
        S6687=1;
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
      }
    }
    else {
      S6687=1;
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread9349(int [] tdone, int [] ends){
        S6664=1;
    S6616=0;
    if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 331, column: 13
      b_thread_17 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 332, column: 6
      if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 333, column: 10
        faulty_thread_17 = b_thread_17.Faulty;//sysj\Orchestrator.sysj line: 334, column: 7
        if(faulty_thread_17){//sysj\Orchestrator.sysj line: 335, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 336, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(2);//sysj\Orchestrator.sysj line: 336, column: 8
          id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 337, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 338, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 338, column: 8
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        else {
          S6616=1;
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
      }
      else {
        S6616=1;
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
      }
    }
    else {
      S6616=1;
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread9348(int [] tdone, int [] ends){
        S6593=1;
    S6545=0;
    if(bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 13
      b_thread_16 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 305, column: 6
      if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 306, column: 10
        faulty_thread_16 = b_thread_16.Faulty;//sysj\Orchestrator.sysj line: 307, column: 7
        if(faulty_thread_16){//sysj\Orchestrator.sysj line: 308, column: 7
          System.err.println("fault pos1");//sysj\Orchestrator.sysj line: 309, column: 11
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 311, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(1);//sysj\Orchestrator.sysj line: 311, column: 8
          id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 312, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 313, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 313, column: 8
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        else {
          S6545=1;
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
      }
      else {
        S6545=1;
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
    }
    else {
      S6545=1;
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread9347(int [] tdone, int [] ends){
        S6522=1;
    S6474=0;
    if(bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 281, column: 13
      b_thread_15 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 282, column: 6
      if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 283, column: 10
        faulty_thread_15 = b_thread_15.Faulty;//sysj\Orchestrator.sysj line: 284, column: 7
        if(faulty_thread_15){//sysj\Orchestrator.sysj line: 285, column: 7
          fault_1.setPresent();//sysj\Orchestrator.sysj line: 286, column: 8
          currsigs.addElement(fault_1);
          fault_1.setValue(0);//sysj\Orchestrator.sysj line: 286, column: 8
          id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 287, column: 8
          faultUpdate.setPresent();//sysj\Orchestrator.sysj line: 288, column: 8
          currsigs.addElement(faultUpdate);
          faultUpdate.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 288, column: 8
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          S6474=1;
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
      }
      else {
        S6474=1;
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
      }
    }
    else {
      S6474=1;
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread9346(int [] tdone, int [] ends){
        S6451=1;
    if(fault_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 13
      pos_thread_7 = (int)(fault_1.getpreval() == null ? 0 : ((Integer)fault_1.getpreval()).intValue());//sysj\Orchestrator.sysj line: 186, column: 6
      stop_1.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
      currsigs.addElement(stop_1);
      stop_1.setValue(pos_thread_7);//sysj\Orchestrator.sysj line: 187, column: 6
      S5951=0;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S5951=0;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread9345(int [] tdone, int [] ends){
        S5945=1;
    S5889=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread9344(int [] tdone, int [] ends){
        S5887=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread9343(int [] tdone, int [] ends){
        S4079=1;
    S3945=0;
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
      switch(S9341){
        case 0 : 
          S9341=0;
          break RUN;
        
        case 1 : 
          S9341=2;
          S9341=2;
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          fault_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          stop_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          pauseFaultCheck_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          faultSolved_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          addFault_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          thread9343(tdone,ends);
          thread9344(tdone,ends);
          thread9345(tdone,ends);
          thread9346(tdone,ends);
          thread9347(tdone,ends);
          thread9348(tdone,ends);
          thread9349(tdone,ends);
          thread9350(tdone,ends);
          thread9351(tdone,ends);
          thread9352(tdone,ends);
          thread9353(tdone,ends);
          thread9354(tdone,ends);
          thread9355(tdone,ends);
          thread9356(tdone,ends);
          thread9357(tdone,ends);
          thread9358(tdone,ends);
          thread9359(tdone,ends);
          thread9360(tdone,ends);
          thread9361(tdone,ends);
          thread9362(tdone,ends);
          thread9363(tdone,ends);
          thread9364(tdone,ends);
          thread9365(tdone,ends);
          thread9366(tdone,ends);
          thread9367(tdone,ends);
          thread9368(tdone,ends);
          thread9369(tdone,ends);
          thread9370(tdone,ends);
          thread9371(tdone,ends);
          thread9372(tdone,ends);
          thread9373(tdone,ends);
          thread9374(tdone,ends);
          thread9375(tdone,ends);
          thread9376(tdone,ends);
          thread9377(tdone,ends);
          thread9378(tdone,ends);
          thread9379(tdone,ends);
          thread9380(tdone,ends);
          int biggest9381 = 0;
          if(ends[2]>=biggest9381){
            biggest9381=ends[2];
          }
          if(ends[5]>=biggest9381){
            biggest9381=ends[5];
          }
          if(ends[6]>=biggest9381){
            biggest9381=ends[6];
          }
          if(ends[7]>=biggest9381){
            biggest9381=ends[7];
          }
          if(ends[15]>=biggest9381){
            biggest9381=ends[15];
          }
          if(ends[16]>=biggest9381){
            biggest9381=ends[16];
          }
          if(ends[17]>=biggest9381){
            biggest9381=ends[17];
          }
          if(ends[18]>=biggest9381){
            biggest9381=ends[18];
          }
          if(ends[19]>=biggest9381){
            biggest9381=ends[19];
          }
          if(ends[20]>=biggest9381){
            biggest9381=ends[20];
          }
          if(ends[21]>=biggest9381){
            biggest9381=ends[21];
          }
          if(ends[22]>=biggest9381){
            biggest9381=ends[22];
          }
          if(ends[23]>=biggest9381){
            biggest9381=ends[23];
          }
          if(ends[24]>=biggest9381){
            biggest9381=ends[24];
          }
          if(ends[25]>=biggest9381){
            biggest9381=ends[25];
          }
          if(ends[26]>=biggest9381){
            biggest9381=ends[26];
          }
          if(ends[27]>=biggest9381){
            biggest9381=ends[27];
          }
          if(ends[28]>=biggest9381){
            biggest9381=ends[28];
          }
          if(ends[29]>=biggest9381){
            biggest9381=ends[29];
          }
          if(ends[30]>=biggest9381){
            biggest9381=ends[30];
          }
          if(ends[31]>=biggest9381){
            biggest9381=ends[31];
          }
          if(ends[32]>=biggest9381){
            biggest9381=ends[32];
          }
          if(ends[33]>=biggest9381){
            biggest9381=ends[33];
          }
          if(ends[34]>=biggest9381){
            biggest9381=ends[34];
          }
          if(ends[35]>=biggest9381){
            biggest9381=ends[35];
          }
          if(ends[36]>=biggest9381){
            biggest9381=ends[36];
          }
          if(ends[37]>=biggest9381){
            biggest9381=ends[37];
          }
          if(ends[38]>=biggest9381){
            biggest9381=ends[38];
          }
          if(ends[39]>=biggest9381){
            biggest9381=ends[39];
          }
          if(ends[40]>=biggest9381){
            biggest9381=ends[40];
          }
          if(ends[41]>=biggest9381){
            biggest9381=ends[41];
          }
          if(ends[42]>=biggest9381){
            biggest9381=ends[42];
          }
          if(ends[43]>=biggest9381){
            biggest9381=ends[43];
          }
          if(ends[44]>=biggest9381){
            biggest9381=ends[44];
          }
          if(ends[45]>=biggest9381){
            biggest9381=ends[45];
          }
          if(ends[46]>=biggest9381){
            biggest9381=ends[46];
          }
          if(ends[47]>=biggest9381){
            biggest9381=ends[47];
          }
          if(ends[48]>=biggest9381){
            biggest9381=ends[48];
          }
          if(biggest9381 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZeroUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posOneUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posTwoUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posThreeUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posFourUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posFiveUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posSixUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posSevenUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posEightUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          posNineUpdate_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          filling_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          capLoading_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRobotLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startRobotUnloaderThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startFillerThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          startCapperThread_1.setClear();//sysj\Orchestrator.sysj line: 18, column: 2
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkFiller_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkCapLoader_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          checkCapper_1.setClear();//sysj\Orchestrator.sysj line: 19, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          fillerFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          capLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          capperFinish_1.setClear();//sysj\Orchestrator.sysj line: 20, column: 2
          fault_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          stop_1.setClear();//sysj\Orchestrator.sysj line: 21, column: 2
          pauseFaultCheck_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          faultSolved_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          addFault_1.setClear();//sysj\Orchestrator.sysj line: 22, column: 2
          thread9382(tdone,ends);
          thread9389(tdone,ends);
          thread9390(tdone,ends);
          thread9391(tdone,ends);
          thread9410(tdone,ends);
          thread9411(tdone,ends);
          thread9412(tdone,ends);
          thread9413(tdone,ends);
          thread9414(tdone,ends);
          thread9415(tdone,ends);
          thread9416(tdone,ends);
          thread9417(tdone,ends);
          thread9418(tdone,ends);
          thread9419(tdone,ends);
          thread9420(tdone,ends);
          thread9421(tdone,ends);
          thread9422(tdone,ends);
          thread9423(tdone,ends);
          thread9424(tdone,ends);
          thread9425(tdone,ends);
          thread9426(tdone,ends);
          thread9427(tdone,ends);
          thread9428(tdone,ends);
          thread9429(tdone,ends);
          thread9430(tdone,ends);
          thread9431(tdone,ends);
          thread9432(tdone,ends);
          thread9433(tdone,ends);
          thread9434(tdone,ends);
          thread9435(tdone,ends);
          thread9436(tdone,ends);
          thread9437(tdone,ends);
          thread9438(tdone,ends);
          thread9439(tdone,ends);
          thread9440(tdone,ends);
          thread9441(tdone,ends);
          thread9442(tdone,ends);
          thread9443(tdone,ends);
          int biggest9444 = 0;
          if(ends[2]>=biggest9444){
            biggest9444=ends[2];
          }
          if(ends[5]>=biggest9444){
            biggest9444=ends[5];
          }
          if(ends[6]>=biggest9444){
            biggest9444=ends[6];
          }
          if(ends[7]>=biggest9444){
            biggest9444=ends[7];
          }
          if(ends[15]>=biggest9444){
            biggest9444=ends[15];
          }
          if(ends[16]>=biggest9444){
            biggest9444=ends[16];
          }
          if(ends[17]>=biggest9444){
            biggest9444=ends[17];
          }
          if(ends[18]>=biggest9444){
            biggest9444=ends[18];
          }
          if(ends[19]>=biggest9444){
            biggest9444=ends[19];
          }
          if(ends[20]>=biggest9444){
            biggest9444=ends[20];
          }
          if(ends[21]>=biggest9444){
            biggest9444=ends[21];
          }
          if(ends[22]>=biggest9444){
            biggest9444=ends[22];
          }
          if(ends[23]>=biggest9444){
            biggest9444=ends[23];
          }
          if(ends[24]>=biggest9444){
            biggest9444=ends[24];
          }
          if(ends[25]>=biggest9444){
            biggest9444=ends[25];
          }
          if(ends[26]>=biggest9444){
            biggest9444=ends[26];
          }
          if(ends[27]>=biggest9444){
            biggest9444=ends[27];
          }
          if(ends[28]>=biggest9444){
            biggest9444=ends[28];
          }
          if(ends[29]>=biggest9444){
            biggest9444=ends[29];
          }
          if(ends[30]>=biggest9444){
            biggest9444=ends[30];
          }
          if(ends[31]>=biggest9444){
            biggest9444=ends[31];
          }
          if(ends[32]>=biggest9444){
            biggest9444=ends[32];
          }
          if(ends[33]>=biggest9444){
            biggest9444=ends[33];
          }
          if(ends[34]>=biggest9444){
            biggest9444=ends[34];
          }
          if(ends[35]>=biggest9444){
            biggest9444=ends[35];
          }
          if(ends[36]>=biggest9444){
            biggest9444=ends[36];
          }
          if(ends[37]>=biggest9444){
            biggest9444=ends[37];
          }
          if(ends[38]>=biggest9444){
            biggest9444=ends[38];
          }
          if(ends[39]>=biggest9444){
            biggest9444=ends[39];
          }
          if(ends[40]>=biggest9444){
            biggest9444=ends[40];
          }
          if(ends[41]>=biggest9444){
            biggest9444=ends[41];
          }
          if(ends[42]>=biggest9444){
            biggest9444=ends[42];
          }
          if(ends[43]>=biggest9444){
            biggest9444=ends[43];
          }
          if(ends[44]>=biggest9444){
            biggest9444=ends[44];
          }
          if(ends[45]>=biggest9444){
            biggest9444=ends[45];
          }
          if(ends[46]>=biggest9444){
            biggest9444=ends[46];
          }
          if(ends[47]>=biggest9444){
            biggest9444=ends[47];
          }
          if(ends[48]>=biggest9444){
            biggest9444=ends[48];
          }
          if(biggest9444 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest9444 == 0){
            S9341=0;
            active[1]=0;
            ends[1]=0;
            S9341=0;
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
      showStartRemover.setpreclear();
      showStopRemover.setpreclear();
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
      showStartRemover.sethook();
      showStartRemover.setClear();
      showStopRemover.sethook();
      showStopRemover.setClear();
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
