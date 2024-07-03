package me.matthew.finalproject.trip.expense;

public class PerDayExpense implements Expense {
    private final double amountPerDay;
    private final double maxAmountPerDay;

    public PerDayExpense(final double amountPerDay, final double maxAmountPerDay) {
        this.amountPerDay = amountPerDay;
        this.maxAmountPerDay = maxAmountPerDay;
    }

    @Override
    public double getAmount(final double days) {
        return amountPerDay * days;
    }

    @Override
    public double getReimbursableAmount(final double days) {
        return Math.min(getAmount(days), maxAmountPerDay * days);
    }
}
