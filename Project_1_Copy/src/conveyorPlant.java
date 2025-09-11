import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class conveyorPlant extends ClockDomain{
  public conveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleArriveToZero = new Signal("bottleArriveToZero", Signal.INPUT);
  public Signal bottleArriveToFive = new Signal("bottleArriveToFive", Signal.INPUT);
  public Signal roturn = new Signal("roturn", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  private Signal conveyorMove_5;
  private Signal posZero_5;
  private Signal posOne_5;
  private Signal posFive_5;
  private Signal posSeven_5;
  private BottleTwin bZero_thread_6;//sysj\plant.sysj line: 213, column: 5
  private BottleTwin bFive_thread_6;//sysj\plant.sysj line: 214, column: 5
  private BottleTwin b_thread_7;//sysj\plant.sysj line: 234, column: 4
  private BottleTwin b_thread_8;//sysj\plant.sysj line: 248, column: 4
  private int S554 = 1;
  private int S496 = 1;
  private int S504 = 1;
  private int S512 = 1;
  private int S520 = 1;
  private int S552 = 1;
  private int S530 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread572(int [] tdone, int [] ends){
        switch(S552){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S530){
          case 0 : 
            if(posOne_5.getprestatus()){//sysj\plant.sysj line: 269, column: 10
              S530=1;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 271, column: 5
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\plant.sysj line: 270, column: 10
              S530=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 271, column: 5
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread571(int [] tdone, int [] ends){
        switch(S520){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 260, column: 10
          posOne_5.setPresent();//sysj\plant.sysj line: 261, column: 4
          currsigs.addElement(posOne_5);
          posOne_5.setValue(null);//sysj\plant.sysj line: 261, column: 4
          System.out.println("Emitted posOne_5");
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread570(int [] tdone, int [] ends){
        switch(S512){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 247, column: 10
          b_thread_8 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 248, column: 4
          posFive_5.setPresent();//sysj\plant.sysj line: 252, column: 4
          currsigs.addElement(posFive_5);
          posFive_5.setValue(b_thread_8);//sysj\plant.sysj line: 252, column: 4
          System.out.println("Emitted posFive_5");
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread569(int [] tdone, int [] ends){
        switch(S504){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 233, column: 10
          b_thread_7 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 234, column: 4
          posZero_5.setPresent();//sysj\plant.sysj line: 238, column: 4
          currsigs.addElement(posZero_5);
          posZero_5.setValue(b_thread_7);//sysj\plant.sysj line: 238, column: 4
          System.out.println("Emitted posZero_5");
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread568(int [] tdone, int [] ends){
        switch(S496){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 211, column: 10
          bZero_thread_6 = (BottleTwin)(posZero_5.getpreval() == null ? null : ((BottleTwin)posZero_5.getpreval()));//sysj\plant.sysj line: 213, column: 5
          bFive_thread_6 = (BottleTwin)(posFive_5.getpreval() == null ? null : ((BottleTwin)posFive_5.getpreval()));//sysj\plant.sysj line: 214, column: 5
          if(bZero_thread_6 != null){//sysj\plant.sysj line: 216, column: 8
            posOne_5.setPresent();//sysj\plant.sysj line: 217, column: 6
            currsigs.addElement(posOne_5);
            posOne_5.setValue(bZero_thread_6);//sysj\plant.sysj line: 217, column: 6
            System.out.println("Emitted posOne_5");
            posZero_5.setPresent();//sysj\plant.sysj line: 218, column: 6
            currsigs.addElement(posZero_5);
            posZero_5.setValue(null);//sysj\plant.sysj line: 218, column: 6
            System.out.println("Emitted posZero_5");
            if(bFive_thread_6 != null){//sysj\plant.sysj line: 220, column: 8
              posSeven_5.setPresent();//sysj\plant.sysj line: 221, column: 6
              currsigs.addElement(posSeven_5);
              posSeven_5.setValue(bFive_thread_6);//sysj\plant.sysj line: 221, column: 6
              System.out.println("Emitted posSeven_5");
              posFive_5.setPresent();//sysj\plant.sysj line: 222, column: 6
              currsigs.addElement(posFive_5);
              posFive_5.setValue(null);//sysj\plant.sysj line: 222, column: 6
              System.out.println("Emitted posFive_5");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(bFive_thread_6 != null){//sysj\plant.sysj line: 220, column: 8
              posSeven_5.setPresent();//sysj\plant.sysj line: 221, column: 6
              currsigs.addElement(posSeven_5);
              posSeven_5.setValue(bFive_thread_6);//sysj\plant.sysj line: 221, column: 6
              System.out.println("Emitted posSeven_5");
              posFive_5.setPresent();//sysj\plant.sysj line: 222, column: 6
              currsigs.addElement(posFive_5);
              posFive_5.setValue(null);//sysj\plant.sysj line: 222, column: 6
              System.out.println("Emitted posFive_5");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread566(int [] tdone, int [] ends){
        S552=1;
    S530=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread565(int [] tdone, int [] ends){
        S520=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread564(int [] tdone, int [] ends){
        S512=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread563(int [] tdone, int [] ends){
        S504=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread562(int [] tdone, int [] ends){
        S496=1;
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
      switch(S554){
        case 0 : 
          S554=0;
          break RUN;
        
        case 1 : 
          S554=2;
          S554=2;
          conveyorMove_5.setClear();//sysj\plant.sysj line: 207, column: 2
          posZero_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posOne_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posFive_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posSeven_5.setClear();//sysj\plant.sysj line: 208, column: 2
          thread562(tdone,ends);
          thread563(tdone,ends);
          thread564(tdone,ends);
          thread565(tdone,ends);
          thread566(tdone,ends);
          int biggest567 = 0;
          if(ends[6]>=biggest567){
            biggest567=ends[6];
          }
          if(ends[7]>=biggest567){
            biggest567=ends[7];
          }
          if(ends[8]>=biggest567){
            biggest567=ends[8];
          }
          if(ends[9]>=biggest567){
            biggest567=ends[9];
          }
          if(ends[10]>=biggest567){
            biggest567=ends[10];
          }
          if(biggest567 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_5.setClear();//sysj\plant.sysj line: 207, column: 2
          posZero_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posOne_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posFive_5.setClear();//sysj\plant.sysj line: 208, column: 2
          posSeven_5.setClear();//sysj\plant.sysj line: 208, column: 2
          thread568(tdone,ends);
          thread569(tdone,ends);
          thread570(tdone,ends);
          thread571(tdone,ends);
          thread572(tdone,ends);
          int biggest573 = 0;
          if(ends[6]>=biggest573){
            biggest573=ends[6];
          }
          if(ends[7]>=biggest573){
            biggest573=ends[7];
          }
          if(ends[8]>=biggest573){
            biggest573=ends[8];
          }
          if(ends[9]>=biggest573){
            biggest573=ends[9];
          }
          if(ends[10]>=biggest573){
            biggest573=ends[10];
          }
          if(biggest573 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
          //FINXME code
          if(biggest573 == 0){
            S554=0;
            active[5]=0;
            ends[5]=0;
            S554=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_5 = new Signal();
    posZero_5 = new Signal();
    posOne_5 = new Signal();
    posFive_5 = new Signal();
    posSeven_5 = new Signal();
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
          motConveyorOnOff.gethook();
          enable.gethook();
          bottleArriveToZero.gethook();
          bottleArriveToFive.gethook();
          roturn.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOnOff.setpreclear();
      enable.setpreclear();
      bottleArriveToZero.setpreclear();
      bottleArriveToFive.setpreclear();
      roturn.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      conveyorMove_5.setpreclear();
      posZero_5.setpreclear();
      posOne_5.setpreclear();
      posFive_5.setpreclear();
      posSeven_5.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOnOff.getStatus() ? motConveyorOnOff.setprepresent() : motConveyorOnOff.setpreclear();
      motConveyorOnOff.setpreval(motConveyorOnOff.getValue());
      motConveyorOnOff.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleArriveToZero.getStatus() ? bottleArriveToZero.setprepresent() : bottleArriveToZero.setpreclear();
      bottleArriveToZero.setpreval(bottleArriveToZero.getValue());
      bottleArriveToZero.setClear();
      dummyint = bottleArriveToFive.getStatus() ? bottleArriveToFive.setprepresent() : bottleArriveToFive.setpreclear();
      bottleArriveToFive.setpreval(bottleArriveToFive.getValue());
      bottleArriveToFive.setClear();
      dummyint = roturn.getStatus() ? roturn.setprepresent() : roturn.setpreclear();
      roturn.setpreval(roturn.getValue());
      roturn.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      conveyorMove_5.setClear();
      posZero_5.setClear();
      posOne_5.setClear();
      posFive_5.setClear();
      posSeven_5.setClear();
      if(paused[5]!=0 || suspended[5]!=0 || active[5]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[5] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
