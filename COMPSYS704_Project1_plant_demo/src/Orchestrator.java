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
  public Signal rotaryTableStatus = new Signal("rotaryTableStatus", Signal.INPUT);
  public Signal rotaryTableRequest = new Signal("rotaryTableRequest", Signal.OUTPUT);
  private int S1 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1){
        case 0 : 
          S1=0;
          break RUN;
        
        case 1 : 
          S1=2;
          S1=2;
          System.out.println("Hello Machines");//sysj\controller.sysj line: 6, column: 2
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
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
          rotaryTableStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableStatus.setpreclear();
      rotaryTableRequest.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableStatus.getStatus() ? rotaryTableStatus.setprepresent() : rotaryTableStatus.setpreclear();
      rotaryTableStatus.setpreval(rotaryTableStatus.getValue());
      rotaryTableStatus.setClear();
      rotaryTableRequest.sethook();
      rotaryTableRequest.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableStatus.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
