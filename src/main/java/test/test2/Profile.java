package test.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	   @Autowired
	   @Qualifier("student1")
	   private Person person;

	   public Profile(){
	      System.out.println("Inside Profile constructor." );
	   }

	   public void printAge() {
	      System.out.println("Age : " + person.getAge() );
	   }

	   public void printName() {
	      System.out.println("Name : " + person.getName() );
	   }
}
