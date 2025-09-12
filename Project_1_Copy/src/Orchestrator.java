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
  public Signal rotTableTurned = new Signal("rotTableTurned", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal moveConveyor = new Signal("moveConveyor", Signal.OUTPUT);
  public Signal turnRotTable = new Signal("turnRotTable", Signal.OUTPUT);
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
  private BottleTwin b1_thread_4;//sysj\Orchestrator.sysj line: 67, column: 4
  private BottleTwin b2_thread_4;//sysj\Orchestrator.sysj line: 68, column: 4
  private BottleTwin b3_thread_4;//sysj\Orchestrator.sysj line: 69, column: 4
  private BottleTwin b4_thread_4;//sysj\Orchestrator.sysj line: 70, column: 4
  private BottleTwin b5_thread_4;//sysj\Orchestrator.sysj line: 71, column: 4
  private BottleTwin b6_thread_4;//sysj\Orchestrator.sysj line: 72, column: 4
  private BottleTwin b_thread_5;//sysj\Orchestrator.sysj line: 103, column: 4
  private BottleTwin b_thread_6;//sysj\Orchestrator.sysj line: 119, column: 4
  private BottleTwin b_thread_7;//sysj\Orchestrator.sysj line: 132, column: 4
  private int S737 = 1;
  private int S652 = 1;
  private int S577 = 1;
  private int S578 = 1;
  private int S685 = 1;
  private int S684 = 1;
  private int S654 = 1;
  private int S705 = 1;
  private int S689 = 1;
  private int S713 = 1;
  private int S721 = 1;
  private int S735 = 1;
  private int S723 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread751(int [] tdone, int [] ends){
        switch(S735){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S723){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 131, column: 10
              b_thread_7 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 132, column: 4
              bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 138, column: 4
              currsigs.addElement(bottlePos2);
              bottlePos2.setValue(b_thread_7);//sysj\Orchestrator.sysj line: 138, column: 4
              System.out.println("Emitted bottlePos2");
              S723=1;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(posTwoLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 139, column: 10
              S723=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread750(int [] tdone, int [] ends){
        switch(S721){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 118, column: 10
          b_thread_6 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 119, column: 4
          bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 123, column: 4
          currsigs.addElement(bottlePos1);
          bottlePos1.setValue(b_thread_6);//sysj\Orchestrator.sysj line: 123, column: 4
          System.out.println("Emitted bottlePos1");
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
  }

  public void thread749(int [] tdone, int [] ends){
        switch(S713){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 10
          b_thread_5 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 103, column: 4
          bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 107, column: 4
          currsigs.addElement(bottlePos0);
          bottlePos0.setValue(b_thread_5);//sysj\Orchestrator.sysj line: 107, column: 4
          System.out.println("Emitted bottlePos0");
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
      
    }
  }

  public void thread748(int [] tdone, int [] ends){
        switch(S705){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S689){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 61, column: 10
              S689=1;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 62, column: 10
              turnRotTable.setPresent();//sysj\Orchestrator.sysj line: 64, column: 4
              currsigs.addElement(turnRotTable);
              System.out.println("Emitted turnRotTable");
              S689=2;
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
          
          case 2 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 65, column: 10
              b1_thread_4 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 67, column: 4
              b2_thread_4 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 68, column: 4
              b3_thread_4 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 69, column: 4
              b4_thread_4 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 70, column: 4
              b5_thread_4 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 71, column: 4
              b6_thread_4 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 72, column: 4
              posOne_1.setPresent();//sysj\Orchestrator.sysj line: 74, column: 4
              currsigs.addElement(posOne_1);
              posOne_1.setValue(b6_thread_4);//sysj\Orchestrator.sysj line: 74, column: 4
              System.out.println("Emitted posOne_1");
              posTwo_1.setPresent();//sysj\Orchestrator.sysj line: 75, column: 4
              currsigs.addElement(posTwo_1);
              posTwo_1.setValue(b1_thread_4);//sysj\Orchestrator.sysj line: 75, column: 4
              System.out.println("Emitted posTwo_1");
              posThree_1.setPresent();//sysj\Orchestrator.sysj line: 76, column: 4
              currsigs.addElement(posThree_1);
              posThree_1.setValue(b2_thread_4);//sysj\Orchestrator.sysj line: 76, column: 4
              System.out.println("Emitted posThree_1");
              posFour_1.setPresent();//sysj\Orchestrator.sysj line: 77, column: 4
              currsigs.addElement(posFour_1);
              posFour_1.setValue(b3_thread_4);//sysj\Orchestrator.sysj line: 77, column: 4
              System.out.println("Emitted posFour_1");
              posFive_1.setPresent();//sysj\Orchestrator.sysj line: 78, column: 4
              currsigs.addElement(posFive_1);
              posFive_1.setValue(b4_thread_4);//sysj\Orchestrator.sysj line: 78, column: 4
              System.out.println("Emitted posFive_1");
              posSix_1.setPresent();//sysj\Orchestrator.sysj line: 79, column: 4
              currsigs.addElement(posSix_1);
              posSix_1.setValue(b5_thread_4);//sysj\Orchestrator.sysj line: 79, column: 4
              System.out.println("Emitted posSix_1");
              S689=3;
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
          
          case 3 : 
            S689=3;
            S689=0;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread747(int [] tdone, int [] ends){
        switch(S685){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S684){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 45, column: 9
              S684=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 47, column: 4
              moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 48, column: 4
              currsigs.addElement(moveConveyor);
              System.out.println("Emitted moveConveyor");
              S654=0;
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
            switch(S654){
              case 0 : 
                if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 49, column: 10
                  posOne_1.setPresent();//sysj\Orchestrator.sysj line: 50, column: 4
                  currsigs.addElement(posOne_1);
                  posOne_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 50, column: 4
                  System.out.println("Emitted posOne_1");
                  posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 51, column: 4
                  currsigs.addElement(posZeroLeft_1);
                  System.out.println("Emitted posZeroLeft_1");
                  S654=1;
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
                if(rotTableTurned.getprestatus() || posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 52, column: 10
                  b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 47, column: 4
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 48, column: 4
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S654=0;
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

  public void thread746(int [] tdone, int [] ends){
        switch(S652){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S577){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 18, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 19, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 21, column: 4
              S577=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 22, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 23, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 24, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 25, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                S578=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 16, column: 7
                S577=0;
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
            switch(S578){
              case 0 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 28, column: 14
                  posZero_1.setPresent();//sysj\Orchestrator.sysj line: 32, column: 5
                  currsigs.addElement(posZero_1);
                  posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 32, column: 5
                  System.out.println("Emitted posZero_1");
                  S578=1;
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
                  S578=2;
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
                  S577=0;
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

  public void thread744(int [] tdone, int [] ends){
        S735=1;
    S723=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread743(int [] tdone, int [] ends){
        S721=1;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread742(int [] tdone, int [] ends){
        S713=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread741(int [] tdone, int [] ends){
        S705=1;
    S689=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread740(int [] tdone, int [] ends){
        S685=1;
    S684=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread739(int [] tdone, int [] ends){
        S652=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 16, column: 7
    S577=0;
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
      switch(S737){
        case 0 : 
          S737=0;
          break RUN;
        
        case 1 : 
          S737=2;
          S737=2;
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
          thread739(tdone,ends);
          thread740(tdone,ends);
          thread741(tdone,ends);
          thread742(tdone,ends);
          thread743(tdone,ends);
          thread744(tdone,ends);
          int biggest745 = 0;
          if(ends[2]>=biggest745){
            biggest745=ends[2];
          }
          if(ends[3]>=biggest745){
            biggest745=ends[3];
          }
          if(ends[4]>=biggest745){
            biggest745=ends[4];
          }
          if(ends[5]>=biggest745){
            biggest745=ends[5];
          }
          if(ends[6]>=biggest745){
            biggest745=ends[6];
          }
          if(ends[7]>=biggest745){
            biggest745=ends[7];
          }
          if(biggest745 == 1){
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
          thread746(tdone,ends);
          thread747(tdone,ends);
          thread748(tdone,ends);
          thread749(tdone,ends);
          thread750(tdone,ends);
          thread751(tdone,ends);
          int biggest752 = 0;
          if(ends[2]>=biggest752){
            biggest752=ends[2];
          }
          if(ends[3]>=biggest752){
            biggest752=ends[3];
          }
          if(ends[4]>=biggest752){
            biggest752=ends[4];
          }
          if(ends[5]>=biggest752){
            biggest752=ends[5];
          }
          if(ends[6]>=biggest752){
            biggest752=ends[6];
          }
          if(ends[7]>=biggest752){
            biggest752=ends[7];
          }
          if(biggest752 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest752 == 0){
            S737=0;
            active[1]=0;
            ends[1]=0;
            S737=0;
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
          rotTableTurned.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      conveyorMoved.setpreclear();
      rotTableTurned.setpreclear();
      recieveTwin.setpreclear();
      moveConveyor.setpreclear();
      turnRotTable.setpreclear();
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
      dummyint = rotTableTurned.getStatus() ? rotTableTurned.setprepresent() : rotTableTurned.setpreclear();
      rotTableTurned.setpreval(rotTableTurned.getValue());
      rotTableTurned.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      moveConveyor.sethook();
      moveConveyor.setClear();
      turnRotTable.sethook();
      turnRotTable.setClear();
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
        rotTableTurned.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
