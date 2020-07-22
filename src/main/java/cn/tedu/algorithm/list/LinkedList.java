package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/12 18:23
 * @Created by liukaihua
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表元素个数
    public int getSize(){
        return size;
    }

    //是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        size++;
        add(0,e);
    }

    public void add(E e){
        if (dummyHead.next == null) {
            dummyHead.next = new Node(e);
            size++;
        }else {
            Node res = new Node(e);
            res.next = dummyHead.next;
            dummyHead.next = res;
        }
    }

    public void addNode(E e){
        if (dummyHead.next == null) {
            dummyHead.next = new Node(e);
            size++;
        }else {
            add(e);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    public void add(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed");
        }

        Node prev = dummyHead;
        for (int i=0;i<index;i++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed");
        }
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed");
        }
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean isContains(E e){
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed");
        }
        Node prev = dummyHead;
        for (int i=0;i<index;i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur+"->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
