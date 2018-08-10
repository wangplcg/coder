package cn.com.sun.mapper.wscl;

import cn.com.sun.commons.dto.WssqxxDto;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 22:54
 */

public interface IWsInfoMapper {
    /**
     * 获取文书申请情况信息
     */
    List<Map<String, String>> getWssqBySqxh(String sqxh);

    /**
     * 插入文书申请情况信息
     */
    int insertWssqInfo(WssqxxDto wssqxxDto);
}