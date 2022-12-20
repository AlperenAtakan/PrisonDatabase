import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuthorityScreen0  extends JFrame{
    private JPanel panel1;
    private JButton goButton;
    private JButton returnBackButton;
    private JTable table1;
    private JLabel messageLabel;

    static boolean authoritytableClicked=false;
    static String tableRowName="";

    static boolean tableClicked=false;
    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();
    public AuthorityScreen0(){
        model = (DefaultTableModel)table1.getModel();
        add(panel1);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Yetki Seviyesi : Müdür");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateAuthorTable();


        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginScreen loginScreen=new LoginScreen();
                setVisible(false);
                loginScreen.setVisible(true);
            }
        });


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                messageLabel.setText(" ");
                model = (DefaultTableModel) table1.getModel();
                int selected=table1.getSelectedRow();
                tableRowName="";
                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Tablo Boş !");
                    }
                    else {
                        messageLabel.setText("Öncelikle Tablo Seçin");
                    }
                }else{
                    tableClicked = true;

                    tableRowName= model.getValueAt(selected,0).toString();


                }

            }
        });
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (tableRowName.equals("Yetkililer")){


                } else if (tableRowName.equals("Mahkumlar")) {

                    prisonerWiew prisonerWiew = new prisonerWiew();
                    setVisible(false);
                    prisonerWiew.setVisible(true);

                } else if (tableRowName.equals("Hücreler")) {

                    cellWiew2 cellWiew2=new cellWiew2();
                    setVisible(false);
                    cellWiew2.setVisible(true);

                } else if (tableRowName.equals("Personeller")) {




                } else if (tableRowName.equals("Yemekler")) {


                } else if (tableRowName.equals("Giderler")) {
                    
                } else if (tableRowName.equals("Gardiyanlar")) {
                    guardWiew guardWiew = new guardWiew();
                    setVisible(false);
                    guardWiew.setVisible(true);

                } else {
                    messageLabel.setText("Öncelikle Bir Tablo Seçin !");
                }


            }
        });
    }
    private void CreateAuthorTable(){

        model = (DefaultTableModel) table1.getModel();
        String[] columnNames = {
                " "
        };

        String[] rawNames={
                "Yetkililer",
                "Mahkumlar",
                "Hücreler",
                "Gardiyanlar",
                "Personeller",
                "Yemekler",
                "Giderler"
        };

        model.setColumnIdentifiers(columnNames);
        for (int i=0;i<rawNames.length;i++){
            model.addRow(new String[]{rawNames[i]});
        }




}}
