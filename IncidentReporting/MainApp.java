import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add User\n2. Submit Report\n3. View Reports\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Role (citizen/admin): ");
                String role = sc.nextLine();
                User.addUser(name, email, role);

            } else if (choice == 2) {
                System.out.print("User ID: ");
                int userId = sc.nextInt();
                sc.nextLine();
                System.out.print("Type of Incident: ");
                String type = sc.nextLine();
                System.out.print("Description: ");
                String desc = sc.nextLine();
                System.out.print("Location: ");
                String loc = sc.nextLine();
                Report.addReport(userId, type, desc, loc);

            } else if (choice == 3) {
                Report.listReports();

            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}
