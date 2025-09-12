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
  public Signal filled = new Signal("filled", Signal.INPUT);
  public Signal recieveTwin = new Signal("recieveTwin", Signal.OUTPUT);
  public Signal moveConveyor = new Signal("moveConveyor", Signal.OUTPUT);
  public Signal turnRotTable = new Signal("turnRotTable", Signal.OUTPUT);
  public Signal fillerBottleOut = new Signal("fillerBottleOut", Signal.OUTPUT);
  public Signal startFilling = new Signal("startFilling", Signal.OUTPUT);
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
  private BottleTwin b_thread_2;//sysj\Orchestrator.sysj line: 22, column: 4
  private int ID_thread_2;//sysj\Orchestrator.sysj line: 24, column: 5
  private String name_thread_2;//sysj\Orchestrator.sysj line: 25, column: 5
  private BottleTwin b_thread_3;//sysj\Orchestrator.sysj line: 48, column: 4
  private BottleTwin b1_thread_6;//sysj\Orchestrator.sysj line: 77, column: 4
  private BottleTwin b2_thread_6;//sysj\Orchestrator.sysj line: 78, column: 4
  private BottleTwin b3_thread_6;//sysj\Orchestrator.sysj line: 79, column: 4
  private BottleTwin b4_thread_6;//sysj\Orchestrator.sysj line: 80, column: 4
  private BottleTwin b5_thread_6;//sysj\Orchestrator.sysj line: 81, column: 4
  private BottleTwin b6_thread_6;//sysj\Orchestrator.sysj line: 82, column: 4
  private BottleTwin b_thread_8;//sysj\Orchestrator.sysj line: 121, column: 4
  private BottleTwin b_thread_9;//sysj\Orchestrator.sysj line: 134, column: 4
  private BottleTwin b_thread_10;//sysj\Orchestrator.sysj line: 147, column: 4
  private BottleTwin b_thread_11;//sysj\Orchestrator.sysj line: 161, column: 4
  private int S1305 = 1;
  private int S1012 = 1;
  private int S937 = 1;
  private int S938 = 1;
  private int S1213 = 1;
  private int S1212 = 1;
  private int S1046 = 1;
  private int S1016 = 1;
  private int S1019 = 1;
  private int S1022 = 1;
  private int S1233 = 1;
  private int S1217 = 1;
  private int S1247 = 1;
  private int S1235 = 1;
  private int S1261 = 1;
  private int S1249 = 1;
  private int S1275 = 1;
  private int S1263 = 1;
  private int S1289 = 1;
  private int S1277 = 1;
  private int S1303 = 1;
  private int S1291 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread1329(int [] tdone, int [] ends){
        switch(S1303){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1291){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 160, column: 10
              b_thread_11 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 161, column: 4
              if(b_thread_11 != null){//sysj\Orchestrator.sysj line: 162, column: 8
                bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 163, column: 4
                currsigs.addElement(bottlePos2);
                bottlePos2.setValue(b_thread_11);//sysj\Orchestrator.sysj line: 163, column: 4
                System.out.println("Emitted bottlePos2");
                S1291=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
              else {
                S1291=1;
                active[11]=1;
                ends[11]=1;
                tdone[11]=1;
              }
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            S1291=1;
            S1291=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1328(int [] tdone, int [] ends){
        switch(S1289){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1277){
          case 0 : 
            if(posTwo_1.getprestatus()){//sysj\Orchestrator.sysj line: 146, column: 10
              b_thread_10 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 147, column: 4
              if(b_thread_10 != null){//sysj\Orchestrator.sysj line: 148, column: 8
                bottlePos2.setPresent();//sysj\Orchestrator.sysj line: 149, column: 4
                currsigs.addElement(bottlePos2);
                bottlePos2.setValue(b_thread_10);//sysj\Orchestrator.sysj line: 149, column: 4
                System.out.println("Emitted bottlePos2");
                S1277=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
              else {
                S1277=1;
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
              }
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            S1277=1;
            S1277=0;
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1327(int [] tdone, int [] ends){
        switch(S1275){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1263){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 133, column: 10
              b_thread_9 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 134, column: 4
              if(b_thread_9 != null){//sysj\Orchestrator.sysj line: 135, column: 8
                bottlePos1.setPresent();//sysj\Orchestrator.sysj line: 136, column: 5
                currsigs.addElement(bottlePos1);
                bottlePos1.setValue(b_thread_9);//sysj\Orchestrator.sysj line: 136, column: 5
                System.out.println("Emitted bottlePos1");
                S1263=1;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                S1263=1;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            S1263=1;
            S1263=0;
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1326(int [] tdone, int [] ends){
        switch(S1261){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1249){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 120, column: 10
              b_thread_8 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 121, column: 4
              S1249=1;
              if(b_thread_8 != null){//sysj\Orchestrator.sysj line: 122, column: 8
                bottlePos0.setPresent();//sysj\Orchestrator.sysj line: 123, column: 5
                currsigs.addElement(bottlePos0);
                bottlePos0.setValue(b_thread_8);//sysj\Orchestrator.sysj line: 123, column: 5
                System.out.println("Emitted bottlePos0");
                S1249=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                S1249=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            S1249=0;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
          case 2 : 
            S1249=2;
            S1249=0;
            active[8]=1;
            ends[8]=1;
            tdone[8]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1325(int [] tdone, int [] ends){
        switch(S1247){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1235){
          case 0 : 
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 100, column: 10
              startFilling.setPresent();//sysj\Orchestrator.sysj line: 101, column: 4
              currsigs.addElement(startFilling);
              System.out.println("Emitted startFilling");
              S1235=1;
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
            if(filled.getprestatus()){//sysj\Orchestrator.sysj line: 102, column: 10
              S1235=0;
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

  public void thread1324(int [] tdone, int [] ends){
        switch(S1233){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1217){
          case 0 : 
            if(posOne_1.getprestatus()){//sysj\Orchestrator.sysj line: 71, column: 10
              S1217=1;
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
            if(request.getprestatus()){//sysj\Orchestrator.sysj line: 72, column: 10
              turnRotTable.setPresent();//sysj\Orchestrator.sysj line: 74, column: 4
              currsigs.addElement(turnRotTable);
              System.out.println("Emitted turnRotTable");
              S1217=2;
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
          
          case 2 : 
            if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 75, column: 10
              fillerBottleOut.setPresent();//sysj\Orchestrator.sysj line: 76, column: 4
              currsigs.addElement(fillerBottleOut);
              System.out.println("Emitted fillerBottleOut");
              b1_thread_6 = (BottleTwin)(posOne_1.getpreval() == null ? null : ((BottleTwin)posOne_1.getpreval()));//sysj\Orchestrator.sysj line: 77, column: 4
              b2_thread_6 = (BottleTwin)(posTwo_1.getpreval() == null ? null : ((BottleTwin)posTwo_1.getpreval()));//sysj\Orchestrator.sysj line: 78, column: 4
              b3_thread_6 = (BottleTwin)(posThree_1.getpreval() == null ? null : ((BottleTwin)posThree_1.getpreval()));//sysj\Orchestrator.sysj line: 79, column: 4
              b4_thread_6 = (BottleTwin)(posFour_1.getpreval() == null ? null : ((BottleTwin)posFour_1.getpreval()));//sysj\Orchestrator.sysj line: 80, column: 4
              b5_thread_6 = (BottleTwin)(posFive_1.getpreval() == null ? null : ((BottleTwin)posFive_1.getpreval()));//sysj\Orchestrator.sysj line: 81, column: 4
              b6_thread_6 = (BottleTwin)(posSix_1.getpreval() == null ? null : ((BottleTwin)posSix_1.getpreval()));//sysj\Orchestrator.sysj line: 82, column: 4
              posOne_1.setPresent();//sysj\Orchestrator.sysj line: 84, column: 4
              currsigs.addElement(posOne_1);
              posOne_1.setValue(b6_thread_6);//sysj\Orchestrator.sysj line: 84, column: 4
              System.out.println("Emitted posOne_1");
              posTwo_1.setPresent();//sysj\Orchestrator.sysj line: 85, column: 4
              currsigs.addElement(posTwo_1);
              posTwo_1.setValue(b1_thread_6);//sysj\Orchestrator.sysj line: 85, column: 4
              System.out.println("Emitted posTwo_1");
              posThree_1.setPresent();//sysj\Orchestrator.sysj line: 86, column: 4
              currsigs.addElement(posThree_1);
              posThree_1.setValue(b2_thread_6);//sysj\Orchestrator.sysj line: 86, column: 4
              System.out.println("Emitted posThree_1");
              posFour_1.setPresent();//sysj\Orchestrator.sysj line: 87, column: 4
              currsigs.addElement(posFour_1);
              posFour_1.setValue(b3_thread_6);//sysj\Orchestrator.sysj line: 87, column: 4
              System.out.println("Emitted posFour_1");
              posFive_1.setPresent();//sysj\Orchestrator.sysj line: 88, column: 4
              currsigs.addElement(posFive_1);
              posFive_1.setValue(b4_thread_6);//sysj\Orchestrator.sysj line: 88, column: 4
              System.out.println("Emitted posFive_1");
              posSix_1.setPresent();//sysj\Orchestrator.sysj line: 89, column: 4
              currsigs.addElement(posSix_1);
              posSix_1.setValue(b5_thread_6);//sysj\Orchestrator.sysj line: 89, column: 4
              System.out.println("Emitted posSix_1");
              S1217=3;
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
          
          case 3 : 
            S1217=3;
            S1217=0;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1322(int [] tdone, int [] ends){
        switch(S1022){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 59, column: 15
          S1022=0;
          active[5]=0;
          ends[5]=0;
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

  public void thread1321(int [] tdone, int [] ends){
        switch(S1019){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(rotTableTurned.getprestatus()){//sysj\Orchestrator.sysj line: 55, column: 15
          S1019=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread1319(int [] tdone, int [] ends){
        S1022=1;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1318(int [] tdone, int [] ends){
        S1019=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1317(int [] tdone, int [] ends){
        switch(S1213){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1212){
          case 0 : 
            if(posZero_1.getprestatus()){//sysj\Orchestrator.sysj line: 46, column: 9
              S1212=1;
              b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
              S1046=0;
              if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                currsigs.addElement(moveConveyor);
                System.out.println("Emitted moveConveyor");
                S1016=0;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S1046=1;
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
          
          case 1 : 
            switch(S1046){
              case 0 : 
                switch(S1016){
                  case 0 : 
                    if(conveyorMoved.getprestatus()){//sysj\Orchestrator.sysj line: 51, column: 11
                      posOne_1.setPresent();//sysj\Orchestrator.sysj line: 52, column: 5
                      currsigs.addElement(posOne_1);
                      posOne_1.setValue(b_thread_3);//sysj\Orchestrator.sysj line: 52, column: 5
                      System.out.println("Emitted posOne_1");
                      posZeroLeft_1.setPresent();//sysj\Orchestrator.sysj line: 53, column: 5
                      currsigs.addElement(posZeroLeft_1);
                      System.out.println("Emitted posZeroLeft_1");
                      S1016=1;
                      thread1318(tdone,ends);
                      thread1319(tdone,ends);
                      int biggest1320 = 0;
                      if(ends[4]>=biggest1320){
                        biggest1320=ends[4];
                      }
                      if(ends[5]>=biggest1320){
                        biggest1320=ends[5];
                      }
                      if(biggest1320 == 1){
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
                  
                  case 1 : 
                    thread1321(tdone,ends);
                    thread1322(tdone,ends);
                    int biggest1323 = 0;
                    if(ends[4]>=biggest1323){
                      biggest1323=ends[4];
                    }
                    if(ends[5]>=biggest1323){
                      biggest1323=ends[5];
                    }
                    if(biggest1323 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest1323 == 0){
                      S1046=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                S1046=1;
                b_thread_3 = (BottleTwin)(posZero_1.getpreval() == null ? null : ((BottleTwin)posZero_1.getpreval()));//sysj\Orchestrator.sysj line: 48, column: 4
                S1046=0;
                if(b_thread_3 != null){//sysj\Orchestrator.sysj line: 49, column: 8
                  moveConveyor.setPresent();//sysj\Orchestrator.sysj line: 50, column: 5
                  currsigs.addElement(moveConveyor);
                  System.out.println("Emitted moveConveyor");
                  S1016=0;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S1046=1;
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

  public void thread1316(int [] tdone, int [] ends){
        switch(S1012){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S937){
          case 0 : 
            if(newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 19, column: 10
              System.err.println("newBottleTwin ");//sysj\Orchestrator.sysj line: 20, column: 7
              b_thread_2 = (BottleTwin)(newBottleTwin.getpreval() == null ? null : ((BottleTwin)newBottleTwin.getpreval()));//sysj\Orchestrator.sysj line: 22, column: 4
              S937=1;
              if(b_thread_2 != null){//sysj\Orchestrator.sysj line: 23, column: 7
                ID_thread_2 = b_thread_2.ID;//sysj\Orchestrator.sysj line: 24, column: 5
                name_thread_2 = b_thread_2.name;//sysj\Orchestrator.sysj line: 25, column: 5
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + b_thread_2);//sysj\Orchestrator.sysj line: 26, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + ID_thread_2);//sysj\Orchestrator.sysj line: 27, column: 8
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOo " + name_thread_2);//sysj\Orchestrator.sysj line: 28, column: 8
                S938=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
                S937=0;
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
            switch(S938){
              case 0 : 
                if(!newBottleTwin.getprestatus()){//sysj\Orchestrator.sysj line: 29, column: 14
                  posZero_1.setPresent();//sysj\Orchestrator.sysj line: 33, column: 5
                  currsigs.addElement(posZero_1);
                  posZero_1.setValue(b_thread_2);//sysj\Orchestrator.sysj line: 33, column: 5
                  System.out.println("Emitted posZero_1");
                  S938=1;
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
                if(posZeroLeft_1.getprestatus()){//sysj\Orchestrator.sysj line: 34, column: 11
                  S938=2;
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
                if(request.getprestatus()){//sysj\Orchestrator.sysj line: 35, column: 11
                  recieveTwin.setPresent();//sysj\Orchestrator.sysj line: 37, column: 5
                  currsigs.addElement(recieveTwin);
                  System.out.println("Emitted recieveTwin");
                  System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
                  S937=0;
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

  public void thread1314(int [] tdone, int [] ends){
        S1303=1;
    S1291=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1313(int [] tdone, int [] ends){
        S1289=1;
    S1277=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1312(int [] tdone, int [] ends){
        S1275=1;
    S1263=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1311(int [] tdone, int [] ends){
        S1261=1;
    S1249=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1310(int [] tdone, int [] ends){
        S1247=1;
    S1235=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1309(int [] tdone, int [] ends){
        S1233=1;
    S1217=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1308(int [] tdone, int [] ends){
        S1213=1;
    S1212=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1307(int [] tdone, int [] ends){
        S1012=1;
    System.err.println("new Orchestrator Cycle");//sysj\Orchestrator.sysj line: 17, column: 7
    S937=0;
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
      switch(S1305){
        case 0 : 
          S1305=0;
          break RUN;
        
        case 1 : 
          S1305=2;
          S1305=2;
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          thread1307(tdone,ends);
          thread1308(tdone,ends);
          thread1309(tdone,ends);
          thread1310(tdone,ends);
          thread1311(tdone,ends);
          thread1312(tdone,ends);
          thread1313(tdone,ends);
          thread1314(tdone,ends);
          int biggest1315 = 0;
          if(ends[2]>=biggest1315){
            biggest1315=ends[2];
          }
          if(ends[3]>=biggest1315){
            biggest1315=ends[3];
          }
          if(ends[6]>=biggest1315){
            biggest1315=ends[6];
          }
          if(ends[7]>=biggest1315){
            biggest1315=ends[7];
          }
          if(ends[8]>=biggest1315){
            biggest1315=ends[8];
          }
          if(ends[9]>=biggest1315){
            biggest1315=ends[9];
          }
          if(ends[10]>=biggest1315){
            biggest1315=ends[10];
          }
          if(ends[11]>=biggest1315){
            biggest1315=ends[11];
          }
          if(biggest1315 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          posZero_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posOne_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posTwo_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posThree_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFour_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posFive_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSix_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posSeven_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posEight_1.setClear();//sysj\Orchestrator.sysj line: 12, column: 2
          posZeroLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posOneLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posTwoLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posThreeLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFourLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posFiveLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSixLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posSevenLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          posEightLeft_1.setClear();//sysj\Orchestrator.sysj line: 13, column: 2
          thread1316(tdone,ends);
          thread1317(tdone,ends);
          thread1324(tdone,ends);
          thread1325(tdone,ends);
          thread1326(tdone,ends);
          thread1327(tdone,ends);
          thread1328(tdone,ends);
          thread1329(tdone,ends);
          int biggest1330 = 0;
          if(ends[2]>=biggest1330){
            biggest1330=ends[2];
          }
          if(ends[3]>=biggest1330){
            biggest1330=ends[3];
          }
          if(ends[6]>=biggest1330){
            biggest1330=ends[6];
          }
          if(ends[7]>=biggest1330){
            biggest1330=ends[7];
          }
          if(ends[8]>=biggest1330){
            biggest1330=ends[8];
          }
          if(ends[9]>=biggest1330){
            biggest1330=ends[9];
          }
          if(ends[10]>=biggest1330){
            biggest1330=ends[10];
          }
          if(ends[11]>=biggest1330){
            biggest1330=ends[11];
          }
          if(biggest1330 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1330 == 0){
            S1305=0;
            active[1]=0;
            ends[1]=0;
            S1305=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          filled.gethook();
          df = true;
        }
        runClockDomain();
      }
      newBottleTwin.setpreclear();
      request.setpreclear();
      conveyorMoved.setpreclear();
      rotTableTurned.setpreclear();
      filled.setpreclear();
      recieveTwin.setpreclear();
      moveConveyor.setpreclear();
      turnRotTable.setpreclear();
      fillerBottleOut.setpreclear();
      startFilling.setpreclear();
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
      dummyint = filled.getStatus() ? filled.setprepresent() : filled.setpreclear();
      filled.setpreval(filled.getValue());
      filled.setClear();
      recieveTwin.sethook();
      recieveTwin.setClear();
      moveConveyor.sethook();
      moveConveyor.setClear();
      turnRotTable.sethook();
      turnRotTable.setClear();
      fillerBottleOut.sethook();
      fillerBottleOut.setClear();
      startFilling.sethook();
      startFilling.setClear();
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
        filled.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
