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
  private int S2243 = 1;
  private int S2118 = 1;
  private int S2082 = 1;
  private int S2159 = 1;
  private int S2123 = 1;
  
  private int[] ends = new int[21];
  private int[] tdone = new int[21];
  
  public void thread2836(int [] tdone, int [] ends){
        switch(S2159){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S2123){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 313, column: 12
              S2123=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 314, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            S2123=1;
            S2123=2;
            valveInletOnOff.setPresent();//sysj\controller.sysj line: 320, column: 8
            currsigs.addElement(valveInletOnOff);
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 319, column: 12
              S2123=0;
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 314, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\controller.sysj line: 320, column: 8
              currsigs.addElement(valveInletOnOff);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2835(int [] tdone, int [] ends){
        switch(S2118){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S2082){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 297, column: 12
              S2082=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 298, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            S2082=1;
            S2082=2;
            dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 304, column: 8
            currsigs.addElement(dosUnitValveExtend);
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 303, column: 12
              S2082=0;
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 298, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 304, column: 8
              currsigs.addElement(dosUnitValveExtend);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2833(int [] tdone, int [] ends){
        S2159=1;
    S2123=0;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 314, column: 8
    currsigs.addElement(valveInjectorOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2832(int [] tdone, int [] ends){
        S2118=1;
    S2082=0;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 298, column: 8
    currsigs.addElement(dosUnitValveRetract);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2243){
        case 0 : 
          S2243=0;
          break RUN;
        
        case 1 : 
          S2243=2;
          S2243=2;
          System.out.println("filler Controller started");//sysj\controller.sysj line: 291, column: 2
          thread2832(tdone,ends);
          thread2833(tdone,ends);
          int biggest2834 = 0;
          if(ends[16]>=biggest2834){
            biggest2834=ends[16];
          }
          if(ends[17]>=biggest2834){
            biggest2834=ends[17];
          }
          if(biggest2834 == 1){
            active[15]=1;
            ends[15]=1;
            break RUN;
          }
        
        case 2 : 
          thread2835(tdone,ends);
          thread2836(tdone,ends);
          int biggest2837 = 0;
          if(ends[16]>=biggest2837){
            biggest2837=ends[16];
          }
          if(ends[17]>=biggest2837){
            biggest2837=ends[17];
          }
          if(biggest2837 == 1){
            active[15]=1;
            ends[15]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2837 == 0){
            S2243=0;
            active[15]=0;
            ends[15]=0;
            S2243=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[15] != 0){
      int index = 15;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[15]!=0 || suspended[15]!=0 || active[15]!=1);
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
      if(paused[15]!=0 || suspended[15]!=0 || active[15]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[15] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
