public class HW2 {



    public static void main(String[] args) {
        HW2 hw = new HW2();
        hw.testArray();
        hw.generateAndSortArray();
    }

    public void generateAndSortArray() {
        int len = 1000;
        MyArray arr;

        for(int i = 1; i < 4 ; i++) {
            len = len * 10;

            arr = generateArray(len);
            ArraySort.mergeSort(arr.getArray());

            arr = generateArray(len);
            ArraySort.insertionSort(arr.getArray());

            arr = generateArray(len);
            ArraySort.selectionSort(arr.getArray());

            arr = generateArray(len);
            ArraySort.bubbleSort(arr.getArray());
            reportArrayInfo(arr);
        }
    }


    public MyArray generateArray(int len) {
        MyArray arr = new MyArray(len);
        for(int i = 0; i < len; i++) {
            int val = (int)(Math.random() * Integer.MAX_VALUE);
            arr.set(i, val);
        }
        return arr;
    }


    public void reportArrayInfo(MyArray arr) {
        System.out.printf("Array length: %d\n", arr.getLength());
        if(arr.isSorted()) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }

    public void testArray() {
        MyArray arr = new MyArray(10);
        arr.set(0, 1);
        arr.set(1, 2);
        arr.set(2, 3);
        arr.set(3, 4);
        arr.set(4, 5);
        System.out.println(arr);
        arr.delete(1);
        arr.delete(3);
        arr.add(666);
        arr.add(333);
        System.out.println(arr);
        System.out.println(arr.find(4));
        System.out.println(arr.find(333));
        System.out.println(arr.find(934524));
        reportArrayInfo(arr);
    }



}
