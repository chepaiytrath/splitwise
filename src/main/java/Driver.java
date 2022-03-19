import entity.Expense;
import entity.ExpenseRequest;
import entity.Group;
import entity.User;
import entity.split.Split;
import entity.split.SplitRequest;
import exception.GroupNotFoundException;
import exception.InvalidSplitRequestException;
import exception.InvalidSplitTypeException;
import exception.UserNotFoundException;
import service.account.AccountService;
import service.account.AccountServiceImpl;
import service.expense.ExpenseService;
import service.expense.ExpenseServiceImpl;
import service.split.SplitService;
import service.split.SplitServiceImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static enums.SplitType.*;

public class Driver {
    private static AccountService accountService = new AccountServiceImpl();
    private static ExpenseService expenseService = new ExpenseServiceImpl();
    private static SplitService splitService = new SplitServiceImpl();

    public static void main(String[] args) throws UserNotFoundException, GroupNotFoundException, InvalidSplitRequestException, InvalidSplitTypeException {
        User jatin = accountService.createUser("jatin", "jatin@gmail.com", "123", "Jatin Address");
        User rakesh = accountService.createUser("rakesh", "rakesh@gmail.com", "456", "Rakesh Address");
        User aaditya = accountService.createUser("aaditya", "aaditya@gmail.com", "789", "Aaditya Address");

        Group group = accountService.createGroup("Group1", jatin.getUserId());
        accountService.addUserToGroup(rakesh.getUserId(), group.getGroupId());
        accountService.addUserToGroup(aaditya.getUserId(), group.getGroupId());


        Expense firstExpense = createFirstExpense(jatin, rakesh, group);
        Expense secondExpense = createSecondExpense(rakesh, aaditya, group);
        Expense thirdExpense = createThirdExpense(jatin, rakesh, aaditya, group);


        expenseService.showAllBalances(group.getGroupId());
    }

    private static Expense createFirstExpense(User jatin, User rakesh, Group group) throws InvalidSplitTypeException, InvalidSplitRequestException {
        SplitRequest splitRequest = new SplitRequest(PERCENT, Arrays.asList(jatin.getUserId(), rakesh.getUserId()), Arrays.asList(40.00, 60.00));
        List<Split> splits = splitService.createSplits(splitRequest);
        String paidByUser = jatin.getUserId();

        ExpenseRequest expenseReq = new ExpenseRequest(
                PERCENT,
                "Expense1",
                1000.00,
                LocalDateTime.now(),
                paidByUser,
                group.getGroupId(),
                splits);
        Expense expense = expenseService.addExpense(expenseReq);
        return expense;
    }

    private static Expense createSecondExpense(User rakesh, User aaditya, Group group) throws InvalidSplitRequestException, InvalidSplitTypeException {
        SplitRequest splitRequest = new SplitRequest(EXACT, Arrays.asList(rakesh.getUserId(), aaditya.getUserId()), Arrays.asList(200.00, 300.00));
        List<Split> splits = splitService.createSplits(splitRequest);

        String paidByUser = rakesh.getUserId();

        ExpenseRequest expenseReq = new ExpenseRequest(
                EXACT,
                "Expense2",
                500.00,
                LocalDateTime.now(),
                paidByUser,
                group.getGroupId(),
                splits);

        Expense expense = expenseService.addExpense(expenseReq);
        return expense;
    }

    private static Expense createThirdExpense(User jatin, User rakesh, User aaditya, Group group) throws InvalidSplitRequestException, InvalidSplitTypeException {
        SplitRequest splitRequest = new SplitRequest(EQUAL, Arrays.asList(aaditya.getUserId(), jatin.getUserId(), rakesh.getUserId()), Arrays.asList());
        List<Split> splits = splitService.createSplits(splitRequest);

        String paidByUser = aaditya.getUserId();

        ExpenseRequest expenseReq = new ExpenseRequest(
                EQUAL,
                "Expense3",
                1200.00,
                LocalDateTime.now(),
                paidByUser,
                group.getGroupId(),
                splits);

        Expense expense = expenseService.addExpense(expenseReq);
        return expense;
    }
}