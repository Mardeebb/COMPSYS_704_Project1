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
  public Signal gripperGripped = new Signal("gripperGripped", Signal.INPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.INPUT);
  public Signal startCapping = new Signal("startCapping", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  public Signal capped = new Signal("capped", Signal.OUTPUT);
  private Signal capCapped_1;
  private int S1884 = 1;
  private int S1636 = 1;
  private int S1644 = 1;
  private int S1650 = 1;
  private int S1677 = 1;
  private int S1676 = 1;
  private int S1659 = 1;
  private int S1656 = 1;
  private int S1663 = 1;
  private int S1660 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread1897(int [] tdone, int [] ends){
        switch(S1663){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1660){
          case 0 : 
            S1660=0;
            gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 45, column: 6
            currsigs.addElement(gripperTurnExtend);
            System.out.println("Emitted gripperTurnExtend");
            S1660=1;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\capperController.sysj line: 46, column: 12
              S1663=0;
              active[6]=0;
              ends[6]=0;
              tdone[6]=1;
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

  public void thread1896(int [] tdone, int [] ends){
        switch(S1659){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1656){
          case 0 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\capperController.sysj line: 34, column: 12
              capCapped_1.setPresent();//sysj\capperController.sysj line: 37, column: 6
              currsigs.addElement(capCapped_1);
              System.out.println("Emitted capCapped_1");
              gripperTurnRetract.setPresent();//sysj\capperController.sysj line: 38, column: 6
              currsigs.addElement(gripperTurnRetract);
              System.out.println("Emitted gripperTurnRetract");
              S1656=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 35, column: 7
              currsigs.addElement(capGripperPos5Extend);
              System.out.println("Emitted capGripperPos5Extend");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\capperController.sysj line: 39, column: 12
              capped.setPresent();//sysj\capperController.sysj line: 40, column: 6
              currsigs.addElement(capped);
              System.out.println("Emitted capped");
              S1659=0;
              active[5]=0;
              ends[5]=0;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1894(int [] tdone, int [] ends){
        S1663=1;
    S1660=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1893(int [] tdone, int [] ends){
        S1659=1;
    S1656=0;
    capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 35, column: 7
    currsigs.addElement(capGripperPos5Extend);
    System.out.println("Emitted capGripperPos5Extend");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1892(int [] tdone, int [] ends){
        switch(S1677){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1676){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\capperController.sysj line: 32, column: 11
              S1676=1;
              thread1893(tdone,ends);
              thread1894(tdone,ends);
              int biggest1895 = 0;
              if(ends[5]>=biggest1895){
                biggest1895=ends[5];
              }
              if(ends[6]>=biggest1895){
                biggest1895=ends[6];
              }
              if(biggest1895 == 1){
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
          
          case 1 : 
            thread1896(tdone,ends);
            thread1897(tdone,ends);
            int biggest1898 = 0;
            if(ends[5]>=biggest1898){
              biggest1898=ends[5];
            }
            if(ends[6]>=biggest1898){
              biggest1898=ends[6];
            }
            if(biggest1898 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest1898 == 0){
              S1677=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1891(int [] tdone, int [] ends){
        switch(S1650){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(capCapped_1.getprestatus()){//sysj\capperController.sysj line: 26, column: 11
          S1650=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 27, column: 6
          currsigs.addElement(cylPos5ZAxisExtend);
          System.out.println("Emitted cylPos5ZAxisExtend");
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread1890(int [] tdone, int [] ends){
        switch(S1644){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(capCapped_1.getprestatus()){//sysj\capperController.sysj line: 20, column: 11
          S1644=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 21, column: 6
          currsigs.addElement(cylClampBottleExtend);
          System.out.println("Emitted cylClampBottleExtend");
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread1888(int [] tdone, int [] ends){
        S1677=1;
    S1676=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1887(int [] tdone, int [] ends){
        S1650=1;
    cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 27, column: 6
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1886(int [] tdone, int [] ends){
        S1644=1;
    cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 21, column: 6
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
      switch(S1884){
        case 0 : 
          S1884=0;
          break RUN;
        
        case 1 : 
          S1884=2;
          S1884=2;
          capCapped_1.setClear();//sysj\capperController.sysj line: 14, column: 3
          System.out.println("waiting");//sysj\capperController.sysj line: 16, column: 4
          S1636=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          capCapped_1.setClear();//sysj\capperController.sysj line: 14, column: 3
          switch(S1636){
            case 0 : 
              if(startCapping.getprestatus()){//sysj\capperController.sysj line: 17, column: 10
                S1636=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\capperController.sysj line: 18, column: 10
                S1636=2;
                thread1886(tdone,ends);
                thread1887(tdone,ends);
                thread1888(tdone,ends);
                int biggest1889 = 0;
                if(ends[2]>=biggest1889){
                  biggest1889=ends[2];
                }
                if(ends[3]>=biggest1889){
                  biggest1889=ends[3];
                }
                if(ends[4]>=biggest1889){
                  biggest1889=ends[4];
                }
                if(biggest1889 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              thread1890(tdone,ends);
              thread1891(tdone,ends);
              thread1892(tdone,ends);
              int biggest1899 = 0;
              if(ends[2]>=biggest1899){
                biggest1899=ends[2];
              }
              if(ends[3]>=biggest1899){
                biggest1899=ends[3];
              }
              if(ends[4]>=biggest1899){
                biggest1899=ends[4];
              }
              if(biggest1899 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest1899 == 0){
                System.out.println("waiting");//sysj\capperController.sysj line: 16, column: 4
                S1636=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
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
    capCapped_1 = new Signal();
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
          gripperGripped.gethook();
          cylClamped.gethook();
          startCapping.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      gripperGripped.setpreclear();
      cylClamped.setpreclear();
      startCapping.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      capped.setpreclear();
      capCapped_1.setpreclear();
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
      dummyint = gripperGripped.getStatus() ? gripperGripped.setprepresent() : gripperGripped.setpreclear();
      gripperGripped.setpreval(gripperGripped.getValue());
      gripperGripped.setClear();
      dummyint = cylClamped.getStatus() ? cylClamped.setprepresent() : cylClamped.setpreclear();
      cylClamped.setpreval(cylClamped.getValue());
      cylClamped.setClear();
      dummyint = startCapping.getStatus() ? startCapping.setprepresent() : startCapping.setpreclear();
      startCapping.setpreval(startCapping.getValue());
      startCapping.setClear();
      cylPos5ZAxisExtend.sethook();
      cylPos5ZAxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      capped.sethook();
      capped.setClear();
      capCapped_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
        gripperGripped.gethook();
        cylClamped.gethook();
        startCapping.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
