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
  private int S3706 = 1;
  private int S3633 = 1;
  private int S3611 = 1;
  private int S3686 = 1;
  private int S3640 = 1;
  private int S3704 = 1;
  private int S3694 = 1;
  private int S3702 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread3761(int [] tdone, int [] ends){
        switch(S3702){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 405, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 405, column: 45
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

  public void thread3760(int [] tdone, int [] ends){
        switch(S3694){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 403, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 403, column: 43
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

  public void thread3759(int [] tdone, int [] ends){
        switch(S3704){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        thread3760(tdone,ends);
        thread3761(tdone,ends);
        int biggest3762 = 0;
        if(ends[26]>=biggest3762){
          biggest3762=ends[26];
        }
        if(ends[27]>=biggest3762){
          biggest3762=ends[27];
        }
        if(biggest3762 == 1){
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        //FINXME code
        if(biggest3762 == 0){
          S3704=0;
          active[25]=0;
          ends[25]=0;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread3758(int [] tdone, int [] ends){
        switch(S3686){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3640){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 387, column: 19
              S3640=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 388, column: 17
              currsigs.addElement(dosUnitEvac);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 390, column: 19
              S3640=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 394, column: 17
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
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 393, column: 19
              S3640=3;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 394, column: 17
              currsigs.addElement(dosUnitFilled);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 396, column: 19
              S3640=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 388, column: 17
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

  public void thread3757(int [] tdone, int [] ends){
        switch(S3633){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3611){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 19
              S3611=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 376, column: 17
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 375, column: 19
              S3611=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 376, column: 17
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

  public void thread3754(int [] tdone, int [] ends){
        S3702=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 405, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 405, column: 45
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

  public void thread3753(int [] tdone, int [] ends){
        S3694=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 403, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 403, column: 43
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

  public void thread3752(int [] tdone, int [] ends){
        S3704=1;
    thread3753(tdone,ends);
    thread3754(tdone,ends);
    int biggest3755 = 0;
    if(ends[26]>=biggest3755){
      biggest3755=ends[26];
    }
    if(ends[27]>=biggest3755){
      biggest3755=ends[27];
    }
    if(biggest3755 == 1){
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread3751(int [] tdone, int [] ends){
        S3686=1;
    S3640=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 388, column: 17
    currsigs.addElement(dosUnitEvac);
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread3750(int [] tdone, int [] ends){
        S3633=1;
    S3611=0;
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
      switch(S3706){
        case 0 : 
          S3706=0;
          break RUN;
        
        case 1 : 
          S3706=2;
          S3706=2;
          thread3750(tdone,ends);
          thread3751(tdone,ends);
          thread3752(tdone,ends);
          int biggest3756 = 0;
          if(ends[23]>=biggest3756){
            biggest3756=ends[23];
          }
          if(ends[24]>=biggest3756){
            biggest3756=ends[24];
          }
          if(ends[25]>=biggest3756){
            biggest3756=ends[25];
          }
          if(biggest3756 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
        
        case 2 : 
          thread3757(tdone,ends);
          thread3758(tdone,ends);
          thread3759(tdone,ends);
          int biggest3763 = 0;
          if(ends[23]>=biggest3763){
            biggest3763=ends[23];
          }
          if(ends[24]>=biggest3763){
            biggest3763=ends[24];
          }
          if(ends[25]>=biggest3763){
            biggest3763=ends[25];
          }
          if(biggest3763 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3763 == 0){
            S3706=0;
            active[22]=0;
            ends[22]=0;
            S3706=0;
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
