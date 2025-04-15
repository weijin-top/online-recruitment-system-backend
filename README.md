# online-recruitment-system-backend | 求职招聘系统

#### 友情提示

> 1.**项目演示地址**: [bilibili演示地址](https://www.bilibili.com/video/BV1tYPUeJEaF/)

> 2.**前端仓库地址**：[配套项目前端地址](https://gitee.com/weijin-top/online-recruitment-system-frontend.git)

#### 介绍

本项目为求职招聘系统，该仓库为**后端**，本项目已经完成，如有疑问可以在issue中提问，看见会仔细回答各位。  
如在测试过程中发现bug，请及时联系，有时间会一一修复，联系方式在下方

**如果各位喜欢，麻烦各位大佬点点Star**

##### 温馨提示

1. 我会给两个SQL文件，一个是仅有结构，另一个包括结构和数据，如果使用包含数据的SQL脚本文件，里面用户表的所有密码均为**123456**
2. 如果使用含数据的SQL脚本，图片可能无法正确展示
3. **配置文件application.yml文件中 “XXXXXXXXXXXXX”一定要改为自己正确的**
4. 本项目配置了minio本地存储和OSS阿里云存储，**建议使用minio存储**，需**先安装minio到本地**，网上有许多教程，再**访问minio web网页创建一个新的Bucket**，接着**创建Access Keys**
   ,最后**配置修改配置文件minio信息**
5. 注意：使用了minio本地存储图片，页面中的图片无法显示，需要在将数据库图片地址修改为自己上传到minio上的地址，数据库只需要recruitment后面的地址(包含recruitment/，因为前端做了图片代理)
6. **minio中一定要开启权限，步骤（以开启online-recruitment-system的权限为例）Buckets->online-recruitment-system->Access Policy 一定要设置为public(
   非常重要！！！)**

#### 安装

1. 拉取项目

   ``` bash
   git clone https://gitee.com/weijin-top/online-recruitment-system-backend.git
   ```

2. 导入IDEA，配置好maven、java版本（需要java17版本）

3. 配置application.yml，配置好mysql、redis和阿里云OSS。

4. 直接点运行就可以使用了

#### 开发环境

| 工具  | 版本号 | 下载                                                        |
| ----- | ------ | ---------------------------------------------------------- |
| JDK   | 17     | https://www.oracle.com/java/technologies/downloads/#java17 |
| MySQL | 8.0.36 | https://downloads.mysql.com/archives/installer/            |
| Redis | 7.0    | https://redis.io/download                                  |

#### 联系方式

微信：weijin-top  
QQ： 3413105907

#### 功能结构图

![输入图片说明](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/function/在线求职招聘系统-功能结构图.png)

### 项目展示

#### 管理员

![管理员-首页](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/管理员-首页.png)

![管理员-企业审核-审核通过](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/管理员-企业审核-审核通过.png)

![管理员-职位类别管理](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/管理员-职位类别管理.png)

#### 招聘者

![招聘者-处理简历](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/招聘者-处理简历.png)

![求职者_招聘者-聊天](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者_招聘者-聊天.png)

![招聘者-面试管理-未处理](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/招聘者-面试管理-未处理.png)

![招聘者-投递管理](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/招聘者-投递管理.png)

#### 求职者

![求职者-简历预览](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者-简历预览.png)

![求职者-首页](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者-首页.png)

![求职者-投递箱](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者-投递箱.png)

![求职者-我的面试](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者-我的面试.png)

![求职者-查看面试结果](https://gitee.com/weijin-top/online-recruitment-system-backend/raw/master/image/printscreen/求职者-查看面试结果.png)
