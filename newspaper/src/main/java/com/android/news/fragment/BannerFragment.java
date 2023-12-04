package com.android.news.fragment;

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

import com.android.news.adapter.TextAdapter;
import com.android.news.data.ImageData;
import com.android.news.R;
import com.android.news.data.TextData;
import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.BaseIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public class BannerFragment extends Fragment {
    List<ImageData> mData = new ArrayList<>();
    com.youth.banner.Banner banner;
    RecyclerView recyclerView;
    ArrayList<TextData> textList = new ArrayList();

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
        TextAdapter adapter = new TextAdapter(getContext(), textList);
        super.onViewCreated(view, savedInstanceState);
        banner.setOnBannerListener((OnBannerListener<ImageData>) (data, position) ->    //点击事件
                Toast.makeText(getContext(), data.getTitle(), Toast.LENGTH_SHORT).show());
        recyclerView = view.findViewById(R.id.rv_text);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        upData();
        listData();
    }

    void upData() { //添加数据
        mData.add(new ImageData("https://p2.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231621558_134.jpg", getString(R.string.title1)));
        mData.add(new ImageData("https://p3.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231557997_300.jpg", getString(R.string.title2)));
        mData.add(new ImageData("https://p4.img.cctvpic.com/photoAlbum/page/performance/img/2023/11/29/1701231795090_280.jpg", getString(R.string.title3)));
        mData.add(new ImageData("https://p2.img.cctvpic.com/photoAlbum/page/performance/img/2023/12/3/1701578956024_629.jpg", getString(R.string.title4)));
    }

    void listData() {
        textList.add(new TextData("微软今天发布新闻稿，于今年 2 月推出 Copilot预览版以来，成为了很多人的日常 AI 伴侣，现在摘掉预览的帽子，正式上线。"));
        textList.add(new TextData("OpenAI 首席执行官山姆・阿尔特曼（Sam Altman）上月出席 DevDay 活动时，原计划12月推出称为“GPT Store”的在线平台，不过官方近日宣布推迟该商城平台上线计划。"));
        textList.add(new TextData("RTX4090显卡禁售，英伟达欲面向中国市场推出4090D，RTX4090D的性能可能略低于原版RTX4090，但它仍然是一款强大的显卡，适用于高级游戏、虚拟现实和创作等领域。"));
        textList.add(new TextData("微软官方近日更新了 Dev Home 应用的 GitHub 页面，希望在 Win11 设置应用中引入“高级 Windows 设置”选项，提供更丰富的控制选项，帮用户更好地掌控设备。"));
        textList.add(new TextData("ChatGPT发布一周年之际，人工智能革命才刚刚开始。在过去的一年里，它强大的功能改变了越来越多人的工作和生活方式，成为了世界上用户增长最快的应用程序。当然，其日益增长的影响力也引发了人们对人工智能在社会中的作用的质疑。 近期以来，OpenAI公司经历了戏剧性的内斗事件，幸运的是，奥特曼重新掌控了OpenAI，使这家初创公司免除了分崩离析的悲惨命运，并开启了艰难决策的新阶段。"));
    }
}