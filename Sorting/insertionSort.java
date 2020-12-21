public class insertionSort {
    static void sort(int a[]){
        int temp,j,i;
        for(i=1; i<a.length; i++){
            temp = a[i];
            for(j=i-1; j>=0 && temp<a[j]; j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
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
