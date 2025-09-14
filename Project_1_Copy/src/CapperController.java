import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S2098 = 1;
  private int S1649 = 1;
  private int S1631 = 1;
  private int S1636 = 1;
  private int S1654 = 1;
  private int S1659 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread2110(int [] tdone, int [] ends){
        switch(S1659){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 27, column: 43
        currsigs.addElement(gripperTurnExtend);
        System.out.println("Emitted gripperTurnExtend");
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2109(int [] tdone, int [] ends){
        switch(S1654){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 27, column: 8
        currsigs.addElement(capGripperPos5Extend);
        System.out.println("Emitted capGripperPos5Extend");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2107(int [] tdone, int [] ends){
        S1659=1;
    gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 27, column: 43
    currsigs.addElement(gripperTurnExtend);
    System.out.println("Emitted gripperTurnExtend");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2106(int [] tdone, int [] ends){
        S1654=1;
    capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 27, column: 8
    currsigs.addElement(capGripperPos5Extend);
    System.out.println("Emitted capGripperPos5Extend");
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2104(int [] tdone, int [] ends){
        switch(S1636){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\capperController.sysj line: 19, column: 42
        currsigs.addElement(cylPos5ZaxisExtend);
        System.out.println("Emitted cylPos5ZaxisExtend");
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2103(int [] tdone, int [] ends){
        switch(S1631){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 19, column: 7
        currsigs.addElement(cylClampBottleExtend);
        System.out.println("Emitted cylClampBottleExtend");
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread2101(int [] tdone, int [] ends){
        S1636=1;
    cylPos5ZaxisExtend.setPresent();//sysj\capperController.sysj line: 19, column: 42
    currsigs.addElement(cylPos5ZaxisExtend);
    System.out.println("Emitted cylPos5ZaxisExtend");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2100(int [] tdone, int [] ends){
        S1631=1;
    cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 19, column: 7
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
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
      switch(S2098){
        case 0 : 
          S2098=0;
          break RUN;
        
        case 1 : 
          S2098=2;
          S2098=2;
          System.out.println("Capper CD");//sysj\capperController.sysj line: 9, column: 2
          S1649=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S1649){
            case 0 : 
              S1649=0;
              S1649=1;
              thread2100(tdone,ends);
              thread2101(tdone,ends);
              int biggest2102 = 0;
              if(ends[2]>=biggest2102){
                biggest2102=ends[2];
              }
              if(ends[3]>=biggest2102){
                biggest2102=ends[3];
              }
              if(biggest2102 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              if(gripperZAxisLowered.getprestatus()){//sysj\capperController.sysj line: 18, column: 11
                S1649=2;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread2103(tdone,ends);
                thread2104(tdone,ends);
                int biggest2105 = 0;
                if(ends[2]>=biggest2105){
                  biggest2105=ends[2];
                }
                if(ends[3]>=biggest2105){
                  biggest2105=ends[3];
                }
                if(biggest2105 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2105 == 0){
                  S1649=2;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 2 : 
              S1649=2;
              S1649=3;
              if(gripperZAxisLowered.getprestatus()){//sysj\capperController.sysj line: 25, column: 13
                thread2106(tdone,ends);
                thread2107(tdone,ends);
                int biggest2108 = 0;
                if(ends[4]>=biggest2108){
                  biggest2108=ends[4];
                }
                if(ends[5]>=biggest2108){
                  biggest2108=ends[5];
                }
                if(biggest2108 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                S1649=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\capperController.sysj line: 26, column: 12
                S1649=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread2109(tdone,ends);
                thread2110(tdone,ends);
                int biggest2111 = 0;
                if(ends[4]>=biggest2111){
                  biggest2111=ends[4];
                }
                if(ends[5]>=biggest2111){
                  biggest2111=ends[5];
                }
                if(biggest2111 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2111 == 0){
                  S1649=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      cylPos5ZaxisExtend.sethook();
      cylPos5ZaxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
