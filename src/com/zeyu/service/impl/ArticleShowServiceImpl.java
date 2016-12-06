package com.zeyu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ArticleDao;
import com.zeyu.dao.ArticleShowDao;
import com.zeyu.dao.UserDao;
import com.zeyu.entity.Answer;
import com.zeyu.entity.ArticleShow;
import com.zeyu.entity.User;
import com.zeyu.entity.vo.AnswerVo;
import com.zeyu.entity.vo.ArticleShowGather;
import com.zeyu.entity.vo.ArticleShowVo;
import com.zeyu.service.ArticleShowService;
@Service("articleShowService")
public class ArticleShowServiceImpl implements ArticleShowService{
	@Resource
	ArticleShowDao articleshowDao;
	@Resource
	ArticleDao articleDao;
	@Resource
	UserDao userDao;

	
	
	public ArticleShowVo getArticleShowVo(Integer article_id) {
		ArticleShowVo articleshowVo = new ArticleShowVo();
		articleshowVo.setArticle(articleDao.findById(article_id));
		List<ArticleShowGather> articleshowGathers = new ArrayList<ArticleShowGather>();
		List<ArticleShow> articles = new ArrayList<ArticleShow>();
		
		articles = articleshowDao.findBySearch1("article_id=" + article_id);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < articles.size(); i++) {
			Date create_date = new Date();
			try {
				create_date = format.parse(articles.get(i).getCreate_time() + "");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ArticleShowGather articleshowGather = new ArticleShowGather();
			User user = userDao.findById(articles.get(i).getUser_id());
			if(user!=null){
				articleshowGather.setUsername(user.getUser_name());
				articleshowGather.setUsertype(user.getUser_type());
				articleshowGather.setArticleshow(articles.get(i));
				articleshowGather.setArticle_time(create_date);
				articleshowGathers.add(articleshowGather);
			}
		}
		articleshowVo.setArticleshowGathers(articleshowGathers);
		String user_name = userDao.findById(articleDao.findById(article_id).getArticle_user_id()).getUser_name();
		if (user_name != null)
			articleshowVo.setUser_name(user_name);
		return articleshowVo;
	}



	@Override
	public 	void reply(ArticleShow articleShow) {
		articleshowDao.add(articleShow);
	}



	@Override
	public ArticleShow getArticleShowByID(Integer article_id) {
		// TODO Auto-generated method stub
		return articleshowDao.findById(article_id);
	}

	






	

}
