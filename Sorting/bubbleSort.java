public class bubbleSort {
    static void sort(int a[]){
        int length = a.length;
        int temp;
        for(int round=1; round<length; round++){
            int flag = 1;
            for(int i=0; i<length - round; i++){
                if(a[i] > a[i+1]){
                    flag = 0;
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            if(flag == 1)
                break;
        }
    }
    public static void main(String[] args) {
        int a[] = new int[]{12,23,2,8,9,7,13};
        sort(a);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
