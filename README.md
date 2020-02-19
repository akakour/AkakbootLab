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
### 浏览器访问
### 高级应用
