
class Employee
{
    private String name;
    private int hours;
    private int wage;
    private double payBeforeTax;
    private double payAfterTax;
    private int numEmployees;

    public void setName(String nameIn) {name = nameIn;}
    public String getName() {return name;}

    public void setHours(int hoursIn){hours = hoursIn;}
    public int getHours(){return hours;}

    public void setWage(int wageIn){wage = wageIn;}
    public int getWage(){return wage;}

    public void setNumEmployees(int numEmployeesIn){numEmployees = numEmployeesIn;}
    public int getNumEmployees(){return numEmployees;}

    public Employee() { // constructor where nothing is passed in
    
        name = "";
        hours = 0;
        wage = 0;
    }

    public Employee(String nameIn, int hoursIn, int wageIn){ // constructor with parameters passed in
        name = nameIn;
        hours = hoursIn;
        wage = wageIn;
    }

    public String toString() { //overriding toString method
        payBeforeTax = hours*wage;
        payAfterTax = payBeforeTax*.9505; // adjusting for Illinois income tax
        return name + ": " + "Hours worked: " + hours + ", Hourly wage: " + wage + ", Pay before tax: " + payBeforeTax + ", Pay after tax: " + payAfterTax;
    }

}