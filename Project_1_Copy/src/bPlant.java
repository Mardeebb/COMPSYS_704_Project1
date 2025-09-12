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
  private String s_thread_20;//sysj\plant.sysj line: 350, column: 10
  private String s_thread_21;//sysj\plant.sysj line: 366, column: 10
  private String s_thread_17;//sysj\plant.sysj line: 384, column: 7
  private int S1686 = 1;
  private int S1649 = 1;
  private int S1526 = 1;
  private int S1456 = 1;
  private int S1550 = 1;
  private int S1537 = 1;
  private int S1529 = 1;
  private int S1548 = 1;
  private int S1540 = 1;
  private int S1651 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread1729(int [] tdone, int [] ends){
        switch(S1548){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1540){
          case 0 : 
            S1540=0;
            S1540=1;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 1 : 
            S1540=1;
            S1540=2;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 2 : 
            S1540=2;
            S1540=3;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 3 : 
            S1540=3;
            S1540=4;
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 4 : 
            S1540=4;
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 365, column: 17
              s_thread_21 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 366, column: 10
              System.err.println("[PLANT L2] got: " + s_thread_21);//sysj\plant.sysj line: 367, column: 10
              CMD_L2E.setPresent();//sysj\plant.sysj line: 368, column: 10
              currsigs.addElement(CMD_L2E);
              CMD_L2E.setValue(s_thread_21);//sysj\plant.sysj line: 368, column: 10
              System.out.println("Emitted CMD_L2E");
              S1540=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S1540=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1728(int [] tdone, int [] ends){
        switch(S1537){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S1529){
          case 0 : 
            S1529=0;
            S1529=1;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 1 : 
            S1529=1;
            S1529=2;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 2 : 
            S1529=2;
            S1529=3;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 3 : 
            S1529=3;
            S1529=4;
            active[20]=1;
            ends[20]=1;
            tdone[20]=1;
            break;
          
          case 4 : 
            S1529=4;
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 349, column: 17
              s_thread_20 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 350, column: 10
              System.err.println("[PLANT L] got: " + s_thread_20);//sysj\plant.sysj line: 351, column: 10
              CMD_LE.setPresent();//sysj\plant.sysj line: 352, column: 10
              currsigs.addElement(CMD_LE);
              CMD_LE.setValue(s_thread_20);//sysj\plant.sysj line: 352, column: 10
              System.out.println("Emitted CMD_LE");
              S1529=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S1529=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1727(int [] tdone, int [] ends){
        switch(S1550){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        thread1728(tdone,ends);
        thread1729(tdone,ends);
        int biggest1730 = 0;
        if(ends[20]>=biggest1730){
          biggest1730=ends[20];
        }
        if(ends[21]>=biggest1730){
          biggest1730=ends[21];
        }
        if(biggest1730 == 1){
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
        //FINXME code
        if(biggest1730 == 0){
          S1550=0;
          active[19]=0;
          ends[19]=0;
          tdone[19]=1;
        }
        break;
      
    }
  }

  public void thread1726(int [] tdone, int [] ends){
        switch(S1526){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1456){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 334, column: 11
              S1456=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 335, column: 13
              S1456=2;
              CMDfb_L.setPresent();//sysj\plant.sysj line: 337, column: 8
              currsigs.addElement(CMDfb_L);
              System.out.println("Emitted CMDfb_L");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 336, column: 13
              S1456=3;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              CMDfb_L.setPresent();//sysj\plant.sysj line: 337, column: 8
              currsigs.addElement(CMDfb_L);
              System.out.println("Emitted CMDfb_L");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 339, column: 11
              S1456=4;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 340, column: 13
              S1456=5;
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 342, column: 8
              currsigs.addElement(CMDfb_L2);
              System.out.println("Emitted CMDfb_L2");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 341, column: 13
              S1456=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              CMDfb_L2.setPresent();//sysj\plant.sysj line: 342, column: 8
              currsigs.addElement(CMDfb_L2);
              System.out.println("Emitted CMDfb_L2");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1723(int [] tdone, int [] ends){
        S1548=1;
    if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 365, column: 17
      s_thread_21 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 366, column: 10
      System.err.println("[PLANT L2] got: " + s_thread_21);//sysj\plant.sysj line: 367, column: 10
      CMD_L2E.setPresent();//sysj\plant.sysj line: 368, column: 10
      currsigs.addElement(CMD_L2E);
      CMD_L2E.setValue(s_thread_21);//sysj\plant.sysj line: 368, column: 10
      System.out.println("Emitted CMD_L2E");
      S1540=0;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1540=0;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread1722(int [] tdone, int [] ends){
        S1537=1;
    if(CMD_L.getprestatus()){//sysj\plant.sysj line: 349, column: 17
      s_thread_20 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 350, column: 10
      System.err.println("[PLANT L] got: " + s_thread_20);//sysj\plant.sysj line: 351, column: 10
      CMD_LE.setPresent();//sysj\plant.sysj line: 352, column: 10
      currsigs.addElement(CMD_LE);
      CMD_LE.setValue(s_thread_20);//sysj\plant.sysj line: 352, column: 10
      System.out.println("Emitted CMD_LE");
      S1529=0;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
    else {
      S1529=0;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread1721(int [] tdone, int [] ends){
        S1550=1;
    thread1722(tdone,ends);
    thread1723(tdone,ends);
    int biggest1724 = 0;
    if(ends[20]>=biggest1724){
      biggest1724=ends[20];
    }
    if(ends[21]>=biggest1724){
      biggest1724=ends[21];
    }
    if(biggest1724 == 1){
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread1720(int [] tdone, int [] ends){
        S1526=1;
    S1456=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1686){
        case 0 : 
          S1686=0;
          break RUN;
        
        case 1 : 
          S1686=2;
          S1686=2;
          System.out.println("Baxter robot Plant started");//sysj\plant.sysj line: 328, column: 3
          S1649=0;
          thread1720(tdone,ends);
          thread1721(tdone,ends);
          int biggest1725 = 0;
          if(ends[18]>=biggest1725){
            biggest1725=ends[18];
          }
          if(ends[19]>=biggest1725){
            biggest1725=ends[19];
          }
          if(biggest1725 == 1){
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S1649){
            case 0 : 
              thread1726(tdone,ends);
              thread1727(tdone,ends);
              int biggest1731 = 0;
              if(ends[18]>=biggest1731){
                biggest1731=ends[18];
              }
              if(ends[19]>=biggest1731){
                biggest1731=ends[19];
              }
              if(biggest1731 == 1){
                active[17]=1;
                ends[17]=1;
                break RUN;
              }
              //FINXME code
              if(biggest1731 == 0){
                S1649=1;
                S1651=0;
                active[17]=1;
                ends[17]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S1651){
                case 0 : 
                  if(CMD_R.getprestatus()){//sysj\plant.sysj line: 383, column: 13
                    s_thread_17 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\plant.sysj line: 384, column: 7
                    System.err.println("[PLANT R] got: !!!!!!!!!!!!!!!" + s_thread_17);//sysj\plant.sysj line: 385, column: 7
                    S1651=1;
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  else {
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(enable.getprestatus()){//sysj\plant.sysj line: 386, column: 13
                    S1651=2;
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  else {
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 387, column: 13
                    CMDfb_R.setPresent();//sysj\plant.sysj line: 388, column: 7
                    currsigs.addElement(CMDfb_R);
                    System.out.println("Emitted CMDfb_R");
                    S1651=0;
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  else {
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
              }
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[17] != 0){
      int index = 17;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
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
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
      else{
        CMD_L.gethook();
        CMD_L2.gethook();
        CMD_R.gethook();
        CMD_R2.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[17] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
