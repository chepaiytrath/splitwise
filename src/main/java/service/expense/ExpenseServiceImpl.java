package service.expense;

import entity.Expense;
import entity.ExpenseRequest;
import entity.Group;
import entity.User;
import entity.split.Split;
import repository.ExpenseRepository;
import repository.GroupRepository;
import repository.UserRepository;
import strategy.SplitApplierStrategy;

import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public Expense addExpense(ExpenseRequest expenseReq) {
        applySplit(expenseReq);
        Expense expense = new Expense(expenseReq);

        Group group = GroupRepository.groupMap.get(expenseReq.getGroupId());
        group.getExpenses().add(expense.getExpenseId());
        Map<String, Map<String, Double>> userBalances = group.getBalances();
        String userWhoPaidExpense = expenseReq.getPaidByUser();


        for (Split split : expense.getSplits()) {
            split.setExpenseId(expense.getExpenseId());

            String userWhoHasToPay = split.getUserId();

            Map<String, Double> userWhoHasToPayMap = userBalances.get(userWhoHasToPay);
            userWhoHasToPayMap.putIfAbsent(userWhoPaidExpense, 0.0);
            userWhoHasToPayMap.put(userWhoPaidExpense, userWhoHasToPayMap.get(userWhoPaidExpense) + split.getSplitAmount());

            Map<String, Double> userWhoPaidExpenseMap = userBalances.get(userWhoPaidExpense);
            userWhoPaidExpenseMap.putIfAbsent(userWhoHasToPay, 0.0);
            userWhoPaidExpenseMap.put(userWhoHasToPay, userWhoPaidExpenseMap.get(userWhoHasToPay) - split.getSplitAmount());
        }

        ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(), expense);
        return expense;
    }

    @Override
    public void showAllBalances(String groupId) {
        Group group = GroupRepository.groupMap.get(groupId);

        for (String fromUserId : group.getBalances().keySet()) {
            User fromUser = UserRepository.userMap.get(fromUserId);
            Map<String, Double> map = group.getBalances().get(fromUser.getUserId());
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    User toUser = UserRepository.userMap.get(entry.getKey());
                    System.out.println("User " + fromUser.getName() + " owes " + "User " + toUser.getName() + " Rs." + entry.getValue());
                }
            }
        }
    }

    private void applySplit(ExpenseRequest expenseReq) {
        double totalExpenseAmount = expenseReq.getExpenseAmount();
        String paidByUser = expenseReq.getPaidByUser();
        int usersInExpense = expenseReq.getSplits().size();
        List<Split> splits = expenseReq.getSplits();
        SplitApplierStrategy.getInstance(expenseReq.getSplitType()).applySplit(totalExpenseAmount, paidByUser, usersInExpense, splits);
    }
}