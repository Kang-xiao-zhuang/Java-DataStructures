# 线性表

## 1. 线性表的定义

线性表（List）：零个或多个数据元素的有限序列



首先它是一个序列。也就是说，元素之间是有顺序的，若元素存在多个，则第一个元素无前驱，最后一个元素无后继，其他每个元素都有且只有一个前驱和后继

若将线性表记为（a ~1~  ，…，a ~i-1~ ，a~i~，a~i+1~ ，…，a~n~ ），则表中a~i-1~领先于a~i~，a~i+1~领先于a~i~ ，称a~i-1~是a~i~的直接前驱元素，a~i+1~是a~i~的直接后继元素。

当i=1，2，…，n-1时，a~i~有且仅有一个直接后继，当i=2,3，…，n时，a~i~有且仅有一个直接前驱。

![在这里插入图片描述](https://img-blog.csdnimg.cn/a7ba8a12112747348afb556de0940748.png)



所以线性表元素的个数n（n≥0）定义为线性表的长度，当n=0时，称为==空表==



在非空表中的每个数据元素都有一个确定的位置，如a~1~是第一个数据元素，a~n~是最后一个数据元素，a~i~是第i个数据元素，称i为数据元素a~i~在线性表中的位序



## 2. 线性表的顺序存储结构

### 2.1 顺序存储定义

线性表的顺序存储结构，指的是用一段==地址连续的存储单元==依次存储线性表的数据元素。



线性表（a~1~ ,a~2~ ,......,a~n~）的顺序存储示意图

![在这里插入图片描述](https://img-blog.csdnimg.cn/94805ec14cd640cf8f000f1a1843e0fb.png)



顺序存储结构需要三个属性：

1. 存储空间的起始位置：数组data，它的存储位置就是存储空间的存储位置
2. 线性表的最大存储容量：数组长度MaxSize
3. 线性表的当前长度：length

## 3. Java设计实现顺序表操作

首先我们设计一个`List`接口，自定义的顺序表去实现接口

```java
/**
 * 
 * @ClassName: List
 * @Description:List接口
 * @author: KangXiaoZhuang
 * @date: 2022年11月7日 下午10:55:39
 */
public interface List<E> {
	void clear();

	void ensureCapacity(int newCapacity);

	int size();

	boolean isEmpty();

	void trimToSize();

	E get(int index);

	int indexOf(E element);

	boolean contains(E element);

	E set(int index, E newElement);

	boolean add(E addElement);

	void add(int index, E addElement);

	E remove(int index);
}
```



在实现MyArrayList之前，先概括主要的细节

1. MyArrayList保持基础数组，数组的容量，以及存储在MyArrayList中的当前项数。
2. MyArrayList提供一种机制改变基础数组的容量。通过获得一个新数组，将老数组拷贝到新数组来改变数组的容量。
3. MyArrayList将提供get和set的实现。
4. MyArrayList将提供基本的方法，如 size，isEmpty，clear等。还提供remove，以及两种版本的add，如果数组的大小和容量相同，add方法会扩容。
5. MyArrayList将实现一个Iterator接口的类。这个类将存储迭代序列中的下一项的下标，并提供next，hasNext和remove方法。MyArrayList的迭代器直接返回实现Iterator接口的该类的新构造的实例。



**具体代码实现**

```java
/**
 * 
 * @ClassName: MyArrayList
 * @Description: 自定义ArrayList
 * @author: KangXiaoZhuang
 * @date: 2022年11月7日 下午10:55:12
 */
public class MyArrayList<E> implements Iterable<E>, List<E> {

	// 默认大小
	private static final int DEFAULT_CAPACITY = 10;
	// 找不到置为-1
	public static final int ELEMENT_NOT_FOUND = -1;
	// 集合大小
	private int size;
	// 存放元素的数组
	private E[] elements;
	// 构造方法
	public MyArrayList() {
		clear();
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: 清空集合
	 * @param:
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void clear() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * @Title: ensureCapacity
	 * @Description: 开辟一个新的数组，扩容操作
	 * @param: @param newCapacity
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size) {
			return;
		}
		E[] oldElements = elements;
		// 新建一个数组
		elements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			elements[i] = oldElements[i];
		}
	}

	/**
	 * 
	 * @Title: size
	 * @Description: 返回集合大小
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 返回集合是否为空
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 
	 * @Title: trimToSize
	 * @Description: 修改指定大小
	 * @param:
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void trimToSize() {
		ensureCapacity(size());
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 获取指定索引的元素
	 * @param: @param  index
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 
	 * @Title: indexOf
	 * @Description: 查看元素的索引
	 * @param: @param  element
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i]))
					return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: contains
	 * @Description: 是否包含指定元素
	 * @param: @param  element
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: set
	 * @Description: 修改指定索引的值
	 * @param: @param  index
	 * @param: @param  newElement
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E set(int index, E newElement) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = newElement;
		return old;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 直接从尾部插入
	 * @param: @param  addElement 添加的元素
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean add(E addElement) {
		add(size(), addElement);
		return true;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 指定索引位置添加元素
	 * @param: @param index 索引
	 * @param: @param addElement 添加的元素
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void add(int index, E addElement) {
		// 先判断是否需要扩容
		if (elements.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		// 集合元素往后移动
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = addElement;
		size++;
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除指定索引的元素
	 * @param: @param  index
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E remove(int index) {
		E removeElement = elements[index];
		// 集合的元素统一向前移动
		for (int i = index; i < size() - 1; i++) {
			elements[i] = elements[i + 1];
		}
		// 长度减1
		size--;

		return removeElement;
	}

	/**
	 * 
	 * @Title: rangeCheck
	 * @Description: 判断索引是否合法
	 * @param: @param index
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void rangeCheck(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("索引越界异常!!!");
		}
	}

	public void print() {
		for (E e : elements) {
			if (e != null) {
				System.out.print(e + ",");
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>(this);
	}

	class ArrayListIterator<E> implements Iterator<E> {

		private int current = 0;

		private MyArrayList<E> myArrayList;

		public ArrayListIterator(MyArrayList<E> myArrayList) {
			this.myArrayList = myArrayList;
		}

		@Override
		public boolean hasNext() {
			// 判断是否还有下一个
			return current < myArrayList.size();
		}

		@Override
		public E next() {
			// 看是否还有下一个
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return myArrayList.elements[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
}
```

**测试**

```java
public class MyArrayListTest {

	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		System.out.println("添加元素");
		for (int i = 0; i < 10; i++) {
			myArrayList.add(i);
		}
		myArrayList.print();
		System.out.println();
		System.out.println("清空集合");
		myArrayList.clear();
		System.out.println("集合大小:" + myArrayList.size());
		System.out.println("添加元素");
		for (int i = 10; i < 20; i++) {
			myArrayList.add(i);
		}
		myArrayList.print();
		System.out.println();
		System.out.println("集合大小:" + myArrayList.size());
		System.out.println("集合是否为空:" + myArrayList.isEmpty());
		System.out.println("索引5的元素是:" + myArrayList.get(5));
		System.out.println("删除索引5的元素:" + myArrayList.remove(5));
		myArrayList.print();
		System.out.println();
		System.out.println("在索引0处添加元素666:");
		myArrayList.set(0, 666);
		myArrayList.print();
		System.out.println();

		System.out.println("迭代器遍历");
		// 迭代器遍历
		Iterator<Integer> iterator = myArrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void test02() {
		MyArrayList<User> userList = new MyArrayList<User>();
		System.out.println("添加User");
		for (int i = 0; i < 10; i++) {
			userList.add(new User(i, i + "号"));
		}
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
```

**测试结果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/d53f47c84b314a4fbc621fd65711e0ae.png)
