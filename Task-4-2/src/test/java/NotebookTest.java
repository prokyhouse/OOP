
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class NotebookTest {
    Notebook notebook = new Notebook();

    @Test
    public void addTest() throws IOException {
        notebook.add("My new note");
        notebook.add("My second new note");
        notebook.add("My third note");

        System.out.println(notebook.show());
    }
    @Test
    public void removeTest() throws IOException {
        notebook.add("My new note");
        notebook.add("My second new note");
        notebook.remove("My second new note");
        System.out.println(notebook.show());
    }

    @Test
    public void showTest() throws IOException {
        notebook.add("My new note");
        System.out.println(notebook.show());
    }

    @Test
    public void searchTest() throws IOException {
        notebook.add("My new note");
        notebook.add("My second new note");
        notebook.add("My third note");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime first = LocalDateTime.parse("2019/12/24 20:25:44", dtf);
        LocalDateTime second = LocalDateTime.parse("2021/12/24 22:59:44", dtf);
        System.out.println(notebook.show(first, second, "third"));
    }
}