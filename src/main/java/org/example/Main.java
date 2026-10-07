package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/nandb");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("@9110933739S");
        try(

                Connection con = mysqlDataSource.getConnection();
                PreparedStatement ps =con.prepareStatement("select  * from register");


                )
        {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
            }


        }catch(Exception e){

            System.out.println(e);
        }
    }
}