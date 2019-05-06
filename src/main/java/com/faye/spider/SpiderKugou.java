package com.faye.spider;

import net.sf.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Faye F F HE
 * @Date 2019/1/6 19:29
 *
 * 下载酷狗音乐top500歌曲
 */

public class SpiderKugou {

    public static String filePath = "C:\\Users\\xiaomi\\Music\\KuGou\\";

    public static String mp3 = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&callback=jQuery191027067069941080546_1546235744250&"
            + "hash=HASH&album_id=0&_=TIME";

    // 8888 - top500；31308 - 华语新歌榜
    public static String LINK = "https://www.kugou.com/yy/rank/home/PAGE-8888.html?from=rank";

    public static void main(String[] args) throws IOException {
        for(int i = 1 ; i < 23 ; i++){ //每页22首歌
            String url = LINK.replace("PAGE", i + "");
            getTitle(url);
        }
    }

    public static String getTitle(String url) throws IOException{
        HttpGetConnect connect = new HttpGetConnect();
        String content = connect.connect(url, "utf-8");
        HtmlManage html = new HtmlManage();
        Document doc = html.manage(content);
        Element ele = doc.getElementsByClass("pc_temp_songlist").get(0);
        Elements eles = ele.getElementsByTag("li");
        for(int i = 0 ; i < eles.size() ; i++){
            Element item = eles.get(i);
            String title = item.attr("title").trim();
            String link = item.getElementsByTag("a").first().attr("href");

            download(link, title);
        }
        return null;
    }

    public static String download(String url, String name) throws IOException{
        String hash = "";
        HttpGetConnect connect = new HttpGetConnect();
        String content = connect.connect(url, "utf-8");
        HtmlManage html = new HtmlManage();

        String regEx = "\"hash\":\"[0-9A-Z]+\"";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            hash = matcher.group();
            hash = hash.replace("\"hash\":\"", "");
            hash = hash.replace("\"", "");
        }

        String item = mp3.replace("HASH", hash);
        item = item.replace("TIME", System.currentTimeMillis() + "");

        System.out.println(item);
        String mp = connect.connect(item, "utf-8");

        mp = mp.substring(mp.indexOf("(") + 1, mp.length() - 3);

        JSONObject json = JSONObject.fromObject(mp);
        String playUrl = json.getJSONObject("data").getString("play_url");


        System.out.print(playUrl + "  ==  ");
        FileDownload down = new FileDownload();
        down.download(playUrl, filePath + name + ".mp3");

        System.out.println(name + "下载完成");
        return playUrl;
    }

}