import java.io.*;

class TenderService {

    public void addTender(Tender t) {
        try {
            FileWriter fw = new FileWriter("tenders.txt", true);
            fw.write(t.id + "," + t.title + "," + t.description + "," + t.deadline + "\n");
            fw.close();
            System.out.println("Tender added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding tender");
        }
    }

    public void viewTenders() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("tenders.txt"));
            String line;

            System.out.println("\n--- Tenders ---");

            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                System.out.println("ID: " + t[0] + " | " + t[1] + " | Deadline: " + t[3]);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("No tenders found");
        }
    }
}
