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
  private int S707 = 1;
  private int S506 = 1;
  private int S490 = 1;
  private int S485 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S707){
        case 0 : 
          S707=0;
          break RUN;
        
        case 1 : 
          S707=2;
          S707=2;
          System.out.println("Rotary Table started");//sysj\controller.sysj line: 61, column: 5
          S506=0;
          S490=0;
          if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 65, column: 4
            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
            S490=1;
            active[7]=1;
            ends[7]=1;
            break RUN;
          }
          else {
            S485=0;
            if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
              rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 65, column: 4
              S485=1;
              if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                ends[7]=2;
                ;//sysj\controller.sysj line: 65, column: 4
                System.out.println("Request received");//sysj\controller.sysj line: 66, column: 4
                S506=1;
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
              else {
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
            }
            else {
              active[7]=1;
              ends[7]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S506){
            case 0 : 
              switch(S490){
                case 0 : 
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 65, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                    S490=1;
                    active[7]=1;
                    ends[7]=1;
                    break RUN;
                  }
                  else {
                    switch(S485){
                      case 0 : 
                        if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                          rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 65, column: 4
                          S485=1;
                          if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                            rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                            ends[7]=2;
                            ;//sysj\controller.sysj line: 65, column: 4
                            System.out.println("Request received");//sysj\controller.sysj line: 66, column: 4
                            S506=1;
                            active[7]=1;
                            ends[7]=1;
                            break RUN;
                          }
                          else {
                            active[7]=1;
                            ends[7]=1;
                            break RUN;
                          }
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          break RUN;
                        }
                      
                      case 1 : 
                        if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                          rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                          ends[7]=2;
                          ;//sysj\controller.sysj line: 65, column: 4
                          System.out.println("Request received");//sysj\controller.sysj line: 66, column: 4
                          S506=1;
                          active[7]=1;
                          ends[7]=1;
                          break RUN;
                        }
                        else {
                          active[7]=1;
                          ends[7]=1;
                          break RUN;
                        }
                      
                    }
                  }
                  break;
                
                case 1 : 
                  S490=1;
                  S490=0;
                  if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 65, column: 4
                    rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                    S490=1;
                    active[7]=1;
                    ends[7]=1;
                    break RUN;
                  }
                  else {
                    S485=0;
                    if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                      rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 65, column: 4
                      S485=1;
                      if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                        rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                        ends[7]=2;
                        ;//sysj\controller.sysj line: 65, column: 4
                        System.out.println("Request received");//sysj\controller.sysj line: 66, column: 4
                        S506=1;
                        active[7]=1;
                        ends[7]=1;
                        break RUN;
                      }
                      else {
                        active[7]=1;
                        ends[7]=1;
                        break RUN;
                      }
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                  }
                
              }
              break;
            
            case 1 : 
              if(enable.getprestatus()){//sysj\controller.sysj line: 67, column: 10
                S506=2;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 69, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
              else {
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
            
            case 2 : 
              if(tableAlignedWithSensorC.getprestatus()){//sysj\controller.sysj line: 68, column: 10
                System.out.println("Aborted");//sysj\controller.sysj line: 71, column: 4
                S506=3;
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 69, column: 5
                currsigs.addElement(rotaryTableTrigger);
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
            
            case 3 : 
              if(!enable.getprestatus()){//sysj\controller.sysj line: 72, column: 10
                S506=0;
                S490=0;
                if(!rotaryTableRequest_in.isPartnerPresent() || rotaryTableRequest_in.isPartnerPreempted()){//sysj\controller.sysj line: 65, column: 4
                  rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                  S490=1;
                  active[7]=1;
                  ends[7]=1;
                  break RUN;
                }
                else {
                  S485=0;
                  if(!rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                    rotaryTableRequest_in.setACK(true);//sysj\controller.sysj line: 65, column: 4
                    S485=1;
                    if(rotaryTableRequest_in.isREQ()){//sysj\controller.sysj line: 65, column: 4
                      rotaryTableRequest_in.setACK(false);//sysj\controller.sysj line: 65, column: 4
                      ends[7]=2;
                      ;//sysj\controller.sysj line: 65, column: 4
                      System.out.println("Request received");//sysj\controller.sysj line: 66, column: 4
                      S506=1;
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                    else {
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                  }
                  else {
                    active[7]=1;
                    ends[7]=1;
                    break RUN;
                  }
                }
              }
              else {
                active[7]=1;
                ends[7]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[7] != 0){
      int index = 7;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
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
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
      else{
        rotaryTableRequest_in.gethook();
        rotaryTableStatus_o.gethook();
        enable.gethook();
        tableAlignedWithSensorC.gethook();
      }
      runFinisher();
      if(active[7] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
