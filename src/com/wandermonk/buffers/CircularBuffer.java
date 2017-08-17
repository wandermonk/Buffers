package com.wandermonk.buffers;

import java.nio.BufferOverflowException;

public class CircularBuffer {
	
	public static final int DEFAULT_SIZE = 10;
	int[] buffer;
	int head;
	int tail;
	
	public CircularBuffer(int size) {
		if(size == 0) {
			buffer = new int[DEFAULT_SIZE];
		}else {
		buffer = new int[size];
		}
		head = 0;
		tail = 0;
	}
	
	public void add(int element) {
		if(head != (tail -1)) {
			buffer[head++] = element;
		}else {
			throw new BufferOverflowException();
		}
		head = head % buffer.length;
	}
}
