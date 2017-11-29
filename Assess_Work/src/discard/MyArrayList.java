package discard;

import java.util.ArrayList;

public class MyArrayList<E> {
	 //������MyArrayListʱ���粻ָ����С�����ʼ��СΪ10
   private static final int DEFAULT_CAPACITY = 10;
   private E[] contents;
   private int size = 0;

   //���ֹ��캯���������û�����ָ����С����Ĭ�ϴ�С�����Ա�
   public MyArrayList(){
       init(DEFAULT_CAPACITY);
   }
   public MyArrayList(int initCapacity){
       init(initCapacity);
   }
   //˽�л�����init�������캯������ʼ������contents
   private void init(int capacity){
       //ע�ⲻ�ܽ����������飬�������ǿ��ת��һ��Object����
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
           //��������Ԫ�ص�����ָ��null������GC�Ϳ��Ի����ڴ�
           contents[i] = null;
       }
       this.size = 0;
   }
   
   public boolean add(E element){
       if(size()>=contents.length){
           //һ���б��е�Ԫ�ظ�������������ĳ��ȣ����ǾͶ������������
           ensureCapacity();
       }
       //��Ԫ�ط������λ�ò���Ԫ����Ŀ��1
       contents[size++] = element;
       return true;

   }
   public void add(int index, E element){
       //һ��Ҫ����Ԫ�ص�λ��Ϊ�������Ŀǰ��Ԫ���������׳��쳣
       //�˴�����index����size���൱�����б�ĩβ����Ԫ��
   	if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
   	if(size()>=contents.length){
			ensureCapacity();
		}
       //��������ǰһ��Ԫ�ص�ֵ�����һ��Ԫ��
       for(int i=size();i>index;i--)
           contents[i] = contents[i-1];
       //��Ҫ�����Ԫ�طŵ�indexλ����
       contents[index] = element;
       this.size++;
   }
   private void ensureCapacity(){
       //�˴�������������Ǿ������2����1��������Լ�ѡ�����ݵĶ���
       E[] newContents = (E[]) new Object[2*contents.length+1];
       //���������е�ֵȫ��������������
       System.arraycopy(contents,0,newContents,0,size());
       //����contentsָ���µ�����
       contents = newContents;
   }
   
   public boolean remove(E element){
       if(element == null){
           for(int i=0;i<size();i++){
               if(contents[i] == null){
               //����ҵ�Ԫ��Ϊnull����ʹ��˽�з���fastRemove����λ��Ԫ��ɾ��
                   fastRemove(i);
                   return true;
               }
           }
           return false;
       }else{
           for(int i=0;i<size();i++){
               if(element.equals(contents)){
                   //����ҵ�Ԫ��Ϊelement����ʹ��˽�з���fastRemove����λ��Ԫ��ɾ��
                   fastRemove(i);
                   return true;
               }
           }
           return false;
       }
   }
   public void remove(int index){
       //һ��Ҫ����Ԫ�ص�λ��Ϊ�������Ŀǰ��Ԫ���������׳��쳣
       //�˴�������index����size
       if(index<0 || index>=size())
           throw new IndexOutOfBoundsException();
       fastRemove(index);
   }
   //˽�л�����ʵ��������߽��ֱ��ɾ��ĳһλ�õ�Ԫ��
   private void fastRemove(int index){
       //��Ҫ�Ӻ���ǰ�ƶ���Ԫ����Ŀ
       int numMoved = size() - index -1;
       if(numMoved > 0){
           //������i+1λ�ÿ�ʼ��numMoved��Ԫ���ƶ�������i��λ��
           //�൱�ڽ�iλ���ϵ�Ԫ��ɾ�������������Ԫ����ǰ��һλ
           System.arraycopy(contents,index+1,contents,index,numMoved);
       }
       //��Ԫ����Ŀ��һ���ͷ�ԭ�����һλ���ڴ�
       contents[--size] = null;
   }
   
   public E get(int index){
       //һ��Ҫ��ȡԪ�ص�λ��Ϊ�������Ŀǰ��Ԫ���������׳��쳣
       //�˴�������index����size
       if(index<0 || index>=size())
           throw new IndexOutOfBoundsException();
       return contents[index];
   }
   public void set(int index, E element){
       //һ��Ҫ��ȡԪ�ص�λ��Ϊ�������Ŀǰ��Ԫ���������׳��쳣
       //�˴�������index����size
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
