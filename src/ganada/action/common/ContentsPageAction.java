package ganada.action.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ganada.obj.*;
import ganada.obj.common.BannerHTML;
import ganada.obj.common.BannerHTMLDao;
import ganada.obj.common.ContentsPage;
import ganada.obj.common.ContentsPageDao;

public class ContentsPageAction extends HaveSubAction {
    private static ContentsPage page;
    private static List<BannerHTML> banners;
    
    private static ContentsPageDao pageDao;
    private static BannerHTMLDao bannerDao;
    
    private static String innerHTML = "";

    public void init(String pageCode) throws Exception {
        pageDao = ContentsPageDao.getInstance();
        bannerDao = BannerHTMLDao.getInstance();

        page = pageDao.getPage(pageCode);
        banners = new ArrayList<BannerHTML>();
        
        for (int key : page.bannerMap().keySet()) {
            String code = page.bannerMap().get(key);
            BannerHTML curBanner;
            curBanner = bannerDao.getBanner(code);
            banners.add(curBanner);
        }
        
        for (BannerHTML cur : banners) {
            innerHTML += cur.getHtml();
        }
    }
    
    public String exe(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String code = (String) request.getParameter("code");
            if (page == null) init(code);            

            HttpSession session = request.getSession();
            session.setAttribute("pageTitle", page.getName());
            session.setAttribute("menu", "0");
            session.setAttribute("innerHTML", innerHTML);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/jsp/template/page.jsp";
    }

}