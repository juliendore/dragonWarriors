package com.dragonWarriors;

import java.sql.*;


public class Connect {

    private Connection con;

    public Connect() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/dwcharacters";
            String user = "julien";
            String passwd = "123";
            this.con = DriverManager.getConnection(url, user, passwd);
            System.out.println("connection successfully established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getHeroes() throws SQLException {
        Statement state = con.createStatement();
        ResultSet result = state.executeQuery("select * from hero");
        ResultSetMetaData resultMeta = result.getMetaData();
        System.out.println("\n***********************************************************");
        for (int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
        System.out.println("\n***********************************************************");
        while (result.next()) {
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString() + "\t |");
            System.out.println("\n-----------------------------------------------------------");
        }
        result.close();
        state.close();

        return result;
    }

    public void getHero(String name) throws SQLException {

        Statement state = con.createStatement();
        String query = "SELECT * FROM hero";
        query += " WHERE name = ?";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1, name);

        ResultSet result = state.executeQuery(prepare.toString());
        ResultSetMetaData resultMeta = result.getMetaData();

        System.out.println("\n***********************************************************");
        for (int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
        System.out.println("\n***********************************************************");
        while (result.next()) {
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString() + "\t |");
            System.out.println("\n-----------------------------------------------------------");
        }

        prepare.close();
        state.close();

    }

}