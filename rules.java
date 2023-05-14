import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class rules extends JFrame implements ActionListener{
    
    String name;
    JButton back, start;

    rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to simple Minds ");
        heading.setBounds(30,20,700,30);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 20));    
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel rule = new JLabel();
        rule.setBounds(20,60,700,350);
        rule.setFont(new Font("Tahoma", Font.PLAIN, 14));    
        rule.setForeground(Color.BLACK);
        //rule ko set krne k liye setText()
        rule.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rule);
 
        back = new JButton("Back");
        back.setBounds(250, 420, 100, 25);
        back.setBackground(new Color(20, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(650, 420, 100, 25);
        start.setBackground(new Color(20, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);



       
        setSize(1200,500);
        setLocation(130, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            setVisible(false);
            new Quiz(name);
        }
        //agr back pr click kiya to. current frame close and login class pr chle jao.
        else 
        {
            setVisible(false);
            new Login();
        }
    } 

    public static void main(String args[])
    {
        new rules("User");
    }
}
