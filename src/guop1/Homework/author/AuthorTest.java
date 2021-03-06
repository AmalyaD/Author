package guop1.Homework.author;

import java.util.Scanner;

public class AuthorTest {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = "0";
    private static final String ADD_AUTHOR = "1";
    private static final String SEARCH_AUTHOR = "2";
    private static final String SEARCH_AUTHOR_BY_AGE = "3";
    private static final String PRINT_AUTHORS = "4";
    private static final String ADD_BOOK = "5";
    private static final String PRINT_BOOK = "6";
    private static final String SEARCH_BOOKS_BY_TITLE = "7";
    private static final String SEARCH_BOOKS_BY_AUTHOR = "8";
    private static final String COUNT_BOOKS_BY_AUTHOR = "9";
    private static final String CHANGE_AUTHOR = "10";
    private static final String CHANGE_BOOK_AUTHOR  = "11";




    public static void main(String[] args) {


//        System.out.println("Please enter the name: ");
//        String name = scanner.next();
//
//        System.out.println("Please enter the surname: ");
//        String surname = scanner.next();
//
//        System.out.println("Please enter the email: ");
//        String email = scanner.next();
//
//        System.out.println("Please enter the gender: ");
//        String gender = scanner.next();
//
//        System.out.println("Please enter the age: ");
//        int age = scanner.nextInt();
//
//        System.out.println("Please enter the book title");
//        String book = scanner.next();
//
//        System.out.println("Please enter the book distraction");
//        String distraction = scanner.next();
//
//        System.out.println("Please input book's price");
//        double price = Double.parseDouble(scanner.next());
//
//        System.out.println("Please input book's count");
//        int count = (scanner.nextInt());


//        for (int i = 0; i < count; i++) {
//            Author author = new Author(name,surname,email,age, gender);
//            authorStorage.add(author);
//        }

        authorStorage.add(new Author("poxos", "poxosyan", "poxos@mail.com", 22, "male"));
        authorStorage.add(new Author("petros", "petrosyan", "petros@mail.com", 33, "male"));
        authorStorage.add(new Author("martiros", "martirosyan", "martiros@mail.com", 44, "male"));
//        bookStorage.addBook(new Book("Verq Hayastani","Nkaragrutyun", 1000.52, 2));

        authorStorage.print();

        //  System.out.println("Author by index  is : " + authorStorage.getIndex(4));
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                case SEARCH_AUTHOR:
                    searchAuthor();
                    break;
                case SEARCH_AUTHOR_BY_AGE:
                    searchAuthorByAge();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.print();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOK:
                    bookStorage.print();
                    break;
                case SEARCH_BOOKS_BY_TITLE:
                    searchBookByTitle();
                    break;
                case SEARCH_BOOKS_BY_AUTHOR:
                    searchBooksByAuthor();
                    break;
                case COUNT_BOOKS_BY_AUTHOR:
                    COUNT_BOOKS_BY_AUTHOR();
                    break;
                case CHANGE_AUTHOR:
                    CHANGE_AUTHOR();
                    break;
                case CHANGE_BOOK_AUTHOR:
                    changeBookAuthor();
                default:
                    System.out.println("invalid command!");
            }
        }
    }

    private static void changeBookAuthor() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.changeBookAuthor(keyword,keyword);
    }

    private static void CHANGE_AUTHOR() {
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        System.out.println("Gender:");
        String gender = scanner.nextLine();
        System.out.println("Age:");
        int age = scanner.nextInt();

        authorStorage.changeAuthor(email, name, surname, age, gender);
    }

    private static void COUNT_BOOKS_BY_AUTHOR() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.countBooksByAuthor(keyword);
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_AUTHOR + " for ADD_AUTHOR");
        System.out.println("Please input " + SEARCH_AUTHOR + " for SEARCH_AUTHOR");
        System.out.println("Please input " + SEARCH_AUTHOR_BY_AGE + " for SEARCH_AUTHOR_BY_AGE");
        System.out.println("Please input " + PRINT_AUTHORS + " for PRINT_AUTHORS");
        System.out.println("Please input " + ADD_BOOK + " for ADD_BOOK");
        System.out.println("Please input " + PRINT_BOOK + " PRINT_BOOK");
        System.out.println("Please input " + SEARCH_BOOKS_BY_TITLE + " SEARCH_BOOKS_BY_TITLE");
        System.out.println("Please input " + SEARCH_BOOKS_BY_AUTHOR + " SEARCH_BOOKS_BY_AUTHOR");
    }

    private static void searchAuthorByAge() {
        System.out.println("Please input min age");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input max age");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchAuthorByAge(minAge, maxAge);
    }

    private static void searchAuthor() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchAuthor(keyword);
    }

    private static void addAuthor() {
        System.out.println("please input author's name");
        String name = scanner.nextLine();

        System.out.println("please input author's surname");
        String surname = scanner.nextLine();

        System.out.println("please input author's email");
        String email = scanner.nextLine();

        System.out.println("please input author's gender");
        String gender = scanner.nextLine();

        System.out.println("please input author's age");
        int age = Integer.parseInt(scanner.nextLine());

        Author author = new Author(name, surname, email, age, gender);

        if (authorStorage.getByEmail(author.getEmail()) != null) {
            System.err.println("Invalid email. Author with this email already exists");
        } else {
            authorStorage.add(author);
            System.out.println("Thank you, author was added");
        }

//        Author author = new Author();
//        author.setName(name);
//        author.setSurname(surname);
//        author.setAge(age);
//        author.setEmail(email);
//        author.setGender(gender);

        authorStorage.add(author);
        System.out.println("Thank you! Author was added");


    }

    private static void searchBookByTitle() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBook(keyword);
    }

    private static  void searchBooksByAuthor() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByAuthor(keyword);
    }

    private static void addBook() {

        System.out.println("please choose author's email");
        System.out.println("--------");
        authorStorage.print();
        System.out.println("--------");
        String email = scanner.nextLine();

        Author author = authorStorage.getByEmail(email);

        if (author != null) {

            System.out.println("Please input book's titel");
            String title = scanner.nextLine();

            System.out.println("Please input book's description");
            String description = scanner.nextLine();

            System.out.println("Please input book's price");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Please input book's count");
            int count = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input author's data");
            System.out.println("Please input author's name");
            String name = scanner.nextLine();
            System.out.println("Please input author's surname");
            String surname = scanner.nextLine();
            System.out.println("Please input author's email");
            String authorEmail = scanner.nextLine();
            System.out.println("Please input author's age");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input author's gender");
            String gender = scanner.nextLine();
            Book book =
                    new Book(title, description, price, count, new Author(name, surname, authorEmail, age, gender));
            bookStorage.addBook(book);
            System.out.println("Thank you, Book was added");

        } else {
            System.out.println("invalid email! please try again");
            addBook();
        }
    }
}
