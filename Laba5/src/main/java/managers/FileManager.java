package managers;

import data.SpaceMarine;
import exceptions.EmptyCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Operates the file for saving/loading collection.
 */
public class FileManager {
    String path;
    Stack<SpaceMarine> stackFromFile = new Stack<>();
    ArrayList<String> ar = new ArrayList<>();
    AscerForStartFIle ascerForStartFIle;

    public FileManager(String path) {
        this.path = path;
    }

    /**
     * Writes collection to a file.
     */
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

    /**
     * Reads collection from a file and then loads her.
     *
     * @return Read collection.
     */

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
                    throw new EmptyCollection();
                }
                ascerForStartFIle = new AscerForStartFIle(ar);
                SpaceMarine pushingObject = ascerForStartFIle.startFunc();
                if (!(pushingObject == null)) stackFromFile.push(pushingObject);
                ar.clear();
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Загрузочный файл не найден!");
        } catch (EmptyCollection e) {
            System.out.println("В данной строке недостаточно аргументов для создания объекта");
        } catch (Exception e) {
            System.out.println("something wrong");
        }
        return stackFromFile;
    }
}