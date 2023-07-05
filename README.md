# MoeClassroomManager
Moe 教室管理系统前端基于 HTML, CSS, JavaScript, 后端基于 Spring Boot + MyBatis 框架构建, 使用 Maven 进行项目管理, 使用 MySQL 作为数据库，推荐使用 IntelliJ IDEA 作为开发环境 

## 功能特点

1. 教室预约功能: 

   - 学生和老师可以进行教室预约
   - 学生预约需要辅导员一级审批和楼长二级审批通过
   - 如果一级或二级审批未通过, 系统将提示填写未通过原因
   - 老师预约只需要楼长审批

2. 教学楼信息管理: 

   - 管理教学楼的基本信息
   - 每个教学楼对应一个楼长

3. 教室信息管理: 

   - 管理教室的基本信息
   - 设置教室的固定上课占用情况, 例如每周某天某节该教室有课

   - 对于未被占用的教室, 允许临时预约使用

4. 用户信息管理: 

   - 用户信息, 包括学生, 老师, 辅导员和楼长的信息管理
   - 普通管理员可以管理除了用户账户以外的所有信息, 超级管理员除普通管理员权限外还可管理用户账户信息
   - 用户可以自行修改密码

5. 班级管理: 

   - 一个辅导员可以管理多个班级
   - 学生预约教室需要经过班级辅导员一级审批

## 快速开始

1. 克隆项目到本地: 

   ```bash
   git clone git@github.com:TomyJan/MoeClassroomManager.git
   ```

2. 导入项目到 IntelliJ IDEA 或其他支持的 IDE 

3. 配置数据库: 

   1. 在 MySQL 数据库中创建一个新的数据库, 或者运行 `./docs/create_database.sql` 以创建数据库
   2. 运行 `./docs/install.sql` , 以完成数据库的初始化和示例数据的导入
   3. 打开 `./src/main/resourcs/application-dev.yml` 文件，配置数据库连接信息。

4. 运行项目: 

   - 在 IntelliJ IDEA 中点击 **Run -> Run 'Application'** , 项目将在嵌入式 Tomcat 服务器上启动
   
5. 访问应用程序: 

   - 在浏览器中访问 `http://localhost:81`, 即可开始使用教室管理系统

## 部署

在开发完成后，可以使用 Maven 构建 jar 文件, 以便将其部署到生产环境

## 许可证

该项目采用 MPL 2.0 许可, 有关更多信息, 请参阅 [LICENSE](/LICENSE) 文件

