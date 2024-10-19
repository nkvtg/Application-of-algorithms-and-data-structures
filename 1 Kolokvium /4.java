import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
class Array<E> {
    private E data[];
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void insertLast(E o) {
        if (size + 1 > data.length)
            this.resize();
        data[size++] = o;
    }
    public void insert(int position, E o) {
        if (position >= 0 && position <= size) {
            if (size + 1 > data.length)
                this.resize();
            for (int i = size; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = o;
            size++;
        } else {
            System.out.println("Ne mozhe da se vmetne element na taa pozicija");
        }
    }
    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }
    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }
    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i]))
                return i;
        }
        return -1;
    }
    public int getSize() {
        return size;
    }
    public void delete(int position) {
        if (position >= 0 && position < size) {
            E[] newData = (E[]) new Object[size - 1];
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            for (int i = position + 1; i < size; i++)
                newData[i - 1] = data[i];
            data = newData;
            size--;
        }
    }
    public void resize() {
        E[] newData = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        this.data = newData;
    }

    @Override
    public String toString() {
        String ret = new String();
        if(size>0) {
            ret = "{";
            ret += data[0];
            for(int i=1;i<size;i++) {
                ret += "," + data[i];
            }
            ret+="}";
            return ret;
        }
        else {
            ret = "Prazna niza!";
        }
        return ret;
    }

    public Double average() {
        double sum = 0.0;

        for(int i=0; i<size; i++) {
            sum += ((Number)get(i)).doubleValue();
        }

        return sum/(double)size;
    }
    public void eraseElements() {
        Array<E> temp = new Array<>(size);
        for(int i=0; i<size; i++) {
            if(((Number)data[i]).doubleValue() >= average()) {
                temp.insertLast(data[i]);
            }
        }

        this.data = temp.data;
        this.size = temp.size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        Array<Integer> array = new Array<>(size);

        for (int i = 0; i < size; i++) {
            int temp = sc.nextInt();
            array.insertLast(temp);
        }

        System.out.println(array.toString());
        array.eraseElements();
        System.out.println(array.toString());
    }
}
