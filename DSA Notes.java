❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖ SORTING ❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖

➤ Bubble Sort:

   ⊛ It sorts N elements by placing the biggest element at the end in each iteration.
   ⊛ Starting with two pointer, Initial value of both are 0.
   ⊛ In each iteration we have to compare next two element that why arr[j] > arr[j + 1].
   ⊛ Second pointer goes till (arr.length - i - 1) because in each iteration, we will get our largest index at the end.
   ⊛ Time Complexity: O(N^2).

   public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

➤ Selection Sort:
   
    ⊛ It sorts N elements by placing the Smallest element at the Starting according to the order in each iteration.
    ⊛ Starting with two pointer, both goes till N and Second pointer increase every time to find smallest.
    ⊛ And at the end of first iteration we will swap smallest element with arr[i].
    ⊛ Time Complexity: O(N^2)

    public static void SelectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

➤ Insertion Sort:

    ⊛ In Insertion sort array contains two part one is Sorted Part and another one is Unsorted part.
    ⊛ Initially, Sorted part will be of one index and during execution Sorted part will increase and unsorted part will decrease.
    ⊛ First we will store the CURRENT index into current variable and then we find the particular place then we will place current at that position.
    ⊛ Time Complexity: O(N^2)

    public static void InsertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            //Placement
            arr[j + 1] = current;
        }
    }

➤ Merge Sort:
    
    ⊛ In Merge sort, an Array divided into multiple subArrays till the single element array and then they are combining in sorted order.
    ⊛ After Combining all elments array are in sorted form.
    ⊛ At every recursive call We divide the array into two subArrays.
    ⊛ Then merging two the array at every recursion call according to the order.
    ⊛ Time Complexity: O(NlogN) & Space Complexity: O(N)
    
    public static void merge(int[] arr, int start, int end){
        // Calculating mid element
        int mid = start + (end - start)/2;

        // creating a temp Array
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }

        // Copying all Elements of temp into Original Array.
        for(int m = 0, n = start; m < temp.length; m++, n++){
            arr[n] = temp[m];
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

➤ Quick Sort:
    
    ⊛ In Quick Sort, First we choose pivot element and swaps element such a way that all the smaller elements comes before pivot and greater elements after pivot.
    ⊛ At every recursive call We divide the array into two subArrays According to the pivot element.
    ⊛ Time Complexity: O(NlogN).

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while(arr[j] > pivot && j >= low){
                j--;
            }
            // Swapping ith index and jth index.
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swapping high with the pivot element.
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    public static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

➤ Recursive Bubble Sort:
    
    ⊛ first we start a loop and send the largest element to the end of the array by comparing adjacent element.
    ⊛ And then we recursive call for (N - 1), and if n == 0 then it will terminate.
    ⊛ Time Complexity: O(N^2).

    public static void bubbleSort(int[] arr, int n){
        if(n == 0){
            return;
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr, n - 1);
    }

➤ Recursive Insertion Sort:
    
    ⊛ first we start a loop and find the current element at i = 1 and then by comparing elements we insert an element at particular position.
    ⊛ And then we recursive call for (N - 1) & (i + 1), and if n == 0 then it will terminate.
    ⊛ Time Complexity: O(N^2).

     public static void insertionSort(int[] arr, int n, int i){
        if(n == 0){
            return;
        }
        int current = arr[i];
        int j = i - 1;
        while(j >= 0 && current < arr[j]){
            arr[j + 1] = arr[j];
            j--;
        }
        // placement
        arr[j + 1] = current;
        insertionSort(arr, n - 1, i + 1);
    }

❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖ ARRAYS ❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖❖


➤ Q. Find Second Largest Element in the Array?
 
    Solution: 01
    ⊛ In First Iteration We will push the last element at the end of the array just like Recursive Bubble Sort
    ⊛ And then we will assign the previous value of max to the secondMax Variable and gets the answer.
    ⊛ Time Complexity: O(N).

    public static int findSecondMaxElement(int[] arr) {
        // First we will push greatest element at the end of the Array.
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // and when Max gets its final value, its previous value which is second last
        // assigned to the second_Max.
        int max = Integer.MIN_VALUE;
        int second_max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                second_max = max;
                max = arr[i];
            }
        }
        return second_max;

    }
    
    Solution: 02
    ⊛ In First Iteration We will find the largest element in the Array.
    ⊛ and After that we Again do an iteration and find nearest greater maximum value, which is second greatest element.
    ⊛ Time Complexity: O(N).

    public static int findSecondMaxElement(int[] arr) {
         int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int secondMax = -1;
        for(int i = 0; i < arr.length; i++){
            if(secondMax < arr[i] && arr[i] < max){
                secondMax = arr[i];
            }
        }
        return secondMax;

    }

➤ Q. Check If Array is Sorted or not in Rotated Array?
      
      ⊛ First we will traverse the Array from start till end and if arr[i] > arr[i + 1] present two times then Rotated Array is unsorted
      ⊛ We will use arr[(i + 1) % n) instead of arr[i + 1], because Array is rotated it will go to the 1 index otherwise it will throw index out of bound error.
      ⊛ Time Complexity: O(N).

      public static boolean checkSorted(int[] arr){
        // In case of Rotated Array.
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
            // %n because whenever it goes at end index then 6 % 5 = 1 will start from index 1.
            // and will not throw Array Index out of bound
            if(arr[i] > arr[(i + 1) % n]){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
      
➤Q. Write a program to remove duplicates from Sorted Array and Return K where K is the Last position of distinct element.

      ⊛ Remove duplicate Elements from Array and return the Array.
      ⊛ We will traverse with count variable and if we find duplicate elment then update the count otherwise add element to the nums[i - count] = nums[i].
      ⊛ Time Complexity: O(N).

       public static int removeDuplicates(int[] nums){
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }
            else{
                // It will store the current number to the last non-duplicate element.
                nums[i - count] = nums[i];
            }
        }
        return n - count;
    }

➤Q. Write a program to move all Zeros at the end of the Array.
    
      ⊛ We will traverse the Array till end, If we get zero at any index then we will increase the Zeros value by one.
      ⊛ Otherwise if we get not Zeros element then we will set that index 0 and then we will set that value to the arr[i - Zeros] by doing we will get non zeros elment at starting 
      ⊛ Time Complexity: O(N).

     public static void zerosToEnd(int[] arr){
        int zeros = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                zeros++;
            }
            else{
                int temp = arr[i];
                arr[i] = 0;
                arr[i - zeros] = temp;
            }
        }
    }

➤Q. Write a program to find union of two sorted Array.

    ⊛ We will start with two pointer one will be in first array initialized with 0 index and another will be in second Array initialized with 0 index.
    ⊛ by comparing these two pointers with we will add values in our map as arrays are sorted.
    ⊛ Time Complexity: O(N) & Space Complexity: O(1).

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
           HashMap<Integer, Integer> map = new HashMap<>();
           ArrayList<Integer> ans = new ArrayList<>();
           for(int i = 0; i < n; i++){
               map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
           }
           for(int i = 0; i < m; i++){
               map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
           }
           for(int val: map.keySet()){
               ans.add(val);
           }
           return ans;
        */
        
        // Optimized Solution: --> Time Complexity: O(N) & Space complexity: O(1)
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(union.size() == 0 || union.get(union.size() - 1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++; // it will be outside to ignore duplicate values.
            }
            else{
                if(union.size() == 0 || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++; // it will be outside to ignore duplicate values.
            }
        }
        while(i < n){
            if(union.get(union.size() - 1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++; // it will be outside to ignore duplicate values.
        }
        while(j < m){
            if(union.get(union.size() - 1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++; // it will be outside to ignore duplicate values.
        }
        return union;
    }

➤Q. Write a program to find Intersection of two sorted Array.

     ⊛ We will start with two pointer one will be in first array initialized with 0 index and another will be in second Array initialized with 0 index.
     ⊛ by comparing these two pointers with we will add values in our map as arrays are sorted.
     ⊛ Time Complexity: O(N) & Space Complexity: O(1).

     public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2, int n, int m){
        /*
         * BruteForce Approach --> Time complexity: O(N^2) & Space Complexity: O(1).
         * ArrayList<Integer> intersection = new ArrayList<>();
           for(int i = 0; i < n; i++){
               for(int j = 0; j < m; j++){
                   if(arr1[i] == arr2[j]){
                       if((intersection.size() == 0 ||intersection.get(intersection.size() - 1) != arr1[i])){
                           intersection.add(arr1[i]);
                       }
                   }
               }
           }
           return intersection;
        */

        // Optimized Solution --> Time complexity: O(N) & Space complexity: O(1).
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return ans;
        
    }


➤Q. Write a program to find missing number in the range 0 to N in an Array.
       
      ⊛ First we will find the Sum of all element in the array and then we will find the sum of 0 to N - 1 (if from 0) or 1 to N (if from 1).
      ⊛ by subtracting the sum of all elments by Sum from 1 to N we will get our number which is missing.
      ⊛ Time Complexity: O(N) & Space Complexity: O(1).

     public static int missingNumber(int[] arr) {
        int sum = 0;
        int N = arr.length;
        // calculating sum of all elements of the array.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        // calculation sum till 0 to N - 1
        int sum2 = (N * (N + 1))/2;
        // We will get our ans by subtracting
        int ans = sum2 - sum;
        return ans;
        
    }


➤Q. Write a program to search an element from 2D Array.
       
      ⊛ This is another method to search element from 2D array by using two pointer.
      ⊛ Time Complexity: O(M * N) & Space Complexity: O(1).


    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

