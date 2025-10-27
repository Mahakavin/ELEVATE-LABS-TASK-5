package calc;

import java.util.*;

public class BankAccountSimulation {
    public static void main(String[] args) {
        System.out.println("Welcome to the \"BANK ACCOUNT SIMULATION\"");
        System.out.println("Enter your current Balance in a Bank account");
        Scanner scan = new Scanner(System.in);
        double balance = scan.nextDouble();
        Transaction t = new Transaction(balance);
        boolean process = true;
        List<List<Object>> detail = new ArrayList<>();

        while (process) {
            try {
                System.out.println("Press\n 1 to \"DEPOSIT\"\n 2 to \"WITHDRAW\"\n 3 to see \"TRANSACTION\"");
                int number = scan.nextInt();
                if (number == 1) {
                    System.out.println("Enter the amount to deposit");
                    double amount = scan.nextDouble();
                    t.deposit(amount);
                    detail.add(new ArrayList<>(t.getDetail()));
                    t.getDetail().clear();
                } else if (number == 2) {
                    System.out.println("Enter the amount to withdraw");
                    double amount = scan.nextDouble();
                    t.withDraw(amount);
                    detail.add(new ArrayList<>(t.getDetail()));
                    t.getDetail().clear();
                } else if (number == 3) {
                    System.out.println("All Transaction History is Shown now");
                    for (int i = 0; i < detail.size(); i++) {
                        System.out.println("Transaction number :" + (i + 1));
                        System.out.println("Before Transaction your balance is :" + detail.get(i).get(0));
                        System.out.println("Transaction type: " + detail.get(i).get(1));
                        System.out.println("Current Balance in your account is :" + detail.get(i).get(2));
                    }
                } else {
                    System.out.println("Enter the correct number");
                    continue;
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            System.out.println("You want to continue the process press \"YES\" Otherwise press\"NO\"");
            if (scan.next().equalsIgnoreCase("No")) {
                process = false;
            }
        }
        System.out.println("Thank You For Your patience\n HAVE A GREAT DAY");
    }
}

class Account {
    private double balance;
    List<Object> detail = new ArrayList<>();

    Account(double amount) {
        balance = amount;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            detail.add(balance);
            detail.add("Deposited");
            balance = balance + amount;
            detail.add(balance);
            System.out.println("Your current balance after deposit is :" + balance);
        } else {
            System.out.println("Amount should not be negative");
        }
    }

    public void withDraw(double amount) {
        if (balance - amount > 0) {
            detail.add(balance);
            detail.add("Withdraw");
            balance = balance - amount;
            detail.add(balance);
            System.out.println("Amount " + amount + " is withdrawn successfully. Current amount in your balance is " + balance);
        } else {
            System.out.println("Insufficient balance. Enter amount less than balance");
        }
    }

    public List<Object> getDetail() {
        return detail;
    }
}

class Transaction extends Account {
    Transaction(double amount) {
        super(amount);
    }
}
