package com.example.OceanEyes.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.OceanEyes.Config.MqttConfig;
@Service
public class MqttService {

    private final MqttConfig mqttConfig;

    public MqttService() {
        mqttConfig = new MqttConfig();
        mqttConfig.connect();
    }

    public void sendMessage(String topic, String message) {
        mqttConfig.publish(topic, message);
    }

    public void receiveMessages(String topic) {
        mqttConfig.subscribe(topic);
    }

    @PostConstruct
    public void init() {
        mqttConfig.subscribe("device/data");
    }

    public void closeConnection() {
        mqttConfig.disconnect();
    }
}
