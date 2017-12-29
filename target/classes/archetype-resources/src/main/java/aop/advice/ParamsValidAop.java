#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.aop.advice;

import java.util.List;

import ${package}.contsts.enums.BaseStatus;
import ${package}.excp.BaseException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @Description 打印参数、返回值
 * 
 * @author Auto generated, DO NOT EDIT
 */
public class ParamsValidAop implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        BindingResult bs = null;

        Object[] args = invocation.getArguments();
        if (args != null && args.length > 0) {
            for (Object o : args) {
                if (o instanceof BindingResult) {
                    bs = (BindingResult) o;
                    break;
                }
            }
        }
        if (bs != null) {
            validateAnnotation(bs);
        }

        return invocation.proceed();
    }

    /**
     * 注解校验结果
     * 
     * @param bindingResult
     */
    protected void validateAnnotation(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder msg = new StringBuilder();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                msg.append("参数：");
                msg.append(error.getField());
                msg.append(" ");
                msg.append(error.getDefaultMessage());
                msg.append("!");
            }

            BaseStatus baseStatus = BaseStatus.PARAM_ERROR;
            baseStatus.setDes(msg.toString());
            throw new BaseException(baseStatus);
        }
    }
}
