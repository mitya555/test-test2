package test.test2;

public class Logging {

	   /** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	   public void beforeAdvice(){
	      System.out.println("before advice.");
	   }

	   /** 
	    * This is the method which I would like to execute
	    * after a selected method execution.
	    */
	   public void afterAdvice(){
	      System.out.println("after advice.");
	   }

	   /** 
	    * This is the method which I would like to execute
	    * when any method returns.
	    */
	   public void afterReturningAdvice(Object retVal){
	      System.out.println("returning: " + retVal);
	   }

	   /**
	    * This is the method which I would like to execute
	    * if there is an exception raised.
	    */
	   public void AfterThrowingAdvice(IllegalArgumentException ex){
	      System.out.println("exception: " + ex);   
	   }
	   
}
