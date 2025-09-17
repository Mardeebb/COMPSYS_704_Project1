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
  private BottleTwin b_thread_3;//sysj\fillerPlant.sysj line: 56, column: 4
  private int id_thread_3;//sysj\fillerPlant.sysj line: 57, column: 4
  private int S4776 = 1;
  private int S4643 = 1;
  private int S4625 = 1;
  private int S4756 = 1;
  private int S4650 = 1;
  private int S4774 = 1;
  private int S4764 = 1;
  private int S4772 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread4789(int [] tdone, int [] ends){
        switch(S4772){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 67, column: 30
          dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 67, column: 45
          currsigs.addElement(dosUnitFilledE);
          System.out.println("Emitted dosUnitFilledE");
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

  public void thread4788(int [] tdone, int [] ends){
        switch(S4764){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 65, column: 30
          dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 65, column: 43
          currsigs.addElement(dosUnitEvacE);
          System.out.println("Emitted dosUnitEvacE");
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

  public void thread4787(int [] tdone, int [] ends){
        switch(S4774){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread4788(tdone,ends);
        thread4789(tdone,ends);
        int biggest4790 = 0;
        if(ends[5]>=biggest4790){
          biggest4790=ends[5];
        }
        if(ends[6]>=biggest4790){
          biggest4790=ends[6];
        }
        if(biggest4790 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest4790 == 0){
          S4774=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread4786(int [] tdone, int [] ends){
        switch(S4756){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4650){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 36, column: 19
              S4650=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 39, column: 19
              S4650=2;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 43, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
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
              S4650=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 43, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 45, column: 19
              S4650=4;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 47, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
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
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 46, column: 19
              S4650=5;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 47, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 49, column: 19
              S4650=6;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 53, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
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
          
          case 6 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 52, column: 19
              S4650=7;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 53, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 7 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 55, column: 19
              b_thread_3 = (BottleTwin)(bottle_1.getpreval() == null ? null : ((BottleTwin)bottle_1.getpreval()));//sysj\fillerPlant.sysj line: 56, column: 4
              id_thread_3 = b_thread_3.ID;//sysj\fillerPlant.sysj line: 57, column: 4
              fillID.setPresent();//sysj\fillerPlant.sysj line: 58, column: 4
              currsigs.addElement(fillID);
              fillID.setValue(id_thread_3);//sysj\fillerPlant.sysj line: 58, column: 4
              System.out.println("Emitted fillID");
              S4650=0;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
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

  public void thread4785(int [] tdone, int [] ends){
        switch(S4643){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S4625){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\fillerPlant.sysj line: 18, column: 19
              b_thread_2 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\fillerPlant.sysj line: 19, column: 4
              id_thread_2 = b_thread_2.ID;//sysj\fillerPlant.sysj line: 20, column: 4
              if(b_thread_2 != null){//sysj\fillerPlant.sysj line: 21, column: 7
                bottle_1.setPresent();//sysj\fillerPlant.sysj line: 22, column: 5
                currsigs.addElement(bottle_1);
                bottle_1.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 22, column: 5
                System.out.println("Emitted bottle_1");
                bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 23, column: 14
                currsigs.addElement(bottleAtPos2);
                bottleAtPos2.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 23, column: 14
                System.out.println("Emitted bottleAtPos2");
                fillerWorkingID.setPresent();//sysj\fillerPlant.sysj line: 24, column: 14
                currsigs.addElement(fillerWorkingID);
                fillerWorkingID.setValue(id_thread_2);//sysj\fillerPlant.sysj line: 24, column: 14
                System.out.println("Emitted fillerWorkingID");
                S4625=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S4625=1;
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
            S4625=1;
            S4625=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread4782(int [] tdone, int [] ends){
        S4772=1;
    if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 67, column: 30
      dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 67, column: 45
      currsigs.addElement(dosUnitFilledE);
      System.out.println("Emitted dosUnitFilledE");
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

  public void thread4781(int [] tdone, int [] ends){
        S4764=1;
    if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 65, column: 30
      dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 65, column: 43
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
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

  public void thread4780(int [] tdone, int [] ends){
        S4774=1;
    thread4781(tdone,ends);
    thread4782(tdone,ends);
    int biggest4783 = 0;
    if(ends[5]>=biggest4783){
      biggest4783=ends[5];
    }
    if(ends[6]>=biggest4783){
      biggest4783=ends[6];
    }
    if(biggest4783 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread4779(int [] tdone, int [] ends){
        S4756=1;
    S4650=0;
    dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 37, column: 17
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4778(int [] tdone, int [] ends){
        S4643=1;
    S4625=0;
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
      switch(S4776){
        case 0 : 
          S4776=0;
          break RUN;
        
        case 1 : 
          S4776=2;
          S4776=2;
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 14, column: 2
          thread4778(tdone,ends);
          thread4779(tdone,ends);
          thread4780(tdone,ends);
          int biggest4784 = 0;
          if(ends[2]>=biggest4784){
            biggest4784=ends[2];
          }
          if(ends[3]>=biggest4784){
            biggest4784=ends[3];
          }
          if(ends[4]>=biggest4784){
            biggest4784=ends[4];
          }
          if(biggest4784 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 14, column: 2
          thread4785(tdone,ends);
          thread4786(tdone,ends);
          thread4787(tdone,ends);
          int biggest4791 = 0;
          if(ends[2]>=biggest4791){
            biggest4791=ends[2];
          }
          if(ends[3]>=biggest4791){
            biggest4791=ends[3];
          }
          if(ends[4]>=biggest4791){
            biggest4791=ends[4];
          }
          if(biggest4791 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4791 == 0){
            S4776=0;
            active[1]=0;
            ends[1]=0;
            S4776=0;
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
