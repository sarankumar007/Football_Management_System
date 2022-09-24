package sjce_league;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Details {
    public void details() {
        System.out.println("Team name  Manager");
        System.out.println("---- ----  -------");
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sk", "root", "sarankumarr007");
            String query = "select * from details";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String manager=rs.getString("managers");
                String team = rs.getString("team_name");
                System.out.println(team+"  "+manager);

            }
            System.out.println();
            System.out.println("-------------------------------------------------");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
