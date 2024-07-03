package me.matthew.finalproject.trip;

import me.matthew.finalproject.trip.expense.Expense;

import java.util.Collection;
import java.util.Objects;

public final class Trip {
    private final Collection<Expense> expenses;
    private final double days;

    Trip(final Collection<Expense> expenses, final double days) {
        this.expenses = Objects.requireNonNull(expenses);
        this.days = days;
    }

    public double getTotalExpenses() {
        double expensesAmount = 0;

        for (final Expense expense : expenses)
            expensesAmount += expense.getAmount(days);

        return expensesAmount;
    }

    public double getTotalReimbursableExpenses() {
        double allowedExpenses = 0;

        for (final Expense expense : expenses)
            allowedExpenses += expense.getReimbursableAmount(days);

        return allowedExpenses;
    }
}
