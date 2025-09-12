import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.BottleTwin;//sysj\Orchestrator.sysj line: 1, column: 1

public class Orchestrator extends ClockDomain{
  public Orchestrator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal newBottleTwin = new Signal("newBottleTwin", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal conveyorMoved = new Signal("conveyorMoved", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal moveConveyor = new Signal("moveConveyor", Signal.OUTPUT);
  public Signal bottlePos0 = new Signal("bottlePos0", Signal.OUTPUT);
  public Signal bottlePos1 = new Signal("bottlePos1", Signal.OUTPUT);
  public Signal bottlePos2 = new Signal("bottlePos2", Signal.OUTPUT);
  public Signal bottlePos3 = new Signal("bottlePos3", Signal.OUTPUT);
  public Signal bottlePos4 = new Signal("bottlePos4", Signal.OUTPUT);
  public Signal bottlePos5 = new Signal("bottlePos5", Signal.OUTPUT);
  public Signal bottlePos6 = new Signal("bottlePos6", Signal.OUTPUT);
  public Signal bottlePos7 = new Signal("bottlePos7", Signal.OUTPUT);
  public Signal bottlePos8 = new Signal("bottlePos8", Signal.OUTPUT);
  private Signal posZero_1;
  private Signal posOne_1;
  private Signal posTwo_1;
  private Signal posThree_1;
  private Signal posFour_1;
  private Signal posFive_1;
  private Signal posSix_1;
  private Signal posSeven_1;
  private Signal posEight_1;
  private Signal posZeroLeft_1;
  private Signal posOneLeft_1;
  private Signal posTwoLeft_1;
  private Signal posThreeLeft_1;
  private Signal posFourLeft_1;
  private Signal posFiveLeft_1;
  private Signal posSixLeft_1;
  private Signal posSevenLeft_1;
  private Signal posEightLeft_1;
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 21, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 23, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 24, column: 5
  private BottleTwin b_thread_3;//sysj\Orchestrator.sysj line: 47, column: 4
  private BottleTwin b_thread_4;//sysj\Orchestrator.sysj line: 75, column: 4
  private BottleTwin b_thread_5;//sysj\Orchestrator.sysj line: 91, column: 4
  private BottleTwin b_thread_6;//sysj\Orchestrator.sysj line: 104, column: 4
  private int S619 = 1;
  private int S524 = 1;
  private int S449 = 1;
  private int S450 = 1;
  private int S557 = 1;
  private int S556 = 1;
  private int S526 = 1;
  private int S571 = 1;
  private int S559 = 1;
  private int S603 = 1;
  private int S573 = 1;
  private int S617 = 1;
  private int S605 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread631(int [] tdone, int [] ends){
        switch(S617){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S605){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 103, column: 10
              b_thread_6 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 104, column: 4
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 110, column: 4
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 110, column: 4
              System.out.println("Emitted bottlePos2");
              S605=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            if(posTwoLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 111, column: 10
              S605=0;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread630(int [] tdone, int [] ends){
        switch(S603){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S573){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 90, column: 10
              b_thread_5 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 91, column: 4
              S573=1;
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 93, column: 5
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 93, column: 5
              System.out.println("Emitted bottlePos1");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(posOneLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 92, column: 10
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 95, column: 4
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(null);//sysj\Orchestrator.sysj line: 95, column: 4
              System.out.println("Emitted bottlePos1");
              S573=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 93, column: 5
              currsigs.addElement(bottlePos1);
              bottlePos1.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 93, column: 5
              System.out.println("Emitted bottlePos1");
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread629(int [] tdone, int [] ends){
        switch(S571){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S559){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 74, column: 10
              b_thread_4 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 75, column: 4
              bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 79, column: 4
              currsigs.addElement(bottlePos0);
              bottlePos0.setValue(b_thread_4);//sysj\Orchestrator.sysj line: 79, column: 4
              System.out.println("Emitted bottlePos0");
              S559=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(posZeroLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 80, column: 10
              S559=0;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread628(int [] tdone, int [] ends){
        switch(S557){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S556){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 45, column: 9
              S556=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 47, column: 4
              moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 48, column: 4
              currsigs.addElement(moveConveyor);
              System.out.println("Emitted moveConveyor");
              S526=0;
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
            switch(S526){
              case 0 : 
                if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
                  posTwo_1.setPresent();//sysj\Orchestrator.sysj line: 50, column: 4
                  currsigs.addElement(posTwo_1);
                  posTwo_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 50, column: 4
                  System.out.println("Emitted posTwo_1");
                  posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 51, column: 4
                  currsigs.addElement(posZeroLeft_1);
                  System.out.println("Emitted posZeroLeft_1");
                  S526=1;
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
                if(posOneLeft_1.getprestatus() && posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 52, column: 10
                  b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 47, column: 4
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 48, column: 4
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S526=0;
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
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread627(int [] tdone, int [] ends){
        switch(S524){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S449){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 18, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 19, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 21, column: 4
              S449=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 22, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 23, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 24, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 25, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                S450=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 16, column: 7
                S449=0;
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
          
          case 1 : 
            switch(S450){
              case 0 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 28, column: 14
                  posZero_1.setPresent();//sysj\Orchestrator.sysj line: 32, column: 5
                  currsigs.addElement(posZero_1);
                  posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 32, column: 5
                  System.out.println("Emitted posZero_1");
                  S450=1;
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
                if(posZeroLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 33, column: 11
                  S450=2;
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
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 36, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 16, column: 7
                  S449=0;
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
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread625(int [] tdone, int [] ends){
        S617=1;
    S605=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread624(int [] tdone, int [] ends){
        S603=1;
    S573=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread623(int [] tdone, int [] ends){
        S571=1;
    S559=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread622(int [] tdone, int [] ends){
        S557=1;
    S556=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread621(int [] tdone, int [] ends){
        S524=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 16, column: 7
    S449=0;
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
      switch(S619){
        case 0 : 
          S619=0;
          break RUN;
        
        case 1 : 
          S619=2;
          S619=2;
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          thread621(tdone,ends);
          thread622(tdone,ends);
          thread623(tdone,ends);
          thread624(tdone,ends);
          thread625(tdone,ends);
          int biggest626 = 0;
          if(ends[2]>=biggest626){
            biggest626=ends[2];
          }
          if(ends[3]>=biggest626){
            biggest626=ends[3];
          }
          if(ends[4]>=biggest626){
            biggest626=ends[4];
          }
          if(ends[5]>=biggest626){
            biggest626=ends[5];
          }
          if(ends[6]>=biggest626){
            biggest626=ends[6];
          }
          if(biggest626 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 11, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          thread627(tdone,ends);
          thread628(tdone,ends);
          thread629(tdone,ends);
          thread630(tdone,ends);
          thread631(tdone,ends);
          int biggest632 = 0;
          if(ends[2]>=biggest632){
            biggest632=ends[2];
          }
          if(ends[3]>=biggest632){
            biggest632=ends[3];
          }
          if(ends[4]>=biggest632){
            biggest632=ends[4];
          }
          if(ends[5]>=biggest632){
            biggest632=ends[5];
          }
          if(ends[6]>=biggest632){
            biggest632=ends[6];
          }
          if(biggest632 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest632 == 0){
            S619=0;
            active[1]=0;
            ends[1]=0;
            S619=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posZero_1 = new Signal();
    posOne_1 = new Signal();
    posTwo_1 = new Signal();
    posThree_1 = new Signal();
    posFour_1 = new Signal();
    posFive_1 = new Signal();
    posSix_1 = new Signal();
    posSeven_1 = new Signal();
    posEight_1 = new Signal();
    posZeroLeft_1 = new Signal();
    posOneLeft_1 = new Signal();
    posTwoLeft_1 = new Signal();
    posThreeLeft_1 = new Signal();
    posFourLeft_1 = new Signal();
    posFiveLeft_1 = new Signal();
    posSixLeft_1 = new Signal();
    posSevenLeft_1 = new Signal();
    posEightLeft_1 = new Signal();
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
          newBottleTwin.gethook();
          request.gethook();
          conveyorMoved.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      conveyorMoved.setpreclear();
      recieveTwin.setpreclear();
      moveConveyor.setpreclear();
      bottlePos0.setpreclear();
      bottlePos1.setpreclear();
      bottlePos2.setpreclear();
      bottlePos3.setpreclear();
      bottlePos4.setpreclear();
      bottlePos5.setpreclear();
      bottlePos6.setpreclear();
      bottlePos7.setpreclear();
      bottlePos8.setpreclear();
      posZero_1.setpreclear();
      posOne_1.setpreclear();
      posTwo_1.setpreclear();
      posThree_1.setpreclear();
      posFour_1.setpreclear();
      posFive_1.setpreclear();
      posSix_1.setpreclear();
      posSeven_1.setpreclear();
      posEight_1.setpreclear();
      posZeroLeft_1.setpreclear();
      posOneLeft_1.setpreclear();
      posTwoLeft_1.setpreclear();
      posThreeLeft_1.setpreclear();
      posFourLeft_1.setpreclear();
      posFiveLeft_1.setpreclear();
      posSixLeft_1.setpreclear();
      posSevenLeft_1.setpreclear();
      posEightLeft_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = newBottleTwin.getStatus() ? newBottleTwin.setprepresent() : newBottleTwin.setpreclear();
      newBottleTwin.setpreval(newBottleTwin.getValue());
      newBottleTwin.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = conveyorMoved.getStatus() ? conveyorMoved.setprepresent() : conveyorMoved.setpreclear();
      conveyorMoved.setpreval(conveyorMoved.getValue());
      conveyorMoved.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      moveConveyor.sethook();
      moveConveyor.setClear();
      bottlePos0.sethook();
      bottlePos0.setClear();
      bottlePos1.sethook();
      bottlePos1.setClear();
      bottlePos2.sethook();
      bottlePos2.setClear();
      bottlePos3.sethook();
      bottlePos3.setClear();
      bottlePos4.sethook();
      bottlePos4.setClear();
      bottlePos5.sethook();
      bottlePos5.setClear();
      bottlePos6.sethook();
      bottlePos6.setClear();
      bottlePos7.sethook();
      bottlePos7.setClear();
      bottlePos8.sethook();
      bottlePos8.setClear();
      posZero_1.setClear();
      posOne_1.setClear();
      posTwo_1.setClear();
      posThree_1.setClear();
      posFour_1.setClear();
      posFive_1.setClear();
      posSix_1.setClear();
      posSeven_1.setClear();
      posEight_1.setClear();
      posZeroLeft_1.setClear();
      posOneLeft_1.setClear();
      posTwoLeft_1.setClear();
      posThreeLeft_1.setClear();
      posFourLeft_1.setClear();
      posFiveLeft_1.setClear();
      posSixLeft_1.setClear();
      posSevenLeft_1.setClear();
      posEightLeft_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        newBottleTwin.gethook();
        request.gethook();
        conveyorMoved.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
