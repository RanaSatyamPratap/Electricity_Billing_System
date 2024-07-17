package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculateBill extends JFrame implements ActionListener {

    Choice meternumcho, monthcho ;
    JLabel nameText, addressText;
    TextField unitText;
    JButton submit, cancel;

    calculateBill(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(17,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);


        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(50,80,100,20);
        panel.add(meternum);

        meternumcho = new Choice();
        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while (resultSet.next()){
                meternumcho.add(resultSet.getString("meter_no"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        meternumcho.setBounds(180,80,100,20);
        panel.add(meternumcho);

        JLabel name = new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel();
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        JLabel address = new JLabel("Address");
        address.setBounds(50,160,150,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180,160,250,20);
        panel.add(addressText);

        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '"+meternumcho.getSelectedItem()+"'");
            while (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }



        meternumcho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '"+meternumcho.getSelectedItem()+"'");
                    while (resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JLabel unitconsumed = new JLabel("Unit Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitText = new TextField();
        unitText.setBounds(180,200,100,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthcho = new Choice();
        monthcho.add("January");
        monthcho.add("February");
        monthcho.add("March");
        monthcho.add("April");
        monthcho.add("May");
        monthcho.add("June");
        monthcho.add("July");
        monthcho.add("August");
        monthcho.add("September");
        monthcho.add("October");
        monthcho.add("November");
        monthcho.add("December");
        monthcho.setBounds(180,240,100,20);
        panel.add(monthcho);


        submit = new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imagelabel1 = new JLabel(imageIcon1);
        add(imagelabel1, "East");




        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String smeterNo = meternumcho.getSelectedItem();
            String sunit= unitText.getText();
            String smonth = monthcho.getSelectedItem();

            int totalBill = 0;
            int units =  Integer.parseInt(sunit);
            String query_text = "select * from tax";
            try{
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_text);
                while (resultSet.next()){
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("swacch_bharat"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));
                }

            }catch (Exception E){
                E.printStackTrace();
            }
            String query_total_bill = "insert into bill values('"+smeterNo+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }


        }
        else {
            setVisible(false);
        }


    }



    public static void main(String[] args) {
        new calculateBill();
    }
}
