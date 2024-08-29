# 大事件平台

---
>这是一个由`zank`开发的SpringBoot+Vue前后端分离项目，此为后端部分，项目主要分为三个模块：
> * 文章分类管理
> * 文章管理
> * 用户管理

使用方法：将[application.yml](./src/main/resources/application.yml)的`profiles`改为`pro`生产环境，然后配置数据库信息，和redis信息，并在环境变量添加`ALIBABA_CLOUD_ACCESS_KEY_ID`和`ALIBABA_CLOUD_ACCESS_KEY_SECRET`为你自己的阿里云的密钥，然后运行项目即可。

可将项目`mvn package`后生成的jar包，使用`java -jar big_event-0.0.1-SNAPSHOT.jar`命令运行或部署到服务器。

### 附录
[数据库文件(bigevent.sql)](./bigevent.sql)