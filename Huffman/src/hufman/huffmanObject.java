package hufman;

public class huffmanObject {

	private String nodeName ;  // Mban emrin e nyjes
	
	private int nodeWeght ;  // mban vleren nr.

	public huffmanObject(String nodeName, int nodeWeght) {
		super();
		this.nodeName = nodeName;
		this.nodeWeght = nodeWeght;
	}
	
	
	public huffmanObject( int nodeWeght) {
		super();
		this.nodeWeght = nodeWeght;
	}
	
	public huffmanObject(String nodeName ) {
		super();
		this.nodeName = nodeName;
		
	}


	public huffmanObject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNodeName() {
		return nodeName;
	}


	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}


	public int getNodeWeght() {
		return nodeWeght;
	}


	public void setNodeWeght(int nodeWeght) {
		this.nodeWeght = nodeWeght;
	}


	@Override
	public String toString() {
		return "huffmanObject [nodeName=" + nodeName + ", nodeWeght=" + nodeWeght + "]";
	}
	
	
	
}
