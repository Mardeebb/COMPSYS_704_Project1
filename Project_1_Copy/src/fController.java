import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\fillerController.sysj line: 1, column: 1

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
  private BottleTwin b_thread_1;//sysj\fillerController.sysj line: 17, column: 3
  private int S4597 = 1;
  private int S4047 = 1;
  private int S4052 = 1;
  private int S4057 = 1;
  private int S4074 = 1;
  private int S4079 = 1;
  private int S4096 = 1;
  private int S4101 = 1;
  private int S4118 = 1;
  private int S4123 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread4621(int [] tdone, int [] ends){
        switch(S4123){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 72, column: 8
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread4620(int [] tdone, int [] ends){
        switch(S4118){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 68, column: 12
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread4618(int [] tdone, int [] ends){
        S4123=1;
    valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 72, column: 8
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread4617(int [] tdone, int [] ends){
        S4118=1;
    dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 68, column: 12
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread4615(int [] tdone, int [] ends){
        switch(S4101){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 60, column: 8
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread4614(int [] tdone, int [] ends){
        switch(S4096){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 56, column: 12
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread4612(int [] tdone, int [] ends){
        S4101=1;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 60, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread4611(int [] tdone, int [] ends){
        S4096=1;
    dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 56, column: 12
    currsigs.addElement(dosUnitValveRetract);
    System.out.println("Emitted dosUnitValveRetract");
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread4609(int [] tdone, int [] ends){
        switch(S4079){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 48, column: 8
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread4608(int [] tdone, int [] ends){
        switch(S4074){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 44, column: 12
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread4606(int [] tdone, int [] ends){
        S4079=1;
    valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 48, column: 8
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread4605(int [] tdone, int [] ends){
        S4074=1;
    dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 44, column: 12
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4603(int [] tdone, int [] ends){
        switch(S4057){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 36, column: 8
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread4602(int [] tdone, int [] ends){
        switch(S4052){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 32, column: 12
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread4600(int [] tdone, int [] ends){
        S4057=1;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 36, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4599(int [] tdone, int [] ends){
        S4052=1;
    dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 32, column: 12
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
      switch(S4597){
        case 0 : 
          S4597=0;
          break RUN;
        
        case 1 : 
          S4597=2;
          S4597=2;
          System.out.println("filler Controller started");//sysj\fillerController.sysj line: 11, column: 2
          S4047=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S4047){
            case 0 : 
              if(startFilling.getprestatus()){//sysj\fillerController.sysj line: 15, column: 12
                S4047=1;
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
              if(bottleAtPos2.getprestatus()){//sysj\fillerController.sysj line: 16, column: 12
                b_thread_1 = (BottleTwin)(bottleAtPos2.getpreval() == null ? null : ((BottleTwin)bottleAtPos2.getpreval()));//sysj\fillerController.sysj line: 17, column: 3
                if(b_thread_1 != null) {//sysj\fillerController.sysj line: 18, column: 17
                  while(true) {//sysj\fillerController.sysj line: 19, column: 16
                    System.err.println(b_thread_1.recipe[0]);//sysj\fillerController.sysj line: 20, column: 5
                    System.err.println(b_thread_1.recipe[1]);//sysj\fillerController.sysj line: 21, column: 5
                    System.err.println(b_thread_1.recipe[2]);//sysj\fillerController.sysj line: 22, column: 5
                    System.err.println(b_thread_1.recipe[3]);//sysj\fillerController.sysj line: 23, column: 5
                    System.err.println(b_thread_1.recipe[4]);//sysj\fillerController.sysj line: 24, column: 5
                  }
                }
                S4047=2;
                thread4599(tdone,ends);
                thread4600(tdone,ends);
                int biggest4601 = 0;
                if(ends[2]>=biggest4601){
                  biggest4601=ends[2];
                }
                if(ends[3]>=biggest4601){
                  biggest4601=ends[3];
                }
                if(biggest4601 == 1){
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
              if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 30, column: 12
                S4047=3;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4602(tdone,ends);
                thread4603(tdone,ends);
                int biggest4604 = 0;
                if(ends[2]>=biggest4604){
                  biggest4604=ends[2];
                }
                if(ends[3]>=biggest4604){
                  biggest4604=ends[3];
                }
                if(biggest4604 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4604 == 0){
                  S4047=3;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S4047=3;
              S4047=4;
              thread4605(tdone,ends);
              thread4606(tdone,ends);
              int biggest4607 = 0;
              if(ends[4]>=biggest4607){
                biggest4607=ends[4];
              }
              if(ends[5]>=biggest4607){
                biggest4607=ends[5];
              }
              if(biggest4607 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 4 : 
              if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 42, column: 12
                S4047=5;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4608(tdone,ends);
                thread4609(tdone,ends);
                int biggest4610 = 0;
                if(ends[4]>=biggest4610){
                  biggest4610=ends[4];
                }
                if(ends[5]>=biggest4610){
                  biggest4610=ends[5];
                }
                if(biggest4610 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4610 == 0){
                  S4047=5;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              S4047=5;
              S4047=6;
              thread4611(tdone,ends);
              thread4612(tdone,ends);
              int biggest4613 = 0;
              if(ends[6]>=biggest4613){
                biggest4613=ends[6];
              }
              if(ends[7]>=biggest4613){
                biggest4613=ends[7];
              }
              if(biggest4613 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 6 : 
              if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 54, column: 12
                S4047=7;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4614(tdone,ends);
                thread4615(tdone,ends);
                int biggest4616 = 0;
                if(ends[6]>=biggest4616){
                  biggest4616=ends[6];
                }
                if(ends[7]>=biggest4616){
                  biggest4616=ends[7];
                }
                if(biggest4616 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4616 == 0){
                  S4047=7;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 7 : 
              S4047=7;
              S4047=8;
              thread4617(tdone,ends);
              thread4618(tdone,ends);
              int biggest4619 = 0;
              if(ends[8]>=biggest4619){
                biggest4619=ends[8];
              }
              if(ends[9]>=biggest4619){
                biggest4619=ends[9];
              }
              if(biggest4619 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 8 : 
              if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 66, column: 12
                S4047=9;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread4620(tdone,ends);
                thread4621(tdone,ends);
                int biggest4622 = 0;
                if(ends[8]>=biggest4622){
                  biggest4622=ends[8];
                }
                if(ends[9]>=biggest4622){
                  biggest4622=ends[9];
                }
                if(biggest4622 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest4622 == 0){
                  S4047=9;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 9 : 
              S4047=9;
              filled.setPresent();//sysj\fillerController.sysj line: 77, column: 6
              currsigs.addElement(filled);
              System.out.println("Emitted filled");
              S4047=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
