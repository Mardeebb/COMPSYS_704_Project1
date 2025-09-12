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
  public Signal pos0 = new Signal("pos0", Signal.OUTPUT);
  public Signal pos1 = new Signal("pos1", Signal.OUTPUT);
  public Signal pos5 = new Signal("pos5", Signal.OUTPUT);
  public Signal pos7 = new Signal("pos7", Signal.OUTPUT);
  private Signal conveyorMove_5;
  private Signal posZero_5;
  private Signal posOne_5;
  private Signal posFive_5;
  private Signal posSeven_5;
  private BottleTwin bZero_thread_6;//sysj\plant.sysj line: 218, column: 5
  private BottleTwin bFive_thread_6;//sysj\plant.sysj line: 219, column: 5
  private BottleTwin b_thread_7;//sysj\plant.sysj line: 242, column: 4
  private int id_thread_7;//sysj\plant.sysj line: 246, column: 4
  private BottleTwin b_thread_8;//sysj\plant.sysj line: 258, column: 4
  private int id_thread_8;//sysj\plant.sysj line: 262, column: 4
  private BottleTwin b_thread_10;//sysj\plant.sysj line: 282, column: 4
  private int id_thread_10;//sysj\plant.sysj line: 283, column: 4
  private int S792 = 1;
  private int S710 = 1;
  private int S460 = 1;
  private int S718 = 1;
  private int S726 = 1;
  private int S734 = 1;
  private int S790 = 1;
  private int S736 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread915(int [] tdone, int [] ends){
        switch(S790){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S736){
          case 0 : 
            if(posOne_5.getprestatus()){//sysj\plant.sysj line: 281, column: 10
              b_thread_10 = (BottleTwin)(posOne_5.getpreval() == null ? null : ((BottleTwin)posOne_5.getpreval()));//sysj\plant.sysj line: 282, column: 4
              id_thread_10 = b_thread_10.ID;//sysj\plant.sysj line: 283, column: 4
              S736=1;
              pos1.setPresent();//sysj\plant.sysj line: 285, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_10);//sysj\plant.sysj line: 285, column: 5
              System.out.println("Emitted pos1");
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 286, column: 5
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
            if(roturn.getprestatus()){//sysj\plant.sysj line: 284, column: 10
              S736=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 286, column: 5
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

  public void thread914(int [] tdone, int [] ends){
        switch(S734){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 272, column: 10
          posOne_5.setPresent();//sysj\plant.sysj line: 273, column: 4
          currsigs.addElement(posOne_5);
          posOne_5.setValue(null);//sysj\plant.sysj line: 273, column: 4
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

  public void thread913(int [] tdone, int [] ends){
        switch(S726){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 257, column: 10
          b_thread_8 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 258, column: 4
          id_thread_8 = b_thread_8.ID;//sysj\plant.sysj line: 262, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 263, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_8);//sysj\plant.sysj line: 263, column: 4
          System.out.println("Emitted pos5");
          posFive_5.setPresent();//sysj\plant.sysj line: 264, column: 4
          currsigs.addElement(posFive_5);
          posFive_5.setValue(b_thread_8);//sysj\plant.sysj line: 264, column: 4
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

  public void thread912(int [] tdone, int [] ends){
        switch(S718){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 241, column: 10
          b_thread_7 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 242, column: 4
          id_thread_7 = b_thread_7.ID;//sysj\plant.sysj line: 246, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 247, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_7);//sysj\plant.sysj line: 247, column: 4
          System.out.println("Emitted pos0");
          posZero_5.setPresent();//sysj\plant.sysj line: 248, column: 4
          currsigs.addElement(posZero_5);
          posZero_5.setValue(b_thread_7);//sysj\plant.sysj line: 248, column: 4
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

  public void thread911(int [] tdone, int [] ends){
        switch(S710){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S460){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 215, column: 10
              S460=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 216, column: 10
              bZero_thread_6 = (BottleTwin)(posZero_5.getpreval() == null ? null : ((BottleTwin)posZero_5.getpreval()));//sysj\plant.sysj line: 218, column: 5
              bFive_thread_6 = (BottleTwin)(posFive_5.getpreval() == null ? null : ((BottleTwin)posFive_5.getpreval()));//sysj\plant.sysj line: 219, column: 5
              if(bZero_thread_6 != null){//sysj\plant.sysj line: 221, column: 8
                posOne_5.setPresent();//sysj\plant.sysj line: 222, column: 6
                currsigs.addElement(posOne_5);
                posOne_5.setValue(bZero_thread_6);//sysj\plant.sysj line: 222, column: 6
                System.out.println("Emitted posOne_5");
                posZero_5.setPresent();//sysj\plant.sysj line: 223, column: 6
                currsigs.addElement(posZero_5);
                posZero_5.setValue(null);//sysj\plant.sysj line: 223, column: 6
                System.out.println("Emitted posZero_5");
                pos0.setPresent();//sysj\plant.sysj line: 224, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 224, column: 6
                System.out.println("Emitted pos0");
                if(bFive_thread_6 != null){//sysj\plant.sysj line: 227, column: 8
                  posSeven_5.setPresent();//sysj\plant.sysj line: 228, column: 6
                  currsigs.addElement(posSeven_5);
                  posSeven_5.setValue(bFive_thread_6);//sysj\plant.sysj line: 228, column: 6
                  System.out.println("Emitted posSeven_5");
                  posFive_5.setPresent();//sysj\plant.sysj line: 229, column: 6
                  currsigs.addElement(posFive_5);
                  posFive_5.setValue(null);//sysj\plant.sysj line: 229, column: 6
                  System.out.println("Emitted posFive_5");
                  pos5.setPresent();//sysj\plant.sysj line: 230, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 230, column: 6
                  System.out.println("Emitted pos5");
                  S460=0;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S460=0;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
              }
              else {
                if(bFive_thread_6 != null){//sysj\plant.sysj line: 227, column: 8
                  posSeven_5.setPresent();//sysj\plant.sysj line: 228, column: 6
                  currsigs.addElement(posSeven_5);
                  posSeven_5.setValue(bFive_thread_6);//sysj\plant.sysj line: 228, column: 6
                  System.out.println("Emitted posSeven_5");
                  posFive_5.setPresent();//sysj\plant.sysj line: 229, column: 6
                  currsigs.addElement(posFive_5);
                  posFive_5.setValue(null);//sysj\plant.sysj line: 229, column: 6
                  System.out.println("Emitted posFive_5");
                  pos5.setPresent();//sysj\plant.sysj line: 230, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 230, column: 6
                  System.out.println("Emitted pos5");
                  S460=0;
                  active[6]=1;
                  ends[6]=1;
                  tdone[6]=1;
                }
                else {
                  S460=0;
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
        break;
      
    }
  }

  public void thread909(int [] tdone, int [] ends){
        S790=1;
    S736=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread908(int [] tdone, int [] ends){
        S734=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread907(int [] tdone, int [] ends){
        S726=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread906(int [] tdone, int [] ends){
        S718=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread905(int [] tdone, int [] ends){
        S710=1;
    S460=0;
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
      switch(S792){
        case 0 : 
          S792=0;
          break RUN;
        
        case 1 : 
          S792=2;
          S792=2;
          conveyorMove_5.setClear();//sysj\plant.sysj line: 211, column: 2
          posZero_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posOne_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posFive_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posSeven_5.setClear();//sysj\plant.sysj line: 212, column: 2
          thread905(tdone,ends);
          thread906(tdone,ends);
          thread907(tdone,ends);
          thread908(tdone,ends);
          thread909(tdone,ends);
          int biggest910 = 0;
          if(ends[6]>=biggest910){
            biggest910=ends[6];
          }
          if(ends[7]>=biggest910){
            biggest910=ends[7];
          }
          if(ends[8]>=biggest910){
            biggest910=ends[8];
          }
          if(ends[9]>=biggest910){
            biggest910=ends[9];
          }
          if(ends[10]>=biggest910){
            biggest910=ends[10];
          }
          if(biggest910 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_5.setClear();//sysj\plant.sysj line: 211, column: 2
          posZero_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posOne_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posFive_5.setClear();//sysj\plant.sysj line: 212, column: 2
          posSeven_5.setClear();//sysj\plant.sysj line: 212, column: 2
          thread911(tdone,ends);
          thread912(tdone,ends);
          thread913(tdone,ends);
          thread914(tdone,ends);
          thread915(tdone,ends);
          int biggest916 = 0;
          if(ends[6]>=biggest916){
            biggest916=ends[6];
          }
          if(ends[7]>=biggest916){
            biggest916=ends[7];
          }
          if(ends[8]>=biggest916){
            biggest916=ends[8];
          }
          if(ends[9]>=biggest916){
            biggest916=ends[9];
          }
          if(ends[10]>=biggest916){
            biggest916=ends[10];
          }
          if(biggest916 == 1){
            active[5]=1;
            ends[5]=1;
            break RUN;
          }
          //FINXME code
          if(biggest916 == 0){
            S792=0;
            active[5]=0;
            ends[5]=0;
            S792=0;
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
      pos0.setpreclear();
      pos1.setpreclear();
      pos5.setpreclear();
      pos7.setpreclear();
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
      pos0.sethook();
      pos0.setClear();
      pos1.sethook();
      pos1.setClear();
      pos5.sethook();
      pos5.setClear();
      pos7.sethook();
      pos7.setClear();
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
