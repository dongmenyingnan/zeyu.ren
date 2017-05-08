package com.zeyu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.AnswerDao;
import com.zeyu.dao.QuestionDao;
import com.zeyu.dao.UserDao;
import com.zeyu.entity.Answer;
import com.zeyu.entity.User;
import com.zeyu.entity.vo.AnswerGather;
import com.zeyu.entity.vo.AnswerVo;
import com.zeyu.service.AnswerService;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	
	
	@Resource
	AnswerDao answerDao;
	@Resource
	QuestionDao questionDao;
	@Resource
	UserDao userDao;

	@Override
	public void reply(Answer answer) {
		answerDao.add(answer);
	}

	@Override
	public AnswerVo getAnswerVo(Integer question_id) {
		AnswerVo answerVo = new AnswerVo();
		answerVo.setQuestion(questionDao.findById(question_id));
		List<AnswerGather> answerGathers = new ArrayList<AnswerGather>();
		List<Answer> answers = new ArrayList<Answer>();
		
		answers = answerDao.findBySearch("question_id=" + question_id);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < answers.size(); i++) {
			Date create_date = new Date();
			String create_date1 = null;
			try {
				create_date = format.parse(answers.get(i).getCreate_time() + "");
				create_date1 = format.format(create_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			AnswerGather answerGather = new AnswerGather();
			User user = userDao.findById(answers.get(i).getUser_id());
			if(user!=null){
				answerGather.setUsername(user.getUser_name());
				answerGather.setUsertype(user.getUser_type());
				answerGather.setAnswer(answers.get(i));
				answerGather.setAnswer_time(create_date1);
				answerGathers.add(answerGather);
			}
		}
		answerVo.setAnswerGathers(answerGathers);
		String user_name = userDao.findById(questionDao.findById(question_id).getUser_id()).getUser_name();
		if (user_name != null)
			answerVo.setUser_name(user_name);
		return answerVo;
	}

	@Override
	public int getAnswerCount() {
		return answerDao.findCount();
	}

	@Override
	public List<Answer> getAnswersByUserId(int user_id) {
		return answerDao.findByProperty("user_id='" + user_id + "'");
	}

	public List<Answer> getPageAnswersByUserId(int user_id, int page) {
		return answerDao.findFilterConditionByPage(page, " model.user_id ='" + user_id + "'");
	}

	@Override
	public Integer getAnswerCountByUserId(int user_id) {
		return getAnswersByUserId(user_id).size();
	}

	@Override
	public Answer getAnswerByID(Integer answer_id) {
		return answerDao.findById(answer_id);
	}

	@Override
	public void updateAnswer(Answer answer) {
		answerDao.update(answer);
	}

}
