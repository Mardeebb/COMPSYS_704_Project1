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
  private Signal robotLoaderFinish_1;
  private Signal conveyorFinish_1;
  private Signal rotTableFinish_1;
  private Signal robotUnloaderFinish_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 23, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin bEight_thread_8;//sysj\Orchestrator.sysj line: 170, column: 4
  private BottleTwin bZero_thread_9;//sysj\Orchestrator.sysj line: 194, column: 4
  private BottleTwin bFive_thread_9;//sysj\Orchestrator.sysj line: 195, column: 4
  private BottleTwin bOne_thread_10;//sysj\Orchestrator.sysj line: 220, column: 4
  private BottleTwin bTwo_thread_10;//sysj\Orchestrator.sysj line: 221, column: 4
  private BottleTwin bThree_thread_10;//sysj\Orchestrator.sysj line: 222, column: 4
  private BottleTwin bFour_thread_10;//sysj\Orchestrator.sysj line: 223, column: 4
  private BottleTwin bFive_thread_10;//sysj\Orchestrator.sysj line: 224, column: 4
  private BottleTwin bSix_thread_10;//sysj\Orchestrator.sysj line: 225, column: 4
  private BottleTwin bSeven_thread_11;//sysj\Orchestrator.sysj line: 248, column: 4
  private int id_thread_13;//sysj\Orchestrator.sysj line: 284, column: 5
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 281, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 303, column: 5
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 300, column: 4
  private int id_thread_15;//sysj\Orchestrator.sysj line: 326, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 323, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 346, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 343, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 365, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 362, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 384, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 381, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 403, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 400, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 422, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 419, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 441, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 438, column: 4
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 458, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 460, column: 5
  private int S2393 = 1;
  private int S371 = 1;
  private int S315 = 1;
  private int S316 = 1;
  private int S427 = 1;
  private int S375 = 1;
  private int S461 = 1;
  private int S435 = 1;
  private int S431 = 1;
  private int S495 = 1;
  private int S469 = 1;
  private int S465 = 1;
  private int S529 = 1;
  private int S503 = 1;
  private int S499 = 1;
  private int S563 = 1;
  private int S537 = 1;
  private int S533 = 1;
  private int S577 = 1;
  private int S565 = 1;
  private int S603 = 1;
  private int S579 = 1;
  private int S623 = 1;
  private int S605 = 1;
  private int S637 = 1;
  private int S625 = 1;
  private int S651 = 1;
  private int S639 = 1;
  private int S825 = 1;
  private int S652 = 1;
  private int S673 = 1;
  private int S999 = 1;
  private int S826 = 1;
  private int S847 = 1;
  private int S1173 = 1;
  private int S1000 = 1;
  private int S1021 = 1;
  private int S1347 = 1;
  private int S1174 = 1;
  private int S1195 = 1;
  private int S1521 = 1;
  private int S1348 = 1;
  private int S1369 = 1;
  private int S1695 = 1;
  private int S1522 = 1;
  private int S1543 = 1;
  private int S1869 = 1;
  private int S1696 = 1;
  private int S1717 = 1;
  private int S2043 = 1;
  private int S1870 = 1;
  private int S1891 = 1;
  private int S2217 = 1;
  private int S2044 = 1;
  private int S2065 = 1;
  private int S2391 = 1;
  private int S2218 = 1;
  private int S2239 = 1;
  
  private int[] ends = new int[23];
  private int[] tdone = new int[23];
  
  public void thread2437(int [] tdone, int [] ends){
        switch(S2391){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S2218){
          case 0 : 
            S2218=0;
            b_thread_22 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 458, column: 4
            S2218=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 459, column: 8
              S2239=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 460, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 462, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 462, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 463, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 463, column: 6
              System.out.println("Emitted bottlePos9");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S2239=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 466, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 466, column: 5
              System.out.println("Emitted bottlePos9B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S2239){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 461, column: 11
                  S2218=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 463, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 463, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 467, column: 11
                  S2218=0;
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

  public void thread2436(int [] tdone, int [] ends){
        switch(S2217){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2044){
          case 0 : 
            S2044=0;
            S2044=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 440, column: 8
              S2065=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 441, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 443, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 443, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 444, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 444, column: 6
              System.out.println("Emitted bottlePos8");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2065=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 447, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 447, column: 5
              System.out.println("Emitted bottlePos8B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S2065){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 442, column: 11
                  b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 438, column: 4
                  S2044=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 444, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 444, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 448, column: 11
                  b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 438, column: 4
                  S2044=0;
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

  public void thread2435(int [] tdone, int [] ends){
        switch(S2043){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S1870){
          case 0 : 
            S1870=0;
            S1870=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 421, column: 8
              S1891=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 422, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 424, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 424, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 425, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 425, column: 6
              System.out.println("Emitted bottlePos7");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S1891=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 428, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 428, column: 5
              System.out.println("Emitted bottlePos7B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S1891){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 423, column: 11
                  b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 419, column: 4
                  S1870=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 425, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 425, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 429, column: 11
                  b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 419, column: 4
                  S1870=0;
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

  public void thread2434(int [] tdone, int [] ends){
        switch(S1869){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1696){
          case 0 : 
            S1696=0;
            S1696=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 402, column: 8
              S1717=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 403, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 405, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 405, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 406, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 406, column: 6
              System.out.println("Emitted bottlePos6");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S1717=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 409, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 409, column: 5
              System.out.println("Emitted bottlePos6B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S1717){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 404, column: 11
                  b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 400, column: 4
                  S1696=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 406, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 406, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 410, column: 11
                  b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 400, column: 4
                  S1696=0;
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

  public void thread2433(int [] tdone, int [] ends){
        switch(S1695){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1522){
          case 0 : 
            S1522=0;
            S1522=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 383, column: 8
              S1543=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 384, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 386, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 386, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 387, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 387, column: 6
              System.out.println("Emitted bottlePos5");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S1543=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 390, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 390, column: 5
              System.out.println("Emitted bottlePos5B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S1543){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 385, column: 11
                  b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 381, column: 4
                  S1522=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 387, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 387, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 391, column: 11
                  b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 381, column: 4
                  S1522=0;
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

  public void thread2432(int [] tdone, int [] ends){
        switch(S1521){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1348){
          case 0 : 
            S1348=0;
            S1348=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 364, column: 8
              S1369=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 365, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 367, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 367, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 368, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 368, column: 6
              System.out.println("Emitted bottlePos4");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1369=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 371, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 371, column: 5
              System.out.println("Emitted bottlePos4B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S1369){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 366, column: 11
                  b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
                  S1348=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 368, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 368, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 372, column: 11
                  b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
                  S1348=0;
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

  public void thread2431(int [] tdone, int [] ends){
        switch(S1347){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1174){
          case 0 : 
            S1174=0;
            S1174=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 345, column: 8
              S1195=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 346, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 348, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 348, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 349, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 349, column: 6
              System.out.println("Emitted bottlePos3");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1195=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 352, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 352, column: 5
              System.out.println("Emitted bottlePos3B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S1195){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 11
                  b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
                  S1174=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 349, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 349, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 353, column: 11
                  b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
                  S1174=0;
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

  public void thread2430(int [] tdone, int [] ends){
        switch(S1173){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1000){
          case 0 : 
            S1000=0;
            S1000=1;
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 325, column: 8
              S1021=0;
              id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 326, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 328, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 328, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 329, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 329, column: 6
              System.out.println("Emitted bottlePos2");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1021=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 332, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 332, column: 5
              System.out.println("Emitted bottlePos2B");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S1021){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 327, column: 11
                  b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 323, column: 4
                  S1000=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 329, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 329, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 333, column: 11
                  b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 323, column: 4
                  S1000=0;
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

  public void thread2429(int [] tdone, int [] ends){
        switch(S999){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S826){
          case 0 : 
            S826=0;
            S826=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 302, column: 8
              S847=0;
              id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 303, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 305, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 305, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 307, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 307, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 308, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 308, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S847=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 313, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 313, column: 5
              System.out.println("Emitted bottlePos1B");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S847){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 11
                  b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 300, column: 4
                  S826=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 307, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 307, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 308, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 308, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 314, column: 11
                  b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 300, column: 4
                  S826=0;
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

  public void thread2428(int [] tdone, int [] ends){
        switch(S825){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S652){
          case 0 : 
            S652=0;
            S652=1;
            if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 283, column: 8
              S673=0;
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 284, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 286, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_13);//sysj\Orchestrator.sysj line: 286, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 287, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 287, column: 6
              System.out.println("Emitted bottlePos0");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S673=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 290, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 290, column: 5
              System.out.println("Emitted bottlePos0B");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S673){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 285, column: 11
                  b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 281, column: 4
                  S652=0;
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 287, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 287, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 291, column: 11
                  b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 281, column: 4
                  S652=0;
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
        break;
      
    }
  }

  public void thread2427(int [] tdone, int [] ends){
        switch(S651){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S639){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 265, column: 10
              S639=1;
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
            S639=1;
            startFilling.setPresent();//sysj\Orchestrator.sysj line: 268, column: 4
            currsigs.addElement(startFilling);
            System.out.println("Emitted startFilling");
            S639=2;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 269, column: 10
              S639=0;
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

  public void thread2426(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S625){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 246, column: 10
              bSeven_thread_11 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 248, column: 4
              S625=1;
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
            S625=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 250, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 250, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 251, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_11);//sysj\Orchestrator.sysj line: 251, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S625=2;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            S625=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 254, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S625=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 255, column: 10
              S625=0;
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

  public void thread2425(int [] tdone, int [] ends){
        switch(S623){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S605){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 215, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 218, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S605=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 219, column: 10
              bOne_thread_10 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 220, column: 4
              bTwo_thread_10 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 221, column: 4
              bThree_thread_10 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 222, column: 4
              bFour_thread_10 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 223, column: 4
              bFive_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 224, column: 4
              bSix_thread_10 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 225, column: 4
              S605=2;
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
            S605=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 227, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_10);//sysj\Orchestrator.sysj line: 227, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 228, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_10);//sysj\Orchestrator.sysj line: 228, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 229, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_10);//sysj\Orchestrator.sysj line: 229, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 230, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_10);//sysj\Orchestrator.sysj line: 230, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 231, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_10);//sysj\Orchestrator.sysj line: 231, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 232, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_10);//sysj\Orchestrator.sysj line: 232, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S605=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            S605=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 235, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S605=4;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 236, column: 10
              S605=0;
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

  public void thread2424(int [] tdone, int [] ends){
        switch(S603){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S579){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 188, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 191, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S579=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 192, column: 10
              bZero_thread_9 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 194, column: 4
              bFive_thread_9 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 195, column: 4
              S579=2;
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
          
          case 2 : 
            S579=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 197, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 197, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 198, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 198, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 199, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_9);//sysj\Orchestrator.sysj line: 199, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_9);//sysj\Orchestrator.sysj line: 200, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S579=3;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 3 : 
            S579=3;
            S579=4;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 4 : 
            if(!posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 203, column: 10
              conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 204, column: 4
              currsigs.addElement(conveyorFinish_1);
              System.out.println("Emitted conveyorFinish_1");
              S579=5;
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
          
          case 5 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 205, column: 10
              S579=0;
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

  public void thread2423(int [] tdone, int [] ends){
        switch(S577){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S565){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 168, column: 10
              bEight_thread_8 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 170, column: 4
              S565=1;
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
            S565=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 172, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 172, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 173, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_8);//sysj\Orchestrator.sysj line: 173, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S565=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S565=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 176, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S565=3;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 177, column: 10
              S565=0;
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

  public void thread2422(int [] tdone, int [] ends){
        switch(S563){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S537){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 152, column: 10
              S537=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 153, column: 12
                S533=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 154, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S533=1;
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
            switch(S533){
              case 0 : 
                S537=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 158, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S537=0;
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

  public void thread2421(int [] tdone, int [] ends){
        switch(S529){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S503){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 135, column: 10
              S503=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 137, column: 12
                S499=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 138, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S499=1;
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
            switch(S499){
              case 0 : 
                S503=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 142, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S503=0;
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

  public void thread2420(int [] tdone, int [] ends){
        switch(S495){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S469){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 120, column: 10
              S469=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 121, column: 12
                S465=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 122, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S465=1;
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
            switch(S465){
              case 0 : 
                S469=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 126, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S469=0;
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

  public void thread2419(int [] tdone, int [] ends){
        switch(S461){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S435){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 105, column: 10
              S435=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 106, column: 12
                S431=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 107, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S431=1;
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
            switch(S431){
              case 0 : 
                S435=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S435=0;
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

  public void thread2418(int [] tdone, int [] ends){
        switch(S427){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S375){
          case 0 : 
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
              S375=1;
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
              checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 4
              currsigs.addElement(checkRobotLoader_1);
              System.out.println("Emitted checkRobotLoader_1");
              S375=2;
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
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 54, column: 10
              S375=3;
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
            S375=3;
            S375=4;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            S375=4;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S375=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S375=6;
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
            S375=6;
            S375=7;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 7 : 
            S375=7;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 67, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S375=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 68, column: 10
              S375=9;
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
            S375=9;
            S375=10;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 10 : 
            S375=10;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 72, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S375=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 73, column: 10
              S375=12;
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
            S375=12;
            S375=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            S375=13;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 77, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S375=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 78, column: 10
              S375=15;
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
            S375=15;
            S375=16;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 16 : 
            S375=16;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 82, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S375=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 83, column: 10
              S375=18;
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
            S375=18;
            S375=19;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 19 : 
            S375=19;
            checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 90, column: 4
            currsigs.addElement(checkRotTable_1);
            System.out.println("Emitted checkRotTable_1");
            S375=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 91, column: 10
              S375=21;
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
            S375=21;
            S375=22;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 22 : 
            S375=22;
            S375=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2417(int [] tdone, int [] ends){
        switch(S371){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S315){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S315=1;
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
                S316=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S315=0;
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
            switch(S316){
              case 0 : 
                S316=0;
                S316=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S316=1;
                S316=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S316=3;
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
                  S315=0;
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

  public void thread2415(int [] tdone, int [] ends){
        S2391=1;
    S2218=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread2414(int [] tdone, int [] ends){
        S2217=1;
    b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 438, column: 4
    S2044=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2413(int [] tdone, int [] ends){
        S2043=1;
    b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 419, column: 4
    S1870=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2412(int [] tdone, int [] ends){
        S1869=1;
    b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 400, column: 4
    S1696=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2411(int [] tdone, int [] ends){
        S1695=1;
    b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 381, column: 4
    S1522=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2410(int [] tdone, int [] ends){
        S1521=1;
    b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 362, column: 4
    S1348=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2409(int [] tdone, int [] ends){
        S1347=1;
    b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 343, column: 4
    S1174=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2408(int [] tdone, int [] ends){
        S1173=1;
    b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 323, column: 4
    S1000=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2407(int [] tdone, int [] ends){
        S999=1;
    b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 300, column: 4
    S826=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2406(int [] tdone, int [] ends){
        S825=1;
    b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 281, column: 4
    S652=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2405(int [] tdone, int [] ends){
        S651=1;
    S639=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2404(int [] tdone, int [] ends){
        S637=1;
    S625=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2403(int [] tdone, int [] ends){
        S623=1;
    S605=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2402(int [] tdone, int [] ends){
        S603=1;
    S579=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2401(int [] tdone, int [] ends){
        S577=1;
    S565=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2400(int [] tdone, int [] ends){
        S563=1;
    S537=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2399(int [] tdone, int [] ends){
        S529=1;
    S503=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2398(int [] tdone, int [] ends){
        S495=1;
    S469=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2397(int [] tdone, int [] ends){
        S461=1;
    S435=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2396(int [] tdone, int [] ends){
        S427=1;
    S375=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2395(int [] tdone, int [] ends){
        S371=1;
    S315=0;
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
      switch(S2393){
        case 0 : 
          S2393=0;
          break RUN;
        
        case 1 : 
          S2393=2;
          S2393=2;
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
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2395(tdone,ends);
          thread2396(tdone,ends);
          thread2397(tdone,ends);
          thread2398(tdone,ends);
          thread2399(tdone,ends);
          thread2400(tdone,ends);
          thread2401(tdone,ends);
          thread2402(tdone,ends);
          thread2403(tdone,ends);
          thread2404(tdone,ends);
          thread2405(tdone,ends);
          thread2406(tdone,ends);
          thread2407(tdone,ends);
          thread2408(tdone,ends);
          thread2409(tdone,ends);
          thread2410(tdone,ends);
          thread2411(tdone,ends);
          thread2412(tdone,ends);
          thread2413(tdone,ends);
          thread2414(tdone,ends);
          thread2415(tdone,ends);
          int biggest2416 = 0;
          if(ends[2]>=biggest2416){
            biggest2416=ends[2];
          }
          if(ends[3]>=biggest2416){
            biggest2416=ends[3];
          }
          if(ends[4]>=biggest2416){
            biggest2416=ends[4];
          }
          if(ends[5]>=biggest2416){
            biggest2416=ends[5];
          }
          if(ends[6]>=biggest2416){
            biggest2416=ends[6];
          }
          if(ends[7]>=biggest2416){
            biggest2416=ends[7];
          }
          if(ends[8]>=biggest2416){
            biggest2416=ends[8];
          }
          if(ends[9]>=biggest2416){
            biggest2416=ends[9];
          }
          if(ends[10]>=biggest2416){
            biggest2416=ends[10];
          }
          if(ends[11]>=biggest2416){
            biggest2416=ends[11];
          }
          if(ends[12]>=biggest2416){
            biggest2416=ends[12];
          }
          if(ends[13]>=biggest2416){
            biggest2416=ends[13];
          }
          if(ends[14]>=biggest2416){
            biggest2416=ends[14];
          }
          if(ends[15]>=biggest2416){
            biggest2416=ends[15];
          }
          if(ends[16]>=biggest2416){
            biggest2416=ends[16];
          }
          if(ends[17]>=biggest2416){
            biggest2416=ends[17];
          }
          if(ends[18]>=biggest2416){
            biggest2416=ends[18];
          }
          if(ends[19]>=biggest2416){
            biggest2416=ends[19];
          }
          if(ends[20]>=biggest2416){
            biggest2416=ends[20];
          }
          if(ends[21]>=biggest2416){
            biggest2416=ends[21];
          }
          if(ends[22]>=biggest2416){
            biggest2416=ends[22];
          }
          if(biggest2416 == 1){
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
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2417(tdone,ends);
          thread2418(tdone,ends);
          thread2419(tdone,ends);
          thread2420(tdone,ends);
          thread2421(tdone,ends);
          thread2422(tdone,ends);
          thread2423(tdone,ends);
          thread2424(tdone,ends);
          thread2425(tdone,ends);
          thread2426(tdone,ends);
          thread2427(tdone,ends);
          thread2428(tdone,ends);
          thread2429(tdone,ends);
          thread2430(tdone,ends);
          thread2431(tdone,ends);
          thread2432(tdone,ends);
          thread2433(tdone,ends);
          thread2434(tdone,ends);
          thread2435(tdone,ends);
          thread2436(tdone,ends);
          thread2437(tdone,ends);
          int biggest2438 = 0;
          if(ends[2]>=biggest2438){
            biggest2438=ends[2];
          }
          if(ends[3]>=biggest2438){
            biggest2438=ends[3];
          }
          if(ends[4]>=biggest2438){
            biggest2438=ends[4];
          }
          if(ends[5]>=biggest2438){
            biggest2438=ends[5];
          }
          if(ends[6]>=biggest2438){
            biggest2438=ends[6];
          }
          if(ends[7]>=biggest2438){
            biggest2438=ends[7];
          }
          if(ends[8]>=biggest2438){
            biggest2438=ends[8];
          }
          if(ends[9]>=biggest2438){
            biggest2438=ends[9];
          }
          if(ends[10]>=biggest2438){
            biggest2438=ends[10];
          }
          if(ends[11]>=biggest2438){
            biggest2438=ends[11];
          }
          if(ends[12]>=biggest2438){
            biggest2438=ends[12];
          }
          if(ends[13]>=biggest2438){
            biggest2438=ends[13];
          }
          if(ends[14]>=biggest2438){
            biggest2438=ends[14];
          }
          if(ends[15]>=biggest2438){
            biggest2438=ends[15];
          }
          if(ends[16]>=biggest2438){
            biggest2438=ends[16];
          }
          if(ends[17]>=biggest2438){
            biggest2438=ends[17];
          }
          if(ends[18]>=biggest2438){
            biggest2438=ends[18];
          }
          if(ends[19]>=biggest2438){
            biggest2438=ends[19];
          }
          if(ends[20]>=biggest2438){
            biggest2438=ends[20];
          }
          if(ends[21]>=biggest2438){
            biggest2438=ends[21];
          }
          if(ends[22]>=biggest2438){
            biggest2438=ends[22];
          }
          if(biggest2438 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2438 == 0){
            S2393=0;
            active[1]=0;
            ends[1]=0;
            S2393=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    robotLoaderFinish_1 = new Signal();
    conveyorFinish_1 = new Signal();
    rotTableFinish_1 = new Signal();
    robotUnloaderFinish_1 = new Signal();
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
      robotLoaderFinish_1.setpreclear();
      conveyorFinish_1.setpreclear();
      rotTableFinish_1.setpreclear();
      robotUnloaderFinish_1.setpreclear();
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
      robotLoaderFinish_1.setClear();
      conveyorFinish_1.setClear();
      rotTableFinish_1.setClear();
      robotUnloaderFinish_1.setClear();
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
