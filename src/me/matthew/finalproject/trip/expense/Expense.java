package me.matthew.finalproject.trip.expense;

public interface Expense {
    double getAmount(double days);
    double getReimbursableAmount(double days);
}
