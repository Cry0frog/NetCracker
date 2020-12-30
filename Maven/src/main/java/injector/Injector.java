package injector;

import annotation.configuration.Configuration;
import annotation.injectable.AutoInjectable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * The class contains an inject method for dependency injection
 * @author Valuyskikh Nikita
 * @version 1.0
 */
@Configuration
public class Injector {

    /**
     * The method performs dependency injection into the passed object
     * @param object passed object
     * @param <T> data type
     * @throws NoSuchMethodException NoSuch Method Exception
     * @throws IllegalAccessException Illegal Access Exception
     * @throws InvocationTargetException Invocation Target Exception
     * @throws InstantiationException Instantiation Exception
     * @throws ClassNotFoundException Class Not Found Exception
     */
    public static <T> void inject(T object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Injector injector = new Injector();
        Class<?> aClass = injector.getClass();
        Configuration configuration = aClass.getAnnotation(Configuration.class);

        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                System.out.println(field.getType().getName());
                if (field.getType().getName().equals("java.util.ArrayList")) {
                    ArrayList<Object> arrayList = new ArrayList<>();
                    for (String str : configuration.packages()) {

                        if (field.toString().contains(str.split("\\.")[0])) {
                            Class myClass = Class.forName(str);
                            Constructor constructor = myClass.getConstructor();
                            Object o = constructor.newInstance();
                            arrayList.add(o);
                        }

                    }
                    boolean isAccessible = field.canAccess(object);
                    field.setAccessible(true);
                    field.set(object, arrayList);
                    field.setAccessible(isAccessible);
                } else {
                    String nameClasses = null;

                    for (String str : configuration.packages()) {
                        String pack = field.getType().getPackageName().split("\\.")[0];
                        if (str.split("\\.")[0].equals(pack)) nameClasses = str;
                    }

                    Class myClass = Class.forName(nameClasses);
                    Constructor constructor = myClass.getConstructor();
                    Object o = constructor.newInstance();
                    boolean isAccessible = field.canAccess(object);
                    field.setAccessible(true);
                    field.set(object, o);
                    field.setAccessible(isAccessible);
                }
            }
        }
    }
}
