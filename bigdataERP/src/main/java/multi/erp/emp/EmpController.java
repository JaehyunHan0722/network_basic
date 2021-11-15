package multi.erp.emp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping("/emp/insert.do")
	//스프링 MVC의  DispatcherServlet이 넘겨주는 VO객체를 서비스단의 메소드를 호출하면서 넘겨준다.
	public String insert(EmpVO command) { //VO객체를 command객체라 한다.
		System.out.println("================="+command);
		service.insert(command);
		return "redirect:/emp/loginPage.do";//회원가입이 완료되면 로그인을 하기 위한 페이지로 redirect하도록 설정
	}
	@RequestMapping("/emp/list.do")
	public ModelAndView getMemberList() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> userlist =  service.getMemberList();
		System.out.println("***********************************************");
		System.out.println(userlist);
		//tiles에 등록한 뷰의 이름
		mav.setViewName("emp/list");
		mav.addObject("userlist", userlist);
		return mav;
	}
	//원래 웹을 요청하는 방식(동기) => emp/insert로 등록한 뷰의 모든 html태그가 서버에서 클라이언트로 전송된다. 
//	@RequestMapping("/emp/idcheck.do")
//	public ModelAndView idCheck(String id) {
//		ModelAndView mav = new ModelAndView();
//		boolean state = service.idCheck(id);
//		String result = "";
//		if(state) {//사용자가 입력한 id가 db에 이미 저장되어 있다는 의미
//			result = "사용 불가능한 아이디";
//		}else {
//			result = "사용가능한 아이디";
//		}
//		mav.setViewName("emp/insert");
//		mav.addObject("result", result);
//		return mav;
//	}
	// Ajax로 요청되는 메소드
	/* produces속성 : Ajax요청 후 클라이언트로 전송할 데이터의 타입을 정의
	 *               application/text는 Ajax요청을 처리하고 클라이언트로 보내는 응답메시지 타입이  text라는 의미
	 *  */
	//String은 response되는 데이터의 형식 - 어노테이션을 이용해서 response되는 데이터라는 것을 표시
	@RequestMapping(value = "/emp/idcheck.do", method = RequestMethod.GET,
			 produces = "application/text;charset=utf-8" )
	public @ResponseBody String idCheck(String id) {
		boolean state = service.idCheck(id);
		String result = "";
		if(state) {//사용자가 입력한 id가 db에 이미 저장되어 있다는 의미
			result = "사용 불가능한 아이디";
		}else {
			result = "사용가능한 아이디";
		}
		return result;
	}
	@RequestMapping(value="/emp/login.do",method=RequestMethod.POST)
	public ModelAndView login(EmpVO loginUserInfo,HttpServletRequest request) {
		System.out.println(loginUserInfo);//사용자가 입력한 값
		ModelAndView mav = new ModelAndView();
		//DB인증을 받은 user 정보
		EmpVO loginOkUser =  service.login(loginUserInfo);
		String viewName = "";
		if(loginOkUser!=null) {
			//로그인성공
			//HttpServletRequest에서 제공하는 getSession메소드를 이용해서 세션을 새롭게 만든다.
			//세션은 클라이언트가 사용하는 공간을 서버에 저장하여 관리하며 각 클라이언트마다 세션의 아이디를 다르게 부여한다. 
			//세션을 만들고 response할때 response메시지에 session의 id를 저장할 수 있도록 셋팅한다.
			//클라이언트에 response가 도착하면 세션 아이디를 쿠키로 클라이언트의 컴퓨터에 저장한다.
			//새로운 요청을 할때 쿠키로 저장된 세션id를 request에 저장하여 요청하며 서버에서는  request의 세션id와 동일한 값이 
			//있는지 확인하고 동일한 값의 세션으로 접속할 수 있도록 한다.
			HttpSession session = request.getSession();
			//세션에 저장할 데이터를 setAttribute메소드를 이용해서 작업
			session.setAttribute("loginOkUser", loginOkUser);
			viewName = "login/ok";
			if(loginOkUser.getInfo().equals("admin")) {
				viewName = "admin/index";
			}
		}else {
			//로그인실패
			viewName = "login";
		}
		mav.setViewName(viewName);
		//view에서 로그인 사용자 정보를 사용하기 때문
		//mav.addObject("loginOkUser",loginOkUser);
		System.out.println("db연동완료:"+loginOkUser);
		return mav;
	}
	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession ses) 
			throws Exception {
		if(ses!=null) {
			//세션객체가 있으면 세션객체를 없애기
			ses.invalidate();
		}
		return "redirect:/index.do";
	}
}



























