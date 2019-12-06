public class singleLinkList {

	private Node head;

	public void addhead(String obj){
		Node newhead = new Node(obj);
		if(head == null){
			head = newhead;
		}else {
			newhead.next = head;
			head = newhead;
		}
	}

	public void addend(String obj){
		Node newend = new Node(obj);
		if(head == null){
			head = newend;
		}else {
			Node current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = newend;
		}
	}

	public void delete(int type){
		if(type == 0){
			if(head != null){
				head = head.next;
			}
		}else if(type == -1){
			if (head != null){
				Node currentnode = head;
				Node previous = null;
				while (currentnode.next != null){
					previous = currentnode;
					currentnode = currentnode.next;
				}
				previous.next = null;
			}
		}
	}

	public void delete(){
		delete(0);
	}

	public void delete(Node obj){
		delete(0);
	}
	public void reverse(){
		if(head != null){
			Node previousNode = null;
			Node currentNode = head;
			Node nextNode;
			while(currentNode != null){
				nextNode = currentNode.next;
				currentNode.next = previousNode;
				previousNode = currentNode;
				currentNode = nextNode;
			}
			head = previousNode;
		}
	}

	public void display(){
		if(head != null){
			Node node = head;
			if(node.next == null){//当前链表只有一个节点
				System.out.println("["+node.data+"]");
				return;
			}
			while(node != null){
				if(node.equals(head)){
					System.out.print("["+node.data+"->");
					}else if(node.next == null){
					System.out.print(node.data+"]");
					}else{
					System.out.print(node.data+"->");
					}
				node = node.next;
			}
			System.out.println();
			}else{//如果链表一个节点都没有，直接打印[]
			 System.out.println("[]");
			}
		}

	public static void  main(String[] args){
		singleLinkList singleList = new singleLinkList();
		singleList.addend("A");
		singleList.addend("B");
		singleList.addend("C");
		singleList.addend("D");
		//打印当前链表信息
		singleList.display();
		//删除C
		singleList.reverse();
		singleList.display();
		singleList.delete();
		//查找B
		singleList.display();
//		System.out.println(singleList.find("B"));
	}
}
