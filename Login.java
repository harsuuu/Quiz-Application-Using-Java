import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.beans.JavaBean;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname; 
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(770,60,350,40);
        heading.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 40));    
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name = new JLabel("Enter your Name");
        name.setBounds(820,150,300,18);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));    
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(700,190,400,25);
        tfname.setFont(new Font("Times Now Roman", Font.BOLD, 18));
        add(tfname);

        rules = new JButton("Submit");
        rules.setBounds(700, 230, 120, 25);
        rules.setBackground(new Color(20, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(980, 230, 120, 25);
        back.setBackground(new Color(20, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

       
        setSize(1200,500);
        setLocation(130, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == rules)
        {
            String name = tfname.getText(); 
            setVisible(false);
            new rules(name);
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
