import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class Heap {
	
	

	private int size=0;
	private int[] heap;
	
	public Heap(int capacity){
		heap=new int[capacity];
		Map<Integer, Integer>a=null;
		a.remove(key);
	}
	
	public boolean insert(int element){
		if(size==heap.length-1){
			throw new NoSuchElementException("not found");
		}
		else {
			heap[size++]=element;
			refactor(size-1);
		}
		return false;
	}
	private void refactor(int size){
		while(heap[size]<heap[size/2]){
			//dologic
			size/=2;
		}
	}
	private boolean delete(){
		Stack<String> s=new Stack<String>();
		s.pop();
		Queue<String> q=new Queue<String>() {

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(String e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String remove() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String peek() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return false;
		
	}
	
	
	
}
