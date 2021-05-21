package managers;

import DAO.DAO;
import data.SpaceMarine;
import exceptions.EmptyCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Operates the file for saving/loading collection.
 */
public class FileManager {
    String myenv;
    String mainFile;
    Boolean isWritable = true;
    Boolean isNed = false;
    Stack<SpaceMarine> stackFromFile = new Stack<>();
    ArrayList<String> ar = new ArrayList<>();
    AscerForStartFIle ascerForStartFIle;
    private ArrayList<SpaceMarine> tmpMarineFromSave2 = new ArrayList<>();
    private ArrayList<SpaceMarine> tmpMarineFromSave = new ArrayList<>();
    File file;

    public FileManager(String path) {
        this.myenv = path;
        this.mainFile = path;
        try {
            this.file = new File(System.getenv(myenv));
        } catch (NullPointerException e) {
            System.out.println("Системная переменная с загрузочным файлом не найдена! Добавьте её и попробуйте вновь");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Перезапустите программу");
        }
    }

    /**
     * Writes collection to a file, when main file unavailable
     */
    public void saveCollection2(Stack<SpaceMarine> stack) {
        try (PrintWriter outFile = new PrintWriter(new File("tmp.csv"))) {
            isNed = true;
            tmpMarineFromSave2.addAll(stack);
            for (SpaceMarine i : stack
            ) {
                outFile.println(i.toCsv());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Повторите попытку позже60");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите попытку позже");
        }
    }

    /**
     * Merges the temporary file with the main.
     */
    public Stack<SpaceMarine> merger() {
        Stack<SpaceMarine> spaceMarines = new Stack<>();
        if (isNed) {
            isNed = false;
            spaceMarines.addAll(tmpMarineFromSave2);
            return spaceMarines;
        }
        spaceMarines.addAll(tmpMarineFromSave);
        return spaceMarines;
    }

    /**
     * Writes collection to a file.
     */
    public void saveCollection(Stack<SpaceMarine> stack) {
        isWritable = true;
        if (System.getenv(myenv) != null) {
            if (file.exists() && !file.canWrite()) {
                System.out.println("Недостаточно прав для записи в файл. Добавьте права на запись");
                System.out.println("Создам временный файл на сохранение коллекции.");
                saveCollection2(stack);
                isWritable = false;
            } else if (!file.exists()) {
                System.out.println("Создам временный файл на сохранение коллекции.");
                saveCollection2(stack);
                isWritable = false;
            }
            if (isWritable) {
                try (PrintWriter outFile = new PrintWriter(new File(System.getenv(myenv)))) {
                    tmpMarineFromSave.addAll(stack);
                    stack = merger();
                    for (SpaceMarine i : stack
                    ) {
                        outFile.println(i.toCsv());
                    }
                    tmpMarineFromSave.clear();
                    tmpMarineFromSave2.clear();
                    isNed = false;
                    System.out.println("Коллекция успешно сохранена!");
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден. Повторите попытку позже");
                } catch (Exception e) {
                    System.out.println("Что-то пошло не так. Повторите попытку позже");
                }
            } else {
                System.out.println("Файл, кот орый содержится в загрузочной прееменной недоступен.");

            }
        }
    }


    /**
     * Reads collection from a file and then loads her.
     *
     * @return Read collection.
     */

    public Stack<SpaceMarine> loader() {
        if (System.getenv(myenv) != null) {
            if (file.exists() && !file.canRead()) {
                System.out.println("Недостаточно прав для чтения данных из файла. Добавьте права на чтение и запустите программу вновь");
                System.exit(0);
            }
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
                        if (!(pushingObject == null)) DAO.getDaoSpaceMarine().create(pushingObject);
                        ar.clear();
                    } catch (EmptyCollection e) {
                        System.out.println("В данной строке недостаточно аргументов для создания объекта");
                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так. Повторите попытку позже");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден. Добавьте файл и запустите программу заново!");
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Что-то пошло не так. Перезапустите программу.");
            }
        } else {
            System.out.println("Системная переменная с загрузочным файлом не найдена!");
            System.exit(0);
        }
        return stackFromFile;
    }
}