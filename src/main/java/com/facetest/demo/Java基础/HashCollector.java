package com.facetest.demo.Java基础;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 集合中的 Hash 关联的集合类型
 */
public class HashCollector {
    public  static void main(String[] args) {
        // HashMap 和 HashTable 一样都是一个 KV 结构的 Map
        // 但是 HashMap 是非线程安全的 HashTable 在操作方法上都加上了 synchronized 关键字来保证线程安全
        // 所以在效率上 HashMap > HashTable

        // HashMap 的底层实现
        // JDK1.8之前使用数组+链表实现
        // 计算Key的hashcode，经过扰动函数获得hash值，得到存储位置。
        // 与存储位置中的元素进行比较，如果元素相等则覆盖，如果不相等则追加到链表后面
        // JDK1.8之后使用数组+链表或红黑树（链表长度超过阀值的时候自动转化为红黑树 默认为8）提高查询速度
        Map<String,Object> hashMap = new HashMap();
        Map<String,Object> hashtable = new Hashtable();
        // 关于 KV 存储键值 范围
        hashMap.put(null,null);
        // 此处虽然编译器不会明显报错 但是在运行的时候 就会报错 空指针
        // Exception in thread "main" java.lang.NullPointerException
        // hashtable.put(null,null);
        // Exception in thread "main" java.lang.NullPointerException
        // 所以 HashTable KV都不支持为 Null 所以我们不推荐使用 HashTable 存储数据
        // hashtable.put("null",null);
        // 随着 JUC 包的出现 HashMap 有了随之对应的线程安全类 ConcurrentHashMap
        // 能保证在不太消耗性能的情况下保持线程同步 不支持 KV 为 Null

        // ConcurrentHashMap 和 HashTable 的区别
        // ConcurrentHashMap
        // 在JDK1.7 的时候两者底层数据结构都是使用 数组+链表
        // 在JDK1.8 的时候ConcurrentHashMap 和 HashMap 的数据结构都改成了 数组+链表或红黑树
        // JDK1.7的时候 ConcurrentHashMap使用分段锁，对整个桶数组进行分割分段（Segment），每一个锁控制一段，
        // 多线程情况下访问多段数据的时候不会发生锁竞争，提高了并发访问率。
        // JDK1.8的时候抛弃了 Segment 概念，并发控制使用 synchronized和CAS操作

        // HashTable 共用同一把锁，使用synchronize来保证线程同步，当一个线程访问同步方法时其他线程访问时陷入堵塞。
        // 如使用 put 添加元素，另一个元素不能使用 put 添加元素，且不能使用 get 获取元素
        Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null,null);

        // 关于扩容
        // HashTable 默认大小为 11 扩容为 2n+1 当指定初始化大小的时候 HashTable 就会使默认大小为设置的
        Map<String,Object> hashtable2 = new Hashtable(2);
        // HashMap 默认大小为 16 扩容为 2n 当指定默认初始化大小的时候 HashMap 会将其扩充为2的指数幂
        Map<String,Object> hashMap2 = new HashMap(2);

        // HashMap 和 HashSet 的区别
        // HashMap 实现了 Map 接口、HashSet 实现了 Set 接口。
        // HashMap 存储 KV 键值对、HashSet 仅存储对象
        // HashMap 计算 k 的 hashcode、HashSet 计算 对象的 hashcode
        // HashSet 中维护了一个 HashMap 来存储数据 其中大多数方法都是直接调用 HashMap的方法进行操作
        // 比如 public boolean add(E e) { return map.put(e, PRESENT)==null; }
        Set<String> set = new HashSet<>();
        set.add("abc");

        // HashSet 判断去重
        // 当HashSet加入对象时，首先计算放入对象的 hashcode 如果没有出现冲突，则判断该对象没有出现过，则插入成功。
        // 如果出现了 hashcode 冲突，则 使用 equals 方法比较对象是否相等，相等则插入失败，不相等则重新散列 hashcode 重复此操作

    }
}
