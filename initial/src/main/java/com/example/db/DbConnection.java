package com.example.db;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DbConnection {

    static Connection conn = null;

    public static Connection connectDB() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/appointments-db", "postgres", "postgres");
        System.out.println("Connection successful");
        return conn;
    }

    public static Connection connectDb2() throws Exception{

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/appointments-db", "postgres", "postgres");
        return conn;
    }


    // when calling this method, returns all doctors and their specialities beside their name

    public static List<Doctor> getAllDoctors() {

        List doctors = new LinkedList<Doctor>();

       try{
            Connection conn = connectDB();
            String query = "Select * FROM doctors";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            //Table that represents the table we query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("speciality"));
                doctors.add(new Doctor(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("speciality")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Could not fetch Doctors - FAILURE");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
       return doctors;

    }

    public static void getAllSlots() {

        try {
            String query = "Select * FROM slots";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getDate("date"));
                System.out.println(resultSet.getInt("doctor_id"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("time"));

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not fetch Slots - FAILURE");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    // when inputting doctors name, returns specific speciality
    // eg. Sooraj, returns dentist

    private static void updateSpeciality( int id,String speciality){

        try{
            String query = "Update doctors set speciality =? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, speciality);
            preparedStatement.setInt(2, id);
            preparedStatement.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static int insertIntoSlots( String time, String date, int doctors_id,String note){
       int lReturn = 0;
        try{
            Connection conn = DbConnection.connectDB();
            //String query = "insert into slots values( slot_time=?,slot_date=?,doctors_id=?,note=?)";
            String query = "insert into slots(slot_time,slot_date,doctors_id,note) values( ?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            //preparedStatement.setInt(1, id);
            preparedStatement.setString(1, time);
            preparedStatement.setString(2, date);
            preparedStatement.setInt(3, doctors_id);
            preparedStatement.setString(4, note);

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            lReturn = -1;
        }

        return lReturn;
    }
    private static void getAllDoctorsForSpeciality(String speciality) {

        try{

            String query = "Select * FROM doctors WHERE speciality=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, speciality);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("speciality"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

   /* public static void main(String[] args) {
        try {
            Connection conn = connectDB();
            DbConnection.getAllDoctors();
            DbConnection.getAllDoctorsForSpeciality("Cardiologist");
            DbConnection.updateSpeciality(2,"Cardiologist");
            DbConnection.getAllSlots();
            DbConnection.insertIntoSlots(10,"11:00", Date.valueOf("29-10-2022"),3);
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    } */




}
