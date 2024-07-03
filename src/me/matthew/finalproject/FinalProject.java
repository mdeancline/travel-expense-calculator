package me.matthew.finalproject;

import me.matthew.finalproject.trip.Trip;
import me.matthew.finalproject.trip.TripPrompt;
import me.matthew.finalproject.trip.expense.FullRideExpense;
import me.matthew.finalproject.trip.expense.question.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public final class FinalProject {
    private static final double MEAL_COST_PER_DAY = 37;
    private static final double PARKING_FEES_PER_DAY = 10;
    private static final double TAXI_FEES_PER_DAY = 20;
    private static final double LODGING_FEES_PER_DAY = 95;
    private static final double AMOUNT_PER_MILE = .27;

    public static void main(final String[] args) {
        final List<Trip> trips = new ArrayList<>();

        boolean hasMultipleTrips = true;

        while (hasMultipleTrips) {
            final Scanner keyboard = new Scanner(System.in);

            final TripPrompt prompt = new TripPrompt(keyboard, "Number of days on the trip:");
            prompt.addQuestion(new FlatRateQuestion("Amount of airfare:"));
            prompt.addQuestion(new FlatRateQuestion("Amount of car rental:"));
            prompt.addQuestion(new FullRideQuestion("Miles driven (if a private vehicle was used):", AMOUNT_PER_MILE));
            prompt.addQuestion(new NormalQuestion("Parking fees:", PARKING_FEES_PER_DAY));
            prompt.addQuestion(new NormalQuestion("Taxi fees:", TAXI_FEES_PER_DAY));
            prompt.addQuestion(new FlatRateQuestion("Conference registration fees:"));
            prompt.addQuestion(new NormalQuestion("Lodging charges per night:", LODGING_FEES_PER_DAY, true));

            prompt.addKnownExpense(new FullRideExpense(MEAL_COST_PER_DAY));

            trips.add(prompt.start());

            System.out.println("Another trip? Type y if so. Otherwise, type anything else: ");
            final String anotherTripChoice = keyboard.next();

            hasMultipleTrips = !anotherTripChoice.isEmpty() && anotherTripChoice.toLowerCase().charAt(0) == 'y';
        }

        System.out.println();
        displayExpenses(trips);
    }

    private static void displayExpenses(final Collection<Trip> trips) {
        double totalExpenses = 0, totalAllowedExpenses = 0;

        for (final Trip trip : trips) {
            totalExpenses += trip.getTotalExpenses();
            totalAllowedExpenses += trip.getTotalReimbursableExpenses();
        }

        printExpenses(totalExpenses, totalAllowedExpenses);
    }

    private static void printExpenses(final double totalExpenses, final double totalAllowedExpenses) {
        System.out.printf("Total spent: $%,.2f\n", totalExpenses);
        System.out.printf("Total allowable: $%,.2f\n", totalAllowedExpenses);
        System.out.printf("Excess amount: $%,.2f\n", totalAllowedExpenses - totalExpenses);
        System.out.printf("Saved amount: $%,.2f\n", Math.max(0, totalAllowedExpenses - totalExpenses));
    }
}
