package lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/19 9:24
 */
@SpringBootTest(classes = FinallyTest.class)
@RunWith(SpringRunner.class)
@Slf4j
public class FinallyTest {
    
    public int getTt(){
        int a = 1;
        try {
            int h = 0;
            a = a/h;
            return a + 1;
        } catch (Exception e) {
            return a + 2;
        } finally {
            a = 30;
            return a;
        }
    }
    
    @Test
    public void finallyTt(){
       log.info(getTt() + ""); 
    }


    
}
