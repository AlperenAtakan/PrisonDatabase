import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends  JFrame  {


    prisonStuff stuff =new prisonStuff();


    private JLabel messageText;
    private JLabel prisonControlPanel;
    private JPanel dışdışpanel;
    private JButton loginButton;
    private JPasswordField passwordText;
    private JTextField usernameText;

    static int level=3;
    public LoginScreen(){
        add(dışdışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Hapishane Veritabanı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageText.setText(" ");
                String username=  usernameText.getText();
                String password= new String(passwordText.getPassword());
                boolean loginSuccess=stuff.login(username,password);
                level=stuff.getLevel(username,password);

                if (loginSuccess==true && level==0){
                    messageText.setText("Giriş Başarılı Yetki Seviyesi Müdür !");
                    AuthorityScreen0 screen0 = new AuthorityScreen0();
                    setVisible(false);
                    screen0.setVisible(true);
                } else if (loginSuccess==true && level==1) {
                    messageText.setText("Giriş Başarılı Yetki Seviyesi Gardiyan !");
                    AuthorityScreen1 screen1 = new AuthorityScreen1();
                    setVisible(false);
                    screen1.setVisible(true);
                } else if (loginSuccess==true && level==2) {
                    messageText.setText("Giriş Başarılı Yetki Seviyesi Personel !");
                    AuthorityScreen2 screen2 = new AuthorityScreen2();
                    setVisible(false);
                    screen2.setVisible(true);
                } else {
                    messageText.setText("Giriş Başarısız! Kullanıcı Hatası veya Şifre Hatalı!");
                }
            }
        });
    }
}
