
class Employee
{
    private int hours;
    private int wage;
    private int numEmployees;

    public void setHours(int hoursIn)
    {
        hours = hoursIn;
    }
    public int getHours()
    {
        return hours;
    }

    public void setWage(int wageIn)
    {
        wage = wageIn;
    }
    public int getWage()
    {
        return wage;
    }

    public void setNumEmployees(int numEmployeesIn)
    {
        numEmployees = numEmployeesIn;
    }
    public int getNumEmployees()
    {
        return numEmployees;
    }

    public Employee()
    {
        hours = 0;
        wage = 0;
    }
}