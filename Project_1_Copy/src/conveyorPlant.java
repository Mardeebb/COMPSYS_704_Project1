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
  private int S2252 = 1;
  private int S2233 = 1;
  private int S2183 = 1;
  private int S2164 = 1;
  private int S2250 = 1;
  private int S2238 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread2258(int [] tdone, int [] ends){
        switch(S2250){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2238){
          case 0 : 
            S2238=0;
            if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
              currsigs.addElement(bottleAtPos1);
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S2238=1;
            S2238=0;
            if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
              currsigs.addElement(bottleAtPos1);
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
                bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
                currsigs.addElement(bottleLeftPos5);
                S2238=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S2238=1;
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

  public void thread2257(int [] tdone, int [] ends){
        switch(S2233){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2183){
          case 0 : 
            if(motConveyorOnOff.getprestatus()){//sysj\conveyorPlant.sysj line: 17, column: 10
              S2183=1;
              S2164=0;
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
              S2183=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S2164){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\conveyorPlant.sysj line: 21, column: 11
                    S2164=1;
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
                    S2164=2;
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
                  S2164=2;
                  S2164=3;
                  plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 34, column: 5
                  currsigs.addElement(plantMoved);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 3 : 
                  plantMoved.setPresent();//sysj\conveyorPlant.sysj line: 34, column: 5
                  currsigs.addElement(plantMoved);
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

  public void thread2255(int [] tdone, int [] ends){
        S2250=1;
    S2238=0;
    if(bottleAtOne.getprestatus()){//sysj\conveyorPlant.sysj line: 44, column: 12
      bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 45, column: 5
      currsigs.addElement(bottleAtPos1);
      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
        currsigs.addElement(bottleLeftPos5);
        S2238=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S2238=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
    else {
      if(!bottleAtFive.getprestatus()){//sysj\conveyorPlant.sysj line: 47, column: 12
        bottleLeftPos5.setPresent();//sysj\conveyorPlant.sysj line: 48, column: 5
        currsigs.addElement(bottleLeftPos5);
        S2238=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S2238=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread2254(int [] tdone, int [] ends){
        S2233=1;
    S2183=0;
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
      switch(S2252){
        case 0 : 
          S2252=0;
          break RUN;
        
        case 1 : 
          S2252=2;
          S2252=2;
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          thread2254(tdone,ends);
          thread2255(tdone,ends);
          int biggest2256 = 0;
          if(ends[2]>=biggest2256){
            biggest2256=ends[2];
          }
          if(ends[3]>=biggest2256){
            biggest2256=ends[3];
          }
          if(biggest2256 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          conveyorMove_1.setClear();//sysj\conveyorPlant.sysj line: 13, column: 2
          thread2257(tdone,ends);
          thread2258(tdone,ends);
          int biggest2259 = 0;
          if(ends[2]>=biggest2259){
            biggest2259=ends[2];
          }
          if(ends[3]>=biggest2259){
            biggest2259=ends[3];
          }
          if(biggest2259 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2259 == 0){
            S2252=0;
            active[1]=0;
            ends[1]=0;
            S2252=0;
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
