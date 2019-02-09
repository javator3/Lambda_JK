package pl.sda.lambda;

import pl.sda.Lambda.AddInterface;
import pl.sda.Lambda.Movie;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        AddInterface add = (a, b) -> a + b;
        add.calc(4, 2);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);

        for (Integer integer: numbers){
            System.out.println(integer);
        }

        Consumer<Integer> integerConsumer = n -> System.out.println(n) ;
        numbers.forEach(integerConsumer);

        // lambda przez wykonanie:
        numbers.forEach(System.out::println);

        //można labde wypisac w jednej linijce przez referencje:
        numbers.forEach(s -> System.out.println(s));

        List<Movie> movies = Arrays.asList(
                new Movie("Tytul",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        60,
                        Arrays.asList("Jan", "Maciek")),
                new Movie("Tytul2",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        20,
                        Arrays.asList("Michal", "Maciek")),
                new Movie("Tytul2",
                        "Kamil",
                        LocalDate.of(2012, 02, 12),
                        20,
                        Arrays.asList("Jan", "Maciej"))
        );

        //standard way
        for (Movie movie: movies){
            System.out.println(movie.getTitle());
        }

        //stream:
        List<String> titles = movies
                .stream()
                .map(f -> f.getTitle())
                .collect(Collectors.toList());

        //drugi stream - lista directors

        //iteracja po liscie

        titles.forEach(System.out::println);

        System.out.println(titles);


        List<Movie> movieList = movies.stream()
                .filter(f -> f.getPrice() > 50)
                .filter(f -> f.getTitle().length() > 5)
                .collect(Collectors.toList());

        movieList.forEach(p -> System.out.println(p.getTitle() + p.getPrice()));
        movieList.forEach(System.out::println);

        //zwwróć listę tytułów filmó których get price >10 i <30


        List<String> myMvieList = movies
                .stream()
                .filter(s -> s.getPrice() > 10)
                .filter(s -> s.getPrice() <30)
                .map(p -> p.getTitle())
                .collect(Collectors.toList());

        myMvieList.forEach(System.out::println);

        //zróc liste filmow w których gra Jan

        List<Movie> moviesWithJan = movies
                .stream()
                .filter(f -> f.getActorList().contains("Jan"))
                .collect(Collectors.toList());

        System.out.println(moviesWithJan.size());

        //wyswietlanie tytułów filmó z janem z dużych liter

        List<String> moviesWiathJanUpperCase = movies
                .stream()
                .filter(f -> f.getActorList().contains("Jan"))
                .map(f -> f.getTitle())
                .map(f -> f.toUpperCase())
                .collect(Collectors.toList());

        moviesWiathJanUpperCase.forEach(System.out::println);

        //ponizszy sposób wysiwetla nawiasy kadratowe
        System.out.println(moviesWiathJanUpperCase);
    }
}
