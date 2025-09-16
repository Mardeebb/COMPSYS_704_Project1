import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class fController extends ClockDomain{
  public fController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal startFilling = new Signal("startFilling", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal filled = new Signal("filled", Signal.OUTPUT);
  private int S4461 = 1;
  private int S4175 = 1;
  private int S4180 = 1;
  private int S4185 = 1;
  private int S4202 = 1;
  private int S4207 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4473(int [] tdone, int [] ends){
        switch(S4207){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 35, column: 8
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread4472(int [] tdone, int [] ends){
        switch(S4202){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 31, column: 12
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread4470(int [] tdone, int [] ends){
        S4207=1;
    valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 35, column: 8
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4469(int [] tdone, int [] ends){
        S4202=1;
    dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 31, column: 12
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4467(int [] tdone, int [] ends){
        switch(S4185){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 23, column: 8
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread4466(int [] tdone, int [] ends){
        switch(S4180){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 19, column: 12
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread4464(int [] tdone, int [] ends){
        S4185=1;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 23, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4463(int [] tdone, int [] ends){
        S4180=1;
    dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 19, column: 12
    currsigs.addElement(dosUnitValveRetract);
    System.out.println("Emitted dosUnitValveRetract");
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
      switch(S4461){
        case 0 : 
          S4461=0;
          break RUN;
        
        case 1 : 
          S4461=2;
          S4461=2;
          System.out.println("filler Controller started");//sysj\fillerController.sysj line: 9, column: 2
          S4175=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S4175){
            case 0 : 
              if(startFilling.getprestatus()){//sysj\fillerController.sysj line: 13, column: 12
                S4175=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              if(bottleAtPos2.getprestatus()){//sysj\fillerController.sysj line: 14, column: 12
                S4175=2;
                thread4463(tdone,ends);
                thread4464(tdone,ends);
                int biggest4465 = 0;
                if(ends[2]>=biggest4465){
                  biggest4465=ends[2];
                }
                if(ends[3]>=biggest4465){
                  biggest4465=ends[3];
                }
                if(biggest4465 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 17, column: 12
                S4175=3;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4466(tdone,ends);
                thread4467(tdone,ends);
                int biggest4468 = 0;
                if(ends[2]>=biggest4468){
                  biggest4468=ends[2];
                }
                if(ends[3]>=biggest4468){
                  biggest4468=ends[3];
                }
                if(biggest4468 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4468 == 0){
                  S4175=3;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S4175=3;
              S4175=4;
              thread4469(tdone,ends);
              thread4470(tdone,ends);
              int biggest4471 = 0;
              if(ends[4]>=biggest4471){
                biggest4471=ends[4];
              }
              if(ends[5]>=biggest4471){
                biggest4471=ends[5];
              }
              if(biggest4471 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 4 : 
              if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 29, column: 12
                S4175=5;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4472(tdone,ends);
                thread4473(tdone,ends);
                int biggest4474 = 0;
                if(ends[4]>=biggest4474){
                  biggest4474=ends[4];
                }
                if(ends[5]>=biggest4474){
                  biggest4474=ends[5];
                }
                if(biggest4474 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4474 == 0){
                  S4175=5;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              S4175=5;
              filled.setPresent();//sysj\fillerController.sysj line: 40, column: 6
              currsigs.addElement(filled);
              System.out.println("Emitted filled");
              S4175=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          startFilling.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      startFilling.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filled.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = startFilling.getStatus() ? startFilling.setprepresent() : startFilling.setpreclear();
      startFilling.setpreval(startFilling.getValue());
      startFilling.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      filled.sethook();
      filled.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        startFilling.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
