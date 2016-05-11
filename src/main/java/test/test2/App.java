package test.test2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    private static AbstractApplicationContext context;

	public static void main( String[] args )
    {
        context = new ClassPathXmlApplicationContext("Beans.xml");

        Profile profile = (Profile) context.getBean("profile");

        profile.printAge();
        profile.printName();
        
        context.registerShutdownHook();
    }
}
