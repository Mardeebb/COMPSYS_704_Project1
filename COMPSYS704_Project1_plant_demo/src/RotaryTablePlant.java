import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1

public class RotaryTablePlant extends ClockDomain{
  public RotaryTablePlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  public Signal rotContent = new Signal("rotContent", Signal.OUTPUT);
  public output_Channel atPos4_o = new output_Channel();
  private Signal posOne_10;
  private Signal posFive_10;
  private Signal turn_10;
  private int[] packedArray_thread_11;//sysj\plant.sysj line: 182, column: 3
  private int pos_thread_11;//sysj\plant.sysj line: 183, column: 3
  private int pos1_thread_11;//sysj\plant.sysj line: 195, column: 4
  private int pos5_thread_11;//sysj\plant.sysj line: 196, column: 4
  private int pos4_thread_11;//sysj\plant.sysj line: 197, column: 4
  private int[] newPackedArray_thread_11;//sysj\plant.sysj line: 202, column: 4
  private int S600 = 1;
  private int S581 = 1;
  private int S558 = 1;
  private int S598 = 1;
  
  private int[] ends = new int[13];
  private int[] tdone = new int[13];
  
  public void thread624(int [] tdone, int [] ends){
        switch(S598){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_10.getpreval() == null ? 0 : ((Integer)posOne_10.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 219, column: 7
          capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 220, column: 5
          currsigs.addElement(capOnBottleAtPos1);
          if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 222, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 223, column: 5
            currsigs.addElement(bottleAtPos5);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
          }
          else {
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
          }
        }
        else {
          if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 222, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 223, column: 5
            currsigs.addElement(bottleAtPos5);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
          }
          else {
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
          }
        }
        break;
      
    }
  }

  public void thread623(int [] tdone, int [] ends){
        switch(S581){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S558){
          case 0 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 193, column: 10
              pos1_thread_11 = packedArray_thread_11[0];//sysj\plant.sysj line: 195, column: 4
              pos5_thread_11 = packedArray_thread_11[4];//sysj\plant.sysj line: 196, column: 4
              pos4_thread_11 = packedArray_thread_11[3];//sysj\plant.sysj line: 197, column: 4
              rotTurn.setPresent();//sysj\plant.sysj line: 199, column: 4
              currsigs.addElement(rotTurn);
              rotTurn.setValue(packedArray_thread_11);//sysj\plant.sysj line: 199, column: 4
              posOne_10.setPresent();//sysj\plant.sysj line: 200, column: 4
              currsigs.addElement(posOne_10);
              posOne_10.setValue(pos1_thread_11);//sysj\plant.sysj line: 200, column: 4
              posFive_10.setPresent();//sysj\plant.sysj line: 201, column: 4
              currsigs.addElement(posFive_10);
              posFive_10.setValue(pos5_thread_11);//sysj\plant.sysj line: 201, column: 4
              newPackedArray_thread_11 = new int[6];//sysj\plant.sysj line: 202, column: 4
              newPackedArray_thread_11[0] = packedArray_thread_11[5];//sysj\plant.sysj line: 203, column: 4
              for(int i_thread_11 = 1; i_thread_11 < 6; i_thread_11 = i_thread_11 + 1) {//sysj\plant.sysj line: 205, column: 30
                newPackedArray_thread_11[i_thread_11] = packedArray_thread_11[i_thread_11 - 1];//sysj\plant.sysj line: 206, column: 5
              }
              packedArray_thread_11 = newPackedArray_thread_11;//sysj\plant.sysj line: 208, column: 4
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 209, column: 4
              currsigs.addElement(tableAlignedWithSensorC);
              System.out.println("table aligned");//sysj\plant.sysj line: 210, column: 4
              S558=1;
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
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 10
              S558=0;
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

  public void thread621(int [] tdone, int [] ends){
        S598=1;
    if((Integer)(posOne_10.getpreval() == null ? 0 : ((Integer)posOne_10.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 219, column: 7
      capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 220, column: 5
      currsigs.addElement(capOnBottleAtPos1);
      if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 222, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 223, column: 5
        currsigs.addElement(bottleAtPos5);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
      }
      else {
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
      }
    }
    else {
      if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 222, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 223, column: 5
        currsigs.addElement(bottleAtPos5);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
      }
      else {
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
      }
    }
  }

  public void thread620(int [] tdone, int [] ends){
        S581=1;
    packedArray_thread_11 = new int[6];//sysj\plant.sysj line: 182, column: 3
    pos_thread_11 = 0;//sysj\plant.sysj line: 183, column: 3
    for(int i_thread_11 = 0; i_thread_11 < 6; i_thread_11 = i_thread_11 + 1) {//sysj\plant.sysj line: 185, column: 29
      packedArray_thread_11[i_thread_11] = 0;//sysj\plant.sysj line: 186, column: 7
    }
    packedArray_thread_11[0] = 5;//sysj\plant.sysj line: 189, column: 6
    packedArray_thread_11[3] = 1;//sysj\plant.sysj line: 190, column: 6
    S558=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S600){
        case 0 : 
          S600=0;
          break RUN;
        
        case 1 : 
          S600=2;
          S600=2;
          posOne_10.setClear();//sysj\plant.sysj line: 180, column: 2
          posFive_10.setClear();//sysj\plant.sysj line: 180, column: 2
          turn_10.setClear();//sysj\plant.sysj line: 180, column: 2
          thread620(tdone,ends);
          thread621(tdone,ends);
          int biggest622 = 0;
          if(ends[11]>=biggest622){
            biggest622=ends[11];
          }
          if(ends[12]>=biggest622){
            biggest622=ends[12];
          }
          if(biggest622 == 1){
            active[10]=1;
            ends[10]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_10.setClear();//sysj\plant.sysj line: 180, column: 2
          posFive_10.setClear();//sysj\plant.sysj line: 180, column: 2
          turn_10.setClear();//sysj\plant.sysj line: 180, column: 2
          thread623(tdone,ends);
          thread624(tdone,ends);
          int biggest625 = 0;
          if(ends[11]>=biggest625){
            biggest625=ends[11];
          }
          if(ends[12]>=biggest625){
            biggest625=ends[12];
          }
          if(biggest625 == 1){
            active[10]=1;
            ends[10]=1;
            break RUN;
          }
          //FINXME code
          if(biggest625 == 0){
            S600=0;
            active[10]=0;
            ends[10]=0;
            S600=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_10 = new Signal();
    posFive_10 = new Signal();
    turn_10 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[10] != 0){
      int index = 10;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[10]!=0 || suspended[10]!=0 || active[10]!=1);
      else{
        if(!df){
          atPos4_o.gethook();
          rotaryTableTrigger.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurn.setpreclear();
      rotContent.setpreclear();
      posOne_10.setpreclear();
      posFive_10.setpreclear();
      turn_10.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      tableAlignedWithSensorC.sethook();
      tableAlignedWithSensorC.setClear();
      rotTurn.sethook();
      rotTurn.setClear();
      rotContent.sethook();
      rotContent.setClear();
      posOne_10.setClear();
      posFive_10.setClear();
      turn_10.setClear();
      atPos4_o.sethook();
      if(paused[10]!=0 || suspended[10]!=0 || active[10]!=1);
      else{
        atPos4_o.gethook();
        rotaryTableTrigger.gethook();
      }
      runFinisher();
      if(active[10] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
