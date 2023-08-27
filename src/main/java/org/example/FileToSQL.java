package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileToSQL {
    NewsType newsType= new NewsType();
    int k = 0;

    /**
         * 获取某文件夹下的文件名和文件内容,存入map集合中
         * @param filePath 需要获取的文件的 路径
         * @return 返回存储文件名和文件内容的map集合
         */
        public void getFilesDatas(String filePath,String str, int type) throws ClassNotFoundException, SQLException {

            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String format1 = format.format(new Date());
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement=null;
            File file = new File(filePath); //需要获取的文件的路径
            File[] filePathLists = file.listFiles(); //存储文件路径的String数组
            newsType.setNewstypeId(type);
            newsType.setNewsTime(format1);
            for(int i=0;i<filePathLists.length;i++){
                if(filePathLists[i].isFile()){
                    try {//读取指定文件路径下的文件内容
                        //economy = readFile(filePathLists[i]);
                        newsType=readFile(filePathLists[i]);
                        preparedStatement = connection.prepareStatement("insert into "+str+" values(null,?,?,?,?,0,0)");
                        preparedStatement = connection.prepareStatement("insert into "+str+" values(null,?,?,?,?,0,0)");
                        preparedStatement.setObject(1,newsType.getNewstypeId());
                        preparedStatement.setObject(2,newsType.getNewsTitle());
                        preparedStatement.setObject(3,newsType.getNewsContext());
                        preparedStatement.setObject(4,newsType.getNewsTime());
                        preparedStatement.executeUpdate();
                        k++;
                        System.out.println(k);



                       //if(connection!=null) {

                      // }
//                        service.addNews(economy);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            preparedStatement.close();
            connection.close();
        }

        /**
         * 读取指定目录下的文件
         * @param path 文件的路径
         * @return 文件内容
         * @throws IOException
         */
        public NewsType readFile(File path) throws IOException{
            //创建一个输入流对象
            InputStream is = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            //先读第一行标题
            String title = reader.readLine();
            //然后读内容
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = reader.readLine())!= null){
                stringBuffer.append(str);
            }

            //创建返回对象
            newsType.setNewsContext(stringBuffer.toString().trim());
            newsType.setNewsTitle(title);

            reader.close();
            return newsType;
        }

    private String url = "jdbc:mysql://36.133.153.206:3306/news?character-set-server=utf8&autoReconnect=true";
    private String username = "root";
    private String password = "123456";
    private String driver = "com.mysql.jdbc.Driver";

}
