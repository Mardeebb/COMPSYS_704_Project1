import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTableController extends ClockDomain{
  public RotaryTableController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public input_Channel rotaryTableRequest_in = new input_Channel();
  public output_Channel rotaryTableStatus_o = new output_Channel();
  private int S227 = 1;
  private int S26 = 1;
  private int S10 = 1;
  private int S5 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S227){
        case 0 : 
          S227=0;
          break RUN;
        
        case 1 : 
          S227=2;
          S227=2;
          System.out.println("Rotary Table started");//sysj\controller.sysj line: 39, column: 5
          S26=0;
          S10=0;
          if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 43, column: 4
            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
            S10=1;
            active[3]=1;
            ends[3]=1;
            break RUN;
          }
          else {
            S5=0;
            if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
              rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 43, column: 4
              S5=1;
              if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                ends[3]=2;
                ;//sysj\controller.sysj line: 43, column: 4
                System.out.println("Request received");//sysj\controller.sysj line: 44, column: 4
                S26=1;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S26){
            case 0 : 
              switch(S10){
                case 0 : 
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 43, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                    S10=1;
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                  else {
                    switch(S5){
                      case 0 : 
                        if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                          rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 43, column: 4
                          S5=1;
                          if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                            ends[3]=2;
                            ;//sysj\controller.sysj line: 43, column: 4
                            System.out.println("Request received");//sysj\controller.sysj line: 44, column: 4
                            S26=1;
                            active[3]=1;
                            ends[3]=1;
                            break RUN;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          break RUN;
                        }
                      
                      case 1 : 
                        if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                          rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                          ends[3]=2;
                          ;//sysj\controller.sysj line: 43, column: 4
                          System.out.println("Request received");//sysj\controller.sysj line: 44, column: 4
                          S26=1;
                          active[3]=1;
                          ends[3]=1;
                          break RUN;
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          break RUN;
                        }
                      
                    }
                  }
                  break;
                
                case 1 : 
                  S10=1;
                  S10=0;
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 43, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                    S10=1;
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                  else {
                    S5=0;
                    if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                      rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 43, column: 4
                      S5=1;
                      if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                        rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                        ends[3]=2;
                        ;//sysj\controller.sysj line: 43, column: 4
                        System.out.println("Request received");//sysj\controller.sysj line: 44, column: 4
                        S26=1;
                        active[3]=1;
                        ends[3]=1;
                        break RUN;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        break RUN;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                  }
                
              }
              break;
            
            case 1 : 
              if(enable.getprestatus()){//sysj\controller.sysj line: 45, column: 10
                S26=2;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 47, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 46, column: 10
                System.out.println("Aborted");//sysj\controller.sysj line: 49, column: 4
                S26=3;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 47, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 3 : 
              if(!enable.getprestatus()){//sysj\controller.sysj line: 50, column: 10
                S26=0;
                S10=0;
                if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 43, column: 4
                  rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                  S10=1;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                else {
                  S5=0;
                  if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                    rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 43, column: 4
                    S5=1;
                    if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 43, column: 4
                      rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 43, column: 4
                      ends[3]=2;
                      ;//sysj\controller.sysj line: 43, column: 4
                      System.out.println("Request received");//sysj\controller.sysj line: 44, column: 4
                      S26=1;
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
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
    while(active[3] != 0){
      int index = 3;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        if(!df){
          rotaryTableRequest_in.gethook();
          rotaryTableStatus_o.gethook();
          enable.gethook();
          tableAlignedWithSensorC.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = tableAlignedWithSensorC.getStatus() ? tableAlignedWithSensorC.setprepresent() : tableAlignedWithSensorC.setpreclear();
      tableAlignedWithSensorC.setpreval(tableAlignedWithSensorC.getValue());
      tableAlignedWithSensorC.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      rotaryTableRequest_in.sethook();
      rotaryTableStatus_o.sethook();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        rotaryTableRequest_in.gethook();
        rotaryTableStatus_o.gethook();
        enable.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
