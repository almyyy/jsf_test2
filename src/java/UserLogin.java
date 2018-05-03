import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean(name = "userLogin", eager = true)
//@RequestScoped
public class UserLogin {
    private String message ="Enter username and password.";
    private String username;
    private String password;
    
    private String cred1Usr = "usr1"; // hardcoded 2 users, I know maybe I could use array of struct with members username and password
    private String cred1Pwd = "pwd1";
    private String cred2Usr = "usr2";
    private String cred2Pwd = "pwd2";

    
    public String login(){
        if(cred1Usr.equalsIgnoreCase(username) && cred1Pwd.equalsIgnoreCase(password) ||
           cred2Usr.equalsIgnoreCase(username) && cred2Pwd.equalsIgnoreCase(password) ) {
            message ="Successfully logged-in.";
            return "storage"; // storage.xhtml
    	} else {
            message ="Wrong credentials.";
            return "login"; // login.xhtml
    	}
    }
    public String getMessage() {
	return message;
    }
    public void setMessage(String message) {
	this.message = message;
    }
    public String getUsername() {
	return username;
    }
    public void setUsername(String username) {
	this.username = username;
    }
    public String getPassword() {
	return password;
    }
    public void setPassword(String password) {
	this.password = password;
    }
} 