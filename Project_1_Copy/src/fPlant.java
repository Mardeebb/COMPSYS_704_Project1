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
  private int S3750 = 1;
  private int S3677 = 1;
  private int S3655 = 1;
  private int S3730 = 1;
  private int S3684 = 1;
  private int S3748 = 1;
  private int S3738 = 1;
  private int S3746 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void thread3805(int [] tdone, int [] ends){
        switch(S3746){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 424, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 424, column: 45
          currsigs.addElement(dosUnitFilledE);
          active[28]=1;
          ends[28]=1;
          tdone[28]=1;
        }
        else {
          active[28]=1;
          ends[28]=1;
          tdone[28]=1;
        }
        break;
      
    }
  }

  public void thread3804(int [] tdone, int [] ends){
        switch(S3738){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 422, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 422, column: 43
          currsigs.addElement(dosUnitEvacE);
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

  public void thread3803(int [] tdone, int [] ends){
        switch(S3748){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        thread3804(tdone,ends);
        thread3805(tdone,ends);
        int biggest3806 = 0;
        if(ends[27]>=biggest3806){
          biggest3806=ends[27];
        }
        if(ends[28]>=biggest3806){
          biggest3806=ends[28];
        }
        if(biggest3806 == 1){
          active[26]=1;
          ends[26]=1;
          tdone[26]=1;
        }
        //FINXME code
        if(biggest3806 == 0){
          S3748=0;
          active[26]=0;
          ends[26]=0;
          tdone[26]=1;
        }
        break;
      
    }
  }

  public void thread3802(int [] tdone, int [] ends){
        switch(S3730){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S3684){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 406, column: 19
              S3684=1;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 407, column: 17
              currsigs.addElement(dosUnitEvac);
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 409, column: 19
              S3684=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 413, column: 17
              currsigs.addElement(dosUnitFilled);
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
          
          case 2 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 412, column: 19
              S3684=3;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 413, column: 17
              currsigs.addElement(dosUnitFilled);
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 415, column: 19
              S3684=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 407, column: 17
              currsigs.addElement(dosUnitEvac);
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
        break;
      
    }
  }

  public void thread3801(int [] tdone, int [] ends){
        switch(S3677){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3655){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 393, column: 19
              S3655=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 395, column: 17
              currsigs.addElement(bottleAtPos2);
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 394, column: 19
              S3655=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 395, column: 17
              currsigs.addElement(bottleAtPos2);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3798(int [] tdone, int [] ends){
        S3746=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 424, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 424, column: 45
      currsigs.addElement(dosUnitFilledE);
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread3797(int [] tdone, int [] ends){
        S3738=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 422, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 422, column: 43
      currsigs.addElement(dosUnitEvacE);
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

  public void thread3796(int [] tdone, int [] ends){
        S3748=1;
    thread3797(tdone,ends);
    thread3798(tdone,ends);
    int biggest3799 = 0;
    if(ends[27]>=biggest3799){
      biggest3799=ends[27];
    }
    if(ends[28]>=biggest3799){
      biggest3799=ends[28];
    }
    if(biggest3799 == 1){
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread3795(int [] tdone, int [] ends){
        S3730=1;
    S3684=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 407, column: 17
    currsigs.addElement(dosUnitEvac);
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread3794(int [] tdone, int [] ends){
        S3677=1;
    S3655=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3750){
        case 0 : 
          S3750=0;
          break RUN;
        
        case 1 : 
          S3750=2;
          S3750=2;
          thread3794(tdone,ends);
          thread3795(tdone,ends);
          thread3796(tdone,ends);
          int biggest3800 = 0;
          if(ends[24]>=biggest3800){
            biggest3800=ends[24];
          }
          if(ends[25]>=biggest3800){
            biggest3800=ends[25];
          }
          if(ends[26]>=biggest3800){
            biggest3800=ends[26];
          }
          if(biggest3800 == 1){
            active[23]=1;
            ends[23]=1;
            break RUN;
          }
        
        case 2 : 
          thread3801(tdone,ends);
          thread3802(tdone,ends);
          thread3803(tdone,ends);
          int biggest3807 = 0;
          if(ends[24]>=biggest3807){
            biggest3807=ends[24];
          }
          if(ends[25]>=biggest3807){
            biggest3807=ends[25];
          }
          if(ends[26]>=biggest3807){
            biggest3807=ends[26];
          }
          if(biggest3807 == 1){
            active[23]=1;
            ends[23]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3807 == 0){
            S3750=0;
            active[23]=0;
            ends[23]=0;
            S3750=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[23] != 0){
      int index = 23;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[23]!=0 || suspended[23]!=0 || active[23]!=1);
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
      if(paused[23]!=0 || suspended[23]!=0 || active[23]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[23] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
