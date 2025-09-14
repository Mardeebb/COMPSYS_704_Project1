import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

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
  private Signal releaseCap_3;
  private Signal raiseGripper_3;
  private Signal unclampBottle_3;
  private int S2003 = 1;
  private int S129 = 1;
  private int S200 = 1;
  private int S152 = 1;
  private int S132 = 1;
  private int S135 = 1;
  private int S289 = 1;
  private int S213 = 1;
  private int S203 = 1;
  private int S206 = 1;
  private int S336 = 1;
  private int S296 = 1;
  private int S292 = 1;
  private int S295 = 1;
  private int S440 = 1;
  private int S354 = 1;
  
  private int[] ends = new int[21];
  private int[] tdone = new int[21];
  
  public void thread2830(int [] tdone, int [] ends){
        switch(S440){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S354){
          case 0 : 
            if(gripperGripped.getprestatus()){//sysj\controller.sysj line: 236, column: 14
              S354=1;
              System.out.println("Twist");//sysj\controller.sysj line: 239, column: 9
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 240, column: 9
              currsigs.addElement(gripperTurnExtend);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 238, column: 14
              releaseCap_3.setPresent();//sysj\controller.sysj line: 243, column: 8
              currsigs.addElement(releaseCap_3);
              S354=2;
              System.out.println("retract");//sysj\controller.sysj line: 245, column: 9
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 246, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 240, column: 9
              currsigs.addElement(gripperTurnExtend);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 244, column: 15
              S354=3;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 246, column: 9
              currsigs.addElement(gripperTurnRetract);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 3 : 
            S354=3;
            raiseGripper_3.setPresent();//sysj\controller.sysj line: 249, column: 8
            currsigs.addElement(raiseGripper_3);
            System.err.println("raise the gripper");//sysj\controller.sysj line: 250, column: 8
            S354=4;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 4 : 
            S354=4;
            unclampBottle_3.setPresent();//sysj\controller.sysj line: 252, column: 8
            currsigs.addElement(unclampBottle_3);
            S354=5;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 5 : 
            S354=5;
            S354=0;
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2828(int [] tdone, int [] ends){
        S295=1;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2827(int [] tdone, int [] ends){
        S292=1;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2825(int [] tdone, int [] ends){
        switch(S295){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(cylClamped.getprestatus()){//sysj\controller.sysj line: 224, column: 47
          S295=0;
          active[12]=0;
          ends[12]=0;
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

  public void thread2824(int [] tdone, int [] ends){
        switch(S292){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 224, column: 14
          S292=0;
          active[11]=0;
          ends[11]=0;
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

  public void thread2823(int [] tdone, int [] ends){
        switch(S336){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S296){
          case 0 : 
            thread2824(tdone,ends);
            thread2825(tdone,ends);
            int biggest2826 = 0;
            if(ends[11]>=biggest2826){
              biggest2826=ends[11];
            }
            if(ends[12]>=biggest2826){
              biggest2826=ends[12];
            }
            if(biggest2826 == 1){
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            //FINXME code
            if(biggest2826 == 0){
              System.out.println("gripped the cap");//sysj\controller.sysj line: 225, column: 7
              S296=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 227, column: 8
              currsigs.addElement(capGripperPos5Extend);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_3.getprestatus()){//sysj\controller.sysj line: 226, column: 13
              S296=2;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 227, column: 8
              currsigs.addElement(capGripperPos5Extend);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 2 : 
            S296=2;
            S296=0;
            thread2827(tdone,ends);
            thread2828(tdone,ends);
            int biggest2829 = 0;
            if(ends[11]>=biggest2829){
              biggest2829=ends[11];
            }
            if(ends[12]>=biggest2829){
              biggest2829=ends[12];
            }
            if(biggest2829 == 1){
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2821(int [] tdone, int [] ends){
        S206=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2820(int [] tdone, int [] ends){
        S203=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2818(int [] tdone, int [] ends){
        switch(S206){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(!unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 211, column: 41
          S206=0;
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

  public void thread2817(int [] tdone, int [] ends){
        switch(S203){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(!raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 211, column: 14
          S203=0;
          active[8]=0;
          ends[8]=0;
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

  public void thread2816(int [] tdone, int [] ends){
        switch(S289){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S213){
          case 0 : 
            thread2817(tdone,ends);
            thread2818(tdone,ends);
            int biggest2819 = 0;
            if(ends[8]>=biggest2819){
              biggest2819=ends[8];
            }
            if(ends[9]>=biggest2819){
              biggest2819=ends[9];
            }
            if(biggest2819 == 1){
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            //FINXME code
            if(biggest2819 == 0){
              S213=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            S213=1;
            S213=2;
            System.err.println("gripper lowered");//sysj\controller.sysj line: 214, column: 8
            cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 215, column: 8
            currsigs.addElement(cylPos5ZAxisExtend);
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 2 : 
            if(raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 213, column: 13
              System.err.println("lifted");//sysj\controller.sysj line: 217, column: 7
              S213=3;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 215, column: 8
              currsigs.addElement(cylPos5ZAxisExtend);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 3 : 
            S213=3;
            System.err.println("waiting");//sysj\controller.sysj line: 210, column: 7
            S213=0;
            thread2820(tdone,ends);
            thread2821(tdone,ends);
            int biggest2822 = 0;
            if(ends[8]>=biggest2822){
              biggest2822=ends[8];
            }
            if(ends[9]>=biggest2822){
              biggest2822=ends[9];
            }
            if(biggest2822 == 1){
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2814(int [] tdone, int [] ends){
        S135=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2813(int [] tdone, int [] ends){
        S132=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2811(int [] tdone, int [] ends){
        switch(S135){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(!unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 199, column: 41
          S135=0;
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

  public void thread2810(int [] tdone, int [] ends){
        switch(S132){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(!raiseGripper_3.getprestatus()){//sysj\controller.sysj line: 199, column: 14
          S132=0;
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
  }

  public void thread2809(int [] tdone, int [] ends){
        switch(S200){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S152){
          case 0 : 
            thread2810(tdone,ends);
            thread2811(tdone,ends);
            int biggest2812 = 0;
            if(ends[5]>=biggest2812){
              biggest2812=ends[5];
            }
            if(ends[6]>=biggest2812){
              biggest2812=ends[6];
            }
            if(biggest2812 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            //FINXME code
            if(biggest2812 == 0){
              S152=1;
              System.out.println("Bottle clamped");//sysj\controller.sysj line: 201, column: 8
              cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 202, column: 8
              currsigs.addElement(cylClampBottleExtend);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(unclampBottle_3.getprestatus()){//sysj\controller.sysj line: 200, column: 13
              S152=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 202, column: 8
              currsigs.addElement(cylClampBottleExtend);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S152=2;
            S152=0;
            thread2813(tdone,ends);
            thread2814(tdone,ends);
            int biggest2815 = 0;
            if(ends[5]>=biggest2815){
              biggest2815=ends[5];
            }
            if(ends[6]>=biggest2815){
              biggest2815=ends[6];
            }
            if(biggest2815 == 1){
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2807(int [] tdone, int [] ends){
        S440=1;
    S354=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread2805(int [] tdone, int [] ends){
        S295=1;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2804(int [] tdone, int [] ends){
        S292=1;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2803(int [] tdone, int [] ends){
        S336=1;
    S296=0;
    thread2804(tdone,ends);
    thread2805(tdone,ends);
    int biggest2806 = 0;
    if(ends[11]>=biggest2806){
      biggest2806=ends[11];
    }
    if(ends[12]>=biggest2806){
      biggest2806=ends[12];
    }
    if(biggest2806 == 1){
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2801(int [] tdone, int [] ends){
        S206=1;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2800(int [] tdone, int [] ends){
        S203=1;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2799(int [] tdone, int [] ends){
        S289=1;
    System.err.println("waiting");//sysj\controller.sysj line: 210, column: 7
    S213=0;
    thread2800(tdone,ends);
    thread2801(tdone,ends);
    int biggest2802 = 0;
    if(ends[8]>=biggest2802){
      biggest2802=ends[8];
    }
    if(ends[9]>=biggest2802){
      biggest2802=ends[9];
    }
    if(biggest2802 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread2797(int [] tdone, int [] ends){
        S135=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2796(int [] tdone, int [] ends){
        S132=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2795(int [] tdone, int [] ends){
        S200=1;
    S152=0;
    thread2796(tdone,ends);
    thread2797(tdone,ends);
    int biggest2798 = 0;
    if(ends[5]>=biggest2798){
      biggest2798=ends[5];
    }
    if(ends[6]>=biggest2798){
      biggest2798=ends[6];
    }
    if(biggest2798 == 1){
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2003){
        case 0 : 
          S2003=0;
          break RUN;
        
        case 1 : 
          S2003=2;
          S2003=2;
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          System.out.println("waiting");//sysj\controller.sysj line: 193, column: 4
          S129=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          releaseCap_3.setClear();//sysj\controller.sysj line: 191, column: 3
          raiseGripper_3.setClear();//sysj\controller.sysj line: 191, column: 3
          unclampBottle_3.setClear();//sysj\controller.sysj line: 191, column: 3
          switch(S129){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 194, column: 10
                System.out.println("Capper doing work");//sysj\controller.sysj line: 195, column: 5
                S129=1;
                thread2795(tdone,ends);
                thread2799(tdone,ends);
                thread2803(tdone,ends);
                thread2807(tdone,ends);
                int biggest2808 = 0;
                if(ends[4]>=biggest2808){
                  biggest2808=ends[4];
                }
                if(ends[7]>=biggest2808){
                  biggest2808=ends[7];
                }
                if(ends[10]>=biggest2808){
                  biggest2808=ends[10];
                }
                if(ends[13]>=biggest2808){
                  biggest2808=ends[13];
                }
                if(biggest2808 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              thread2809(tdone,ends);
              thread2816(tdone,ends);
              thread2823(tdone,ends);
              thread2830(tdone,ends);
              int biggest2831 = 0;
              if(ends[4]>=biggest2831){
                biggest2831=ends[4];
              }
              if(ends[7]>=biggest2831){
                biggest2831=ends[7];
              }
              if(ends[10]>=biggest2831){
                biggest2831=ends[10];
              }
              if(ends[13]>=biggest2831){
                biggest2831=ends[13];
              }
              if(biggest2831 == 1){
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              //FINXME code
              if(biggest2831 == 0){
                S129=2;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              S129=2;
              System.out.println("waiting");//sysj\controller.sysj line: 193, column: 4
              S129=0;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_3 = new Signal();
    raiseGripper_3 = new Signal();
    unclampBottle_3 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[3] != 0){
      int index = 3;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
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
      releaseCap_3.setpreclear();
      raiseGripper_3.setpreclear();
      unclampBottle_3.setpreclear();
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
      releaseCap_3.setClear();
      raiseGripper_3.setClear();
      unclampBottle_3.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
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
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
