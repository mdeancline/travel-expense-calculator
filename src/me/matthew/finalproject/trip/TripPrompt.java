package me.matthew.finalproject.trip;

import me.matthew.finalproject.trip.expense.Expense;
import me.matthew.finalproject.trip.expense.question.TripQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TripPrompt {
    private final List<TripQuestion> questions = new LinkedList<>();
    private final List<Expense> knownExpenses = new LinkedList<>();
    private final Scanner scanner;
    private final String daysQuestionText;

    public TripPrompt(final Scanner scanner, final String daysQuestionText) {
        this.scanner = scanner;
        this.daysQuestionText = daysQuestionText;
    }

    public Trip start() {
        final List<Expense> expenses = new ArrayList<>(questions.size() + knownExpenses.size());
        expenses.addAll(knownExpenses);

        System.out.print(daysQuestionText + " ");
        final double days = TripInputs.getLegitimateInput(scanner);

        for (final TripQuestion question : questions)
            expenses.add(question.ask(scanner));

        return new Trip(expenses, days);
    }

    public void addQuestion(final TripQuestion question) {
        questions.add(question);
    }

    public void addKnownExpense(final Expense expense) {
        knownExpenses.add(expense);
    }
}
