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
  private BottleTwin bEight_thread_8;//sysj\Orchestrator.sysj line: 174, column: 4
  private BottleTwin bZero_thread_9;//sysj\Orchestrator.sysj line: 194, column: 4
  private BottleTwin bFive_thread_9;//sysj\Orchestrator.sysj line: 195, column: 4
  private BottleTwin bOne_thread_10;//sysj\Orchestrator.sysj line: 218, column: 4
  private BottleTwin bTwo_thread_10;//sysj\Orchestrator.sysj line: 219, column: 4
  private BottleTwin bThree_thread_10;//sysj\Orchestrator.sysj line: 220, column: 4
  private BottleTwin bFour_thread_10;//sysj\Orchestrator.sysj line: 221, column: 4
  private BottleTwin bFive_thread_10;//sysj\Orchestrator.sysj line: 222, column: 4
  private BottleTwin bSix_thread_10;//sysj\Orchestrator.sysj line: 223, column: 4
  private BottleTwin bSeven_thread_11;//sysj\Orchestrator.sysj line: 246, column: 4
  private int id_thread_13;//sysj\Orchestrator.sysj line: 282, column: 5
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 279, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 301, column: 5
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 298, column: 4
  private int id_thread_15;//sysj\Orchestrator.sysj line: 320, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 317, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 340, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 337, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 359, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 356, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 378, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 375, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 397, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 394, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 416, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 413, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 435, column: 5
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 432, column: 4
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 452, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 454, column: 5
  private int S2149 = 1;
  private int S139 = 1;
  private int S83 = 1;
  private int S84 = 1;
  private int S195 = 1;
  private int S143 = 1;
  private int S229 = 1;
  private int S203 = 1;
  private int S199 = 1;
  private int S263 = 1;
  private int S237 = 1;
  private int S233 = 1;
  private int S297 = 1;
  private int S271 = 1;
  private int S267 = 1;
  private int S331 = 1;
  private int S305 = 1;
  private int S301 = 1;
  private int S345 = 1;
  private int S333 = 1;
  private int S365 = 1;
  private int S347 = 1;
  private int S379 = 1;
  private int S367 = 1;
  private int S393 = 1;
  private int S381 = 1;
  private int S407 = 1;
  private int S395 = 1;
  private int S581 = 1;
  private int S408 = 1;
  private int S429 = 1;
  private int S755 = 1;
  private int S582 = 1;
  private int S603 = 1;
  private int S929 = 1;
  private int S756 = 1;
  private int S777 = 1;
  private int S1103 = 1;
  private int S930 = 1;
  private int S951 = 1;
  private int S1277 = 1;
  private int S1104 = 1;
  private int S1125 = 1;
  private int S1451 = 1;
  private int S1278 = 1;
  private int S1299 = 1;
  private int S1625 = 1;
  private int S1452 = 1;
  private int S1473 = 1;
  private int S1799 = 1;
  private int S1626 = 1;
  private int S1647 = 1;
  private int S1973 = 1;
  private int S1800 = 1;
  private int S1821 = 1;
  private int S2147 = 1;
  private int S1974 = 1;
  private int S1995 = 1;
  
  private int[] ends = new int[23];
  private int[] tdone = new int[23];
  
  public void thread2193(int [] tdone, int [] ends){
        switch(S2147){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S1974){
          case 0 : 
            S1974=0;
            b_thread_22 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 452, column: 4
            S1974=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 453, column: 8
              S1995=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 454, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 456, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 456, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 457, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 457, column: 6
              System.out.println("Emitted bottlePos9");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S1995=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 460, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 460, column: 5
              System.out.println("Emitted bottlePos9B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S1995){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 455, column: 11
                  S1974=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 457, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 457, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 461, column: 11
                  S1974=0;
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

  public void thread2192(int [] tdone, int [] ends){
        switch(S1973){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1800){
          case 0 : 
            S1800=0;
            S1800=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 434, column: 8
              S1821=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 435, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 437, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 437, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 438, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 438, column: 6
              System.out.println("Emitted bottlePos8");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S1821=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 441, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 441, column: 5
              System.out.println("Emitted bottlePos8B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S1821){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 436, column: 11
                  b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
                  S1800=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 438, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 438, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 442, column: 11
                  b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
                  S1800=0;
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

  public void thread2191(int [] tdone, int [] ends){
        switch(S1799){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S1626){
          case 0 : 
            S1626=0;
            S1626=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 415, column: 8
              S1647=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 416, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 418, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 418, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 419, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 419, column: 6
              System.out.println("Emitted bottlePos7");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S1647=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 422, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 422, column: 5
              System.out.println("Emitted bottlePos7B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S1647){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 417, column: 11
                  b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
                  S1626=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 419, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 419, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 423, column: 11
                  b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
                  S1626=0;
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

  public void thread2190(int [] tdone, int [] ends){
        switch(S1625){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1452){
          case 0 : 
            S1452=0;
            S1452=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 396, column: 8
              S1473=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 397, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 399, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 399, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 400, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 400, column: 6
              System.out.println("Emitted bottlePos6");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S1473=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 403, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 403, column: 5
              System.out.println("Emitted bottlePos6B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S1473){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 398, column: 11
                  b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 394, column: 4
                  S1452=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 400, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 400, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 404, column: 11
                  b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 394, column: 4
                  S1452=0;
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

  public void thread2189(int [] tdone, int [] ends){
        switch(S1451){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1278){
          case 0 : 
            S1278=0;
            S1278=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 377, column: 8
              S1299=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 378, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 380, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 380, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 381, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 381, column: 6
              System.out.println("Emitted bottlePos5");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S1299=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 384, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 384, column: 5
              System.out.println("Emitted bottlePos5B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S1299){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 379, column: 11
                  b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 375, column: 4
                  S1278=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 381, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 381, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 385, column: 11
                  b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 375, column: 4
                  S1278=0;
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

  public void thread2188(int [] tdone, int [] ends){
        switch(S1277){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1104){
          case 0 : 
            S1104=0;
            S1104=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 358, column: 8
              S1125=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 359, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 361, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 361, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 362, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 362, column: 6
              System.out.println("Emitted bottlePos4");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1125=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 365, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 365, column: 5
              System.out.println("Emitted bottlePos4B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S1125){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 360, column: 11
                  b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 356, column: 4
                  S1104=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 362, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 362, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 366, column: 11
                  b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 356, column: 4
                  S1104=0;
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

  public void thread2187(int [] tdone, int [] ends){
        switch(S1103){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S930){
          case 0 : 
            S930=0;
            S930=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 339, column: 8
              S951=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 340, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 342, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 342, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 343, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 343, column: 6
              System.out.println("Emitted bottlePos3");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S951=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 346, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 346, column: 5
              System.out.println("Emitted bottlePos3B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S951){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 341, column: 11
                  b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 337, column: 4
                  S930=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 343, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 343, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 11
                  b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 337, column: 4
                  S930=0;
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

  public void thread2186(int [] tdone, int [] ends){
        switch(S929){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S756){
          case 0 : 
            S756=0;
            S756=1;
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 319, column: 8
              S777=0;
              id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 320, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 322, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 322, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 323, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 323, column: 6
              System.out.println("Emitted bottlePos2");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S777=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 326, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 326, column: 5
              System.out.println("Emitted bottlePos2B");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S777){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 321, column: 11
                  b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 317, column: 4
                  S756=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 323, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 323, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 327, column: 11
                  b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 317, column: 4
                  S756=0;
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

  public void thread2185(int [] tdone, int [] ends){
        switch(S755){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S582){
          case 0 : 
            S582=0;
            S582=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 300, column: 8
              S603=0;
              id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 301, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 303, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 303, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 304, column: 6
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 304, column: 6
              System.out.println("Emitted bottlePos1");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S603=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 307, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 307, column: 5
              System.out.println("Emitted bottlePos1B");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S603){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 302, column: 11
                  b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 298, column: 4
                  S582=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 304, column: 6
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 304, column: 6
                  System.out.println("Emitted bottlePos1");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 308, column: 11
                  b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 298, column: 4
                  S582=0;
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

  public void thread2184(int [] tdone, int [] ends){
        switch(S581){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S408){
          case 0 : 
            S408=0;
            S408=1;
            if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 281, column: 8
              S429=0;
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 282, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 284, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_13);//sysj\Orchestrator.sysj line: 284, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 285, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 285, column: 6
              System.out.println("Emitted bottlePos0");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S429=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 288, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 288, column: 5
              System.out.println("Emitted bottlePos0B");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S429){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 283, column: 11
                  b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 279, column: 4
                  S408=0;
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 285, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 285, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 289, column: 11
                  b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 279, column: 4
                  S408=0;
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

  public void thread2183(int [] tdone, int [] ends){
        switch(S407){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S395){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 263, column: 10
              S395=1;
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
            S395=1;
            startFilling.setPresent();//sysj\Orchestrator.sysj line: 266, column: 4
            currsigs.addElement(startFilling);
            System.out.println("Emitted startFilling");
            S395=2;
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 267, column: 10
              S395=0;
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

  public void thread2182(int [] tdone, int [] ends){
        switch(S393){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S381){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 244, column: 10
              bSeven_thread_11 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 246, column: 4
              S381=1;
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
            S381=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 248, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 248, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 249, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_11);//sysj\Orchestrator.sysj line: 249, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S381=2;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            S381=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 252, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S381=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 253, column: 10
              S381=0;
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

  public void thread2181(int [] tdone, int [] ends){
        switch(S379){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S367){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 215, column: 10
              bOne_thread_10 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 218, column: 4
              bTwo_thread_10 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 219, column: 4
              bThree_thread_10 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 220, column: 4
              bFour_thread_10 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 221, column: 4
              bFive_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 222, column: 4
              bSix_thread_10 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 223, column: 4
              S367=1;
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
            S367=1;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 225, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_10);//sysj\Orchestrator.sysj line: 225, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 226, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_10);//sysj\Orchestrator.sysj line: 226, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 227, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_10);//sysj\Orchestrator.sysj line: 227, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 228, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_10);//sysj\Orchestrator.sysj line: 228, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 229, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_10);//sysj\Orchestrator.sysj line: 229, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 230, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_10);//sysj\Orchestrator.sysj line: 230, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S367=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S367=2;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 233, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S367=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 234, column: 10
              S367=0;
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

  public void thread2180(int [] tdone, int [] ends){
        switch(S365){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S347){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 192, column: 10
              bZero_thread_9 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 194, column: 4
              bFive_thread_9 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 195, column: 4
              S347=1;
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
            S347=1;
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
            S347=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S347=2;
            S347=3;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 3 : 
            if(!posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 203, column: 10
              conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 204, column: 4
              currsigs.addElement(conveyorFinish_1);
              System.out.println("Emitted conveyorFinish_1");
              S347=4;
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
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 205, column: 10
              S347=0;
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

  public void thread2179(int [] tdone, int [] ends){
        switch(S345){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S333){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 172, column: 10
              bEight_thread_8 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 174, column: 4
              S333=1;
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
            S333=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 176, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 176, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 177, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_8);//sysj\Orchestrator.sysj line: 177, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S333=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S333=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 180, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S333=3;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 181, column: 10
              S333=0;
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

  public void thread2178(int [] tdone, int [] ends){
        switch(S331){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S305){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 156, column: 10
              S305=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 157, column: 12
                S301=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 158, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S301=1;
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
            switch(S301){
              case 0 : 
                S305=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 162, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S305=0;
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

  public void thread2177(int [] tdone, int [] ends){
        switch(S297){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S271){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 139, column: 10
              S271=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 141, column: 12
                S267=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 142, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S267=1;
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
            switch(S267){
              case 0 : 
                S271=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 146, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S271=0;
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

  public void thread2176(int [] tdone, int [] ends){
        switch(S263){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S237){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 124, column: 10
              S237=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 125, column: 12
                S233=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 126, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S233=1;
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
            switch(S233){
              case 0 : 
                S237=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 130, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S237=0;
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

  public void thread2175(int [] tdone, int [] ends){
        switch(S229){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S203){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 109, column: 10
              S203=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 110, column: 12
                S199=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S199=1;
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
            switch(S199){
              case 0 : 
                S203=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 115, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S203=0;
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

  public void thread2174(int [] tdone, int [] ends){
        switch(S195){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S143){
          case 0 : 
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
              S143=1;
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
              checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 57, column: 4
              currsigs.addElement(checkRobotLoader_1);
              System.out.println("Emitted checkRobotLoader_1");
              S143=2;
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
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 58, column: 10
              S143=3;
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
            S143=3;
            S143=4;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            S143=4;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 62, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S143=5;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 5 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 63, column: 10
              S143=6;
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
            S143=6;
            S143=7;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 7 : 
            S143=7;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 71, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S143=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 72, column: 10
              S143=9;
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
            S143=9;
            S143=10;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 10 : 
            S143=10;
            checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 76, column: 4
            currsigs.addElement(checkRobotLoader_1);
            System.out.println("Emitted checkRobotLoader_1");
            S143=11;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 11 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 77, column: 10
              S143=12;
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
            S143=12;
            S143=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            S143=13;
            checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 81, column: 4
            currsigs.addElement(checkRobotUnloader_1);
            System.out.println("Emitted checkRobotUnloader_1");
            S143=14;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 14 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 82, column: 10
              S143=15;
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
            S143=15;
            S143=16;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 16 : 
            S143=16;
            checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 86, column: 4
            currsigs.addElement(checkConveyor_1);
            System.out.println("Emitted checkConveyor_1");
            S143=17;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 17 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 87, column: 10
              S143=18;
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
            S143=18;
            S143=19;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 19 : 
            S143=19;
            checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 94, column: 4
            currsigs.addElement(checkRotTable_1);
            System.out.println("Emitted checkRotTable_1");
            S143=20;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 20 : 
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 95, column: 10
              S143=21;
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
            S143=21;
            S143=22;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 22 : 
            S143=22;
            S143=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2173(int [] tdone, int [] ends){
        switch(S139){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S83){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S83=1;
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
                S84=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S83=0;
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
            switch(S84){
              case 0 : 
                S84=0;
                S84=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S84=1;
                S84=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S84=3;
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
                  S83=0;
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

  public void thread2171(int [] tdone, int [] ends){
        S2147=1;
    S1974=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread2170(int [] tdone, int [] ends){
        S1973=1;
    b_thread_21 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 432, column: 4
    S1800=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2169(int [] tdone, int [] ends){
        S1799=1;
    b_thread_20 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 413, column: 4
    S1626=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2168(int [] tdone, int [] ends){
        S1625=1;
    b_thread_19 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 394, column: 4
    S1452=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2167(int [] tdone, int [] ends){
        S1451=1;
    b_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 375, column: 4
    S1278=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2166(int [] tdone, int [] ends){
        S1277=1;
    b_thread_17 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 356, column: 4
    S1104=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2165(int [] tdone, int [] ends){
        S1103=1;
    b_thread_16 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 337, column: 4
    S930=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2164(int [] tdone, int [] ends){
        S929=1;
    b_thread_15 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 317, column: 4
    S756=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2163(int [] tdone, int [] ends){
        S755=1;
    b_thread_14 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 298, column: 4
    S582=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2162(int [] tdone, int [] ends){
        S581=1;
    b_thread_13 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 279, column: 4
    S408=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2161(int [] tdone, int [] ends){
        S407=1;
    S395=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2160(int [] tdone, int [] ends){
        S393=1;
    S381=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2159(int [] tdone, int [] ends){
        S379=1;
    S367=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2158(int [] tdone, int [] ends){
        S365=1;
    S347=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2157(int [] tdone, int [] ends){
        S345=1;
    S333=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2156(int [] tdone, int [] ends){
        S331=1;
    S305=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2155(int [] tdone, int [] ends){
        S297=1;
    S271=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2154(int [] tdone, int [] ends){
        S263=1;
    S237=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2153(int [] tdone, int [] ends){
        S229=1;
    S203=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2152(int [] tdone, int [] ends){
        S195=1;
    S143=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2151(int [] tdone, int [] ends){
        S139=1;
    S83=0;
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
      switch(S2149){
        case 0 : 
          S2149=0;
          break RUN;
        
        case 1 : 
          S2149=2;
          S2149=2;
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
          thread2151(tdone,ends);
          thread2152(tdone,ends);
          thread2153(tdone,ends);
          thread2154(tdone,ends);
          thread2155(tdone,ends);
          thread2156(tdone,ends);
          thread2157(tdone,ends);
          thread2158(tdone,ends);
          thread2159(tdone,ends);
          thread2160(tdone,ends);
          thread2161(tdone,ends);
          thread2162(tdone,ends);
          thread2163(tdone,ends);
          thread2164(tdone,ends);
          thread2165(tdone,ends);
          thread2166(tdone,ends);
          thread2167(tdone,ends);
          thread2168(tdone,ends);
          thread2169(tdone,ends);
          thread2170(tdone,ends);
          thread2171(tdone,ends);
          int biggest2172 = 0;
          if(ends[2]>=biggest2172){
            biggest2172=ends[2];
          }
          if(ends[3]>=biggest2172){
            biggest2172=ends[3];
          }
          if(ends[4]>=biggest2172){
            biggest2172=ends[4];
          }
          if(ends[5]>=biggest2172){
            biggest2172=ends[5];
          }
          if(ends[6]>=biggest2172){
            biggest2172=ends[6];
          }
          if(ends[7]>=biggest2172){
            biggest2172=ends[7];
          }
          if(ends[8]>=biggest2172){
            biggest2172=ends[8];
          }
          if(ends[9]>=biggest2172){
            biggest2172=ends[9];
          }
          if(ends[10]>=biggest2172){
            biggest2172=ends[10];
          }
          if(ends[11]>=biggest2172){
            biggest2172=ends[11];
          }
          if(ends[12]>=biggest2172){
            biggest2172=ends[12];
          }
          if(ends[13]>=biggest2172){
            biggest2172=ends[13];
          }
          if(ends[14]>=biggest2172){
            biggest2172=ends[14];
          }
          if(ends[15]>=biggest2172){
            biggest2172=ends[15];
          }
          if(ends[16]>=biggest2172){
            biggest2172=ends[16];
          }
          if(ends[17]>=biggest2172){
            biggest2172=ends[17];
          }
          if(ends[18]>=biggest2172){
            biggest2172=ends[18];
          }
          if(ends[19]>=biggest2172){
            biggest2172=ends[19];
          }
          if(ends[20]>=biggest2172){
            biggest2172=ends[20];
          }
          if(ends[21]>=biggest2172){
            biggest2172=ends[21];
          }
          if(ends[22]>=biggest2172){
            biggest2172=ends[22];
          }
          if(biggest2172 == 1){
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
          thread2173(tdone,ends);
          thread2174(tdone,ends);
          thread2175(tdone,ends);
          thread2176(tdone,ends);
          thread2177(tdone,ends);
          thread2178(tdone,ends);
          thread2179(tdone,ends);
          thread2180(tdone,ends);
          thread2181(tdone,ends);
          thread2182(tdone,ends);
          thread2183(tdone,ends);
          thread2184(tdone,ends);
          thread2185(tdone,ends);
          thread2186(tdone,ends);
          thread2187(tdone,ends);
          thread2188(tdone,ends);
          thread2189(tdone,ends);
          thread2190(tdone,ends);
          thread2191(tdone,ends);
          thread2192(tdone,ends);
          thread2193(tdone,ends);
          int biggest2194 = 0;
          if(ends[2]>=biggest2194){
            biggest2194=ends[2];
          }
          if(ends[3]>=biggest2194){
            biggest2194=ends[3];
          }
          if(ends[4]>=biggest2194){
            biggest2194=ends[4];
          }
          if(ends[5]>=biggest2194){
            biggest2194=ends[5];
          }
          if(ends[6]>=biggest2194){
            biggest2194=ends[6];
          }
          if(ends[7]>=biggest2194){
            biggest2194=ends[7];
          }
          if(ends[8]>=biggest2194){
            biggest2194=ends[8];
          }
          if(ends[9]>=biggest2194){
            biggest2194=ends[9];
          }
          if(ends[10]>=biggest2194){
            biggest2194=ends[10];
          }
          if(ends[11]>=biggest2194){
            biggest2194=ends[11];
          }
          if(ends[12]>=biggest2194){
            biggest2194=ends[12];
          }
          if(ends[13]>=biggest2194){
            biggest2194=ends[13];
          }
          if(ends[14]>=biggest2194){
            biggest2194=ends[14];
          }
          if(ends[15]>=biggest2194){
            biggest2194=ends[15];
          }
          if(ends[16]>=biggest2194){
            biggest2194=ends[16];
          }
          if(ends[17]>=biggest2194){
            biggest2194=ends[17];
          }
          if(ends[18]>=biggest2194){
            biggest2194=ends[18];
          }
          if(ends[19]>=biggest2194){
            biggest2194=ends[19];
          }
          if(ends[20]>=biggest2194){
            biggest2194=ends[20];
          }
          if(ends[21]>=biggest2194){
            biggest2194=ends[21];
          }
          if(ends[22]>=biggest2194){
            biggest2194=ends[22];
          }
          if(biggest2194 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2194 == 0){
            S2149=0;
            active[1]=0;
            ends[1]=0;
            S2149=0;
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
