package _2_JavaCore._2_2_OOP;

import java.util.Random;

public class Slytherin extends Hogwarts {
    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int leadership;

    public Slytherin(String fullname, int spellPower, int apparitionDistance, int cunning, int determination, int ambition, int resourcefulness, int leadership) {
        super(fullname, spellPower, apparitionDistance);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.leadership = leadership;
    }

    public Slytherin(String fullname) {
        super(fullname);
        Random random = new Random();
        cunning = random.nextInt(100);
        determination = random.nextInt(100);
        ambition = random.nextInt(100);
        resourcefulness = random.nextInt(100);
        leadership = random.nextInt(100);
    }

    @Override
    public void printStudent() {
        System.out.println(getFullName() + " [spellPower=" + getSpellPower() + ", apparitionDistance=" + getApparitionDistance() + ']' +
                "{cunning=" + cunning + ", determination=" + determination + ", ambition=" + ambition + ", resourcefulness=" + resourcefulness + ", leadership=" + leadership + "}");
    }

    public void challengeSlytherin(Slytherin slytherin) {
        if (cunning + determination + ambition + resourcefulness + leadership > slytherin.cunning + slytherin.determination + slytherin.ambition + slytherin.resourcefulness + slytherin.leadership) {
            System.out.println(getFullName() + " лучший Слизеринец, чем " + slytherin.getFullName());
        } else if (cunning + determination + ambition + resourcefulness + leadership < slytherin.cunning + slytherin.determination + slytherin.ambition + slytherin.resourcefulness + slytherin.leadership) {
            System.out.println(slytherin.getFullName() + " лучший Слизеринец, чем " + getFullName());
        } else System.out.println(getFullName() + " такой же хороший Слизеринец как и " + slytherin.getFullName());
    }
}
