import java.util.ArrayList;
import java.util.UUID;

public class Test {

    public static int BBBBB = 1000000;

    public static void main(String[] argv) throws InterruptedException {


//        Controller controller = new Controller();
//        populate(controller, BBBBB);
//
//        search(controller,1);
//        search(controller,2);
//        search(controller,3);
//        search(controller,4);


        int[] range = {0, 0, 0, 0};

        Controller con = new Controller();

        ArrayList<Result> wyn = con.search("ile");

        for(Result x:wyn)
            System.out.println(x);

    }



//
//    private static void search(Controller controller, int threadsNum) {
//
//        controller.THREADS_NUM=threadsNum;
//        //System.out.println("-- search ---------------------");
//
//        long timeStart  = System.currentTimeMillis();
//
//
//        for(int i =0;i<1;i++){
//            controller.search(String.valueOf(i));
//
//        }
//
//        //System.out.println(numberFound + " which is: "+ 100*(float)numberFound/BOOKS_NUM + " %");
//      //  System.out.println("---- time");
//        System.out.println(controller.THREADS_NUM+ "\t"+(System.currentTimeMillis()-timeStart));
//    }
//
//    private static void populate(Controller controller, int BOOKS_NUM) {
//
//        System.out.println("------------------------------");
//        System.out.println("- begin ----------------------");
//
//        long heapSizeBefore = Runtime.getRuntime().totalMemory();
//
//
//        for (int i = 0; i < BOOKS_NUM; i++) {
//
//            if (i % 10 == 0)
//                System.out.print((int) ((float) i / BOOKS_NUM) + "\r");
//
//            //UUID.randomUUID().toString()
//            controller.addBook(String.valueOf(i), String.valueOf((int)(Math.random()*10000)), String.valueOf(i));
//        }
//
//        long heapSizeAfter = Runtime.getRuntime().totalMemory();
//        long size = heapSizeAfter - heapSizeBefore;
//
//
//
//        System.out.println("memory taken: " + size + "\t" + 100 * size / (float)Runtime.getRuntime().maxMemory() + " %");
//        System.out.println("------------------------------");
//
//    }


}
