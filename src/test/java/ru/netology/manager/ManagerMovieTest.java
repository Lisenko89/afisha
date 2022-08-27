package ru.netology.manager;

import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.DataMovie;

import static org.junit.jupiter.api.Assertions.*;
@Data

class ManagerMovieTest {
    ManagerMovie manager = new ManagerMovie();
    private final DataMovie first = new DataMovie(1, "Soul", "cartoon", false);
    private final DataMovie second = new DataMovie(2, "Call me", "action", false);
    private final DataMovie third = new DataMovie(3, "Gentlemen", "action", false);
    private final DataMovie fourth = new DataMovie(4, "Invisible", "Thriller", false);
    private final DataMovie fifth = new DataMovie(5, "Troll's tour", "cartoon", true);
    private final DataMovie sixth = new DataMovie(6, "I BelieveInLove", "romance", true);
    private final DataMovie seventh = new DataMovie(7, "Pinocchio", "children", true);
    private final DataMovie eighth = new DataMovie(8, "House of Cards", "serials", true);
    private final DataMovie ninth = new DataMovie(9, "The man is unknown", "horror", true);
    private final DataMovie tenth = new DataMovie(10, "Method", "action", true);

    private final DataMovie eleventh = new DataMovie(11, "Trigger", "serials", true);

    @BeforeEach
    void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);


    }

    @Test
    void shouldAddMovie() {
        DataMovie[] actual = manager.addMovie(eleventh);
        DataMovie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldUseManagerMovie() {
        ManagerMovie manager = new ManagerMovie();
        assertEquals(10, manager.getMoviesQuantity());

    }

    @Test
    void shouldUseManagerMovieTwenty() {
        ManagerMovie manager = new ManagerMovie(20);
        assertEquals(20, manager.getMoviesQuantity());

    }


    @Test
    void shouldGetAllMovies() {
        DataMovie[] actual = manager.getAllMovies();
        DataMovie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMovies() {
        DataMovie[] actual = manager.getTheRightAmountMovies();
        DataMovie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOneMovies() {
        manager.setMoviesQuantity(1);
        DataMovie[] actual = manager.getTheRightAmountMovies();
        DataMovie[] expected = {new DataMovie(10, "Method", "action", true)};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetSevenMovies() {
        manager.setMoviesQuantity(8);
        DataMovie[] actual = manager.getTheRightAmountMovies();
        DataMovie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGoreThanAllMovies() {
        manager.setMoviesQuantity(100);
        DataMovie[] actual = manager.getTheRightAmountMovies();
        DataMovie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

}