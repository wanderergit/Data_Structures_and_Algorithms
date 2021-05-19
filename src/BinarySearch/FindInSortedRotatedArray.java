//package BinarySearch;
//
//public class FindInSortedRotatedArray {
//    public static void main(String[] args) {
//
//    }
//    public int search(final List<Integer> A, int B) {
//
//        int pivot = findPivot(A);
//        // System.out.println(pivot);
//        if(B == A.get(pivot)) return pivot;
//        else if(B <= A.get(A.size()-1)) return binSearch(A, B, pivot+1, A.size()-1);
//        return binSearch(A, B, 0, pivot-1);
//    }
//
//    public static int findPivot(final List<Integer> A){
//        int mid, s = 0, e = A.size()-1, res =  -1;
//
//        while(s <= e){
//            mid = s + (e-s)/2;
//            if(A.get(mid-1) > A.get(mid) && A.get(mid+1) > A.get(mid)){
//                res = mid;
//                break;
//            } else if(A.get(mid) > A.get(s))
//                s = mid+1;
//            else if(A.get(mid) < A.get(e))
//                e = mid-1;
//        }
//
//        return res;
//    }
//
//    public static int binSearch(final List<Integer> A, int B, int s, int e){
//        int mid;
//
//        while(s <= e){
//            mid = s + (e-s)/2;
//            if(A.get(mid) == B) return mid;
//            else if(A.get(mid) > B) e = mid - 1;
//            else if(A.get(mid) < B) s = mid + 1;
//        }
//
//
//        return -1;
//    }
//}
