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
  private Signal posOne_13;
  private Signal posFive_13;
  private Signal turn_13;
  private int[] packedArray_thread_14;//sysj\plant.sysj line: 218, column: 3
  private int pos_thread_14;//sysj\plant.sysj line: 219, column: 3
  private int pos1_thread_14;//sysj\plant.sysj line: 231, column: 5
  private int pos5_thread_14;//sysj\plant.sysj line: 232, column: 5
  private int[] newPackedArray_thread_14;//sysj\plant.sysj line: 236, column: 5
  private int S1964 = 1;
  private int S1957 = 1;
  private int S1894 = 1;
  private int S1962 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread2440(int [] tdone, int [] ends){
        switch(S1962){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_13.getpreval() == null ? 0 : ((Integer)posOne_13.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 252, column: 29
        }
        if((Integer)(posFive_13.getpreval() == null ? 0 : ((Integer)posFive_13.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 255, column: 30
        }
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread2439(int [] tdone, int [] ends){
        switch(S1957){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 228, column: 10
          S1894=0;
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        else {
          switch(S1894){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 229, column: 11
                S1894=1;
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
              if(enable.getprestatus()){//sysj\plant.sysj line: 230, column: 11
                pos1_thread_14 = packedArray_thread_14[0];//sysj\plant.sysj line: 231, column: 5
                pos5_thread_14 = packedArray_thread_14[4];//sysj\plant.sysj line: 232, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 233, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_14);//sysj\plant.sysj line: 233, column: 5
                posOne_13.setPresent();//sysj\plant.sysj line: 234, column: 5
                currsigs.addElement(posOne_13);
                posOne_13.setValue(pos1_thread_14);//sysj\plant.sysj line: 234, column: 5
                posFive_13.setPresent();//sysj\plant.sysj line: 235, column: 5
                currsigs.addElement(posFive_13);
                posFive_13.setValue(pos5_thread_14);//sysj\plant.sysj line: 235, column: 5
                newPackedArray_thread_14 = new int[6];//sysj\plant.sysj line: 236, column: 5
                newPackedArray_thread_14[0] = packedArray_thread_14[5];//sysj\plant.sysj line: 237, column: 5
                for(int i_thread_14 = 1; i_thread_14 < 6; i_thread_14 = i_thread_14 + 1) {//sysj\plant.sysj line: 239, column: 31
                  newPackedArray_thread_14[i_thread_14] = packedArray_thread_14[i_thread_14 - 1];//sysj\plant.sysj line: 240, column: 6
                }
                packedArray_thread_14 = newPackedArray_thread_14;//sysj\plant.sysj line: 242, column: 5
                S1894=2;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 243, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
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
            
            case 2 : 
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 243, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread2437(int [] tdone, int [] ends){
        S1962=1;
    if((Integer)(posOne_13.getpreval() == null ? 0 : ((Integer)posOne_13.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 252, column: 29
    }
    if((Integer)(posFive_13.getpreval() == null ? 0 : ((Integer)posFive_13.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 255, column: 30
    }
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2436(int [] tdone, int [] ends){
        S1957=1;
    packedArray_thread_14 = new int[6];//sysj\plant.sysj line: 218, column: 3
    pos_thread_14 = 0;//sysj\plant.sysj line: 219, column: 3
    for(int i_thread_14 = 0; i_thread_14 < 6; i_thread_14 = i_thread_14 + 1) {//sysj\plant.sysj line: 220, column: 29
      packedArray_thread_14[i_thread_14] = 0;//sysj\plant.sysj line: 221, column: 7
    }
    packedArray_thread_14[0] = 5;//sysj\plant.sysj line: 224, column: 6
    packedArray_thread_14[3] = 1;//sysj\plant.sysj line: 225, column: 6
    S1894=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1964){
        case 0 : 
          S1964=0;
          break RUN;
        
        case 1 : 
          S1964=2;
          S1964=2;
          posOne_13.setClear();//sysj\plant.sysj line: 216, column: 2
          posFive_13.setClear();//sysj\plant.sysj line: 216, column: 2
          turn_13.setClear();//sysj\plant.sysj line: 216, column: 2
          thread2436(tdone,ends);
          thread2437(tdone,ends);
          int biggest2438 = 0;
          if(ends[14]>=biggest2438){
            biggest2438=ends[14];
          }
          if(ends[15]>=biggest2438){
            biggest2438=ends[15];
          }
          if(biggest2438 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_13.setClear();//sysj\plant.sysj line: 216, column: 2
          posFive_13.setClear();//sysj\plant.sysj line: 216, column: 2
          turn_13.setClear();//sysj\plant.sysj line: 216, column: 2
          thread2439(tdone,ends);
          thread2440(tdone,ends);
          int biggest2441 = 0;
          if(ends[14]>=biggest2441){
            biggest2441=ends[14];
          }
          if(ends[15]>=biggest2441){
            biggest2441=ends[15];
          }
          if(biggest2441 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2441 == 0){
            S1964=0;
            active[13]=0;
            ends[13]=0;
            S1964=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_13 = new Signal();
    posFive_13 = new Signal();
    turn_13 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
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
      posOne_13.setpreclear();
      posFive_13.setpreclear();
      turn_13.setpreclear();
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
      posOne_13.setClear();
      posFive_13.setClear();
      turn_13.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
