package interview.UtilPackages;

import java.time.LocalDate;

public class Transaction {
    private final int transactionId;
    private final double amount;
    private final LocalDate date;

    public Transaction(int transactionId, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + transactionId
                + ", amount=" + amount
                + ", date=" + date + "}";
    }
}