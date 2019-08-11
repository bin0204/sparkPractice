package com.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

import org.json.*;




public class ReceiveJSON {

	public static void main(String[] args) {
		
		try {
			//receive url
			String url = "http://ihongss.com/demo/ajax_member_list4.json";
			
			CloseableHttpClient client = HttpClients.createDefault();
			
			//call "get" way
			HttpGet get = new HttpGet(url);
			
			HttpResponse response = client.execute(get);
			
			
			//InputStream <==> OutputStream
			//InputStreamReader <==> OutputStreamWriter
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String recvData = "";
			while((recvData = br.readLine()) != null) {
				JSONObject json = new JSONObject(recvData);
				String ret = json.getString("ret");	
				if(ret.equals("y")) {
					JSONArray jary = json.getJSONArray("data");
					for(int i=0;i<jary.length();i++) {	
						JSONObject jobj = jary.getJSONObject(i);
						String id = jobj.getString("id");
						String name = jobj.getString("name");
						int age = jobj.getInt("age");
						System.out.println(id);
						System.out.println(name);
						System.out.println(age);
					}
					//System.out.println(jary);
				}
			}
			br.close();
		}
		catch(Exception e) {
			//System.out.println(e.getMessage());
		}
	}

}
