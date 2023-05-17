package org.zinash.daos;

import org.zinash.models.Car;
import org.zinash.models.Person;
import org.zinash.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements CarDaoInterface {
    @Override
    public List<Car> getAllCars() {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM cars";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);

            List<Car> carList = new ArrayList<>();
            while(rs.next()) {
                Car c = new Car(
                        rs.getInt("plateNo"),
                        rs.getString("carName"),
                        rs.getInt("fYear"),
                        rs.getString("country"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getInt("fkpersonid")

                );
                carList.add(c);
            }

            return carList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the address of the customer");
            e.printStackTrace();
        }



        return null;
    }
    //@Override
    public void addCar(Car car) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into cars (carName, fYear, Country, model, Price, fkpersonid )" +
                    " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, car.getCarName());
            ps.setInt(2, car.getfYear());
            ps.setString(3, car.getCountry());
            ps.setString(4, car.getModel());
            ps.setInt(5, car.getPrice());
            ps.setInt(6, car.getFkpersonid());
            ps.executeUpdate();

            System.out.println("Car " + car.getCarName() + " was added!");
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Sorry we can't add the car");
            System.out.println();
            e.printStackTrace();
        }

    }

    @Override
    public void updatePrice(int plateNo, double price) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "update cars set price = ? where plateNo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, plateNo);
            ps.executeUpdate();
            System.out.println("The price of car plateNo " + plateNo + " is updated to " + price);
        }catch (SQLException e) {
            System.out.println("Sorry we can't update the price");
            e.printStackTrace();
        }

    }

    @Override
    public void deletCar(int plateNo) {

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from cars where plateNo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, plateNo);
            ps.executeUpdate();
            System.out.println("The car with plateNo number " + plateNo + " is deleted!");
            System.out.println();

        } catch (SQLException e) {
            System.err.println("Sorry we can't delete the car");
            System.err.println("Sorry some thing went wrong. We can't delete the car.");
        }

    }

    @Override
    public List<Car> getCarByplateNo(int plateNo) {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM cars where plateNo=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, plateNo);

            rs = ps.executeQuery();

            List<Car> carList = new ArrayList<>();
            while(rs.next()) {
                Car c = new Car(
                        rs.getInt("plateNo"),
                        rs.getString("carName"),
                        rs.getInt("fYear"),
                        rs.getString("country"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getInt("fkpersonid")

                );
                carList.add(c);
            }

            return carList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the address of the customer");
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public List<Car> getCarBycarName(String carName) {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM cars where carName=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, carName);

            rs = ps.executeQuery();

            List<Car> carList = new ArrayList<>();
            while(rs.next()) {
                Car c = new Car(
                        rs.getInt("plateNo"),
                        rs.getString("carName"),
                        rs.getInt("fYear"),
                        rs.getString("country"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getInt("fkpersonid")

                );
                carList.add(c);
            }

            return carList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the name of the car");
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public List <Car> getCarByPersonName(String name){
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;

            String sql = "select * from cars join persons on cars.fkPersonid = " + "persons.personid where persons.firstname=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            rs = ps.executeQuery();
            List<Car> carList = new ArrayList<>();

            while(rs.next()) {

                Car c = new Car(
                        rs.getInt("plateNo"),
                        rs.getString("carName"),
                        rs.getInt("fYear"),
                        rs.getString("country"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getInt("fkpersonid")

                );
                carList.add(c);
            }

            return carList;

        } catch (SQLException e) {
            System.err.println("Sorry we can't find the product");
            e.printStackTrace();
        }
        return null;
    }



}



