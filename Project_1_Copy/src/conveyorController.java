import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

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
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.OUTPUT);
  public Signal conveyorMoving = new Signal("conveyorMoving", Signal.OUTPUT);
  public Signal conveyorStop = new Signal("conveyorStop", Signal.OUTPUT);
  private int S123 = 1;
  private int S65 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S123){
        case 0 : 
          S123=0;
          break RUN;
        
        case 1 : 
          S123=2;
          S123=2;
          S65=0;
          active[2]=1;
          ends[2]=1;
          break RUN;
        
        case 2 : 
          switch(S65){
            case 0 : 
              if(move.getprestatus()){//sysj\controller.sysj line: 46, column: 10
                S65=1;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 1 : 
              if(!bottleAtPos1.getprestatus()){//sysj\controller.sysj line: 47, column: 10
                S65=2;
                conveyorMoving.setPresent();//sysj\controller.sysj line: 49, column: 5
                currsigs.addElement(conveyorMoving);
                motConveyorOnOff.setPresent();//sysj\controller.sysj line: 50, column: 5
                currsigs.addElement(motConveyorOnOff);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 2 : 
              if(bottleAtPos1.getprestatus()){//sysj\controller.sysj line: 48, column: 10
                conveyorStop.setPresent();//sysj\controller.sysj line: 52, column: 4
                currsigs.addElement(conveyorStop);
                S65=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                motConveyorOnOff.setPresent();//sysj\controller.sysj line: 50, column: 5
                currsigs.addElement(motConveyorOnOff);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        if(!df){
          move.gethook();
          bottleAtPos1.gethook();
          bottleLeftPos5.gethook();
          df = true;
        }
        runClockDomain();
      }
      move.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      motConveyorOnOff.setpreclear();
      conveyorMoving.setpreclear();
      conveyorStop.setpreclear();
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
      motConveyorOnOff.sethook();
      motConveyorOnOff.setClear();
      conveyorMoving.sethook();
      conveyorMoving.setClear();
      conveyorStop.sethook();
      conveyorStop.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        move.gethook();
        bottleAtPos1.gethook();
        bottleLeftPos5.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
