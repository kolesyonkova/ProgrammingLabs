package managers;

import data.SpaceMarine;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class FileManager {
    String path;
    Stack<SpaceMarine> stackFromFile = new Stack<>();
    ArrayList<String> ar = new ArrayList<>();
    AscerForStartFIle ascerForStartFIle;

    public FileManager(String path) {
        this.path = path;
    }

    public void saveCollection(Stack<SpaceMarine> stack) {
        try (PrintWriter outFile = new PrintWriter(new File("myCollection.txt"))) {
            for (SpaceMarine i : stack
            ) {
                outFile.println(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Повторите попытку позже");
        }
    }


    public Stack<SpaceMarine> loader() {
        try (FileInputStream fstream = new FileInputStream(path)) {
            String reader;
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((reader = br.readLine()) != null) {

                String[] nm = reader.split(",");
                for (String s : nm) {
                    ar.add(s.trim());
                }
                if (ar.size() != 11) {
                    throw new Exception();
                }

                ascerForStartFIle = new AscerForStartFIle(ar);
                stackFromFile.push(ascerForStartFIle.startFunc());
                ar.clear();
            }

        } catch (
                Exception e) {
            System.out.println("something wrong");
        }
        return stackFromFile;
    }
}