import com.google.gson.Gson;
import spark.*;
import static spark.Spark.*;
import org.json.*;


public class View {


    public static void main(String[] args) throws InterruptedException {

        Controller controller = new Controller();

        controller.addBook("Ala","Ala ma kota","ksiazki");
        controller.addBook("Przewodnik","Monako jest spoko","wycieczki");

        get("/files", (req, res) -> {
            res.header("Access-Control-Allow-Origin","*");
            return controller.getBooks();
        }, json());

        get("/search/:word", (req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            return controller.search(req.params(":word"));
        }, json());

        /*
            curl -v -H "Accept: application/json" -H "Content-type: application/json" -X
            POST -d '{"filename":"filename","data":"data","folder":"folder"}'  http://localhost:4567/push
        */
        post("/push/", (req, res) -> {

            System.out.println("PUSH" + req.body());

            JSONObject json = new JSONObject(new String(req.bodyAsBytes(), "UTF-8"));
            controller.addBook(
                    String.valueOf(json.get("filename")),
                    String.valueOf(json.get("data")),
                    String.valueOf(json.get("folder"))
            );

            res.header("Access-Control-Allow-Origin","*");
            // should return json but test want it to be this way
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
