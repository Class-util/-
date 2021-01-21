package Day09;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 21
 * Time:16:38
 */
public class Student {
    private String name;
    private String classes;
    private double grade;

    public Student() {
    }

    public Student(String name, String classes, int grade) {
        this.name = name;
        this.classes = classes;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", grade=" + grade +
                '}';
    }
}
