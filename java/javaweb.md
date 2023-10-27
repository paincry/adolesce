
# HTML  CSS
- 建议  https://w3school.com.cn  自己了解


## JavaScript
- 基本语法和 java 是一致的，需要额外了解的有 JS 的输出语句

### JS 输出语句
- window. alert (" ");  写入警告框，浏览器弹出警告框的输出内容。
- document. writr (" "); 写入 HTML，在浏览器展示。
- console.log (" "); 写入浏览器控制台，在控制台中展示

### 变量
- var 关键字是用来声明变量的
	- var a = 20；
	- var 定义的变量不论在哪都为全局变量，并且可以重复定义，新的值会覆盖旧的值
- ECMA 6 更新了两种新的变量定义关键字
	-  let 关键字定义的变量，是局部变量，不能重复定义。
	-  const 关键字定义的变量，是一个只读的常量，一旦声明，常量的值就不能改变。

### 运算符
- === 全等运算符，数据类型和值全都相等才会返回 true


### 函数（方法）

##### 函数的定义
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


### JS 对象

#### Array
- Array 用于定义数组
```JavaScript
var arr = new Array(1,2,3,4);
var arr = [1,2,3,4];
//给第二个索引赋值为10
arr[2] = 10;
```
- 数组的长度是可变的，如果没有赋值输出的结果为 undefined。
##### 属性
- length
##### 方法
- forEach ( ) 遍历数组
- push ( ) 添加元素
	- 从末尾开始添加，并返回新的长度
- splice ( ) 删除元素
	- splice 有两个参数（从第几个开始删，删几个）。




#### String
- 创建字符串
```JavaScript
var Str = new String("Hello String");
var Str = "Hello String"
```
##### 属性
- length
##### 方法
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


#### JSON
##### JSON 基础语法
- var 变量名 = ‘ { “key 1” :  value 1,  "key 2" : value 2 } ’;
- var userStr = ' { "name" : "Jerry" , "age": 18,} ';
- 现在 userStr 就是一个字符串，我们不能使用 userStr. name 的方式来获取到 name 的变量
	使用 JSON. parse 方法将 JSON 字符串转为 JS 对象
```JavaScript
var jsObject = JSON.parse(userStr);
```
- 使用 JSON. stringify 方法可以将 JS 对象转为 JSON 字符串
```JavaScript
var jsonStr = JSON.stringify(jsObject);
```

#### BOM
##### 属性

##### 方法


#### DOM

##### 属性

##### 方法