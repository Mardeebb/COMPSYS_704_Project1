import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

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
  private int S364 = 1;
  private int S239 = 1;
  private int S203 = 1;
  private int S280 = 1;
  private int S244 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread370(int [] tdone, int [] ends){
        switch(S280){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S244){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 230, column: 12
              S244=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            S244=1;
            S244=2;
            valveInletOnOff.setPresent();//sysj\controller.sysj line: 237, column: 8
            currsigs.addElement(valveInletOnOff);
            System.out.println("Emitted valveInletOnOff");
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 236, column: 12
              S244=0;
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\controller.sysj line: 237, column: 8
              currsigs.addElement(valveInletOnOff);
              System.out.println("Emitted valveInletOnOff");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread369(int [] tdone, int [] ends){
        switch(S239){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S203){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 214, column: 12
              S203=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S203=1;
            S203=2;
            dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 221, column: 8
            currsigs.addElement(dosUnitValveExtend);
            System.out.println("Emitted dosUnitValveExtend");
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 220, column: 12
              S203=0;
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 221, column: 8
              currsigs.addElement(dosUnitValveExtend);
              System.out.println("Emitted dosUnitValveExtend");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread367(int [] tdone, int [] ends){
        S280=1;
    S244=0;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread366(int [] tdone, int [] ends){
        S239=1;
    S203=0;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
    currsigs.addElement(dosUnitValveRetract);
    System.out.println("Emitted dosUnitValveRetract");
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S364){
        case 0 : 
          S364=0;
          break RUN;
        
        case 1 : 
          S364=2;
          S364=2;
          System.out.println("filler Controller started");//sysj\controller.sysj line: 208, column: 2
          thread366(tdone,ends);
          thread367(tdone,ends);
          int biggest368 = 0;
          if(ends[6]>=biggest368){
            biggest368=ends[6];
          }
          if(ends[7]>=biggest368){
            biggest368=ends[7];
          }
          if(biggest368 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
        
        case 2 : 
          thread369(tdone,ends);
          thread370(tdone,ends);
          int biggest371 = 0;
          if(ends[6]>=biggest371){
            biggest371=ends[6];
          }
          if(ends[7]>=biggest371){
            biggest371=ends[7];
          }
          if(biggest371 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
          //FINXME code
          if(biggest371 == 0){
            S364=0;
            active[5]=0;
            ends[5]=0;
            S364=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[5] != 0){
      int index = 5;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[5]!=0 || suspended[5]!=0 || active[5]!=1);
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
      if(paused[5]!=0 || suspended[5]!=0 || active[5]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[5] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
