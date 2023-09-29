```
import java.util.List;  
@SuppressWarnings("unchecked")  
public class MyArrayList<T>{  
    private Object[] arr;  
    private int size;  
    private int capacity;  
  
    public MyArrayList(){  
        this.capacity = 10;  
        this.size = 0;  
        arr = new Object[capacity];  
    }  
  
  
    public int size() {  
        return this.size;  
    }  
  
    public boolean isEmpty() {  
        return this.size == 0;  
    }  
  
  
    public T get(int index) {  
        if(index < 0 || index >= this.size) return null;  
        return (T) arr[index];  
    }  
  
    public T set(int index, T element) {  
        if(index < 0 || index >= this.size) return null;  
        arr[index] = element;  
        return (T) arr[index];  
    }  
  
    public void add(T element) {  
        if(this.size == this.capacity){  
            this.capacity *= 2;  
            Object[] newArr = new Object[this.capacity];  
            for(int i = 0;i<this.size;i++){  
                newArr[i] = arr[i];  
            }  
            this.arr = newArr;  
        }  
        this.arr[this.size++] = element;  
    }  
    public T remove(int index){  
        if(this.isEmpty()) return null;  
        return (T) arr[--this.size];  
    }  
  
    @Override  
    public String toString(){  
        String s = "";  
        s+="[";  
        for(int i = 0;i<this.size;i++){  
            s+=arr[i].toString();  
            if(i!= this.size-1) s+=", ";  
        }  
        s+="]";  
        return s;  
    }  
}
```