package ru.aston.homework2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<Student> readStudentsFromFile(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(";");
                String studentName = parts[0].trim();

                List<Book> books = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    String[] bookParts = parts[i].split(",");
                    String title = bookParts[0].trim();
                    int year = Integer.parseInt(bookParts[1].trim());
                    int pages = Integer.parseInt(bookParts[2].trim());

                    books.add(new Book(title, year, pages));
                }

                students.add(new Student(studentName, books));
            }
        }

        return students;
    }
}
