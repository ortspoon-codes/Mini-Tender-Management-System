import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TenderService ts = new TenderService();

        while (true) {
            System.out.println("\n1. Add Tender\n2. View Tenders\n3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Description: ");
                String desc = sc.nextLine();

                System.out.print("Deadline: ");
                String dl = sc.nextLine();

                ts.addTender(new Tender(id, title, desc, dl));
            } else if (choice == 2) {
                ts.viewTenders();
            } else {
                break;
            }
        }
    }
}
