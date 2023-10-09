import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountApplication {
    public static void main(String[] args) {
        // Read customer data from a CSV file and create accounts
        List<Account> accounts = readCustomerData("NewBankAccounts.csv");

        // Display account information
        for (Account account : accounts) {
            account.showInfo();
            System.out.println("\n==========================\n");
        }
    }

    private static List<Account> readCustomerData(String fileName) {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String ssn = data[1];
                String accountType = data[2];
                double initialDeposit = Double.parseDouble(data[3]);

                if (accountType.equalsIgnoreCase("savings")) {
                    accounts.add(new SavingsAccount(name, ssn, initialDeposit));
                } else if (accountType.equalsIgnoreCase("checking")) {
                    accounts.add(new CheckingAccount(name, ssn, initialDeposit));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}

    interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    void transfer(double amount, Account destinationAccount);

    void showInfo();
}

class SavingsAccount implements Account {
    private String accountNumber;
    private double balance;
    private String ssn;
    private int safetyDepositBox;
    private int accessCode;

    private static int uniqueSafetyDepositBox = 100;
    private static int uniqueAccessCode = 1000;

    public SavingsAccount(String name, String ssn, double initialDeposit) {
        this.ssn = ssn;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber('1');
        this.safetyDepositBox = uniqueSafetyDepositBox++;
        this.accessCode = generateAccessCode();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void transfer(double amount, Account destinationAccount) {
        if (balance >= amount) {
            withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Savings Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("SSN: " + ssn);
        System.out.println("Balance: $" + balance);
        System.out.println("Safety Deposit Box Number: " + safetyDepositBox);
        System.out.println("Access Code: " + accessCode);
    }

    private String generateAccountNumber(char accountType) {
        Random random = new Random();
        int uniqueID = random.nextInt(900) + 100;
        return accountType + ssn.substring(ssn.length() - 2) + uniqueID + random.nextInt(900);
    }

    private int generateAccessCode() {
        return new Random().nextInt(9000) + 1000;
    }
}

class CheckingAccount implements Account {
    private String accountNumber;
    private double balance;
    private String ssn;
    private long debitCardNumber;
    private int pin;

    private static long uniqueDebitCardNumber = 100000000000L;
    private static int uniquePin = 1000;

    public CheckingAccount(String name, String ssn, double initialDeposit) {
        this.ssn = ssn;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber('2');
        this.debitCardNumber = uniqueDebitCardNumber++;
        this.pin = generatePin();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void transfer(double amount, Account destinationAccount) {
        if (balance >= amount) {
            withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Checking Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("SSN: " + ssn);
        System.out.println("Balance: $" + balance);
        System.out.println("Debit Card Number: " + debitCardNumber);
        System.out.println("PIN: " + pin);
    }

    private String generateAccountNumber(char accountType) {
        Random random = new Random();
        int uniqueID = random.nextInt(900) + 100;
        return accountType + ssn.substring(ssn.length() - 2) + uniqueID + random.nextInt(900);
    }

    private int generatePin() {
        return new Random().nextInt(9000) + 1000;
    }
}
