package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String acctype;
    String meter_pass;

    main_class(String acctype, String meter_pass){
        this.meter_pass= meter_pass;
        this.acctype = acctype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageicon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imagelabel = new JLabel(imageIcon2);
        add(imagelabel);



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 18));



        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,15));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        newcustomer.setBackground(new Color(33, 150, 243));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);


        JMenuItem customerDetails = new JMenuItem("Customer Detail");
        customerDetails.setFont((new Font("monospaced",Font.PLAIN, 15)));
        ImageIcon customerDetailsimg = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerDetailsImage = customerDetailsimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        customerDetails.setBackground(new Color(33, 150, 243));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);


        JMenuItem depositDetail = new JMenuItem(("Deposit Detail"));
        depositDetail.setFont((new Font("monospaced",Font.PLAIN, 15)));
        ImageIcon depositDetailImg = new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositDetailImage = depositDetailImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetail.setIcon(new ImageIcon(depositDetailImage));
        depositDetail.setBackground(new Color(33, 150, 243));
        depositDetail.addActionListener(this);
        menu.add(depositDetail);


        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon calculateBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBillImage = calculateBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        calculateBill.setBackground(new Color(33, 150, 243));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);



        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif", Font.PLAIN, 18));


        JMenuItem upInformation = new JMenuItem("Update Information");
        upInformation.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon upInformationImg = new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upInformationImage = upInformationImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upInformation.setIcon(new ImageIcon(upInformationImage));
        upInformation.setBackground(new Color(33, 150, 243));
        upInformation.addActionListener(this);
        info.add(upInformation);


        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon viewInfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewInfoImage = viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.setBackground(new Color(33, 150, 243));
        viewInfo.addActionListener(this);
        info.add(viewInfo);



        JMenu user = new JMenu("User");
        user.setFont(new Font("serif", Font.PLAIN, 18));


        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image paybillImage = paybillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillImage));
        paybill.setBackground(new Color(33, 150, 243));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image billdetailsImage = billdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.setBackground(new Color(33, 150, 243));
        billdetails.addActionListener(this);
        user.add(billdetails);


        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif", Font.PLAIN, 18));


        JMenuItem genbill = new JMenuItem("Generate Bill");
        genbill.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon genbillImg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genbillImage = genbillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genbill.setIcon(new ImageIcon(genbillImage));
        genbill.setBackground(new Color(33, 150, 243));
        genbill.addActionListener(this);
        bill.add(genbill);


        JMenu utility = new JMenu("Utiliy");
        utility.setFont(new Font("serif", Font.PLAIN, 18));
        menuBar.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.setBackground(new Color(33, 150, 243));
        notepad.addActionListener(this);
        utility.add(notepad);


        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.setBackground(new Color(33, 150, 243));
        calculator.addActionListener(this);
        utility.add(calculator);



        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.PLAIN, 18));


        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced", Font.PLAIN,15));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image eexitImage = eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.setBackground(new Color(115, 173, 220));
        eexit.addActionListener(this);
        exit.add(eexit);


        if (acctype.equals("Admin")){
            menuBar.add(menu);
        }else {

            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);


        setLayout(new FlowLayout());
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")){
            new newCustomer();
        } else if (msg.equals("Customer Detail")) {
            new customer_detail();
        }else if (msg.equals("Deposit Detail")){
            new deposit_detail();
        } else if (msg.equals("Calculate Bill")) {
            new calculateBill();
        } else if (msg.equals("View Information")) {
            new view_information(meter_pass);
        }else if (msg.equals("Update Information")){
            new update_information(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new bill_details(meter_pass);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
            
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();

        } else if (msg.equals("Pay Bill")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }
    }

    public static void main(String[] args) {
        new main_class("","");
    }
}
