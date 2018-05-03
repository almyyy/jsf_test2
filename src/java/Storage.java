import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.*;


@ManagedBean(name = "storage", eager = true)
@RequestScoped
public class Storage {
    private String dataFileName = "ToDoStorageFile.bin"; // each user should have its own storage file
    private String data;
    private String errMsg = "no err";
    
    public Storage(){
        load(); // load data in constructor
    }
    
    // it should be saved into DB
    public void save() {
        try{
            FileOutputStream fos=new FileOutputStream(dataFileName); 
            ObjectOutputStream output=new ObjectOutputStream(fos);

            output.writeObject(data);
            
            errMsg = "saving ok";
        }
        catch(Exception ex){
            //System.out.println("Exception is: "+ex);
            errMsg = "Exception is: "+ex;
        }
    }
    
    // it should be loaded from DB
    private void load() {
        Path path = Paths.get(dataFileName);
        if (!Files.exists(path)) {
            data = "initial value...";
            return;
        }
        
        try{
            FileInputStream fis=new FileInputStream(dataFileName);
            ObjectInputStream input=new ObjectInputStream(fis);

            data = (String)input.readObject();
            
            errMsg = "loading ok";
        }
        catch(Exception ex){
            //System.out.println("Exception is: "+ex);
            errMsg = "Exception is: "+ex;
        }       
   
    }
            
    public String getData() {
	return data;
    }
    public void setData(String data) {
	this.data = data;
    }
    
    public String getErrMsg() {
	return errMsg;
    }
    public void setErrMsg(String errMsg) {
	this.errMsg = errMsg;
    }
} 