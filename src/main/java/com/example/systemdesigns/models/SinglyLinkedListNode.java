package com.example.systemdesigns.models;

public class SinglyLinkedListNode {
	private int value;
	private SinglyLinkedListNode next;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public SinglyLinkedListNode getNext() {
		return next;
	}
	public void setNext(SinglyLinkedListNode next) {
		this.next = next;
	}
}
