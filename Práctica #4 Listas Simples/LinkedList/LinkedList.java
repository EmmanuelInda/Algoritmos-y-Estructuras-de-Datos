package LinkedList;

import java.util.Random;

public class LinkedList<T> {
	private Node<T> head;

	public LinkedList () {
		head = null;
	}

	public void insertFirst(T data) {
		Node<T> newNode = new Node<>(data);

		newNode.setNext(head);
		head = newNode;
	}

	public T deleteFirst() {
		if (head == null)
			return null;

		Node<T> temp = head;
		T data = temp.getData();

		head = head.getNext();

		return data;
	}

	public void insertLast(T data) {
		Node<T> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
		} else {
			Node<T> last = nodeAt(size() - 1);
			last.setNext(newNode);
		}
	}

	public T deleteLast() {
		if (head == null)
			return null;

		T data;

		if (head.getNext() == null) {
			data = head.getData();
			head = null;

			return data;
		}

		Node<T> nextToLast = nodeAt(size() - 2);
		Node<T> last = nodeAt(size() - 1);
		data = last.getData();

		nextToLast.setNext(null);

		return data;
	}

	public void insertAt(int pos, T data) {
		Node<T> newNode = new Node<>(data);

		if (pos == 0) {
			newNode.setNext(head);
			head = newNode;

			return;
		}

		Node<T> prev = nodeAt(pos - 1);

		newNode.setNext(prev.getNext());
		prev.setNext(newNode);
	}

	public T deleteAt(int pos) {
		T data;

		if (pos == 0) {
			data = head.getData();
			head = head.getNext();

			return data;
		}

		Node<T> current = nodeAt(pos);
		Node<T> prev = nodeAt(pos - 1);
		data = prev.getData();

		prev.setNext(current.getNext());

		return data;
	}

	public int size() {
		if (head == null)
			return 0;

		int i = 0;
		Node<T> temp = head;

		while (temp != null) {
			++i;
			temp = temp.getNext();
		}

		return i;
	}

	public void shuffle() {
		if (head == null || head.getNext() == null) return;

		Random rand = new Random();
		int size = size();

		for (int i = 0; i < size; ++i) {
			int swapIdx = rand.nextInt(size);

			Node<T> node1 = nodeAt(i);
			Node<T> node2 = nodeAt(swapIdx);

			T temp = node1.getData();
			node1.setData(node2.getData());
			node2.setData(temp);
		}

	}

	/*
	 *		Shell sort
	 */
	public void sort() {
		int n = size();

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; ++i) {
				T temp = nodeAt(i).getData();
				int j;
				for (j = i; j >= gap && ((Comparable<T>) nodeAt(j - gap).getData()).compareTo(temp) > 0; j -= gap) {
					nodeAt(j).setData(nodeAt(j - gap).getData());
				}
				nodeAt(j).setData(temp);
			}
		}
	}

	public T get(int pos) {
		Node<T> temp = nodeAt(pos);
		if (temp == null) return null;

		T data = temp.getData();

		return data;
	}

	@Override
	public String toString() {
		if (head == null)
			return "";

		StringBuilder sb = new StringBuilder();
		Node<T> temp = head;

		while (temp != null) {
			sb.append(temp.getData());

			if (temp.getNext() != null)
				sb.append(" ");

			temp = temp.getNext();
		}

		return sb.toString();
	}

	private Node<T> nodeAt(int pos) {
		if (head == null) return null;

		Node<T> temp = head;

		for (int i = 0; i < pos; ++i)
			temp = temp.getNext();

		return temp;
	}
}

