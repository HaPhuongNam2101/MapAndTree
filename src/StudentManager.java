import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Map<Integer, Student> ListStudents = new HashMap<>();
    public void saveStudent(Student student) {
        ListStudents.put(student.getId(), student);
    }
    public void deleteStudent(int id) {
        ListStudents.remove(id);
    }
    public Student getStudent(int id) {
        return ListStudents.get(id);
    }
    public Map<Integer, Student> getStudentByName(String name) {
        Map<Integer, Student> studentsByName = new HashMap<>();
        for (Student student : ListStudents.values()) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                studentsByName.put(student.getId(), student);
            }
        }
        return studentsByName;
    }
    public Student getMaxAvg(){
        Student topStudent = null;
        double maxAvg = 0;
        for (Student student : ListStudents.values()) {
            double avg = student.getAvgScore();
            if (avg > maxAvg) {
                maxAvg = avg;
                topStudent = student;
            }
        }
        return topStudent;
    }
    public Map<Integer, Student> getAllStudents() {
        return ListStudents;
    }
}
