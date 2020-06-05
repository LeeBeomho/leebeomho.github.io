import java.util.ArrayList;

public class WorstFit implements Fit{
	 @Override
	    public void fit(ArrayList<Bin> arr, Item item) {
	    	  int[] remainCapaArray=new int[arr.size()];
	    	  int[] indexArray=new int[arr.size()];
	    	  
	    	  for (int i=0; i<arr.size(); i++) {
	    		  Bin a = arr.get(i);
	    		  remainCapaArray[i]=a.remainCapacity;
	    		  indexArray[i]=i;
	    	  }
	    	  
	    	  if(arr.size()>0)
	    		  QuickSort.reverseQuickSort(remainCapaArray, 0, arr.size()-1, indexArray);
	    	  
	    	
	    	  for (int i=0; i<arr.size(); i++) {
	              Bin bin = arr.get(indexArray[i]);
	              if(bin.check(item)) {
	                  bin.update(item);
	                  return;
	              }
	          }

	          Bin b = new Bin();
	          b.update(item);
	          arr.add(b);
	          
	    }
}
