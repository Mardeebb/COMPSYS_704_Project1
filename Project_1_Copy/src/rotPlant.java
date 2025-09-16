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
  public Signal posFive = new Signal("posFive", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  private BottleTwin b_thread_3;//sysj\rotPlant.sysj line: 32, column: 4
  private BottleTwin b_thread_4;//sysj\rotPlant.sysj line: 46, column: 4
  private int S8155 = 1;
  private int S8103 = 1;
  private int S8076 = 1;
  private int S8135 = 1;
  private int S8153 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread8163(int [] tdone, int [] ends){
        switch(S8153){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(posFive.getprestatus()){//sysj\rotPlant.sysj line: 45, column: 10
          b_thread_4 = (BottleTwin)(posFive.getpreval() == null ? null : ((BottleTwin)posFive.getpreval()));//sysj\rotPlant.sysj line: 46, column: 4
          if(b_thread_4 != null){//sysj\rotPlant.sysj line: 47, column: 7
            bottleAtPos5.setPresent();//sysj\rotPlant.sysj line: 48, column: 5
            currsigs.addElement(bottleAtPos5);
            System.out.println("Emitted bottleAtPos5");
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
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread8162(int [] tdone, int [] ends){
        switch(S8135){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(posOne.getprestatus()){//sysj\rotPlant.sysj line: 31, column: 10
          b_thread_3 = (BottleTwin)(posOne.getpreval() == null ? null : ((BottleTwin)posOne.getpreval()));//sysj\rotPlant.sysj line: 32, column: 4
          if(b_thread_3 != null){//sysj\rotPlant.sysj line: 33, column: 7
            if(b_thread_3.isCapped || b_thread_3.isCapOn){//sysj\rotPlant.sysj line: 34, column: 8
              capOnBottleAtPos1.setPresent();//sysj\rotPlant.sysj line: 35, column: 6
              currsigs.addElement(capOnBottleAtPos1);
              System.out.println("Emitted capOnBottleAtPos1");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread8161(int [] tdone, int [] ends){
        switch(S8103){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 18, column: 10
          S8076=0;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          switch(S8076){
            case 0 : 
              if(enable.getprestatus()){//sysj\rotPlant.sysj line: 19, column: 11
                rotTurn.setPresent();//sysj\rotPlant.sysj line: 21, column: 5
                currsigs.addElement(rotTurn);
                System.out.println("Emitted rotTurn");
                S8076=1;
                tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 22, column: 5
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
            
            case 1 : 
              tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 22, column: 5
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

  public void thread8159(int [] tdone, int [] ends){
        S8153=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread8158(int [] tdone, int [] ends){
        S8135=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread8157(int [] tdone, int [] ends){
        S8103=1;
    S8076=0;
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
      switch(S8155){
        case 0 : 
          S8155=0;
          break RUN;
        
        case 1 : 
          S8155=2;
          S8155=2;
          thread8157(tdone,ends);
          thread8158(tdone,ends);
          thread8159(tdone,ends);
          int biggest8160 = 0;
          if(ends[2]>=biggest8160){
            biggest8160=ends[2];
          }
          if(ends[3]>=biggest8160){
            biggest8160=ends[3];
          }
          if(ends[4]>=biggest8160){
            biggest8160=ends[4];
          }
          if(biggest8160 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread8161(tdone,ends);
          thread8162(tdone,ends);
          thread8163(tdone,ends);
          int biggest8164 = 0;
          if(ends[2]>=biggest8164){
            biggest8164=ends[2];
          }
          if(ends[3]>=biggest8164){
            biggest8164=ends[3];
          }
          if(ends[4]>=biggest8164){
            biggest8164=ends[4];
          }
          if(biggest8164 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest8164 == 0){
            S8155=0;
            active[1]=0;
            ends[1]=0;
            S8155=0;
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
          posFive.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      enable.setpreclear();
      posOne.setpreclear();
      posFive.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurn.setpreclear();
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
      dummyint = posFive.getStatus() ? posFive.setprepresent() : posFive.setpreclear();
      posFive.setpreval(posFive.getValue());
      posFive.setClear();
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
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableTrigger.gethook();
        enable.gethook();
        posOne.gethook();
        posFive.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
