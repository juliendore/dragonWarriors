package com.dragonWarriors;

import java.sql.*;
import java.util.ArrayList;


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

    public void getHeroes() throws SQLException {

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

    }

    public ArrayList getHero(int id) throws SQLException {

        String selectString = "SELECT * FROM hero WHERE id = ?";
        PreparedStatement prepare = con.prepareStatement(selectString);
        prepare.setInt(1, id);
        ResultSet result = prepare.executeQuery();
        ResultSetMetaData resultMeta = result.getMetaData();

        ArrayList<String> resultarraylist = new ArrayList();
        while (result.next()) {
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                resultarraylist.add(result.getObject(i).toString());
        }

        prepare.close();
        prepare.close();

        return resultarraylist;
    }

    public void createHero(String name, String type, int hp, int strength) throws SQLException {

        String selectString = "INSERT INTO hero (type ,name ,hp,strength) VALUES (?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(selectString);
        prepare.setString(1, type);
        prepare.setString(2, name);
        prepare.setInt(3, hp);
        prepare.setInt(4, strength);
        prepare.executeUpdate();

        prepare.close();
        prepare.close();

    }

    public void updateHero(int id, String newname) throws SQLException {

        String selectString = "UPDATE hero SET name = ? WHERE id = ?";
        PreparedStatement prepare = con.prepareStatement(selectString);
        prepare.setString(1, newname);
        prepare.setInt(2, id);
        prepare.executeUpdate();
        prepare.close();
        prepare.close();

    }

    public void deleteHero(int id) throws SQLException {

        String selectString = "DELETE FROM hero WHERE id = ?";
        PreparedStatement prepare = con.prepareStatement(selectString);
        prepare.setInt(1, id);
        prepare.executeUpdate();
        prepare.close();
        prepare.close();


    }

}