package cn.com;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * User: wangpl
 * Date: 2019-09-29
 * Time: 10:19
 */

public class StringTextTest {

    @Test
    public void getSorted() {
        List<DataDO> datas = getDatas();
        List<IndexDataDO> dataArrays = Lists.newArrayList();
        IndexDataDO currentIndex = null;
        for (int i = 0; i < datas.size(); i++) {
            DataDO exceptDO = datas.get(i);
            if (i == datas.size() - 1) {
                if (currentIndex == null) {
                    currentIndex = new IndexDataDO(exceptDO.getName(), exceptDO.getMc(), exceptDO.getId(), exceptDO.getId());
                }
                dataArrays.add(currentIndex);
                continue;
            }
            exceptDO.setId(exceptDO.getId() + 1);
            DataDO nextData = datas.get(i + 1);
            if (currentIndex == null) {
                currentIndex = new IndexDataDO(exceptDO.getName(), exceptDO.getMc(), exceptDO.getId() - 1, exceptDO.getId() - 1);
            }
            if (Objects.equals(exceptDO, nextData)) {
                currentIndex.setEnd(nextData.getId());
            } else {
                dataArrays.add(currentIndex);
                currentIndex = null;
            }
        }

        for (IndexDataDO dataArray : dataArrays) {
            System.out.println(dataArray.getName() + "," +  dataArray.getMc() + "," + dataArray.getStart() + "," + dataArray.getEnd());
        }

    }


    public List<DataDO> getDatas() {
        List<DataDO> dataDOList = Lists.newArrayList();
        dataDOList.add(new DataDO("大", "2", 1));
        dataDOList.add(new DataDO("大", "4", 2));
        dataDOList.add(new DataDO("大", "1", 5));
        dataDOList.add(new DataDO("大", "1", 6));
        dataDOList.add(new DataDO("大", "1", 7));
        dataDOList.add(new DataDO("大", "1", 8));
        dataDOList.add(new DataDO("小", "2", 1));
        dataDOList.add(new DataDO("小", "3", 1));
        dataDOList.add(new DataDO("小", "1", 1));
        dataDOList.add(new DataDO("中", "2", 1));
        dataDOList.add(new DataDO("中", "2", 2));
        dataDOList.add(new DataDO("中", "2", 3));
        return dataDOList;
    }

    @Data
    @AllArgsConstructor
    static class DataDO {
        private String name;
        private String mc;
        private Integer id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataDO dataDO = (DataDO) o;
            return name.equals(dataDO.name) &&
                    mc.equals(dataDO.mc) &&
                    id.equals(dataDO.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, mc, id);
        }
    }


    @Data
    @AllArgsConstructor
    static class IndexDataDO {
        private String name;
        private String mc;
        private Integer start;
        private Integer end;
    }

    @Test
    public void test() throws ParseException {
        int i1 = 1 << 1;
        System.out.println(0 | i1);
        int i2 = 1 << 2;
        System.out.println(0 | i2);
        int i3 = 1 << 3;
        System.out.println(0 | i3);
        int i4 = 1 << 4;
        System.out.println(0 | i4);
        int i5 = 1 << 5;
        System.out.println(0 | i5);
        int i6 = 1 << 6;
        System.out.println(0 | i6);
        int i7 = 1 << 7;
        System.out.println(0 | i7);
        System.out.println(Integer.toBinaryString(536870784));
        System.out.println(Integer.toBinaryString(Integer.valueOf("128")));
        System.out.println(new Date().compareTo(DateUtils.parseDate("2020-01-01", "yyyy-MM-dd")));
    }


    @Test
    public void testRandom() {
        System.out.println(new Random().nextInt() + "");
        System.out.println(new SecureRandom().nextInt() + "");
    }

    @Test
    public void test11() throws UnsupportedEncodingException, MalformedURLException {
        String service = "https://etax.shenzhen.chinatax.gov.cn/login-web/oauth2/auth?response_type=code&state&client_id=app_wxyyClient";
        String redirectAllowDomains = "etax.shenzhen.chinatax.gov.cn";
        // 跳转地址白名单配置，added by zjxin 2019.09.25
        if (StringUtils.isNotBlank(redirectAllowDomains) && StringUtils.isNotBlank(service)){
            List<String> allowDomainList = Arrays.asList(redirectAllowDomains.split(","));
            String serviceTemp = URLDecoder.decode(service, "UTF-8");
            URL urlTemp = new URL(serviceTemp);
            if (!allowDomainList.contains(urlTemp.getHost())){
                service = null;
            }
        }
        System.out.println(service);
    }

    @Test
    public void test111() {
        Pattern compile = Pattern.compile("^https?://");
        Matcher matcher = compile.matcher("https://etax.shenzhen.chinatax.gov.cn/login-web/oauth2/auth?response_type=code&state&client_id=a");
        System.out.println(matcher.find());
    }

    private String addParamToUrl(String url, String paramName, String value) {
        if (url.indexOf("?") < 0) {
            return url += ("?" + paramName + "=" + value);
        } else {
            String params = url.substring(url.indexOf("?") + 1);
            String[] paramArr = params.split("&");
            boolean find = false;
            for (String pa : paramArr) {
                if (pa.trim().startsWith(paramName + "=")) {
                    find = true;
                }
            }
            if (!find) {
                url += ("&" + paramName + "=" + value);
            }
            return url;
        }
    }

    @Test
    public void internalTest() {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("https://etax.shenzhen.chinatax.gov.cn/login-web/oauth2/token?client_id=szdzswjzrrsm&client_secret=smdzswjzrr%232020&grant_type=authorization_code&code=ebe432f35c4f492d886d2427f6c17ad0&response_type=code&redirect_uri=https://www.baidu.com");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();

            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(requestConfig);
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (org.apache.http.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testNum() {
        System.out.println(1 << 8);
        System.out.println('c' - Byte.MIN_VALUE);
        System.out.println(Integer.valueOf('c'));
        int i = 1;
        System.out.println(--i);
        System.out.println(--i);
        System.out.println(--i);
        System.out.println(i);
    }
}