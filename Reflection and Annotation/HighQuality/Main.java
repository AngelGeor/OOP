package RefclectionAndAnnotation_Lab.HighQuality;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;
        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s%n", field.getName()));

        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(System.out::println);

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(System.out::println);
    }
}
