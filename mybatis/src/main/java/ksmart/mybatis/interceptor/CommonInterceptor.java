package ksmart.mybatis.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonInterceptor implements HandlerInterceptor{
	
	/**
	 * HandlerMapping이 핸들러 객체를 결정한 후 handlerAdapter가 핸들러를 호출하기 전에 호출되는 메소드
	 * return true(핸들러메소드 실행), false(핸들러 메소드 실행 X : 핸들러까지 진입 금지)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//파라미터 값을 확인
			Set<String> paramKeySet = request.getParameterMap().keySet();
		// 결과열에 문자열을 포함해서 만들어줌 자바스크립트의 배열 join 
			StringJoiner param = new StringJoiner(", ");
			
			for(String key : paramKeySet) {
				param.add(key+ ": "+ request.getParameter(key));
			}
			log.info("ACCESS INFO===========================");
			log.info("PORT		::::::		{}", request.getLocalPort());
			log.info("ServerName		::::::		{}",request.getServerName());
			log.info("HTTPMethod		::::::		{}",request.getMethod());
			log.info("URL		::::::		{}",request.getRequestURL());
			log.info("CLINET IP		::::::		{}",request.getRemoteAddr());
			log.info("ServerName		::::::		{}",request.getMethod());
			log.info("ServerName		::::::		{}",request.getMethod());
				
		return HandlerInterceptor.super.preHandle(request, response, handler);
		// return HandlerInterceptor.super.preHandle(request, response, handler); 
		// 주저리 주저리 말은 많지만  boolean 타입이라 return true와 같음
		
	}
	
	/**
	 * HandlerAdapter 가 실제로 핸들러를 호출 한 후 DispatcherServlet이 뷰를 전달하기 전에 호출되는 메소드
	 * 
	 */ 
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		//기본적으로 void type 모델엔 뷰가 필요없음 왜? controller 전이라 
	}
	
	
	/**
	 * HandlerAdapter 가 실제로 핸들러를 호출한 후 DispatcherServlet이 뷰를 랜더링 한 후에 호출되는 메소드
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}





