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
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 192, column: 5
  private BottleTwin b_thread_15;//sysj\Orchestrator.sysj line: 210, column: 5
  private BottleTwin bEight_thread_16;//sysj\Orchestrator.sysj line: 232, column: 4
  private BottleTwin bZero_thread_17;//sysj\Orchestrator.sysj line: 258, column: 4
  private BottleTwin bFive_thread_17;//sysj\Orchestrator.sysj line: 259, column: 4
  private BottleTwin bOne_thread_18;//sysj\Orchestrator.sysj line: 283, column: 4
  private BottleTwin bTwo_thread_18;//sysj\Orchestrator.sysj line: 284, column: 4
  private BottleTwin bThree_thread_18;//sysj\Orchestrator.sysj line: 285, column: 4
  private BottleTwin bFour_thread_18;//sysj\Orchestrator.sysj line: 286, column: 4
  private BottleTwin bFive_thread_18;//sysj\Orchestrator.sysj line: 287, column: 4
  private BottleTwin bSix_thread_18;//sysj\Orchestrator.sysj line: 288, column: 4
  private BottleTwin bSeven_thread_19;//sysj\Orchestrator.sysj line: 313, column: 4
  private int id_thread_22;//sysj\Orchestrator.sysj line: 369, column: 5
  private BottleTwin b_thread_22;//sysj\Orchestrator.sysj line: 366, column: 4
  private int id_thread_23;//sysj\Orchestrator.sysj line: 388, column: 5
  private BottleTwin b_thread_23;//sysj\Orchestrator.sysj line: 385, column: 4
  private int id_thread_24;//sysj\Orchestrator.sysj line: 411, column: 5
  private BottleTwin b_thread_24;//sysj\Orchestrator.sysj line: 408, column: 4
  private int id_thread_25;//sysj\Orchestrator.sysj line: 431, column: 5
  private BottleTwin b_thread_25;//sysj\Orchestrator.sysj line: 428, column: 4
  private int id_thread_26;//sysj\Orchestrator.sysj line: 450, column: 5
  private BottleTwin b_thread_26;//sysj\Orchestrator.sysj line: 447, column: 4
  private int id_thread_27;//sysj\Orchestrator.sysj line: 469, column: 5
  private BottleTwin b_thread_27;//sysj\Orchestrator.sysj line: 466, column: 4
  private int id_thread_28;//sysj\Orchestrator.sysj line: 488, column: 5
  private BottleTwin b_thread_28;//sysj\Orchestrator.sysj line: 485, column: 4
  private int id_thread_29;//sysj\Orchestrator.sysj line: 507, column: 5
  private BottleTwin b_thread_29;//sysj\Orchestrator.sysj line: 504, column: 4
  private int id_thread_30;//sysj\Orchestrator.sysj line: 526, column: 5
  private BottleTwin b_thread_30;//sysj\Orchestrator.sysj line: 523, column: 4
  private BottleTwin b_thread_31;//sysj\Orchestrator.sysj line: 543, column: 4
  private int id_thread_31;//sysj\Orchestrator.sysj line: 545, column: 5
  private int S6844 = 1;
  private int S4543 = 1;
  private int S4487 = 1;
  private int S4488 = 1;
  private int S4734 = 1;
  private int S4546 = 1;
  private int S4550 = 1;
  private int S4549 = 1;
  private int S4554 = 1;
  private int S4553 = 1;
  private int S4558 = 1;
  private int S4557 = 1;
  private int S4562 = 1;
  private int S4561 = 1;
  private int S4584 = 1;
  private int S4583 = 1;
  private int S4588 = 1;
  private int S4587 = 1;
  private int S4768 = 1;
  private int S4742 = 1;
  private int S4738 = 1;
  private int S4802 = 1;
  private int S4776 = 1;
  private int S4772 = 1;
  private int S4836 = 1;
  private int S4810 = 1;
  private int S4806 = 1;
  private int S4870 = 1;
  private int S4844 = 1;
  private int S4840 = 1;
  private int S4920 = 1;
  private int S4882 = 1;
  private int S4876 = 1;
  private int S4874 = 1;
  private int S4970 = 1;
  private int S4932 = 1;
  private int S4926 = 1;
  private int S4996 = 1;
  private int S4972 = 1;
  private int S5016 = 1;
  private int S4998 = 1;
  private int S5036 = 1;
  private int S5018 = 1;
  private int S5062 = 1;
  private int S5038 = 1;
  private int S5082 = 1;
  private int S5064 = 1;
  private int S5102 = 1;
  private int S5084 = 1;
  private int S5276 = 1;
  private int S5103 = 1;
  private int S5124 = 1;
  private int S5450 = 1;
  private int S5277 = 1;
  private int S5298 = 1;
  private int S5624 = 1;
  private int S5451 = 1;
  private int S5472 = 1;
  private int S5798 = 1;
  private int S5625 = 1;
  private int S5646 = 1;
  private int S5972 = 1;
  private int S5799 = 1;
  private int S5820 = 1;
  private int S6146 = 1;
  private int S5973 = 1;
  private int S5994 = 1;
  private int S6320 = 1;
  private int S6147 = 1;
  private int S6168 = 1;
  private int S6494 = 1;
  private int S6321 = 1;
  private int S6342 = 1;
  private int S6668 = 1;
  private int S6495 = 1;
  private int S6516 = 1;
  private int S6842 = 1;
  private int S6669 = 1;
  private int S6690 = 1;
  
  private int[] ends = new int[32];
  private int[] tdone = new int[32];
  
  public void thread6910(int [] tdone, int [] ends){
        switch(S6842){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S6669){
          case 0 : 
            S6669=0;
            b_thread_31 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 543, column: 4
            S6669=1;
            if(b_thread_31 != null){//sysj\Orchestrator.sysj line: 544, column: 8
              S6690=0;
              id_thread_31 = b_thread_31.ID;//sysj\Orchestrator.sysj line: 545, column: 5
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 547, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_31);//sysj\Orchestrator.sysj line: 547, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 548, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_31);//sysj\Orchestrator.sysj line: 548, column: 6
              System.out.println("Emitted bottlePos9");
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S6690=1;
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 551, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 551, column: 5
              System.out.println("Emitted bottlePos9B");
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
          case 1 : 
            switch(S6690){
              case 0 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 546, column: 11
                  S6669=0;
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 548, column: 6
                  currsigs.addElement(bottlePos9);
                  bottlePos9.setValue(b_thread_31);//sysj\Orchestrator.sysj line: 548, column: 6
                  System.out.println("Emitted bottlePos9");
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                break;
              
              case 1 : 
                if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 552, column: 11
                  S6669=0;
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

  public void thread6909(int [] tdone, int [] ends){
        switch(S6668){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S6495){
          case 0 : 
            S6495=0;
            S6495=1;
            if(b_thread_30 != null){//sysj\Orchestrator.sysj line: 525, column: 8
              S6516=0;
              id_thread_30 = b_thread_30.ID;//sysj\Orchestrator.sysj line: 526, column: 5
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 528, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_30);//sysj\Orchestrator.sysj line: 528, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 529, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_30);//sysj\Orchestrator.sysj line: 529, column: 6
              System.out.println("Emitted bottlePos8");
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S6516=1;
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 532, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 532, column: 5
              System.out.println("Emitted bottlePos8B");
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
          case 1 : 
            switch(S6516){
              case 0 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 527, column: 11
                  b_thread_30 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 523, column: 4
                  S6495=0;
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 529, column: 6
                  currsigs.addElement(bottlePos8);
                  bottlePos8.setValue(b_thread_30);//sysj\Orchestrator.sysj line: 529, column: 6
                  System.out.println("Emitted bottlePos8");
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                break;
              
              case 1 : 
                if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 533, column: 11
                  b_thread_30 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 523, column: 4
                  S6495=0;
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

  public void thread6908(int [] tdone, int [] ends){
        switch(S6494){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S6321){
          case 0 : 
            S6321=0;
            S6321=1;
            if(b_thread_29 != null){//sysj\Orchestrator.sysj line: 506, column: 8
              S6342=0;
              id_thread_29 = b_thread_29.ID;//sysj\Orchestrator.sysj line: 507, column: 5
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 509, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_29);//sysj\Orchestrator.sysj line: 509, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 510, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_29);//sysj\Orchestrator.sysj line: 510, column: 6
              System.out.println("Emitted bottlePos7");
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S6342=1;
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 513, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 513, column: 5
              System.out.println("Emitted bottlePos7B");
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
          case 1 : 
            switch(S6342){
              case 0 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 508, column: 11
                  b_thread_29 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 504, column: 4
                  S6321=0;
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 510, column: 6
                  currsigs.addElement(bottlePos7);
                  bottlePos7.setValue(b_thread_29);//sysj\Orchestrator.sysj line: 510, column: 6
                  System.out.println("Emitted bottlePos7");
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                break;
              
              case 1 : 
                if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 514, column: 11
                  b_thread_29 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 504, column: 4
                  S6321=0;
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

  public void thread6907(int [] tdone, int [] ends){
        switch(S6320){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S6147){
          case 0 : 
            S6147=0;
            S6147=1;
            if(b_thread_28 != null){//sysj\Orchestrator.sysj line: 487, column: 8
              S6168=0;
              id_thread_28 = b_thread_28.ID;//sysj\Orchestrator.sysj line: 488, column: 5
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 490, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_28);//sysj\Orchestrator.sysj line: 490, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 491, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_28);//sysj\Orchestrator.sysj line: 491, column: 6
              System.out.println("Emitted bottlePos6");
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S6168=1;
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 494, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 494, column: 5
              System.out.println("Emitted bottlePos6B");
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
          case 1 : 
            switch(S6168){
              case 0 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 489, column: 11
                  b_thread_28 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 485, column: 4
                  S6147=0;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 491, column: 6
                  currsigs.addElement(bottlePos6);
                  bottlePos6.setValue(b_thread_28);//sysj\Orchestrator.sysj line: 491, column: 6
                  System.out.println("Emitted bottlePos6");
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
              case 1 : 
                if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 495, column: 11
                  b_thread_28 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 485, column: 4
                  S6147=0;
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

  public void thread6906(int [] tdone, int [] ends){
        switch(S6146){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S5973){
          case 0 : 
            S5973=0;
            S5973=1;
            if(b_thread_27 != null){//sysj\Orchestrator.sysj line: 468, column: 8
              S5994=0;
              id_thread_27 = b_thread_27.ID;//sysj\Orchestrator.sysj line: 469, column: 5
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 471, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_27);//sysj\Orchestrator.sysj line: 471, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 472, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_27);//sysj\Orchestrator.sysj line: 472, column: 6
              System.out.println("Emitted bottlePos5");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              S5994=1;
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 475, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 475, column: 5
              System.out.println("Emitted bottlePos5B");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 1 : 
            switch(S5994){
              case 0 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 470, column: 11
                  b_thread_27 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 466, column: 4
                  S5973=0;
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                else {
                  bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 472, column: 6
                  currsigs.addElement(bottlePos5);
                  bottlePos5.setValue(b_thread_27);//sysj\Orchestrator.sysj line: 472, column: 6
                  System.out.println("Emitted bottlePos5");
                  active[27]=1;
                  ends[27]=1;
                  tdone[27]=1;
                }
                break;
              
              case 1 : 
                if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 476, column: 11
                  b_thread_27 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 466, column: 4
                  S5973=0;
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

  public void thread6905(int [] tdone, int [] ends){
        switch(S5972){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S5799){
          case 0 : 
            S5799=0;
            S5799=1;
            if(b_thread_26 != null){//sysj\Orchestrator.sysj line: 449, column: 8
              S5820=0;
              id_thread_26 = b_thread_26.ID;//sysj\Orchestrator.sysj line: 450, column: 5
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 452, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_26);//sysj\Orchestrator.sysj line: 452, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 453, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 453, column: 6
              System.out.println("Emitted bottlePos4");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S5820=1;
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 456, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 456, column: 5
              System.out.println("Emitted bottlePos4B");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 1 : 
            switch(S5820){
              case 0 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 451, column: 11
                  b_thread_26 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 447, column: 4
                  S5799=0;
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                else {
                  bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 453, column: 6
                  currsigs.addElement(bottlePos4);
                  bottlePos4.setValue(b_thread_26);//sysj\Orchestrator.sysj line: 453, column: 6
                  System.out.println("Emitted bottlePos4");
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                break;
              
              case 1 : 
                if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 457, column: 11
                  b_thread_26 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 447, column: 4
                  S5799=0;
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

  public void thread6904(int [] tdone, int [] ends){
        switch(S5798){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S5625){
          case 0 : 
            S5625=0;
            S5625=1;
            if(b_thread_25 != null){//sysj\Orchestrator.sysj line: 430, column: 8
              S5646=0;
              id_thread_25 = b_thread_25.ID;//sysj\Orchestrator.sysj line: 431, column: 5
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 433, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_25);//sysj\Orchestrator.sysj line: 433, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 434, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 434, column: 6
              System.out.println("Emitted bottlePos3");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S5646=1;
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 437, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 437, column: 5
              System.out.println("Emitted bottlePos3B");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            switch(S5646){
              case 0 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 432, column: 11
                  b_thread_25 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 428, column: 4
                  S5625=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                else {
                  bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 434, column: 6
                  currsigs.addElement(bottlePos3);
                  bottlePos3.setValue(b_thread_25);//sysj\Orchestrator.sysj line: 434, column: 6
                  System.out.println("Emitted bottlePos3");
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                }
                break;
              
              case 1 : 
                if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 438, column: 11
                  b_thread_25 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 428, column: 4
                  S5625=0;
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

  public void thread6903(int [] tdone, int [] ends){
        switch(S5624){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S5451){
          case 0 : 
            S5451=0;
            S5451=1;
            if(b_thread_24 != null){//sysj\Orchestrator.sysj line: 410, column: 8
              S5472=0;
              id_thread_24 = b_thread_24.ID;//sysj\Orchestrator.sysj line: 411, column: 5
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 413, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_24);//sysj\Orchestrator.sysj line: 413, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 414, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 414, column: 6
              System.out.println("Emitted bottlePos2");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S5472=1;
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 417, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 417, column: 5
              System.out.println("Emitted bottlePos2B");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S5472){
              case 0 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 412, column: 11
                  b_thread_24 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 408, column: 4
                  S5451=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 414, column: 6
                  currsigs.addElement(bottlePos2);
                  bottlePos2.setValue(b_thread_24);//sysj\Orchestrator.sysj line: 414, column: 6
                  System.out.println("Emitted bottlePos2");
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
              case 1 : 
                if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 418, column: 11
                  b_thread_24 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 408, column: 4
                  S5451=0;
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

  public void thread6902(int [] tdone, int [] ends){
        switch(S5450){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S5277){
          case 0 : 
            S5277=0;
            S5277=1;
            if(b_thread_23 != null){//sysj\Orchestrator.sysj line: 387, column: 8
              S5298=0;
              id_thread_23 = b_thread_23.ID;//sysj\Orchestrator.sysj line: 388, column: 5
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 390, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_23);//sysj\Orchestrator.sysj line: 390, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 392, column: 7
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 392, column: 7
              System.out.println("Emitted bottlePos1");
              bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 393, column: 7
              currsigs.addElement(bottlePos1Rot);
              bottlePos1Rot.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 393, column: 7
              System.out.println("Emitted bottlePos1Rot");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S5298=1;
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 398, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 398, column: 5
              System.out.println("Emitted bottlePos1B");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S5298){
              case 0 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 389, column: 11
                  b_thread_23 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
                  S5277=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 392, column: 7
                  currsigs.addElement(bottlePos1);
                  bottlePos1.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 392, column: 7
                  System.out.println("Emitted bottlePos1");
                  bottlePos1Rot.setPresent();//sysj\Orchestrator.sysj line: 393, column: 7
                  currsigs.addElement(bottlePos1Rot);
                  bottlePos1Rot.setValue(b_thread_23);//sysj\Orchestrator.sysj line: 393, column: 7
                  System.out.println("Emitted bottlePos1Rot");
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 399, column: 11
                  b_thread_23 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
                  S5277=0;
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

  public void thread6901(int [] tdone, int [] ends){
        switch(S5276){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S5103){
          case 0 : 
            S5103=0;
            S5103=1;
            if(b_thread_22 != null){//sysj\Orchestrator.sysj line: 368, column: 8
              S5124=0;
              id_thread_22 = b_thread_22.ID;//sysj\Orchestrator.sysj line: 369, column: 5
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 371, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_22);//sysj\Orchestrator.sysj line: 371, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 372, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 372, column: 6
              System.out.println("Emitted bottlePos0");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S5124=1;
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 375, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 375, column: 5
              System.out.println("Emitted bottlePos0B");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S5124){
              case 0 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 370, column: 11
                  b_thread_22 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 366, column: 4
                  S5103=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 372, column: 6
                  currsigs.addElement(bottlePos0);
                  bottlePos0.setValue(b_thread_22);//sysj\Orchestrator.sysj line: 372, column: 6
                  System.out.println("Emitted bottlePos0");
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 376, column: 11
                  b_thread_22 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 366, column: 4
                  S5103=0;
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

  public void thread6900(int [] tdone, int [] ends){
        switch(S5102){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5084){
          case 0 : 
            if(startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 347, column: 10
              startCapLoading.setPresent();//sysj\Orchestrator.sysj line: 349, column: 4
              currsigs.addElement(startCapLoading);
              System.out.println("Emitted startCapLoading");
              S5084=1;
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
            if(capLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 350, column: 10
              S5084=2;
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
            S5084=2;
            S5084=3;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 3 : 
            S5084=3;
            capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 353, column: 4
            currsigs.addElement(capLoaderFinish_1);
            System.out.println("Emitted capLoaderFinish_1");
            S5084=4;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 4 : 
            if(!startCapLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 355, column: 10
              S5084=0;
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

  public void thread6899(int [] tdone, int [] ends){
        switch(S5082){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5064){
          case 0 : 
            if(startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 330, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 332, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S5064=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 333, column: 10
              S5064=2;
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
            S5064=2;
            S5064=3;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 3 : 
            S5064=3;
            fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 336, column: 4
            currsigs.addElement(fillerFinish_1);
            System.out.println("Emitted fillerFinish_1");
            S5064=4;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 4 : 
            if(!startFillerThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 338, column: 10
              S5064=0;
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

  public void thread6898(int [] tdone, int [] ends){
        switch(S5062){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5038){
          case 0 : 
            if(startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 309, column: 10
              startBottleUnloading.setPresent();//sysj\Orchestrator.sysj line: 311, column: 4
              currsigs.addElement(startBottleUnloading);
              System.out.println("Emitted startBottleUnloading");
              S5038=1;
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
            if(bottleUnloaded.getprestatus()){//sysj\Orchestrator.sysj line: 312, column: 10
              bSeven_thread_19 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 313, column: 4
              S5038=2;
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
            S5038=2;
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 315, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 315, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            posNineUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 316, column: 4
            currsigs.addElement(posNineUpdate_1);
            posNineUpdate_1.setValue(bSeven_thread_19);//sysj\Orchestrator.sysj line: 316, column: 4
            System.out.println("Emitted posNineUpdate_1");
            S5038=3;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 3 : 
            if(bottleUnloaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 317, column: 10
              S5038=4;
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
          
          case 4 : 
            S5038=4;
            robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 319, column: 4
            currsigs.addElement(robotUnloaderFinish_1);
            System.out.println("Emitted robotUnloaderFinish_1");
            S5038=5;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 5 : 
            if(!startRobotUnloaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 320, column: 10
              S5038=0;
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

  public void thread6897(int [] tdone, int [] ends){
        switch(S5036){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5018){
          case 0 : 
            if(startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 278, column: 10
              startRotTable.setPresent();//sysj\Orchestrator.sysj line: 281, column: 4
              currsigs.addElement(startRotTable);
              System.out.println("Emitted startRotTable");
              S5018=1;
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
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 282, column: 10
              bOne_thread_18 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 283, column: 4
              bTwo_thread_18 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 284, column: 4
              bThree_thread_18 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 285, column: 4
              bFour_thread_18 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 286, column: 4
              bFive_thread_18 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 287, column: 4
              bSix_thread_18 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 288, column: 4
              S5018=2;
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
            S5018=2;
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 290, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bSix_thread_18);//sysj\Orchestrator.sysj line: 290, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posTwoUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 291, column: 4
            currsigs.addElement(posTwoUpdate_1);
            posTwoUpdate_1.setValue(bOne_thread_18);//sysj\Orchestrator.sysj line: 291, column: 4
            System.out.println("Emitted posTwoUpdate_1");
            posThreeUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 292, column: 4
            currsigs.addElement(posThreeUpdate_1);
            posThreeUpdate_1.setValue(bTwo_thread_18);//sysj\Orchestrator.sysj line: 292, column: 4
            System.out.println("Emitted posThreeUpdate_1");
            posFourUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 293, column: 4
            currsigs.addElement(posFourUpdate_1);
            posFourUpdate_1.setValue(bThree_thread_18);//sysj\Orchestrator.sysj line: 293, column: 4
            System.out.println("Emitted posFourUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 294, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(bFour_thread_18);//sysj\Orchestrator.sysj line: 294, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posSixUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 295, column: 4
            currsigs.addElement(posSixUpdate_1);
            posSixUpdate_1.setValue(bFive_thread_18);//sysj\Orchestrator.sysj line: 295, column: 4
            System.out.println("Emitted posSixUpdate_1");
            S5018=3;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 3 : 
            S5018=3;
            rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 298, column: 4
            currsigs.addElement(rotTableFinish_1);
            System.out.println("Emitted rotTableFinish_1");
            S5018=4;
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 4 : 
            if(!startRotThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 299, column: 10
              S5018=0;
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

  public void thread6896(int [] tdone, int [] ends){
        switch(S5016){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S4998){
          case 0 : 
            if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 252, column: 10
              startConveyor.setPresent();//sysj\Orchestrator.sysj line: 255, column: 4
              currsigs.addElement(startConveyor);
              System.out.println("Emitted startConveyor");
              S4998=1;
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
            if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 256, column: 10
              bZero_thread_17 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 258, column: 4
              bFive_thread_17 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 259, column: 4
              S4998=2;
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
          
          case 2 : 
            S4998=2;
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 261, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 261, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 262, column: 4
            currsigs.addElement(posFiveUpdate_1);
            posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 262, column: 4
            System.out.println("Emitted posFiveUpdate_1");
            posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 263, column: 4
            currsigs.addElement(posOneUpdate_1);
            posOneUpdate_1.setValue(bZero_thread_17);//sysj\Orchestrator.sysj line: 263, column: 4
            System.out.println("Emitted posOneUpdate_1");
            posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 264, column: 4
            currsigs.addElement(posSevenUpdate_1);
            posSevenUpdate_1.setValue(bFive_thread_17);//sysj\Orchestrator.sysj line: 264, column: 4
            System.out.println("Emitted posSevenUpdate_1");
            S4998=3;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
          case 3 : 
            S4998=3;
            conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 267, column: 4
            currsigs.addElement(conveyorFinish_1);
            System.out.println("Emitted conveyorFinish_1");
            S4998=4;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
          case 4 : 
            if(!startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 268, column: 10
              S4998=0;
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
  }

  public void thread6895(int [] tdone, int [] ends){
        switch(S4996){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S4972){
          case 0 : 
            if(startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 227, column: 10
              startBottleLoading.setPresent();//sysj\Orchestrator.sysj line: 229, column: 4
              currsigs.addElement(startBottleLoading);
              System.out.println("Emitted startBottleLoading");
              S4972=1;
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
            if(bottleLoaded.getprestatus()){//sysj\Orchestrator.sysj line: 230, column: 10
              bEight_thread_16 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 232, column: 4
              S4972=2;
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
          
          case 2 : 
            S4972=2;
            posEightUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 234, column: 4
            currsigs.addElement(posEightUpdate_1);
            posEightUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 234, column: 4
            System.out.println("Emitted posEightUpdate_1");
            posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 235, column: 4
            currsigs.addElement(posZeroUpdate_1);
            posZeroUpdate_1.setValue(bEight_thread_16);//sysj\Orchestrator.sysj line: 235, column: 4
            System.out.println("Emitted posZeroUpdate_1");
            S4972=3;
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
          case 3 : 
            if(bottleLoaderRelease.getprestatus()){//sysj\Orchestrator.sysj line: 237, column: 10
              S4972=4;
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
          
          case 4 : 
            S4972=4;
            robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 240, column: 4
            currsigs.addElement(robotLoaderFinish_1);
            System.out.println("Emitted robotLoaderFinish_1");
            S4972=5;
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
          case 5 : 
            if(!startRobotLoaderThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 241, column: 10
              S4972=0;
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
  }

  public void thread6894(int [] tdone, int [] ends){
        switch(S4970){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S4932){
          case 0 : 
            if(checkCapLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 208, column: 10
              S4932=1;
              if(bottlePos3.getprestatus()){//sysj\Orchestrator.sysj line: 209, column: 12
                S4926=0;
                b_thread_15 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 210, column: 5
                if(!b_thread_15.isCapOn && !b_thread_15.isCapped){//sysj\Orchestrator.sysj line: 211, column: 8
                  startCapLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 212, column: 6
                  currsigs.addElement(startCapLoaderThread_1);
                  System.out.println("Emitted startCapLoaderThread_1");
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S4926=1;
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
            switch(S4926){
              case 0 : 
                S4932=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
                break;
              
              case 1 : 
                capLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 217, column: 5
                currsigs.addElement(capLoaderFinish_1);
                System.out.println("Emitted capLoaderFinish_1");
                S4932=0;
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

  public void thread6893(int [] tdone, int [] ends){
        switch(S4920){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4882){
          case 0 : 
            if(checkFiller_1.getprestatus()){//sysj\Orchestrator.sysj line: 190, column: 10
              S4882=1;
              if(bottlePos2.getprestatus()){//sysj\Orchestrator.sysj line: 191, column: 12
                S4876=0;
                b_thread_14 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 192, column: 5
                S4874=0;
                if(!b_thread_14.isFilled){//sysj\Orchestrator.sysj line: 193, column: 8
                  startFillerThread_1.setPresent();//sysj\Orchestrator.sysj line: 194, column: 6
                  currsigs.addElement(startFillerThread_1);
                  System.out.println("Emitted startFillerThread_1");
                  S4874=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  S4874=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
              else {
                S4876=1;
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
            switch(S4876){
              case 0 : 
                switch(S4874){
                  case 0 : 
                    S4882=0;
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                    break;
                  
                  case 1 : 
                    S4874=1;
                    S4882=0;
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                    break;
                  
                }
                break;
              
              case 1 : 
                fillerFinish_1.setPresent();//sysj\Orchestrator.sysj line: 199, column: 5
                currsigs.addElement(fillerFinish_1);
                System.out.println("Emitted fillerFinish_1");
                S4882=0;
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

  public void thread6892(int [] tdone, int [] ends){
        switch(S4870){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S4844){
          case 0 : 
            if(checkRobotUnloader_1.getprestatus()){//sysj\Orchestrator.sysj line: 175, column: 10
              S4844=1;
              if(bottlePos7.getprestatus()){//sysj\Orchestrator.sysj line: 176, column: 12
                S4840=0;
                startRobotUnloaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 177, column: 5
                currsigs.addElement(startRobotUnloaderThread_1);
                System.out.println("Emitted startRobotUnloaderThread_1");
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S4840=1;
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
            switch(S4840){
              case 0 : 
                S4844=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
                break;
              
              case 1 : 
                robotUnloaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 181, column: 5
                currsigs.addElement(robotUnloaderFinish_1);
                System.out.println("Emitted robotUnloaderFinish_1");
                S4844=0;
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

  public void thread6891(int [] tdone, int [] ends){
        switch(S4836){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S4810){
          case 0 : 
            if(checkRotTable_1.getprestatus()){//sysj\Orchestrator.sysj line: 158, column: 10
              S4810=1;
              if(bottlePos1.getprestatus() || bottlePos2.getprestatus() || bottlePos3.getprestatus() || bottlePos4.getprestatus() || bottlePos5.getprestatus() || bottlePos6.getprestatus()){//sysj\Orchestrator.sysj line: 160, column: 12
                S4806=0;
                startRotThread_1.setPresent();//sysj\Orchestrator.sysj line: 161, column: 5
                currsigs.addElement(startRotThread_1);
                System.out.println("Emitted startRotThread_1");
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
              }
              else {
                S4806=1;
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
            switch(S4806){
              case 0 : 
                S4810=0;
                active[12]=1;
                ends[12]=1;
                tdone[12]=1;
                break;
              
              case 1 : 
                rotTableFinish_1.setPresent();//sysj\Orchestrator.sysj line: 165, column: 5
                currsigs.addElement(rotTableFinish_1);
                System.out.println("Emitted rotTableFinish_1");
                S4810=0;
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

  public void thread6890(int [] tdone, int [] ends){
        switch(S4802){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S4776){
          case 0 : 
            if(checkConveyor_1.getprestatus()){//sysj\Orchestrator.sysj line: 143, column: 10
              S4776=1;
              if((!bottlePos7.getprestatus() && !bottlePos1.getprestatus()) && (bottlePos0.getprestatus() || bottlePos5.getprestatus())){//sysj\Orchestrator.sysj line: 144, column: 12
                S4772=0;
                startConveyorThread_1.setPresent();//sysj\Orchestrator.sysj line: 145, column: 5
                currsigs.addElement(startConveyorThread_1);
                System.out.println("Emitted startConveyorThread_1");
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S4772=1;
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
            switch(S4772){
              case 0 : 
                S4776=0;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
                break;
              
              case 1 : 
                conveyorFinish_1.setPresent();//sysj\Orchestrator.sysj line: 149, column: 5
                currsigs.addElement(conveyorFinish_1);
                System.out.println("Emitted conveyorFinish_1");
                S4776=0;
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

  public void thread6889(int [] tdone, int [] ends){
        switch(S4768){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S4742){
          case 0 : 
            if(checkRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 128, column: 10
              S4742=1;
              if(!bottlePos0.getprestatus() && bottlePos8.getprestatus()){//sysj\Orchestrator.sysj line: 129, column: 12
                S4738=0;
                startRobotLoaderThread_1.setPresent();//sysj\Orchestrator.sysj line: 130, column: 5
                currsigs.addElement(startRobotLoaderThread_1);
                System.out.println("Emitted startRobotLoaderThread_1");
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
              else {
                S4738=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            switch(S4738){
              case 0 : 
                S4742=0;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
                break;
              
              case 1 : 
                robotLoaderFinish_1.setPresent();//sysj\Orchestrator.sysj line: 134, column: 5
                currsigs.addElement(robotLoaderFinish_1);
                System.out.println("Emitted robotLoaderFinish_1");
                S4742=0;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6887(int [] tdone, int [] ends){
        switch(S4588){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S4587){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 11
              S4587=1;
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
            S4587=1;
            S4587=2;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
          case 2 : 
            S4587=2;
            S4588=0;
            active[9]=0;
            ends[9]=0;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6886(int [] tdone, int [] ends){
        switch(S4584){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S4583){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 94, column: 11
              S4583=1;
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
            S4583=1;
            S4583=2;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S4583=2;
            S4584=0;
            active[8]=0;
            ends[8]=0;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6884(int [] tdone, int [] ends){
        S4588=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 101, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S4587=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread6883(int [] tdone, int [] ends){
        S4584=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 93, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S4583=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread6881(int [] tdone, int [] ends){
        switch(S4562){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S4561){
          case 0 : 
            if(robotUnloaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 82, column: 11
              S4561=1;
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
            S4561=1;
            S4561=2;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            S4561=2;
            S4562=0;
            active[7]=0;
            ends[7]=0;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6880(int [] tdone, int [] ends){
        switch(S4558){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S4557){
          case 0 : 
            if(robotLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 11
              S4557=1;
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
            S4557=1;
            S4557=2;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            S4557=2;
            S4558=0;
            active[6]=0;
            ends[6]=0;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6879(int [] tdone, int [] ends){
        switch(S4554){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S4553){
          case 0 : 
            if(fillerFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 67, column: 11
              S4553=1;
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
            S4553=1;
            S4553=2;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 2 : 
            S4553=2;
            S4554=0;
            active[5]=0;
            ends[5]=0;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6878(int [] tdone, int [] ends){
        switch(S4550){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4549){
          case 0 : 
            if(capLoaderFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 11
              S4549=1;
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
            S4549=1;
            S4549=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S4549=2;
            S4550=0;
            active[4]=0;
            ends[4]=0;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread6876(int [] tdone, int [] ends){
        S4562=1;
    checkRobotUnloader_1.setPresent();//sysj\Orchestrator.sysj line: 81, column: 5
    currsigs.addElement(checkRobotUnloader_1);
    System.out.println("Emitted checkRobotUnloader_1");
    S4561=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread6875(int [] tdone, int [] ends){
        S4558=1;
    checkRobotLoader_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 5
    currsigs.addElement(checkRobotLoader_1);
    System.out.println("Emitted checkRobotLoader_1");
    S4557=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread6874(int [] tdone, int [] ends){
        S4554=1;
    checkFiller_1.setPresent();//sysj\Orchestrator.sysj line: 66, column: 5
    currsigs.addElement(checkFiller_1);
    System.out.println("Emitted checkFiller_1");
    S4553=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread6873(int [] tdone, int [] ends){
        S4550=1;
    checkCapLoader_1.setPresent();//sysj\Orchestrator.sysj line: 58, column: 5
    currsigs.addElement(checkCapLoader_1);
    System.out.println("Emitted checkCapLoader_1");
    S4549=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread6872(int [] tdone, int [] ends){
        switch(S4734){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4546){
          case 0 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 53, column: 10
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
            S4546=3;
            thread6873(tdone,ends);
            thread6874(tdone,ends);
            thread6875(tdone,ends);
            thread6876(tdone,ends);
            int biggest6877 = 0;
            if(ends[4]>=biggest6877){
              biggest6877=ends[4];
            }
            if(ends[5]>=biggest6877){
              biggest6877=ends[5];
            }
            if(ends[6]>=biggest6877){
              biggest6877=ends[6];
            }
            if(ends[7]>=biggest6877){
              biggest6877=ends[7];
            }
            if(biggest6877 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            thread6878(tdone,ends);
            thread6879(tdone,ends);
            thread6880(tdone,ends);
            thread6881(tdone,ends);
            int biggest6882 = 0;
            if(ends[4]>=biggest6882){
              biggest6882=ends[4];
            }
            if(ends[5]>=biggest6882){
              biggest6882=ends[5];
            }
            if(ends[6]>=biggest6882){
              biggest6882=ends[6];
            }
            if(ends[7]>=biggest6882){
              biggest6882=ends[7];
            }
            if(biggest6882 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest6882 == 0){
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 87, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
              S4546=4;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(conveyorFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 88, column: 10
              S4546=5;
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
            S4546=5;
            S4546=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            S4546=6;
            S4546=7;
            thread6883(tdone,ends);
            thread6884(tdone,ends);
            int biggest6885 = 0;
            if(ends[8]>=biggest6885){
              biggest6885=ends[8];
            }
            if(ends[9]>=biggest6885){
              biggest6885=ends[9];
            }
            if(biggest6885 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 7 : 
            thread6886(tdone,ends);
            thread6887(tdone,ends);
            int biggest6888 = 0;
            if(ends[8]>=biggest6888){
              biggest6888=ends[8];
            }
            if(ends[9]>=biggest6888){
              biggest6888=ends[9];
            }
            if(biggest6888 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            //FINXME code
            if(biggest6888 == 0){
              S4546=8;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 8 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 108, column: 10
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 109, column: 10
              checkRotTable_1.setPresent();//sysj\Orchestrator.sysj line: 111, column: 4
              currsigs.addElement(checkRotTable_1);
              System.out.println("Emitted checkRotTable_1");
              S4546=10;
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
            if(rotTableFinish_1.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 10
              S4546=11;
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
            S4546=11;
            S4546=12;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 12 : 
            S4546=12;
            S4546=13;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 13 : 
            if(!enable.getprestatus()){//sysj\Orchestrator.sysj line: 116, column: 10
              S4546=14;
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
            if(enable.getprestatus()){//sysj\Orchestrator.sysj line: 117, column: 10
              checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
              currsigs.addElement(checkConveyor_1);
              System.out.println("Emitted checkConveyor_1");
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

  public void thread6871(int [] tdone, int [] ends){
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

  public void thread6869(int [] tdone, int [] ends){
        S6842=1;
    S6669=0;
    active[31]=1;
    ends[31]=1;
    tdone[31]=1;
  }

  public void thread6868(int [] tdone, int [] ends){
        S6668=1;
    b_thread_30 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 523, column: 4
    S6495=0;
    active[30]=1;
    ends[30]=1;
    tdone[30]=1;
  }

  public void thread6867(int [] tdone, int [] ends){
        S6494=1;
    b_thread_29 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 504, column: 4
    S6321=0;
    active[29]=1;
    ends[29]=1;
    tdone[29]=1;
  }

  public void thread6866(int [] tdone, int [] ends){
        S6320=1;
    b_thread_28 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 485, column: 4
    S6147=0;
    active[28]=1;
    ends[28]=1;
    tdone[28]=1;
  }

  public void thread6865(int [] tdone, int [] ends){
        S6146=1;
    b_thread_27 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 466, column: 4
    S5973=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread6864(int [] tdone, int [] ends){
        S5972=1;
    b_thread_26 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 447, column: 4
    S5799=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread6863(int [] tdone, int [] ends){
        S5798=1;
    b_thread_25 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 428, column: 4
    S5625=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread6862(int [] tdone, int [] ends){
        S5624=1;
    b_thread_24 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 408, column: 4
    S5451=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread6861(int [] tdone, int [] ends){
        S5450=1;
    b_thread_23 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 385, column: 4
    S5277=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread6860(int [] tdone, int [] ends){
        S5276=1;
    b_thread_22 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 366, column: 4
    S5103=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread6859(int [] tdone, int [] ends){
        S5102=1;
    S5084=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread6858(int [] tdone, int [] ends){
        S5082=1;
    S5064=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread6857(int [] tdone, int [] ends){
        S5062=1;
    S5038=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread6856(int [] tdone, int [] ends){
        S5036=1;
    S5018=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread6855(int [] tdone, int [] ends){
        S5016=1;
    S4998=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread6854(int [] tdone, int [] ends){
        S4996=1;
    S4972=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread6853(int [] tdone, int [] ends){
        S4970=1;
    S4932=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread6852(int [] tdone, int [] ends){
        S4920=1;
    S4882=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread6851(int [] tdone, int [] ends){
        S4870=1;
    S4844=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread6850(int [] tdone, int [] ends){
        S4836=1;
    S4810=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread6849(int [] tdone, int [] ends){
        S4802=1;
    S4776=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread6848(int [] tdone, int [] ends){
        S4768=1;
    S4742=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread6847(int [] tdone, int [] ends){
        S4734=1;
    checkConveyor_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
    currsigs.addElement(checkConveyor_1);
    System.out.println("Emitted checkConveyor_1");
    S4546=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6846(int [] tdone, int [] ends){
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
      switch(S6844){
        case 0 : 
          S6844=0;
          break RUN;
        
        case 1 : 
          S6844=2;
          S6844=2;
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
          thread6846(tdone,ends);
          thread6847(tdone,ends);
          thread6848(tdone,ends);
          thread6849(tdone,ends);
          thread6850(tdone,ends);
          thread6851(tdone,ends);
          thread6852(tdone,ends);
          thread6853(tdone,ends);
          thread6854(tdone,ends);
          thread6855(tdone,ends);
          thread6856(tdone,ends);
          thread6857(tdone,ends);
          thread6858(tdone,ends);
          thread6859(tdone,ends);
          thread6860(tdone,ends);
          thread6861(tdone,ends);
          thread6862(tdone,ends);
          thread6863(tdone,ends);
          thread6864(tdone,ends);
          thread6865(tdone,ends);
          thread6866(tdone,ends);
          thread6867(tdone,ends);
          thread6868(tdone,ends);
          thread6869(tdone,ends);
          int biggest6870 = 0;
          if(ends[2]>=biggest6870){
            biggest6870=ends[2];
          }
          if(ends[3]>=biggest6870){
            biggest6870=ends[3];
          }
          if(ends[10]>=biggest6870){
            biggest6870=ends[10];
          }
          if(ends[11]>=biggest6870){
            biggest6870=ends[11];
          }
          if(ends[12]>=biggest6870){
            biggest6870=ends[12];
          }
          if(ends[13]>=biggest6870){
            biggest6870=ends[13];
          }
          if(ends[14]>=biggest6870){
            biggest6870=ends[14];
          }
          if(ends[15]>=biggest6870){
            biggest6870=ends[15];
          }
          if(ends[16]>=biggest6870){
            biggest6870=ends[16];
          }
          if(ends[17]>=biggest6870){
            biggest6870=ends[17];
          }
          if(ends[18]>=biggest6870){
            biggest6870=ends[18];
          }
          if(ends[19]>=biggest6870){
            biggest6870=ends[19];
          }
          if(ends[20]>=biggest6870){
            biggest6870=ends[20];
          }
          if(ends[21]>=biggest6870){
            biggest6870=ends[21];
          }
          if(ends[22]>=biggest6870){
            biggest6870=ends[22];
          }
          if(ends[23]>=biggest6870){
            biggest6870=ends[23];
          }
          if(ends[24]>=biggest6870){
            biggest6870=ends[24];
          }
          if(ends[25]>=biggest6870){
            biggest6870=ends[25];
          }
          if(ends[26]>=biggest6870){
            biggest6870=ends[26];
          }
          if(ends[27]>=biggest6870){
            biggest6870=ends[27];
          }
          if(ends[28]>=biggest6870){
            biggest6870=ends[28];
          }
          if(ends[29]>=biggest6870){
            biggest6870=ends[29];
          }
          if(ends[30]>=biggest6870){
            biggest6870=ends[30];
          }
          if(ends[31]>=biggest6870){
            biggest6870=ends[31];
          }
          if(biggest6870 == 1){
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
          thread6871(tdone,ends);
          thread6872(tdone,ends);
          thread6889(tdone,ends);
          thread6890(tdone,ends);
          thread6891(tdone,ends);
          thread6892(tdone,ends);
          thread6893(tdone,ends);
          thread6894(tdone,ends);
          thread6895(tdone,ends);
          thread6896(tdone,ends);
          thread6897(tdone,ends);
          thread6898(tdone,ends);
          thread6899(tdone,ends);
          thread6900(tdone,ends);
          thread6901(tdone,ends);
          thread6902(tdone,ends);
          thread6903(tdone,ends);
          thread6904(tdone,ends);
          thread6905(tdone,ends);
          thread6906(tdone,ends);
          thread6907(tdone,ends);
          thread6908(tdone,ends);
          thread6909(tdone,ends);
          thread6910(tdone,ends);
          int biggest6911 = 0;
          if(ends[2]>=biggest6911){
            biggest6911=ends[2];
          }
          if(ends[3]>=biggest6911){
            biggest6911=ends[3];
          }
          if(ends[10]>=biggest6911){
            biggest6911=ends[10];
          }
          if(ends[11]>=biggest6911){
            biggest6911=ends[11];
          }
          if(ends[12]>=biggest6911){
            biggest6911=ends[12];
          }
          if(ends[13]>=biggest6911){
            biggest6911=ends[13];
          }
          if(ends[14]>=biggest6911){
            biggest6911=ends[14];
          }
          if(ends[15]>=biggest6911){
            biggest6911=ends[15];
          }
          if(ends[16]>=biggest6911){
            biggest6911=ends[16];
          }
          if(ends[17]>=biggest6911){
            biggest6911=ends[17];
          }
          if(ends[18]>=biggest6911){
            biggest6911=ends[18];
          }
          if(ends[19]>=biggest6911){
            biggest6911=ends[19];
          }
          if(ends[20]>=biggest6911){
            biggest6911=ends[20];
          }
          if(ends[21]>=biggest6911){
            biggest6911=ends[21];
          }
          if(ends[22]>=biggest6911){
            biggest6911=ends[22];
          }
          if(ends[23]>=biggest6911){
            biggest6911=ends[23];
          }
          if(ends[24]>=biggest6911){
            biggest6911=ends[24];
          }
          if(ends[25]>=biggest6911){
            biggest6911=ends[25];
          }
          if(ends[26]>=biggest6911){
            biggest6911=ends[26];
          }
          if(ends[27]>=biggest6911){
            biggest6911=ends[27];
          }
          if(ends[28]>=biggest6911){
            biggest6911=ends[28];
          }
          if(ends[29]>=biggest6911){
            biggest6911=ends[29];
          }
          if(ends[30]>=biggest6911){
            biggest6911=ends[30];
          }
          if(ends[31]>=biggest6911){
            biggest6911=ends[31];
          }
          if(biggest6911 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6911 == 0){
            S6844=0;
            active[1]=0;
            ends[1]=0;
            S6844=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
