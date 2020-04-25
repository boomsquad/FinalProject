import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class PayStubFrame extends JFrame implements ActionListener
{
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

        JPanel myPanel = new JPanel();
        contentPane.add(myPanel);
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
}