# Interview 面试题 SpringBoot 版
### 涵盖了很多知识面 从基础的Java基础到面向对象、设计模式，以及Java8新特性。
### 主要是后端方向 SSM + SpringBoot + SpringCloud（暂时不会写）
### MybatisPlus：
* 常用实现 IService、BaseMapper
* 分页（使用MybatisPlus之后就没必要使用PageHelp了，两者会发生冲突，实际上MybatisPlus会和很多Mybatis相关的东西发生冲突，要不就屏蔽到一些，要不就不要添加依赖） 
### Redis 缓存：
* 使用SpringBoot的RedisTemplate操作Redis
* 使用布隆过滤器解决缓存穿透（BloomFileter） 双重校验锁单例模式+可序列化到本地+恢复
### RabbitMq 消息队列:
* 几种消息模型
* 延迟队列
### 平时使用到的工具类 生成Excel + 压缩文件 + 发送邮件

