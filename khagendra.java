import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double totalbalance;


    Account(String name, int accNumber, String accType) {
        customerName = name;
        accountNumber = accNumber;
        accountType = accType;
        totalbalance = 0;
    }


    public void deposit(double amount) {
        totalbalance += amount;
        System.out.println("Deposited: " + amount + ". Updated balance: " + totalbalance);
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + totalbalance);
    }

 
    public void withdraw(double amount) {
        System.out.println("This operation is specific to account type.");
    }
}


class SavAccount extends Account {
    double interestRate = 0.04;

    SavAccount(String name, int accNumber) {
        super(name, accNumber, "Savings");
    }


    public void computeInterest() {
        double interest = totalbalance * interestRate;
        totalbalance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + totalbalance);
    }


    @Override
    public void withdraw(double amount) {
        if (totalbalance >= amount) {
            totalbalance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + totalbalance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
class CurAccount extends Account {
    double minBalance = 500.0;
    double serviceCharge = 50.0;

    CurAccount(String name, int accNumber) {
        super(name, accNumber, "Current");
    }

    public void checkMinBalance() {
        if (totalbalance < minBalance) {
            totalbalance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge imposed: " + serviceCharge + ". Updated balance: " + totalbalance);
        }
    }


    @Override
    public void withdraw(double amount) {
        if (totalbalance >= amount) {
            totalbalance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + totalbalance);
            checkMinBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
class Bank {
    public static void main(String[] args) {
   	Scanner sc = new Scanner(System.in);
        System.out.println("Enter account holder name:");
        String name=sc.next();
        System.out.println("Enter account number:");
        int accountnumber=sc.nextInt();
        SavAccount savingsAccount = new SavAccount(name, accountnumber);

        System.out.println("Enter account holder name:");
        String name1=sc.next();
        System.out.println("Enter account number:");
        int accountnumber1=sc.nextInt();
        CurAccount currentAccount = new CurAccount(name1, accountnumber1);

        while (true) {
            System.out.println("\n-----MENU-----");
            System.out.println("1. Deposit amount \n2. Withdraw ammount \n3. Compute Interest\n4. Display Account Details\n5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            System.out.print("Enter the type of account (saving/current): ");
            String accType = sc.next();

            if (accType.equals("saving")) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount to be deposited: ");
                        double depositAmount = sc.nextDouble();
                        savingsAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter the amount to be withdraw: ");
                        double withdrawalAmount = sc.nextDouble();
                        savingsAccount.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        savingsAccount.computeInterest();
                        break;
                    case 4:
                        System.out.println("account holder name: " + savingsAccount.customerName);
                        System.out.println("Account number: " + savingsAccount.accountNumber);
                        System.out.println("Type of Account: " + savingsAccount.accountType);
                        savingsAccount.displayBalance();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else if (accType.equals("current")) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to be deposited: ");
                        double depositAmount = sc.nextDouble();
                        currentAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to be withdraw: ");
                        double withdrawalAmount = sc.nextDouble();
                        currentAccount.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Current accounts do not earn interest.");
                        break;
                    case 4:
                        System.out.println("Customer name: " + currentAccount.customerName);
                        System.out.println("Account number: " + currentAccount.accountNumber);
                        System.out.println("Type of Account: " + currentAccount.accountType);
                        currentAccount.displayBalance();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Invalid account type.");
            }
        }
    }
}