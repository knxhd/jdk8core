package com.mikasa.list;

import com.mikasa.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ListStream
 * @description
 * @author: tianluhua
 * @date 2019/4/17 16:41
 */
public class ListStream {

    /**
     * list集合中的分组求和，将多个字段相同的对象的某个字段的值相加
     *
     * @param
     * @return void
     * @date 2019/4/17 16:37
     */
    @Test
    public void listGroupBySum() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("张无忌", "倚天屠龙记", "明朝", 2));
        userList.add(new User("郭靖", "射雕英雄传", "大宋", 4));
        userList.add(new User("赵敏", "倚天屠龙记", "明朝", 3));
        userList.add(new User("洪七公", "射雕英雄传", "大宋", 3));
        userList.add(new User("洪七公", "射雕英雄传", "大宋", 7));
        /*
         * 根据name、address和conntry进行分组，并将scode求和，得到新的list集合
         * 获得一个map，address-country-name为分组依据的map
         */
        List<User> userList1 = new ArrayList<>();
        Map<String, Integer> collect = userList.stream().collect(Collectors.groupingBy(user -> user.getAddress() + "-" + user.getCountry() + "-" + user.getName(), Collectors.summingInt(User::getScode)));
        for (String key : collect.keySet()) {
            User user = new User();
            String[] split = key.split("-");
            user.setAddress(split[0]);
            user.setCountry(split[1]);
            user.setName(split[2]);
            user.setScode(collect.get(key));
            userList1.add(user);
        }
        for (User user : userList1) {
            System.out.println(user);
        }
    }
}
