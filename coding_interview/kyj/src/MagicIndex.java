import java.io.IOException;

/**
 * Created by yong on 2018. 9. 18..
 */
public class MagicIndex {
    /**
     * description : 코딩인터뷰 9-3번
     * solution :
     */
    public static void main(String[] args) throws IOException{
        int [] arr = {-40, -20, 1, 2, 3, 5, 7, 9, 12, 13};

        int result = getMagicIndex(arr);
        System.out.println(result);

        result = magicFast(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    /**
     * Brute-force 방법
     */
    public static int getMagicIndex(int[] arr){
        int arrSize = arr.length;

        for(int i = 0; i < arrSize; i++){

            if(i == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * Recursive 방법
     */
    public static int magicFast(int[] array, int start, int end){
        if(end < start || start < 0 || end >= array.length){
            return -1;
        }

        int mid = (start + end) / 2;

        if(array[mid] == mid) {
            return mid;
        }else if(array[mid] > mid){
            return magicFast(array, start, mid - 1);
        }else{
            return magicFast(array, mid + 1, end);
        }
    }
}
