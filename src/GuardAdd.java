import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardAdd extends  JFrame {
    private JPanel DışPanel;
    private JTextField nameText;
    private JTextField lastNameText;
    private JTextField rankText;
    private JTextField weightText;
    private JTextField heightText;
    private JTextField ageText;
    private JButton addButton;
    private JButton returnBackButton;
    private JLabel MessageLabel;
    private JLabel imageLabel;
    private JPanel ImageAreaPanel;
    private JButton resimSeçMax56KbButton;

    prisonStuff stuff =new prisonStuff();

    public GuardAdd(){
        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Gardiyan Ekle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardWiew guardWiew=new guardWiew();
                setVisible(false);
                guardWiew.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String name = nameText.getText();
                    String surname = lastNameText.getText();
                    String rank = rankText.getText();
                    int weight = Integer.parseInt(weightText.getText());
                    int height = Integer.parseInt(heightText.getText());
                    int age = Integer.parseInt(ageText.getText());


                    stuff.addGuard(name, surname, rank, weight, height, age);

                    MessageLabel.setText("Gardiyan Ekleme Başarılı");
                }catch (NumberFormatException exception){
                    MessageLabel.setText("Ekleme Başarısız! Boş Alanları Doldurunuz!");
                    exception.printStackTrace();
                }
            }
        });
    }


}
