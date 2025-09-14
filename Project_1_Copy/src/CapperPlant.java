import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  private int S2255 = 1;
  private int S2143 = 1;
  private int S2121 = 1;
  private int S2196 = 1;
  private int S2160 = 1;
  private int S2219 = 1;
  private int S2205 = 1;
  private int S2253 = 1;
  private int S2227 = 1;
  private int S2221 = 1;
  private int S2235 = 1;
  private int S2243 = 1;
  private int S2251 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread2274(int [] tdone, int [] ends){
        switch(S2251){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\capperPlant.sysj line: 61, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\capperPlant.sysj line: 61, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread2273(int [] tdone, int [] ends){
        switch(S2243){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\capperPlant.sysj line: 59, column: 25
          gripperTurnHomePosE.setPresent();//sysj\capperPlant.sysj line: 59, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread2272(int [] tdone, int [] ends){
        switch(S2235){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\capperPlant.sysj line: 57, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\capperPlant.sysj line: 57, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread2271(int [] tdone, int [] ends){
        switch(S2227){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S2221){
          case 0 : 
            S2221=0;
            if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 55, column: 25
              gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 55, column: 46
              currsigs.addElement(gripperZAxisLoweredE);
              System.out.println("Emitted gripperZAxisLoweredE");
              S2221=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S2221=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S2221=1;
            S2221=0;
            if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 55, column: 25
              gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 55, column: 46
              currsigs.addElement(gripperZAxisLoweredE);
              System.out.println("Emitted gripperZAxisLoweredE");
              S2221=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S2221=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2270(int [] tdone, int [] ends){
        switch(S2253){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        thread2271(tdone,ends);
        thread2272(tdone,ends);
        thread2273(tdone,ends);
        thread2274(tdone,ends);
        int biggest2275 = 0;
        if(ends[6]>=biggest2275){
          biggest2275=ends[6];
        }
        if(ends[7]>=biggest2275){
          biggest2275=ends[7];
        }
        if(ends[8]>=biggest2275){
          biggest2275=ends[8];
        }
        if(ends[9]>=biggest2275){
          biggest2275=ends[9];
        }
        if(biggest2275 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest2275 == 0){
          S2253=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread2269(int [] tdone, int [] ends){
        switch(S2219){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2205){
          case 0 : 
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 41, column: 10
              S2205=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 42, column: 5
              currsigs.addElement(gripperTurnHomePos);
              System.out.println("Emitted gripperTurnHomePos");
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 45, column: 9
              S2205=2;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\capperPlant.sysj line: 46, column: 12
                gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 48, column: 5
                currsigs.addElement(gripperTurnFinalPos);
                System.out.println("Emitted gripperTurnFinalPos");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S2205=3;
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
          
          case 2 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 47, column: 11
              S2205=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\capperPlant.sysj line: 48, column: 5
              currsigs.addElement(gripperTurnFinalPos);
              System.out.println("Emitted gripperTurnFinalPos");
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 51, column: 9
              S2219=0;
              active[4]=0;
              ends[4]=0;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2268(int [] tdone, int [] ends){
        switch(S2196){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2160){
          case 0 : 
            if(!cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 25, column: 10
              S2160=1;
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 33, column: 5
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 27, column: 5
              currsigs.addElement(gripperZAxisLowered);
              System.out.println("Emitted gripperZAxisLowered");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZaxisExtend.getprestatus() && enable.getprestatus()){//sysj\capperPlant.sysj line: 32, column: 10
              S2160=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\capperPlant.sysj line: 33, column: 5
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S2160=2;
            S2160=0;
            System.err.println("Emitting");//sysj\capperPlant.sysj line: 26, column: 5
            gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 27, column: 5
            currsigs.addElement(gripperZAxisLowered);
            System.out.println("Emitted gripperZAxisLowered");
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2267(int [] tdone, int [] ends){
        switch(S2143){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2121){
          case 0 : 
            if(enable.getprestatus()){//sysj\capperPlant.sysj line: 15, column: 10
              S2121=1;
              bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 17, column: 5
              currsigs.addElement(bottleAtPos4);
              System.out.println("Emitted bottleAtPos4");
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
            if(!enable.getprestatus()){//sysj\capperPlant.sysj line: 16, column: 10
              S2121=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\capperPlant.sysj line: 17, column: 5
              currsigs.addElement(bottleAtPos4);
              System.out.println("Emitted bottleAtPos4");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S2121=2;
            S2121=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2264(int [] tdone, int [] ends){
        S2251=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\capperPlant.sysj line: 61, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\capperPlant.sysj line: 61, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      System.out.println("Emitted gripperTurnFinalPosE");
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread2263(int [] tdone, int [] ends){
        S2243=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\capperPlant.sysj line: 59, column: 25
      gripperTurnHomePosE.setPresent();//sysj\capperPlant.sysj line: 59, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      System.out.println("Emitted gripperTurnHomePosE");
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread2262(int [] tdone, int [] ends){
        S2235=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\capperPlant.sysj line: 57, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\capperPlant.sysj line: 57, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      System.out.println("Emitted gripperZAxisLiftedE");
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread2261(int [] tdone, int [] ends){
        S2227=1;
    S2221=0;
    if(gripperZAxisLowered.getprestatus()){//sysj\capperPlant.sysj line: 55, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\capperPlant.sysj line: 55, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      System.out.println("Emitted gripperZAxisLoweredE");
      S2221=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S2221=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2260(int [] tdone, int [] ends){
        S2253=1;
    thread2261(tdone,ends);
    thread2262(tdone,ends);
    thread2263(tdone,ends);
    thread2264(tdone,ends);
    int biggest2265 = 0;
    if(ends[6]>=biggest2265){
      biggest2265=ends[6];
    }
    if(ends[7]>=biggest2265){
      biggest2265=ends[7];
    }
    if(ends[8]>=biggest2265){
      biggest2265=ends[8];
    }
    if(ends[9]>=biggest2265){
      biggest2265=ends[9];
    }
    if(biggest2265 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2259(int [] tdone, int [] ends){
        S2219=1;
    S2205=0;
    if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\capperPlant.sysj line: 40, column: 12
      gripperTurnHomePos.setPresent();//sysj\capperPlant.sysj line: 42, column: 5
      currsigs.addElement(gripperTurnHomePos);
      System.out.println("Emitted gripperTurnHomePos");
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S2205=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2258(int [] tdone, int [] ends){
        S2196=1;
    S2160=0;
    System.err.println("Emitting");//sysj\capperPlant.sysj line: 26, column: 5
    gripperZAxisLowered.setPresent();//sysj\capperPlant.sysj line: 27, column: 5
    currsigs.addElement(gripperZAxisLowered);
    System.out.println("Emitted gripperZAxisLowered");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2257(int [] tdone, int [] ends){
        S2143=1;
    S2121=0;
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
      switch(S2255){
        case 0 : 
          S2255=0;
          break RUN;
        
        case 1 : 
          S2255=2;
          S2255=2;
          thread2257(tdone,ends);
          thread2258(tdone,ends);
          thread2259(tdone,ends);
          thread2260(tdone,ends);
          int biggest2266 = 0;
          if(ends[2]>=biggest2266){
            biggest2266=ends[2];
          }
          if(ends[3]>=biggest2266){
            biggest2266=ends[3];
          }
          if(ends[4]>=biggest2266){
            biggest2266=ends[4];
          }
          if(ends[5]>=biggest2266){
            biggest2266=ends[5];
          }
          if(biggest2266 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread2267(tdone,ends);
          thread2268(tdone,ends);
          thread2269(tdone,ends);
          thread2270(tdone,ends);
          int biggest2276 = 0;
          if(ends[2]>=biggest2276){
            biggest2276=ends[2];
          }
          if(ends[3]>=biggest2276){
            biggest2276=ends[3];
          }
          if(ends[4]>=biggest2276){
            biggest2276=ends[4];
          }
          if(ends[5]>=biggest2276){
            biggest2276=ends[5];
          }
          if(biggest2276 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2276 == 0){
            S2255=0;
            active[1]=0;
            ends[1]=0;
            S2255=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          cylPos5ZaxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      enable.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZaxisExtend.getStatus() ? cylPos5ZaxisExtend.setprepresent() : cylPos5ZaxisExtend.setpreclear();
      cylPos5ZaxisExtend.setpreval(cylPos5ZaxisExtend.getValue());
      cylPos5ZaxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      gripperZAxisLoweredE.sethook();
      gripperZAxisLoweredE.setClear();
      gripperZAxisLiftedE.sethook();
      gripperZAxisLiftedE.setClear();
      gripperTurnHomePosE.sethook();
      gripperTurnHomePosE.setClear();
      gripperTurnFinalPosE.sethook();
      gripperTurnFinalPosE.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        cylPos5ZaxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
