import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class rotPlant extends ClockDomain{
  public rotPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  public Signal rotContent = new Signal("rotContent", Signal.OUTPUT);
  private Signal posOne_11;
  private Signal posFive_11;
  private Signal turn_11;
  private int[] packedArray_thread_12;//sysj\plant.sysj line: 192, column: 3
  private int pos_thread_12;//sysj\plant.sysj line: 193, column: 3
  private int pos1_thread_12;//sysj\plant.sysj line: 205, column: 5
  private int pos5_thread_12;//sysj\plant.sysj line: 206, column: 5
  private int[] newPackedArray_thread_12;//sysj\plant.sysj line: 210, column: 5
  private int S1634 = 1;
  private int S1627 = 1;
  private int S1564 = 1;
  private int S1632 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread2106(int [] tdone, int [] ends){
        switch(S1632){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_11.getpreval() == null ? 0 : ((Integer)posOne_11.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 226, column: 29
        }
        if((Integer)(posFive_11.getpreval() == null ? 0 : ((Integer)posFive_11.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 229, column: 30
        }
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
        break;
      
    }
  }

  public void thread2105(int [] tdone, int [] ends){
        switch(S1627){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 202, column: 10
          S1564=0;
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          switch(S1564){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 203, column: 11
                S1564=1;
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
              if(enable.getprestatus()){//sysj\plant.sysj line: 204, column: 11
                pos1_thread_12 = packedArray_thread_12[0];//sysj\plant.sysj line: 205, column: 5
                pos5_thread_12 = packedArray_thread_12[4];//sysj\plant.sysj line: 206, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 207, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_12);//sysj\plant.sysj line: 207, column: 5
                posOne_11.setPresent();//sysj\plant.sysj line: 208, column: 5
                currsigs.addElement(posOne_11);
                posOne_11.setValue(pos1_thread_12);//sysj\plant.sysj line: 208, column: 5
                posFive_11.setPresent();//sysj\plant.sysj line: 209, column: 5
                currsigs.addElement(posFive_11);
                posFive_11.setValue(pos5_thread_12);//sysj\plant.sysj line: 209, column: 5
                newPackedArray_thread_12 = new int[6];//sysj\plant.sysj line: 210, column: 5
                newPackedArray_thread_12[0] = packedArray_thread_12[5];//sysj\plant.sysj line: 211, column: 5
                for(int i_thread_12 = 1; i_thread_12 < 6; i_thread_12 = i_thread_12 + 1) {//sysj\plant.sysj line: 213, column: 31
                  newPackedArray_thread_12[i_thread_12] = packedArray_thread_12[i_thread_12 - 1];//sysj\plant.sysj line: 214, column: 6
                }
                packedArray_thread_12 = newPackedArray_thread_12;//sysj\plant.sysj line: 216, column: 5
                S1564=2;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 217, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
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
            
            case 2 : 
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 217, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread2103(int [] tdone, int [] ends){
        S1632=1;
    if((Integer)(posOne_11.getpreval() == null ? 0 : ((Integer)posOne_11.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 226, column: 29
    }
    if((Integer)(posFive_11.getpreval() == null ? 0 : ((Integer)posFive_11.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 229, column: 30
    }
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2102(int [] tdone, int [] ends){
        S1627=1;
    packedArray_thread_12 = new int[6];//sysj\plant.sysj line: 192, column: 3
    pos_thread_12 = 0;//sysj\plant.sysj line: 193, column: 3
    for(int i_thread_12 = 0; i_thread_12 < 6; i_thread_12 = i_thread_12 + 1) {//sysj\plant.sysj line: 194, column: 29
      packedArray_thread_12[i_thread_12] = 0;//sysj\plant.sysj line: 195, column: 7
    }
    packedArray_thread_12[0] = 5;//sysj\plant.sysj line: 198, column: 6
    packedArray_thread_12[3] = 1;//sysj\plant.sysj line: 199, column: 6
    S1564=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1634){
        case 0 : 
          S1634=0;
          break RUN;
        
        case 1 : 
          S1634=2;
          S1634=2;
          posOne_11.setClear();//sysj\plant.sysj line: 190, column: 2
          posFive_11.setClear();//sysj\plant.sysj line: 190, column: 2
          turn_11.setClear();//sysj\plant.sysj line: 190, column: 2
          thread2102(tdone,ends);
          thread2103(tdone,ends);
          int biggest2104 = 0;
          if(ends[12]>=biggest2104){
            biggest2104=ends[12];
          }
          if(ends[13]>=biggest2104){
            biggest2104=ends[13];
          }
          if(biggest2104 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_11.setClear();//sysj\plant.sysj line: 190, column: 2
          posFive_11.setClear();//sysj\plant.sysj line: 190, column: 2
          turn_11.setClear();//sysj\plant.sysj line: 190, column: 2
          thread2105(tdone,ends);
          thread2106(tdone,ends);
          int biggest2107 = 0;
          if(ends[12]>=biggest2107){
            biggest2107=ends[12];
          }
          if(ends[13]>=biggest2107){
            biggest2107=ends[13];
          }
          if(biggest2107 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2107 == 0){
            S1634=0;
            active[11]=0;
            ends[11]=0;
            S1634=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_11 = new Signal();
    posFive_11 = new Signal();
    turn_11 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[11] != 0){
      int index = 11;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[11]!=0 || suspended[11]!=0 || active[11]!=1);
      else{
        if(!df){
          rotaryTableTrigger.gethook();
          enable.gethook();
          bottleIn.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      enable.setpreclear();
      bottleIn.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurn.setpreclear();
      rotContent.setpreclear();
      posOne_11.setpreclear();
      posFive_11.setpreclear();
      turn_11.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleIn.getStatus() ? bottleIn.setprepresent() : bottleIn.setpreclear();
      bottleIn.setpreval(bottleIn.getValue());
      bottleIn.setClear();
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
      posOne_11.setClear();
      posFive_11.setClear();
      turn_11.setClear();
      if(paused[11]!=0 || suspended[11]!=0 || active[11]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[11] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
