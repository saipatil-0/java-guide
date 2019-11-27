/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saipati
 */

public interface QueueInterface<E>
{
	public void insert(E x); // inserts x at the rear of the queue
	public E remove(); // removes and returns the front item or returns null if the queue is empty
	public boolean isEmpty(); // returns true if no elements are in the queue
	public E peek(); // returns the front item, does not alter the queue or returns null if the queue is empty
	public int size(); //returns the number of items in the queue
}

