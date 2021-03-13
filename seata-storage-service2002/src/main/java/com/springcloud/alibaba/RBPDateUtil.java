package com.springcloud.alibaba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author i531869
 * @Date 2021/3/12 13:49
 * @Version 1.0
 */
public class RBPDateUtil {

  /**
   * seconds for one hour
   */
  private static final int SECOND_PER_HOUR = 60 * 60;

  /**
   * seconds for one minute
   */
  private static final int SECOND_PER_MINUTE = 60;

  /**
   * Assemble utc timezone like 'UTC+0800'
   *
   * @param currentOffsetTimeSec TimeZone in seconds
   * @return
   */
  public static String assembleUtcTimeZone(Integer currentOffsetTimeSec) {
    Integer currentOffsetHour = Math.abs(currentOffsetTimeSec) / SECOND_PER_HOUR;
    Integer currentOffsetMin = Math.abs(currentOffsetTimeSec) / SECOND_PER_MINUTE % SECOND_PER_MINUTE;

    //assemble utc timezone
    StringBuffer utcTimeStr = new StringBuffer();
    utcTimeStr.append(" UTC");
    if (currentOffsetTimeSec > 0 || currentOffsetTimeSec == 0) {
      utcTimeStr.append("+");
    } else {
      utcTimeStr.append("-");
    }
    if (currentOffsetHour < 10) {
      utcTimeStr.append("0").append(currentOffsetHour);
    } else {
      utcTimeStr.append(currentOffsetHour);
    }
    if (currentOffsetMin.equals(0)) {
      utcTimeStr.append("0").append(currentOffsetMin);
    } else {
      utcTimeStr.append(currentOffsetMin);
    }
    return utcTimeStr.toString();
  }

  /**
   * Adjust the date offset
   *
   * @param date   old date
   * @param field  granularity(hour, minute, second....)
   * @param offset
   * @return new date string after offset
   * @throws ParseException
   */
  public static String dateOffset(Date date, int field, int offset) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(field, offset);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateStr = dateFormat.format(cal.getTime());
    return dateStr;
  }
}
