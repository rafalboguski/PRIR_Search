import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class Test {

 
    public static void main(String[] argv) throws InterruptedException {

        Controller con = new Controller();

        populate(con, 44);


        ArrayDeque<Result> wyn = null;

        wyn = con.search("b");


        int match =0;
        for(Result r:wyn)
            match += r.positions.size();
        //    System.out.println(r);


        System.out.println("Found: "+ match);

    }



    private static void populate(Controller controller, int BOOKS_NUM) {



        for (int i = 0; i < BOOKS_NUM; i++) {

            int tmp = (int) (BOOKS_NUM/10f);

            if (i % tmp == 0)
                System.out.print("▀▀");

            //UUID.randomUUID().toString()  losowy string

            String text = "";
            String aaa = UUID.randomUUID().toString();
            for(int w =0;w<2000;w++){
                text += aaa+"\n";
            }

            controller.addBook(String.valueOf(i), text, String.valueOf(i));
        }
        System.out.println("");
    }


}
