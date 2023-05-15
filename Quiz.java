import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    // check krne k liye ki user ne answer diya ki nhi.
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupotion;
    JButton next, submit, lifeline;

    public static int timer = 15;
    // jese hi 15 second ho jaye aur answer na de paye to next question
    // automatically aa jaye.
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(30, 0, 1300, 875); // frame size
        getContentPane().setBackground(Color.WHITE); // colour of frame
        setLayout(null);

        // NOW Frame pr ek image lgani hai.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 400);
        add(image);

        // ab photo k neeche hme label lagne hai.
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupotion = new ButtonGroup();
        groupotion.add(opt1);
        groupotion.add(opt2);
        groupotion.add(opt3);
        groupotion.add(opt4);

        next = new JButton("Next");
        next.setBounds(1000, 520, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1000, 600, 200, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1000, 680, 200, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true); // for showing the frame
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1; // mtlb next button pr click kr chuka hai.
            if (groupotion.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                // groupopotion se 4 option then getselect se choose jo kra bo bala option and
                // getAction se option m jo value hai bo is variable m store ho jayegi.
                useranswers[count][0] = groupotion.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            // agr hmne ek bar lifeline button use kr liya hai ek question m to use disable
            // kr do.
            lifeline.setEnabled(false);

        }
        // agr sare question k bad submit pr click krenge to ye kro.
        else if (ae.getSource() == submit) {

            ans_given = 1;
            if (groupotion.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                // groupopotion se 4 option then getselect se choose jo kra bo bala option and
                // getAction se option m jo value hai bo is variable m store ho jayegi.
                useranswers[count][0] = groupotion.getSelection().getActionCommand();
            }
            for (int i = 0; i < useranswers.length; i++) {
                // if agr user ka answer mil rha given answers se than 10 points de do
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } // agr nhi mil rha to else loop.
                else {
                    score += 0;
                }
            }
            // after this ise band krke nyi class bnao "score" jisme score ko show kroge.
            setVisible(false);
            new score(name, score);

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Times Now", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 1000, 500);
        } else {
            g.drawString("Times up!!", 1000, 500);
        }

        timer--;
        // value km hoti rh mtlb 15 second se km hoti rh.
        // isko km krne k liye multithread ki sleep method se krenge.
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // next question k liye after 15 second
        if (ans_given == 1) // mtlb bnda answer kr chuka hai.
        {
            ans_given = 0; // next question k liye zero set krna hai.
            // and timer ko bhi dubara se set krna pdega.
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            // agr count =9 hai aur submit pr click nhi kiya to automatic submit ho jaye.
            if (count == 9) {
                // ab hme check krna hai konsa option select kiya hai aur dekhna hai uska score
                // kitna hai.
                // user ne kuch option select nhi kiya.
                if (groupotion.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    // groupopotion se 4 option then getselect se choose jo kra bo bala option and
                    // getAction se option m jo value hai bo is variable m store ho jayegi.
                    useranswers[count][0] = groupotion.getSelection().getActionCommand();
                }
                for (int i = 0; i < useranswers.length; i++) {
                    // if agr user ka answer mil rha given answers se than 10 points de do
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } // agr nhi mil rha to else loop.
                    else{
                        score += 0;
                    }

                }
                // after this ise band krke nyi class bnao "score" jisme score ko show kroge.
                setVisible(false);
                // now score class ka object bnao and username and score pass krdo.
                new score(name, score);
            } else {
                // user ne kuch option select nhi kiya.
                if (groupotion.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    // groupopotion se 4 option then getselect se choose jo kra bo bala option and
                    // getAction se option m jo value hai bo is variable m store ho jayegi.
                    useranswers[count][0] = groupotion.getSelection().getActionCommand();
                }
                count++; // intital value 0 than 1 ho jayegi than next ques dikhan start ho jayega and
                         // hme start() bhi dikhana pdega.
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + " .");
        question.setText(questions[count][0]);
        // har option k neeche bo value bhi deni hogi jo user ne choose ki hai
        // getActioncommand se.
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // ab kya hoga jese tumne koi option choose kra than 15 sec ho gye, to next
        // question jo aayega bo bhi usi number ka option choose hokr rkha hoga.iske
        // liye jo selection h use clear krna pdega.
        groupotion.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
