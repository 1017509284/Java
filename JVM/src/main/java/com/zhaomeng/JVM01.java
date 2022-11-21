package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/11/13 17:35
 */

/**
 * ? java开发的程序效率相对C/C++较低的原因之一：java有垃圾回收器
 *
 * ? 如何发现垃圾
 * ? 1. 引用计数（Reference Count），当堆空间中的对象的引用计数变为0的时候，那么这个对象就是垃圾（无法解决循环引用的问题）
 * ? 2. 根可达算法（java采用，Root Searching）从栈空间的对象开始向堆中的指向的对象进行探索，如果能探索到的，那就不是垃圾，反之就是垃圾
 * ?    什么是根？JVM stack, native method stack, run-time constant pool, static references in method area, Clazz
 *
 * ? 常用的GC算法
 * ? 1. MArk-Sweep  标记清除
 * ?      缺点：碎片化严重
 * ? 2. Copying 拷贝
 * ? Mark-Compact 标记压缩
 * ?      缺点：效率较低
 *
 *  ? 垃圾回收器的演化(随着内存大小的不断)
 *  年轻代：Serial，ParNew，Parallel Scavenge
 *  老年代：Serial Old，CMS，Parallel Old
 *
 *  常用配合：
 *  Serial + Serial Old
 *  Parallel Scavenge + Parallel Old
 *  ParNew + CMS
 *
 *  Serial : a stop-the-world, copying collector which uses a single GC thread
 *  ParNew : Concurrent GC
 *  Parallel Scavenge : 在serial的基础上，变成了多线程清理垃圾
 *  CMS : Concurrent GC，工作在老年代
 *  Serial Old : a stop-the-world, mark-sweep-compact collector that uses a single GC thread
 *  Parallel Old : 在serial的基础上，变成了多线程清理垃圾
 *  G1 : 替代CMS
 *  ZGC
 *  Shenandoah
 *  Epsilon
 *
 */
public class JVM01 {
}
