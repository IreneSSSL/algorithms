package easy.linkedList;

public class RemoveDuplicatedSortedList83 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        String s = "se";
        String[] ss = s.split("s");
        System.out.println(s.trim().length());
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return head;}
        if (head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            while (second !=null && first.val == second.val){
                ListNode tmp = second.next;
                first.next = tmp;
                second = tmp;
            }
            first = first.next;
            if (first == null) break;
            second = first.next;
        }
        return head;
    }
}
