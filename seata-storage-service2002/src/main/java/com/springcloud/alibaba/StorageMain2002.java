package com.springcloud.alibaba;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cglib.core.Local;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author i531869
 * @Date 2021/3/8 15:29
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class StorageMain2002 {
  public static void main(String[] args) throws ParseException {
    // Calendar calendar =Calendar.getInstance();
    // calendar.set(2021,2,12,7,00);
    // Date date = calendar.getTime();
    // Integer offset = -28800;
    // String dateStr = RBPDateUtil.dateOffset(date, Calendar.SECOND, offset);
    // String utc = RBPDateUtil.assembleUtcTimeZone(offset);
    // String dateStrUtc = dateStr.concat(utc);
    // System.out.println(dateStrUtc);

    // try {
    //   System.out.println("========");
    //   String dateStr = "//2017-03-01 22:33:23";
    //   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //   simpleDateFormat.parse(dateStr);
    //   System.out.println("日志能否打印");
    // }catch (ParseException e){
    //   log.error(e.getMessage());
    // }
    // String dateStr = "2017-03-01 22:33:23";
    // DateUtil.offset()
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Date date = new Date();
    // String str = simpleDateFormat.format(date);
    // System.out.println(str);
    // Date date1 = simpleDateFormat.parse(str);
    // System.out.println(date1);
    // System.out.println(cal.getTimeZone());
    // System.out.println("小时:" + 19800 / (60 * 60));
    // System.out.println("分钟:" + -19800 / 60 % 60);
    // TimeZone zone=  TimeZone.getTimeZone(ZoneId.of("Australia/Darwin"));
    // System.out.println(zone.get);
    //
    // System.out.println("result:" + i);
    // System.out.println("mod:" + k);
    SpringApplication.run(StorageMain2002.class, args);
  }
}
