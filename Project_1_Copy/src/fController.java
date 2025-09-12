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
  private int S363 = 1;
  private int S238 = 1;
  private int S202 = 1;
  private int S279 = 1;
  private int S243 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread919(int [] tdone, int [] ends){
        switch(S279){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S243){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 230, column: 12
              S243=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S243=1;
            S243=2;
            valveInletOnOff.setPresent();//sysj\controller.sysj line: 237, column: 8
            currsigs.addElement(valveInletOnOff);
            System.out.println("Emitted valveInletOnOff");
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 236, column: 12
              S243=0;
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
              currsigs.addElement(valveInjectorOnOff);
              System.out.println("Emitted valveInjectorOnOff");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\controller.sysj line: 237, column: 8
              currsigs.addElement(valveInletOnOff);
              System.out.println("Emitted valveInletOnOff");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread918(int [] tdone, int [] ends){
        switch(S238){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S202){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 214, column: 12
              S202=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S202=1;
            S202=2;
            dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 221, column: 8
            currsigs.addElement(dosUnitValveExtend);
            System.out.println("Emitted dosUnitValveExtend");
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 220, column: 12
              S202=0;
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
              currsigs.addElement(dosUnitValveRetract);
              System.out.println("Emitted dosUnitValveRetract");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 221, column: 8
              currsigs.addElement(dosUnitValveExtend);
              System.out.println("Emitted dosUnitValveExtend");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread916(int [] tdone, int [] ends){
        S279=1;
    S243=0;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 231, column: 8
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread915(int [] tdone, int [] ends){
        S238=1;
    S202=0;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 215, column: 8
    currsigs.addElement(dosUnitValveRetract);
    System.out.println("Emitted dosUnitValveRetract");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S363){
        case 0 : 
          S363=0;
          break RUN;
        
        case 1 : 
          S363=2;
          S363=2;
          System.out.println("filler Controller started");//sysj\controller.sysj line: 208, column: 2
          thread915(tdone,ends);
          thread916(tdone,ends);
          int biggest917 = 0;
          if(ends[5]>=biggest917){
            biggest917=ends[5];
          }
          if(ends[6]>=biggest917){
            biggest917=ends[6];
          }
          if(biggest917 == 1){
            active[4]=1;
            ends[4]=1;
            break RUN;
          }
        
        case 2 : 
          thread918(tdone,ends);
          thread919(tdone,ends);
          int biggest920 = 0;
          if(ends[5]>=biggest920){
            biggest920=ends[5];
          }
          if(ends[6]>=biggest920){
            biggest920=ends[6];
          }
          if(biggest920 == 1){
            active[4]=1;
            ends[4]=1;
            break RUN;
          }
          //FINXME code
          if(biggest920 == 0){
            S363=0;
            active[4]=0;
            ends[4]=0;
            S363=0;
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
    while(active[4] != 0){
      int index = 4;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[4]!=0 || suspended[4]!=0 || active[4]!=1);
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
      if(paused[4]!=0 || suspended[4]!=0 || active[4]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[4] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
