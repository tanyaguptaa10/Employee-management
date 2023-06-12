package Employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // 
import java.awt.event.*;

public class Viewemployee extends JFrame implements ActionListener {

    JTable table;
    Choice cemployeeid;
    JButton search, print, update, back;

    Viewemployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchlbl = new JLabel("search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        searchlbl.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        add(searchlbl);

        cemployeeid = new Choice();
        cemployeeid.setBounds(180, 20, 150, 20);
        add(cemployeeid);

        try {

            connectivity c = new connectivity();
            ResultSet rs = c.s.executeQuery("select * from employee"); //  ddl command will take  data from employee table nd insert in table
            //use of this function  whatever the data is  come in resultset  we have to insert in connectivity so use this library  function
            // table.setModel(DbUtils.resultSetToTableModel(rs)); // this function will insert the data
            while (rs.next()) {
                cemployeeid.add(rs.getString("emplid"));  // every column("emplid") added to cemployee 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
        try {

            connectivity c = new connectivity();
            ResultSet rs = c.s.executeQuery("select * from employee"); //  ddl command will take  data from employee table nd insert in table
            //use of this function  whatever the data is  come in resultset  we have to insert in connectivity so use this library  function
            table.setModel(DbUtils.resultSetToTableModel(rs)); // this function will insert the data
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table); // for inserting sroll bar  we have to pass fuction on which you need the fuction          
        jsp.setBounds(0, 100, 900, 600); // jsb to be shown on the top of the frame
        add(jsp);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(20, 70, 80, 20);
        add(search);

        print = new JButton("Print");
        print.addActionListener(this);
        print.setBounds(120, 70, 80, 20);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
if(ae.getSource() == search){
    String query = "select * from employee where emplid = '"+cemployeeid.getSelectedItem()+"'";
   
        try {

            connectivity c = new connectivity();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                   
          } catch (Exception e) {
            e.printStackTrace();
        }

}
else if(ae.getSource() == print){
    try{
    table.print();
     } catch (Exception e) {
            e.printStackTrace();
        }
}
else if(ae.getSource() == back){
}
else{
    setVisible(false);
    new Homepage();
}
    }
    public static void main(String[] args) {
        new Viewemployee();
    }
}
