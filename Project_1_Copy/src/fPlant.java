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
  private int S8684 = 1;
  private int S8611 = 1;
  private int S8589 = 1;
  private int S8664 = 1;
  private int S8618 = 1;
  private int S8682 = 1;
  private int S8672 = 1;
  private int S8680 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread8739(int [] tdone, int [] ends){
        switch(S8680){
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

  public void thread8738(int [] tdone, int [] ends){
        switch(S8672){
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

  public void thread8737(int [] tdone, int [] ends){
        switch(S8682){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        thread8738(tdone,ends);
        thread8739(tdone,ends);
        int biggest8740 = 0;
        if(ends[26]>=biggest8740){
          biggest8740=ends[26];
        }
        if(ends[27]>=biggest8740){
          biggest8740=ends[27];
        }
        if(biggest8740 == 1){
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        //FINXME code
        if(biggest8740 == 0){
          S8682=0;
          active[25]=0;
          ends[25]=0;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread8736(int [] tdone, int [] ends){
        switch(S8664){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S8618){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 387, column: 19
              S8618=1;
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
              S8618=2;
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
              S8618=3;
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
              S8618=0;
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

  public void thread8735(int [] tdone, int [] ends){
        switch(S8611){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S8589){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 19
              S8589=1;
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
              S8589=0;
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

  public void thread8732(int [] tdone, int [] ends){
        S8680=1;
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

  public void thread8731(int [] tdone, int [] ends){
        S8672=1;
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

  public void thread8730(int [] tdone, int [] ends){
        S8682=1;
    thread8731(tdone,ends);
    thread8732(tdone,ends);
    int biggest8733 = 0;
    if(ends[26]>=biggest8733){
      biggest8733=ends[26];
    }
    if(ends[27]>=biggest8733){
      biggest8733=ends[27];
    }
    if(biggest8733 == 1){
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread8729(int [] tdone, int [] ends){
        S8664=1;
    S8618=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 388, column: 17
    currsigs.addElement(dosUnitEvac);
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread8728(int [] tdone, int [] ends){
        S8611=1;
    S8589=0;
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
      switch(S8684){
        case 0 : 
          S8684=0;
          break RUN;
        
        case 1 : 
          S8684=2;
          S8684=2;
          thread8728(tdone,ends);
          thread8729(tdone,ends);
          thread8730(tdone,ends);
          int biggest8734 = 0;
          if(ends[23]>=biggest8734){
            biggest8734=ends[23];
          }
          if(ends[24]>=biggest8734){
            biggest8734=ends[24];
          }
          if(ends[25]>=biggest8734){
            biggest8734=ends[25];
          }
          if(biggest8734 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
        
        case 2 : 
          thread8735(tdone,ends);
          thread8736(tdone,ends);
          thread8737(tdone,ends);
          int biggest8741 = 0;
          if(ends[23]>=biggest8741){
            biggest8741=ends[23];
          }
          if(ends[24]>=biggest8741){
            biggest8741=ends[24];
          }
          if(ends[25]>=biggest8741){
            biggest8741=ends[25];
          }
          if(biggest8741 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
          //FINXME code
          if(biggest8741 == 0){
            S8684=0;
            active[22]=0;
            ends[22]=0;
            S8684=0;
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
