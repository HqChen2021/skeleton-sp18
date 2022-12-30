public class SLList {

    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public IntNode sentinel;;
    public int size;


    public SLList(int item){
        sentinel.next = new IntNode(item, null);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(1994, null);
        size = 0;
    }

    public void addFirst(int item) {
        sentinel.next = new IntNode(item, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return this.sentinel.next.item;
    }

    /* iterative way */
    public void addLast(int item) {

        IntNode ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new IntNode(item,null);
        size += 1;
    }

    /* recursive way */
    public void addLast_recursive(int item) {
        addLast_recursive(item, sentinel.next);
    }

    /* recursive way */
    public void addLast_recursive(int item, IntNode ptr) {
        if (ptr.next == null) {
            ptr.next = new IntNode(item, null);
            return;
        }
        else {
            ptr = ptr.next;
            addLast_recursive(item, ptr.next);
        }
    }

//    public static int size(IntNode p){
//        if (p.next==null){
//            return 1;
//        }
//        else {
//            return 1 + size(p.next);
//        }
//    }
//
//    public int size(){
//        return size(first);
//    }

}