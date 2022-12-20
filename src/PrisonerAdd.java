import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class PrisonerAdd extends JFrame{
    private JPanel DışPanel;
    private JButton addButton;
    private JButton returnBackButton;
    private JTextField prisonerName;
    private JTextField prisonerLastName;
    private JTextField prisonerHeight;
    private JTextField prisonerWeight;
    private JTextField prisonerReleaseDate;
    private JTextField prisonerTC;
    private JTextField prisonerAge;
    private JTextField prisonerGender;
    private JTextField prisonerPunishmentTime;
    private JLabel messageLabel;
    private JButton chooseImageButton;
    private JPanel prisonerImageField;
    private JLabel imageLabel;

    prisonStuff stuff =new prisonStuff();
    String fileName=null;
    byte[] prisonerImage=null;

    public PrisonerAdd(){

        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    String name= prisonerName.getText();
                    String lastname=prisonerLastName.getText();
                    int height= Integer.parseInt(prisonerHeight.getText());
                    int weight= Integer.parseInt(prisonerWeight.getText());
                    String releaseDate=prisonerReleaseDate.getText();
                    String TC=prisonerTC.getText();
                    int age= Integer.parseInt(prisonerAge.getText());
                    int gender= Integer.parseInt(prisonerGender.getText());
                    int punishmentTime= Integer.parseInt(prisonerPunishmentTime.getText());
                    byte[] image=prisonerImage;
                    if (image==null){
                        messageLabel.setText("Resimsiz Ekleme Yapıldı!");
                    }

                    stuff.addPrisoner(name,lastname,height,weight,releaseDate,TC,age,gender,punishmentTime,image);

                    messageLabel.setText("Ekleme Başarılı");
                }catch (NumberFormatException exception){
                    messageLabel.setText("Ekleme Başarısız. Lütfen Alanları Doldurun!");
                    exception.printStackTrace();
                }



            }
        });
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                prisonerWiew prisonerWiew= new prisonerWiew();
                prisonerWiew.setVisible(true);
            }
        });
        chooseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser=new JFileChooser();

                chooser.showOpenDialog(null);
                File file=chooser.getSelectedFile();

                    fileName=file.getAbsolutePath();
                    ImageIcon imageIcon=new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(prisonerImageField.getWidth(),prisonerImageField.getHeight(), Image.SCALE_SMOOTH));
                    imageLabel.setIcon(imageIcon);
                    try{
                        File image=new File(fileName);
                        FileInputStream inputStream=new FileInputStream(image);
                        ByteArrayOutputStream bos=new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];

                        for (int readNum;(readNum=inputStream.read(buf))!=-1;){
                            bos.write(buf,0,readNum);
                        }
                        prisonerImage=bos.toByteArray();
                        messageLabel.setText("Resim Başarıyla Seçildi");

                    }catch (Exception exception){
                    messageLabel.setText("Resim Eklenirken Sıkıntı Oluştu");
                    exception.printStackTrace();
                }

            }
        });
    }
}
