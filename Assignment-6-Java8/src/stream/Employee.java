package stream;

//stream.Employee.java
class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}