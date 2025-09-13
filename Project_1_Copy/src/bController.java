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
  private int S1385 = 1;
  private int S972 = 1;
  private int S848 = 1;
  private int S1109 = 1;
  private int S985 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread1409(int [] tdone, int [] ends){
        switch(S1109){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S985){
          case 0 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 312, column: 10
              S985=1;
              CMD_R2.setPresent();//sysj\controller.sysj line: 316, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 316, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 313, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 313, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 315, column: 10
              S985=2;
              CMD_R.setPresent();//sysj\controller.sysj line: 319, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 319, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 316, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 316, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 318, column: 10
              S985=3;
              CMD_R2.setPresent();//sysj\controller.sysj line: 322, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 322, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 319, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\controller.sysj line: 319, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 321, column: 10
              S985=4;
              CMD_R.setPresent();//sysj\controller.sysj line: 325, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 325, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 322, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb C");//sysj\controller.sysj line: 322, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\controller.sysj line: 324, column: 10
              S985=5;
              CMD_R2.setPresent();//sysj\controller.sysj line: 328, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 328, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R.setPresent();//sysj\controller.sysj line: 325, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\controller.sysj line: 325, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\controller.sysj line: 327, column: 10
              S985=0;
              CMD_R.setPresent();//sysj\controller.sysj line: 313, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 313, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\controller.sysj line: 328, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\controller.sysj line: 328, column: 5
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1408(int [] tdone, int [] ends){
        switch(S972){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S848){
          case 0 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 289, column: 10
              S848=1;
              CMD_L2.setPresent();//sysj\controller.sysj line: 293, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 293, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 290, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 290, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 292, column: 10
              S848=2;
              CMD_L.setPresent();//sysj\controller.sysj line: 296, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 296, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 293, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 293, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 295, column: 10
              S848=3;
              CMD_L2.setPresent();//sysj\controller.sysj line: 299, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 299, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 296, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\controller.sysj line: 296, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 298, column: 10
              S848=4;
              CMD_L.setPresent();//sysj\controller.sysj line: 302, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 302, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 299, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\controller.sysj line: 299, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\controller.sysj line: 301, column: 10
              S848=5;
              CMD_L2.setPresent();//sysj\controller.sysj line: 305, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 305, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L.setPresent();//sysj\controller.sysj line: 302, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\controller.sysj line: 302, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_L2.getprestatus()){//sysj\controller.sysj line: 304, column: 10
              S848=0;
              CMD_L.setPresent();//sysj\controller.sysj line: 290, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 290, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\controller.sysj line: 305, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\controller.sysj line: 305, column: 5
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1406(int [] tdone, int [] ends){
        S1109=1;
    S985=0;
    CMD_R.setPresent();//sysj\controller.sysj line: 313, column: 5
    currsigs.addElement(CMD_R);
    CMD_R.setValue("limb_moveto right_limb B");//sysj\controller.sysj line: 313, column: 5
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread1405(int [] tdone, int [] ends){
        S972=1;
    S848=0;
    CMD_L.setPresent();//sysj\controller.sysj line: 290, column: 5
    currsigs.addElement(CMD_L);
    CMD_L.setValue("limb_moveto left_limb B");//sysj\controller.sysj line: 290, column: 5
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1385){
        case 0 : 
          S1385=0;
          break RUN;
        
        case 1 : 
          S1385=2;
          S1385=2;
          System.out.println("Baxtor robot Controller started");//sysj\controller.sysj line: 286, column: 2
          thread1405(tdone,ends);
          thread1406(tdone,ends);
          int biggest1407 = 0;
          if(ends[13]>=biggest1407){
            biggest1407=ends[13];
          }
          if(ends[14]>=biggest1407){
            biggest1407=ends[14];
          }
          if(biggest1407 == 1){
            active[12]=1;
            ends[12]=1;
            break RUN;
          }
        
        case 2 : 
          thread1408(tdone,ends);
          thread1409(tdone,ends);
          int biggest1410 = 0;
          if(ends[13]>=biggest1410){
            biggest1410=ends[13];
          }
          if(ends[14]>=biggest1410){
            biggest1410=ends[14];
          }
          if(biggest1410 == 1){
            active[12]=1;
            ends[12]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1410 == 0){
            S1385=0;
            active[12]=0;
            ends[12]=0;
            S1385=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[12] != 0){
      int index = 12;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
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
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
      else{
        bottleLoad.gethook();
        bottleUnload.gethook();
        CMDfb_L.gethook();
        CMDfb_L2.gethook();
        CMDfb_R.gethook();
        CMDfb_R2.gethook();
      }
      runFinisher();
      if(active[12] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
