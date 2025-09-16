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
  private String s_thread_5;//sysj\robotPlant.sysj line: 52, column: 10
  private String s_thread_6;//sysj\robotPlant.sysj line: 65, column: 10
  private String s_thread_7;//sysj\robotPlant.sysj line: 78, column: 10
  private String s_thread_8;//sysj\robotPlant.sysj line: 89, column: 10
  private int S7838 = 1;
  private int S7474 = 1;
  private int S7404 = 1;
  private int S7548 = 1;
  private int S7478 = 1;
  private int S7618 = 1;
  private int S7565 = 1;
  private int S7553 = 1;
  private int S7582 = 1;
  private int S7570 = 1;
  private int S7599 = 1;
  private int S7587 = 1;
  private int S7616 = 1;
  private int S7604 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread7855(int [] tdone, int [] ends){
        switch(S7616){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S7604){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 92, column: 16
              S7604=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            S7604=1;
            S7604=0;
            if(CMD_R2.getprestatus()){//sysj\robotPlant.sysj line: 88, column: 17
              s_thread_8 = (String)(CMD_R2.getpreval() == null ? null : ((String)CMD_R2.getpreval()));//sysj\robotPlant.sysj line: 89, column: 10
              System.err.println("[PLANT R2] got: " + s_thread_8);//sysj\robotPlant.sysj line: 90, column: 10
              CMD_R2E.setPresent();//sysj\robotPlant.sysj line: 91, column: 10
              currsigs.addElement(CMD_R2E);
              CMD_R2E.setValue(s_thread_8);//sysj\robotPlant.sysj line: 91, column: 10
              System.out.println("Emitted CMD_R2E");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S7604=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7854(int [] tdone, int [] ends){
        switch(S7599){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S7587){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 81, column: 16
              S7587=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            S7587=1;
            S7587=0;
            if(CMD_R.getprestatus()){//sysj\robotPlant.sysj line: 77, column: 17
              s_thread_7 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\robotPlant.sysj line: 78, column: 10
              System.err.println("[PLANT R] got: " + s_thread_7);//sysj\robotPlant.sysj line: 79, column: 10
              CMD_RE.setPresent();//sysj\robotPlant.sysj line: 80, column: 10
              currsigs.addElement(CMD_RE);
              CMD_RE.setValue(s_thread_7);//sysj\robotPlant.sysj line: 80, column: 10
              System.out.println("Emitted CMD_RE");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S7587=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7853(int [] tdone, int [] ends){
        switch(S7582){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S7570){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 68, column: 16
              S7570=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S7570=1;
            S7570=0;
            if(CMD_L2.getprestatus()){//sysj\robotPlant.sysj line: 64, column: 17
              s_thread_6 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\robotPlant.sysj line: 65, column: 10
              System.err.println("[PLANT L2] got: " + s_thread_6);//sysj\robotPlant.sysj line: 66, column: 10
              CMD_L2E.setPresent();//sysj\robotPlant.sysj line: 67, column: 10
              currsigs.addElement(CMD_L2E);
              CMD_L2E.setValue(s_thread_6);//sysj\robotPlant.sysj line: 67, column: 10
              System.out.println("Emitted CMD_L2E");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S7570=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7852(int [] tdone, int [] ends){
        switch(S7565){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S7553){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 55, column: 16
              S7553=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S7553=1;
            S7553=0;
            if(CMD_L.getprestatus()){//sysj\robotPlant.sysj line: 51, column: 17
              s_thread_5 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\robotPlant.sysj line: 52, column: 10
              System.err.println("[PLANT L] got: " + s_thread_5);//sysj\robotPlant.sysj line: 53, column: 10
              CMD_LE.setPresent();//sysj\robotPlant.sysj line: 54, column: 10
              currsigs.addElement(CMD_LE);
              CMD_LE.setValue(s_thread_5);//sysj\robotPlant.sysj line: 54, column: 10
              System.out.println("Emitted CMD_LE");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S7553=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7851(int [] tdone, int [] ends){
        switch(S7618){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread7852(tdone,ends);
        thread7853(tdone,ends);
        thread7854(tdone,ends);
        thread7855(tdone,ends);
        int biggest7856 = 0;
        if(ends[5]>=biggest7856){
          biggest7856=ends[5];
        }
        if(ends[6]>=biggest7856){
          biggest7856=ends[6];
        }
        if(ends[7]>=biggest7856){
          biggest7856=ends[7];
        }
        if(ends[8]>=biggest7856){
          biggest7856=ends[8];
        }
        if(biggest7856 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest7856 == 0){
          S7618=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread7850(int [] tdone, int [] ends){
        switch(S7548){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S7478){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 33, column: 12
              S7478=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\robotPlant.sysj line: 34, column: 14
              S7478=2;
              CMDfb_R.setPresent();//sysj\robotPlant.sysj line: 36, column: 9
              currsigs.addElement(CMDfb_R);
              System.out.println("Emitted CMDfb_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\robotPlant.sysj line: 35, column: 14
              S7478=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMDfb_R.setPresent();//sysj\robotPlant.sysj line: 36, column: 9
              currsigs.addElement(CMDfb_R);
              System.out.println("Emitted CMDfb_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 38, column: 12
              S7478=4;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\robotPlant.sysj line: 39, column: 14
              S7478=5;
              CMDfb_R2.setPresent();//sysj\robotPlant.sysj line: 41, column: 9
              currsigs.addElement(CMDfb_R2);
              System.out.println("Emitted CMDfb_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\robotPlant.sysj line: 40, column: 14
              S7478=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMDfb_R2.setPresent();//sysj\robotPlant.sysj line: 41, column: 9
              currsigs.addElement(CMDfb_R2);
              System.out.println("Emitted CMDfb_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7849(int [] tdone, int [] ends){
        switch(S7474){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S7404){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 15, column: 11
              S7404=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\robotPlant.sysj line: 16, column: 13
              S7404=2;
              CMDfb_L.setPresent();//sysj\robotPlant.sysj line: 18, column: 8
              currsigs.addElement(CMDfb_L);
              System.out.println("Emitted CMDfb_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\robotPlant.sysj line: 17, column: 13
              S7404=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMDfb_L.setPresent();//sysj\robotPlant.sysj line: 18, column: 8
              currsigs.addElement(CMDfb_L);
              System.out.println("Emitted CMDfb_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 20, column: 11
              S7404=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\robotPlant.sysj line: 21, column: 13
              S7404=5;
              CMDfb_L2.setPresent();//sysj\robotPlant.sysj line: 23, column: 8
              currsigs.addElement(CMDfb_L2);
              System.out.println("Emitted CMDfb_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\robotPlant.sysj line: 22, column: 13
              S7404=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMDfb_L2.setPresent();//sysj\robotPlant.sysj line: 23, column: 8
              currsigs.addElement(CMDfb_L2);
              System.out.println("Emitted CMDfb_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7846(int [] tdone, int [] ends){
        S7616=1;
    S7604=0;
    if(CMD_R2.getprestatus()){//sysj\robotPlant.sysj line: 88, column: 17
      s_thread_8 = (String)(CMD_R2.getpreval() == null ? null : ((String)CMD_R2.getpreval()));//sysj\robotPlant.sysj line: 89, column: 10
      System.err.println("[PLANT R2] got: " + s_thread_8);//sysj\robotPlant.sysj line: 90, column: 10
      CMD_R2E.setPresent();//sysj\robotPlant.sysj line: 91, column: 10
      currsigs.addElement(CMD_R2E);
      CMD_R2E.setValue(s_thread_8);//sysj\robotPlant.sysj line: 91, column: 10
      System.out.println("Emitted CMD_R2E");
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S7604=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread7845(int [] tdone, int [] ends){
        S7599=1;
    S7587=0;
    if(CMD_R.getprestatus()){//sysj\robotPlant.sysj line: 77, column: 17
      s_thread_7 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\robotPlant.sysj line: 78, column: 10
      System.err.println("[PLANT R] got: " + s_thread_7);//sysj\robotPlant.sysj line: 79, column: 10
      CMD_RE.setPresent();//sysj\robotPlant.sysj line: 80, column: 10
      currsigs.addElement(CMD_RE);
      CMD_RE.setValue(s_thread_7);//sysj\robotPlant.sysj line: 80, column: 10
      System.out.println("Emitted CMD_RE");
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S7587=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread7844(int [] tdone, int [] ends){
        S7582=1;
    S7570=0;
    if(CMD_L2.getprestatus()){//sysj\robotPlant.sysj line: 64, column: 17
      s_thread_6 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\robotPlant.sysj line: 65, column: 10
      System.err.println("[PLANT L2] got: " + s_thread_6);//sysj\robotPlant.sysj line: 66, column: 10
      CMD_L2E.setPresent();//sysj\robotPlant.sysj line: 67, column: 10
      currsigs.addElement(CMD_L2E);
      CMD_L2E.setValue(s_thread_6);//sysj\robotPlant.sysj line: 67, column: 10
      System.out.println("Emitted CMD_L2E");
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S7570=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread7843(int [] tdone, int [] ends){
        S7565=1;
    S7553=0;
    if(CMD_L.getprestatus()){//sysj\robotPlant.sysj line: 51, column: 17
      s_thread_5 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\robotPlant.sysj line: 52, column: 10
      System.err.println("[PLANT L] got: " + s_thread_5);//sysj\robotPlant.sysj line: 53, column: 10
      CMD_LE.setPresent();//sysj\robotPlant.sysj line: 54, column: 10
      currsigs.addElement(CMD_LE);
      CMD_LE.setValue(s_thread_5);//sysj\robotPlant.sysj line: 54, column: 10
      System.out.println("Emitted CMD_LE");
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S7553=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread7842(int [] tdone, int [] ends){
        S7618=1;
    thread7843(tdone,ends);
    thread7844(tdone,ends);
    thread7845(tdone,ends);
    thread7846(tdone,ends);
    int biggest7847 = 0;
    if(ends[5]>=biggest7847){
      biggest7847=ends[5];
    }
    if(ends[6]>=biggest7847){
      biggest7847=ends[6];
    }
    if(ends[7]>=biggest7847){
      biggest7847=ends[7];
    }
    if(ends[8]>=biggest7847){
      biggest7847=ends[8];
    }
    if(biggest7847 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread7841(int [] tdone, int [] ends){
        S7548=1;
    S7478=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7840(int [] tdone, int [] ends){
        S7474=1;
    S7404=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S7838){
        case 0 : 
          S7838=0;
          break RUN;
        
        case 1 : 
          S7838=2;
          S7838=2;
          System.out.println("Baxter robot Plant started");//sysj\robotPlant.sysj line: 9, column: 3
          thread7840(tdone,ends);
          thread7841(tdone,ends);
          thread7842(tdone,ends);
          int biggest7848 = 0;
          if(ends[2]>=biggest7848){
            biggest7848=ends[2];
          }
          if(ends[3]>=biggest7848){
            biggest7848=ends[3];
          }
          if(ends[4]>=biggest7848){
            biggest7848=ends[4];
          }
          if(biggest7848 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread7849(tdone,ends);
          thread7850(tdone,ends);
          thread7851(tdone,ends);
          int biggest7857 = 0;
          if(ends[2]>=biggest7857){
            biggest7857=ends[2];
          }
          if(ends[3]>=biggest7857){
            biggest7857=ends[3];
          }
          if(ends[4]>=biggest7857){
            biggest7857=ends[4];
          }
          if(biggest7857 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7857 == 0){
            S7838=0;
            active[1]=0;
            ends[1]=0;
            S7838=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
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
