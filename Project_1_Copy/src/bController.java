import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class bController extends ClockDomain{
  public bController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal startBottleLoading = new Signal("startBottleLoading", Signal.INPUT);
  public Signal startBottleUnloading = new Signal("startBottleUnloading", Signal.INPUT);
  public Signal CMDfb_L = new Signal("CMDfb_L", Signal.INPUT);
  public Signal CMDfb_L2 = new Signal("CMDfb_L2", Signal.INPUT);
  public Signal CMDfb_R = new Signal("CMDfb_R", Signal.INPUT);
  public Signal CMDfb_R2 = new Signal("CMDfb_R2", Signal.INPUT);
  public Signal CMD_L = new Signal("CMD_L", Signal.OUTPUT);
  public Signal CMD_L2 = new Signal("CMD_L2", Signal.OUTPUT);
  public Signal CMD_R = new Signal("CMD_R", Signal.OUTPUT);
  public Signal CMD_R2 = new Signal("CMD_R2", Signal.OUTPUT);
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.OUTPUT);
  public Signal bottleUnloaded = new Signal("bottleUnloaded", Signal.OUTPUT);
  public Signal bottleLoaderRelease = new Signal("bottleLoaderRelease", Signal.OUTPUT);
  private int S7576 = 1;
  private int S7028 = 1;
  private int S6850 = 1;
  private int S7210 = 1;
  private int S7032 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread7582(int [] tdone, int [] ends){
        switch(S7210){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S7032){
          case 0 : 
            if(!startBottleUnloading.getprestatus()){//sysj\robotController.sysj line: 37, column: 10
              S7032=1;
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
            if(startBottleUnloading.getprestatus()){//sysj\robotController.sysj line: 38, column: 10
              S7032=2;
              CMD_R.setPresent();//sysj\robotController.sysj line: 40, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb C");//sysj\robotController.sysj line: 40, column: 5
              System.out.println("Emitted CMD_R");
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
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 39, column: 10
              S7032=3;
              CMD_R2.setPresent();//sysj\robotController.sysj line: 43, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 43, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 40, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb C");//sysj\robotController.sysj line: 40, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 42, column: 10
              S7032=4;
              CMD_R.setPresent();//sysj\robotController.sysj line: 46, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\robotController.sysj line: 46, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 43, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 43, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 45, column: 10
              S7032=5;
              bottleUnloaded.setPresent();//sysj\robotController.sysj line: 50, column: 5
              currsigs.addElement(bottleUnloaded);
              System.out.println("Emitted bottleUnloaded");
              CMD_R2.setPresent();//sysj\robotController.sysj line: 51, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb B");//sysj\robotController.sysj line: 51, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 46, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\robotController.sysj line: 46, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 48, column: 10
              S7032=6;
              CMD_R.setPresent();//sysj\robotController.sysj line: 54, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 54, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 51, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb B");//sysj\robotController.sysj line: 51, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 6 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 53, column: 10
              S7032=7;
              CMD_R2.setPresent();//sysj\robotController.sysj line: 57, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\robotController.sysj line: 57, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 54, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 54, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 7 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 56, column: 10
              S7032=0;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 57, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\robotController.sysj line: 57, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7581(int [] tdone, int [] ends){
        switch(S7028){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S6850){
          case 0 : 
            if(!startBottleLoading.getprestatus()){//sysj\robotController.sysj line: 9, column: 10
              S6850=1;
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
            if(startBottleLoading.getprestatus()){//sysj\robotController.sysj line: 10, column: 10
              S6850=2;
              CMD_L.setPresent();//sysj\robotController.sysj line: 12, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\robotController.sysj line: 12, column: 5
              System.out.println("Emitted CMD_L");
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
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 11, column: 10
              S6850=3;
              CMD_L2.setPresent();//sysj\robotController.sysj line: 15, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 15, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 12, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\robotController.sysj line: 12, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\robotController.sysj line: 14, column: 10
              S6850=4;
              CMD_L.setPresent();//sysj\robotController.sysj line: 18, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\robotController.sysj line: 18, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\robotController.sysj line: 15, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 15, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 17, column: 10
              S6850=5;
              bottleLoaded.setPresent();//sysj\robotController.sysj line: 22, column: 5
              currsigs.addElement(bottleLoaded);
              System.out.println("Emitted bottleLoaded");
              CMD_L2.setPresent();//sysj\robotController.sysj line: 23, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\robotController.sysj line: 23, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 18, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb close");//sysj\robotController.sysj line: 18, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_L2.getprestatus()){//sysj\robotController.sysj line: 20, column: 10
              S6850=6;
              CMD_L.setPresent();//sysj\robotController.sysj line: 26, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 26, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\robotController.sysj line: 23, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb C");//sysj\robotController.sysj line: 23, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 6 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 25, column: 10
              S6850=7;
              CMD_L2.setPresent();//sysj\robotController.sysj line: 29, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\robotController.sysj line: 29, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 26, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 26, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 7 : 
            if(CMDfb_L2.getprestatus()){//sysj\robotController.sysj line: 28, column: 10
              bottleLoaderRelease.setPresent();//sysj\robotController.sysj line: 31, column: 4
              currsigs.addElement(bottleLoaderRelease);
              System.out.println("Emitted bottleLoaderRelease");
              S6850=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\robotController.sysj line: 29, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_moveto left_limb A");//sysj\robotController.sysj line: 29, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7579(int [] tdone, int [] ends){
        S7210=1;
    S7032=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread7578(int [] tdone, int [] ends){
        S7028=1;
    S6850=0;
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
      switch(S7576){
        case 0 : 
          S7576=0;
          break RUN;
        
        case 1 : 
          S7576=2;
          S7576=2;
          System.out.println("Baxtor robot Controller started");//sysj\robotController.sysj line: 6, column: 2
          thread7578(tdone,ends);
          thread7579(tdone,ends);
          int biggest7580 = 0;
          if(ends[2]>=biggest7580){
            biggest7580=ends[2];
          }
          if(ends[3]>=biggest7580){
            biggest7580=ends[3];
          }
          if(biggest7580 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread7581(tdone,ends);
          thread7582(tdone,ends);
          int biggest7583 = 0;
          if(ends[2]>=biggest7583){
            biggest7583=ends[2];
          }
          if(ends[3]>=biggest7583){
            biggest7583=ends[3];
          }
          if(biggest7583 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7583 == 0){
            S7576=0;
            active[1]=0;
            ends[1]=0;
            S7576=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          startBottleLoading.gethook();
          startBottleUnloading.gethook();
          CMDfb_L.gethook();
          CMDfb_L2.gethook();
          CMDfb_R.gethook();
          CMDfb_R2.gethook();
          df = true;
        }
        runClockDomain();
      }
      startBottleLoading.setpreclear();
      startBottleUnloading.setpreclear();
      CMDfb_L.setpreclear();
      CMDfb_L2.setpreclear();
      CMDfb_R.setpreclear();
      CMDfb_R2.setpreclear();
      CMD_L.setpreclear();
      CMD_L2.setpreclear();
      CMD_R.setpreclear();
      CMD_R2.setpreclear();
      bottleLoaded.setpreclear();
      bottleUnloaded.setpreclear();
      bottleLoaderRelease.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = startBottleLoading.getStatus() ? startBottleLoading.setprepresent() : startBottleLoading.setpreclear();
      startBottleLoading.setpreval(startBottleLoading.getValue());
      startBottleLoading.setClear();
      dummyint = startBottleUnloading.getStatus() ? startBottleUnloading.setprepresent() : startBottleUnloading.setpreclear();
      startBottleUnloading.setpreval(startBottleUnloading.getValue());
      startBottleUnloading.setClear();
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
      bottleLoaded.sethook();
      bottleLoaded.setClear();
      bottleUnloaded.sethook();
      bottleUnloaded.setClear();
      bottleLoaderRelease.sethook();
      bottleLoaderRelease.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        startBottleLoading.gethook();
        startBottleUnloading.gethook();
        CMDfb_L.gethook();
        CMDfb_L2.gethook();
        CMDfb_R.gethook();
        CMDfb_R2.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
