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
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal capOn = new Signal("capOn", Signal.OUTPUT);
  public Signal capOnID = new Signal("capOnID", Signal.OUTPUT);
  private Signal bottleID_1;
  private int currnetID_thread_2;//sysj\capLoaderController.sysj line: 21, column: 4
  private int id_thread_2;//sysj\capLoaderController.sysj line: 57, column: 4
  private BottleTwin b_thread_3;//sysj\capLoaderController.sysj line: 69, column: 4
  private int id_thread_3;//sysj\capLoaderController.sysj line: 70, column: 4
  private int S382 = 1;
  private int S176 = 1;
  private int S2 = 1;
  private int S33 = 1;
  private int S190 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread388(int [] tdone, int [] ends){
        switch(S190){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(bottleIn.getprestatus()){//sysj\capLoaderController.sysj line: 68, column: 10
          b_thread_3 = (BottleTwin)(bottleIn.getpreval() == null ? null : ((BottleTwin)bottleIn.getpreval()));//sysj\capLoaderController.sysj line: 69, column: 4
          id_thread_3 = b_thread_3.ID;//sysj\capLoaderController.sysj line: 70, column: 4
          bottleID_1.setPresent();//sysj\capLoaderController.sysj line: 71, column: 4
          currsigs.addElement(bottleID_1);
          bottleID_1.setValue(id_thread_3);//sysj\capLoaderController.sysj line: 71, column: 4
          System.out.println("Emitted bottleID_1");
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
      
    }
  }

  public void thread387(int [] tdone, int [] ends){
        switch(S176){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2){
          case 0 : 
            if(request.getprestatus()){//sysj\capLoaderController.sysj line: 19, column: 10
              currnetID_thread_2 = (int)(bottleID_1.getpreval() == null ? 0 : ((Integer)bottleID_1.getpreval()).intValue());//sysj\capLoaderController.sysj line: 21, column: 4
              if(currnetID_thread_2 == -1) {//sysj\capLoaderController.sysj line: 22, column: 24
                break ;//sysj\capLoaderController.sysj line: 23, column: 5
              }
              System.err.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");//sysj\capLoaderController.sysj line: 25, column: 7
              S2=1;
              armDest.setPresent();//sysj\capLoaderController.sysj line: 29, column: 5
              currsigs.addElement(armDest);
              System.out.println("Emitted armDest");
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
            if(armAtDest.getprestatus()){//sysj\capLoaderController.sysj line: 28, column: 10
              ;//sysj\capLoaderController.sysj line: 30, column: 5
              S2=2;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armDest.setPresent();//sysj\capLoaderController.sysj line: 29, column: 5
              currsigs.addElement(armDest);
              System.out.println("Emitted armDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            S2=2;
            S2=3;
            pusherExtend.setPresent();//sysj\capLoaderController.sysj line: 33, column: 5
            currsigs.addElement(pusherExtend);
            System.out.println("Emitted pusherExtend");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 3 : 
            if(pusherExtended.getprestatus()){//sysj\capLoaderController.sysj line: 32, column: 10
              S2=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              pusherExtend.setPresent();//sysj\capLoaderController.sysj line: 33, column: 5
              currsigs.addElement(pusherExtend);
              System.out.println("Emitted pusherExtend");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            S2=4;
            S2=5;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 5 : 
            if(pusherRetracted.getprestatus()){//sysj\capLoaderController.sysj line: 36, column: 10
              S2=6;
              armSource.setPresent();//sysj\capLoaderController.sysj line: 38, column: 5
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
          
          case 6 : 
            if(armAtSource.getprestatus()){//sysj\capLoaderController.sysj line: 37, column: 10
              ;//sysj\capLoaderController.sysj line: 39, column: 5
              S2=7;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armSource.setPresent();//sysj\capLoaderController.sysj line: 38, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 7 : 
            S2=7;
            S2=8;
            S33=0;
            vacOn.setPresent();//sysj\capLoaderController.sysj line: 42, column: 5
            currsigs.addElement(vacOn);
            System.out.println("Emitted vacOn");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 8 : 
            if(WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 41, column: 10
              ;//sysj\capLoaderController.sysj line: 44, column: 5
              S2=9;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S33){
                case 0 : 
                  vacOn.setPresent();//sysj\capLoaderController.sysj line: 42, column: 5
                  currsigs.addElement(vacOn);
                  System.out.println("Emitted vacOn");
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 1 : 
                  if(WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 43, column: 11
                    ;//sysj\capLoaderController.sysj line: 44, column: 5
                    S2=9;
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
          
          case 9 : 
            S2=9;
            S2=10;
            vacOn.setPresent();//sysj\capLoaderController.sysj line: 48, column: 6
            currsigs.addElement(vacOn);
            System.out.println("Emitted vacOn");
            armDest.setPresent();//sysj\capLoaderController.sysj line: 49, column: 6
            currsigs.addElement(armDest);
            System.out.println("Emitted armDest");
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 10 : 
            if(armAtDest.getprestatus()){//sysj\capLoaderController.sysj line: 46, column: 10
              S2=11;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              vacOn.setPresent();//sysj\capLoaderController.sysj line: 48, column: 6
              currsigs.addElement(vacOn);
              System.out.println("Emitted vacOn");
              armDest.setPresent();//sysj\capLoaderController.sysj line: 49, column: 6
              currsigs.addElement(armDest);
              System.out.println("Emitted armDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 11 : 
            if(!WPgripped.getprestatus()){//sysj\capLoaderController.sysj line: 53, column: 10
              S2=12;
              armSource.setPresent();//sysj\capLoaderController.sysj line: 55, column: 5
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
          
          case 12 : 
            if(armAtSource.getprestatus()){//sysj\capLoaderController.sysj line: 54, column: 10
              ;//sysj\capLoaderController.sysj line: 56, column: 5
              id_thread_2 = (int)(bottleID_1.getpreval() == null ? 0 : ((Integer)bottleID_1.getpreval()).intValue());//sysj\capLoaderController.sysj line: 57, column: 4
              capOnID.setPresent();//sysj\capLoaderController.sysj line: 58, column: 4
              currsigs.addElement(capOnID);
              capOnID.setValue(id_thread_2);//sysj\capLoaderController.sysj line: 58, column: 4
              System.out.println("Emitted capOnID");
              capOn.setPresent();//sysj\capLoaderController.sysj line: 59, column: 4
              currsigs.addElement(capOn);
              System.out.println("Emitted capOn");
              bottleID_1.setPresent();//sysj\capLoaderController.sysj line: 60, column: 4
              currsigs.addElement(bottleID_1);
              bottleID_1.setValue(-1);//sysj\capLoaderController.sysj line: 60, column: 4
              System.out.println("Emitted bottleID_1");
              S2=13;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armSource.setPresent();//sysj\capLoaderController.sysj line: 55, column: 5
              currsigs.addElement(armSource);
              System.out.println("Emitted armSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            S2=13;
            S2=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread385(int [] tdone, int [] ends){
        S190=1;
    bottleID_1.setPresent();//sysj\capLoaderController.sysj line: 66, column: 3
    currsigs.addElement(bottleID_1);
    bottleID_1.setValue(-1);//sysj\capLoaderController.sysj line: 66, column: 3
    System.out.println("Emitted bottleID_1");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread384(int [] tdone, int [] ends){
        S176=1;
    S2=0;
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
      switch(S382){
        case 0 : 
          S382=0;
          break RUN;
        
        case 1 : 
          S382=2;
          S382=2;
          bottleID_1.setClear();//sysj\capLoaderController.sysj line: 12, column: 2
          System.out.println("caploader Controller started");//sysj\capLoaderController.sysj line: 14, column: 5
          thread384(tdone,ends);
          thread385(tdone,ends);
          int biggest386 = 0;
          if(ends[2]>=biggest386){
            biggest386=ends[2];
          }
          if(ends[3]>=biggest386){
            biggest386=ends[3];
          }
          if(biggest386 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          bottleID_1.setClear();//sysj\capLoaderController.sysj line: 12, column: 2
          thread387(tdone,ends);
          thread388(tdone,ends);
          int biggest389 = 0;
          if(ends[2]>=biggest389){
            biggest389=ends[2];
          }
          if(ends[3]>=biggest389){
            biggest389=ends[3];
          }
          if(biggest389 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest389 == 0){
            S382=0;
            active[1]=0;
            ends[1]=0;
            S382=0;
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
          request.gethook();
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
      request.setpreclear();
      bottleIn.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      capOn.setpreclear();
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
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
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
      capOn.sethook();
      capOn.setClear();
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
        request.gethook();
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
