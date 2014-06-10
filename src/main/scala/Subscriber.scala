package main.scala

import org.eclipse.paho.client.mqttv3._
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

/**
 *
 * MQTT subcriber
 * @author Prabeesh K
 * @mail prabsmails@gmail.com
 *
 */

object Subscriber {

  def main(args: Array[String]) {

    val brokerUrl = "tcp://10.30.9.105:1883"
    val topic = "hello"

    //Set up persistence for messages 
    val persistence = new MemoryPersistence

    //Initializing Mqtt Client specifying brokerUrl, clientID and MqttClientPersistance
    val client = new MqttClient(brokerUrl, MqttClient.generateClientId, persistence)

    //Connect to MqttBroker    
    client.connect

    //Subscribe to Mqtt topic
    client.subscribe(topic)

    //Callback automatically triggers as and when new message arrives on specified topic
    val callback = new MqttCallback {

      override def messageArrived(topic: String, message: MqttMessage): Unit = println(message.toString)

      override def connectionLost(cause: Throwable): Unit = cause.printStackTrace()

      override def deliveryComplete(token: IMqttDeliveryToken): Unit = {

      }
    }

    //Set up callback for MqttClient
    client.setCallback(callback)

  }
}
