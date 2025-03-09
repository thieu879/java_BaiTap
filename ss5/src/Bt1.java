public class Bt1 {
    public static void main(String[] args) {
        int [] arr = {10,20,5,50,30};
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }else {
                continue;
            }
        }
        System.out.println(max);
    }
}
