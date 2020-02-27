/* Joseph Teixeira
 * 2/27/2020
 * ID: 1211321420
 */
import java.util.Arrays;

public class SimpleList {
    private int list[];
    private int count;
    
    public SimpleList() {
        this.count = 0;
        list = new int[10];
    }
    
    public void add(int num) {
        // If array is full, increase size by 50% using resize method
        if (count == list.length) {
             int half = count / 2;
             resize(count + half);
        }
        // shifting remaining elements
        for (int i = count; i > 0; i--) {
             list[i] = list[i - 1];
        }
        // adding element at first index, increment count
        list[0] = num;
        count++;
    }
    // private method to resize the array with a given new size
    
    private void resize(int newSize) {
        int array[] = new int[newSize];
        // copying elements to new array
        for (int i = 0; i < newSize && i < count; i++) {
             array[i] = list[i];
        }
        // replacing old array with new one
        list = array;
        // adjusting count if necessary
        if (newSize < count) {
            count = newSize;
        }
    }
    
    public void remove(int num) {
        int index = search(num);
        if (index != -1) {
             // remove specific indexed element in array
             // left shift array
             for (int i = index; i < count - 1; i++) {
                 list[i] = list[i + 1];
             }
             count--;
        } else {}
        // finding 75% of the capacity
        int n = 3 * list.length / 4;
        // if count is less than 75% capacity (more than 25% free space),
        // resizing to size=count (since no size is mentioned, I'm using the
        // exact size)
        if (count < n) {
             resize(count);
        }
    }
    
    // appends an element to the end
    public void append(int value) {
        // increasing capacity if full
        if (count == list.length) {
             int half = count / 2;
             resize(count + half);
        }
        // adding at count index
        list[count] = value;
        count++;
    }
    
    // returns the first element
    public int first() {
        if (count == 0) {
             return -1;
        }
        // otherwise returning first element
        return list[0];
    }
    
    // returns the last element
    public int last() {
    	int last = list[count];
    	if(last == 0)
    		return -1;
    		else
    			return last;
    }

    // returns the current capacity (might not be the same as count)  
    public int size() {
        return list.length;
    }
    
    public int count() {
    	return count;
    }
    
    public int search(int num) {
        int index = -1;
        for (int i = 0; i < count; i++) {
             if (list[i] == num) {
                 index = i;
             }
        }
        return index;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < count; i++) {
             str += list[i];
             if (i != count - 1) {
                 str += " ";
             }
        }
        return str;
    }
}