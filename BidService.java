import java.io.*;

class BidService {

    public void placeBid(Bid b) {
        try {
            FileWriter fw = new FileWriter("bids.txt", true);
            fw.write(b.tenderId + "," + b.vendorName + "," + b.amount + "\n");
            fw.close();
            System.out.println("Bid placed successfully!");
        } catch (Exception e) {
            System.out.println("Error placing bid");
        }
    }

    public void viewBids() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("bids.txt"));
            String line;

            System.out.println("\n--- Bids ---");

            while ((line = br.readLine()) != null) {
                String[] b = line.split(",");
                System.out.println("Tender ID: " + b[0] + " | Vendor: " + b[1] + " | Amount: " + b[2]);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("No bids found");
        }
    }
}
