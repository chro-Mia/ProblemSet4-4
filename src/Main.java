public class Main {
    public static void main(String[] args){
        int[] array = new int[]{6,4,3,2,6};
        selectionSort(array);
        for(int ints : array){
            System.out.println(ints);
        }
    }

    public static int[] selectionSort(int[] array){
        int lowest = array[0];
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < lowest){
                lowest = array[i];
                index = i;
            }
        }
        array[index] = array[0];
        array[0] = lowest;
        return array;
    }
}
