import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\conveyorController.sysj line: 1, column: 1

public class conveyorController extends ClockDomain{
  public conveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal move = new Signal("move", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.INPUT);
  public Signal moved = new Signal("moved", Signal.INPUT);
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.OUTPUT);
  public Signal conveyorMoving = new Signal("conveyorMoving", Signal.OUTPUT);
  public Signal conveyorStop = new Signal("conveyorStop", Signal.OUTPUT);
  public Signal conveyorMoved = new Signal("conveyorMoved", Signal.OUTPUT);
  private int S11 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S11){
        case 0 : 
          S11=0;
          break RUN;
        
        case 1 : 
          S11=2;
          S11=2;
          active[1]=0;
          ends[1]=0;
          S11=0;
          break RUN;
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          move.gethook();
          bottleAtPos1.gethook();
          bottleLeftPos5.gethook();
          moved.gethook();
          df = true;
        }
        runClockDomain();
      }
      move.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      moved.setpreclear();
      motConveyorOnOff.setpreclear();
      conveyorMoving.setpreclear();
      conveyorStop.setpreclear();
      conveyorMoved.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = move.getStatus() ? move.setprepresent() : move.setpreclear();
      move.setpreval(move.getValue());
      move.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = bottleLeftPos5.getStatus() ? bottleLeftPos5.setprepresent() : bottleLeftPos5.setpreclear();
      bottleLeftPos5.setpreval(bottleLeftPos5.getValue());
      bottleLeftPos5.setClear();
      dummyint = moved.getStatus() ? moved.setprepresent() : moved.setpreclear();
      moved.setpreval(moved.getValue());
      moved.setClear();
      motConveyorOnOff.sethook();
      motConveyorOnOff.setClear();
      conveyorMoving.sethook();
      conveyorMoving.setClear();
      conveyorStop.sethook();
      conveyorStop.setClear();
      conveyorMoved.sethook();
      conveyorMoved.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        move.gethook();
        bottleAtPos1.gethook();
        bottleLeftPos5.gethook();
        moved.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
