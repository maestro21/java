import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


class HashTable{
    private Stack[] hashArr;
    private int arrSize;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new Stack[arrSize];
    }

    public void print(){
        for(int i = 0; i < arrSize; i++){
            if(hashArr[i] != null){
                System.out.println(Arrays.toString(hashArr[i].toArray()));
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void add(int key){
        int hashVal = hashFunc(key);
        if(hashArr[hashVal] == null)  {
            hashArr[hashVal] = new Stack();
        }
        hashArr[hashVal].push(key);
        System.out.printf("Added %d\n", key);
    }

    public void remove(int key){
        int hashVal = hashFunc(key);
        if(hashArr[hashVal] == null) {
            return;
        }
        int i = hashArr[hashVal].search(key);

        if(i != -1) {
            hashArr[hashVal].remove(i);
            System.out.printf("Removed %d\n", key);
        }
    }

    public boolean contains(int key){
        int hashVal = hashFunc(key);
        if(hashArr[hashVal] == null) {
            return false;
        }
        int i = hashArr[hashVal].search(key);
        return (i > -1);
    }
}

public class HW8 {

    private static HashTable ht;

    public static void main(String[] args) throws IOException{
        ht = new HashTable(10);

        for(int i = 0; i < 20; i++) {
            ht.add(i);
        }

        ht.print();

        ht.add(55);
        ht.remove(12);
        ht.print();

        find(5);
        find(15);
        find(12);
        find(55);
        find(100);
    }

    public static void find(int i) {
        if(ht.contains(i)) {
            System.out.printf("%d found in hashtable\n", i);
        } else {
            System.out.printf("%d not found\n", i);
        }
    }

}
