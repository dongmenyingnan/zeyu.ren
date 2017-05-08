package com.zeyu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ExceptionArticleDao;
import com.zeyu.dao.ExceptionDao;
import com.zeyu.entity.Exception;
import com.zeyu.entity.ExceptionArticle;
import com.zeyu.entity.Manual;
import com.zeyu.service.ExceptionArticleService;
import com.zeyu.util.TimeUtil;
@Service("exceptionArticleService")
public class ExceptionArticleServiceImpl implements ExceptionArticleService{

	@Resource
	ExceptionArticleDao exceptionArticleDao;
	@Resource
	ExceptionDao exceptionDao;
	
	public List<Exception> getcateSeach(int flag) {
		
		return exceptionDao.findByIntSearchException(flag);
	}

	@Override
	public ExceptionArticle findByIdArtcle(int exception_id) {
		// TODO Auto-generated method stub
		return exceptionArticleDao.findByIntSearch1Exception(exception_id);
	}

	@Override
	public String ExceptionArticle_time(int timer) {
		Date create_date = new Date();
		Date now_date = new Date();
		create_date = exceptionArticleDao.findById(timer).getExceptionarticle_time();
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
	public List<Exception> getcateSeach(int flag, int page) {
		// TODO Auto-generated method stub
		return exceptionDao.findByIntSearchExcep(flag, page);
	}

	@Override
	public boolean delete(String id) {

			try {
				exceptionDao.deleteByIds("data.exception_id=" + id);
				exceptionArticleDao.deleteByIds("data.uuid=" + id);
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		
	}

	@Override
	public void adddata(ExceptionArticle exceptionArticle) {
		exceptionArticleDao.add(exceptionArticle);
		
	}

	@Override
	public void add(Exception exception) {
		exceptionDao.add(exception);
		
	}
	public List<Exception> getExceptionByUserId(int id) {
		return exceptionDao.findByProperty("exception_type='" + id + "'");
	}

	public int getExceptionCountByUserId(int i) {
		// TODO Auto-generated method stub
		return getExceptionByUserId(i).size();
	}	

}
