package OnlineExamSystem;


import javax.swing.*;

public class ResultPage extends JFrame{

    ResultPage(int score){

        setTitle("Exam Result");

        JLabel result = new JLabel("Your Score: "+score);
        result.setBounds(150,100,200,30);

        add(result);

        setSize(400,300);
        setLayout(null);
        setVisible(true);
    }
}