import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;
import java.awt.GridLayout;
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

        //Buttons at the bottom on screen.
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


        //Creates a menu bar at the top.
        JMenuBar menuBar = new JMenuBar();
        add(menuBar, BorderLayout.NORTH);

        //Adds a file tab to the menu bar.
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New", KeyEvent.VK_C);
        newItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                
                repaint();
            }
        }); 
        fileMenu.add(newItem);

        JMenuItem exitMenu = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenu.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenu);

        //Adds options tab to menu bar.
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(optionsMenu);

        JMenuItem helpItem = new JMenuItem("Help", KeyEvent.VK_X);
        optionsMenu.add(helpItem);
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