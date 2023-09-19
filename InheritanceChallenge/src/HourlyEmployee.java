public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, String birthDate, String endDate,  String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }


    public double getDoublePay() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyPayRate=" + hourlyPayRate +
                "} " + super.toString();
    }
}
