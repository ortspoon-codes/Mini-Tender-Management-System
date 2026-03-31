import java.io.*;

class BidService {
    public void findLowestBid(int tenderId) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("bids.txt"));
            String line;

            double min = Double.MAX_VALUE;
            String winner = "";
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] b = line.split(",");

                int id = Integer.parseInt(b[0].trim());
                String name = b[1].trim();
                double amt = Double.parseDouble(b[2].trim());

                if (id == tenderId) {
                    found = true;

                    if (amt < min) {
                        min = amt;
                        winner = name;
                    }
                }
            }

            br.close();

            if (!found) {
                System.out.println("No bids found for this tender.");
            } else {
                System.out.println("Winner: " + winner + " with lowest bid: " + min);
            }

        } catch (Exception e) {
            System.out.println("Error finding winner");
        }
    }

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