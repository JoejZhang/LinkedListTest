
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Random;

/**
 * CheckLinkedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 2, 2018</pre>
 */
public class CheckLinkedListTest {
    private Node listNull;//空链表
    private Node listCircle1;//有环链表1
    private Node listCircle2;//有环链表2
    private Node list1, list2;//单链表,两者不重合
    private Node list3, list4;//单链表,两者重合
    private Random r = new Random();

    @Before
    public void before() throws Exception {
        //在这个初始化链表，测试用例
        listNull = null;//空链表

        listCircle1  = getLinkedList(12);//listCircle1先初始化为一条链
        alistLastInsertBIndex(listCircle1, listCircle1,5);//listCircle1形成一个环
        listCircle2  = getLinkedList(14);
        alistLastInsertBIndex(listCircle2, listCircle2,6);//listCircle2形成一个环

        list1 = getLinkedList(10);//创建一条长度为10的链表
        list2 = getLinkedList(10);

        list3 = getLinkedList(10);
        list4 = getLinkedList(6);
        alistLastInsertBIndex(list4,list3,5);//list4链表插入list3中。使两条链表相交

    }

    //得到一条数据随机，指定长度的单链表
    private Node getLinkedList(int length) {
        if (length <= 0 || length > 100) {
            return null;//参数有误
        }
        Node node = new Node(r.nextInt(100));
        Node p = node; //指针
        for (int i = 0; i < length - 1; i++) {
            Node nextNode = new Node(r.nextInt(100));
            nextNode.data = r.nextInt(100);
            p.next = nextNode;
            p = nextNode;
        }
        return node;
    }

    public Node getLastNode(Node list) {
        Node nLast = list;
        while (nLast.next != null) {
            nLast = nLast.next;
        }
        return nLast;
    }

    //a链表末端插入b链表的某个位置
   private void alistLastInsertBIndex(Node a ,Node b ,int index){
       Node insertNode = b;
       for (int i = 0; i < index; i++) {
           insertNode = insertNode.next;
       }
       getLastNode(a).next = insertNode;//list4插入list3
   }

    @After
    public void after() throws Exception {

    }


    /**
     * Method: checkLinkedList(Node list1, Node list2)
     */
    @Test
    public void testCheckLinkedList() throws Exception {
        //两个空结点测试
        System.out.println("listNull 和 listNull 结果为" + CheckLinkedList.checkLinkedList(listNull, listNull));

        //两条成环链表测试
        System.out.println("listCircle1 和 listCircle2 结果为" + CheckLinkedList.checkLinkedList(listCircle1, listCircle2));

        //两条成环链表测试
        System.out.println("listCircle1 和 list1 结果为" + CheckLinkedList.checkLinkedList(listCircle1, list1));

        //一个链表，和空链表测试
        System.out.println("list1 和 listNull 结果为" + CheckLinkedList.checkLinkedList(list1, listNull));
        //两条不相交不成环的链表测试
        printList(list1);
        printList(list2);
        System.out.println("list1 和 list2 结果为" + CheckLinkedList.checkLinkedList(list1, list2));

        //两条相交不成环的链表测试
        printList(list3);
        printList(list4);
        System.out.print("list3 和 list4 结果为" + CheckLinkedList.checkLinkedList(list3, list4));

    }

    //打印无环链表
    private void printList(Node list) {
        System.out.print(list.data + " ");
        while (list.next != null) {
            list = list.next;
            System.out.print(list.data + " ");
        }
        System.out.print("\n");
    }


} 
