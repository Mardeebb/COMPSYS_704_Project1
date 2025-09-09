import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Orchestrator extends ClockDomain{
  public Orchestrator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal conveyorStatus = new Signal("conveyorStatus", Signal.INPUT);
  public Signal fillerStatus = new Signal("fillerStatus", Signal.INPUT);
  public Signal capperStatus = new Signal("capperStatus", Signal.INPUT);
  public Signal rotaryTableStatus = new Signal("rotaryTableStatus", Signal.INPUT);
  public Signal capLoaderStatus = new Signal("capLoaderStatus", Signal.INPUT);
  public Signal robotLoaderStatus = new Signal("robotLoaderStatus", Signal.INPUT);
  public Signal robotUnloaderStatus = new Signal("robotUnloaderStatus", Signal.INPUT);
  public Signal rotaryTableRequest = new Signal("rotaryTableRequest", Signal.OUTPUT);
  private int S7 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S7){
        case 0 : 
          S7=0;
          break RUN;
        
        case 1 : 
          S7=2;
          S7=2;
          System.out.println("Orchestrator");//sysj\controller.sysj line: 7, column: 2
          rotaryTableRequest.setPresent();//sysj\controller.sysj line: 10, column: 4
          currsigs.addElement(rotaryTableRequest);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          rotaryTableRequest.setPresent();//sysj\controller.sysj line: 10, column: 4
          currsigs.addElement(rotaryTableRequest);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
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
          conveyorStatus.gethook();
          fillerStatus.gethook();
          capperStatus.gethook();
          rotaryTableStatus.gethook();
          capLoaderStatus.gethook();
          robotLoaderStatus.gethook();
          robotUnloaderStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      conveyorStatus.setpreclear();
      fillerStatus.setpreclear();
      capperStatus.setpreclear();
      rotaryTableStatus.setpreclear();
      capLoaderStatus.setpreclear();
      robotLoaderStatus.setpreclear();
      robotUnloaderStatus.setpreclear();
      rotaryTableRequest.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = conveyorStatus.getStatus() ? conveyorStatus.setprepresent() : conveyorStatus.setpreclear();
      conveyorStatus.setpreval(conveyorStatus.getValue());
      conveyorStatus.setClear();
      dummyint = fillerStatus.getStatus() ? fillerStatus.setprepresent() : fillerStatus.setpreclear();
      fillerStatus.setpreval(fillerStatus.getValue());
      fillerStatus.setClear();
      dummyint = capperStatus.getStatus() ? capperStatus.setprepresent() : capperStatus.setpreclear();
      capperStatus.setpreval(capperStatus.getValue());
      capperStatus.setClear();
      dummyint = rotaryTableStatus.getStatus() ? rotaryTableStatus.setprepresent() : rotaryTableStatus.setpreclear();
      rotaryTableStatus.setpreval(rotaryTableStatus.getValue());
      rotaryTableStatus.setClear();
      dummyint = capLoaderStatus.getStatus() ? capLoaderStatus.setprepresent() : capLoaderStatus.setpreclear();
      capLoaderStatus.setpreval(capLoaderStatus.getValue());
      capLoaderStatus.setClear();
      dummyint = robotLoaderStatus.getStatus() ? robotLoaderStatus.setprepresent() : robotLoaderStatus.setpreclear();
      robotLoaderStatus.setpreval(robotLoaderStatus.getValue());
      robotLoaderStatus.setClear();
      dummyint = robotUnloaderStatus.getStatus() ? robotUnloaderStatus.setprepresent() : robotUnloaderStatus.setpreclear();
      robotUnloaderStatus.setpreval(robotUnloaderStatus.getValue());
      robotUnloaderStatus.setClear();
      rotaryTableRequest.sethook();
      rotaryTableRequest.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        conveyorStatus.gethook();
        fillerStatus.gethook();
        capperStatus.gethook();
        rotaryTableStatus.gethook();
        capLoaderStatus.gethook();
        robotLoaderStatus.gethook();
        robotUnloaderStatus.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
