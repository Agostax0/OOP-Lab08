package it.unibo.oop.lab.mvcio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * 
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator");
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     */
    //private DataInputStream input = new DataInputStream(new FileInputStream(""));
    private File x = new File("");
    /**
     * 
     * @param path
     */
    public void setCurrentFile(final String name) {
        if (x.exists()) {
            x.renameTo(new File(Controller.PATH+name+".txt"));
        } else {
            x.delete();
        }
    }
    /**
     * 2) A method for getting the current File
     * 
     */
    /*
     * @return
     */
    public File getCurrentFile() {
        return this.x;
    }

     /* 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 
     */
    /*
     * @return
     */
    public String getPath() {
        return this.x.getAbsolutePath();
    }
     /* 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 
     */
    public void writeOnFile(final String input) {
        try(DataOutputStream os = new DataOutputStream(new FileOutputStream(this.x.getAbsoluteFile()))){
            os.writeUTF(input);
        }catch(Exception e1){
            System.out.print("errore");
        }
    }
     /* 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
    

}
