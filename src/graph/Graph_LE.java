package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import linearEstructures.List;
import linearEstructures.Node;
import linearEstructures.Queue;
import linearEstructures.Stack;

public class Graph_LE implements Node{
	
	private int Data;
	
	int label;
	Node next;
	List nodes = new List();
	boolean visited = false;
	
	Node MostImportant=null;

	public Graph_LE(int Data, int label) {
		this.Data = Data;
		this.label = label;
	}
	public Graph_LE() {
		
	}

	
	public void insert_node() {
		nodes.insertAtEnd(next);
	}

	public void delete_node() {
		Graph_LE search = new Graph_LE(0, label);
		for (int i = 0; i < nodes.length(); i++)
			if (nodes.get(i).isEqual(search)) {
				nodes.deleteAtIndex(i);
				break;
			}

	}

	public void insert_edge(int label1, int label2) {
		Graph_LE search = new Graph_LE(0, label1);
		for (int i = 0; i < nodes.length(); i++)
			if (nodes.get(i).isEqual(search)) {
				nodes.get(i).edges.insertAtEnd(search);
				break;
			}

		search = new Graph_LE(0, label2);
		for (int i = 0; i < nodes.length(); i++)
			if (nodes.get(i).isEqual(search)) {
				nodes.get(i).edges.insertAtEnd(search);
				break;
			}

	}

	public boolean if_exists(int label) {
		Graph_LE search = new Graph_LE(0, label);
		for (int i = 0; i < nodes.length(); i++)
			if (nodes.get(i).isEqual(search)) {
				return true;
			}
		return false;
	}

	public List getNodes() {
		return nodes;
	}

	public void setNodes(List node) {
		this.nodes = node;
	}
    
	// this method implement with bfs
	public void MostImportant() {
		this.MostImportant=nodes.get(0);
		for (int i = 0; i < nodes.lenght; i++) {
			if(numberEdges(MostImportant)<numberEdges(nodes.get(i))){
			this.MostImportant=nodes.get(i);	
			}
		}
		

		
	}
	public static void main(String[] args) {

		Graph_LE graph = new Graph_LE();
		try {
			FileReader fr = new FileReader("google.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line =br.readLine();
			String[] record=null;
			while(line != null) {
				record = line.split(" ");
				graph.insert_edge(Integer.parseInt(record[0]),Integer.parseInt(record[1]));
				line =br.readLine();
				br.close();
			}			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		graph.MostImportant();
		System.out.println(graph.MostImportant);
	}

	@Override
	public void setNext(Node node) {
		next = (Graph_LE) node;
	}

	@Override
	public Node getNext() {
		return next;
	}

	@Override
	public Node clone() {
		return new Graph_LE(this.getData(), Data);
	}

	@Override
	public boolean isEqual(Node node) {
		Graph_LE temp = (Graph_LE) node;
		return this.getData() == temp.getData() ? true : false;
	}

	@Override
	public boolean isLessThan(Node node) {
		Graph_LE temp = (Graph_LE) node;
		return this.getData() < temp.getData() ? true : false;
	}

	int getData() {
		return Data;
	}

	void setData(int data) {
		Data = data;
	}
	@Override
	public int numberEdges(Node node) {
		int cont=0;
		Graph_LE temp=(Graph_LE)node;
		for (int i = 0; i < temp.nodes.edges.length(); i++) {
			cont++;
		}
		
		// TODO Auto-generated method stub
		return cont;
	}


}