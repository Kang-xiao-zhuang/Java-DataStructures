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