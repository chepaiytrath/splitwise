package service.expense;

import entity.Expense;
import entity.ExpenseRequest;

public interface ExpenseService {
    Expense addExpense(ExpenseRequest expenseReq);

    void showAllBalances(String groupId);

    // Optional
    // void showBalancesOfUser(String groupId, String userId);
}