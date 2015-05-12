import prototypes.Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class Test {

 
    public static void main(String[] argv) throws InterruptedException {

        Controller con = new Controller();

        // liczba ksiazek jako parametr
        populate(con, 1000);

        ArrayDeque<Result> wyn = null;

        Random ran = new Random();

        // w petli robie szukanie
        // dla jedego nie jest stabilne
        // najpierw musi sie rozkrecic
        // wtedy widac efekty zrownoleglenia

        for (int i = 0; i < 250; i++) {

            wyn = con.search(String.valueOf(ran.nextInt(10)));
            int match = 0;
            for (Result r : wyn) {
                match += r.positions.size();
                //    System.out.println(r); // wypisanie wynikow

            }
            //System.out.println("Found: " + match); //wypisanie liczby znalezionych wystapien

        }
    }


    private static void populate(Controller controller, int BOOKS_NUM) {

        for (int i = 0; i < BOOKS_NUM; i++) {
            int tmp = (int) (BOOKS_NUM/10f);

            if (i % tmp == 0)
                System.out.print("▀▀");

            //UUID.randomUUID().toString()  losowy string b3g8s8-a8h3 itd

            String text = "";
            String aaa = "wenocbbuoiewcuinhkxsucgfuisvsicbdsfhcuisdbsduicsd";//UUID.randomUUID().toString();
          //  for(int w =0;w<12;w++){ // petla do sklejania bardzo dlugich tekstow
                text += aaa+"\n";
          //  }
            controller.addBook(String.valueOf(i+1), text, String.valueOf(i));
        }
        System.out.println("");
    }


}
