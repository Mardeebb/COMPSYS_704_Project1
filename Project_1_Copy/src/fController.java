import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\fillerController.sysj line: 1, column: 1

public class fController extends ClockDomain{
  public fController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal startFilling = new Signal("startFilling", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal filled = new Signal("filled", Signal.OUTPUT);
  public Signal liquidMessage = new Signal("liquidMessage", Signal.OUTPUT);
  private Signal volume_1;
  private Signal liquidType_1;
  private Signal startFillingProcess_1;
  private Signal fillingProcessFinish_1;
  private BottleTwin b_thread_2;//sysj\fillerController.sysj line: 21, column: 4
  private int[] recipe_thread_2;//sysj\fillerController.sysj line: 23, column: 5
  private int i_thread_2;//sysj\fillerController.sysj line: 25, column: 9
  private int amount_thread_2;//sysj\fillerController.sysj line: 26, column: 6
  private int v_thread_3;//sysj\fillerController.sysj line: 64, column: 3
  private int l_thread_3;//sysj\fillerController.sysj line: 65, column: 3
  private String message_thread_3;//sysj\fillerController.sysj line: 67, column: 6
  private int S3713 = 1;
  private int S2841 = 1;
  private int S2267 = 1;
  private int S2268 = 1;
  private int S2281 = 1;
  private int S2274 = 1;
  private int S2269 = 1;
  private int S2987 = 1;
  private int S2845 = 1;
  private int S2850 = 1;
  private int S2855 = 1;
  private int S2872 = 1;
  private int S2877 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread3730(int [] tdone, int [] ends){
        switch(S2877){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 88, column: 8
        currsigs.addElement(valveInletOnOff);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread3729(int [] tdone, int [] ends){
        switch(S2872){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 84, column: 12
        currsigs.addElement(dosUnitValveExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread3727(int [] tdone, int [] ends){
        S2877=1;
    valveInletOnOff.setPresent();//sysj\fillerController.sysj line: 88, column: 8
    currsigs.addElement(valveInletOnOff);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3726(int [] tdone, int [] ends){
        S2872=1;
    dosUnitValveExtend.setPresent();//sysj\fillerController.sysj line: 84, column: 12
    currsigs.addElement(dosUnitValveExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread3724(int [] tdone, int [] ends){
        switch(S2855){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 76, column: 8
        currsigs.addElement(valveInjectorOnOff);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread3723(int [] tdone, int [] ends){
        switch(S2850){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 72, column: 12
        currsigs.addElement(dosUnitValveRetract);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread3721(int [] tdone, int [] ends){
        S2855=1;
    valveInjectorOnOff.setPresent();//sysj\fillerController.sysj line: 76, column: 8
    currsigs.addElement(valveInjectorOnOff);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3720(int [] tdone, int [] ends){
        S2850=1;
    dosUnitValveRetract.setPresent();//sysj\fillerController.sysj line: 72, column: 12
    currsigs.addElement(dosUnitValveRetract);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3719(int [] tdone, int [] ends){
        switch(S2987){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2845){
          case 0 : 
            if(startFillingProcess_1.getprestatus()){//sysj\fillerController.sysj line: 49, column: 12
              S2845=1;
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
            if(bottleAtPos2.getprestatus()){//sysj\fillerController.sysj line: 50, column: 12
              v_thread_3 = (int)(volume_1.getpreval() == null ? 0 : ((Integer)volume_1.getpreval()).intValue());//sysj\fillerController.sysj line: 64, column: 3
              l_thread_3 = (int)(liquidType_1.getpreval() == null ? 0 : ((Integer)liquidType_1.getpreval()).intValue());//sysj\fillerController.sysj line: 65, column: 3
              message_thread_3 = "Filling " + v_thread_3 + "ml of liquid type " + l_thread_3;//sysj\fillerController.sysj line: 67, column: 6
              liquidMessage.setPresent();//sysj\fillerController.sysj line: 68, column: 6
              currsigs.addElement(liquidMessage);
              liquidMessage.setValue(message_thread_3);//sysj\fillerController.sysj line: 68, column: 6
              S2845=2;
              thread3720(tdone,ends);
              thread3721(tdone,ends);
              int biggest3722 = 0;
              if(ends[4]>=biggest3722){
                biggest3722=ends[4];
              }
              if(ends[5]>=biggest3722){
                biggest3722=ends[5];
              }
              if(biggest3722 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj\fillerController.sysj line: 70, column: 12
              S2845=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread3723(tdone,ends);
              thread3724(tdone,ends);
              int biggest3725 = 0;
              if(ends[4]>=biggest3725){
                biggest3725=ends[4];
              }
              if(ends[5]>=biggest3725){
                biggest3725=ends[5];
              }
              if(biggest3725 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              //FINXME code
              if(biggest3725 == 0){
                S2845=3;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 3 : 
            S2845=3;
            S2845=4;
            thread3726(tdone,ends);
            thread3727(tdone,ends);
            int biggest3728 = 0;
            if(ends[6]>=biggest3728){
              biggest3728=ends[6];
            }
            if(ends[7]>=biggest3728){
              biggest3728=ends[7];
            }
            if(biggest3728 == 1){
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 4 : 
            if(dosUnitEvac.getprestatus()){//sysj\fillerController.sysj line: 82, column: 12
              S2845=5;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread3729(tdone,ends);
              thread3730(tdone,ends);
              int biggest3731 = 0;
              if(ends[6]>=biggest3731){
                biggest3731=ends[6];
              }
              if(ends[7]>=biggest3731){
                biggest3731=ends[7];
              }
              if(biggest3731 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              //FINXME code
              if(biggest3731 == 0){
                S2845=5;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 5 : 
            S2845=5;
            S2845=6;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 6 : 
            S2845=6;
            liquidMessage.setPresent();//sysj\fillerController.sysj line: 93, column: 6
            currsigs.addElement(liquidMessage);
            liquidMessage.setValue("");//sysj\fillerController.sysj line: 93, column: 6
            fillingProcessFinish_1.setPresent();//sysj\fillerController.sysj line: 94, column: 6
            currsigs.addElement(fillingProcessFinish_1);
            S2845=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3718(int [] tdone, int [] ends){
        switch(S2841){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2267){
          case 0 : 
            if(startFilling.getprestatus()){//sysj\fillerController.sysj line: 19, column: 13
              S2267=1;
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
            if(bottleAtPos2.getprestatus()){//sysj\fillerController.sysj line: 20, column: 13
              b_thread_2 = (BottleTwin)(bottleAtPos2.getpreval() == null ? null : ((BottleTwin)bottleAtPos2.getpreval()));//sysj\fillerController.sysj line: 21, column: 4
              S2267=2;
              if(b_thread_2 != null){//sysj\fillerController.sysj line: 22, column: 7
                recipe_thread_2 = new int[5];//sysj\fillerController.sysj line: 23, column: 5
                recipe_thread_2 = b_thread_2.recipe;//sysj\fillerController.sysj line: 24, column: 5
                i_thread_2 = 0;//sysj\fillerController.sysj line: 25, column: 9
                S2268=0;
                if(i_thread_2 < 5){//sysj\fillerController.sysj line: 25, column: 20
                  amount_thread_2 = recipe_thread_2[i_thread_2];//sysj\fillerController.sysj line: 26, column: 6
                  S2281=0;
                  if(amount_thread_2 > 0){//sysj\fillerController.sysj line: 27, column: 9
                    S2274=0;
                    volume_1.setPresent();//sysj\fillerController.sysj line: 28, column: 7
                    currsigs.addElement(volume_1);
                    volume_1.setValue(amount_thread_2);//sysj\fillerController.sysj line: 28, column: 7
                    liquidType_1.setPresent();//sysj\fillerController.sysj line: 29, column: 7
                    currsigs.addElement(liquidType_1);
                    liquidType_1.setValue(i_thread_2);//sysj\fillerController.sysj line: 29, column: 7
                    startFillingProcess_1.setPresent();//sysj\fillerController.sysj line: 30, column: 7
                    currsigs.addElement(startFillingProcess_1);
                    S2269=0;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S2274=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  ends[2]=2;
                  ;//sysj\fillerController.sysj line: 22, column: 18
                  S2268=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                filled.setPresent();//sysj\fillerController.sysj line: 41, column: 7
                currsigs.addElement(filled);
                S2267=3;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            switch(S2268){
              case 0 : 
                switch(S2281){
                  case 0 : 
                    switch(S2274){
                      case 0 : 
                        switch(S2269){
                          case 0 : 
                            if(fillingProcessFinish_1.getprestatus()){//sysj\fillerController.sysj line: 31, column: 13
                              S2269=1;
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
                            if(!fillingProcessFinish_1.getprestatus()){//sysj\fillerController.sysj line: 32, column: 13
                              S2269=2;
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
                            S2269=2;
                            S2281=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                            break;
                          
                        }
                        break;
                      
                      case 1 : 
                        S2274=1;
                        S2281=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                        break;
                      
                    }
                    break;
                  
                  case 1 : 
                    S2281=1;
                    i_thread_2 = i_thread_2 + 1;//sysj\fillerController.sysj line: 25, column: 27
                    if(i_thread_2 < 5){//sysj\fillerController.sysj line: 25, column: 20
                      amount_thread_2 = recipe_thread_2[i_thread_2];//sysj\fillerController.sysj line: 26, column: 6
                      S2281=0;
                      if(amount_thread_2 > 0){//sysj\fillerController.sysj line: 27, column: 9
                        S2274=0;
                        volume_1.setPresent();//sysj\fillerController.sysj line: 28, column: 7
                        currsigs.addElement(volume_1);
                        volume_1.setValue(amount_thread_2);//sysj\fillerController.sysj line: 28, column: 7
                        liquidType_1.setPresent();//sysj\fillerController.sysj line: 29, column: 7
                        currsigs.addElement(liquidType_1);
                        liquidType_1.setValue(i_thread_2);//sysj\fillerController.sysj line: 29, column: 7
                        startFillingProcess_1.setPresent();//sysj\fillerController.sysj line: 30, column: 7
                        currsigs.addElement(startFillingProcess_1);
                        S2269=0;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S2274=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      ends[2]=2;
                      ;//sysj\fillerController.sysj line: 22, column: 18
                      S2268=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                S2268=1;
                filled.setPresent();//sysj\fillerController.sysj line: 41, column: 7
                currsigs.addElement(filled);
                S2267=3;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
            }
            break;
          
          case 3 : 
            S2267=3;
            S2267=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3716(int [] tdone, int [] ends){
        S2987=1;
    S2845=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3715(int [] tdone, int [] ends){
        S2841=1;
    S2267=0;
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
      switch(S3713){
        case 0 : 
          S3713=0;
          break RUN;
        
        case 1 : 
          S3713=2;
          S3713=2;
          volume_1.setClear();//sysj\fillerController.sysj line: 12, column: 2
          liquidType_1.setClear();//sysj\fillerController.sysj line: 13, column: 2
          startFillingProcess_1.setClear();//sysj\fillerController.sysj line: 14, column: 2
          fillingProcessFinish_1.setClear();//sysj\fillerController.sysj line: 14, column: 2
          System.out.println("filler Controller started");//sysj\fillerController.sysj line: 16, column: 2
          thread3715(tdone,ends);
          thread3716(tdone,ends);
          int biggest3717 = 0;
          if(ends[2]>=biggest3717){
            biggest3717=ends[2];
          }
          if(ends[3]>=biggest3717){
            biggest3717=ends[3];
          }
          if(biggest3717 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          volume_1.setClear();//sysj\fillerController.sysj line: 12, column: 2
          liquidType_1.setClear();//sysj\fillerController.sysj line: 13, column: 2
          startFillingProcess_1.setClear();//sysj\fillerController.sysj line: 14, column: 2
          fillingProcessFinish_1.setClear();//sysj\fillerController.sysj line: 14, column: 2
          thread3718(tdone,ends);
          thread3719(tdone,ends);
          int biggest3732 = 0;
          if(ends[2]>=biggest3732){
            biggest3732=ends[2];
          }
          if(ends[3]>=biggest3732){
            biggest3732=ends[3];
          }
          if(biggest3732 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3732 == 0){
            S3713=0;
            active[1]=0;
            ends[1]=0;
            S3713=0;
            break RUN;
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
    volume_1 = new Signal();
    liquidType_1 = new Signal();
    startFillingProcess_1 = new Signal();
    fillingProcessFinish_1 = new Signal();
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
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          startFilling.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      startFilling.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      filled.setpreclear();
      liquidMessage.setpreclear();
      volume_1.setpreclear();
      liquidType_1.setpreclear();
      startFillingProcess_1.setpreclear();
      fillingProcessFinish_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = startFilling.getStatus() ? startFilling.setprepresent() : startFilling.setpreclear();
      startFilling.setpreval(startFilling.getValue());
      startFilling.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      filled.sethook();
      filled.setClear();
      liquidMessage.sethook();
      liquidMessage.setClear();
      volume_1.setClear();
      liquidType_1.setClear();
      startFillingProcess_1.setClear();
      fillingProcessFinish_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        startFilling.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
