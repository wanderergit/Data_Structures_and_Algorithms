package Arrays;

import java.util.ArrayList;

public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 7};
        int arr2[] = {2, 3, 5, 6};

        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> intersection = new ArrayList<>();

        getUnionIntersection(arr1, arr2, union, intersection);

        System.out.println(union.toString());
        System.out.println(intersection.toString());

    }

    public static void getUnionIntersection(int[] arr1, int[] arr2, ArrayList<Integer> union, ArrayList<Integer> intersection){
        int ptr1 = 0, ptr2 = 0;

        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] > arr2[ptr2]){
                union.add(arr2[ptr2]);
                ptr2++;
            } else if(arr2[ptr2] > arr1[ptr1]){
                union.add(arr1[ptr1]);
                ptr1++;
            } else {
                union.add(arr1[ptr1]);
                intersection.add(arr1[ptr1]);
                ptr1++;
                ptr2++;
            }
        }

        if(ptr1 == arr1.length){
            while(ptr2 < arr2.length){
                union.add(arr2[ptr2]);
                ptr2++;
            }
        }
        if(ptr2 == arr2.length){
            while(ptr1 < arr1.length){
                union.add(arr1[ptr1]);
                ptr1++;
            }
        }
    }
}

