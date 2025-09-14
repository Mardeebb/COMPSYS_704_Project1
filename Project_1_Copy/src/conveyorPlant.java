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
  private Signal conveyorMove_16;
  private Signal posZero_16;
  private Signal posOne_16;
  private Signal posFive_16;
  private Signal posSeven_16;
  private BottleTwin bZero_thread_17;//sysj\plant.sysj line: 285, column: 5
  private BottleTwin bFive_thread_17;//sysj\plant.sysj line: 286, column: 5
  private BottleTwin b_thread_18;//sysj\plant.sysj line: 309, column: 4
  private int id_thread_18;//sysj\plant.sysj line: 313, column: 4
  private BottleTwin b_thread_19;//sysj\plant.sysj line: 325, column: 4
  private int id_thread_19;//sysj\plant.sysj line: 329, column: 4
  private BottleTwin b_thread_21;//sysj\plant.sysj line: 349, column: 4
  private int id_thread_21;//sysj\plant.sysj line: 350, column: 4
  private int S2305 = 1;
  private int S2223 = 1;
  private int S1973 = 1;
  private int S2231 = 1;
  private int S2239 = 1;
  private int S2247 = 1;
  private int S2303 = 1;
  private int S2249 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread2452(int [] tdone, int [] ends){
        switch(S2303){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2249){
          case 0 : 
            if(posOne_16.getprestatus()){//sysj\plant.sysj line: 348, column: 10
              b_thread_21 = (BottleTwin)(posOne_16.getpreval() == null ? null : ((BottleTwin)posOne_16.getpreval()));//sysj\plant.sysj line: 349, column: 4
              id_thread_21 = b_thread_21.ID;//sysj\plant.sysj line: 350, column: 4
              S2249=1;
              pos1.setPresent();//sysj\plant.sysj line: 352, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_21);//sysj\plant.sysj line: 352, column: 5
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 353, column: 5
              currsigs.addElement(bottleAtPos1);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\plant.sysj line: 351, column: 10
              S2249=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 353, column: 5
              currsigs.addElement(bottleAtPos1);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2451(int [] tdone, int [] ends){
        switch(S2247){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 339, column: 10
          posOne_16.setPresent();//sysj\plant.sysj line: 340, column: 4
          currsigs.addElement(posOne_16);
          posOne_16.setValue(null);//sysj\plant.sysj line: 340, column: 4
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        else {
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread2450(int [] tdone, int [] ends){
        switch(S2239){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 324, column: 10
          b_thread_19 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 325, column: 4
          id_thread_19 = b_thread_19.ID;//sysj\plant.sysj line: 329, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 330, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_19);//sysj\plant.sysj line: 330, column: 4
          posFive_16.setPresent();//sysj\plant.sysj line: 331, column: 4
          currsigs.addElement(posFive_16);
          posFive_16.setValue(b_thread_19);//sysj\plant.sysj line: 331, column: 4
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
      
    }
  }

  public void thread2449(int [] tdone, int [] ends){
        switch(S2231){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 308, column: 10
          b_thread_18 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 309, column: 4
          id_thread_18 = b_thread_18.ID;//sysj\plant.sysj line: 313, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 314, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_18);//sysj\plant.sysj line: 314, column: 4
          posZero_16.setPresent();//sysj\plant.sysj line: 315, column: 4
          currsigs.addElement(posZero_16);
          posZero_16.setValue(b_thread_18);//sysj\plant.sysj line: 315, column: 4
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

  public void thread2448(int [] tdone, int [] ends){
        switch(S2223){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1973){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 282, column: 10
              S1973=1;
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
          
          case 1 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 283, column: 10
              bZero_thread_17 = (BottleTwin)(posZero_16.getpreval() == null ? null : ((BottleTwin)posZero_16.getpreval()));//sysj\plant.sysj line: 285, column: 5
              bFive_thread_17 = (BottleTwin)(posFive_16.getpreval() == null ? null : ((BottleTwin)posFive_16.getpreval()));//sysj\plant.sysj line: 286, column: 5
              if(bZero_thread_17 != null){//sysj\plant.sysj line: 288, column: 8
                posOne_16.setPresent();//sysj\plant.sysj line: 289, column: 6
                currsigs.addElement(posOne_16);
                posOne_16.setValue(bZero_thread_17);//sysj\plant.sysj line: 289, column: 6
                posZero_16.setPresent();//sysj\plant.sysj line: 290, column: 6
                currsigs.addElement(posZero_16);
                posZero_16.setValue(null);//sysj\plant.sysj line: 290, column: 6
                pos0.setPresent();//sysj\plant.sysj line: 291, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 291, column: 6
                if(bFive_thread_17 != null){//sysj\plant.sysj line: 294, column: 8
                  posSeven_16.setPresent();//sysj\plant.sysj line: 295, column: 6
                  currsigs.addElement(posSeven_16);
                  posSeven_16.setValue(bFive_thread_17);//sysj\plant.sysj line: 295, column: 6
                  posFive_16.setPresent();//sysj\plant.sysj line: 296, column: 6
                  currsigs.addElement(posFive_16);
                  posFive_16.setValue(null);//sysj\plant.sysj line: 296, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 297, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 297, column: 6
                  S1973=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  S1973=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
              else {
                if(bFive_thread_17 != null){//sysj\plant.sysj line: 294, column: 8
                  posSeven_16.setPresent();//sysj\plant.sysj line: 295, column: 6
                  currsigs.addElement(posSeven_16);
                  posSeven_16.setValue(bFive_thread_17);//sysj\plant.sysj line: 295, column: 6
                  posFive_16.setPresent();//sysj\plant.sysj line: 296, column: 6
                  currsigs.addElement(posFive_16);
                  posFive_16.setValue(null);//sysj\plant.sysj line: 296, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 297, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 297, column: 6
                  S1973=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  S1973=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
            }
            else {
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2446(int [] tdone, int [] ends){
        S2303=1;
    S2249=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2445(int [] tdone, int [] ends){
        S2247=1;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2444(int [] tdone, int [] ends){
        S2239=1;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2443(int [] tdone, int [] ends){
        S2231=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2442(int [] tdone, int [] ends){
        S2223=1;
    S1973=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2305){
        case 0 : 
          S2305=0;
          break RUN;
        
        case 1 : 
          S2305=2;
          S2305=2;
          conveyorMove_16.setClear();//sysj\plant.sysj line: 278, column: 2
          posZero_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posOne_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posFive_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posSeven_16.setClear();//sysj\plant.sysj line: 279, column: 2
          thread2442(tdone,ends);
          thread2443(tdone,ends);
          thread2444(tdone,ends);
          thread2445(tdone,ends);
          thread2446(tdone,ends);
          int biggest2447 = 0;
          if(ends[17]>=biggest2447){
            biggest2447=ends[17];
          }
          if(ends[18]>=biggest2447){
            biggest2447=ends[18];
          }
          if(ends[19]>=biggest2447){
            biggest2447=ends[19];
          }
          if(ends[20]>=biggest2447){
            biggest2447=ends[20];
          }
          if(ends[21]>=biggest2447){
            biggest2447=ends[21];
          }
          if(biggest2447 == 1){
            active[16]=1;
            ends[16]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_16.setClear();//sysj\plant.sysj line: 278, column: 2
          posZero_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posOne_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posFive_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posSeven_16.setClear();//sysj\plant.sysj line: 279, column: 2
          thread2448(tdone,ends);
          thread2449(tdone,ends);
          thread2450(tdone,ends);
          thread2451(tdone,ends);
          thread2452(tdone,ends);
          int biggest2453 = 0;
          if(ends[17]>=biggest2453){
            biggest2453=ends[17];
          }
          if(ends[18]>=biggest2453){
            biggest2453=ends[18];
          }
          if(ends[19]>=biggest2453){
            biggest2453=ends[19];
          }
          if(ends[20]>=biggest2453){
            biggest2453=ends[20];
          }
          if(ends[21]>=biggest2453){
            biggest2453=ends[21];
          }
          if(biggest2453 == 1){
            active[16]=1;
            ends[16]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2453 == 0){
            S2305=0;
            active[16]=0;
            ends[16]=0;
            S2305=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_16 = new Signal();
    posZero_16 = new Signal();
    posOne_16 = new Signal();
    posFive_16 = new Signal();
    posSeven_16 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[16] != 0){
      int index = 16;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[16]!=0 || suspended[16]!=0 || active[16]!=1);
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
      conveyorMove_16.setpreclear();
      posZero_16.setpreclear();
      posOne_16.setpreclear();
      posFive_16.setpreclear();
      posSeven_16.setpreclear();
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
      conveyorMove_16.setClear();
      posZero_16.setClear();
      posOne_16.setClear();
      posFive_16.setClear();
      posSeven_16.setClear();
      if(paused[16]!=0 || suspended[16]!=0 || active[16]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[16] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
