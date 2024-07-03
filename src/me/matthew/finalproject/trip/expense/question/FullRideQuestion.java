package me.matthew.finalproject.trip.expense.question;

import me.matthew.finalproject.trip.expense.Expense;
import me.matthew.finalproject.trip.expense.FullRideExpense;

public class FullRideQuestion extends AbstractTripQuestion {
    private final double amountPerFactor;

    public FullRideQuestion(final String text, final double amountPerFactor) {
        super(text);
        this.amountPerFactor = amountPerFactor;
    }

    @Override
    protected Expense askExpense(final double input) {
        return new FullRideExpense(input, amountPerFactor);
    }
}
