package sjce_league;
import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("*************************************************************************** WELCOME TO SJCE PREMIER LEAGUE ***************************************************************************");
        while (true) {
            System.out.println("ENTER YOUR CHOICE:\n1)TEAM LIST \n2)MANAGERS \n3)PLAYERS \n4)MANAGE PLAYERS(admin only) \n5)EXIT");
            int choice=sc.nextInt();
            switch (choice){
                case 1:{
                   Teams teams=new Teams();
                   teams.teams();
                   db("teams");
                   break;
                }
                case 2:{
                    Details details=new Details();
                    details.details();
                    break;
                }
                case 3:{
                   Players.players();
                    break;
                }
                case 4:{
                    sc.nextLine();
                    System.out.println("Enter username:");
                    String user=sc.nextLine();
                    System.out.println("Enter password:");
                    String pass=sc.nextLine();
                    System.out.println(user+" "+pass);
                    if(user.equals("sk") && pass.equals("dbms")){
                    System.out.println("1)ADD PLAYERS  2)REMOVE PLAYERS");
                    int t=sc.nextInt();
                    switch(t){
                        case 1:{
                           ManagePlayers managePlayers=new ManagePlayers();
                           managePlayers.add_players();
                            break;
                        }
                        case 2:{
                         ManagePlayers managePlayers=new ManagePlayers();
                         managePlayers.remove_players();
                            break;
                        }
                        default:
                            System.out.println("Enter valid choice!!!");
                    }


                }
                    else{
                        System.out.println("Invalid username or password!!! Try again");
                    }
                    break;
                }

                    case 5:
                        System.exit(0);



                default:
                    System.out.println("enter valid choice!!!");
            }



        }

    }
    public static void db(String a){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sk", "root", "sarankumarr007");
            String query = "select * from "+a;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String team = rs.getString("team_name");
                System.out.println("*"+team);

            }
            System.out.println();
            System.out.println("-------------------------------------------------");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

