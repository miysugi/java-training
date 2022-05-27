package com.samuraism.javatraining;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException{
        // H2をサーバモードで起動
        Server.main(
                // tcpリスナを有効化
                "-tcp",
                // 存在しないDBへの接続を試みたら作る
                "-ifNotExists"
        );
        SpringApplication.run(Main.class, args);
    }
}
