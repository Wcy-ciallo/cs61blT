import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    private class Node {
        T item;
        Node prev;
        Node next;
        
        Node() {}

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private int size;
    private Node sentinel;
    public LinkedListDeque61B() {
        this.size = 0;
        this.sentinel = new Node();
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }
    @Override
    public void addFirst(T x) {
        // TODO Auto-generated method stub
        Node newItem = new Node(x, this.sentinel, this.sentinel.next);
        this.sentinel.next.prev = newItem;
        this.sentinel.next = newItem;
        this.size++;
    }

    @Override
    public void addLast(T x) {
        // TODO Auto-generated method stub
        Node newItem = new Node(x, this.sentinel.prev, this.sentinel);
        this.sentinel.prev.next = newItem;
        this.sentinel.prev = newItem;
        this.size++;
    }

    @Override
    public List<T> toList() {
        // TODO Auto-generated method stub
        List<T> returnList = new ArrayList<>();
        Node point = this.sentinel.next;
        while(point != this.sentinel){
            returnList.add(point.item);
            point = point.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.sentinel.next == this.sentinel;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        if(size == 0) {
            return null;
        }
        Node first = this.sentinel.next;
        Node newFirst = first.next;
        this.sentinel.next = newFirst;
        newFirst.prev = this.sentinel;
        this.size--;
        T val = first.item;
        first.item = null;
        first.next = first.prev = null;
        return val;
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        if(this.size == 0) {
            return null;
        }
        Node last = this.sentinel.prev;
        Node newLast = last.prev;
        this.sentinel.prev = newLast;
        newLast.next = this.sentinel;
        this.size--;
        T val = last.item;
        last.item = null;
        last.next = last.prev = null;
        return val;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        if(index >= size || index < 0) {
            return null;
        }
        Node p = this.sentinel.next;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }

    @Override
    public T getRecursive(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int idx) {
        if(node == this.sentinel) {
            return null;
        }
        if(idx == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, idx - 1);
    }
    
}
