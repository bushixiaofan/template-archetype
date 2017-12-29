package it.pkg.aop.aspect;

import com.song.common.log.CommonLogger;
import it.pkg.contsts.LogIdConst;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 切面
 */
@Aspect
@Component
public class HelloAspect {

    @Pointcut(value = "execution(* it.pkg.service.*.*(..)) || @annotation(it.pkg.aop.annot.HelloAnnotation)")
    private void HelloAspectMethod() {

    }

    @Before("HelloAspectMethod()")
    public void checkMessage(JoinPoint joinPoint){
        CommonLogger.info(LogIdConst.INFO, false,"@Before-check!!!");
    }

    @AfterReturning(pointcut = "HelloAspectMethod()", returning = "obj")
    public void checkReturn(JoinPoint joinPoint, Object obj) {
        CommonLogger.info(LogIdConst.INFO, false, "@AfterReturning-目标方法返回值：" + obj);
    }

    @After("HelloAspectMethod()")
    public void checkAfter(JoinPoint joinPoint){
        CommonLogger.info(LogIdConst.INFO, false,"@After-释放资源！");
    }

    @Around("HelloAspectMethod()")
    public Object checkAround(ProceedingJoinPoint joinPoint) throws Throwable{
        CommonLogger.info(LogIdConst.INFO, false,"@Around！");

        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0 && args[0].getClass() == String.class){
            args[0] = "@Around" + args[0];
        }
        Object result = joinPoint.proceed(args);
        if(result != null && result.getClass() == String.class){
            result = result + "--wy";
        }
        return result;
    }

    @AfterThrowing(throwing = "ex", pointcut = "HelloAspectMethod()")
    public void checkAfterThrowing(Throwable ex){
        CommonLogger.info(LogIdConst.INFO, false,"@AfterThrowing-异常抛出！");

    }

}
