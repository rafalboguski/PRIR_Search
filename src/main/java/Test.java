//import prototypes.Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class Test {


    public static void main(String[] argv) throws InterruptedException {


        Controller con = new Controller();

        con.addBook("a","Ala\n ma kota Toma","sdf");
        ///con.addBook("b","Ala\n ma kota Bena","sdf");
       // con.addBook("c","Ala\n ma kota Eda","sdf");



        print(con,"Toma");

    }

    private static void print(Controller con, String o){
        //System.out.println("Search --------"+o);
        try {
            ArrayDeque<Result> ds = con.search(o);
            System.out.println(ds.size());
            for(Result r: ds) {
                System.out.println(r.filename);
                System.out.println(r.positions);
            }



        } catch (InterruptedException e) {
            System.out.println(e);
        }
        //System.out.println("-------------");
    }

    static void populate(Controller controller, int BOOKS_NUM) {

        for (int i = 0; i < BOOKS_NUM; i++) {
            int tmp = (int) (BOOKS_NUM/10f);

            if (i % tmp == 0)
                System.out.print("▀▀");

            //UUID.randomUUID().toString()  losowy string b3g8s8-a8h3 itd

            String text = "";
            String aaa = "wenocbbuoiewcuinochkxsucgfuisvsicbdnocsfhcuisdbsduicsd";//UUID.randomUUID().toString();
           for(int w =0;w<5;w++){ // petla do sklejania bardzo dlugich tekstow
                text += aaa+"\r\n";
            }
            controller.addBook(String.valueOf(i+1), text, String.valueOf(i));
        }
        System.out.println("");
    }


}
