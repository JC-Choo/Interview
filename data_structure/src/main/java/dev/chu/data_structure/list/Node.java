package dev.chu.data_structure.list;

import org.jetbrains.annotations.NotNull;

public class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @NotNull
    public String toString() {
        return "Node("+data.toString()+")";
    }
}
