package me.matthew.finalproject.trip.expense.question;

import me.matthew.finalproject.trip.expense.Expense;
import me.matthew.finalproject.trip.expense.PerDayExpense;
import me.matthew.finalproject.trip.expense.TotalExpense;

public class NormalQuestion extends AbstractTripQuestion {
    private final double maxAmountPerDay;
    private final boolean isPerDayBasis;

    public NormalQuestion(final String text, final double maxAmountPerDay, final boolean isPerDayBasis) {
        super(text);
        this.maxAmountPerDay = maxAmountPerDay;
        this.isPerDayBasis = isPerDayBasis;
    }

    public NormalQuestion(final String text, final double maxAmountPerDay) {
        this(text, maxAmountPerDay, false);
    }

    @Override
    protected Expense askExpense(final double input) {
        return isPerDayBasis ? new PerDayExpense(input, maxAmountPerDay) : new TotalExpense(input, maxAmountPerDay);
    }
}
