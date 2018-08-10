package cn.com.sun.service.impl;

import cn.com.sun.commons.dto.WssqxxDto;
import cn.com.sun.mapper.wscl.IWsInfoMapper;
import cn.com.sun.service.IWsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 23:12
 */
@Service
public class WsInfoServiceImpl implements IWsInfoService {

    @Autowired
    IWsInfoMapper wsInfoMapper;

    public List<Map<String, String>> getWsInfo(String sqxh) {
        return wsInfoMapper.getWssqBySqxh(sqxh);
    }

    public int addtWsInfo(WssqxxDto wssqxxDto) {
        return wsInfoMapper.insertWssqInfo(wssqxxDto);
    }
}
