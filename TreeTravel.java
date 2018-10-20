/*
 * 1191 : https://www.acmicpc.net/problem/1191
 */
 
 import java.util.Scanner;

public class TreeTravel {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		Tree tree = new Tree();

		for(int i=0; i<size; i++) {
			String s = scan.nextLine();
			String splited[] = s.split(" ");
			
			tree.add(splited[0].charAt(0), splited[1].charAt(0), splited[2].charAt(0));
		}
		
		tree.preorder(tree.getRoot());
		System.out.println();
		
		tree.inorder(tree.getRoot());
		System.out.println();
		
		tree.postorder(tree.getRoot());
		System.out.println();
	}

}

class Node {
	private char data;
	private Node left;
	private Node right;

	public Node(char data) {
		this.data = data;
		left = null;
		right = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getInstance() {
		return this;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}

class Tree {
	
	Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public void add(char data, char left, char right) {
		if(root==null) {
			root = new Node(data);
			if(left!='.') { root.setLeft(new Node(left)); }
			if(right!='.') { root.setRight(new Node(right)); }
		}
		else {
			searchPut(data, root, left, right);
		}
	}

	public Node searchPut(char data, Node node, char left, char right) {
		if(node.getData()==data) { 
			if(left!='.') { node.setLeft(new Node(left)); }
			if(right!='.') { node.setRight(new Node(right)); }
		}
		if(node.getLeft()!=null) 
			searchPut(data, node.getLeft(), left, right);
		if(node.getRight()!=null) 
			searchPut(data, node.getRight(), left, right);
		
		return null;
	}

	// 전위
	public void preorder(Node node) {
		System.out.print(node.getData());
		if (node.getLeft() != null)
			preorder(node.getLeft());
		if (node.getRight() != null)
			preorder(node.getRight());
	}

	// 중위
	public void inorder(Node node) {
		if (node.getLeft() != null)
			inorder(node.getLeft());
		System.out.print(node.getData());
		if (node.getRight() != null)
			inorder(node.getRight());
	}

	// 후위
	public void postorder(Node node) {
		if (node.getLeft() != null)
			postorder(node.getLeft());
		if (node.getRight() != null)
			postorder(node.getRight());
		System.out.print(node.getData());
	}

	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}

	
}
