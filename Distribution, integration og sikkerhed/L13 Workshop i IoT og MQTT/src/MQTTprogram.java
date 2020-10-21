import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTprogram {

    private static MqttClient sampleClient;

    private static String[] topics = {"3254", "5227", "7695", "4218"};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String broker = "tcp://192.168.1.1:1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            // Opg 7
            sampleClient.setCallback(new SimpleMqttCallBack());

            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");


            // Test
            for (String topic : topics) {
                String name = "cmnd/grp" + topic + "/Power1";
                publishMessage(sampleClient, name, "1");
            }

            Thread.sleep(5000);

            for (String topic : topics) {
                String name = "cmnd/grp" + topic + "/Power1";
                publishMessage(sampleClient, name, "0");
            }

            // Opg 6
//            String topic = "cmnd/grp3297/Power1";
//            publishMessage(sampleClient, topic, "1");
//            publishMessage(sampleClient, topic, "0");

            // Opg 7
//            String topicOpg7 = "tele/grp3297/SENSOR";
//            sampleClient.subscribe(topicOpg7);
//            Thread.sleep(200000);

            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void publishMessage(MqttClient sampleClient, String topicsend, String content) throws MqttPersistenceException, MqttException {
        // Laver en publish på sampleClient med topic topicsend og indhold content.
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        System.out.println(content.getBytes());
        sampleClient.publish(topicsend, message);
        System.out.println("Message published");
    }

    public static void toggleHeater(String value) throws MqttException {
        String topic = "cmnd/grp3297/Power1";
        publishMessage(sampleClient, topic, value);
    }

}