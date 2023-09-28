import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Node node = new Node(n);
		String s;
		while ((s = br.readLine()) != null) {
			n = Integer.parseInt(s);
			node = InsertNode(node, n);
		}
		
		PostOrder(node);
	}

	private static Node InsertNode(Node node, int n) {
		Node newNode = null;
		if (node == null) 	return new Node(n);

		if (node.value > n) { // 기준 노드보다 삽입 노드의 숫자가 작은 경우 왼쪽
			newNode = InsertNode(node.left, n);
			node.left = newNode;
		} 
		else { // 반대면 오른쪽
			newNode = InsertNode(node.right, n);
			node.right = newNode;
		}
		
		return node;
	}

	private static void PostOrder(Node node) {  //왼쪽 오른쪽 루트 후위 순회
		if (node != null) {
			PostOrder(node.left);
			PostOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	private static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}

	}
}