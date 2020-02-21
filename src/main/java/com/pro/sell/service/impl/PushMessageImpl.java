package com.pro.sell.service.impl;

import com.pro.sell.config.WechatAccountConfig;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 发送微信模板消息
 * @author Maktub
 * @Date 2020/2/21 10:47
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void pushOrderStatus(OrderMasterDTO orderMasterDto) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
        wxMpTemplateMessage.setToUser("XXX");
        List<WxMpTemplateData> wxMpTemplateData = Arrays.asList(
                new WxMpTemplateData("first", "请点击收货"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "13458252326"),
                new WxMpTemplateData("keyword3", orderMasterDto.getOrderId()),
                new WxMpTemplateData("keyword4", orderMasterDto.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "￥" + orderMasterDto.getOrderAmount()),
                new WxMpTemplateData("keyword6", "欢迎再次选购!")
        );
        wxMpTemplateMessage.setData(wxMpTemplateData);
        
        
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败,{}", e.getMessage());
        }
    }
}
