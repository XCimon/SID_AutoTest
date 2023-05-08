package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Component
//@ConfigurationProperties("kafka")
public class KafkaProperty {
    String bootstrapServers = "10.151.5.217:30093";
    Consumer consumer;
    String topic;
    String msgTopic;
    String enableSsl = "true";
    Sasl sasl = new Sasl();
    Security security = new Security();
    Ssl ssl = new Ssl();
    
    @Data
    public static class Consumer {
        String groupId;
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sasl {
        String mechanism = "SCRAM-SHA-512";
        Jaas jaas = new Jaas();
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Jaas {
        String username;
        String password;
        String config = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"admin\" password=\"cjEIXRbMnZLt\";";
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Security {
        String protocol = "SASL_SSL";
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Ssl {
        Store truststore = new Store("/Users/xupeng/Desktop/certificates/client.truststore.jks", "nrFRb_7Bqg808zrOuD8BZyF9aYvroKup");
        Store keystore = new Store("/Users/xupeng/Desktop/certificates/client.keystore.jks", "nrFRb_7Bqg808zrOuD8BZyF9aYvroKup");
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Store {
        String location;
        String password;
    }
    
}
