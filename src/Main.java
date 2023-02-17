import com.nomaan.dsa.linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(32);
        list.add(354);
        list.add(1);
        list.add(5);

        System.out.println(list);

        list.add(2,2);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(6,5);
        System.out.println(list);

        list.add(0,1);
        System.out.println(list);
    }
}
