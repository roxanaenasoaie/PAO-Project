package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsv {

    private static ReadFromCsv instance = null;

    private ReadFromCsv() {}

    public static ReadFromCsv getInstance() {
        if (instance == null) {
            instance = new ReadFromCsv();
        }
        return instance;
    }

    public List<String[]> read(String filename) throws IOException {
        String line = "";
        String splitBy = ",";
        String[] data = new String[0];
        List<String[]> dataList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {
            data = line.split(splitBy);
            dataList.add(data);
        }
        return dataList;
    }
}