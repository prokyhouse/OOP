import java.util.ArrayList;
import java.util.Collection;

public class Grades {
    /**
     *
     * @param marks is the mark's list of semester or entire perios
     * @return average score
     */
    public static double AverageScore(ArrayList<Integer> marks) {
        double result = 0.0;

        for (int mark : marks) {
            result += mark;
        }

        result /= marks.size();
        return result;
    }

    /**
     *
     * @param gradebook student's gradebook
     * @return true, if the gradebook meets the conditions
     */
    public static boolean DiplomaWithHonors(Gradebook gradebook) {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        grades = gradebook.getAllGrades();
        int fives = 0;
        boolean satisfactorily = false;
        for (int grade : grades) {
            if (grade == 5) {
                fives++;
            }
            if (grade < 4) {
                satisfactorily = true;
            }
        }
        double fivesCondition = (double) fives / grades.size();

        return fivesCondition >= 0.75 && !satisfactorily && gradebook.getQualifyingWorkGrade() == 5;
    }

    /**
     *
     * @param gradebook student's gradebook
     * @param semester № of semester
     * @return true, if our student has no "3" during this period (semester)
     */
    public static boolean scholarship(Gradebook gradebook, int semester) {
        Collection<Integer> marks = gradebook.getSemesterGrades(semester);
        boolean result = true;
        for (int mark : marks) {
            if (mark < 4) {
                result = false;
                break;
            }
        }
        return result;
    }
}
