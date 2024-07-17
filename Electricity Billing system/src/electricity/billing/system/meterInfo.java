package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    JLabel  meterLoc, metertyp, phaseCode, billtyp,day,note, note1;
    Choice meterLocCho, metertypCho, phaseCodeCho, billtypCho;
    JButton submit;

    String meternumber;

    meterInfo(String meternumber){
        this.meternumber = meternumber;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meterNumText = new JLabel(meternumber);
        meterNumText.setBounds(180,80,150,20);
        panel.add(meterNumText);

        meterLoc = new JLabel("Meter Location ");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);


        metertyp = new JLabel("Meter Type ");
        metertyp.setBounds(50,160,100,20);
        panel.add(metertyp);

        metertypCho = new Choice();
        metertypCho.add("Electric");
        metertypCho.add("Solar");
        metertypCho.add("Smart");
        metertypCho.setBounds(180,160,150,20);
        panel.add(metertypCho);

        phaseCode = new JLabel("Phase Code ");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        billtyp = new JLabel("Bill Type");
        billtyp.setBounds(50,240,100,20);
        panel.add(billtyp);

        billtypCho = new Choice();
        billtypCho.add("Normal");
        billtypCho.add("Industrial");
        billtypCho.setBounds(180,240,150,20);
        panel.add(billtypCho);

        day = new JLabel("30 Days billig Time.. ");
        day.setBounds(50,280,150,20);
        panel.add(day);

        note = new JLabel("Note:- ");
        note.setBounds(50,320,100,20);
        panel.add(note);

        note1 = new JLabel("By Default bill is calculated for 30 days  ");
        note1.setBounds(50,360,300,20);
        panel.add(note1);


        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.white);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);


        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        add(imgLabel,"East");
        setVisible(true);



        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
            String smeternum = meternumber;
            String smeterloc = meterLocCho.getSelectedItem();
            String smetertyp = metertypCho.getSelectedItem();
            String sphasecode = phaseCodeCho.getSelectedItem();
            String sbilltyp = billtypCho.getSelectedItem();
            String sday = "30";

            String query_meterinfo = "insert into meter_info values('"+smeternum+"','"+smeterloc+"','"+smetertyp+"','"+sphasecode+"','"+sbilltyp+"','"+sday+"')";


            try{
                database c = new database();
                c.statement.executeUpdate(query_meterinfo);

                JOptionPane.showMessageDialog(null,"Meter Information Submited Successfully.");
                setVisible(false);


            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
