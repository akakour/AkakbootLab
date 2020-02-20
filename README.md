## SpringBoot 整合 api文档框架Swagger2
### jar包导入
```xml
<!--    swagger2 相关-->
<dependency>
     <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>2.9.2</version>
</dependency>
<dependency>
       <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
</dependency>
```
### 修改配置文件，配置类
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.akakour.lab.swagger.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot 整合 Swagger2")
                        .description("Swagger2 —— api文档框架")
                        .version("0.1")
                        .contact(new Contact("Akakour", "www.akakour.com", "akakour@qq.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.swagger2.akakour.com")
                        .build());
    }
}
```
### swagger2 相关注解的使用
```java

@RestController
//Api的主分类
@Api(tags = "SpringBoot 整合 Swagger2，这是一个Controller接口测试")
public class SwaggerController {

    @Data
    public class User {
        String name;
        String city;
    }

    @PostMapping("/getUserById/{id}")
    //Api的动作描述
    @ApiOperation("查询个人信息")
    //Api的参数信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "个人ID")
    })
    public User getUserById(@PathVariable("id") String id) {
        User user = new User();
        user.setName("akakour");
        user.setCity("ToKyo Shinagawa");
        return user;
    }
}

```
### 浏览器访问
浏览器输入
```xml
http://ip:端口/swagger-ui.html
```
### 高级应用
