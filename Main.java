import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TenderService ts = new TenderService();
        BidService bs = new BidService();

        while (true) {
            System.out.println("\n===== MINI TENDER SYSTEM =====");
            System.out.println("1. Admin");
            System.out.println("2. Vendor");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // ADMIN SECTION
            if (choice == 1) {

                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. Add Tender");
                System.out.println("2. View Tenders");
                System.out.println("3. View Bids");
                System.out.println("4. Find Winner");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    System.out.print("Enter Tender ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Deadline: ");
                    String dl = sc.nextLine();

                    ts.addTender(new Tender(id, title, desc, dl));
                }

                else if (ch == 2) {
                    ts.viewTenders();
                }

                else if (ch == 3) {
                    bs.viewBids();
                }

                else if (ch == 4) {
                    System.out.print("Enter Tender ID: ");
                    int tid = sc.nextInt();
                    bs.findLowestBid(tid);
                }

                else {
                    System.out.println("Invalid choice");
                }
            }

            // VENDOR SECTION
            else if (choice == 2) {

                System.out.println("\n--- VENDOR MENU ---");
                System.out.println("1. View Tenders");
                System.out.println("2. Place Bid");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    ts.viewTenders();
                }

                else if (ch == 2) {
                    System.out.print("Enter Tender ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Vendor Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Bid Amount: ");
                    double amt = sc.nextDouble();

                    if (amt <= 0) {
                        System.out.println("Invalid amount");
                    } else {
                        bs.placeBid(new Bid(tid, name, amt));
                    }
                }

                else {
                    System.out.println("Invalid choice");
                }
            }

            // EXIT
            else if (choice == 3) {
                System.out.println("Exiting system...");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
