package sjce_league;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ManagePlayers {
    Scanner sc=new Scanner(System.in);
    public  void add_players() {
        System.out.println("Enter player name:");
        String name=sc.nextLine();
        System.out.println("Enter age:");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter position:");
        String position=sc.nextLine();
        System.out.println("Enter department:");
        String department =sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sk", "root", "sarankumarr007");
            String query = "insert into players  VALUES ('"+name+"','"+ age+"','"+position+"','"+department+"')";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("The player has been added successfully!!!");


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void remove_players() {
        System.out.println("Enter player name to be deleted:");
        String name=sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sk", "root", "sarankumarr007");
            String query = "delete from players where name=\""+name+"\"";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("The player has been deleted successfully");


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }



}
