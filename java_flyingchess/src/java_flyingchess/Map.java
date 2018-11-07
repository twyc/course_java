package java_flyingchess;
public class Map {
    public static void main(String[] args) {
        Map map = new Map();
        map.createMap();
        map.showMap(0, 0);
    }
    int[] map = new int[100];   //对战地图
    int[] luckyTurn = {6, 23, 40, 55, 69, 83}; //幸运轮盘 
    int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};//地雷位置
    int[] pause = {9, 27, 60, 93};         //暂停
    int[] timeTunnel = {20, 25, 45, 63, 72, 88, 90};//时空隧道
    
     /**
       * 生成地图
       */
    public void createMap(){
        int i = 0; 
        
        //在对战地图上设置幸运轮盘
        for(i = 0; i < luckyTurn.length; i++){
            map[luckyTurn[i]] = 1; 
        }
        
        //在对战地图上设置地雷
        for(i = 0; i < landMine.length; i++){
            map[landMine[i]] = 2; 
        }
        
        //在对战地图上设置暂停
        for(i = 0; i < pause.length; i++){
            map[pause[i]] = 3; 
        }
        
        //在对战地图上设置时空隧道
        for(i = 0; i < timeTunnel.length; i++){
            map[timeTunnel[i]] = 4; 
        }
    }
    
    /**
     * 获取地图当前位置的对应图片
     * @param i 地图当前位置的关卡代号
     * @param index 当前地图位置编号
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     * @return 地图当前位置的对应图片
     */
    public String getGraph(int i, int index, int playerPos1, int playerPos2){
        String  graph = "－";
        switch (i) {
        case 1:
            graph="¤";
            break;
        case 2:
            graph="★";
            break;
        case 3:
            graph="■";
            break;
        case 4:
            graph="〓";
            break;
        default:
            break;
        }
        /***********待补充的代码区域*************/
        //设置给定的地图位置index的正确的图形符号graph,graph的可能值包括：
        //@@（2个玩家恰好同在位置index）
        //Ａ（玩家1恰好在位置index）
        //Ｂ（玩家2恰好在位置index）
        //¤、★、■、〓、－（2个玩家均不在位置index，则按关卡代号i相应设置图形符号）     
        /***********待补充的代码区域*************/
        if(playerPos1 == playerPos2 && playerPos1 == index) {
            graph="@@";
        }
        else if(playerPos1 == index || playerPos2 == index) {
            graph="@";
        }
        return graph;
    }
    
    /**
     * 输出地图的奇数行（第1、3行）
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLine1(int start, int end, int playerPos1, int playerPos2){     
        for(int i = start; i < end; i++){
            System.out.print(getGraph(map[i], i, playerPos1, playerPos2));
        }
    }
    
    /**
     * 输出地图的偶数行（第2行）
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLine2(int start, int end, int playerPos1, int playerPos2){    
        /***********待补充的代码区域*************/
        for(int i = end-1; i >= start; i--){
            System.out.print(getGraph(map[i], i, playerPos1, playerPos2));
        }
        /***********待补充的代码区域*************/
    }
    public void space30() {
        for(int i = 0;i < 30; i++) {
            System.out.print("  ");
        }
    }
    /**
     * 输出地图的右竖列
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showRLine(int start, int end, int playerPos1, int playerPos2){
        /***********待补充的代码区域*************/
        for(int i = start;i < end; i++) {
            space30();
            System.out.println(getGraph(map[i], i, playerPos1, playerPos2));
        }
        /***********待补充的代码区域*************/
    }
    
    /**
     * 输出地图的左竖列
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLLine(int start, int end, int playerPos1, int playerPos2){
        /***********待补充的代码区域*************/
        for(int i = start;i < end; i++) {
            System.out.println(getGraph(map[i], i, playerPos1, playerPos2));

        }
        /***********待补充的代码区域*************/
    }

    /**
     * 显示对战地图
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showMap(int playerPos1, int playerPos2){
        showLine1(0, 31, playerPos1, playerPos2);   //显示地图第一行
        System.out.println();                       //换行
        showRLine(31, 35, playerPos1, playerPos2);
        showLine2(35, 66, playerPos1, playerPos2);
        System.out.println();                        //换行                    
        showLLine(66, 69, playerPos1, playerPos2);
        showLine1(69, 100, playerPos1, playerPos2);
    }  
}