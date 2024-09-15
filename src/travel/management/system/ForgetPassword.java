package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField lblusername, lblname, lblsecurity,lblpassword, lblanswer;
    JButton retrive, back, search;
    
    ForgetPassword(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(350,200,900,380);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Forget Password");
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,550,280);
        add(p1);
        
        URL imageURL = getClass().getResource("/images/forgotpassword.jpg");
        ImageIcon i1 = new ImageIcon(imageURL);
        Image scale = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scale);
        JLabel image1 = new JLabel(i1);
        setIconImage(i1.getImage());
        image1.setBounds(630,50,200,200);
        add(image1); 
        
        JLabel lblUserName =new JLabel("UserName");
        lblUserName.setFont(new Font("Tahoma",Font.BOLD,16));
        lblUserName.setBounds(50,20,125,25);
        p1.add(lblUserName);
        
        lblusername=new JTextField();
        lblusername.setBounds(185,20,200,25);
        lblusername.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblusername);
        
        search=new JButton();
        search.setText("Search");
        search.setBounds(400,20,130,25);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        search.setBackground(new Color(133,193,233));
        search.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(search);
        
        JLabel lblName =new JLabel("Name");
        lblName.setFont(new Font("Tahoma",Font.BOLD,16));
        lblName.setBounds(50,60,125,25);
        p1.add(lblName);
        
        lblname=new JTextField();
        lblname.setEditable(false);
        lblname.setBounds(185,60,200,25);
        lblname.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblname);
        
        JLabel lblSecurity =new JLabel("Security Que");
        lblSecurity.setFont(new Font("Tahoma",Font.BOLD,16));
        lblSecurity.setBounds(50,100,125,25);
        p1.add(lblSecurity);
        
        lblsecurity=new JTextField();
        lblsecurity.setEditable(false);;
        lblsecurity.setBounds(185,100,200,25);
        lblsecurity.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblsecurity);
        
        JLabel lblAnswer =new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahoma",Font.BOLD,16));
        lblAnswer.setBounds(50,140,125,25);
        p1.add(lblAnswer);
        
        lblanswer=new JTextField();
        lblanswer.setBounds(185,140,200,25);
        lblanswer.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblanswer);
        
        retrive=new JButton();
        retrive.setText("Retrive");
        retrive.setBounds(400,140,130,25);
        retrive.setForeground(Color.WHITE);
        retrive.addActionListener(this);
        retrive.setBackground(new Color(133,193,233));
        retrive.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(retrive);
        
        JLabel lblPassword =new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,16));
        lblPassword.setBounds(50,180,125,25);
        p1.add(lblPassword);
        
        lblpassword=new JTextField();
        lblpassword.setEditable(false);
        lblpassword.setBounds(185,180,200,25);
        lblpassword.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblpassword);
        
        back=new JButton();
        back.setText("Back");
        back.setBounds(185,230,130,25);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBackground(new Color(133,193,233));
        back.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(back);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        ResultSet rs;
        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        } else if(ae.getSource()==search){
            String query="Select * from account where username='"+lblusername.getText()+"'";
            try{
            Conn c=new Conn();
            rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblsecurity.setText(rs.getString("security"));
                
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==retrive){
             String query="Select * from account where username='"+lblusername.getText()+"'";
             String answer;
             String ans=lblanswer.getText();
            try{
            Conn c=new Conn();
            rs=c.s.executeQuery(query);
            while(rs.next()){
               answer=rs.getString("answer");
               String password=rs.getString("password");
               if(answer.compareTo(ans)==0){
                    lblpassword.setText(password);
                    c.s.close();
                }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Answer");
               }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new ForgetPassword();
    }
}
