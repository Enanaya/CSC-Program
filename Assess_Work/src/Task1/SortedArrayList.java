package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import Task2.Client;
import Task2.Event;

public class SortedArrayList<E extends Comparable<E>> extends ArrayList<E> {

	public boolean add(E e) {
		// TODO Auto-generated method stub
		if (size() == 0) {
			add(0, e);
			return true;
		} else {
			add(size(), e);
//			E value = e;
			// int x = 0;
			for (int x = size() - 1; x > 0; x--) {
				for (int y = x - 1; y >= 0; y--) {
					if (get(x).compareTo(get(y)) < 0) {
//						set(x, get(y));
//						set(y, e);
//						break;
						E temp=get(x);
						set(x, get(y));
						set(y, temp);
					}
				}
			}
			// add(x, value);
			return true;
		}
	}
}
