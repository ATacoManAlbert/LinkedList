
public class LinkedList
{
    Node tail, head;
    int size;
    public LinkedList()
    {
        tail = new Node(null, null);
        head = new Node(null, null);
        head.next = tail;
        tail.prev = head;
        int size = 0;
    }

    public void setNext(Node beforeNode, Node midNode)
    {
        if(beforeNode != tail && midNode.prev == null && midNode.next == null)
        {
            Node afterNode = beforeNode.next;
            beforeNode.next = midNode;
            afterNode.prev = midNode;
            midNode.next = afterNode;
            midNode.prev = beforeNode;
            size++;
        }
        else
        {
            System.out.println("Could Not Set Next Node Because:");
            if(beforeNode == tail){System.out.println("You Cannot Set A Node After The Tail");}
            if(midNode.prev != null){System.out.println("The Node To Be Set Has A Previous Node, Must Be A Blank Node");}
            if(midNode.next != null){System.out.println("The Node To Be Set Has A Next Node, Must Be A Blank Node");}
        }
    }

    public void setPrev(Node afterNode, Node midNode)
    {
        if(afterNode != head)
        {
            setNext(afterNode.prev, midNode);
        }
        else
        {
            System.out.println("Could Not Set Previous Node Because You Cannot Set A Node Before The Head");
        }
    }

    public void setFirst(Node midNode)
    {
        setNext(head, midNode);
    }

    public void setLast(Node midNode)
    {
        setPrev(tail.prev, midNode);
    }

    public void setAfterPos(int pos, Node midNode)
    {
        Node beforeNode = head;
        if(pos>=0 && pos<size)
        {
            for(int i = 0; i<pos; i++)
            {
                beforeNode = beforeNode.next;
            }
            setNext(beforeNode, midNode);
        }
        else
        {
            System.out.println("Could Not Set Node Because That Position Is Out Of Bounds");
        }
    }

    public void setBeforePos(int pos, Node midNode)
    {
        setAfterPos(pos-1, midNode);
    }

    public void removeNode(Node midNode)
    {
        if(midNode != head && midNode != tail)
        {
            Node beforeNode = midNode.prev;
            Node afterNode = midNode.next;
            beforeNode.next = afterNode;
            afterNode.prev = beforeNode;
            midNode.next = null;
            midNode.prev = null;
            size--;
        }
        else
        {
            System.out.println("Could Not Remove Node Because:");
            if(midNode == head){System.out.println("You Cannot Remove The Head");}
            if(midNode == tail){System.out.println("You Cannot Remove The Tail");}
        }
    }

    public void removeNext(Node beforeNode)
    {
        if(beforeNode.next != tail)
        {
            removeNode(beforeNode.next);
        }
        else
        {
            System.out.println("Could Not Remove Node Because You Cannot Remove The Tail");
        }
    }

    public void removePrev(Node afterNode)
    {
        if(afterNode.prev != head)
        {
            removeNode(afterNode.prev);
        }
        else
        {
            System.out.println("Could Not Remove Node Because You Cannot Remove The Head");
        }
    }

    public void removeFirst()
    {
        removeNode(head.next);
    }

    public void removeLast()
    {
        removeNode(tail.prev);
    }

    public void removeAtPos(int pos)
    {
        Node midNode = head;
        if(pos>=0 && pos<size)
        {
            for(int i = 0; i<pos; i++)
            {
                midNode = midNode.next;
            }
            removeNode(midNode);
        }        
        else
        {
            System.out.println("Could Not Remove Node Because That Position Is Out Of Bounds");
        }
    }

    public void removeAfterPos(int pos)
    {
        removeAtPos(pos+1);
    }

    public void removeBeforePos(int pos)
    {
        removeAtPos(pos-1);
    }

}
