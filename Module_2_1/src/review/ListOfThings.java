package review;

import java.util.ArrayList;
import java.util.List;

public class ListOfThings extends MyList {
    private final int MAX_ELEMENTS = 4;
    private List<Integer> list = new ArrayList<>();
    private static ListOfThings instance = null;

    private ListOfThings()
    {
    }

    public static ListOfThings getInstance() // singleton
    {
        if (instance == null) {
            instance = new ListOfThings();
        }
        return instance;
    }

    public void add(int x) {
        if (list.size() < MAX_ELEMENTS)
            list.add(x);
        else
            System.out.println("List is full: " + MAX_ELEMENTS);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int size() { return MAX_ELEMENTS; }
    public int get(int x) { return list.get(x); }
    public int numberOfElements() { return list.size(); }
}
