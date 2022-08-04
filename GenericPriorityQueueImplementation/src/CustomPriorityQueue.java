import java.util.Comparator;

public class CustomPriorityQueue<T> {

    private Node<T> head;
    Comparator<T> comparator;

    public CustomPriorityQueue(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void add(T val){
        Node<T> newNode = new Node<>(val);

        Node previous = null;
        Node current = head;

        while (current != null && comparator.compare(val, (T) current.getVal()) > 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            newNode.setNext(head);
            head = newNode;
        }else {
            previous.setNext(newNode);
            newNode.setNext(current);
        }

        return;
    }

    public void printQueue(){
        Node<T> temp = head;
        while (temp != null){
            System.out.println(temp.getVal().toString());
            temp = temp.getNext();
        }
    }

}
