package managers;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import data.SpaceMarine;
import exceptions.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Ask from start file a marine's values.
 */
public class AscerForStartFIle implements Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    private ArrayList<String> ar;

    public AscerForStartFIle(ArrayList<String> ar) {
        this.ar = ar;
    }

    private static Long index = -1L;

    /**
     * function for create marine
     *
     * @return new marine
     */
    public SpaceMarine startFunc() {
        index += 1L;
        SpaceMarine marine= new SpaceMarine(index, askName(), askCoordinates(), askDate(), askHealth(), askHeartCounts(), askAchievements(), askMeleeWeapon(), askChapter());
        if(marine.isEmpty()){return null;}
        return marine;
        }

    /**
     * ask marine's melee weapon
     *
     * @return melee weapon
     */
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

    /**
     * ask achievements
     *
     * @return achievements
     */
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

    /**
     * ask heart count
     *
     * @return heart count
     */
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

    /**
     * ask health of marine
     *
     * @return marine's health
     */
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
            return 0L;
        }
        return health;
    }

    /**
     * output local date
     *
     * @return local date
     */
    public LocalDate askDate() {
        return LocalDate.now();
    }

    /**
     * ask X,Y coordinates
     *
     * @return x, y coordinates
     */
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

    /**
     * ask name of marine
     *
     * @return marine's name
     */
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

    /**
     * asks about chapter
     *
     * @return new chapter
     */
    public Chapter askChapter() {
        return new Chapter(askChapterName(), askChapterLegion(), askChapterMarinesCount(), askChapterWorld());
    }

    /**
     * ask how much marines
     *
     * @return count of marines
     */
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

    /**
     * ask chapter world
     *
     * @return chapter world
     */
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

    /**
     * ask chapter parent Legion
     *
     * @return parent Legion
     */
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

    /**
     * ask chapter name
     *
     * @return chapter name
     */
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
