public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {

        head = null;
        tail = null;
    }

    public int size() {
        //probably it should be private (should we invoke it?) then, return void!
        size = 0;
        if (head == null) {
            return 0;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                size++;
            }

            size++;
            return size;
        }

    }

    public void add(int value) {

        if (head == null) {
            head = new Node(value);
            head.setPrev(null);
            tail = head;
            //should it be here?
        } else {
            Node temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(new Node(value));
            temp.getNext().setPrev(temp);

            tail = temp.getNext();


        }
        size();
    }

    public void push(int value) {

        if (head == null) {
            head = new Node(value);
            head.setPrev(null);
        } else {

            Node temp = head;
            while (temp.getPrev() != null) {
                temp = temp.getPrev();
            }
            temp.setPrev(new Node(value));
            temp.getPrev().setNext(temp);
            head = temp.getPrev();
        }
        size();
    }

    public void addByIndex(int value, int index) {

        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException("length is " + size + "unreachable element is " + index);
        }

        if (index == 0) {
            push(value);
        } else if (index == this.size) {
            add(value);
        } else {

            Node newNode = new Node(value);
            Node temp = getNodeByIndex(index - 1);
            temp.getNext().setPrev(newNode);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            newNode.setPrev(temp);
        }
        size();

    }

    public void setValue(int value, int index) {
        getNodeByIndex(index).setValue(value);
    }

    public void removeFirst() {

        if (head == null) {
            throw new UnsupportedOperationException("can't delete in empty list");
        }
        else if(head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head.getNext().setPrev(head.getPrev());
            head = head.getNext();
        }

        size();
    }

    public void removeLast() {

        if (tail == null || tail.equals(head)) {
            removeFirst();
        }else {
            tail.getPrev().setNext(tail.getNext());
            tail = tail.getPrev();
        }

        size();
    }

    public void removeByIndex(int index) {

        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("index is " + index + " the length is " + size);
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node temp = getNodeByIndex(index);
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
        }
        size();
    }

    public int getFirst() {
        return head.getValue();
    }

    public int getLast() {
        return tail.getValue();
    }

    public int getByIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("index is " + index + " the length is " + size);
        } else if (index == 0) {
            return getFirst();
        } else if (index == size -1) {
            return getLast();
        } else {
            return getNodeByIndex(index).getValue();
        }
    }

    private Node getNodeByIndex(int index) {

        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("length is " + size + "your index is " + index);
        }
        if (index >= size / 2) {
            //start from the end
            return getNodeByIndexTail(index);
        } else {
            // start for the beginning
            return getNodeByIndexHead(index);
        }

    }

    private Node getNodeByIndexHead(int index) {
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.getNext();
            i++;
        }
        return temp;
    }

    private Node getNodeByIndexTail(int index) {
        Node temp = tail;
        int i = size - 1;
        while (i > index) {
            temp = temp.getPrev();
            i--;
        }
        return temp;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[" + head.getValue());
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            str.append(", ").append(temp.getValue());
        }
        str.append("]").append("\n" + "size is ").append(size);
        return str.toString();
    }
}
