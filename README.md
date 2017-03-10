#spring_boot #spring

<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.1.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>

spring-boot-starter-web

https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
http://www.vogella.com/tutorials/Hamcrest/article.html
==========================================================

application.properties
applocation-{profile}.properties
YAML format

# profile is active
spring.profiles.active=production

# default log config
logging.level.org.springframework.web=DEBUG

# default server config
server.port=8080

# spring resouces handling
spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/ # Locations of static resources.

==========================================================
logging.path -> windows paths ???

==========================================================
spring boot starter data jpa

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

data source configuration
data source pooling -> tomcat-jdbc is default pooling strategy

@Configuration
	public class PersistenceConfiguration {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
		public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}

==========================================================
JPA
Spring Data JPA

@Entity -> @Id, @GeneratedValue(strategy=Generation.AUTO)
Repository -> @Repository interface extends JpaRepository<{Entity class name}, Long>
	findAll(), findOne(id), saveAndFlush(), delete(id)
Use: inject repository with @Autowired

https://spring.io/guides/gs/accessing-data-jpa/
https://spring.io/guides/gs/accessing-data-rest/

==========================================================
UNIT TEST - INTEGRATION TEST - WEB INTEGRATION TEST
https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-1.4-Release-Notes

Integration test
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemo1Application.class)

Web Integration test
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

==========================================================
Spring Data JPA -> JpaRepository (Repository -> spring standard data concept, not jpa)
https://app.pluralsight.com/library/courses/spring-data-jpa-getting-started/table-of-contents

CRUD operations: Create, Read, Update, Delete

+ JPA
+ Data Access Layer (Persistence Tier)
	-> (Repository, Entity) <=> DB table
+ Repository Generator
+ Query DSL (Domain Specific Language)
+ Auditing paging

github.com/dlbunker/ps-guitar-db

@Entity
@NameNativeQuery(name, query, resultClass)

@Repository -> Spring concept

JpaRepository
+ interface
+ Map 1 to 1 with a JPA entity
+ Focus on DAO contract (query DSL)
+ Best practices:
	++ structure: model, repository, controller for each module
	++ class name: {name}JpaRepository.java
	++ @Repository (not necessary) just for clear

proxy strategy -> migrate standard repository to jpa repository (inject jparepository in repository -> keep the old code in controller and test)

+ Query DSL
	++ Advantages: utilize your work; less code, less to maintain; check your queries at startup rather than runtime
	++ Query method syntax basics:
		+++ find..By, query..By.., findFirstBy..,
		+++ And, Or
		+++ findByErreurLike
		+++ findByStateAndCountry
		+++ findByStateOrState

+ @Query annotation, jpa query (JPQL)
	++ Name parameters: :name, @Param
	++ Enhanced JPQL syntax: ..like %?1
	++ Native queries: nativeQuery = true
	++ Modifiable queries: @Modifying

+ JPA Named Queries
	++ @NamedQuery in @Entity class
	++ @NamedQuery(name="..", query="..)
	++ App startup validates queries rather than at runtime

+ Native SQL support
	++ @Query("..", nativeQuery=true)
	++ NamedNativeQuery(..)

+ Custom repository: impl suffix
















