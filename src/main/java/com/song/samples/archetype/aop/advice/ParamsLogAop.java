package com.song.samples.archetype.aop.advice;

import com.song.common.log.CommonLogger;
import com.song.common.utils.JsonUtil;
import com.song.samples.archetype.contsts.AlarmIdConst;
import com.song.samples.archetype.contsts.LogIdConst;
import com.song.samples.archetype.excp.BaseException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 打印参数、返回值
 * 
 * @author Auto generated, DO NOT EDIT
 */
public class ParamsLogAop implements MethodInterceptor {

    private static final String LOG_REQ = "logreq";
    private static final String LOG_RSP = "logrsp";

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String paramsStr = logRequest(request, invocation);
        try {
            value = invocation.proceed();
        } catch (BaseException ex) {
            CommonLogger.error(AlarmIdConst.ERROR, AlarmIdConst.ERROR, true, ex.getInfo(), ex);
        } catch (Exception ex) {
            CommonLogger.error(AlarmIdConst.ERROR, AlarmIdConst.ERROR, true, ex.getMessage(), ex);
        }

        logRequestResponse(paramsStr, JsonUtil.toJson(value));
        return value;
    }

    /**
     * @param invocation
     * @return
     */
    private static boolean isAnnotationBody(MethodInvocation invocation) {
        Annotation[][] list = invocation.getMethod().getParameterAnnotations();
        for (Annotation[] annotations : list) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof RequestBody) {
                    return true;
                }
            }
        }

        return false;

    }

    public static String logRequest(HttpServletRequest httpRequest, MethodInvocation invocation) {

        String paramsStr = "";
        if (isAnnotationBody(invocation)) {
            paramsStr = JsonUtil.toJson(invocation.getArguments());
        } else {
            Map<String, String> params = new HashMap<String, String>();
            if (httpRequest != null) {
                @SuppressWarnings("rawtypes")
                Enumeration enume = httpRequest.getParameterNames();
                if (null != enume) {
                    while (enume.hasMoreElements()) {
                        Object element = enume.nextElement();
                        if (null != element) {
                            String paramName = (String) element;
                            String paramValue = httpRequest.getParameter(paramName);
                            params.put(paramName, paramValue);
                        }
                    }
                }
            }
            paramsStr = JsonUtil.toJson(params);
        }

        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put(LOG_REQ, paramsStr);
        CommonLogger.info(LogIdConst.BASE_OUT_REQUEST, true, logMap);
        return paramsStr;
    }

    public static void logRequestResponse(String paramsStr, String re) {
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put(LOG_REQ, paramsStr);
        logMap.put(LOG_RSP, re);
        CommonLogger.info(LogIdConst.BASE_OUT_RESPONSE, true, logMap);
    }
}
