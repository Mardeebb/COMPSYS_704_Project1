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
  private int S4379 = 1;
  private int S3906 = 1;
  private int S3722 = 1;
  private int S4043 = 1;
  private int S3919 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread4385(int [] tdone, int [] ends){
        switch(S4043){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S3919){
          case 0 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 32, column: 10
              S3919=1;
              CMD_R2.setPresent();//sysj\robotController.sysj line: 36, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 36, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 33, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb C");//sysj\robotController.sysj line: 33, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 35, column: 10
              S3919=2;
              CMD_R.setPresent();//sysj\robotController.sysj line: 39, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\robotController.sysj line: 39, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 36, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 36, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 38, column: 10
              S3919=3;
              CMD_R2.setPresent();//sysj\robotController.sysj line: 42, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb B");//sysj\robotController.sysj line: 42, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 39, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb close");//sysj\robotController.sysj line: 39, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 41, column: 10
              S3919=4;
              CMD_R.setPresent();//sysj\robotController.sysj line: 45, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 45, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 42, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb B");//sysj\robotController.sysj line: 42, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_R.getprestatus()){//sysj\robotController.sysj line: 44, column: 10
              S3919=5;
              CMD_R2.setPresent();//sysj\robotController.sysj line: 48, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\robotController.sysj line: 48, column: 5
              System.out.println("Emitted CMD_R2");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R.setPresent();//sysj\robotController.sysj line: 45, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_gripper right_limb open");//sysj\robotController.sysj line: 45, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(CMDfb_R2.getprestatus()){//sysj\robotController.sysj line: 47, column: 10
              S3919=0;
              CMD_R.setPresent();//sysj\robotController.sysj line: 33, column: 5
              currsigs.addElement(CMD_R);
              CMD_R.setValue("limb_moveto right_limb C");//sysj\robotController.sysj line: 33, column: 5
              System.out.println("Emitted CMD_R");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              CMD_R2.setPresent();//sysj\robotController.sysj line: 48, column: 5
              currsigs.addElement(CMD_R2);
              CMD_R2.setValue("limb_moveto right_limb A");//sysj\robotController.sysj line: 48, column: 5
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

  public void thread4384(int [] tdone, int [] ends){
        switch(S3906){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3722){
          case 0 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 9, column: 10
              S3722=1;
              CMD_L2.setPresent();//sysj\robotController.sysj line: 13, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb close");//sysj\robotController.sysj line: 13, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 10, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\robotController.sysj line: 10, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(CMDfb_L2.getprestatus()){//sysj\robotController.sysj line: 12, column: 10
              S3722=2;
              CMD_L.setPresent();//sysj\robotController.sysj line: 16, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb C");//sysj\robotController.sysj line: 16, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\robotController.sysj line: 13, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb close");//sysj\robotController.sysj line: 13, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 15, column: 10
              S3722=3;
              CMD_L2.setPresent();//sysj\robotController.sysj line: 19, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 19, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 16, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb C");//sysj\robotController.sysj line: 16, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(CMDfb_L2.getprestatus()){//sysj\robotController.sysj line: 18, column: 10
              S3722=4;
              CMD_L.setPresent();//sysj\robotController.sysj line: 22, column: 6
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb A");//sysj\robotController.sysj line: 22, column: 6
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L2.setPresent();//sysj\robotController.sysj line: 19, column: 5
              currsigs.addElement(CMD_L2);
              CMD_L2.setValue("limb_gripper left_limb open");//sysj\robotController.sysj line: 19, column: 5
              System.out.println("Emitted CMD_L2");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            if(CMDfb_L.getprestatus()){//sysj\robotController.sysj line: 21, column: 10
              S3722=0;
              CMD_L.setPresent();//sysj\robotController.sysj line: 10, column: 5
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb B");//sysj\robotController.sysj line: 10, column: 5
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              CMD_L.setPresent();//sysj\robotController.sysj line: 22, column: 6
              currsigs.addElement(CMD_L);
              CMD_L.setValue("limb_moveto left_limb A");//sysj\robotController.sysj line: 22, column: 6
              System.out.println("Emitted CMD_L");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4382(int [] tdone, int [] ends){
        S4043=1;
    S3919=0;
    CMD_R.setPresent();//sysj\robotController.sysj line: 33, column: 5
    currsigs.addElement(CMD_R);
    CMD_R.setValue("limb_moveto right_limb C");//sysj\robotController.sysj line: 33, column: 5
    System.out.println("Emitted CMD_R");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4381(int [] tdone, int [] ends){
        S3906=1;
    S3722=0;
    CMD_L.setPresent();//sysj\robotController.sysj line: 10, column: 5
    currsigs.addElement(CMD_L);
    CMD_L.setValue("limb_moveto left_limb B");//sysj\robotController.sysj line: 10, column: 5
    System.out.println("Emitted CMD_L");
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
      switch(S4379){
        case 0 : 
          S4379=0;
          break RUN;
        
        case 1 : 
          S4379=2;
          S4379=2;
          System.out.println("Baxtor robot Controller started");//sysj\robotController.sysj line: 6, column: 2
          thread4381(tdone,ends);
          thread4382(tdone,ends);
          int biggest4383 = 0;
          if(ends[2]>=biggest4383){
            biggest4383=ends[2];
          }
          if(ends[3]>=biggest4383){
            biggest4383=ends[3];
          }
          if(biggest4383 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread4384(tdone,ends);
          thread4385(tdone,ends);
          int biggest4386 = 0;
          if(ends[2]>=biggest4386){
            biggest4386=ends[2];
          }
          if(ends[3]>=biggest4386){
            biggest4386=ends[3];
          }
          if(biggest4386 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4386 == 0){
            S4379=0;
            active[1]=0;
            ends[1]=0;
            S4379=0;
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
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleLoad.gethook();
        bottleUnload.gethook();
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
