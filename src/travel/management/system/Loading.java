package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    JProgressBar bar;
    Thread t;
    String name;
    Loading(String name){
        this.name=name;
        System.out.println(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,200,650,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Travel Management System");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Raleway",Font.BOLD,32));
        heading.setBounds(100,20,500,40);
        add(heading);
        
        bar= new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        t=new Thread(this);
        t.start();
        JLabel user=new JLabel("Welcome "+name);
        user.setForeground(Color.RED);
        user.setFont(new Font("Raleway",Font.BOLD,18));
        user.setBounds(200,300,400,40);
        add(user);
        
        setVisible(true);
    }
    @Override
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    Thread.sleep(50);
                    System.out.println(name);
                    new DashBoard(name);
                    break;
                }
                Thread.sleep(40);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Loading("");
    }
}
