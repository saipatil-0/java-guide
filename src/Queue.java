/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saipati
 */
public class Queue <E>implements QueueInterface<E> 
{
	private E[] items; 
	private int numItems;// number of elements currently in the queue
	int front, rear; // holds the indices of the front and rear elements
	int maxQueue; // maximum capacity
	public Queue() // default constructor, sets maxQueue to 10 
	{
		items = (E[]) new Object[10]; // new E[10] is illegal; the cast is necessary
		numItems = 0;
		front = rear = -1;  // -ô°1 indicates that the queue is empty
		maxQueue = 10;
	}
	public Queue(int max) // one argument constructor, accepts maximum capacity
	{
		maxQueue = max;
		items = (E[]) new Object[maxQueue]; // new E[maxQueue] is illegal; the cast is necessary
		numItems = 0;
		front = rear = -1;
	}
	public void insert(E x)
	{
		// inserts x at the rear of the queue
		// if overflow occurs, issues a message and exits 
		if (numItems == maxQueue) // queue is full 
		{
			System.out.printf("Queue Overflow\n");
			System.exit(0); 
		}
		rear = (rear + 1) % maxQueue; // % maxQueue ensures wraparound
		items[rear] = x;
		numItems++;
		if (numItems == 1) // if queue was previously empty
			front = rear; 
	}
	public E remove()
	// removes and returns the first item in the queue 
	// if the queue is empty, returns null
	{
		if (numItems == 0) //Empty queue
			return null;
		E temp = items[front]; // holds the first item in the queue
		numItems--;
		if (numItems == 0) // if the queue is now empty set front and rear to â€“1
			front = rear = -1; 
		else
			front = (front + 1) % maxQueue; // %maxQueue ensures wraparound
		return temp;
	}
	public E peek()
	// returns the first item in the queue or null if the queue is empty
	// does not alter the queue
	{
		if (numItems == 0)
			return null;
		else
			return items[front];
	}
	public boolean isEmpty()
	// returns true if the queue is empty
	{
		return (numItems == 0);
	}
	public int size()
	// returns the number of items currently in the queue
	{
		return numItems;
	}
}

