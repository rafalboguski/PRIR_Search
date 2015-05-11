//import com.google.gson.Gson;
//import spark.*;
//
//
//import static spark.Spark.*;
//
//import org.json.*;
//
//import java.util.Objects;
//
//
///*
//    Tutaj obsuguje zapytnia http i oddaje sterowanie do kontrolera
//
// */
//
//
//public class View {
//
//
//    public static void main(String[] args) {
//
//        Controller controller = new Controller();
//
//        get("/files", (req, res) -> controller.getBooks(), json());
//
//
//        //curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"filename":"filename","data":"data","folder":"folder"}'  http://localhost:4567/push
//        post("/push", (req, res) -> {
//
//            JSONObject json = new JSONObject(req.body().substring(1, req.body().length() - 1));
//
//            String filename = String.valueOf(json.get("filename"));
//            String data = String.valueOf(json.get("data"));
//            String folder = String.valueOf(json.get("folder"));
//
//            print("PUT BEGIN--------------");
//            print("  filename: " + filename);
//            print("  data: " + data);
//            print("  folder: " + folder);
//            print("PUT END----------------");
//
//            controller.addBook(filename, data, folder);
//
//
//            return "Done";
//        });
//
//        get("/search/:word", (req, res) -> {
//
//
//
//
//
//            return "Matches in files: "+controller.search(req.params(":word"));
//
//        }, json());
//
//    }
//
//
//    public static String toJson(Object object) {
//        return new Gson().toJson(object);
//    }
//
//    public static ResponseTransformer json() {
//        return View::toJson;
//    }
//
//    public static void print(Object o){
//        System.out.println(o);
//    }
//
//}
