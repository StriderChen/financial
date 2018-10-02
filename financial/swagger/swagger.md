### swagger注解
    swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
    
    @Api：修饰整个类，描述Controller的作用
    @ApiOperation：描述一个类的一个方法，或者说一个接口
    @ApiParam：单个参数描述
    @ApiModel：用对象来接收参数
    @ApiProperty：用对象接收参数时，描述对象的一个字段
    @ApiResponse：HTTP响应其中1个描述
    @ApiResponses：HTTP响应整体描述
    @ApiIgnore：使用该注解忽略这个API 
    @ApiError ：发生错误返回的信息
    @ApiParamImplicitL：一个请求参数
    @ApiParamsImplicit 多个请求参数
    
### Swagger
#### 引入
    @import,组合注解
    spring.factories ## 依赖添加进来即可
    @ConfigurationProperties
#### 工具
    swagger ui
    swagger editor
    swagger codegen