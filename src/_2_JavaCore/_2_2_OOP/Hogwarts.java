package _2_JavaCore._2_2_OOP;

public class Hogwarts {
    private String fullName;
    private int spellPower;
    private int apparitionDistance;

    public String getFullName() {
        return fullName;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public int getApparitionDistance() {
        return apparitionDistance;
    }

    public Hogwarts(String fullName, int spellPower, int apparitionDistance) {
        this.fullName = fullName;
        this.spellPower = spellPower;
        this.apparitionDistance = apparitionDistance;
    }

    public Hogwarts(String fullName) {
        this.fullName = fullName;
        java.util.Random random = new java.util.Random();
        spellPower = random.nextInt(100);
        apparitionDistance = random.nextInt(100);
    }

    public void printStudent() {
        System.out.println(fullName + " [spellPower=" + spellPower + ", apparitionDistance=" + apparitionDistance + ']');
    }

    public void challenge(Hogwarts hogwarts) {
        if (spellPower > hogwarts.spellPower) {
            System.out.println(fullName + " обладает большей мощностью магии, чем " + hogwarts.fullName);
        } else if (spellPower < hogwarts.spellPower) {
            System.out.println(hogwarts.fullName + " обладает большей мощностью магии, чем " + fullName);
        } else System.out.println(fullName + " и " + hogwarts.fullName + " равны по мощности магии");

        if (apparitionDistance > hogwarts.apparitionDistance) {
            System.out.println(fullName + " обладает большей дальностью трансгрессии, чем " + hogwarts.fullName);
        } else if (apparitionDistance < hogwarts.apparitionDistance) {
            System.out.println(hogwarts.fullName + " обладает большей дальностью трансгрессии, чем " + fullName);
        } else System.out.println(fullName + " и " + hogwarts.fullName + " равны по дальности трансгрессии");
    }
}
