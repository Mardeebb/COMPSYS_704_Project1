import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\plant.sysj line: 2, column: 1

public class rPlant extends ClockDomain{
  public rPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal bottleIn = new Signal("bottleIn", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  public Signal rotContent = new Signal("rotContent", Signal.OUTPUT);
  private Signal posOne_2;
  private Signal posFive_2;
  private Signal turn_2;
  private int[] packedArray_thread_3;//sysj\plant.sysj line: 151, column: 3
  private int pos_thread_3;//sysj\plant.sysj line: 152, column: 3
  private int pos1_thread_3;//sysj\plant.sysj line: 164, column: 5
  private int pos5_thread_3;//sysj\plant.sysj line: 165, column: 5
  private int[] newPackedArray_thread_3;//sysj\plant.sysj line: 169, column: 5
  private int S255 = 1;
  private int S236 = 1;
  private int S183 = 1;
  private int S253 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread560(int [] tdone, int [] ends){
        switch(S253){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_2.getpreval() == null ? 0 : ((Integer)posOne_2.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 185, column: 7
          capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 186, column: 5
          currsigs.addElement(capOnBottleAtPos1);
          System.out.println("Emitted capOnBottleAtPos1");
          if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 188, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 189, column: 5
            currsigs.addElement(bottleAtPos5);
            System.out.println("Emitted bottleAtPos5");
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 188, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 189, column: 5
            currsigs.addElement(bottleAtPos5);
            System.out.println("Emitted bottleAtPos5");
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        break;
      
    }
  }

  public void thread559(int [] tdone, int [] ends){
        switch(S236){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 161, column: 10
          S183=0;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          switch(S183){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 162, column: 11
                pos1_thread_3 = packedArray_thread_3[0];//sysj\plant.sysj line: 164, column: 5
                pos5_thread_3 = packedArray_thread_3[4];//sysj\plant.sysj line: 165, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 166, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_3);//sysj\plant.sysj line: 166, column: 5
                System.out.println("Emitted rotTurn");
                posOne_2.setPresent();//sysj\plant.sysj line: 167, column: 5
                currsigs.addElement(posOne_2);
                posOne_2.setValue(pos1_thread_3);//sysj\plant.sysj line: 167, column: 5
                System.out.println("Emitted posOne_2");
                posFive_2.setPresent();//sysj\plant.sysj line: 168, column: 5
                currsigs.addElement(posFive_2);
                posFive_2.setValue(pos5_thread_3);//sysj\plant.sysj line: 168, column: 5
                System.out.println("Emitted posFive_2");
                newPackedArray_thread_3 = new int[6];//sysj\plant.sysj line: 169, column: 5
                newPackedArray_thread_3[0] = packedArray_thread_3[5];//sysj\plant.sysj line: 170, column: 5
                for(int i_thread_3 = 1; i_thread_3 < 6; i_thread_3 = i_thread_3 + 1) {//sysj\plant.sysj line: 172, column: 31
                  newPackedArray_thread_3[i_thread_3] = packedArray_thread_3[i_thread_3 - 1];//sysj\plant.sysj line: 173, column: 6
                }
                packedArray_thread_3 = newPackedArray_thread_3;//sysj\plant.sysj line: 175, column: 5
                S183=1;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 176, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
                System.out.println("Emitted tableAlignedWithSensorC");
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
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 176, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              System.out.println("Emitted tableAlignedWithSensorC");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread557(int [] tdone, int [] ends){
        S253=1;
    if((Integer)(posOne_2.getpreval() == null ? 0 : ((Integer)posOne_2.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 185, column: 7
      capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 186, column: 5
      currsigs.addElement(capOnBottleAtPos1);
      System.out.println("Emitted capOnBottleAtPos1");
      if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 188, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 189, column: 5
        currsigs.addElement(bottleAtPos5);
        System.out.println("Emitted bottleAtPos5");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      if((Integer)(posFive_2.getpreval() == null ? 0 : ((Integer)posFive_2.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 188, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 189, column: 5
        currsigs.addElement(bottleAtPos5);
        System.out.println("Emitted bottleAtPos5");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
  }

  public void thread556(int [] tdone, int [] ends){
        S236=1;
    packedArray_thread_3 = new int[6];//sysj\plant.sysj line: 151, column: 3
    pos_thread_3 = 0;//sysj\plant.sysj line: 152, column: 3
    for(int i_thread_3 = 0; i_thread_3 < 6; i_thread_3 = i_thread_3 + 1) {//sysj\plant.sysj line: 153, column: 29
      packedArray_thread_3[i_thread_3] = 0;//sysj\plant.sysj line: 154, column: 7
    }
    packedArray_thread_3[0] = 5;//sysj\plant.sysj line: 157, column: 6
    packedArray_thread_3[3] = 1;//sysj\plant.sysj line: 158, column: 6
    S183=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S255){
        case 0 : 
          S255=0;
          break RUN;
        
        case 1 : 
          S255=2;
          S255=2;
          posOne_2.setClear();//sysj\plant.sysj line: 149, column: 2
          posFive_2.setClear();//sysj\plant.sysj line: 149, column: 2
          turn_2.setClear();//sysj\plant.sysj line: 149, column: 2
          thread556(tdone,ends);
          thread557(tdone,ends);
          int biggest558 = 0;
          if(ends[3]>=biggest558){
            biggest558=ends[3];
          }
          if(ends[4]>=biggest558){
            biggest558=ends[4];
          }
          if(biggest558 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_2.setClear();//sysj\plant.sysj line: 149, column: 2
          posFive_2.setClear();//sysj\plant.sysj line: 149, column: 2
          turn_2.setClear();//sysj\plant.sysj line: 149, column: 2
          thread559(tdone,ends);
          thread560(tdone,ends);
          int biggest561 = 0;
          if(ends[3]>=biggest561){
            biggest561=ends[3];
          }
          if(ends[4]>=biggest561){
            biggest561=ends[4];
          }
          if(biggest561 == 1){
            active[2]=1;
            ends[2]=1;
            break RUN;
          }
          //FINXME code
          if(biggest561 == 0){
            S255=0;
            active[2]=0;
            ends[2]=0;
            S255=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_2 = new Signal();
    posFive_2 = new Signal();
    turn_2 = new Signal();
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
          rotaryTableTrigger.gethook();
          bottleIn.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      bottleIn.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurn.setpreclear();
      rotContent.setpreclear();
      posOne_2.setpreclear();
      posFive_2.setpreclear();
      turn_2.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      dummyint = bottleIn.getStatus() ? bottleIn.setprepresent() : bottleIn.setpreclear();
      bottleIn.setpreval(bottleIn.getValue());
      bottleIn.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      tableAlignedWithSensorC.sethook();
      tableAlignedWithSensorC.setClear();
      rotTurn.sethook();
      rotTurn.setClear();
      rotContent.sethook();
      rotContent.setClear();
      posOne_2.setClear();
      posFive_2.setClear();
      turn_2.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        rotaryTableTrigger.gethook();
        bottleIn.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
