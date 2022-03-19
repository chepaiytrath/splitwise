package repository;

import entity.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {
    public static Map<String, Expense> expenseMap = new HashMap<>();
}