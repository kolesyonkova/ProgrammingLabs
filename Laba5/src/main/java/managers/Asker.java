package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import exceptions.LowHealthException;
import exceptions.MustBeNotEmptyException;
import exceptions.NumberOfHeartCountsException;
import exceptions.NumberOfMarinesException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asker {
    private final Scanner userScanner;
    private LocalDate localDate;

    public Asker(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    public Chapter askChapter() {
        return new Chapter(askChapterName(), askChapterLegion(), askChapterMarinesCount(), askChapterWorld());
    }

    public Long askChapterMarinesCount() {
        Long marinesCount;
        String tmp;
        while (true) {
            try {
                System.out.println("Введите количество морских пехотинцев: ");
                tmp = userScanner.nextLine().trim();
                marinesCount = Long.parseLong(tmp);
                if (marinesCount > 1000 || marinesCount <= 0) {
                    throw new NumberOfMarinesException();
                }
                break;
            } catch (NumberOfMarinesException e) {
                System.out.println("Количество морских пехотинцев должно быть от 1 до 1000");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат, повторите ввод.");
            } catch (InputMismatchException e) {
                System.out.println("Неверные данные. Повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод");
            }
        }
        return marinesCount;
    }

    public String askChapterWorld() {
        String world;
        while (true) {
            try {
                System.out.println("Введите мир: ");
                world = userScanner.nextLine();
                if (world.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Поле не может быть пустым. Повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод");
            }
        }
        return world;
    }

    public String askChapterLegion() {
        String parentLegion = "";
        System.out.println("Введите имя Легиона: ");
        try {
            parentLegion = userScanner.nextLine();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод");
        }
        return parentLegion;
    }

    public String askChapterName() {
        String name = "";
        while (true) {
            try {
                System.out.println("Введите имя главы: ");
                name = userScanner.nextLine();
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Поле не может быть пустым. Повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод");
            }
        }
        return name;
    }

    public Integer askHeartCount() {
        String tmp;
        Integer heartCount;
        while (true) {
            try {
                System.out.println("Введите количество сердечных сокращений: ");
                tmp = userScanner.nextLine().trim();
                heartCount = Integer.parseInt(tmp);
                if (heartCount <= 0 || heartCount > 3) {
                    throw new NumberOfHeartCountsException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат, повторите ввод.");
            } catch (NumberOfHeartCountsException e) {
                System.out.println("Число серднечный сокращений должно быть в диапозоне от 1 до 3. Повторите ввод. ");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return heartCount;
    }

    public String askAchievements() {
        String str;
        while (true) {
            try {
                System.out.println("Введите достижения: ");
                str = userScanner.nextLine().trim();
                if (str.equals("")) {
                    throw new MustBeNotEmptyException();
                }
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Поле не может быть пустым. Повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return str;
    }

    public Double askX() {
        String tmp;
        Double x;
        while (true) {
            try {
                System.out.println("Введите координату Х: ");
                tmp = userScanner.nextLine().trim();
                x = Double.parseDouble(tmp);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат, повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return x;

    }

    public Integer askY() {
        String tmp;
        Integer y;
        while (true) {
            try {
                System.out.println("Введите координату Y: ");
                tmp = userScanner.nextLine().trim();
                y = Integer.parseInt(tmp);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат, повторите ввод.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return y;

    }

    public Coordinates askCoordinates() {
        return new Coordinates(askX(), askY());
    }

    public LocalDate askLocalDate() {
        localDate = LocalDate.now();
        return localDate;
    }

    public Long askHealth() {
        String tmp;
        Long health;
        while (true) {
            try {
                System.out.println("Введите здоровье бойца: ");
                tmp = userScanner.nextLine().trim();
                health = Long.parseLong(tmp);
                if (health <= 0) {
                    throw new LowHealthException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат, повторите ввод.");
            } catch (LowHealthException e) {
                System.out.println("Здоровье не может быть меньше 1");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return health;
    }

    public String askName() {
        String name;
        while (true) {
            try {
                System.out.println("Введите имя: ");
                name = userScanner.nextLine().trim();
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Имя не распознано!");
            } catch (MustBeNotEmptyException exception) {
                System.out.println("Имя не может быть пустым!");
            } catch (IllegalStateException exception) {
                System.out.println("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    public MeleeWeapon askMeleeWeapon() {
        MeleeWeapon meleeWeapon;
        String weapon;
        while (true) {
            try {
                System.out.println("Выберите оружие ближнего боя. На выбор: \n MANREAPER,\n" +
                        "POWER_BLADE,\n" +
                        "POWER_FIST");
                weapon = userScanner.nextLine();
                if (weapon.equals("")) {
                    throw new MustBeNotEmptyException();
                }
                meleeWeapon = MeleeWeapon.valueOf(weapon.toUpperCase());
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Поле не должно быть пустым");
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите попытку");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите ввод.");
            }
        }
        return meleeWeapon;
    }
}
//TODO: наложить условия на аскеры, обработать try/catch