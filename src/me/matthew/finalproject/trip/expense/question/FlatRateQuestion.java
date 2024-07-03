package me.matthew.finalproject.trip.expense.question;

import me.matthew.finalproject.trip.expense.Expense;
import me.matthew.finalproject.trip.expense.FlatRateExpense;

public class FlatRateQuestion extends AbstractTripQuestion {
    public FlatRateQuestion(final String text) {
        super(text);
    }

    @Override
    protected Expense askExpense(final double input) {
        return new FlatRateExpense(input);
    }
}
