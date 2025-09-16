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
  private Signal conveyorMove_17;
  private Signal posZero_17;
  private Signal posOne_17;
  private Signal posFive_17;
  private Signal posSeven_17;
  private BottleTwin bZero_thread_18;//sysj\plant.sysj line: 305, column: 5
  private BottleTwin bFive_thread_18;//sysj\plant.sysj line: 306, column: 5
  private BottleTwin b_thread_19;//sysj\plant.sysj line: 329, column: 4
  private int id_thread_19;//sysj\plant.sysj line: 333, column: 4
  private BottleTwin b_thread_20;//sysj\plant.sysj line: 345, column: 4
  private int id_thread_20;//sysj\plant.sysj line: 349, column: 4
  private BottleTwin b_thread_22;//sysj\plant.sysj line: 369, column: 4
  private int id_thread_22;//sysj\plant.sysj line: 370, column: 4
  private int S3645 = 1;
  private int S3563 = 1;
  private int S3313 = 1;
  private int S3571 = 1;
  private int S3579 = 1;
  private int S3587 = 1;
  private int S3643 = 1;
  private int S3589 = 1;
  
  private int[] ends = new int[29];
  private int[] tdone = new int[29];
  
  public void thread3792(int [] tdone, int [] ends){
        switch(S3643){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S3589){
          case 0 : 
            if(posOne_17.getprestatus()){//sysj\plant.sysj line: 368, column: 10
              b_thread_22 = (BottleTwin)(posOne_17.getpreval() == null ? null : ((BottleTwin)posOne_17.getpreval()));//sysj\plant.sysj line: 369, column: 4
              id_thread_22 = b_thread_22.ID;//sysj\plant.sysj line: 370, column: 4
              S3589=1;
              pos1.setPresent();//sysj\plant.sysj line: 372, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_22);//sysj\plant.sysj line: 372, column: 5
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 373, column: 5
              currsigs.addElement(bottleAtPos1);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\plant.sysj line: 371, column: 10
              S3589=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 373, column: 5
              currsigs.addElement(bottleAtPos1);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3791(int [] tdone, int [] ends){
        switch(S3587){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 359, column: 10
          posOne_17.setPresent();//sysj\plant.sysj line: 360, column: 4
          currsigs.addElement(posOne_17);
          posOne_17.setValue(null);//sysj\plant.sysj line: 360, column: 4
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
      
    }
  }

  public void thread3790(int [] tdone, int [] ends){
        switch(S3579){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 344, column: 10
          b_thread_20 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 345, column: 4
          id_thread_20 = b_thread_20.ID;//sysj\plant.sysj line: 349, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 350, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_20);//sysj\plant.sysj line: 350, column: 4
          posFive_17.setPresent();//sysj\plant.sysj line: 351, column: 4
          currsigs.addElement(posFive_17);
          posFive_17.setValue(b_thread_20);//sysj\plant.sysj line: 351, column: 4
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

  public void thread3789(int [] tdone, int [] ends){
        switch(S3571){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 328, column: 10
          b_thread_19 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 329, column: 4
          id_thread_19 = b_thread_19.ID;//sysj\plant.sysj line: 333, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 334, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_19);//sysj\plant.sysj line: 334, column: 4
          posZero_17.setPresent();//sysj\plant.sysj line: 335, column: 4
          currsigs.addElement(posZero_17);
          posZero_17.setValue(b_thread_19);//sysj\plant.sysj line: 335, column: 4
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

  public void thread3788(int [] tdone, int [] ends){
        switch(S3563){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S3313){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 302, column: 10
              S3313=1;
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
            if(enable.getprestatus()){//sysj\plant.sysj line: 303, column: 10
              bZero_thread_18 = (BottleTwin)(posZero_17.getpreval() == null ? null : ((BottleTwin)posZero_17.getpreval()));//sysj\plant.sysj line: 305, column: 5
              bFive_thread_18 = (BottleTwin)(posFive_17.getpreval() == null ? null : ((BottleTwin)posFive_17.getpreval()));//sysj\plant.sysj line: 306, column: 5
              if(bZero_thread_18 != null){//sysj\plant.sysj line: 308, column: 8
                posOne_17.setPresent();//sysj\plant.sysj line: 309, column: 6
                currsigs.addElement(posOne_17);
                posOne_17.setValue(bZero_thread_18);//sysj\plant.sysj line: 309, column: 6
                posZero_17.setPresent();//sysj\plant.sysj line: 310, column: 6
                currsigs.addElement(posZero_17);
                posZero_17.setValue(null);//sysj\plant.sysj line: 310, column: 6
                pos0.setPresent();//sysj\plant.sysj line: 311, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 311, column: 6
                if(bFive_thread_18 != null){//sysj\plant.sysj line: 314, column: 8
                  posSeven_17.setPresent();//sysj\plant.sysj line: 315, column: 6
                  currsigs.addElement(posSeven_17);
                  posSeven_17.setValue(bFive_thread_18);//sysj\plant.sysj line: 315, column: 6
                  posFive_17.setPresent();//sysj\plant.sysj line: 316, column: 6
                  currsigs.addElement(posFive_17);
                  posFive_17.setValue(null);//sysj\plant.sysj line: 316, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 317, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 317, column: 6
                  S3313=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  S3313=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
              }
              else {
                if(bFive_thread_18 != null){//sysj\plant.sysj line: 314, column: 8
                  posSeven_17.setPresent();//sysj\plant.sysj line: 315, column: 6
                  currsigs.addElement(posSeven_17);
                  posSeven_17.setValue(bFive_thread_18);//sysj\plant.sysj line: 315, column: 6
                  posFive_17.setPresent();//sysj\plant.sysj line: 316, column: 6
                  currsigs.addElement(posFive_17);
                  posFive_17.setValue(null);//sysj\plant.sysj line: 316, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 317, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 317, column: 6
                  S3313=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  S3313=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
              }
            }
            else {
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3786(int [] tdone, int [] ends){
        S3643=1;
    S3589=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread3785(int [] tdone, int [] ends){
        S3587=1;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread3784(int [] tdone, int [] ends){
        S3579=1;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread3783(int [] tdone, int [] ends){
        S3571=1;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread3782(int [] tdone, int [] ends){
        S3563=1;
    S3313=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3645){
        case 0 : 
          S3645=0;
          break RUN;
        
        case 1 : 
          S3645=2;
          S3645=2;
          conveyorMove_17.setClear();//sysj\plant.sysj line: 298, column: 2
          posZero_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posOne_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posFive_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posSeven_17.setClear();//sysj\plant.sysj line: 299, column: 2
          thread3782(tdone,ends);
          thread3783(tdone,ends);
          thread3784(tdone,ends);
          thread3785(tdone,ends);
          thread3786(tdone,ends);
          int biggest3787 = 0;
          if(ends[18]>=biggest3787){
            biggest3787=ends[18];
          }
          if(ends[19]>=biggest3787){
            biggest3787=ends[19];
          }
          if(ends[20]>=biggest3787){
            biggest3787=ends[20];
          }
          if(ends[21]>=biggest3787){
            biggest3787=ends[21];
          }
          if(ends[22]>=biggest3787){
            biggest3787=ends[22];
          }
          if(biggest3787 == 1){
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_17.setClear();//sysj\plant.sysj line: 298, column: 2
          posZero_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posOne_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posFive_17.setClear();//sysj\plant.sysj line: 299, column: 2
          posSeven_17.setClear();//sysj\plant.sysj line: 299, column: 2
          thread3788(tdone,ends);
          thread3789(tdone,ends);
          thread3790(tdone,ends);
          thread3791(tdone,ends);
          thread3792(tdone,ends);
          int biggest3793 = 0;
          if(ends[18]>=biggest3793){
            biggest3793=ends[18];
          }
          if(ends[19]>=biggest3793){
            biggest3793=ends[19];
          }
          if(ends[20]>=biggest3793){
            biggest3793=ends[20];
          }
          if(ends[21]>=biggest3793){
            biggest3793=ends[21];
          }
          if(ends[22]>=biggest3793){
            biggest3793=ends[22];
          }
          if(biggest3793 == 1){
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3793 == 0){
            S3645=0;
            active[17]=0;
            ends[17]=0;
            S3645=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_17 = new Signal();
    posZero_17 = new Signal();
    posOne_17 = new Signal();
    posFive_17 = new Signal();
    posSeven_17 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[17] != 0){
      int index = 17;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
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
      conveyorMove_17.setpreclear();
      posZero_17.setpreclear();
      posOne_17.setpreclear();
      posFive_17.setpreclear();
      posSeven_17.setpreclear();
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
      conveyorMove_17.setClear();
      posZero_17.setClear();
      posOne_17.setClear();
      posFive_17.setClear();
      posSeven_17.setClear();
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[17] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
