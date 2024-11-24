package _1_IntroductionToTheProfessionAndLanguageSyntax._1_12_ObjectsAndClasses;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    //////////////////////////////////////////////////////////////////////////////////
    public void printAuthor() {
        System.out.println("Автор: " + this.getName() + " " + this.getSurname());
    }
}
