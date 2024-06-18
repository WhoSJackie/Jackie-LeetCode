package com.wang.Leetcode;

import java.util.Random;
import java.util.Scanner;

public class ChunWanMagic {


    /**
     *
     * @param pockets 撕掉后的扑克牌
     * @param name 姓名
     * @param isNorthOrSouth 北方人：1，南方人：0
     * @param sex 男：1，女：0
     * @return
     */
    public String doublePocket(String[] pockets,String name,int isNorthOrSouth,int sex){
        int len = pockets.length;
        int top = 0;
        String save = "";
        if (len!=8){
            return "不符合游戏要求数量";
        }

        // 1.按照名字长度，放牌在最下面
        int nameLen = name.length();
        int index=0;
        String temp = "";
        while (index<nameLen){
            insertPocket(pockets,0,1,8);
            index++;
        }

        // 2.从最顶上拿三张牌，随意插入中间
        // 2.1随机插入中间
        Random random = new Random();
        // 2.1.1 生成 4-7位置的随机数
        int randomInt = random.nextInt(3)+4+top;
        // 2.1.2 插入中间，需要先移动，再插入
        insertPocket(pockets,0,3,randomInt);

        // 3.取掉最上面的牌，保存,并且将最上面置为空
        save = pockets[0];
        pockets[0] = "";
        top = 1;

        // 4.南方人往中间插一张，北方人插两张
        if (isNorthOrSouth==1){
            // 北方人插入两张
            randomInt = random.nextInt(4)+top+2;
            insertPocket(pockets,top,2,randomInt);
        } else if (isNorthOrSouth==0){
            // 南方人插入一张
            randomInt = random.nextInt(5)+top+1;
            insertPocket(pockets,top,1,randomInt);
        } else{
            return null;
        }

        // 5. 男生扔掉一张牌，女生扔掉两张牌
        if (sex==1){
            pockets[top++]="";
        } else if (sex==0){
            pockets[top++]="";
            pockets[top++]="";
        }

        // 6.“见证奇迹的时刻” 往下放七张牌
        for (int i=0;i<7;i++){
            insertPocket(pockets,top,1,8);
        }

        // 7. "好运留下来，烦恼丢出去"
        if (sex==1){
            // 男生循环5次
            for (int i=0;i<5;i++){
                insertPocket(pockets,top,1,8);
                pockets[top++]="";
            }
        } else if (sex==0){
            //女生循环4次
            for (int i=0;i<4;i++){
                insertPocket(pockets,top,1,8);
                pockets[top++]="";
            }
        }else{
            return null;
        }

        // 查看剩下的那张牌
        System.out.println("藏在屁股下的牌是:"+save);
        return pockets[pockets.length-1];
    }

    // 洗牌函数，假设都是一次，并且牌是连续,从start位置开始计数
    private  void insertPocket(String[] arr,int start,int num,int pos){
        if (num>arr.length||pos>arr.length){
            return ;
        }
        // 存放牌组
        String[] temp = new String[num];
        for (int i=start;i<num;i++){
            temp[i] = arr[i];
        }
        // 开始插入牌，插入到哪两张牌之间，永远都是移动前面部分，填补到前面空缺位置
        // pos代表插入到哪张牌之前一个位置
        for (int i=start+num;i<pos;i++){
            arr[i-num] = arr[i];
        }
        // 插入牌
        for (int i=start;i<num;i++){
            arr[pos-start-num+i] = temp[i];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pockets = new String[4];
        String[] pocketFinal = new String[8];
        System.out.println("输入扑克牌:");
        for (int i=0;i<4;i++){
            pockets[i] = scanner.nextLine();
        }
        System.out.println("输入姓名:");
        String name = scanner.nextLine();
        System.out.println("输入南方还是北方人(1是北方人，0是南方人)：");
        int northOrSouth = scanner.nextInt();
        System.out.println("输入性别（1是男，0是女）：");
        int sex = scanner.nextInt();

        // 撕掉扑克牌
        for (int i = 0; i < pockets.length; i++) {
            pocketFinal[i] = pockets[i];
            pocketFinal[i+4] = pockets[i];
        }
        System.out.println("手中剩余的牌是:"+new ChunWanMagic().doublePocket(pocketFinal, name, northOrSouth, sex));
    }


}
