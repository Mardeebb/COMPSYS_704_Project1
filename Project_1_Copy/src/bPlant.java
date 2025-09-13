import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

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
  private String s_thread_29;//sysj\plant.sysj line: 413, column: 10
  private String s_thread_30;//sysj\plant.sysj line: 427, column: 10
  private String s_thread_26;//sysj\plant.sysj line: 445, column: 7
  private int S2326 = 1;
  private int S2289 = 1;
  private int S2166 = 1;
  private int S2096 = 1;
  private int S2190 = 1;
  private int S2177 = 1;
  private int S2169 = 1;
  private int S2188 = 1;
  private int S2180 = 1;
  private int S2291 = 1;
  
  private int[] ends = new int[31];
  private int[] tdone = new int[31];
  
  public void thread2389(int [] tdone, int [] ends){
        switch(S2188){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S2180){
          case 0 : 
            S2180=0;
            S2180=1;
            active[30]=1;
            ends[30]=1;
            tdone[30]=1;
            break;
          
          case 1 : 
            S2180=1;
            S2180=2;
            active[30]=1;
            ends[30]=1;
            tdone[30]=1;
            break;
          
          case 2 : 
            S2180=2;
            S2180=3;
            active[30]=1;
            ends[30]=1;
            tdone[30]=1;
            break;
          
          case 3 : 
            S2180=3;
            S2180=4;
            active[30]=1;
            ends[30]=1;
            tdone[30]=1;
            break;
          
          case 4 : 
            S2180=4;
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 426, column: 17
              s_thread_30 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 427, column: 10
              CMD_L2E.setPresent();//sysj\plant.sysj line: 429, column: 10
              currsigs.addElement(CMD_L2E);
              CMD_L2E.setValue(s_thread_30);//sysj\plant.sysj line: 429, column: 10
              S2180=0;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S2180=0;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2388(int [] tdone, int [] ends){
        switch(S2177){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S2169){
          case 0 : 
            S2169=0;
            S2169=1;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 1 : 
            S2169=1;
            S2169=2;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 2 : 
            S2169=2;
            S2169=3;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 3 : 
            S2169=3;
            S2169=4;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 4 : 
            S2169=4;
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 412, column: 17
              s_thread_29 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 413, column: 10
              CMD_LE.setPresent();//sysj\plant.sysj line: 415, column: 10
              currsigs.addElement(CMD_LE);
              CMD_LE.setValue(s_thread_29);//sysj\plant.sysj line: 415, column: 10
              S2169=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S2169=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2387(int [] tdone, int [] ends){
        switch(S2190){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        thread2388(tdone,ends);
        thread2389(tdone,ends);
        int biggest2390 = 0;
        if(ends[29]>=biggest2390){
          biggest2390=ends[29];
        }
        if(ends[30]>=biggest2390){
          biggest2390=ends[30];
        }
        if(biggest2390 == 1){
          active[28]=1;
          ends[28]=1;
          tdone[28]=1;
        }
        //FINXME code
        if(biggest2390 == 0){
          S2190=0;
          active[28]=0;
          ends[28]=0;
          tdone[28]=1;
        }
        break;
      
    }
  }

  public void thread2386(int [] tdone, int [] ends){
        switch(S2166){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S2096){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 397, column: 11
              S2096=1;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 398, column: 13
              S2096=2;
              CMDfb_L.setPresent();//sysj\plant.sysj line: 400, column: 8
              currsigs.addElement(CMDfb_L);
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 399, column: 13
              S2096=3;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              CMDfb_L.setPresent();//sysj\plant.sysj line: 400, column: 8
              currsigs.addElement(CMDfb_L);
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 402, column: 11
              S2096=4;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 403, column: 13
              S2096=5;
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 405, column: 8
              currsigs.addElement(CMDfb_L2);
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 404, column: 13
              S2096=0;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 405, column: 8
              currsigs.addElement(CMDfb_L2);
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2383(int [] tdone, int [] ends){
        S2188=1;
    if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 426, column: 17
      s_thread_30 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 427, column: 10
      CMD_L2E.setPresent();//sysj\plant.sysj line: 429, column: 10
      currsigs.addElement(CMD_L2E);
      CMD_L2E.setValue(s_thread_30);//sysj\plant.sysj line: 429, column: 10
      S2180=0;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
    else {
      S2180=0;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
  }

  public void thread2382(int [] tdone, int [] ends){
        S2177=1;
    if(CMD_L.getprestatus()){//sysj\plant.sysj line: 412, column: 17
      s_thread_29 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 413, column: 10
      CMD_LE.setPresent();//sysj\plant.sysj line: 415, column: 10
      currsigs.addElement(CMD_LE);
      CMD_LE.setValue(s_thread_29);//sysj\plant.sysj line: 415, column: 10
      S2169=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S2169=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread2381(int [] tdone, int [] ends){
        S2190=1;
    thread2382(tdone,ends);
    thread2383(tdone,ends);
    int biggest2384 = 0;
    if(ends[29]>=biggest2384){
      biggest2384=ends[29];
    }
    if(ends[30]>=biggest2384){
      biggest2384=ends[30];
    }
    if(biggest2384 == 1){
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread2380(int [] tdone, int [] ends){
        S2166=1;
    S2096=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2326){
        case 0 : 
          S2326=0;
          break RUN;
        
        case 1 : 
          S2326=2;
          S2326=2;
          System.out.println("Baxter robot Plant started");//sysj\plant.sysj line: 391, column: 3
          S2289=0;
          thread2380(tdone,ends);
          thread2381(tdone,ends);
          int biggest2385 = 0;
          if(ends[27]>=biggest2385){
            biggest2385=ends[27];
          }
          if(ends[28]>=biggest2385){
            biggest2385=ends[28];
          }
          if(biggest2385 == 1){
            active[26]=1;
            ends[26]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S2289){
            case 0 : 
              thread2386(tdone,ends);
              thread2387(tdone,ends);
              int biggest2391 = 0;
              if(ends[27]>=biggest2391){
                biggest2391=ends[27];
              }
              if(ends[28]>=biggest2391){
                biggest2391=ends[28];
              }
              if(biggest2391 == 1){
                active[26]=1;
                ends[26]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2391 == 0){
                S2289=1;
                S2291=0;
                active[26]=1;
                ends[26]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S2291){
                case 0 : 
                  if(CMD_R.getprestatus()){//sysj\plant.sysj line: 444, column: 13
                    s_thread_26 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\plant.sysj line: 445, column: 7
                    S2291=1;
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                  else {
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(enable.getprestatus()){//sysj\plant.sysj line: 447, column: 13
                    S2291=2;
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                  else {
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 448, column: 13
                    CMDfb_R.setPresent();//sysj\plant.sysj line: 449, column: 7
                    currsigs.addElement(CMDfb_R);
                    S2291=0;
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                  else {
                    active[26]=1;
                    ends[26]=1;
                    break RUN;
                  }
                
              }
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[26] != 0){
      int index = 26;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[26]!=0 || suspended[26]!=0 || active[26]!=1);
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
      if(paused[26]!=0 || suspended[26]!=0 || active[26]!=1);
      else{
        CMD_L.gethook();
        CMD_L2.gethook();
        CMD_R.gethook();
        CMD_R2.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[26] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
