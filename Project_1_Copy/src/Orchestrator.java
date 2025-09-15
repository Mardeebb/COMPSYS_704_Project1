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
  private Signal checkRobotLoader_1;
  private Signal checkConveyor_1;
  private Signal checkRotTable_1;
  private Signal robotLoaderFinish_1;
  private Signal conveyorFinish_1;
  private Signal rotTableFinish_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 23, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 26, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 27, column: 5
  private BottleTwin bEight_thread_7;//sysj\Orchestrator.sysj line: 123, column: 4
  private BottleTwin bZero_thread_8;//sysj\Orchestrator.sysj line: 143, column: 4
  private BottleTwin bFive_thread_8;//sysj\Orchestrator.sysj line: 144, column: 4
  private BottleTwin bOne_thread_9;//sysj\Orchestrator.sysj line: 166, column: 4
  private BottleTwin bTwo_thread_9;//sysj\Orchestrator.sysj line: 167, column: 4
  private BottleTwin bThree_thread_9;//sysj\Orchestrator.sysj line: 168, column: 4
  private BottleTwin bFour_thread_9;//sysj\Orchestrator.sysj line: 169, column: 4
  private BottleTwin bFive_thread_9;//sysj\Orchestrator.sysj line: 170, column: 4
  private BottleTwin bSix_thread_9;//sysj\Orchestrator.sysj line: 171, column: 4
  private int id_thread_10;//sysj\Orchestrator.sysj line: 201, column: 5
  private BottleTwin b_thread_10;//sysj\Orchestrator.sysj line: 198, column: 4
  private int id_thread_11;//sysj\Orchestrator.sysj line: 220, column: 5
  private BottleTwin b_thread_11;//sysj\Orchestrator.sysj line: 217, column: 4
  private int id_thread_12;//sysj\Orchestrator.sysj line: 239, column: 5
  private BottleTwin b_thread_12;//sysj\Orchestrator.sysj line: 236, column: 4
  private int id_thread_13;//sysj\Orchestrator.sysj line: 259, column: 5
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 256, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 278, column: 5
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 275, column: 4
  private int id_thread_15;//sysj\Orchestrator.sysj line: 297, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 294, column: 4
  private int id_thread_16;//sysj\Orchestrator.sysj line: 316, column: 5
  private BottleTwin b_thread_16;//sysj\Orchestrator.sysj line: 313, column: 4
  private int id_thread_17;//sysj\Orchestrator.sysj line: 335, column: 5
  private BottleTwin b_thread_17;//sysj\Orchestrator.sysj line: 332, column: 4
  private int id_thread_18;//sysj\Orchestrator.sysj line: 354, column: 5
  private BottleTwin b_thread_18;//sysj\Orchestrator.sysj line: 351, column: 4
  private BottleTwin b_thread_19;//sysj\Orchestrator.sysj line: 371, column: 4
  private int id_thread_19;//sysj\Orchestrator.sysj line: 373, column: 5
  private int S2489 = 1;
  private int S547 = 1;
  private int S459 = 1;
  private int S460 = 1;
  private int S603 = 1;
  private int S551 = 1;
  private int S637 = 1;
  private int S611 = 1;
  private int S607 = 1;
  private int S671 = 1;
  private int S645 = 1;
  private int S641 = 1;
  private int S705 = 1;
  private int S679 = 1;
  private int S675 = 1;
  private int S719 = 1;
  private int S707 = 1;
  private int S733 = 1;
  private int S721 = 1;
  private int S747 = 1;
  private int S735 = 1;
  private int S921 = 1;
  private int S748 = 1;
  private int S769 = 1;
  private int S1095 = 1;
  private int S922 = 1;
  private int S943 = 1;
  private int S1269 = 1;
  private int S1096 = 1;
  private int S1117 = 1;
  private int S1443 = 1;
  private int S1270 = 1;
  private int S1291 = 1;
  private int S1617 = 1;
  private int S1444 = 1;
  private int S1465 = 1;
  private int S1791 = 1;
  private int S1618 = 1;
  private int S1639 = 1;
  private int S1965 = 1;
  private int S1792 = 1;
  private int S1813 = 1;
  private int S2139 = 1;
  private int S1966 = 1;
  private int S1987 = 1;
  private int S2313 = 1;
  private int S2140 = 1;
  private int S2161 = 1;
  private int S2487 = 1;
  private int S2314 = 1;
  private int S2335 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread2527(int [] tdone, int [] ends){
        switch(S2487){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2314){
          case 0 : 
            S2314=0;
            b_thread_19 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 371, column: 4
            S2314=1;
            if(b_thread_19 != null){//sysj\Orchestrator.sysj line: 372, column: 8
              S2335=0;
              id_thread_19 = b_thread_19.ID;//sysj\Orchestrator.sysj line: 373, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 375, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_19);//sysj\Orchestrator.sysj line: 375, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 376, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 376, column: 6
              System.out.println("Emitted bottlePos9");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2335=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 379, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 379, column: 5
              System.out.println("Emitted bottlePos9B");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2335){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 374, column: 11
                  S2314=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 376, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_19);//sysj\Orchestrator.sysj line: 376, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 380, column: 11
                  S2314=0;
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

  public void thread2526(int [] tdone, int [] ends){
        switch(S2313){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S2140){
          case 0 : 
            S2140=0;
            S2140=1;
            if(b_thread_18 != null){//sysj\Orchestrator.sysj line: 353, column: 8
              S2161=0;
              id_thread_18 = b_thread_18.ID;//sysj\Orchestrator.sysj line: 354, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 356, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_18);//sysj\Orchestrator.sysj line: 356, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 357, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 357, column: 6
              System.out.println("Emitted bottlePos8");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S2161=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 360, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 360, column: 5
              System.out.println("Emitted bottlePos8B");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S2161){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 355, column: 11
                  b_thread_18 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 351, column: 4
                  S2140=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 357, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_18);//sysj\Orchestrator.sysj line: 357, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 361, column: 11
                  b_thread_18 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 351, column: 4
                  S2140=0;
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

  public void thread2525(int [] tdone, int [] ends){
        switch(S2139){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1966){
          case 0 : 
            S1966=0;
            S1966=1;
            if(b_thread_17 != null){//sysj\Orchestrator.sysj line: 334, column: 8
              S1987=0;
              id_thread_17 = b_thread_17.ID;//sysj\Orchestrator.sysj line: 335, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 337, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_17);//sysj\Orchestrator.sysj line: 337, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 338, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 338, column: 6
              System.out.println("Emitted bottlePos7");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1987=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 341, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 341, column: 5
              System.out.println("Emitted bottlePos7B");
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S1987){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 336, column: 11
                  b_thread_17 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 332, column: 4
                  S1966=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 338, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_17);//sysj\Orchestrator.sysj line: 338, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 342, column: 11
                  b_thread_17 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 332, column: 4
                  S1966=0;
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

  public void thread2524(int [] tdone, int [] ends){
        switch(S1965){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1792){
          case 0 : 
            S1792=0;
            S1792=1;
            if(b_thread_16 != null){//sysj\Orchestrator.sysj line: 315, column: 8
              S1813=0;
              id_thread_16 = b_thread_16.ID;//sysj\Orchestrator.sysj line: 316, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 318, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_16);//sysj\Orchestrator.sysj line: 318, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 319, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 319, column: 6
              System.out.println("Emitted bottlePos6");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1813=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 322, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 322, column: 5
              System.out.println("Emitted bottlePos6B");
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S1813){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 317, column: 11
                  b_thread_16 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 313, column: 4
                  S1792=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 319, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_16);//sysj\Orchestrator.sysj line: 319, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 323, column: 11
                  b_thread_16 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 313, column: 4
                  S1792=0;
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

  public void thread2523(int [] tdone, int [] ends){
        switch(S1791){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1618){
          case 0 : 
            S1618=0;
            S1618=1;
            if(b_thread_15 != null){//sysj\Orchestrator.sysj line: 296, column: 8
              S1639=0;
              id_thread_15 = b_thread_15.ID;//sysj\Orchestrator.sysj line: 297, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 299, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_15);//sysj\Orchestrator.sysj line: 299, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 300, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 300, column: 6
              System.out.println("Emitted bottlePos5");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1639=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 303, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 303, column: 5
              System.out.println("Emitted bottlePos5B");
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S1639){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 298, column: 11
                  b_thread_15 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 294, column: 4
                  S1618=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 300, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_15);//sysj\Orchestrator.sysj line: 300, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 304, column: 11
                  b_thread_15 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 294, column: 4
                  S1618=0;
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

  public void thread2522(int [] tdone, int [] ends){
        switch(S1617){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1444){
          case 0 : 
            S1444=0;
            S1444=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 277, column: 8
              S1465=0;
              id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 278, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 280, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 280, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 281, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 281, column: 6
              System.out.println("Emitted bottlePos4");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S1465=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 284, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 284, column: 5
              System.out.println("Emitted bottlePos4B");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S1465){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 279, column: 11
                  b_thread_14 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 275, column: 4
                  S1444=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 281, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 281, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 285, column: 11
                  b_thread_14 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 275, column: 4
                  S1444=0;
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

  public void thread2521(int [] tdone, int [] ends){
        switch(S1443){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1270){
          case 0 : 
            S1270=0;
            S1270=1;
            if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 258, column: 8
              S1291=0;
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 259, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 261, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_13);//sysj\Orchestrator.sysj line: 261, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 262, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 262, column: 6
              System.out.println("Emitted bottlePos3");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S1291=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 265, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 265, column: 5
              System.out.println("Emitted bottlePos3B");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S1291){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 260, column: 11
                  b_thread_13 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 256, column: 4
                  S1270=0;
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 262, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 262, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[13]=1;
                  ends[13]=1;
                  tdone[13]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 266, column: 11
                  b_thread_13 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 256, column: 4
                  S1270=0;
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

  public void thread2520(int [] tdone, int [] ends){
        switch(S1269){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1096){
          case 0 : 
            S1096=0;
            S1096=1;
            if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 238, column: 8
              S1117=0;
              id_thread_12 = b_thread_12.ID;//sysj\Orchestrator.sysj line: 239, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 241, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_12);//sysj\Orchestrator.sysj line: 241, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 242, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 242, column: 6
              System.out.println("Emitted bottlePos2");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S1117=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 245, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 245, column: 5
              System.out.println("Emitted bottlePos2B");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            switch(S1117){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 240, column: 11
                  b_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 236, column: 4
                  S1096=0;
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 242, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 242, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 246, column: 11
                  b_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 236, column: 4
                  S1096=0;
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

  public void thread2519(int [] tdone, int [] ends){
        switch(S1095){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S922){
          case 0 : 
            S922=0;
            S922=1;
            if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 219, column: 8
              S943=0;
              id_thread_11 = b_thread_11.ID;//sysj\Orchestrator.sysj line: 220, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 222, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_11);//sysj\Orchestrator.sysj line: 222, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 223, column: 6
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 223, column: 6
              System.out.println("Emitted bottlePos1");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S943=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 226, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 226, column: 5
              System.out.println("Emitted bottlePos1B");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            switch(S943){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 221, column: 11
                  b_thread_11 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
                  S922=0;
                  active[11]=1;
                  ends[11]=1;
                  tdone[11]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 223, column: 6
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 223, column: 6
                  System.out.println("Emitted bottlePos1");
                  active[11]=1;
                  ends[11]=1;
                  tdone[11]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 227, column: 11
                  b_thread_11 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
                  S922=0;
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
        break;
      
    }
  }

  public void thread2518(int [] tdone, int [] ends){
        switch(S921){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S748){
          case 0 : 
            S748=0;
            S748=1;
            if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 200, column: 8
              S769=0;
              id_thread_10 = b_thread_10.ID;//sysj\Orchestrator.sysj line: 201, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 203, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_10);//sysj\Orchestrator.sysj line: 203, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 204, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 204, column: 6
              System.out.println("Emitted bottlePos0");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S769=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 207, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 207, column: 5
              System.out.println("Emitted bottlePos0B");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            switch(S769){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 202, column: 11
                  b_thread_10 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 198, column: 4
                  S748=0;
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 204, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 204, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 208, column: 11
                  b_thread_10 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 198, column: 4
                  S748=0;
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
        break;
      
    }
  }

  public void thread2517(int [] tdone, int [] ends){
        switch(S747){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S735){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 163, column: 10
              bOne_thread_9 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 166, column: 4
              bTwo_thread_9 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 167, column: 4
              bThree_thread_9 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 168, column: 4
              bFour_thread_9 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 169, column: 4
              bFive_thread_9 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 170, column: 4
              bSix_thread_9 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 171, column: 4
              S735=1;
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
            S735=1;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 173, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_9);//sysj\Orchestrator.sysj line: 173, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 174, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_9);//sysj\Orchestrator.sysj line: 174, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 175, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_9);//sysj\Orchestrator.sysj line: 175, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 176, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_9);//sysj\Orchestrator.sysj line: 176, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 177, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_9);//sysj\Orchestrator.sysj line: 177, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 178, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_9);//sysj\Orchestrator.sysj line: 178, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S735=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S735=2;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 181, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S735=3;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 3 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 182, column: 10
              S735=0;
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

  public void thread2516(int [] tdone, int [] ends){
        switch(S733){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S721){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 141, column: 10
              bZero_thread_8 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 143, column: 4
              bFive_thread_8 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 144, column: 4
              S721=1;
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
            S721=1;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 146, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 146, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 148, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_8);//sysj\Orchestrator.sysj line: 148, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 149, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_8);//sysj\Orchestrator.sysj line: 149, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S721=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S721=2;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 152, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S721=3;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 3 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 153, column: 10
              S721=0;
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

  public void thread2515(int [] tdone, int [] ends){
        switch(S719){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S707){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 121, column: 10
              bEight_thread_7 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 123, column: 4
              S707=1;
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
            S707=1;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 125, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 125, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 126, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_7);//sysj\Orchestrator.sysj line: 126, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S707=2;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            S707=2;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 129, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S707=3;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 3 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 130, column: 10
              S707=0;
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
          
        }
        break;
      
    }
  }

  public void thread2514(int [] tdone, int [] ends){
        switch(S705){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S679){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 10
              S679=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 104, column: 12
                S675=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 105, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S675=1;
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
            switch(S675){
              case 0 : 
                S679=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 109, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S679=0;
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

  public void thread2513(int [] tdone, int [] ends){
        switch(S671){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S645){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 87, column: 10
              S645=1;
              if(bottlePos0.getprestatus() && !bottlePos1.getprestatus()){//sysj\Orchestrator.sysj line: 88, column: 12
                S641=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S641=1;
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
            switch(S641){
              case 0 : 
                S645=0;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 93, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S645=0;
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

  public void thread2512(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S611){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 72, column: 10
              S611=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 73, column: 12
                S607=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S607=1;
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
            switch(S607){
              case 0 : 
                S611=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 78, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S611=0;
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

  public void thread2511(int [] tdone, int [] ends){
        switch(S603){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S551){
          case 0 : 
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
              S551=1;
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
              S551=2;
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
              S551=3;
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
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 54, column: 10
              S551=4;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 55, column: 10
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 57, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S551=5;
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
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 58, column: 10
              S551=6;
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
            if(!request.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 10
              S551=7;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 60, column: 10
              checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 62, column: 4
              currsigs.addElement(checkRotTable_1);
              System.out.println("Emitted checkRotTable_1");
              S551=8;
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
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 63, column: 10
              S551=0;
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

  public void thread2510(int [] tdone, int [] ends){
        switch(S547){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S459){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 21, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 22, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 23, column: 4
              S459=1;
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
                S460=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S459=0;
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
            switch(S460){
              case 0 : 
                S460=0;
                S460=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S460=1;
                S460=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S460=3;
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
                  S460=4;
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
                  S460=5;
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
                  S459=0;
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

  public void thread2508(int [] tdone, int [] ends){
        S2487=1;
    S2314=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2507(int [] tdone, int [] ends){
        S2313=1;
    b_thread_18 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 351, column: 4
    S2140=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2506(int [] tdone, int [] ends){
        S2139=1;
    b_thread_17 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 332, column: 4
    S1966=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2505(int [] tdone, int [] ends){
        S1965=1;
    b_thread_16 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 313, column: 4
    S1792=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2504(int [] tdone, int [] ends){
        S1791=1;
    b_thread_15 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 294, column: 4
    S1618=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2503(int [] tdone, int [] ends){
        S1617=1;
    b_thread_14 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 275, column: 4
    S1444=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2502(int [] tdone, int [] ends){
        S1443=1;
    b_thread_13 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 256, column: 4
    S1270=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2501(int [] tdone, int [] ends){
        S1269=1;
    b_thread_12 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 236, column: 4
    S1096=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2500(int [] tdone, int [] ends){
        S1095=1;
    b_thread_11 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
    S922=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2499(int [] tdone, int [] ends){
        S921=1;
    b_thread_10 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 198, column: 4
    S748=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2498(int [] tdone, int [] ends){
        S747=1;
    S735=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2497(int [] tdone, int [] ends){
        S733=1;
    S721=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2496(int [] tdone, int [] ends){
        S719=1;
    S707=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2495(int [] tdone, int [] ends){
        S705=1;
    S679=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2494(int [] tdone, int [] ends){
        S671=1;
    S645=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2493(int [] tdone, int [] ends){
        S637=1;
    S611=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2492(int [] tdone, int [] ends){
        S603=1;
    S551=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2491(int [] tdone, int [] ends){
        S547=1;
    S459=0;
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
      switch(S2489){
        case 0 : 
          S2489=0;
          break RUN;
        
        case 1 : 
          S2489=2;
          S2489=2;
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
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2491(tdone,ends);
          thread2492(tdone,ends);
          thread2493(tdone,ends);
          thread2494(tdone,ends);
          thread2495(tdone,ends);
          thread2496(tdone,ends);
          thread2497(tdone,ends);
          thread2498(tdone,ends);
          thread2499(tdone,ends);
          thread2500(tdone,ends);
          thread2501(tdone,ends);
          thread2502(tdone,ends);
          thread2503(tdone,ends);
          thread2504(tdone,ends);
          thread2505(tdone,ends);
          thread2506(tdone,ends);
          thread2507(tdone,ends);
          thread2508(tdone,ends);
          int biggest2509 = 0;
          if(ends[2]>=biggest2509){
            biggest2509=ends[2];
          }
          if(ends[3]>=biggest2509){
            biggest2509=ends[3];
          }
          if(ends[4]>=biggest2509){
            biggest2509=ends[4];
          }
          if(ends[5]>=biggest2509){
            biggest2509=ends[5];
          }
          if(ends[6]>=biggest2509){
            biggest2509=ends[6];
          }
          if(ends[7]>=biggest2509){
            biggest2509=ends[7];
          }
          if(ends[8]>=biggest2509){
            biggest2509=ends[8];
          }
          if(ends[9]>=biggest2509){
            biggest2509=ends[9];
          }
          if(ends[10]>=biggest2509){
            biggest2509=ends[10];
          }
          if(ends[11]>=biggest2509){
            biggest2509=ends[11];
          }
          if(ends[12]>=biggest2509){
            biggest2509=ends[12];
          }
          if(ends[13]>=biggest2509){
            biggest2509=ends[13];
          }
          if(ends[14]>=biggest2509){
            biggest2509=ends[14];
          }
          if(ends[15]>=biggest2509){
            biggest2509=ends[15];
          }
          if(ends[16]>=biggest2509){
            biggest2509=ends[16];
          }
          if(ends[17]>=biggest2509){
            biggest2509=ends[17];
          }
          if(ends[18]>=biggest2509){
            biggest2509=ends[18];
          }
          if(ends[19]>=biggest2509){
            biggest2509=ends[19];
          }
          if(biggest2509 == 1){
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
          checkRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkConveyor_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          checkRotTable_1.setClear();//sysj\Orchestrator.sysj line: 16, column: 2
          robotLoaderFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          conveyorFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          rotTableFinish_1.setClear();//sysj\Orchestrator.sysj line: 17, column: 2
          thread2510(tdone,ends);
          thread2511(tdone,ends);
          thread2512(tdone,ends);
          thread2513(tdone,ends);
          thread2514(tdone,ends);
          thread2515(tdone,ends);
          thread2516(tdone,ends);
          thread2517(tdone,ends);
          thread2518(tdone,ends);
          thread2519(tdone,ends);
          thread2520(tdone,ends);
          thread2521(tdone,ends);
          thread2522(tdone,ends);
          thread2523(tdone,ends);
          thread2524(tdone,ends);
          thread2525(tdone,ends);
          thread2526(tdone,ends);
          thread2527(tdone,ends);
          int biggest2528 = 0;
          if(ends[2]>=biggest2528){
            biggest2528=ends[2];
          }
          if(ends[3]>=biggest2528){
            biggest2528=ends[3];
          }
          if(ends[4]>=biggest2528){
            biggest2528=ends[4];
          }
          if(ends[5]>=biggest2528){
            biggest2528=ends[5];
          }
          if(ends[6]>=biggest2528){
            biggest2528=ends[6];
          }
          if(ends[7]>=biggest2528){
            biggest2528=ends[7];
          }
          if(ends[8]>=biggest2528){
            biggest2528=ends[8];
          }
          if(ends[9]>=biggest2528){
            biggest2528=ends[9];
          }
          if(ends[10]>=biggest2528){
            biggest2528=ends[10];
          }
          if(ends[11]>=biggest2528){
            biggest2528=ends[11];
          }
          if(ends[12]>=biggest2528){
            biggest2528=ends[12];
          }
          if(ends[13]>=biggest2528){
            biggest2528=ends[13];
          }
          if(ends[14]>=biggest2528){
            biggest2528=ends[14];
          }
          if(ends[15]>=biggest2528){
            biggest2528=ends[15];
          }
          if(ends[16]>=biggest2528){
            biggest2528=ends[16];
          }
          if(ends[17]>=biggest2528){
            biggest2528=ends[17];
          }
          if(ends[18]>=biggest2528){
            biggest2528=ends[18];
          }
          if(ends[19]>=biggest2528){
            biggest2528=ends[19];
          }
          if(biggest2528 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2528 == 0){
            S2489=0;
            active[1]=0;
            ends[1]=0;
            S2489=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    checkRobotLoader_1 = new Signal();
    checkConveyor_1 = new Signal();
    checkRotTable_1 = new Signal();
    robotLoaderFinish_1 = new Signal();
    conveyorFinish_1 = new Signal();
    rotTableFinish_1 = new Signal();
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
      checkRobotLoader_1.setpreclear();
      checkConveyor_1.setpreclear();
      checkRotTable_1.setpreclear();
      robotLoaderFinish_1.setpreclear();
      conveyorFinish_1.setpreclear();
      rotTableFinish_1.setpreclear();
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
      checkRobotLoader_1.setClear();
      checkConveyor_1.setClear();
      checkRotTable_1.setClear();
      robotLoaderFinish_1.setClear();
      conveyorFinish_1.setClear();
      rotTableFinish_1.setClear();
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
