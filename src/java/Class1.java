import javax.faces.bean.ManagedBean;
@ManagedBean(name = "Class1", eager = true)
 
 public class Class1 {

   public Class1() {
      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World!";
   }
}
