package com.samuraism.training;

import org.glassfish.embeddable.*;
import org.h2.tools.Server;

import java.nio.file.Paths;
import java.sql.SQLException;

public class Payara {
    public static void main(String... args) {
        new Payara().start(8080);
    }

    private GlassFish glassfish;
    private Server h2Server = null;

    public void start(int port) {
        // h2データベース起動
        try {
            String[] args = {
                    // tcpリスナを有効化
                    "-tcp",
                    "-tcpPort", "9092",
                    // Web管理コンソールを8082番で有効化、パスワードは admin
                    "-web",
                    "-webPort", "8082",
                    "-webAdminPassword", "admin",
                    // 存在しないDBへの接続を試みたら作る
                    "-ifNotExists"
            };
            Server.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Payara起動
        try {
            BootstrapProperties bootstrap = new BootstrapProperties();
            GlassFishRuntime runtime = GlassFishRuntime.bootstrap(bootstrap);
            GlassFishProperties properties = new GlassFishProperties();
            properties.setPort("http-listener", port);
            glassfish = runtime.newGlassFish(properties);
            glassfish.start();
            glassfish.getDeployer().deploy(Paths.get("src/main/webapp").toFile(),
                    "--contextroot", "/",
                    "--name", "training");
        } catch (GlassFishException gfe) {
            throw new RuntimeException(gfe);
        }
    }

    public void stop() {
        try {
            glassfish.stop();
            glassfish.dispose();
        } catch (GlassFishException gfe) {
            throw new RuntimeException(gfe);
        }
        h2Server.stop();
    }
}