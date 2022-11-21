package lambda;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/9/15 14:02
 */
public class Test1 {
    public static void main(String[] args) {
        new Thread( () -> {
            System.out.println("lamdba写法");
            System.out.println("lamdba1");
        }).start();
        new Thread( () -> System.out.printf("lamdba2")).start();
        new MathOperation() {
            @Override
            public void operation(int a, int b) {
                System.out.println(a + b); 
            }
        }.operation(1,2);

        MathOperation mathOperation = (a, b) -> System.out.println(a + b);
        mathOperation.operation(1,2);
    }
    
    

    
    
}
