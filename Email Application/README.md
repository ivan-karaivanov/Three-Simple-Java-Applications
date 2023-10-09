# Email Application

This Java program, **EmailApp**, is designed to automate the process of creating email accounts for new hires.

## Features

1. **Email Address Generation**: The program generates email addresses with the following syntax: `firstname.lastname@department.company.com`. If a department is not specified, it will be left blank.

2. **Random Password Generation**: It generates a random password for each email account, enhancing security.

3. **Customizable Mailbox Capacity**: You can set the mailbox capacity to meet your organization's needs. The default capacity is 500 MB.

4. **Alternate Email Address**: You can define an alternate email address for each user.

5. **Password Change**: Provides a method to change the user's password.

6. **Information Retrieval**: Includes methods to retrieve the user's name, email address, mailbox capacity, alternate email address, and password.

## Usage

To use the Email Application, create an instance of the `EmailApp` class for each new hire. Here's an example of how to create a user and display their information:

```java
public static void main(String[] args) {
    EmailApp user = new EmailApp("John", "Smith", "development");

    System.out.println("Name: " + user.getName());
    System.out.println("Email: " + user.getEmail());
    System.out.println("Mailbox Capacity: " + user.getMailboxCapacity() + " MB");
    System.out.println("Alternate Email: " + user.getAlternateEmail());
    System.out.println("Password: " + user.getPassword());
}
```

## Customization

- You can customize the default company name by modifying the `company` variable in the `EmailApp` class.
- Adjust the length and complexity of generated passwords by changing the parameters in the `generateRandomPassword` method.

## Author

This Email Application program was developed by [Ivan Karaivanov].

## License

This program is provided under the [MIT] license.

