package com.java;

public class ThreadMain {

	
	//thread 1
	static Runnable r1 = new Runnable() {
		@Override
		public void run() {
			try {
				for(int i = 0; i<10; i++) {
					System.out.println("i"+i);
					Thread.sleep(500); //0.5ÃÊ µô·¹ÀÌ
				}
			}
			catch(Exception e) {
				
			}
		}
		
	 };
	
    //Thread 2
	static Runnable r2 = new Runnable() {
		@Override
		public void run() {
			try {
				for(int j = 0; j<10; j++) {
					System.out.println("j"+j);
					Thread.sleep(500); //0.5ÃÊ
				}
			}
			catch(Exception e) {
				
			}
		}
	};
	public static void main(String[] args) {
		
		new Thread(r1).start();
		new Thread(r2).start();
		
		
	}

}
