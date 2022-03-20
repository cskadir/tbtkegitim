package kadir.korkmaz;

import java.util.Arrays;

public class MyList<T> {

    private int capacity;
    private int lastIndex;
    private T array[];

    public MyList() {
        lastIndex = -1;
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    public MyList(int capacity) {
        lastIndex = -1;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return lastIndex + 1;
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(T data) {

        if(lastIndex == capacity-1){
            T tempArray[] = (T[]) new Object[array.length * 2];

            for (int i=0; i< array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        lastIndex++;
        array[lastIndex] = data;
    }

    public T get(int index) {
        if( index > 0  && index <= lastIndex){
            return array[index];
        }
        return null;
    }

    public T  remove(int index){

        if( index >= 0  && index <= lastIndex){
            T temp = array[index];
            for(int i =index ; i<=lastIndex-1 ; i++){
                array[i] = array[i+1];
            }
            array[lastIndex] =null;
            lastIndex--;
        }
        return null;
    }

    public T  set(int index, T data){

        if( index >= 0  && index <= lastIndex){
            array[index] = data;
            return data;
        }
        return null;
    }

    public String toString(){
        String s = "[ ";
        for (int i=0; i <= lastIndex; i++) {
            s+=array[i].toString() +",";
        }
        s+=" ]";
        return s;
    }

    public int indexOf(T data){

        for (int i=0; i <= lastIndex; i++) {
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){

        for (int i = lastIndex ; i>= 0; i--) {
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(lastIndex == -1)
            return true;
        return false;
    }

    public T[] toArray() {
        return Arrays.copyOf((T[])array,lastIndex+1);
    }

    public void clear() {
        for (int i=0; i<array.length; i++) {
            array[i] = null;
        }

        lastIndex = -1;
    }

    public MyList<T> subList(int start,int finish){
        MyList<T> newList= new MyList<>();
        for (int i=start; i<=finish; i++) {
            newList.add(array[i]);
        }
        return newList;
    }

    public boolean contains(T data){

        for (int i=0; i <= lastIndex; i++) {
            if(array[i] == data){
                return true;
            }
        }
        return  false;
    }
}
