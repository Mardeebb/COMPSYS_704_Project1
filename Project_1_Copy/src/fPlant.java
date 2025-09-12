import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

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
  private int S696 = 1;
  private int S623 = 1;
  private int S601 = 1;
  private int S676 = 1;
  private int S630 = 1;
  private int S694 = 1;
  private int S684 = 1;
  private int S678 = 1;
  private int S692 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread709(int [] tdone, int [] ends){
        switch(S692){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 44, column: 30
          dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 44, column: 45
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

  public void thread708(int [] tdone, int [] ends){
        switch(S684){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S678){
          case 0 : 
            S678=0;
            if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 42, column: 30
              dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 42, column: 43
              currsigs.addElement(dosUnitEvacE);
              System.out.println("Emitted dosUnitEvacE");
              S678=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S678=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S678=1;
            S678=0;
            if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 42, column: 30
              dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 42, column: 43
              currsigs.addElement(dosUnitEvacE);
              System.out.println("Emitted dosUnitEvacE");
              S678=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S678=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread707(int [] tdone, int [] ends){
        switch(S694){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        thread708(tdone,ends);
        thread709(tdone,ends);
        int biggest710 = 0;
        if(ends[5]>=biggest710){
          biggest710=ends[5];
        }
        if(ends[6]>=biggest710){
          biggest710=ends[6];
        }
        if(biggest710 == 1){
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        //FINXME code
        if(biggest710 == 0){
          S694=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread706(int [] tdone, int [] ends){
        switch(S676){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S630){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 26, column: 19
              S630=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 27, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 29, column: 19
              S630=2;
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 33, column: 17
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
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\fillerPlant.sysj line: 32, column: 19
              S630=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\fillerPlant.sysj line: 33, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 35, column: 19
              S630=0;
              dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 27, column: 17
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

  public void thread705(int [] tdone, int [] ends){
        switch(S623){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S601){
          case 0 : 
            if(enable.getprestatus()){//sysj\fillerPlant.sysj line: 13, column: 19
              S601=1;
              bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 15, column: 17
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
            if(!enable.getprestatus()){//sysj\fillerPlant.sysj line: 14, column: 19
              S601=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\fillerPlant.sysj line: 15, column: 17
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

  public void thread702(int [] tdone, int [] ends){
        S692=1;
    if(dosUnitFilled.getprestatus()){//sysj\fillerPlant.sysj line: 44, column: 30
      dosUnitFilledE.setPresent();//sysj\fillerPlant.sysj line: 44, column: 45
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

  public void thread701(int [] tdone, int [] ends){
        S684=1;
    S678=0;
    if(dosUnitEvac.getprestatus()){//sysj\fillerPlant.sysj line: 42, column: 30
      dosUnitEvacE.setPresent();//sysj\fillerPlant.sysj line: 42, column: 43
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
      S678=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S678=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread700(int [] tdone, int [] ends){
        S694=1;
    thread701(tdone,ends);
    thread702(tdone,ends);
    int biggest703 = 0;
    if(ends[5]>=biggest703){
      biggest703=ends[5];
    }
    if(ends[6]>=biggest703){
      biggest703=ends[6];
    }
    if(biggest703 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread699(int [] tdone, int [] ends){
        S676=1;
    S630=0;
    dosUnitEvac.setPresent();//sysj\fillerPlant.sysj line: 27, column: 17
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread698(int [] tdone, int [] ends){
        S623=1;
    S601=0;
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
      switch(S696){
        case 0 : 
          S696=0;
          break RUN;
        
        case 1 : 
          S696=2;
          S696=2;
          thread698(tdone,ends);
          thread699(tdone,ends);
          thread700(tdone,ends);
          int biggest704 = 0;
          if(ends[2]>=biggest704){
            biggest704=ends[2];
          }
          if(ends[3]>=biggest704){
            biggest704=ends[3];
          }
          if(ends[4]>=biggest704){
            biggest704=ends[4];
          }
          if(biggest704 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread705(tdone,ends);
          thread706(tdone,ends);
          thread707(tdone,ends);
          int biggest711 = 0;
          if(ends[2]>=biggest711){
            biggest711=ends[2];
          }
          if(ends[3]>=biggest711){
            biggest711=ends[3];
          }
          if(ends[4]>=biggest711){
            biggest711=ends[4];
          }
          if(biggest711 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest711 == 0){
            S696=0;
            active[1]=0;
            ends[1]=0;
            S696=0;
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
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
