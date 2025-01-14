package com.monk.player.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.widget.AbsoluteLayout;
import android.widget.ViewAnimator;
import android.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.widget.* ;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andy.player.R;
import com.*;
import com.monk.player.adapter.FragmentAdapter;
import com.monk.player.aidl.* ;
import com.monk.player.aidl.IMusicPlayer;
import com.monk.player.aidl.MusicPlayListner;
import com.monk.player.aidl.SongBean;
import com.monk.player.application.MyApplication;
import com.monk.player.bean.BaseActivity;
import com.monk.player.mvp.local.LocalMusicFragment;
import com.monk.player.mvp.paly.PlayFragment;
import com.monk.player.mvp.search.SearchMusicActivity;
import com.monk.player.service.MusicService;
import com.monk.player.tools.CoverLoader;
import com.monk.player.tools.LogUtil;
import com.monk.player.tools.NaviMenuExecutor;
import com.monk.player.tools.PermissionUtils;
import com.monk.player.tools.RetrofitUtil;
import com.monk.player.tools.SongEvent;
import com.monk.player.tools.ToastUtil;
import com.monk.player.tools.WeatherExecutor;
import org.*;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MusicAcitivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_local_music)
    TextView tvLocalMusic;
    @BindView(R.id.tv_online_music)
    TextView tvOnlineMusic;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.iv_play_bar_cover)
    ImageView ivPlayBarCover;
    @BindView(R.id.tv_play_bar_title)
    TextView tvPlayBarTitle;
    @BindView(R.id.tv_play_bar_artist)
    TextView tvPlayBarArtist;
    @BindView(R.id.iv_play_bar_play)
    ImageView ivPlayBarPlay;
    @BindView(R.id.iv_play_bar_next)
    ImageView ivPlayBarNext;
    @BindView(R.id.pb_play_bar)
    ProgressBar pbPlayBar;
    @BindView(R.id.fl_play_bar)
    FrameLayout flPlayBar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private FragmentAdapter fragmentAdapter;
    public static boolean isPlayFragmentShow = false;
    private PlayFragment mPlayFragment;
    public static SongBean needToPlay;
    private View vNavigationHeader;


    private MusicPlayListner listner = new MusicPlayListner.Stub() {
        @Override
        public void action(int actioncode, Message message, SongBean songBean) throws RemoteException {
            mHandler.sendMessage(message);
            needToPlay = songBean;
        }
    };


    private IMusicPlayer mMusicService = MyApplication.myApplication.getMusicPlayerService();
    /**
     * 处理远程Service的回调
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MusicService.MUSIC_ACTION_PLAY:
                    LogUtil.doLog("handleMessage", "Action_play");
                    ivPlayBarPlay.setSelected(true);
                    setTheCurrentMusicState(needToPlay);
                    break;
                case MusicService.MUSIC_ACTION_COMPLETE:
                    LogUtil.doLog("handleMessage", "COMPLETE");
                    ivPlayBarPlay.setSelected(false);
                    break;
                case MusicService.MUSIC_ACTION_PAUSE:
                    LogUtil.doLog("handleMessage", "Aciton_pause");
                    ivPlayBarPlay.setSelected(false);
                    break;
                case MusicService.MUSIC_ACTION_CONTINUE_PLAY:
                    LogUtil.doLog("handleMessage", "Action_Continute_Play");
                    ivPlayBarPlay.setSelected(true);
                    break;
                case MusicService.MUSIC_ACTION_ERROR:
                    ToastUtil.Toast("由于歌曲没有版权暂时无法播放");
                default:
                    super.handleMessage(msg);
            }

        }
    };

    public PermissionUtils.ComfirmListener comfirmListener = new PermissionUtils.ComfirmListener() {
        @Override
        public void granted(String prmission) {
            switch (prmission) {
                case Manifest.permission.WRITE_EXTERNAL_STORAGE:

                    ((LocalMusicFragment) fragmentAdapter.getItem(0)).updateMusicList(null);

            }
        }

        @Override
        public void denied(String prmission) {
            switch (prmission) {
                case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                    LogUtil.doLog("denied", "手机空间不足");

            }
        }
    };


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_music_acitivity;
    }

    @Override
    public void initData() {
        /**
         * 注册监听器
         */
        // add navigation header
        vNavigationHeader = LayoutInflater.from(this).inflate(R.layout.nav_header_music_acitivity, navView, false);
        navView.addHeaderView(vNavigationHeader);
        updateWeather();
        try {
            mMusicService.registListner(listner);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().register(this);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
        viewpager.addOnPageChangeListener(this);
        viewpager.setDrawingCacheEnabled(true);
        tvLocalMusic.setSelected(true);
        PermissionUtils.RequestReadAndWriteExt(this, comfirmListener);
        navView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music_acitivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawerLayout.closeDrawers();
        return NaviMenuExecutor.onNavigationItemSelected(item, this);
    }

    @OnClick({R.id.iv_menu, R.id.tv_local_music, R.id.tv_online_music, R.id.fl_play_bar, R.id.iv_search, R.id.iv_play_bar_play, R.id.iv_play_bar_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.tv_local_music:
                viewpager.setCurrentItem(0);
                break;
            case R.id.tv_online_music:
                viewpager.setCurrentItem(1);
                break;
            case R.id.fl_play_bar:
                if (mPlayFragment != null)
                    showPlayingFragment();
                break;
            case R.id.iv_search:
                startActivity(new Intent(MusicAcitivity.this, SearchMusicActivity.class));
                break;
            case R.id.iv_play_bar_play:
                if (ivPlayBarPlay.isSelected()) {
                    try {
                        mMusicService.action(MusicService.MUSIC_ACTION_PAUSE, new SongBean());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        mMusicService.action(MusicService.MUSIC_ACTION_CONTINUE_PLAY, new SongBean());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.iv_play_bar_next:
                if (mPlayFragment != null) {
                    mPlayFragment.toNext();
                }
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            tvLocalMusic.setSelected(true);
            tvOnlineMusic.setSelected(false);

        } else {
            tvLocalMusic.setSelected(false);
            tvOnlineMusic.setSelected(true);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void showPlayingFragment() {
        if (isPlayFragmentShow) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_up, 0);
        if (mPlayFragment == null) {
            mPlayFragment = new PlayFragment(null);
            ft.replace(android.R.id.content, mPlayFragment);
        } else {
            ft.show(mPlayFragment);
        }
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = true;
    }

    //设置加载完成后的图片
    private void showPlayingFragmentWithSongEvent(SongEvent songEvent, List<SongBean> songlist) {
        if (isPlayFragmentShow) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_up, 0);
        if (mPlayFragment == null) {
            mPlayFragment = new PlayFragment(songEvent);
            mPlayFragment.setSongList(songlist);
            ft.replace(android.R.id.content, mPlayFragment);
        } else {
            ft.show(mPlayFragment);
        }
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = true;
    }

    public void hidePlayingFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(0, R.anim.fragment_slide_down);
        ft.hide(mPlayFragment);
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = false;
    }

    //BUS的订阅事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnEvenMain(SongEvent songEvent) {

        //==null为本地音乐
        if (songEvent.getSongBean().getM4a() == null) {
            if (mPlayFragment == null) {
                showPlayingFragmentWithSongEvent(songEvent, ((LocalMusicFragment) fragmentAdapter.getItem(0)).getList());
                return;
            }
            mPlayFragment.activityCallPlayNext(songEvent.getSongBean());
        } else {
            if (mPlayFragment == null) {
                List<SongBean> list = ((LocalMusicFragment) fragmentAdapter.getItem(0)).getList();
                list.add(songEvent.getSongBean());
                showPlayingFragmentWithSongEvent(songEvent, list);
                return;
            } else {
                mPlayFragment.addNewNetWorkSong(songEvent.getSongBean());
            }
            Log.d(TAG, "OnEvenMain: " + songEvent.getSongBean());

        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        RetrofitUtil.cancelDisposable();
    }


    public void setTheCurrentMusicState(SongBean songBean) {
        if (songBean.getM4a() == null) {
            Bitmap cover = CoverLoader.getInstance().loadThumbnail(songBean);
            ivPlayBarCover.setImageBitmap(cover);
        } else {
            Glide.with(this).load(songBean.getAlbumpic_small()).error(R.drawable.default_cover).into(ivPlayBarCover);
        }
        tvPlayBarArtist.setText(songBean.getSingername());
        tvPlayBarTitle.setText(songBean.getSongname());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onBackPressed() {
        if (mPlayFragment.isCommentFragmentShow) {
            hideCommentFragment();
            mPlayFragment.isCommentFragmentShow=false;
        } else if (isPlayFragmentShow) {
            hidePlayingFragment();
        } else {
            super.onBackPressed();
        }
    }

    private void updateWeather() {

        PermissionUtils.ComfirmListener locationListener = new PermissionUtils.ComfirmListener() {
            @Override
            public void granted(String prmission) {
                switch (prmission) {
                    case Manifest.permission.ACCESS_FINE_LOCATION:

                        new WeatherExecutor(MusicAcitivity.this, vNavigationHeader);

                }
            }

            @Override
            public void denied(String prmission) {
                switch (prmission) {
                    case Manifest.permission.ACCESS_FINE_LOCATION:
                        LogUtil.doLog("denied", "无法定位");

                }
            }
        };
        PermissionUtils.RequsetLocationServer(this, locationListener);
    }

    public void hideCommentFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(0, R.anim.fragment_slide_down);
        ft.hide(mPlayFragment.commentFragment);
        ft.commitAllowingStateLoss();
    }

}
