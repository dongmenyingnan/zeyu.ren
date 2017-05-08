package com.zeyu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.ManualArticleDao;
import com.zeyu.dao.ManualDao;
import com.zeyu.entity.Answer;
import com.zeyu.entity.Manual;
import com.zeyu.entity.ManualArticle;
import com.zeyu.service.ManualService;
import com.zeyu.util.TimeUtil;
@Service("manualService")
public class ManualServiceImpl  implements ManualService{

	@Resource
	ManualDao manualDao;
	
	@Resource
	ManualArticleDao manualArticleDao;
	
	@Override
	public List<Manual> getcateSeach(int flag,int page) {
		
		return manualDao.findByIntSearch(flag,page);
	}

	@Override
	public ManualArticle findByIdArtcle(int manual_id) {
		// TODO Auto-generated method stub
		return manualArticleDao.findByIntSearch2(manual_id);
	}

	@Override
	public String ManualArticle_time(int timer) {
		Date create_date = new Date();
		Date now_date = new Date();
		create_date = manualArticleDao.findByIntSearch2(timer).getMaualartcle_time();
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
	public boolean delete(String id) {
		try {
			manualDao.deleteByIds("data.manual_id=" + id);
			manualArticleDao.deleteByIds("data.uuid=" + id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void add(Manual manual) {
		manualDao.add(manual);
	}
	public void adddata(ManualArticle manualArticle) {
		manualArticleDao.add(manualArticle);
	}

	@Override
	public void updata(ManualArticle manualArticle) {
		manualArticleDao.update(manualArticle);
		
	}
	public List<Manual> getManualByUserId(int id) {
		return manualDao.findByProperty("manual_type='" + id + "'");
	}

	@Override
	public int getManualCountByUserId(int id) {
		// TODO Auto-generated method stub
		return getManualByUserId(id).size();
	}
	
	

}
