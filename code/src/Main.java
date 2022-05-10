import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner myscan = new Scanner(System.in);
    static Formula1ChampionshipManager fcm = new Formula1ChampionshipManager();
    static String reply1;
    static int reply2 = 0;

    public static void main(String[] args) throws IOException {
        System.out.print("Would you want to restore previous data ? (yes/no) : ");
        reply1 = myscan.nextLine();
        if (reply1.equalsIgnoreCase("yes")) {
            File myObj = new File("data.txt");
            if (myObj.exists()) {
                System.out.println("All data restored");
                Formula1Driver.restoreData();
                System.out.println();
            }
            else {
                System.out.println("Previous data doesn't exist\n");
            }
            start();

        } else if (reply1.equalsIgnoreCase("no")) {
            start();
            System.out.println();
        } else {
            System.out.println("Something went wrong, Try again");
        }
    }
    public static void start() throws IOException {

        do {
            while (true) {
                try {
                    fcm.Menu();
                    System.out.print("Enter the suitable number of your option - ");
                    reply2 = myscan.nextInt();
                    if (reply2 < 8) break;
                    else System.out.println("Invalid response, please try again\n");
                } catch (InputMismatchException e) {
                    System.out.println("Number format exception, please try again\n");
                    myscan.next();
                }
            }
            switch (reply2) {
                case 1 -> Formula1Driver.createNewDriver();
                case 2 -> Formula1Driver.deleteDriver();
                case 3 -> Formula1Driver.changeDriver();
                case 4 -> Formula1Driver.displayStatistics();
                case 5 -> Formula1Driver.displayTable();
                case 6 -> fcm.nameList();
                case 7 -> GUI.guiMenu();
                case 0 -> Formula1Driver.exit();
            }
        }
        while (reply2 != 0);
    }
 }

