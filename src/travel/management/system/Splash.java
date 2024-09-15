package travel.management.system;
import javax.swing.*;
import java.net.URL;
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread thread;
    @Override
    public void run(){
        try{
            Thread.sleep(7000);
            //new Login();
            setVisible(false);
            Login l1=new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      public Splash(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Travel Management System");
        thread=new Thread(this);
        URL imageURL = ClassLoader.getSystemResource("images/splash.jpg");
        System.out.println(imageURL);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image scaledImage = icon.getImage().getScaledInstance(1200, 600,Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            JLabel image= new JLabel(icon);
            getContentPane().add(image);
            //setIconImage(icon.getImage());
        } else {
            System.err.println("Image not found: images/splash.jpg");
        }
            thread.start();
         pack(); 
         setVisible(true);
    }
    public static void main(String[] args){
       Splash frame= new Splash();
       int x=1;
       for(int i=1;i<=560;x+=7,i+=6){
           frame.setLocation(750-(x+i)/2,400-(i/2));
           frame.setSize(i+x,i);
           try{
               Thread.sleep(35);
           }catch(Exception e){
               e.printStackTrace();
           }
       }
    }
}
