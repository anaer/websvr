SpringMVC 开发步骤
1. 新建Dynamic Web Project
2. Configure -> Convert to Maven Project 转换为Maven工程
3. 配置pom。xml, 添加spring依赖
    <properties>
        <spring.version>4.0.4.RELEASE</spring.version>
    </properties>

    <dependencies>
        <!-- spring jar包 -->
        <dependency>
            <artifactId>spring-orm</artifactId>
            <groupId>org.springframework</groupId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
    </dependencies>
4. 配置web.xml, 添加分发器DispatcherServlet,指定contextConfigLocation
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/conf/springMVC.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
5. 对应指定的contextConfigLocation,添加springMVC.xml配置文件
  1) 指定默认扫描包
  2) 添加注解支持
  3) 定义跳转后缀
6. 编写后台代码
