import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class fPlant extends ClockDomain{
  public fPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.INPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal dosUnitEvacE = new Signal("dosUnitEvacE", Signal.OUTPUT);
  public Signal dosUnitFilledE = new Signal("dosUnitFilledE", Signal.OUTPUT);
  private int S2080 = 1;
  private int S2007 = 1;
  private int S1985 = 1;
  private int S2060 = 1;
  private int S2014 = 1;
  private int S2078 = 1;
  private int S2068 = 1;
  private int S2076 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread2131(int [] tdone, int [] ends){
        switch(S2076){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 378, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 378, column: 45
          currsigs.addElement(dosUnitFilledE);
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        else {
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread2130(int [] tdone, int [] ends){
        switch(S2068){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 376, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 376, column: 43
          currsigs.addElement(dosUnitEvacE);
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
      
    }
  }

  public void thread2129(int [] tdone, int [] ends){
        switch(S2078){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        thread2130(tdone,ends);
        thread2131(tdone,ends);
        int biggest2132 = 0;
        if(ends[24]>=biggest2132){
          biggest2132=ends[24];
        }
        if(ends[25]>=biggest2132){
          biggest2132=ends[25];
        }
        if(biggest2132 == 1){
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        //FINXME code
        if(biggest2132 == 0){
          S2078=0;
          active[23]=0;
          ends[23]=0;
          tdone[23]=1;
        }
        break;
      
    }
  }

  public void thread2128(int [] tdone, int [] ends){
        switch(S2060){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S2014){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 360, column: 19
              S2014=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 361, column: 17
              currsigs.addElement(dosUnitEvac);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 363, column: 19
              S2014=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 367, column: 17
              currsigs.addElement(dosUnitFilled);
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
          
          case 2 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 366, column: 19
              S2014=3;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 367, column: 17
              currsigs.addElement(dosUnitFilled);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 369, column: 19
              S2014=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 361, column: 17
              currsigs.addElement(dosUnitEvac);
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
          
        }
        break;
      
    }
  }

  public void thread2127(int [] tdone, int [] ends){
        switch(S2007){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1985){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 347, column: 19
              S1985=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 349, column: 17
              currsigs.addElement(bottleAtPos2);
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 348, column: 19
              S1985=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 349, column: 17
              currsigs.addElement(bottleAtPos2);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2124(int [] tdone, int [] ends){
        S2076=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 378, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 378, column: 45
      currsigs.addElement(dosUnitFilledE);
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
    else {
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread2123(int [] tdone, int [] ends){
        S2068=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 376, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 376, column: 43
      currsigs.addElement(dosUnitEvacE);
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread2122(int [] tdone, int [] ends){
        S2078=1;
    thread2123(tdone,ends);
    thread2124(tdone,ends);
    int biggest2125 = 0;
    if(ends[24]>=biggest2125){
      biggest2125=ends[24];
    }
    if(ends[25]>=biggest2125){
      biggest2125=ends[25];
    }
    if(biggest2125 == 1){
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread2121(int [] tdone, int [] ends){
        S2060=1;
    S2014=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 361, column: 17
    currsigs.addElement(dosUnitEvac);
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread2120(int [] tdone, int [] ends){
        S2007=1;
    S1985=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2080){
        case 0 : 
          S2080=0;
          break RUN;
        
        case 1 : 
          S2080=2;
          S2080=2;
          thread2120(tdone,ends);
          thread2121(tdone,ends);
          thread2122(tdone,ends);
          int biggest2126 = 0;
          if(ends[21]>=biggest2126){
            biggest2126=ends[21];
          }
          if(ends[22]>=biggest2126){
            biggest2126=ends[22];
          }
          if(ends[23]>=biggest2126){
            biggest2126=ends[23];
          }
          if(biggest2126 == 1){
            active[20]=1;
            ends[20]=1;
            break RUN;
          }
        
        case 2 : 
          thread2127(tdone,ends);
          thread2128(tdone,ends);
          thread2129(tdone,ends);
          int biggest2133 = 0;
          if(ends[21]>=biggest2133){
            biggest2133=ends[21];
          }
          if(ends[22]>=biggest2133){
            biggest2133=ends[22];
          }
          if(ends[23]>=biggest2133){
            biggest2133=ends[23];
          }
          if(biggest2133 == 1){
            active[20]=1;
            ends[20]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2133 == 0){
            S2080=0;
            active[20]=0;
            ends[20]=0;
            S2080=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[20] != 0){
      int index = 20;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[20]!=0 || suspended[20]!=0 || active[20]!=1);
      else{
        if(!df){
          valveInjectorOnOff.gethook();
          valveInletOnOff.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      enable.setpreclear();
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      dosUnitEvacE.setpreclear();
      dosUnitFilledE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = valveInjectorOnOff.getStatus() ? valveInjectorOnOff.setprepresent() : valveInjectorOnOff.setpreclear();
      valveInjectorOnOff.setpreval(valveInjectorOnOff.getValue());
      valveInjectorOnOff.setClear();
      dummyint = valveInletOnOff.getStatus() ? valveInletOnOff.setprepresent() : valveInletOnOff.setpreclear();
      valveInletOnOff.setpreval(valveInletOnOff.getValue());
      valveInletOnOff.setClear();
      dummyint = dosUnitValveRetract.getStatus() ? dosUnitValveRetract.setprepresent() : dosUnitValveRetract.setpreclear();
      dosUnitValveRetract.setpreval(dosUnitValveRetract.getValue());
      dosUnitValveRetract.setClear();
      dummyint = dosUnitValveExtend.getStatus() ? dosUnitValveExtend.setprepresent() : dosUnitValveExtend.setpreclear();
      dosUnitValveExtend.setpreval(dosUnitValveExtend.getValue());
      dosUnitValveExtend.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      dosUnitEvacE.sethook();
      dosUnitEvacE.setClear();
      dosUnitFilledE.sethook();
      dosUnitFilledE.setClear();
      if(paused[20]!=0 || suspended[20]!=0 || active[20]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[20] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
