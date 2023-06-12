
package Employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import java.sql.*;
public class login extends JFrame implements ActionListener { 
    JTextField tusername,tpassword;
    login(){
        getContentPane().setBackground( Color.white);
        setLayout(null); 
        
        JLabel lblusername = new JLabel("USERNAME");
        lblusername .setBounds(40,20,100,30);
        add(lblusername);
        
        tusername = new JTextField();
        tusername .setBounds(150 , 20,150,30);
        add(tusername);
        
        JLabel lblpassword = new JLabel ("PASSWORD");
        lblpassword .setBounds(40,70,100,30);
        add(lblpassword);
        
       
         tpassword = new JTextField(); 
        tpassword .setBounds(150,70,150,30);
        add(tpassword);
        
        
        JButton login = new JButton ("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         Image i2 = i1 .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);// CONVERT  INTO IMAGE ICON 
        JLabel Image  = new JLabel(i3);
         Image.setBounds (350,0,200,200);
        add(Image);
         setSize(600,300);
       setLocation(450,200);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tusername.getText();// gettext means whatever  value is given in textfield  
            String password = tpassword.getText();
            
            connectivity  c = new connectivity();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs  = c.s.executeQuery(query);// excute query function //call  // excute the program and result will strore in resultset RS
           
           if(rs.next()){
               setVisible(false);//next class
               new Homepage();  
           }
           else{
               JOptionPane.showMessageDialog(null,"Invalid username or password");
               setVisible(false);
           }
        }catch(Exception e){
        e.printStackTrace();
    }
    }
    public static void main (String args []){
        new login();
}

}

