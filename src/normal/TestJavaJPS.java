package normal;

import scala.math.Ordering;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 刘雄康
 * @version v1.0
 * @description TestJavaJps
 * @date 2018年12月21日
 */
public class TestJavaJPS {


    public static void main(Ordering.String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " is running");
            }
        }, new Date(), 6000);

    }
}
