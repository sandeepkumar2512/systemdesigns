package com.example.systemdesigns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.systemdesigns.models.SinglyLinkedListNode;
import com.example.systemdesigns.models.TreeNode;

@RestController
@RequestMapping("/data/structure/general")
public class DataStructureGeneralController {

	@GetMapping("/reverse-singly-linked-list")
	public void reverseSinglyLinkedList() {
		int[] arr = {2,4,6,9,1,0,11,3,42,5};
		SinglyLinkedListNode sll = buildSinglyLinkedList(arr);
		printSLL(sll);
		SinglyLinkedListNode reversedSll = reverseSll(sll);
		printSLL(reversedSll);
	}
	
	@GetMapping("/swap-numbers")
	public void swapNumbers() {
		int x = 10;
		int y = -5;
		System.out.println("before swap x="+x + ", y="+y);
		x = x+y;//5
		y = x-y;//10
		x = x-y;//-5
		System.out.println("after swap x="+x + ", y="+y);
	}
	
	@GetMapping("/mirror-image-of-bst")
	public void mirrorImageOfTree() {
		int[] arr = {2,4,6,9,1,0,11,3,42,5};
		TreeNode root = buildBST(arr);
		mirrorImageBST(root);
		printTreeNode(root);
	}

	private void printTreeNode(TreeNode root) {
		if(root == null) return;
		printTreeNode(root.getLeft());
		System.out.println(root.getValue());
		printTreeNode(root.getRight());
	}

	private void mirrorImageBST(TreeNode root) {
		if(root == null) {
			return;
		}
		root.setLeft(root.getRight());
		root.setRight(root.getLeft());
		mirrorImageBST(root.getRight());
		mirrorImageBST(root.getLeft());
	}

	private TreeNode buildBST(int[] arr) {
		TreeNode root = new TreeNode();
		return root;
	}

	private SinglyLinkedListNode reverseSll(SinglyLinkedListNode node) {
		SinglyLinkedListNode node1 = null;
		SinglyLinkedListNode node2 = node;
		
		while(node != null) {
			node2 = node.getNext();
			node.setNext(node1);
			node1 = node;
			if(node2==null) {
				break;
			}
			node = node2;
		}
		
		return node;
	}

	private SinglyLinkedListNode buildSinglyLinkedList(int[] arr) {
		SinglyLinkedListNode firstNode = null;
		SinglyLinkedListNode lastNode = null;
		for(int i=0;i<arr.length; i++) {
			SinglyLinkedListNode node = new SinglyLinkedListNode();
			node.setValue(arr[i]);
			node.setNext(null);
			if(i==0) {
				firstNode = node;
			}else {
				lastNode.setNext(node);
			}
			lastNode = node;
		}
		return firstNode;
	}
	
	private void printSLL(SinglyLinkedListNode node) {
		while(node!=null) {
			System.out.print(node.getValue() + "->");
			node = node.getNext();
		}
		System.out.println("\n");
	}
}
