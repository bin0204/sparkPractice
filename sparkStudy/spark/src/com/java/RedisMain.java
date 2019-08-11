package com.java;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisMain {

	public static void main(String[] args) {
		
		String host = "127.0.0.1";
		int port = 6379;
		int timeout = 3000;
		int db = 0;

		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisPool pool = 
				new JedisPool(
						jedisPoolConfig, 
						host, 
						port, 
						timeout, 
						null, db); //null 비밀번호 설정 
		Jedis jedis = pool.getResource();

		
		// Connect 체크
		System.out.println(jedis.isConnected());

		//redis에 서버에 값을 넣음
		jedis.set("key4", "{\"ret\":\"abc\"}");
		jedis.set("key5", "ddddddddddddddddddddddddddddddddddddddd");
		jedis.set("key6", "{\"ret\":\"abc\"}"); 
		
		String str = "";
		for(int i =0; i<1000; i++) {
			str += "dfdfa er af daf de fedfafdf";
		}	
		jedis.set("key7", str);
		
		// key5로 넣은 데이터는 1초후 자동 삭제
		jedis.expire("key5", 1);

		// key5의 값을 가져옴.
		System.out.println(jedis.get("key5"));

		if (jedis != null) {
			jedis.close();
		}
		pool.close();
	}
}
