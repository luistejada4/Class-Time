import com.time.Time;


public class Main {

    public static void main(String args[]) throws InterruptedException {

        Time time = new Time();

         time.setTime(7, 20, 0);
         for(int i = 0; i < 1000000000; i++)
         {
            System.out.println(time.UniversalFormat()); 
         }
         time.stopTime();
    }
}