package volatiles;

import com.tsbx.GateWayMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * volatile 可见性验证 ,原子性验证（atom）
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/27 16:02
 */

class MyDate{
    volatile int  number = 0;
    public void addNum(){
        this.number += 10;
    }
    public void add(){
        number ++;
    }
}

                                                                     
@Slf4j
@SpringBootTest(classes = GateWayMain.class)
@RunWith(SpringRunner.class)
public class VolatileVisibalityDemo {
    
    
    @Test
    public void  VolatileAtomDemo(){
        MyDate myDate = new MyDate();
        // 启动20个线程，每个线程将myData的number值加1000次，那么理论上number值最终是20000
        for (int i= 0; i<20; i++){
            new Thread(()->{
                myDate.add();   
            }).start();
        }
        
        // 程序运行时，模型会有主线程和守护线程。如果超过２个，那就说明上面的２０个线程还有没执行完的，就需要等待
        while (Thread.activeCount() >2){
            Thread.yield();
        }
        log.info("number值加了20000次，此时number的实际值是：" + myDate.number);
    }
    
    
    
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        // 启动一个线程修改myData的number，将number的值加10
        new Thread(()->{
            log.info("线程" + Thread.currentThread().getName() + "正在执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myDate.addNum();
            log.info("线程" + Thread.currentThread().getName() + "执行完成后，numer的值为：" + myDate.number);

        }).start();
        
        // 看一下主线程能否保持可见性
        while (myDate.number == 0){
            // 当上面的线程将number加10后，如果有可见性的话，那么就会跳出循环；
            // 如果没有可见性的话，就会一直在循环里执行
        }
        log.info("具有可见性");


    }

}
