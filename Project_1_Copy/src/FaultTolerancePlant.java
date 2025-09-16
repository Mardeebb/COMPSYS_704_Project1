import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class FaultTolerancePlant extends ClockDomain{
  public FaultTolerancePlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal fault = new Signal("fault", Signal.INPUT);
  public Signal faultOnE = new Signal("faultOnE", Signal.OUTPUT);
  private int S3220 = 1;
  private int S3184 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3220){
        case 0 : 
          S3220=0;
          break RUN;
        
        case 1 : 
          S3220=2;
          S3220=2;
          S3184=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          switch(S3184){
            case 0 : 
              if(fault.getprestatus()){//sysj\plant.sysj line: 215, column: 10
                System.err.println("Fualt");//sysj\plant.sysj line: 216, column: 5
                S3184=1;
                faultOnE.setPresent();//sysj\plant.sysj line: 218, column: 6
                currsigs.addElement(faultOnE);
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
            
            case 1 : 
              if(enable.getprestatus()){//sysj\plant.sysj line: 217, column: 11
                System.err.println("aborted");//sysj\plant.sysj line: 220, column: 5
                S3184=2;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                faultOnE.setPresent();//sysj\plant.sysj line: 218, column: 6
                currsigs.addElement(faultOnE);
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
            
            case 2 : 
              if(!enable.getprestatus()){//sysj\plant.sysj line: 222, column: 10
                S3184=0;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        if(!df){
          enable.gethook();
          fault.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      fault.setpreclear();
      faultOnE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = fault.getStatus() ? fault.setprepresent() : fault.setpreclear();
      fault.setpreval(fault.getValue());
      fault.setClear();
      faultOnE.sethook();
      faultOnE.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        enable.gethook();
        fault.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
