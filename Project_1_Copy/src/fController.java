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
  private int S7255 = 1;
  private int S7130 = 1;
  private int S7094 = 1;
  private int S7171 = 1;
  private int S7135 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread7838(int [] tdone, int [] ends){
        switch(S7171){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S7135){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 307, column: 12
              S7135=1;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 308, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            S7135=1;
            S7135=2;
            valveInletOnOff.setPresent();//sysj\controller.sysj line: 314, column: 8
            currsigs.addElement(valveInletOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 313, column: 12
              S7135=0;
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 308, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\controller.sysj line: 314, column: 8
              currsigs.addElement(valveInletOnOff);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7837(int [] tdone, int [] ends){
        switch(S7130){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S7094){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 291, column: 12
              S7094=1;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 292, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            S7094=1;
            S7094=2;
            dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 298, column: 8
            currsigs.addElement(dosUnitValveExtend);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 297, column: 12
              S7094=0;
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 292, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 298, column: 8
              currsigs.addElement(dosUnitValveExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7835(int [] tdone, int [] ends){
        S7171=1;
    S7135=0;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 308, column: 8
    currsigs.addElement(valveInjectorOnOff);
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread7834(int [] tdone, int [] ends){
        S7130=1;
    S7094=0;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 292, column: 8
    currsigs.addElement(dosUnitValveRetract);
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
      switch(S7255){
        case 0 : 
          S7255=0;
          break RUN;
        
        case 1 : 
          S7255=2;
          S7255=2;
          System.out.println("filler Controller started");//sysj\controller.sysj line: 285, column: 2
          thread7834(tdone,ends);
          thread7835(tdone,ends);
          int biggest7836 = 0;
          if(ends[12]>=biggest7836){
            biggest7836=ends[12];
          }
          if(ends[13]>=biggest7836){
            biggest7836=ends[13];
          }
          if(biggest7836 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
        
        case 2 : 
          thread7837(tdone,ends);
          thread7838(tdone,ends);
          int biggest7839 = 0;
          if(ends[12]>=biggest7839){
            biggest7839=ends[12];
          }
          if(ends[13]>=biggest7839){
            biggest7839=ends[13];
          }
          if(biggest7839 == 1){
            active[11]=1;
            ends[11]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7839 == 0){
            S7255=0;
            active[11]=0;
            ends[11]=0;
            S7255=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
      if(paused[11]!=0 || suspended[11]!=0 || active[11]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[11] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
