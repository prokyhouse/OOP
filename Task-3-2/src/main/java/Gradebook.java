import java.util.*;

public class Gradebook extends Semester {

    private int id;
    private String fullName;
    private String faculty;
    private String specialty;
    private final Semester[] semesters = new Semester[9];
    private int qualifyingWorkGrade;

    public Gradebook(int id, String fullName, String faculty, String specialty, int qualifyingWorkGrade) {
        this.id = id;
        this.fullName = fullName;
        this.faculty = faculty;
        this.specialty = specialty;
        this.qualifyingWorkGrade = qualifyingWorkGrade;

        for (int i = 1; i < 9; i++) {
            Semester s = new Semester();
            semesters[i] = s;
        }
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setFullName(int id) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFaculty(int id) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setSpecialty(int id) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setQualifyingWorkGrade(int qualifyingWorkGrade) {
        this.qualifyingWorkGrade = qualifyingWorkGrade;
    }

    public int getQualifyingWorkGrade() {
        return qualifyingWorkGrade;
    }

    public void add(int semester, String discipline, int grade) {
        this.semesters[semester].setGrade(discipline, grade);
    }

    public Semester[] getAllSemestersInfo() {
        return semesters;
    }

    public Collection<Integer> getSemesterGrades(int course) {
        return semesters[course].getGrades();
    }

    public Collection<String> getSemesterDisciplines(int course) {
        return semesters[course].getDisciplines();
    }

    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            grades.addAll(semesters[i].getGrades());
        }
        return grades;
    }
}
