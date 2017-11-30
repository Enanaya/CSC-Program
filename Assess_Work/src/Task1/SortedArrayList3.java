package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import Task2.Clients;
import Task2.Event;

public class SortedArrayList<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7562457359071672548L;

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private static final Object[] EMPTY_ELEMENTDATA = {};

	private transient Object[] elementData;
	private int size;

	public SortedArrayList() {
		// TODO Auto-generated constructor stub
		this(10);
		// this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public SortedArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	// custom method:add event
	public boolean add(Event e) {
		ensureCapacityInternal(size + 1); // Increments modCount!!
		elementData[size++] = e;
		/*this.sort((Comparator<? super E>) new Comparator<Event>() {
			@Override
			public int compare(Event o1, Event o2) {
				// TODO Auto-generated method stub
				return o1.getName().substring(0, 1).compareToIgnoreCase(o2.getName().substring(0, 1));
			}

		});*/
		if (size()>1) {
		Arrays.sort(elementData,new com()); 
		}
		return true;
		
	}

	class com implements Comparator<Object>{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Event e1=(Event) o1;
			Event e2=(Event) o2;
			String str1=e1.getName().substring(0, 1);
			String str2=e2.getName().substring(0, 1);
			
//			int res=e1.getName().substring(0, 1).compareTo(e2.getName().substring(0, 1));
			int res=str1.compareTo(str2);
			return res;
		}
		
	}
	
	
	// custom method:add client
	@SuppressWarnings("unchecked")
	public boolean add(Clients c) {
		ensureCapacityInternal(size + 1); // Increments modCount!!
		elementData[size++] = c;
		this.sort((Comparator<? super E>) new Comparator<Clients>() {
			@Override
			public int compare(Clients o1, Clients o2) {
				// TODO Auto-generated method stub
				int res;
				String sur1 = ( o1.getSurname());
				String sur2 = ( o2.getSurname());
				res = sur1.substring(0, 1).compareToIgnoreCase(sur2.substring(0, 1));
				if (res == 0) {
					String fir1 = ((Clients) o1).getFirstname();
					String fir2 = ((Clients) o2).getFirstname();
					res = fir1.substring(0, 1).compareToIgnoreCase(fir2.substring(0, 1));
				}
				return res;
			}

		});
		return true;
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}

		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;

		// overflow-conscious code
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		// minCapacity is usually close to size, so this is a win:
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) // overflow
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		if (index<0||index==size()) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return (E) elementData[index];
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return  (Iterator<E>) new ArrayListIterator();
	}

    private class ArrayListIterator implements Iterator<E>{

        private int current = 0;

        //判断是否还有下一个数据
        public boolean hasNext() {
            return current<size();
        }

        //返回下一个数据
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return  (E) elementData[current++];
        }

        //移除刚才返回的下一个数据（next()返回的值）
        public void remove() {
            SortedArrayList.this.remove(--current);
        }

    }
   
}
