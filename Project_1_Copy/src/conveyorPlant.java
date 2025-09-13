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
  private Signal conveyorMove_13;
  private Signal posZero_13;
  private Signal posOne_13;
  private Signal posFive_13;
  private Signal posSeven_13;
  private BottleTwin bZero_thread_14;//sysj\plant.sysj line: 251, column: 5
  private BottleTwin bFive_thread_14;//sysj\plant.sysj line: 252, column: 5
  private BottleTwin b_thread_15;//sysj\plant.sysj line: 275, column: 4
  private int id_thread_15;//sysj\plant.sysj line: 279, column: 4
  private BottleTwin b_thread_16;//sysj\plant.sysj line: 291, column: 4
  private int id_thread_16;//sysj\plant.sysj line: 295, column: 4
  private BottleTwin b_thread_18;//sysj\plant.sysj line: 315, column: 4
  private int id_thread_18;//sysj\plant.sysj line: 316, column: 4
  private int S2022 = 1;
  private int S1940 = 1;
  private int S1690 = 1;
  private int S1948 = 1;
  private int S1956 = 1;
  private int S1964 = 1;
  private int S2020 = 1;
  private int S1966 = 1;
  
  private int[] ends = new int[30];
  private int[] tdone = new int[30];
  
  public void thread2397(int [] tdone, int [] ends){
        switch(S2020){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1966){
          case 0 : 
            if(posOne_13.getprestatus()){//sysj\plant.sysj line: 314, column: 10
              b_thread_18 = (BottleTwin)(posOne_13.getpreval() == null ? null : ((BottleTwin)posOne_13.getpreval()));//sysj\plant.sysj line: 315, column: 4
              id_thread_18 = b_thread_18.ID;//sysj\plant.sysj line: 316, column: 4
              S1966=1;
              pos1.setPresent();//sysj\plant.sysj line: 318, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_18);//sysj\plant.sysj line: 318, column: 5
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 319, column: 5
              currsigs.addElement(bottleAtPos1);
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
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\plant.sysj line: 317, column: 10
              S1966=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 319, column: 5
              currsigs.addElement(bottleAtPos1);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2396(int [] tdone, int [] ends){
        switch(S1964){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 305, column: 10
          posOne_13.setPresent();//sysj\plant.sysj line: 306, column: 4
          currsigs.addElement(posOne_13);
          posOne_13.setValue(null);//sysj\plant.sysj line: 306, column: 4
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

  public void thread2395(int [] tdone, int [] ends){
        switch(S1956){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 290, column: 10
          b_thread_16 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 291, column: 4
          id_thread_16 = b_thread_16.ID;//sysj\plant.sysj line: 295, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 296, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_16);//sysj\plant.sysj line: 296, column: 4
          posFive_13.setPresent();//sysj\plant.sysj line: 297, column: 4
          currsigs.addElement(posFive_13);
          posFive_13.setValue(b_thread_16);//sysj\plant.sysj line: 297, column: 4
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

  public void thread2394(int [] tdone, int [] ends){
        switch(S1948){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 274, column: 10
          b_thread_15 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 275, column: 4
          id_thread_15 = b_thread_15.ID;//sysj\plant.sysj line: 279, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 280, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_15);//sysj\plant.sysj line: 280, column: 4
          posZero_13.setPresent();//sysj\plant.sysj line: 281, column: 4
          currsigs.addElement(posZero_13);
          posZero_13.setValue(b_thread_15);//sysj\plant.sysj line: 281, column: 4
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
      
    }
  }

  public void thread2393(int [] tdone, int [] ends){
        switch(S1940){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1690){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 248, column: 10
              S1690=1;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 249, column: 10
              bZero_thread_14 = (BottleTwin)(posZero_13.getpreval() == null ? null : ((BottleTwin)posZero_13.getpreval()));//sysj\plant.sysj line: 251, column: 5
              bFive_thread_14 = (BottleTwin)(posFive_13.getpreval() == null ? null : ((BottleTwin)posFive_13.getpreval()));//sysj\plant.sysj line: 252, column: 5
              if(bZero_thread_14 != null){//sysj\plant.sysj line: 254, column: 8
                posOne_13.setPresent();//sysj\plant.sysj line: 255, column: 6
                currsigs.addElement(posOne_13);
                posOne_13.setValue(bZero_thread_14);//sysj\plant.sysj line: 255, column: 6
                posZero_13.setPresent();//sysj\plant.sysj line: 256, column: 6
                currsigs.addElement(posZero_13);
                posZero_13.setValue(null);//sysj\plant.sysj line: 256, column: 6
                pos0.setPresent();//sysj\plant.sysj line: 257, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 257, column: 6
                if(bFive_thread_14 != null){//sysj\plant.sysj line: 260, column: 8
                  posSeven_13.setPresent();//sysj\plant.sysj line: 261, column: 6
                  currsigs.addElement(posSeven_13);
                  posSeven_13.setValue(bFive_thread_14);//sysj\plant.sysj line: 261, column: 6
                  posFive_13.setPresent();//sysj\plant.sysj line: 262, column: 6
                  currsigs.addElement(posFive_13);
                  posFive_13.setValue(null);//sysj\plant.sysj line: 262, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 263, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 263, column: 6
                  S1690=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  S1690=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
              else {
                if(bFive_thread_14 != null){//sysj\plant.sysj line: 260, column: 8
                  posSeven_13.setPresent();//sysj\plant.sysj line: 261, column: 6
                  currsigs.addElement(posSeven_13);
                  posSeven_13.setValue(bFive_thread_14);//sysj\plant.sysj line: 261, column: 6
                  posFive_13.setPresent();//sysj\plant.sysj line: 262, column: 6
                  currsigs.addElement(posFive_13);
                  posFive_13.setValue(null);//sysj\plant.sysj line: 262, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 263, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 263, column: 6
                  S1690=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  S1690=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2391(int [] tdone, int [] ends){
        S2020=1;
    S1966=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2390(int [] tdone, int [] ends){
        S1964=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2389(int [] tdone, int [] ends){
        S1956=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2388(int [] tdone, int [] ends){
        S1948=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2387(int [] tdone, int [] ends){
        S1940=1;
    S1690=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2022){
        case 0 : 
          S2022=0;
          break RUN;
        
        case 1 : 
          S2022=2;
          S2022=2;
          conveyorMove_13.setClear();//sysj\plant.sysj line: 244, column: 2
          posZero_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posOne_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posFive_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posSeven_13.setClear();//sysj\plant.sysj line: 245, column: 2
          thread2387(tdone,ends);
          thread2388(tdone,ends);
          thread2389(tdone,ends);
          thread2390(tdone,ends);
          thread2391(tdone,ends);
          int biggest2392 = 0;
          if(ends[14]>=biggest2392){
            biggest2392=ends[14];
          }
          if(ends[15]>=biggest2392){
            biggest2392=ends[15];
          }
          if(ends[16]>=biggest2392){
            biggest2392=ends[16];
          }
          if(ends[17]>=biggest2392){
            biggest2392=ends[17];
          }
          if(ends[18]>=biggest2392){
            biggest2392=ends[18];
          }
          if(biggest2392 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_13.setClear();//sysj\plant.sysj line: 244, column: 2
          posZero_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posOne_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posFive_13.setClear();//sysj\plant.sysj line: 245, column: 2
          posSeven_13.setClear();//sysj\plant.sysj line: 245, column: 2
          thread2393(tdone,ends);
          thread2394(tdone,ends);
          thread2395(tdone,ends);
          thread2396(tdone,ends);
          thread2397(tdone,ends);
          int biggest2398 = 0;
          if(ends[14]>=biggest2398){
            biggest2398=ends[14];
          }
          if(ends[15]>=biggest2398){
            biggest2398=ends[15];
          }
          if(ends[16]>=biggest2398){
            biggest2398=ends[16];
          }
          if(ends[17]>=biggest2398){
            biggest2398=ends[17];
          }
          if(ends[18]>=biggest2398){
            biggest2398=ends[18];
          }
          if(biggest2398 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2398 == 0){
            S2022=0;
            active[13]=0;
            ends[13]=0;
            S2022=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_13 = new Signal();
    posZero_13 = new Signal();
    posOne_13 = new Signal();
    posFive_13 = new Signal();
    posSeven_13 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
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
      conveyorMove_13.setpreclear();
      posZero_13.setpreclear();
      posOne_13.setpreclear();
      posFive_13.setpreclear();
      posSeven_13.setpreclear();
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
      conveyorMove_13.setClear();
      posZero_13.setClear();
      posOne_13.setClear();
      posFive_13.setClear();
      posSeven_13.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
