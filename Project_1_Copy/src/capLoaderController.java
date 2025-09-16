import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\capLoaderController.sysj line: 2, column: 1

public class capLoaderController extends ClockDomain{
  public capLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal startLoading = new Signal("startLoading", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal capLoaded = new Signal("capLoaded", Signal.OUTPUT);
  public Signal capOnID = new Signal("capOnID", Signal.OUTPUT);
  private Signal bottleID_1;
  private int currnetID_thread_2;//sysj\capLoaderController.sysj line: 24, column: 4
  private int id_thread_2;//sysj\capLoaderController.sysj line: 56, column: 4
  private BottleTwin b_thread_3;//sysj\capLoaderController.sysj line: 71, column: 4
  private int id_thread_3;//sysj\capLoaderController.sysj line: 72, column: 4
  private int S388 = 1;
  private int S179 = 1;
  private int S3 = 1;
  private int S34 = 1;
  private int S193 = 1;
  private int S181 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread394(int [] tdone, int [] ends){
        switch(S193){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S181){
          case 0 : 
            if(bottleIn.getprestatus()){//sysj\capLoaderController.sysj line: 69, column: 10
              b_thread_3 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\capLoaderController.sysj line: 71, column: 4
              id_thread_3 = -1;//sysj\capLoaderController.sysj line: 72, column: 4
              if(b_thread_3 != null) {//sysj\capLoaderController.sysj line: 73, column: 16
                id_thread_3 = b_thread_3.ID;//sysj\capLoaderController.sysj line: 74, column: 5
              }
              bottleID_1.setPresent();//sysj\capLoaderController.sysj line: 76, column: 4
              currsigs.addElement(bottleID_1);
              bottleID_1.setValue(id_thread_3);//sysj\capLoaderController.sysj line: 76, column: 4
              System.out.println("Emitted bottleID_1");
              S181=1;
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
            S181=1;
            S181=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread393(int [] tdone, int [] ends){
        switch(S179){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3){
          case 0 : 
            S3=0;
            S3=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 1 : 
            if(startLoading.getprestatus()){//sysj\capLoaderController.sysj line: 20, column: 10
              S3=2;
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
            S3=2;
            currnetID_thread_2 = (int)(bottleID_1.getpreval() == null ? 0 : ((Integer)bottleID_1.getpreval()).intValue());//sysj\capLoaderController.sysj line: 24, column: 4
            if(currnetID_thread_2 == -1) {//sysj\capLoaderController.sysj line: 25, column: 24
              break ;//sysj\capLoaderController.sysj line: 26, column: 5
            }
            S3=3;
            armDest.setPresent();//sysj\capLoaderController.sysj line: 31, column: 5
            currsigs.addElement(armDest);
            System.out.println("Emitted armDest");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 3 : 
            if(armAtDest.getprestatus()){//sysj\capLoaderController.sysj line: 30, column: 10
              ;//sysj\capLoaderController.sysj line: 32, column: 5
              S3=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armDest.setPresent();//sysj\capLoaderController.sysj line: 31, column: 5
              currsigs.addElement(armDest);
              System.out.println("Emitted armDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            S3=4;
            S3=5;
            pusherExtend.setPresent();//sysj\capLoaderController.sysj line: 35, column: 5
            currsigs.addElement(pusherExtend);
            System.out.println("Emitted pusherExtend");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 5 : 
            if(pusherExtended.getprestatus()){//sysj\capLoaderController.sysj line: 34, column: 10
              S3=6;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              pusherExtend.setPresent();//sysj\capLoaderController.sysj line: 35, column: 5
              currsigs.addElement(pusherExtend);
              System.out.println("Emitted pusherExtend");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 6 : 
            S3=6;
            S3=7;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 7 : 
            if(pusherRetracted.getprestatus()){//sysj\capLoaderController.sysj line: 38, column: 10
              S3=8;
              armSource.setPresent();//sysj\capLoaderController.sysj line: 40, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
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
          
          case 8 : 
            if(armAtSource.getprestatus()){//sysj\capLoaderController.sysj line: 39, column: 10
              ;//sysj\capLoaderController.sysj line: 41, column: 5
              S3=9;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armSource.setPresent();//sysj\capLoaderController.sysj line: 40, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 9 : 
            S3=9;
            S3=10;
            S34=0;
            vacOn.setPresent();//sysj\capLoaderController.sysj line: 44, column: 5
            currsigs.addElement(vacOn);
            System.out.println("Emitted vacOn");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 10 : 
            if(WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 43, column: 10
              ;//sysj\capLoaderController.sysj line: 46, column: 5
              S3=11;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S34){
                case 0 : 
                  vacOn.setPresent();//sysj\capLoaderController.sysj line: 44, column: 5
                  currsigs.addElement(vacOn);
                  System.out.println("Emitted vacOn");
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 1 : 
                  if(WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 45, column: 11
                    ;//sysj\capLoaderController.sysj line: 46, column: 5
                    S3=11;
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
                
              }
            }
            break;
          
          case 11 : 
            S3=11;
            S3=12;
            vacOn.setPresent();//sysj\capLoaderController.sysj line: 50, column: 6
            currsigs.addElement(vacOn);
            System.out.println("Emitted vacOn");
            armDest.setPresent();//sysj\capLoaderController.sysj line: 51, column: 6
            currsigs.addElement(armDest);
            System.out.println("Emitted armDest");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 12 : 
            if(armAtDest.getprestatus()){//sysj\capLoaderController.sysj line: 48, column: 10
              S3=13;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              vacOn.setPresent();//sysj\capLoaderController.sysj line: 50, column: 6
              currsigs.addElement(vacOn);
              System.out.println("Emitted vacOn");
              armDest.setPresent();//sysj\capLoaderController.sysj line: 51, column: 6
              currsigs.addElement(armDest);
              System.out.println("Emitted armDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(!WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 55, column: 10
              id_thread_2 = (int)(bottleID_1.getpreval() == null ? 0 : ((Integer)bottleID_1.getpreval()).intValue());//sysj\capLoaderController.sysj line: 56, column: 4
              capOnID.setPresent();//sysj\capLoaderController.sysj line: 57, column: 4
              currsigs.addElement(capOnID);
              capOnID.setValue(id_thread_2);//sysj\capLoaderController.sysj line: 57, column: 4
              System.out.println("Emitted capOnID");
              S3=14;
              armSource.setPresent();//sysj\capLoaderController.sysj line: 59, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
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
          
          case 14 : 
            if(armAtSource.getprestatus()){//sysj\capLoaderController.sysj line: 58, column: 10
              ;//sysj\capLoaderController.sysj line: 60, column: 5
              S3=15;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armSource.setPresent();//sysj\capLoaderController.sysj line: 59, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 15 : 
            S3=15;
            capLoaded.setPresent();//sysj\capLoaderController.sysj line: 62, column: 4
            currsigs.addElement(capLoaded);
            System.out.println("Emitted capLoaded");
            S3=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread391(int [] tdone, int [] ends){
        S193=1;
    bottleID_1.setPresent();//sysj\capLoaderController.sysj line: 67, column: 3
    currsigs.addElement(bottleID_1);
    bottleID_1.setValue(-1);//sysj\capLoaderController.sysj line: 67, column: 3
    System.out.println("Emitted bottleID_1");
    S181=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread390(int [] tdone, int [] ends){
        S179=1;
    S3=0;
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
      switch(S388){
        case 0 : 
          S388=0;
          break RUN;
        
        case 1 : 
          S388=2;
          S388=2;
          bottleID_1.setClear();//sysj\capLoaderController.sysj line: 12, column: 2
          System.out.println("caploader Controller started");//sysj\capLoaderController.sysj line: 14, column: 5
          thread390(tdone,ends);
          thread391(tdone,ends);
          int biggest392 = 0;
          if(ends[2]>=biggest392){
            biggest392=ends[2];
          }
          if(ends[3]>=biggest392){
            biggest392=ends[3];
          }
          if(biggest392 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottleID_1.setClear();//sysj\capLoaderController.sysj line: 12, column: 2
          thread393(tdone,ends);
          thread394(tdone,ends);
          int biggest395 = 0;
          if(ends[2]>=biggest395){
            biggest395=ends[2];
          }
          if(ends[3]>=biggest395){
            biggest395=ends[3];
          }
          if(biggest395 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest395 == 0){
            S388=0;
            active[1]=0;
            ends[1]=0;
            S388=0;
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
    bottleID_1 = new Signal();
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          startLoading.gethook();
          bottleIn.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      startLoading.setpreclear();
      bottleIn.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      capLoaded.setpreclear();
      capOnID.setpreclear();
      bottleID_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = startLoading.getStatus() ? startLoading.setprepresent() : startLoading.setpreclear();
      startLoading.setpreval(startLoading.getValue());
      startLoading.setClear();
      dummyint = bottleIn.getStatus() ? bottleIn.setprepresent() : bottleIn.setpreclear();
      bottleIn.setpreval(bottleIn.getValue());
      bottleIn.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      capLoaded.sethook();
      capLoaded.setClear();
      capOnID.sethook();
      capOnID.setClear();
      bottleID_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        startLoading.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
