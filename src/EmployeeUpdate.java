import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeUpdate extends JFrame{
    private JPanel DışPanel;
    private JButton updateButton;
    private JButton returnBackButton;
    private JTextField personelJobText;
    private JTextField personelDepartmantText;
    private JLabel messageLabel;
    private JTextField personelIDtext;
    private JTextField personelNameText;
    private JTextField personelLastNameText;
    prisonStuff stuff =new prisonStuff();
    public EmployeeUpdate() {

        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Personel Güncelleme/Görüntüleme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        personelIDtext.setText(employeeWiew.EmployeeDatas[0].toString());
        personelNameText.setText(employeeWiew.EmployeeDatas[1].toString());
        personelLastNameText.setText(employeeWiew.EmployeeDatas[2].toString());
        personelDepartmantText.setText(employeeWiew.EmployeeDatas[3].toString());
        personelJobText.setText(employeeWiew.EmployeeDatas[4].toString());

        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                employeeWiew employeeWiew=new employeeWiew();
                setVisible(false);
                employeeWiew.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText(" ");


                int ID= Integer.parseInt(personelIDtext.getText());
                String name= personelNameText.getText();
                String lastname=personelLastNameText.getText();
                String department=personelDepartmantText.getText();
                String job=personelJobText.getText();
                stuff.updateEmployee(ID,name,lastname,department,job);

                messageLabel.setText("Personel Bilgileri Güncelleme Başarılı!");
                try {
                }catch (Exception exception){
                    messageLabel.setText("Güncelleme Başarısız! Alanları doldurunuz !");
                }
            }
        });
    }
}
