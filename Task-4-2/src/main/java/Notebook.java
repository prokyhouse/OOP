import com.google.gson.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Notebook {

    private final List<Note> notebook;
    private final Gson gsonData;
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

    public String show(LocalDateTime after, LocalDateTime before,String keyWord){
        LocalDateTime date;
        List<Note> searchResult = new ArrayList<>();;
        for (Note note: notebook) {
            date = LocalDateTime.parse(note.getTime(), dtf);
            String text = note.getText();
            if((date.isAfter(after))&&(date.isBefore(before))&&(text.contains(keyWord))){
                searchResult.add(note);
            }
        }
        return gsonData.toJson(searchResult);
    }

    public String show(){
        return gsonData.toJson(notebook);
    }
}
