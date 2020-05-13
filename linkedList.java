import java.util.LinkedList;

public class linkedList {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }
     public node mergeSort(node h)
     {
         if(h==null || h.next==null)
         {
             return h;
         }

         node middle = getMiddle(h);
         node nextOfmiddle = middle.next;
         middle.next=null;
         node left = mergeSort(h);
         node right =mergeSort(nextOfmiddle);

         node sortedList = merge (left,right);
         return sortedList;

     }
     public  node merge( node a , node b)
     {
         node result = null;
         if(a == null)
             return b;
         if(b==null)
             return a;

         if(a.val<b.val)
         {
             result = a;
             result.next = merge(a.next,b);
         }else{
             result=b;
             result.next = merge(a,b.next);
         }
         return result;
     }

    public static node getMiddle(node head)
    {
        if (head == null)
            return head;

        node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int new_data)
    {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Utility function to print the linked list
    void printList(node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }


    public static void test(){
        try {
            Float f1 = new Float("3.0");


            int a = f1.intValue();
            byte b = f1.byteValue();
            double d = f1.doubleValue();
            System.out.println(a + b + d);
        }catch (NumberFormatException ne)
        {
            System.out.println("bad");
        }
    }
    public static void main(String[] args)
    {
        test();

        /*linkedList li = new linkedList();
        *//*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         *//*
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);*/
    }

}
