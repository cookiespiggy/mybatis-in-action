#mybatis开发说明
在用mybatis开发的过程中,我们先写了接口,然后又写了配置文件,对应起来,就可以去用了.
这种方式比较麻烦,我们也可以用逆向工程,但是都是同理,有接口也有配置文件.
那么我们可以试想一下,我们能否只写接口,不写配置文件,就可以完成CRUD操作呢?
使用通用Mapper.
1. 导入依赖
2. 集成Mapper(以Mybatis插件的方式)
