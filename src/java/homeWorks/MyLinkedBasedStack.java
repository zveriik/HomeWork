package homeWorks;

public class MyLinkedBasedStack<T> {

	private static class Node <T>{
		T item;
		Node previous;
		public Node(final T item, final Node previous) {
			this.item = item;
			this.previous = previous;
		}
	}

	private Node entry;
    private int capacity;

	public void push(final T item) {
		Node tmp = new Node(item, entry);
        entry = tmp;
        capacity++;
	}

    public T pop() {
        try{
            T item = (T) entry.item;
            entry = entry.previous;
            capacity--;
            return item;
        } catch (Exception e){
            System.out.println("Stack empty");
            return null;
        }
    }

    public T top() {
        try{
            T item = (T) entry.item;
            return item;
        } catch (Exception e){
            System.out.println("Stack empty");
            return null;
        }
    }

    public int length(){
        return capacity;
    }

}
