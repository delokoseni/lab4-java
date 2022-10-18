package classes;
import java.util.Scanner;

public class Employee {
    /** Индивидуальный номер **/
    private int  id;
    /** Стаж **/
    private Experience exp;
    /** Отработанные за месяц часы **/
    private Hours hour;
    /** Должность **/
    private Jobtitle jt;
    /** Конструктор класса со всеми параметрами **/
    public Employee(int id, Experience exp, Hours hour, Jobtitle jt) {
        if (id >= 0){
            this.id = id;
            this.exp = exp;
            this.hour = hour;
            this.jt = jt;
        }
        else{
            System.out.println("Указано недопустимое значение id.");
            this.id = 0;
            this.exp = new Experience();
            this.hour = new Hours();
            this.jt = new Jobtitle();
        }
    }

    /** Конструктор класса с одним параметром **/
    public Employee(int allfields){
        if(allfields >= 0) {
            id = allfields;
            exp = new Experience(allfields);
            hour = new Hours(allfields);
            jt = new Jobtitle(allfields);
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            id = 0;
            exp = new Experience();
            hour = new Hours();
            jt = new Jobtitle();
        }
    }

    /** Конструктор класса без параметров **/
    public Employee(){
        id = 0;
        exp = new Experience();
        hour = new Hours();
        jt = new Jobtitle();
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("ID: " + id);
        exp.output();
        hour.output();
        jt.output();
    }

    /** Метод ввода **/
    public void input(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите ID: ");
        id = inp.nextInt();
        exp.input();
        hour.input();
        jt.input();
    }

    /** Метод подсчета зарплаты **/
    public int getsalary(Salary sal){
        int salary = 0;
        salary += hour.hoursmoney(jt, sal);
        salary = sal.allmoney(salary, exp, jt);
        return salary;
    }

    /** Метод определения положена ли премия **/
    public String getpremium(int houramount){
        if (hour.allhours() < houramount)
            return "Премия не положена";
        else
            return "Премия положена";
    }
}