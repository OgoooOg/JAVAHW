package ru.aston.homework2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader.readStudentsFromFile("studentList.txt").stream()

                    .peek(System.out::println)

                    .map(Student::getBooks)

                    .flatMap(List::stream)

                    .sorted()

                    .distinct()

                    .filter(book -> book.getYear() > 2000)

                    .limit(3)

                    .map(Book::getYear)

                    .findFirst()

                    .ifPresentOrElse(
                            year -> System.out.println("Найденный год выпуска: " + year),
                            () -> System.out.println("Такая книга отсутствует")
                    );

        } catch (IOException e) {
            System.err.println("Ошибка при работе с текстовым файлом: " + e.getMessage());
        }
    }
}
