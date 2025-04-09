import java.sql.*;

public class Report {
    public static void addReport(int userId, String type, String description, String location) {
        try {
            Connection con = DBConnection.connect();
            String query = "INSERT INTO reports (reporter_id, type, description, location) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, type);
            ps.setString(3, description);
            ps.setString(4, location);
            ps.executeUpdate();
            System.out.println("Report submitted.");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listReports() {
        try {
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reports");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Location: " + rs.getString("location"));
                System.out.println("----");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
