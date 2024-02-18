public class Ticket {
    int row_num;
    int seat_num;
    double price;
    Person person;

    public Ticket(int row_num, int seat_num, double price, Person person) {
        this.row_num = row_num;
        this.seat_num = seat_num;
        this.price = price;
        this.person = person;
    }

    public void print() {
        System.out.print("Name : " + this.person.name + ", ");
        System.out.print("Surname : " + this.person.surname + ", ");
        System.out.print("Email : " + this.person.email + ", ");       //print information of tickets
        System.out.print("Row No. : " + this.row_num + ", ");
        System.out.print("Seat No. : " + this.seat_num + ", ");
        System.out.println("Price : " + this.price);
    }

    public int getRow_num() {
        return this.row_num;
    }
    public int getSeat_num() {
        return this.seat_num;
    }
    public double getPrice() {
        return this.price;
    }
}
