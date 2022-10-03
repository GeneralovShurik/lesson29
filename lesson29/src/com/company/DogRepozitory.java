package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DogRepozitory {

    //создаем список собак
    private LinkedList<Dog> dogs = new LinkedList<>();

    public DogRepozitory (){
        this.dogs.add(new Dog("Dog #1",2,"black"));
        this.dogs.add(new Dog("Dog #2",3,"red"));
        this.dogs.add(new Dog("Dog #3",4,"green"));
        this.dogs.add(new Dog("Dog #4",2,"yellow"));
        this.dogs.add(new Dog("Dog #5",6,"grin"));
        this.dogs.add(new Dog("Dog #6",8,"blue"));
        this.dogs.add(new Dog("Dog #7",12,"white"));
        this.dogs.add(new Dog("Dog #8",2,"black"));
        this.dogs.add(new Dog("Dog #9",13,"black"));
        this.dogs.add(new Dog("Dog #10",7,"black"));
        this.dogs.add(new Dog("Dog #11",9,"grin"));
        this.dogs.add(new Dog("Dog #12",10,"black"));
        this.dogs.add(new Dog("Dog #13",14,"white"));
        this.dogs.add(new Dog("Dog #14",16,"black"));
        this.dogs.add(new Dog("Dog #15",20,"blue"));
        this.dogs.add(new Dog("Dog #16",19,"grin"));
        this.dogs.add(new Dog("Dog #17",18,"yellow"));
        this.dogs.add(new Dog("Dog #18",17,"red"));
        this.dogs.add(new Dog("Dog #19",4,"white"));
        this.dogs.add(new Dog("Dog #20",11,"black"));

    }

    public List<Dog> getDogs(Dog.Pagination p){
        Stream<Dog> stream = this.dogs.stream();

        //сортировка(если указана)

        if(p.getSortBy() != null){
            stream = stream.sorted(p.getSortBy());
        }
        //фильтр по возрасту, если задан
        if(p.getFromAge() != null) {
            stream = stream.filter((Dog dog) -> dog.getAge()>= p.getFromAge()
            );
        }
        if(p.getToAge() != null) {
            stream = stream.filter((Dog dog) -> dog.getAge() <= p.getToAge()
            );
        }

        return stream
                .skip((p.getPage()-1) * p.getPerPage())
                .limit(p.getPerPage()).collect(Collectors.toList());
    }

}
