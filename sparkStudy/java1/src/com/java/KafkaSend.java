package com.java;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

//서버쪽으로 데이터를 보내는 곳 docker3의 역할
public class KafkaSend {

	public static void main(String[] args) {
	
		try {
			Properties config = new Properties();//Creates an empty property list with no default values.
			config.put("bootstrap.servers", "192.168.99.102:9092"); 
			config.put("acks", "all");
			config.put("block.on.buffer.full", "false");
			config.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
			config.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
			
			//producer 생성
			KafkaProducer<String, String> producer = new KafkaProducer<String, String>(config);
		
			System.out.println(producer);
			//3초 간격으로 메세지를 보냄
			for(int i=0; i<100; i++) {
				String msg = "Test Message: " + i;
				//A key/value pair to be sent to Kafka.
				//This consists of a topic name to which the record is being sent, 
				//an optional partition number, and an optional key and value. 
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("testPNU", msg);
				producer.send(record);
				
				//A thread is a thread of execution in a program. 
				//The JavaVirtual Machine allows an application to have multiple threads 
				//of execution running concurrently. 
				//In computer science, a thread of execution is the smallest sequence of 
				//programmed instructions that can be managed independently by a scheduler, 
				//which is typically a part of the operating system.
				Thread.sleep(2000);
			}
			producer.flush();
			producer.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
