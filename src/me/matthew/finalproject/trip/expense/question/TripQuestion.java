package me.matthew.finalproject.trip.expense.question;

import me.matthew.finalproject.trip.expense.Expense;

import java.util.Scanner;

public interface TripQuestion {
    Expense ask(Scanner scanner);
}
