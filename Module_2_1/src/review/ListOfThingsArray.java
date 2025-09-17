package review;

public class ListOfThingsArray extends MyList {
    private int[] list = new int[4];
    private int listElements = 0;

    public void add(int x) {
        if (listElements < list.length) {
            list[listElements++] = x;
        } else {
            System.out.println("list is full: " + list.length);
        }
    }

    public void remove(int index) {
        if (index < 0 && index >= list.length-1) return;

        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length-1] = 0;listElements--;
    }

    public int size() { return list.length; }
    public int get(int x) { return list[x]; }
    public int numberOfElements() { return listElements; }
}
