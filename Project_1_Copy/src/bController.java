import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\controller.sysj line: 1, column: 1

public class bController extends ClockDomain{
  public bController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleLoad = new Signal("bottleLoad", Signal.INPUT);
  public Signal bottleUnload = new Signal("bottleUnload", Signal.INPUT);
  public Signal CMDfb_L = new Signal("CMDfb_L", Signal.INPUT);
  public Signal CMDfb_L2 = new Signal("CMDfb_L2", Signal.INPUT);
  public Signal CMDfb_R = new Signal("CMDfb_R", Signal.INPUT);
  public Signal CMDfb_R2 = new Signal("CMDfb_R2", Signal.INPUT);
  public Signal CMD_L = new Signal("CMD_L", Signal.OUTPUT);
  public Signal CMD_L2 = new Signal("CMD_L2", Signal.OUTPUT);
  public Signal CMD_R = new Signal("CMD_R", Signal.OUTPUT);
  public Signal CMD_R2 = new Signal("CMD_R2", Signal.OUTPUT);
  private int S913 = 1;
  private int S500 = 1;
  private int S376 = 1;
  private int S637 = 1;
  private int S513 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread925(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S513){
          case 0 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 276, column: 10
              S513=1;
              CMD_R2.setPresent();//sysj\controller.sysj line: 280, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 280, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 277, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 277, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 279, column: 10
              S513=2;
              CMD_R.setPresent();//sysj\controller.sysj line: 283, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 283, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 280, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 280, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 282, column: 10
              S513=3;
              CMD_R2.setPresent();//sysj\controller.sysj line: 286, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 286, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 283, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 283, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 285, column: 10
              S513=4;
              CMD_R.setPresent();//sysj\controller.sysj line: 289, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 289, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 286, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 286, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 288, column: 10
              S513=5;
              CMD_R2.setPresent();//sysj\controller.sysj line: 292, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 292, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 289, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 289, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 291, column: 10
              S513=0;
              CMD_R.setPresent();//sysj\controller.sysj line: 277, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 277, column: 5
              System.out.println("Emitted CMD_R");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 292, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 292, column: 5
              System.out.println("Emitted CMD_R2");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread924(int [] tdone, int [] ends){
        switch(S500){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S376){
          case 0 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 253, column: 10
              S376=1;
              CMD_L2.setPresent();//sysj\controller.sysj line: 257, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 257, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 254, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 254, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 256, column: 10
              S376=2;
              CMD_L.setPresent();//sysj\controller.sysj line: 260, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 260, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 257, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 257, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 259, column: 10
              S376=3;
              CMD_L2.setPresent();//sysj\controller.sysj line: 263, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 263, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 260, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 260, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 262, column: 10
              S376=4;
              CMD_L.setPresent();//sysj\controller.sysj line: 266, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 266, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 263, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 263, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 265, column: 10
              S376=5;
              CMD_L2.setPresent();//sysj\controller.sysj line: 269, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 269, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 266, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 266, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 268, column: 10
              S376=0;
              CMD_L.setPresent();//sysj\controller.sysj line: 254, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 254, column: 5
              System.out.println("Emitted CMD_L");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 269, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 269, column: 5
              System.out.println("Emitted CMD_L2");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread922(int [] tdone, int [] ends){
        S637=1;
    S513=0;
    CMD_R.setPresent();//sysj\controller.sysj line: 277, column: 5
    currsigs.addElement(CMD_R);
    CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 277, column: 5
    System.out.println("Emitted CMD_R");
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread921(int [] tdone, int [] ends){
        S500=1;
    S376=0;
    CMD_L.setPresent();//sysj\controller.sysj line: 254, column: 5
    currsigs.addElement(CMD_L);
    CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 254, column: 5
    System.out.println("Emitted CMD_L");
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S913){
        case 0 : 
          S913=0;
          break RUN;
        
        case 1 : 
          S913=2;
          S913=2;
          System.out.println("Baxtor robot Controller started");//sysj\controller.sysj line: 250, column: 2
          thread921(tdone,ends);
          thread922(tdone,ends);
          int biggest923 = 0;
          if(ends[8]>=biggest923){
            biggest923=ends[8];
          }
          if(ends[9]>=biggest923){
            biggest923=ends[9];
          }
          if(biggest923 == 1){
            active[7]=1;
            ends[7]=1;
            break RUN;
          }
        
        case 2 : 
          thread924(tdone,ends);
          thread925(tdone,ends);
          int biggest926 = 0;
          if(ends[8]>=biggest926){
            biggest926=ends[8];
          }
          if(ends[9]>=biggest926){
            biggest926=ends[9];
          }
          if(biggest926 == 1){
            active[7]=1;
            ends[7]=1;
            break RUN;
          }
          //FINXME code
          if(biggest926 == 0){
            S913=0;
            active[7]=0;
            ends[7]=0;
            S913=0;
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
    while(active[7] != 0){
      int index = 7;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
      else{
        if(!df){
          bottleLoad.gethook();
          bottleUnload.gethook();
          CMDfb_L.gethook();
          CMDfb_L2.gethook();
          CMDfb_R.gethook();
          CMDfb_R2.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleLoad.setpreclear();
      bottleUnload.setpreclear();
      CMDfb_L.setpreclear();
      CMDfb_L2.setpreclear();
      CMDfb_R.setpreclear();
      CMDfb_R2.setpreclear();
      CMD_L.setpreclear();
      CMD_L2.setpreclear();
      CMD_R.setpreclear();
      CMD_R2.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleLoad.getStatus() ? bottleLoad.setprepresent() : bottleLoad.setpreclear();
      bottleLoad.setpreval(bottleLoad.getValue());
      bottleLoad.setClear();
      dummyint = bottleUnload.getStatus() ? bottleUnload.setprepresent() : bottleUnload.setpreclear();
      bottleUnload.setpreval(bottleUnload.getValue());
      bottleUnload.setClear();
      dummyint = CMDfb_L.getStatus() ? CMDfb_L.setprepresent() : CMDfb_L.setpreclear();
      CMDfb_L.setpreval(CMDfb_L.getValue());
      CMDfb_L.setClear();
      dummyint = CMDfb_L2.getStatus() ? CMDfb_L2.setprepresent() : CMDfb_L2.setpreclear();
      CMDfb_L2.setpreval(CMDfb_L2.getValue());
      CMDfb_L2.setClear();
      dummyint = CMDfb_R.getStatus() ? CMDfb_R.setprepresent() : CMDfb_R.setpreclear();
      CMDfb_R.setpreval(CMDfb_R.getValue());
      CMDfb_R.setClear();
      dummyint = CMDfb_R2.getStatus() ? CMDfb_R2.setprepresent() : CMDfb_R2.setpreclear();
      CMDfb_R2.setpreval(CMDfb_R2.getValue());
      CMDfb_R2.setClear();
      CMD_L.sethook();
      CMD_L.setClear();
      CMD_L2.sethook();
      CMD_L2.setClear();
      CMD_R.sethook();
      CMD_R.setClear();
      CMD_R2.sethook();
      CMD_R2.setClear();
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
      else{
        bottleLoad.gethook();
        bottleUnload.gethook();
        CMDfb_L.gethook();
        CMDfb_L2.gethook();
        CMDfb_R.gethook();
        CMDfb_R2.gethook();
      }
      runFinisher();
      if(active[7] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
