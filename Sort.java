
uncommenting this should fail the github actions
public class Sort{
    void printarray(int arr[]) {
        int n = arr.length;
        for(int i =0 ; i< n;i++)
        {
            System.out.print(arr[i]+"\t");
        }

    }

    void lsearch(int arr[],int key){
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                System.out.println("\nElement found at position " + (i+1));
                return;
            }
        }
    }
    void bsearch(int arr[],int key,int low,int high){

        int mid = (high+low)/2;
        if(key ==  arr[mid]) {
            System.out.println("\nElement found at position " + (mid+1));
            return;
        }
        else
        if(key<arr[mid])
            bsearch(arr,key,low,mid-1);
        else
            bsearch(arr,key,mid+1,high);

    }

    void bubblesort(int arr[]){
        int n = arr.length;
        for (int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            }
        }
    }

    void selectsort(int arr[]){
        int n = arr.length;
        for (int i = 0; i <n-1; i++){
            int min = i;

            for ( int j = i+1; j<n;j++)
            
                if (arr[j] < arr[min])
                {
                    min = j;
                }

            int temp = arr[i];
            arr[i]  = arr[min];
            arr[min] = temp;        
        

        }

    }

    void isort(int arr[]){
        int n = arr.length;
        for(int i =1; i<n; i++ ){
            int key = arr[i];
            int j = i-1;
            while ( j >=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;

            }
            arr[j+1] = key;
        }
    }

    public static void divide(int arr[], int si , int ei) {
        if (si>=ei)
        return;
        int mid = si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
        
    }
    public static void conquer(int arr[],int si,int mid,int ei){
        int merged[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x++] = arr[idx1++];
                
            }
            else
            {
                merged[x++] = arr[idx2++];
                
            }
            

        }
        while(idx1<=mid){
            merged[x++] = arr[idx1++];
        }
        while(idx2<=ei){
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=si; i<merged.length;i++,j++){
            arr[j]= merged[i];
        }

    }

    int partition(int arr[],int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>= low+1){
                j--;
            }
            if(i<j) swap (arr, i,j);
        }
        swap (arr,low,j);
        return j;
    }

    void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void qs(int arr[],int low,int high){
        if(low<high){
            int pIndex  = partition(arr,low,high);
            qs(arr,low,pIndex-1);
            qs(arr,pIndex+1,high);
        }

    }


    int[] qsort(int arr[]){
        qs(arr,0,arr.length-1);
        return arr;

    }
    public static void main(String args[]) {
        Sort s = new Sort();
        int[] arr = new int[] {10, 30, 50, 40,20,12,73,27};
        int key = 27; //Element to be seatched
        //s.printarray(arr); //Array before sorting
        System.out.println();
        //s.divide(arr,0,arr.length-1); //Calling merge sort
        //s.selectsort(arr); //Calling selection sort
        //s.bubblesort(arr); //Calling bubble sort
        //s.isort(arr); //Calling insertion sort
        s.qsort(arr); //Calling quick sort
        System.out.println("\nElement to be searched "+ key);
        s.printarray(arr); //Array after sorting
        s.bsearch(arr,key,0,arr.length); //Binary Search
        //s.lsearch(arr,key); //Linear Search

    }
        
    
}

