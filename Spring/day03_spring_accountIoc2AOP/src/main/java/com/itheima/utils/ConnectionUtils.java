package com.itheima.utils;


import javax.sql.DataSource;
import java.sql.Connection;


/**
 * 连接的工具类，他从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal获取
        Connection conn = tl.get();
        //2.判断当前线程是否有连接
        try{
            if (conn == null){
                //3.从数据中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);}
                return conn;
            }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();

    }

}
