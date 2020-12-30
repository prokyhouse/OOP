import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Notebook {

    private final List<Note> notebook;
    private final Gson gsonData;
    String notesFile = "Notes.json";
    DateTimeFormatter dtf;

    Notebook() {
        notebook = new ArrayList<>();
        gsonData = new GsonBuilder().setPrettyPrinting().create();
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    public void add(String text) {
        LocalDateTime now = LocalDateTime.now();
        Note newNote = new Note(dtf.format(now), text);
        notebook.add(newNote);
    }

    public void remove(String text){
        notebook.removeIf(note -> note.getText().equals(text));
    }

    public String show(LocalDateTime after, LocalDateTime before,String keyWord) throws IOException {
        LocalDateTime date;
        List<Note> searchResult = new ArrayList<>();;
        for (Note note: notebook) {
            date = LocalDateTime.parse(note.getTime(), dtf);
            String text = note.getText();
            if((date.isAfter(after))&&(date.isBefore(before))&&(text.contains(keyWord))){
                searchResult.add(note);
            }
        }
        try (Writer writer = new FileWriter(notesFile)) {
            gsonData.toJson(searchResult, writer);
        }
        return gsonData.toJson(searchResult);
    }

    public String show() throws IOException {
        try (Writer writer = new FileWriter(notesFile)) {
            gsonData.toJson(notebook, writer);
        }
        return gsonData.toJson(notebook);
    }
}
