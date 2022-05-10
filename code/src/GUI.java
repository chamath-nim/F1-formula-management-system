import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends Formula1Driver{

    static actions myAction = new actions();

    public static void guiMenu() {
        JFrame fmenu = new JFrame("Menu");
        JButton b1 = new JButton("button 1");
        JButton b2 = new JButton("button 2");
        JButton b3 = new JButton("button 3");
        JButton b4 = new JButton("button 4");
        JButton b5 = new JButton("button 5");
        JButton b6 = new JButton("button 6");
        JButton b7 = new JButton("button 7");

        JLabel l1 = new JLabel("Sort drivers descending order according to the points");
        JLabel l2 = new JLabel("Sort drivers ascending order according to the points");
        JLabel l3 = new JLabel("Sort drivers descending order according to the 1st positions");
        JLabel l4 = new JLabel("Generate random races and positions by existing players");
        JLabel l5 = new JLabel("Generate random races and positions according to the probability");
        JLabel l6 = new JLabel("Sort all races ascending order according to the date");
        JLabel l7 = new JLabel("Display participated races and position by a selected driver");

        b1.setBounds(50, 30, 80, 30);
        b2.setBounds(50, 80, 80, 30);
        b3.setBounds(50, 130, 80, 30);
        b4.setBounds(50, 180, 80, 30);
        b5.setBounds(50, 230, 80, 30);
        b6.setBounds(50, 280, 80, 30);
        b7.setBounds(50, 330, 80, 30);

        l1.setBounds(140, 30, 350, 30);
        l2.setBounds(140, 80, 350, 30);
        l3.setBounds(140, 130, 350, 30);
        l4.setBounds(140, 180, 350, 30);
        l5.setBounds(140, 230, 350, 30);
        l6.setBounds(140, 280, 350, 30);
        l7.setBounds(140, 330, 350, 30);

        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);
        b7.setFocusable(false);

        fmenu.add(b1);
        fmenu.add(b2);
        fmenu.add(b3);
        fmenu.add(b4);
        fmenu.add(b5);
        fmenu.add(b6);
        fmenu.add(b7);

        fmenu.add(l1);
        fmenu.add(l2);
        fmenu.add(l3);
        fmenu.add(l4);
        fmenu.add(l5);
        fmenu.add(l6);
        fmenu.add(l7);

        fmenu.setSize(550, 430);
        fmenu.setLayout(null);
        fmenu.setVisible(true);

        ActionListener a = e -> {
            fmenu.dispose();
            if (e.getSource() == b1) myAction.window1();
            if (e.getSource() == b2) myAction.window2();
            if (e.getSource() == b3) myAction.window3();
            if (e.getSource() == b4) myAction.window4();
//                if (e.getSource() == b5) myAction.window5();
            if (e.getSource() == b6) myAction.window6();
            if (e.getSource() == b7) myAction.window7();
        };
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);


    }
}

class actions{

    Formula1ChampionshipManager fcm = new Formula1ChampionshipManager();

    String[][] data1 = new String[0][3];
    String[][] data2 ={{"",""}};

    public void window1(){
        ArrayList<Formula1Driver> myArray = Formula1Driver.sortByPoints();
        JFrame window = new JFrame();

        JButton q1 =new JButton("Quit");
        q1.setBounds(570,350,80,30);
        q1.setFocusable(false);
        JTable t1 = new JTable();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Points","Name","Team","Location","1st","2nd","3rd"}, 0);
        for(Formula1Driver dr : myArray){
            model.addRow(new Object[]{dr.point, dr.data.get(0),dr.data.get(1),dr.data.get(2),dr.positionData.get(0),
                                        dr.positionData.get(1),dr.positionData.get(2)});
        }

        t1.setModel(model);
        t1.setEnabled(false);
        JScrollPane sp=new JScrollPane(t1);
        window.add(q1);
        window.add(sp);
        window.setTitle("window 1");
        window.setSize(700, 450);
        window.setResizable(false);

        window.setVisible(true);

        q1.addActionListener(new ActionListener() { //Anonymous new ActionListener() can be replaced with lambda
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                if (e.getSource() == q1) GUI.guiMenu();
            }
        });


    }
    public void window2(){

        ArrayList<Formula1Driver> myArray = Formula1Driver.sortByPoints();
        JFrame window = new JFrame();

        JButton q2 =new JButton("Quit");
        q2.setBounds(570,350,80,30);
        q2.setFocusable(false);
        JTable t1 = new JTable();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Points","Name","Team","Location","1st","2nd","3rd"}, 0);
        for (int i = myArray.size()-1; i>=0; i--){
            model.addRow(new Object[]{myArray.get(i).point, myArray.get(i).data.get(0), myArray.get(i).data.get(1),
                    myArray.get(i).data.get(2),myArray.get(i).positionData.get(0),myArray.get(i).positionData.get(1),
                    myArray.get(i).positionData.get(2)});
        }

        t1.setModel(model);
        t1.setEnabled(false);
        JScrollPane sp=new JScrollPane(t1);
        window.add(q2);
        window.add(sp);
        window.setTitle("window 2");
        window.setSize(700, 450);
        window.setResizable(false);
        window.setVisible(true);

        q2.addActionListener(e -> {
            window.dispose();
            if (e.getSource() == q2) GUI.guiMenu();
        });

    }
    public void window3(){
        ArrayList<Formula1Driver> myArray1 = Formula1Driver.sortByPositions();
        JFrame window = new JFrame();

        JButton q3 =new JButton("Quit");
        q3.setBounds(570,350,80,30);
        q3.setFocusable(false);
        JTable t1 = new JTable();

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Points","Name","Team","Location","1st","2nd","3rd"}, 0);
        for (int i = myArray1.size()-1; i>=0; i--){
            model.addRow(new Object[]{myArray1.get(i).point, myArray1.get(i).data.get(0), myArray1.get(i).data.get(1),
                    myArray1.get(i).data.get(2),myArray1.get(i).positionData.get(0),myArray1.get(i).positionData.get(1),
                    myArray1.get(i).positionData.get(2)});
        }

        t1.setModel(model);
        t1.setEnabled(false);
        JScrollPane sp=new JScrollPane(t1);

        window.add(q3);
        window.add(sp);
        window.setTitle("window 3");
        window.setSize(700, 450);
        window.setResizable(false);
        window.setVisible(true);

        q3.addActionListener(e -> {
            window.dispose();
            if (e.getSource() == q3) GUI.guiMenu();
        });

    }

    public void window4(){
        ArrayList<Formula1Driver> myArray = Formula1Driver.sortByPoints();
        JFrame f=new JFrame();

        JButton generate = new JButton("generate");
        generate.setBounds(100,440,100,33);
        f.add(generate);

        JButton q4 = new JButton("Quit");
        q4.setBounds(100,480,100,33);
        f.add(q4);

        generate.setFocusable(false);
        q4.setFocusable(false);

        JTable t1=new JTable();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Points","Name","Team","Location","1st","2nd","3rd"}, 0);
        for (Formula1Driver formula1Driver : myArray) {
            model.addRow(new Object[]{formula1Driver.point, formula1Driver.data.get(0), formula1Driver.data.get(1),
                    formula1Driver.data.get(2), formula1Driver.positionData.get(0), formula1Driver.positionData.get(1),
                    formula1Driver.positionData.get(2)});
        }
        t1.setEnabled(false);
        t1.setModel(model);
        JPanel pp = new JPanel();
        pp.setBounds(630,200,600,300);


        String[] column1={"Name","Start Position","End Position"};
        JTable jj = new JTable(data1,column1);
        JScrollPane sp=new JScrollPane(jj);
        pp.add(sp);
        f.add(pp);

        jj.setEnabled(false);
        JScrollPane spp =new JScrollPane(t1);
        f.add(spp);
        f.setSize(1200,700);
        f.setVisible(true);
        f.setResizable(false);

        ActionListener a4 = e -> {
            if (e.getSource() == q4) {
                f.dispose();
                GUI.guiMenu();
            }
            if (e.getSource() == generate) {
                f.dispose();
                data1 = fcm.nameListR();
                window4();
            }
        };
        q4.addActionListener(a4);
        generate.addActionListener(a4);

    }
//    public void window5(){
//        window.setTitle("window 1");
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setSize(500, 450);
//        window.setLayout(null);
//        window.setVisible(true);
//
//    }
    public void window6(){

            JFrame window = new JFrame();
            ArrayList<Formula1Driver> myArray6 = Formula1Driver.sortByDate();

            JButton q6 =new JButton("Quit");
            q6.setBounds(570,350,80,30);
            q6.setFocusable(false);
            JTable t1 = new JTable();

            DefaultTableModel model = new DefaultTableModel(new Object[]{"Date and Time","1st","2nd","3rd"}, 0);
            for (Formula1Driver formula1Driver : myArray6) {
                model.addRow(new Object[]{formula1Driver.date, formula1Driver.namePosList.get(0), formula1Driver.namePosList.get(1),
                        formula1Driver.namePosList.get(2)});
            }

            t1.setModel(model);
            t1.setEnabled(false);
            JScrollPane sp=new JScrollPane(t1);

            window.add(q6);
            window.add(sp);
            window.setTitle("window 6");
            window.setSize(700, 450);
            window.setResizable(false);
            window.setVisible(true);

            q6.addActionListener(e -> {
                window.dispose();
                if (e.getSource() == q6) GUI.guiMenu();
            });
    }

    public void window7() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton b = new JButton("submit");
        JTextField t = new JTextField(16);
        b.setFocusable(false);
        panel.add(b);panel.add(t);

        String[] column1 ={"The date, race have taken place","Position"};

        JTable jj = new JTable(data2,column1);
        panel.add(new JScrollPane(jj));
        JButton q7 =new JButton("Quit");
        q7.setFocusable(false);
        panel.add(q7);

        frame.add(panel);
        frame.setTitle("window 7");
        frame.setSize(750, 530);
        frame.setResizable(false);
        frame.setVisible(true);

        ActionListener a7 = e -> {
            if (e.getSource()==q7){
                frame.dispose();
                GUI.guiMenu();
            }
            if (e.getSource()==b){
                frame.dispose();
                data2 = fcm.details(t.getText().toUpperCase());
                window7();
            }
        };
        b.addActionListener(a7);
        q7.addActionListener(a7);
    }
}
