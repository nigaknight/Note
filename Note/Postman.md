# Postman简介

# Postman入门

## 天气接口

1、使用postman可以给api接口发送请求

2、例子：使用天气api https://www.tianqiapi.com/api/，发送天气请求

3、在api网站会有详细的参数说明，并且有些参数是必须的，postman可以在表格中填写请求所需要带的参数

## 百度IP接口

1、Postman中的Request可以自定义名字和测试集（Collection）

2、使用Chrome的F12调试窗口进行抓包

3、点击百度ip查询按钮后，在调试窗口的network中可以看到抓到的数据包，其中script就是我们发送的请求

4、点开Headers，可以看到四个模块

（1）General

- Request URL：我们所请求的接口在服务器上的地址
- Request Method：我们发送的请求的方法类型
- Status Code：本次请求的Http状态码
- Remote Address：请求的服务器的ip和端口
- Referrer Policy：本次请求的策略方式

（2）Response Headers

（3）Request Headers

（4）Query String Parameters

query：请求时的参数信息

5、在Postman中新建一个Request，可以给Request起一个名字，并创建一个测试集。

6、将Chrome调试窗口中的Request URL复制到Postman中，会自动在表格中生成请求所带的参数。

7、我们可以通过勾选不同组合的参数，来测试出哪些参数对于这个接口是必须的。

8、测试错误的ip的地址格式，会获得空的数据。

# 接口测试系统

## 接口测试流程

1、获取接口信息

通过接口文档和抓包来获取接口的基本调用方式和返回

2、接口测试用例设计

根据获取到的接口信息，按照接口测试用例设计方法，设计参数和预期返回结果

3、接口发包

使用工具或者编程向接口传递参数

4、返回信息验证

获取接口返回的结果，进行解析和验证

## Postman发起接口请求

1、请求部分

重点关注四大信息：接口URL地址、请求方法、请求头和请求参数

2、接口收发包

接口收发包的过程就像通过快递公司寄快递。

Postman接口请求过程：对方的地址（URL）、选择快递公司（HTTP方法）、填写快递单（头域信息）、包装快递物品（发送请求体参数）

Postman接口响应验证：是否成功收到回件（HTTP状态码）、获取返回（收到接口响应）、查看快递单（检查返回头域）、拆快递查看内容（查看返回主体内容）

## 获取响应返回信息

重点关注相应的正文主体，可能对响应头和状态码进行校验。

# Postman界面功能

1、发送请求窗口

（1）请求方式：有GET、POST等请求方式

（2）请求URL：填写需要请求的接口的URL

（3）Params：显示和填写请求URL所带的参数信息

2、请求响应窗口

（1）Body：请求返回的内容主体；Pretty中可以根据所选的解析方式来讲内容格式化，比如按照json格式显示；Raw则显示原本的内容；Preview的显示和浏览器上显示的内容相同。

（2）Cookies：本次请求所拿到的cookie。

（3）Headers：响应的Response Headers信息。

（4）Test Results：结果断言，和请求的Test相关。