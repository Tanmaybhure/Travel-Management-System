package travel.management.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton Forget,login,signin;
    ImageIcon i1;
    JTextField lblusertext,lblpass;
    public Login() {
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350, 200);
        setTitle("Login");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel(new BorderLayout()); 
        p1.setBounds(0,0,400,400);
        p1.setBackground(new Color(131, 193, 233));
        getContentPane().add(p1);
        
        URL imageURL = getClass().getResource("/images/login.png"); // Use getClass() to get the resource
        i1 = new ImageIcon(imageURL);
        Image scale = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scale);
        JLabel image1 = new JLabel(i1);
        setIconImage(i1.getImage());
        p1.add(image1, BorderLayout.CENTER); 
        
        JPanel p2= new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(179, 225, 245));
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lblUserName =new JLabel("Username");
        lblUserName.setBounds(60,20,100,25);
        lblUserName.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblUserName);
        
        lblusertext= new JTextField();
        lblusertext.setBounds(60,60,300,30);
        lblusertext.setBorder(BorderFactory.createEmptyBorder());
        p2.add(lblusertext);
        
        JLabel lblPassword =new JLabel("Password");
        lblPassword.setBounds(60,110,100,25);
        lblPassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblPassword);
        
        lblpass= new JTextField();
        lblpass.setBounds(60,150,300,30);
        lblpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(lblpass);
        
        login=new JButton();
        login.setText("Login");
        login.setBounds(60,200,130,30);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBackground(new Color(133,193,233));
        login.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(login);
        
        signin=new JButton();
        signin.setText("Signup");
        signin.setBounds(220,200,130,30);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        signin.setBackground(new Color(133,193,233));
        signin.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(signin);
        
        Forget=new JButton();
        Forget.setText("Forget Password");
        Forget.setBounds(110,250,200,30);
        Forget.setForeground(Color.WHITE);
        Forget.addActionListener(this);
        Forget.setBackground(new Color(133,193,233));
        Forget.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(Forget);
        
        setVisible(true);  
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==signin){
            setVisible(false);
            new Signup().setVisible(true);
        }else if(ae.getSource()==Forget){
            setVisible(false);
            new ForgetPassword().setVisible(true);
        }else if(ae.getSource()==login){
            try{
               String username=lblusertext. getText();
               String password=lblpass.getText();
               Boolean userfound=false;
               //System.out.println(username +" "+ password);
               Conn c=new Conn();
               String query="select * from account where username='"+username+"';";
               //System.out.println(query);
               ResultSet rs=c.s.executeQuery(query);
               while(rs.next()){
                   String user=rs.getString("username");
                   String pass=rs.getString("password");
                   String name=rs.getString("name");
                   userfound=true;
                  // System.out.println(user+" "+pass+" "+name);
                   if(user.compareTo(username)==0 && pass.compareTo(password)==0){
                       setVisible(false);
                       c.s.close();
                       new Loading(name).setVisible(true);
                       break;
                   }
               }
               if(userfound!=true){
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        new Login();
    }
}
