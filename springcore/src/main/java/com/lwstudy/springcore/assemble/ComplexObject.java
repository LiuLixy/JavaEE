package com.lwstudy.springcore.assemble;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 22:08
 */
public class ComplexObject {

    private Properties properties;

    private List<Object> list;

    private Set<String> set;

    private Map<String, Object> map;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "properties=" + properties +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
