#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.aop.aspect;

import com.song.common.log.CommonLogger;
import ${package}.contsts.LogIdConst;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class HelloAdvice {

    public void checkMessage(JoinPoint joinPoint){
        CommonLogger.info(LogIdConst.INFO, false,"@Before-check!!!");
        CommonLogger.info(LogIdConst.INFO, false,"@Before-目标对象为：" + joinPoint.getTarget());
        CommonLogger.info(LogIdConst.INFO, false,"@Before-目标方法：" + joinPoint.getSignature().getName());
        CommonLogger.info(LogIdConst.INFO, false,"@Before-目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    public void checkReturn(JoinPoint joinPoint, Object obj){
        CommonLogger.info(LogIdConst.INFO, false,"@AfterReturning-目标方法返回值：" + obj);
        CommonLogger.info(LogIdConst.INFO, false,"@AfterReturning-生成日志");

        CommonLogger.info(LogIdConst.INFO, false,"@AfterReturning-目标对象为：" + joinPoint.getTarget());
        CommonLogger.info(LogIdConst.INFO, false,"@AfterReturning-目标方法：" + joinPoint.getSignature().getName());
        CommonLogger.info(LogIdConst.INFO, false,"@AfterReturning-目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    public void checkAfter(JoinPoint joinPoint){
        CommonLogger.info(LogIdConst.INFO, false,"@After-释放资源！");
        CommonLogger.info(LogIdConst.INFO, false,"@After-目标对象为：" + joinPoint.getTarget());
        CommonLogger.info(LogIdConst.INFO, false,"@After-目标方法：" + joinPoint.getSignature().getName());
        CommonLogger.info(LogIdConst.INFO, false,"@After-目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));
    }

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

    public void checkAfterThrowing(Throwable ex){
        CommonLogger.info(LogIdConst.INFO, false,"@AfterThrowing-异常抛出！");
        CommonLogger.info(LogIdConst.INFO, false,"@AfterThrowing-异常日志！");

    }
}
