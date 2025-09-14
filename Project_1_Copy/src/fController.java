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
  public Signal Filled = new Signal("Filled", Signal.OUTPUT);
  private int S3243 = 1;
  private int S2861 = 1;
  private int S2866 = 1;
  private int S2871 = 1;
  private int S2888 = 1;
  private int S2893 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread3255(int [] tdone, int [] ends){
        switch(S2893){
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

  public void thread3254(int [] tdone, int [] ends){
        switch(S2888){
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

  public void thread3252(int [] tdone, int [] ends){
        S2893=1;
    valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 35, column: 8
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3251(int [] tdone, int [] ends){
        S2888=1;
    dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 31, column: 12
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3249(int [] tdone, int [] ends){
        switch(S2871){
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

  public void thread3248(int [] tdone, int [] ends){
        switch(S2866){
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

  public void thread3246(int [] tdone, int [] ends){
        S2871=1;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 23, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3245(int [] tdone, int [] ends){
        S2866=1;
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
      switch(S3243){
        case 0 : 
          S3243=0;
          break RUN;
        
        case 1 : 
          S3243=2;
          S3243=2;
          System.out.println("filler Controller started");//sysj\fillerController.sysj line: 9, column: 2
          S2861=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S2861){
            case 0 : 
              if(startFilling.getprestatus()){//sysj\fillerController.sysj line: 13, column: 12
                S2861=1;
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
                S2861=2;
                thread3245(tdone,ends);
                thread3246(tdone,ends);
                int biggest3247 = 0;
                if(ends[2]>=biggest3247){
                  biggest3247=ends[2];
                }
                if(ends[3]>=biggest3247){
                  biggest3247=ends[3];
                }
                if(biggest3247 == 1){
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
                S2861=3;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread3248(tdone,ends);
                thread3249(tdone,ends);
                int biggest3250 = 0;
                if(ends[2]>=biggest3250){
                  biggest3250=ends[2];
                }
                if(ends[3]>=biggest3250){
                  biggest3250=ends[3];
                }
                if(biggest3250 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest3250 == 0){
                  S2861=3;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S2861=3;
              S2861=4;
              thread3251(tdone,ends);
              thread3252(tdone,ends);
              int biggest3253 = 0;
              if(ends[4]>=biggest3253){
                biggest3253=ends[4];
              }
              if(ends[5]>=biggest3253){
                biggest3253=ends[5];
              }
              if(biggest3253 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 4 : 
              if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 29, column: 12
                Filled.setPresent();//sysj\fillerController.sysj line: 38, column: 6
                currsigs.addElement(Filled);
                System.out.println("Emitted Filled");
                S2861=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread3254(tdone,ends);
                thread3255(tdone,ends);
                int biggest3256 = 0;
                if(ends[4]>=biggest3256){
                  biggest3256=ends[4];
                }
                if(ends[5]>=biggest3256){
                  biggest3256=ends[5];
                }
                if(biggest3256 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest3256 == 0){
                  Filled.setPresent();//sysj\fillerController.sysj line: 38, column: 6
                  currsigs.addElement(Filled);
                  System.out.println("Emitted Filled");
                  S2861=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
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
      Filled.setpreclear();
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
      Filled.sethook();
      Filled.setClear();
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
