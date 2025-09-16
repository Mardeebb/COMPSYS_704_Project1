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
  private int S3744 = 1;
  private int S3671 = 1;
  private int S3649 = 1;
  private int S3724 = 1;
  private int S3678 = 1;
  private int S3742 = 1;
  private int S3732 = 1;
  private int S3740 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void thread3799(int [] tdone, int [] ends){
        switch(S3740){
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

  public void thread3798(int [] tdone, int [] ends){
        switch(S3732){
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

  public void thread3797(int [] tdone, int [] ends){
        switch(S3742){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        thread3798(tdone,ends);
        thread3799(tdone,ends);
        int biggest3800 = 0;
        if(ends[27]>=biggest3800){
          biggest3800=ends[27];
        }
        if(ends[28]>=biggest3800){
          biggest3800=ends[28];
        }
        if(biggest3800 == 1){
          active[26]=1;
          ends[26]=1;
          tdone[26]=1;
        }
        //FINXME code
        if(biggest3800 == 0){
          S3742=0;
          active[26]=0;
          ends[26]=0;
          tdone[26]=1;
        }
        break;
      
    }
  }

  public void thread3796(int [] tdone, int [] ends){
        switch(S3724){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S3678){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 406, column: 19
              S3678=1;
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
              S3678=2;
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
              S3678=3;
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
              S3678=0;
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

  public void thread3795(int [] tdone, int [] ends){
        switch(S3671){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3649){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 393, column: 19
              S3649=1;
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
              S3649=0;
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

  public void thread3792(int [] tdone, int [] ends){
        S3740=1;
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

  public void thread3791(int [] tdone, int [] ends){
        S3732=1;
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

  public void thread3790(int [] tdone, int [] ends){
        S3742=1;
    thread3791(tdone,ends);
    thread3792(tdone,ends);
    int biggest3793 = 0;
    if(ends[27]>=biggest3793){
      biggest3793=ends[27];
    }
    if(ends[28]>=biggest3793){
      biggest3793=ends[28];
    }
    if(biggest3793 == 1){
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread3789(int [] tdone, int [] ends){
        S3724=1;
    S3678=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 407, column: 17
    currsigs.addElement(dosUnitEvac);
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread3788(int [] tdone, int [] ends){
        S3671=1;
    S3649=0;
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
      switch(S3744){
        case 0 : 
          S3744=0;
          break RUN;
        
        case 1 : 
          S3744=2;
          S3744=2;
          thread3788(tdone,ends);
          thread3789(tdone,ends);
          thread3790(tdone,ends);
          int biggest3794 = 0;
          if(ends[24]>=biggest3794){
            biggest3794=ends[24];
          }
          if(ends[25]>=biggest3794){
            biggest3794=ends[25];
          }
          if(ends[26]>=biggest3794){
            biggest3794=ends[26];
          }
          if(biggest3794 == 1){
            active[23]=1;
            ends[23]=1;
            break RUN;
          }
        
        case 2 : 
          thread3795(tdone,ends);
          thread3796(tdone,ends);
          thread3797(tdone,ends);
          int biggest3801 = 0;
          if(ends[24]>=biggest3801){
            biggest3801=ends[24];
          }
          if(ends[25]>=biggest3801){
            biggest3801=ends[25];
          }
          if(ends[26]>=biggest3801){
            biggest3801=ends[26];
          }
          if(biggest3801 == 1){
            active[23]=1;
            ends[23]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3801 == 0){
            S3744=0;
            active[23]=0;
            ends[23]=0;
            S3744=0;
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
