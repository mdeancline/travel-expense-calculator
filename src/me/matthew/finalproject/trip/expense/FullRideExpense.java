package me.matthew.finalproject.trip.expense;

public class FullRideExpense implements Expense {
    private final double factor;
    private final double maxAmountPerFactor;

    public FullRideExpense(final double factor, final double maxAmountPerFactor) {
        this.factor = factor;
        this.maxAmountPerFactor = maxAmountPerFactor;
    }

    public FullRideExpense(final double maxAmountPerFactor) {
        this(0, maxAmountPerFactor);
    }

    @Override
    public double getAmount(final double days) {
        return (factor == 0 ? days : factor) * maxAmountPerFactor;
    }

    @Override
    public double getReimbursableAmount(final double days) {
        return getAmount(days);
    }
}
