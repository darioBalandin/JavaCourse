public class Main {
    public static void main(String[] args) {

        Worker tim= new Worker("Tim", "01/01/1990", "01/01/2020");
        System.out.println(tim);

        Employee bob = new Employee("Bob", "01/01/1990", "01/01/2020",  "01/01/2010");
        System.out.println(bob);

        SalariedEmployee alice = new SalariedEmployee("Alice", "01/01/1990", "01/01/2020",  "01/01/2010", 100000.00, false);
        System.out.println(alice);

        HourlyEmployee eve = new HourlyEmployee("Eve", "01/01/1990", "01/01/2020",  "01/01/2010", 100.00);
        System.out.println(eve);
    }
}