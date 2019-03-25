import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
ForTests tests = new ForTests();

        for (Method method:tests.getClass().getDeclaredMethods()
             ) {Test annotation = method.getAnnotation(Test.class);
                BeforeSuite bfs = method.getAnnotation(BeforeSuite.class);
                AfterSuite afs = method.getAnnotation(AfterSuite.class);

             if (annotation !=null){
                 method.invoke(tests);
                 System.out.println(bfs);
                 System.out.println("Test text is" + annotation.Type());
                 System.out.println(afs);
             }
            
        }

    }
}
