package com.san.app.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	// 포인트컷 : 조인포인트(비즈니스 로직과 관련된 메소드) 중에서 Advice(공통로직)가 적용될 메소드
	//@Pointcut("execution(* *..*ServiceImpl.*(..))") 특정패키지 
	@Pointcut("within(*..*ServiceImpl)") // 특정 패키지 밑 or 특정 클래스 밑 
	public void allPointCut() {

	}

	// 위빙 : 포인트컷 + Advice + 동작시점
	// Advice는 @Autowired 하면됨
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// AOP가 적용되는 메소드의 이름
		String signatureStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);

		// 비즈니스 메소드 실행 전 Advice 실행
		System.out.println("핵심 기능 전 실행 - 공통 기능 : " + System.currentTimeMillis());
		try {
			Object obj = joinPoint.proceed(); // 실제 비즈니스 메소드 실행 코드
			return obj;
		} finally {
			// 비즈니스 메소드 실행 후 Advice 실행
			System.out.println("핵심 기능 후 실행 - 공통 기능 : " + System.currentTimeMillis());

		}
	}
}
