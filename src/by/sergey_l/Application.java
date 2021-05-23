package by.sergey_l;

import by.sergey_l.service.BookService;
import by.sergey_l.service.impl.BookServiceImpl;

import java.util.Comparator;
import java.util.Scanner;

public class Application {
    private int menu() {
        int selection = 0;
        System.out.println("1. Показать все книги.");
        System.out.println("2. Добавить книгу.");
        System.out.println("3. Удалить книгу.");
        System.out.println("4. Изменить книгу.");
        System.out.println("5. Выход");
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) { //этим циклом заставлеям ввести число от 1 до 5
            while (sc.hasNextInt() == false) {
                System.out.print("Ваш ввод не корректен, повторите >> ");
                sc.next();
            }
            selection = sc.nextInt();
            if ((selection > 0) && (selection <= 5)) {
                done = true;
            } else {
                System.out.print("Ваш ввод не корректен, повторите >> ");
            }
        }
        return selection;
    }
    private void watchAllBook() {
        System.out.println("Выберите вид сортировки: ");
        System.out.println("1. По названию (возрастание)");
        System.out.println("2. По название (убывание)");
        Scanner sc = new Scanner(System.in);
        int selection = 0;
        while (sc.hasNextInt() == false) {
            System.out.print("Ваш ввод не корректен, повторите >> ");
            sc.next();
        }
        selection = sc.nextInt();
        BookService bookService = new BookServiceImpl();
        switch (selection) {
            case 1: {
                bookService.getAllBooks().stream().sorted().forEach(System.out :: println);
                break;
            }
            case 2: {
                bookService.getAllBooks().stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
                break;
            }
            default: {
                System.out.println("Ваш ввод некорректен, сортировка не выбрана.");
                bookService.getAllBooks().forEach(System.out :: println);
            }
        }
    }

    public void start() {
        boolean exit = false;
        int selection;
        while (!exit) {
            System.out.println("Выберите действие: ");
            selection = menu();
            switch (selection) {
                case 1: {
                    watchAllBook();
                    break;
                }
                case 2: {
                    System.out.println("функциональность в процессе разработки");
                    break;
                }
                case 3: {
                    System.out.println("функциональность в процессе разработки");
                    break;
                }
                case 4: {
                    System.out.println("функциональность в процессе разработки");
                    break;
                }
                case 5: {
                    exit = true;
                    break;
                }
            }
        }
    }
}
