package us.bingh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MicrosoftOnline {

//60 minute time limit:
//
//    a) recursively reverse a string.
//
//    b) print a number vertically with each digit on its own line, without converting to a string.
//            eg. 12345 becomes:
//            1
//            2
//            3
//            4
//            5
//            (note you can do this problem just fine without needing a list or recursive stack...)
//
//    c) remove all prime numbers from a linked list. (no mention of how large numbers could be)


    public static void main(String[] args) {
        // --------------------- reverse string
//        String str = "hellouworld";
//        str = reverse1(str);
//        System.out.println(str);
//        ------------------------ print int number without string
//        printNumberVerticallyWithoutStr(12394);
        //        ------------------------ reverseLinkList
//        ReverseLinkList.Node result = ReverseLinkList.buildLinklist();
//        result = ReverseLinkList.recursiveReverseList(result);
//        while (result != null) {
//            System.out.println(result.value);
//            result = result.next;
//        }

        //        ------------------------ remove prime number
        RemovePrimeNumber.Node result = RemovePrimeNumber.buildNodeList();

        RemovePrimeNumber.removePrimeNumber(result);
        while (result != null && result.next != null) {
            System.out.println(result.value);
            result = result.next;
        }
//        while (result != null && result.prev!=null) {
//            System.out.println(result.value);
//            result = result.prev;
//        }

    }

    /**
     *
     */
    static class ReverseStr {
        static String reverse(String str) {
            int len = str.length();
            char[] charArray = new char[len];
            for (int i = 0; i < (len + 1) / 2; i++) {
                charArray[i] = str.charAt(len - i - 1);
                charArray[len - i - 1] = str.charAt(i);
            }
            return new String(charArray);
        }

        static String reverse1(String str) {
            char[] array = str.toCharArray();
            int swapA = 0;
            int len = array.length;

            recursivelyReverse(array, swapA, len);


            return new String(array);
        }

        private static void recursivelyReverse(char[] array, int swapA, int len) {
            char temp = array[swapA];
            array[swapA] = array[len - 1 - swapA];
            array[len - 1 - swapA] = temp;
            ++swapA;
            if (swapA < (len) / 2) {
                recursivelyReverse(array, swapA, len);
            }
        }

    }

    /**
     *
     */
    static class PrintIntNumber {
        static void printNumberVerticallyWithStr(int number) {
            String str = number + "";
            for (int i = 0; i < str.length(); i++) {
                System.out.println(str.charAt(i));
            }
        }

        static void printNumberVerticallyWithoutStr(int number) {
            List<Character> list = new ArrayList<Character>();

            while (number > 0) {
                list.add((char) (number % 10));
                number = number / 10;
            }

            for (int i = list.size() - 1; i >= 0; --i) {
                System.out.println(Integer.valueOf(list.get(i)));
            }

        }

    }

    /**
     *
     */
    static class RemovePrimeNumber {

        static Node buildNodeList() {
            int count = 20;
            Node preN = null;
            Node head = null;
            while (count >= 0) {

                Node node = new Node(count);
                if (head == null) {
                    head = node;
                }
                node.prev = preN;
                if (node.prev != null) {
                    node.prev.next = node;
                }
                preN = node;
                --count;
            }

            return head;

        }

        static void removePrimeNumber(Node head) {
            if (head == null) {
                return;
            }

            boolean primeNumber = isPrimeNumber(head.value);
            if (primeNumber) {
                head.prev.next = head.next;
                head.next.prev = head.prev;
            }
            removePrimeNumber(head.next);
        }

        static boolean isPrimeNumber(long n) {
            if (n <= 3) {
                return n > 1;
            }
            if (n % 6 != 1 && n % 6 != 5) {
                return false;
            }
            long sqrt = (long) Math.sqrt(n);
            for (int i = 5; i <= sqrt; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }

        static class Node {
            Node prev;
            Node next;
            int value;


            Node(int value) {
                this.value = value;
            }

        }

    }


    /**
     * 单链表反转
     */
    static class ReverseLinkList {

        static class Node {
            Node next;
            int value;

            Node(int value) {
                this.value = value;
            }
        }

        static Node buildLinklist() {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = null;

            return node1;
        }

        static Node reverseList(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            Node newHead = null;
            while (head != null) {
                Node temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }
            return newHead;
        }

        static Node recursiveReverseList(Node head) {

            if (head == null || head.next == null) {
                return head;
            }

            Node newHead = recursiveReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    }
}
