package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Article;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.ArticleVO;
import com.zeyu.entity.vo.QuestionVo;

public interface ArticleService {
	//写文章
	public void write(Article artile);
	//获取所有文章，默认以时间排序
	public List<Article> getAllArticles(int page);
	//根据用户种类展示文章
	public List<Article> showArticlesByUserKind(int page);
	//搜索文章
	public List<Article> searchArticles(int page,String condition);
	//获取文章数量
	public int getArticleCount();
	
	public List<String> getAuToListArticles(String str);

	public void hits(Integer question_id);
	
	public int getQuestionCount();
	
	public String article_time(Integer article_id);
	
	public boolean updateAttentions(int article_id);
	
	public void askhits(hitsCollect hit);
	
	public boolean hitsCheck(int article_id,Integer user_id);
	
	public ArticleVO getArticleVoByArticleId(int article_id);
	
	public List<ArticleVO> getArticleByPage(int kind,int page);
	
	public List<ArticleVO> getFilterArticleByPage(int kind,int page,String filterContent);
	
	public int getFilterArticleCount(String content);
}

