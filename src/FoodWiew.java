import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodWiew extends JFrame {
    private JPanel DışPanel;
    private JTable foodTable;
    private JButton returnBackButton;
    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();
    public static Object[] foodDatas= new Object[4];
    public FoodWiew(){
        model = (DefaultTableModel) foodTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Mahkum Tablosu");
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
                "Yemek Adı",   //String
                "Maliyet",   //int
                "Adet",    //int
                "Gün",       //String
        };
        model.setColumnIdentifiers(columnNames);

        getFood();
    }

    public void getFood(){

        model.setRowCount(0);

        ArrayList<Food> foods =new ArrayList<Food>();

        foods=stuff.getFood();
        if (foods!=null){

            System.out.println("Bağlantı Başarılı!");
            for (Food food: foods){
                Object[]add={food.getName(),food.getCost(),food.getCount(),food.getDay()};

                model.addRow(add);

            }
        }
    }
}
