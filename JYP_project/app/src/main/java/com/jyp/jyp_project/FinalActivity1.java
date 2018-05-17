package com.jyp.jyp_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;



public class FinalActivity1 extends YouTubeBaseActivity {

//    private ProgressDialog progressBar;

    static final int PERMISSION_REQUEST_CODE = 1;
    String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};
//    private File outputFile; //파일명까지 포함한 경로
//    private File path;//디렉토리경로

    //퍼미션 관련 코드
    @SuppressLint("WrongConstant")
    private boolean hasPermissions(String[] permissions) {
        int res = 0;
        //스트링 배열에 있는 퍼미션들의 허가 상태 여부 확인
        for (String perms : permissions){
            res = checkCallingOrSelfPermission(perms);
            if (!(res == PackageManager.PERMISSION_GRANTED)){
                //퍼미션 허가 안된 경우
                return false;
            }

        }
        //퍼미션이 허가된 경우
        return true;
    }


    private void requestNecessaryPermissions(String[] permissions) {
        //마시멜로( API 23 )이상에서 런타임 퍼미션(Runtime Permission) 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final1);

        //퍼미션 관련 코드드
       if (!hasPermissions(PERMISSIONS)) { //퍼미션 허가를 했었는지 여부를 확인
            requestNecessaryPermissions(PERMISSIONS);//퍼미션 허가안되어 있다면 사용자에게 요청
        } else {
            //이미 사용자에게 퍼미션 허가를 받음.
        }


        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("놀이방법");
        tabHost1.addTab(ts1);
        TextView finalTab1 = (TextView) findViewById(R.id.tab1);
        Intent intent1 = getIntent(); // 보내온 Intent를 얻는다
        finalTab1.setText(intent1.getStringExtra("rule"));

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2) ; ts2.setIndicator("효과");
        tabHost1.addTab(ts2);
        TextView finalTab2 = (TextView) findViewById(R.id.tab2);
        Intent intent2 = getIntent(); // 보내온 Intent를 얻는다
        finalTab2.setText(intent2.getStringExtra("effect"));

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("동영상");
        tabHost1.addTab(ts3) ;

        Button videobutton = (Button)findViewById(R.id.videobutton);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent videoIntent = new Intent(FinalActivity1.this, Video1Activity.class);
//                FinalActivity1.this.startActivity(videoIntent);
//            }
//        });

        final YouTubePlayer.OnInitializedListener listener;
        //리스너 등록부분
        listener = new YouTubePlayer.OnInitializedListener() {

            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("I4dXyoP5bvo"); //url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        videobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                YouTubePlayerView youTubeView;
                youTubeView = (YouTubePlayerView)findViewById(R.id.youtube_view_tab3);
                //첫번째 인자는 API키값 두번째는 실행할 리스너객체를 넘겨줌
                youTubeView.initialize("AIzaSyBjDySrh_ba0fe32OGlt0KbOGrurZORz7A", listener);
            }
        });

        // 네 번째 Tab. (탭 표시 텍스트:"TAB 4"), (페이지 뷰:"content4")
        TabHost.TabSpec ts4 = tabHost1.newTabSpec("Tab Spec 4");
        ts4.setContent(R.id.content4);
        ts4.setIndicator("자료");
        tabHost1.addTab(ts4) ;

//        TextView tv=(TextView) findViewById(R.id.tab4);
//        ListView lv=(ListView)findViewById(R.id.listView1);
        Button btn1 = (Button) findViewById(R.id.readbutton);
        Button btn2 = (Button) findViewById(R.id.savebutton);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    TextView tv=(TextView) findViewById(R.id.tab4);
                    String content = new String(readTxt());
                    tv.setText(content);
                } catch (Exception e) {
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"sample_test.txt");
//                Log.d("cvrt", "Error 1");

                try {
                    if(!file.exists()) file.createNewFile();
//                    Log.d("cvrt", "Error 2");
                    FileOutputStream fOut = new FileOutputStream(file, true);
//                    Log.d("cvrt", "Error 3");
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
//                    Log.d("cvrt", "Error 4");
                    myOutWriter.append(readTxt());
//                    Log.d("cvrt", "Error 5");

                    myOutWriter.close();
                    fOut.flush();
                    fOut.close();

                } catch (IOException e) {
//                    Log.e("cvrt", "write Eorr : " + e.getLocalizedMessage());
                    e.printStackTrace();
                }
              }
        });
//        btn3.setOnClickListener(this);

        // 다섯 번째 Tab. (탭 표시 텍스트:"TAB 5"), (페이지 뷰:"content5")
        TabHost.TabSpec ts5 = tabHost1.newTabSpec("Tab Spec 5");
        ts5.setContent(R.id.content5);
        ts5.setIndicator("홈");
        tabHost1.addTab(ts5) ;

        Button backbutton = (Button)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(FinalActivity1.this, MainActivity.class);
                FinalActivity1.this.startActivity(backIntent);
            }
        });

//        // 파일 입출력 테스트 중 !!!
//        TextView tt = (TextView) findViewById(R.id.tab2);
//        tt.setText(readTxt());

    }
    // Text 데이터 출력
    private String readTxt() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw._test);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
