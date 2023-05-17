package org.zinash.models;

import org.zinash.daos.CarDao;
import org.zinash.daos.PersonDao;

import java.util.List;
import java.util.Scanner;


public class Menu {
    //CarDao object
    CarDao carDao = new CarDao();

    //PersonDao object
    PersonDao personDao = new PersonDao();


    public void displayMenu() {
        System.out.println("*======================================================*");
        System.out.println("Welcome to XYZ Car Management!");
        System.out.println("*======================================================*");



        boolean displayMenu = true;
        Scanner scan = new Scanner (System.in);


        while (displayMenu) {
            System.out.println();
            System.out.println("Choose an option please: \n");

            System.out.println("hi             -> for greetings");

            System.out.println("cars       -> for list of cars");

            System.out.println("persons       -> for list of persons");

            System.out.println("addPerson      -> to add person");

            System.out.println("addCar      -> to add car");

            System.out.println("updatePrice      -> to update car price");

            System.out.println("updateCity     -> to update car person city");

            System.out.println("carByplateNo     -> to get car by id");

            System.out.println("personById     -> to get person by id");

            System.out.println("carByCarName     -> to get car by name");

            System.out.println("personByLname     -> to get person by last name");

            System.out.println("carByPersonName     -> to get car by person name");

            System.out.println("deleteCar     -> to delete car");

            System.out.println("deletePerson     -> to delete person");

            System.out.println("exit           -> to exit from the application");

            String line = scan.nextLine();

            switch (line) {

                case "hi":
                    System.out.println("Hello nice to meet you!");
                    break;

                case "cars":

                    List<Car> cars = carDao.getAllCars();

                    if (cars.size() != 0) {
                        System.out.println("Here is the list of Cars...");
                        System.out.println();

                        for (Car car : cars) {
                            System.out.println(car);
                            System.out.println();
                        }

                    } else {
                        System.err.println("Sorry cars are not available");
                    }

                    break;


                case "addCar":

                    System.out.println("carName:");
                    String carName = scan.nextLine();

                    System.out.println("fYear:");
                    int fYear = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Country:");
                    String Country = scan.nextLine();

                    System.out.println("model:");
                    String model = scan.nextLine();

                    System.out.println("Price:");
                    int Price = scan.nextInt();
                    scan.nextLine();

                    System.out.println("fkpersonid:");
                    int fkpersonid = scan.nextInt();
                    scan.nextLine();

                    Car car = new Car(carName, fYear, Country,model,Price, fkpersonid);
                    carDao.addCar(car);

                    break;
                case "updatePrice":
                    System.out.println("plateNo: ");
                    int plateNo = scan.nextInt();
                    scan.nextLine();
                    System.out.println("New price: ");
                    double newPrice = scan.nextDouble();
                    scan.nextLine();

                    carDao.updatePrice(plateNo, newPrice);

                    break;

                case "deleteCar":
                    System.out.println("Which car do you want to delet? please type the plateNo: ");
                    int plNo = scan.nextInt();
                    scan.nextLine();

                    carDao.deletCar(plNo);

                    break;


                case "carByplateNo":
                    System.out.println("Which car do you want to see? (please type plateNo)");
                    int pNo = scan.nextInt();
                    scan.nextLine();
                    List<Car> carById = carDao.getCarByplateNo(pNo);

                    if(carById.size() != 0) {
                        System.out.println("The car plateNo " + pNo + " is:");
                        for (Car c : carById) {
                            System.out.println(c);

                        }
                    } else {
                        System.err.println("Sorry car is not available");
                    }

                    break;


                case "carByCarName":
                    System.out.println("Which car do you want to see? (please type carName)");
                    String cName = scan.nextLine();

                    List<Car> carByCarName = carDao.getCarBycarName(cName);

                    if(carByCarName.size() != 0) {
                        System.out.println("The car name " + cName + " is:");
                        for (Car c : carByCarName) {
                            System.out.println(c);

                        }
                    } else {
                        System.err.println("Sorry the car is not available");
                    }

                    break;

                case "carByPersonName":
                    System.out.println("what is the first name of the person?");
                    String name = scan.nextLine();
                    List<Car> cartByName = carDao.getCarByPersonName(name);

                    if (cartByName.size() != 0) {
                        if (cartByName.size() == 1){
                            System.out.println("The car ordered by " + name + " is:");
                        } else {
                            System.out.println("The cars ordered by " + name + " are:");
                        }

                        for (Car c : cartByName) {
                            System.out.println(c);

                        }
                    } else {
                        System.err.println("Sorry car is not available");
                    }

                    break;

                case "personByLname":
                    System.out.println("Which person do you want to see? (please type lastName)");
                    String lName = scan.nextLine();

                    List<Person> personByLname = personDao.getPersonsByName(lName);

                    if(personByLname.size() != 0) {
                        System.out.println("The person name " + lName + " is:");
                        for (Person p : personByLname) {
                            System.out.println(p);

                        }
                    } else {
                        System.err.println("Sorry the person is not available");
                    }

                    break;


                case "persons":

                    List<Person> persons = personDao.getAllPersons();

                    if (persons.size() != 0) {
                        System.out.println("Here is the list of Persons...");
                        System.out.println();

                        for (Person person : persons) {
                            System.out.println(person);
                            System.out.println();
                        }

                    } else {
                        System.err.println("Sorry persons are not available");
                    }

                    break;

                case "addPerson":
                    System.out.println("firstName:");
                    String firstName = scan.nextLine();

                    System.out.println("lastName:");
                    String lastName = scan.nextLine();

                    System.out.println("address:");
                    String address = scan.nextLine();

                    System.out.println("city:");
                    String city = scan.nextLine();

                    Person person = new Person(firstName, lastName, address, city);
                    personDao.addPerson(person);
                    break;

                case "updateCity":
                    System.out.println("personId: ");
                    int personId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("New city: ");
                    String newCity = scan.nextLine();

                    personDao.updateCity(personId, newCity);

                    break;


                case "personById":
                    System.out.println("Which person do you want to see? (please type personId)");
                    int pid = scan.nextInt();
                    scan.nextLine();
                    List<Person> personById = personDao.getPersonsById(pid);

                    if(personById.size() != 0) {
                        System.out.println("The person id " + pid + " is:");
                        for (Person p : personById) {
                            System.out.println(p);

                        }
                    } else {
                        System.err.println("Sorry person is not available");
                    }

                    break;

                case "deletePerson":
                    System.out.println("Which person do you want to delete? please use personId");
                    int pId = scan.nextInt();
                    scan.nextLine();

                    personDao.deletPerson(pId);
                    break;


                case "exit":
                    displayMenu = false;
                    System.out.println("Thank you for using our application! \nCome back soon");
                    break;

                default:
                    System.err.println("Something went wrong... try again please!");
                    break;



            
            
            
            }

        }
    }
}
