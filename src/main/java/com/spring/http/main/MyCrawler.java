package com.spring.http.main;

import com.spring.http.*;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;
import java.util.Set;

// https://blog.csdn.net/qq_29726869/article/details/79908520
public class MyCrawler {
    /**
     *      * 使用种子初始化 URL 队列
     *      *
     *      * @param seeds 种子 URL
     *      * @return
     *      
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }

    /**
     *      * 抓取过程
     *      *
     *      * @param seeds
     *      * @return
     *      
     */
    public void crawling(String[] seeds) throws FileNotFoundException {
        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018"))
                    return true;
                else
                    return false;
            }
        };

        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty() && Links.getVisitedUrlNum() <= 1000) {
            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null) {
                continue;
            }

            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);
            //对page进行处理： 访问DOM的某个标签

            String dirPath = Class.class.getClass().getResource("/").getPath() + "data";
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            String filePath = dirPath + File.separator+ "data.csv" ;

            File file = new File(filePath);
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath)));
            Elements es = PageParserTool.select(page, "a");
            if (!es.isEmpty()) {

                List<String> lists = es.eachAttr("href");
                List<String> texts = es.eachText();
                for (int i = 0; i < lists.size(); i++) {
                    System.out.println(lists.get(i) + ": " + texts.get(i));

                }
                System.out.println("下面将打印所有a标签： ");
                System.out.println(es);
            }
            //将保存文件
            //FileTool.saveToLocal(page);

            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);

            //得到超链接
            Set<String> links = PageParserTool.getLinks(page, "a");
            for (String link : links) {
                if (link.contains(seeds[0]) )
                    Links.addUnvisitedUrlQueue(link);
                    System.out.println("新增爬取路径: " + link);
            }

        }
    }


    //main 方法入口
    public static void main(String[] args) throws FileNotFoundException {
        MyCrawler crawler = new MyCrawler();
        crawler.crawling(new String[]{"http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/"});
    }

}
