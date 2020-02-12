public class MyArray {

    private int[] arr;

    private int len;


    public int getLength() {
        return len;
    }


    public MyArray(int len) {
        this.arr = new int[len];
        this.len = len;
    }

    public int[] getArray() {
        return arr;
    }

    public boolean isSorted() {
        for(int i = 0; i < len - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void set(int ix, int value) {
        arr[ix] = value;
    }

    public int get(int ix) {
        return arr[ix];
    }

    public void delete(int ix) {
        if(len == 0 || ix < 0 || ix > len) {
            return;
        }

        int[] newArr = new int[len - 1];

        for (int i = 0; i < ix; i++) {
            newArr[i] = arr[i];
        }

        for (int i = ix; i < len - 1; i++) {
            newArr[i] = arr[i + 1];
        }

        this.arr = newArr;
        len--;
    }

    public void add(int num) {
        if(len == arr.length) {
            int[] newArr = new int[len * 2];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            System.out.printf("Array length exceeded -> increasing length twice - from %d to %d\n", len, arr.length);
        }
        arr[len] = num;
        len++;
    }

    public int find(int num) {
        for (int i = 0; i < len; i++) {
            if(arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            sb.append(arr[i]);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
