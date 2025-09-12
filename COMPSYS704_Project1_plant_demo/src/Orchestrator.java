import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Orchestrator extends ClockDomain{
  public Orchestrator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public input_Channel rotaryTableStatus_in = new input_Channel();
  public input_Channel capperStatus_in = new input_Channel();
  public output_Channel rotaryTableRequest_o = new output_Channel();
  public output_Channel capperRequest_o = new output_Channel();
  private int S860 = 1;
  private int S743 = 1;
  private int S727 = 1;
  private int S722 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S860){
        case 0 : 
          S860=0;
          break RUN;
        
        case 1 : 
          S860=2;
          S860=2;
          System.out.println("Hello Machine");//sysj\orchestrator.sysj line: 6, column: 2
          S743=0;
          S727=0;
          if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
            rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
            S727=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            S722=0;
            if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
              rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
              S722=1;
              if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                ends[1]=2;
                ;//sysj\orchestrator.sysj line: 9, column: 4
                S743=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
            else {
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S743){
            case 0 : 
              switch(S727){
                case 0 : 
                  if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    S727=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    switch(S722){
                      case 0 : 
                        if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                          rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                          S722=1;
                          if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                            rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                            ends[1]=2;
                            ;//sysj\orchestrator.sysj line: 9, column: 4
                            S743=1;
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                      case 1 : 
                        if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                          rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                          ends[1]=2;
                          ;//sysj\orchestrator.sysj line: 9, column: 4
                          S743=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      
                    }
                  }
                  break;
                
                case 1 : 
                  S727=1;
                  S727=0;
                  if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    S727=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S722=0;
                    if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                      rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                      S722=1;
                      if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                        rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                        ends[1]=2;
                        ;//sysj\orchestrator.sysj line: 9, column: 4
                        S743=1;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
              }
              break;
            
            case 1 : 
              S743=1;
              S743=0;
              S727=0;
              if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                S727=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                S722=0;
                if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                  rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                  S722=1;
                  if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    ends[1]=2;
                    ;//sysj\orchestrator.sysj line: 9, column: 4
                    S743=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
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
          rotaryTableStatus_in.gethook();
          capperStatus_in.gethook();
          rotaryTableRequest_o.gethook();
          capperRequest_o.gethook();
          df = true;
        }
        runClockDomain();
      }
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      rotaryTableStatus_in.sethook();
      capperStatus_in.sethook();
      rotaryTableRequest_o.sethook();
      capperRequest_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        rotaryTableStatus_in.gethook();
        capperStatus_in.gethook();
        rotaryTableRequest_o.gethook();
        capperRequest_o.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
