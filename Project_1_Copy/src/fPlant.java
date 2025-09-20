import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\fillerPlant.sysj line: 1, column: 1

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
  public Signal bottleOut = new Signal("bottleOut", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal dosUnitEvacE = new Signal("dosUnitEvacE", Signal.OUTPUT);
  public Signal dosUnitFilledE = new Signal("dosUnitFilledE", Signal.OUTPUT);
  public Signal fillerWorkingID = new Signal("fillerWorkingID", Signal.OUTPUT);
  public Signal fillID = new Signal("fillID", Signal.OUTPUT);
  private Signal bottle_1;
  private BottleTwin b_thread_2;//sysj\fillerPlant.sysj line: 19, column: 4
  private int id_thread_2;//sysj\fillerPlant.sysj line: 20, column: 4
  private BottleTwin b_thread_3;//sysj\fillerPlant.sysj line: 46, column: 4
  private int id_thread_3;//sysj\fillerPlant.sysj line: 47, column: 4
  private int S3826 = 1;
  private int S3753 = 1;
  private int S3735 = 1;
  private int S3806 = 1;
  private int S3760 = 1;
  private int S3824 = 1;
  private int S3814 = 1;
  private int S3822 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread3839(int [] tdone, int [] ends){
        switch(S3822){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 57, column: 30
          dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 57, column: 45
          currsigs.addElement(dosUnitFilledE);
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
      
    }
  }

  public void thread3838(int [] tdone, int [] ends){
        switch(S3814){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 55, column: 30
          dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 55, column: 43
          currsigs.addElement(dosUnitEvacE);
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
      
    }
  }

  public void thread3837(int [] tdone, int [] ends){
        switch(S3824){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread3838(tdone,ends);
        thread3839(tdone,ends);
        int biggest3840 = 0;
        if(ends[5]>=biggest3840){
          biggest3840=ends[5];
        }
        if(ends[6]>=biggest3840){
          biggest3840=ends[6];
        }
        if(biggest3840 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest3840 == 0){
          S3824=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread3836(int [] tdone, int [] ends){
        switch(S3806){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3760){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 36, column: 19
              S3760=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
              currsigs.addElement(dosUnitEvac);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 39, column: 19
              S3760=2;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 43, column: 17
              currsigs.addElement(dosUnitFilled);
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
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 42, column: 19
              S3760=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 43, column: 17
              currsigs.addElement(dosUnitFilled);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 45, column: 19
              b_thread_3 = (BottleTwin)(bottle_1.getpreval() == null ? null : ((BottleTwin)bottle_1.getpreval()));//sysj\fillerPlant.sysj line: 46, column: 4
              id_thread_3 = b_thread_3.ID;//sysj\fillerPlant.sysj line: 47, column: 4
              fillID.setPresent();//sysj\fillerPlant.sysj line: 48, column: 4
              currsigs.addElement(fillID);
              fillID.setValue(id_thread_3);//sysj\fillerPlant.sysj line: 48, column: 4
              S3760=0;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
              currsigs.addElement(dosUnitEvac);
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
          
        }
        break;
      
    }
  }

  public void thread3835(int [] tdone, int [] ends){
        switch(S3753){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3735){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\fillerPlant.sysj line: 18, column: 19
              b_thread_2 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\fillerPlant.sysj line: 19, column: 4
              id_thread_2 = b_thread_2.ID;//sysj\fillerPlant.sysj line: 20, column: 4
              if(b_thread_2 != null){//sysj\fillerPlant.sysj line: 21, column: 7
                bottle_1.setPresent();//sysj\fillerPlant.sysj line: 22, column: 5
                currsigs.addElement(bottle_1);
                bottle_1.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 22, column: 5
                bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 23, column: 14
                currsigs.addElement(bottleAtPos2);
                bottleAtPos2.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 23, column: 14
                fillerWorkingID.setPresent();//sysj\fillerPlant.sysj line: 24, column: 14
                currsigs.addElement(fillerWorkingID);
                fillerWorkingID.setValue(id_thread_2);//sysj\fillerPlant.sysj line: 24, column: 14
                S3735=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S3735=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            S3735=1;
            S3735=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3832(int [] tdone, int [] ends){
        S3822=1;
    if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 57, column: 30
      dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 57, column: 45
      currsigs.addElement(dosUnitFilledE);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread3831(int [] tdone, int [] ends){
        S3814=1;
    if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 55, column: 30
      dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 55, column: 43
      currsigs.addElement(dosUnitEvacE);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread3830(int [] tdone, int [] ends){
        S3824=1;
    thread3831(tdone,ends);
    thread3832(tdone,ends);
    int biggest3833 = 0;
    if(ends[5]>=biggest3833){
      biggest3833=ends[5];
    }
    if(ends[6]>=biggest3833){
      biggest3833=ends[6];
    }
    if(biggest3833 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread3829(int [] tdone, int [] ends){
        S3806=1;
    S3760=0;
    dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
    currsigs.addElement(dosUnitEvac);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3828(int [] tdone, int [] ends){
        S3753=1;
    S3735=0;
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
      switch(S3826){
        case 0 : 
          S3826=0;
          break RUN;
        
        case 1 : 
          S3826=2;
          S3826=2;
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 14, column: 2
          thread3828(tdone,ends);
          thread3829(tdone,ends);
          thread3830(tdone,ends);
          int biggest3834 = 0;
          if(ends[2]>=biggest3834){
            biggest3834=ends[2];
          }
          if(ends[3]>=biggest3834){
            biggest3834=ends[3];
          }
          if(ends[4]>=biggest3834){
            biggest3834=ends[4];
          }
          if(biggest3834 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 14, column: 2
          thread3835(tdone,ends);
          thread3836(tdone,ends);
          thread3837(tdone,ends);
          int biggest3841 = 0;
          if(ends[2]>=biggest3841){
            biggest3841=ends[2];
          }
          if(ends[3]>=biggest3841){
            biggest3841=ends[3];
          }
          if(ends[4]>=biggest3841){
            biggest3841=ends[4];
          }
          if(biggest3841 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3841 == 0){
            S3826=0;
            active[1]=0;
            ends[1]=0;
            S3826=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    bottle_1 = new Signal();
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
          valveInjectorOnOff.gethook();
          valveInletOnOff.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          enable.gethook();
          bottleOut.gethook();
          bottleIn.gethook();
          df = true;
        }
        runClockDomain();
      }
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      enable.setpreclear();
      bottleOut.setpreclear();
      bottleIn.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      bottleAtPos2.setpreclear();
      dosUnitEvacE.setpreclear();
      dosUnitFilledE.setpreclear();
      fillerWorkingID.setpreclear();
      fillID.setpreclear();
      bottle_1.setpreclear();
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
      dummyint = bottleOut.getStatus() ? bottleOut.setprepresent() : bottleOut.setpreclear();
      bottleOut.setpreval(bottleOut.getValue());
      bottleOut.setClear();
      dummyint = bottleIn.getStatus() ? bottleIn.setprepresent() : bottleIn.setpreclear();
      bottleIn.setpreval(bottleIn.getValue());
      bottleIn.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      dosUnitEvacE.sethook();
      dosUnitEvacE.setClear();
      dosUnitFilledE.sethook();
      dosUnitFilledE.setClear();
      fillerWorkingID.sethook();
      fillerWorkingID.setClear();
      fillID.sethook();
      fillID.setClear();
      bottle_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
        bottleOut.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
