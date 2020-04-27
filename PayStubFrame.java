import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class PayStubFrame extends JFrame implements ActionListener
{
    JTextField employeeAmtField;
    JTextField empField;
    JTextField wageField;
    JPanel myPanel;



    public PayStubFrame()
    {
        setTitle("PayStub Calculator");
        setBounds(50,50,1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        clearButton.addActionListener(this);
        
        JButton calculateButton = new JButton("Calculate");        
        buttonPanel.add(calculateButton);
        calculateButton.addActionListener(this);

        myPanel = new JPanel();
        contentPane.add(myPanel, BorderLayout.CENTER);
        myPanel.add(new JLabel("Number of employees: "));

        employeeAmtField = new JTextField(3);
        myPanel.add(employeeAmtField);
        
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
        int amtOfEmp = Integer.parseInt(employeeAmtField.getText());
        System.out.println("Amount of employee: " + amtOfEmp);
        for (int i = 1; i <= amtOfEmp; i++) {
            myPanel.add(new JLabel("Employee: "));
            empField = new JTextField(10);
            myPanel.add(empField);
            myPanel.add(new JLabel("Hourly wage: "));
            wageField = new JTextField(3);
            myPanel.add(wageField);
            myPanel.revalidate();
        }
        repaint();
    }
}