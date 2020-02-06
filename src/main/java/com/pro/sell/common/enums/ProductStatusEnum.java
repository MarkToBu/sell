package com.pro.sell.common.enums;

import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
public enum ProductStatusEnum {

   UP(0,"上架"),
   DOWN(1, "下架");

   private Integer code;

   private String message;

   ProductStatusEnum(Integer code,String message){
      this.code = code;
      this.message = message;
   }

}
