package com.qingxuan.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 多状态实体
 * @author Mr.Xihua
 * @email xihua.zh@raycloud.com
 * @date 2021-09-23 09:46
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuple2<T,F> implements Serializable {

    private static final long serialVersionUID = 5684961843364246547L;

    private T key;

    private F value;


    public static <T,F> Tuple2<T,F> of(T t,F f){
        return new Tuple2<>(t,f);
    }
}
