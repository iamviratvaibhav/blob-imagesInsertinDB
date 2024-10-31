package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class blobDemo {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/emp_mgmt";
    private static final String USER_NAME="root";
    private static final String Pass="Viratverma@12";
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try{
            connection= DriverManager.getConnection(JDBC_URL, USER_NAME, Pass);
            File f=new File("D:\\java code\\practice oops\\java project\\blobDemo\\src\\test\\java\\res\\arteum-ro-KiTalJFRkcg-unsplash.jpg");
            FileInputStream fis=new FileInputStream(f); //fis is helper to put images into db;
//            preparedStatement=connection.prepareStatement("CREATE TABLE IF NOT EXISTS dlobDemo (" +
//                    "id INT PRIMARY KEY, " +
//                    "images LONGBLOB" +
//                    ")");
//            preparedStatement=connection.prepareStatement(createTable);
//            System.out.println("Database is created");
            preparedStatement =connection.prepareStatement("insert into blobDemo values(? , ?)");
            preparedStatement.setInt(1, 101);
            preparedStatement.setBinaryStream(2, fis,(int)f.length());
            preparedStatement.executeUpdate();
            System.out.println("Data inserted");
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
