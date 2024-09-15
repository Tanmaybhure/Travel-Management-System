package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.LineBorder;
public class Signup extends JFrame implements ActionListener{
    JButton back,signup;
    JTextField lblusertext,lblnametext,lblpasstext,lblanstext;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Signup");
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        add(p1);
                
        JLabel lblUserName =new JLabel("UserName");
        lblUserName.setFont(new Font("Tahoma",Font.BOLD,17));
        lblUserName.setBounds(50,20,125,25);
        p1.add(lblUserName);
        
        lblusertext=new JTextField();
        lblusertext.setBounds(195,20,200,25);
        lblusertext.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblusertext);
        
        JLabel lblname =new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,17));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        lblnametext=new JTextField();
        lblnametext.setBounds(195,60,200,25);
        lblnametext.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblnametext);
        
        JLabel lblpass =new JLabel("Password");
        lblpass.setFont(new Font("Tahoma",Font.BOLD,17));
        lblpass.setBounds(50,100,125,25);
        p1.add(lblpass);
        
        lblpasstext=new JTextField();
        lblpasstext.setBounds(195,100,200,25);
        lblpasstext.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblpasstext);
        
        JLabel lblsecurity =new JLabel("Security");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,17));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        
        security=new Choice();
        security.add("Favourite Movie Name");
        security.add("GrandFather Name");
        security.add("Marvel Character Name");
        security.add("Favourite Country");
        security.setBounds(195,140,200,35);
        p1.add(security);
        
        JLabel lblans =new JLabel("Answer");
        lblans.setFont(new Font("Tahoma",Font.BOLD,17));
        lblans.setBounds(50,180,125,25);
        p1.add(lblans);
        
        lblanstext=new JTextField();
        lblanstext.setBounds(195,180,200,25);
        lblanstext.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(lblanstext);
        
        signup=new JButton();
        signup.setText("Signup");
        signup.setFont(new Font("Tahoma",Font.BOLD,15));
        signup.setBounds(80,250,100,30);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setBackground(new Color(133,193,233));
        signup.setBorder(new LineBorder(Color.WHITE));
        p1.add(signup);
        
        back=new JButton();
        back.setText("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.setBounds(200,250,100,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBackground(new Color(133,193,233));
        back.setBorder(new LineBorder(Color.WHITE));
        p1.add(back);
        
        URL imageURL = getClass().getResource("/images/signup.png");
        ImageIcon i1 = new ImageIcon(imageURL);
        Image scale = i1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scale);
        JLabel image1 = new JLabel(i1);
        setIconImage(i1.getImage());
        image1.setBounds(580,30,250,250);
        add(image1); 
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource()==signup){
            String username= lblusertext.getText();
            String name=lblnametext.getText();
            String password=lblpasstext.getText();
            String quetion= security.getSelectedItem();
            String answer= lblanstext.getText();
           // System.out.println(username+""+name+""+password+""+quetion+""+answer);
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+quetion+"','"+answer+"');";
            //System.out.println(query);
            try{
            Conn c= new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Welcome "+name+". Your Account Created Successfully");
            setVisible(false);
            c.s.close();
            new Login().setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new Signup();
    }
}
