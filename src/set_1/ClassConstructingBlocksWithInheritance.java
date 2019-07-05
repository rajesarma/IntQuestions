package set_1;

class ClassConstructingSuperClass {
	
	static int super_class_int_variable1 = 20;
	static String super_class_string_variable1 = "Variable1";
	
	{
		System.out.println("In Super Class Instance Initializing Block");
		
	}
	
	static {
		System.out.println("In Super Class Static Block");
		
//		System.out.println("In Super Class variable declared before static block: super_class_int_variable1: "+ClassConstructingSuperClass.super_class_int_variable1);
//		System.out.println("In Super Class variable declared after static block: super_class_int_variable2: "+ClassConstructingSuperClass.super_class_int_variable2);
		
//		System.out.println("In Super Class variable declared before static block: super_class_string_variable1: "+ClassConstructingSuperClass.super_class_string_variable1);
//		System.out.println("In Super Class variable declared after static block: super_class_string_variable2: "+ClassConstructingSuperClass.super_class_string_variable2);
	}
	
	ClassConstructingSuperClass() {
		System.out.println("In Super Class Constructor Block");
	}
	
	{
		System.out.println("In Super Class Instance Block");
	}
	
	static int super_class_int_variable2 = 20;
	static String super_class_string_variable2 = "Variable2";
}


public class ClassConstructingBlocksWithInheritance extends ClassConstructingSuperClass{

	{
		System.out.println("In Derived Class Instance Initializing Block");
	}
	
	static {
		System.out.println("In Derived Class Static Block");
		
//		System.out.println("From Derived Class super_class_int_variable1: "+super_class_int_variable1);
//		System.out.println("From Derived Class super_class_int_variable2: "+super_class_int_variable2);
		
//		System.out.println("From Derived Class super_class_string_variable1: "+super_class_string_variable1);
//		System.out.println("From Derived Class super_class_string_variable2: "+super_class_string_variable2);
		
	}
	
	ClassConstructingBlocksWithInheritance() {
		//super();
		System.out.println("In Derived Class Constructor Block");
	}
	
	{
		System.out.println("In Derived Class Instance Block");
	}
	
	ClassConstructingBlocksWithInheritance(int a) {
		System.out.println("In Derived Class Parameter Block: "+ a);
	}
	
	static int derived_class_int_variable = 30;
	
	public static void main(String[] args) {
		new ClassConstructingBlocksWithInheritance();
		System.out.println(ClassConstructingBlocksWithInheritance.derived_class_int_variable);
		
		System.out.println("--------------------------");
		
		//new ClassConstructingBlocksWithInheritance(10);
		
	}

}


// Can I count on the class loader to initialize those fields in order, such that I can rely on SERVLET_LOGGER to be instantiated before signupObservableAgent?

/*class SignupServlet extends HttpServlet {
    private static final Logger SERVLET_LOGGER=COMPANYLog.open(SignupServlet.class);
    private static final ExceptionMessageHandler handler = new ExceptionMessageHandler();   
    private static final SignupServletObservableAgent signupObservableAgent = 
        new SignupServletObservableAgent(null, SERVLET_LOGGER);
}

// Solution

class SignupServlet extends HttpServlet {
	   private static final Logger SERVLET_LOGGER;
	   private static final ExceptionMessageHandler handler;
	   private static final SignupServletObservableAgent signupObservableAgent;

	   static {
	      SERVLET_LOGGER = COMPANYLog.open(SignupServlet.class);
	      handler = new ExceptionMessageHandler();
	      signupObservableAgent = new SignupServletObservableAgent(null, SERVLET_LOGGER);
	   } 
	}*/