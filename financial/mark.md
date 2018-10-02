#### dependencies与dependencyManagement的区别
    由于有点搞不清楚maven的dependencies和dependecyManagement的区别,特意做一下记录
##### 1、DepencyManagement应用场景
    当我们的项目模块很多的时候，我们使用Maven管理项目非常方便，帮助我们管理构建、文档、报告、依赖、scms、发布、分发的方法。可以方便的编译代码、进行依赖管理、管理二进制库等等。

    由于我们的模块很多，所以我们又抽象了一层，抽出一个itoo-base-parent来管理子项目的公共的依赖。为了项目的正确运行，必须让所有的子项目使用依赖项的统一版本，必须确保应用的各个项目的依赖项和版本一致，才能保证测试的和发布的是相同的结果。

    在我们项目顶层的POM文件中，我们会看到dependencyManagement元素。通过它元素来管理jar包的版本，让子项目中引用一个依赖而不用显示的列出版本号。Maven会沿着父子层次向上走，直到找到一个拥有dependencyManagement元素的项目，然后它就会使用在这个dependencyManagement元素中指定的版本号
    
##### 2、Dependencies
    相对于dependencyManagement，所有生命在dependencies里的依赖都会自动引入，并默认被所有的子项目继承。
 
  
 
##### 3、区别
    dependencies即使在子项目中不写该依赖项，那么子项目仍然会从父项目中继承该依赖项（全部继承）
 
    dependencyManagement里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。
    
    
### mysql中datetime和timestamp的区别
    datetime、timestamp精确度都是秒，datetime与时区无关，存储的范围广(1001-9999)，timestamp与时区有关，存储的范围小(1970-2038)。

### swagger2 api地址
    https://springfox.github.io/springfox/

### jsonrpc内部系统之间交互
    http 不如rpc写法简单
    webservice xml方式浪费带宽
    Thrift grpc 等性能高,但写法很复杂