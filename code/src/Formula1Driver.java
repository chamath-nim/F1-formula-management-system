import java.io.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Formula1Driver extends Driver {

    int point;
    ArrayList<String> data;
    ArrayList<Integer> positionData;
    String date;
    ArrayList<String> namePosList;
    static Scanner myscan = new Scanner(System.in);

    public Formula1Driver(){}
    public Formula1Driver(String date,ArrayList<String> namePosList){
        this.date = date;
        this.namePosList = namePosList;
    }
    public Formula1Driver(int point,ArrayList<String> data,ArrayList<Integer> positionData){
        this.point = point;
        this.data = data;
        this.positionData = positionData;
    }

    /*  add a new F1 driver to championship
        @store data: driver name, driver team, driver, driver location.
         to a 2d arrylist
    */
    public static void createNewDriver(){
        System.out.print("Enter the driver's name : ");
        String name = myscan.nextLine().toUpperCase();
        System.out.print("Enter driver's team : ");
        String team = myscan.nextLine().toUpperCase();
        System.out.print("Enter driver's location : ");
        String location = myscan.nextLine().toUpperCase();

        getDataList().add(new ArrayList<>(Arrays.asList(name, team, location)));
        getPointList().add(0);
        getPositions().add(new ArrayList<>(Arrays.asList(0,0,0)));
    }


    /* delete a Fi driver from championship
       @delete all details of a selected driver
     */
    public static void deleteDriver() {
      System.out.print("Enter the driver's name : ");
      String name = myscan.nextLine().toUpperCase();
        int count = 0;
        boolean entry = false;
        for (ArrayList<String> list : getDataList()) {
            if (list.contains(name)){
                entry = true;
                break;
            }
            count++;
        }
        if (entry) {
            getDataList().remove(count);
            getPointList().remove(count);
            getPositions().remove(count);
        }
        else System.out.println("\nInput is not compatible\n");
    }


    /*  Change the driver for an existing constructor team
        @user is allowed to change driver's name and location
     */
    public static void changeDriver() {
        System.out.print("Enter the driver's team to change the driver : ");
        String name = myscan.nextLine().toUpperCase();
        System.out.print("Enter the new driver's name : ");
        String drName = myscan.nextLine().toUpperCase();
        System.out.print("Enter new driver's loction : ");
        String drLocation = myscan.nextLine().toUpperCase();
        int count = 0;
        boolean change = true;
        for (ArrayList<String> list : getDataList()) {
            if (list.contains(name)) {
                getDataList().get(count).set(0, drName);
                getDataList().get(count).set(2, drLocation);
                change = false;
                break;
            }
            count++;
        }
        if (change) System.out.println("\nInput current driver's name is not compatible, Try again.\n");
    }


    /*
        Display the various statistics for a selected existing driver
        @points,driver,team,location,no 1st 2nd 3rd positions
     */
    public static void displayStatistics(){

        System.out.print("Enter the driver's name : ");
        String name = myscan.nextLine().toUpperCase();
        int count = 0;
        boolean entry = true;
        for (ArrayList<String> list : getDataList()) {
            if (list.contains(name)) {
                System.out.println("Driver            : " + getDataList().get(count).get(0) +
                        "\nTeam              : " + getDataList().get(count).get(1) +
                        "\nLocation          : " + getDataList().get(count).get(2) +
                        "\nTotal Points      : " + getPointList().get(count) +
                        "\nFirst Positions   : " + getPositions().get(count).get(0) +
                        "\nSecond Positions  : " + getPositions().get(count).get(1) +
                        "\nThird Positions   : " + getPositions().get(count).get(2) + "\n" );
                entry = false;
                break;
            }
            count++;
        }
        if (entry) System.out.println("\nInput is not compatible\n");

    }

    /*
        method for sort drivers according to the points
        @Descending order
     */
    public static ArrayList<Formula1Driver> sortByPoints() {
        ArrayList<Formula1Driver> myarray = new ArrayList<>();

        for (int i = 0; i < getDataList().size(); i++) {
            myarray.add(new Formula1Driver(getPointList().get(i), getDataList().get(i), getPositions().get(i)));
        }
        myarray.sort(new sortByPoints());
        return myarray;
    }

    /*
        method for sort drivers according to the 1st positions
        @Descending order
     */
    public static ArrayList<Formula1Driver> sortByPositions(){
        ArrayList<Formula1Driver> myarray = new ArrayList<>();

        for (int i = 0; i < getDataList().size(); i++) {
            myarray.add(new Formula1Driver(getPointList().get(i), getDataList().get(i), getPositions().get(i)));
        }
        myarray.sort(new sortByPosition());
        return myarray;
    }

    /*
        method for sort races according to the dates
        @ascending order
     */
    public static ArrayList<Formula1Driver> sortByDate(){
        ArrayList<Formula1Driver> myarray = new ArrayList<>();

        for (int i = 0; i < getDates().size(); i++) {
            myarray.add(new Formula1Driver(getDates().get(i),getRace().get(i)));
        }
        myarray.sort(new sortByDate());
        return myarray;
    }

    /*
        display sorted point table
        @Descending order according to the points
     */
    public static void displayTable(){
        ArrayList<Formula1Driver> myarray = sortByPoints();
        String format = "| %-6s | %-10s | %-10s | %-10s | %-3s | %-3s | %-3s |";

        System.out.println("-------------------------------------------------------------------");
        System.out.printf(format,"Points","Driver","Team","Location","1st","2nd","3rd");
        System.out.println("\n-------------------------------------------------------------------");
        for (Formula1Driver dr : myarray){
            System.out.printf(format,dr.point,dr.data.get(0),dr.data.get(1),dr.data.get(2),
                    dr.positionData.get(0),dr.positionData.get(1),dr.positionData.get(2));
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------\n");
    }


    /*
        add positions and points to drivers
        @add points to current total of points
        @add 1st 2nd 3rd position to current number of positions
     */
    public static void addRace( ArrayList<String> positionNames ) {

        int num = 1;
        for (int i = 1; i <= positionNames.size(); i++) {
            int points;
            int count = 0;

            for (ArrayList<String> list1 : getDataList()) {

                switch (num) {
                    case 1 -> points = 25;
                    case 2 -> points = 18;
                    case 3 -> points = 15;
                    case 4 -> points = 12;
                    case 5 -> points = 10;
                    case 6 -> points = 8;
                    case 7 -> points = 6;
                    case 8 -> points = 4;
                    case 9 -> points = 2;
                    case 10 -> points = 1;
                    default -> points = 0;
                }
                if (list1.contains(positionNames.get(num-1))) {
                    if (num == 1) {
                        int sum1 = getPositions().get(count).get(0) + 1;
                        getPositions().get(count).set(0, sum1);
                    }
                    if (num == 2) {
                        int sum1 = getPositions().get(count).get(1) + 1;
                        getPositions().get(count).set(1, sum1);
                    }
                    if (num == 3) {
                        int sum1 = getPositions().get(count).get(2) + 1;
                        getPositions().get(count).set(2, sum1);
                    }

                    int sum2 = getPointList().get(count) + points;
                    getPointList().set(count, sum2);
                    num++;
                    break;
                }
                count++;
            }
        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        getDates().add(formattedDate);
        getRace().add(positionNames);
    }

    /*
        store all data in system to text file
        @data: driver details, points, positions, race details(data & time)
     */
    public static void exit() throws IOException {
        try {
            File myObj = new File("data.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName()+"\nAll data stored");
            } else {
                System.out.println("All data stored");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter mywriter = new FileWriter("data.txt");
        mywriter.write(getDataList().size()+"\n");
        for ( int list1 : getPointList()){
            mywriter.write(list1+"\n");
        }

        for (ArrayList<Integer> list2: getPositions()){
            for (int num : list2){
                mywriter.write(num+"\n");
            }
        }

        for (ArrayList<String> list3 : getDataList()){
            for (String data : list3){
                mywriter.write(data+"\n");
            }
        }
        mywriter.write(getDates().size()+"\n");
        for (String date : getDates()){
            mywriter.write(date+"\n");
        }
        for (ArrayList<String> list : getRace()){
            mywriter.write(list.size()+"\n");
            for (String name : list){
                mywriter.write(name+"\n");
            }
        }
        mywriter.close();
    }

    /*
        restore all data from the text file
        @retrieve all data back to arraylists
     */
    public static void restoreData(){
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            int count = myReader.nextInt();

            for (int i = 0; i<count; i++){
                getPointList().add(myReader.nextInt());
            }
            for (int j = 0; j<count; j++){
                ArrayList<Integer> subList1 = new ArrayList<>();
                for (int k = 0; k<3; k++){
                    subList1.add(myReader.nextInt());
                }
                getPositions().add(subList1);
            }
            for (int h = 0; h<count; h++){

                ArrayList<String> subList2 = new ArrayList<>();
                int z = 0;
                while (z<3){
                    String s = myReader.nextLine();
                    if (s.length()>0){
                        subList2.add(s);
                        z++;
                    }
                }
                getDataList().add(subList2);
            }

            int countDate = myReader.nextInt();
            myReader.nextLine();
            for (int i = 0; i<countDate; i++){
                getDates().add(myReader.nextLine());
            }

            for (int j = 0; j< getDates().size(); j++){
                int z = myReader.nextInt();
                myReader.nextLine();
                ArrayList<String> namePos = new ArrayList<>();
                for (int x = 0; x<z; x++){
                    namePos.add(myReader.nextLine());
                }
                getRace().add(namePos);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(getRace());
    }

}



