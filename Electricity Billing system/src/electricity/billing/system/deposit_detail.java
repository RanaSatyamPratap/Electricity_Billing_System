package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deposit_detail extends JFrame implements ActionListener {



    Choice searchMeterCho ,searchMonthCho ;
    JTable table;
    JButton search, print,close;

    deposit_detail() {
        super("Deposit Detail");
        getContentPane().setBackground(new Color(192, 186, 254));
        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);



        JLabel searchByMeterNo = new JLabel("Search By Meter No");
        searchByMeterNo.setBounds(20,20,150,20);
        add(searchByMeterNo);

        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from bill");
            while (resultSet.next()){
                searchMeterCho.add(resultSet.getString("meter_no"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel searchName = new JLabel("Search By Month");
        searchName.setBounds(400,20,100,20);
        add(searchName);

        searchMonthCho = new Choice();
        searchMonthCho.setBounds(500,20,150,20);
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        add(searchMonthCho);

        table = new JTable();
        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20,70,100,25);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(170,70,100,25);
        print.addActionListener(this);
        add(print);

        close = new JButton("Close");
        close.setBounds(550,70,100,25);
        close.addActionListener(this);
        add(close);





        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query_search = "select * from bill where meter_no = '" + searchMeterCho.getSelectedItem() + "' and month = '" + searchMonthCho.getSelectedItem() + "'";
            try {
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource()==print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new deposit_detail();
    }
}

