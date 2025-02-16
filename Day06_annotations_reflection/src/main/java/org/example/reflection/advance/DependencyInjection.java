package org.example.reflection.advance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//Create the @Inject annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

//The DI Container for injecting dependencies using reflection
class DIContainer {

    public static void inject(Object target) throws IllegalAccessException {
        //Get all fields of the target class
        Field[] fields = target.getClass().getDeclaredFields();

        for (Field field : fields) {
            //Check if the field has the @Inject annotation
            if (field.isAnnotationPresent(Inject.class)) {

                field.setAccessible(true);

                //Get the type of the field
                Class<?> fieldType = field.getType();

                //Create an instance of the field type
                Object dependency = createInstance(fieldType);

                //Inject the dependency into the field
                field.set(target, dependency);
            }
        }
    }

    //A simple method to create an instance of a class
    private static Object createInstance(Class<?> clazz) {
        try {
            //Create a new instance using the default constructor
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
        }
    }
}

//A sample dependency class
class DatabaseService {
    public void connect() {
        System.out.println("Connecting to the database...");
    }
}

//A sample class that needs dependency injection
class UserService {
    @Inject
    private DatabaseService databaseService;

    public void performAction() {
        databaseService.connect();
        System.out.println("User service is performing an action.");
    }
}

public class DependencyInjection  {
    public static void main(String[] args) {
        try {
            UserService userService = new UserService();

            //Inject dependencies into the userService object
            DIContainer.inject(userService);

            //Call a method on the injected class
            userService.performAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
