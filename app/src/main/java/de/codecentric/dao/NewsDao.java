package de.codecentric.dao;

import de.codecentric.domain.News;

import java.util.List;

public interface NewsDao {

    List<News> getAllNews();

    void saveNews(News n);
}
