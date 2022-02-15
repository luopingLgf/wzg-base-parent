package com.wzg.framework.constant;

/**
 * 基础的常量接口类
 *
 * @author LuoPing
 * @since 2022/2/9
 */
public interface BaseConstant {
    class Terminal {
        /**
         * 终端的key
         */
        public static final String TERMINAL_KEY = "terminal";
        /**
         * 终端: pc
         */
        public static final String TERMINAL_PC = "pc";
        /**
         * 终端：h5
         */
        public static final String TERMINAL_H5 = "h5";
    }

    class BatchSize {
        public static final int BATCH_SIZE_20 = 20;
        public static final int BATCH_SIZE_50 = 50;
        public static final int BATCH_SIZE_100 = 100;
        public static final int BATCH_SIZE_200 = 200;
        public static final int BATCH_SIZE_500 = 500;
        public static final int BATCH_SIZE_1000 = 1000;
    }

}
