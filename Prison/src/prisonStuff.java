import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prisonStuff {
    private Connection con=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement= null;



    public prisonStuff(){

        String url= "jdbc:mysql://"+ Database.host +":"+ Database.port +"/" + Database.db_name;



        try {
            con= DriverManager.getConnection(url,Database.user_name,Database.password);
            System.out.println("Bağlantı başarılı!");

        } catch (Exception e) {
            System.out.println("Baglanti başarısız!");
            e.printStackTrace();
        }
    }

    public boolean login(String username,String password){

        String query= "Select * From admins where admin_name= ? and password = ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet rs=preparedStatement.executeQuery();

            if (rs.next()==false){
                return  false;
            }else {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                prisonStuff  stuff = new prisonStuff();


                LoginScreen loginScreen=new LoginScreen();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                loginScreen.setVisible(true);
            }
        });





    }

    public void deletePrisoner(int id){
        String sorgu = "Delete from prisoner where idprisoner = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Silme Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addPrisoner(String name,String lastname,int height,int weight,String releaseDate,String TC,int age,int gender,int punishmentTime) {

        String sorgu = "Insert Into prisoner(prisoner_name,prisoner_surname,prisoner_height,prisoner_weight,prisoner_release_date,prisoner_TC,prisoner_age,prisoner_gender,prisoner_punishment_time) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = con.prepareStatement(sorgu);


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, height);
            preparedStatement.setInt(4, weight);
            preparedStatement.setString(5, releaseDate);
            preparedStatement.setString(6, TC);
            preparedStatement.setInt(7, age);
            boolean gender1;
            if (gender==1){
                gender1=true;
            }else {
                gender1=false;
            }
            preparedStatement.setBoolean(8,gender1 );
            preparedStatement.setInt(9, punishmentTime);

            preparedStatement.executeUpdate();





        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız!");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }






    }

    public void updatePrisoner(int id ,String name,String lastname,int height,int weight,String releaseDate,String TC,int age,String gender,int punishmentTime) {
        String sorgu =  "Update prisoner set prisoner_name = ? , prisoner_surname = ? , prisoner_height = ? , prisoner_weight = ?, prisoner_release_date = ? , prisoner_TC = ? , prisoner_age = ? , prisoner_gender = ? , prisoner_punishment_time = ? where idprisoner = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, height);
            preparedStatement.setInt(4, weight);
            preparedStatement.setString(5, releaseDate);
            preparedStatement.setString(6, TC);
            preparedStatement.setInt(7, age);

            boolean gender1=true;
            if (gender.equals("Male")){
                gender1=true;
            }else {
                gender1=false;
            }
            preparedStatement.setBoolean(8,gender1 );
            preparedStatement.setInt(9, punishmentTime);
            preparedStatement.setInt(10,id);

            preparedStatement.executeUpdate();



        } catch (SQLException ex) {
            System.out.println("Update Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Prisoner> getPrisoners(){

        ArrayList<Prisoner> data=new ArrayList<Prisoner>();

        try {
            statement = con.createStatement();

            String sorgu="Select * From prisoner";

            ResultSet rs=statement.executeQuery(sorgu);

            while (rs.next()){
                int id=rs.getInt("idprisoner");

                String name=rs.getString("prisoner_name");

                String surname=rs.getString("prisoner_surname");

                int height=rs.getInt("prisoner_height");

                int weight=rs.getInt("prisoner_weight");

                String releaseDate= String.valueOf(rs.getDate("prisoner_release_date"));

                String TC=rs.getString("prisoner_TC");

                int age=rs.getInt("prisoner_age");

                String gender;
                if (rs.getBoolean("prisoner_gender")){
                    gender="Male";
                }else {
                     gender="Female";
                }

                int punishmentTime=rs.getInt("prisoner_punishment_time");

                data.add(new Prisoner(id,name,surname,height,weight,releaseDate,TC,age,gender,punishmentTime));


            }
            return data;

        } catch (SQLException e) {
            System.out.println("Veritabanına ulaşılamadı");
            return null;
        }



    }
}
