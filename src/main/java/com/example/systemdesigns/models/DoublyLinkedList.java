package com.example.systemdesigns.models;

public class DoublyLinkedList {
	
	public class Node{
		private int value;
		private Node prev;
		private Node next;
		
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public Node getPrev() {
			return prev;
		}
		public void setValue(int value) {
			this.value=value;
		}
		public int getValue() {
			return value;
		}
	}
	
	private Node firstNode = null;
	private Node lastNode = null;
	
	public Node buildDoublyLinkedList(int[] values) {
		for(int i=0;i< values.length; i++) {
			Node currNode = new Node();
			currNode.setValue(values[i]);
			if(i==0) {
				currNode.setPrev(null);
				currNode.setNext(null);
				firstNode = currNode;
			}else {
				currNode.setPrev(lastNode);
				lastNode.setNext(currNode);
				currNode.setNext(null);
			}
			lastNode = currNode;
		}
		return firstNode;
	}
	
	public void removeLeastRecentlyUsedNode() {
		if(lastNode != null) {
			Node prevNode = lastNode.getPrev();
			prevNode.setNext(null);
			lastNode = prevNode;
		}
	}
	
	public void addNode(Node node) {
		if(node != null) {
			node.setNext(firstNode);
			node.setPrev(null);
			firstNode.setPrev(node);
			firstNode = node;
		}
	}
	
	public void shiftNodeToFirstPosition(Node node) {
		if(node !=null) {
			Node prevNode = node.getPrev();
			Node nextNode = node.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
			node.setNext(null);
			node.setPrev(null);
			addNode(node);
		}
	}
	
	public void printNodes(Node node) {
		StringBuilder llBuilder = new StringBuilder();
		while(node != null) {
			llBuilder.append(null!= node.getPrev() ? node.getPrev().getValue() : null);
			llBuilder.append(" -> ");
			if(node.getNext() == null) {
				llBuilder.append(node.getValue());
			}
			node = node.getNext();
		}
		System.out.println(llBuilder.toString());
	}

}
