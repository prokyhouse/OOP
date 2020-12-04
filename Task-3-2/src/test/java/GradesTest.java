import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class GradesTest {

    @Test
    public void AverageTest() throws IOException {

        Gradebook proko = new Gradebook(18212, "K.A. Prokofyev", "MMF", "AM and CS", 5);
        proko.add(1, "DM", 5);
        proko.add(1, "Geometry", 4);
        proko.add(1, "History", 5);
        proko.add(1, "Mathematical analysis", 4);
        proko.add(2, "History", 5);
        proko.add(2, "Higher algebra", 4);
        proko.add(3, "Math. logic", 4);
        proko.add(3, "Comp. methods of lin. algebra", 4);

        ArrayList<Integer> grades = proko.getAllGrades(); //Here we can calculate the average score not only for the entire period.

        Assert.assertEquals(4.375, Grades.AverageScore(grades), 0);
    }

    @Test
    public void DiplomaTest() throws IOException {

        Gradebook proko = new Gradebook(18212, "K.A. Prokofyev", "MMF", "AM and CS", 5);
        proko.add(1, "DM", 5);
        proko.add(1, "Geometry", 4);
        proko.add(1, "History", 5);
        proko.add(1, "Mathematical analysis", 5);
        proko.add(2, "History", 5);

        //Provided that the student potentially writes a qualifying work with "excellent" mark.
        Assert.assertTrue(Grades.DiplomaWithHonors(proko));

        //Provided that the student potentially does not write a qualifying work with "excellent" mark.
        proko.setQualifyingWorkGrade(3);
        Assert.assertFalse(Grades.DiplomaWithHonors(proko));

        //Assume that a student closed the session with a bad grade.
        proko.setQualifyingWorkGrade(5);
        proko.add(2, "Some discpline", 3);
        Assert.assertFalse(Grades.DiplomaWithHonors(proko));

    }

    @Test
    public void ScholarshipTest() throws IOException {

        Gradebook proko = new Gradebook(18212, "K.A. Prokofyev", "MMF", "AM and CS", 5);
        proko.add(1, "DM", 5);
        proko.add(1, "Geometry", 4);
        proko.add(1, "History", 5);
        proko.add(1, "Mathematical analysis", 5);

        Assert.assertTrue(Grades.scholarship(proko, 1));

        //Assume that a student closed the session with a bad grade.
        proko.add(1, "Some discpline", 3);
        Assert.assertFalse(Grades.scholarship(proko, 1));
    }

}