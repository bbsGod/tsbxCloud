package lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * lambda语法在Colletcion接口中使用
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/16 11:01
 */
@SpringBootTest(classes = LambdaMap.class)
@RunWith(SpringRunner.class)
@Slf4j
public class LambdaCollection {
    
    //遍历 arrayList 使用for曾强for循环
    @Test
    public void forEach(){
        //曾强for循环
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        for (String str : list){
            log.info(str);
        }
    }
    
    //遍历 arraylist 通过forEach方法 使用匿名内部类 和 lamdb实现
    @Test
    public void forEachByLambda(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        //匿名内部类实现
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info(s);
            }
        });
        //lambda实现
        list.forEach((s) -> log.info(s));
        
    }
    
    //删除符合条件的arrayList ，通过普通的迭代器
    @Test
    public void removeIf(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            if(it.next().length() > 3){
                it.remove();
            }
        }
        list.forEach((s) -> log.info(s));

    }
    //删除符合条件的arrayList ，通过removeIf方法 使用匿名内部类 和 lambda实现
    @Test
    public void removeIfByLambda(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
   /*     list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });*/
        list.removeIf((s) -> s.length() >3);
        list.forEach((s) -> log.info(s));

    }
    
    //替换 ,代码便利替换
    @Test
    public void replaceAll(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            if(str.length() > 3){
                list.set(i,str.toLowerCase());    
            }
        }
        list.forEach((s) -> log.info(s));
        

    }
    //替换 ,通过replace方法，使用匿名内部类和lambda表达式实现
    @Test
    public void replaceAllByLambda(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
   /*     list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        });*/
        list.replaceAll((s) -> s.toLowerCase());
        list.forEach((s) -> log.info(s));
        
    }
    
    //比较大小 sort  使用Collecionts工具类中
    @Test
    public void sort(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        list.forEach((s) -> log.info(s));

    }
    
    //比较大小 sort  使用list.sort方法  
    @Test
    public void sortBylambda(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "LOVE", "YOU", "TOO"));
        list.sort((str1,str2) -> str1.length() - str2.length());
        list.forEach((s) -> log.info(s));
    }
    
}
