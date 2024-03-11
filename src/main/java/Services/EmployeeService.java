package Services;
import Model.Employee;
import Model.Film;

import java.util.*;
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private static EmployeeService instance;

    public static EmployeeService getInstance(){
        if(instance == null)
            instance = new EmployeeService();
        return instance;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(this.employees);
        return employees;
    }

    public void updateEmployee(int index, Employee employee){
        for (int i =0; i < this.employees.size(); i++)
            if(this.employees.get(i).getId() == index){
                this.employees.remove(i);
                this.employees.add(i, employee);
                break;
            }
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
    public void deleteEmployee (int index){
        for (int i =0; i < this.employees.size(); i++)
            if(this.employees.get(i).getId() == index){
                this.employees.remove(i);
                break;
            }
    }

    public void printEmployee(Employee employee){
        System.out.println(employee.toString());
    }

    public Employee readEmployee(){
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        int id = maxId() + 1;

        employee.setId(id);

        System.out.println("Nume: ");
        employee.setNume(scanner.nextLine());

        System.out.println("Prenume: ");
        employee.setPrenume(scanner.nextLine());

        System.out.println("Mail: ");
        employee.setMail(scanner.nextLine());

        System.out.println("Telefon: ");
        employee.setTelefon(scanner.nextLine());

        System.out.println("Salariu: ");
        employee.setSalariu(Integer.parseInt(scanner.nextLine()));

        System.out.println("Job Title: ");
        employee.setJobTitle(scanner.nextLine());

        return employee;
    }

    public int maxId(){
        int max = 0;
        for(int i =0; i< employees.size(); i++){
            if(employees.get(i).getId() > max){
                max = employees.get(i).getId();
            }
        }
        return max;
    }
}
