import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TenderService ts = new TenderService();
        BidService bs = new BidService();

        while (true) {
            System.out.println("\n1. Admin\n2. Vendor\n3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("1. Add Tender\n2. View Tenders\n3. View Bids");
                int ch = sc.nextInt();

                if (ch == 1) {
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
                }
                else if (ch == 2) ts.viewTenders();
                else if (ch == 3) bs.viewBids();
            }

            else if (choice == 2) {
                System.out.println("1. View Tenders\n2. Place Bid");
                int ch = sc.nextInt();

                if (ch == 1) ts.viewTenders();

                else if (ch == 2) {
                    System.out.print("Enter Tender ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Vendor Name: ");
                    String name = sc.nextLine();

                    System.out.print("Bid Amount: ");
                    double amt = sc.nextDouble();

                    bs.placeBid(new Bid(tid, name, amt));
                }
            }

            else break;
        }
    }
}
