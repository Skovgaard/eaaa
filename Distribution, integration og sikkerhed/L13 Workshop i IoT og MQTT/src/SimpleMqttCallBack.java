import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class SimpleMqttCallBack implements MqttCallback {
    int status = 0;

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }


    public void messageArrived(String s, MqttMessage mqttMessage) throws MqttException {
        String res = new String(mqttMessage.getPayload());
        // res indeholder en måling som et JSON-object

//        System.out.println(res); // Opg 7

        JSONObject jo = new JSONObject(res);
        String time = jo.getString("Time");
        JSONObject am = jo.getJSONObject("AM2301");
        double temp = am.getDouble("Temperature");
        double hum = am.getDouble("Humidity");

        System.out.printf("Time: %s Temp: %s Hum: %s %n", time, temp, hum);

        // Opg 8
//        MQTTprogram.toggleHeater(hum > 85 ? "1" : "0");

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
} 