package cn.com;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
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
import org.apache.lucene.util.RamUsageEstimator;
import org.apache.poi.ss.formula.functions.Count;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
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
        dataDOList.add(new DataDO("???", "2", 1));
        dataDOList.add(new DataDO("???", "4", 2));
        dataDOList.add(new DataDO("???", "1", 5));
        dataDOList.add(new DataDO("???", "1", 6));
        dataDOList.add(new DataDO("???", "1", 7));
        dataDOList.add(new DataDO("???", "1", 8));
        dataDOList.add(new DataDO("???", "2", 1));
        dataDOList.add(new DataDO("???", "3", 1));
        dataDOList.add(new DataDO("???", "1", 1));
        dataDOList.add(new DataDO("???", "2", 1));
        dataDOList.add(new DataDO("???", "2", 2));
        dataDOList.add(new DataDO("???", "2", 3));
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
        // ??????Http?????????(???????????????:???????????????????????????;??????:?????????HttpClient???????????????????????????)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // ??????Get??????
        HttpGet httpGet = new HttpGet();
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ????????????
            RequestConfig requestConfig = RequestConfig.custom()
                    // ????????????????????????(????????????)
                    .setConnectTimeout(5000)
                    // ????????????????????????(????????????)
                    .setConnectionRequestTimeout(5000)
                    // socket??????????????????(????????????)
                    .setSocketTimeout(5000)
                    // ???????????????????????????(?????????true)
                    .setRedirectsEnabled(true).build();

            // ???????????????????????? ???????????????Get?????????
            httpGet.setConfig(requestConfig);
            // ??????????????????(??????)Get??????
            response = httpClient.execute(httpGet);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();
            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (org.apache.http.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
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

    public static String handle(String url) {
        if (StringUtils.isNotBlank(url)) {
            Pattern compile = Pattern.compile("^https?://");
            Matcher matcher = compile.matcher(url);
            if (matcher.find()) {
                return url;
            }
            return "hwww.hao123.com" + url;
        }
        return "";
    }

    @Test
    public void testPattern() {
        Pattern compile = Pattern.compile("^(?!temp)[\\w\\d]*/\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = compile.matcher("41413102010000000215/2020-08-11");
        if (matcher.find()) {
            System.out.println("find");
        }
    }

    @Test
    public void testGrade() {
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile("^([?????????]).*([??????])$");
        Matcher matcher = compile.matcher("??????");
        if (!matcher.matches()) {
            return;
        }
        String age = StringUtils.equals(matcher.group(1), "???") ? "7" : StringUtils.equals(matcher.group(1), "???") ? "8" : "9";
        String halfYear = StringUtils.equals(matcher.group(2), "???") ? "up" : "down";
        System.out.println(age + "_" + halfYear);
    }

    @Test
    public void testPatterns() {
        System.out.println("SELECT t.id, t.chapter_id, t.question_id, t.create_time, t.pt_id, t.type, t.publish_status, t.pt_order_num, t.question_order_num, t.question_tag,\tt.modify_time, t.create_user, t.modify_user, t.question_tag_desc \n" +
                "FROM\n" +
                "\ttower_official_chapter_pt_question t, tower_chapter c \n" +
                "WHERE\tt.chapter_id = c.chapter_id AND c.books_id = #{bookId} AND t.pt_id = #{ptId} AND t.type = 6 ORDER BY t.question_order_num desc");

        String[] split = "??????;".split("[;???]");
        System.out.println(JSONObject.toJSON(split));
    }

    @Test
    public void testUrlEncode() {
        String encode = URLEncoder.encode("organ_course_bo_organ_books_chapter_P_1606704189050");
        System.out.println(encode);

    }

    @Test
    public void testJSONArray() {
        List<String> aNull = JSONArray.parseArray(null, String.class);
        System.out.println(aNull);
    }

    @Test
    public void testDate() {
        long l = System.currentTimeMillis();
        long millis = DateTime.now(DateTimeZone.forOffsetHours(8)).getMillis();
        System.out.println(millis + "    " + l);
        System.out.println(DateTime.now().getMillis());

        //
        // Date date = new Date();
        // LocalDate localDate = date.toInstant().atZone(ZoneId.of("+8")).toLocalDate();
        // LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        // LocalDateTime datetime = LocalDateTime.of(localDate, localTime);
        // long l = datetime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // System.out.println(l);
    }

    @Test
    public void testSets() {
        List<String> lists = Lists.newArrayList("123aa", "214fdsf", "325hdhdt");
        Set<String> hashSet = Sets.newHashSet(lists);
        ArrayList<String> strings = Lists.newArrayList(lists);
        System.out.println(strings);
        //
        // Date date = new Date();
        // LocalDate localDate = date.toInstant().atZone(ZoneId.of("+8")).toLocalDate();
        // LocalTime localTime = LocalTime.of(0, 0, 0, 0);
        // LocalDateTime datetime = LocalDateTime.of(localDate, localTime);
        // long l = datetime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // System.out.println(l);
    }

    @Test
    public void dateTest() {

        DateTime now = DateTime.now(DateTimeZone.forOffsetHours(8)).withMillisOfDay(0);

        long startMillis = now.withDayOfWeek(1).getMillis();
        long endMillis = now.withDayOfWeek(7).plusDays(1).getMillis();

        long startOneMillis = now.withDayOfWeek(1).minusWeeks(1).getMillis();
        long endOneMillis = now.withDayOfWeek(7).plusDays(1).minusWeeks(1).getMillis();

        long startTwoMillis = now.withDayOfWeek(1).minusWeeks(2).getMillis();
        long endTwoMillis = now.withDayOfWeek(7).plusDays(1).minusWeeks(2).getMillis();

        long startThreeMillis = now.withDayOfWeek(1).minusWeeks(3).getMillis();
        long endThreeMillis = now.withDayOfWeek(7).plusDays(1).minusWeeks(3).getMillis();

        long startFourMillis = now.withDayOfWeek(1).minusWeeks(4).getMillis();
        long endFourMillis = now.withDayOfWeek(7).plusDays(1).minusWeeks(3).getMillis();

        System.out.println(startMillis);
        System.out.println(endMillis);
        System.out.println(startOneMillis);
        System.out.println(endOneMillis);
        System.out.println(startTwoMillis);
        System.out.println(endTwoMillis);
        System.out.println(startThreeMillis);
        System.out.println(endThreeMillis);
        System.out.println(startFourMillis);
        System.out.println(endFourMillis);
    }

    private static Configuration conf = Configuration.defaultConfiguration();
    static {
        // path ???????????????null
        conf.setOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        conf.setOptions(Option.ALWAYS_RETURN_LIST);
    }

    public static void main(String[] args) {
        List<String> args1 = new ArrayList<String>();
        String videoDuration = "";
        args1.add("ffprobe");
        args1.add("-i");
        args1.add("http://jzx-video.oss-cn-hangzhou.aliyuncs.com/ss/012d0795bae64e7add45848ee86c4132.mp4");
        args1.add("-show_entries");
        args1.add("format=duration");
        args1.add("-v");
        args1.add("quiet");
        args1.add("-of");
        args1.add("csv=\"p=0\"");
        args1.add("-sexagesimal");
        String argsString = String.join(" ", args1);
        try {
            Process process1 = Runtime.getRuntime().exec(argsString);
            process1.waitFor();
            // FIXME: Add a logger increment to get the progress to 100%.
            int exitCode = process1.exitValue();
            if (exitCode != 0)
            {
                throw new RuntimeException("FFmpeg exec failed - exit code:" + exitCode);
            }
            else
            {
                videoDuration = process1.getOutputStream().toString();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            new RuntimeException("Unable to start FFmpeg executable.");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            new RuntimeException("FFmpeg run interrupted.");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println(videoDuration);


        // String url="http://jzx-video.oss-cn-hangzhou.aliyuncs.com/ss/012d0795bae64e7add45848ee86c4132.mp4";
        // long duration = 0L;
        // FFmpegFrameGrabber ff = new FFmpegFrameGrabber(url);
        // try {
        //     ff.start();
        //     duration = ff.getLengthInTime() / (1000 * 1000);
        //     ff.stop();
        // } catch (FrameGrabber.Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.println(duration);
    }

    private static int getHash(String key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & 0x000001FF;
    }

    volatile int k = 0;

    @Test
    public void thread() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sum();
        });
        Thread t2 = new Thread(() -> {
            sum();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(k);

        new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());


    }

    public void sum() {
        for (int i = 0; i < 9999; i++) {
            k = k + 1;
        }
    }
}