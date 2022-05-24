package application;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

public class WriteToCsv {
    public void write(String filename, List<String> data){
        try{
            FileWriter writer = new FileWriter(filename);
            for (String row : data){
                writer.append(String.join(",", row));
                writer.append("\n");

            }

            writer.flush();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
