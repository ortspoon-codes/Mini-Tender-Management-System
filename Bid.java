class Bid {
    int tenderId;
    String vendorName;
    double amount;

    public Bid(int tenderId, String vendorName, double amount) {
        this.tenderId = tenderId;
        this.vendorName = vendorName;
        this.amount = amount;
    }
}
