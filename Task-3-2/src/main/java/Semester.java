import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Semester {
    private final Map<String, Integer> semester = new HashMap<String, Integer>();

    Semester() {}

    protected void setGrade(String discipline, int grade) {
        this.semester.put(discipline, grade);
    }

    protected Collection<Integer> getGrades() {
        return this.semester.values();
    }

    protected Collection<String> getDisciplines() {
        return this.semester.keySet();
    }
}
