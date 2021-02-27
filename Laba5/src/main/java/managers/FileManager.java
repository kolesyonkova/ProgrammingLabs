package managers;

import java.io.*;
import java.util.*;

public class FileManager {
    String path;
    ArrayDeque<String> arrayDeque=new ArrayDeque<>();
    public FileManager(String path) {
        this.path = path;
    }

    public ArrayDeque<String> reader() {
        try (FileInputStream fstream = new FileInputStream(path)) {
            String reader;
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            do{
            reader=br.readLine();
                arrayDeque.add(reader);
            }while (!reader.equals("End"));
        } catch (Exception e) {
        }
        return arrayDeque;
    }


    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }
}