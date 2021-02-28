package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import data.SpaceMarine;
import exceptions.MustBeNotEmptyException;

import java.time.LocalDate;
import java.util.ArrayList;

public class AscerForStartFIle {
    private ArrayList<String> ar = new ArrayList<String>();

    public AscerForStartFIle(ArrayList<String> ar) {
        this.ar = ar;
    }

    private static Long index = 0L;

    public SpaceMarine startFunc() {
        index += 1L;
        return new SpaceMarine(index, askName(), askCoordinates(), askDate(), askHealth(), askHeartCounts(), askAchievements(), askMeleeWeapon(), askChapter());
    }

    public MeleeWeapon askMeleeWeapon() {
        MeleeWeapon meleeWeapon = MeleeWeapon.MANREAPER;
        String weapon = "";
        try {
            weapon = ar.get(0);
            ar.remove(0);
            meleeWeapon = MeleeWeapon.valueOf(weapon);
            if (weapon.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return meleeWeapon;
    }

    public String askAchievements() {
        String achievements = "";
        try {
            achievements = ar.get(0);
            if (achievements.equals("")) throw new MustBeNotEmptyException();
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return achievements;
    }

    public Integer askHeartCounts() {
        Integer counts = 0;
        try {
            counts = Integer.parseInt(ar.get(0));
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return counts;
    }

    public Long askHealth() {
        Long health = 0L;
        try {
            health = Long.parseLong(ar.get(0));
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return health;
    }

    public LocalDate askDate() {
        return LocalDate.now();
    }

    public Coordinates askCoordinates() {
        Double x = 0D;
        Integer y = 0;
        try {
            x = Double.parseDouble(ar.get(0));
            ar.remove(0);
            y = Integer.parseInt(ar.get(0));
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return new Coordinates(x, y);
    }

    public String askName() {
        String name = "";
        try {
            name = ar.get(0);
            if (name.equals("")) throw new MustBeNotEmptyException();
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return name;
    }

    public Chapter askChapter() {
        Chapter chapter = new Chapter(askChapterName(), askChapterLegion(), askChapterMarinesCount(), askChapterWorld());
        return chapter;
    }

    public Long askChapterMarinesCount() {
        Long marinesCount = 0L;
        try {
            marinesCount = Long.parseLong(ar.get(0));
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return marinesCount;
    }

    public String askChapterWorld() {
        String world = "";
        try {
            world = ar.get(0);
            ar.remove(0);
            if (world.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return world;
    }

    public String askChapterLegion() {
        String parentLegion = "";
        try {
            parentLegion = ar.get(0);
            ar.remove(0);
            if (parentLegion.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return parentLegion;
    }

    public String askChapterName() {
        String name = "";
        try {
            name = ar.get(0);
            ar.remove(0);
            if (name.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("Ошибочка вышла");
        }
        return name;
    }
}
