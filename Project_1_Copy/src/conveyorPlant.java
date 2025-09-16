import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\conveyorPlant.sysj line: 1, column: 1

public class conveyorPlant extends ClockDomain{
  public conveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleArriveToZero = new Signal("bottleArriveToZero", Signal.INPUT);
  public Signal bottleArriveToFive = new Signal("bottleArriveToFive", Signal.INPUT);
  public Signal roturn = new Signal("roturn", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal moved = new Signal("moved", Signal.OUTPUT);
  public Signal pos0 = new Signal("pos0", Signal.OUTPUT);
  public Signal pos1 = new Signal("pos1", Signal.OUTPUT);
  public Signal pos5 = new Signal("pos5", Signal.OUTPUT);
  public Signal pos7 = new Signal("pos7", Signal.OUTPUT);
  private Signal conveyorMove_1;
  private Signal posZero_1;
  private Signal posOne_1;
  private Signal posFive_1;
  private Signal posSeven_1;
  private int S24 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread36(int [] tdone, int [] ends){
        active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread35(int [] tdone, int [] ends){
        active[5]=0;
    ends[5]=0;
    tdone[5]=1;
  }

  public void thread34(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread33(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread32(int [] tdone, int [] ends){
        active[2]=0;
    ends[2]=0;
    tdone[2]=1;
  }

  public void thread30(int [] tdone, int [] ends){
        active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread29(int [] tdone, int [] ends){
        active[5]=0;
    ends[5]=0;
    tdone[5]=1;
  }

  public void thread28(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread27(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread26(int [] tdone, int [] ends){
        active[2]=0;
    ends[2]=0;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S24){
        case 0 : 
          S24=0;
          break RUN;
        
        case 1 : 
          S24=2;
          S24=2;
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 17, column: 2
          posZero_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posOne_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posFive_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posSeven_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          thread26(tdone,ends);
          thread27(tdone,ends);
          thread28(tdone,ends);
          thread29(tdone,ends);
          thread30(tdone,ends);
          int biggest31 = 0;
          if(ends[2]>=biggest31){
            biggest31=ends[2];
          }
          if(ends[3]>=biggest31){
            biggest31=ends[3];
          }
          if(ends[4]>=biggest31){
            biggest31=ends[4];
          }
          if(ends[5]>=biggest31){
            biggest31=ends[5];
          }
          if(ends[6]>=biggest31){
            biggest31=ends[6];
          }
          //FINXME code
          if(biggest31 == 0){
            S24=0;
            active[1]=0;
            ends[1]=0;
            S24=0;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 17, column: 2
          posZero_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posOne_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posFive_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posSeven_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          thread32(tdone,ends);
          thread33(tdone,ends);
          thread34(tdone,ends);
          thread35(tdone,ends);
          thread36(tdone,ends);
          int biggest37 = 0;
          if(ends[2]>=biggest37){
            biggest37=ends[2];
          }
          if(ends[3]>=biggest37){
            biggest37=ends[3];
          }
          if(ends[4]>=biggest37){
            biggest37=ends[4];
          }
          if(ends[5]>=biggest37){
            biggest37=ends[5];
          }
          if(ends[6]>=biggest37){
            biggest37=ends[6];
          }
          //FINXME code
          if(biggest37 == 0){
            S24=0;
            active[1]=0;
            ends[1]=0;
            S24=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_1 = new Signal();
    posZero_1 = new Signal();
    posOne_1 = new Signal();
    posFive_1 = new Signal();
    posSeven_1 = new Signal();
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
          motConveyorOnOff.gethook();
          enable.gethook();
          bottleArriveToZero.gethook();
          bottleArriveToFive.gethook();
          roturn.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOnOff.setpreclear();
      enable.setpreclear();
      bottleArriveToZero.setpreclear();
      bottleArriveToFive.setpreclear();
      roturn.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      moved.setpreclear();
      pos0.setpreclear();
      pos1.setpreclear();
      pos5.setpreclear();
      pos7.setpreclear();
      conveyorMove_1.setpreclear();
      posZero_1.setpreclear();
      posOne_1.setpreclear();
      posFive_1.setpreclear();
      posSeven_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOnOff.getStatus() ? motConveyorOnOff.setprepresent() : motConveyorOnOff.setpreclear();
      motConveyorOnOff.setpreval(motConveyorOnOff.getValue());
      motConveyorOnOff.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleArriveToZero.getStatus() ? bottleArriveToZero.setprepresent() : bottleArriveToZero.setpreclear();
      bottleArriveToZero.setpreval(bottleArriveToZero.getValue());
      bottleArriveToZero.setClear();
      dummyint = bottleArriveToFive.getStatus() ? bottleArriveToFive.setprepresent() : bottleArriveToFive.setpreclear();
      bottleArriveToFive.setpreval(bottleArriveToFive.getValue());
      bottleArriveToFive.setClear();
      dummyint = roturn.getStatus() ? roturn.setprepresent() : roturn.setpreclear();
      roturn.setpreval(roturn.getValue());
      roturn.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      moved.sethook();
      moved.setClear();
      pos0.sethook();
      pos0.setClear();
      pos1.sethook();
      pos1.setClear();
      pos5.sethook();
      pos5.setClear();
      pos7.sethook();
      pos7.setClear();
      conveyorMove_1.setClear();
      posZero_1.setClear();
      posOne_1.setClear();
      posFive_1.setClear();
      posSeven_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
