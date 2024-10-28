import java.util.Scanner;

abstract class Account {
    protected String customerName;
    protected int accountNumber;
    protected double balance;

    public Account(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, int accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest of " + interest + " added to your account.");
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
    }
}

class CurAcct extends Account {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurAcct(String customerName, int accountNumber) {
        super(customerName, accountNumber);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
            return true;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
    }

    public void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Minimum balance violated. Service charge of " + SERVICE_CHARGE + " applied.");
        }
    }
}

 class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose account type: (1) Savings (2) Current");
        int choice = sc.nextInt();
        
        System.out.println("Enter account holder name:");
        String name = sc.next();
        System.out.println("Enter account number:");
        int accountNumber = sc.nextInt();
        
        Account account = null;
        
        if (choice == 1) {
            System.out.println("Enter interest rate:");
            double interestRate = sc.nextDouble();
            account = new SavAcct(name, accountNumber, interestRate);
        } else if (choice == 2) {
            account = new CurAcct(name, accountNumber);
        } else {
            System.out.println("Invalid choice. Please select 1 for Savings or 2 for Current.");
            sc.close();
            return;
        }

        // Example operations
        while (true) {
            System.out.println("\nChoose an operation: (1) Deposit (2) Withdraw (3) Display Balance (4) Compute Interest (5) Exit");
            int operation = sc.nextInt();
            
            switch (operation) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).withdraw(withdrawAmount);
                    } else if (account instanceof CurAcct) {
                        ((CurAcct) account).withdraw(withdrawAmount);
                    }
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else {
                        System.out.println("Interest computation is not applicable for Current Accounts.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
    }
}
