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
  private int S2127 = 1;
  private int S2054 = 1;
  private int S2032 = 1;
  private int S2107 = 1;
  private int S2061 = 1;
  private int S2125 = 1;
  private int S2115 = 1;
  private int S2123 = 1;
  
  private int[] ends = new int[30];
  private int[] tdone = new int[30];
  
  public void thread2410(int [] tdone, int [] ends){
        switch(S2123){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 370, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 370, column: 45
          currsigs.addElement(dosUnitFilledE);
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

  public void thread2409(int [] tdone, int [] ends){
        switch(S2115){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 368, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 368, column: 43
          currsigs.addElement(dosUnitEvacE);
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
      
    }
  }

  public void thread2408(int [] tdone, int [] ends){
        switch(S2125){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread2409(tdone,ends);
        thread2410(tdone,ends);
        int biggest2411 = 0;
        if(ends[23]>=biggest2411){
          biggest2411=ends[23];
        }
        if(ends[24]>=biggest2411){
          biggest2411=ends[24];
        }
        if(biggest2411 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest2411 == 0){
          S2125=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread2407(int [] tdone, int [] ends){
        switch(S2107){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2061){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 352, column: 19
              S2061=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 353, column: 17
              currsigs.addElement(dosUnitEvac);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 355, column: 19
              S2061=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 359, column: 17
              currsigs.addElement(dosUnitFilled);
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
          
          case 2 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 358, column: 19
              S2061=3;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 359, column: 17
              currsigs.addElement(dosUnitFilled);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 361, column: 19
              S2061=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 353, column: 17
              currsigs.addElement(dosUnitEvac);
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
          
        }
        break;
      
    }
  }

  public void thread2406(int [] tdone, int [] ends){
        switch(S2054){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2032){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 339, column: 19
              S2032=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 341, column: 17
              currsigs.addElement(bottleAtPos2);
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 340, column: 19
              S2032=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 341, column: 17
              currsigs.addElement(bottleAtPos2);
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2403(int [] tdone, int [] ends){
        S2123=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 370, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 370, column: 45
      currsigs.addElement(dosUnitFilledE);
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

  public void thread2402(int [] tdone, int [] ends){
        S2115=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 368, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 368, column: 43
      currsigs.addElement(dosUnitEvacE);
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
    else {
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread2401(int [] tdone, int [] ends){
        S2125=1;
    thread2402(tdone,ends);
    thread2403(tdone,ends);
    int biggest2404 = 0;
    if(ends[23]>=biggest2404){
      biggest2404=ends[23];
    }
    if(ends[24]>=biggest2404){
      biggest2404=ends[24];
    }
    if(biggest2404 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread2400(int [] tdone, int [] ends){
        S2107=1;
    S2061=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 353, column: 17
    currsigs.addElement(dosUnitEvac);
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2399(int [] tdone, int [] ends){
        S2054=1;
    S2032=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2127){
        case 0 : 
          S2127=0;
          break RUN;
        
        case 1 : 
          S2127=2;
          S2127=2;
          thread2399(tdone,ends);
          thread2400(tdone,ends);
          thread2401(tdone,ends);
          int biggest2405 = 0;
          if(ends[20]>=biggest2405){
            biggest2405=ends[20];
          }
          if(ends[21]>=biggest2405){
            biggest2405=ends[21];
          }
          if(ends[22]>=biggest2405){
            biggest2405=ends[22];
          }
          if(biggest2405 == 1){
            active[19]=1;
            ends[19]=1;
            break RUN;
          }
        
        case 2 : 
          thread2406(tdone,ends);
          thread2407(tdone,ends);
          thread2408(tdone,ends);
          int biggest2412 = 0;
          if(ends[20]>=biggest2412){
            biggest2412=ends[20];
          }
          if(ends[21]>=biggest2412){
            biggest2412=ends[21];
          }
          if(ends[22]>=biggest2412){
            biggest2412=ends[22];
          }
          if(biggest2412 == 1){
            active[19]=1;
            ends[19]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2412 == 0){
            S2127=0;
            active[19]=0;
            ends[19]=0;
            S2127=0;
            break RUN;
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
    while(active[19] != 0){
      int index = 19;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[19]!=0 || suspended[19]!=0 || active[19]!=1);
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
      if(paused[19]!=0 || suspended[19]!=0 || active[19]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[19] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
