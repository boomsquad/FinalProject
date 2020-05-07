import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
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
    // we are going to need ArrayLists to keep track of the fields that will be added
    ArrayList<Employee> empList = new ArrayList<Employee>();
    ArrayList<JTextField> empFieldList = new ArrayList<JTextField>();
    ArrayList<JTextField> empWageList = new ArrayList<JTextField>();
    ArrayList<JTextField> empHoursList = new ArrayList<JTextField>();

    public PayStubFrame()
    {
        setTitle("PayStub Calculator");
        setBounds(50,50,1100,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        myPanel = new JPanel();
        contentPane.add(myPanel,BorderLayout.WEST);
        myPanel.add(new JLabel("Number of employees: "));

        employeeAmtField = new JTextField(3);
        myPanel.add(employeeAmtField);


        //Buttons at the bottom on screen
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton nextButton = new JButton("Next");
        buttonPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                amtOfEmp = Integer.parseInt(employeeAmtField.getText());
                System.out.println("Amount of employees: " + amtOfEmp);
                for (int i = 0; i < amtOfEmp; i++) 
                {
                    myPanel.add(new JLabel("Employee: "));
                    empField = new JTextField(10);
                    empFieldList.add(empField); // add to the arrayList of empFields
                    myPanel.add(empField);

                    myPanel.add(new JLabel("Hourly wage: "));
                    wageField = new JTextField(3);
                    empWageList.add(wageField); // add to the arraylist of wageFields
                    myPanel.add(wageField);

                    myPanel.add(new JLabel("Hours worked: "));
                    hours = new JTextField(3);
                    empHoursList.add(hours); // add to the arrayList of hourFields
                    myPanel.add(hours);
                }
                myPanel.revalidate();
            }
        });
        nextButton.addActionListener(this);

        JButton calculateButton = new JButton("Calculate");        
        buttonPanel.add(calculateButton);
        calculateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (empFieldList.size() == 0)
                {
                    System.out.println("There is no employee info input!");
                } 
                else 
                {
                    for (int i = 0 ; i < amtOfEmp; i++) 
                    {
                        String empName = empFieldList.get(i).getText();
                        int hoursWorked = Integer.parseInt(empHoursList.get(i).getText());  // parse the fields for the values
                        int wage = Integer.parseInt(empWageList.get(i).getText());
                        newEmp = new Employee(empName, hoursWorked, wage); 
                        empList.add(newEmp); // adding employee to arraylist of employees
                    }
                    for (Employee eIterator : empList) 
                    {
                        System.out.print(eIterator); // printing every employee's info in the arraylist
                        JOptionPane.showMessageDialog(calculateButton, eIterator);
                    }
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
                employeeAmtField.setText("");
                // clearing all the arraylists for a fresh start
                empList.clear();
                empFieldList.clear();
                empHoursList.clear();
                empWageList.clear();

                revalidate();
            }
        });
        clearButton.addActionListener(this);

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
                myPanel.removeAll();
                myPanel.add(new JLabel("Number of employees: "));
                myPanel.add(employeeAmtField);
                employeeAmtField.setText("");
                revalidate();
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
                JOptionPane.showMessageDialog(helpItem,"This application takes the amount employees with their wage and hours and calculates their pay for the week with and without taxes!");
            }
        });
        optionsMenu.add(helpItem);
    }

    public void actionPerformed(ActionEvent e) 
    {
        repaint();
    }
}