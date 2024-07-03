package me.matthew.finalproject.trip.expense;

public class FlatRateExpense implements Expense {
    private final double amount;

    public FlatRateExpense(final double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount(final double days) {
        return amount;
    }

    @Override
    public double getReimbursableAmount(final double days) {
        return amount;
    }
}
