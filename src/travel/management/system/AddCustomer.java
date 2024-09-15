package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class AddCustomer extends JFrame implements ActionListener{
    Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
        JButton add, back;
        String username;
    AddCustomer(String username){
        this.username=username;
        System.out.println(username);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 550);
        setTitle("Add Personal Details");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                getContentPane().setBackground(Color.WHITE);
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/newcustomer.jpg"));
                Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(450,40,450,420);
                add(l1);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t7 = new JTextField();
                t7.setEditable(false);
		t7.setBounds(271, 70, 150, 20);
		contentPane.add(t7);
		t7.setColumns(10);
                t7.setBackground(Color.WHITE);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 110, 150, 20);
                comboBox.setBackground(Color.WHITE);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                t2.setEditable(false);
                t2.setBackground(Color.WHITE);
                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 230, 100, 12);
		add(r2);
                
                ButtonGroup bg=new ButtonGroup();
                bg.add(r1);
                bg.add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(271, 270, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                t5 = new JTextField();
		t5.setBounds(271, 310, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(271, 350, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		t8 = new JTextField();
		t8.setBounds(271, 390, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);
                
                add=new JButton();
                add.setText("Add");
                add.setBounds(35,450,130,30);
                add.setForeground(Color.WHITE);
                add.addActionListener(this);
                add.setBackground(new Color(133,193,233));
                add.setBorder(new LineBorder(new Color(133,193,233)));
                contentPane.add(add);
                
                back=new JButton();
                back.setText("Back");
                back.setBounds(271,450,130,30);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBackground(new Color(133,193,233));
                back.setBorder(new LineBorder(new Color(133,193,233)));
                contentPane.add(back);
		
                try{
                    Conn c = new Conn();
                    System.out.println("Add customer "+username);
                    ResultSet rs = c.s.executeQuery("select * from account where name = '"+username+"'");
                    while(rs.next()){
                        t7.setText(rs.getString("username"));  
                        t2.setText(rs.getString("name"));
                    }
                }catch(Exception e){ 
                    e.printStackTrace();
                }
                setVisible(true);
                            	
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=t7.getText();
            String id= (String)comboBox.getSelectedItem();
            String number=t1.getText();
            String name=t2.getText();
            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }
            String country=t3.getText();
            String address=t5.getText();
            String phone=t6.getText();
            String email=t8.getText();
            
            try{
                Conn c=new Conn();
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
    }else if(ae.getSource()==back){
        setVisible(false);
    }
    }    
    public static void main(String[] args){
        new AddCustomer("");
    }
}