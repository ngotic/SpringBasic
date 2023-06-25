# 스프링 프레임워크 개념정리 및 복습 > Spring MVC
- 스프링 프로젝트 환경설정하기 ☞ [링크](https://github.com/ngotic/SpringBasic/wiki/%EC%8A%A4%ED%94%84%EB%A7%81-MVC-%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0)

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
## ★ @Controller, @Service, @Repository 의미론적으로 정의해놓은 애너테이션인데 내부에 다 @Component를 가지고 있다. 


### ★ Impl쪽에 애너테이션을 붙인다는 것이 핵심이다. 
### XXXDAO.java, XXXService.java 이런 것들은 그냥 인터페이스로 정의한다는 것이다. 
### ★ 로직구분은 컨트롤러, 서비스, 리파지토리, 도메인인데 Mapper 인터페이스를 정의해서 서비스단에서 주입받아서 쓰는 식으로 하기도 한다. 

## 2. WebTest

## 1). 애너테이션 안쓰고 상속으로 정의한 Controller 
- import org.springframework.web.servlet.mvc.Controller; 라는 인터페이스가 있다. 이거 그냥 구현해서 Controller를 정의하면 된다. 
 - handleRequest를 재정의하고 ModelAndView는 모델과 뷰 정보를 담는다. 
 ```java

// 서블릿 역할
public class Ex01Controller implements Controller{
	
	// 요청 메소드
	// doGet/doPost == handleRequest
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// RequestDispatcher > forward()
		// Model > 데이터 전송
		// View  > JSP
		ModelAndView mv = new ModelAndView();
		// mv.setViewName("/WEB-INF/views/ex01.jsp"); // 에러다.> 뷰리졸버 생략시 이거 쓰기
		mv.setViewName("ex01"); 
        mv.addObject("ex01_data","123");
		request.setAttribute("name", "홍길동");	
		return mv;
	}
}

 ```

 ## 2). Controller 애너테이션을 쓰면 좀 더 편해진다. 

 ```java
// 이런거 씸플하고 
@Controller
@RequestMapping(value="/ex03.do", method=RequestMethod.GET)
public class Ex03Controller {
	// 요청 메서드(핸들러) > 메서드 이름을 맘대로 ~
	@RequestMapping
	public String test() {
		return "ex03"; // JSP 페이지 이름이라 생각 > View Resolver가 동작이 된다. 
	}
}
 ```
- 상위 주소를 클래스 위쪽에다가 적는다. 
 ```java
@Controller 
@RequestMapping("/ex04") // 컨트롤러하나당 가상주소 겁나 늘릴 수 있다. 
public class Ex04Controller {
	//http://localhost:8091/web/ex04/ex04.do
	@RequestMapping("/ex04.do") 
	public String ex04() {
		return "ex04";
	}
	@RequestMapping("/ex04_1.do") 
	public String ex04_1() {
		return "ex04";
	}
}

 ```

 ### ex05.jsp > ex05ok.do 으로 데이터 전송
 ```html
 <body>
	<h1>데이터 전송</h1>
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="text" name="data"></div>
		<div><input type="submit" value="보내기"></div>
	</form>
	
	<h1>복합 데이터 전송</h1>
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="text" name="nick"></div>
		<div><input type="text" name="age"></div>
		<div><input type="text" name="address"></div>
		<div><input type="submit" value="보내기"></div>
		
		<input type="hidden" name="seq" value="10">
	</form>
	<h1>다중 데이터 전송</h1>
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="checkbox" name="cb" value="1">사과</div>
		<div><input type="checkbox" name="cb" value="2">버너너</div>
		<div><input type="checkbox" name="cb" value="3">딸기</div>
		<div><input type="checkbox" name="cb" value="4">귤</div>
		<div><input type="checkbox" name="cb" value="5">포도</div>
		<div><input type="submit"   value="보내기"></div>
	</form>
</body>
```

- 스프링 4.3부터 @GetMapping, @PostMapping 제공하니까 이거 써라 ~ 

```java
@Controller
public class Ex05Controller {
	
	@GetMapping("/ex05.do")   // 뷰 불러옴 
	public String ex05() {
		return "ex05";
	}

	@PostMapping("/ex05ok.do") // addok.do 역할
	public String ex05ok(HttpSession session,
			HttpServletRequest req,
			HttpServletResponse resp) {
		// 얘네 매개변수 위치를 바꾸어도 상관이 없다.
		System.out.println(req == null); // false
		System.out.println(resp == null); // false
		System.out.println(session == null); // false
		String data = req.getParameter("data"); 
		// 이거 request를 잘안쓴다. > 물론 쓸 수는 있다. 
		// 서블릿처럼 Post 전송의 바디 내용을 이렇게 받는 것이 가능 
		req.setAttribute("data", data); // 가능
		return "ex05ok";
	}


    // ModelAndView 요거... 잘 안쓴다. 
    // @RequestParam으로 Post나 Get 방식의 데이터를 받고 
    // Model로 데이터를 담아서 뷰로 전송한다. 
    @PostMapping("/ex05ok.do")
	public String ex05ok(@RequestParam("data") String data,
                         Model model) {
		System.out.println(data);		
		model.addAttribute("data", data); 
		return "ex05ok";
	}

    //위에서 @RequestParam("data")을 생략할 수 있다. 생략해버리면 
    // String data 에서 data 이름으로 파라미터가 만들어진다. 


    // 이런식으로 데이터를 GET, POST로 파라미터로 받고 
    @PostMapping("/ex05ok.do")
	public String ex05ok (
				Model model,
				String name,
				String age,
				String address
			) {
		SpringDTO dto = new SpringDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		// 모델에 넣어서 뷰단으로 전송한다. 
		model.addAttribute("dto", dto);
		
		return "ex05ok";
	}
    // 뷰에서는 ${dto.name} 이런식으로 꺼내쓴다. 

    // 복수 데이터 전송 처리 위에처럼 다중 체크해서 전송하는 경우 
    @PostMapping("/ex05ok.do")
	public String ex05ok(Model model,
			// @RequestParam("cb") String[] cb // 된다. 
			String[] cb                          // 된다. 
			//@RequestParam("cb") List<String> cb // 된다. 
			//List<String> cb //이건 안된다.
			//ArrayList<String> cb //이건 안된다.
			){
		//String[] list = req.getParameterValues("cb")
		model.addAttribute("cb", cb);
		return "ex05ok";
	}
    // ArrayList 클래스는 @RequestParam 생략처리 불가 

    //@ModelAttribute 이놈은 자동으로 addAttribute 해주는 친구다. value 형태는 바로 아래
	@PostMapping("/ex05ok.do")
	public String ex05ok(@ModelAttribute("data") String data) {
		// @ModelAttribute("data") 이걸 쓰면 
		// model.addAttribute("data", data); 와 같다.   
		return "ex05ok";
	}

    // 객체 경우는 아래처럼 @ModelAttribute이 사용된다.
    // 객체를 파라미터로 쓰는 경우에는 @ModelAttribute가 자동으로 생략된다.
    // 이때 setter 정의 해놔야 하고 input의 name태그와 setter에 정의된 객체 이름과 같아야 한다. 
    @PostMapping("/ex05ok.do") 
	public String ex05ok( @ModelAttribute("dto") SpringDTO dto) {
			// SpringDTO dto) {
		//1. <input type="text" name="name">
		System.out.println(dto);
		
		return "ex05ok";
	}
    // ★ input 태그 여러개로 정의한 것들을 form으로 전송했을 때 객체로 맵핑되는 예제 > ★ 개편함
}


```
### ★ @ModelAttribute 나 @RequestParam이 생략되었더라도 파라미터의 Type이 뭐냐에 따라서 자동으로 붙여준다. 
- Type이 참조형일 때 > @ModelAttribute
- Type이 기본형, String 일 때 @RequestParam

### ex06Controller.java
```java
@Controller
public class Ex06Controller {

    // 스프링은 아래처럼 redirect와 forward를 String 키워드 형태로 사용가능하다.
    @GetMapping("/ex06.do")
	public String test() {
		return "redirect:/ex05.do";
		//return "forward:/ex05.do";
	}


    @GetMapping("/ex06.do")
    public String test(RedirectAttributes rttr) {
    	String seq  = "5";
    	String type = "1";
    	rttr.addAttribute("seq", seq);
    	rttr.addAttribute("type", type);
    	// 쿼리 스트링을 안붙이고 RedirectAttributes를 사용하여 파라미터를 넘긴다. 
    	// return "redirect:/ex05.do?seq=" +seq + "&type=" + type;
    	return "redirect:/ex06.do";
    }

    @GetMapping("/ex06.do")
	public @ResponseBody SpringDTO test() {
		
		SpringDTO dto = new SpringDTO();
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		
		return dto;
	}
    // [★★응답★★]
    // Return형으로 저렇게 써주면 JSON으로 자동으로 바꿔준다. 
    // @ResponseBody > 이거 덕분에 JSONArray로 만들 필요가 없다. 
    //@ResponseBody 쓰고 옆에 타입을 써주는데 리스트도 된다. 
    //	@GetMapping("/ex06.do")

	public @ResponseBody List<SpringDTO> test() {	
		List<SpringDTO> list = new ArrayList<SpringDTO>();
		SpringDTO dto = new SpringDTO();
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		list.add(dto);
		
		return list;
	}
}
```
### Ex07Controller.java
- @RequestParam에 defaultValue 라는게 있다. 이걸로 값을 넣어준다. 
- 이걸 안넣어주면 
- required=true, required=false 라는 옵션도 있는데 필수로 넣어주냐 안넣어주냐의 차이다. 
``` java
@Controller 
public class Ex07Controller {
	@RequestMapping(value="/ex07.do", method=RequestMethod.GET) 
	public String ex07(@RequestParam(value="num", defaultValue="10") int num, Model model) {
		model.addAttribute("num", 100/num);
		return "ex07";
	}
}
```

### 에러셋팅 

* ControllerAdvice를 붙이면 모든 Controller에서 발생하는 예외를 하나의 클래스 안에 있는 예외처리 메서드에서 처리한다. 
```java

//얘도 컴포넌트의 일정이다. 이 패키지가 ★★'스캔'의 대상이 되어야 한다.
@ControllerAdvice  
@Log4j
public class CommonExceptionAdvice {
	//ArithmeticException 산술이면 이거
	// , Model을 만들어서 데이터를 같이 넘길 수 있다.  
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		log.error("예외 발생");
		model.addAttribute("code","A001");
		model.addAttribute("e", e);
		return "error";
	}	
	// 이 두개의 조합으로 404에러가 났을 때 처리가 가능하다.
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notfound() {		
		return "notfound";
	}
}

// Exception을 Throw하는지 여부 셋팅인데 이게 false가 기본값이라 true로바꿈 
// 이부분이 web.xml에 추가된다. 
<init-param>
		<param-name>throwExceptionIfNoHandlerFound</param-name>
		<param-value>true</param-value>
</init-param>
```
- 이러한 방식으로 METHOD를 두개 등록할 수 있다.
```java
@RequestMapping(value="/list.do", method= { RequestMethod.GET, RequestMethod.POST})
	public String list() {
		return "list";
	}
```