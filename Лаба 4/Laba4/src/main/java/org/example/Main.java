package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Visitor> visitors;

        // чтение json из файла в корне проекта (с большой буквы Books.json)
        try (FileReader reader = new FileReader("Books.json")) {
            Gson gson = new Gson();
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            visitors = gson.fromJson(reader, visitorListType);
        } catch (IOException e) {
            System.err.println("ошибка чтения файла Books.json: " + e.getMessage());
            return;
        }

        System.out.println("=== задание 1 ===");
        // вывести список посетителей и их количество
        visitors.forEach(v -> System.out.println("- " + v.getName() + " " + v.getSurname()));
        System.out.println("количество посетителей: " + visitors.size());


        System.out.println("\n=== задание 2 ===");
        // вывести список и количество книг без повторений
        List<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        uniqueBooks.forEach(b -> System.out.println("- \"" + b.getName() + "\" (" + b.getAuthor() + ")"));
        System.out.println("количество уникальных книг: " + uniqueBooks.size());


        System.out.println("\n=== задание 3 ===");
        // отсортировать по году издания и вывести список книг
        uniqueBooks.stream()
                .sorted((b1, b2) -> Integer.compare(b1.getPublishingYear(), b2.getPublishingYear()))
                .forEach(b -> System.out.println(b.getPublishingYear() + " г. — \"" + b.getName() + "\""));


        System.out.println("\n=== задание 4 ===");
        // проверить, есть ли у кого-то в избранном книга автора “jane austen”
        boolean hasJaneAusten = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(b -> "Jane Austen".equalsIgnoreCase(b.getAuthor()));
        System.out.println("есть ли книга автора jane austen? " + (hasJaneAusten ? "да" : "нет"));


        System.out.println("\n=== задание 5 ===");
        // вывести максимальное число добавленных в избранное книг
        int maxBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max()
                .orElse(0);
        System.out.println("максимальное число книг в избранном: " + maxBooks);


        System.out.println("\n=== задание 6 ===");
        // 1. считаем среднее количество книг по всем посетителям
        double averageBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .average()
                .orElse(0.0);
        System.out.println("среднее количество книг: " + averageBooks);

        // 2. формируем sms для подписанных пользователей
        List<SmsMessage> smsList = visitors.stream()
                .filter(v -> v.isSubscribed())
                .map(v -> {
                    int count = v.getFavoriteBooks().size();
                    String text;
                    if (count > averageBooks) {
                        text = "you are a bookworm";
                    } else if (count < averageBooks) {
                        text = "read more";
                    } else {
                        text = "fine";
                    }
                    return new SmsMessage(v.getPhone(), text);
                })
                .collect(Collectors.toList());

        // вывод sms на экран
        smsList.forEach(sms -> System.out.println("кому: " + sms.getPhone() + " | текст: " + sms.getMessage()));
    }
}
