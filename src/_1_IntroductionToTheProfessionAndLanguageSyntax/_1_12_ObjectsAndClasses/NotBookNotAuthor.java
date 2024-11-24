package _1_IntroductionToTheProfessionAndLanguageSyntax._1_12_ObjectsAndClasses;

public class NotBookNotAuthor {
    public static void main(String[] args) {
        Book book1;
        Book book2;
        Author author1;
        Author author2;
        author1 = new Author("ИмяАвтора1", "ФамилияАвтора1");
        author2 = new Author("ИмяАвтора2", "ФамилияАвтора2");
        book1 = new Book("Название1", author1, 2022);
        book2 = new Book("Название2", author2, 2023);

        book1.printBook();
        System.out.println();
        book2.printBook();

        book1.setPublicYear(1989);
        System.out.println("\nДата публикации book1 изменена\n");
        book1.printBook();
    }
}
