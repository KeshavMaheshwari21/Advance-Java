import java.sql.*;
import java.io.*;
public class jdb
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Records in the Database : ");
            int id = Integer.parseInt(br.readLine());
            String n = br.readLine();
            String a = br.readLine();
            PreparedStatement psmt = con.prepareStatement("insert into emp values(?,?,?)");
            psmt.setInt(1,id);
            psmt.setString(2,n);
            psmt.setString(3,a);
            psmt.execute();
            System.out.println("Records Entered in the Database!!");
            
            System.out.println("\n");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
