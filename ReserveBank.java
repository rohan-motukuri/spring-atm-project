interface ReserveBank {

    void createAccount ();
    void getAccountDetails ();
    void debit (double x, long y);
    void credit (double x);
    double getBalance ();
    void applyLoan ();

    // Any future updates have to first start with modifications from interfaces.
    // For example, For netbanking a different interface is maintained

}

