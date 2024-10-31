package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class blobFatch {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/emp_mgmt";
    private static final String USER_NAME="root";
    private static final String PASS="Viratverma@12";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resutlset;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASS);
            preparedStatement=connection.prepareStatement("Select image from blobDemo where id=?");
            preparedStatement.setInt(1,101);
            resutlset=preparedStatement.executeQuery();
            if(resutlset.next()){
                InputStream is=resutlset.getBinaryStream("image");
                FileOutputStream fis=new FileOutputStream("D:\\java code\\practice oops\\java project\\blobDemo\\src\\test\\java\\res\\ABC_image.jpg");
                byte [] buffer =new byte[1024];
                while(is.read(buffer)>0){
                    fis.write(buffer);
                }
                    fis.close();
                    is.close();
                    System.out.println("Data is fatch");


            }
            else {
                System.out.println("No images are found");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
