public class CompositePatternDemo {
    public static void main(String[] args) {
        Quiz quiz1 = new Quiz("Quiz 1", 30);
        Quiz quiz2 = new Quiz("Quiz 2", 20);

        Lesson lesson1 = new Lesson("Lesson 1", 60);
        lesson1.addComponent(quiz1);

        Project project1 = new Project("Project 1", 90);
        project1.addComponent(lesson1);

        Lesson lesson2 = new Lesson("Lesson 2", 45);
        lesson2.addComponent(quiz2);
        lesson2.addComponent(project1);

        Course course = new Course("Design Patterns Course");
        course.addComponent(lesson2);
        course.addComponent(project1);

        course.showDetails("");
        System.out.println("\nTotal Course Duration: " + course.computeDuration() + " mins");
    }
}
