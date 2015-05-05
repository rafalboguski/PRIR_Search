import com.google.gson.Gson;
import spark.*;
import java.util.ArrayList;
import static spark.Spark.*;
import org.json.*;

public class HelloWorld {


    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("reymont-chlopi-zima.txt", "data", "/home/data/example"));
        books.add(new Book("Orwell-1984.txt", "data", "/home/data/"));



        get("/files", (req, res) -> books, json());

        post("/push", (req, res) -> "ToDo");

        get("/search/:word",(req, res) -> new Book("ToDo",req.params(":word"),"lol"), json());

    }







    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return HelloWorld::toJson;
    }
}