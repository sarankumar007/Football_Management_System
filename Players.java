package sjce_league;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Players {
    public static void players(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter team name");
        String team_name=sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sk", "root", "sarankumarr007");
            String query = "select * from players WHERE team=\'"+team_name+"\'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name=rs.getString(1);
                int age = rs.getInt(2);
                String pos=rs.getString(3);
                String team=rs.getString(4);
                System.out.println("Name: "+name+"      "+"Age: "+age+"      "+"Position: "+pos+"      "+"Team: "+team);

            }
            System.out.println();
            System.out.println("-------------------------------------------------");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
