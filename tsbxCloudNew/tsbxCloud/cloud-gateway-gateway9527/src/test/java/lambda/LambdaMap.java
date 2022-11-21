package lambda;

import com.tsbx.GateWayMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * lambda语法在Map中使用
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/16 9:34
 */
@SpringBootTest (classes = GateWayMain.class)
@RunWith(SpringRunner.class)
@Slf4j
public class LambdaMap {
    @Test
    public void contextLoads() {
        System.out.printf("1111");
    }
    
    //   map 遍历 之前代码
    @Test
    public void forEach(){
        HashMap<Integer, String > map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        for(Map.Entry<Integer,String> entry : map.entrySet() ){
            log.info(entry.getKey() + "==" + entry.getValue());
        }
    }
    
    // forEachs map 便利 使用匿名内部类 和 lambda表达式
    @Test
    public  void forEachByLambda(){
        HashMap<Integer, String > map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
              log.info(k + "==" + v);  
            }
        });

        map.forEach((k, v) -> log.info(k + "==" + v));
    }
    
    //map 替换所有单词为大写
    @Test
    public void replaceAll(){
        HashMap<Integer, String > map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        for(Map.Entry<Integer, String > entry : map.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
        }
        for (Map.Entry<Integer, String> entry1 : map.entrySet()){
            log.info(entry1.getKey() + "=" + entry1.getValue());
        }
    }
   
    // map 替换所有的单词为大写 通过replaceAll方法，使用匿名内部类和lambda来实现
    @Test
    public void replaceAllByLambda(){
        HashMap<Integer, String > map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
/*        map.replaceAll(new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer k, String v) {
                return v.toUpperCase(); 
            }
        });*/
        map.replaceAll((k,v) -> v.toUpperCase());
        for (Map.Entry<Integer, String> entry1 : map.entrySet()){
            log.info(entry1.getKey() + "=" + entry1.getValue());
        }
    }
    
    

}
