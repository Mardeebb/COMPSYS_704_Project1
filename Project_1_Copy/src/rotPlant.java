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
  private Signal posOne_14;
  private Signal posFive_14;
  private Signal turn_14;
  private int[] packedArray_thread_15;//sysj\plant.sysj line: 238, column: 3
  private int pos_thread_15;//sysj\plant.sysj line: 239, column: 3
  private int pos1_thread_15;//sysj\plant.sysj line: 251, column: 5
  private int pos5_thread_15;//sysj\plant.sysj line: 252, column: 5
  private int[] newPackedArray_thread_15;//sysj\plant.sysj line: 256, column: 5
  private int S3304 = 1;
  private int S3297 = 1;
  private int S3234 = 1;
  private int S3302 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void thread3780(int [] tdone, int [] ends){
        switch(S3302){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_14.getpreval() == null ? 0 : ((Integer)posOne_14.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 272, column: 29
        }
        if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 275, column: 30
        }
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread3779(int [] tdone, int [] ends){
        switch(S3297){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 248, column: 10
          S3234=0;
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          switch(S3234){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 249, column: 11
                S3234=1;
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
            
            case 1 : 
              if(enable.getprestatus()){//sysj\plant.sysj line: 250, column: 11
                pos1_thread_15 = packedArray_thread_15[0];//sysj\plant.sysj line: 251, column: 5
                pos5_thread_15 = packedArray_thread_15[4];//sysj\plant.sysj line: 252, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 253, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_15);//sysj\plant.sysj line: 253, column: 5
                posOne_14.setPresent();//sysj\plant.sysj line: 254, column: 5
                currsigs.addElement(posOne_14);
                posOne_14.setValue(pos1_thread_15);//sysj\plant.sysj line: 254, column: 5
                posFive_14.setPresent();//sysj\plant.sysj line: 255, column: 5
                currsigs.addElement(posFive_14);
                posFive_14.setValue(pos5_thread_15);//sysj\plant.sysj line: 255, column: 5
                newPackedArray_thread_15 = new int[6];//sysj\plant.sysj line: 256, column: 5
                newPackedArray_thread_15[0] = packedArray_thread_15[5];//sysj\plant.sysj line: 257, column: 5
                for(int i_thread_15 = 1; i_thread_15 < 6; i_thread_15 = i_thread_15 + 1) {//sysj\plant.sysj line: 259, column: 31
                  newPackedArray_thread_15[i_thread_15] = packedArray_thread_15[i_thread_15 - 1];//sysj\plant.sysj line: 260, column: 6
                }
                packedArray_thread_15 = newPackedArray_thread_15;//sysj\plant.sysj line: 262, column: 5
                S3234=2;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 263, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
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
            
            case 2 : 
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 263, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread3777(int [] tdone, int [] ends){
        S3302=1;
    if((Integer)(posOne_14.getpreval() == null ? 0 : ((Integer)posOne_14.getpreval()).intValue()) == 5) {//sysj\plant.sysj line: 272, column: 29
    }
    if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0) {//sysj\plant.sysj line: 275, column: 30
    }
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread3776(int [] tdone, int [] ends){
        S3297=1;
    packedArray_thread_15 = new int[6];//sysj\plant.sysj line: 238, column: 3
    pos_thread_15 = 0;//sysj\plant.sysj line: 239, column: 3
    for(int i_thread_15 = 0; i_thread_15 < 6; i_thread_15 = i_thread_15 + 1) {//sysj\plant.sysj line: 240, column: 29
      packedArray_thread_15[i_thread_15] = 0;//sysj\plant.sysj line: 241, column: 7
    }
    packedArray_thread_15[0] = 5;//sysj\plant.sysj line: 244, column: 6
    packedArray_thread_15[3] = 1;//sysj\plant.sysj line: 245, column: 6
    S3234=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3304){
        case 0 : 
          S3304=0;
          break RUN;
        
        case 1 : 
          S3304=2;
          S3304=2;
          posOne_14.setClear();//sysj\plant.sysj line: 236, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 236, column: 2
          turn_14.setClear();//sysj\plant.sysj line: 236, column: 2
          thread3776(tdone,ends);
          thread3777(tdone,ends);
          int biggest3778 = 0;
          if(ends[15]>=biggest3778){
            biggest3778=ends[15];
          }
          if(ends[16]>=biggest3778){
            biggest3778=ends[16];
          }
          if(biggest3778 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_14.setClear();//sysj\plant.sysj line: 236, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 236, column: 2
          turn_14.setClear();//sysj\plant.sysj line: 236, column: 2
          thread3779(tdone,ends);
          thread3780(tdone,ends);
          int biggest3781 = 0;
          if(ends[15]>=biggest3781){
            biggest3781=ends[15];
          }
          if(ends[16]>=biggest3781){
            biggest3781=ends[16];
          }
          if(biggest3781 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3781 == 0){
            S3304=0;
            active[14]=0;
            ends[14]=0;
            S3304=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_14 = new Signal();
    posFive_14 = new Signal();
    turn_14 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[14] != 0){
      int index = 14;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
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
      posOne_14.setpreclear();
      posFive_14.setpreclear();
      turn_14.setpreclear();
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
      posOne_14.setClear();
      posFive_14.setClear();
      turn_14.setClear();
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[14] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
