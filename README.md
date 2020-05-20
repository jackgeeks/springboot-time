## java有那些时间操作类：
JDK8之前，处理日期时间的类是Date、Calendar
JDK8发布的时候，推出了LocalDate、LocalTime、LocalDateTime这个三个时间处理类
### Date
 
在JDK 1.1之前， Date有两个附加功能。 它允许将日期解释为年，月，日，小时，分钟和第二个值。 它还允许格式化和解析日期字符串。 不幸的是，这些功能的API不适合国际化。 从JDK 1.1开始， Calendar类应该用于在日期和时间字段之间进行转换，并且DateFormat类应用于格式化和解析日期字符串。 在相应的方法Date被弃用。 

尽管Date类旨在反映协调的世界时间（UTC），但根据Java虚拟机的主机环境的不同，可能不会这样做。 几乎所有的现代操作系统都假设在所有情况下1天= 24×60×60 = 86400秒。 然而，在UTC的时候，大概每一两年会有一秒钟的时间，叫做“闰秒”。 闰秒总是作为一天的最后一秒，总是在12月31日或6月30日。例如，1995年的最后一分钟是61秒，由于增加了闰秒。 大多数计算机时钟不够准确，不能反映出闰秒的区别。 

一些计算机标准是根据格林尼治标准时间（GMT）定义的，相当于世界时间（UT）。 GMT是标准的“民用”名称; UT是同一标准的“科学”名称。 UTC和UT之间的区别是UTC是基于原子钟，UT是基于天文观测，对于所有的实际目的来说，这是一个看不见的细毛。 因为地球的旋转不均匀（减速并以复杂的方式加速），UT并不总是均匀地流动。 根据需要，将时差引入到UTC中，以使UT在UT1的0.9秒内保持UTC，这是UT的版本，并应用了某些修正。 还有其他的时间和日期系统; 例如，基于卫星的全球定位系统（GPS）使用的时间尺度与UTC同步，但不对闰秒进行调整。 进一步信息的一个有趣的来源是美国海军天文台，特别是时间局在： 
```
    //创建一个代表系统当前日期的Date对象
        Date d1 = new Date();

       log.info("当前时间："+d1);
       log.info("时间毫秒数："+System.currentTimeMillis());

        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        String format = sdf.format(d1);
        log.info("格式化后:"+format);

        //使用带参数的构造方法Date(int year, int month, int day) ，
        // 可以构造指定日期的Date类对象，Date类中年份的参数应该是实际需要代表的年份减去1900，
        // 实际需要代表的月份减去1以后的值。
        Date d2 =  new Date(2020-1900, 6-1, 12);//过时了不推荐使用
        log.info("指定时间："+d2);

        //获得年份 （注意年份要加上1900，这样才是日期对象d2所代表的年份）

        int year = d2.getYear() + 1900;//过时了不推荐使用
        log.info("年份："+year);

        //获得月份  （注意月份要加1，这样才是日期对象d2所代表的月份）

        int month = d2.getMonth() + 1;//过时了不推荐使用
        log.info("月份："+month);

        //获得日期

        int date = d2.getDate();//过时了不推荐使用
        log.info("日期："+month);


        //获得小时

        int hour = d2.getHours();//不设置默认为0 。过时了不推荐使用
        log.info("小时："+hour);

        //获得分钟

        int minute = d2.getMinutes();//过时了不推荐使用
        log.info("分钟："+minute);

        //获得秒

        int second = d2.getSeconds();//过时了不推荐使用
        log.info("秒："+second);

        //获得星期 （注意：0代表星期日、1代表星期1、2代表星期2，其他的一次类推了）

        int day = d2.getDay();//过时了不推荐使用
        log.info("星期："+day);
```
> java.util.Date,java.sql.Date区别 
1、java.sql.Date是针对SQL语句使用的，它只包含日期而没有时间部分，一般在读写数据库的时候用，PreparedStament的setDate()的参数和ResultSet的getDate()方法的都是java.sql.Date
2、java.util.Date是在除了SQL语句的情况下面使用，一般是日常日期字段
3、java.util.Date 是 java.sql.Date 的父类，即：继承关系：java.lang.Object --》 java.util.Date --》 java.sql.Date
4.java.sql.Date 使用率非常低
## Calendar
Calendar类是一个抽象类，可以为在某一特定时刻和一组之间的转换的方法calendar fields如YEAR ， MONTH ， DAY_OF_MONTH ， HOUR ，等等，以及用于操纵该日历字段，如获取的日期下个星期。 时间上的瞬间可以用毫秒值表示，该值是从1970年1月1日00:00 00：00.000 GMT（Gregorian）的Epoch的偏移量
```
@Slf4j
public class Calendardome {
    public static void main(String[] args) {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss HHH" );

        // 使用当前时间创建
        Calendar calendar1 = Calendar.getInstance();
        log.info("当前时间："+calendar1);
        log.info("格式化后:"+sdf.format(calendar1.getTime()));
        // 指定时间创建，参数依次为：年，月，日，时，分，秒，月份需要减一
        Calendar calendar2 = new GregorianCalendar(2016, 8, 1, 15, 41, 22);
        log.info("指定时间："+calendar2);

        log.info("格式化后:"+sdf.format(calendar2.getTime()));
         //获得年
        int year = calendar2.get(Calendar.YEAR);
        log.info("年："+year);
        // 取月份要加1
        int month = calendar2.get(Calendar.MONTH) + 1;
        log.info("月份："+month);
        //获得天
        int day = calendar2.get(Calendar.DAY_OF_MONTH);
        log.info("天："+day);
        //获得时
        int hover = calendar2.get(Calendar.HOUR_OF_DAY);
        log.info("时："+hover);
        //获得分钟
        int minute = calendar2.get(Calendar.MINUTE);
        log.info("分钟："+minute);
        //获得秒
        int seconds = calendar2.get(Calendar.SECOND);
        log.info("秒："+seconds);
       // 1-7分别代表 -- 星期日,星期一,星期二,星期三,星期四,星期五,星期六
        //获得星期
        int week = calendar2.get(Calendar.DAY_OF_WEEK);
        log.info("星期："+week);

        String timeDeffer = getTimeDeffer(sdf.format(calendar1.getTime()), sdf.format(calendar2.getTime()));
         log.info(timeDeffer);

    }
    /**
     2      * 获取时间差
     3      * @param time1 time2 需要计算的时间
     4      * @return
     5      */
      public static String getTimeDeffer(String time1,String time2)
    {
               String result = "";
                 if(StringUtils.isNotBlank(time1)&& StringUtils.isNotBlank(time2)){
                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                      try {
                               long dt1 = sdf.parse( time1 ).getTime();
                               long dt2 = sdf.parse( time2 ).getTime();
                                long dc = Math.abs(dt2-dt1);
                                long seconds = dc/1000;
                                long date = seconds/(24*60*60);     //相差的天数
                          long hour = (seconds-date*24*60*60)/(60*60);//相差的小时数
                                long minut = (seconds-date*24*60*60-hour*60*60)/(60);//相差的分钟数
                          long second = (seconds-date*24*60*60-hour*60*60-minut*60);//相差的秒数
                          return (date==0?"":(date+"天"))+(hour==0?"":(hour+"小时"))+(minut==0?"":(minut+"分"))+(second==0?"":(second+"秒"));
                      } catch ( ParseException e) {
                          e.printStackTrace();
                             }
                     }
                 return result;
             }
}

```
### LocalDate、LocalTime、LocalDateTime
> JDK8为什么要推出LocalDate、LocalTime、LocalDateTime这个三个时间处理类？
以此来弥补之前的日期时间类的不足，简化日期时间的操作。在Java8之前，处理日期时间的类是Date、Calendar，这两个在使用起来总是让人感觉不是很舒服，在设计上面有一些缺陷，并且还不是线程安全的。

       想要详细的了解这几个类，我们得要了解一点关于时间、时区划分的一些知识。1884 年, 国际经度会议将地球表面按经线等分为24 区,称为时区。即以本初子午线为基准, 东西经度各7.5 度的范围作为零时区, 然后每隔15度为一时区，每个时区相差一小时。北京时区为东八区，要比零时区早8个小时。如果现在零时区的时间是10点的话，那北京时间就是18点。

       我们平时在程序里面所见到的UTC时间，就是零时区的时间，它的全称是Coordinated Universal Time ，即世界协调时间。另一个常见的缩写是GMT，即格林威治标准时间，格林威治位于 零时区，因此，我们平时说的UTC时间和GMT时间在数值上面都是一样的。 

        可能会有一些疑问，同样是在地球上啊，不同的地区时间怎么还不一样了？难道我现在从北京乘个飞机飞到格林威治，还可以来个时光倒流？如果这样，岂不很神奇？哈哈，当然事情的真相并不是这样的。时间的流逝、细胞的衰老对于整个地球来说都是一样的，因此，不管你在地球的哪里，这一秒过去了，就是过去了，它最为公平，不会多你一分，也不会少你一秒。那怎么记录这流逝的分分秒秒呢？有一个名词，叫做时间戳，它是指格林威治（地球零时区）时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数，这个时间戳，在地球的各个地方都是一致的。在1970年以前，有其他的计时方式，由于没有统一，还造成了一些软件的运行在时间上的错乱，险些酿成了的行业灾难(具体的事件可以网上搜索)。如果单纯指望这个时间戳作为人们的计时标准，那也是不现实的，因为这对人类的生产生活来说没有任何的意义。举个例子：每天早上八点上课（上班）符合我们的习惯，如果是***秒到了上课时间就有违人的正常脑回路了。这时候，根据地球上的不同经纬度、地球自转的特点，就划分了时区，时间戳根据不同的时区转化成当地的时间，以此作为作息标准，从而方便人们的生产生活。北京时间的8点我们可以见到太阳的升起，伦敦时间的八点他们也能见到太阳的升起。

       就这样，可以知道，时间戳对地球上的任何一个地方都是一样的，如果我们想要把时间戳转化成当地的时间，就需要根据所在地区的时区进行转化。不同时区之间进行时间转化也是一样的道理，我们需要根据时区的差异来转化当地的时间
```
@Slf4j
public class LocalTimedome {
    public static void main(String[] args) {
    //获取当前时区的日期
        LocalDate localDate = LocalDate.now();
     log.info("localDate: " + localDate);
        //时间
        LocalTime localTime = LocalTime.now();
       log.info("localTime: " + localTime);
        //根据上面两个对象，获取日期时间
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
       log.info("localDateTime: " + localDateTime);
        //使用静态方法生成此对象
        LocalDateTime localDateTime2 = LocalDateTime.now();
       log.info("localDateTime2: " + localDateTime2);
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
       log.info("格式化之后的时间: " + localDateTime2.format(formatter));

        //转化为时间戳(秒)
        long epochSecond = localDateTime2.toEpochSecond(ZoneOffset.of("+8"));
        //转化为毫秒
        long epochMilli = localDateTime2.atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli();
       log.info("时间戳为:(秒) " + epochSecond + "; (毫秒): " + epochMilli);

        //时间戳(毫秒)转化成LocalDateTime
        Instant instant = Instant.ofEpochMilli(epochMilli);
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());
       log.info("时间戳(毫秒)转化成LocalDateTime: " + localDateTime3.format(formatter));
        //时间戳(秒)转化成LocalDateTime
        Instant instant2 = Instant.ofEpochSecond(epochSecond);
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(instant2, ZoneOffset.systemDefault());
       log.info("时间戳(秒)转化成LocalDateTime: " + localDateTime4.format(formatter));

    }
}

```
新推出来的这三个类，与MySQL中的日期时间类型正好对应，如果我们使用MySQL数据库的话，在插入相应字段的时候，都不需要再进行任何的转化了。对应关系如下：
* LocalTime  对应  time
* LocalDate  对应  date
* LocalDateTime  对应  datetime(timestamp)
## 时区(Zone)
```
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS ", Locale.US);

        Calendar cd = Calendar.getInstance();
        // 设置时区为GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String str = sdf.format(cd.getTime());
        log.info("格林尼治标准时间："+str);
        Calendar cd2 = Calendar.getInstance();
        // 设置时区为GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String str2 = sdf.format(cd2.getTime());
        log.info("北京时间："+str2);



        // 输出所有时区
        //Set<String> set = ZoneId.getAvailableZoneIds();
        //set.forEach(System.out::println);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.atZone(ZoneId.of("Asia/Shanghai"));
        log.info("中国上海时间:"+dateTime);
        log.info("中国上海时间:"+LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        log.info("美国纽约时间:"+LocalDateTime.now(ZoneId.of("America/New_York")));
        log.info("英国伦敦时间:"+LocalDateTime.now(ZoneId.of("Europe/London")));
        // 带时区的时间或日期
        log.info("中国上海时间(带时区的时间或日期):"+ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));

        log.info("中国上海时间(带时区的时间或日期):"+ZonedDateTime.now());
        // LocalDateTime转为ZonedDateTime（带时区的时间或日期）
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        log.info("中国上海时间(localDateTime):"+localDateTime);
        log.info("中国上海时间(zonedDateTime):"+zonedDateTime);
        // ZonedDateTime（带时区的时间或日期）转 LocalDateTime
        LocalDateTime localDateTime1 = zonedDateTime.toLocalDateTime();
        log.info("中国上海时间(带时区的时间或日期):"+localDateTime1);


```


## Spring关于接收时间相关的问题
  前面带大家认识了java关于时间的操作类，在springMvc中你们有没有遇到这样的问题？
* LocalDateTime 类型转换问题
```
Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type `java.time.LocalDateTime` from String "2020-5-19": Failed to deserialize java.time.LocalDateTime: (java.time.format.DateTimeParseException) Text '2020-5-19' could not be parsed at index 5; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.time.LocalDateTime` from String "2020-5-19": Failed to deserialize java.time.LocalDateTime: (java.time.format.DateTimeParseException) Text '2020-5-19' could not be parsed at index 5
 at [Source: (PushbackInputStream); line: 5, column: 17] (through reference chain: com.wpp.springboottime.bean.User["currenttime"])]
```
 * Date类型转换问题
```
Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type `java.util.Date` from String "1980-09-08 11:30": not a valid representation (error: Failed to parse Date value '1980-09-08 11:30': Cannot parse date "1980-09-08 11:30": while it seems to fit format 'yyyy-MM-dd'T'HH:mm:ss.SSSX', parsing fails (leniency? null)); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.util.Date` from String "1980-09-08 11:30": not a valid representation (error: Failed to parse Date value '1980-09-08 11:30': Cannot parse date "1980-09-08 11:30": while it seems to fit format 'yyyy-MM-dd'T'HH:mm:ss.SSSX', parsing fails (leniency? null))
 at [Source: (PushbackInputStream); line: 4, column: 14] (through reference chain: com.wpp.springboottime.bean.User["birthday"])]
```
* 前端时间没有格式化
![f806da6495de510bfbd366ad3514244](http://520htt.com/upload/2020/05/f806da6495de510bfbd366ad3514244-32ce58983cb74fe28e47c1a2c7c5b31c.png)
## 全局处理

### 处理Date类型
```
spring:
  jackson:
    #参数意义：
    #JsonInclude.Include.ALWAYS              默认
    #JsonInclude.Include.NON_DEFAULT     属性为默认值不序列化
    #JsonInclude.Include.NON_EMPTY         属性为 空（””） 或者为 NULL 都不序列化
    #JsonInclude.Include.NON_NULL           属性为NULL   不序列化
    default-property-inclusion: ALWAYS
    time-zone: GMT+8
    date-format: yyyy-MM-dd HH:mm:ss
```
### 处理LocalDateTime 类型
```
@Configuration
public class DateformatConfig {

    /**
     * Date格式化字符串
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * DateTime格式化字符串
     */
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * Time格式化字符串
     */
    private static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 自定义Bean
     *
     * @return
     */
    @Bean
    @Primary
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
                .serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
    }

}
```
## 局部通用方法
`@DateTimeFormat`,`@DateTimeFormat`针对LocalDateTime ，Date 类型转换问题通用
```
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
```
@JsonFormat只适合 Content-Type 为application/json的请求
@DateTimeFormat只适合表单请求
## 关注公众号
![qrcode_for_gh_c8260435c2d7_258](http://520htt.com/upload/2020/05/qrcode_for_gh_c8260435c2d7_258-4703192829404b63b48d02e6e2cf9e1c.jpg)
