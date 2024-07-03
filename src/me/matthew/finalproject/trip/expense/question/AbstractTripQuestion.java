package me.matthew.finalproject.trip.expense.question;

import me.matthew.finalproject.trip.TripInputs;
import me.matthew.finalproject.trip.expense.Expense;

import java.util.Objects;
import java.util.Scanner;

public abstract class AbstractTripQuestion implements TripQuestion {
    private final String text;

    protected AbstractTripQuestion(final String text) {
        this.text = text;
    }

    @Override
    public final Expense ask(final Scanner scanner) {
        System.out.print(text + " ");

        final double input = TripInputs.getLegitimateInput(scanner);
        return Objects.requireNonNull(askExpense(input));
    }

    protected abstract Expense askExpense(final double input);
}
