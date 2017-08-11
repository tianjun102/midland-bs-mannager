package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Area;
import com.midland.web.model.Banner;
import com.midland.web.model.LinkUrlManager;
import com.midland.web.model.Popular;

import java.util.List;
import java.util.Map;

public interface SettingService {

    /**
     * 热门关注
     * @param popular
     * @param pageBounds
     * @return
     */
    public PageList<Popular> findPopularList(Popular popular , PageBounds pageBounds);

    public Popular findPopular(Popular popular);

    public int updatePopular(Popular popular);

    public int insertPopular(Popular popular);

    public Map<String, List<Area>> queryCityByRedis(Map<String,String> parem);

    public Map<String, List<Area>> queryAreaByRedis(Map<String,String> parem);

    /**
     * 友情链接
     * @param linkUrlManager
     * @param pageBounds
     * @return
     */

    public PageList<LinkUrlManager> findLinkUrlList(LinkUrlManager linkUrlManager , PageBounds pageBounds);

    public LinkUrlManager findLinkUrlManager(LinkUrlManager linkUrlManager);

    public int updateLinkUrlManager(LinkUrlManager linkUrlManager);

    public int insertLinkUrlManage(LinkUrlManager linkUrlManager);


    /**
     * Banner管理
     */

    public PageList<Banner> findBannerList(Banner banner , PageBounds pageBounds);

    public Banner findBanner(Banner banner);

    public int updateBanner(Banner banner);

    public int insertBanner(Banner banner);


}
