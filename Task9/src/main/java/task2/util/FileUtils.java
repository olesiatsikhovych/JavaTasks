package task2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        BufferedReader bufferedReader = null;
        List<String> result = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<>();
            for (String line; (line =  bufferedReader.readLine()) != null;){
                lines.add(line);
            }

            for (String line : lines){
                String[] sentences = line.split("(?<=[.!?])");
                result.addAll(Arrays.asList(sentences));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
