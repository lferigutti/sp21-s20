package deque;

public class LinkedListDeque<T> {

    private class TNode {
        public T item;
        public  TNode prev;
        public TNode next;

        public TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    private TNode sentinel;
    private  int size;

    public LinkedListDeque(){
         sentinel = new TNode(null, null, null);
         sentinel.prev = sentinel;
         sentinel.next = sentinel;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(T item){
        sentinel.next = new TNode(item,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size +=1;
    }
    public void addLast(T item){
            sentinel.prev = new TNode(item,sentinel.prev,sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
    }
    public T removeFirst(){
        T item_to_remove = sentinel.next.item;
        if (item_to_remove !=null){
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
        }
        return item_to_remove;

    }
    public T removeLast(){
        T item_to_remove = sentinel.prev.item;
        if (item_to_remove !=null){
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
        }
        return item_to_remove;
    }

    public T get(int index){
       TNode node = sentinel.next;
       int i = 0;
        while (node.item != null){
            if(i == index){
                return node.item;
            }
            i += 1;
            node = node.next;
        }
        return null;
    }

    public T getRecursive(int index){
        TNode node = sentinel.next;
        int firstIndex = 0;
        return getRecursiveHelper(index,firstIndex,node);
    }

    private T getRecursiveHelper(int index, int currentIndex, TNode nodeToSearch){
        if(nodeToSearch.item == null){
            return null;
        } else if (currentIndex == index) {
            return nodeToSearch.item;
        } else {return getRecursiveHelper(index, currentIndex+1,nodeToSearch.next);
        }
    }
    public void printDeque(){
        TNode p = sentinel.next;
        while (p.item != null){
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
        System.out.println();
    }
}
