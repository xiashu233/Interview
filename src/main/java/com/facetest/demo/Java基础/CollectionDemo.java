package com.facetest.demo.Java基础;

/**
 * 集合中的各个元素以及其数据结构实现
 */
public class CollectionDemo {
    public static void main(String[] args) {
        /**
         * <b>Collection</b>
         * 1.List
         *  <ul>
         *      <li>ArrayList:Object数组</li>
         *      <li>Vector:Object数组</li>
         *      <li>LinkedList:双向链表（JDK1.6之前为循环链表，之后取消了循环）</li>
         *  </ul>
         * 2.Set
         *  <ul>
         *    <li>HashSet（无序、唯一）:基于HashMap，底层使用HashMap保存数据</li>
         *    <li>LinkedHashSet:继承于HashSet，底层使用LinkedHashMap实现</li>
         *    <li>TreeSet（有序、唯一）:红黑树，自平衡的二叉树</li>
         *  </ul>
         *
         * <b>Map</b>
         *
         * 1.HashMap：JDK1.8之前使用数组加链表实现，JDK1.8之后使用数组加链表或红黑树（链表存储数据超过阈值 8，自动转化为红黑树）
         *
         * 2.LinkedHashMap：继承于HashMap，在原有的数组加链表或红黑树基础上增加了一条双向链表，所以可以保持键值对的插入顺序
         *
         * 3.HashTable：数组加链表
         *
         * 4.TreeMap：红黑树（自平衡的排序二叉树）
         */
    }
}
