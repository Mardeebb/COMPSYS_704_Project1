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
  private BottleTwin bEight_thread_8;//sysj\Orchestrator.sysj line: 146, column: 4
  private BottleTwin bZero_thread_9;//sysj\Orchestrator.sysj line: 166, column: 4
  private BottleTwin bFive_thread_9;//sysj\Orchestrator.sysj line: 167, column: 4
  private BottleTwin bOne_thread_10;//sysj\Orchestrator.sysj line: 189, column: 4
  private BottleTwin bTwo_thread_10;//sysj\Orchestrator.sysj line: 190, column: 4
  private BottleTwin bThree_thread_10;//sysj\Orchestrator.sysj line: 191, column: 4
  private BottleTwin bFour_thread_10;//sysj\Orchestrator.sysj line: 192, column: 4
  private BottleTwin bFive_thread_10;//sysj\Orchestrator.sysj line: 193, column: 4
  private BottleTwin bSix_thread_10;//sysj\Orchestrator.sysj line: 194, column: 4
  private BottleTwin bSeven_thread_11;//sysj\Orchestrator.sysj line: 217, column: 4
  private int id_thread_12;//sysj\Orchestrator.sysj line: 241, column: 5
  private BottleTwin b_thread_12;//sysj\Orchestrator.sysj line: 238, column: 4
  private int id_thread_13;//sysj\Orchestrator.sysj line: 260, column: 5
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 257, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 279, column: 5
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 276, column: 4
  private int id_thread_15;//sysj\Orchestrator.sysj line: 299, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 296, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 318, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 315, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 337, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 334, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 356, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 353, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 375, column: 5
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 372, column: 4
  private int id_thread_20;//sysj\Orchestrator.sysj line: 394, column: 5
  private BottleTwin b_thread_20;//sysj\Orchestrator.sysj line: 391, column: 4
  private BottleTwin b_thread_21;//sysj\Orchestrator.sysj line: 411, column: 4
  private int id_thread_21;//sysj\Orchestrator.sysj line: 413, column: 5
  private int S2558 = 1;
  private int S550 = 1;
  private int S462 = 1;
  private int S463 = 1;
  private int S624 = 1;
  private int S554 = 1;
  private int S658 = 1;
  private int S632 = 1;
  private int S628 = 1;
  private int S692 = 1;
  private int S666 = 1;
  private int S662 = 1;
  private int S726 = 1;
  private int S700 = 1;
  private int S696 = 1;
  private int S760 = 1;
  private int S734 = 1;
  private int S730 = 1;
  private int S774 = 1;
  private int S762 = 1;
  private int S788 = 1;
  private int S776 = 1;
  private int S802 = 1;
  private int S790 = 1;
  private int S816 = 1;
  private int S804 = 1;
  private int S990 = 1;
  private int S817 = 1;
  private int S838 = 1;
  private int S1164 = 1;
  private int S991 = 1;
  private int S1012 = 1;
  private int S1338 = 1;
  private int S1165 = 1;
  private int S1186 = 1;
  private int S1512 = 1;
  private int S1339 = 1;
  private int S1360 = 1;
  private int S1686 = 1;
  private int S1513 = 1;
  private int S1534 = 1;
  private int S1860 = 1;
  private int S1687 = 1;
  private int S1708 = 1;
  private int S2034 = 1;
  private int S1861 = 1;
  private int S1882 = 1;
  private int S2208 = 1;
  private int S2035 = 1;
  private int S2056 = 1;
  private int S2382 = 1;
  private int S2209 = 1;
  private int S2230 = 1;
  private int S2556 = 1;
  private int S2383 = 1;
  private int S2404 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread2600(int [] tdone, int [] ends){
        switch(S2556){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2383){
          case 0 : 
            S2383=0;
            b_thread_21 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 411, column: 4
            S2383=1;
            if(b_thread_21 != null){//sysj\Orchestrator.sysj line: 412, column: 8
              S2404=0;
              id_thread_21 = b_thread_21.ID;//sysj\Orchestrator.sysj line: 413, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 415, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_21);//sysj\Orchestrator.sysj line: 415, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 416, column: 6
              System.out.println("Emitted bottlePos9");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2404=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 419, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 419, column: 5
              System.out.println("Emitted bottlePos9B");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S2404){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 414, column: 11
                  S2383=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 416, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_21);//sysj\Orchestrator.sysj line: 416, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 420, column: 11
                  S2383=0;
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

  public void thread2599(int [] tdone, int [] ends){
        switch(S2382){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2209){
          case 0 : 
            S2209=0;
            S2209=1;
            if(b_thread_20 != null){//sysj\Orchestrator.sysj line: 393, column: 8
              S2230=0;
              id_thread_20 = b_thread_20.ID;//sysj\Orchestrator.sysj line: 394, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 396, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_20);//sysj\Orchestrator.sysj line: 396, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 397, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 397, column: 6
              System.out.println("Emitted bottlePos8");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2230=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 400, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 400, column: 5
              System.out.println("Emitted bottlePos8B");
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2230){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 395, column: 11
                  b_thread_20 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 391, column: 4
                  S2209=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 397, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_20);//sysj\Orchestrator.sysj line: 397, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 401, column: 11
                  b_thread_20 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 391, column: 4
                  S2209=0;
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

  public void thread2598(int [] tdone, int [] ends){
        switch(S2208){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2035){
          case 0 : 
            S2035=0;
            S2035=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 374, column: 8
              S2056=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 375, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 377, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 377, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 378, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 378, column: 6
              System.out.println("Emitted bottlePos7");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2056=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 381, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 381, column: 5
              System.out.println("Emitted bottlePos7B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2056){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 376, column: 11
                  b_thread_19 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 4
                  S2035=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 378, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 378, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 382, column: 11
                  b_thread_19 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 4
                  S2035=0;
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

  public void thread2597(int [] tdone, int [] ends){
        switch(S2034){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1861){
          case 0 : 
            S1861=0;
            S1861=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 355, column: 8
              S1882=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 356, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 358, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 358, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 359, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 359, column: 6
              System.out.println("Emitted bottlePos6");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S1882=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 362, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 362, column: 5
              System.out.println("Emitted bottlePos6B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S1882){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 357, column: 11
                  b_thread_18 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 353, column: 4
                  S1861=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 359, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 359, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 363, column: 11
                  b_thread_18 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 353, column: 4
                  S1861=0;
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

  public void thread2596(int [] tdone, int [] ends){
        switch(S1860){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1687){
          case 0 : 
            S1687=0;
            S1687=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 336, column: 8
              S1708=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 337, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 339, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 339, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 340, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 340, column: 6
              System.out.println("Emitted bottlePos5");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1708=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 343, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 343, column: 5
              System.out.println("Emitted bottlePos5B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S1708){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 338, column: 11
                  b_thread_17 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 334, column: 4
                  S1687=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 340, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 340, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 344, column: 11
                  b_thread_17 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 334, column: 4
                  S1687=0;
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

  public void thread2595(int [] tdone, int [] ends){
        switch(S1686){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1513){
          case 0 : 
            S1513=0;
            S1513=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 317, column: 8
              S1534=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 318, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 320, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 320, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 321, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 321, column: 6
              System.out.println("Emitted bottlePos4");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1534=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 324, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 324, column: 5
              System.out.println("Emitted bottlePos4B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S1534){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 319, column: 11
                  b_thread_16 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 315, column: 4
                  S1513=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 321, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 321, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 325, column: 11
                  b_thread_16 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 315, column: 4
                  S1513=0;
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

  public void thread2594(int [] tdone, int [] ends){
        switch(S1512){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1339){
          case 0 : 
            S1339=0;
            S1339=1;
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 298, column: 8
              S1360=0;
              id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 299, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 301, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 301, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 302, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 302, column: 6
              System.out.println("Emitted bottlePos3");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1360=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 305, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 305, column: 5
              System.out.println("Emitted bottlePos3B");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S1360){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 300, column: 11
                  b_thread_15 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 296, column: 4
                  S1339=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 302, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 302, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 306, column: 11
                  b_thread_15 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 296, column: 4
                  S1339=0;
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

  public void thread2593(int [] tdone, int [] ends){
        switch(S1338){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1165){
          case 0 : 
            S1165=0;
            S1165=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 278, column: 8
              S1186=0;
              id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 279, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 281, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 281, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 282, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 282, column: 6
              System.out.println("Emitted bottlePos2");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S1186=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 285, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 285, column: 5
              System.out.println("Emitted bottlePos2B");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S1186){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 280, column: 11
                  b_thread_14 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 276, column: 4
                  S1165=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 282, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 282, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 286, column: 11
                  b_thread_14 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 276, column: 4
                  S1165=0;
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

  public void thread2592(int [] tdone, int [] ends){
        switch(S1164){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S991){
          case 0 : 
            S991=0;
            S991=1;
            if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 259, column: 8
              S1012=0;
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 260, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 262, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_13);//sysj\Orchestrator.sysj line: 262, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 6
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 263, column: 6
              System.out.println("Emitted bottlePos1");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S1012=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 266, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 266, column: 5
              System.out.println("Emitted bottlePos1B");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S1012){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 261, column: 11
                  b_thread_13 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 257, column: 4
                  S991=0;
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 6
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 263, column: 6
                  System.out.println("Emitted bottlePos1");
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 267, column: 11
                  b_thread_13 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 257, column: 4
                  S991=0;
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

  public void thread2591(int [] tdone, int [] ends){
        switch(S990){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S817){
          case 0 : 
            S817=0;
            S817=1;
            if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 240, column: 8
              S838=0;
              id_thread_12 = b_thread_12.ID;//sysj\Orchestrator.sysj line: 241, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 243, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_12);//sysj\Orchestrator.sysj line: 243, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 244, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 244, column: 6
              System.out.println("Emitted bottlePos0");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S838=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 247, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 247, column: 5
              System.out.println("Emitted bottlePos0B");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            switch(S838){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 242, column: 11
                  b_thread_12 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 4
                  S817=0;
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 244, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 244, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 248, column: 11
                  b_thread_12 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 4
                  S817=0;
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
        break;
      
    }
  }

  public void thread2590(int [] tdone, int [] ends){
        switch(S816){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S804){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 215, column: 10
              bSeven_thread_11 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
              S804=1;
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
            S804=1;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 219, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 219, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 220, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_11);//sysj\Orchestrator.sysj line: 220, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S804=2;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            S804=2;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 223, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S804=3;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 3 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 224, column: 10
              S804=0;
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

  public void thread2589(int [] tdone, int [] ends){
        switch(S802){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S790){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 186, column: 10
              bOne_thread_10 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 189, column: 4
              bTwo_thread_10 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 190, column: 4
              bThree_thread_10 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 191, column: 4
              bFour_thread_10 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 192, column: 4
              bFive_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 193, column: 4
              bSix_thread_10 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 194, column: 4
              S790=1;
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
            S790=1;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 196, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_10);//sysj\Orchestrator.sysj line: 196, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 197, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_10);//sysj\Orchestrator.sysj line: 197, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 198, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_10);//sysj\Orchestrator.sysj line: 198, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 199, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_10);//sysj\Orchestrator.sysj line: 199, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 200, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_10);//sysj\Orchestrator.sysj line: 200, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 201, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_10);//sysj\Orchestrator.sysj line: 201, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S790=2;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            S790=2;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 204, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S790=3;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 3 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 205, column: 10
              S790=0;
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

  public void thread2588(int [] tdone, int [] ends){
        switch(S788){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S776){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 164, column: 10
              bZero_thread_9 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 166, column: 4
              bFive_thread_9 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 167, column: 4
              S776=1;
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
            S776=1;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 169, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 169, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 170, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 170, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 171, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_9);//sysj\Orchestrator.sysj line: 171, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 172, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_9);//sysj\Orchestrator.sysj line: 172, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S776=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S776=2;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 175, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S776=3;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 3 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 176, column: 10
              S776=0;
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

  public void thread2587(int [] tdone, int [] ends){
        switch(S774){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S762){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 144, column: 10
              bEight_thread_8 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 146, column: 4
              S762=1;
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
            S762=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 148, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 149, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_8);//sysj\Orchestrator.sysj line: 149, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S762=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S762=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 152, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S762=3;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 153, column: 10
              S762=0;
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

  public void thread2586(int [] tdone, int [] ends){
        switch(S760){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S734){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 128, column: 10
              S734=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 129, column: 12
                S730=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 130, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S730=1;
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
            switch(S730){
              case 0 : 
                S734=0;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 134, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S734=0;
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

  public void thread2585(int [] tdone, int [] ends){
        switch(S726){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S700){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 111, column: 10
              S700=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 113, column: 12
                S696=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 114, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S696=1;
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
            switch(S696){
              case 0 : 
                S700=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 118, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S700=0;
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

  public void thread2584(int [] tdone, int [] ends){
        switch(S692){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S666){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 96, column: 10
              S666=1;
              if(bottlePos0.getprestatus() && !bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 97, column: 12
                S662=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 98, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S662=1;
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
            switch(S662){
              case 0 : 
                S666=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 102, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S666=0;
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

  public void thread2583(int [] tdone, int [] ends){
        switch(S658){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S632){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 81, column: 10
              S632=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 82, column: 12
                S628=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 83, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S628=1;
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
            switch(S628){
              case 0 : 
                S632=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 87, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S632=0;
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

  public void thread2582(int [] tdone, int [] ends){
        switch(S624){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S554){
          case 0 : 
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
              S554=1;
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
              checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
              currsigs.addElement(checkRobotLoader_1);
              System.out.println("Emitted checkRobotLoader_1");
              S554=2;
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
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
              S554=3;
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
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 55, column: 10
              S554=4;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 56, column: 10
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S554=5;
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
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S554=6;
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
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 61, column: 10
              S554=7;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 62, column: 10
              checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 64, column: 4
              currsigs.addElement(checkRotTable_1);
              System.out.println("Emitted checkRotTable_1");
              S554=8;
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
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 65, column: 10
              S554=9;
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
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 67, column: 10
              S554=10;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 68, column: 10
              checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 70, column: 4
              currsigs.addElement(checkRobotUnloader_1);
              System.out.println("Emitted checkRobotUnloader_1");
              S554=11;
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
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 71, column: 10
              S554=0;
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

  public void thread2581(int [] tdone, int [] ends){
        switch(S550){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S462){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S462=1;
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
                S463=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S462=0;
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
            switch(S463){
              case 0 : 
                S463=0;
                S463=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S463=1;
                S463=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S463=3;
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
                if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 35, column: 11
                  S463=4;
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
              
              case 4 : 
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 36, column: 11
                  S463=5;
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
              
              case 5 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 38, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 39, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  S462=0;
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

  public void thread2579(int [] tdone, int [] ends){
        S2556=1;
    S2383=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2578(int [] tdone, int [] ends){
        S2382=1;
    b_thread_20 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 391, column: 4
    S2209=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2577(int [] tdone, int [] ends){
        S2208=1;
    b_thread_19 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 372, column: 4
    S2035=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2576(int [] tdone, int [] ends){
        S2034=1;
    b_thread_18 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 353, column: 4
    S1861=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2575(int [] tdone, int [] ends){
        S1860=1;
    b_thread_17 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 334, column: 4
    S1687=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2574(int [] tdone, int [] ends){
        S1686=1;
    b_thread_16 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 315, column: 4
    S1513=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2573(int [] tdone, int [] ends){
        S1512=1;
    b_thread_15 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 296, column: 4
    S1339=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2572(int [] tdone, int [] ends){
        S1338=1;
    b_thread_14 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 276, column: 4
    S1165=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2571(int [] tdone, int [] ends){
        S1164=1;
    b_thread_13 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 257, column: 4
    S991=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2570(int [] tdone, int [] ends){
        S990=1;
    b_thread_12 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 238, column: 4
    S817=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2569(int [] tdone, int [] ends){
        S816=1;
    S804=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2568(int [] tdone, int [] ends){
        S802=1;
    S790=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2567(int [] tdone, int [] ends){
        S788=1;
    S776=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2566(int [] tdone, int [] ends){
        S774=1;
    S762=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2565(int [] tdone, int [] ends){
        S760=1;
    S734=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2564(int [] tdone, int [] ends){
        S726=1;
    S700=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2563(int [] tdone, int [] ends){
        S692=1;
    S666=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2562(int [] tdone, int [] ends){
        S658=1;
    S632=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2561(int [] tdone, int [] ends){
        S624=1;
    S554=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2560(int [] tdone, int [] ends){
        S550=1;
    S462=0;
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
      switch(S2558){
        case 0 : 
          S2558=0;
          break RUN;
        
        case 1 : 
          S2558=2;
          S2558=2;
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
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2560(tdone,ends);
          thread2561(tdone,ends);
          thread2562(tdone,ends);
          thread2563(tdone,ends);
          thread2564(tdone,ends);
          thread2565(tdone,ends);
          thread2566(tdone,ends);
          thread2567(tdone,ends);
          thread2568(tdone,ends);
          thread2569(tdone,ends);
          thread2570(tdone,ends);
          thread2571(tdone,ends);
          thread2572(tdone,ends);
          thread2573(tdone,ends);
          thread2574(tdone,ends);
          thread2575(tdone,ends);
          thread2576(tdone,ends);
          thread2577(tdone,ends);
          thread2578(tdone,ends);
          thread2579(tdone,ends);
          int biggest2580 = 0;
          if(ends[2]>=biggest2580){
            biggest2580=ends[2];
          }
          if(ends[3]>=biggest2580){
            biggest2580=ends[3];
          }
          if(ends[4]>=biggest2580){
            biggest2580=ends[4];
          }
          if(ends[5]>=biggest2580){
            biggest2580=ends[5];
          }
          if(ends[6]>=biggest2580){
            biggest2580=ends[6];
          }
          if(ends[7]>=biggest2580){
            biggest2580=ends[7];
          }
          if(ends[8]>=biggest2580){
            biggest2580=ends[8];
          }
          if(ends[9]>=biggest2580){
            biggest2580=ends[9];
          }
          if(ends[10]>=biggest2580){
            biggest2580=ends[10];
          }
          if(ends[11]>=biggest2580){
            biggest2580=ends[11];
          }
          if(ends[12]>=biggest2580){
            biggest2580=ends[12];
          }
          if(ends[13]>=biggest2580){
            biggest2580=ends[13];
          }
          if(ends[14]>=biggest2580){
            biggest2580=ends[14];
          }
          if(ends[15]>=biggest2580){
            biggest2580=ends[15];
          }
          if(ends[16]>=biggest2580){
            biggest2580=ends[16];
          }
          if(ends[17]>=biggest2580){
            biggest2580=ends[17];
          }
          if(ends[18]>=biggest2580){
            biggest2580=ends[18];
          }
          if(ends[19]>=biggest2580){
            biggest2580=ends[19];
          }
          if(ends[20]>=biggest2580){
            biggest2580=ends[20];
          }
          if(ends[21]>=biggest2580){
            biggest2580=ends[21];
          }
          if(biggest2580 == 1){
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
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRobotUnloader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          robotUnloaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2581(tdone,ends);
          thread2582(tdone,ends);
          thread2583(tdone,ends);
          thread2584(tdone,ends);
          thread2585(tdone,ends);
          thread2586(tdone,ends);
          thread2587(tdone,ends);
          thread2588(tdone,ends);
          thread2589(tdone,ends);
          thread2590(tdone,ends);
          thread2591(tdone,ends);
          thread2592(tdone,ends);
          thread2593(tdone,ends);
          thread2594(tdone,ends);
          thread2595(tdone,ends);
          thread2596(tdone,ends);
          thread2597(tdone,ends);
          thread2598(tdone,ends);
          thread2599(tdone,ends);
          thread2600(tdone,ends);
          int biggest2601 = 0;
          if(ends[2]>=biggest2601){
            biggest2601=ends[2];
          }
          if(ends[3]>=biggest2601){
            biggest2601=ends[3];
          }
          if(ends[4]>=biggest2601){
            biggest2601=ends[4];
          }
          if(ends[5]>=biggest2601){
            biggest2601=ends[5];
          }
          if(ends[6]>=biggest2601){
            biggest2601=ends[6];
          }
          if(ends[7]>=biggest2601){
            biggest2601=ends[7];
          }
          if(ends[8]>=biggest2601){
            biggest2601=ends[8];
          }
          if(ends[9]>=biggest2601){
            biggest2601=ends[9];
          }
          if(ends[10]>=biggest2601){
            biggest2601=ends[10];
          }
          if(ends[11]>=biggest2601){
            biggest2601=ends[11];
          }
          if(ends[12]>=biggest2601){
            biggest2601=ends[12];
          }
          if(ends[13]>=biggest2601){
            biggest2601=ends[13];
          }
          if(ends[14]>=biggest2601){
            biggest2601=ends[14];
          }
          if(ends[15]>=biggest2601){
            biggest2601=ends[15];
          }
          if(ends[16]>=biggest2601){
            biggest2601=ends[16];
          }
          if(ends[17]>=biggest2601){
            biggest2601=ends[17];
          }
          if(ends[18]>=biggest2601){
            biggest2601=ends[18];
          }
          if(ends[19]>=biggest2601){
            biggest2601=ends[19];
          }
          if(ends[20]>=biggest2601){
            biggest2601=ends[20];
          }
          if(ends[21]>=biggest2601){
            biggest2601=ends[21];
          }
          if(biggest2601 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2601 == 0){
            S2558=0;
            active[1]=0;
            ends[1]=0;
            S2558=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
