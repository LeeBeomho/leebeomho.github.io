import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] items = {7, 5, 6, 4, 2, 3, 7, 5};
        ArrayList<Bin> arr = new ArrayList<>();

        Fit ff = new FirstFit();
        for (int i=0; i<items.length; i++) {
            ff.fit(arr, new Item(items[i]));
        }
        
        ArrayList<Bin> arr2 = new ArrayList<>();
        
        Fit lf = new NextFit();
        for (int i=0; i<items.length; i++) {
            lf.fit(arr2, new Item(items[i]));
        }
        
        ArrayList<Bin> arr3 = new ArrayList<>();
        
        Fit bf = new BestFit();
        for (int i=0; i<items.length; i++) {
            bf.fit(arr3, new Item(items[i]));
        }
        
        ArrayList<Bin> arr4 = new ArrayList<>();
        
        //결과 출력
        
        for (int i=0; i<arr.size(); i++) {
        	System.out.println(arr.get(i).toString());
        }
        
        System.out.println(arr.size());
        
        for (int i=0; i<arr2.size(); i++) {
        	System.out.println(arr2.get(i).toString());
        }
        
        System.out.println(arr2.size());
        
        for (int i=0; i<arr3.size(); i++) {
        	System.out.println(arr3.get(i).toString());
        }
        
        System.out.println(arr3.size());
    }
}
