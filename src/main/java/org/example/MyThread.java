package org.example;

import java.sql.SQLException;
import java.util.Objects;

public class MyThread extends Thread{
    private String newsType;
    private String newsTypeEng;
    private  int i;
    public MyThread(){

    }
    public MyThread(String newsType,String newsTypeEng,int i){
        this.newsType=newsType;
        this.i=i;
        this.newsTypeEng=newsTypeEng;
    }

    public void run(){
        FileToSQL fileToSQL = new FileToSQL();
        //for (int i = 0; i < newsType.length; i++) {
        try {//E:\比赛资料\软件杯\THUCNews
            fileToSQL.getFilesDatas("E:\\比赛资料\\软件杯\\THUCNews\\THUCNews\\" + newsType ,newsTypeEng,i+1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyThread myThread = (MyThread) o;
        return i == myThread.i && Objects.equals(newsType, myThread.newsType) && Objects.equals(newsTypeEng, myThread.newsTypeEng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsType, newsTypeEng, i);
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "newsType='" + newsType + '\'' +
                ", newsTypeEng='" + newsTypeEng + '\'' +
                ", i=" + i +
                '}';
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsTypeEng() {
        return newsTypeEng;
    }

    public void setNewsTypeEng(String newsTypeEng) {
        this.newsTypeEng = newsTypeEng;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
