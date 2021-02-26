package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import exceptions.MustBeNotEmptyException;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asker {
    private Scanner userScanner;
    private LocalDate localDate;
    CollectionManager collectionManager;

    public Asker(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    public Chapter askChapter() {
        Chapter chapter = new Chapter();
        try {
            String name;
            System.out.println("Введите имя главы: ");
            name=userScanner.nextLine();
            if (name.equals("")) throw new MustBeNotEmptyException();
            chapter.setName(name);
            System.out.println("Введите родительский легион: ");
            chapter.setParentLegion(userScanner.nextLine());
            System.out.println("Введите мир: ");
            chapter.setWorld(userScanner.nextLine());
            System.out.println("Введите количество морских пехотинцев: ");
            chapter.setMarinesCount(userScanner.nextLong());
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");}
            return chapter;
        }

        public Integer askHeartCount () {
            Integer heartCount;
            System.out.println("Введите количество сердечных сокращений: ");
            heartCount = userScanner.nextInt();
            userScanner.nextLine();
            return heartCount;
        }

        public String askAchievements () {
            String str;
            System.out.println("Введите достижения: ");
            str = userScanner.nextLine();
            return str;
        }

        public Double askX () {
            System.out.println("Введите координату Х: ");
            return userScanner.nextDouble();
        }

        public Integer askY () {
            System.out.println("Введите координату Y: ");
            return userScanner.nextInt();
        }

        public Coordinates askCoordinates () {
            Coordinates coordinates = new Coordinates(askX(), askY());
            return coordinates;
        }

        public LocalDate askLocalDate () {
            localDate = LocalDate.now();
            return localDate;
        }

        public Long askHealth () {
            System.out.println("Введите здоровье: ");
            Long health;
            health = userScanner.nextLong();
            return health;
        }

        public String askName () {
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

        public MeleeWeapon askMeleeWeapon () {
            MeleeWeapon meleeWeapon = MeleeWeapon.MANREAPER;
            String weapon;
            System.out.println("Введите оружие ближнего боя: ");
            weapon = userScanner.nextLine();
            if (weapon.equals(MeleeWeapon.MANREAPER)) {
                meleeWeapon = MeleeWeapon.MANREAPER;
            }
            if (weapon.equals(MeleeWeapon.POWER_BLADE)) {
                meleeWeapon = MeleeWeapon.POWER_BLADE;
            }
            if (weapon.equals(MeleeWeapon.POWER_FIST)) {
                meleeWeapon = MeleeWeapon.POWER_FIST;
            }
            return meleeWeapon;
        }
    }
//TODO: наложить условия на аскеры, обработать try/catch