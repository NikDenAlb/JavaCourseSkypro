package _2_JavaCore._2_2_OOP;

public class Gryffindor extends Hogwarts {
    private int nobility;
    private int honor;
    private int courage;

    public Gryffindor(String fullName, int spellPower, int apparitionDistance, int nobility, int honor, int courage) {
        super(fullName, spellPower, apparitionDistance);
        this.nobility = nobility;
        this.honor = honor;
        this.courage = courage;
    }

    public Gryffindor(String fullName) {
        super(fullName);
        java.util.Random random = new java.util.Random();
        nobility = random.nextInt(100);
        honor = random.nextInt(100);
        courage = random.nextInt(100);
    }

    @Override
    public void printStudent() {
        System.out.println(getFullName() + " [spellPower=" + getSpellPower() + ", apparitionDistance=" + getApparitionDistance() + ']' + "{nobility=" + nobility + ", honor=" + honor + ", courage=" + courage + "}");
    }

    public void challengeGryffindor(Gryffindor gryffindor) {
        if (nobility + honor + courage > gryffindor.nobility + gryffindor.honor + gryffindor.courage) {
            System.out.println(getFullName() + " лучший Гриффиндорец, чем " + gryffindor.getFullName());
        } else if (nobility + honor + courage < gryffindor.nobility + gryffindor.honor + gryffindor.courage) {
            System.out.println(gryffindor.getFullName() + " лучший Гриффиндорец, чем " + getFullName());
        } else System.out.println(getFullName() + " такой же хороший Гриффиндорец как и " + gryffindor.getFullName());
    }
}