# 스프링 프레임워크 개념정리 및 복습 > Spring MVC
## 1. BeginTest 

### com.test.di01
- 기존 : 의존 A라는 객체의 메서드에서 B라는 객체를 직접 생성해서 사용
- DI사용 : 밖에서 객체를 만들고 A쪽으로 생성자 혹은 Setter를 이용하여 주입 받는다. 


### com.test.di02
- New > Spring Bean Configuration File 이렇게 하면 파일이 xml 파일을 만들 수 있다. 
- xml 정의 
```html
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">


</beans>
<!--이런게 위에 들어가 있다. 이클립스에서 namespaces 탭에서 다른 namespace를 추가할 수 있다. 
이런 형식은 root-context.xml의 모양이다. 
여기에 bean이라는 것을 정의한다. 
-->
```
- Bean은 자바빈에서 유래한 말로 그냥 객체이다. 근데 이 Bean을 xml에 정의할 수 있다. 
- 그리고 생성자 방식, Setter 방식으로 주입할 수 있다. 
```html
 <bean id = "pen" class="com.test.di02.Pen"></bean>
   				<!-- 이름 여러개를 붙일 수 있고 스페이스를 둬야 한다. 별칭이다. name : alias -->
   				<!-- 한 객체를 여러 이름으로 다양하게 만들고 싶다면 이렇게 쓴다. -->
   <bean id="brush" name="b1 b2 b3" class="com.test.di02.Brush"></bean>
   <!-- xml에서 객체를 찾는 기준은 id > name 순이다. -->
   
   <!-- getBean은 Type 기준으로 우선순위로 찾는다. -->
   
   <!-- 스프링이 빈을 만들 때 생성자에 주입할 내용있으면 여기에 넣어주세요. 이게 의존주입이다. -->
   <bean id="hong" class="com.test.di02.Hong">
   		<!-- 스프링 의존 주입(DI)이다. : Constructor 
   		앞에서 Pen을 만들고 주입을 하는 것이다. 안전성은 생성자 주입이 높고 사용도 이게 편하다. -->
   		<constructor-arg ref="pen"></constructor-arg>
   </bean>
   
   <bean id="lee" class="com.test.di02.Lee">
   		<!-- 스프링 의존 주입 : Setter -->
   		<property name="brush" ref="brush"></property>
   </bean> 
```

- name이라는 것을 사용하여 id 다음으로의 별명을 지을 수 있다. 하지만 bean을 찾을 때 우선순위는 id > name이다. 
```html
// 아래것은 ref 형식으로 넣을 땐데 이미 정의된 bean을 참조
<property name="brush" ref="brush"></property>

// value형식으로 값을 넣을 수 있다. 
<property name="brush" value="값"></property>

// 또한 아래와 같이 생성자 형식으로 넣을 땐 이렇다.
<constructor-arg ref="pen"></constructor-arg>
```

- 대충 흐름은 xml을 컨텍스트로 등록하고 그 안에 bean을 getBean으로 꺼내쓴다는 이야긴데 뭘로 찾는 지는 id 혹은 name으로 뒤진다는 이야기, name으로도 찾고 id로도 찾을 수 있다는 이야기 
``` java
//ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/di02/di02.xml");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/di02/di02.xml");  // 이건 상대경로다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/di02/di02.xml"); 
		context.getBean("pen"); // 1. id로 팬을 찾고, 2. id에 박힌 Class 위치를 찾고, 3. 객체를 만든다.
		
		Pen p2 = (Pen)context.getBean("pen"); // id
		p2.write();
		
		Brush b1 = (Brush)context.getBean("b1");   // name
		b1.draw();
		
		Brush b2 = (Brush)context.getBean("b2");   // name
		b2.draw();
		
		Brush b3 = (Brush)context.getBean("brush"); // name
		b3.draw();
```

- 사실은 이 과정이 두 파트이다. context에 bean이 있다는 것을 <b>알고</b>[등록], 그것을 [주입]한다. 

- @Autowired는 자동으로 주입한다라는 말이다. 
- ★ 근데 등록을 해야 주입이 가능하다. 
- 이럴 때 component-scan이 필요하다. 내가 만든 controller, repository, service 역할을 같은 클래스를 컴포넌트로 처리해서 빈으로 등록하기 위해선 스캔이 필요하고 이 때 component-scan을 쓴다. 
- 빈 스캔이 되어 등록이 되면 @Autowired로 주입해서 사용한다. 
- 보통은 Controler에서 멤버변수 선언할 때 @Autowired 붙이는 식으로 주입을 많이 한다. 
- 즉 애너테이션 방식과, xml 방식으로 빈의 등록, 주입이 가능하다는 것이다.
- xml 방식 쓸 때는 외부 라이브러리 끌어올 때, 애너테이션 방식은 우리가 만든 로직을 빈으로 등록, 주입할 때 쓴다. 

### 스프링에서 주입 확인하기 
```java
1. 컨트롤러 코드에서 아래처럼 정의
@Controller
public class BoardController {


2. 이렇게 component-scan을 하여 빈 찾기  <context:component-scan base-package="com.test.di05"></context:component-scan>

3. 테스트코드에서 확인 > 주입해보고 NotNull인지 확인
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 있는거 쓰다보니까... 얘를 씀 어떤거 써도 갠찬
@Log4j
public class AnnotationTest {
	@Autowired
	private BoardController controller;
	// 컨트롤러를 주입했을때 이게 Null인지 확인한다. 
	@Test
	public void testController() {
		assertNotNull(controller); 
		controller.doGet();
	}
}	
```
- 위의 방식을 애노테이션을 안쓰면 
- root-context.xml에서 아래처럼 정의
```html
<bean id="controller" class="com.test.di04.BoardController">
		<constructor-arg ref="service"></constructor-arg>
	</bean>
	
	<bean id="service" class="com.test.di04.BoardServiceImpl">
		<property name="dao" ref="dao"></property>
	</bean>
	<!-- 직접 넣을 수도 있는데 직접 넣으면 재사용이 떨어진다. -->
	
	<bean id="dao" class="com.test.di04.BoardDAOImpl"></bean>
```
- 위로 xml 방식으로 등록한 결과로 자바단에선 아래처럼 주입이 된다. (@Autowired가 없이도 객체가 만들어진거임)
- 참조 참조 참조 연쇄과정이 있다. 
```java
public class BoardController {	
	private BoardService service;
	public BoardController(BoardService service) {
		this.service = service;
	}
	public void doGet() {
		this.service.list();
	}	
}

public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	@Override
	public void list() {
		this.dao.list();
	}
}

```


### ★ Impl쪽에 애너테이션을 붙인다는 것이 핵심이다. 
### XXXDAO.java, XXXService.java 이런 것들은 그냥 인터페이스로 정의한다는 것이다. 
### ★ 로직구분은 컨트롤러, 서비스, 리파지토리, 도메인인데 Mapper 인터페이스를 정의해서 서비스단에서 주입받아서 쓰는 식으로 하기도 한다. 

## 2. WebTest
 