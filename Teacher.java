public class Teacher extends Person {

    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Subject: " + subject);
    }
}