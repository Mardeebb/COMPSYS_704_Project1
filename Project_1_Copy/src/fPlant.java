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
  private int S2410 = 1;
  private int S2337 = 1;
  private int S2315 = 1;
  private int S2390 = 1;
  private int S2344 = 1;
  private int S2408 = 1;
  private int S2398 = 1;
  private int S2406 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread2465(int [] tdone, int [] ends){
        switch(S2406){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 404, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 404, column: 45
          currsigs.addElement(dosUnitFilledE);
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
      
    }
  }

  public void thread2464(int [] tdone, int [] ends){
        switch(S2398){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 402, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 402, column: 43
          currsigs.addElement(dosUnitEvacE);
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
      
    }
  }

  public void thread2463(int [] tdone, int [] ends){
        switch(S2408){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        thread2464(tdone,ends);
        thread2465(tdone,ends);
        int biggest2466 = 0;
        if(ends[26]>=biggest2466){
          biggest2466=ends[26];
        }
        if(ends[27]>=biggest2466){
          biggest2466=ends[27];
        }
        if(biggest2466 == 1){
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        //FINXME code
        if(biggest2466 == 0){
          S2408=0;
          active[25]=0;
          ends[25]=0;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread2462(int [] tdone, int [] ends){
        switch(S2390){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S2344){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 386, column: 19
              S2344=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 387, column: 17
              currsigs.addElement(dosUnitEvac);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 389, column: 19
              S2344=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 393, column: 17
              currsigs.addElement(dosUnitFilled);
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
          
          case 2 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 392, column: 19
              S2344=3;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 393, column: 17
              currsigs.addElement(dosUnitFilled);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 395, column: 19
              S2344=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 387, column: 17
              currsigs.addElement(dosUnitEvac);
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
        break;
      
    }
  }

  public void thread2461(int [] tdone, int [] ends){
        switch(S2337){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S2315){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 373, column: 19
              S2315=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 375, column: 17
              currsigs.addElement(bottleAtPos2);
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 374, column: 19
              S2315=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 375, column: 17
              currsigs.addElement(bottleAtPos2);
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2458(int [] tdone, int [] ends){
        S2406=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 404, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 404, column: 45
      currsigs.addElement(dosUnitFilledE);
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
    else {
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread2457(int [] tdone, int [] ends){
        S2398=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 402, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 402, column: 43
      currsigs.addElement(dosUnitEvacE);
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread2456(int [] tdone, int [] ends){
        S2408=1;
    thread2457(tdone,ends);
    thread2458(tdone,ends);
    int biggest2459 = 0;
    if(ends[26]>=biggest2459){
      biggest2459=ends[26];
    }
    if(ends[27]>=biggest2459){
      biggest2459=ends[27];
    }
    if(biggest2459 == 1){
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread2455(int [] tdone, int [] ends){
        S2390=1;
    S2344=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 387, column: 17
    currsigs.addElement(dosUnitEvac);
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread2454(int [] tdone, int [] ends){
        S2337=1;
    S2315=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2410){
        case 0 : 
          S2410=0;
          break RUN;
        
        case 1 : 
          S2410=2;
          S2410=2;
          thread2454(tdone,ends);
          thread2455(tdone,ends);
          thread2456(tdone,ends);
          int biggest2460 = 0;
          if(ends[23]>=biggest2460){
            biggest2460=ends[23];
          }
          if(ends[24]>=biggest2460){
            biggest2460=ends[24];
          }
          if(ends[25]>=biggest2460){
            biggest2460=ends[25];
          }
          if(biggest2460 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
        
        case 2 : 
          thread2461(tdone,ends);
          thread2462(tdone,ends);
          thread2463(tdone,ends);
          int biggest2467 = 0;
          if(ends[23]>=biggest2467){
            biggest2467=ends[23];
          }
          if(ends[24]>=biggest2467){
            biggest2467=ends[24];
          }
          if(ends[25]>=biggest2467){
            biggest2467=ends[25];
          }
          if(biggest2467 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2467 == 0){
            S2410=0;
            active[22]=0;
            ends[22]=0;
            S2410=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[22] != 0){
      int index = 22;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
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
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[22] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
