import java.io.*;
import java.util.*;
public class Theatre {

    private static final int[] Row1 = new int[12];
    private static final int[] Row2 = new int[16];           // Arrays for each row.
    private static final int[] Row3 = new int[20];
    private static final ArrayList<Ticket> tickets = new ArrayList<>();       //Arraylist

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");

        while(true) {
            int n = 60;
            for(int i=0;i<=n;i++)
            {
                System.out.print("-");
            }
            System.out.println();

            System.out.println("Please select an option : ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");                             // Main menu
            System.out.println("4) List available seat");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort ticket by price");
            System.out.println("     0) Quit");

            for(int i=0;i<=n;i++)
            {
                System.out.print("-");
            }
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Enter Option: ");
                int option = scanner.nextInt();


                switch (option) {
                    case 1 -> buy_ticket();
                    case 2 -> print_seating_area();
                    case 3 -> cancel_ticket();
                    case 4 -> show_available();
                    case 5 -> save();                         //Method list
                    case 6 -> load();
                    case 7 -> show_tickets_info();
                    case 8 -> sort_tickets();
                    case 0 -> {
                        System.out.println("Thank you");
                        System.exit(0);
                        scanner.close();
                    }
                    default -> System.out.println(option + " is not a valid option");
                }
            }
            catch (Exception e){
                System.out.println("Invalid Input");         //Execute invalid option
            }

        }


    }
    public static void buy_ticket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String firstName = scanner.next();
        System.out.print("Enter your surname: ");
        String surname = scanner.next();
        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter your price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter the row number: ");
        int row_num = scanner.nextInt();
        System.out.print("Enter the seat number: ");
        int seat_num = scanner.nextInt();

        if ((row_num == 1) && (seat_num < 13) && (seat_num > 0)) {       //Row 1 booking conditions
            if (Row1[seat_num - 1] == 0) {
                Row1[seat_num - 1] = 1;
                System.out.println("Booking Successful..!!!");
            } else {
                System.out.println("It's already booked");
            }

        } else if ((row_num == 2) && (seat_num < 17) && (seat_num > 0)) {       //Row 2 booking conditions
            if (Row2[seat_num - 1] == 0) {
                Row2[seat_num - 1] = 1;
                System.out.println("Booking Successful..!!!");
            } else {
                System.out.println("It's already booked");
            }
        } else if ((row_num == 3) && (seat_num < 21) && (seat_num > 0)) {      //Row 3 booking conditions
            if (Row3[seat_num - 1] == 0) {
                Row3[seat_num - 1] = 1;
                System.out.println("Booking Successful..!!!");
            } else {
                System.out.println("It's already booked");
            }
        } else {
            System.out.println("wrong input");
        }

        Person person = new Person(firstName, surname, email);
        Ticket ticket = new Ticket(row_num, seat_num, price, person);      //add ticket details to the arraylist
        tickets.add(ticket);
    }
    public static void print_seating_area() {
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");           //print stage
        System.out.println("     ***********");
        for (int i = 0; i < Row1.length; i++){
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }

            if (Row1[i] == 0) {
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int i = 0; i < Row2.length; i++){
            if (i == 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (Row2[i] == 0) {
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();
        for (int i = 0; i < Row3.length; i++){
            if (i == 10) {
                System.out.print(" ");
            }
            if (Row3[i] == 0) {
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();
    }

    public static void cancel_ticket() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row number: ");
        int row_num = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seat_num = scanner.nextInt();

        if ((row_num==1) && (seat_num<13) && (seat_num>0)) {            //row 1 seat cancellation
            if(Row1[seat_num - 1] == 1) {
                Row1[seat_num - 1] = 0;
                System.out.println("Cancellation successful..!!");
            }
            else {
                System.out.println("Seat already not booked");
            }

        } else if ((row_num==2) && (seat_num<17) && (seat_num>0)) {        //row 2 seat cancellation
            if(Row2[seat_num - 1] == 1) {
                Row2[seat_num - 1] = 0;
                System.out.println("Cancellation successful..!!");
            }
            else {
                System.out.println("Seat already not booked");
            }
        } else if ((row_num==3) && (seat_num<21) && (seat_num>0)) {     //row 3 seat cancellation
            if(Row3[seat_num - 1] == 1) {
                Row3[seat_num - 1] = 0;
                System.out.println("Cancellation successful..!!");
            }
            else {
                System.out.println("Seat already not booked");
            }
        } else {
            System.out.println("Invalid input");
        }
        tickets.removeIf(ticket -> row_num == ticket.getRow_num() && seat_num == ticket.getSeat_num());
    }                                                                        //Remove details from arraylist

    public static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < Row1.length; i++){
            if (Row1[i] == 0) {                                  //show seats from row 1 array
                System.out.print(i+1 + ",");
            }
        }
        System.out.println("\b");
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < Row2.length; i++){                   //show seats from row 2 array
            if (Row2[i] == 0) {
                System.out.print(i+1 + ",");
            }
        }
        System.out.println("\b");
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < Row3.length; i++){
            if (Row3[i] == 0) {                                  //show seats from row 3 array
                System.out.print(i+1 + ",");
            }
        }
        System.out.println("\b");
        System.out.println();
    }

    public static void save() {
        try {
            FileWriter myWriter = new FileWriter("row's_information.txt");  //Opening the file
            myWriter.write(Arrays.toString(Row1) + "\n");
            myWriter.write(Arrays.toString(Row2) + "\n");
            myWriter.write(Arrays.toString(Row3));
            myWriter.close();                                              //Saving to the file
            System.out.println("Successfully wrote to the file..!!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void load() {
        try {
            File myObj = new File("row's_information.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();                      //Load from the file
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void show_tickets_info() {
        for (Ticket ticket : tickets) {           // info of ticket
            ticket.print();
        }
        double sum = 0;
        for (Ticket ticket : tickets){
            sum = sum + ticket.getPrice();             //total of the price
        }
        System.out.println("Total price : " + sum);
    }

    public static void sort_tickets() {
        ArrayList<Ticket> sortedArray = tickets;

        for (int i = 0; i <sortedArray.size(); i++) {
            for (int j = i + 1; j< sortedArray.size(); j++) {
                if(sortedArray.get(i).getPrice() > sortedArray.get(j).getPrice()) {
                    Ticket temp = sortedArray.get(i);
                    sortedArray.set(i, sortedArray.get(j));
                    sortedArray.set(j, temp);                               //Sorting the arraylist with the price
                }
            }
        }

        for (Ticket ticket : sortedArray) {
            ticket.print();
        }
    }

}

