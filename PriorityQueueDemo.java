import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> pQueue = new PriorityQueue<String>(new MyComparator());

        // Adding items to the pQueue using add()
        pQueue.add("C");


        pQueue.add("Python");
        pQueue.add("Java");
        pQueue.add("C++");

        // Printing the most priority element
        System.out.println("Head value using peek function:"
                + pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        Comparator comp = pQueue.comparator();
        System.out.println(comp);
    }
}
class MyComparator implements Comparator<String>
{



    @Override
    public int compare(String o1, String o2) {
        String first_Str;
        String second_Str;
        first_Str = o1;
        second_Str = o2;
        System.out.println("object 1 --" + o1);
        System.out.println("object 2 --" + o2);
        System.out.println(o1.compareTo(o2));
        return o1.compareTo(o2);
    }
}
