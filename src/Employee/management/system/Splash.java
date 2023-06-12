
package Employee.management.system;
import javax .swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener { // actionlistener is a interface in this all method must we implement  // in actionlistner there is  method
    //" public void actionPerformed (ActionEvent ae)"we have to  override in the class 
    Splash(){ // constructor
        getContentPane ().setBackground(Color.black); // getContentPane ;- In Java Swing, the layer that is used to hold objects is called the content pane.
        //Objects are added to the content pane layer of the container. 
        //The getContentPane() method retrieves the content pane layer so that you can add an object to it
        //setbackground :- change the back ground color 
        setLayout(null); // for  making own layout we have set as null.//using no layout managers
        JLabel heading = new JLabel ("EMPLOYEE MANAGEMENT SYSTEM"); // for heading 
        heading .setBounds(80,30 ,1200,60); // for making own layout we have to use 1 method "setbounds"       
        // setbound method :-  take 4 argument first 2 lable where you have to set  x , y and last 2 lable for taking length and width
        heading.setFont(new Font ("serit",Font.PLAIN,60));
        heading.setForeground( Color.white);
         add (heading);
        ImageIcon i1 = new  ImageIcon(ClassLoader .getSystemResource("icons/front.jpg"));
        // for uploading  image in the frame we have to use classloader and in classloader  there is static method "getsystemresourece"
        //and in getsystemresourece we have to pass address where the imagaes are saved 
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        //in image icon there is one 1 fuction getimage and in this getimaged there is one more method getscakedinstace we have to passes width,height,SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);// CONVERT  INTO IMAGE ICON 
        JLabel image  = new JLabel(i3); 
        // JLABLE _
        // YOU CANT  ADD DIRECT TO  IMAGE USE JLABLE 
        image.setBounds (50,100,1050,500);
        add(image);
        
        JButton clickhere = new JButton("click here to continue");
        clickhere .setBounds(400,400,300,70);
        clickhere.setBackground(Color.white);
        clickhere .addActionListener(this); // click event call 
        image. add(clickhere); // if you want to add button on the top of image, // adding button in JFrame
        setSize(1170,650);
        setLocation(200,50);
        setVisible( true); //making the frame visible 
        while(true){
            heading.setVisible(false);
            try{
                Thread .sleep (500);
            } catch(Exception e){
        }
          heading.setVisible(true); 
             try{
                Thread .sleep (500);
            } catch(Exception e){
        }
        }
    }
     public void actionPerformed (ActionEvent ae) // overrriding 
             {
         setVisible(false);
         new login (); // when you create login object then constructor will call
         //and all coding are write in constructor  so  it open login frame 
     }
    
 
    public static void main ( String args[]){
        new Splash();
    }
}
