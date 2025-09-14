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
  private int S8160 = 1;
  private int S7903 = 1;
  private int S7865 = 1;
  private int S7992 = 1;
  private int S7914 = 1;
  private int S8024 = 1;
  private int S8002 = 1;
  private int S8092 = 1;
  private int S8033 = 1;
  private int S8124 = 1;
  private int S8102 = 1;
  private int S8158 = 1;
  private int S8132 = 1;
  private int S8140 = 1;
  private int S8148 = 1;
  private int S8156 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread8707(int [] tdone, int [] ends){
        switch(S8156){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 204, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 204, column: 46
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

  public void thread8706(int [] tdone, int [] ends){
        switch(S8148){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 202, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 202, column: 45
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

  public void thread8705(int [] tdone, int [] ends){
        switch(S8140){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 200, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 200, column: 45
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

  public void thread8704(int [] tdone, int [] ends){
        switch(S8132){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 198, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 198, column: 46
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

  public void thread8703(int [] tdone, int [] ends){
        switch(S8158){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        thread8704(tdone,ends);
        thread8705(tdone,ends);
        thread8706(tdone,ends);
        thread8707(tdone,ends);
        int biggest8708 = 0;
        if(ends[9]>=biggest8708){
          biggest8708=ends[9];
        }
        if(ends[10]>=biggest8708){
          biggest8708=ends[10];
        }
        if(ends[11]>=biggest8708){
          biggest8708=ends[11];
        }
        if(ends[12]>=biggest8708){
          biggest8708=ends[12];
        }
        if(biggest8708 == 1){
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        //FINXME code
        if(biggest8708 == 0){
          S8158=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread8702(int [] tdone, int [] ends){
        switch(S8124){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S8102){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 188, column: 10
              S8102=1;
              cylClamped.setPresent();//sysj\plant.sysj line: 191, column: 5
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
            if(!cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 190, column: 10
              S8102=2;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              cylClamped.setPresent();//sysj\plant.sysj line: 191, column: 5
              currsigs.addElement(cylClamped);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            S8102=2;
            S8102=0;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread8701(int [] tdone, int [] ends){
        switch(S8092){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S8033){
          case 0 : 
            if(gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 172, column: 12
              S8033=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
              currsigs.addElement(gripperTurnFinalPos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 176, column: 10
              S8033=2;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 177, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 179, column: 6
                currsigs.addElement(gripperTurnHomePos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S8033=3;
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
            if(gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 178, column: 11
              S8033=3;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 179, column: 6
              currsigs.addElement(gripperTurnHomePos);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 182, column: 10
              S8033=0;
              if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 171, column: 13
                gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
                currsigs.addElement(gripperTurnFinalPos);
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                S8033=1;
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

  public void thread8700(int [] tdone, int [] ends){
        switch(S8024){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S8002){
          case 0 : 
            if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 161, column: 10
              S8002=1;
              gripperGripped.setPresent();//sysj\plant.sysj line: 163, column: 5
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
            if(!capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 162, column: 10
              S8002=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              gripperGripped.setPresent();//sysj\plant.sysj line: 163, column: 5
              currsigs.addElement(gripperGripped);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S8002=2;
            S8002=0;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread8699(int [] tdone, int [] ends){
        switch(S7992){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S7914){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 143, column: 10
              S7914=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 145, column: 5
              currsigs.addElement(gripperZAxisLifted);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 148, column: 10
              S7914=2;
              System.err.println("Gripper lowered");//sysj\plant.sysj line: 152, column: 5
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 153, column: 5
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
            if(!cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 151, column: 10
              S7914=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 153, column: 5
              currsigs.addElement(gripperZAxisLowered);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 155, column: 10
              S7914=0;
              System.err.println("Gripper Lifted");//sysj\plant.sysj line: 144, column: 5
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 145, column: 5
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

  public void thread8698(int [] tdone, int [] ends){
        switch(S7903){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S7865){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 132, column: 10
              S7865=1;
              System.err.println("Bottle at pos 4");//sysj\plant.sysj line: 134, column: 5
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 135, column: 5
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
              S7865=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 135, column: 5
              currsigs.addElement(bottleAtPos4);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S7865=2;
            S7865=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread8695(int [] tdone, int [] ends){
        S8156=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 204, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 204, column: 46
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

  public void thread8694(int [] tdone, int [] ends){
        S8148=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 202, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 202, column: 45
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

  public void thread8693(int [] tdone, int [] ends){
        S8140=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 200, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 200, column: 45
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

  public void thread8692(int [] tdone, int [] ends){
        S8132=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 198, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 198, column: 46
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

  public void thread8691(int [] tdone, int [] ends){
        S8158=1;
    thread8692(tdone,ends);
    thread8693(tdone,ends);
    thread8694(tdone,ends);
    thread8695(tdone,ends);
    int biggest8696 = 0;
    if(ends[9]>=biggest8696){
      biggest8696=ends[9];
    }
    if(ends[10]>=biggest8696){
      biggest8696=ends[10];
    }
    if(ends[11]>=biggest8696){
      biggest8696=ends[11];
    }
    if(ends[12]>=biggest8696){
      biggest8696=ends[12];
    }
    if(biggest8696 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread8690(int [] tdone, int [] ends){
        S8124=1;
    S8102=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread8689(int [] tdone, int [] ends){
        S8092=1;
    S8033=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 171, column: 13
      gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 173, column: 6
      currsigs.addElement(gripperTurnFinalPos);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S8033=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread8688(int [] tdone, int [] ends){
        S8024=1;
    S8002=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread8687(int [] tdone, int [] ends){
        S7992=1;
    S7914=0;
    System.err.println("Gripper Lifted");//sysj\plant.sysj line: 144, column: 5
    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 145, column: 5
    currsigs.addElement(gripperZAxisLifted);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread8686(int [] tdone, int [] ends){
        S7903=1;
    S7865=0;
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
      switch(S8160){
        case 0 : 
          S8160=0;
          break RUN;
        
        case 1 : 
          S8160=2;
          S8160=2;
          thread8686(tdone,ends);
          thread8687(tdone,ends);
          thread8688(tdone,ends);
          thread8689(tdone,ends);
          thread8690(tdone,ends);
          thread8691(tdone,ends);
          int biggest8697 = 0;
          if(ends[3]>=biggest8697){
            biggest8697=ends[3];
          }
          if(ends[4]>=biggest8697){
            biggest8697=ends[4];
          }
          if(ends[5]>=biggest8697){
            biggest8697=ends[5];
          }
          if(ends[6]>=biggest8697){
            biggest8697=ends[6];
          }
          if(ends[7]>=biggest8697){
            biggest8697=ends[7];
          }
          if(ends[8]>=biggest8697){
            biggest8697=ends[8];
          }
          if(biggest8697 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          thread8698(tdone,ends);
          thread8699(tdone,ends);
          thread8700(tdone,ends);
          thread8701(tdone,ends);
          thread8702(tdone,ends);
          thread8703(tdone,ends);
          int biggest8709 = 0;
          if(ends[3]>=biggest8709){
            biggest8709=ends[3];
          }
          if(ends[4]>=biggest8709){
            biggest8709=ends[4];
          }
          if(ends[5]>=biggest8709){
            biggest8709=ends[5];
          }
          if(ends[6]>=biggest8709){
            biggest8709=ends[6];
          }
          if(ends[7]>=biggest8709){
            biggest8709=ends[7];
          }
          if(ends[8]>=biggest8709){
            biggest8709=ends[8];
          }
          if(biggest8709 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest8709 == 0){
            S8160=0;
            active[2]=0;
            ends[2]=0;
            S8160=0;
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
