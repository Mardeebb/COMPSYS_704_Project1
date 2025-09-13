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
  private Signal posOne_10;
  private Signal posFive_10;
  private Signal turn_10;
  private int[] packedArray_thread_11;//sysj\plant.sysj line: 184, column: 3
  private int pos_thread_11;//sysj\plant.sysj line: 185, column: 3
  private int pos1_thread_11;//sysj\plant.sysj line: 197, column: 5
  private int pos5_thread_11;//sysj\plant.sysj line: 198, column: 5
  private int[] newPackedArray_thread_11;//sysj\plant.sysj line: 202, column: 5
  private int S1681 = 1;
  private int S1674 = 1;
  private int S1611 = 1;
  private int S1679 = 1;
  
  private int[] ends = new int[30];
  private int[] tdone = new int[30];
  
  public void thread2385(int [] tdone, int [] ends){
        switch(S1679){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_10.getpreval() == null ? 0 : ((Integer)posOne_10.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 218, column: 29
        }
        if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 221, column: 30
        }
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread2384(int [] tdone, int [] ends){
        switch(S1674){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 194, column: 10
          S1611=0;
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          switch(S1611){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 195, column: 11
                S1611=1;
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
              if(enable.getprestatus()){//sysj\plant.sysj line: 196, column: 11
                pos1_thread_11 = packedArray_thread_11[0];//sysj\plant.sysj line: 197, column: 5
                pos5_thread_11 = packedArray_thread_11[4];//sysj\plant.sysj line: 198, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 199, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_11);//sysj\plant.sysj line: 199, column: 5
                posOne_10.setPresent();//sysj\plant.sysj line: 200, column: 5
                currsigs.addElement(posOne_10);
                posOne_10.setValue(pos1_thread_11);//sysj\plant.sysj line: 200, column: 5
                posFive_10.setPresent();//sysj\plant.sysj line: 201, column: 5
                currsigs.addElement(posFive_10);
                posFive_10.setValue(pos5_thread_11);//sysj\plant.sysj line: 201, column: 5
                newPackedArray_thread_11 = new int[6];//sysj\plant.sysj line: 202, column: 5
                newPackedArray_thread_11[0] = packedArray_thread_11[5];//sysj\plant.sysj line: 203, column: 5
                for(int i_thread_11 = 1; i_thread_11 < 6; i_thread_11 = i_thread_11 + 1) {//sysj\plant.sysj line: 205, column: 31
                  newPackedArray_thread_11[i_thread_11] = packedArray_thread_11[i_thread_11 - 1];//sysj\plant.sysj line: 206, column: 6
                }
                packedArray_thread_11 = newPackedArray_thread_11;//sysj\plant.sysj line: 208, column: 5
                S1611=2;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 209, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
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
            
            case 2 : 
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 209, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread2382(int [] tdone, int [] ends){
        S1679=1;
    if((Integer)(posOne_10.getpreval() == null ? 0 : ((Integer)posOne_10.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 218, column: 29
    }
    if((Integer)(posFive_10.getpreval() == null ? 0 : ((Integer)posFive_10.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 221, column: 30
    }
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2381(int [] tdone, int [] ends){
        S1674=1;
    packedArray_thread_11 = new int[6];//sysj\plant.sysj line: 184, column: 3
    pos_thread_11 = 0;//sysj\plant.sysj line: 185, column: 3
    for(int i_thread_11 = 0; i_thread_11 < 6; i_thread_11 = i_thread_11 + 1) {//sysj\plant.sysj line: 186, column: 29
      packedArray_thread_11[i_thread_11] = 0;//sysj\plant.sysj line: 187, column: 7
    }
    packedArray_thread_11[0] = 5;//sysj\plant.sysj line: 190, column: 6
    packedArray_thread_11[3] = 1;//sysj\plant.sysj line: 191, column: 6
    S1611=0;
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
      switch(S1681){
        case 0 : 
          S1681=0;
          break RUN;
        
        case 1 : 
          S1681=2;
          S1681=2;
          posOne_10.setClear();//sysj\plant.sysj line: 182, column: 2
          posFive_10.setClear();//sysj\plant.sysj line: 182, column: 2
          turn_10.setClear();//sysj\plant.sysj line: 182, column: 2
          thread2381(tdone,ends);
          thread2382(tdone,ends);
          int biggest2383 = 0;
          if(ends[11]>=biggest2383){
            biggest2383=ends[11];
          }
          if(ends[12]>=biggest2383){
            biggest2383=ends[12];
          }
          if(biggest2383 == 1){
            active[10]=1;
            ends[10]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_10.setClear();//sysj\plant.sysj line: 182, column: 2
          posFive_10.setClear();//sysj\plant.sysj line: 182, column: 2
          turn_10.setClear();//sysj\plant.sysj line: 182, column: 2
          thread2384(tdone,ends);
          thread2385(tdone,ends);
          int biggest2386 = 0;
          if(ends[11]>=biggest2386){
            biggest2386=ends[11];
          }
          if(ends[12]>=biggest2386){
            biggest2386=ends[12];
          }
          if(biggest2386 == 1){
            active[10]=1;
            ends[10]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2386 == 0){
            S1681=0;
            active[10]=0;
            ends[10]=0;
            S1681=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
      posOne_10.setClear();
      posFive_10.setClear();
      turn_10.setClear();
      if(paused[10]!=0 || suspended[10]!=0 || active[10]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[10] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
