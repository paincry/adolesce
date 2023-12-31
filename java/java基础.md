### java 基础语法
- 键盘录入 scanner 类的基本格式

```java
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();//这是只能接收键盘录入整形数字的类型
String j = sc.next();//这样的写法可以接收字符串类型

```

- Switch case 语句基于 jdk 12 的优化
- 该优化语句省略了 break; 并且不会发生 case 穿透，如果->符号后只有一条语句的话，{ }也可以省略，就像 case2 这样。

```java
switch (){
    case 1 -> {
        System.out.println("1");
        System.out.println("1");
    }
    case 2 -> System.out.println("2");
}

```

### 字符串
- #string 是 java 中专门的字符串类
- 字符串被创建出来之后是不会被改变的，如果用赋值运算符改变字符串的内容的话，实则是创建了两个字符串。
- 字符串之间的比较，如果是用 == 来比较的话，比较的是两个字符串的地址，如果想要比较字符串的内容，需要用 equals 方法来比较，equalsIgnoreCase 可以忽略大小写。
#### StringBuiler
- #stringBuilder 是一个容器，创建之后里面的内容是可以改变的，这样就优化了字符串创建之后不能改变的弊端，提高了字符串的操作效率。
#### StringJoiner
- #stringJoiner 和 steingBuilder 一样也是一个容器，是 jdk 8 才出现的。




## 集合
- java 中有非常多的集合类，最常见的是 #ArrayList 类。
- Arraylist 类中常见的方法就是增删改查。
- 集合的基本创建方法。

```java
public class ArrayListDemo1{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
    }
}
```
## 集合的体系结构

### 单列集合
- #### Collection
	- ##### List 系列集合   ArrayList  LinkedList
		-  添加的元素是有序，可重复，有索引
			- 有序的意思是**存**和**取**的顺序是一致的
			- 可重复是元素可以重复
			- 可以通过索引获取集合中的每一个元素
       - ##### set 系列集合    HashSet  LinkedHashSet   TreeSet
	       - HashSet 的元素是**无序**，不重复，无索引
	       - LinkedHashSet 的元素是**有序**，不重复，无索引
	       - TreeSet 的元素是**可排序**，不重复，无索引
#### HashSet
- 底层采用哈希表存储数据，哈希表底层是数组+链表+红黑树组成的结构。
- 存储位置的计算
```java
int index = (数组长度 - 1) & 哈希值;
```
- 创建默认 16 个数组，新的元素存储在老元素的下方形成链表，数组存储的数据 x>16×0.75 会自动扩容，如果数组>=64&&链表>=8，那么链表会自动变成红黑树。
- 在类中重写 Hashcod 和 equls 方法
#### TreeSet
- 底层是红黑树，可以将元素升序排列
- 如果要输出自定义类，需要实现 comparable 接口，里面只有一个抽象方法 comparaTo。
	- 返回值如果是负数存左边，返回值是正数存右边，返回值是 0 就说明元素已存在

##### 集合的使用方法
1. 如果想要集合中的元素可重复
	- 用 ArrayList 集合，基于数组的。
2. 如果想要集合中的元素可重复，而且当前的增删操作明显多于查询
	- 用 LinkedList 集合，基于链表的
3. 如果想对集合中的元素去重
	- 用 HashSet 集合，基于哈希表的。
4. 如果想对集合中的元素去重，而且保证存取顺序
	- 用 LinkedHashSet 集合，基于哈希表和双链表，效率低于 HashSet。
5. 如果想对集合中的元素进行排序
	- 用 TreeSet 集合，基于红黑树。后续也可以用 List 集合实现排序


## 集合的遍历方式

### 迭代器 Iterator
- 迭代器是集合专用的一种遍历方式
```java
//创建一个名为it的迭代器的对象，指向的是coll这个集合
Iterator<String> it = coll.iterator();
//hasNext是判断此时指向的位置有没有元素
while(it.hasNext()){
	//next方法要做两件事，获取该位置的元素并且将箭头向后移动一位
	String str = it.next();
	System.out.println(str);
}
```


### 增强 for 遍历
- 只有单列集合和数组可以用增强 for 遍历，底层其实就是迭代器
```java
//s其实就是表示了集合中的每一个元素，直接打出来就行
for(String s : coll){
	System.out.println(s);
}
```


### Lambda 表达式遍历
- Jdk 8 之后才出现的一种新的遍历方式
- 底层就是增强 for 遍历
```java
//forEach是一个接口，底层其实也是遍历了集合然后传递给accept方法，这行代码的本身其实是匿名内部类简化之后的结果
coll.forEach(s -> System.out.println(s));
```


### List 集合特有的遍历方式，列表迭代器 ListIterator
- 列表迭代器继承了迭代器也是一个接口，比迭代器额外多了添加元素的功能



### 双列集合
- 就是双列的集合，一列是键，一列是值，一一对应。通常称为键值对


#### Map
- Map 集合是所有双列集合的父类，是一个接口。
- 在集合中，map 集合有两个特殊的方法来判断键是否存在和值是否存在。


#### Map 集合的遍历方式
- 通过键找值
```java
//keySet就是一个Set单列集合
Set<String> keys = map.keySet();
//遍历单列结合Set获取每一个键
for (String key : keys) {
    //利用map集合中的键get到对应的值value
	String value = map.get(key);
	System.out.println(key + "=" + value);
} 
```

- 通过键值对对象直接进行遍历
```java
//通过entrySet这个方法直接获取map中的所有键值对对象
Set<Map.Entry<String, String>> entries = map.entrySet();
//遍历entries这个集合
for(Map.Entry<String, String> entry : entries){
	String key = entry.getKey();
	String value = entry.getValue();
	System.out.println(key + "=" + value);
}
```


### Stream 流
- 结合了 Lambda 表达式，简化集合和数组的操作

### 集合和数组的区别
- 数组的长度是固定的，集合可以自动扩容
- 数组可以存储基本数据类型和引用数据类型，集合只可以存储引用数据类型，如果集合想要存储基本数据类型，需要用到他们的包装类。

#方法

#方法的重载

#面向对象
- 面向对象中提出了‘‘类’’和‘‘对象’’的概念，我现在的理解是一个对象里面包含了若干个类。可以理解成对象是一个文件夹，然后对象这个文件夹中有其他很多个类的文件。或者说，若干个类组成了一个叫对象的东西。
## 类
- #类 一个类中包括两种概念，一种叫属性，一种叫行为。类中创建的属性或者行为被称之为 #方法
- *main*类被称为测试类
- 非*main*类被称为 *javabean* 类
- #javabean类 
用来描述一类事物的类，比如 student, teacher, dog。在书写 javabean 类的时候，我们要私有化成员变量，书写空参数的构造方法，书写带全部参数的构造方法，针对每一个私有化的成员变量书写其对应的 get 和 set 方法。
- #测试类
用来检查其他类是否书写正确，带有 main 方法的类，是程序的入口。
- #工具类
不是用来描述一类事物的，而是帮我们做一些事情的类。


### Static
-  #static 表示静态，是 Java 中的一个修饰符，可以修饰成员方法，成员变量。
- 被 static 修饰的变量被称为静态变量。它被该类所有对象共享。也就是说，在一个类中的所有对象都有的属性，就要用 static 来修饰。
- 被 static 修饰的成员方法被称为静态方法，多用在测试类和工具类中。


### 面向对象的三大特征 
#封装 #继承 #多态

###### 封装
#封装 对象代表什么，就得封装对应的数据，并提供数据对应的行为
- 首先，封装有一层含义是**对应**的意思，就是该对象所对应的类都应该写在该对象里。
- 其次，类中的方法需要用*public*关键字保护起来，当我们想要调用被*public*修饰的方法时，就需要该方法对应的*get*和*set*方法来访问。*get*和*set*方法用*public*修饰。
- Get 方法要注意返回值的类型


###### 继承
- 继承这个概念是类和类之间的，假设两个 javabean 类中有若干个相同的属性又有若干个不同的属性，我们将相同的属性拿出来重新创建一个新的类，这个新的类就可以是两个 javabean 类的父类。
- 继承的关键字是 extends，前面是子类，后面是父类
```java
public class Student extends Person {}

```
- 子类可以在父类的基础上新增其他功能，让子类更强大。
- java 只支持单继承，不支持多继承。object 类可以看成是所有类的父类。


###### 多态
- 有了继承的概念才有多态，也就是同类型的对象表现出的不同形态被称为多态。
- 我们可以用父类对象直接 new 子类对象。
- 使用父类作为参数，可以接收所有子类的对象。


### this 关键字
- 在一个类中有**成员变量**和**局部变量**两个概念，一般情况下写在方法中的变量是局部变量，直接写在类中的是成员变量。
- 当成员变量和局部变量使用同一名称的情况下，我们在方法中输出变量，此时输出的结果由于**就近原则**为局部变量，如果想输出成员变量就需要在输出前面加上 this 关键字。
这里用一段代码演示一下 
```java
public class stu{
    private int age;

    public void method(){
       int age = 10;
       System.out.println(age);
       System.out.println(this.age);
    }
}
```
第一个 age 由于就近原则会输出为 10，第二个 age 添加了 this 关键字会输出为默认值 0。
- this 关键字在内存中的含义，其实就是代表创建者引用的地址。

### 构造方法
- #构造方法 是存在与类中的，并且构造方法名与类名相同，没有返回值。由虚拟机自动调用，不能手动调用。
- 在创建构造方法的时候，最好将无参构造和有参构造方法都写出来。

### 标准的 JavaBean 类
- 在标准 javabean 类中，需要创建该类的属性和行为，然后需要有该类的无参构造方法和有参构造方法，用 public 修饰的方法都要有对应的 get 和 set 方法。

### 基本数据类型和引用数据类型
- 这里简单记一下基本数据类型是存储在栈内存中的真实数据，而引用数据类型是存储在堆内存中，在栈内存中以地址为存储形式。

### 泛型
- 在上述我们创建集合的时候，后面的<>就是泛型，他代表了在这个集合中只能存储什么样的数据类型。
- 如果在创建集合的时候没有规定泛型，java 会默认里面的数据为 object 类型，这样就丢失了很多子类的特有功能
- 除了常见的在集合中我们使用泛型以外，还有泛型类，泛型方法和泛型接口。
- 在我们使用泛型方法的时候，如果我们想让他接收任意的数据类型，但是又想给这个任意规定一个范围，就需要用到泛型的通配符“？”
```java
//表示可以传递E或者E所有的子类类型
? extends E:
//表示可以传递E或者E所有的父类类型
? super E:
```



### 抽象类
- 关键词是 abstract
- 当我们在抽取共性想要创建的父类的时候，如果无法确定方法体，我们就将父类创建为抽象类，强制让子类按照某种格式重写。在实习开发过程中避免了不同程序员对一些东西不同的认知产生的麻烦。



### 接口
- 关键词是 interface, 因为子类不能继承多个父类，所以才有了接口的概念。
- 当我们在一个继承关系中发现，有部分子类有共同的特性，但是又不满足所有子类，这个时候，我们就可以对这个共同的特性写一个接口。接口同样也是抽象的，当我们子类在进行调用的时候必须要进行接口里方法的重写。


### 方法引用
- 把已经存在的方法拿过来用，当做函数式接口中抽象方法的方法体。
-  ::  双冒号符号是方法引用中的特殊符号。
- 这句话很抽象，从表面上看就是将方法放在参数的位置来用，需要满足一定的条件。



### 异常
- 程序中可能出现的问题被称为异常
- 异常的最上层父类：Exception
	- 编译时异常：没有继承 RuntimeExcpetion 的异常，直接继承于 Exception。
				   编译阶段就会显示错误。
	- 运行时异常：RuntimeExcpetion 本身和子类。
				   编译阶段没有错误提示，运行时出现的
- 捕获异常：try... Catch
	- 为了让程序继续运行下去
- 抛出异常：throw   throws
	- 告诉调用者出错了



### File




## IO 流
1. 存储和读取数据的解决方案
	- I：input
	- O：output
	- 流：像流水一样传输数据
2. 用于读写本地或网络数据
3. IO 流可以分为输出流和输入流
	- 输出流：程序 → 文件
	- 输入流：文件 → 程序
4. IO 流按照操作类型的文件可以分为字节流和字符流
	- 字节流：可以操作所有类型的文件
		- InputStream 字节输入流
		- OutputStream 字节输出流
	- 字符流：只能操作纯文本文件
		- 纯文本文件就是用记事本能直接打开且能读懂的文件
		- Reader 字符输入流
		- Writer 字符输出流
			- 以上方法都是抽象的，不能直接创建，在 java 中需要 new 实现类



### 基本流
 
#### 字节流输入文件 FileInputStream

#### 字节流输出文件 FileOutputStream
1. 创建字节流输出流对象
	- 参数是字符串表示的路径或者 File 对象都可以
	- 如果文件不存在就会创建一个新的文件，但要保证父级路径是存在的
		- 如果文件已经存在，则会清空文件，因为第二个参数默认为 false
1. 写数据
	- Write 方法的参数是整数，实际上写道本地文件中的是整数在 ASCII 上对应的字符
2. 释放资源
	- 每次使用完流之后都要释放资源


#### 字符输入流 FileReader

```java
//创建对象
FileReader fr = new FileReader("???\\??.text");
//创建一个数组，长度为2代表一次只读取两个数组
char [] chars = new char[2];
int len;
//read()读取的返回值是十进制数字，read(chars)就是将返回值强转成字符然后放到数组中
whlie((len = fr.read(chars)) != -1){
	//把数组中的数据变成字符串在进行打印
	System.out.print(new String(chars, 0, len));
}
//释放资源
fr.close();

```


#### 字符输出流 FileWriter


### 高级流

#### 缓冲流
- 输入流和输出流分别自带 8192 字节大小 (8 KB)的缓冲区，在缓冲区之前由内存进行数据的传输，速度较快，提升了传输效率
- 字节缓冲流的缓冲大小为 8kb，字符缓冲流的缓冲大小为 16kb
##### 字节缓冲流
- 字节缓冲输入流 BufferedInputStream
- 字节缓冲输出流 BufferedOutputStream

##### 字符缓冲流
- 字符缓冲输入流 BufferedReader
	- 特有方法，读取一行数据，如果没有数据可读了，会返回 null
```java
public String readLine()
```

- 字符缓冲输出流 BufferedWriter
	- 特有方法，可以实现跨平台换行，Mac 换行，linux 换行，windows 换行
```java
public void newLine()
```


#### 转换流
- 属于字符流的一种高级流
	- 转换输入流 InputStreamReader
	- 转换输出流 OutPutStreamWriter
- 转换流的出现是为了解决不同编码方式在我们读写的过程当中不出现乱码的情况，在 jdk 11 之后做了优化，淘汰了这个高级流
	- 如果我们需要将本地文件中的 GBK 文件，转成 UTF-8 输出：
```java
InputStreamReader isr = 
	new InputStreamReader(new FileInputStream("xx\\xx.txt"), "GBK");
OutputStreamWriter osw = 
	new OutputStreamWriter(new FileOutputStream("xx\\xx.txt"), "UTF-8");
int b;
while((b = isr.read()) != -1){
	osw.write(b);
}
osw.close();
isr.close();
```

- 优化后的方案
```java
FileReader fr = new FileReader("xx\\xx.txt", Charset.forName("GBK"));
FileWriter fw = new FileWriter("xx\\xx.txt", Charset.forName("UTF-8"));
int b ;
while ((b = fr.read()) != -1){
	fw.write(b);
}
fw.close();
fr.close();
```
#### 序列化流
- 反序列化流 ObjectInputStream (对象操作输入流)
	- 把文件中的对象读到程序当中
- 序列化流 ObjectOutputStream (对象操作输出流)
	- 把 java 的对象写道本地文件中
	- 序列化流需要注意的是对象要实现 Serializable 接口，并且加上版本号 serialVersionUID



#### 打印流
- PrintStream 字节打印流
- PrintWriter 字符打印流
- 和 C 语言的输出语句有类似的地方，我们每天写的输出语句就是打印流。



#### 压缩流
- 解压缩流
	- 将压缩包里的文件一个一个读取出来
	- 压缩包中的每一个对象都是 zipentry 对象，获取每一个 ZipEntry 对象然后调用里面的 isDirectory 方法来确定这是一个文件还是一个文件夹，然后进行对应的操作
- 压缩流
	- 把每一个文件/文件夹看成 ZipEntry 对象放到压缩包中




#### Commons-io
- apache 提供的一组有关 IO 操作的开源工具包，可以提高 IO 流的开发效率



## 多线程

- 多线程有三种实现方法
	- 继承 Thread 类
		- 可以直接使用 Thread 类中的方法，但是不能再继承其他类，可扩展性较差
	- 实现 Runnable 接口
		- 因为是只是实现了接口，所以可以继承其他的类，可扩展性较强。但是不能直接使用 Thread 中的方法，要获取线程的对象然后用对象去调用。
	- 实现 Callable 接口
		- 可以获得线程的返回值


### 线程池


## 网络编程
### InetAddress
- 表示 IP 地址的类，有两个子类
	- Inet 4 Address 表示 IPv 4 的对象
	- Inet 6 Address 表示 IPv 6 的对象


### UDP 协议
- 可以实现发送数据和接收数据
- UDP 协议发送数据有三种方式，单播，组播，广播，主要取决于 InetAddress 后的参数

### TCP 通信程序
- TCP 通信发送端与接收端的端口号必须是相同的，但是 UDP 可以不同
- 接收数据默认是字节流，如果是传输汉字的话会出现乱码，所以需要用转换流将字节流转换成字符流


## 反射
- 反射允许对成员变量，成员方法和构造方法的信息进行编程访问
- 反射的作用就是可以获取一个类里面的所有信息，获取到了之后结合配置文件动态创建对象
### 获取 class 对象的三种方式
- Class. ForName ("全类名") ;   //全类名就是包名+类名
	- 这个方法是最常用的
- 类名. Class
	- 用类名直接调用一般是在参数中使用
- 对象. GetClass () ;
	- 当已经有了这个类的对象的时候才可以使用

## 动态代理
