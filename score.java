import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener{

    score(String name, int score) {
        setBounds(400, 150, 750,550); // frame size
        getContentPane().setBackground(Color.WHITE); // colour of frame
        setLayout(null);

        // NOW Frame pr ek image lgani hai.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.png"));
        //for image scaling
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel image = new JLabel(i3);
        image.setBounds(0, 170, 300, 250);
        add(image);

        // ab photo k neeche hme label lagne hai.
        JLabel heading = new JLabel("Thanks " + name + " for playing this QUIZ.");
        heading.setBounds(145,40,700,30);
        heading.setFont(new Font("MV Boli", Font.PLAIN, 24));
        heading.setForeground(Color.BLACK);
        add(heading);

        //ab score k liye.
        JLabel lbscore = new JLabel("Your score is : " + score);
        lbscore.setBounds(410,200,300,30);
        lbscore.setFont(new Font("MV Boli", Font.PLAIN, 24));
        lbscore.setForeground(Color.BLACK);
        add(lbscore);

        // Now hme ek button chahiye

        JButton submit = new JButton("PLAY AGAIN"); 
        submit.setBounds(400, 270, 220, 30);
        //submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        //ek hi button hai "play again" agr uspe click kr dete hai to screen band krke start se shrue krdo.
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        // object bna liya.
        new score("User", 0);
    }
}
