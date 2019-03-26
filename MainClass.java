import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(ForTests.class);
    }
    private static void start(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clazz.getConstructor();
        Object newInstance = constructor.newInstance();

        startBeforeAfterSuite(clazz,BeforeSuite.class, newInstance);

        List<Method> tests = getMethodByAnnotation(clazz, Test.class);
        tests.sort(Comparator.comparingInt((Method method) -> {
            return method.getAnnotation(Test.class).priority().getPriority();
        }).reversed());
        for (Method test : tests) {
            test.invoke(newInstance);
        }

        startBeforeAfterSuite(clazz, AfterSuite.class, newInstance);
    }

    private static void startBeforeAfterSuite(Class<?> clazz, Class<? extends Annotation> annotation,Object instance) throws InvocationTargetException, IllegalAccessException {

        List<Method> singleMethodAsList = getMethodByAnnotation(clazz, annotation);
        for (Method method : singleMethodAsList) {
            method.invoke(instance);
        }

    }

    private static List<Method> getMethodByAnnotation(Class<?>clazz, Class<? extends Annotation> annotation){
        List<Method> methods = new ArrayList<>();
        for (Method method: clazz.getMethods()) {
            if (method.isAnnotationPresent(annotation)){
                methods.add(method);
            }
            
        }

        boolean isSingle = methods.size() < 2;
        boolean mustBeSingle = annotation.equals(BeforeSuite.class) || annotation.equals(AfterSuite.class);
        if (mustBeSingle && !isSingle)
            throw new RuntimeException(annotation.getSimpleName() + " IS DOUBLED!!! KILL IT!");

        return methods;


    }
}
