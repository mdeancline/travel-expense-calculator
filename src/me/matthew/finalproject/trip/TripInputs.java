package me.matthew.finalproject.trip;

import java.util.Scanner;

public final class TripInputs {
    private TripInputs() {
        throw new AssertionError();
    }

    public static double getLegitimateInput(final Scanner scanner) {
        double input;

        do {
            input = getNumericInput(scanner);
            if (input > 0) break;
            System.out.println("Value must not be less than 0. Try again: ");
        } while (true);

        return input;
    }

    private static double getNumericInput(final Scanner scanner) {
        try {
            return Double.parseDouble(scanner.next());
        } catch (final NumberFormatException ignored) {
            System.out.println("Value must be a number. Try again: ");
            return getNumericInput(scanner);
        }
    }
}
