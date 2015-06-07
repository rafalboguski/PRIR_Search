import com.google.gson.Gson;
import spark.*;


import static spark.Spark.*;

import org.json.*;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Random;



public class View {


    public static void main(String[] args) throws InterruptedException {


        Controller controller = new Controller();

        // liczba ksiazek jako parametr
        //Test.populate(controller, 1000);
        controller.addBook("kot", "ala ma kota", "kot");
        controller.addBook("przedszkole", "ta \nala nie lubi chodzic do swojego przedszkola taka to jest ala", "przedszkole");



        get("/files", (req, res) -> controller.getBooks(), json());



        // ogaarnij to taj jak mowilem na fb
        //curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"filename":"filename","data":"data","folder":"folder"}'  http://localhost:4567/push
        post("/push", (req, res) -> {

            JSONObject json = new JSONObject(req.body().substring(1, req.body().length() - 1));

            String filename = String.valueOf(json.get("filename"));
            String data = String.valueOf(json.get("data"));
            String folder = String.valueOf(json.get("folder"));

            print("PUT BEGIN--------------");
            print("  filename: " + filename);
            print("  data: " + data);
            print("  folder: " + folder);
            print("PUT END----------------");

            controller.addBook(filename, data, folder);


            return "Done";
        });

        get("/search/:word", (req, res) -> {

            ArrayDeque<Result> wyn = controller.search(req.params(":word"));

            return wyn;

        }, json());

    }


    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return View::toJson;
    }

    public static void print(Object o){
        System.out.println(o);
    }

}
