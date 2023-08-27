package org.example;

import java.sql.SQLException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Random rand = new Random();
        for(int i=0;i<13;i++){
            int pickedNumber = rand.nextInt(14)+1 ;
            System.out.println(pickedNumber);
        }

//        String[] strings1 = new String[]{"财经","彩票","房产","股票","家居","教育","科技","社会","时尚","时政","体育","星座","游戏","娱乐"};
//        String[] strings2 = new String[]{"economy","lottery","property","stock","housetool","education","technology","society","fashion","reign","physical","constellation","game","amusement"};
//        for(int i=0;i<14;i++){
//            Thread tread = new MyThread(strings1[i],strings2[i],i);
//            tread.start();
//        }


       // FileToSQL fileToSQL = new FileToSQL();
//        for (int i = 0; i < strings.length; i++) {
//            try {//E:\比赛资料\软件杯\THUCNews
//                fileToSQL.getFilesDatas("E:\\比赛资料\\软件杯\\THUCNews\\" + strings[i] ,strings[i],i + 1);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
