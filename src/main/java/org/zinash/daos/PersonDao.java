package org.zinash.daos;

import org.zinash.models.Car;
import org.zinash.models.Person;
import org.zinash.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements PersonDaoInterface{


    @Override
    public List<Person> getAllPersons() {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM Persons";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);

            List<Person> personList = new ArrayList<>();
            while(rs.next()) {
                Person p = new Person(
                        rs.getInt("personId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city")
                );
                personList.add(p);
            }

            return personList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the list of the person");
            e.printStackTrace();
        }


        return null;
    }


    @Override
    public List<Person> getPersonsById(int personId) {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM Persons where personId =? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, personId);

            rs = ps.executeQuery();

            List<Person> personList = new ArrayList<>();
            while(rs.next()) {
                Person p = new Person(
                        rs.getInt("personId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city")
                );
                personList.add(p);
            }

            return personList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the person by id");
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Person> getPersonsByName(String lastName) {
        try(Connection conn = ConnectionUtil.getConnection()){

            ResultSet rs = null;
            String sql = "SELECT * FROM Persons where lastName =? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, lastName);

            rs = ps.executeQuery();

            List<Person> personList = new ArrayList<>();
            while(rs.next()) {
                Person p = new Person(
                        rs.getInt("personId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city")
                );
                personList.add(p);
            }

            return personList;


        } catch (SQLException e) {
            System.out.println("Sorry we can't display the person by lastName");
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void addPerson(Person person) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into persons (firstName, lastName, address, city)" +
                    " values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getAddress());
            ps.setString(4, person.getCity());
            ps.executeUpdate();

            System.out.println("Person " + person.getFirstName() + " was added!");
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Sorry we can't add the person");
            System.out.println();
            e.printStackTrace();
        }

    }

    @Override
    public void updateCity(int personId, String newCity) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "update persons set city = ? where personId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newCity);
            ps.setInt(2, personId);
            ps.executeUpdate();
            System.out.println("The city of person personId " + personId + " is updated to " + newCity);
        }catch (SQLException e) {
            System.out.println("Sorry we can't update the city");
            e.printStackTrace();
        }

    }

    @Override
    public void deletPerson(int personId) {

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from persons where personId = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, personId);
            ps.executeUpdate();
            System.out.println("The person with id number " + personId + " is deleted!");
            System.out.println();

        } catch (SQLException e) {
            System.err.println("Sorry we can't delete the persons");
            System.err.println("Sorry some thing went wrong. We can't delete the persons.");
        }

    }


}
