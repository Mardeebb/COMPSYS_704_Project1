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
  private int S7805 = 1;
  private int S7392 = 1;
  private int S7268 = 1;
  private int S7529 = 1;
  private int S7405 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread7844(int [] tdone, int [] ends){
        switch(S7529){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S7405){
          case 0 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 353, column: 10
              S7405=1;
              CMD_R2.setPresent();//sysj\controller.sysj line: 357, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 357, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 354, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 354, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 356, column: 10
              S7405=2;
              CMD_R.setPresent();//sysj\controller.sysj line: 360, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 360, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 357, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 357, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 359, column: 10
              S7405=3;
              CMD_R2.setPresent();//sysj\controller.sysj line: 363, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 363, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 360, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 360, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 362, column: 10
              S7405=4;
              CMD_R.setPresent();//sysj\controller.sysj line: 366, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 366, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 363, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 363, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 365, column: 10
              S7405=5;
              CMD_R2.setPresent();//sysj\controller.sysj line: 369, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 369, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 366, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 366, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 368, column: 10
              S7405=0;
              CMD_R.setPresent();//sysj\controller.sysj line: 354, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 354, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 369, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 369, column: 5
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7843(int [] tdone, int [] ends){
        switch(S7392){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S7268){
          case 0 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 330, column: 10
              S7268=1;
              CMD_L2.setPresent();//sysj\controller.sysj line: 334, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 334, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 331, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 331, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 333, column: 10
              S7268=2;
              CMD_L.setPresent();//sysj\controller.sysj line: 337, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 337, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 334, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 334, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 336, column: 10
              S7268=3;
              CMD_L2.setPresent();//sysj\controller.sysj line: 340, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 340, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 337, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 337, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 339, column: 10
              S7268=4;
              CMD_L.setPresent();//sysj\controller.sysj line: 343, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 343, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 340, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 340, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 342, column: 10
              S7268=5;
              CMD_L2.setPresent();//sysj\controller.sysj line: 346, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 346, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 343, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 343, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 345, column: 10
              S7268=0;
              CMD_L.setPresent();//sysj\controller.sysj line: 331, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 331, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 346, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 346, column: 5
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7841(int [] tdone, int [] ends){
        S7529=1;
    S7405=0;
    CMD_R.setPresent();//sysj\controller.sysj line: 354, column: 5
    currsigs.addElement(CMD_R);
    CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 354, column: 5
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread7840(int [] tdone, int [] ends){
        S7392=1;
    S7268=0;
    CMD_L.setPresent();//sysj\controller.sysj line: 331, column: 5
    currsigs.addElement(CMD_L);
    CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 331, column: 5
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S7805){
        case 0 : 
          S7805=0;
          break RUN;
        
        case 1 : 
          S7805=2;
          S7805=2;
          System.out.println("Baxtor robot Controller started");//sysj\controller.sysj line: 327, column: 2
          thread7840(tdone,ends);
          thread7841(tdone,ends);
          int biggest7842 = 0;
          if(ends[15]>=biggest7842){
            biggest7842=ends[15];
          }
          if(ends[16]>=biggest7842){
            biggest7842=ends[16];
          }
          if(biggest7842 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
        
        case 2 : 
          thread7843(tdone,ends);
          thread7844(tdone,ends);
          int biggest7845 = 0;
          if(ends[15]>=biggest7845){
            biggest7845=ends[15];
          }
          if(ends[16]>=biggest7845){
            biggest7845=ends[16];
          }
          if(biggest7845 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7845 == 0){
            S7805=0;
            active[14]=0;
            ends[14]=0;
            S7805=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[14] != 0){
      int index = 14;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
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
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        bottleLoad.gethook();
        bottleUnload.gethook();
        CMDfb_L.gethook();
        CMDfb_L2.gethook();
        CMDfb_R.gethook();
        CMDfb_R2.gethook();
      }
      runFinisher();
      if(active[14] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
