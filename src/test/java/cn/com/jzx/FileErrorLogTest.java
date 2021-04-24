package cn.com.jzx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * User: wangpl
 * Date: 2020-12-29
 * Time: 10:31
 */

public class FileErrorLogTest {

    @Test
    public void testLogFileId() throws IOException {
        Set<String> questionSet = Sets.newHashSet();
        String fileContent = FileUtils.readFileToString(new File("F://ERRORLOG20201230 trace.txt"));
        Pattern compile = Pattern.compile("错误题Id是 \\[(.*?)]");
        Matcher matcher = compile.matcher(fileContent);
        while (matcher.find()) {
            questionSet.add(matcher.group(1));
        }
        // String coder = StringEscapeUtils.unescapeJava("<svg xmlns:xlink=\\\\\\\"http://www.w3.org/1999/xlink\\\\\\\" width=\\\\\\\"19.317ex\\\\\\\" height=\\\\\\\"3.509ex\\\\\\\" style=\\\\\\\"vertical-align: -1ex; margin-bottom: -0.338ex;\\\\\\\" viewBox=\\\\\\\"0 -934.9 8316.9 1510.9\\\\\\\" role=\\\\\\\"img\\\\\\\" focusable=\\\\\\\"false\\\\\\\" xmlns=\\\\\\\"http://www.w3.org/2000/svg\\\\\\\">\\\\n<defs>\\\\n<path stroke-width=\\\\\\\"1\\\\\\\" id=\\\\\\\"E1-MJMATHI-44\\\\\\\" d=\\\\\\\"M287 628Q287 635 230 637Q207 637 200 638T193 647Q193 655 197 667T204 682Q206 683 403 683Q570 682 590 682T630 676Q702 659 752 597T803 431Q803 275 696 151T444 3L430 1L236 0H125H72Q48 0 41 2T33 11Q33 13 36 25Q40 41 44 43T67 46Q94 46 127 49Q141 52 146 61Q149 65 218 339T287 628ZM703 469Q703 507 692 537T666 584T629 613T590 629T555 636Q553 636 541 636T512 636T479 637H436Q392 637 386 627Q384 623 313 339T242 52Q242 48 253 48T330 47Q335 47 349 47T373 46Q499 46 581 128Q617 164 640 212T683 339T703 469Z\\\\\\\"></path>\\\\n<path stroke-width=\\\\\\\"1\\\\\\\" id=\\\\\\\"E1-MJMATHI-45\\\\\\\" d=\\\\\\\"M492 213Q472 213 472 226Q472 230 477 250T482 285Q482 316 461 323T364 330H312Q311 328 277 192T243 52Q243 48 254 48T334 46Q428 46 458 48T518 61Q567 77 599 117T670 248Q680 270 683 272Q690 274 698 274Q718 274 718 261Q613 7 608 2Q605 0 322 0H133Q31 0 31 11Q31 13 34 25Q38 41 42 43T65 46Q92 46 125 49Q139 52 144 61Q146 66 215 342T285 622Q285 629 281 629Q273 632 228 634H197Q191 640 191 642T193 659Q197 676 203 680H757Q764 676 764 669Q764 664 751 557T737 447Q735 440 717 440H705Q698 445 698 453L701 476Q704 500 704 528Q704 558 697 578T678 609T643 625T596 632T532 634H485Q397 633 392 631Q388 629 386 622Q385 619 355 499T324 377Q347 376 372 376H398Q464 376 489 391T534 472Q538 488 540 490T557 493Q562 493 565 493T570 492T572 491T574 487T577 483L544 351Q511 218 508 216Q505 213 492 213Z\\\\\\\"></path>\\\\n<path stroke-width=\\\\\\\"1\\\\\\\" id=\\\\\\\"E1-MJMAIN-5F\\\\\\\" d=\\\\\\\"M0 -62V-25H499V-62H0Z\\\\\\\"></path>\\\\n<path stroke-width=\\\\\\\"1\\\\\\\" id=\\\\\\\"E1-MJMAIN-2013\\\\\\\" d=\\\\\\\"M0 248V285H499V248H0Z\\\\\\\"></path>\\\\n<path stroke-width=\\\\\\\"1\\\\\\\" id=\\\\\\\"E1-MJMAIN-2E\\\\\\\" d=\\\\\\\"M78 60Q78 84 95 102T138 120Q162 120 180 104T199 61Q199 36 182 18T139 0T96 17T78 60Z\\\\\\\"></path>\\\\n</defs>\\\\n<g stroke=\\\\\\\"currentColor\\\\\\\" fill=\\\\\\\"currentColor\\\\\\\" stroke-width=\\\\\\\"0\\\\\\\" transform=\\\\\\\"matrix(1 0 0 -1 0 0)\\\\\\\">\\\\n <use xlink:href=\\\\\\\"#E1-MJMATHI-44\\\\\\\" x=\\\\\\\"0\\\\\\\" y=\\\\\\\"0\\\\\\\"></use>\\\\n <use xlink:href=\\\\\\\"#E1-MJMATHI-45\\\\\\\" x=\\\\\\\"828\\\\\\\" y=\\\\\\\"0\\\\\\\"></use>\\\\n<g transform=\\\\\\\"translate(1593,0)\\\\\\\">\\\\n<text font-family=\\\\\\\"monospace\\\\\\\" stroke=\\\\\\\"none\\\\\\\" transform=\\\\\\\"scale(71.759) matrix(1 0 0 -1 0 0)\\\\\\\">的</text>\\\\n</g>\\\\n<g transform=\\\\\\\"translate(2741,0)\\\\\\\">\\\\n<text font-family=\\\\\\\"monospace\\\\\\\" stroke=\\\\\\\"none\\\\\\\" transform=\\\\\\\"scale(71.759) matrix(1 0 0 -1 0 0)\\\\\\\">长</text>\\\\n</g>\\\\n<g transform=\\\\\\\"translate(3889,0)\\\\\\\">\\\\n<text font-family=\\\\\\\"monospace\\\\\\\" stroke=\\\\\\\"none\\\\\\\" transform=\\\\\\\"scale(71.759) matrix(1 0 0 -1 0 0)\\\\\\\">为</text>\\\\n</g>\\\\n<g transform=\\\\\\\"translate(5037,0)\\\\\\\">\\\\n<g transform=\\\\\\\"translate(0,-466)\\\\\\\">\\\\n <use xlink:href=\\\\\\\"#E1-MJMAIN-2013\\\\\\\"></use>\\\\n<g transform=\\\\\\\"translate(496.9939879759519,0) scale(4.012024048096192,1)\\\\\\\">\\\\n <use xlink:href=\\\\\\\"#E1-MJMAIN-2013\\\\\\\"></use>\\\\n</g>\\\\n <use xlink:href=\\\\\\\"#E1-MJMAIN-2013\\\\\\\" x=\\\\\\\"2500\\\\\\\" y=\\\\\\\"0\\\\\\\"></use>\\\\n</g>\\\\n</g>\\\\n <use xlink:href=\\\\\\\"#E1-MJMAIN-2E\\\\\\\" x=\\\\\\\"8038\\\\\\\" y=\\\\\\\"0\\\\\\\"></use>\\\\n</g>\\\\n</svg>");
        // coder = StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeHtml4(coder));
        // System.out.println(coder);
            // Pattern compile2 = Pattern.compile("\\*\\*异常\\*\\*渲染失败错误题Id是 \\[(.*?)]");
        // Matcher matcher2 = compile2.matcher(fileContent);
        // while (matcher2.find()) {
        //     questionSet.add(matcher2.group(1));
        // }
        System.out.println(questionSet.size());
        System.out.println(JSONObject.toJSONString(questionSet));
    }

    @Test
    public void testJSON() {
        JSONObject jsonObject = JSONObject.parseObject("            {\n" +
                "                \"code\": \"00000\",\n" +
                "                \"msg\": \"\",\n" +
                "                \"data\": [\n" +
                "                    \"存在删除PT情况请晚上10点后再发布\"\n" +
                "                ]\n" +
                "            }");
        List<String> data = JSON.parseArray(jsonObject.getString("data"), String.class);
        System.out.println(data);
    }

}
