# 正则表达式是什么？

> 正则表达式，又称规则表达式,（Regular Expression，在代码中常简写为regex 、regexp或RE），是一种文本模式，包括普通字符（例如，a 到 z 之间的字母）和特殊字符（称为"元字符"），是计算机科学的一个概念。正则表达式使用单个字符串来描述、匹配一系列匹配某个句法规则的字符串，通常被用来检索、替换那些符合某个模式（规则）的文本。
>														---   摘自百度百科



# 测试工具
在讲解正则之前，需要准备一个正则表达式的测试工具。工具有很多，有在线的测试工具，比如[菜鸟工具](https://c.runoob.com/front-end/854/)、[站长该工具](https://tool.chinaz.com/regex)、[RegExr](https://regexr.com/77o90)等等。

我使用的是[RegExr](https://regexr.com/77o90)



# 字符类集
## 字符集合（Character Set）
字符集合意思是一组字符的集合（好像说了啥，又好像啥也没说😄），含义就是该集合里的字符才会匹配。
字符集合使用`[字符]`标识，里面的字符不限制，比如`[ABC]`就代表A、B、C三个字符都会被匹配上。

![字符集合](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071706761.png)



## 否定的集合（Negated Set）

否定的集合意思是说匹配不包含在集合中的字符，否定的集合使用`[^字符]`来标识，注意里面字符前面要加上`^`字符，代表非的含义。

![Negated Set](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071707090.png)



从图上可以看到A、B、C三个字符都被忽略，其他字符（空格、g、o）都被匹配到了。



## 范围（Range）

如果一个集合中有很多字符，并且这些字符是连续的，可以使用范围方法标识。标识方法是`[首字符-尾字符]`，比如`[A-D]`，就等价于`[ABCD]`。

![Range](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071708002.png)



## 点（dot）

点使用`.`来标识，表示匹配除换行符以外的任何字符。等价于`[^\n\r]`。

![dot](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071709119.png)



## 空白符（whitespace）

什么是空白符，就是空格（spaces）、制表符（tabs）、换行符（breaks）。空白符使用`\s`（小写的s）来标识。

![whitespace](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071709538.png)



可以看到图中匹配到两个空白符。



## 非空白符（not whitespace）

非空白符跟空白符正好对立。使用`\S`（大写的S）来标识。

![非空白符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071710001.png)



## 匹配任意字符（Match any）

如果空白符和非空白符都能匹配到，那么就是匹配到了任意字符。`[\S\s]`就是匹配任意字符。

![匹配任意字符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071711185.png)



## 单词字符（word）

单词字符是字母、数字和下划线的组合。使用小写w标识（`\w`）。等价于`[A-Za-z0-9_]`

![单词字符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071712483.png)



## 非单词字符（not word）

跟单词字符对立。使用`\W`标识。等价于`[^A-Za-z0-9_]`

![非单词字符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071712842.png)



## 数字（digit）

数字使用`\d`标识，等价于`[0-9]`

![数字](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071713958.png)



它只能匹配0-9的数字，负数是无法匹配的。

## 非数字（not digit）

数字使用`\D`标识，等价于`[^0-9]`

![非数字](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071713605.png)



除了0-9之外的数字都匹配到了。



# 锚点（Anchors）

锚点指的是正则表达式中特殊在一类字符。比如开始结尾符、边界符等。

## 开始符

`^`是开始符（没错和非字符是一个，用在不同位置意义不同），匹配字符串的开头，如果启用了多行标志（m），则匹配每行的开头。

比如`^[ab]`就代表以a或者b开头的字符串。

![默认关闭多行模式](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071715109.png)



上面的图是没有启用多行标志。所以只匹配了文字的第一行开头。



开启之后：

![开起多行模式](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071716354.png)



上图开启了多行标志，每行都进行匹配，最终匹配到了三个。

## 结尾符

`$`是结尾符号，匹配字符串的结尾，如果启用了多行标志（m），则匹配每行行的结尾。

![结尾符-单行模式](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071718371.png)



结尾符和开始符一样都有多行标识开启的效果。

![结尾符-多行模式](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071719173.png)



# 字符边界（word boundary）

字符边界使用`【边界字符】\b`表示，匹配单词字符和非单词字符或位置（字符串的开始/结束）之间的单词边界位置。边界字符必须指定否则没有意义，比如`\b`,这是不准确的（有些浏览器或者软件的正则实现也是允许的）。

![image-20230207172053360](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071720451.png)

没有匹配到了四个（h字符前，o后面，e前面，x后面四个边界）。



也可指定编辑字符，比如`lo\b`就代表匹配`lo`边界。

![lo\b](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071722928.png)



可以看到只匹配到了`lo`字符作为边界的情况。

# 非字符边界（not word boundary）

非字符边界使用`【边界字符】\B`表示，用法与字符边界一样。

![非字符边界](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071722717.png)



匹配到了两个`l`字符，该字符不在边界上。



# 转义字符（escaped characters）

转义字符使用`\`来标识，单文本中中出现了正则表达式中有特别意义的字符时，需要转义。

## 保留字符（reserved characters)

在正则表达式中`+*?^$\.[]{}()|/`这些字符有特殊的意义，需要使用转义字符来转义。

比如我要匹配文字中的`+`，那么正则表达式就得写成`\+`，多个`\`转义字符，将`+`转义为普通字符，而不是正则保留字符。

如果不转义，是无法匹配的，看下图：

![不专义的情况](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071723591.png)



转义后就可以匹配

![转义后](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071723696.png)



## 八进制转义字符（Octal escaped character）

八进制转义字符，格式为\000。值必须小于255（\377）。

![八进制转义字符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071725127.png)



`@`字符的值是169，所以匹配到了。

## 十六进制转义字符

以`\x`开头的表示。

![十六进制转义字符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071726629.png)



十六进制`a9`转化为十进制也是169。



## Unicode转义符

`unicode`的格式是`\uFFFF`，`unicode`对照表可以查看[`unicode`表](https://unicode-table.com/cn/)

比如`中`字，使用`\u4e2d`来匹配。

![Unicode转义符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071727546.png)



## 控制符

控制符使用`\c`开头，紧接着A-Z的字符。比如`\cI`就是匹配制表符。

![控制符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071728357.png)



## 制表符（tab）

制表符使用`\t`匹配，等价于使用控制符`\cI`。

![制表符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071728943.png)



## 换行符

换行符使用`\n`匹配

![换行符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071730220.png)



## 垂直制表符

制表符使用`\v`匹配



## 打印换页符

使用`\f`匹配

![打印换页符](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071731041.png)



## 回车符

`\r`用于匹配一个回车符。等价于 `\x0d` 和 `\cM`。



# 分组

分组是通过`()`将表达式括起来，括起来的就是一个组。

## 捕获分组

捕获分组的意思就是分组匹配的值能够被捕获到，可以在后面的表达式中引用。

通过`()`将表达式括起来分组既是捕获分组。每个分组会默认有组号来标识，从1开始，以此类推。

比如`(AB)+`，就代表`AB`同时连续出现的时候会匹配上。

![image-20230207163206576](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071632655.png)



## 序号引用分组

捕获分组可以在后面的表达式中引用。每个分组会默认有组号来标识，从1开始，因此可以通过组号来引用。

比如`([0-9])\1\1`中的`1`就代表前面分组的捕获结果。该表达式只能匹配三位相同数字的字符串，比如`000`、`111`。

![序号引用分组](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071642048.png)



## 命名分组捕获

上面的分组捕获是通过内置的组号来获取捕获结果的，另外一种方式是通过自己命名的方式来捕获。

`(?<name>ABC)`中的`?<name>`就是命名的格式，其中的name就是组名，不过这种方式很多浏览器不支持。



## 非捕获分组

分组结果不会被捕获，后续也就无法再次引用。通过`?:`来定义非捕获数组。具体使用方法直接看例子。

依然将捕获分组中使用的表达式`([0-9])\1\1`修改为非捕获分组`(?:[0-9])\1\1`。

![非捕获分组](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071705598.png)



从图上结果可以看到并没有匹配到任意字串。愿意就是非捕获分组无法通过组号去捕获组的结果，也就是说`\1`无效。



# 环视（`Lookaround`）

环视的操作对象是一个分组，它的作用是从一个分组中获取某一部分（获取那部分也是通过表达式匹配的），环视的匹配方向上来看有两种，可以字符串头部看（也叫做顺序），也可以从字符串尾部看（也叫做逆序）。

从匹配条件的角度来看分为肯定和否定，肯定就是说表达式=`true`，否定代表表达式=`false`。

两两结合，就有四种模式。

1、肯定顺序：`<结果匹配规则表达式>(?=expression)` 
2、否定顺序：`(?!expression)<结果匹配规则表达式>` 
3、肯定逆序：`<结果匹配规则表达式>(?<=expression)` 
4、否定逆序：`(?<!expression)<结果匹配规则表达式>`



上面的`()`代表分组，`?`可以理解为匹配结果。`expression`代表元组中表达式条件，`=`代表表达式为真，`!`代表表达式为假，`<`代表逆序。`<结果匹配规则表达式>`代表`?`结果的匹配规则。



## 肯定顺序（positive lookahead）

肯定顺序环视通过`(?=expression)`来定义。

比如`\d(?=px)`。`?`代表匹配的结果。它要符合`\d`的要求，并且`?`的**右侧**必须要等于`px`。

![肯定顺序](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071806245.png)



通过图可以看到匹配到了两处。需要注意的是`px`并不在匹配结果中。



## 否定顺序

否定顺序环视通过`(?<=expression)` 来定义。

比如`\d(?!px)`，`?`代表匹配的结果，`?`要符合`\d`的要求，`?`的**右侧**不等于`px`。

![否定顺序](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071813702.png)



# 肯定逆序

否定逆序环视通过`(?<=expression)` 来定义。

比如`(?<=px)\d`，`?`代表匹配的结果，`?`要符合`\d`的要求，`?`的**左侧**等于`px`。

![肯定逆序](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071822721.png)



## 否定逆序

否定逆序环视通过`(?<!expression)` 来定义。

比如`(?<!px)\d`，`?`代表匹配的结果，`?`要符合`\d`的要求，`?`的**左侧**不等于`px`。

![否定逆序](https://programtalk-1256529903.cos.ap-beijing.myqcloud.com/202302071825672.png)
