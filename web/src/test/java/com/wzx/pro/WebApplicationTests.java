//package com.wzx.pro;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.wzx.pro.common.util.HttpClientUtil;
//import com.wzx.pro.dao.BigMoneyMapper;
//import com.wzx.pro.domain.money.BigMoney;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.time.DateUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WebApplicationTests{
//    @Resource
//    private BigMoneyMapper bigMoneyMapper;
//
//    @Test
//    public void contextLoads() throws Exception{
//        String startTerm ="";
//        String endTerm ="";
//        for(int i=7;i<23;i++){
//            if(i<10){
//                startTerm = "0"+i+"001";
//                endTerm ="0"+i+"200";
//            }else {
//                startTerm = i+"001";
//                endTerm =i+"200";
//            }
//            String url = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry";
//            Map<String,String> map = Maps.newHashMap();
//            map.put("gameNo","85");
//            map.put("provinceId","0");
//            map.put("pageSize","200");
//            map.put("isVerify","1");
//            map.put("pageNo","1");
//            map.put("startTerm",startTerm);
//            map.put("endTerm",endTerm);
//            String s = HttpClientUtil.doGet(url, map, "utf-8");
//            handelResponse(s);
//
//
//
//        }
//
//    }
//    public  void handelResponse(String str) throws Exception{
//        if(StringUtils.isNoneBlank(str)){
//            JSONObject json = JSON.parseObject(str);
//            boolean success = json.getBooleanValue("success");
//            if(success){
//                JSONObject value = json.getJSONObject("value");
//                if(Objects.nonNull(value)){
//                    JSONArray list = value.getJSONArray("list");
//                    for(int i=0;i<list.size();i++){
//                        JSONObject obj = list.getJSONObject(i);
//                        if(Objects.nonNull(obj)){
//                            String time = obj.getString("lotterySaleEndtime");
//                            String term = obj.getString("lotteryDrawNum");
//                            String result = obj.getString("lotteryDrawResult");
//                            String[] split = result.split(" ");
//                            BigMoney money = new BigMoney();
//                            money.setTime(DateUtils.parseDate(time,"yyyy-MM-dd HH:mm:ss"));
//                            money.setTerm(term);
//                            money.setOne(split[0]);
//                            money.setTwo(split[1]);
//                            money.setThree(split[2]);
//                            money.setFour(split[3]);
//                            money.setFive(split[4]);
//                            money.setBigOne(split[5]);
//                            money.setBigTwo(split[6]);
//                            String replace = result.replace(" ", "");
//                            money.setStr(replace);
//                            money.setLast(money.getBigOne()+money.getBigTwo());
//                            bigMoneyMapper.insert(money);
//                        }
//                    }
//
//                }
//            }
//
//        }
//    }
//
//
//    @Test
//    public void getNumber(){
//
//        List<Integer> list = Lists.newArrayList();
//        String str = "";
//
//
//        while (list.size()<5){
//            int num=(int)(Math.random()*(34)+1);
//            if(!list.contains(num)){
//                list.add(num);
//                str =str+num;
//            }
//
//        }
//
//
//        String strA= "";
//        List<Integer> two = Lists.newArrayList();
//        while (two.size()<2){
//            int aa=(int)(Math.random()*(11)+1);
//            if(!two.contains(aa)){
//                two.add(aa);
//                strA=strA+aa;
//            }
//
//        }
//
//
//        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
//        List<Integer> collectTwo = two.stream().sorted().collect(Collectors.toList());
//
//        BigMoney money = new BigMoney();
//        money.setOne(collect.get(0).toString());
//        money.setTwo(collect.get(1).toString());
//        money.setThree(collect.get(2).toString());
//        money.setFour(collect.get(3).toString());
//        money.setFive(collect.get(4).toString());
//        money.setBigOne(collectTwo.get(0).toString());
//        money.setBigTwo(collectTwo.get(1).toString());
//
//        BigMoney result = bigMoneyMapper.findBigMoney(money);
//
//        System.out.printf(JSON.toJSONString(result));
//
//
//    }
//
//
//}
