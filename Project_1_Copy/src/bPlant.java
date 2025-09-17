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
  private int S6405 = 1;
  private int S6041 = 1;
  private int S5971 = 1;
  private int S6115 = 1;
  private int S6045 = 1;
  private int S6185 = 1;
  private int S6132 = 1;
  private int S6120 = 1;
  private int S6149 = 1;
  private int S6137 = 1;
  private int S6166 = 1;
  private int S6154 = 1;
  private int S6183 = 1;
  private int S6171 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread6422(int [] tdone, int [] ends){
        switch(S6183){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S6171){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 92, column: 16
              S6171=1;
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
            S6171=1;
            S6171=0;
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
              S6171=1;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6421(int [] tdone, int [] ends){
        switch(S6166){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S6154){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 81, column: 16
              S6154=1;
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
            S6154=1;
            S6154=0;
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
              S6154=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6420(int [] tdone, int [] ends){
        switch(S6149){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S6137){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 68, column: 16
              S6137=1;
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
            S6137=1;
            S6137=0;
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
              S6137=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6419(int [] tdone, int [] ends){
        switch(S6132){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S6120){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 55, column: 16
              S6120=1;
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
            S6120=1;
            S6120=0;
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
              S6120=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread6418(int [] tdone, int [] ends){
        switch(S6185){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread6419(tdone,ends);
        thread6420(tdone,ends);
        thread6421(tdone,ends);
        thread6422(tdone,ends);
        int biggest6423 = 0;
        if(ends[5]>=biggest6423){
          biggest6423=ends[5];
        }
        if(ends[6]>=biggest6423){
          biggest6423=ends[6];
        }
        if(ends[7]>=biggest6423){
          biggest6423=ends[7];
        }
        if(ends[8]>=biggest6423){
          biggest6423=ends[8];
        }
        if(biggest6423 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest6423 == 0){
          S6185=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread6417(int [] tdone, int [] ends){
        switch(S6115){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S6045){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 33, column: 12
              S6045=1;
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
              S6045=2;
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
            if(CMD_R2.getprestatus()){//sysj\robotPlant.sysj line: 35, column: 14
              S6045=3;
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
              S6045=4;
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
              S6045=5;
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
            if(CMD_R.getprestatus()){//sysj\robotPlant.sysj line: 40, column: 14
              S6045=0;
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

  public void thread6416(int [] tdone, int [] ends){
        switch(S6041){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S5971){
          case 0 : 
            if(enable.getprestatus()){//sysj\robotPlant.sysj line: 15, column: 11
              S5971=1;
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
              S5971=2;
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
              S5971=3;
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
              S5971=4;
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
              S5971=5;
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
              S5971=0;
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

  public void thread6413(int [] tdone, int [] ends){
        S6183=1;
    S6171=0;
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
      S6171=1;
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread6412(int [] tdone, int [] ends){
        S6166=1;
    S6154=0;
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
      S6154=1;
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread6411(int [] tdone, int [] ends){
        S6149=1;
    S6137=0;
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
      S6137=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread6410(int [] tdone, int [] ends){
        S6132=1;
    S6120=0;
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
      S6120=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread6409(int [] tdone, int [] ends){
        S6185=1;
    thread6410(tdone,ends);
    thread6411(tdone,ends);
    thread6412(tdone,ends);
    thread6413(tdone,ends);
    int biggest6414 = 0;
    if(ends[5]>=biggest6414){
      biggest6414=ends[5];
    }
    if(ends[6]>=biggest6414){
      biggest6414=ends[6];
    }
    if(ends[7]>=biggest6414){
      biggest6414=ends[7];
    }
    if(ends[8]>=biggest6414){
      biggest6414=ends[8];
    }
    if(biggest6414 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread6408(int [] tdone, int [] ends){
        S6115=1;
    S6045=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread6407(int [] tdone, int [] ends){
        S6041=1;
    S5971=0;
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
      switch(S6405){
        case 0 : 
          S6405=0;
          break RUN;
        
        case 1 : 
          S6405=2;
          S6405=2;
          System.out.println("Baxter robot Plant started");//sysj\robotPlant.sysj line: 9, column: 3
          thread6407(tdone,ends);
          thread6408(tdone,ends);
          thread6409(tdone,ends);
          int biggest6415 = 0;
          if(ends[2]>=biggest6415){
            biggest6415=ends[2];
          }
          if(ends[3]>=biggest6415){
            biggest6415=ends[3];
          }
          if(ends[4]>=biggest6415){
            biggest6415=ends[4];
          }
          if(biggest6415 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread6416(tdone,ends);
          thread6417(tdone,ends);
          thread6418(tdone,ends);
          int biggest6424 = 0;
          if(ends[2]>=biggest6424){
            biggest6424=ends[2];
          }
          if(ends[3]>=biggest6424){
            biggest6424=ends[3];
          }
          if(ends[4]>=biggest6424){
            biggest6424=ends[4];
          }
          if(biggest6424 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest6424 == 0){
            S6405=0;
            active[1]=0;
            ends[1]=0;
            S6405=0;
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
