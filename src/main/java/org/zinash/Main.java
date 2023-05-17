package org.zinash;

import org.zinash.models.Menu;
import org.zinash.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        try (Connection con = ConnectionUtil.getConnection()){
            System.out.println("Connection was successful!");
        } catch (SQLException e) {
            System.err.println("Sorry connection failed!");
            e.printStackTrace();
        }

        Menu menu = new Menu();
        menu.displayMenu();

    }



}




