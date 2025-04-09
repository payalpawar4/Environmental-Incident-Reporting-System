import java.sql.*;

public class User {
    public static void addUser(String name, String email, String role) {
        try {
            Connection con = DBConnection.connect();
            String query = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, role);
            ps.executeUpdate();
            System.out.println("User added.");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
