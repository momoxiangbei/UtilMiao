package com.mmxb.utilmiao;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mmxb.utilmiao.aidl.IMyAidl;
import com.mmxb.utilmiao.aidl.MyAidlService;
import com.mmxb.utilmiao.aidl.Person;
import com.mmxb.utilmiao.mvvm.MvvmSimpleActivity;
import com.mmxb.utilmiao.utils.NotificationUtil;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ServiceConnection mConnection;
    private IMyAidl mAidl;

    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;
        resultTV = findViewById(R.id.result_tv);

        findViewById(R.id.test_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (true) {

                }
            }
        });


        findViewById(R.id.notify_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.buildNotification(context, "title", "content", "wakaka");
            }
        });

        findViewById(R.id.aidl_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理
                        mAidl = IMyAidl.Stub.asInterface(service);
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
//                        mAidl = null;
                    }
                };

                Intent intent1 = new Intent(context, MyAidlService.class);
                bindService(intent1, mConnection, BIND_AUTO_CREATE);
                Random random = new Random();
                Person person = new Person();
                person.setmName("wakkk");

                try {
                    mAidl.addPerson(person);
                    List<Person> personList = mAidl.getPersonList();
                    resultTV.setText(personList.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.home_tv).setOnClickListener(v -> {
//            Intent intent = new Intent(context, HomeActivity.class);
//            startActivity(intent);

            // todo test
//        BadgeUtil.getLauncherClassName(this);

        });

        findViewById(R.id.mvvm_tv).setOnClickListener(v -> {
            Intent intent = new Intent(context, MvvmSimpleActivity.class);
            startActivity(intent);
        });


    }
}
