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
  private BottleTwin b_thread_2;//sysj\fillerPlant.sysj line: 20, column: 4
  private BottleTwin b_thread_3;//sysj\fillerPlant.sysj line: 44, column: 4
  private int id_thread_3;//sysj\fillerPlant.sysj line: 45, column: 4
  private int S2646 = 1;
  private int S2573 = 1;
  private int S2543 = 1;
  private int S2626 = 1;
  private int S2580 = 1;
  private int S2644 = 1;
  private int S2634 = 1;
  private int S2628 = 1;
  private int S2642 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread2659(int [] tdone, int [] ends){
        switch(S2642){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 55, column: 30
          dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 55, column: 45
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

  public void thread2658(int [] tdone, int [] ends){
        switch(S2634){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2628){
          case 0 : 
            S2628=0;
            if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 53, column: 30
              dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 53, column: 43
              currsigs.addElement(dosUnitEvacE);
              System.out.println("Emitted dosUnitEvacE");
              S2628=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S2628=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S2628=1;
            S2628=0;
            if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 53, column: 30
              dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 53, column: 43
              currsigs.addElement(dosUnitEvacE);
              System.out.println("Emitted dosUnitEvacE");
              S2628=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S2628=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2657(int [] tdone, int [] ends){
        switch(S2644){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread2658(tdone,ends);
        thread2659(tdone,ends);
        int biggest2660 = 0;
        if(ends[5]>=biggest2660){
          biggest2660=ends[5];
        }
        if(ends[6]>=biggest2660){
          biggest2660=ends[6];
        }
        if(biggest2660 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest2660 == 0){
          S2644=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2656(int [] tdone, int [] ends){
        switch(S2626){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2580){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 34, column: 19
              S2580=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 35, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 37, column: 19
              S2580=2;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 41, column: 17
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
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 40, column: 19
              S2580=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 41, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 43, column: 19
              b_thread_3 = (BottleTwin)(bottle_1.getpreval() == null ? null : ((BottleTwin)bottle_1.getpreval()));//sysj\fillerPlant.sysj line: 44, column: 4
              id_thread_3 = b_thread_3.ID;//sysj\fillerPlant.sysj line: 45, column: 4
              fillID.setPresent();//sysj\fillerPlant.sysj line: 46, column: 4
              currsigs.addElement(fillID);
              fillID.setValue(id_thread_3);//sysj\fillerPlant.sysj line: 46, column: 4
              System.out.println("Emitted fillID");
              S2580=0;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 35, column: 17
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

  public void thread2655(int [] tdone, int [] ends){
        switch(S2573){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2543){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\fillerPlant.sysj line: 18, column: 19
              b_thread_2 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\fillerPlant.sysj line: 20, column: 4
              bottle_1.setPresent();//sysj\fillerPlant.sysj line: 21, column: 4
              currsigs.addElement(bottle_1);
              bottle_1.setValue(b_thread_2);//sysj\fillerPlant.sysj line: 21, column: 4
              System.out.println("Emitted bottle_1");
              S2543=1;
              bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 23, column: 17
              currsigs.addElement(bottleAtPos2);
              System.out.println("Emitted bottleAtPos2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(bottleOut.getprestatus()){//sysj\fillerPlant.sysj line: 22, column: 19
              S2543=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 23, column: 17
              currsigs.addElement(bottleAtPos2);
              System.out.println("Emitted bottleAtPos2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2652(int [] tdone, int [] ends){
        S2642=1;
    if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 55, column: 30
      dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 55, column: 45
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

  public void thread2651(int [] tdone, int [] ends){
        S2634=1;
    S2628=0;
    if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 53, column: 30
      dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 53, column: 43
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
      S2628=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S2628=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2650(int [] tdone, int [] ends){
        S2644=1;
    thread2651(tdone,ends);
    thread2652(tdone,ends);
    int biggest2653 = 0;
    if(ends[5]>=biggest2653){
      biggest2653=ends[5];
    }
    if(ends[6]>=biggest2653){
      biggest2653=ends[6];
    }
    if(biggest2653 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2649(int [] tdone, int [] ends){
        S2626=1;
    S2580=0;
    dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 35, column: 17
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2648(int [] tdone, int [] ends){
        S2573=1;
    S2543=0;
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
      switch(S2646){
        case 0 : 
          S2646=0;
          break RUN;
        
        case 1 : 
          S2646=2;
          S2646=2;
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 13, column: 2
          thread2648(tdone,ends);
          thread2649(tdone,ends);
          thread2650(tdone,ends);
          int biggest2654 = 0;
          if(ends[2]>=biggest2654){
            biggest2654=ends[2];
          }
          if(ends[3]>=biggest2654){
            biggest2654=ends[3];
          }
          if(ends[4]>=biggest2654){
            biggest2654=ends[4];
          }
          if(biggest2654 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottle_1.setClear();//sysj\fillerPlant.sysj line: 13, column: 2
          thread2655(tdone,ends);
          thread2656(tdone,ends);
          thread2657(tdone,ends);
          int biggest2661 = 0;
          if(ends[2]>=biggest2661){
            biggest2661=ends[2];
          }
          if(ends[3]>=biggest2661){
            biggest2661=ends[3];
          }
          if(ends[4]>=biggest2661){
            biggest2661=ends[4];
          }
          if(biggest2661 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2661 == 0){
            S2646=0;
            active[1]=0;
            ends[1]=0;
            S2646=0;
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
