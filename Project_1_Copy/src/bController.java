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
  private int S2793 = 1;
  private int S2380 = 1;
  private int S2256 = 1;
  private int S2517 = 1;
  private int S2393 = 1;
  
  private int[] ends = new int[21];
  private int[] tdone = new int[21];
  
  public void thread2842(int [] tdone, int [] ends){
        switch(S2517){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2393){
          case 0 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 359, column: 10
              S2393=1;
              CMD_R2.setPresent();//sysj\controller.sysj line: 363, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 363, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 360, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 360, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 362, column: 10
              S2393=2;
              CMD_R.setPresent();//sysj\controller.sysj line: 366, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 366, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 363, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 363, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 365, column: 10
              S2393=3;
              CMD_R2.setPresent();//sysj\controller.sysj line: 369, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 369, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 366, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 366, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 368, column: 10
              S2393=4;
              CMD_R.setPresent();//sysj\controller.sysj line: 372, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 372, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 369, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 369, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 371, column: 10
              S2393=5;
              CMD_R2.setPresent();//sysj\controller.sysj line: 375, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 375, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 372, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 372, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 374, column: 10
              S2393=0;
              CMD_R.setPresent();//sysj\controller.sysj line: 360, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 360, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 375, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 375, column: 5
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2841(int [] tdone, int [] ends){
        switch(S2380){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2256){
          case 0 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 336, column: 10
              S2256=1;
              CMD_L2.setPresent();//sysj\controller.sysj line: 340, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 340, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 337, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 337, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 339, column: 10
              S2256=2;
              CMD_L.setPresent();//sysj\controller.sysj line: 343, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 343, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 340, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 340, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 342, column: 10
              S2256=3;
              CMD_L2.setPresent();//sysj\controller.sysj line: 346, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 346, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 343, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 343, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 345, column: 10
              S2256=4;
              CMD_L.setPresent();//sysj\controller.sysj line: 349, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 349, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 346, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 346, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 348, column: 10
              S2256=5;
              CMD_L2.setPresent();//sysj\controller.sysj line: 352, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 352, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 349, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 349, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 351, column: 10
              S2256=0;
              CMD_L.setPresent();//sysj\controller.sysj line: 337, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 337, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 352, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 352, column: 5
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2839(int [] tdone, int [] ends){
        S2517=1;
    S2393=0;
    CMD_R.setPresent();//sysj\controller.sysj line: 360, column: 5
    currsigs.addElement(CMD_R);
    CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 360, column: 5
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2838(int [] tdone, int [] ends){
        S2380=1;
    S2256=0;
    CMD_L.setPresent();//sysj\controller.sysj line: 337, column: 5
    currsigs.addElement(CMD_L);
    CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 337, column: 5
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2793){
        case 0 : 
          S2793=0;
          break RUN;
        
        case 1 : 
          S2793=2;
          S2793=2;
          System.out.println("Baxtor robot Controller started");//sysj\controller.sysj line: 333, column: 2
          thread2838(tdone,ends);
          thread2839(tdone,ends);
          int biggest2840 = 0;
          if(ends[19]>=biggest2840){
            biggest2840=ends[19];
          }
          if(ends[20]>=biggest2840){
            biggest2840=ends[20];
          }
          if(biggest2840 == 1){
            active[18]=1;
            ends[18]=1;
            break RUN;
          }
        
        case 2 : 
          thread2841(tdone,ends);
          thread2842(tdone,ends);
          int biggest2843 = 0;
          if(ends[19]>=biggest2843){
            biggest2843=ends[19];
          }
          if(ends[20]>=biggest2843){
            biggest2843=ends[20];
          }
          if(biggest2843 == 1){
            active[18]=1;
            ends[18]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2843 == 0){
            S2793=0;
            active[18]=0;
            ends[18]=0;
            S2793=0;
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
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[18] != 0){
      int index = 18;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[18]!=0 || suspended[18]!=0 || active[18]!=1);
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
      if(paused[18]!=0 || suspended[18]!=0 || active[18]!=1);
      else{
        bottleLoad.gethook();
        bottleUnload.gethook();
        CMDfb_L.gethook();
        CMDfb_L2.gethook();
        CMDfb_R.gethook();
        CMDfb_R2.gethook();
      }
      runFinisher();
      if(active[18] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
