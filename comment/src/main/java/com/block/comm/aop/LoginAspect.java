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

//�α��� ����� aspect�� ���� �ʿ�� ����! �̰� �����ϻ�
@Component  // @Named
@Aspect
public class LoginAspect {
	private static final Logger Logger  = LoggerFactory.getLogger(LoginAspect.class);

	@Pointcut("execution(* com.block.comm.controller.CommentController.writeForm(..))")
	public void writeForm() {
		Logger.info("LoginAspect�� writeForm()�� ����Ʈ�� ����");
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

		// Controller�� �޼ҵ� ����
		Object result = pjt.proceed();

//		Controller�� �޼ҵ尡 ����ǰ� �� ���Ŀ� �ڵ�

		return result;
	}
}
