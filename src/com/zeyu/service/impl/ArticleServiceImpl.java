package com.zeyu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ArticleDao;
import com.zeyu.dao.ArticleShowDao;
import com.zeyu.dao.UserDao;
import com.zeyu.dao.hitsCollectDao;
import com.zeyu.entity.Article;
import com.zeyu.entity.Question;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.ArticleVO;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.ArticleService;
import com.zeyu.util.TimeUtil;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleDao articleDao;

	@Resource
	UserDao userDao;
	
	@Resource
	hitsCollectDao hitscollectDao;
	@Resource
	ArticleShowDao articleShowDao;
	
	@Override
	public void write(Article article) {
		articleDao.add(article);
	}

	@Override
	public List<Article> getAllArticles(int page) {
		return articleDao.findConditionByPage(page, "order by article_time desc");
	}

	@Override
	public List<Article> showArticlesByUserKind(int page) {
		return articleDao.findConditionByPage(page, "order by article_user_kind");
	}

	@Override
	public List<Article> searchArticles(int page, String condition) {
		return articleDao.findFilterConditionByPage(page," model.article_name like"+ "'%"+condition+"%'");
	}

	@Override
	public int getArticleCount() {
		return articleDao.findCount();
	}

	@Override
	public List<String> getAuToListArticles(String str) {
		List<String> list = new ArrayList<>();
		List<Article> articles = new ArrayList<>();
		articles = articleDao.findByProperty("model.article_name like '%" + str + "%'");
		for (int i = 0; i < articles.size() && i < 5; i++) {
			list.add(articles.get(i).getArticle_name());
		}
		return list;
	}
	public void hits(Integer question_id) {
		Article article = new Article();
		article = articleDao.findById(question_id);
		int hits;
		if (article.getHits() == null) {
			hits = 0;
		} else {
			hits = article.getHits();
		}
		article.setHits(hits + 1);
		articleDao.update(article);
	}
	public int getQuestionCount() {
		return articleDao.findCount();
	}

	@Override
	public String article_time(Integer article_id) {
		Date create_date = new Date();
		Date now_date = new Date();
		create_date = articleDao.findById(article_id).getArticle_time();
		long minutes = TimeUtil.translateMinutes(create_date, now_date);
		long hours = TimeUtil.translateHours(create_date, now_date);
		long days = TimeUtil.translateDays(create_date, now_date);
		long months = TimeUtil.translateMonths(create_date, now_date);
		long years = TimeUtil.translateYears(create_date, now_date);
		if (minutes > 60) {
			if (hours > 24) {
				if (days > 31) {
					if (months > 12) {
						return years + "年前";
					}
					return months + "月前";
				}
				return days + "天前";
			}
			return hours + "月前";
		}
		return minutes + "分钟前";
	}

	@Override
	public boolean updateAttentions(int article_id) {
		Article article = new Article();
		article = articleDao.findById(article_id);
		article.setAttentions((article.getAttentions() == null ? 0 : article.getAttentions() + 1));
		articleDao.update(article);
		return true;
	}
	public boolean hitsCheck(int article_id , Integer coll_user_id) {
		// TODO Auto-generated method stub
		List<hitsCollect> questions; 
		questions= hitscollectDao.findByProperty("model.coll_user_id ="+coll_user_id+"and model.coll_arts_id ="+article_id+" ");
		if(questions.size()==0){
			
			return true;
			
		}else{
			return false;
		}
	
	}
	public void askhits(hitsCollect hit) {
		hitscollectDao.add(hit);
	}
	public Article getArticleById(int article_id) {
		return articleDao.findByProperty("model.article_id=" + article_id).get(0);
	}
	public ArticleVO getArticleVoByArticleId(int article_id) {
		ArticleVO ArticleVo = new ArticleVO();
		ArticleVo.setArticle_number(articleShowDao.findBySearch1("article_id=" + article_id).size());
		Article q = getArticleById(article_id);
		if(q!=null){
			ArticleVo.setArticle(q);
			if (q.getArticle_tag() != null)
				ArticleVo.setLabels(Arrays.asList(q.getArticle_tag().split(",")));
		}
		return ArticleVo;
	}

	@Override
	public List<ArticleVO> getArticleByPage(int kind, int page) {
		// TODO Auto-generated method stub
		List<Article> article = new ArrayList<Article>();
		article.clear();
		if (kind == 1) {
			article = articleDao.findConditionByPage(page, "order by hits desc");
		} else if (kind == 2) {
			article = articleDao.findConditionByPage(page, "order by article_time desc");
		}

		List<ArticleVO> articlevos = new ArrayList<ArticleVO>();
		if (article != null) {
			for (int i = 0; i < article.size(); i++) {
				Integer article_number = articleShowDao.findBySearch1("article_id=" + article.get(i).getArticle_id())
						.size();
				ArticleVO qvo = new ArticleVO();
				qvo.setArticle(article.get(i));
				qvo.setArticle_number(article_number);
				if (article.get(i).getArticle_tag() != null)
					qvo.setLabels(Arrays.asList(article.get(i).getArticle_tag().split(",")));
				articlevos.add(qvo);
			}
		}
		return articlevos;
	}

	@Override
	public List<ArticleVO> getFilterArticleByPage(int kind, int page, String filterContent) {
		// 两种种类，1最热 2最新 page是传递进来的页数
		// 热门 按照点击量排序
		// 最新按照 提问时间 倒序
		
		List<Article> articles = new ArrayList<Article>();
		articles.clear();
		String[] s = filterContent.split(" ");
		String sql = " model.article_name like '%" + s[0] + "%'";
		for (int i = 1; i < s.length; i++) {
			if (s[i].length() > 1) {
				sql += " or model.article_name like '%" + s[i] + "%'";
			}
		}
		if (kind == 1) {
			articles = articleDao.findFilterConditionByPage(page, sql + "order by hits desc");
		} else if (kind == 2) {
			articles = articleDao.findFilterConditionByPage(page, sql + "order by article_time desc");
		}
		List<ArticleVO> articlevos = new ArrayList<ArticleVO>();
		if (articles != null) {
			for (int i = 0; i < articles.size(); i++) {
				Integer answer_number = articleShowDao.findBySearch1("article_id=" + articles.get(i).getArticle_id())
						.size();
				ArticleVO qvo = new ArticleVO();
				qvo.setArticle(articles.get(i)); 
				qvo.setArticle_number(answer_number);
				if (articles.get(i).getArticle_tag() != null)
					qvo.setLabels(Arrays.asList(articles.get(i).getArticle_tag().split(",")));
				articlevos.add(qvo);
			}
		}
		return articlevos;
	}

	@Override
	public int getFilterArticleCount(String content) {
		String[] s = content.split(" ");
		String sql = " model.article_name like '%" + s[0] + "%'";
		for (int i = 1; i < s.length; i++) {
			if (s[i].length() > 1) {
				sql += " or model.article_name like '%" + s[i] + "%'";
			}
		}
		int size = articleDao.getFilterQuestionCount(sql + "order by hits desc");
		return size;
	}
}
