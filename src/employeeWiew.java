import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class employeeWiew extends JFrame {


    private JPanel DışPanel;
    private JTextField SearchText;
    private JTable personelTable;
    private JLabel messageLabel;
    private JButton returnBackButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton addButton;
    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();
    public static Object[] EmployeeDatas= new Object[5];
    static boolean EmployeetableClicked=false;
    public employeeWiew(){

        model = (DefaultTableModel) personelTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Personel Tablosu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateTable();
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (LoginScreen.level==0){
                    AuthorityScreen0 authorityScreen0=new AuthorityScreen0();
                    setVisible(false);
                    authorityScreen0.setVisible(true);
                } else if (LoginScreen.level==1) {
                    AuthorityScreen1 authorityScreen1= new AuthorityScreen1();
                    setVisible(false);
                    authorityScreen1.setVisible(true);
                } else if (LoginScreen.level==2) {
                    AuthorityScreen2 authorityScreen2 = new AuthorityScreen2();
                    setVisible(false);
                    authorityScreen2.setVisible(true);
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EmployeetableClicked){
                    EmployeeUpdate employeeUpdate=new EmployeeUpdate();
                    setVisible(false);
                    employeeUpdate.setVisible(true);
                }else {
                    messageLabel.setText("Güncellemek için Personel seç!");
                }
            }
        });
        personelTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model = (DefaultTableModel) personelTable.getModel();
                int selected=personelTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Tablo Boş!");
                    }
                    else {
                        messageLabel.setText("Güncellemek İçin Personel Seç!");
                    }
                }else {

                    EmployeetableClicked = true;

                    int ID= (int) model.getValueAt(selected, 0);

                    String name= (String) model.getValueAt(selected, 1);

                    String lastname= (String) model.getValueAt(selected, 2);

                    String departman= (String) model.getValueAt(selected, 3);

                    String Job= (String) model.getValueAt(selected, 4);


                    EmployeeDatas[0] =ID;
                    EmployeeDatas[1] =name;
                    EmployeeDatas[2] =lastname;
                    EmployeeDatas[3] =departman;
                    EmployeeDatas[4] =Job;

                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");

                model = (DefaultTableModel) personelTable.getModel();
                int selected=personelTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Tablo Boş!");
                    }
                    else {
                        messageLabel.setText("Önce personel seçiniz!");
                    }
                }else {

                    int id=(int)model.getValueAt(selected,0);

                    stuff.deleteEmployee(id);
                    CreateTable();
                    messageLabel.setText("Personel Başarıyla Silindi!");


                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeAdd employeeAdd=new EmployeeAdd();
                setVisible(false);
                employeeAdd.setVisible(true);
            }
        });
        SearchText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String searh= SearchText.getText();

                dynamicSearc(searh);
            }
        });

    }
    public void dynamicSearc(String text){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);

        personelTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }
    private void CreateTable(){

        String[] columnNames = {
                "Personel ID",   //int
                "Ad",   //String
                "Soyad",    //String
                "Departman",       //String
                "Job"      //String

        };
        model.setColumnIdentifiers(columnNames);

        getEmployee();

    }
    public void getEmployee(){
        model.setRowCount(0);

        ArrayList<Employee> employees =new ArrayList<Employee>();

        employees=stuff.getEmployees();
        if (employees!=null){

            System.out.println("Bağlantı Başarılı!");
            for (Employee employee: employees){
                Object[]add={employee.getEmployeeID(),employee.getEmployeeName(),employee.getEmployeeLastName(),
                        employee.getDepartment(),employee.getJob()};

                model.addRow(add);
            }
        }
    }




}
