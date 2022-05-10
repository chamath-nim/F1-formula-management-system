import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    static Scanner myscan = new Scanner(System.in);

    /*
        show a menu to user to chose the method
     */
    @Override
    public void Menu() {
        System.out.println("""
                -----------------------------MENU------------------------------
                Enter 1 - Create a new driver
                Enter 2 - Delete a driver and the team
                Enter 3 - Change the driver for an existing constructor team
                Enter 4 - Display the statistics for a selected existing driver
                Enter 5 - Display the Formula 1 Driver Table
                Enter 6 - Add a completed race
                Enter 7 - Display the GUI
                Enter 0 - Exit
                ---------------------------------------------------------------
                """);
    }

    /*
        method for get all names, who have
        particpated in the race
     */
    @Override
    public void nameList(){
        int quantity ;
        int i = 1;
        ArrayList<String> names = new ArrayList<>();

        try {
            System.out.print("How many drivers have competed ? : ");
            quantity = myscan.nextInt();
            myscan.nextLine();

            while (i <= quantity){
                boolean check1 = true;

                System.out.print("Enter the name of position " + i + " : ");
                String nameOfPosition = myscan.nextLine().toUpperCase();

                for (ArrayList<String> list : Formula1Driver.getDataList()){
                    if (list.contains(nameOfPosition)){
                        names.add(nameOfPosition);
                        check1 = false;
                        i++;
                        break;
                    }
                }
                if (check1){
                    System.out.println("Input driver doesn't exist, Try again\n");
                }
            }

        } catch (InputMismatchException e) {
            System.out.print("Number format exception, please try again\n");
            myscan.nextLine();
        }
        Formula1Driver.addRace(names);
    }

    /*
        randomly generate starting positions and end positios
        @for actions.window4()
     */
    @Override
    public String[][] nameListR(){
        String[][] nameArray = new String[Formula1Driver.getDataList().size()][3];
        ArrayList<String> randomName = new ArrayList<>();

        for (int i = 1; i<=Formula1Driver.getDataList().size(); i++){
            nameArray[i-1][0] = "Position "+i;
        }
        for (ArrayList<String> list : Formula1Driver.getDataList()){
            randomName.add(list.get(0));
        }
        Collections.shuffle(randomName);
        int count1 = 0;
        for (String name1 : randomName){
            nameArray[count1][1] = name1;
            count1++;
        }

        int count2 = 0;
        Collections.shuffle(randomName);
        for (String name2 : randomName){
            nameArray[count2][2] = name2;
            count2++;
        }

        Formula1Driver.addRace(randomName);
        return nameArray;
    }

    /*
        parse details of races that a given driver participated
        @race date and position driver has taken in that race
     */
    @Override
    public String[][] details(String n){
        ArrayList<ArrayList<String>> myArray = new ArrayList<>();
        for (int i = 0; i<Formula1Driver.getDates().size(); i++){
            if (Formula1Driver.getRace().get(i).contains(n)){
                myArray.add(new ArrayList<>(Arrays.asList(Formula1Driver.getDates().get(i),
                        "Position "+index(n,i))));
            }
        }
        String[][] array = new String[myArray.size()][2];
        for (int i = 0; i < myArray.size(); i++) {
            ArrayList<String> row = myArray.get(i);
            array[i] = row.toArray(new String[0]);
        }
        return array;


    }
    @Override
    public int index(String name, int x){
        int count = 1;
        for (String n : Formula1Driver.getRace().get(x)){
            if (n.equalsIgnoreCase(name))break;
            count++;
        }
        return count;
    }
}

