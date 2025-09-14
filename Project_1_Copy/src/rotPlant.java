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
  public Signal posOne = new Signal("posOne", Signal.INPUT);
  public Signal posSix = new Signal("posSix", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurned = new Signal("rotTurned", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  private Signal turn_1;
  private Signal pos1_1;
  private Signal pos2_1;
  private Signal pos3_1;
  private Signal pos4_1;
  private Signal pos5_1;
  private Signal pos6_1;
  private BottleTwin b1_thread_2;//sysj\rotPlant.sysj line: 26, column: 5
  private BottleTwin b2_thread_2;//sysj\rotPlant.sysj line: 27, column: 5
  private BottleTwin b3_thread_2;//sysj\rotPlant.sysj line: 28, column: 5
  private BottleTwin b4_thread_2;//sysj\rotPlant.sysj line: 29, column: 5
  private BottleTwin b5_thread_2;//sysj\rotPlant.sysj line: 30, column: 5
  private BottleTwin b6_thread_2;//sysj\rotPlant.sysj line: 31, column: 5
  private int ID_thread_2;//sysj\rotPlant.sysj line: 33, column: 6
  private int[] packedArray_thread_2;//sysj\rotPlant.sysj line: 22, column: 5
  private BottleTwin b_thread_4;//sysj\rotPlant.sysj line: 106, column: 4
  private int S3840 = 1;
  private int S3828 = 1;
  private int S3793 = 1;
  private int S3830 = 1;
  private int S3838 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread3848(int [] tdone, int [] ends){
        switch(S3838){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(posOne.getprestatus()){//sysj\rotPlant.sysj line: 103, column: 10
          b_thread_4 = (BottleTwin)(posOne.getpreval() == null ? null : ((BottleTwin)posOne.getpreval()));//sysj\rotPlant.sysj line: 106, column: 4
          System.err.println(b_thread_4.ID);//sysj\rotPlant.sysj line: 107, column: 4
          pos1_1.setPresent();//sysj\rotPlant.sysj line: 109, column: 4
          currsigs.addElement(pos1_1);
          pos1_1.setValue(b_thread_4);//sysj\rotPlant.sysj line: 109, column: 4
          System.out.println("Emitted pos1_1");
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

  public void thread3847(int [] tdone, int [] ends){
        switch(S3830){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread3846(int [] tdone, int [] ends){
        switch(S3828){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 21, column: 10
          packedArray_thread_2 = new int[6];//sysj\rotPlant.sysj line: 22, column: 5
          S3793=0;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          switch(S3793){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 23, column: 11
                S3793=1;
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
              if(enable.getprestatus()){//sysj\rotPlant.sysj line: 24, column: 11
                b1_thread_2 = (BottleTwin)(pos1_1.getpreval() == null ? null : ((BottleTwin)pos1_1.getpreval()));//sysj\rotPlant.sysj line: 26, column: 5
                b2_thread_2 = (BottleTwin)(pos2_1.getpreval() == null ? null : ((BottleTwin)pos2_1.getpreval()));//sysj\rotPlant.sysj line: 27, column: 5
                b3_thread_2 = (BottleTwin)(pos3_1.getpreval() == null ? null : ((BottleTwin)pos3_1.getpreval()));//sysj\rotPlant.sysj line: 28, column: 5
                b4_thread_2 = (BottleTwin)(pos4_1.getpreval() == null ? null : ((BottleTwin)pos4_1.getpreval()));//sysj\rotPlant.sysj line: 29, column: 5
                b5_thread_2 = null;//sysj\rotPlant.sysj line: 30, column: 5
                b6_thread_2 = (BottleTwin)(pos6_1.getpreval() == null ? null : ((BottleTwin)pos6_1.getpreval()));//sysj\rotPlant.sysj line: 31, column: 5
                if(b1_thread_2 != null) {//sysj\rotPlant.sysj line: 32, column: 20
                  ID_thread_2 = b1_thread_2.ID;//sysj\rotPlant.sysj line: 33, column: 6
                  packedArray_thread_2[1] = ID_thread_2;//sysj\rotPlant.sysj line: 34, column: 6
                }
                else {//sysj\rotPlant.sysj line: 35, column: 11
                  packedArray_thread_2[1] = -1;//sysj\rotPlant.sysj line: 36, column: 6
                }
                if(b2_thread_2 != null) {//sysj\rotPlant.sysj line: 38, column: 20
                  ID_thread_2 = b2_thread_2.ID;//sysj\rotPlant.sysj line: 39, column: 6
                  packedArray_thread_2[2] = ID_thread_2;//sysj\rotPlant.sysj line: 40, column: 6
                }
                else {//sysj\rotPlant.sysj line: 41, column: 11
                  packedArray_thread_2[2] = -1;//sysj\rotPlant.sysj line: 42, column: 6
                }
                if(b3_thread_2 != null) {//sysj\rotPlant.sysj line: 44, column: 20
                  ID_thread_2 = b3_thread_2.ID;//sysj\rotPlant.sysj line: 45, column: 6
                  packedArray_thread_2[3] = ID_thread_2;//sysj\rotPlant.sysj line: 46, column: 6
                }
                else {//sysj\rotPlant.sysj line: 47, column: 11
                  packedArray_thread_2[3] = -1;//sysj\rotPlant.sysj line: 48, column: 6
                }
                if(b4_thread_2 != null) {//sysj\rotPlant.sysj line: 50, column: 20
                  ID_thread_2 = b4_thread_2.ID;//sysj\rotPlant.sysj line: 51, column: 6
                  packedArray_thread_2[4] = ID_thread_2;//sysj\rotPlant.sysj line: 52, column: 6
                }
                else {//sysj\rotPlant.sysj line: 53, column: 11
                  packedArray_thread_2[4] = -1;//sysj\rotPlant.sysj line: 54, column: 6
                }
                if(b5_thread_2 != null) {//sysj\rotPlant.sysj line: 56, column: 20
                  ID_thread_2 = b5_thread_2.ID;//sysj\rotPlant.sysj line: 57, column: 6
                  packedArray_thread_2[5] = ID_thread_2;//sysj\rotPlant.sysj line: 58, column: 6
                }
                else {//sysj\rotPlant.sysj line: 59, column: 11
                  packedArray_thread_2[5] = -1;//sysj\rotPlant.sysj line: 60, column: 6
                }
                if(b6_thread_2 != null) {//sysj\rotPlant.sysj line: 62, column: 20
                  ID_thread_2 = b6_thread_2.ID;//sysj\rotPlant.sysj line: 63, column: 6
                  packedArray_thread_2[0] = ID_thread_2;//sysj\rotPlant.sysj line: 64, column: 6
                }
                else {//sysj\rotPlant.sysj line: 65, column: 11
                  packedArray_thread_2[0] = -1;//sysj\rotPlant.sysj line: 66, column: 6
                }
                System.err.println(packedArray_thread_2);//sysj\rotPlant.sysj line: 68, column: 5
                pos1_1.setPresent();//sysj\rotPlant.sysj line: 70, column: 5
                currsigs.addElement(pos1_1);
                pos1_1.setValue(b6_thread_2);//sysj\rotPlant.sysj line: 70, column: 5
                System.out.println("Emitted pos1_1");
                pos2_1.setPresent();//sysj\rotPlant.sysj line: 71, column: 5
                currsigs.addElement(pos2_1);
                pos2_1.setValue(b1_thread_2);//sysj\rotPlant.sysj line: 71, column: 5
                System.out.println("Emitted pos2_1");
                pos3_1.setPresent();//sysj\rotPlant.sysj line: 72, column: 5
                currsigs.addElement(pos3_1);
                pos3_1.setValue(b2_thread_2);//sysj\rotPlant.sysj line: 72, column: 5
                System.out.println("Emitted pos3_1");
                pos4_1.setPresent();//sysj\rotPlant.sysj line: 73, column: 5
                currsigs.addElement(pos4_1);
                pos4_1.setValue(b3_thread_2);//sysj\rotPlant.sysj line: 73, column: 5
                System.out.println("Emitted pos4_1");
                pos5_1.setPresent();//sysj\rotPlant.sysj line: 74, column: 5
                currsigs.addElement(pos5_1);
                pos5_1.setValue(b4_thread_2);//sysj\rotPlant.sysj line: 74, column: 5
                System.out.println("Emitted pos5_1");
                pos6_1.setPresent();//sysj\rotPlant.sysj line: 75, column: 5
                currsigs.addElement(pos6_1);
                pos6_1.setValue(b5_thread_2);//sysj\rotPlant.sysj line: 75, column: 5
                System.out.println("Emitted pos6_1");
                rotTurned.setPresent();//sysj\rotPlant.sysj line: 77, column: 5
                currsigs.addElement(rotTurned);
                System.out.println("Emitted rotTurned");
                rotTurn.setPresent();//sysj\rotPlant.sysj line: 78, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_2);//sysj\rotPlant.sysj line: 78, column: 5
                System.out.println("Emitted rotTurn");
                turn_1.setPresent();//sysj\rotPlant.sysj line: 79, column: 5
                currsigs.addElement(turn_1);
                System.out.println("Emitted turn_1");
                S3793=2;
                tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 80, column: 5
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
              tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 80, column: 5
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

  public void thread3844(int [] tdone, int [] ends){
        S3838=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3843(int [] tdone, int [] ends){
        S3830=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3842(int [] tdone, int [] ends){
        S3828=1;
    packedArray_thread_2 = new int[6];//sysj\rotPlant.sysj line: 22, column: 5
    S3793=0;
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
      switch(S3840){
        case 0 : 
          S3840=0;
          break RUN;
        
        case 1 : 
          S3840=2;
          S3840=2;
          turn_1.setClear();//sysj\rotPlant.sysj line: 16, column: 2
          pos1_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos2_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos3_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos4_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos5_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos6_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          thread3842(tdone,ends);
          thread3843(tdone,ends);
          thread3844(tdone,ends);
          int biggest3845 = 0;
          if(ends[2]>=biggest3845){
            biggest3845=ends[2];
          }
          if(ends[3]>=biggest3845){
            biggest3845=ends[3];
          }
          if(ends[4]>=biggest3845){
            biggest3845=ends[4];
          }
          if(biggest3845 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          turn_1.setClear();//sysj\rotPlant.sysj line: 16, column: 2
          pos1_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos2_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos3_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos4_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos5_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos6_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          thread3846(tdone,ends);
          thread3847(tdone,ends);
          thread3848(tdone,ends);
          int biggest3849 = 0;
          if(ends[2]>=biggest3849){
            biggest3849=ends[2];
          }
          if(ends[3]>=biggest3849){
            biggest3849=ends[3];
          }
          if(ends[4]>=biggest3849){
            biggest3849=ends[4];
          }
          if(biggest3849 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3849 == 0){
            S3840=0;
            active[1]=0;
            ends[1]=0;
            S3840=0;
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
    turn_1 = new Signal();
    pos1_1 = new Signal();
    pos2_1 = new Signal();
    pos3_1 = new Signal();
    pos4_1 = new Signal();
    pos5_1 = new Signal();
    pos6_1 = new Signal();
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
          posOne.gethook();
          posSix.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      enable.setpreclear();
      posOne.setpreclear();
      posSix.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurned.setpreclear();
      rotTurn.setpreclear();
      turn_1.setpreclear();
      pos1_1.setpreclear();
      pos2_1.setpreclear();
      pos3_1.setpreclear();
      pos4_1.setpreclear();
      pos5_1.setpreclear();
      pos6_1.setpreclear();
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
      dummyint = posOne.getStatus() ? posOne.setprepresent() : posOne.setpreclear();
      posOne.setpreval(posOne.getValue());
      posOne.setClear();
      dummyint = posSix.getStatus() ? posSix.setprepresent() : posSix.setpreclear();
      posSix.setpreval(posSix.getValue());
      posSix.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      tableAlignedWithSensorC.sethook();
      tableAlignedWithSensorC.setClear();
      rotTurned.sethook();
      rotTurned.setClear();
      rotTurn.sethook();
      rotTurn.setClear();
      turn_1.setClear();
      pos1_1.setClear();
      pos2_1.setClear();
      pos3_1.setClear();
      pos4_1.setClear();
      pos5_1.setClear();
      pos6_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        posOne.gethook();
        posSix.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
