## 准备工作

1. 下载[github for windows](https://desktop.github.com/)
2. [注册github账号](https://github.com/)

## 创建第一个代码库

### 认识界面

打开之后有三个选项，Add，Create，Clone。

Add功能：如果本地有工程，就可以使用Add添加

Clone功能：将在浏览器上已经创建好的项目导入到本地，换句话说就是下载到本地。

Create功能：创建一个代码库， Name填写你的仓库名字。Local path写你将要保存在本地路径。

## 开始使用第一个代码库

### 修改第一个代码库中内容

右键点击First，选择Open in Explorer，这样我们就可以转到创建的代码库在本地的位置。

我们新建一个文本文档，在里面编辑，可以添加两段文本。（windows记事本下编辑会乱码，可以用vscode在utf-8编码下编辑）。

github for windows会显示编辑内容；并且前面会有**蓝色标识**，这个蓝色标识是提示你会上传改变的文本。

我们填写好**Summary**和**Description**。Summary就是这次改动的总结，我们也可以理解为标题*（必填）*，而Description可以理解为详细概况*（选填）*

在**History**目录下会发生改变，会在**History**目录下形成一天时间线，来指出每一次的修改标题和内容，同时会把修改的内容用**绿色标识**标出。

### 上传与同步

上传：点击右上角的**publish**，就可以将本地文本上传到github网页上。

同步：当你的代码库上传后就会发现，原来的**publish**以及变为了**Sync**。点击**Sync**同步代码库！

## 分支的使用

### 创建分支

我们创建第一个分支取名为**“new master”**,点击**Create new branch**创建第一个分支。

我们来修改**new master**分支上的内容。 我们仍旧打开**Test.txt**进行编辑。

### 切换分支

我们点击**master**就会切换到**master**分支。

### 上传/同步分支

这个操作和同步仓库是一个操作，点击**Publish/Sync**上传或同步分支

### 删除分支

首先要把分支切换到你要删除的分支下，如我们要删除**new master**，将分支切换到**new master**点击右上角齿轮就会出现**Delete new master**

### 合并两个分支

将一个分支与**master**分支进行合并。 我们首先把分支切换到**master**下，点击**Update from new-branch**进行分支的合并。

## 团队协作流程

### 认识Flow

### 为团队成员写入权限

### 创建分支

### 添加提交

### 打开一个pull请求

### 部署

### 合并

## Git

[廖雪峰Git教程](https://www.liaoxuefeng.com/wiki/896043488029600/900785521032192)

### 设置名字和email

```
git config --global user.name "nigaknight"
git config --global user.email "1572236483@qq.com"
```

git config 命令：设置

--global 参数：这台机器上所有的Git仓库都会使用这个配置

查看当前git的邮箱和用户名

```
git config user.name
git config user.email
```

### 创建版本库

```
$ git init
```

### 把文件添加到版本库

```
$ git add readme.txt
```

git add  <file> 命令：添加文件到暂存区

将所有更改添加到暂存区

```
git add .
```

```
$ git commit -m "wrote a readme file"
```

git commit <file> 命令：提交文件到仓库

-m 参数：后面跟着的是本次提交的说明

### 查看仓库当前状态

```
$ git status
```

### 查看文件的更改内容

```
$ git diff readme.txt
```

### 显示提交日志

```
$ git log
```

显示简略的提交日志

```
$ git log --pretty=oneline
```

### 回退到上一个版本

```
$ git reset --hard HEAD^
```

上一个版本就是`HEAD^`，上上一个版本就是`HEAD^^`，当然往上100个版本写100个`^`比较容易数不过来，所以写成`HEAD~100`。

回退到任意版本

```
$ git reset --hard 1094a
```

其中1094a是版本号，可以用git log或者git reflog来找版本号；

```
$ git reflog
```

### 丢弃工作区修改

1、还没有使用git add存到暂存区，可以用

```
$ git checkout -- readme.txt
```

这里有两种情况：

一种是`readme.txt`自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；

一种是`readme.txt`已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。

总之，就是让这个文件回到最近一次`git commit`或`git add`时的状态。

2、已经用git add存到暂存区，可以用

```
$ git reset HEAD readme.txt
```

然后

```
$ git checkout -- readme.txt
```

### 从版本库中删除文件

```
$ git rm test.txt
```

先手动删除文件，然后使用git rm <file>和git add<file>效果是一样的。

### 配置远程仓库

生成SSH Key 私钥和密钥

```
ssh-keygen -t rsa -C "1572236483@qq.com"
```

将本地仓库和远程仓库关联

```
git remote add origin git@github.com:nigaknight/Test2.git
```

推送内容到远程仓库

```
git push -u origin master
```

-u 参数：将本地的master分支和远程的master分支关联起来，之后就可以简化推送操作

删除本地仓库和远程仓库的关联关系

```
git remote rm origin
```

从远程仓库克隆到本地库

```
git clone git@github.com:michaelliao/gitskills.git
```

### 创建与合并分支

创建并切换到分支dev

```
$ git checkout -b dev
```

参数 -b：表示切换到新分支

相当于以下两条命令

```
$ git branch dev
$ git checkout dev
```

命令 git branch：创建分支

命令 git checkout：切换分支

查看所有分支

```
$ git branch
```

合并指定分支到当前分支

```
$ git merge dev
```

删除分支

```
$ git branch -d dev
```

删除远程分支

```
git push origin -d dev
```

### Github访问慢的解决方法

修改访问Github的DNS

使用DNS查询网站**http://tool.chinaz.com/dns**，查找访问github网站TTL最小的IP地址，写到电脑里面C:\Windows\System32\drivers\etc目录下的hosts文件中

如：

```
192.30.255.113 github.com
```

在CMD窗口中ping github.com可以看到访问该网站的速度。