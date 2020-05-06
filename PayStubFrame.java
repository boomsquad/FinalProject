import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class PayStubFrame extends JFrame implements ActionListener
{
    JTextField employeeAmtField;
    JTextField empField;
    JTextField wageField;
    JTextField hours;
    JPanel myPanel;
    int amtOfEmp;
    Employee newEmp;
    ArrayList<Employee> empList = new ArrayList<Employee>();

    public PayStubFrame()
    {
        setTitle("PayStub Calculator");
        setBounds(50,50,1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //Buttons at the bottom on screen
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton nextButton = new JButton("Next");
        buttonPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Action performed!");
                amtOfEmp = Integer.parseInt(employeeAmtField.getText());
                System.out.println("Amount of employees: " + amtOfEmp);
                for (int i = 1; i <= amtOfEmp; i++) 
                {
                    myPanel.add(new JLabel("Employee: "));
                    empField = new JTextField(10);
                    myPanel.add(empField);
                    myPanel.add(new JLabel("Hourly wage: "));
                    wageField = new JTextField(3);
                    myPanel.add(wageField);
                    myPanel.add(new JLabel("Hours worked: "));
                    hours = new JTextField(3);
                    myPanel.add(hours);
                    myPanel.revalidate();
                }   
            }
        });
        nextButton.addActionListener(this);

        JButton calculateButton = new JButton("Calculate");        
        buttonPanel.add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String empName = empField.getText();
                int hoursWorked = Integer.parseInt(hours.getText());
                int wage = Integer.parseInt(wageField.getText());
                for (int i = 1; i <= amtOfEmp; i++) {
                    newEmp = new Employee(empName, hoursWorked, wage); // getting the employee info and adding them to a new employee object
                    empList.add(newEmp); // adding employee to arraylist
                }
                for (Employee eIterator : empList) {
                    System.out.println(eIterator); // printing every employee's info in the arraylist
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // removing all additional panels and resetting to the starting layout
                myPanel.removeAll();
                myPanel.add(new JLabel("Number of employees: "));
                myPanel.add(employeeAmtField);
            }
        });
        clearButton.addActionListener(this);


        myPanel = new JPanel();
        contentPane.add(myPanel, BorderLayout.WEST);
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
        helpItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(helpItem,"This application takes the amount employees with their wage and hours and calculates their pay by weekly, biweekly, or salary!");
            }
        });
        optionsMenu.add(helpItem);
    }

    public void actionPerformed(ActionEvent e) 
    {
        repaint();
    }
}