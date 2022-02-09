package com.foameraserblue.carecat.config

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.hibernate.annotations.common.util.impl.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.http.HttpServletRequest


@Aspect
@Component
class LogAopConfig() {
    private val log = LoggerFactory.logger(javaClass)


    /**
     * controller에 들어오는 모든 request에 대해 pointcut을 적용한다
     */
    @Pointcut("within(com.foameraserblue.carecat.web.controller..*)")
    fun onRequest() {
    }


    /**
     * controller에서 처리하는 모든 request메세지를 로깅처리한다
     */
    @Around("com.foameraserblue.carecat.config.LogAopConfig.onRequest()")
    fun requestLogging(pjp: ProceedingJoinPoint): Any {
        val request: HttpServletRequest =
            (RequestContextHolder.currentRequestAttributes() as (ServletRequestAttributes)).request

        val paramsMap: Map<String, Array<String>> = request.parameterMap

        var params = ""

        if (paramsMap.isNotEmpty()) {
            params = " [" + paramMapToString(paramsMap) + "]"
        }

        val start: Long = System.currentTimeMillis()

        val result: Any?

        try {
            result = pjp.proceed(pjp.args)
            return result
        } finally {
            val end: Long = System.currentTimeMillis()

            log.infof(
                "Request: {} {} {} < {} ({} ms)",
                request.method, request.requestURI,
                params, request.remoteHost, end - start

            )

        }
    }

    /**
     * 파라미터로 들어온 rest api 파라미터를 원하는 문자열 형태로 가공한다.
     * @param paramsMap rest api 파라미터
     * @return [String] 가공된 문자열
     */
    fun paramMapToString(paramsMap: Map<String, Array<String>>): String {
        return paramsMap.entries
            .map { entry -> "%s -> %s".format(entry.key, entry.value.joinToString { ", " }) }
            .joinToString { ", " }

    }

}
