package com.jyp.jyp_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


//유트브 플레이어 테스트----------------------------------------------------------------------------
//YouTubeBaseActivity로 상속 받는것에 유의 ***중요
public class Video1Activity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);
//
//
//        final YouTubePlayerView youTubeView;
//        Button button;
//        final YouTubePlayer.OnInitializedListener listener;
//
//            button = (Button)findViewById(R.id.videoButton);
//            youTubeView = (YouTubePlayerView)findViewById(R.id.youtube_view);
//
//            //리스너 등록부분
//            listener = new YouTubePlayer.OnInitializedListener(){
//
//                //초기화 성공시
//                @Override
//                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                    youTubePlayer.loadVideo("QadSVWXF_ks");//url의 맨 뒷부분 ID값만 넣으면 됨
//                }
//                @Override
//                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//                }
//            };
//
//            button.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view) {
//                    //첫번째 인자는 API키값 두번째는 실행할 리스너객체를 넘겨줌
////                    youTubeView.initialize("AIzaSyAmkohU9WUmoA-1cGo1yby0545s7XfZaEo", listener);
//                    youTubeView.initialize("AIzaSyBjDySrh_ba0fe32OGlt0KbOGrurZORz7A", listener);
//                }
//            });

    }
}
