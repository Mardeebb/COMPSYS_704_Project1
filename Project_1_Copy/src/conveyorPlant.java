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
  private BottleTwin bZero_thread_17;//sysj\plant.sysj line: 286, column: 5
  private BottleTwin bFive_thread_17;//sysj\plant.sysj line: 287, column: 5
  private BottleTwin b_thread_18;//sysj\plant.sysj line: 310, column: 4
  private int id_thread_18;//sysj\plant.sysj line: 314, column: 4
  private BottleTwin b_thread_19;//sysj\plant.sysj line: 326, column: 4
  private int id_thread_19;//sysj\plant.sysj line: 330, column: 4
  private BottleTwin b_thread_21;//sysj\plant.sysj line: 350, column: 4
  private int id_thread_21;//sysj\plant.sysj line: 351, column: 4
  private int S3601 = 1;
  private int S3519 = 1;
  private int S3269 = 1;
  private int S3527 = 1;
  private int S3535 = 1;
  private int S3543 = 1;
  private int S3599 = 1;
  private int S3545 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread3748(int [] tdone, int [] ends){
        switch(S3599){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S3545){
          case 0 : 
            if(posOne_16.getprestatus()){//sysj\plant.sysj line: 349, column: 10
              b_thread_21 = (BottleTwin)(posOne_16.getpreval() == null ? null : ((BottleTwin)posOne_16.getpreval()));//sysj\plant.sysj line: 350, column: 4
              id_thread_21 = b_thread_21.ID;//sysj\plant.sysj line: 351, column: 4
              S3545=1;
              pos1.setPresent();//sysj\plant.sysj line: 353, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(id_thread_21);//sysj\plant.sysj line: 353, column: 5
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 354, column: 5
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
            if(roturn.getprestatus()){//sysj\plant.sysj line: 352, column: 10
              S3545=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 354, column: 5
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

  public void thread3747(int [] tdone, int [] ends){
        switch(S3543){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\plant.sysj line: 340, column: 10
          posOne_16.setPresent();//sysj\plant.sysj line: 341, column: 4
          currsigs.addElement(posOne_16);
          posOne_16.setValue(null);//sysj\plant.sysj line: 341, column: 4
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

  public void thread3746(int [] tdone, int [] ends){
        switch(S3535){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\plant.sysj line: 325, column: 10
          b_thread_19 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\plant.sysj line: 326, column: 4
          id_thread_19 = b_thread_19.ID;//sysj\plant.sysj line: 330, column: 4
          pos5.setPresent();//sysj\plant.sysj line: 331, column: 4
          currsigs.addElement(pos5);
          pos5.setValue(id_thread_19);//sysj\plant.sysj line: 331, column: 4
          posFive_16.setPresent();//sysj\plant.sysj line: 332, column: 4
          currsigs.addElement(posFive_16);
          posFive_16.setValue(b_thread_19);//sysj\plant.sysj line: 332, column: 4
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

  public void thread3745(int [] tdone, int [] ends){
        switch(S3527){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\plant.sysj line: 309, column: 10
          b_thread_18 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\plant.sysj line: 310, column: 4
          id_thread_18 = b_thread_18.ID;//sysj\plant.sysj line: 314, column: 4
          pos0.setPresent();//sysj\plant.sysj line: 315, column: 4
          currsigs.addElement(pos0);
          pos0.setValue(id_thread_18);//sysj\plant.sysj line: 315, column: 4
          posZero_16.setPresent();//sysj\plant.sysj line: 316, column: 4
          currsigs.addElement(posZero_16);
          posZero_16.setValue(b_thread_18);//sysj\plant.sysj line: 316, column: 4
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

  public void thread3744(int [] tdone, int [] ends){
        switch(S3519){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S3269){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 283, column: 10
              S3269=1;
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
            if(enable.getprestatus()){//sysj\plant.sysj line: 284, column: 10
              bZero_thread_17 = (BottleTwin)(posZero_16.getpreval() == null ? null : ((BottleTwin)posZero_16.getpreval()));//sysj\plant.sysj line: 286, column: 5
              bFive_thread_17 = (BottleTwin)(posFive_16.getpreval() == null ? null : ((BottleTwin)posFive_16.getpreval()));//sysj\plant.sysj line: 287, column: 5
              if(bZero_thread_17 != null){//sysj\plant.sysj line: 289, column: 8
                posOne_16.setPresent();//sysj\plant.sysj line: 290, column: 6
                currsigs.addElement(posOne_16);
                posOne_16.setValue(bZero_thread_17);//sysj\plant.sysj line: 290, column: 6
                posZero_16.setPresent();//sysj\plant.sysj line: 291, column: 6
                currsigs.addElement(posZero_16);
                posZero_16.setValue(null);//sysj\plant.sysj line: 291, column: 6
                pos0.setPresent();//sysj\plant.sysj line: 292, column: 6
                currsigs.addElement(pos0);
                pos0.setValue(-1);//sysj\plant.sysj line: 292, column: 6
                if(bFive_thread_17 != null){//sysj\plant.sysj line: 295, column: 8
                  posSeven_16.setPresent();//sysj\plant.sysj line: 296, column: 6
                  currsigs.addElement(posSeven_16);
                  posSeven_16.setValue(bFive_thread_17);//sysj\plant.sysj line: 296, column: 6
                  posFive_16.setPresent();//sysj\plant.sysj line: 297, column: 6
                  currsigs.addElement(posFive_16);
                  posFive_16.setValue(null);//sysj\plant.sysj line: 297, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 298, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 298, column: 6
                  S3269=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  S3269=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
              else {
                if(bFive_thread_17 != null){//sysj\plant.sysj line: 295, column: 8
                  posSeven_16.setPresent();//sysj\plant.sysj line: 296, column: 6
                  currsigs.addElement(posSeven_16);
                  posSeven_16.setValue(bFive_thread_17);//sysj\plant.sysj line: 296, column: 6
                  posFive_16.setPresent();//sysj\plant.sysj line: 297, column: 6
                  currsigs.addElement(posFive_16);
                  posFive_16.setValue(null);//sysj\plant.sysj line: 297, column: 6
                  pos5.setPresent();//sysj\plant.sysj line: 298, column: 6
                  currsigs.addElement(pos5);
                  pos5.setValue(-1);//sysj\plant.sysj line: 298, column: 6
                  S3269=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  S3269=0;
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

  public void thread3742(int [] tdone, int [] ends){
        S3599=1;
    S3545=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread3741(int [] tdone, int [] ends){
        S3543=1;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread3740(int [] tdone, int [] ends){
        S3535=1;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread3739(int [] tdone, int [] ends){
        S3527=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread3738(int [] tdone, int [] ends){
        S3519=1;
    S3269=0;
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
      switch(S3601){
        case 0 : 
          S3601=0;
          break RUN;
        
        case 1 : 
          S3601=2;
          S3601=2;
          conveyorMove_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posZero_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posOne_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posFive_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posSeven_16.setClear();//sysj\plant.sysj line: 280, column: 2
          thread3738(tdone,ends);
          thread3739(tdone,ends);
          thread3740(tdone,ends);
          thread3741(tdone,ends);
          thread3742(tdone,ends);
          int biggest3743 = 0;
          if(ends[17]>=biggest3743){
            biggest3743=ends[17];
          }
          if(ends[18]>=biggest3743){
            biggest3743=ends[18];
          }
          if(ends[19]>=biggest3743){
            biggest3743=ends[19];
          }
          if(ends[20]>=biggest3743){
            biggest3743=ends[20];
          }
          if(ends[21]>=biggest3743){
            biggest3743=ends[21];
          }
          if(biggest3743 == 1){
            active[16]=1;
            ends[16]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_16.setClear();//sysj\plant.sysj line: 279, column: 2
          posZero_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posOne_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posFive_16.setClear();//sysj\plant.sysj line: 280, column: 2
          posSeven_16.setClear();//sysj\plant.sysj line: 280, column: 2
          thread3744(tdone,ends);
          thread3745(tdone,ends);
          thread3746(tdone,ends);
          thread3747(tdone,ends);
          thread3748(tdone,ends);
          int biggest3749 = 0;
          if(ends[17]>=biggest3749){
            biggest3749=ends[17];
          }
          if(ends[18]>=biggest3749){
            biggest3749=ends[18];
          }
          if(ends[19]>=biggest3749){
            biggest3749=ends[19];
          }
          if(ends[20]>=biggest3749){
            biggest3749=ends[20];
          }
          if(ends[21]>=biggest3749){
            biggest3749=ends[21];
          }
          if(biggest3749 == 1){
            active[16]=1;
            ends[16]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3749 == 0){
            S3601=0;
            active[16]=0;
            ends[16]=0;
            S3601=0;
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
