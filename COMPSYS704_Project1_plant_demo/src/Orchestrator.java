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
  private int S368 = 1;
  private int S251 = 1;
  private int S235 = 1;
  private int S230 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S368){
        case 0 : 
          S368=0;
          break RUN;
        
        case 1 : 
          S368=2;
          S368=2;
          System.out.println("Hello Machine");//sysj\orchestrator.sysj line: 6, column: 2
          S251=0;
          S235=0;
          if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
            rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
            S235=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            S230=0;
            if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
              rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
              S230=1;
              if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                ends[1]=2;
                ;//sysj\orchestrator.sysj line: 9, column: 4
                S251=1;
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
          switch(S251){
            case 0 : 
              switch(S235){
                case 0 : 
                  if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    S235=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    switch(S230){
                      case 0 : 
                        if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                          rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                          S230=1;
                          if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                            rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                            ends[1]=2;
                            ;//sysj\orchestrator.sysj line: 9, column: 4
                            S251=1;
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
                          S251=1;
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
                  S235=1;
                  S235=0;
                  if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    S235=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    S230=0;
                    if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                      rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                      S230=1;
                      if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                        rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                        ends[1]=2;
                        ;//sysj\orchestrator.sysj line: 9, column: 4
                        S251=1;
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
              S251=1;
              S251=0;
              S235=0;
              if(!rotaryTableRequest_o.isPartnerPresent() || rotaryTableRequest_o.isPartnerPreempted()){//sysj\orchestrator.sysj line: 9, column: 4
                rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                S235=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                S230=0;
                if(rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                  rotaryTableRequest_o.setVal(true);//sysj\orchestrator.sysj line: 9, column: 4
                  S230=1;
                  if(!rotaryTableRequest_o.isACK()){//sysj\orchestrator.sysj line: 9, column: 4
                    rotaryTableRequest_o.setREQ(false);//sysj\orchestrator.sysj line: 9, column: 4
                    ends[1]=2;
                    ;//sysj\orchestrator.sysj line: 9, column: 4
                    S251=1;
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
