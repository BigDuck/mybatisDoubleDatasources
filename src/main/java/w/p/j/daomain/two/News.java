package w.p.j.daomain.two;

import javax.persistence.*;

public class News {
    @Id
    @Column(name = "news_id")
    private Integer newsId;

    @Column(name = "news_title")
    private String newsTitle;

    @Column(name = "news_con")
    private String newsCon;

    /**
     * @return news_id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * @param newsId
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * @return news_title
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * @param newsTitle
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * @return news_con
     */
    public String getNewsCon() {
        return newsCon;
    }

    /**
     * @param newsCon
     */
    public void setNewsCon(String newsCon) {
        this.newsCon = newsCon;
    }

    public News(Integer newsId, String newsTitle, String newsCon) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsCon = newsCon;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsCon='" + newsCon + '\'' +
                '}';
    }
}