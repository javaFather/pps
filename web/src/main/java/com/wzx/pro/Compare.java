package com.wzx.pro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class Compare {
    private static List<String> passCompare=Lists.newArrayList("neq","SHJT","type_BT","type_ES","type_OD","type_RP","1期");

    private static List<String> passAttribute = Lists.newArrayList("title");

    public static void main(String[] args) {
        //1.attribute  属性标签
//        String name = "1借条";
        String name = "3微零花";
        String url = "C:/Users/wangzhenxing-jk/AppData/Roaming/360Teams/downloadFiles/老新标签对比";
        String newJson = readJsonFile(url + "/new/"+name+"/1.txt");
        String oldJson = readJsonFile(url + "/old/"+name+"/1.txt");
        JSONObject new_json = JSON.parseObject(newJson, JSONObject.class);
        JSONObject old_json = JSON.parseObject(oldJson, JSONObject.class);

        JSONObject new_data = new_json.getJSONObject("data");
        JSONObject old_data = old_json.getJSONObject("data");

        JSONArray new_attribute = new_data.getJSONArray("attribute");
        JSONArray old_attribute = old_data.getJSONArray("attribute");

        Map<String, Map<String, Object>> oldMap = convertAttribute(old_attribute);
        Map<String, Map<String, Object>> newMap = convertAttribute(new_attribute);
        //比较属性标签
        List<JSONObject> strings = compareAttribute(oldMap, newMap);
        log.info("属性标签对比结果：{}", JSON.toJSONString(strings));

        //比较行为标签
        JSONObject old_behavior_obj = old_data.getJSONObject("behavior");
        JSONObject new_behavior_obj = new_data.getJSONObject("behavior");
        if (old_behavior_obj == null && new_behavior_obj == null) {
            return;
        }

        //行为标签match
        JSONArray old_match = getMatch(old_behavior_obj, "match");
        JSONArray new_match = getMatch(new_behavior_obj, "match");
        List<JSONObject> matchResult = compareMatch(old_match, new_match);
        log.info("行为标签match比较结果:{}", JSON.toJSONString(matchResult));

        //行为标签noMatch
        JSONArray old_no_match = getMatch(old_behavior_obj, "nomatchs");
        JSONArray new_no_match = getMatch(new_behavior_obj, "nomatchs");
        List<JSONObject> noMatchResult = compareMatch(old_no_match, new_no_match);
        log.info("行为标签nomatchs比较结果:{}", JSON.toJSONString(noMatchResult));

    }


    private static List<JSONObject> compareMatch(JSONArray old_match, JSONArray new_match) {
        Map<String, Object> map = Maps.newHashMap();
        for (Object obj : new_match) {
            JSONObject item = JSON.parseObject(obj.toString());
            map.put(item.getString("key"), item);
        }

        List<JSONObject> result = Lists.newArrayList();
        for (Object obj : old_match) {
            JSONObject itemResult = new JSONObject();
            JSONObject oldItem = JSON.parseObject(obj.toString());
            String labelKey = (String) oldItem.get("key");
            //新标签的值
            Object newObj = map.get(labelKey);
            if(Objects.isNull(newObj)){
                itemResult.put("1",labelKey+"标签在新标签中不存在");
                result.add(itemResult);
                continue;
            }

            JSONObject newItem = JSON.parseObject(newObj.toString());
            compareJson(labelKey, oldItem, newItem, itemResult, 0);
            if (itemResult.size() > 0) {
                result.add(itemResult);
            }
        }

        return result;
    }

    private static void compareJson(String labelKey, JSONObject oldItem, JSONObject newItem, JSONObject result, int index) {
        if (Objects.isNull(oldItem) || Objects.isNull(newItem)) {
            return;
        }

        for (String key : oldItem.keySet()) {
            if(Lists.newArrayList("label","original_placeholder","1期","title","credit_extension").contains(key)){
                continue;
            }

            //遍历jsonObject
            Object oldKeyValue = oldItem.get(key);

            Object newKeyValue = newItem.get(key);

            if (!newItem.containsKey(key)) {
                result.put(String.valueOf(++index), labelKey + "下" + key + "标签属性在新标签中不存在");
                continue;
            }

            if (oldKeyValue instanceof JSONArray) {
                if (!(newKeyValue instanceof JSONArray)) {
                    result.put(String.valueOf(++index), labelKey + "下" + key + "标签属性值类型不相等");
                    continue;
                }
                JSONArray oldItemArray = JSONObject.parseArray(oldKeyValue.toString());
                JSONArray newItemArray = JSONObject.parseArray(newKeyValue.toString());

                for (Object item : oldItemArray) {
                    JSONObject oldItemObj = JSONObject.parseObject(item.toString());
                    String itemKey = String.valueOf(oldItemObj.get("key"));
                    if(passCompare.contains(itemKey)){
                        continue;
                    }
                    Map<String, Object> map = Maps.newHashMap();
                    for (Object obj : newItemArray) {
                        JSONObject newItemValue = JSON.parseObject(obj.toString());
                        map.put(newItemValue.getString("key"), newItemValue);
                    }

                    Object obj = map.get(itemKey);
                    if (Objects.isNull(obj)) {
                        result.put(String.valueOf(++index), labelKey + "下" + itemKey + "属性值在新标签不存在");
                        continue;
                    }
                    JSONObject newItemObj = JSONObject.parseObject(obj.toString());
                    compareJson(labelKey+"-->"+itemKey, oldItemObj, newItemObj, result, index);
                }

            } else {
                oldKeyValue=String.valueOf(oldKeyValue);
                newKeyValue=String.valueOf(newKeyValue);
                if (!oldKeyValue.equals(newKeyValue)) {
                    result.put(String.valueOf(++index), labelKey + "下" + key + "标签属性的值不相等，" +
                            "【oldValue=】" + JSON.toJSONString(oldKeyValue) + "【newValue=】" + JSON.toJSONString(newKeyValue));
                }

            }

        }

    }


    /**
     * 获取行为标签列表
     *
     * @param obj
     * @return
     */
    private static JSONArray getMatch(JSONObject obj, String key) {
        if (obj == null) {
            return new JSONArray();
        }
        return obj.getJSONArray(key);
    }


    private static Map<String, Map<String, Object>> convertAttribute(JSONArray array) {
        Map<String, Map<String, Object>> result = Maps.newHashMap();
        for (Object obj : array) {
            Map<String, Object> map = JSON.parseObject(obj.toString());
            String key = (String) map.get("key");
            if (StringUtils.isEmpty(key)) {
                continue;
            }
            map.remove("key");
            map.remove("id");
            map.remove("treeJson");
            Object options = map.get("options");
            if (Objects.nonNull(options)) {
                JSONArray optionsArray = JSON.parseArray(options.toString());
                List<Map<String, Object>> list = Lists.newArrayList();
                for (Object item : optionsArray) {
                    Map<String, Object> optItemMap = JSON.parseObject(item.toString());
                    List<String> removeKey = Lists.newArrayList();
                    for (String itemKey : optItemMap.keySet()) {
                        //为空的options 属性
                        String optItemVal = (String) optItemMap.get(itemKey);
                        if (optItemVal.equals("") || optItemVal.equals("null")) {
                            removeKey.add(itemKey);
                        }
                    }
                    //移除为空的options 属性
                    for (String removeItemKey : removeKey) {
                        optItemMap.remove(removeItemKey);
                    }

                    list.add(optItemMap);
                }
                map.put("options", list);
            }
            result.put(key, map);
        }
        return result;
    }

    /**
     * 比较属性标签
     *
     * @return
     */
    private static List<JSONObject> compareAttribute(Map<String, Map<String, Object>> oldMap, Map<String, Map<String, Object>> newMap) {
        List<JSONObject> result = Lists.newArrayList();
        for (String key : oldMap.keySet()) {
            JSONObject message = new JSONObject();
            int count = 0;
            Map<String, Object> oldItem = oldMap.get(key);
            Map<String, Object> newItem = newMap.get(key);
            //老标签不存在新标签中
            if (Objects.isNull(newItem)) {
                message.put(String.valueOf(++count), key + "在新标签中不存在");
                continue;
            }

            List<String> passList = Lists.newArrayList("message","label","placeholder","title","extra","type");
            //迭代元素比较
            for (String itemKey : oldItem.keySet()) {
                if(passList.contains(itemKey)){
                    continue;
                }
                //比较基本属性
                if (!itemKey.equals("options")) {
                    Object oldValue = oldItem.get(itemKey);
                    Object newValue = newItem.get(itemKey);
                    if (!oldValue.equals(newValue)) {
                        message.put(String.valueOf(++count), key + "标签下，" + itemKey + "属性值不相等【oldValue=" + oldValue + "】，【newValue=" + newValue + "】");
                    }
                } else {

                    if(passAttribute.contains(key)){
                        continue;
                    }

                    //比较 options
                    JSONArray oldValue = JSON.parseArray(oldItem.get(itemKey).toString());
                    JSONArray newValue = JSON.parseArray(newItem.get(itemKey).toString());
                    if (oldValue != null && newValue != null && oldValue.size() > newValue.size()) {
                        message.put(String.valueOf(++count), key + "【options:个数不相等】," +
                                "oldValue=【" + JSON.toJSONString(oldValue) + "】，newValue=【" + JSON.toJSONString(newValue) + "】");
                    }
                    for (Object item : oldValue) {
                        JSONObject itemJson = JSON.parseObject(item.toString());
                        if (!newValue.contains(itemJson)) {
                            message.put(String.valueOf(++count), key + "【options:值不相等】,oldValue=【" + JSON.toJSONString(oldValue) + "】，newValue=【" + JSON.toJSONString(newValue) + "】");
                        }
                    }
                }
            }
            if (message.size() > 0) {
                result.add(message);
            }
        }

        return result;
    }

    public static String readJsonFile(String filePath) {
        String jsonStr = "";
        try {
            File jsonFile = new File(filePath);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
