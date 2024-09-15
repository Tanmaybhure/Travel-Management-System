package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class DashBoard extends JFrame implements ActionListener{
    String username;
    JButton addpersonalDetails,viewpersonalDetails,updatepersonalDetails,deletepersonalDetails,checkpackages,bookpackages,viewpackages,viewhotels,bookhotels,viewbookhotels,destination,payment,calculator,notepad,about;
    DashBoard(String username1){
        username=username1;
        System.out.println(username);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel p1=new JPanel();
        setTitle("Travel Management System");
        p1.setLayout(null);
        p1.setBounds(0,0,1650,65);
        p1.setBackground(new Color(35, 178, 222));
        add(p1);
        
        URL imageURL = getClass().getResource("/images/dashboard.png"); 
        ImageIcon i1 = new ImageIcon(imageURL);
        Image scale = i1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scale);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(5,0,70,70);
        setIconImage(i1.getImage());
        p1.add(image1); 
        
        URL imageURL1 = getClass().getResource("/images/home.jpg"); 
        ImageIcon i2 = new ImageIcon(imageURL1);
        Image scale1 = i2.getImage().getScaledInstance(1350, 1000,Image.SCALE_SMOOTH);
        i2 = new ImageIcon(scale1);
        JLabel image2 = new JLabel(i2);
        image2.setBounds(300,65,1350,1000);
       // setIconImage(i1.getImage());
        add(image2); 
        
        JLabel heading=new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway",Font.BOLD,20));
        p1.add(heading);
        
        JLabel Dname=new JLabel("Welcome "+username);
        Dname.setBounds(80,42,350,20);
        Dname.setForeground(Color.WHITE);
        Dname.setFont(new Font("Raleway",Font.PLAIN,14));
        p1.add(Dname);
        
        JLabel heading1=new JLabel("Travel and Tourism Management System");
        heading1.setBounds(1000,10,480,40);
        heading1.setForeground(Color.WHITE);
        heading1.setFont(new Font("Raleway",Font.BOLD,24));
        p1.add(heading1);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,65,300,900);
        p2.setBackground(new Color(35, 178, 222));
        add(p2);
        
        addpersonalDetails=new JButton("Add Personal Details");
        addpersonalDetails.setBounds(0,0,300,50);
        addpersonalDetails.setBackground(new Color(134, 143, 141));
        addpersonalDetails.addActionListener(this);
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Raleway",Font.PLAIN,18));
        addpersonalDetails.setFocusPainted(false);
        p2.add(addpersonalDetails);
        
        updatepersonalDetails=new JButton("Update Personal Details");
        updatepersonalDetails.setBounds(0,50,300,50);
        updatepersonalDetails.addActionListener(this);
        updatepersonalDetails.setBackground(new Color(134, 143, 141));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Raleway",Font.PLAIN,18));
        updatepersonalDetails.setFocusPainted(false);
        p2.add(updatepersonalDetails);
        
        viewpersonalDetails=new JButton("View Personal Details");
        viewpersonalDetails.setBounds(0,100,300,50);
        viewpersonalDetails.addActionListener(this);
        viewpersonalDetails.setBackground(new Color(134, 143, 141));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Raleway",Font.PLAIN,18));
        viewpersonalDetails.setFocusPainted(false);
        p2.add(viewpersonalDetails);
        
        deletepersonalDetails=new JButton("Delete Personal Details");
        deletepersonalDetails.setBounds(0,150,300,50);
        deletepersonalDetails.addActionListener(this);
        deletepersonalDetails.setBackground(new Color(134, 143, 141));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.setFont(new Font("Raleway",Font.PLAIN,18));
        deletepersonalDetails.setFocusPainted(false);
        p2.add(deletepersonalDetails);
        
        checkpackages=new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.addActionListener(this);
        checkpackages.setBackground(new Color(134, 143, 141));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Raleway",Font.PLAIN,18));
        checkpackages.setFocusPainted(false);
        p2.add(checkpackages);
        
        bookpackages=new JButton("Book Packages");
        bookpackages.addActionListener(this);
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(134, 143, 141));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Raleway",Font.PLAIN,18));
        bookpackages.setFocusPainted(false);
        p2.add(bookpackages);
        
        viewpackages=new JButton("View Packages");
        viewpackages.addActionListener(this);
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(134, 143, 141));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Raleway",Font.PLAIN,18));
        viewpackages.setFocusPainted(false);
        p2.add(viewpackages);
        
        viewhotels=new JButton("View Hotels");
        viewhotels.addActionListener(this);
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(134, 143, 141));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Raleway",Font.PLAIN,18));
        viewhotels.setFocusPainted(false);
        p2.add(viewhotels);
        
        bookhotels=new JButton("Book Hotel");
        bookhotels.addActionListener(this);
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(new Color(134, 143, 141));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Raleway",Font.PLAIN,18));
        bookhotels.setFocusPainted(false);
        p2.add(bookhotels);
        
        viewbookhotels=new JButton("View Book Hotel");
        viewbookhotels.addActionListener(this);
        viewbookhotels.setBounds(0,450,300,50);
        viewbookhotels.setBackground(new Color(134, 143, 141));
        viewbookhotels.setForeground(Color.WHITE);
        viewbookhotels.setFont(new Font("Raleway",Font.PLAIN,18));
        viewbookhotels.setFocusPainted(false);
        p2.add(viewbookhotels);
        
        destination=new JButton("Destination");
        destination.addActionListener(this);
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(134, 143, 141));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Raleway",Font.PLAIN,18));
        destination.setFocusPainted(false);
        p2.add(destination);
        
        payment=new JButton("Payment");
        payment.addActionListener(this);
        payment.setBounds(0,550,300,50);
        payment.setBackground(new Color(134, 143, 141));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Raleway",Font.PLAIN,18));
        payment.setFocusPainted(false);
        p2.add(payment);
        
        calculator=new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.addActionListener(this);
        calculator.setBackground(new Color(134, 143, 141));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Raleway",Font.PLAIN,18));
        calculator.setFocusPainted(false);
        p2.add(calculator);
        
        notepad=new JButton("Notepad");
        notepad.addActionListener(this);
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(134, 143, 141));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Raleway",Font.PLAIN,18));
        notepad.setFocusPainted(false);
        p2.add(notepad);
        
        about=new JButton("About");
        about.addActionListener(this);
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(134, 143, 141));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Raleway",Font.PLAIN,18));
        about.setFocusPainted(false);
        p2.add(about);
        

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonalDetails){
            System.out.println(username);
            new AddCustomer(username);
        }else if(ae.getSource()==viewpersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource()==updatepersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkpackages){
            new CheckPackage();
        }else if(ae.getSource()==bookpackages){
            new BookPackage(username);
        }else if (ae.getSource()==viewpackages){
            new Viewpackage(username);
        }
        else if(ae.getSource()==viewhotels){
            new CheckHotels();     
        }
    }
    public static void main(String[] args){
        new DashBoard("");
    }
}
