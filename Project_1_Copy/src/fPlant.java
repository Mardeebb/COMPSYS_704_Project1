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
  private int S1452 = 1;
  private int S1379 = 1;
  private int S1357 = 1;
  private int S1432 = 1;
  private int S1386 = 1;
  private int S1450 = 1;
  private int S1440 = 1;
  private int S1448 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread1717(int [] tdone, int [] ends){
        switch(S1448){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 314, column: 30
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 314, column: 45
          currsigs.addElement(dosUnitFilledE);
          System.out.println("Emitted dosUnitFilledE");
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        else {
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread1716(int [] tdone, int [] ends){
        switch(S1440){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 312, column: 30
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 312, column: 43
          currsigs.addElement(dosUnitEvacE);
          System.out.println("Emitted dosUnitEvacE");
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        break;
      
    }
  }

  public void thread1715(int [] tdone, int [] ends){
        switch(S1450){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        thread1716(tdone,ends);
        thread1717(tdone,ends);
        int biggest1718 = 0;
        if(ends[15]>=biggest1718){
          biggest1718=ends[15];
        }
        if(ends[16]>=biggest1718){
          biggest1718=ends[16];
        }
        if(biggest1718 == 1){
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        //FINXME code
        if(biggest1718 == 0){
          S1450=0;
          active[14]=0;
          ends[14]=0;
          tdone[14]=1;
        }
        break;
      
    }
  }

  public void thread1714(int [] tdone, int [] ends){
        switch(S1432){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1386){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 296, column: 19
              S1386=1;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 297, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 299, column: 19
              S1386=2;
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 303, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 302, column: 19
              S1386=3;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 303, column: 17
              currsigs.addElement(dosUnitFilled);
              System.out.println("Emitted dosUnitFilled");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 305, column: 19
              S1386=0;
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 297, column: 17
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1713(int [] tdone, int [] ends){
        switch(S1379){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1357){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 283, column: 19
              S1357=1;
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 285, column: 17
              currsigs.addElement(bottleAtPos2);
              System.out.println("Emitted bottleAtPos2");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 284, column: 19
              S1357=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 285, column: 17
              currsigs.addElement(bottleAtPos2);
              System.out.println("Emitted bottleAtPos2");
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1710(int [] tdone, int [] ends){
        S1448=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 314, column: 30
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 314, column: 45
      currsigs.addElement(dosUnitFilledE);
      System.out.println("Emitted dosUnitFilledE");
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread1709(int [] tdone, int [] ends){
        S1440=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 312, column: 30
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 312, column: 43
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread1708(int [] tdone, int [] ends){
        S1450=1;
    thread1709(tdone,ends);
    thread1710(tdone,ends);
    int biggest1711 = 0;
    if(ends[15]>=biggest1711){
      biggest1711=ends[15];
    }
    if(ends[16]>=biggest1711){
      biggest1711=ends[16];
    }
    if(biggest1711 == 1){
      active[14]=1;
      ends[14]=1;
      tdone[14]=1;
    }
  }

  public void thread1707(int [] tdone, int [] ends){
        S1432=1;
    S1386=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 297, column: 17
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread1706(int [] tdone, int [] ends){
        S1379=1;
    S1357=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1452){
        case 0 : 
          S1452=0;
          break RUN;
        
        case 1 : 
          S1452=2;
          S1452=2;
          thread1706(tdone,ends);
          thread1707(tdone,ends);
          thread1708(tdone,ends);
          int biggest1712 = 0;
          if(ends[12]>=biggest1712){
            biggest1712=ends[12];
          }
          if(ends[13]>=biggest1712){
            biggest1712=ends[13];
          }
          if(ends[14]>=biggest1712){
            biggest1712=ends[14];
          }
          if(biggest1712 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
        
        case 2 : 
          thread1713(tdone,ends);
          thread1714(tdone,ends);
          thread1715(tdone,ends);
          int biggest1719 = 0;
          if(ends[12]>=biggest1719){
            biggest1719=ends[12];
          }
          if(ends[13]>=biggest1719){
            biggest1719=ends[13];
          }
          if(ends[14]>=biggest1719){
            biggest1719=ends[14];
          }
          if(biggest1719 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1719 == 0){
            S1452=0;
            active[11]=0;
            ends[11]=0;
            S1452=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[11] != 0){
      int index = 11;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[11]!=0 || suspended[11]!=0 || active[11]!=1);
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
      if(paused[11]!=0 || suspended[11]!=0 || active[11]!=1);
      else{
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[11] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
