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
  private int S268 = 1;
  private int S130 = 1;
  private int S94 = 1;
  private int S125 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S268){
        case 0 : 
          S268=0;
          break RUN;
        
        case 1 : 
          S268=2;
          S268=2;
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          S130=0;
          if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 19, column: 14
            bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 20, column: 7
            currsigs.addElement(bottleAtPos1);
            System.out.println("Emitted bottleAtPos1");
            S94=0;
            if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
              bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
              currsigs.addElement(bottleLeftPos5);
              System.out.println("Emitted bottleLeftPos5");
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S94=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
          else {
            S94=0;
            if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
              bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
              currsigs.addElement(bottleLeftPos5);
              System.out.println("Emitted bottleLeftPos5");
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S94=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          switch(S130){
            case 0 : 
              if(motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 17, column: 10
                S130=1;
                S125=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                switch(S94){
                  case 0 : 
                    bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
                    currsigs.addElement(bottleLeftPos5);
                    System.out.println("Emitted bottleLeftPos5");
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  
                  case 1 : 
                    S94=1;
                    if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 19, column: 14
                      bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 20, column: 7
                      currsigs.addElement(bottleAtPos1);
                      System.out.println("Emitted bottleAtPos1");
                      S94=0;
                      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
                        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
                        currsigs.addElement(bottleLeftPos5);
                        System.out.println("Emitted bottleLeftPos5");
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S94=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      S94=0;
                      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
                        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
                        currsigs.addElement(bottleLeftPos5);
                        System.out.println("Emitted bottleLeftPos5");
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S94=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  
                }
              }
              break;
            
            case 1 : 
              if(!motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 29, column: 10
                S130=2;
                plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 55, column: 5
                currsigs.addElement(plantMoved);
                System.out.println("Emitted plantMoved");
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                switch(S125){
                  case 0 : 
                    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 32, column: 11
                      S125=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 1 : 
                    S125=1;
                    S130=2;
                    plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 55, column: 5
                    currsigs.addElement(plantMoved);
                    System.out.println("Emitted plantMoved");
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  
                }
              }
              break;
            
            case 2 : 
              if(!motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 54, column: 10
                S130=0;
                if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 19, column: 14
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 20, column: 7
                  currsigs.addElement(bottleAtPos1);
                  System.out.println("Emitted bottleAtPos1");
                  S94=0;
                  if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
                    bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
                    currsigs.addElement(bottleLeftPos5);
                    System.out.println("Emitted bottleLeftPos5");
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S94=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  S94=0;
                  if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 22, column: 14
                    bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 23, column: 7
                    currsigs.addElement(bottleLeftPos5);
                    System.out.println("Emitted bottleLeftPos5");
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S94=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
              else {
                plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 55, column: 5
                currsigs.addElement(plantMoved);
                System.out.println("Emitted plantMoved");
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
