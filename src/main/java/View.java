import com.google.gson.Gson;
import spark.*;
import static spark.Spark.*;
import org.json.*;
import java.net.URLDecoder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Random;


public class View {

    public static void main(String[] args) throws InterruptedException {

        Controller controller = new Controller();

        get("/files", (req, res) -> controller.getBooks(), json());

        get("/search/:word", (req, res) -> controller.search(req.params(":word")), json());

        //curl -v -H "Accept: application/json" -H "Content-type: application/json"
        // -X POST -d '{"filename":"filename","data":"data","folder":"folder"}'  http://localhost:4567/push
        post("/push", (req, res) -> {
            JSONObject json = new JSONObject(new String(req.bodyAsBytes(), "UTF-8"));

            controller.addBook(
                    String.valueOf(json.get("filename")),
                    String.valueOf(json.get("data")),
                    String.valueOf(json.get("folder")));
            return "<p>OK</p>";
        });

    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return View::toJson;
    }

}
