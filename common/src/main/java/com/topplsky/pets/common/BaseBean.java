package com.topplsky.pets.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseBean implements Serializable {
    private static final long serialVersionUID = -7502176222329928247L;

    public String toString() {
        return JSON.toJSONString(this);
    }

}
