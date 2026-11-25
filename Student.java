public class Student extends Person {

    String department;

    public Student(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Department: " + department);
    }
}