package java_flyingchess;

import java.util.*;
public class Game {
    Map map;  //地图
    int playerPos1; //对战中玩家1的当前位置
    int playerPos2; //对战中玩家2的当前位置
    String[] goAndStop = new String[2];   //走或停标识设置
    String[] playerName = new String[2];  //对战角色
    
    /*
     * 初始化游戏的一局
     */
    public void init(){
       map = new Map();
       map.createMap();  //生成地图
         playerPos1 = 0;   //设置玩家1起始位置
         playerPos2 = 0;   //设置玩家2起始位置
         goAndStop[0] = "on";  //记录玩家1下一次走或停
         goAndStop[1] = "on";  //设置玩家2下一次走或停
    }
    
    
    /**
     * 开始游戏
     */
      public void start(){
          //初始化
          init();  
        System.out.println("**************************************************************");
        System.out.println("*                                                            *");
        System.out.println("*                                                            *");
        System.out.println("*                         骑士飞行棋                         *");
        System.out.println("*                                                            *");
        System.out.println("*                                                            *");
        System.out.println("**************************************************************\n");
        
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~两  人  对  战~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("请选择角色: 1. 戴高乐 2. 艾森豪威尔 3. 麦克阿瑟 4. 巴顿");
        Scanner input = new Scanner(System.in);
        
        System.out.print("请玩家1选择角色:  ");
        int role1 = input.nextInt();
        System.out.print("请玩家2选择角色:  ");
          int role2 = input.nextInt();

          setRole(1, role1);   //设置玩家1代表的角色
          setRole(2, role2);   //设置玩家2代表的角色     
          play();   //开始两人对战
        input.close();
      }
      
      /**
       * 设置对战角色
       * @param no 玩家次序 1：玩家1 2：玩家2
       * @param role 角色代号
       */
      public void setRole(int no, int role){
        switch(role){
          case 1: 
            playerName[no-1] = "戴高乐";
            break;
          case 2: 
            playerName[no-1] = "艾森豪威尔";
            break;
          case 3:
            playerName[no-1] = "麦克阿瑟";
            break;
          case 4: 
            playerName[no-1] = "巴顿";
            break;
          default: 
            break;
        }
      }
      
      
      /**
       * 两人对战玩法
       */
      public void play(){   
          System.out.println("\n");
         
        System.out.print("**************************************************************\n");
        System.out.print("*                        Game Start                          *\n");
        System.out.print("**************************************************************\n");
        
        //显示对战双方士兵样式
        System.out.println("^_^" + playerName[0] + "的士兵：　Ａ");
        System.out.println("^_^" + playerName[1] + "的士兵：  Ｂ\n");
          
        //显示对战地图
        System.out.println("图例说明：\n" + "@@ 起点; ■ 暂停; ¤ 幸运轮盘; ★ 地雷; 〓 时空隧道; － 普通\n\n地图如下：");
          
          map.showMap(playerPos1, playerPos2);
          
          
        //游戏开始
        int step;  //存储骰子数目
          while(playerPos1 < 99 && playerPos2 < 99){  //有任何一方走到终点，跳出循环 
          
            //2个玩家轮流掷骰子
            if(goAndStop[0].equals("on")){    
                  //玩家1掷骰子
                step = throwShifter(1);   //掷骰子
                System.out.println("\n-----------------");  //显示结果信息
              System.out.println("骰子数： "+ step);
              playerPos1 = getCurPos(1, playerPos1, step);   //计算这一次移动后的当前位置
              playerPos2 = Math.max(playerPos2,0);
              System.out.println("\n您当前位置：  "+ playerPos1);
              System.out.println("对方当前位置："+ playerPos2);
              System.out.println("-----------------\n");
              map.showMap(playerPos1, playerPos2); //显示当前地图
              if(playerPos1 == 99){  //如果走到终点
                  break;   //退出
                }
          }else{
            System.out.println("\n" + playerName[0] +"停掷一次！\n");   //显示此次暂停信息
            goAndStop[0] = "on";   //设置下次可掷状态 
          }

          
              System.out.println("\n\n\n\n");
          
          if(goAndStop[1].equals("on")){
                  //玩家2掷骰子
              step = throwShifter(2); //掷骰子
              System.out.println("\n-----------------"); //显示结果信息
              System.out.println("骰子数： "+ step);
              playerPos2 = getCurPos(2, playerPos2, step);   //计算这一次移动后的当前位置
              playerPos1 = Math.max(playerPos1,0);
              System.out.println("\n您当前位置：  "+ playerPos2);
              System.out.println("对方当前位置："+ playerPos1);
              System.out.println("-----------------\n");
              map.showMap(playerPos1, playerPos2);
              if(playerPos2 == 99){  //如果走到终点
                  break;   //退出
                }
          }else{
            System.out.println("\n" + playerName[1] + "停掷一次！\n");  //显示此次暂停信息
            goAndStop[1] = "on";  //设置下次可掷状态 
          }
          System.out.println("\n\n\n\n");
        }
          
          //游戏结束
        System.out.println("\n\n\n\n");
        System.out.print("****************************************************\n");
        System.out.print("                      Game  Over                    \n");
        System.out.print("****************************************************\n\n");
          judge();
      }
      
      
      /**
       * 掷骰子
       * @param no 玩家次序
       * @return step 掷出的骰子数目
       */
      public int throwShifter(int no){
        int step = 0;  
        System.out.print("\n\n" + playerName[no-1] + ", 请您按任意字母键后回车启动掷骰子： ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
            //产生一个1~6的数字,即掷的骰子数目
        step = (int)(Math.random()*10)%6+1;
        return step; 
      }
      

      
      /**
       * 计算玩家此次移动后的当前位置
       * @param no 玩家次序
       * @param position 移动前位置
       * @param step 掷的骰子数目
       * @return position 移动后的位置
       */
      public int getCurPos(int no, int position, int step){
        position = position + step;  //第一次移动后的位置
        if(position >= 99){
          return 99;
        }
        Scanner input = new Scanner(System.in);
        switch(map.map[position]){   //根据地图中的关卡代号进行判断
           case 0:    //走到普通格
            if (position == playerPos1) {
            playerPos1 = 0;
          }
            if (position == playerPos2) {
            playerPos2 = 0;
          }
            break;
           case 1:   //幸运轮盘
             System.out.println(".....welcome to luckyTurn!.....");
             System.out.println("  please choose a choice:");
             System.out.println("  1.change the pos 2. attack");
             int op = input.nextInt();
             System.out.println("my option is " + op);
             if(no % 2 == 0) {//play2 now
              if(op == 1) {
                 int t = playerPos1;
                 playerPos1 = position;
                 position = t;
               }
               else {
                 playerPos1-=6;
               }
             }
             else {
              if(op == 1) {
                 int t = playerPos2;
                 playerPos2 = position;
                 position = t;
               }
               else {
                 playerPos2-=6;
               }
             }
             break;
          case 2:   //踩到地雷
            position -= 6;
            break;
          case 3:  //下一次暂停一次
            goAndStop[no-1] = "off";
            break;
          case 4:   //时空隧道
            position += 10;
            break;
        }
        
        //返回此次掷骰子后玩家的位置坐标   
        if(position < 0){
          return 0;
        }else if(position > 99){
          return 99;
        }else{
          return position; 
        }
      }
      
      /**
       * 显示对战结果
       */
      public void judge(){
        if(playerPos1 > playerPos2){
          System.out.println("\n恭喜" + playerName[0] + "将军! 您获胜了！");
        }else{
          System.out.println("\n恭喜" + playerName[1] + "将军! 您获胜了！");
        }
      }
}
