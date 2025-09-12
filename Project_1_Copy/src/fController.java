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
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private int S584 = 1;
  private int S459 = 1;
  private int S423 = 1;
  private int S500 = 1;
  private int S464 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread590(int [] tdone, int [] ends){
        switch(S500){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S464){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 31, column: 12
              S464=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 32, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            S464=1;
            S464=2;
            valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 38, column: 8
            currsigs.addElement(valveInletOnOff);
            System.out.println("Emitted valveInletOnOff");
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 37, column: 12
              S464=0;
              valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 32, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 38, column: 8
              currsigs.addElement(valveInletOnOff);
              System.out.println("Emitted valveInletOnOff");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread589(int [] tdone, int [] ends){
        switch(S459){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S423){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 15, column: 12
              S423=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 16, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            S423=1;
            S423=2;
            dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 22, column: 8
            currsigs.addElement(dosUnitValveExtend);
            System.out.println("Emitted dosUnitValveExtend");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 21, column: 12
              S423=0;
              dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 16, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 22, column: 8
              currsigs.addElement(dosUnitValveExtend);
              System.out.println("Emitted dosUnitValveExtend");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread587(int [] tdone, int [] ends){
        S500=1;
    S464=0;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 32, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread586(int [] tdone, int [] ends){
        S459=1;
    S423=0;
    dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 16, column: 8
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
      switch(S584){
        case 0 : 
          S584=0;
          break RUN;
        
        case 1 : 
          S584=2;
          S584=2;
          System.out.println("filler Controller started");//sysj\fillerController.sysj line: 9, column: 2
          thread586(tdone,ends);
          thread587(tdone,ends);
          int biggest588 = 0;
          if(ends[2]>=biggest588){
            biggest588=ends[2];
          }
          if(ends[3]>=biggest588){
            biggest588=ends[3];
          }
          if(biggest588 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread589(tdone,ends);
          thread590(tdone,ends);
          int biggest591 = 0;
          if(ends[2]>=biggest591){
            biggest591=ends[2];
          }
          if(ends[3]>=biggest591){
            biggest591=ends[3];
          }
          if(biggest591 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest591 == 0){
            S584=0;
            active[1]=0;
            ends[1]=0;
            S584=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
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
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
