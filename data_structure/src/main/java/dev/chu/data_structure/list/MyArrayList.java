package dev.chu.data_structure.list;

import java.util.Collection;

public class MyArrayList<E> implements List<E> {

    int size;   // 요소의 개수
    private E[] array;  // 요수를 저장할 배열

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    /**
     * "상수"
     * @param element : 더하고자 하는 element
     * @return : true
     */
    @Override
    public boolean add(E element) {
        if (size >= array.length) {
            E[] otherArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, otherArray, 0, array.length);
            array = otherArray;
        }
        array[size] = element;
        size++;
        return true;
    }

    /**
     * "선형"
     * @param index : 더하고자 하는 위치
     * @param element : 더하고자 하는 값
     * @return : 더했을 경우 true 리턴
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        add(element);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
    }

    /**
     * "선형"
     * @param element : 찾고자 하는 위치에 해당하는 값
     * @return : 찾을 경우 해당 위치의 index 를 리턴, 없을 경우 -1 을 리턴
     */
    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (equals(element, array[i])) {
                return i;
            }
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
     * "상수"
     * @param index : 얻고자 하는 값의 위치
     * @return : 얻고자 하는 위치에 해당하는 값
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E old = get(index);
        array[index] = element;
        return old;
    }

    /**
     * "선형"
     * @param index : 지우고자 하는 위치
     * @return : 지우고자 하는 위치에 있던 기존 값
     */
    @Override
    public E remove(int index) {
        E old = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * "선형"
     * @param element : 지우고자 하는 element
     * @return : 지울 값이 array 에 있을 때 true, 없으면 false 를 리턴
     */
    public boolean remove(Object element) {
        boolean isRemove = false;
        for (int i = 0; i < size ; i++) {
            if (equals(element, array[i])) {
                remove(i);
                isRemove = true;
            }
        }

        return isRemove;
    }

    /**
     * remove(obj)가 바로 찾을 경우 선형이지만, 보통 "이차"라고 생각하면 된다.
     * @param collection : 없애고자 하는 Collection
     * @return : 전부 없앨 경우 true, 아닐 경우 false
     */
    public boolean removeAll(Collection<?> collection) {
        boolean flag = false;

        for (Object obj : collection) {
            flag |= remove(obj);
        }

        return flag;
    }
}
