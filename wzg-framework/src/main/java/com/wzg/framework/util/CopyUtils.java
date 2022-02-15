package com.wzg.framework.util;

import com.wzg.framework.exception.CustomException;

import java.io.*;

/**
 * <p>
 * 对象拷贝工具类
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/15
 */
public class CopyUtils {
    /**
     * 对象拷贝 - 序列号方式
     *
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T extends Serializable> T serialClone(T obj) {
        try {
            // 创建一块内存来存放对象
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(bout);
            // 将对象转化为二进制存入开辟的内存中（序例化）
            oos.writeObject(obj);

            // 读取内存中的二进制内容
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            // 将二进制内容转化回对象（反序例化）
            ObjectInputStream ois = new ObjectInputStream(bin);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CustomException("对象拷贝异常");
        }

    }
}
