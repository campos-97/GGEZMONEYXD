package algorithms.files.txt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class txtAlgorithms {

    //Creates txt file, and saves it. Warning: If file already exists it would overwrite it.
    public static void saveTxt(String txtPath, String text){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(txtPath, "UTF-8");
            writer.print(text);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
