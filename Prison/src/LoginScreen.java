import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends  JFrame  {


    prisonStuff stuff =new prisonStuff();

    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JPanel DışPanel;
    private JButton enterButton;
    private JLabel messageText;

    public LoginScreen(){
        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Database");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                messageText.setText("");
                String username=  UsernameField.getText();
                String password= new String(PasswordField.getPassword());

                boolean loginSuccess=stuff.login(username,password);

                if (loginSuccess==true){

                    messageText.setText("Login Succesful!");

                    prisonerWiew prisonerWiew = new prisonerWiew();
                    setVisible(false);
                    prisonerWiew.setVisible(true);


                }else {
                    messageText.setText("Login Failed!");
                }

            }
        });


    }
}
