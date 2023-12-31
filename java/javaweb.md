
# HTML  CSS
- 建议  https://w3school.com.cn  自己了解


# JavaScript
## 基本语法 ：
- ### JS 输出语句
	- window. alert (" ");  写入警告框，浏览器弹出警告框的输出内容。
	- document. writr (" "); 写入 HTML，在浏览器展示。
	- console. log (" "); 写入浏览器控制台，在控制台中展示
- ### JS 变量
	- var 关键字是用来声明变量的
		- var a = 20；
		- var 定义的变量不论在哪都为全局变量，并且可以重复定义，新的值会覆盖旧的值
	- ECMA 6 更新了两种新的变量定义关键字
		-  let 关键字定义的变量，是局部变量，不能重复定义。
		-  const 关键字定义的变量，是一个只读的常量，一旦声明，常量的值就不能改变。
- ### JS运算符
	- === 全等运算符，数据类型和值全都相等才会返回 true
- ### JS 函数（方法）
	- #### JS 函数的定义
		- JS 通过 function 关键字来定义函数
 ```javaScript
function add(a,b){
	return a+b;
}
```
- 函数里的参数不需要类型，函数的返回值也不用定义类型
	##### 函数的调用
	- 如果函数没有返回值，就直接通过函数名+参数来调用函数
	- 如果函数有返回值，就 var 一个变量来接收返回值
```JavaScript
var a = add(a,b);
alert(result);
```


## JS 对象
### Array
- Array 用于定义数组
```JavaScript
var arr = new Array(1,2,3,4);
var arr = [1,2,3,4];
//给第二个索引赋值为10
arr[2] = 10;
//数组的长度是可变的，如果没有赋值输出的结果为 undefined
```
- #### 属性
	- length
- #### 方法
	- forEach ( ) 遍历数组
	- push ( ) 添加元素
		- 从末尾开始添加，并返回新的长度
	- splice ( ) 删除元素
		- splice 有两个参数（从第几个开始删，删几个）。

### String
- 创建字符串
```JavaScript
var Str = new String("Hello String");
var Str = "Hello String"
```
- #### 属性
	- length
- #### 方法
	- charAt ( )
		- 获取指定位置的字符
		- str.charAt (4);   //4 索引处的字符
	- indexOf ( )
		- 检索字符串的位置
	- trim ( )
		- 去除字符串左右两边的空格
	- substring ( )
		- 截取指定的字符串
		- substring (start , end);  //参数（开始索引，结束索引）；含头不含尾。


### JSON
- #### JSON 基础语法
	- var 变量名 = ‘ { “key 1” :  value 1,  "key 2" : value 2 } ’;
	- var userStr = ' { "name" : "Jerry" , "age": 18,} ';
		- 此时 userStr 就是一个字符串，我们不能使用 userStr. name 的方式来获取到 name 的变量
			使用 JSON. parse 方法将 JSON 字符串转为 JS 对象
```JavaScript
var jsObject = JSON.parse(userStr);
```
- 使用 JSON. stringify 方法可以将 JS 对象转为 JSON 字符串
```JavaScript
var jsonStr = JSON.stringify(jsObject);
```

### BOM
- 浏览器对象模型，JavaScript 将浏览器的各个部分封装成对象允许 JavaScript 与浏览器对话
	- #### Window：浏览器窗口对象
		- ##### 获取：
			- window. 方法
		- ##### 属性
			- history
			- location
			- navigator
		- ##### 方法
			- alert（）：显示一个带有**确认**按钮的警告框。
			- confirm（）：显示一个带有**确认**和**取消**按钮的警告框。
				- 该方法有返回值，如果点击确认返回 true，点击取消返回 false。
			- setInterval（）：按照指定周期来调用函数或表达式（毫秒）。
			- setTimeout（）：在指定时间后来调用函数或表达式 （毫秒）。
	- #### Location：地址栏对象
		- ##### 获取 ：
			- Location. 属性；
		- ##### 属性 ：
			- href：设置或返回完整的 URL。

### DOM
- 文档对象模型，将标记语言的各个组成部分封装为对应的对象：
	常见的对象模型有
	-  Document：整个文档对象
	-  Element：元素对象
	-  Attribute：属性对象
	-  Text：文本对象
	-  Comment：注释对象
- JavaScript 通过 DOM 就可以对 HTML 进行操作：
	- 改变 HTML 元素的内容
	- 改变 HTML 元素的样式（CSS）
	- 对 HTML DOM 事件作出反应
	- 添加和删除 HTML 元素


## 事件监听
- ### 事件绑定
	- #### 方式一
		- 通过 HTML 标签中的事件属性进行绑定
	- #### 方式二
		- 通过 DOM 元素属性绑定
```JavaScript
<input type = "button" onclick = "on()" value = "按钮1">

<script>
	function on (){
		alert('我被点击了');
	}
</script>
```

```JavaScript
<input type = "button" id = "btn" value = "按钮2">

<script>
	document.getElementByID('btn').onclick = function(){
		alert('我被点击了');
	}
</script>
```



# Vue
- Vue 是一个基于 MVVM 模型的前端 js 框架。
- 新建 HTML 页面，引入 Vue. js 文件
```JavaScript
<script  src = "js/vue.js"> </script>
```
- 在 JS 代码区域，创建 Vue 核心对象，定义数据类型
```JavaScript
<script>
	//定义vue对象
	new Vue({
		el: "#app", //vue接管的区域
		data: {
			message: "Hello Vue"
		}
	})
</script>
```
- 编写试图
```JavaScript
<div id = "add">
	<input type = "text" v-model="message">
	{{ message }}
</div>
```



## Vue 常用命令
-  自己查阅




## Vue 生命周期
- Vue 对象从创建到销毁的整个过程。
	一共有八个阶段，每触发一个生命周期事件都会自动执行一个生命周期方法（钩子）

### 八个阶段
1. beforeCreate       (创建前)
2. created              （创建后）
3. beforeMount      (载入前)
4. **mounted**           **(挂载完成)**
5. beforeUpdate  （更新前）
6. updated           （更新后）
7. beforeDestroy （销毁前）
8. destroyed        （销毁后）
	- 重点关注一个阶段 mounted：挂载完成，Vue 初始化成功，HTML 页面渲染成功，发送请求获取数据

## Ajax
- 作用
	- 数据交换：给服务器发送请求，并获取服务器响应的数据。
	- 异步交互：可以在不重新加载整个页面的情况下，与服务器交换数据并跟新部分网页的技术。

### Axios
- Axios 对 Ajax 进行了封装，简化书写，快速开发。
- [Axios 官网]( https://www.axios-http.cn )


## Vue 组件库 Element
- 使用 Element 组件，直接进入 Element 官网 [官网 | Element](https://element.eleme.cn/#/zh-CN/component/quickstart) 复制粘贴想要的组件代码然后再进行相应的调整
	- ### 常用的组件：
		- Table 表格
		- Pagination 分页
		- Dialog 对话框
		- Form 表单

## Vue 路由
- ### Vue Router
	- Vue Router 是 Vue 的官方路由
	- 组成
		- VueRouter：路由器类，根据路由请求在路由试图中动态渲染选中的组件
		- router -Link：请求链接组件，浏览器会解析成
		- router - view：动态试图组件，用来渲染展示与路由路径对应的组件


## 打包部署
- Vue 打包会默认到 dist 文件夹

### 部署
- #### Nginx
	- Nginx 是一款轻量级的 Web 服务器。
	- [Nginx官网](https://nginx.org)
- 将打包好的 dist 目录下的文件复制到 nginx 安装目录的 html 目录下
	- nginx 服务器默认占用 80 端口号，如果端口被占用了，可以在 nginx. conf 中修改端口号。
		如果要查看是谁占用了端口可以在 cmd 中输入 netstat -ano | findStr 80。




# Maven

## 依赖

### 依赖配置
- 依赖：指当前项目运行所需要的 jar 包，一个项目中可以引入多个依赖
```java
<dependencies>  
    <dependency>        
	    <groupId>ch.qos.logback</groupId>  
        <artifactId>logback-classic</artifactId>  
        <version>1.4.8</version>  
    </dependency>
</dependencies>
```
- 在 pom. xml 中编写 dependencies 标签，
	在 dependencies 标签中使用 dependency 标签来引入坐标
		dependency 中的 groupId artifactId version 就是坐标

### 依赖传递
#### 依赖传递是一种自带的特性
- 直接依赖：在当前项目中通过依赖配置建立的依赖关系
- 间接依赖：被依赖的资源如果依赖其他资源，当前项目也会间接依赖其他资源

### 依赖范围
- 默认情况下可以在该项目的任何地方使用
	可以通过 scope 标签设置依赖的作用范围

|scope 值|主程序|测试程序|打包|
|:-:|:-:|:-:|:-:|
|compile (默认) | Y | Y | Y 
|test| - | Y | - 
|provided | Y | Y| - 
|runtime | - | Y | Y 

 

### 排除依赖
- 如果我们当前项目不想要其他资源的依赖，可以使用排除依赖
	主动断开依赖的资源，被排除的资源无需指定版本

```java
<exclusions>
	<exclusion>
		 <groupId>排除的资源</groupId>  
        <artifactId>排除的资源</artifactId>  
	</exclusion>
</exclusions>
```


## Maven 生命周期
- Maven 有三套不同的生命周期。分别是：
	- clean
	- default
	- site

- 在这三套生命周期中我们常用的有五个：
	- clean 清理
	- compile 编译
	- test 测试
	- package 打包
	- install 安装
- 这些生命周期的执行都是由 Maven 中的插件完成的




# HTTP

## HTTP 请求数据格式
- ### Get 请求方式
	- 请求参数在请求行中，表现形式是 ?key = value & key = value, 就在第一行请求行当中携带
	- Get 请求大小是有限制的
- ### Post 请求方式
	- 请求参数在第一行请求行是不显示的，在请求体中携带
	- Post 请求大小是没有限制的

## HTTP 响应
- 常见的相应返回值
	- 200：客户端请求成功
	- 404：URL 输入有误，资源被删除
	- 500：服务器发生不可预期的错误




# Web 后端开发

## 请求响应
 1. 简单参数
	 - 定义方法形参，请求变量名与形参变量名一致。
	 - 如果不一致通过@RequestParam 手动映射。
 
 2. 实体参数
	 - 请求参数名，与实体对象的属性名一致，会自动接收封装
 
 3. 数组集合参数
	 - 数组：请求参数名与数组名一致，直接封装
	 - 集合：请求参数名与集合名一致，@RequestParam 绑定关系
 
 4. 日期参数
	 - @DataTimeFormat
 
 5. JSON 参数
	 - @RequestBody
 
 6. 路径参数
	 - PathVariable

### @ResponseBody
- 位于 Controller 类上/方法上
- 将方法返回值直接响应，若返回值类型是实体对象或集合，转 JSON 响应格式

### 统一响应结果
Result（code、msg、data）



## 三层架构

- controller：控制层，接收前端发送的请求，对请求进行处理，并响应数据。
- service：业务逻辑层，处理具体的业务逻辑。
- dao：数据访问层（Data Access Object），负责数据访问操作，包括数据的曾删改查。
- 高内聚低耦合


### IOC & DI

- @Component
	- 将当前类交给 IOC 容器管理，称为 IOC 容器中的 Bean
		- @Component 的衍生注解：
			@Controller：标注在控制器上
			@Service：标注在业务类上
			@Repository：标注在数据访问类上

- @Autowired
	- 运行时，IOC 容器会提供该类型的 Bean 对象，并赋值给该变量——依赖注入
		- @Autowired 默认安装类型自动装配，如果同类型的 bean 存在多个：
			@Primary
			@Autowired+@Qualifier（“bean 的名称”）
			@Resource（name=“bean 的名称”）

- @Resource 与@Autowired 的区别
	@Autowired 是 Spring 框架提供的注解，而@Resource 是 JDK 提供的注解。
	@Autowired 默认是按照类型注入，而@Resource 是按照名称进行注入


## MySQL

### 多表查询
- 笛卡尔积
#### 内连接
- 隐式内连接：
	select 字段列表 from 表1，表2 where 条件;
- 显式内连接：
	select 字段列表 from 表 1 inner join 表 2 on 连接条件


#### 外连接
- 左外连接：
	select 字段列表 from 表1 left outer join 表2 on 连接条件；
- 右外连接：
	select 字段列表 from 表 1 right outer join 表 2 on 连接条件；

#### 嵌套查询
- select * from 表1 where column1 = （select column1 from 表2）； 

### 事务
- 事务是一组操作的集合，要么同时成功要么同时失败。
- 开启事务：start transaction；
- 提交事务：commit；
- 回滚事务：rollback；

事务的四大特性 ACID：
- 原子性：事务是不可分割的最小单元，要么全部成功，要么全部失败；
- 一致性：事务完成是必须使所有的数据都保持一致状态；
- 隔离性：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行；
- 持久性：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的；

### 索引
- 提高了数据查询的效率，但是会占用存储空间，降低了增删改查的效率
#### 结构
- B+Tree（多路平衡搜索树）

#### 语法
- 创建索引
	- create unique index 索引名 on 表名 ( 字段名 , ... );
		只有唯一索引才添加 unique，多个索引不用加unique
- 查看索引
	- show index from 表名;
- 删除索引
	- drop index 索引名 on 表名;
- 