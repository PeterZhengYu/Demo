package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_button = findViewById(R.id.bt_button);

        bt_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyThread thread1 = new MyThread("窗口1");
                MyThread2 thread2 = new MyThread2("窗口2");
                thread1.start();
                thread2.start();
            }
        });
    }

    public class MyThread extends Thread {
        private int count = 100;
        private String name;

        public MyThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while (count > 0) {
                count--;
                System.out.println(name + "卖掉了1张票，剩余票数为：" + count);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class MyThread2 extends Thread {
        private int count = 100;
        private String name;

        public MyThread2(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(".....");
            System.out.println("111111111111111111111111");
        }
    }
}
