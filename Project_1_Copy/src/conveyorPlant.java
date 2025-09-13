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
  private Signal conveyorMove_14;
  private Signal posZero_14;
  private Signal posOne_14;
  private Signal posFive_14;
  private Signal posSeven_14;
  private BottleTwin bZero_thread_15;//sysj\plant.sysj line: 259, column: 5
  private BottleTwin bFive_thread_15;//sysj\plant.sysj line: 260, column: 5
  private BottleTwin b_thread_16;//sysj\plant.sysj line: 283, column: 4
  private int id_thread_16;//sysj\plant.sysj line: 287, column: 4
  private BottleTwin b_thread_17;//sysj\plant.sysj line: 299, column: 4
  private int id_thread_17;//sysj\plant.sysj line: 303, column: 4
  private BottleTwin b_thread_19;//sysj\plant.sysj line: 323, column: 4
  private int id_thread_19;//sysj\plant.sysj line: 324, column: 4
  private int S1975 = 1;
  private int S1893 = 1;
  private int S1643 = 1;
  private int S1901 = 1;
  private int S1909 = 1;
  private int S1917 = 1;
  private int S1973 = 1;
  private int S1919 = 1;
  
  private int[] ends = new int[26];
  private int[] tdone = new int[26];
  
  public void thread2118(int [] tdone, int [] ends){
        switch(S1973){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1919){
          case 0 : 
            if(posOne_14.getprestatus()){//sysj\plant.sysj line: 322, column: 10
              b_thread_19 = (BottleTwin)(posOne_14.getpreval() == null ? null : ((BottleTwin)posOne_14.getpreval()));//sysj\plant.sysj line: 323, column: 4
              id_thread_19 = b_thread_19.ID;//sysj\plant.sysj line: 324, column: 4
              S1919=1;
              pos1.setPresent();//sysj\plant.sysj line: 326, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_19);//sysj\plant.sysj line: 326, column: 5
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 327, column: 5
              currsigs.addElement(bottleAtPos1);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\plant.sysj line: 325, column: 10
              S1919=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 327, column: 5
              currsigs.addElement(bottleAtPos1);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2117(int [] tdone, int [] ends){
        switch(S1917){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 313, column: 10
          posOne_14.setPresent();//sysj\plant.sysj line: 314, column: 4
          currsigs.addElement(posOne_14);
          posOne_14.setValue(null);//sysj\plant.sysj line: 314, column: 4
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        else {
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        break;
      
    }
  }

  public void thread2116(int [] tdone, int [] ends){
        switch(S1909){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 298, column: 10
          b_thread_17 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 299, column: 4
          id_thread_17 = b_thread_17.ID;//sysj\plant.sysj line: 303, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 304, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_17);//sysj\plant.sysj line: 304, column: 4
          posFive_14.setPresent();//sysj\plant.sysj line: 305, column: 4
          currsigs.addElement(posFive_14);
          posFive_14.setValue(b_thread_17);//sysj\plant.sysj line: 305, column: 4
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        else {
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        break;
      
    }
  }

  public void thread2115(int [] tdone, int [] ends){
        switch(S1901){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 282, column: 10
          b_thread_16 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 283, column: 4
          id_thread_16 = b_thread_16.ID;//sysj\plant.sysj line: 287, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 288, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_16);//sysj\plant.sysj line: 288, column: 4
          posZero_14.setPresent();//sysj\plant.sysj line: 289, column: 4
          currsigs.addElement(posZero_14);
          posZero_14.setValue(b_thread_16);//sysj\plant.sysj line: 289, column: 4
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        else {
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread2114(int [] tdone, int [] ends){
        switch(S1893){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1643){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 256, column: 10
              S1643=1;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 257, column: 10
              bZero_thread_15 = (BottleTwin)(posZero_14.getpreval() == null ? null : ((BottleTwin)posZero_14.getpreval()));//sysj\plant.sysj line: 259, column: 5
              bFive_thread_15 = (BottleTwin)(posFive_14.getpreval() == null ? null : ((BottleTwin)posFive_14.getpreval()));//sysj\plant.sysj line: 260, column: 5
              if(bZero_thread_15 != null){//sysj\plant.sysj line: 262, column: 8
                posOne_14.setPresent();//sysj\plant.sysj line: 263, column: 6
                currsigs.addElement(posOne_14);
                posOne_14.setValue(bZero_thread_15);//sysj\plant.sysj line: 263, column: 6
                posZero_14.setPresent();//sysj\plant.sysj line: 264, column: 6
                currsigs.addElement(posZero_14);
                posZero_14.setValue(null);//sysj\plant.sysj line: 264, column: 6
                pos0.setPresent();//sysj\plant.sysj line: 265, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 265, column: 6
                if(bFive_thread_15 != null){//sysj\plant.sysj line: 268, column: 8
                  posSeven_14.setPresent();//sysj\plant.sysj line: 269, column: 6
                  currsigs.addElement(posSeven_14);
                  posSeven_14.setValue(bFive_thread_15);//sysj\plant.sysj line: 269, column: 6
                  posFive_14.setPresent();//sysj\plant.sysj line: 270, column: 6
                  currsigs.addElement(posFive_14);
                  posFive_14.setValue(null);//sysj\plant.sysj line: 270, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 271, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 271, column: 6
                  S1643=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1643=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                if(bFive_thread_15 != null){//sysj\plant.sysj line: 268, column: 8
                  posSeven_14.setPresent();//sysj\plant.sysj line: 269, column: 6
                  currsigs.addElement(posSeven_14);
                  posSeven_14.setValue(bFive_thread_15);//sysj\plant.sysj line: 269, column: 6
                  posFive_14.setPresent();//sysj\plant.sysj line: 270, column: 6
                  currsigs.addElement(posFive_14);
                  posFive_14.setValue(null);//sysj\plant.sysj line: 270, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 271, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 271, column: 6
                  S1643=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1643=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2112(int [] tdone, int [] ends){
        S1973=1;
    S1919=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2111(int [] tdone, int [] ends){
        S1917=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2110(int [] tdone, int [] ends){
        S1909=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2109(int [] tdone, int [] ends){
        S1901=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2108(int [] tdone, int [] ends){
        S1893=1;
    S1643=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1975){
        case 0 : 
          S1975=0;
          break RUN;
        
        case 1 : 
          S1975=2;
          S1975=2;
          conveyorMove_14.setClear();//sysj\plant.sysj line: 252, column: 2
          posZero_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posOne_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posSeven_14.setClear();//sysj\plant.sysj line: 253, column: 2
          thread2108(tdone,ends);
          thread2109(tdone,ends);
          thread2110(tdone,ends);
          thread2111(tdone,ends);
          thread2112(tdone,ends);
          int biggest2113 = 0;
          if(ends[15]>=biggest2113){
            biggest2113=ends[15];
          }
          if(ends[16]>=biggest2113){
            biggest2113=ends[16];
          }
          if(ends[17]>=biggest2113){
            biggest2113=ends[17];
          }
          if(ends[18]>=biggest2113){
            biggest2113=ends[18];
          }
          if(ends[19]>=biggest2113){
            biggest2113=ends[19];
          }
          if(biggest2113 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_14.setClear();//sysj\plant.sysj line: 252, column: 2
          posZero_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posOne_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 253, column: 2
          posSeven_14.setClear();//sysj\plant.sysj line: 253, column: 2
          thread2114(tdone,ends);
          thread2115(tdone,ends);
          thread2116(tdone,ends);
          thread2117(tdone,ends);
          thread2118(tdone,ends);
          int biggest2119 = 0;
          if(ends[15]>=biggest2119){
            biggest2119=ends[15];
          }
          if(ends[16]>=biggest2119){
            biggest2119=ends[16];
          }
          if(ends[17]>=biggest2119){
            biggest2119=ends[17];
          }
          if(ends[18]>=biggest2119){
            biggest2119=ends[18];
          }
          if(ends[19]>=biggest2119){
            biggest2119=ends[19];
          }
          if(biggest2119 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2119 == 0){
            S1975=0;
            active[14]=0;
            ends[14]=0;
            S1975=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_14 = new Signal();
    posZero_14 = new Signal();
    posOne_14 = new Signal();
    posFive_14 = new Signal();
    posSeven_14 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[14] != 0){
      int index = 14;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
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
      conveyorMove_14.setpreclear();
      posZero_14.setpreclear();
      posOne_14.setpreclear();
      posFive_14.setpreclear();
      posSeven_14.setpreclear();
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
      conveyorMove_14.setClear();
      posZero_14.setClear();
      posOne_14.setClear();
      posFive_14.setClear();
      posSeven_14.setClear();
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[14] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
