package com.zhaomeng.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Arrays;
import java.util.Properties;

public class Admin {

    private static final String TOPIC_NAME = "xiaolin_topic";
    public static void main(String[] args) {
        AdminClient adminClient = Admin.adminClient();
        System.out.println(adminClient);
    }

    public static void createTopic() {
        AdminClient adminClient = adminClient();

        // 副本因子
        Short replicationFactor = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, replicationFactor);

        adminClient.createTopics(Arrays.asList(newTopic));
    }
    /**
     * 配置AdminClient
     */
    public static AdminClient adminClient() {

        Properties properties = new Properties();
        // !配置虚拟机服务器地址
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.106:9092");


        return AdminClient.create(properties);
    }
}
