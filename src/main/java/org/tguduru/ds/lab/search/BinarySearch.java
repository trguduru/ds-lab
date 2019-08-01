package org.tguduru.ds.lab.search;

public class BinarySearch{
  private int [] data;

  public BinarySearch(int [] input){
    this.data = input;
  }

  public boolean searchElement(int element,int low, int high){
    if(low > high)
      return false;
    else{
      int mid = (low + high)/2;
      if(element == data[mid])
          return true;
      else if(element < data [mid])
       return searchElement(element,low,mid - 1);
      else
     return searchElement(element,mid+1,high);
    }

  }

  public boolean binarySearch(int element){
    return searchElement(element, 0, data.length);
  }


    public static void main(String[] args) {
        int [] input = {10,25,40,46,55,63,75,90};
        BinarySearch search  = new BinarySearch(input);
        //binary search in a sorted array
        System.out.println(search.binarySearch(44));
    }


}
