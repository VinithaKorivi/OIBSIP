package OnlineExamSystem;

import javax.swing.*;
import java.awt.event.*;

public class ExamPage extends JFrame implements ActionListener {
    JLabel questionLabel, timerLabel;
    JRadioButton option1, option2, option3, option4;
    JButton nextButton;
    ButtonGroup optionsGroup;
    
    String loggedInUser;
    int currentQ = 0;
    int score = 0;
    int timeLeft = 60; 

    String[] questions = {
        "1. Java is ___?",
        "2. JVM stands for ___?",
        "3. Which is not OOP feature?",
        "4. Swing is used for ___?",
        "5. Main method signature is ___?"
    };

    String[][] options = {
        {"Language", "OS", "Database", "Browser"},
        {"Java Virtual Machine", "Java Variable Method", "Java Visual Machine", "None"},
        {"Inheritance", "Polymorphism", "Encapsulation", "Compilation"},
        {"GUI", "Networking", "Database", "Web Service"},
        {"public static void main(String[] args)", "private void main()", "public void start()", "void main(String args)"}
    };

    int[] answers = {0, 0, 3, 0, 0}; 

    public ExamPage(String username) {
        loggedInUser = username;

        setTitle("Exam Page");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 500, 30);
        add(questionLabel);

        option1 = new JRadioButton();
        option1.setBounds(50, 100, 500, 30);
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(50, 140, 500, 30);
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(50, 180, 500, 30);
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(50, 220, 500, 30);
        add(option4);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(250, 270, 100, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        timerLabel = new JLabel("Time Left: " + timeLeft + " sec");
        timerLabel.setBounds(400, 10, 200, 30);
        add(timerLabel);

        setQuestion();
        startTimer();

        setVisible(true);
    }

    private void setQuestion() {
        optionsGroup.clearSelection();
        questionLabel.setText(questions[currentQ]);
        option1.setText(options[currentQ][0]);
        option2.setText(options[currentQ][1]);
        option3.setText(options[currentQ][2]);
        option4.setText(options[currentQ][3]);
    }

    private void startTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft + " sec");
                if(timeLeft <= 0) {
                    ((Timer)e.getSource()).stop();
                    submitExam();
                }
            }
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        if(option1.isSelected()) selected = 0;
        else if(option2.isSelected()) selected = 1;
        else if(option3.isSelected()) selected = 2;
        else if(option4.isSelected()) selected = 3;

        if(selected == answers[currentQ]) score++;

        currentQ++;
        if(currentQ < questions.length) {
            setQuestion();
        } else {
            submitExam();
        }
    }

    private void submitExam() {
        JOptionPane.showMessageDialog(this, loggedInUser + ", Your Score is: " + score + "/" + questions.length);
        new Dashboard(loggedInUser);
        dispose();
    }
}