package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import data.SpaceMarine;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class FileManager {
    String path;
    Stack<SpaceMarine> stackFromFile = new Stack<>();
    ArrayList<String> ar = new ArrayList<String>();
    AscerForStartFIle ascerForStartFIle;
    public FileManager(String path) {
        this.path = path;
    }

    public Stack<SpaceMarine> loader() {
        try (FileInputStream fstream = new FileInputStream(path)) {
            String reader;
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((reader = br.readLine()) != null) {

                String[] nm = reader.split(",");
                for (int i = 0; i < nm.length; i++) {
                    ar.add(nm[i].trim());
                }
                if (ar.size() != 11) {
                    throw new Exception();
                }

                ascerForStartFIle=new AscerForStartFIle(ar);
                stackFromFile.push(ascerForStartFIle.startFunc());
                ar.clear();
            }

        } catch (
                Exception e) {
            System.out.println("something wrong");
        }
        return stackFromFile;
    }


    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }
}