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
  private int S213 = 1;
  private int S28 = 1;
  private int S8 = 1;
  private int S3 = 1;
  
  private int[] ends = new int[3];
  private int[] tdone = new int[3];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S213){
        case 0 : 
          S213=0;
          break RUN;
        
        case 1 : 
          S213=2;
          S213=2;
          System.out.println("Rotary Table started");//sysj\controller.sysj line: 24, column: 5
          S28=0;
          S8=0;
          if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 28, column: 4
            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
            S8=1;
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          else {
            S3=0;
            if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
              rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 28, column: 4
              S3=1;
              if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                ends[2]=2;
                ;//sysj\controller.sysj line: 28, column: 4
                S28=1;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S28){
            case 0 : 
              switch(S8){
                case 0 : 
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 28, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                    S8=1;
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                  else {
                    switch(S3){
                      case 0 : 
                        if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                          rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 28, column: 4
                          S3=1;
                          if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                            ends[2]=2;
                            ;//sysj\controller.sysj line: 28, column: 4
                            S28=1;
                            active[2]=1;
                            ends[2]=1;
                            break RUN;
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          break RUN;
                        }
                      
                      case 1 : 
                        if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                          rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                          ends[2]=2;
                          ;//sysj\controller.sysj line: 28, column: 4
                          S28=1;
                          active[2]=1;
                          ends[2]=1;
                          break RUN;
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          break RUN;
                        }
                      
                    }
                  }
                  break;
                
                case 1 : 
                  S8=1;
                  S8=0;
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 28, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                    S8=1;
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                  else {
                    S3=0;
                    if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                      rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 28, column: 4
                      S3=1;
                      if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                        rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                        ends[2]=2;
                        ;//sysj\controller.sysj line: 28, column: 4
                        S28=1;
                        active[2]=1;
                        ends[2]=1;
                        break RUN;
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        break RUN;
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      break RUN;
                    }
                  }
                
              }
              break;
            
            case 1 : 
              if(enable.getprestatus()){//sysj\controller.sysj line: 30, column: 10
                S28=2;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 32, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 2 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 31, column: 10
                System.out.println("Aborted");//sysj\controller.sysj line: 34, column: 4
                S28=3;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 32, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 3 : 
              S28=3;
              S28=0;
              S8=0;
              if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 28, column: 4
                rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                S8=1;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                S3=0;
                if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                  rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 28, column: 4
                  S3=1;
                  if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 28, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 28, column: 4
                    ends[2]=2;
                    ;//sysj\controller.sysj line: 28, column: 4
                    S28=1;
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1};
    char [] paused1 = {0, 0, 0};
    char [] suspended1 = {0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
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
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        rotaryTableRequest_in.gethook();
        rotaryTableStatus_o.gethook();
        enable.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
