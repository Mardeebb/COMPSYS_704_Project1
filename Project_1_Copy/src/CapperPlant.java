import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
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
  public Signal gripperGripped = new Signal("gripperGripped", Signal.OUTPUT);
  public Signal cylClamped = new Signal("cylClamped", Signal.OUTPUT);
  private int S1886 = 1;
  private int S1629 = 1;
  private int S1607 = 1;
  private int S1718 = 1;
  private int S1640 = 1;
  private int S1750 = 1;
  private int S1728 = 1;
  private int S1818 = 1;
  private int S1759 = 1;
  private int S1850 = 1;
  private int S1828 = 1;
  private int S1884 = 1;
  private int S1858 = 1;
  private int S1866 = 1;
  private int S1874 = 1;
  private int S1882 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread2433(int [] tdone, int [] ends){
        switch(S1882){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 203, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 203, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread2432(int [] tdone, int [] ends){
        switch(S1874){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 201, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 201, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread2431(int [] tdone, int [] ends){
        switch(S1866){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 199, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 199, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread2430(int [] tdone, int [] ends){
        switch(S1858){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 197, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 197, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread2429(int [] tdone, int [] ends){
        switch(S1884){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        thread2430(tdone,ends);
        thread2431(tdone,ends);
        thread2432(tdone,ends);
        thread2433(tdone,ends);
        int biggest2434 = 0;
        if(ends[9]>=biggest2434){
          biggest2434=ends[9];
        }
        if(ends[10]>=biggest2434){
          biggest2434=ends[10];
        }
        if(ends[11]>=biggest2434){
          biggest2434=ends[11];
        }
        if(ends[12]>=biggest2434){
          biggest2434=ends[12];
        }
        if(biggest2434 == 1){
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        //FINXME code
        if(biggest2434 == 0){
          S1884=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread2428(int [] tdone, int [] ends){
        switch(S1850){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1828){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 187, column: 10
              S1828=1;
              cylClamped.setPresent();//sysj\plant.sysj line: 190, column: 5
              currsigs.addElement(cylClamped);
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
          
          case 1 : 
            if(!cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 189, column: 10
              S1828=2;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              cylClamped.setPresent();//sysj\plant.sysj line: 190, column: 5
              currsigs.addElement(cylClamped);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            S1828=2;
            S1828=0;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2427(int [] tdone, int [] ends){
        switch(S1818){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1759){
          case 0 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
              S1759=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 6
              currsigs.addElement(gripperTurnFinalPos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 175, column: 10
              S1759=2;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 176, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 178, column: 6
                currsigs.addElement(gripperTurnHomePos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S1759=3;
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
          
          case 2 : 
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 177, column: 11
              S1759=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 178, column: 6
              currsigs.addElement(gripperTurnHomePos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 181, column: 10
              S1759=0;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 170, column: 13
                gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 6
                currsigs.addElement(gripperTurnFinalPos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S1759=1;
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
          
        }
        break;
      
    }
  }

  public void thread2426(int [] tdone, int [] ends){
        switch(S1750){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1728){
          case 0 : 
            if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 160, column: 10
              S1728=1;
              gripperGripped.setPresent();//sysj\plant.sysj line: 162, column: 5
              currsigs.addElement(gripperGripped);
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
          
          case 1 : 
            if(!capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 161, column: 10
              S1728=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperGripped.setPresent();//sysj\plant.sysj line: 162, column: 5
              currsigs.addElement(gripperGripped);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S1728=2;
            S1728=0;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2425(int [] tdone, int [] ends){
        switch(S1718){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1640){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 142, column: 10
              S1640=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 144, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 147, column: 10
              S1640=2;
              System.err.println("Gripper lowered");//sysj\plant.sysj line: 151, column: 5
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 152, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            if(!cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 150, column: 10
              S1640=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 152, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 154, column: 10
              S1640=0;
              System.err.println("Gripper Lifted");//sysj\plant.sysj line: 143, column: 5
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 144, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
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

  public void thread2424(int [] tdone, int [] ends){
        switch(S1629){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1607){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 132, column: 10
              S1607=1;
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 134, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 133, column: 10
              S1607=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 134, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S1607=2;
            S1607=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2421(int [] tdone, int [] ends){
        S1882=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 203, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 203, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread2420(int [] tdone, int [] ends){
        S1874=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 201, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 201, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread2419(int [] tdone, int [] ends){
        S1866=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 199, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 199, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2418(int [] tdone, int [] ends){
        S1858=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 197, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 197, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread2417(int [] tdone, int [] ends){
        S1884=1;
    thread2418(tdone,ends);
    thread2419(tdone,ends);
    thread2420(tdone,ends);
    thread2421(tdone,ends);
    int biggest2422 = 0;
    if(ends[9]>=biggest2422){
      biggest2422=ends[9];
    }
    if(ends[10]>=biggest2422){
      biggest2422=ends[10];
    }
    if(ends[11]>=biggest2422){
      biggest2422=ends[11];
    }
    if(ends[12]>=biggest2422){
      biggest2422=ends[12];
    }
    if(biggest2422 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread2416(int [] tdone, int [] ends){
        S1850=1;
    S1828=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2415(int [] tdone, int [] ends){
        S1818=1;
    S1759=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 170, column: 13
      gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 6
      currsigs.addElement(gripperTurnFinalPos);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S1759=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2414(int [] tdone, int [] ends){
        S1750=1;
    S1728=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2413(int [] tdone, int [] ends){
        S1718=1;
    S1640=0;
    System.err.println("Gripper Lifted");//sysj\plant.sysj line: 143, column: 5
    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 144, column: 5
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2412(int [] tdone, int [] ends){
        S1629=1;
    S1607=0;
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
      switch(S1886){
        case 0 : 
          S1886=0;
          break RUN;
        
        case 1 : 
          S1886=2;
          S1886=2;
          thread2412(tdone,ends);
          thread2413(tdone,ends);
          thread2414(tdone,ends);
          thread2415(tdone,ends);
          thread2416(tdone,ends);
          thread2417(tdone,ends);
          int biggest2423 = 0;
          if(ends[3]>=biggest2423){
            biggest2423=ends[3];
          }
          if(ends[4]>=biggest2423){
            biggest2423=ends[4];
          }
          if(ends[5]>=biggest2423){
            biggest2423=ends[5];
          }
          if(ends[6]>=biggest2423){
            biggest2423=ends[6];
          }
          if(ends[7]>=biggest2423){
            biggest2423=ends[7];
          }
          if(ends[8]>=biggest2423){
            biggest2423=ends[8];
          }
          if(biggest2423 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          thread2424(tdone,ends);
          thread2425(tdone,ends);
          thread2426(tdone,ends);
          thread2427(tdone,ends);
          thread2428(tdone,ends);
          thread2429(tdone,ends);
          int biggest2435 = 0;
          if(ends[3]>=biggest2435){
            biggest2435=ends[3];
          }
          if(ends[4]>=biggest2435){
            biggest2435=ends[4];
          }
          if(ends[5]>=biggest2435){
            biggest2435=ends[5];
          }
          if(ends[6]>=biggest2435){
            biggest2435=ends[6];
          }
          if(ends[7]>=biggest2435){
            biggest2435=ends[7];
          }
          if(ends[8]>=biggest2435){
            biggest2435=ends[8];
          }
          if(biggest2435 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2435 == 0){
            S1886=0;
            active[2]=0;
            ends[2]=0;
            S1886=0;
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
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      cylPos5ZAxisExtend.setpreclear();
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
      gripperGripped.setpreclear();
      cylClamped.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = cylPos5ZAxisExtend.getStatus() ? cylPos5ZAxisExtend.setprepresent() : cylPos5ZAxisExtend.setpreclear();
      cylPos5ZAxisExtend.setpreval(cylPos5ZAxisExtend.getValue());
      cylPos5ZAxisExtend.setClear();
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
      gripperGripped.sethook();
      gripperGripped.setClear();
      cylClamped.sethook();
      cylClamped.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        cylPos5ZAxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
