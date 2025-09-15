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
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal startConveyor = new Signal("startConveyor", Signal.OUTPUT);
  public Signal startRotTable = new Signal("startRotTable", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
  public Signal startCapLoading = new Signal("startCapLoading", Signal.OUTPUT);
  public Signal capperBottleOut = new Signal("capperBottleOut", Signal.OUTPUT);
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
  private Signal startRobotLoader_1;
  private Signal startConveyorThread_1;
  private Signal startRotThread_1;
  private Signal startCapLoaderThread_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 20, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 23, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 24, column: 5
  private BottleTwin bZero_thread_3;//sysj\Orchestrator.sysj line: 49, column: 4
  private BottleTwin bFive_thread_3;//sysj\Orchestrator.sysj line: 50, column: 4
  private BottleTwin bZero_thread_4;//sysj\Orchestrator.sysj line: 68, column: 4
  private BottleTwin bFive_thread_4;//sysj\Orchestrator.sysj line: 69, column: 4
  private BottleTwin b_thread_5;//sysj\Orchestrator.sysj line: 90, column: 4
  private int id_thread_5;//sysj\Orchestrator.sysj line: 91, column: 4
  private BottleTwin b_thread_6;//sysj\Orchestrator.sysj line: 108, column: 4
  private int id_thread_6;//sysj\Orchestrator.sysj line: 109, column: 4
  private BottleTwin b_thread_7;//sysj\Orchestrator.sysj line: 126, column: 4
  private int id_thread_7;//sysj\Orchestrator.sysj line: 127, column: 4
  private BottleTwin b_thread_8;//sysj\Orchestrator.sysj line: 145, column: 4
  private int id_thread_8;//sysj\Orchestrator.sysj line: 146, column: 4
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 163, column: 4
  private int id_thread_9;//sysj\Orchestrator.sysj line: 164, column: 4
  private BottleTwin b_thread_10;//sysj\Orchestrator.sysj line: 181, column: 4
  private int id_thread_10;//sysj\Orchestrator.sysj line: 182, column: 4
  private BottleTwin b_thread_11;//sysj\Orchestrator.sysj line: 199, column: 4
  private int id_thread_11;//sysj\Orchestrator.sysj line: 200, column: 4
  private BottleTwin b_thread_12;//sysj\Orchestrator.sysj line: 217, column: 4
  private int id_thread_12;//sysj\Orchestrator.sysj line: 218, column: 4
  private BottleTwin b_thread_13;//sysj\Orchestrator.sysj line: 235, column: 4
  private int id_thread_13;//sysj\Orchestrator.sysj line: 236, column: 4
  private BottleTwin b_thread_14;//sysj\Orchestrator.sysj line: 254, column: 4
  private int id_thread_14;//sysj\Orchestrator.sysj line: 255, column: 4
  private int S1323 = 1;
  private int S525 = 1;
  private int S453 = 1;
  private int S454 = 1;
  private int S533 = 1;
  private int S541 = 1;
  private int S619 = 1;
  private int S542 = 1;
  private int S697 = 1;
  private int S620 = 1;
  private int S775 = 1;
  private int S698 = 1;
  private int S853 = 1;
  private int S776 = 1;
  private int S931 = 1;
  private int S854 = 1;
  private int S1009 = 1;
  private int S932 = 1;
  private int S1087 = 1;
  private int S1010 = 1;
  private int S1165 = 1;
  private int S1088 = 1;
  private int S1243 = 1;
  private int S1166 = 1;
  private int S1321 = 1;
  private int S1244 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread1351(int [] tdone, int [] ends){
        switch(S1321){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1244){
          case 0 : 
            S1244=0;
            b_thread_14 = (BottleTwin)(posNineUpdate_1.getpreval() == null ? null : ((BottleTwin)posNineUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 254, column: 4
            id_thread_14 = b_thread_14.ID;//sysj\Orchestrator.sysj line: 255, column: 4
            S1244=1;
            if(b_thread_14 != null){//sysj\Orchestrator.sysj line: 256, column: 8
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 258, column: 6
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(id_thread_14);//sysj\Orchestrator.sysj line: 258, column: 6
              System.out.println("Emitted bottlePos9B");
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 259, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 259, column: 6
              System.out.println("Emitted bottlePos9");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              bottlePos9B.setPresent();//sysj\Orchestrator.sysj line: 262, column: 5
              currsigs.addElement(bottlePos9B);
              bottlePos9B.setValue(-1);//sysj\Orchestrator.sysj line: 262, column: 5
              System.out.println("Emitted bottlePos9B");
              S1244=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            if(posNineUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 257, column: 11
              S1244=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              bottlePos9.setPresent();//sysj\Orchestrator.sysj line: 259, column: 6
              currsigs.addElement(bottlePos9);
              bottlePos9.setValue(b_thread_14);//sysj\Orchestrator.sysj line: 259, column: 6
              System.out.println("Emitted bottlePos9");
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1350(int [] tdone, int [] ends){
        switch(S1243){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1166){
          case 0 : 
            S1166=0;
            S1166=1;
            if(b_thread_13 != null){//sysj\Orchestrator.sysj line: 238, column: 8
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 240, column: 6
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(id_thread_13);//sysj\Orchestrator.sysj line: 240, column: 6
              System.out.println("Emitted bottlePos8B");
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 241, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 241, column: 6
              System.out.println("Emitted bottlePos8");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              bottlePos8B.setPresent();//sysj\Orchestrator.sysj line: 244, column: 5
              currsigs.addElement(bottlePos8B);
              bottlePos8B.setValue(-1);//sysj\Orchestrator.sysj line: 244, column: 5
              System.out.println("Emitted bottlePos8B");
              b_thread_13 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 235, column: 4
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 236, column: 4
              S1166=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(posEightUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 239, column: 11
              b_thread_13 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 235, column: 4
              id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 236, column: 4
              S1166=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              bottlePos8.setPresent();//sysj\Orchestrator.sysj line: 241, column: 6
              currsigs.addElement(bottlePos8);
              bottlePos8.setValue(b_thread_13);//sysj\Orchestrator.sysj line: 241, column: 6
              System.out.println("Emitted bottlePos8");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1349(int [] tdone, int [] ends){
        switch(S1165){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1088){
          case 0 : 
            S1088=0;
            S1088=1;
            if(b_thread_12 != null){//sysj\Orchestrator.sysj line: 220, column: 8
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 222, column: 6
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(id_thread_12);//sysj\Orchestrator.sysj line: 222, column: 6
              System.out.println("Emitted bottlePos7B");
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 223, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 223, column: 6
              System.out.println("Emitted bottlePos7");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              bottlePos7B.setPresent();//sysj\Orchestrator.sysj line: 226, column: 5
              currsigs.addElement(bottlePos7B);
              bottlePos7B.setValue(-1);//sysj\Orchestrator.sysj line: 226, column: 5
              System.out.println("Emitted bottlePos7B");
              b_thread_12 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
              id_thread_12 = b_thread_12.ID;//sysj\Orchestrator.sysj line: 218, column: 4
              S1088=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(posSevenUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 221, column: 11
              b_thread_12 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
              id_thread_12 = b_thread_12.ID;//sysj\Orchestrator.sysj line: 218, column: 4
              S1088=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              bottlePos7.setPresent();//sysj\Orchestrator.sysj line: 223, column: 6
              currsigs.addElement(bottlePos7);
              bottlePos7.setValue(b_thread_12);//sysj\Orchestrator.sysj line: 223, column: 6
              System.out.println("Emitted bottlePos7");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1348(int [] tdone, int [] ends){
        switch(S1087){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1010){
          case 0 : 
            S1010=0;
            S1010=1;
            if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 202, column: 8
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 204, column: 6
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(id_thread_11);//sysj\Orchestrator.sysj line: 204, column: 6
              System.out.println("Emitted bottlePos6B");
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 205, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 205, column: 6
              System.out.println("Emitted bottlePos6");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              bottlePos6B.setPresent();//sysj\Orchestrator.sysj line: 208, column: 5
              currsigs.addElement(bottlePos6B);
              bottlePos6B.setValue(-1);//sysj\Orchestrator.sysj line: 208, column: 5
              System.out.println("Emitted bottlePos6B");
              b_thread_11 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 199, column: 4
              id_thread_11 = b_thread_11.ID;//sysj\Orchestrator.sysj line: 200, column: 4
              S1010=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if(posSixUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 203, column: 11
              b_thread_11 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 199, column: 4
              id_thread_11 = b_thread_11.ID;//sysj\Orchestrator.sysj line: 200, column: 4
              S1010=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              bottlePos6.setPresent();//sysj\Orchestrator.sysj line: 205, column: 6
              currsigs.addElement(bottlePos6);
              bottlePos6.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 205, column: 6
              System.out.println("Emitted bottlePos6");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1347(int [] tdone, int [] ends){
        switch(S1009){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S932){
          case 0 : 
            S932=0;
            S932=1;
            if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 184, column: 8
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 186, column: 6
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(id_thread_10);//sysj\Orchestrator.sysj line: 186, column: 6
              System.out.println("Emitted bottlePos5B");
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 187, column: 6
              System.out.println("Emitted bottlePos5");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              bottlePos5B.setPresent();//sysj\Orchestrator.sysj line: 190, column: 5
              currsigs.addElement(bottlePos5B);
              bottlePos5B.setValue(-1);//sysj\Orchestrator.sysj line: 190, column: 5
              System.out.println("Emitted bottlePos5B");
              b_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 181, column: 4
              id_thread_10 = b_thread_10.ID;//sysj\Orchestrator.sysj line: 182, column: 4
              S932=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if(posFiveUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 185, column: 11
              b_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 181, column: 4
              id_thread_10 = b_thread_10.ID;//sysj\Orchestrator.sysj line: 182, column: 4
              S932=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              bottlePos5.setPresent();//sysj\Orchestrator.sysj line: 187, column: 6
              currsigs.addElement(bottlePos5);
              bottlePos5.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 187, column: 6
              System.out.println("Emitted bottlePos5");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1346(int [] tdone, int [] ends){
        switch(S931){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S854){
          case 0 : 
            S854=0;
            S854=1;
            if(b_thread_9 != null){//sysj\Orchestrator.sysj line: 166, column: 8
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 168, column: 6
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(id_thread_9);//sysj\Orchestrator.sysj line: 168, column: 6
              System.out.println("Emitted bottlePos4B");
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 169, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 169, column: 6
              System.out.println("Emitted bottlePos4");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottlePos4B.setPresent();//sysj\Orchestrator.sysj line: 172, column: 5
              currsigs.addElement(bottlePos4B);
              bottlePos4B.setValue(-1);//sysj\Orchestrator.sysj line: 172, column: 5
              System.out.println("Emitted bottlePos4B");
              b_thread_9 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 163, column: 4
              id_thread_9 = b_thread_9.ID;//sysj\Orchestrator.sysj line: 164, column: 4
              S854=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(posFourUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 167, column: 11
              b_thread_9 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 163, column: 4
              id_thread_9 = b_thread_9.ID;//sysj\Orchestrator.sysj line: 164, column: 4
              S854=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottlePos4.setPresent();//sysj\Orchestrator.sysj line: 169, column: 6
              currsigs.addElement(bottlePos4);
              bottlePos4.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 169, column: 6
              System.out.println("Emitted bottlePos4");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1345(int [] tdone, int [] ends){
        switch(S853){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S776){
          case 0 : 
            S776=0;
            S776=1;
            if(b_thread_8 != null){//sysj\Orchestrator.sysj line: 148, column: 8
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 150, column: 6
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(id_thread_8);//sysj\Orchestrator.sysj line: 150, column: 6
              System.out.println("Emitted bottlePos3B");
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 151, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_8);//sysj\Orchestrator.sysj line: 151, column: 6
              System.out.println("Emitted bottlePos3");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              bottlePos3B.setPresent();//sysj\Orchestrator.sysj line: 154, column: 5
              currsigs.addElement(bottlePos3B);
              bottlePos3B.setValue(-1);//sysj\Orchestrator.sysj line: 154, column: 5
              System.out.println("Emitted bottlePos3B");
              b_thread_8 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 145, column: 4
              id_thread_8 = b_thread_8.ID;//sysj\Orchestrator.sysj line: 146, column: 4
              S776=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(posThreeUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 149, column: 11
              b_thread_8 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 145, column: 4
              id_thread_8 = b_thread_8.ID;//sysj\Orchestrator.sysj line: 146, column: 4
              S776=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              bottlePos3.setPresent();//sysj\Orchestrator.sysj line: 151, column: 6
              currsigs.addElement(bottlePos3);
              bottlePos3.setValue(b_thread_8);//sysj\Orchestrator.sysj line: 151, column: 6
              System.out.println("Emitted bottlePos3");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1344(int [] tdone, int [] ends){
        switch(S775){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S698){
          case 0 : 
            S698=0;
            S698=1;
            if(b_thread_7 != null){//sysj\Orchestrator.sysj line: 129, column: 8
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 131, column: 6
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(id_thread_7);//sysj\Orchestrator.sysj line: 131, column: 6
              System.out.println("Emitted bottlePos2B");
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 132, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_7);//sysj\Orchestrator.sysj line: 132, column: 6
              System.out.println("Emitted bottlePos2");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottlePos2B.setPresent();//sysj\Orchestrator.sysj line: 135, column: 5
              currsigs.addElement(bottlePos2B);
              bottlePos2B.setValue(-1);//sysj\Orchestrator.sysj line: 135, column: 5
              System.out.println("Emitted bottlePos2B");
              b_thread_7 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 126, column: 4
              id_thread_7 = b_thread_7.ID;//sysj\Orchestrator.sysj line: 127, column: 4
              S698=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(posTwoUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 130, column: 11
              b_thread_7 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 126, column: 4
              id_thread_7 = b_thread_7.ID;//sysj\Orchestrator.sysj line: 127, column: 4
              S698=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 132, column: 6
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_7);//sysj\Orchestrator.sysj line: 132, column: 6
              System.out.println("Emitted bottlePos2");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1343(int [] tdone, int [] ends){
        switch(S697){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S620){
          case 0 : 
            S620=0;
            S620=1;
            if(b_thread_6 != null){//sysj\Orchestrator.sysj line: 111, column: 8
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 113, column: 6
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(id_thread_6);//sysj\Orchestrator.sysj line: 113, column: 6
              System.out.println("Emitted bottlePos1B");
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 114, column: 6
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 114, column: 6
              System.out.println("Emitted bottlePos1");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              bottlePos1B.setPresent();//sysj\Orchestrator.sysj line: 117, column: 5
              currsigs.addElement(bottlePos1B);
              bottlePos1B.setValue(-1);//sysj\Orchestrator.sysj line: 117, column: 5
              System.out.println("Emitted bottlePos1B");
              b_thread_6 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 108, column: 4
              id_thread_6 = b_thread_6.ID;//sysj\Orchestrator.sysj line: 109, column: 4
              S620=0;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(posOneUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 112, column: 11
              b_thread_6 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 108, column: 4
              id_thread_6 = b_thread_6.ID;//sysj\Orchestrator.sysj line: 109, column: 4
              S620=0;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 114, column: 6
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 114, column: 6
              System.out.println("Emitted bottlePos1");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1342(int [] tdone, int [] ends){
        switch(S619){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S542){
          case 0 : 
            S542=0;
            S542=1;
            if(b_thread_5 != null){//sysj\Orchestrator.sysj line: 93, column: 8
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 95, column: 6
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(id_thread_5);//sysj\Orchestrator.sysj line: 95, column: 6
              System.out.println("Emitted bottlePos0B");
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 96, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 96, column: 6
              System.out.println("Emitted bottlePos0");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              bottlePos0B.setPresent();//sysj\Orchestrator.sysj line: 99, column: 5
              currsigs.addElement(bottlePos0B);
              bottlePos0B.setValue(-1);//sysj\Orchestrator.sysj line: 99, column: 5
              System.out.println("Emitted bottlePos0B");
              b_thread_5 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 90, column: 4
              id_thread_5 = b_thread_5.ID;//sysj\Orchestrator.sysj line: 91, column: 4
              S542=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(posZeroUpdate_1.getprestatus()){//sysj\Orchestrator.sysj line: 94, column: 11
              b_thread_5 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 90, column: 4
              id_thread_5 = b_thread_5.ID;//sysj\Orchestrator.sysj line: 91, column: 4
              S542=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 96, column: 6
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 96, column: 6
              System.out.println("Emitted bottlePos0");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1341(int [] tdone, int [] ends){
        switch(S541){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(startConveyorThread_1.getprestatus()){//sysj\Orchestrator.sysj line: 66, column: 10
          bZero_thread_4 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 68, column: 4
          bFive_thread_4 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 69, column: 4
          posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 71, column: 4
          currsigs.addElement(posZeroUpdate_1);
          posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 71, column: 4
          System.out.println("Emitted posZeroUpdate_1");
          posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 72, column: 4
          currsigs.addElement(posFiveUpdate_1);
          posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 72, column: 4
          System.out.println("Emitted posFiveUpdate_1");
          posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 73, column: 4
          currsigs.addElement(posOneUpdate_1);
          posOneUpdate_1.setValue(bZero_thread_4);//sysj\Orchestrator.sysj line: 73, column: 4
          System.out.println("Emitted posOneUpdate_1");
          posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 4
          currsigs.addElement(posSevenUpdate_1);
          posSevenUpdate_1.setValue(bFive_thread_4);//sysj\Orchestrator.sysj line: 74, column: 4
          System.out.println("Emitted posSevenUpdate_1");
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
      
    }
  }

  public void thread1340(int [] tdone, int [] ends){
        switch(S533){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(startRobotLoader_1.getprestatus()){//sysj\Orchestrator.sysj line: 47, column: 10
          bZero_thread_3 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 49, column: 4
          bFive_thread_3 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 50, column: 4
          posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 4
          currsigs.addElement(posZeroUpdate_1);
          posZeroUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 52, column: 4
          System.out.println("Emitted posZeroUpdate_1");
          posFiveUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 4
          currsigs.addElement(posFiveUpdate_1);
          posFiveUpdate_1.setValue(null);//sysj\Orchestrator.sysj line: 53, column: 4
          System.out.println("Emitted posFiveUpdate_1");
          posOneUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 54, column: 4
          currsigs.addElement(posOneUpdate_1);
          posOneUpdate_1.setValue(bZero_thread_3);//sysj\Orchestrator.sysj line: 54, column: 4
          System.out.println("Emitted posOneUpdate_1");
          posSevenUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 55, column: 4
          currsigs.addElement(posSevenUpdate_1);
          posSevenUpdate_1.setValue(bFive_thread_3);//sysj\Orchestrator.sysj line: 55, column: 4
          System.out.println("Emitted posSevenUpdate_1");
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
  }

  public void thread1339(int [] tdone, int [] ends){
        switch(S525){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S453){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 18, column: 10
              System.err.println("Orchestrator newBottleTwin ");//sysj\Orchestrator.sysj line: 19, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 20, column: 4
              S453=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 22, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 23, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 24, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 25, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                posZeroUpdate_1.setPresent();//sysj\Orchestrator.sysj line: 31, column: 5
                currsigs.addElement(posZeroUpdate_1);
                posZeroUpdate_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 31, column: 5
                System.out.println("Emitted posZeroUpdate_1");
                S454=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S453=0;
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
            switch(S454){
              case 0 : 
                S454=0;
                S454=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 1 : 
                S454=1;
                S454=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(!bottlePos0.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S454=3;
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
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 35, column: 11
                  S454=4;
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
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 37, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 38, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  S453=0;
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

  public void thread1337(int [] tdone, int [] ends){
        S1321=1;
    S1244=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread1336(int [] tdone, int [] ends){
        S1243=1;
    b_thread_13 = (BottleTwin)(posEightUpdate_1.getpreval() == null ? null : ((BottleTwin)posEightUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 235, column: 4
    id_thread_13 = b_thread_13.ID;//sysj\Orchestrator.sysj line: 236, column: 4
    S1166=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread1335(int [] tdone, int [] ends){
        S1165=1;
    b_thread_12 = (BottleTwin)(posSevenUpdate_1.getpreval() == null ? null : ((BottleTwin)posSevenUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 217, column: 4
    id_thread_12 = b_thread_12.ID;//sysj\Orchestrator.sysj line: 218, column: 4
    S1088=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1334(int [] tdone, int [] ends){
        S1087=1;
    b_thread_11 = (BottleTwin)(posSixUpdate_1.getpreval() == null ? null : ((BottleTwin)posSixUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 199, column: 4
    id_thread_11 = b_thread_11.ID;//sysj\Orchestrator.sysj line: 200, column: 4
    S1010=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1333(int [] tdone, int [] ends){
        S1009=1;
    b_thread_10 = (BottleTwin)(posFiveUpdate_1.getpreval() == null ? null : ((BottleTwin)posFiveUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 181, column: 4
    id_thread_10 = b_thread_10.ID;//sysj\Orchestrator.sysj line: 182, column: 4
    S932=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1332(int [] tdone, int [] ends){
        S931=1;
    b_thread_9 = (BottleTwin)(posFourUpdate_1.getpreval() == null ? null : ((BottleTwin)posFourUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 163, column: 4
    id_thread_9 = b_thread_9.ID;//sysj\Orchestrator.sysj line: 164, column: 4
    S854=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1331(int [] tdone, int [] ends){
        S853=1;
    b_thread_8 = (BottleTwin)(posThreeUpdate_1.getpreval() == null ? null : ((BottleTwin)posThreeUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 145, column: 4
    id_thread_8 = b_thread_8.ID;//sysj\Orchestrator.sysj line: 146, column: 4
    S776=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1330(int [] tdone, int [] ends){
        S775=1;
    b_thread_7 = (BottleTwin)(posTwoUpdate_1.getpreval() == null ? null : ((BottleTwin)posTwoUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 126, column: 4
    id_thread_7 = b_thread_7.ID;//sysj\Orchestrator.sysj line: 127, column: 4
    S698=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1329(int [] tdone, int [] ends){
        S697=1;
    b_thread_6 = (BottleTwin)(posOneUpdate_1.getpreval() == null ? null : ((BottleTwin)posOneUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 108, column: 4
    id_thread_6 = b_thread_6.ID;//sysj\Orchestrator.sysj line: 109, column: 4
    S620=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1328(int [] tdone, int [] ends){
        S619=1;
    b_thread_5 = (BottleTwin)(posZeroUpdate_1.getpreval() == null ? null : ((BottleTwin)posZeroUpdate_1.getpreval()));//sysj\Orchestrator.sysj line: 90, column: 4
    id_thread_5 = b_thread_5.ID;//sysj\Orchestrator.sysj line: 91, column: 4
    S542=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1327(int [] tdone, int [] ends){
        S541=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1326(int [] tdone, int [] ends){
        S533=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1325(int [] tdone, int [] ends){
        S525=1;
    S453=0;
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
      switch(S1323){
        case 0 : 
          S1323=0;
          break RUN;
        
        case 1 : 
          S1323=2;
          S1323=2;
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
          startRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          thread1325(tdone,ends);
          thread1326(tdone,ends);
          thread1327(tdone,ends);
          thread1328(tdone,ends);
          thread1329(tdone,ends);
          thread1330(tdone,ends);
          thread1331(tdone,ends);
          thread1332(tdone,ends);
          thread1333(tdone,ends);
          thread1334(tdone,ends);
          thread1335(tdone,ends);
          thread1336(tdone,ends);
          thread1337(tdone,ends);
          int biggest1338 = 0;
          if(ends[2]>=biggest1338){
            biggest1338=ends[2];
          }
          if(ends[3]>=biggest1338){
            biggest1338=ends[3];
          }
          if(ends[4]>=biggest1338){
            biggest1338=ends[4];
          }
          if(ends[5]>=biggest1338){
            biggest1338=ends[5];
          }
          if(ends[6]>=biggest1338){
            biggest1338=ends[6];
          }
          if(ends[7]>=biggest1338){
            biggest1338=ends[7];
          }
          if(ends[8]>=biggest1338){
            biggest1338=ends[8];
          }
          if(ends[9]>=biggest1338){
            biggest1338=ends[9];
          }
          if(ends[10]>=biggest1338){
            biggest1338=ends[10];
          }
          if(ends[11]>=biggest1338){
            biggest1338=ends[11];
          }
          if(ends[12]>=biggest1338){
            biggest1338=ends[12];
          }
          if(ends[13]>=biggest1338){
            biggest1338=ends[13];
          }
          if(ends[14]>=biggest1338){
            biggest1338=ends[14];
          }
          if(biggest1338 == 1){
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
          startRobotLoader_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startConveyorThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startRotThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          startCapLoaderThread_1.setClear();//sysj\Orchestrator.sysj line: 15, column: 2
          thread1339(tdone,ends);
          thread1340(tdone,ends);
          thread1341(tdone,ends);
          thread1342(tdone,ends);
          thread1343(tdone,ends);
          thread1344(tdone,ends);
          thread1345(tdone,ends);
          thread1346(tdone,ends);
          thread1347(tdone,ends);
          thread1348(tdone,ends);
          thread1349(tdone,ends);
          thread1350(tdone,ends);
          thread1351(tdone,ends);
          int biggest1352 = 0;
          if(ends[2]>=biggest1352){
            biggest1352=ends[2];
          }
          if(ends[3]>=biggest1352){
            biggest1352=ends[3];
          }
          if(ends[4]>=biggest1352){
            biggest1352=ends[4];
          }
          if(ends[5]>=biggest1352){
            biggest1352=ends[5];
          }
          if(ends[6]>=biggest1352){
            biggest1352=ends[6];
          }
          if(ends[7]>=biggest1352){
            biggest1352=ends[7];
          }
          if(ends[8]>=biggest1352){
            biggest1352=ends[8];
          }
          if(ends[9]>=biggest1352){
            biggest1352=ends[9];
          }
          if(ends[10]>=biggest1352){
            biggest1352=ends[10];
          }
          if(ends[11]>=biggest1352){
            biggest1352=ends[11];
          }
          if(ends[12]>=biggest1352){
            biggest1352=ends[12];
          }
          if(ends[13]>=biggest1352){
            biggest1352=ends[13];
          }
          if(ends[14]>=biggest1352){
            biggest1352=ends[14];
          }
          if(biggest1352 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1352 == 0){
            S1323=0;
            active[1]=0;
            ends[1]=0;
            S1323=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    startRobotLoader_1 = new Signal();
    startConveyorThread_1 = new Signal();
    startRotThread_1 = new Signal();
    startCapLoaderThread_1 = new Signal();
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
      recieveTwin.setpreclear();
      startConveyor.setpreclear();
      startRotTable.setpreclear();
      startFilling.setpreclear();
      startCapLoading.setpreclear();
      capperBottleOut.setpreclear();
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
      startRobotLoader_1.setpreclear();
      startConveyorThread_1.setpreclear();
      startRotThread_1.setpreclear();
      startCapLoaderThread_1.setpreclear();
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
      capperBottleOut.sethook();
      capperBottleOut.setClear();
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
      startRobotLoader_1.setClear();
      startConveyorThread_1.setClear();
      startRotThread_1.setClear();
      startCapLoaderThread_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        conveyorMoved.gethook();
        rotTableTurned.gethook();
        filled.gethook();
        capLoaded.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
