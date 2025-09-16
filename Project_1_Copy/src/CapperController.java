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
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private Signal releaseCap_1;
  private Signal raiseGripper_1;
  private Signal unclampBottle_1;
  private int S3512 = 1;
  private int S1638 = 1;
  private int S1709 = 1;
  private int S1661 = 1;
  private int S1641 = 1;
  private int S1644 = 1;
  private int S1798 = 1;
  private int S1722 = 1;
  private int S1712 = 1;
  private int S1715 = 1;
  private int S1845 = 1;
  private int S1805 = 1;
  private int S1801 = 1;
  private int S1804 = 1;
  private int S1949 = 1;
  private int S1863 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread3549(int [] tdone, int [] ends){
        switch(S1949){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1863){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\capperController.sysj line: 57, column: 14
              S1863=1;
              System.out.println("Twist");//sysj\capperController.sysj line: 60, column: 9
              gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 61, column: 9
              currsigs.addElement(gripperTurnExtend);
              System.out.println("Emitted gripperTurnExtend");
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
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\capperController.sysj line: 59, column: 14
              releaseCap_1.setPresent();//sysj\capperController.sysj line: 64, column: 8
              currsigs.addElement(releaseCap_1);
              System.out.println("Emitted releaseCap_1");
              S1863=2;
              System.out.println("retract");//sysj\capperController.sysj line: 66, column: 9
              gripperTurnRetract.setPresent();//sysj\capperController.sysj line: 67, column: 9
              currsigs.addElement(gripperTurnRetract);
              System.out.println("Emitted gripperTurnRetract");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\capperController.sysj line: 61, column: 9
              currsigs.addElement(gripperTurnExtend);
              System.out.println("Emitted gripperTurnExtend");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\capperController.sysj line: 65, column: 15
              S1863=3;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\capperController.sysj line: 67, column: 9
              currsigs.addElement(gripperTurnRetract);
              System.out.println("Emitted gripperTurnRetract");
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 3 : 
            S1863=3;
            raiseGripper_1.setPresent();//sysj\capperController.sysj line: 70, column: 8
            currsigs.addElement(raiseGripper_1);
            System.out.println("Emitted raiseGripper_1");
            System.err.println("raise the gripper");//sysj\capperController.sysj line: 71, column: 8
            S1863=4;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 4 : 
            S1863=4;
            unclampBottle_1.setPresent();//sysj\capperController.sysj line: 73, column: 8
            currsigs.addElement(unclampBottle_1);
            System.out.println("Emitted unclampBottle_1");
            S1863=5;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 5 : 
            S1863=5;
            S1863=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3547(int [] tdone, int [] ends){
        S1804=1;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3546(int [] tdone, int [] ends){
        S1801=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3544(int [] tdone, int [] ends){
        switch(S1804){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\capperController.sysj line: 45, column: 47
          S1804=0;
          active[10]=0;
          ends[10]=0;
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

  public void thread3543(int [] tdone, int [] ends){
        switch(S1801){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\capperController.sysj line: 45, column: 14
          S1801=0;
          active[9]=0;
          ends[9]=0;
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

  public void thread3542(int [] tdone, int [] ends){
        switch(S1845){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1805){
          case 0 : 
            thread3543(tdone,ends);
            thread3544(tdone,ends);
            int biggest3545 = 0;
            if(ends[9]>=biggest3545){
              biggest3545=ends[9];
            }
            if(ends[10]>=biggest3545){
              biggest3545=ends[10];
            }
            if(biggest3545 == 1){
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            //FINXME code
            if(biggest3545 == 0){
              System.out.println("gripped the cap");//sysj\capperController.sysj line: 46, column: 7
              S1805=1;
              capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 48, column: 8
              currsigs.addElement(capGripperPos5Extend);
              System.out.println("Emitted capGripperPos5Extend");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_1.getprestatus()){//sysj\capperController.sysj line: 47, column: 13
              S1805=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\capperController.sysj line: 48, column: 8
              currsigs.addElement(capGripperPos5Extend);
              System.out.println("Emitted capGripperPos5Extend");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 2 : 
            S1805=2;
            S1805=0;
            thread3546(tdone,ends);
            thread3547(tdone,ends);
            int biggest3548 = 0;
            if(ends[9]>=biggest3548){
              biggest3548=ends[9];
            }
            if(ends[10]>=biggest3548){
              biggest3548=ends[10];
            }
            if(biggest3548 == 1){
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3540(int [] tdone, int [] ends){
        S1715=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3539(int [] tdone, int [] ends){
        S1712=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3537(int [] tdone, int [] ends){
        switch(S1715){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(!unclampBottle_1.getprestatus()){//sysj\capperController.sysj line: 32, column: 41
          S1715=0;
          active[7]=0;
          ends[7]=0;
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

  public void thread3536(int [] tdone, int [] ends){
        switch(S1712){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(!raiseGripper_1.getprestatus()){//sysj\capperController.sysj line: 32, column: 14
          S1712=0;
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
  }

  public void thread3535(int [] tdone, int [] ends){
        switch(S1798){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1722){
          case 0 : 
            thread3536(tdone,ends);
            thread3537(tdone,ends);
            int biggest3538 = 0;
            if(ends[6]>=biggest3538){
              biggest3538=ends[6];
            }
            if(ends[7]>=biggest3538){
              biggest3538=ends[7];
            }
            if(biggest3538 == 1){
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            //FINXME code
            if(biggest3538 == 0){
              S1722=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S1722=1;
            S1722=2;
            System.err.println("gripper lowered");//sysj\capperController.sysj line: 35, column: 8
            cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 36, column: 8
            currsigs.addElement(cylPos5ZAxisExtend);
            System.out.println("Emitted cylPos5ZAxisExtend");
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 2 : 
            if(raiseGripper_1.getprestatus()){//sysj\capperController.sysj line: 34, column: 13
              System.err.println("lifted");//sysj\capperController.sysj line: 38, column: 7
              S1722=3;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\capperController.sysj line: 36, column: 8
              currsigs.addElement(cylPos5ZAxisExtend);
              System.out.println("Emitted cylPos5ZAxisExtend");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            S1722=3;
            System.err.println("waiting");//sysj\capperController.sysj line: 31, column: 7
            S1722=0;
            thread3539(tdone,ends);
            thread3540(tdone,ends);
            int biggest3541 = 0;
            if(ends[6]>=biggest3541){
              biggest3541=ends[6];
            }
            if(ends[7]>=biggest3541){
              biggest3541=ends[7];
            }
            if(biggest3541 == 1){
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3533(int [] tdone, int [] ends){
        S1644=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3532(int [] tdone, int [] ends){
        S1641=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3530(int [] tdone, int [] ends){
        switch(S1644){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(!unclampBottle_1.getprestatus()){//sysj\capperController.sysj line: 20, column: 41
          S1644=0;
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
  }

  public void thread3529(int [] tdone, int [] ends){
        switch(S1641){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(!raiseGripper_1.getprestatus()){//sysj\capperController.sysj line: 20, column: 14
          S1641=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread3528(int [] tdone, int [] ends){
        switch(S1709){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1661){
          case 0 : 
            thread3529(tdone,ends);
            thread3530(tdone,ends);
            int biggest3531 = 0;
            if(ends[3]>=biggest3531){
              biggest3531=ends[3];
            }
            if(ends[4]>=biggest3531){
              biggest3531=ends[4];
            }
            if(biggest3531 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            //FINXME code
            if(biggest3531 == 0){
              S1661=1;
              System.out.println("Bottle clamped");//sysj\capperController.sysj line: 22, column: 8
              cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 23, column: 8
              currsigs.addElement(cylClampBottleExtend);
              System.out.println("Emitted cylClampBottleExtend");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(unclampBottle_1.getprestatus()){//sysj\capperController.sysj line: 21, column: 13
              S1661=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              cylClampBottleExtend.setPresent();//sysj\capperController.sysj line: 23, column: 8
              currsigs.addElement(cylClampBottleExtend);
              System.out.println("Emitted cylClampBottleExtend");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S1661=2;
            S1661=0;
            thread3532(tdone,ends);
            thread3533(tdone,ends);
            int biggest3534 = 0;
            if(ends[3]>=biggest3534){
              biggest3534=ends[3];
            }
            if(ends[4]>=biggest3534){
              biggest3534=ends[4];
            }
            if(biggest3534 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3526(int [] tdone, int [] ends){
        S1949=1;
    S1863=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3524(int [] tdone, int [] ends){
        S1804=1;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3523(int [] tdone, int [] ends){
        S1801=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3522(int [] tdone, int [] ends){
        S1845=1;
    S1805=0;
    thread3523(tdone,ends);
    thread3524(tdone,ends);
    int biggest3525 = 0;
    if(ends[9]>=biggest3525){
      biggest3525=ends[9];
    }
    if(ends[10]>=biggest3525){
      biggest3525=ends[10];
    }
    if(biggest3525 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread3520(int [] tdone, int [] ends){
        S1715=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3519(int [] tdone, int [] ends){
        S1712=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3518(int [] tdone, int [] ends){
        S1798=1;
    System.err.println("waiting");//sysj\capperController.sysj line: 31, column: 7
    S1722=0;
    thread3519(tdone,ends);
    thread3520(tdone,ends);
    int biggest3521 = 0;
    if(ends[6]>=biggest3521){
      biggest3521=ends[6];
    }
    if(ends[7]>=biggest3521){
      biggest3521=ends[7];
    }
    if(biggest3521 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread3516(int [] tdone, int [] ends){
        S1644=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3515(int [] tdone, int [] ends){
        S1641=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3514(int [] tdone, int [] ends){
        S1709=1;
    S1661=0;
    thread3515(tdone,ends);
    thread3516(tdone,ends);
    int biggest3517 = 0;
    if(ends[3]>=biggest3517){
      biggest3517=ends[3];
    }
    if(ends[4]>=biggest3517){
      biggest3517=ends[4];
    }
    if(biggest3517 == 1){
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3512){
        case 0 : 
          S3512=0;
          break RUN;
        
        case 1 : 
          S3512=2;
          S3512=2;
          releaseCap_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          raiseGripper_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          unclampBottle_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          System.out.println("waiting");//sysj\capperController.sysj line: 14, column: 4
          S1638=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          releaseCap_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          raiseGripper_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          unclampBottle_1.setClear();//sysj\capperController.sysj line: 12, column: 3
          switch(S1638){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\capperController.sysj line: 15, column: 10
                System.out.println("Capper doing work");//sysj\capperController.sysj line: 16, column: 5
                S1638=1;
                thread3514(tdone,ends);
                thread3518(tdone,ends);
                thread3522(tdone,ends);
                thread3526(tdone,ends);
                int biggest3527 = 0;
                if(ends[2]>=biggest3527){
                  biggest3527=ends[2];
                }
                if(ends[5]>=biggest3527){
                  biggest3527=ends[5];
                }
                if(ends[8]>=biggest3527){
                  biggest3527=ends[8];
                }
                if(ends[11]>=biggest3527){
                  biggest3527=ends[11];
                }
                if(biggest3527 == 1){
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
            
            case 1 : 
              thread3528(tdone,ends);
              thread3535(tdone,ends);
              thread3542(tdone,ends);
              thread3549(tdone,ends);
              int biggest3550 = 0;
              if(ends[2]>=biggest3550){
                biggest3550=ends[2];
              }
              if(ends[5]>=biggest3550){
                biggest3550=ends[5];
              }
              if(ends[8]>=biggest3550){
                biggest3550=ends[8];
              }
              if(ends[11]>=biggest3550){
                biggest3550=ends[11];
              }
              if(biggest3550 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest3550 == 0){
                S1638=2;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 2 : 
              S1638=2;
              System.out.println("waiting");//sysj\capperController.sysj line: 14, column: 4
              S1638=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_1 = new Signal();
    raiseGripper_1 = new Signal();
    unclampBottle_1 = new Signal();
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
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      releaseCap_1.setpreclear();
      raiseGripper_1.setpreclear();
      unclampBottle_1.setpreclear();
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
      releaseCap_1.setClear();
      raiseGripper_1.setClear();
      unclampBottle_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
        gripperGripped.gethook();
        cylClamped.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
