package otherQuestion;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 *  基础知识疑惑：返回对象被篡改后能否影响到类中对象
 */
public class TestReturnValueChange {
    private Map map = new HashMap();

    public void init() {
        map.put("111", "111");
        map.put("222", "222");
    }

    public Map getMap() {
        return map;
    }

    public void printMap() {
        System.out.println("map="+ JSON.toJSONString(map));
    }

    public static void main(String[] args) {
        TestReturnValueChange testReturnValueChange = new TestReturnValueChange();
        testReturnValueChange.init();
        Map map1 = testReturnValueChange.getMap();
        System.out.println("map1="+ JSON.toJSONString(map1));
        map1.put("333","333");
        testReturnValueChange.printMap();
    }
}
