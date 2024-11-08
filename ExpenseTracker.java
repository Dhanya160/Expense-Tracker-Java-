import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private double amount;
    private String category;

    public Expense(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return category + ": $" + amount;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(double amount, String category) {
        expenses.add(new Expense(amount, category));
    }

    public void listExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Expense  2. List Expenses  3. Calculate Total  4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                tracker.addExpense(amount, category);
            } else if (choice == 2) {
                tracker.listExpenses();
            } else if (choice == 3) {
                tracker.calculateTotal();
            } else {
                break;
            }
        }
        scanner.close();
    }
}
