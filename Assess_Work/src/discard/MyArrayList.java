package discard;

import java.util.ArrayList;

public class MyArrayList<E> {
	 //在声明MyArrayList时，如不指明大小，则初始大小为10
   private static final int DEFAULT_CAPACITY = 10;
   private E[] contents;
   private int size = 0;

   //两种构造函数，允许用户创建指定大小或者默认大小的线性表
   public MyArrayList(){
       init(DEFAULT_CAPACITY);
   }
   public MyArrayList(int initCapacity){
       init(initCapacity);
   }
   //私有化方法init帮助构造函数来初始化数组contents
   private void init(int capacity){
       //注意不能建立泛型数组，因此我们强行转换一个Object数组
       contents = (E[]) new Object[capacity];
   }
   
   public int size(){
       return this.size;
   }
   public boolean isEmpty(){
       return size()==0;
   }
   public void clear(){
       for(int i=0;i<size();i++){
           //将数组中元素的引用指向null，这样GC就可以回收内存
           contents[i] = null;
       }
       this.size = 0;
   }
   
   public boolean add(E element){
       if(size()>=contents.length){
           //一旦列表中的元素个数等于了数组的长度，我们就对数组进行扩容
           ensureCapacity();
       }
       //将元素放置最后位置并把元素数目加1
       contents[size++] = element;
       return true;

   }
   public void add(int index, E element){
       //一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
       //此处允许index等于size，相当于在列表末尾插入元素
   	if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
   	if(size()>=contents.length){
			ensureCapacity();
		}
       //将数组中前一个元素的值赋予后一个元素
       for(int i=size();i>index;i--)
           contents[i] = contents[i-1];
       //将要插入的元素放到index位置上
       contents[index] = element;
       this.size++;
   }
   private void ensureCapacity(){
       //此处新数组的容量是旧数组的2倍加1，你可以自己选择扩容的多少
       E[] newContents = (E[]) new Object[2*contents.length+1];
       //将就数组中的值全部拷于新数组中
       System.arraycopy(contents,0,newContents,0,size());
       //在让contents指向新的数组
       contents = newContents;
   }
   
   public boolean remove(E element){
       if(element == null){
           for(int i=0;i<size();i++){
               if(contents[i] == null){
               //如果找到元素为null，就使用私有方法fastRemove将该位置元素删除
                   fastRemove(i);
                   return true;
               }
           }
           return false;
       }else{
           for(int i=0;i<size();i++){
               if(element.equals(contents)){
                   //如果找到元素为element，就使用私有方法fastRemove将该位置元素删除
                   fastRemove(i);
                   return true;
               }
           }
           return false;
       }
   }
   public void remove(int index){
       //一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
       //此处不允许index等于size
       if(index<0 || index>=size())
           throw new IndexOutOfBoundsException();
       fastRemove(index);
   }
   //私有化方法实现无须检查边界就直接删除某一位置的元素
   private void fastRemove(int index){
       //需要从后向前移动的元素数目
       int numMoved = size() - index -1;
       if(numMoved > 0){
           //将数组i+1位置开始的numMoved个元素移动到数组i的位置
           //相当于将i位置上的元素删除，并将后面的元素向前移一位
           System.arraycopy(contents,index+1,contents,index,numMoved);
       }
       //将元素数目减一并释放原来最后一位的内存
       contents[--size] = null;
   }
   
   public E get(int index){
       //一旦要获取元素的位置为负或大于目前的元素数量就抛出异常
       //此处不允许index等于size
       if(index<0 || index>=size())
           throw new IndexOutOfBoundsException();
       return contents[index];
   }
   public void set(int index, E element){
       //一旦要获取元素的位置为负或大于目前的元素数量就抛出异常
       //此处不允许index等于size
       if(index<0 || index>=size())
           throw new IndexOutOfBoundsException();
       contents[index] = element;
   }
   public boolean contains(E element){
       if(element == null){
           for(int i=0;i<size();i++){
               if(contents[i] == null)
                   return true;
           }
           return false;
       }else{
           for(int i=0;i<size();i++){
               if(element.equals(contents[i]))
                   return true;
           }
           return false;
       }
   }
   public void printAll(){
		for(int i=0;i<size();i++){
			System.out.println(contents[i]);
		}
	}
}
