import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\capLoaderPlant.sysj line: 1, column: 1
import run.BottleTwin;//sysj\capLoaderPlant.sysj line: 2, column: 1

public class capLoaderPlant extends ClockDomain{
  public capLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj\capLoaderPlant.sysj line: 83, column: 3
  private int S1597 = 1;
  private int S444 = 1;
  private int S398 = 1;
  private int S497 = 1;
  private int S451 = 1;
  private int S541 = 1;
  private int S511 = 1;
  private int S506 = 1;
  private int S609 = 1;
  private int S563 = 1;
  private int S545 = 1;
  private int S641 = 1;
  private int S691 = 1;
  private int S649 = 1;
  private int S657 = 1;
  private int S665 = 1;
  private int S673 = 1;
  private int S681 = 1;
  private int S689 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread1624(int [] tdone, int [] ends){
        switch(S689){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\capLoaderPlant.sysj line: 111, column: 24
          emptyE.setPresent();//sysj\capLoaderPlant.sysj line: 111, column: 31
          currsigs.addElement(emptyE);
          System.out.println("Emitted emptyE");
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        else {
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread1623(int [] tdone, int [] ends){
        switch(S681){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\capLoaderPlant.sysj line: 109, column: 24
          armAtDestE.setPresent();//sysj\capLoaderPlant.sysj line: 109, column: 35
          currsigs.addElement(armAtDestE);
          System.out.println("Emitted armAtDestE");
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread1622(int [] tdone, int [] ends){
        switch(S673){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 107, column: 24
          armAtSourceE.setPresent();//sysj\capLoaderPlant.sysj line: 107, column: 37
          currsigs.addElement(armAtSourceE);
          System.out.println("Emitted armAtSourceE");
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread1621(int [] tdone, int [] ends){
        switch(S665){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\capLoaderPlant.sysj line: 105, column: 24
          WPgrippedE.setPresent();//sysj\capLoaderPlant.sysj line: 105, column: 35
          currsigs.addElement(WPgrippedE);
          System.out.println("Emitted WPgrippedE");
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread1620(int [] tdone, int [] ends){
        switch(S657){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\capLoaderPlant.sysj line: 103, column: 24
          pusherExtendedE.setPresent();//sysj\capLoaderPlant.sysj line: 103, column: 40
          currsigs.addElement(pusherExtendedE);
          System.out.println("Emitted pusherExtendedE");
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread1619(int [] tdone, int [] ends){
        switch(S649){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\capLoaderPlant.sysj line: 101, column: 24
          pusherRetractedE.setPresent();//sysj\capLoaderPlant.sysj line: 101, column: 41
          currsigs.addElement(pusherRetractedE);
          System.out.println("Emitted pusherRetractedE");
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread1618(int [] tdone, int [] ends){
        switch(S691){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread1619(tdone,ends);
        thread1620(tdone,ends);
        thread1621(tdone,ends);
        thread1622(tdone,ends);
        thread1623(tdone,ends);
        thread1624(tdone,ends);
        int biggest1625 = 0;
        if(ends[8]>=biggest1625){
          biggest1625=ends[8];
        }
        if(ends[9]>=biggest1625){
          biggest1625=ends[9];
        }
        if(ends[10]>=biggest1625){
          biggest1625=ends[10];
        }
        if(ends[11]>=biggest1625){
          biggest1625=ends[11];
        }
        if(ends[12]>=biggest1625){
          biggest1625=ends[12];
        }
        if(ends[13]>=biggest1625){
          biggest1625=ends[13];
        }
        if(biggest1625 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest1625 == 0){
          S691=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread1617(int [] tdone, int [] ends){
        switch(S641){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\capLoaderPlant.sysj line: 85, column: 12
          if(capcount_thread_6 > 0) {//sysj\capLoaderPlant.sysj line: 86, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\capLoaderPlant.sysj line: 87, column: 6
          }
          if(refill.getprestatus()){//sysj\capLoaderPlant.sysj line: 89, column: 12
            capcount_thread_6 = 5;//sysj\capLoaderPlant.sysj line: 90, column: 5
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        else {
          if(refill.getprestatus()){//sysj\capLoaderPlant.sysj line: 89, column: 12
            capcount_thread_6 = 5;//sysj\capLoaderPlant.sysj line: 90, column: 5
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
        }
        break;
      
    }
  }

  public void thread1616(int [] tdone, int [] ends){
        switch(S609){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S563){
          case 0 : 
            if(empty.getprestatus()){//sysj\capLoaderPlant.sysj line: 68, column: 10
              S563=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S545){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\capLoaderPlant.sysj line: 70, column: 13
                    S545=1;
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
                  if(pusherExtended.getprestatus()){//sysj\capLoaderPlant.sysj line: 71, column: 13
                    capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 73, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\capLoaderPlant.sysj line: 73, column: 7
                    System.out.println("Emitted capPos_1");
                    S545=2;
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
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\capLoaderPlant.sysj line: 74, column: 13
                    capDec_1.setPresent();//sysj\capLoaderPlant.sysj line: 75, column: 7
                    currsigs.addElement(capDec_1);
                    System.out.println("Emitted capDec_1");
                    S545=0;
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
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\capLoaderPlant.sysj line: 78, column: 10
              S563=0;
              S545=0;
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
        break;
      
    }
  }

  public void thread1615(int [] tdone, int [] ends){
        switch(S541){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S511){
          case 0 : 
            switch(S506){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\capLoaderPlant.sysj line: 48, column: 12
                  S506=1;
                  if(armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 51, column: 14
                    capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 52, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\capLoaderPlant.sysj line: 52, column: 7
                    System.out.println("Emitted capPos_1");
                    S511=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S511=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\capLoaderPlant.sysj line: 49, column: 7
                  currsigs.addElement(WPgripped);
                  System.out.println("Emitted WPgripped");
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S511=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 45, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\capLoaderPlant.sysj line: 46, column: 8
                    capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 47, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\capLoaderPlant.sysj line: 47, column: 6
                    System.out.println("Emitted capPos_1");
                    S506=0;
                    WPgripped.setPresent();//sysj\capLoaderPlant.sysj line: 49, column: 7
                    currsigs.addElement(WPgripped);
                    System.out.println("Emitted WPgripped");
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S511=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S511=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S511=1;
            S511=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 45, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\capLoaderPlant.sysj line: 46, column: 8
                capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 47, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\capLoaderPlant.sysj line: 47, column: 6
                System.out.println("Emitted capPos_1");
                S506=0;
                WPgripped.setPresent();//sysj\capLoaderPlant.sysj line: 49, column: 7
                currsigs.addElement(WPgripped);
                System.out.println("Emitted WPgripped");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S511=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S511=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1614(int [] tdone, int [] ends){
        switch(S497){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S451){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 32, column: 10
              S451=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\capLoaderPlant.sysj line: 33, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 35, column: 10
              S451=2;
              pusherExtended.setPresent();//sysj\capLoaderPlant.sysj line: 37, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
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
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 36, column: 10
              S451=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\capLoaderPlant.sysj line: 37, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 39, column: 10
              S451=0;
              pusherRetracted.setPresent();//sysj\capLoaderPlant.sysj line: 33, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
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
  }

  public void thread1613(int [] tdone, int [] ends){
        switch(S444){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S398){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 19, column: 10
              S398=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\capLoaderPlant.sysj line: 20, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 22, column: 10
              S398=2;
              armAtSource.setPresent();//sysj\capLoaderPlant.sysj line: 24, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 23, column: 10
              S398=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\capLoaderPlant.sysj line: 24, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\capLoaderPlant.sysj line: 26, column: 10
              S398=0;
              armAtDest.setPresent();//sysj\capLoaderPlant.sysj line: 20, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
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
  }

  public void thread1610(int [] tdone, int [] ends){
        S689=1;
    if(empty.getprestatus()){//sysj\capLoaderPlant.sysj line: 111, column: 24
      emptyE.setPresent();//sysj\capLoaderPlant.sysj line: 111, column: 31
      currsigs.addElement(emptyE);
      System.out.println("Emitted emptyE");
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread1609(int [] tdone, int [] ends){
        S681=1;
    if(armAtDest.getprestatus()){//sysj\capLoaderPlant.sysj line: 109, column: 24
      armAtDestE.setPresent();//sysj\capLoaderPlant.sysj line: 109, column: 35
      currsigs.addElement(armAtDestE);
      System.out.println("Emitted armAtDestE");
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread1608(int [] tdone, int [] ends){
        S673=1;
    if(armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 107, column: 24
      armAtSourceE.setPresent();//sysj\capLoaderPlant.sysj line: 107, column: 37
      currsigs.addElement(armAtSourceE);
      System.out.println("Emitted armAtSourceE");
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread1607(int [] tdone, int [] ends){
        S665=1;
    if(WPgripped.getprestatus()){//sysj\capLoaderPlant.sysj line: 105, column: 24
      WPgrippedE.setPresent();//sysj\capLoaderPlant.sysj line: 105, column: 35
      currsigs.addElement(WPgrippedE);
      System.out.println("Emitted WPgrippedE");
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread1606(int [] tdone, int [] ends){
        S657=1;
    if(pusherExtended.getprestatus()){//sysj\capLoaderPlant.sysj line: 103, column: 24
      pusherExtendedE.setPresent();//sysj\capLoaderPlant.sysj line: 103, column: 40
      currsigs.addElement(pusherExtendedE);
      System.out.println("Emitted pusherExtendedE");
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread1605(int [] tdone, int [] ends){
        S649=1;
    if(pusherRetracted.getprestatus()){//sysj\capLoaderPlant.sysj line: 101, column: 24
      pusherRetractedE.setPresent();//sysj\capLoaderPlant.sysj line: 101, column: 41
      currsigs.addElement(pusherRetractedE);
      System.out.println("Emitted pusherRetractedE");
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread1604(int [] tdone, int [] ends){
        S691=1;
    thread1605(tdone,ends);
    thread1606(tdone,ends);
    thread1607(tdone,ends);
    thread1608(tdone,ends);
    thread1609(tdone,ends);
    thread1610(tdone,ends);
    int biggest1611 = 0;
    if(ends[8]>=biggest1611){
      biggest1611=ends[8];
    }
    if(ends[9]>=biggest1611){
      biggest1611=ends[9];
    }
    if(ends[10]>=biggest1611){
      biggest1611=ends[10];
    }
    if(ends[11]>=biggest1611){
      biggest1611=ends[11];
    }
    if(ends[12]>=biggest1611){
      biggest1611=ends[12];
    }
    if(ends[13]>=biggest1611){
      biggest1611=ends[13];
    }
    if(biggest1611 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread1603(int [] tdone, int [] ends){
        S641=1;
    capcount_thread_6 = 5;//sysj\capLoaderPlant.sysj line: 83, column: 3
    if(capDec_1.getprestatus()){//sysj\capLoaderPlant.sysj line: 85, column: 12
      if(capcount_thread_6 > 0) {//sysj\capLoaderPlant.sysj line: 86, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\capLoaderPlant.sysj line: 87, column: 6
      }
      if(refill.getprestatus()){//sysj\capLoaderPlant.sysj line: 89, column: 12
        capcount_thread_6 = 5;//sysj\capLoaderPlant.sysj line: 90, column: 5
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
    else {
      if(refill.getprestatus()){//sysj\capLoaderPlant.sysj line: 89, column: 12
        capcount_thread_6 = 5;//sysj\capLoaderPlant.sysj line: 90, column: 5
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
    }
  }

  public void thread1602(int [] tdone, int [] ends){
        S609=1;
    S563=0;
    S545=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1601(int [] tdone, int [] ends){
        S541=1;
    S511=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\capLoaderPlant.sysj line: 45, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\capLoaderPlant.sysj line: 46, column: 8
        capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 47, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\capLoaderPlant.sysj line: 47, column: 6
        System.out.println("Emitted capPos_1");
        S506=0;
        WPgripped.setPresent();//sysj\capLoaderPlant.sysj line: 49, column: 7
        currsigs.addElement(WPgripped);
        System.out.println("Emitted WPgripped");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S511=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S511=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1600(int [] tdone, int [] ends){
        S497=1;
    S451=0;
    pusherRetracted.setPresent();//sysj\capLoaderPlant.sysj line: 33, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1599(int [] tdone, int [] ends){
        S444=1;
    S398=0;
    armAtDest.setPresent();//sysj\capLoaderPlant.sysj line: 20, column: 5
    currsigs.addElement(armAtDest);
    System.out.println("Emitted armAtDest");
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
      switch(S1597){
        case 0 : 
          S1597=0;
          break RUN;
        
        case 1 : 
          S1597=2;
          S1597=2;
          new Thread(new GUI()).start();//sysj\capLoaderPlant.sysj line: 13, column: 2
          capDec_1.setClear();//sysj\capLoaderPlant.sysj line: 14, column: 2
          capPos_1.setClear();//sysj\capLoaderPlant.sysj line: 15, column: 2
          capPos_1.setPresent();//sysj\capLoaderPlant.sysj line: 16, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\capLoaderPlant.sysj line: 16, column: 2
          System.out.println("Emitted capPos_1");
          thread1599(tdone,ends);
          thread1600(tdone,ends);
          thread1601(tdone,ends);
          thread1602(tdone,ends);
          thread1603(tdone,ends);
          thread1604(tdone,ends);
          int biggest1612 = 0;
          if(ends[2]>=biggest1612){
            biggest1612=ends[2];
          }
          if(ends[3]>=biggest1612){
            biggest1612=ends[3];
          }
          if(ends[4]>=biggest1612){
            biggest1612=ends[4];
          }
          if(ends[5]>=biggest1612){
            biggest1612=ends[5];
          }
          if(ends[6]>=biggest1612){
            biggest1612=ends[6];
          }
          if(ends[7]>=biggest1612){
            biggest1612=ends[7];
          }
          if(biggest1612 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\capLoaderPlant.sysj line: 14, column: 2
          capPos_1.setClear();//sysj\capLoaderPlant.sysj line: 15, column: 2
          thread1613(tdone,ends);
          thread1614(tdone,ends);
          thread1615(tdone,ends);
          thread1616(tdone,ends);
          thread1617(tdone,ends);
          thread1618(tdone,ends);
          int biggest1626 = 0;
          if(ends[2]>=biggest1626){
            biggest1626=ends[2];
          }
          if(ends[3]>=biggest1626){
            biggest1626=ends[3];
          }
          if(ends[4]>=biggest1626){
            biggest1626=ends[4];
          }
          if(ends[5]>=biggest1626){
            biggest1626=ends[5];
          }
          if(ends[6]>=biggest1626){
            biggest1626=ends[6];
          }
          if(ends[7]>=biggest1626){
            biggest1626=ends[7];
          }
          if(biggest1626 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1626 == 0){
            S1597=0;
            active[1]=0;
            ends[1]=0;
            S1597=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    capPos_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capDec_1.setpreclear();
      capPos_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
