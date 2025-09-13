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
  private int S835 = 1;
  private int S710 = 1;
  private int S674 = 1;
  private int S751 = 1;
  private int S715 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread1403(int [] tdone, int [] ends){
        switch(S751){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S715){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 266, column: 12
              S715=1;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 267, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            S715=1;
            S715=2;
            valveInletOnOff.setPresent();//sysj\controller.sysj line: 273, column: 8
            currsigs.addElement(valveInletOnOff);
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 272, column: 12
              S715=0;
              valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 267, column: 8
              currsigs.addElement(valveInjectorOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj\controller.sysj line: 273, column: 8
              currsigs.addElement(valveInletOnOff);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1402(int [] tdone, int [] ends){
        switch(S710){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S674){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 250, column: 12
              S674=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 251, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            S674=1;
            S674=2;
            dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 257, column: 8
            currsigs.addElement(dosUnitValveExtend);
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 2 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 256, column: 12
              S674=0;
              dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 251, column: 8
              currsigs.addElement(dosUnitValveRetract);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 257, column: 8
              currsigs.addElement(dosUnitValveExtend);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1400(int [] tdone, int [] ends){
        S751=1;
    S715=0;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 267, column: 8
    currsigs.addElement(valveInjectorOnOff);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1399(int [] tdone, int [] ends){
        S710=1;
    S674=0;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 251, column: 8
    currsigs.addElement(dosUnitValveRetract);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S835){
        case 0 : 
          S835=0;
          break RUN;
        
        case 1 : 
          S835=2;
          S835=2;
          System.out.println("filler Controller started");//sysj\controller.sysj line: 244, column: 2
          thread1399(tdone,ends);
          thread1400(tdone,ends);
          int biggest1401 = 0;
          if(ends[10]>=biggest1401){
            biggest1401=ends[10];
          }
          if(ends[11]>=biggest1401){
            biggest1401=ends[11];
          }
          if(biggest1401 == 1){
            active[9]=1;
            ends[9]=1;
            break RUN;
          }
        
        case 2 : 
          thread1402(tdone,ends);
          thread1403(tdone,ends);
          int biggest1404 = 0;
          if(ends[10]>=biggest1404){
            biggest1404=ends[10];
          }
          if(ends[11]>=biggest1404){
            biggest1404=ends[11];
          }
          if(biggest1404 == 1){
            active[9]=1;
            ends[9]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1404 == 0){
            S835=0;
            active[9]=0;
            ends[9]=0;
            S835=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[9] != 0){
      int index = 9;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[9]!=0 || suspended[9]!=0 || active[9]!=1);
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
      if(paused[9]!=0 || suspended[9]!=0 || active[9]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[9] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
