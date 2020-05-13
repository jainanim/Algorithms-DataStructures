public class binarySearchpivot {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = search(arr, 0, n-1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    public static int search(int[]arr,int low, int high , int key)
    {
        if(low>high)
            return -1;


        int m = (low + high)/2;
        if(arr[m]== key)
        {
            return m;
        }

        if(arr[low]<arr[m])
        {
            if(key<=arr[m] && key>=arr[low])
                return search(arr,low,m-1,key);
            else
                return search(arr,m+1,high,key);
        }

        if(key>=arr[m] && key<=arr[high])
            return search(arr,m+1,high,key);

        return search(arr,low,m-1,key);

    }

}
