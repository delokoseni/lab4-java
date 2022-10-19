package classes;
import java.util.Scanner;

public class Hours {
    /** Кол-во часов, отработанных по графику **/
    private int normal;
    /** Кол-во часов, отработанных сверхурочно **/
    private int overtime;
    /** Кол - во часов, отработанных в выходные дни **/
    private int weekends;

    /** Конструктор класса со всеми параметрами **/
    public Hours(int normal, int overtime, int weekends){
        if(normal >= 0)
            this.normal = normal;
        else {
            System.out.println("Указано недопустимое значение normal.");
            this.normal = 0;
        }
        if(overtime >= 0)
            this.overtime = overtime;
        else{
            System.out.println("Указано недопустимое значение overtime.");
            this.overtime = 0;
        }
        if(weekends >= 0)
            this.weekends = weekends;
        else{
            System.out.println("Указано недопустимое значение weekends.");
            this.weekends = 0;
        }
    }

    /** Конструктор класса с одним параметром **/
    public Hours(int allfields){
        if(allfields >= 0) {
            normal = allfields;
            overtime = allfields;
            weekends = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            normal = 0;
            overtime = 0;
            weekends = 0;
        }
    }

    /** Конструктор класса без параметров **/
    public Hours(){
        normal = 0;
        overtime = 0;
        weekends = 0;
    }

    /** Метод установки значений **/
    public void set(Hours h){
        this.normal = h.normal;
        this.overtime = h.overtime;
        this.weekends = h.weekends;
    }

    /** Метод ввода **/
    public void input(){
        int normal, overtime, weekends;
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите кол-во отработанных за месяц часов по графику: ");
        normal = inp.nextInt();
        System.out.println("Введите кол-во сверхурочных часов: ");
        overtime = inp.nextInt();
        System.out.println("Введите кол-во отработанных за месяц часов в выходные: ");
        weekends = inp.nextInt();
        Hours h = new Hours(normal, overtime, weekends);
        this.set(h);
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("Отработано часов за месяц(по графику): " + normal);
        System.out.println("Отработано часов за месяц(сверхурочно): " + overtime);
        System.out.println("Отработано часов за месяц(в выходные дни): " + weekends);
    }

    /** Метод возвращающий все отработанные за месяц часы **/
    public int allhours(){
        int all = 0;
        all += normal;
        all += overtime;
        all += weekends;
        return all;
    }

    /** Метод возвращающий зарплаты за все отработанные часы **/
    public int hoursmoney(Jobtitle jt,Salary sal){
        int salary = 0;
        salary += jt.jtmoney(normal);
        salary += sal.overtimeweekends(overtime, weekends);
        return salary;
    }
}