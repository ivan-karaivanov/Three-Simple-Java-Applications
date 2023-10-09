# New Bank Account Application

This is a Java application for managing new customer bank account requests. It allows you to read customer data from a CSV file, create bank accounts, and display account information.

## Usage

1. Run the `BankAccountApplication` class to start the application.
2. The program will read customer data from the "NewBankAccounts.csv" file located in the root directory.
3. The application creates both savings and checking accounts based on the data in the CSV file.
4. Account information, including details specific to each account type, is displayed.

## CSV File Format

- The CSV file should have the following format for each entry: `name,ssn,accountType,initialDeposit`.
- `name`: Customer name
- `ssn`: Social Security Number
- `accountType`: Account type (either "savings" or "checking")
- `initialDeposit`: Initial deposit amount

## Features

- The program generates 11-digit account numbers based on account type, SSN, and a unique number.
- Savings account holders are assigned a Safety Deposit Box with a 3-digit number and a 4-digit access code.
- Checking account holders receive a 12-digit Debit card number and a 4-digit PIN code.
- Both account types use an interest rate determined by an interface.
- The `showInfo` method reveals relevant account information, including specific details for each account type.

## Author

[Ivan Karaivanov]

## License

This project is open-source and available under the [MIT License](LICENSE).

