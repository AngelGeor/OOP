package RefclectionAndAnnotation_Lab.ReflectionTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;
        System.out.println(clazz.toString());
        System.out.println(clazz.getSuperclass().toString());
        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Reflection reflection = (Reflection) clazz.getDeclaredConstructor().newInstance();
        System.out.println(reflection);

        Constructor constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class);
        Class[] parametersTypes = constructor.getParameterTypes();



    }
}
