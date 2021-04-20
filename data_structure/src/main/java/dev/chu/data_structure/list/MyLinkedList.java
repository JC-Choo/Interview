package dev.chu.data_structure.list;

public class MyLinkedList implements List<Object> {

    int size;
    Node head;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * "선형"
     * @param element : 더하고자 하는 Object
     * @return : true 를 리턴
     */
    @Override
    public boolean add(Object element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            for (; node.next != null; node = node.next) {
                node.next = new Node(element);
            }
        }
        size++;
        return true;
    }

    /**
     * getNode() 함수가 선형이므로, add 함수는 "선형"
     *
     * @param index   : 더하고자 하는 위치
     * @param element : 더하고자 하는 element
     */
    @Override
    public void add(int index, Object element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            // A -> B -> C ===> A -> D -> B -> C
            Node node = getNode(index - 1);
            node.next = new Node(element, node.next);
        }
        size++;
    }

    /**
     * "선형"
     * @param element : 찾고자 하는 element
     * @return : 찾고자 하는 element 가 있을 경우 해당 index 를 return, 없으면 -1을 리턴
     */
    @Override
    public int indexOf(Object element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (equals(element, node.data)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    /**
     * getNode or get 함수는 "선형" 이다.
     * 찾고자 하는 index 까지 for 문을 돌려 마지막 node 의 next 값을 반환해줘야 하기 때문.
     * @param index : 찾고자 하는 위치
     * @return : getNode - Node, get - Object
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // A -> B -> C -> D ====> 1 -> B
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    @Override
    public Object set(int index, Object element) {
        // A -> B -> C ===> A -> D -> C
        Node oldNode = getNode(index-1);
        Object old = oldNode.data;
        oldNode.next = new Node(element, oldNode.next.next);

        return old;
    }

    /**
     *  "선형"
     *  결국 기존에 보고 있던 index 의 값을 없애기 위해선, index-1 위치에 있는 Node 의 next 를 next.next를 바라보게 하면 된다.
     *  이렇게 될 경우 버려진 next는 가비지 컬렉션에 의해 제거된다.
     * @param index
     * @return
     */
    @Override
    public Object remove(int index) {
        Object element = get(index);

        if (index == 0) {
            head = head.next;
        } else {
            // A -> B -> C -> D ====> A -> C -> D
            Node node = getNode(index-1);
            node.next = node.next.next;
        }
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 두 개의 상수시간 연산으로 볼 수 있지만, 요소의 개수에 비례하여 가비지 컬렉터가 동작하므로 "선형"이다.
     */
    public void clear() {
        head = null;
        size = 0;
    }
}
