package datastructure;

public class Node {

	private String key;
	private int value;
	Node next;
	
	
	public Node(String key, int value) {
		this.key = key;
		this.setValue(value);
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
