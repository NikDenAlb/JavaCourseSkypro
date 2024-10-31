package _2_JavaCore._2_2_OOP;

import java.util.Random;

public class Ravenclaw extends Hogwarts {
    private int intelligence;
    private int knowledge;
    private int creativity;
    private int wit;

    public Ravenclaw(String fullname, int spellPower, int apparitionDistance, int intelligence, int knowledge, int creativity, int wit) {
        super(fullname, spellPower, apparitionDistance);
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.creativity = creativity;
        this.wit = wit;
    }

    public Ravenclaw(String fullname) {
        super(fullname);
        Random random = new Random();
        intelligence = random.nextInt(100);
        knowledge = random.nextInt(100);
        creativity = random.nextInt(100);
        wit = random.nextInt(100);
    }

    @Override
    public void printStudent() {
        System.out.println(getFullName() + " [spellPower=" + getSpellPower() + ", apparitionDistance=" + getApparitionDistance() + ']'
                + "{intelligence=" + intelligence + ", knowledge=" + knowledge + ", creativity=" + creativity + ", wit=" + wit + "}");
    }

    public void challengeRavenclawr(Ravenclaw ravenclaw) {
        if (intelligence + knowledge + creativity + wit > ravenclaw.intelligence + ravenclaw.knowledge + ravenclaw.creativity + ravenclaw.wit) {
            System.out.println(getFullName() + " лучший Когтевранец, чем " + ravenclaw.getFullName());
        } else if (intelligence + knowledge + creativity + wit < ravenclaw.intelligence + ravenclaw.knowledge + ravenclaw.creativity + ravenclaw.wit) {
            System.out.println(ravenclaw.getFullName() + " лучший Когтевранец, чем " + getFullName());
        } else System.out.println(getFullName() + " такой же хороший Когтевранец как и " + ravenclaw.getFullName());
    }
}
