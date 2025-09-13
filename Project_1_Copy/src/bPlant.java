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
  private String s_thread_28;//sysj\plant.sysj line: 406, column: 10
  private String s_thread_29;//sysj\plant.sysj line: 420, column: 10
  private String s_thread_25;//sysj\plant.sysj line: 438, column: 7
  private int S2361 = 1;
  private int S2324 = 1;
  private int S2201 = 1;
  private int S2131 = 1;
  private int S2225 = 1;
  private int S2212 = 1;
  private int S2204 = 1;
  private int S2223 = 1;
  private int S2215 = 1;
  private int S2326 = 1;
  
  private int[] ends = new int[30];
  private int[] tdone = new int[30];
  
  public void thread2422(int [] tdone, int [] ends){
        switch(S2223){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S2215){
          case 0 : 
            S2215=0;
            S2215=1;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 1 : 
            S2215=1;
            S2215=2;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 2 : 
            S2215=2;
            S2215=3;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 3 : 
            S2215=3;
            S2215=4;
            active[29]=1;
            ends[29]=1;
            tdone[29]=1;
            break;
          
          case 4 : 
            S2215=4;
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 419, column: 17
              s_thread_29 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 420, column: 10
              System.err.println("[PLANT L2] got: " + s_thread_29);//sysj\plant.sysj line: 421, column: 10
              CMD_L2E.setPresent();//sysj\plant.sysj line: 422, column: 10
              currsigs.addElement(CMD_L2E);
              CMD_L2E.setValue(s_thread_29);//sysj\plant.sysj line: 422, column: 10
              S2215=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S2215=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2421(int [] tdone, int [] ends){
        switch(S2212){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S2204){
          case 0 : 
            S2204=0;
            S2204=1;
            active[28]=1;
            ends[28]=1;
            tdone[28]=1;
            break;
          
          case 1 : 
            S2204=1;
            S2204=2;
            active[28]=1;
            ends[28]=1;
            tdone[28]=1;
            break;
          
          case 2 : 
            S2204=2;
            S2204=3;
            active[28]=1;
            ends[28]=1;
            tdone[28]=1;
            break;
          
          case 3 : 
            S2204=3;
            S2204=4;
            active[28]=1;
            ends[28]=1;
            tdone[28]=1;
            break;
          
          case 4 : 
            S2204=4;
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 405, column: 17
              s_thread_28 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 406, column: 10
              System.err.println("[PLANT L] got: " + s_thread_28);//sysj\plant.sysj line: 407, column: 10
              CMD_LE.setPresent();//sysj\plant.sysj line: 408, column: 10
              currsigs.addElement(CMD_LE);
              CMD_LE.setValue(s_thread_28);//sysj\plant.sysj line: 408, column: 10
              S2204=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S2204=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2420(int [] tdone, int [] ends){
        switch(S2225){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        thread2421(tdone,ends);
        thread2422(tdone,ends);
        int biggest2423 = 0;
        if(ends[28]>=biggest2423){
          biggest2423=ends[28];
        }
        if(ends[29]>=biggest2423){
          biggest2423=ends[29];
        }
        if(biggest2423 == 1){
          active[27]=1;
          ends[27]=1;
          tdone[27]=1;
        }
        //FINXME code
        if(biggest2423 == 0){
          S2225=0;
          active[27]=0;
          ends[27]=0;
          tdone[27]=1;
        }
        break;
      
    }
  }

  public void thread2419(int [] tdone, int [] ends){
        switch(S2201){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S2131){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 390, column: 11
              S2131=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 391, column: 13
              S2131=2;
              CMDfb_L.setPresent();//sysj\plant.sysj line: 393, column: 8
              currsigs.addElement(CMDfb_L);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 392, column: 13
              S2131=3;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              CMDfb_L.setPresent();//sysj\plant.sysj line: 393, column: 8
              currsigs.addElement(CMDfb_L);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 395, column: 11
              S2131=4;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 396, column: 13
              S2131=5;
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 398, column: 8
              currsigs.addElement(CMDfb_L2);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 397, column: 13
              S2131=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 398, column: 8
              currsigs.addElement(CMDfb_L2);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2416(int [] tdone, int [] ends){
        S2223=1;
    if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 419, column: 17
      s_thread_29 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 420, column: 10
      System.err.println("[PLANT L2] got: " + s_thread_29);//sysj\plant.sysj line: 421, column: 10
      CMD_L2E.setPresent();//sysj\plant.sysj line: 422, column: 10
      currsigs.addElement(CMD_L2E);
      CMD_L2E.setValue(s_thread_29);//sysj\plant.sysj line: 422, column: 10
      S2215=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S2215=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread2415(int [] tdone, int [] ends){
        S2212=1;
    if(CMD_L.getprestatus()){//sysj\plant.sysj line: 405, column: 17
      s_thread_28 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 406, column: 10
      System.err.println("[PLANT L] got: " + s_thread_28);//sysj\plant.sysj line: 407, column: 10
      CMD_LE.setPresent();//sysj\plant.sysj line: 408, column: 10
      currsigs.addElement(CMD_LE);
      CMD_LE.setValue(s_thread_28);//sysj\plant.sysj line: 408, column: 10
      S2204=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S2204=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread2414(int [] tdone, int [] ends){
        S2225=1;
    thread2415(tdone,ends);
    thread2416(tdone,ends);
    int biggest2417 = 0;
    if(ends[28]>=biggest2417){
      biggest2417=ends[28];
    }
    if(ends[29]>=biggest2417){
      biggest2417=ends[29];
    }
    if(biggest2417 == 1){
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread2413(int [] tdone, int [] ends){
        S2201=1;
    S2131=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2361){
        case 0 : 
          S2361=0;
          break RUN;
        
        case 1 : 
          S2361=2;
          S2361=2;
          System.out.println("Baxter robot Plant started");//sysj\plant.sysj line: 384, column: 3
          S2324=0;
          thread2413(tdone,ends);
          thread2414(tdone,ends);
          int biggest2418 = 0;
          if(ends[26]>=biggest2418){
            biggest2418=ends[26];
          }
          if(ends[27]>=biggest2418){
            biggest2418=ends[27];
          }
          if(biggest2418 == 1){
            active[25]=1;
            ends[25]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S2324){
            case 0 : 
              thread2419(tdone,ends);
              thread2420(tdone,ends);
              int biggest2424 = 0;
              if(ends[26]>=biggest2424){
                biggest2424=ends[26];
              }
              if(ends[27]>=biggest2424){
                biggest2424=ends[27];
              }
              if(biggest2424 == 1){
                active[25]=1;
                ends[25]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2424 == 0){
                S2324=1;
                S2326=0;
                active[25]=1;
                ends[25]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S2326){
                case 0 : 
                  if(CMD_R.getprestatus()){//sysj\plant.sysj line: 437, column: 13
                    s_thread_25 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\plant.sysj line: 438, column: 7
                    System.err.println("[PLANT R] got: !!!!!!!!!!!!!!!" + s_thread_25);//sysj\plant.sysj line: 439, column: 7
                    S2326=1;
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                  else {
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(enable.getprestatus()){//sysj\plant.sysj line: 440, column: 13
                    S2326=2;
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                  else {
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 441, column: 13
                    CMDfb_R.setPresent();//sysj\plant.sysj line: 442, column: 7
                    currsigs.addElement(CMDfb_R);
                    S2326=0;
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                  else {
                    active[25]=1;
                    ends[25]=1;
                    break RUN;
                  }
                
              }
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[25] != 0){
      int index = 25;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[25]!=0 || suspended[25]!=0 || active[25]!=1);
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
      if(paused[25]!=0 || suspended[25]!=0 || active[25]!=1);
      else{
        CMD_L.gethook();
        CMD_L2.gethook();
        CMD_R.gethook();
        CMD_R2.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[25] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
