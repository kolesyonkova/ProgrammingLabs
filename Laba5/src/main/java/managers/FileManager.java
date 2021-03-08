package managers;

import data.SpaceMarine;
import exceptions.CanNotExecuteException;
import exceptions.EmptyCollection;
import exceptions.UnReadException;
import exceptions.UnWriteException;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Operates the file for saving/loading collection.
 */
public class FileManager {
    String myenv;
    Stack<SpaceMarine> stackFromFile = new Stack<>();
    ArrayList<String> ar = new ArrayList<>();
    AscerForStartFIle ascerForStartFIle;
    File file;

    public FileManager(String path) {
        this.myenv = path;
        this.file = new File(System.getenv(myenv));
    }

    public void checkRights(File file) {
        if (!file.canExecute()) try {
            throw new CanNotExecuteException();
        } catch (CanNotExecuteException e) {
            System.out.println("Can not execute");
        }
        if (!file.canExecute()) try {
            throw new UnReadException();
        } catch (UnReadException e) {
            System.out.println("Can not read");
        }
        if (!file.canWrite()) {
            try {
                throw new UnWriteException();
            } catch (UnWriteException e) {
                System.out.println("can not write");
            }
        }
    }

    /**
     * Writes collection to a file.
     */
    public void saveCollection(Stack<SpaceMarine> stack) {
        if (System.getenv(myenv) != null) {
            checkRights(file);
            try (PrintWriter outFile = new PrintWriter(new File(System.getenv(myenv)))) {
                for (SpaceMarine i : stack
                ) {
                    outFile.println(i + ", ");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден. Повторите попытку позже");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите попытку позже");
            }
        } else System.out.println("Системная переменная с загрузочным файлом не найдена!");
    }


    /**
     * Reads collection from a file and then loads her.
     *
     * @return Read collection.
     */

    public Stack<SpaceMarine> loader() {
        if (System.getenv(myenv) != null) {

            try (FileInputStream fstream = new FileInputStream(System.getenv(myenv))) {
                String reader;
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                while ((reader = br.readLine()) != null) {
                    try {
                        ar.clear();
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
                    } catch (EmptyCollection e) {
                        System.out.println("В данной строке недостаточно аргументов для создания объекта");
                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так. Повторите попытку позже");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Системная переменная с загрузочным файлом не найдена!");
        return stackFromFile;
    }
}