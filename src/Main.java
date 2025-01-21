public class Main {
    public static void main(String[] args){
        int[] array = new int[1000];
        for(int i = 0; i < 1000; i++){
            int a = (int)(Math.random() * 100);
            array[i] = a;
        }
        insertionSort(array);

        long startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            int a = (int)(Math.random() * 100);
            binarySearch(array, a);
        }
        long duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
    //binary search is much faster especially for larger arrays
    //linear search is super slow large arrays (many times slower)
    //but linear search also works for unsorted arrays

    public static int[] selectionSort(int[] array){
        int index = 0;

        for(int i = 0; i < array.length; i++){
            int lowest = array[i];
            for(int j = i; j < array.length; j++){
                if(array[j] <= lowest){
                    lowest = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = lowest;
        }
        return array;
    }

    public static int[] insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int intToSort = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > intToSort){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = intToSort;
        }

        return array;
    }

    public static int binarySearch(int[] array, int numToFind){
        int minIndex = 0;
        int maxIndex = array.length - 1;

        while(minIndex <= maxIndex){
            int mid = minIndex + (maxIndex - minIndex) / 2;
            if(array[mid] == numToFind){
                return mid;
            }
            if(array[mid] < numToFind){
                minIndex = mid + 1;
            }
            else{
                maxIndex = mid - 1;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] array, int numToFind){
        for(int i = 0; i < array.length; i++){
            if(array[i] == numToFind){
                return i;
            }
        }
        return -1;
    }
}
