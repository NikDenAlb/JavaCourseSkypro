package _2_JavaCore._2_2_OOP;

public class Hufflepuff extends Hogwarts {
    private int hardWork;
    private int loyalty;
    private int fairPlay;

    public Hufflepuff(String fullname, int spellPower, int apparitionDistance, int hardWork, int loyalty, int fairPlay) {
        super(fullname, spellPower, apparitionDistance);
        this.hardWork = hardWork;
        this.loyalty = loyalty;
        this.fairPlay = fairPlay;
    }

    public Hufflepuff(String fullname) {
        super(fullname);
        java.util.Random random = new java.util.Random();
        hardWork = random.nextInt(100);
        loyalty = random.nextInt(100);
        fairPlay = random.nextInt(100);
    }

    @Override
    public void printStudent() {
        System.out.println(getFullName() + " [spellPower=" + getSpellPower() + ", apparitionDistance=" + getApparitionDistance() + ']' + "{hardWork=" + hardWork + ", loyalty=" + loyalty + ", fairPlay=" + fairPlay + "}");
    }

    public void challengeHufflepuff(Hufflepuff hufflepuff) {
        if (hardWork + loyalty + fairPlay > hufflepuff.hardWork + hufflepuff.loyalty + hufflepuff.fairPlay) {
            System.out.println(getFullName() + " лучший Пуффендуец, чем " + hufflepuff.getFullName());
        } else if (hardWork + loyalty + fairPlay < hufflepuff.hardWork + hufflepuff.loyalty + hufflepuff.fairPlay) {
            System.out.println(hufflepuff.getFullName() + " лучший Пуффендуец, чем " + getFullName());
        } else System.out.println(getFullName() + " такой же хороший Пуффендуец как и " + hufflepuff.getFullName());
    }
}
