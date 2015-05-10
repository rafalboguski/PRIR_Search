import java.util.ArrayList;
import java.util.UUID;

public class Test {

 
    public static void main(String[] argv) throws InterruptedException {

        long heapSizeBefore = Runtime.getRuntime().totalMemory();
        int[] range = {0, 0, 0, 0};

        Controller con = new Controller();

        // liczba ksiazek
        populate(con, 500000);


        for(int i = 1;i<5;i++)
            search(con,i);


        System.out.println("------------------------------");
        System.out.println("------------------------------");
        for (Result x : aaa)
            System.out.print(x);

        long heapSizeAfter = Runtime.getRuntime().totalMemory();
        long size = heapSizeAfter - heapSizeBefore;


        System.out.println("memory taken: " + size + "\t" + 100 * size / (float) Runtime.getRuntime().maxMemory() + " %");
        System.out.println("------------------------------");


    }

    public static ArrayList<Result> aaa = new ArrayList<>();

    //
    private static void search(Controller controller, int threadsNum) {


        controller.THREADS_NUM = threadsNum;
        //System.out.println("-- search ---------------------");


        ArrayList<Result> wyn = new ArrayList<>();

        long timeStart = System.currentTimeMillis();

        // ile przebiegow szukanie (usrednia wyniki czasu wykonywania)
        //for(int i = 0;i<32;i++)
         wyn = controller.search("ile");


//        System.out.println("------------------------------");
//        System.out.println("----- WYNIKI :   PLIKI " + wyn.size());
//        System.out.println("------------------------------");
//
//       for (Result x : wyn)
//            System.out.println(x);


        //System.out.println(numberFound + " which is: "+ 100*(float)numberFound/BOOKS_NUM + " %");
        //  System.out.println("---- time");
        System.out.println((System.currentTimeMillis() - timeStart));
        aaa.addAll(wyn);


    }

    //
    private static void populate(Controller controller, int BOOKS_NUM) {

        System.out.println("------------------------------");
        System.out.println("- begin ----------------------");



        for (int i = 0; i < BOOKS_NUM; i++) {

            int tmp = (int) (BOOKS_NUM/10f);

            if (i % tmp == 0)
                System.out.print("▀▀");

            //UUID.randomUUID().toString()  losowy string
            controller.addBook(String.valueOf(i), "dsdfsdfsdfsdfsdfdsf\nsdfsdfsdfsdfds\nschahckhdfsdf\nsfdsdfsdfsdf\nsdfsdfdsfdsf\nsdfsdfsdf\nsdsdfsdf\nsfsdf", String.valueOf(i));
        }
        System.out.println("");



    }


}
