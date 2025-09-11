import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

public class Orchestrator extends ClockDomain{
  public Orchestrator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal newBottleTwin = new Signal("newBottleTwin", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal moveConveyor = new Signal("moveConveyor", Signal.OUTPUT);
  public Signal bottleToConveyor = new Signal("bottleToConveyor", Signal.OUTPUT);
  private BottleTwin b_thread_1;//sysj\controller.sysj line: 18, column: 4
  private int ID_thread_1;//sysj\controller.sysj line: 20, column: 5
  private String name_thread_1;//sysj\controller.sysj line: 21, column: 5
  private int S61 = 1;
  private int S2 = 1;
  private int S3 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S61){
        case 0 : 
          S61=0;
          break RUN;
        
        case 1 : 
          S61=2;
          S61=2;
          System.err.println("new Orchestrator Cycle");//sysj\controller.sysj line: 13, column: 7
          S2=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S2){
            case 0 : 
              if(newBottleTwin.getprestatus()){//sysj\controller.sysj line: 15, column: 10
                System.err.println("newBottleTwin ");//sysj\controller.sysj line: 16, column: 7
                b_thread_1 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\controller.sysj line: 18, column: 4
                S2=1;
                if(b_thread_1 != null){//sysj\controller.sysj line: 19, column: 7
                  ID_thread_1 = b_thread_1.ID;//sysj\controller.sysj line: 20, column: 5
                  name_thread_1 = b_thread_1.name;//sysj\controller.sysj line: 21, column: 5
                  System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_1);//sysj\controller.sysj line: 22, column: 8
                  System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_1);//sysj\controller.sysj line: 23, column: 8
                  System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_1);//sysj\controller.sysj line: 24, column: 8
                  S3=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  System.err.println("new Orchestrator Cycle");//sysj\controller.sysj line: 13, column: 7
                  S2=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S3){
                case 0 : 
                  if(!newBottleTwin.getprestatus()){//sysj\controller.sysj line: 25, column: 14
                    S3=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(request.getprestatus()){//sysj\controller.sysj line: 26, column: 11
                    bottleToConveyor.setPresent();//sysj\controller.sysj line: 27, column: 5
                    currsigs.addElement(bottleToConveyor);
                    bottleToConveyor.setValue(b_thread_1);//sysj\controller.sysj line: 27, column: 5
                    System.out.println("Emitted bottleToConveyor");
                    moveConveyor.setPresent();//sysj\controller.sysj line: 28, column: 5
                    currsigs.addElement(moveConveyor);
                    System.out.println("Emitted moveConveyor");
                    recieveTwin.setPresent();//sysj\controller.sysj line: 30, column: 5
                    currsigs.addElement(recieveTwin);
                    System.out.println("Emitted recieveTwin");
                    System.err.println("new Orchestrator Cycle");//sysj\controller.sysj line: 13, column: 7
                    S2=0;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
              }
              break;
            
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
          newBottleTwin.gethook();
          request.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      recieveTwin.setpreclear();
      moveConveyor.setpreclear();
      bottleToConveyor.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = newBottleTwin.getStatus() ? newBottleTwin.setprepresent() : newBottleTwin.setpreclear();
      newBottleTwin.setpreval(newBottleTwin.getValue());
      newBottleTwin.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      moveConveyor.sethook();
      moveConveyor.setClear();
      bottleToConveyor.sethook();
      bottleToConveyor.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
