package cn.com.im.handler;

import cn.com.im.entity.ExceptionPacket;
import cn.com.im.execption.IMBusinessException;
import cn.com.im.execption.IMSysException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 17:04
 */

public class ExceptionHandler extends SimpleChannelInboundHandler<ExceptionPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ExceptionPacket msg) {
        System.out.println(new Date() +" 处理错误, 收到错误信息： " + msg.getMsg() + "错误代码 ： " + msg.getMsgCode());
    }
}