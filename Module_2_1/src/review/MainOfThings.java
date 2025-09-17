package review;

public class MainOfThings {
    public static void main(String[] args) {
        MyList list = ListOfThings.getInstance();
        list.add(1);
        list.add(123);
        list.add(3);
        list.add(23);
        list.add(67); // list is full
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

        list.add(9999);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
    }
}
