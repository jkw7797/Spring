package com.block.comm.aop;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

//로그인 기능을 aspect로 만들 필요는 없다! 이건 연습일뿐
@Component  // @Named
@Aspect
public class LoginAspect {
	private static final Logger Logger  = LoggerFactory.getLogger(LoginAspect.class);

	@Pointcut("execution(* com.block.comm.controller.CommentController.writeForm(..))")
	public void writeForm() {
		Logger.info("LoginAspect의 writeForm()에 포인트컷 동작");
	}

	@Around("writeForm()")
	public Object human(ProceedingJoinPoint pjt) throws Throwable {
		HttpSession session = null;
		HttpServletResponse resp = null;
		for (Object obj : pjt.getArgs()) {
			if (obj instanceof HttpSession) {
				session = (HttpSession) obj;
			} else if (obj instanceof HttpServletResponse) {
				resp = (HttpServletResponse) obj;
			}
		}
		
		if (session.getAttribute("id")==null){
//			return "login";
			return "redirect:/login.chain";
			// resp.sendRedirect("/comm/login.chain");
		}

		// Controller의 메소드 실행
		Object result = pjt.proceed();

//		Controller의 메소드가 실행되고 난 이후에 코드

		return result;
	}
}
