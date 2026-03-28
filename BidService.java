public void findLowestBid(int tenderId) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("bids.txt"));
        String line;

        double min = Double.MAX_VALUE;
        String winner = "";

        while ((line = br.readLine()) != null) {
            String[] b = line.split(",");

            if (Integer.parseInt(b[0]) == tenderId) {
                double amt = Double.parseDouble(b[2]);

                if (amt < min) {
                    min = amt;
                    winner = b[1];
                }
            }
        }

        br.close();

        if (!winner.equals("")) {
            System.out.println("Winner: " + winner + " with bid: " + min);
        } else {
            System.out.println("No bids found for this tender.");
        }

    } catch (Exception e) {
        System.out.println("Error finding winner");
    }
}
