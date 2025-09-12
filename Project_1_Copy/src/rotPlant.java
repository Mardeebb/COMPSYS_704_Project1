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
  public Signal posTwo = new Signal("posTwo", Signal.INPUT);
  public Signal posThree = new Signal("posThree", Signal.INPUT);
  public Signal posFour = new Signal("posFour", Signal.INPUT);
  public Signal posFive = new Signal("posFive", Signal.INPUT);
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
  private int S778 = 1;
  private int S752 = 1;
  private int S721 = 1;
  private int S754 = 1;
  private int S776 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread786(int [] tdone, int [] ends){
        switch(S776){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(posOne.getprestatus()){//sysj\rotPlant.sysj line: 50, column: 10
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

  public void thread785(int [] tdone, int [] ends){
        switch(S754){
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

  public void thread784(int [] tdone, int [] ends){
        switch(S752){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 22, column: 10
          S721=0;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          switch(S721){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\rotPlant.sysj line: 23, column: 11
                S721=1;
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
                rotTurned.setPresent();//sysj\rotPlant.sysj line: 25, column: 5
                currsigs.addElement(rotTurned);
                System.out.println("Emitted rotTurned");
                rotTurn.setPresent();//sysj\rotPlant.sysj line: 26, column: 5
                currsigs.addElement(rotTurn);
                System.out.println("Emitted rotTurn");
                turn_1.setPresent();//sysj\rotPlant.sysj line: 27, column: 5
                currsigs.addElement(turn_1);
                System.out.println("Emitted turn_1");
                S721=2;
                tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 28, column: 5
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
              tableAlignedWithSensorC.setPresent();//sysj\rotPlant.sysj line: 28, column: 5
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

  public void thread782(int [] tdone, int [] ends){
        S776=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread781(int [] tdone, int [] ends){
        S754=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread780(int [] tdone, int [] ends){
        S752=1;
    S721=0;
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
      switch(S778){
        case 0 : 
          S778=0;
          break RUN;
        
        case 1 : 
          S778=2;
          S778=2;
          turn_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos1_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos2_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos3_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos4_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos5_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos6_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          thread780(tdone,ends);
          thread781(tdone,ends);
          thread782(tdone,ends);
          int biggest783 = 0;
          if(ends[2]>=biggest783){
            biggest783=ends[2];
          }
          if(ends[3]>=biggest783){
            biggest783=ends[3];
          }
          if(ends[4]>=biggest783){
            biggest783=ends[4];
          }
          if(biggest783 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          turn_1.setClear();//sysj\rotPlant.sysj line: 17, column: 2
          pos1_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos2_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos3_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos4_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos5_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          pos6_1.setClear();//sysj\rotPlant.sysj line: 18, column: 2
          thread784(tdone,ends);
          thread785(tdone,ends);
          thread786(tdone,ends);
          int biggest787 = 0;
          if(ends[2]>=biggest787){
            biggest787=ends[2];
          }
          if(ends[3]>=biggest787){
            biggest787=ends[3];
          }
          if(ends[4]>=biggest787){
            biggest787=ends[4];
          }
          if(biggest787 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest787 == 0){
            S778=0;
            active[1]=0;
            ends[1]=0;
            S778=0;
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
          posTwo.gethook();
          posThree.gethook();
          posFour.gethook();
          posFive.gethook();
          posSix.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      enable.setpreclear();
      posOne.setpreclear();
      posTwo.setpreclear();
      posThree.setpreclear();
      posFour.setpreclear();
      posFive.setpreclear();
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
      dummyint = posTwo.getStatus() ? posTwo.setprepresent() : posTwo.setpreclear();
      posTwo.setpreval(posTwo.getValue());
      posTwo.setClear();
      dummyint = posThree.getStatus() ? posThree.setprepresent() : posThree.setpreclear();
      posThree.setpreval(posThree.getValue());
      posThree.setClear();
      dummyint = posFour.getStatus() ? posFour.setprepresent() : posFour.setpreclear();
      posFour.setpreval(posFour.getValue());
      posFour.setClear();
      dummyint = posFive.getStatus() ? posFive.setprepresent() : posFive.setpreclear();
      posFive.setpreval(posFive.getValue());
      posFive.setClear();
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
        posTwo.gethook();
        posThree.gethook();
        posFour.gethook();
        posFive.gethook();
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
