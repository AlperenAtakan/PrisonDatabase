import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAdd extends JFrame{
    private JPanel DışPanel;
    private JButton addButton;
    private JButton returnBackButton;
    private JTextField personelNameText;
    private JTextField personelLastNameText;
    private JTextField personelDepartmanText;
    private JTextField personelJobText;
    private JLabel messageLabel;
    prisonStuff stuff =new prisonStuff();

    public EmployeeAdd(){

        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Personel Ekleme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                employeeWiew employeeWiew = new employeeWiew();
                setVisible(false);
                employeeWiew.setVisible(true);

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name= personelNameText.getText();
                    String lastname=personelLastNameText.getText();
                    String department=personelDepartmanText.getText();
                    String job=personelJobText.getText();

                    stuff.addEmployee(name,lastname,department,job);

                    messageLabel.setText("Ekleme Başarılı");
                }catch (NumberFormatException exception){
                    messageLabel.setText("Ekleme Başarısız. Lütfen Alanları Doldurun!");
                    exception.printStackTrace();
                }
            }
        });
    }


}
