public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("- - - - - -");
        for (int i = 0; i < 5; i++) {
            list.push(i);
        }
        System.out.println(list);

        System.out.println("- - - - - -");
        list.setValue(4444, 5);
        System.out.println("set value 444, index = 5 \n" + list);

        System.out.println("- - - - - -");
        list.addByIndex(888, 3);
        System.out.println("add value 888, index = 3 \n" + list);

        System.out.println("- - - - - -");
        list.removeFirst();
        System.out.println("removed first\n" + list);

        System.out.println("- - - - - -");
        list.removeLast();
        System.out.println("removed last\n" + list);

        System.out.println("- - - - - -");
        list.getByIndex(3);
        System.out.println("get value, index = 2 is " +list.getByIndex(2) + "\n" + list);

        System.out.println("- - - - - -");
        list.getByIndex(4);
        System.out.println("get value, index = 4 is " +list.getByIndex(4) + "\n" + list);

        System.out.println("- - - - - -");
        list.removeByIndex(3);
        System.out.println("remove 3 elem\n" +list );

        System.out.println("- - - - - -");
        LinkedList newList = new LinkedList();
        System.out.println(newList);

        System.out.println("- - - - - -");
        newList.add(-100);
        System.out.println(newList);

        System.out.println("- - - - - -");
        newList.removeLast();
        System.out.println("removing the last\n" + newList);

        // doesn't permit to delete an elem in the empty list
        /*System.out.println("- - - - - -");
        newList.removeLast();
        newList.removeFirst();*/

        System.out.println("- - - - - -");
        newList.add(100);
        System.out.println("add 100\n" + newList);

        System.out.println("- - - - - -");
        newList.push(-100);
        System.out.println("puss -100\n" + newList);

        System.out.println("- - - - - -");
        System.out.println("get first value " + newList.getFirst());

        System.out.println("- - - - - -");
        System.out.println("get last value " + newList.getLast());

        System.out.println("- - - - - -");
        newList.removeByIndex(1);
        System.out.println("remove 1 " + newList);

        System.out.println("- - - - - -");
        System.out.println("get first " + newList.getFirst());

        System.out.println("- - - - - -");
        System.out.println("get last " + newList.getLast());

    }


}
