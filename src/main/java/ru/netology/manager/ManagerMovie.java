package ru.netology.manager;


import lombok.Data;


import ru.netology.domain.DataMovie;

@Data


public class ManagerMovie {
    private DataMovie[] items = new DataMovie[0];
    private int moviesQuantity = 10;

    public ManagerMovie() {
    }

    public ManagerMovie(int moviesQuantity) {
        this.moviesQuantity = moviesQuantity;
    }

    //Метод для добавления фильмов
    public DataMovie[] addMovie(DataMovie film) {
        int lenght = items.length + 1;
        DataMovie[] tmp = new DataMovie[lenght];
        // for (int i = 0; i < items.length; i++) {
        // tmp[i]=items[i];
        //}
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        items = tmp;


        return items;
    }


    //Метод получения всего списка элементов
    public DataMovie[] getAllMovies() {
        DataMovie[] tmp = new DataMovie[items.length];
        // перебираем массив в прямом порядке, кладем в обратном
        for (int i = 0; i < tmp.length; i++) {
            int index = items.length - i - 1;
            tmp[i] = items[index];
        }
        return tmp;
    }


    //Метод, которотый выводит нужное количество фильмов
    public DataMovie[] getTheRightAmountMovies() {
        int count = this.moviesQuantity;
        if (count > items.length)
            count = items.length;
        DataMovie[] answer = new DataMovie[count];
        for (int i = 0; i < answer.length; i++) {
            int index = items.length - i - 1;
            answer[i] = items[index];
        }
        return answer;
    }


}
