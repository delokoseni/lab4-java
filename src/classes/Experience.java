package classes;
import java.util.Scanner;

public class Experience {
    /** Кол-во реально отработанных лет **/
    private int workingyears;
    /** Кол-во лет в армии, если сохранялось рабочее место **/
    private int army;
    /** Кол-во лет в декретном отпуске, если сохранялось рабочее место **/
    private int maternityleave;
    /** Конструктор класса со всеми параметрами **/
    public Experience(int workingyears, int army, int maternityleave) {
        if(workingyears >= 0)
            this.workingyears = workingyears;
        else{
            System.out.println("Указано недопустимое значение workingyears.");
            this.workingyears = 0;
        }
        if(army >= 0)
            this.army = army;
        else {
            System.out.println("Указано недопустимое значение army.");
            this.army = 0;
        }
        if(maternityleave >= 0)
            this.maternityleave = maternityleave;
        else{
            System.out.println("Указано недопустимое значение maternityleave.");
            this.maternityleave = 0;
        }
    }

    /** Конструктор класса с одним параметром **/
    public Experience(int allfields) {
        if(allfields >= 0) {
            workingyears = allfields;
            army = allfields;
            maternityleave = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            workingyears = 0;
            army = 0;
            maternityleave = 0;
        }
    }

    /** Конструктор класса без параметров **/
    public Experience(){
        workingyears = 0;
        army = 0;
        maternityleave = 0;
    }

    /** Метод вывода **/
    public void output(){
        System.out.println("Стаж (отработано лет): " + workingyears);
        System.out.println("Стаж (кол-во лет в армии): " + army);
        System.out.println("Стаж (кол-во лет в декретном отпуске): " + maternityleave);
    }

    /** Метод установки значений **/
    public void set(Experience e){
        this.army = e.army;
        this.maternityleave = e.maternityleave;
        this.workingyears = e.workingyears;
    }

    /** Метод ввода **/
    public void input(){
        int workingyears, army, maternityleave;
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите кол-во реально отработанных лет: ");
        workingyears = inp.nextInt();
        System.out.println("Введите кол-во лет, проведенных в армии: ");
        army = inp.nextInt();
        System.out.println("Введите кол-во лет в декретном отпуске: ");
        maternityleave = inp.nextInt();
        Experience e = new Experience(workingyears, army, maternityleave);
        this.set(e);
    }

    /** Метод возвращающий совокупный стаж **/
    public int allexp(){
        int all;
        all = workingyears;
        all += army;
        all += maternityleave;
        return all;
    }
}