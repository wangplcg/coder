package cn.com.sun.service;

import cn.com.sun.commons.dto.WssqxxDto;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 23:07
 */

public interface IWsInfoService {

    List<Map<String, String>> getWsInfo(String sqxh);


    int addtWsInfo(WssqxxDto wssqxxDto);

}
