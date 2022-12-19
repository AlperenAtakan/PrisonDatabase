import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class cellDetailWiew extends JFrame {


    private JPanel DışPanel;
    private JTable cellDetailTable;
    private JTextField cellIDText;
    private JTextField cellSizeText;
    private JTextField cellCapacityText;
    private JTextField cellStuffCountText;
    private JTextField cellPrisonerCountText;
    private JButton prisonerDetailButton;
    private JButton returnBackButton;
    private JLabel messageLabel;
    static boolean cellDetailtableClicked=false;

    DefaultTableModel model;
    prisonStuff stuff= new prisonStuff();
    cellWiew2 cellWiew2=new cellWiew2();


    public cellDetailWiew(){

        model = (DefaultTableModel) cellDetailTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Guard Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cellIDText.setText(String.valueOf(cellWiew2.cellDetaildatas[0]));
        cellSizeText.setText(String.valueOf(cellWiew2.cellDetaildatas[1]));
        cellCapacityText.setText(String.valueOf(cellWiew2.cellDetaildatas[2]));
        cellStuffCountText.setText(String.valueOf(cellWiew2.cellDetaildatas[3]));
        cellPrisonerCountText.setText(String.valueOf(cellWiew2.cellDetaildatas[4]));
        CreateTable();


        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cellWiew2 cellWiew2=new cellWiew2();
                setVisible(false);
                cellWiew2.setVisible(true);
            }
        });
        cellDetailTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
        cellDetailTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model=(DefaultTableModel) cellDetailTable.getModel();
                int selected=cellDetailTable.getSelectedRow();
                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select prisoner to update!");
                    }
                }else{
                    cellDetailtableClicked=true;
                    int ID= (int) model.getValueAt(selected, 0);

                    String name= (String) model.getValueAt(selected, 1);

                    String lastname= (String) model.getValueAt(selected, 2);

                    int height= (int) model.getValueAt(selected, 3);

                    int weight= (int) model.getValueAt(selected, 4);

                    String releaseDate= (String) model.getValueAt(selected, 5);

                    String TC= (String) model.getValueAt(selected, 6);

                    int age= (int) model.getValueAt(selected, 7);

                    int gender;
                    if ( model.getValueAt(selected, 8).equals("Male")){
                        gender=1;

                    }else {
                        gender=0;
                    }
                    int punishmenttime= (int) model.getValueAt(selected, 9);

                    prisonerWiew.prisonerDatas[0] =ID;
                    prisonerWiew.prisonerDatas[1] =name;
                    prisonerWiew.prisonerDatas[2] =lastname;
                    prisonerWiew.prisonerDatas[3] =height;
                    prisonerWiew.prisonerDatas[4] =weight;
                    prisonerWiew.prisonerDatas[5] =releaseDate;
                    prisonerWiew.prisonerDatas[6] =TC;
                    prisonerWiew.prisonerDatas[7] =age;
                    prisonerWiew.prisonerDatas[8] =gender;
                    prisonerWiew.prisonerDatas[9] =punishmenttime;


                }
            }
        });
        prisonerDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cellDetailtableClicked){
                    PrisonerUpdate prisonerUpdate = new PrisonerUpdate();
                    setVisible(false);
                    prisonerUpdate.setVisible(true);
                }else {
                    messageLabel.setText("Select Prisoner Then Click Button!");
                }
            }
        });
    }

   public void CreateTable(){
        String[] columnNames = {
                "PrisonerID",   //int
                "First Name",   //String
                "Last Name",    //String
                "Height",       //int
                "Weight",       //int
                "ReleaseDate",  //String
                "TC",           //String
                "Age",          //int
                "Gender",        //String
                "Punishment Time"//String

        };
        model.setColumnIdentifiers(columnNames);
        getCellPrisoners(cellWiew2.cellID);
    }

    public void getCellPrisoners(int cellID){

        model.setRowCount(0);
        ArrayList<Prisoner> cellPrisoners = new ArrayList<Prisoner>();
        cellPrisoners=stuff.getCellPrisoner(cellID);

        if (cellPrisoners!=null){
            System.out.println("Bağlantı Başarılı");
            for (Prisoner prisoner : cellPrisoners){
                Object[]add={prisoner.getPrisonerID(),prisoner.getPrisonerName(),prisoner.getPrisonerLastName(),
                        prisoner.getHeight(),prisoner.getWeight(),prisoner.getReleaseDate(),prisoner.getTC(),
                        prisoner.getAge(),prisoner.getGender(),prisoner.getPunishmenTime()};
                model.addRow(add);
            }
        }

    }
}
