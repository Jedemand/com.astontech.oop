package com.astontech.console;

import Common.helpers.DateHelper;
import Common.helpers.MathHelper;
import com.astontech.bo.*;
import com.astontech.bo.interfaces.*;
import com.astontech.dao.*;
import com.astontech.dao.mysql.*;
import org.apache.log4j.Logger;


import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        LessonDeSerialization();
    }

    private static  void LessonRecursion(int recursionCount){
        logger.info("Recursive Count = " +recursionCount);
        if (recursionCount > 0){
            LessonRecursion(recursionCount - 1);
        }
    }

    private static void LessonSerialization(){
        //get an object from db
        PersonDAO personDAO = new PersonDAOImpl();
        Person person = personDAO.getPersonById(1);
        //serialize to text
        try {
            FileOutputStream fileOut = new FileOutputStream("./ser_person.txt"); //this makes a byte stream. Unreadable
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            logger.info("Object serialized and written to file");

        } catch (IOException io){
            logger.error(io);
        }
        //
    }

    private static void LessonDeSerialization(){
        Person person = null;
        try {
            FileInputStream fileIn = new FileInputStream("./ser_person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            person = (Person) in.readObject(); //take the serialized information and put it back into an object
            in.close();

        } catch (FileNotFoundException filEx){
            logger.error(filEx);
        } catch (IOException ioEx){
            logger.error(ioEx);
        }catch (ClassNotFoundException clsEx){
            logger.error(clsEx);
        }

        logger.info(person.toString());
    }

    private static void LessonBoxUnBoxCast(){
        //Boxing converting a value type to a reference type
        //Unboxing converting a reference type back to a value type

        //box
        int x = 10;
        Object o = x;
        LessonReflectionAndGeneric(o.getClass());

        //unbox
        int y = (int) o; // explicit casting
        logger.info(y);

        //implicit casting
        int i = 100;
        double d = i;

        double db = 1.92;
        //int in = db; doesn't like. Cannot cast from more to less precise
        int in = (int) db;

        //explicit casting


    }
    private static <T> void LessonReflectionAndGeneric(Class<T> genericClass){
        
        logger.info("FullName: " + genericClass.getName());
        logger.info("SimpleName: " + genericClass.getSimpleName());
        for(Field field: genericClass.getDeclaredFields()){
            logger.info("Field: " + field.getName() + " Type: " + field.getType());
        }
        for(Method method: genericClass.getDeclaredMethods()){
            logger.info("Method: " + method.getName());
        }

    }

    private static void LABDAOVehicleDelete(){
        //VehicleMake bat = new VehicleMake(0, "Bat", new java.util.Date(47, 10, 15));
     //   VehicleMakeDAO deleteMakeDAO = new VehicleMakeDAOImpl();
    //   deleteMakeDAO.deleteVehicleMake(7);

        VehicleModelDAO deleteModelDao = new VehicleModelDAOImpl();
        deleteModelDao.deleteVehicleModel(8);

    }

    private static void LABDAOVehicleUpdate(){
//        VehicleMakeDAO MakeDAO = new VehicleMakeDAOImpl();
//        VehicleMake updateMake = MakeDAO.getVehicleMakeById(3);

//        System.out.println(updateMake.getVehicleMakeName());

//        updateMake.setVehicleMakeName("Honda");
//        updateMake.setCreateDate(new java.util.Date(28, 11, 23));
//        if(MakeDAO.updateVehicleMake(updateMake))
//            System.out.println("Updated");
//        else
//            System.out.println("fail");

//        VehicleMakeDAO MakeDAO2 = new VehicleMakeDAOImpl();
//        VehicleMake updateMake2 = MakeDAO2.getVehicleMakeById(4);

//        System.out.println(updateMake2.getVehicleMakeName());
//        updateMake2.setVehicleMakeName("Volkswagen");

//        updateMake2.setCreateDate(new java.util.Date(37, 3, 28));
//        if(MakeDAO2.updateVehicleMake(updateMake2))
//            System.out.println("Updated");
//        else
//            System.out.println("fail");
        VehicleMake Chevy = new VehicleMake(0, "Chevy", new java.util.Date(67, 8, 14));
        VehicleModel Impala = new VehicleModel(0,"Impama", Chevy);

//        VehicleModelDAO updateModelDAO = new VehicleModelDAOImpl();
//        updateModelDAO.insertVehicleModel(Impala, Chevy);

//        VehicleModel updateModel = updateModelDAO.getVehicleModelById(9);

//        System.out.println(updateModel.getVehicleModelName());

//        updateModel.setVehicleModelName("Impala");
//        updateModelDAO.updateVehicleModel(updateModel, Chevy);

        Vehicle updateVehicle = new Vehicle(0, 1967, "YTR-963", "BM567895J", "Silver", false, 25000, new java.util.Date(68, 5, 9), Impala);
        VehicleDAO updateDAO = new VehicleDAOImpl();
        //updateDAO.insertVehicle(updateVehicle, Impala);

        Vehicle changeVehicle = updateDAO.getVehicleById(11);
        changeVehicle.setPurchasePrice(67000);

        updateDAO.updateVehicle(changeVehicle, Impala);


    }
    private static void LABDAOVehicleInsert(){
        VehicleMake GM = new VehicleMake(0, "GM", new java.util.Date(1908, 7, 15));
//        VehicleMakeDAO insertMakeDAO = new VehicleMakeDAOImpl();
//        insertMakeDAO.insertVehicleMake(GM);


        VehicleModel Buick = new VehicleModel(0,"Buick", GM);
//        VehicleModelDAO insertModelDAO = new VehicleModelDAOImpl();
//        insertModelDAO.insertVehicleModel(Buick, GM);

        Vehicle insertVehicle = new Vehicle(0, 1996, "857-PJK", "JN5674DN9", "Green", true, 8500, new java.util.Date(2010, 9, 17), Buick);
        VehicleDAO insertDAO = new VehicleDAOImpl();
        insertDAO.insertVehicle(insertVehicle, Buick);

//        VehicleMake GM = new VehicleMake(0, "GM", new java.util.Date(1908, 7, 15));
//        VehicleModel Buick = new VehicleModel(0,"Buick", GM);
//        Vehicle insertVehicle = new Vehicle(0, 1996, "857-PJK", "JN5674DN9", "Green", true, 8500, new java.util.Date(2010, 9, 17), Buick);
//
//        VehicleMakeAndModel insertVehicleDAO = new VehicleMakeAndModelImpl();
//        insertVehicleDAO.insertVehicleMakeAndModel(insertVehicle, Buick, GM);
    }

    private static void LABDAOEmailUpdate(){

    }
    private static void LABDAOEmailPhoneEmployeeInsert(){
        Person newPerson = new Person(0, "Mr.", "Thomas", "MacHeath", new java.util.Date(77, 9, 18), "The Knife", false, "M");
        PersonDAO addPersonDAO = new PersonDAOImpl();
        //addPersonDAO.insertPerson(newPerson); ADDED PERSON

        Person personFK = addPersonDAO.getPersonById(11); //Because newPerson doesn't have a FK

        Employee newEmployee = new Employee(0, new java.util.Date(98, 11, 5),  new java.util.Date(102, 3, 11), new java.util.Date(77, 9, 18), newPerson);
        EmployeeDAO addEmployeeDAO = new EmployeeDAOImpl();
        //addEmployeeDAO.insertEmployee(newEmployee, personFK); ADDED EMPLOYEE

        Employee employeeFK = addEmployeeDAO.getEmployeeById(9); //For Email FK

        EntityTypeDAO getEntityTypeDAO = new EntityTypeDAOImpl();
        EntityType emailTypeFK = getEntityTypeDAO.getEntityTypeById(3); //for Email Fk
        EntityType phoneTypeFK = getEntityTypeDAO.getEntityTypeById(5); //for phone fk


        Email newEmail = new Email(0, "thomas.macheath@drurylane.com", newEmployee, emailTypeFK);
        EmailDAO addEmail = new EmailDAOImpl();
        //addEmail.insertEmail(newEmail, employeeFK, emailTypeFK); Email Added

        ClientDAO getClient = new ClientDAOImpl();
        Client druryLane = getClient.getClientById(11);

        Phone newPhone = new Phone(0, phoneTypeFK, druryLane, personFK, 612, 6765434, 0);
        PhoneDAO addPhone = new PhoneDAOImpl();
        //addPhone.insertPhone(newPhone, phoneTypeFK, personFK, druryLane); Phone Added

        Email updateEmail = new Email(0, "thomas.theknife.macheath@drurylane.com", newEmployee, emailTypeFK);
       // addEmail.updateEmail(updateEmail, employeeFK, emailTypeFK); updated email

        Employee updateEmployee = new Employee(9, new java.util.Date(98, 11, 5),  new java.util.Date(105, 3, 11), new java.util.Date(87, 9, 18), newPerson);
       // addEmployeeDAO.updateEmployee(updateEmployee, personFK); updated employee

        Phone updatePhone = new Phone(9, phoneTypeFK, druryLane, personFK, 651, 5857920, 0);
        //addPhone.updatePhone(updatePhone, phoneTypeFK, personFK, druryLane); updated phone

        addEmployeeDAO.deleteEmployee(9);
        addEmail.deleteEmail(0);
        addPhone.deletePhone(9);



    }

    private static void LessonDAODelete(){
//

       //Person updatePerson = new Person(9, "Ms.", "Jennifer", "MacHeath", new java.sql.Date(1630421692), "Ms. Mack", false, "F");
//        PersonDAO updateDAO = new PersonDAOImpl();
//        updateDAO.updatePerson(updatePerson);
        PersonDAO deleteDAO = new PersonDAOImpl();
        deleteDAO.deletePerson(11);


    }

    private static void LessonDAOUpdate(){
      //  Person insertPerson = new Person(0, "Ms.", "Polly", "Peachum",  new java.sql.Date(1984, 7, 16), "Pretty Polly", false, "F");
        //PersonDAO insertDAO = new PersonDAOImpl();
        //insertDAO.insertPerson(insertPerson);

        PersonDAO personDAO = new PersonDAOImpl();
        Person person = personDAO.getPersonById(11);

        person.setLastName("MacHeath");
        person.setCreateDate(new Date());
        person.setDeleted(false);
        if(personDAO.updatePerson(person))
            System.out.println("Updated");
        else
            System.out.println("fail");
    }

    private static void LABDAOEmail(){
        EmailDAO emailDAO = new EmailDAOImpl();
        List<Email> emailList = emailDAO.getEmailList();

        System.out.println("==================================");
        for(Email email: emailList){
            System.out.println(email.getEmailId() + ": " + email.getEmailAddress());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a email from List: ");
        String emailId = scanner.nextLine();

        //endregion

        //region Get Details
        Email emailDetail = emailDAO.getEmailById(Integer.parseInt(emailId));
        System.out.println("-----email Details------");
        System.out.println("Address: " + emailDetail.getEmailAddress());
        System.out.println("EmployeeID: " + emailDetail.getEmployeeId());
        //endregion

    }
    
    private static void LABDAOVehicleMake(){
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();
        List<VehicleMake> vehicleMakeList = vehicleMakeDAO.getVehicleMakeList();

        System.out.println("==================================");
        for(VehicleMake vehicleMake: vehicleMakeList){
            System.out.println(vehicleMake.getVehicleMakeId() + ": " + vehicleMake.getVehicleMakeName());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a vehicleMake from List: ");
        String vehicleMakeId = scanner.nextLine();

        //endregion

        //region Get Details
        VehicleMake vehicleMakeDetail = vehicleMakeDAO.getVehicleMakeById(Integer.parseInt(vehicleMakeId));
        System.out.println("-----VehicleMake Details------");
        System.out.println("Name: " + vehicleMakeDetail.getVehicleMakeName());
        //endregion
    
    }
    
    private static void LABDAOGetVehicleModel(){
        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();
        List<VehicleModel> vehicleModelList = vehicleModelDAO.getVehicleModelList();

        System.out.println("==================================");
        for(VehicleModel vehicleModel: vehicleModelList){
            System.out.println(vehicleModel.getVehicleModelId() + ": " + vehicleModel.getVehicleModelName());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a vehicleModel from List: ");
        String vehicleModelId = scanner.nextLine();

        //endregion

        //region Get Details
        VehicleModel vehicleModelDetail = vehicleModelDAO.getVehicleModelById(Integer.parseInt(vehicleModelId));
        System.out.println("-----VehicleModel Details------");
        System.out.println("Model Name: " + vehicleModelDetail.getVehicleModelName());

        //endregion
    }
    private static void LABDAOGetVehicle(){
        VehicleDAO vehicleDAO = new VehicleDAOImpl();
        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();

        System.out.println("==================================");
        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getVehicleId() + ": " + vehicle.getYear() + " " + vehicle.getColor() + " " + vehicle.getLicensePlate());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a vehicle from List: ");
        String vehicleId = scanner.nextLine();

        //endregion

        //region Get Details
        Vehicle vehicleDetail = vehicleDAO.getVehicleById(Integer.parseInt(vehicleId));
        System.out.println("-----Vehicle Details------");
        System.out.println("Year: " + vehicleDetail.getYear());
        System.out.println("Color: " + vehicleDetail.getColor());
        //endregion
    }
    
    private static void LABDAOGetPhone(){
        PhoneDAO phoneDAO = new PhoneDAOImpl();
        List<Phone> phoneList = phoneDAO.getPhoneList();

        System.out.println("==================================");
        for(Phone phone: phoneList){
            System.out.println(phone.getPhoneId() + ": " + phone.getAreaCode() + " " + phone.getPhoneNumber());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a Phone from List: ");
        String phoneId = scanner.nextLine();

        //endregion

        //region Get Details
        Phone phoneDetail = phoneDAO.getPhoneById(Integer.parseInt(phoneId));
        System.out.println("-----Phone Details------");
        System.out.println("Area Code: " + phoneDetail.getAreaCode());
        System.out.println("Phone Number: " + phoneDetail.getPhoneNumber());
        //endregion

    }
    private static void LABDAOOGetEmployee(){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employeeList = employeeDAO.getEmployeeList();

        System.out.println("==================================");
        for(Employee employee: employeeList){
            System.out.println(employee.getEmployeeId() + ": " + employee.getHireDate() + " " + employee.getBirthDate());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a employee from List: ");
        String employeeId = scanner.nextLine();

        //endregion

        //region Get Details
        Employee employeeDetail = employeeDAO.getEmployeeById(Integer.parseInt(employeeId));
        System.out.println("-----employee Details------");
        System.out.println("Hire Date: " + employeeDetail.getHireDate());
        System.out.println("BirthDate: " + employeeDetail.getBirthDate());
        //endregion
    }
    private static Connection LabDBConnection(){
        String postHost = "localhost";
        String postName = "connectionLabDatabase";
        String postUser = "root";
        String postPassword = "Niemand00";
        String useSSL = "false";
        String procBod = "true";

        Connection connection = null;
        try{

            connection = DriverManager.getConnection("jdbc:postgresql://" + postHost + ":5432/" + postName, "postUser", "postPassword");
        } catch (SQLException ex){
            logger.error("Connection failed" + ex);
            return null;
        }

        if(connection != null){
            logger.info("Successfully connected");
            return connection;
        } else{
            logger.info("Connection failed");
        }
        return connection;
    }

    private static void LessonDAO(){
        //region Create Menu
        PersonDAO personDAO = new PersonDAOImpl();
        List<Person> personList = personDAO.getPersonList();

        System.out.println("==================================");
        for(Person person: personList){
            System.out.println(person.getPersonId() + ": " + person.getFirstName() + " " + person.getLastName());
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        //endregion

        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a Person from List: ");
        String personId = scanner.nextLine();

        //endregion

        //region Get Details
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));
        System.out.println("-----Person Details------");
        System.out.println("Full Name: " + personDetail.getFirstName());
        System.out.println("Gender: " + personDetail.getGender());
        System.out.println("Display Name: " + personDetail.getDisplayFirstName());
        //endregion
    }
    private static void LessonGetStoredProcedure(){
        Connection conn = LessonDBConnection();
        try{
            String sp = "{call get_person(?,?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1,20);
            cStmt.setInt(2,1);

            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                String FirstName = rs.getString(2);
                String LastName = rs.getString(3);
                String DisplayFirstName = rs.getString(4);
                String Gender = rs.getString(5);
                logger.info(" First Name: " + FirstName + " - LastName: " + LastName + " - Display First Name: " + DisplayFirstName + " - Gender: " + Gender);

            }
        } catch (SQLException sqlex){
            logger.error(sqlex);
        }
    }
    private static void LessonExecuteQuery(){
        Connection conn = LessonDBConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "select PersonId, Firstname, LastName from person;";

            ResultSet rs = statement.executeQuery(sql); //executeQuery is the equivalent of hit F5 on x
            while(rs.next()){   //rs.next() returns a bool. True so long as there is another result set
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                logger.info("Id: " + personId + " First Name: " + firstName + " - LastName: " + lastName); //get the value at the first column
            }
            conn.close();


        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }

    }

    private static Connection LessonDBConnection(){
        //DB connection string
        String dbHost = "localhost";
        String dbName = "astonengineer";
        String dbUser = "root";
        String dbPassword = "The-Dagda00";
        String useSSL = "false";
        String procBod = "true";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
          logger.error("Mysql driver not founder" + ex);
          return null;
        }

        logger.info("MySQL Driver Registered");

        Connection connection = null;
        try{

            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?autoReconnect=true&useSSL=" +useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPassword);
        } catch (SQLException ex){
            logger.error("Connection failed" + ex);
            return null;
        }

        if(connection != null){
            logger.info("Successfully connected");
            return connection;
        } else{
            logger.info("Connection failed");
        }
        return connection;
    }

    private static void CompareLab(){
        Person Connor = new Person("Connor", "McEvoy");
        Person Alexander = new Person("Alexander", "Gerchak");

        System.out.println("Compare to Returns :: " + Connor.compareTo(Alexander));
        int result = Connor.compareTo(Alexander);

        if(result > 0){
            System.out.println(Connor.getLastName() + " comes before " + Alexander.getLastName());
        }else if (result < 0){
            System.out.println(Connor.getLastName() + " comes after " + Alexander.getLastName());
        }else {
            System.out.println(Connor.getLastName() + " is equal to " + Alexander.getLastName());
        }


        VehicleMake Chevrolet = new VehicleMake("Chevrolet");
        VehicleModel Impala = new VehicleModel("Impala", Chevrolet);
        VehicleMake Ford = new VehicleMake("Ford");
        VehicleModel Focus = new VehicleModel("Focus", Ford);

        Vehicle myCar = new Vehicle(1, 1994, "BFT-987", "GT5674FT98", "Blue", true, 15000, new Date(), Impala);
        Vehicle yourCar = new Vehicle(2, 2015, "TRY-498", "DRE43567UH67", "Red", true, 20000, new Date(), Focus);

        System.out.println("Compare to Returns :: " + myCar.compareTo(yourCar));
        int carResult = myCar.compareTo(yourCar);

        if(result > 0){
            System.out.println(myCar.getVehicleModelId().getVehicleModelName() + " is younger than " + yourCar.getVehicleModelId().getVehicleModelName());
        }else if (result < 0){
            System.out.println(myCar.getVehicleModelId().getVehicleModelName() + " is older than " + yourCar.getVehicleModelId().getVehicleModelName());
        }else {
            System.out.println(myCar.getVehicleModelId().getVehicleModelName() + " the same year as " + yourCar.getVehicleModelId().getVehicleModelName());
        }



    }
    private static void CharSequenceLab(){
        drawkcab Reverser = new drawkcab();
        Reverser.returnBackward("drawkcab", 7, 0);
    }
    private static void InterfacesLab(){
        Person Connor = new Person("Connor", "McEvoy");
        CarTrip driveToAustralia = new CarTrip(3.10, 29, 55, Connor);

        LoyaltyCompany Quantus = new LoyaltyCompany("Quantus");
        Flight flyToAustralia = new Flight(.20, 575, Quantus);

        System.out.println("Time on the road: " + driveToAustralia.getTravelTime(9005) + " Days");
        System.out.println("Time in the air: " + flyToAustralia.getTravelTime(9008) + " Hours");
        System.out.println("Cost to Drive: " + driveToAustralia.getCostOfTrip(9005));
        System.out.println("Cost to Fly: " + flyToAustralia.getCostOfTrip(9005));
    }
    private static void LessonLogging(){
        //notes: Levels of loggin
        logger.debug("This is a DEBUG log message");
        logger.info("This is a INFO log message");

        //Production level (log in a live application)
        logger.warn("This is a WARN log message");
        logger.error("This is a ERROR log message");
        logger.fatal("This is a FATAL log message");
    }

    private static void LessonInterfaces(ILocation ILocation){
        Site MN010 = new Site();
        MN010.setCoffeeMachine(2);
        MN010.setConferenceRooms(4);
        MN010.setCubicles(12);
        MN010.setOffices(4);
        MN010.setSiteName("MN010");

        Home House = new Home();
        House.setAddress("1345 Warwick Ave, St. Paul");
        Employee Bob = new Employee();
        Bob.setFirstName("Bob");
        House.setOwner(Bob);



        System.out.println("Location Name: " +ILocation.getLocationName());
        System.out.println("Can Have Meetings: " +ILocation.canHAveMeetings());
        System.out.println("Number of Work Spaces: " + ILocation.numberOfWorkspaces());
        System.out.println("Has Coffee: " + ILocation.hasCoffee());
    }
    private static void HashLab(){
        Hashtable<Integer, String> funnyAnimals = new Hashtable<>();
        funnyAnimals.put(1, "Flamboyant CuttleFish");
        funnyAnimals.put(2, "Dik Dik");
        funnyAnimals.put(3, "Crows");
        funnyAnimals.put(4, "Vampire Squid");
        funnyAnimals.put(5, "Giant Sloths");
        funnyAnimals.put(6, "Pygmy Mammoth");
        funnyAnimals.put(7, "Quokka");
        funnyAnimals.put(9, "Wolf Mouse");

        for(Integer key : funnyAnimals.keySet()){
            System.out.println("Key: " + key + " Value: " + funnyAnimals.get(key));
        }

        HashMap<Integer, String > funnyObjects = new HashMap<>();
        funnyObjects.put(1, "Rubber Chickens");
        funnyObjects.put(2, "Plungers");
        funnyObjects.put(3, "Scooters");
        funnyObjects.put(5, "Blimps");
        funnyObjects.put(6, "Velocipedes");
        funnyObjects.put(7, "large Umbrellas");
        funnyObjects.put(8, "Bad Taxidermy");

        for(Integer key : funnyObjects.keySet()){
            System.out.println("Key: " + key + " Value: " + funnyObjects.get(key));
        }

        HashSet<String> funnyPlants = new HashSet<>();
        funnyPlants.add("Durian");
        funnyPlants.add("Cantaloupe");
        funnyPlants.add("Star Fruit");
        funnyPlants.add("Buddha's Hand");
        funnyPlants.add("Gourds");
        funnyPlants.add("Loufas");
        funnyPlants.add("Fly Agaric");

        for(String s : funnyPlants){
            System.out.println(s);
        }



    }
    private static void LessonValueRef(){
        //reference type: more than 1 primitive data type. Cyclical. Updating one updates the other. Pointer
        Employee firstEmployee = new Employee();
        firstEmployee.setFirstName("Connor");

        Employee secondEmployee = firstEmployee;

        System.out.println(secondEmployee.getFirstName());
        //value type: just 1 primitive data type. One sets value, will not update.
        int firstInt = 10;
        int secondInt = firstInt;

        firstInt = 20;
        System.out.println(secondInt);

    }
    private static void LessonHash(){
        //key-value pairs/value lists

        //Hash Table 1) Does not allow for null 2) synchronized, thread safe, performance decreased
        Hashtable<Integer, String> firstHashTable = new Hashtable<>();
        firstHashTable.put(1, "Inheritence");
        firstHashTable.put(2, "Abstraction");
        firstHashTable.put(3, "Polymorphism");
        firstHashTable.put(4, "Encapsulation");
        //firstHashTable.put(5, null); will throw a null pointer exception NPE

        System.out.println(firstHashTable.get(3));

        for(Integer key : firstHashTable.keySet()){
            System.out.println("Key: " + key + " value: " + firstHashTable.get(key));
        }

        //Hash Map 1) Does allow for Null 2) un-synchronized, not thread safe, better performance

        HashMap<Integer, String> firstHashMap = new HashMap<>();
        firstHashMap.put(1, "Inheritence");
        firstHashMap.put(2, "Abstraction");
        firstHashMap.put(3, "Polymorphism");
        firstHashMap.put(4, "Encapsulation");
        firstHashMap.put(5, null);

        for(Integer key : firstHashMap.keySet()){
            System.out.println("Key: " + key + " Value: " + firstHashMap.get(key));
        }

        //Hash Set 1) Built in mechanism for duplicated 2) used for where you want to maintain a unique set
        HashSet<String> oopPrincip = new HashSet<>();
        oopPrincip.add("Inheritence");
        oopPrincip.add("Abstraction");
        oopPrincip.add("Polymorphism");
        oopPrincip.add("Encapsulation");


        if(oopPrincip.contains("Encapsulation")){
            System.out.println("Values exists");
        }else
            System.out.println("Value does not exist");

        for(String s : oopPrincip){
            System.out.println(s);
        }

    }

    private static void LessonPolymorphism(){
        //compile time polymorphism, overloaded methods(all have the same name, but different parameters)

        //runtime polymorphism overridden methods(Override a method from a base class in the child class)
        BaseBo newBew = new BaseBo();
        System.out.println(newBew.test_method());

        EntityType newET = new EntityType(); //same method name, but different code
        System.out.println(newET.test_method());
    }
    private static void LessonInstanceVsStatic(){
        //The cumbersome way with instances
//        Math InstanceOfMathClass = new Math();
//        System.out.println(InstanceOfMathClass.E);
//        System.out.println(InstanceOfMathClass.square(4));

        //Fast way with static
        System.out.println(MathHelper.square(4));
        System.out.println(MathHelper.E);

    }

    private static void LessonNestingLab(){
        VehicleMake Chevrolet = new VehicleMake("Chevrolet");
        VehicleModel Impala = new VehicleModel("Impala", Chevrolet);
        VehicleMake Ford = new VehicleMake("Ford");
        VehicleModel Focus = new VehicleModel("Focus", Ford);
        VehicleMake Nissan = new VehicleMake("Nissan");
        VehicleModel Leaf = new VehicleModel("Leaf", Nissan);
        Person carFanatic = new Person();
        carFanatic.getVehicles().add(new Vehicle(1, 1994, "BFT-987", "GT5674FT98", "Blue", true, 12000, new Date(), Impala));
        carFanatic.getVehicles().add(new Vehicle(2, 2015, "TRY-498", "DRE43567UH67", "Red", true, 145000, new Date(), Focus));
        carFanatic.getVehicles().add(new Vehicle(3, 2018, "FYO-754", "NBR6734O8", "Green", true, 18750, new Date(), Leaf));
        for(Vehicle vehicle: carFanatic.getVehicles()){
            System.out.println(vehicle.toString());
        }
    }
    private static void LessonComplexProperties(){
        //notes: when to use inheritance (should answer the question: 'Is A'?)
        // when to use complex (nested) objects (should answer the questions 'Has A'?)
        EntityType emailWorkType = new EntityType("Work");
        Email myEmail = new Email("bipin@bip.com");
        myEmail.setEmailType(emailWorkType);
        System.out.println(myEmail.getEmailAddress() + " Type: " + myEmail.getEmailType().getEntityTypeName());

        //Collections of complex objects
        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("test3@test.com"));
        myEmployee.getEmails().add(new Email("test2@test.com"));

        for(Email email : myEmployee.getEmails()){
            System.out.println(email.getEmailAddress());
        }
    }

    private static void LessonCollections(){
        List<Employee> employeeList = new ArrayList<Employee>();

        Employee emp1 = new Employee("Dan", "Simmers");
        Employee emp2 = new Employee("James", "McRoberts");
        Employee emp3 = new Employee("Sean", "Nilsen");
        Employee emp4 = new Employee("Adrian", "Ratanyke");

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        employeeList.add(new Employee("John", "Doe"));

        System.out.println(employeeList.get(4)); //this will create Employee@memory address
        System.out.println(employeeList.get(3).getFirstName());

        for(Employee e : employeeList){
            System.out.println(e.GetFullName());
        }

    }
    private static void LessonObjectLab(){
//        Address newAddress = new Address(1, 1768, "Saint Street", "TownsVille", 1, 1);
//        System.out.println(newAddress.getAddressNumber() + " " + newAddress.getStreet() + " " + newAddress.getCity());
//
//        Client newClient = new Client(1, "Best Client", new Date());
//        System.out.println(newClient.getClientId() + " " + newClient.getClientName() + " " + newClient.getCreateDate());
//
//        ClientContact newClientContact = new ClientContact(1, 1, 2);
//        System.out.println(newClientContact.getClientContactId() + " " + newClientContact.getClientId() + " " + newClientContact.getEntityTypeId());
//
//        Email newEmail = new Email("someone@someemail.com");
//        System.out.println(newEmail.getEmailAddress());
//
//        Employee newEmployee = new Employee("Bob", "McBobbers");
//        System.out.println(newEmployee.GetFullName());
//
//        EmployeeProject newEmployeeProject = new EmployeeProject(1, 2, 3, 4, 5, new Date());
//        System.out.println(newEmployeeProject.getEmployeeId() + " " + newEmployeeProject.getProjectId() + " " + newEmployeeProject.getStartDate());
//
//        Entity newEntity = new Entity(1, "Phone");
//        System.out.println(newEntity.getEntityId() + " " + newEntity.getEntityName());
//
//        EntityType newEntityType = new EntityType("Work");
//        System.out.println(newEntityType.getEntityTypeName() + " " + newEntityType.getEntityId());
//
//        LoyaltyCompany newLoyaltyCompany = new LoyaltyCompany();
//        newLoyaltyCompany.setCompanyName("Delta");
//        System.out.println(newLoyaltyCompany.getCompanyName());
//
//        LoyaltyAccount newLoyaltyAccount = new LoyaltyAccount(1, 2, 3, "HZ42314");
//        System.out.println(newLoyaltyAccount.getMemberNumber());
//
//        Person newPerson = new Person(1, "Mr.", "John", "McJohnny", "John", "M");
//        System.out.println(newPerson.getTitle() + " " + newPerson.getLastName());
//
//        Phone newPhone = new Phone(1, 2, 4, 612, 2475667);
//        System.out.println(newPhone.getAreaCode() + " " + newPhone.getPhoneNumber());
//
//        Project newProject = new Project();
//        newProject.setProjectName("Java Course");
//        System.out.println(newProject.getProjectName());
//
//        ProjectStatus newProjectStatus = new ProjectStatus();
//        newProjectStatus.setNotes("In Progress");
//        System.out.println(newProjectStatus.getNotes());
//
//        Review newReview = new Review();
//        newReview.setReviewName("Connor's Review");
//        System.out.println(newReview.getReviewName());
//
//        ReviewData newReviewData = new ReviewData();
//        newReviewData.setCreateDate(new Date());
//        System.out.println(newReviewData.getCreateDate());
//
//        ReviewId newReviewId = new ReviewId();
//        newReviewId.setReviewName("1st Review");
//        System.out.println(newReviewId.getReviewName());
//
//        Training newTraining = new Training();
//        newTraining.setEmployeeName("Connor");
//        System.out.println(newTraining.getEmployeeName());
//
//        TrainingData newTrainingData = new TrainingData();
//        newTrainingData.setCreateDate(new Date());
//        System.out.println(newTrainingData.getCreateDate());
//
//        Vehicle newVehicle = new Vehicle(1, 1994, "CGF-228", "H678FT578", "Gray", false, new Date(), 3);
//        System.out.println(newVehicle.getColor() + " " + newVehicle.isPurchased());
//
//        VehicleMake newVehicleMake = new VehicleMake(1, "Ford Focus", new Date());
//        System.out.println(newVehicleMake.getVehicleMakeName());
//
//        VehicleStatus newVehicleStatus = new VehicleStatus(1, 2, 1, "Broken", new Date());
//        System.out.println(newVehicleStatus.getNotes());




    }
    private static void LessonConstructorMethods(){
        //Making of a Method: Signature(Declaration) the first line
        /* access modifier (private
        * instance or static (static)
        * return type (void)
        * Method Name (LessonConstructorMethods)
        * Parameters  (Nil)
        */

        //Constructors: special methods with same name as class. Called when instantiated.

        Employee constructorEmployee = new Employee("Connor", "McEvoy");
        System.out.println(constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName());

        Employee const2Employee = new Employee("Kafka");
        System.out.println(const2Employee.getLastName());

        Employee employeeJames = new Employee("James", "McRoberts");
        System.out.println(employeeJames.GetFullName());



    }


    private static void LessonInheritance(){
        //4 principles of OOB: Encapsulation, Abstraction, Inheritance, Polymorphism

        Employee employeeConnor = new Employee();

        employeeConnor.setFirstName("Connor");
        employeeConnor.setLastName("McEvoy");
        employeeConnor.setId(3);

        System.out.println(employeeConnor.getFirstName() + " " + employeeConnor.getLastName() + " " + employeeConnor.getId());
    }

    private static void LessonClassObjects(){
        //instantiating a new object
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Connor");
        myFirstPerson.setLastName("McEvoy");
        myFirstPerson.setTitle("Mr.");
        System.out.print(myFirstPerson.getTitle());
        System.out.print(myFirstPerson.getFirstName());
        System.out.print(myFirstPerson.getLastName());
        
        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Bob");
        mySecondPerson.setLastName("Beblebock");
        mySecondPerson.setTitle("Mr.");
        System.out.print(mySecondPerson.getTitle());
        System.out.print(mySecondPerson.getFirstName());
        System.out.print(mySecondPerson.getLastName());

        //setting value for super(inherited) class
        myFirstPerson.setId(3);
        System.out.println(myFirstPerson.getId());
    }
    private static void LessonExceptions() throws Exception {
        String firstNam3 = "Connor";
        try {
            int x3 = Integer.parseInt(firstNam3);
            System.out.print("Integer value: ");
            System.out.println(x3);
        } catch (Exception var2) {
            throw new Exception("A custom exception from LessonExceptions method.", var2);
        }
    }
    private static void LessonFlowControl() {
        String name = "Robert";
        if (name.equals("Connor")) {
            System.out.println("That's my name!");
        } else {
            System.out.println("That's not my name");
            if (name.length() == 6) {
                System.out.println("Right Length though");
            } else if (name.length() < 6) {
                System.out.println("Too short!");
            } else if (name.length() > 6) {
                System.out.println("Too Long");
            }
        }
        byte var2 = -1;
        switch(name.hashCode()) {
            case -1841845854:
                if (name.equals("Robert")) {
                    var2 = 2;
                }
                break;
            case 66965:
                if (name.equals("Bob")) {
                    var2 = 0;
                }
                break;
            case 79132860:
                if (name.equals("Robby")) {
                    var2 = 1;
                }
        }
        switch(var2) {
            case 0:
                System.out.println("You became a Bob");
                break;
            case 1:
                System.out.println("You're a Robby");
                break;
            case 2:
                System.out.println("You either die a Robert or live long enough to see yourself become a Bob");
                break;
            default:
                System.out.println("You are not named Robert");
        }
    }
    private static void LessonOperators() {
        int val = 10;
        System.out.println(val + 10);
        System.out.println(val - 5);
        int modVal = 10;
        System.out.println(modVal % 3);
        System.out.println("increment after: ");
        val = val + 1;
        System.out.println(val);
        System.out.println(val++);
        System.out.println(val++);
        System.out.println(val);
        val = 10;
        System.out.println("increment before: ");
        val = val + 1;
        System.out.println(val);
        ++val;
        System.out.println(val);
        ++val;
        System.out.println(val);
        val = 10;
        int anotherVal = 10;
        if (val == anotherVal) {
            System.out.println("Equal");
        } else if (val != anotherVal) {
            System.out.println("Not Equal");
        } else {
            System.out.println("What did you do wrong?");
        }
        if ((val != 10 || anotherVal != 20) && anotherVal != 10) {
            System.out.println("Not Equal");
        } else {
            System.out.println("Equal");
        }
        if (val != 10) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
    private static void LessonLists() {
        List<String> myStringCollection = new ArrayList();
        myStringCollection.add("1st String");
        myStringCollection.add("2nd String");
        myStringCollection.add("3rd String");
        myStringCollection.add("4th String");
        myStringCollection.add("5th String");
        System.out.println(myStringCollection);
        Iterator var1 = myStringCollection.iterator();
        while(var1.hasNext()) {
            String singleString = (String)var1.next();
            System.out.println(singleString);
        }
        List<Integer> myIntCollection = new ArrayList();
        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);
        System.out.println(myIntCollection);
        Iterator var8 = myIntCollection.iterator();
        while(var8.hasNext()) {
            Integer singleInt = (Integer)var8.next();
            System.out.println(singleInt);
        }
        String[] myStringArray = new String[]{"1st", "2nd", "3rd", "4th", "5th"};
        System.out.println(myStringArray);
        String[] var10 = myStringArray;
        int var4 = myStringArray.length;
        for(int var5 = 0; var5 < var4; ++var5) {
            String singleString = var10[var5];
            System.out.println(singleString);
        }
    }
    private static void LessonStrings() {
        String firstString = "";
        firstString = "something";
        firstString = null;
        if (firstString != null && !firstString.isEmpty()) {
            System.out.println("String has a value");
        } else {
            System.out.println("String is empty");
        }
        firstString = "another value";
        for(int x = 0; x <= 100; ++x) {
            firstString = "new value " + Integer.toString(x);
            System.out.println(firstString);
        }
        StringBuilder myStringBuilder = new StringBuilder();
        for(int x = 0; x <= 100; ++x) {
            myStringBuilder.append("new value with string builder ").append(Integer.toString(x)).append("\n");
        }
        System.out.println(myStringBuilder);
        String myName = "Connor";
        int indexOf = myName.indexOf("r");
        System.out.println(indexOf);
        int lastIndexOf = myName.lastIndexOf("o");
        System.out.println(lastIndexOf);
        String largeString = "This is a longer string";
        char[] var6 = largeString.toCharArray();
        int var7 = var6.length;
        for(int var8 = 0; var8 < var7; ++var8) {
            char c = var6[var8];
            System.out.println(c);
        }
        String partofLargeString = largeString.substring(8, 16);
        System.out.println(partofLargeString);
    }
    private static void LessonDataTypes() {
        boolean myBool = false;
        int myInt = 4;
        String myString = "some words";
        Date myDate = new Date();
        System.out.println(myBool);
        System.out.println(myInt);
        System.out.println(myString);
        System.out.println(myDate);
        String numberString = "341";
        int intFromString = Integer.parseInt(numberString);
        System.out.println(intFromString);
        int i = 312;
        String stringFromInt = Integer.toString(i);
        System.out.println(stringFromInt);
        String stringFromDate = myDate.toString();
        System.out.println(stringFromDate);
    }
    private static void LessonVariables() {
        String lastName = "McEvoy";
        String firstName = "Connor";
        String middleName = "Matthew";
        System.out.println(firstName + " " + middleName + " " + lastName);
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String input = reader.nextLine();
        System.out.println(input);
    }
}
