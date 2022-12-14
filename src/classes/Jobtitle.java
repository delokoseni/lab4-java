package classes;
import java.util.Scanner;

public class Jobtitle {
    /** Наименование должности **/
    private String jtitle;
    /** Стоимость часа работы **/
    private int hourlycost;
    /** Подчиненные **/
    private Subordinates subs;
    /** Конструктор со всеми параметрами **/
    public Jobtitle(String jtitle, int hourlycost, Subordinates subs){
        this.jtitle = jtitle;
        if(hourlycost >= 0)
            this.hourlycost = hourlycost;
        else {
            System.out.println("Указано недопустимое значение hourlycost.");
            this.hourlycost = 0;
        }
        this.subs = subs;
    }

    /** Конструктор с одним параметром **/
    public Jobtitle(int allfields){
        if(allfields >= 0) {
            jtitle = Integer.toString(allfields);
            hourlycost = allfields;
            subs = new Subordinates(allfields);
        }
        else{
            System.out.println("Указано недопустимое значение allfields.");
            jtitle = "";
            hourlycost = 0;
            subs = new Subordinates();
        }
    }

    /** Конструктор без параметров **/
    public Jobtitle(){
        jtitle = "";
        hourlycost = 0;
        subs = new Subordinates();
    }

    /** Метод установки значений **/
    public void set(Jobtitle j){
        this.jtitle = j.jtitle;
        this.hourlycost = j.hourlycost;
        this.subs.set(j.subs);
    }

    /** Метод ввода класса **/
    public void input(){
        String jtitle;
        int hourlycost;
        Subordinates subs = new Subordinates();
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите должность: ");
        jtitle = inp.nextLine();
        System.out.println("Введите стоимость часа работы: ");
        hourlycost = inp.nextInt();
        subs.input();
        Jobtitle j = new Jobtitle(jtitle, hourlycost, subs);
        this.set(j);
    }

    /** Метод вывода класса **/
    public void output(){
        System.out.println("Должность: " + jtitle);
        System.out.println("Стоимость часа работы: " + hourlycost);
        subs.output();
    }

    /** Метод сравнения **/
    public float comparisonhc(int hcost){
        float percent;
        percent = (float)hourlycost / ((float)hcost / 100) - 100;
        return percent;
    }

    /** Метод вспомогательный при вычислении зарплаты **/
    public int jtmoney(int normal){
        int x = 0;
        x += normal * hourlycost;
        return x;
    }

    /** Метод возвращающий количество подчиненных сотрудника **/
    public int getamount(){
        return subs.getamount();
    }

    /** Метод для редактирования должности **/
    public void editjtitle(String jtitle, String add){
        StringBuilder sb = new StringBuilder();
        String[] words = this.jtitle.split(" ");
        this.jtitle = "";
        for(String word : words) {
            if(word.equals(jtitle)) {
                sb.append(add);
                sb.append(" ");
            }
            sb.append(word);
            sb.append(" ");
        }
        this.jtitle = sb.toString();
    }
}