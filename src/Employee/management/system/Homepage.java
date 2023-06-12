package Employee.management.system;

import javax.swing.*; // jframe access from swing so we have to import  
import java.awt.*; // for access image 
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener { //Homepage extends JFrame - we have to create frame so extend through homepage

    JButton view, update, remove, add;

    Homepage() { // constructor
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        // for uploading  image in the frame we have to use classloader and in classloader  there is static method "getsystemresourece"
        //and in getsystemresourece we have to pass address where the imagaes are saved 
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        //in image icon there is one 1 fuction getimage and in this getimaged there is one more method getscakedinstace we have to passes width,height,SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);// CONVERT  INTO IMAGE ICON 
        JLabel image = new JLabel(i3);
        // JLABLE _
        // YOU CANT  ADD DIRECT TO  IMAGE USE JLABLE 

        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee management system");
        heading.setBounds(650, 20, 400, 40);  // where you want to add your heading
        heading.setFont(new Font("TOHOMA", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add employee");
        add.addActionListener(this);
        add.setBounds(650, 80, 150, 40);
        image.add(add);

        view = new JButton("View employees");
        view.addActionListener(this);
        view.setBounds(820, 80, 150, 40);
        image.add(view);

        update = new JButton("Update employee");
        update.setBounds(650, 120, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove employee");
        remove.setBounds(820, 120, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
          setVisible(false);
          new Viewemployee();
        }
        
        else if (ae.getSource()== update){
             setVisible(false);
            new Viewemployee();
        }
         else{
            setVisible(false);
            new removeEmployee();
         }
    }

    public static void main(String[] args) {
        new Homepage(); // new object
    }
}
