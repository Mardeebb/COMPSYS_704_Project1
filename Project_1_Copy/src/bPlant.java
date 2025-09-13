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
  private String s_thread_21;//sysj\plant.sysj line: 371, column: 10
  private String s_thread_22;//sysj\plant.sysj line: 384, column: 10
  private String s_thread_23;//sysj\plant.sysj line: 397, column: 10
  private String s_thread_24;//sysj\plant.sysj line: 408, column: 10
  private int S1890 = 1;
  private int S1526 = 1;
  private int S1456 = 1;
  private int S1600 = 1;
  private int S1530 = 1;
  private int S1670 = 1;
  private int S1617 = 1;
  private int S1605 = 1;
  private int S1634 = 1;
  private int S1622 = 1;
  private int S1651 = 1;
  private int S1639 = 1;
  private int S1668 = 1;
  private int S1656 = 1;
  
  private int[] ends = new int[25];
  private int[] tdone = new int[25];
  
  public void thread1939(int [] tdone, int [] ends){
        switch(S1668){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S1656){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 411, column: 16
              S1656=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            S1656=1;
            S1656=0;
            if(CMD_R2.getprestatus()){//sysj\plant.sysj line: 407, column: 17
              s_thread_24 = (String)(CMD_R2.getpreval() == null ? null : ((String)CMD_R2.getpreval()));//sysj\plant.sysj line: 408, column: 10
              System.err.println("[PLANT R2] got: " + s_thread_24);//sysj\plant.sysj line: 409, column: 10
              CMD_R2E.setPresent();//sysj\plant.sysj line: 410, column: 10
              currsigs.addElement(CMD_R2E);
              CMD_R2E.setValue(s_thread_24);//sysj\plant.sysj line: 410, column: 10
              System.out.println("Emitted CMD_R2E");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S1656=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1938(int [] tdone, int [] ends){
        switch(S1651){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S1639){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 400, column: 16
              S1639=1;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            S1639=1;
            S1639=0;
            if(CMD_R.getprestatus()){//sysj\plant.sysj line: 396, column: 17
              s_thread_23 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\plant.sysj line: 397, column: 10
              System.err.println("[PLANT R] got: " + s_thread_23);//sysj\plant.sysj line: 398, column: 10
              CMD_RE.setPresent();//sysj\plant.sysj line: 399, column: 10
              currsigs.addElement(CMD_RE);
              CMD_RE.setValue(s_thread_23);//sysj\plant.sysj line: 399, column: 10
              System.out.println("Emitted CMD_RE");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S1639=1;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1937(int [] tdone, int [] ends){
        switch(S1634){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S1622){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 387, column: 16
              S1622=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            S1622=1;
            S1622=0;
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 383, column: 17
              s_thread_22 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 384, column: 10
              System.err.println("[PLANT L2] got: " + s_thread_22);//sysj\plant.sysj line: 385, column: 10
              CMD_L2E.setPresent();//sysj\plant.sysj line: 386, column: 10
              currsigs.addElement(CMD_L2E);
              CMD_L2E.setValue(s_thread_22);//sysj\plant.sysj line: 386, column: 10
              System.out.println("Emitted CMD_L2E");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S1622=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1936(int [] tdone, int [] ends){
        switch(S1617){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1605){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 16
              S1605=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            S1605=1;
            S1605=0;
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 370, column: 17
              s_thread_21 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 371, column: 10
              System.err.println("[PLANT L] got: " + s_thread_21);//sysj\plant.sysj line: 372, column: 10
              CMD_LE.setPresent();//sysj\plant.sysj line: 373, column: 10
              currsigs.addElement(CMD_LE);
              CMD_LE.setValue(s_thread_21);//sysj\plant.sysj line: 373, column: 10
              System.out.println("Emitted CMD_LE");
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S1605=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1935(int [] tdone, int [] ends){
        switch(S1670){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        thread1936(tdone,ends);
        thread1937(tdone,ends);
        thread1938(tdone,ends);
        thread1939(tdone,ends);
        int biggest1940 = 0;
        if(ends[21]>=biggest1940){
          biggest1940=ends[21];
        }
        if(ends[22]>=biggest1940){
          biggest1940=ends[22];
        }
        if(ends[23]>=biggest1940){
          biggest1940=ends[23];
        }
        if(ends[24]>=biggest1940){
          biggest1940=ends[24];
        }
        if(biggest1940 == 1){
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        //FINXME code
        if(biggest1940 == 0){
          S1670=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread1934(int [] tdone, int [] ends){
        switch(S1600){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1530){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 352, column: 12
              S1530=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 353, column: 14
              S1530=2;
              CMDfb_R.setPresent();//sysj\plant.sysj line: 355, column: 9
              currsigs.addElement(CMDfb_R);
              System.out.println("Emitted CMDfb_R");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 2 : 
            if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 354, column: 14
              S1530=3;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMDfb_R.setPresent();//sysj\plant.sysj line: 355, column: 9
              currsigs.addElement(CMDfb_R);
              System.out.println("Emitted CMDfb_R");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 3 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 357, column: 12
              S1530=4;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 4 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 358, column: 14
              S1530=5;
              CMDfb_R2.setPresent();//sysj\plant.sysj line: 360, column: 9
              currsigs.addElement(CMDfb_R2);
              System.out.println("Emitted CMDfb_R2");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 5 : 
            if(CMD_L.getprestatus()){//sysj\plant.sysj line: 359, column: 14
              S1530=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMDfb_R2.setPresent();//sysj\plant.sysj line: 360, column: 9
              currsigs.addElement(CMDfb_R2);
              System.out.println("Emitted CMDfb_R2");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1933(int [] tdone, int [] ends){
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

  public void thread1930(int [] tdone, int [] ends){
        S1668=1;
    S1656=0;
    if(CMD_R2.getprestatus()){//sysj\plant.sysj line: 407, column: 17
      s_thread_24 = (String)(CMD_R2.getpreval() == null ? null : ((String)CMD_R2.getpreval()));//sysj\plant.sysj line: 408, column: 10
      System.err.println("[PLANT R2] got: " + s_thread_24);//sysj\plant.sysj line: 409, column: 10
      CMD_R2E.setPresent();//sysj\plant.sysj line: 410, column: 10
      currsigs.addElement(CMD_R2E);
      CMD_R2E.setValue(s_thread_24);//sysj\plant.sysj line: 410, column: 10
      System.out.println("Emitted CMD_R2E");
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      S1656=1;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread1929(int [] tdone, int [] ends){
        S1651=1;
    S1639=0;
    if(CMD_R.getprestatus()){//sysj\plant.sysj line: 396, column: 17
      s_thread_23 = (String)(CMD_R.getpreval() == null ? null : ((String)CMD_R.getpreval()));//sysj\plant.sysj line: 397, column: 10
      System.err.println("[PLANT R] got: " + s_thread_23);//sysj\plant.sysj line: 398, column: 10
      CMD_RE.setPresent();//sysj\plant.sysj line: 399, column: 10
      currsigs.addElement(CMD_RE);
      CMD_RE.setValue(s_thread_23);//sysj\plant.sysj line: 399, column: 10
      System.out.println("Emitted CMD_RE");
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
    else {
      S1639=1;
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread1928(int [] tdone, int [] ends){
        S1634=1;
    S1622=0;
    if(CMD_L2.getprestatus()){//sysj\plant.sysj line: 383, column: 17
      s_thread_22 = (String)(CMD_L2.getpreval() == null ? null : ((String)CMD_L2.getpreval()));//sysj\plant.sysj line: 384, column: 10
      System.err.println("[PLANT L2] got: " + s_thread_22);//sysj\plant.sysj line: 385, column: 10
      CMD_L2E.setPresent();//sysj\plant.sysj line: 386, column: 10
      currsigs.addElement(CMD_L2E);
      CMD_L2E.setValue(s_thread_22);//sysj\plant.sysj line: 386, column: 10
      System.out.println("Emitted CMD_L2E");
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
    else {
      S1622=1;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread1927(int [] tdone, int [] ends){
        S1617=1;
    S1605=0;
    if(CMD_L.getprestatus()){//sysj\plant.sysj line: 370, column: 17
      s_thread_21 = (String)(CMD_L.getpreval() == null ? null : ((String)CMD_L.getpreval()));//sysj\plant.sysj line: 371, column: 10
      System.err.println("[PLANT L] got: " + s_thread_21);//sysj\plant.sysj line: 372, column: 10
      CMD_LE.setPresent();//sysj\plant.sysj line: 373, column: 10
      currsigs.addElement(CMD_LE);
      CMD_LE.setValue(s_thread_21);//sysj\plant.sysj line: 373, column: 10
      System.out.println("Emitted CMD_LE");
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1605=1;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread1926(int [] tdone, int [] ends){
        S1670=1;
    thread1927(tdone,ends);
    thread1928(tdone,ends);
    thread1929(tdone,ends);
    thread1930(tdone,ends);
    int biggest1931 = 0;
    if(ends[21]>=biggest1931){
      biggest1931=ends[21];
    }
    if(ends[22]>=biggest1931){
      biggest1931=ends[22];
    }
    if(ends[23]>=biggest1931){
      biggest1931=ends[23];
    }
    if(ends[24]>=biggest1931){
      biggest1931=ends[24];
    }
    if(biggest1931 == 1){
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread1925(int [] tdone, int [] ends){
        S1600=1;
    S1530=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1924(int [] tdone, int [] ends){
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
      switch(S1890){
        case 0 : 
          S1890=0;
          break RUN;
        
        case 1 : 
          S1890=2;
          S1890=2;
          System.out.println("Baxter robot Plant started");//sysj\plant.sysj line: 328, column: 3
          thread1924(tdone,ends);
          thread1925(tdone,ends);
          thread1926(tdone,ends);
          int biggest1932 = 0;
          if(ends[18]>=biggest1932){
            biggest1932=ends[18];
          }
          if(ends[19]>=biggest1932){
            biggest1932=ends[19];
          }
          if(ends[20]>=biggest1932){
            biggest1932=ends[20];
          }
          if(biggest1932 == 1){
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
        
        case 2 : 
          thread1933(tdone,ends);
          thread1934(tdone,ends);
          thread1935(tdone,ends);
          int biggest1941 = 0;
          if(ends[18]>=biggest1941){
            biggest1941=ends[18];
          }
          if(ends[19]>=biggest1941){
            biggest1941=ends[19];
          }
          if(ends[20]>=biggest1941){
            biggest1941=ends[20];
          }
          if(biggest1941 == 1){
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1941 == 0){
            S1890=0;
            active[17]=0;
            ends[17]=0;
            S1890=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
