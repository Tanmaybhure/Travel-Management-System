package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class UpdateCustomer extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
        JButton add, back;
        String username;
    UpdateCustomer(String name){
        this.username=name;
        System.out.println(username);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 550);
        setTitle("Update Personal Details");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                getContentPane().setBackground(Color.WHITE);
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("images/update.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(550,40,300,600);
                setIconImage(i2.getImage());
                add(l1);
		
		JLabel lblName = new JLabel("Update Customer Details");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 8, 260, 53);
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
		t8.setBounds(271, 390, 200, 20);
		contentPane.add(t8);
		t8.setColumns(10);
                
                add=new JButton();
                add.setText("Update");
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
                   Conn c=new Conn();
                   String query="Select * from customer where name='"+username+"'";
                   System.out.println(query);
                   ResultSet rs=c.s.executeQuery(query);
                   while(rs.next()){
                        String idType = rs.getString("id");
                        String gender = rs.getString("gender");
        
                        if("Passport".equals(idType)) {
                            comboBox.setSelectedIndex(0); 
                        } else if ("Aadhar Card".equals(idType)) {
                            comboBox.setSelectedIndex(1); 
                        } else if ("Voter Id".equals(idType)) {
                            comboBox.setSelectedIndex(2);
                        } else if ("Driving license".equals(idType)) {
                            comboBox.setSelectedIndex(3); 
                        }
                        t7.setText(rs.getString("username"));  
                        t2.setText(rs.getString("name"));
                        t1.setText(rs.getString("number"));
                        t3.setText(rs.getString("country"));
                        t5.setText(rs.getString("address"));
                        t6.setText(rs.getString("phone"));
                        t8.setText(rs.getString("email"));
                        if ("Male".equals(gender)) {
                            r1.setSelected(true);
                        } else if ("Female".equals(gender)) {
                            r2.setSelected(true);
                        }
                   }
                }catch(Exception e)
                {
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
                String query = "UPDATE customer SET id='" + id + "', number='" + number + "', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "'where name='"+username+"'";
                System.out.println(query);
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Update Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
    }else if(ae.getSource()==back){
        setVisible(false);
    }
    }    
    public static void main(String[] args){
        new UpdateCustomer("");
    }
}