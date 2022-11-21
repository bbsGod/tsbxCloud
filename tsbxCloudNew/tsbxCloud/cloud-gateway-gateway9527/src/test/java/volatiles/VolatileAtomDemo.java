package volatiles;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile Atom 非原子性验证
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/28 9:53
 */

class MyData{
    volatile int number = 0;
    volatile AtomicInteger num = new AtomicInteger();
    
    public synchronized  void add1(){
        number ++;
       
    }
    public  void add(){
        number ++;
        num.getAndIncrement();
    }
}
@Slf4j
public class VolatileAtomDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 启动20个线程，每个线程将myData的number值加1000次，那么理论上number值最终是20000
        for (int i=0; i<20; i++){
            new Thread(()->{
                for (int j=0; j<1000; j++){
                    myData.add();
                }
            }).start();
        }
        // 程序运行时，模型会有主线程和守护线程。如果超过２个，那就说明上面的２０个线程还有没执行完的，就需要等待
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        log.info("number值加了20000次，此时number的实际值是：" + myData.number);
        log.info("num值加了20000次，此时number的实际值是：" + myData.num);

    }
}
