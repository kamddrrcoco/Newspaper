package com.android.newspaper.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.newspaper.adapter.TextAdapter;
import com.android.newspaper.data.ImageData;
import com.android.newspaper.R;
import com.android.newspaper.data.TextData;
import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.BaseIndicator;
import com.youth.banner.listener.OnBannerListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class BannerFragment extends Fragment {
    List<ImageData> mData = new ArrayList<>();
    com.youth.banner.Banner banner;
    RecyclerView recyclerView;
    ArrayList<TextData> textList = new ArrayList();
    private final LinearLayoutManager layoutInflater = new LinearLayoutManager(this.getContext());
    private TextAdapter adapter = new TextAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banner, container, false);
        banner = view.findViewById(R.id.banner_view);
        banner.setAdapter(new BannerImageAdapter<ImageData>(mData) {    //设置轮播图片来源
                    @Override
                    public void onBindView(BannerImageHolder holder, ImageData data, int position, int size) {
                        Glide.with(holder.imageView)
                                .load(data.getImage())
                                .into(holder.imageView);
                    }
                }).addBannerLifecycleObserver(this)
                .setIndicator(new BaseIndicator(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        banner.setOnBannerListener((OnBannerListener<ImageData>) (data, position) ->    //点击事件
                Toast.makeText(getContext(), data.getTitle(), Toast.LENGTH_SHORT).show());
        recyclerView = view.findViewById(R.id.rv_text);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(this.layoutInflater);
        upData();
        listData();
    }

    void upData() { //添加数据
        mData.add(new ImageData("https://p2.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231621558_134.jpg", getString(R.string.title1)));
        mData.add(new ImageData("https://p3.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231557997_300.jpg", getString(R.string.title2)));
        mData.add(new ImageData("https://p4.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231795090_280.jpg", getString(R.string.title3)));
    }

    void listData() {
        textList.add(new TextData("标题1"));
        textList.add(new TextData("标题2"));
        textList.add(new TextData("标题3"));
    }
}