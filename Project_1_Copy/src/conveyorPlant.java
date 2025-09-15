import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\conveyorPlant.sysj line: 1, column: 1

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
  public Signal moved = new Signal("moved", Signal.OUTPUT);
  public Signal pos0 = new Signal("pos0", Signal.OUTPUT);
  public Signal pos1 = new Signal("pos1", Signal.OUTPUT);
  public Signal pos5 = new Signal("pos5", Signal.OUTPUT);
  public Signal pos7 = new Signal("pos7", Signal.OUTPUT);
  private Signal conveyorMove_1;
  private Signal posZero_1;
  private Signal posOne_1;
  private Signal posFive_1;
  private Signal posSeven_1;
  private BottleTwin bZero_thread_2;//sysj\conveyorPlant.sysj line: 23, column: 5
  private BottleTwin bFive_thread_2;//sysj\conveyorPlant.sysj line: 24, column: 5
  private BottleTwin b_thread_3;//sysj\conveyorPlant.sysj line: 45, column: 4
  private int id_thread_3;//sysj\conveyorPlant.sysj line: 47, column: 5
  private BottleTwin b_thread_4;//sysj\conveyorPlant.sysj line: 59, column: 4
  private int id_thread_4;//sysj\conveyorPlant.sysj line: 61, column: 5
  private BottleTwin b_thread_6;//sysj\conveyorPlant.sysj line: 83, column: 4
  private int id_thread_6;//sysj\conveyorPlant.sysj line: 85, column: 5
  private int S2030 = 1;
  private int S1814 = 1;
  private int S1722 = 1;
  private int S1706 = 1;
  private int S1840 = 1;
  private int S1866 = 1;
  private int S1874 = 1;
  private int S2028 = 1;
  private int S1876 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread2042(int [] tdone, int [] ends){
        switch(S2028){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1876){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\conveyorPlant.sysj line: 82, column: 10
              b_thread_6 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\conveyorPlant.sysj line: 83, column: 4
              S1876=1;
              if(b_thread_6 != null){//sysj\conveyorPlant.sysj line: 84, column: 7
                id_thread_6 = b_thread_6.ID;//sysj\conveyorPlant.sysj line: 85, column: 5
                pos1.setPresent();//sysj\conveyorPlant.sysj line: 87, column: 6
                currsigs.addElement(pos1);
                pos1.setValue(id_thread_6);//sysj\conveyorPlant.sysj line: 87, column: 6
                System.out.println("Emitted pos1");
                bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 88, column: 6
                currsigs.addElement(bottleAtPos1);
                System.out.println("Emitted bottleAtPos1");
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S1876=0;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(roturn.getprestatus()){//sysj\conveyorPlant.sysj line: 86, column: 11
              pos1.setPresent();//sysj\conveyorPlant.sysj line: 90, column: 5
              currsigs.addElement(pos1);
              pos1.setValue(-1);//sysj\conveyorPlant.sysj line: 90, column: 5
              System.out.println("Emitted pos1");
              S1876=0;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 88, column: 6
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2041(int [] tdone, int [] ends){
        switch(S1874){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(roturn.getprestatus()){//sysj\conveyorPlant.sysj line: 73, column: 10
          posOne_1.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 4
          currsigs.addElement(posOne_1);
          posOne_1.setValue(null);//sysj\conveyorPlant.sysj line: 74, column: 4
          System.out.println("Emitted posOne_1");
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread2040(int [] tdone, int [] ends){
        switch(S1866){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(bottleArriveToFive.getprestatus()){//sysj\conveyorPlant.sysj line: 58, column: 10
          b_thread_4 = (BottleTwin)(bottleArriveToFive.getpreval() == null ? null : ((BottleTwin)bottleArriveToFive.getpreval()));//sysj\conveyorPlant.sysj line: 59, column: 4
          if(b_thread_4 != null){//sysj\conveyorPlant.sysj line: 60, column: 7
            id_thread_4 = b_thread_4.ID;//sysj\conveyorPlant.sysj line: 61, column: 5
            pos5.setPresent();//sysj\conveyorPlant.sysj line: 62, column: 5
            currsigs.addElement(pos5);
            pos5.setValue(id_thread_4);//sysj\conveyorPlant.sysj line: 62, column: 5
            System.out.println("Emitted pos5");
            posFive_1.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 5
            currsigs.addElement(posFive_1);
            posFive_1.setValue(b_thread_4);//sysj\conveyorPlant.sysj line: 63, column: 5
            System.out.println("Emitted posFive_1");
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2039(int [] tdone, int [] ends){
        switch(S1840){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(bottleArriveToZero.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 10
          b_thread_3 = (BottleTwin)(bottleArriveToZero.getpreval() == null ? null : ((BottleTwin)bottleArriveToZero.getpreval()));//sysj\conveyorPlant.sysj line: 45, column: 4
          if(b_thread_3 != null){//sysj\conveyorPlant.sysj line: 46, column: 7
            id_thread_3 = b_thread_3.ID;//sysj\conveyorPlant.sysj line: 47, column: 5
            pos0.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
            currsigs.addElement(pos0);
            pos0.setValue(id_thread_3);//sysj\conveyorPlant.sysj line: 48, column: 5
            System.out.println("Emitted pos0");
            posZero_1.setPresent();//sysj\conveyorPlant.sysj line: 49, column: 5
            currsigs.addElement(posZero_1);
            posZero_1.setValue(b_thread_3);//sysj\conveyorPlant.sysj line: 49, column: 5
            System.out.println("Emitted posZero_1");
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread2038(int [] tdone, int [] ends){
        switch(S1814){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1722){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 21, column: 10
              S1722=1;
              bZero_thread_2 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\conveyorPlant.sysj line: 23, column: 5
              bFive_thread_2 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\conveyorPlant.sysj line: 24, column: 5
              S1706=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 10
              S1722=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S1706){
                case 0 : 
                  if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 25, column: 11
                    if(bZero_thread_2 != null){//sysj\conveyorPlant.sysj line: 26, column: 8
                      posOne_1.setPresent();//sysj\conveyorPlant.sysj line: 27, column: 6
                      currsigs.addElement(posOne_1);
                      posOne_1.setValue(bZero_thread_2);//sysj\conveyorPlant.sysj line: 27, column: 6
                      System.out.println("Emitted posOne_1");
                      posZero_1.setPresent();//sysj\conveyorPlant.sysj line: 28, column: 6
                      currsigs.addElement(posZero_1);
                      posZero_1.setValue(null);//sysj\conveyorPlant.sysj line: 28, column: 6
                      System.out.println("Emitted posZero_1");
                      pos0.setPresent();//sysj\conveyorPlant.sysj line: 29, column: 6
                      currsigs.addElement(pos0);
                      pos0.setValue(-1);//sysj\conveyorPlant.sysj line: 29, column: 6
                      System.out.println("Emitted pos0");
                      S1722=0;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S1722=0;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
                case 1 : 
                  S1722=0;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2036(int [] tdone, int [] ends){
        S2028=1;
    S1876=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2035(int [] tdone, int [] ends){
        S1874=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2034(int [] tdone, int [] ends){
        S1866=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2033(int [] tdone, int [] ends){
        S1840=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2032(int [] tdone, int [] ends){
        S1814=1;
    S1722=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2030){
        case 0 : 
          S2030=0;
          break RUN;
        
        case 1 : 
          S2030=2;
          S2030=2;
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 17, column: 2
          posZero_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posOne_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posFive_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posSeven_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          thread2032(tdone,ends);
          thread2033(tdone,ends);
          thread2034(tdone,ends);
          thread2035(tdone,ends);
          thread2036(tdone,ends);
          int biggest2037 = 0;
          if(ends[2]>=biggest2037){
            biggest2037=ends[2];
          }
          if(ends[3]>=biggest2037){
            biggest2037=ends[3];
          }
          if(ends[4]>=biggest2037){
            biggest2037=ends[4];
          }
          if(ends[5]>=biggest2037){
            biggest2037=ends[5];
          }
          if(ends[6]>=biggest2037){
            biggest2037=ends[6];
          }
          if(biggest2037 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 17, column: 2
          posZero_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posOne_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posFive_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          posSeven_1.setClear();//sysj\conveyorPlant.sysj line: 18, column: 2
          thread2038(tdone,ends);
          thread2039(tdone,ends);
          thread2040(tdone,ends);
          thread2041(tdone,ends);
          thread2042(tdone,ends);
          int biggest2043 = 0;
          if(ends[2]>=biggest2043){
            biggest2043=ends[2];
          }
          if(ends[3]>=biggest2043){
            biggest2043=ends[3];
          }
          if(ends[4]>=biggest2043){
            biggest2043=ends[4];
          }
          if(ends[5]>=biggest2043){
            biggest2043=ends[5];
          }
          if(ends[6]>=biggest2043){
            biggest2043=ends[6];
          }
          if(biggest2043 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2043 == 0){
            S2030=0;
            active[1]=0;
            ends[1]=0;
            S2030=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    conveyorMove_1 = new Signal();
    posZero_1 = new Signal();
    posOne_1 = new Signal();
    posFive_1 = new Signal();
    posSeven_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
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
      moved.setpreclear();
      pos0.setpreclear();
      pos1.setpreclear();
      pos5.setpreclear();
      pos7.setpreclear();
      conveyorMove_1.setpreclear();
      posZero_1.setpreclear();
      posOne_1.setpreclear();
      posFive_1.setpreclear();
      posSeven_1.setpreclear();
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
      moved.sethook();
      moved.setClear();
      pos0.sethook();
      pos0.setClear();
      pos1.sethook();
      pos1.setClear();
      pos5.sethook();
      pos5.setClear();
      pos7.sethook();
      pos7.setClear();
      conveyorMove_1.setClear();
      posZero_1.setClear();
      posOne_1.setClear();
      posFive_1.setClear();
      posSeven_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleArriveToZero.gethook();
        bottleArriveToFive.gethook();
        roturn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
