package cn.com.core.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * BeanNameAware                  获取到容器中bean名称
 * ResourceLoaderAware            获取到当前 资源加载器 可以获取外部资源文件
 * BeanFactoryAware               获取当前bean factory，可以调用容器服务
 * ApplicationContextAware        当前ApplicationContext
 * MessageSourceAware             获取消息source 可以获取文本信息
 * ApplicationEventPublisherAware 应用事件发布器，可以用发布事件
 *
 * @author wangplcg
 * @create 2018-04-15 22:22
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader loader;


    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outPutResult() {
        System.out.println("Bean 的名称为： " + beanName);
        Resource resource = loader.getResource("classpath:cn/com/core/el/test.txt");
        try {
            System.out.println("ResourceLoader 加载文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
