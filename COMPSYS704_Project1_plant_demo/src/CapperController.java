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
  public Signal gripperTurnRetracted = new Signal("gripperTurnRetracted", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S483 = 1;
  private int S3 = 1;
  private int S8 = 1;
  private int S13 = 1;
  private int S30 = 1;
  private int S35 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread719(int [] tdone, int [] ends){
        switch(S35){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 42, column: 43
        currsigs.addElement(gripperTurnExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread718(int [] tdone, int [] ends){
        switch(S30){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 42, column: 8
        currsigs.addElement(capGripperPos5Extend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread716(int [] tdone, int [] ends){
        S35=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 42, column: 43
    currsigs.addElement(gripperTurnExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread715(int [] tdone, int [] ends){
        S30=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 42, column: 8
    currsigs.addElement(capGripperPos5Extend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread713(int [] tdone, int [] ends){
        switch(S13){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylPos5ZaxisExtend.setPresent();//sysj\controller.sysj line: 34, column: 42
        currsigs.addElement(cylPos5ZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread712(int [] tdone, int [] ends){
        switch(S8){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 34, column: 7
        currsigs.addElement(cylClampBottleExtend);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread710(int [] tdone, int [] ends){
        S13=1;
    cylPos5ZaxisExtend.setPresent();//sysj\controller.sysj line: 34, column: 42
    currsigs.addElement(cylPos5ZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread709(int [] tdone, int [] ends){
        S8=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 34, column: 7
    currsigs.addElement(cylClampBottleExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S483){
        case 0 : 
          S483=0;
          break RUN;
        
        case 1 : 
          S483=2;
          S483=2;
          System.out.println("Capper CD");//sysj\controller.sysj line: 24, column: 2
          S3=0;
          active[2]=1;
          ends[2]=1;
          break RUN;
        
        case 2 : 
          switch(S3){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 29, column: 11
                S3=1;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 1 : 
              S3=1;
              S3=2;
              thread709(tdone,ends);
              thread710(tdone,ends);
              int biggest711 = 0;
              if(ends[3]>=biggest711){
                biggest711=ends[3];
              }
              if(ends[4]>=biggest711){
                biggest711=ends[4];
              }
              if(biggest711 == 1){
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 2 : 
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 33, column: 11
                S3=3;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                thread712(tdone,ends);
                thread713(tdone,ends);
                int biggest714 = 0;
                if(ends[3]>=biggest714){
                  biggest714=ends[3];
                }
                if(ends[4]>=biggest714){
                  biggest714=ends[4];
                }
                if(biggest714 == 1){
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest714 == 0){
                  S3=3;
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S3=3;
              S3=4;
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 40, column: 13
                thread715(tdone,ends);
                thread716(tdone,ends);
                int biggest717 = 0;
                if(ends[5]>=biggest717){
                  biggest717=ends[5];
                }
                if(ends[6]>=biggest717){
                  biggest717=ends[6];
                }
                if(biggest717 == 1){
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
              }
              else {
                S3=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 4 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 41, column: 12
                S3=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                thread718(tdone,ends);
                thread719(tdone,ends);
                int biggest720 = 0;
                if(ends[5]>=biggest720){
                  biggest720=ends[5];
                }
                if(ends[6]>=biggest720){
                  biggest720=ends[6];
                }
                if(biggest720 == 1){
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest720 == 0){
                  S3=0;
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
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
      gripperTurnRetracted.setpreclear();
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
      gripperTurnRetracted.sethook();
      gripperTurnRetracted.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
