import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Controller extends ClockDomain{
  public Controller(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  private Signal automode_1;
  private Signal manual_1;
  private Signal startauto_1;
  private Integer m_thread_4;//sysj\controller.sysj line: 60, column: 4
  private Integer m_thread_5;//sysj\controller.sysj line: 74, column: 4
  private int S927 = 1;
  private int S240 = 1;
  private int S12 = 1;
  private int S35 = 1;
  private int S263 = 1;
  private int S247 = 1;
  private int S304 = 1;
  private int S276 = 1;
  private int S333 = 1;
  private int S365 = 1;
  private int S343 = 1;
  private int S397 = 1;
  private int S375 = 1;
  private int S429 = 1;
  private int S407 = 1;
  private int S461 = 1;
  private int S439 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread1019(int [] tdone, int [] ends){
        switch(S461){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S439){
          case 0 : 
            if(armDestM.getprestatus() && manual_1.getprestatus()){//sysj\controller.sysj line: 114, column: 10
              S439=1;
              armDest.setPresent();//sysj\controller.sysj line: 116, column: 5
              currsigs.addElement(armDest);
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
          
          case 1 : 
            if(!armDestM.getprestatus() || automode_1.getprestatus()){//sysj\controller.sysj line: 115, column: 10
              S439=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              armDest.setPresent();//sysj\controller.sysj line: 116, column: 5
              currsigs.addElement(armDest);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1018(int [] tdone, int [] ends){
        switch(S429){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S407){
          case 0 : 
            if(armSourceM.getprestatus() && manual_1.getprestatus()){//sysj\controller.sysj line: 105, column: 10
              S407=1;
              armSource.setPresent();//sysj\controller.sysj line: 107, column: 5
              currsigs.addElement(armSource);
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
          
          case 1 : 
            if(!armSourceM.getprestatus() || automode_1.getprestatus()){//sysj\controller.sysj line: 106, column: 10
              S407=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              armSource.setPresent();//sysj\controller.sysj line: 107, column: 5
              currsigs.addElement(armSource);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1017(int [] tdone, int [] ends){
        switch(S397){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S375){
          case 0 : 
            if(vacOnM.getprestatus() && manual_1.getprestatus()){//sysj\controller.sysj line: 96, column: 10
              S375=1;
              vacOn.setPresent();//sysj\controller.sysj line: 98, column: 5
              currsigs.addElement(vacOn);
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
            if(!vacOnM.getprestatus() || automode_1.getprestatus()){//sysj\controller.sysj line: 97, column: 10
              S375=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              vacOn.setPresent();//sysj\controller.sysj line: 98, column: 5
              currsigs.addElement(vacOn);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1016(int [] tdone, int [] ends){
        switch(S365){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S343){
          case 0 : 
            if(pusherExtendM.getprestatus() && manual_1.getprestatus()){//sysj\controller.sysj line: 87, column: 10
              S343=1;
              pusherExtend.setPresent();//sysj\controller.sysj line: 89, column: 5
              currsigs.addElement(pusherExtend);
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
            if(!pusherExtendM.getprestatus() || automode_1.getprestatus()){//sysj\controller.sysj line: 88, column: 10
              S343=0;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              pusherExtend.setPresent();//sysj\controller.sysj line: 89, column: 5
              currsigs.addElement(pusherExtend);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1015(int [] tdone, int [] ends){
        switch(S333){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(manual_1.getprestatus()){//sysj\controller.sysj line: 80, column: 10
          m_thread_5 = (Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 74, column: 4
          if(m_thread_5 != null){//sysj\controller.sysj line: 75, column: 8
            if(m_thread_5.intValue() == 0){//sysj\controller.sysj line: 76, column: 12
              startauto_1.setPresent();//sysj\controller.sysj line: 77, column: 9
              currsigs.addElement(startauto_1);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread1014(int [] tdone, int [] ends){
        switch(S304){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S276){
          case 0 : 
            if(startauto_1.getprestatus()){//sysj\controller.sysj line: 63, column: 15
              S276=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              manual_1.setPresent();//sysj\controller.sysj line: 64, column: 10
              currsigs.addElement(manual_1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S276=1;
            m_thread_4 = (Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 60, column: 4
            S276=0;
            if(m_thread_4 != null){//sysj\controller.sysj line: 61, column: 8
              if(m_thread_4.intValue() == 1){//sysj\controller.sysj line: 62, column: 12
                manual_1.setPresent();//sysj\controller.sysj line: 64, column: 10
                currsigs.addElement(manual_1);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S276=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S276=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1013(int [] tdone, int [] ends){
        switch(S263){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S247){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\controller.sysj line: 51, column: 14
              S247=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              automode_1.setPresent();//sysj\controller.sysj line: 52, column: 9
              currsigs.addElement(automode_1);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!manual_1.getprestatus()){//sysj\controller.sysj line: 54, column: 10
              S247=0;
              automode_1.setPresent();//sysj\controller.sysj line: 52, column: 9
              currsigs.addElement(automode_1);
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

  public void thread1012(int [] tdone, int [] ends){
        switch(S240){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(!automode_1.getprestatus()){//sysj\controller.sysj line: 14, column: 10
          S12=0;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          switch(S12){
            case 0 : 
              if(request.getprestatus() && !empty.getprestatus()){//sysj\controller.sysj line: 15, column: 11
                S12=1;
                armDest.setPresent();//sysj\controller.sysj line: 17, column: 6
                currsigs.addElement(armDest);
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
              if(armAtDest.getprestatus()){//sysj\controller.sysj line: 16, column: 11
                ;//sysj\controller.sysj line: 18, column: 6
                S12=2;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                armDest.setPresent();//sysj\controller.sysj line: 17, column: 6
                currsigs.addElement(armDest);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 2 : 
              S12=2;
              S12=3;
              pusherExtend.setPresent();//sysj\controller.sysj line: 21, column: 6
              currsigs.addElement(pusherExtend);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 3 : 
              if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 20, column: 11
                S12=4;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                pusherExtend.setPresent();//sysj\controller.sysj line: 21, column: 6
                currsigs.addElement(pusherExtend);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 4 : 
              S12=4;
              S12=5;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 5 : 
              if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 24, column: 11
                S12=6;
                armSource.setPresent();//sysj\controller.sysj line: 26, column: 6
                currsigs.addElement(armSource);
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
            
            case 6 : 
              if(armAtSource.getprestatus()){//sysj\controller.sysj line: 25, column: 11
                ;//sysj\controller.sysj line: 27, column: 6
                S12=7;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                armSource.setPresent();//sysj\controller.sysj line: 26, column: 6
                currsigs.addElement(armSource);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 7 : 
              S12=7;
              S12=8;
              S35=0;
              vacOn.setPresent();//sysj\controller.sysj line: 30, column: 6
              currsigs.addElement(vacOn);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 8 : 
              if(WPgripped.getprestatus()){//sysj\controller.sysj line: 29, column: 11
                ;//sysj\controller.sysj line: 32, column: 6
                S12=9;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                switch(S35){
                  case 0 : 
                    vacOn.setPresent();//sysj\controller.sysj line: 30, column: 6
                    currsigs.addElement(vacOn);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                    break;
                  
                  case 1 : 
                    if(WPgripped.getprestatus()){//sysj\controller.sysj line: 31, column: 12
                      ;//sysj\controller.sysj line: 32, column: 6
                      S12=9;
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
              }
              break;
            
            case 9 : 
              S12=9;
              S12=10;
              vacOn.setPresent();//sysj\controller.sysj line: 36, column: 7
              currsigs.addElement(vacOn);
              armDest.setPresent();//sysj\controller.sysj line: 37, column: 7
              currsigs.addElement(armDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
              break;
            
            case 10 : 
              if(armAtDest.getprestatus()){//sysj\controller.sysj line: 34, column: 11
                S12=11;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                vacOn.setPresent();//sysj\controller.sysj line: 36, column: 7
                currsigs.addElement(vacOn);
                armDest.setPresent();//sysj\controller.sysj line: 37, column: 7
                currsigs.addElement(armDest);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
            case 11 : 
              if(!WPgripped.getprestatus()){//sysj\controller.sysj line: 41, column: 11
                S12=12;
                armSource.setPresent();//sysj\controller.sysj line: 43, column: 6
                currsigs.addElement(armSource);
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
            
            case 12 : 
              if(armAtSource.getprestatus()){//sysj\controller.sysj line: 42, column: 11
                ;//sysj\controller.sysj line: 44, column: 6
                S12=0;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                armSource.setPresent();//sysj\controller.sysj line: 43, column: 6
                currsigs.addElement(armSource);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread1010(int [] tdone, int [] ends){
        S461=1;
    S439=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1009(int [] tdone, int [] ends){
        S429=1;
    S407=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1008(int [] tdone, int [] ends){
        S397=1;
    S375=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1007(int [] tdone, int [] ends){
        S365=1;
    S343=0;
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1006(int [] tdone, int [] ends){
        S333=1;
    m_thread_5 = (Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 74, column: 4
    if(m_thread_5 != null){//sysj\controller.sysj line: 75, column: 8
      if(m_thread_5.intValue() == 0){//sysj\controller.sysj line: 76, column: 12
        startauto_1.setPresent();//sysj\controller.sysj line: 77, column: 9
        currsigs.addElement(startauto_1);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread1005(int [] tdone, int [] ends){
        S304=1;
    m_thread_4 = (Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 60, column: 4
    S276=0;
    if(m_thread_4 != null){//sysj\controller.sysj line: 61, column: 8
      if(m_thread_4.intValue() == 1){//sysj\controller.sysj line: 62, column: 12
        manual_1.setPresent();//sysj\controller.sysj line: 64, column: 10
        currsigs.addElement(manual_1);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S276=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S276=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1004(int [] tdone, int [] ends){
        S263=1;
    S247=0;
    automode_1.setPresent();//sysj\controller.sysj line: 52, column: 9
    currsigs.addElement(automode_1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1003(int [] tdone, int [] ends){
        S240=1;
    S12=0;
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
      switch(S927){
        case 0 : 
          S927=0;
          break RUN;
        
        case 1 : 
          S927=2;
          S927=2;
          System.out.println("Controller startedh");//sysj\controller.sysj line: 9, column: 5
          automode_1.setClear();//sysj\controller.sysj line: 10, column: 5
          manual_1.setClear();//sysj\controller.sysj line: 10, column: 5
          startauto_1.setClear();//sysj\controller.sysj line: 10, column: 5
          thread1003(tdone,ends);
          thread1004(tdone,ends);
          thread1005(tdone,ends);
          thread1006(tdone,ends);
          thread1007(tdone,ends);
          thread1008(tdone,ends);
          thread1009(tdone,ends);
          thread1010(tdone,ends);
          int biggest1011 = 0;
          if(ends[2]>=biggest1011){
            biggest1011=ends[2];
          }
          if(ends[3]>=biggest1011){
            biggest1011=ends[3];
          }
          if(ends[4]>=biggest1011){
            biggest1011=ends[4];
          }
          if(ends[5]>=biggest1011){
            biggest1011=ends[5];
          }
          if(ends[6]>=biggest1011){
            biggest1011=ends[6];
          }
          if(ends[7]>=biggest1011){
            biggest1011=ends[7];
          }
          if(ends[8]>=biggest1011){
            biggest1011=ends[8];
          }
          if(ends[9]>=biggest1011){
            biggest1011=ends[9];
          }
          if(biggest1011 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          automode_1.setClear();//sysj\controller.sysj line: 10, column: 5
          manual_1.setClear();//sysj\controller.sysj line: 10, column: 5
          startauto_1.setClear();//sysj\controller.sysj line: 10, column: 5
          thread1012(tdone,ends);
          thread1013(tdone,ends);
          thread1014(tdone,ends);
          thread1015(tdone,ends);
          thread1016(tdone,ends);
          thread1017(tdone,ends);
          thread1018(tdone,ends);
          thread1019(tdone,ends);
          int biggest1020 = 0;
          if(ends[2]>=biggest1020){
            biggest1020=ends[2];
          }
          if(ends[3]>=biggest1020){
            biggest1020=ends[3];
          }
          if(ends[4]>=biggest1020){
            biggest1020=ends[4];
          }
          if(ends[5]>=biggest1020){
            biggest1020=ends[5];
          }
          if(ends[6]>=biggest1020){
            biggest1020=ends[6];
          }
          if(ends[7]>=biggest1020){
            biggest1020=ends[7];
          }
          if(ends[8]>=biggest1020){
            biggest1020=ends[8];
          }
          if(ends[9]>=biggest1020){
            biggest1020=ends[9];
          }
          if(biggest1020 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1020 == 0){
            S927=0;
            active[1]=0;
            ends[1]=0;
            S927=0;
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
    automode_1 = new Signal();
    manual_1 = new Signal();
    startauto_1 = new Signal();
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          request.gethook();
          mode.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      request.setpreclear();
      mode.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      automode_1.setpreclear();
      manual_1.setpreclear();
      startauto_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      automode_1.setClear();
      manual_1.setClear();
      startauto_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        request.gethook();
        mode.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
