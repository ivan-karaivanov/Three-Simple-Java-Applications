import java.util.Random;

public class EmailApp {
    private String firstName;
    private String lastName;
    private String department;
    private String company = "netflix.com";
    private String email;
    private String password;
    private int mailboxCapacity = 500; // Default mailbox capacity
    private String alternateEmail;

    // Constructor for name
    public EmailApp(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = generateEmail();
        this.password = generateRandomPassword(10);
    }

    // Generate an email address based on the syntax
    private String generateEmail() {
        if (department.isEmpty()) {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company;
        } else {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company;
        }
    }

    // Generate a random password
    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder passwordBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            passwordBuilder.append(characters.charAt(index));
        }

        return passwordBuilder.toString();
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set alternate email address
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // To display the name, email, and mailbox capacity
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        EmailApp user = new EmailApp("John", "Smith", "development");

        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Mailbox Capacity: " + user.getMailboxCapacity() + " MB");
        System.out.println("Alternate Email: " + user.getAlternateEmail());
        System.out.println("Password: " + user.getPassword());
    }
}
