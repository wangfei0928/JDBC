package com.wf.test;

import com.wf.util.JDBCPool;

import java.sql.Connection;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCPool.getConn();
        System.out.println(Arrays.toString(JDBCPool.connections));
        System.out.println(Arrays.toString(JDBCPool.allStatus));
        System.out.println("--------------");
        JDBCPool.releaseCon(conn);

        Connection conn2 = JDBCPool.getConn();
        System.out.println(Arrays.toString(JDBCPool.connections));
        System.out.println(Arrays.toString(JDBCPool.allStatus));
        System.out.println("--------------");
        Connection conn3 = JDBCPool.getConn();
        System.out.println(Arrays.toString(JDBCPool.connections));
        System.out.println(Arrays.toString(JDBCPool.allStatus));
        System.out.println("--------------");
        Connection conn4 = JDBCPool.getConn();
        System.out.println(Arrays.toString(JDBCPool.connections));
        System.out.println(Arrays.toString(JDBCPool.allStatus));
        System.out.println("--------------");
        Connection conn5 = JDBCPool.getConn();
        System.out.println(Arrays.toString(JDBCPool.connections));
        System.out.println(Arrays.toString(JDBCPool.allStatus));

    }
}
