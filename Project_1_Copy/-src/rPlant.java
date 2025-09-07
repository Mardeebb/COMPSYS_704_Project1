import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1

public class rPlant extends ClockDomain{
  public rPlant(String name){super(name);}
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
  private Signal posOne_2;
  private Signal posFive_2;
  private Signal turn_2;
  private int[] packedArray_thread_3;//sysj\plant.sysj line: 125, column: 3
  private int pos_thread_3;//sysj\plant.sysj line: 126, column: 3
  private int pos1_thread_3;//sysj\plant.sysj line: 137, column: 4
  private int pos5_thread_3;//sysj\plant.sysj line: 138, column: 4
  private int[] newPackedArray_thread_3;//sysj\plant.sysj line: 142, column: 4
  private int S126 = 1;
  private int S107 = 1;
  private int S84 = 1;
  private int S124 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread132(int [] tdone, int [] ends){
        switch(S124){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_2.getpreval() == null ? 0 : ((Integer)posOne_2.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 158, column: 7
          capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 159, column: 5
          currsigs.addElement(capOnBottleAtPos1);
          if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 161, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 5
            currsigs.addElement(bottleAtPos5);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 161, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 5
            currsigs.addElement(bottleAtPos5);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        break;
      
    }
  }

  public void thread131(int [] tdone, int [] ends){
        switch(S107){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S84){
          case 0 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 135, column: 10
              pos1_thread_3 = packedArray_thread_3[0];//sysj\plant.sysj line: 137, column: 4
              pos5_thread_3 = packedArray_thread_3[4];//sysj\plant.sysj line: 138, column: 4
              rotTurn.setPresent();//sysj\plant.sysj line: 139, column: 4
              currsigs.addElement(rotTurn);
              rotTurn.setValue(packedArray_thread_3);//sysj\plant.sysj line: 139, column: 4
              posOne_2.setPresent();//sysj\plant.sysj line: 140, column: 4
              currsigs.addElement(posOne_2);
              posOne_2.setValue(pos1_thread_3);//sysj\plant.sysj line: 140, column: 4
              posFive_2.setPresent();//sysj\plant.sysj line: 141, column: 4
              currsigs.addElement(posFive_2);
              posFive_2.setValue(pos5_thread_3);//sysj\plant.sysj line: 141, column: 4
              newPackedArray_thread_3 = new int[6];//sysj\plant.sysj line: 142, column: 4
              newPackedArray_thread_3[0] = packedArray_thread_3[5];//sysj\plant.sysj line: 143, column: 4
              for(int i_thread_3 = 1; i_thread_3 < 6; i_thread_3 = i_thread_3 + 1) {//sysj\plant.sysj line: 145, column: 30
                newPackedArray_thread_3[i_thread_3] = packedArray_thread_3[i_thread_3 - 1];//sysj\plant.sysj line: 146, column: 5
              }
              packedArray_thread_3 = newPackedArray_thread_3;//sysj\plant.sysj line: 148, column: 4
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 149, column: 4
              currsigs.addElement(tableAlignedWithSensorC);
              S84=1;
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
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 150, column: 10
              S84=0;
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

  public void thread129(int [] tdone, int [] ends){
        S124=1;
    if((Integer)(posOne_2.getpreval() == null ? 0 : ((Integer)posOne_2.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 158, column: 7
      capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 159, column: 5
      currsigs.addElement(capOnBottleAtPos1);
      if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 161, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 5
        currsigs.addElement(bottleAtPos5);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 161, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 5
        currsigs.addElement(bottleAtPos5);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
  }

  public void thread128(int [] tdone, int [] ends){
        S107=1;
    packedArray_thread_3 = new int[6];//sysj\plant.sysj line: 125, column: 3
    pos_thread_3 = 0;//sysj\plant.sysj line: 126, column: 3
    for(int i_thread_3 = 0; i_thread_3 < 6; i_thread_3 = i_thread_3 + 1) {//sysj\plant.sysj line: 127, column: 29
      packedArray_thread_3[i_thread_3] = 0;//sysj\plant.sysj line: 128, column: 7
    }
    packedArray_thread_3[0] = 5;//sysj\plant.sysj line: 131, column: 6
    packedArray_thread_3[3] = 1;//sysj\plant.sysj line: 132, column: 6
    S84=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S126){
        case 0 : 
          S126=0;
          break RUN;
        
        case 1 : 
          S126=2;
          S126=2;
          posOne_2.setClear();//sysj\plant.sysj line: 123, column: 2
          posFive_2.setClear();//sysj\plant.sysj line: 123, column: 2
          turn_2.setClear();//sysj\plant.sysj line: 123, column: 2
          thread128(tdone,ends);
          thread129(tdone,ends);
          int biggest130 = 0;
          if(ends[3]>=biggest130){
            biggest130=ends[3];
          }
          if(ends[4]>=biggest130){
            biggest130=ends[4];
          }
          if(biggest130 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_2.setClear();//sysj\plant.sysj line: 123, column: 2
          posFive_2.setClear();//sysj\plant.sysj line: 123, column: 2
          turn_2.setClear();//sysj\plant.sysj line: 123, column: 2
          thread131(tdone,ends);
          thread132(tdone,ends);
          int biggest133 = 0;
          if(ends[3]>=biggest133){
            biggest133=ends[3];
          }
          if(ends[4]>=biggest133){
            biggest133=ends[4];
          }
          if(biggest133 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest133 == 0){
            S126=0;
            active[2]=0;
            ends[2]=0;
            S126=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_2 = new Signal();
    posFive_2 = new Signal();
    turn_2 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        if(!df){
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
      posOne_2.setpreclear();
      posFive_2.setpreclear();
      turn_2.setpreclear();
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
      posOne_2.setClear();
      posFive_2.setClear();
      turn_2.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        rotaryTableTrigger.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
