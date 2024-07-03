package me.matthew.finalproject.trip.expense;

public class TotalExpense implements Expense {
    private final double totalAmount;
    private final double maxAmountPerDay;

    public TotalExpense(final double totalAmount, final double maxAmountPerDay) {
        this.totalAmount = totalAmount;
        this.maxAmountPerDay = maxAmountPerDay;
    }

    @Override
    public double getAmount(final double days) {
        return totalAmount;
    }

    @Override
    public double getReimbursableAmount(final double days) {
        return Math.min(totalAmount, maxAmountPerDay * days);
    }
}
