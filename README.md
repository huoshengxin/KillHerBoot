说明: 

- /static、/public、/resources、和/META-INF/resources，
默认映射路径都是/。SpringBoot 默认会按照
META/resources > resources > static > public 
的优先级寻找对应的资源文件并返回第一个找到的文件。
-  http://127.0.0.1:8089/pic.png 可以直接访问到图片
- SpringBoot 官方原话 : 如果你的应用使用 jar 打包，不要使用/src/main/webapp 目录，尽管它是一个标准目录,该目录仅仅在使用 war 打包部署的时候生效，在大部分构建工具都它都会被忽略



>value	String	设置事务管理器(可选)
transactionManager	String	设置事务管理器(可选)
propagation	enum: Propagation	事务传播行为 (可选)
isolation	enum: Isolation	事务隔离级别 (可选)
timeout	int	事务超时时间 (可选)
readOnly	boolean	是否只读事务，默认 false，即为读写事务 (可选)
rollbackFor	Class 对象数组，继承自 Throwable	导致事务回滚的异常类数组 (可选)
rollbackForClassName	类名数组，继承自 Throwable 的类名	导致事务回滚的异常类名字数组 (可选)
noRollbackFor	Class 对象数组，继承自 Throwable	不会导致事务回滚的异常类数组 (可选)
noRollbackForClassName	类名数组，继承自 Throwable 的类名	不会导致事务回滚的异常类名字数组(可选)


### Aop常用注解
- 注解	描述
- @Before	在方法执行前执行
- @After	在方法执行后执行
- @AfterReturning	在结果返回后执行
- @AfterThrowing	在抛出异常后执行
- @Around	环绕通知，相当于同时使用@Before 和@After


### SpringBoot配置信息的查询
    上面提及过，SpringBoot的配置文件，主要的目的就是对配置信息进行修改的，但在配置时的key从哪里去查询
    呢？我们可以查阅SpringBoot的官方文档
    文档URL：https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/htmlsingle/#common-applicationproperties
    常用的配置摘抄如下：
    我们可以通过配置application.poperties 或者 application.yml 来修改SpringBoot的默认配置
    例如：
    application.properties文件
    application.yml文件
    spring.quartz.properties.*= # Additional Quartz Scheduler properties.
    # ----------------------------------------
    # WEB PROPERTIES
    # ----------------------------------------
    # EMBEDDED SERVER CONFIGURATION (ServerProperties)
    server.port=8080 # Server HTTP port.
    server.servlet.context-path= # Context path of the application.
    server.servlet.path=/ # Path of the main dispatcher servlet.
    # HTTP encoding (HttpEncodingProperties)
    spring.http.encoding.charset=UTF-8 # Charset of HTTP requests and responses. Added to
    the "Content-Type" header if not set explicitly.
    # JACKSON (JacksonProperties)
    spring.jackson.date-format= # Date format string or a fully-qualified date format
    class name. For instance, `yyyy-MM-dd HH:mm:ss`.
    # SPRING MVC (WebMvcProperties)
    spring.mvc.servlet.load-on-startup=-1 # Load on startup priority of the dispatcher
    servlet.
    spring.mvc.static-path-pattern=/** # Path pattern used for static resources.
    spring.mvc.view.prefix= # Spring MVC view prefix.
    spring.mvc.view.suffix= # Spring MVC view suffix.
    # DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
    spring.datasource.driver-class-name= # Fully qualified name of the JDBC driver. Autodetected
    based on the URL by default.
    spring.datasource.password= # Login password of the database.
    spring.datasource.url= # JDBC URL of the database.
    spring.datasource.username= # Login username of the database.
    # JEST (Elasticsearch HTTP client) (JestProperties)
    spring.elasticsearch.jest.password= # Login password.
    spring.elasticsearch.jest.proxy.host= # Proxy host the HTTP client should use.
    spring.elasticsearch.jest.proxy.port= # Proxy port the HTTP client should use.
    spring.elasticsearch.jest.read-timeout=3s # Read timeout.
    spring.elasticsearch.jest.username= # Login username.