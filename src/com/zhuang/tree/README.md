# 树

## 树的定义

树(Tree) 是n(n$\geq$0) 个结点的有限集，它或为空树(n=O)；或为非空树，对千非空树T:
(1) 有且仅有一个称之为根的结点；
(2) 除根结点以外的其余结点可分为m(m>0）个互不相交的有限集T~i~, T~2~, …T~m~，其中每一个集合本身又是一棵树，并且称为根的子树(SubTree)



如图所示

（ a) 是只有一个**根结点**的树； （ b ）是有**13 个结点**的树，其中A是根，其余结点分成3个互不相交的子集： T~1~{B, E, F, K, L}, T~2~ = {C, G}, T~3~{D, H, I, J, M} 。T~1~ 、T~2~和T~3~都是根A 的子树，且本身也是一棵树。例如T~1~ ，其根为B, 其余结点分为两个互不相交的子集： T~11~ = {E, K, L}, T~12~= {F} 。T~11~和T~12~都是B 的子树。而T~11~中E是根，｛K ｝和{L} 是E 的两棵互不相交的子树，其本身又是只有一个根结点的树。



![在这里插入图片描述](https://img-blog.csdnimg.cn/9ae525285c7941928e4cc25e2084c470.png)



树的结构定义是一个递归的定义，即在树的定义中又用到树的定义，它道出了树的固有特性。树还可有其他的表示形式



(a) 是以嵌套集合（即是一些集合的集体，对千其中任何两个集合，或者不相交，或者一个包含另一个）的形式表示的； （ b ）是以广义表的形式表示的，根作为由子树森林组成的表的名字写在表的左边； （ c ）用的是凹入表示法（类似书的编目）

![在这里插入图片描述](https://img-blog.csdnimg.cn/aa5cc68ddf2841caaa8f0476561d3beb.png)

## 树的基本术语

![在这里插入图片描述](https://img-blog.csdnimg.cn/9ae525285c7941928e4cc25e2084c470.png)



(1) 结点：树中的一个独立单元。包含一个数据元素及若干指向其子树的分支，如图中的A 、B 、C 、D 等

(2) 结点的度：结点拥有的子树数称为结点的度。例如， A 的度为3, C 的度为I, F 的度为0 。

(3) 树的度：树的度是树内各结点度的最大值。图所示的树的度为3 。

(4) 叶子：度为0 的结点称为叶子或终端结点。结点K 、L 、F 、G 、M 、I 、J 都是树的叶子。

(5) 非终端结点：度不为0 的结点称为非终端结点或分支结点。除根结点之外，非终端结点也称为内部结点。

(6) 双亲和孩子：结点的子树的根称为该结点的孩子，相应地，该结点称为孩子的双亲。例如， B 的双亲为A, B 的孩子有E 和F 。

(7) 兄弟：同一个双亲的孩子之间互称兄弟。例如， H 、I 和J 互为兄弟。

(8) 祖先：从根到该结点所经分支上的所有结点。例如， M 的祖先为A 、D 和H 。

(9) 子孙：以某结点为根的子树中的任一结点都称为该结点的子孙。如B 的子孙为E 、K 、L和F 。

(10) 层次：结点的层次从根开始定义起，根为第一层，根的孩子为第二层。树中任一结点的层次等于其双亲结点的层次加1 。

(11) 堂兄弟：双亲在同一层的结点互为堂兄弟。例如，结点G 与E 、F 、H 、I 、J 互为堂兄弟。

(12) 树的深度：树中结点的最大层次称为树的深度或高度。图所示的树的深度为4 。

(I3) 有序树和无序树：如果将树中结点的各子树看成从左至右是有次序的（即不能互换），则称该树为有序树，否则称为无序树。在有序树中最左边的子树的根称为第一个孩子，最右边的称为最后一个孩子。

(14) 森林：是m(m$\geq$0) 棵互不相交的树的集合。对树中每个结点而言，其子树的集合即为森林。由此，也可以用森林和树相互递归的定义来描述树。就逻辑结构而言，任何一棵树都是一个二元组Tree= (root, F), 其中root 是数据元素，称作树的根结点； F 是m(m>=0) 棵树的森林， F ＝（ T~1~,T~2~, …， T~m~) ，其中T,= （r~i~,r~1~) 称作根root 的第i棵子树；当m!=0 时，在树根和其子树森林之间存在下列关系：
RF= {<root, r~i~,> |i= 1, 2,… ,m, m>0}
这个定义将有助于得到森林和树与二叉树之间转换的递归定义。

## 二叉树的定义

二叉树(Binary Tree) 是n(n$\geq$0) 个结点所构成的集合，它或为空树(n=0) ；或为非空树，对于非空树T:
(1) 有且仅有一个称之为根的结点；
(2) 除根结点以外的其余结点分为两个互不相交的子集T~1~和T~2~ ，分别称为T的左子树和右子树，且T~1~和T~2~本身又都是二叉树。



二叉树与树一样具有递归性质，二叉树与树的区别主要有以下两点：
(1) 二叉树每个结点至多只有两棵子树（即二叉树中不存在度大于2的结点）；

(2)二叉树的子树有左右之分，其次序不能任意颠倒。



二叉树的递归定义表明二叉树或为空，或是由一个根结点加上两棵分别称为左子树和右子树的、互不相交的二叉树组成。由千这两棵子树也是二叉树，则由二叉树的定义，它们也可以是空树。



**二叉树可以有5 种基本形态**

![在这里插入图片描述](https://img-blog.csdnimg.cn/5a5247f367934a429b0ebd22e36ef8d7.png)



## 二叉树的性质

> 性质1 在二叉树的第1 层上至多有2^i-1^ 个结点（i$\geq$1)。
>
> 
>
> 性质2 深度为K 的二叉树至多有2^k-1^个结点(k$\geq$1)。
>
> 
>
> 性质3 对任何一棵二叉树T, 如果其终端结点数为n~0~, 度为2 的结点数为n~2~, 则n~0~=n~1~+n~2~ 。



**介绍两种特殊形态的二叉树，它们是满二叉树和完全二叉树**



![在这里插入图片描述](https://img-blog.csdnimg.cn/f3ccb76ccf214d2bb1758b697e2476ab.png)



满二叉树的特点是：每一层上的结点数都是最大结点数，即每一层i 的结点数都具有最大值2^i-1^



完全二叉树：深度为K的，有n 个结点的二叉树，当且仅当其每一个结点都与深度为K 的满二叉树中编号从1至n的结点一一对应时，称之为完全二叉树。



完全二叉树的特点是：
(1) 叶子结点只可能在层次最大的两层上出现；



(2) 对任一结点，若其右分支下的子孙的最大层次为L, 则其左分支下的子孙的最大层次必L为L+1。



> 性质4 具有n 个结点的完全二叉树的深度为log2~n~＋ 1
>
> 
>
> 性质5 若采用连续储存（数组）的方式存放二叉树，则结点与下标之间的关系：
> 若某个结点的下标为 i ，则这个结点的父结点的下标为 i / 2。
> 若某个结点的下标为 i ，且结点的度为2，则这个结点的左子结点的下标为 2 * i + 1。
> 若某个结点的下标为 i ，且结点的度为2，则这个结点的右子结点的下标为 2 * i + 2。



## 二叉树的存储结构

### 顺序存储结构

顺序存储结构使用一组地址连续的存储单元来存储数据元素，为了能够在存储结构中反映出结点之间的逻辑关系，必须将二叉树中的结点依照一定的规律安排在这组单元中。



对于完全二叉树，只要从根起按层序存储即可，依次自上而下、自左至右存储结点元素，即将完全二叉树上编号为i 的结点元素存储在如上定义的一维数组中下标为i-1的分量中



对于一般二叉树，则应将其每个结点与完全二叉树上的结点相对照，存储在一维数组的相应分量中



![在这里插入图片描述](https://img-blog.csdnimg.cn/0f1e19ff117e4288be54f020a9ad6640.png)



### 链式存储结构

设计不同的结点结构可构成不同形式的链式存储结构。



二叉树的结点（见图5.9 (a) ）由一个数据元素和分别指向其左、右子树的两个分支构成，则表示二叉树的链表中的结点至少包含3 个域：数据域和左、右指针域，如图5.9 (b) 所示。有时，为了便于找到结点的双亲，还可在结点结构中增加一个指向其双亲结点的指针域，如图5.9 (C) 所示。利用这两种结点结构所得二叉树的存储结构分别称之为二叉链表和三叉链表，如图5.10 所示。链表的头指针指向二叉树的根结点。容易证得，在含有n 个结点的二叉链表中有n+1个空链域。



![在这里插入图片描述](https://img-blog.csdnimg.cn/442ba950eb734aabb0a4fecfb5a50d92.png)





## 遍历二叉树

遍历二叉树(traversing binary tree) 是指按某条搜索路径巡访树中每个结点，使得每个结点均被访问一次，而且仅被访问一次。访问的含义很广，可以是对结点做各种处理，包括输出结点的信息，对结点进行运算和修改等。遍历二叉树是二叉树最基本的操作，也是二叉树其他各种操作的基础，遍历的实质是对二叉树进行线性化的过程，即遍历的结果是将非线性结构的树中结点排成一个线性序列。由千二叉树的每个结点都可能有两棵子树，因而需要寻找一种规律，以便使二叉树上的结点能排列在一个线性队列上，从而便于遍历。



二叉树是由3 个基本单元组成：根结点、左子树和右子树。因此，若能依次遍历这三部分，便是遍历了整个二叉树。假如从L 、D 、R 分别表示遍历左子树、访问根结点和遍历右子树，则可有DLR 、LDR 、LRD 、DRL 、RDL 、RLD 这6 种遍历二叉树的方案。若限定先左后右，则只有前3 种情况，分别称之为先（根）序遍历、中（根）序遍历和后（根）序遍历



若先序遍历此二叉树，按访间结点的先后即字将结点排列起来，可得到二叉树的先序序列为

`- + a * b - cd/ef`



中序遍历此二叉树，可得此二叉树的中序序列为

`a + b * c - d - e/f`



后序遍历此二叉树，可得此二叉树的后序序列为

`abed-*+ ef/ 一`



![在这里插入图片描述](https://img-blog.csdnimg.cn/f1ef01ebed674ba8ae639a7eca8f628b.png)

### 先序遍历

先序遍历二叉树的操作定义如下：
若二叉树为空，则空操作；否则
(I) 访问根结点；
(2) 先序遍历左子树；
(3) 先序遍历右子树。

### 中序遍历

中序遍历二叉树的操作定义如下：
若二叉树为空，则空操作；否则
(I) 中序遍历左子树；
(2) 访问根结点；
(3) 中序遍历右子树。

### 后序遍历

后序遍历二叉树的操作定义如下：
若二叉树为空，则空操作；否则
(I) 后序遍历左子树；
(2) 后序遍历右子树；
(3) 访问根结点。

## 二叉搜索树

前驱节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的前一个节点为该节点的前驱节点；



后继节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的后一个节点为该节点的后继节点；



二叉搜索树（又：二叉查找树，二叉排序树，Binary Search Tree，BST）是一种二叉树，其中每个结点最多有 两个子结点且具有二叉搜索树性质：左子树上所有结点的值均小于它的根结点的值以及右子树上所有结点的值均大于它的根结点的值

BST（尤其是像AVL Tree这样平衡的BST）是实现某种**表**（或**映射**）抽象数据类型（ADT）的高效数据结构。

表ADT必须**至少**支持以下三种操作：

1. 搜索（v） - 确定 ADT 中是否存在 v，
2. 插入（v） - 将 v 插入ADT，
3. 删除（v） - 从 ADT 中删除 v 。



![在这里插入图片描述](https://img-blog.csdnimg.cn/738c4bacf74c4460917f9d1ffd2aade4.png)

### 搜索操作

搜索27节点 



![在这里插入图片描述](https://img-blog.csdnimg.cn/499a0ee925fd47ffb19007aab0aa240e.gif)



### 插入操作

插入46节点



![在这里插入图片描述](https://img-blog.csdnimg.cn/4f602681a1924f82bc26ccfffdcfd29a.gif)

### 删除操作 

删除84节点



![在这里插入图片描述](https://img-blog.csdnimg.cn/6dc06b9545d84a75b53d9ea6bb2efa12.gif)



### 查找前驱节点

查找61前驱节点



![在这里插入图片描述](https://img-blog.csdnimg.cn/e58d6e0679974fe3928c227140e88e01.gif)



### 查找后继节点

查找22后继节点



![在这里插入图片描述](https://img-blog.csdnimg.cn/221f440c92fc41afa182cb397ec3be75.gif)

### 前序遍历

![在这里插入图片描述](https://img-blog.csdnimg.cn/119797685c6b4d15af1f697b67003c92.gif)

### 中序遍历

![在这里插入图片描述](https://img-blog.csdnimg.cn/a0f101e71d174537ba3b3703fcd64670.gif)



## 树和森林

### 树的存储结构

1. 双亲表示法
这种表示方法中，以一组连续的存储单元存储树的结点，每个结点除了数据域data 外，还附设一个parent 域用以指示其双亲结点的位置，

![在这里插入图片描述](https://img-blog.csdnimg.cn/125cd403e41543f69978deb92f23313f.png)

一棵树及其双亲表示的存储结构

![在这里插入图片描述](https://img-blog.csdnimg.cn/50f5d240963740e082429289523c3528.png)

2. 孩子表示法

由于树中每个结点可能有多棵子树，则可用多重链表，即每个结点有多个指针域，其中每个
指针指向一棵子树的根结点

![在这里插入图片描述](https://img-blog.csdnimg.cn/fe79d116918a4382b08da4b89d5d0bd5.png)

3. 孩子兄弟法

又称二叉树表示法，或二叉链表表示法，即以二叉链表做树的存储结构。链表中结点的两个链域分别指向该结点的第一个孩子结点和下一个兄弟结点，分别命名为`firstchild` 域和`nextsibling`域

![在这里插入图片描述](https://img-blog.csdnimg.cn/7e1f3a2200c44853b0b549bfb959352f.png)	

### 森林与二叉树的转换

森林与二叉树之间的对应关系

![在这里插入图片描述](https://img-blog.csdnimg.cn/1911a142528d4b34923b59444c9df527.png)

1. 森林转换成二叉树
如果F= {T~1~, T~2~, …，T~m~｝是森林，则可按如下规则转换成一棵二叉树B = (root, LB, RB) 。
(1) 若F为空，即m=0 ， 则B 为空树；
(2) 若F非空，即m!=0，则B 的根root 即为森林中第一棵树的根ROOT(T~1~); B 的左子树LB 是从T~1~中根结点的子树森林F~1~{T~11~, T~12~, …， T~1m~} 转换而成的二叉树；其右子树RB是从森林F'= {T~2~, T~3~, …，T~m~｝转换而成的二叉树。

2. 二叉树转换成森林
如果B = (root, LB, RB)是一棵二叉树，则可按如下规则转换成森林F= ｛T~1~， T~2~, …，T~m~｝：
(1) 若B 为空，则F 为空；
(2) 若B 非空，则F 中第一棵树T~1~的根ROOT(T~1~)即为二叉树B 的根root; T~1~中根结点的子树森林F~1~是由B 的左子树LB 转换而成的森林； F 中除T~1~之外其余树组成的森林F= {T~2~, T~3~, …，T~m~｝是由B 的右子树RB 转换而成的森林。



## 红黑树

## 2-3-4树的介绍 

2-3-4树名字的2,3,4的含义是指一个节点可能含有的子节点的个数。对非叶节点有三种情况

- 有一个数据项的节点总是有两个子节点。
- 有两个数据项的节点总是有三个子节点。
- 有三个数据项的节点总是有四个子节点。

简而言之，非叶节点的子节点数总是比它含有的数据项多1。



![在这里插入图片描述](https://img-blog.csdnimg.cn/bb7e4c348bc544d99ffdd48d1bac6028.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/45285fca11a84921b193bcef5a07ebe6.png)





## 插入节点

新的数据项总是插在叶节点里，在树的最底层，如果插入到有子节点的节点里，子节点的编号就要发生变化来保持树的结构，保证节点的子节点比数据项多1



插入可能会涉及到一个节点移动一个或者两个其他的数据项，这样在新数据插入后关键值仍保持正确的顺序



### 节点不分裂

如果往下寻找要插入位置的路途中，节点已经满了，插入就变得复杂了。发生这种情况，必须节点分裂。从而保证树的平衡。



**插入节点18的图解**

![在这里插入图片描述](https://img-blog.csdnimg.cn/b38572e30d3b4044aee7be65ab5276e5.png)





### 节点分裂

- 创建一个新的空节点，它是要分裂节点的兄弟，在要分裂节点的右边。
- 数据项C移到新的节点中。
- 数据项B移到分裂节点的父节点中。
- 数据项A保留在原来的位置上
- 最右边的两个子节点从要分裂节点处裂开，连到新节点

![在这里插入图片描述](https://img-blog.csdnimg.cn/f369dbcb747f4ea19f1223e566d89407.png)





### 根的分裂

如果一开始查找插入点时就碰到满的根是，插入过程复杂点

- 创建新的根，它就是要分裂节点的父节点
- 创建第二个新的节点，就是要分裂节点的兄弟节点 

- 数据项C移到新的兄弟节点中
- 数据项B移到新的根节点中
- 数据项A保留在原理的位置上
- 要分裂节点最右边的两个子节点断开连接，连接到新的兄弟节点中



![在这里插入图片描述](https://img-blog.csdnimg.cn/a607497c42d8438fa4adffa7b265db5a.png)



### 在下行路途中分裂



![在这里插入图片描述](https://img-blog.csdnimg.cn/76a8018f572f46bb935bae8e858f401d.png)



## 红黑树

## RBT的定义

红黑树（Red Black Tree） 是一种自平衡二叉查找树，又叫红黑二叉查找树。红黑树是在1972年由Rudolf Bayer发明的，当时被称为平衡二叉B树（Symmetric Binary B-trees）。后来，在1978年被Leo J. Guibas和Robert Sedgewick修改为如今的“红黑树”。



红黑树是一种AVL树（平衡二叉树）的变体，都是在进行插入和删除操作时通过特定操作保持二叉查找树的平衡，他的左右子树高度差有可能大于1，所以红黑树不是严格意义上的AVL树（平衡二叉树），但对之进行平衡的代价较低，并且其平均统计性能要强于AVL树（平衡二叉树） 。他虽然是复杂的，但他的最坏情况运行时间也是非常良好的，并且在实践中是高效的。他可以在O(logn)时间内做查找，插入和删除，这里的n是树中元素的数目。



由于每一棵红黑树都是一颗BST树（二叉查找树），除了结点信息、添加和删除操作有些特殊外，其余操作几乎不用修改，可以直接使用。


![在这里插入图片描述](https://img-blog.csdnimg.cn/4422384f060a4f54b23220896eda1497.png)

### RBT的性质

红黑树是一种结点带有颜色属性的二叉查找树，但他在二叉查找树之外，还有以下5大性质

- 每一个节点不是红色就是黑色的
- 根总是黑色的
- 所有叶子结点都是黑色
- 如果节点是红色的，则它的子节点必须是黑色的（反之倒不一定必须为真）
- 从根到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点

**用法最广:**

- Java ConcurrentHashMap & TreeMap
- C++ STL: map & set
- linux进程调度Completely Fair Scheduler,用红黑树管理进程控制块
- epoll在内核中的实现，用红黑树管理事件块
- nginx中，用红黑树管理timer等



## 左旋操作

**左旋：**以某个节点作为支点(旋转节点)，其右子节点变为旋转节点的父节点，右子节点的左子节点变为旋转节点的右子节点，旋转节点的左子节点保持不变。右子节点的左子节点相当于从右子节点上“断开”，重新连接到旋转节点上。



**左旋**只影响旋转结点和其**右子树**的结构，把右子树的结点往左子树挪了。







![在这里插入图片描述](https://img-blog.csdnimg.cn/abe05d35f9cb427d98df27caabe7bfed.png)

**左旋后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/0a451bcfbc774464a955b1482107e8d9.png)

**变色后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/fe006272e29e411895035db4cfb20f2b.png)

****

**更复杂的左旋**

![在这里插入图片描述](https://img-blog.csdnimg.cn/c1466848de8343148fbf74e8d5c5286b.png)

**左旋后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/4aaf47fd414a4cc4bd2bbae6d8629d03.png)

**变色后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/68abe4077c374c2189af76680dea9b5c.png)

### 左旋的条件是什么？

- 旋转节点的右路出现两个连续的红色节点。
- 旋转节点的右子节点不为空。（如果右子节点为空，左旋后，根节点就变成空了。）

### 左旋的具体步骤

- 获取当前结点h
- 获取当前结点h的右子结点x
- 让h的右子结点指向x的左子结点
- 让x的左子结点指向h结点

![在这里插入图片描述](https://img-blog.csdnimg.cn/d697ce9be2cd4b28b334932d3709a662.png)

```java
// 左旋操作
private void rotateLeft(Node h) {
	// 判断当前节点h是否为null
	if (h != null) {
		// 获取当前节点h的右子节点x
		Node x = h.right;
		// 让h的右子节点指向x的左子节点
		h.right = x.left;
		// 判断x的左子节点是否为null
		if (x.left != null) {
			// 让x的左子节点的父节点指向h
			x.left.parent = h;
		}
		// 让x的父节点指向h的父节点
		x.parent = h.parent;
		// 判断h的父节点是否为null
		if (h.parent == null) {
			// 说明是根节点
			root = x;
		} else if (h.parent.left == h) { // 判断当前h子树是否为父节点的右子树
			h.parent.left = x;
		} else { // 判断当前h子树是否为父节点的右子树
			h.parent.right = x;
		}
		// x左子节点指向h节点
		x.left = h;
		// h节点的父节点指向x节点
		h.parent = x;
	}
}
```

## 右旋操作

**右旋**：以某个结点作为支点(旋转结点)，其左子结点变为旋转结点的父结点，左子结点的右子结点变为旋转结点的左子结点，右子结点保持不变。



**右旋**只影响旋转结点和其**左子树**的结构，把左子树的结点往右子树挪了。

#### （一）选转节点为插入节点的爷爷节点

**旋转节点为根节点**

![在这里插入图片描述](https://img-blog.csdnimg.cn/12e38da777da42bc96e41136408578fd.png)

**根节点右旋后**



![在这里插入图片描述](https://img-blog.csdnimg.cn/3e4ed095b4904502b20e0f34733a4498.png)



**变色后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/6add95c8b56046fe846ecff070c61416.png)



#### （二）旋转节点是插入节点的父节点：

**插入节点7，旋转节点8**

![在这里插入图片描述](https://img-blog.csdnimg.cn/c50746bae2f547f5a509ce125f8f7613.png)

**8右旋后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/bb1544ea4eda49e19d0733af58465905.png)

**根节点5左旋后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/8839a48233774b6bb7994a49037cb558.png)

**变色后**

![在这里插入图片描述](https://img-blog.csdnimg.cn/4139a28e0d524d04897ccf024765bd80.png)

### 右旋的条件是什么？

- 左子节点不为空。
- 旋转节点的左路，存在两个相连的红色节点。

### 右旋的具体步骤

- 获取当前结点h
- 获取当前结点h的左子结点x
- 让h的左子结点指向x的右子结点
- 让x的右子结点指向h结点

![在这里插入图片描述](https://img-blog.csdnimg.cn/73d3d12e455a48f5892f76122394a1a3.png)

```java
// 右旋操作
private void rotateRight(Node h) {
	// 判断当前节点h是否为null
	if (h != null) {
		// 获取当前节点h的左子节点x
		Node x = h.left;
		// 让h的左子节点指向x的右子节点
		h.left = x.right;
		// 判断x的右子节点是否为null
		if (x.right != null) {
			// 让x的右子节点的父节点指向h
			x.right.parent = h;
		}
		// 让x的父节点指向h的父节点
		x.parent = h.parent;
		// 判断h的父节点是否为null
		if (h.parent == null) {
			// 说明是根节点
			root = x;
		} else if (h.parent.right == h) { // 判断当前h子树是否为父节点的右子树
			// 如果是，修正为新的x子树
			h.parent.right = x;
		} else { // 判断当前h子树是否为父节点的左子树
			// 如果是，修正为新的x子树
			h.parent.left = x;
		}
		// x左子节点指向h节点
		x.left = h;
		// h节点的父节点指向x节点
		h.parent = x;
	}
```

### 变色操作

- 红色变为黑色。
- 黑色变为红色。

### 添加操作

参考文章：[数据结构：树基础_轻松的小希的博客-CSDN博客](https://caochenlei.blog.csdn.net/article/details/115079406)

## RBT的获取

### 获取指定结点

```java
// 获取指定节点
public Node getNode(Key key) {
	Node temp = root;
	while (temp != null) {
		int cmp = key.compareTo(temp.key);
		if (cmp < 0) {
			temp = temp.left;
		} else if (cmp > 0) {
			temp = temp.right;
		} else {
			return temp;
		}
	}
	return null;
}
```

### 获取最小结点

```java
// 获取最小节点
public Node getMinNode() {
	Node temp = root;
	if (temp != null) {
		while (temp.left != null) {
			temp = temp.left;
		}
	}
	return temp;
}
```

### 获取最大结点

```java
// 获取最大节点
public Node getMaxNode() {
	Node temp = root;
	if (temp != null) {
		while (temp.right != null) {
			temp = temp.right;
		}
	}
	return temp;
}
```

### 获取前驱结点

![在这里插入图片描述](https://img-blog.csdnimg.cn/a2f279bc356249069b3309c58afb7456.png)

前驱结点： 小于当前结点的最大值，在一棵树中，判断前驱结点分为三种情况。



第一种情况：要查询的结点为null，此时直接返回null。



第二种情况：要查询的结点不为null，并且左子树不为null，在其左子树中找到最大的那个结点即可。如上图所示：结点4的前驱结点是结点3。



第三种情况：要查询的结点不为null，并且左子树为null，我们就需要循环向上查询其父结点，直到当前结点是父结点的右子结点为止。如上图所示：结点5的前驱结点是结点4，操作顺序：首先结点5是结点6的左子结点，结点6是结点8的左子结点，结点8是结点4的右子结点，此时停止，结点4就是前驱结点。

```java
// 获取指定节点的前驱节点
public Node predecessor(Node node) {
	if (node == null) {
		return null;
	} else if (node.left != null) {
		Node temp = node.left;
		while (temp.right != null) {
				temp = temp.right;
		}
		return temp;
	} else {
		Node temp = node.parent;
		Node x = node;
		while (temp != null && x == temp.left) {
			x = temp;
			temp = temp.parent;
		}
		return temp;
	}
}
```

### 获取后继结点

![在这里插入图片描述](https://img-blog.csdnimg.cn/a2f279bc356249069b3309c58afb7456.png)

后继结点： 大于当前结点的最小值，在一棵树中，判断后继结点分为三种情况。



第一种情况：要查询的结点为null，此时直接返回null。



第二种情况：要查询的结点不为null，并且右子树不为null，在其右子树中找到最小的那个结点即可。如上图所示：结点4的后继结点是结点5。



第三种情况：要查询的结点不为null，并且右子树为null，我们就需要循环向上查询其父结点，直到当前结点是父结点的左子结点为止。如上图所示：结点3的后继结点是结点4，操作顺序：首先结点3是结点2的右子结点，结点2是结点4的左子结点，此时停止，结点4就是后继结点。


```java
// 获取指定节点的后驱节点
public Node successor(Node node) {
	if (node == null) {
		return null;
	} else if (node.right != null) {
		Node temp = node.right;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	} else {
		Node temp = node.parent;
		Node x = node;
		while (temp != null && x == temp.right) {
			x = temp;
			temp = temp.parent;
		}
		return temp;
	}
}
```

## RBT的删除

### 删除操作

关于红黑树的删除操作，这时候你不能使用BST的那种递归删除，因为我们当前的红黑树的结点有父结点指向，这点比较麻烦，具体删除规则一共分为4种：



1、要删除的结点是叶子结点，此时直接删除即可。（叶子结点可黑可红，由于RBT是黑色平衡，如果删除的是黑色结点，我们要先调整，然后再删除）



2、要删除的结点是树根结点，此时直接删除即可。（树根结点永远黑色，删除完了就完了，树就空了，还保持啥平衡）



3、要删除的结点有1个孩子，可能有左孩子，可能有右孩子，只需让左 / 右孩子指向 要删除结点 的父亲结点即可。



4、要删除的结点有2个孩子，肯定有左孩子，肯定有右孩子，只需让该结点的前驱或后继结点的值覆盖 要删除结点 的值，然后删除前驱或后继结点即可。

如下图所示：4的前驱结点是3.5、6的后继结点是6.5，此时的问题就变成了第1种的删除规则了；5的前驱结点是4、5的后继结点是6，这两种情况都有1个孩子，此时的问题就变成了第3种的删除规则了。

![在这里插入图片描述](https://img-blog.csdnimg.cn/ccd4ef23ffc14dc78776a8cca8422cfc.png)

因此，我们在进行删除操作的时候，首先从第4种规则开始判断，第4种规则虽然要删除前驱或者后继结点，但是因为和第3种情况和第1种情况重复，所以，删除的动作全部交给第3种情况和第1种情况来处理，又因为，第1、2种情况比较固定，所以，我们的处理顺序是：处理第4种、处理第3种、处理第2种、处理第1种。



当然了，在第3种中，如果删除的时候也是黑结点，那么删除后也是需要修正的，以此来保持红黑树的平衡。

```java
// 删除操作
	public Value delete(Key key) {
		Node p = getNode(key);
		if (p == null)
			return null;
		Value oldValue = p.value;
		deleteNode(p);
		return oldValue;
	}

	// 真正删除
	private void deleteNode(Node node) {
		size--;
		// 4. 删除的节点有2个孩子，肯定有左孩子，肯定有右孩子
		if (node.left != null && node.right != null) {
			// 找到前驱节点，然后替换要删除的节点的键值
			Node prev = predecessor(node);
			node.key = prev.key;
			node.value = prev.value;
			node = prev;
		}
		// 3.要删除的节点有一个孩子，可能有左孩子，可能有右孩子
		Node replacement = (node.left != null ? node.left : node.right);
		if (replacement != null) {
			// 让左右子节点连接到node的父节点
			replacement.parent = node.parent;
			if (node.parent == null) {
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else {
				node.parent.right = replacement;
			}
			// 释放当前node节点所有指向等待回收
			node.left = node.right = node.parent = null;
			// 如果当前节点是黑色，需要修正
			if (node.color == BLACK) {
				fixAfterDelete(replacement);
			}
			// 2.要删除的节点是树根节点，此时直接删除即可
			else if (node.parent == null) {
				root = null;
			} else {
				// 要删除的节点是叶子节点，直接删除(如果删除黑色节点，先调整，然后再删除)
				if (node.color == BLACK) {
					fixAfterDelete(node);
				}
				// 再删除
				if (node.parent != null) {
					if (node == node.parent.left) {
						node.parent.left = null;
					} else if (node == node.parent.right) {
						node.parent.right = null;
					}
					node.parent = null;
				}
			}
		}
	}
```



> Q：为什么第1种情况是先调整再删除，而第3种情况是先删除再调整？
>
> A：第1种情况删除的是叶子结点，你如果先删除的话，删除完了，你还有办法再调整吗？显然结点都没了，这是无法调整，那为什么第3种可以呢？因为第3种调整的是`replacement`被替换的那个结点。

### 删除的修正操作

参考博客 ：[数据结构：树基础](https://caochenlei.blog.csdn.net/article/details/115079406)



```java
private void fixAfterDelete(Node node) {
		// 那么在此之前要处理的必定是 node != root && colorOf(node) == BLACK
		while (node != root && colorOf(node) == BLACK) {
			// node是左孩子的情况
			if (node == leftOf(parentOf(node))) {
				// 获取当前的兄弟结点
				Node brother = rightOf(parentOf(node));

				// 找到真正的兄弟结点
				if (colorOf(brother) == RED) {
					setColor(brother, BLACK);
					setColor(parentOf(node), RED);
					rotateLeft(parentOf(node));
					brother = rightOf(parentOf(node));
				}

				// 这个兄弟结点帮不了
				if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
					setColor(brother, RED);
					node = parentOf(node);
				}
				// 这个兄弟结点帮得了
				else {
					// 判断当前结构是不是需要调整，找到真正的兄弟结点
					if (colorOf(rightOf(brother)) == BLACK) {
						setColor(leftOf(brother), BLACK);
						setColor(brother, RED);
						rotateRight(brother);
						brother = rightOf(parentOf(node));
					}
					// 让老父亲去顶替被删除结点，让亲兄弟去顶替老父亲
					setColor(brother, colorOf(parentOf(node)));
					setColor(parentOf(node), BLACK);
					setColor(rightOf(brother), BLACK);
					rotateLeft(parentOf(node));
					// 这种情况，调整一次即可，node=root代表跳出当前循环
					node = root;
				}
			}
			// node是右孩子的情况
			else {
				// 获取当前的兄弟结点
				Node brother = leftOf(parentOf(node));

				// 找到真正的兄弟结点
				if (colorOf(brother) == RED) {
					setColor(brother, BLACK);
					setColor(parentOf(node), RED);
					rotateRight(parentOf(node));
					brother = leftOf(parentOf(node));
				}

				// 这个兄弟结点帮不了
				if (colorOf(rightOf(brother)) == BLACK && colorOf(leftOf(brother)) == BLACK) {
					setColor(brother, RED);
					node = parentOf(node);
				}
				// 这个兄弟结点帮得了
				else {
					// 判断当前结构是不是需要调整，找到真正的兄弟结点
					if (colorOf(leftOf(brother)) == BLACK) {
						setColor(rightOf(brother), BLACK);
						setColor(brother, RED);
						rotateLeft(brother);
						brother = leftOf(parentOf(node));
					}
					// 让老父亲去顶替被删除结点，让亲兄弟去顶替老父亲
					setColor(brother, colorOf(parentOf(node)));
					setColor(parentOf(node), BLACK);
					setColor(leftOf(brother), BLACK);
					rotateRight(parentOf(node));
					// 这种情况，调整一次即可，node=root代表跳出当前循环
					node = root;
				}
			}
		}

		// 如果当前结点是红色，那么立即修改为黑色
		// 还有一种情况就是为了保证根结点root始终是黑色，因为replacement最后有可能成为根结点
		setColor(node, BLACK);
}
```

## 平衡二叉树

### 平衡二叉树的定义

二叉排序树查找算法的性能取决于二叉树的结构，而二叉排序树的形状则取决于其数据集。如果数据呈有序排列，则二叉排序树是线性的，查找的时间复杂度为O(n) ；反之，如果二叉排序树的结构合理，则查找速度较快，查找的时间复杂度为O(logn)。事实上，树的高度越小，查找速度越快。因此，希望二叉树的高度尽可能小。本节将讨论一种特殊类型的二叉排序树，称为平衡二叉树(Balanced Binary Tree 或Height-Balanced ·Tree)，因由前苏联数学家Adelson-Velskii 和Landis 提出，所以又称AVL 树。



平衡二叉树或者是空树，或者是具有如下特征的二叉排序树：

(1) 左子树和右子树的深度之差的绝对值不超过1;



(2) 左子树和右子树也是平衡二叉树。

****

若将二叉树上结点的平衡因子(Balance Factor, BF) 定义为该结点左子树和右子树的深度之差，则平衡二叉树上所有结点的平衡因子只可能屉－l 、0 和1 。只要二



叉树上有一个结点的平衡因子的绝对值大于1, 则该二叉树就是不平衡的。

![在这里插入图片描述](https://img-blog.csdnimg.cn/6f6818e76b7c4b29bb85962dc77aedd3.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/3c3a29afeb384d9cac39925a320f951e.png)



因为AVL 树上任何结点的左右子树的深度之差都不超过1,则可以证明它的深度和log2n是同数量级的（其中n 为结点个数）。由此，其查找的时间复杂度是O(log2n） 

### 平衡二叉树的平衡调整方法

如何创建一棵平衡二叉树呢？插入结点时，首先按照二叉排序树处理，若插入结点后破坏了平衡二叉树的特性，需对平衡二叉树进行调整。调整方法是：找到离插入结点最近且平衡因子绝对值超过1 的祖先结点，以该结点为根的子树称为最小不平衡子树，可将重新平衡的范围局限千这棵子树。



假设表中关键字序列为(13, 24, 37, 90, 53)

![在这里插入图片描述](https://img-blog.csdnimg.cn/944219e2396d40ceb097c718307c38d1.png)
