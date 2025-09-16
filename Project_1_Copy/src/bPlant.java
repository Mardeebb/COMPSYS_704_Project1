import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class bPlant extends ClockDomain{
  public bPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal CMD_L = new Signal("CMD_L", Signal.INPUT);
  public Signal CMD_L2 = new Signal("CMD_L2", Signal.INPUT);
  public Signal CMD_R = new Signal("CMD_R", Signal.INPUT);
  public Signal CMD_R2 = new Signal("CMD_R2", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleLoad = new Signal("bottleLoad", Signal.OUTPUT);
  public Signal bottleUnload = new Signal("bottleUnload", Signal.OUTPUT);
  public Signal CMDfb_L = new Signal("CMDfb_L", Signal.OUTPUT);
  public Signal CMDfb_L2 = new Signal("CMDfb_L2", Signal.OUTPUT);
  public Signal CMDfb_R = new Signal("CMDfb_R", Signal.OUTPUT);
  public Signal CMDfb_R2 = new Signal("CMDfb_R2", Signal.OUTPUT);
  public Signal CMD_LE = new Signal("CMD_LE", Signal.OUTPUT);
  public Signal CMD_L2E = new Signal("CMD_L2E", Signal.OUTPUT);
  public Signal CMD_RE = new Signal("CMD_RE", Signal.OUTPUT);
  public Signal CMD_R2E = new Signal("CMD_R2E", Signal.OUTPUT);
  private int S2888 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2888){
        case 0 : 
          S2888=0;
          break RUN;
        
        case 1 : 
          S2888=2;
          System.out.println("Baxter robot Plant started");//sysj\robotPlant.sysj line: 9, column: 3
          S2888=0;
          active[1]=0;
          ends[1]=0;
          S2888=0;
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
          CMD_L.gethook();
          CMD_L2.gethook();
          CMD_R.gethook();
          CMD_R2.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      CMD_L.setpreclear();
      CMD_L2.setpreclear();
      CMD_R.setpreclear();
      CMD_R2.setpreclear();
      enable.setpreclear();
      bottleLoad.setpreclear();
      bottleUnload.setpreclear();
      CMDfb_L.setpreclear();
      CMDfb_L2.setpreclear();
      CMDfb_R.setpreclear();
      CMDfb_R2.setpreclear();
      CMD_LE.setpreclear();
      CMD_L2E.setpreclear();
      CMD_RE.setpreclear();
      CMD_R2E.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = CMD_L.getStatus() ? CMD_L.setprepresent() : CMD_L.setpreclear();
      CMD_L.setpreval(CMD_L.getValue());
      CMD_L.setClear();
      dummyint = CMD_L2.getStatus() ? CMD_L2.setprepresent() : CMD_L2.setpreclear();
      CMD_L2.setpreval(CMD_L2.getValue());
      CMD_L2.setClear();
      dummyint = CMD_R.getStatus() ? CMD_R.setprepresent() : CMD_R.setpreclear();
      CMD_R.setpreval(CMD_R.getValue());
      CMD_R.setClear();
      dummyint = CMD_R2.getStatus() ? CMD_R2.setprepresent() : CMD_R2.setpreclear();
      CMD_R2.setpreval(CMD_R2.getValue());
      CMD_R2.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      bottleLoad.sethook();
      bottleLoad.setClear();
      bottleUnload.sethook();
      bottleUnload.setClear();
      CMDfb_L.sethook();
      CMDfb_L.setClear();
      CMDfb_L2.sethook();
      CMDfb_L2.setClear();
      CMDfb_R.sethook();
      CMDfb_R.setClear();
      CMDfb_R2.sethook();
      CMDfb_R2.setClear();
      CMD_LE.sethook();
      CMD_LE.setClear();
      CMD_L2E.sethook();
      CMD_L2E.setClear();
      CMD_RE.sethook();
      CMD_RE.setClear();
      CMD_R2E.sethook();
      CMD_R2E.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        CMD_L.gethook();
        CMD_L2.gethook();
        CMD_R.gethook();
        CMD_R2.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
