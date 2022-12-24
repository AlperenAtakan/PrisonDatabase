import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class PrisonerUpdate extends JFrame{

    private JTextField prisonerName;

    private JTextField prisonerHeight;
    private JTextField prisonerWeight;
    private JTextField prisonerReleaseDate;
    private JTextField prisonerTC;
    private JTextField prisonerAge;
    private JTextField prisonerGender;
    private JLabel messageLabel;
    private JTextField prisonerPunishmenttime;
    private JTextField prisonerID;

    prisonStuff stuff =new prisonStuff();
    private JPanel Dışpanel;
    private JButton updateButton;
    private JButton returnButton;
    private JTextField prisonerLastname;
    private JLabel imageLabel;
    private JPanel prisonerImageField;
    private JButton imageChooseButton;
    byte [] prisoner_photo=null;
    String filename=null;


    public PrisonerUpdate(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Mahkum Güncelleme/Görüntüleme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        prisonerID.setText( prisonerWiew.prisonerDatas[0].toString());
        prisonerName.setText((String)prisonerWiew.prisonerDatas[1]);
        prisonerLastname.setText((String) prisonerWiew.prisonerDatas[2]);
        prisonerHeight.setText(prisonerWiew.prisonerDatas[3].toString());
        prisonerWeight.setText( prisonerWiew.prisonerDatas[4].toString());
        prisonerReleaseDate.setText((String)prisonerWiew.prisonerDatas[5]);
        prisonerTC.setText((String) prisonerWiew.prisonerDatas[6]);
        prisonerAge.setText(prisonerWiew.prisonerDatas[7].toString());
        byte[] byte_photo = prisonerWiew.prisoner.getImage();
        ImageIcon imageIcon=new ImageIcon(new ImageIcon(byte_photo).getImage().getScaledInstance(300,240, Image.SCALE_SMOOTH));
        imageLabel.setIcon(imageIcon);
        if (prisonerWiew.prisonerDatas[8].toString().equals("1")){

            prisonerGender.setText("Erkek");
        }else {
            prisonerGender.setText("Kadın");}

        prisonerPunishmenttime.setText(prisonerWiew.prisonerDatas[9].toString());



        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText(" ");



                int ID= Integer.parseInt(prisonerID.getText());
                String name= prisonerName.getText();
                String lastname=prisonerLastname.getText();
                int height= Integer.parseInt(prisonerHeight.getText());
                int weight= Integer.parseInt(prisonerWeight.getText());
                String releaseDate=prisonerReleaseDate.getText();
                String TC=prisonerTC.getText();
                int age= Integer.parseInt(prisonerAge.getText());
                String gender= (prisonerGender.getText());
                int gender1;
                if (gender.equals("Erkek")){
                    gender1=1;
                }else{
                    gender1=0;
                }
                int punishmenttime= Integer.parseInt(prisonerPunishmenttime.getText());
                byte[] photo = prisoner_photo;


                stuff.updatePrisoner(ID,name,lastname,height,weight,releaseDate,TC,age,gender1,punishmenttime,photo);


                messageLabel.setText("Mahkum Bilgileri Güncelleme Başarılı!");


            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                prisonerWiew prisonerWiew= new prisonerWiew();
                prisonerWiew.setVisible(true);
            }
        });
        imageChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try{
                    JFileChooser chooser=new JFileChooser();
                    chooser.showOpenDialog(null);
                    File f=chooser.getSelectedFile();
                    filename=f.getAbsolutePath();



                    ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(prisonerImageField.getWidth(),prisonerImageField.getHeight(), Image.SCALE_SMOOTH));
                    imageLabel.setIcon(imageIcon);
                    File image=new File(filename);
                    FileInputStream fis=new FileInputStream(image);
                    ByteArrayOutputStream bos =new ByteArrayOutputStream();
                    byte[] buf=new byte [1024];
                    for (int readNum;(readNum=fis.read(buf))!=-1;){
                        bos.write(buf,0,readNum);
                    }
                    prisoner_photo= bos.toByteArray();

                }catch (Exception exception){
                    messageLabel.setText("Resim seçme hatalı!");
                    exception.printStackTrace();
                }

            }
        });
    }
}
