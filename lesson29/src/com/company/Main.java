package com.company;

import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Stream API

        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("Tom",12));
        cats.add(new Cat("Barsik",2));
        cats.add(new Cat("Lion",5));
        cats.add(new Cat("Fedor",6));
        cats.add(new Cat("Miay",7));
        cats.add(new Cat("Oleg",4));
        cats.add(new Cat("Simon",10));
        cats.add(new Cat("Vasiliy",3));


        // преобразование объектов класса Cat  в объекты класса Dog
        // превращаем котов в собак

        cats.stream()
                .map((Cat cat)-> new Dog(cat.getName(),cat.getAge(),"black")) // превращаем котов в собак
                .skip(2)                                              // пропускает(удаляет) первые два элемента
                .limit(3)                                             //в stream останется только первые три объекта
                .forEach(System.out::println);

        System.out.println("================");

        //пагинация
        DogRepozitory repo = new DogRepozitory();
        repo.getDogs(new Dog
                .PaginationBuilder(1,5)
                .setMinAge(2)
                .setMaxAge(4)
                .setSort((d1,d2) -> Integer.compare(d2.getAge(), d1.getAge()))
                .build())
                .stream()
                .forEach(System.out::println);

        }

    }

