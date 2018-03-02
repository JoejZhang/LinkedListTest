public class CheckLinkedList {
    public  static String checkLinkedList (Node list1 , Node list2){
        //其中一条为空链
        if(list1 == null || list2 == null){
            return "其中至少有一条空链，不会有交点";
        }
        Node node1 = isACircle(list1);//检查是否有环
        Node node2 = isACircle(list2);//检查是否有环

        if(node1 == null && node2 == null){
            //两条链表都有环
            return "检测到两条有环的链表，算法暂时不支持计算";
        }
        else if (node1 == node2){
            //两条链表无环且最后的结点为同一结点
            return "两条链表有交点";
        }
        else{
            //包括一条有环，一条无环的情况,还有两条无环不相交情况
            return "两条链表无交点";
        }

    }

    //检查是否有环，有环返回null，无环返回最后一个结点
    private static Node isACircle(Node list){

        if(list.next == null){//只有一个结点
            return list;
        }
        //定义两个指针 p1 ,p2 用于检测是否有环
        Node p1 = list;
        Node p2 = list.next;

        while(true){
            if(p1 == p2) {
                return null;//当两个指针相遇，则存在环
            }

            p1 = p1.next;  //p1移动一个
            if(p2.next == null){
                return p2;//如果p2没有下一个结点，返回最后的一个结点
            }

            p2 = p2.next;//p2移动一个
            if(p2.next == null){
                return p2;//如果p2没有下一个结点，返回最后的一个结点
            }
            p2 = p2.next;//p2再移动一个

        }
    }
}
