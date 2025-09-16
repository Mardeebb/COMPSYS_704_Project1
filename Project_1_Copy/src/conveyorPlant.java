import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\conveyorPlant.sysj line: 1, column: 1

public class conveyorPlant extends ClockDomain{
  public conveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleAtOne = new Signal("bottleAtOne", Signal.INPUT);
  public Signal bottleAtFive = new Signal("bottleAtFive", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal plantMoved = new Signal("plantMoved", Signal.OUTPUT);
  private Signal conveyorMove_1;
  private int S4036 = 1;
  private int S4017 = 1;
  private int S3967 = 1;
  private int S3948 = 1;
  private int S4034 = 1;
  private int S4022 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread4042(int [] tdone, int [] ends){
        switch(S4034){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S4022){
          case 0 : 
            S4022=0;
            if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                System.out.println("Emitted bottleLeftPos5");
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                System.out.println("Emitted bottleLeftPos5");
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S4022=1;
            S4022=0;
            if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                System.out.println("Emitted bottleLeftPos5");
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                System.out.println("Emitted bottleLeftPos5");
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S4022=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4041(int [] tdone, int [] ends){
        switch(S4017){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3967){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 17, column: 10
              S3967=1;
              S3948=0;
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
            if(!motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 18, column: 10
              S3967=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S3948){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\conveyorPlant.sysj line: 21, column: 11
                    S3948=1;
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
                  if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 11
                    S3948=2;
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
                  S3948=2;
                  S3948=3;
                  plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 34, column: 5
                  currsigs.addElement(plantMoved);
                  System.out.println("Emitted plantMoved");
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 3 : 
                  plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 34, column: 5
                  currsigs.addElement(plantMoved);
                  System.out.println("Emitted plantMoved");
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread4039(int [] tdone, int [] ends){
        S4034=1;
    S4022=0;
    if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
      bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
      currsigs.addElement(bottleAtPos1);
      System.out.println("Emitted bottleAtPos1");
      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
        currsigs.addElement(bottleLeftPos5);
        System.out.println("Emitted bottleLeftPos5");
        S4022=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4022=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
    else {
      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
        currsigs.addElement(bottleLeftPos5);
        System.out.println("Emitted bottleLeftPos5");
        S4022=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S4022=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread4038(int [] tdone, int [] ends){
        S4017=1;
    S3967=0;
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
      switch(S4036){
        case 0 : 
          S4036=0;
          break RUN;
        
        case 1 : 
          S4036=2;
          S4036=2;
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          thread4038(tdone,ends);
          thread4039(tdone,ends);
          int biggest4040 = 0;
          if(ends[2]>=biggest4040){
            biggest4040=ends[2];
          }
          if(ends[3]>=biggest4040){
            biggest4040=ends[3];
          }
          if(biggest4040 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          thread4041(tdone,ends);
          thread4042(tdone,ends);
          int biggest4043 = 0;
          if(ends[2]>=biggest4043){
            biggest4043=ends[2];
          }
          if(ends[3]>=biggest4043){
            biggest4043=ends[3];
          }
          if(biggest4043 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4043 == 0){
            S4036=0;
            active[1]=0;
            ends[1]=0;
            S4036=0;
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
    conveyorMove_1 = new Signal();
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
          motConveyorOnOff.gethook();
          enable.gethook();
          bottleAtOne.gethook();
          bottleAtFive.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOnOff.setpreclear();
      enable.setpreclear();
      bottleAtOne.setpreclear();
      bottleAtFive.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      plantMoved.setpreclear();
      conveyorMove_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOnOff.getStatus() ? motConveyorOnOff.setprepresent() : motConveyorOnOff.setpreclear();
      motConveyorOnOff.setpreval(motConveyorOnOff.getValue());
      motConveyorOnOff.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleAtOne.getStatus() ? bottleAtOne.setprepresent() : bottleAtOne.setpreclear();
      bottleAtOne.setpreval(bottleAtOne.getValue());
      bottleAtOne.setClear();
      dummyint = bottleAtFive.getStatus() ? bottleAtFive.setprepresent() : bottleAtFive.setpreclear();
      bottleAtFive.setpreval(bottleAtFive.getValue());
      bottleAtFive.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      plantMoved.sethook();
      plantMoved.setClear();
      conveyorMove_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOnOff.gethook();
        enable.gethook();
        bottleAtOne.gethook();
        bottleAtFive.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
