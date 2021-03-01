package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import data.SpaceMarine;
import exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AscerForStartFIle {
    private ArrayList<String> ar;

    public AscerForStartFIle(ArrayList<String> ar) {
        this.ar = ar;
    }

    private static Long index = -1L;

    public SpaceMarine startFunc() {
        index += 1L;
        return new SpaceMarine(index, askName(), askCoordinates(), askDate(), askHealth(), askHeartCounts(), askAchievements(), askMeleeWeapon(), askChapter());
    }

    public MeleeWeapon askMeleeWeapon() {
        MeleeWeapon meleeWeapon;
        String weapon;
        try {
            weapon = ar.get(0);
            meleeWeapon = MeleeWeapon.valueOf(weapon.toUpperCase());
            ar.remove(0);
            if (weapon.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено оружие ближнего боя. данный объект не будет создан");
            return null;
        }
        return meleeWeapon;
    }

    public String askAchievements() {
        String achievements;
        try {
            achievements = ar.get(0);
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определены достижения. данный объект не будет создан");
            return null;
        }
        return achievements;
    }

    public Integer askHeartCounts() {
        Integer counts = 0;
        try {
            counts = Integer.parseInt(ar.get(0));
            ar.remove(0);
            if (counts <= 0 || counts > 3) {
                throw new NumberOfHeartCountsException();
            }
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено количество сердечых сокращений. данный объект не будет создан");
            return null;
        }
        return counts;
    }

    public Long askHealth() {
        Long health;
        try {
            health = Long.parseLong(ar.get(0));
            ar.remove(0);
            if (health <= 0) {
                throw new LowHealthException();
            }
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено здоровье. данный объект не будет создан");
            return null;
        }
        return health;
    }

    public LocalDate askDate() {
        return LocalDate.now();
    }

    public Coordinates askCoordinates() {
        Double x;
        Integer y;
        try {
            x = Double.parseDouble(ar.get(0));
            ar.remove(0);
            if (x <= -56) {
                throw new WrongArgumentException();
            }
            y = Integer.parseInt(ar.get(0));
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определены координаты. данный объект не будет создан");
            return null;
        }
        return new Coordinates(x, y);
    }

    public String askName() {
        String name = "";
        try {
            name = ar.get(0);
            ar.remove(0);
            if (name.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено имя объекта. данный объект не будет создан");

        }
        return name;
    }

    public Chapter askChapter() {
        return new Chapter(askChapterName(), askChapterLegion(), askChapterMarinesCount(), askChapterWorld());
    }

    public Long askChapterMarinesCount() {
        Long marinesCount;
        try {
            marinesCount = Long.parseLong(ar.get(0));
            ar.remove(0);
            if (marinesCount > 1000 || marinesCount <= 0) {
                throw new NumberOfMarinesException();
            }
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено количество солдат. данный объект не будет создан");
            return null;
        }
        return marinesCount;
    }

    public String askChapterWorld() {
        String world;
        try {
            world = ar.get(0);
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определен мир главы. данный объект не будет создан");
            return null;
        }
        return world;
    }

    public String askChapterLegion() {
        String parentLegion = "";
        try {
            parentLegion = ar.get(0);
            ar.remove(0);
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определен родительский легион. данный объект не будет создан");
            return null;
        }
        return parentLegion;
    }

    public String askChapterName() {
        String name;
        try {
            name = ar.get(0);
            ar.remove(0);
            if (name.equals("")) throw new MustBeNotEmptyException();
        } catch (Exception e) {
            System.out.println("В загрузочном файле неверно определено имя главы. данный объект не будет создан");
            return null;
        }
        return name;
    }
}
