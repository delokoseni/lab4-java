package classes;
import java.util.Scanner;

public class Salary {
    /** Процент увеличения оплаты сверхурочных часов **/
    private int overtimecost;
    /** Процент увеличения оплаты часов отработанных в выходные **/
    private int weekendcost;
    /** Процент увеличения оплаты за стаж **/
    private int exppercent;
    /** Процент увеличения оплаты за наличие подчененных **/
    private int subspercent;
    /** Учет стажа **/
    private boolean expstatus;
    /** Учет наличия подчиненных **/
    private boolean subsstatus;
    /** Конструктор со всеми параметрами **/
    public Salary(int overtimecost, int weekendcost, int exppercent, int subspercent, boolean expstatus,
                  boolean subsstatus){
        if(overtimecost >= 0)
            this.overtimecost = overtimecost;
        else{
            System.out.println("Указано недопустимое значение overtimecost.");
            this.overtimecost = 0;
        }
        if(weekendcost >= 0)
            this.weekendcost = weekendcost;
        else{
            System.out.println("Указано недопустимое значение weekendcost.");
            this.weekendcost = 0;
        }
        if(exppercent >= 0)
            this.exppercent = exppercent;
        else{
            System.out.println("Указано недопустимое значение exppercent.");
            this.exppercent = 0;
        }
        if(subspercent >= 0)
            this.subspercent = subspercent;
        else{
            System.out.println("Указано недопустимое значение subspercent.");
            this.subspercent = 0;
        }
        this.expstatus = expstatus;
        this.subsstatus = subsstatus;
    }

    /** Конструктор с одним параметром **/
    public Salary(int allfields){
        if (allfields >= 0) {
            overtimecost = allfields;
            weekendcost = allfields;
            exppercent = allfields;
            subspercent = allfields;
            if (allfields > 0) {
                expstatus = true;
                subsstatus = true;
            } else {
                expstatus = false;
                subsstatus = false;
            }
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            overtimecost = 0;
            weekendcost = 0;
            exppercent = 0;
            subspercent = 0;
            expstatus = false;
            subsstatus = false;
        }
    }

    /** Конструктор без параметров **/
    public Salary() {
        overtimecost = 0;
        weekendcost = 0;
        exppercent = 0;
        subspercent = 0;
        expstatus = false;
        subsstatus = false;
    }

    /** Метод установки значений **/
    public void set(Salary salary){
        this.overtimecost = salary.overtimecost;
        this.weekendcost = salary.weekendcost;
        this.exppercent = salary.exppercent;
        this.subspercent = salary.subspercent;
        this.expstatus = salary.expstatus;
        this.subsstatus = salary.subsstatus;
    }

    /** Метод ввода **/
    public void input(){
        int a, overtimecost, weekendcost, exppercent = 0, subspercent = 0;
        boolean expstatus = false, subsstatus = false;
        Scanner inp = new Scanner(System.in);
        System.out.println("На сколько процентов увеличивать почасовую оплату сверхурочных: ");
        overtimecost = inp.nextInt();
        System.out.println("На сколько процентов увеличивать почасовую оплату в выходные: ");
        weekendcost = inp.nextInt();
        System.out.println("Учитывать ли стаж (0 - нет, иначе - да): ");
        a = inp.nextInt();
        if(a != 0) {
            System.out.println("На сколько процентов умножать зарплату за стаж: ");
            exppercent = inp.nextInt();
            expstatus = true;
        }
        System.out.println("Учитывать ли наличие подчиненных (0 - нет, иначе - да): ");
        a = inp.nextInt();
        if(a != 0) {
            System.out.println("На сколько процентов умножать зарплату за наличие подчиненных: ");
            subspercent = inp.nextInt();
            subsstatus = true;
        }
        Salary salary = new Salary(overtimecost, weekendcost, exppercent, subspercent, expstatus, subsstatus);
        this.set(salary);
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("Коэффициент умножения оплаты сверхурочных часов: " + overtimecost);
        System.out.println("Коэффициент умножения оплаты часов отработанных в выходные: " + weekendcost);
        System.out.println("Коэффициент умножения оплаты за стаж: " + exppercent);
        System.out.println("Коэффициент умножения оплаты за наличие подчененных: " + subspercent);
        System.out.println("Учет стажа: " + expstatus);
        System.out.println("Учет наличия подчиненных: " + subsstatus);
    }

    /** Вспомогательный метод при вычислении зарплаты **/
    public int overtimeweekends(int overtime, int weekends){
        int x = 0;
        x += overtime * overtimecost;
        x += weekends * weekendcost;
        return x;
    }

    /** Вспомогательный метод при вычислении зарплаты **/
    public int allmoney(int salary, Experience exp, Jobtitle jt){
        if(expstatus)
            salary += (float)salary / 100 * exppercent * exp.allexp();
        if(subsstatus)
            salary += (float)salary / 100 * subspercent * jt.getamount();
        return salary;
    }
}