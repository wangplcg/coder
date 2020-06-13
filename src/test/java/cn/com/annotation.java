package cn.com;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: wangpl
 * Date: 2020-04-21
 * Time: 11:16
 */

public class annotation {

    @Data
    @AttachSessionKey("hgxzxzxx")
    static class AttachDto extends BaseAttachDto {
        private String data;
    }

    static class XXXX {

    }

    static HttpServletRequest httpServletRequest = new MockHttpServletRequest();

    public static void main(String[] args) {
        AttachDto attachDto = new AttachDto();
        attachDto.setData("DAta datat ta11111t");
        setAttachLoginInfo(httpServletRequest, AttachDto.class, attachDto);
        attachDto.setData("DAta datat ta22222t");
        setAttachLoginInfo(httpServletRequest, AttachDto.class, attachDto);
        attachDto.setData("DAta datat ta33333t");
        setAttachLoginInfo(httpServletRequest, AttachDto.class, attachDto);

        AttachDto attachLoginInfo = getAttachLoginInfo(httpServletRequest, AttachDto.class);
        System.out.println(attachLoginInfo.getData());
    }



    /**
     * 设置登录关联会话
     * 使用注解标记缓存值
     * @see AttachSessionKey
     **/
    public static <T> void setAttachLoginInfo(HttpServletRequest request, Class<? extends BaseAttachDto> clazz, BaseAttachDto t) {
        if (clazz == null) {
            return;
        }
        String cacheKey = getCacheKey(clazz);
        Map<String, Object> attachLoginInfo = (Map<String, Object>)request.getSession().getAttribute("SSO_ATTACH_LOGIN_INFO");
        if (attachLoginInfo == null) {
            attachLoginInfo = new HashMap<>();
        }
        System.out.println("cache Key :: " + cacheKey);
        attachLoginInfo.put(cacheKey, t);
        request.getSession().setAttribute("SSO_ATTACH_LOGIN_INFO", attachLoginInfo);
    }

    /**
     * 获取登录关联会话
     * 根据缓存值
     * @see AttachSessionKey
     */
    public static<T> T getAttachLoginInfo(HttpServletRequest request, Class<? extends BaseAttachDto> clazz) {
        Map<String, Object> attachLoginInfo = (Map<String, Object>)request.getSession().getAttribute("SSO_ATTACH_LOGIN_INFO");
        if (clazz == null || attachLoginInfo == null) {
            return null;
        }
        String cacheKey = getCacheKey(clazz);
        return (T)attachLoginInfo.get(cacheKey);
    }

    public static String getCacheKey(Class clazz) {
        String cacheKey = clazz.getSimpleName();
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if (AttachSessionKey.class.isAssignableFrom(declaredAnnotation.annotationType())) {
                AttachSessionKey attachSessionKey = (AttachSessionKey) declaredAnnotation;
                if (StringUtils.isNotBlank(attachSessionKey.value())) {
                    cacheKey = attachSessionKey.value();
                }
            }
        }
        return cacheKey;
    }
}
