import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\rotPlant.sysj line: 1, column: 1

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
  private Signal posOne_1;
  private Signal posFive_1;
  private Signal turn_1;
  private int[] packedArray_thread_2;//sysj\rotPlant.sysj line: 17, column: 3
  private int pos_thread_2;//sysj\rotPlant.sysj line: 18, column: 3
  private int pos1_thread_2;//sysj\rotPlant.sysj line: 30, column: 5
  private int pos5_thread_2;//sysj\rotPlant.sysj line: 31, column: 5
  private int[] newPackedArray_thread_2;//sysj\rotPlant.sysj line: 35, column: 5
  private int S930 = 1;
  private int S923 = 1;
  private int S860 = 1;
  private int S928 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread936(int [] tdone, int [] ends){
        switch(S928){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_1.getpreval() == null ? 0 : ((Integer)posOne_1.getpreval()).intValue()) == 5) {//sysj\rotPlant.sysj line: 51, column: 29
        }
        if((Integer)(posFive_1.getpreval() == null ? 0 : ((Integer)posFive_1.getpreval()).intValue()) != 0) {//sysj\rotPlant.sysj line: 54, column: 30
        }
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread935(int [] tdone, int [] ends){
        switch(S923){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 27, column: 10
          S860=0;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          switch(S860){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 28, column: 11
                S860=1;
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
            
            case 1 : 
              if(enable.getprestatus()){//sysj\rotPlant.sysj line: 29, column: 11
                pos1_thread_2 = packedArray_thread_2[0];//sysj\rotPlant.sysj line: 30, column: 5
                pos5_thread_2 = packedArray_thread_2[4];//sysj\rotPlant.sysj line: 31, column: 5
                rotTurn.setPresent();//sysj\rotPlant.sysj line: 32, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_2);//sysj\rotPlant.sysj line: 32, column: 5
                System.out.println("Emitted rotTurn");
                posOne_1.setPresent();//sysj\rotPlant.sysj line: 33, column: 5
                currsigs.addElement(posOne_1);
                posOne_1.setValue(pos1_thread_2);//sysj\rotPlant.sysj line: 33, column: 5
                System.out.println("Emitted posOne_1");
                posFive_1.setPresent();//sysj\rotPlant.sysj line: 34, column: 5
                currsigs.addElement(posFive_1);
                posFive_1.setValue(pos5_thread_2);//sysj\rotPlant.sysj line: 34, column: 5
                System.out.println("Emitted posFive_1");
                newPackedArray_thread_2 = new int[6];//sysj\rotPlant.sysj line: 35, column: 5
                newPackedArray_thread_2[0] = packedArray_thread_2[5];//sysj\rotPlant.sysj line: 36, column: 5
                for(int i_thread_2 = 1; i_thread_2 < 6; i_thread_2 = i_thread_2 + 1) {//sysj\rotPlant.sysj line: 38, column: 31
                  newPackedArray_thread_2[i_thread_2] = packedArray_thread_2[i_thread_2 - 1];//sysj\rotPlant.sysj line: 39, column: 6
                }
                packedArray_thread_2 = newPackedArray_thread_2;//sysj\rotPlant.sysj line: 41, column: 5
                S860=2;
                tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 42, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
                System.out.println("Emitted tableAlignedWithSensorC");
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
            
            case 2 : 
              tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 42, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              System.out.println("Emitted tableAlignedWithSensorC");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread933(int [] tdone, int [] ends){
        S928=1;
    if((Integer)(posOne_1.getpreval() == null ? 0 : ((Integer)posOne_1.getpreval()).intValue()) == 5) {//sysj\rotPlant.sysj line: 51, column: 29
    }
    if((Integer)(posFive_1.getpreval() == null ? 0 : ((Integer)posFive_1.getpreval()).intValue()) != 0) {//sysj\rotPlant.sysj line: 54, column: 30
    }
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread932(int [] tdone, int [] ends){
        S923=1;
    packedArray_thread_2 = new int[6];//sysj\rotPlant.sysj line: 17, column: 3
    pos_thread_2 = 0;//sysj\rotPlant.sysj line: 18, column: 3
    for(int i_thread_2 = 0; i_thread_2 < 6; i_thread_2 = i_thread_2 + 1) {//sysj\rotPlant.sysj line: 19, column: 29
      packedArray_thread_2[i_thread_2] = 0;//sysj\rotPlant.sysj line: 20, column: 7
    }
    packedArray_thread_2[0] = 5;//sysj\rotPlant.sysj line: 23, column: 6
    packedArray_thread_2[3] = 1;//sysj\rotPlant.sysj line: 24, column: 6
    S860=0;
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
      switch(S930){
        case 0 : 
          S930=0;
          break RUN;
        
        case 1 : 
          S930=2;
          S930=2;
          posOne_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          posFive_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          turn_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          thread932(tdone,ends);
          thread933(tdone,ends);
          int biggest934 = 0;
          if(ends[2]>=biggest934){
            biggest934=ends[2];
          }
          if(ends[3]>=biggest934){
            biggest934=ends[3];
          }
          if(biggest934 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          posFive_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          turn_1.setClear();//sysj\rotPlant.sysj line: 15, column: 2
          thread935(tdone,ends);
          thread936(tdone,ends);
          int biggest937 = 0;
          if(ends[2]>=biggest937){
            biggest937=ends[2];
          }
          if(ends[3]>=biggest937){
            biggest937=ends[3];
          }
          if(biggest937 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest937 == 0){
            S930=0;
            active[1]=0;
            ends[1]=0;
            S930=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_1 = new Signal();
    posFive_1 = new Signal();
    turn_1 = new Signal();
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
      posOne_1.setpreclear();
      posFive_1.setpreclear();
      turn_1.setpreclear();
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
      posOne_1.setClear();
      posFive_1.setClear();
      turn_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
