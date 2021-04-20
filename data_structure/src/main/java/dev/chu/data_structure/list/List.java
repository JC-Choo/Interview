package dev.chu.data_structure.list;

public interface List<E> {
    boolean add(E element);
    void add(int index, E element);
    int indexOf(E element);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int size();
}
