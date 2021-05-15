package Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2, 2, 0, 1, 0, 2, 1, 0, 0, 2, 0, 1};
        int[] res = dutchNationalFlag(arr, arr.length);
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    public static int[] dutchNationalFlag(int[] arr, int n){
        int l = 0, m = 0, h = n-1;
        while(m<=h){
            switch(arr[m]){
                case 0:
                    swap(m, l, arr);
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(m, h, arr);
                    h--;
                    break;
            }
        }
        return arr;
    }

    public static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
