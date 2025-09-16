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
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal dosUnitEvacE = new Signal("dosUnitEvacE", Signal.OUTPUT);
  public Signal dosUnitFilledE = new Signal("dosUnitFilledE", Signal.OUTPUT);
  public Signal fillID = new Signal("fillID", Signal.OUTPUT);
  private Signal bottle_1;
  private BottleTwin b_thread_2;//sysj\fillerPlant.sysj line: 18, column: 4
  private BottleTwin b_thread_3;//sysj\fillerPlant.sysj line: 43, column: 4
  private int id_thread_3;//sysj\fillerPlant.sysj line: 44, column: 4
  private int S666 = 1;
  private int S593 = 1;
  private int S575 = 1;
  private int S646 = 1;
  private int S600 = 1;
  private int S664 = 1;
  private int S654 = 1;
  private int S662 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread679(int [] tdone, int [] ends){
        switch(S662){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 54, column: 30
          dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 54, column: 45
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

  public void thread678(int [] tdone, int [] ends){
        switch(S654){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 52, column: 30
          dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 52, column: 43
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

  public void thread677(int [] tdone, int [] ends){
        switch(S664){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread678(tdone,ends);
        thread679(tdone,ends);
        int biggest680 = 0;
        if(ends[5]>=biggest680){
          biggest680=ends[5];
        }
        if(ends[6]>=biggest680){
          biggest680=ends[6];
        }
        if(biggest680 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest680 == 0){
          S664=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread676(int [] tdone, int [] ends){
        switch(S646){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S600){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 33, column: 19
              S600=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 34, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 36, column: 19
              S600=2;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 40, column: 17
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
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 39, column: 19
              S600=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 40, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 42, column: 19
              b_thread_3 = (BottleTwin)(bottle_1.getpreval() == null ? null : ((BottleTwin)bottle_1.getpreval()));//sysj\fillerPlant.sysj line: 43, column: 4
              id_thread_3 = b_thread_3.ID;//sysj\fillerPlant.sysj line: 44, column: 4
              fillID.setPresent();//sysj\fillerPlant.sysj line: 45, column: 4
              currsigs.addElement(fillID);
              fillID.setValue(id_thread_3);//sysj\fillerPlant.sysj line: 45, column: 4
              System.out.println("Emitted fillID");
              S600=0;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 34, column: 17
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

  public void thread675(int [] tdone, int [] ends){
        switch(S593){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S575){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\fillerPlant.sysj line: 17, column: 19
              b_thread_2 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\fillerPlant.sysj line: 18, column: 4
              if(b_thread_2 != null){//sysj\fillerPlant.sysj line: 19, column: 7
                bottle_1.setPresent();//sysj\fillerPlant.sysj line: 20, column: 5
                currsigs.addElement(bottle_1);
                bottle_1.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 20, column: 5
                System.out.println("Emitted bottle_1");
                bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 21, column: 14
                currsigs.addElement(bottleAtPos2);
                System.out.println("Emitted bottleAtPos2");
                S575=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S575=1;
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
            S575=1;
            S575=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread672(int [] tdone, int [] ends){
        S662=1;
    if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 54, column: 30
      dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 54, column: 45
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

  public void thread671(int [] tdone, int [] ends){
        S654=1;
    if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 52, column: 30
      dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 52, column: 43
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

  public void thread670(int [] tdone, int [] ends){
        S664=1;
    thread671(tdone,ends);
    thread672(tdone,ends);
    int biggest673 = 0;
    if(ends[5]>=biggest673){
      biggest673=ends[5];
    }
    if(ends[6]>=biggest673){
      biggest673=ends[6];
    }
    if(biggest673 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread669(int [] tdone, int [] ends){
        S646=1;
    S600=0;
    dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 34, column: 17
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread668(int [] tdone, int [] ends){
        S593=1;
    S575=0;
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
      switch(S666){
        case 0 : 
          S666=0;
          break RUN;
        
        case 1 : 
          S666=2;
          S666=2;
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 13, column: 2
          thread668(tdone,ends);
          thread669(tdone,ends);
          thread670(tdone,ends);
          int biggest674 = 0;
          if(ends[2]>=biggest674){
            biggest674=ends[2];
          }
          if(ends[3]>=biggest674){
            biggest674=ends[3];
          }
          if(ends[4]>=biggest674){
            biggest674=ends[4];
          }
          if(biggest674 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 13, column: 2
          thread675(tdone,ends);
          thread676(tdone,ends);
          thread677(tdone,ends);
          int biggest681 = 0;
          if(ends[2]>=biggest681){
            biggest681=ends[2];
          }
          if(ends[3]>=biggest681){
            biggest681=ends[3];
          }
          if(ends[4]>=biggest681){
            biggest681=ends[4];
          }
          if(biggest681 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest681 == 0){
            S666=0;
            active[1]=0;
            ends[1]=0;
            S666=0;
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
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      dosUnitEvacE.setpreclear();
      dosUnitFilledE.setpreclear();
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
