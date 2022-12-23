import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class expendsWiew extends JFrame{
    private JPanel DışPanel;
    private JTable expenseTable;
    private JButton returnBackButton;

    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();

    public expendsWiew() {

        model = (DefaultTableModel) expenseTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Gider Tablosu");
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
    }


    private void CreateTable(){

        String[] columnNames = {

                "Gider Adı",   //String
                "Maliyet",   //int
                "Tipi",       //String
        };
        model.setColumnIdentifiers(columnNames);

        getExpense();
    }

    public void getExpense(){

        model.setRowCount(0);

        ArrayList<Expend> expends =new ArrayList<Expend>();

        expends=stuff.getExpend();
        if (expends!=null){

            System.out.println("Bağlantı Başarılı!");
            for (Expend expend: expends){
                Object[]add={expend.getName(),expend.getCost(),expend.getType()};

                model.addRow(add);

            }
        }
    }

}
