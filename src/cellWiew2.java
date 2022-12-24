import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cellWiew2 extends  JFrame{
    public static int[] cellDetaildatas = new int[5];
    private JPanel DışPanel;
    private JButton CELL1Button;
    private JButton returnBackButton;
    private JButton CELL2;
    private JButton CELL3;
    private JButton CELL4;
    private JButton CELL5;
    private JButton CELL6;
    private JButton CELL7;
    private JButton CELL8;

    static int cellID;
    int cellSize;
    int cellCapacity;
    int cell_Stuff_count;
    int cell_Prisoner_count;
    cellDetailWiew cellDetailWiew;

    public cellWiew2(){
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Hücreler");
        cellWiew2.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        CELL1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=1;
                cellSize=10;
                cellCapacity=2;
                cell_Stuff_count=4;
                cell_Prisoner_count=2;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();

            }
        });
        CELL2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                cellID=2;
                cellSize=15;
                cellCapacity=3;
                cell_Stuff_count=4;
                cell_Prisoner_count=3;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
        CELL3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=3;
                cellSize=20;
                cellCapacity=4;
                cell_Stuff_count=5;
                cell_Prisoner_count=4;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });

        CELL4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=4;
                cellSize=25;
                cellCapacity=5;
                cell_Stuff_count=5;
                cell_Prisoner_count=4;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
        CELL5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=5;
                cellSize=30;
                cellCapacity=2;
                cell_Stuff_count=6;
                cell_Prisoner_count=2;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
        CELL6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=6;
                cellSize=15;
                cellCapacity=3;
                cell_Stuff_count=4;
                cell_Prisoner_count=3;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
        CELL7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=7;
                cellSize=15;
                cellCapacity=3;
                cell_Stuff_count=4;
                cell_Prisoner_count=2;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
        CELL8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellID=8;
                cellSize=15;
                cellCapacity=3;
                cell_Stuff_count=4;
                cell_Prisoner_count=2;

                cellDetaildatas[0]=cellID;
                cellDetaildatas[1]=cellSize;
                cellDetaildatas[2]=cellCapacity;
                cellDetaildatas[3]=cell_Stuff_count;
                cellDetaildatas[4]=cell_Prisoner_count;

                cellDetailWiew=new cellDetailWiew();
                setVisible(false);
                cellDetailWiew.setVisible(true);
                cellDetailWiew.CreateTable();
            }
        });
    }




}
