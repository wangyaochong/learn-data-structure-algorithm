package leetcode.byNumber.p200;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p146_LRU {
      @Test
    public void test() {
        // 返回 4
    }

    public static void main(String[] args) {
        p146_LRU cache = new p146_LRU(2);
        cache.put(1, 1); // 缓存是 {1=1}
        cache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(cache.get(1));    // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(cache.get(2));    // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(cache.get(1));    // 返回 -1 (未找到)
        System.out.println(cache.get(3));    // 返回 3
        System.out.println(cache.get(4));
    }

    static class Node {
        Node pre;
        Node next;
        Integer key;
        Integer value;
    }

    Map<Integer, Node> map = new HashMap<>();

    int maxCapacity;
    int currentCapacity;
    Node head = new Node();
    Node tail = new Node();




    public p146_LRU(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            makeRecent(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (currentCapacity == maxCapacity) {
                Node pre = tail.pre;
                map.remove(pre.key);

                tail.pre = pre.pre;
                pre.pre.next = tail;

                pre.next = null;
                pre.pre = null;//移除元素
                currentCapacity--;
            }
            currentCapacity++;
            Node tmp = new Node();
            tmp.value = value;
            tmp.key = key;
            Node next = head.next;
            next.pre = tmp;
            head.next = tmp;

            tmp.pre = head;
            tmp.next = next;
            map.put(key, tmp);
        } else {
            node.value = value;
            makeRecent(node);
        }
    }

    private void makeRecent(Node node) {
        Node breakNext = node.next;   //连接上
        Node breakPre = node.pre;
        breakPre.next = breakNext;
        breakNext.pre = breakPre;
        Node headNext = head.next;
        headNext.pre = node;
        head.next = node;
        node.next = headNext;
        node.pre = head;
    }
}
