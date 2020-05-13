import java.util.HashMap;

public class smallestSumContiguous {
    public static void main(String[] args) {
        int result = smallestSumContiguous.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = smallestSumContiguous.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = smallestSumContiguous.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);

        System.out.println("Length of the longest substring: " + smallestSumContiguous.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + smallestSumContiguous.findLength("araaci", 1));
    }
    public static int findMinSubArray(int s, int[]arr)
    {
        int res=999999;
        int winstart=0;
        int l = arr.length;
        int sum=0;

        for(int winEnd =0;winEnd < l;winEnd++)
        {
            sum = sum + arr[winEnd];
            while(sum >= s)
            {
                res = Math.min(res,winEnd-winstart+1);
                sum = sum -arr[winstart];
                winstart++;

            }

        }
        return res;
    }
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if(str.length()==0|| str==null || str.length()<k)
            throw new IllegalArgumentException();
        HashMap<Character,Integer> map = new HashMap<>();
        int winStart = 0;
        int maxLen =0;
        for(int winEnd =0; winEnd<str.length();winEnd++)
        {
            char rightChar = str.charAt(winEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);


            while(map.size()>k)
            {
                //reduce map size
               char leftChar = str.charAt(winStart);
               int freq = map.get(leftChar);
               if(freq==1)
               {

               }
               else
               {
                   map.put(leftChar,freq--);
               }





            }
            maxLen = Math.max(winEnd-winStart,maxLen);
        }


        return -1;
    }


}
