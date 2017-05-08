package com.zeyu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.AnswerDao;
import com.zeyu.dao.QuestionDao;
import com.zeyu.dao.hitsCollectDao;
import com.zeyu.entity.Question;
import com.zeyu.entity.hitsCollect;
import com.zeyu.entity.vo.QuestionVo;
import com.zeyu.service.QuestionService;
import com.zeyu.util.TimeUtil;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Resource
	QuestionDao questionDao;

	@Resource
	AnswerDao answerDao;

	@Resource
	hitsCollectDao hitsCollectDao;
	
	
	@Override
	public void ask(Question question) {
		questionDao.add(question);
	}
	public void askhits(hitsCollect hit) {
		hitsCollectDao.add(hit);
	}

	@Override
	public List<QuestionVo> getAllQuestion() {
		List<Question> questions = new ArrayList<Question>();
		questions = questionDao.findAll();
		List<QuestionVo> questionvos = new ArrayList<QuestionVo>();
		if (questions != null) {
			for (int i = 0; i < questions.size(); i++) {
				Integer answer_number = answerDao.findBySearch("question_id=" + questions.get(i).getQuestion_id())
						.size();
				QuestionVo qvo = new QuestionVo();
				qvo.setQuestion(questions.get(i));
				qvo.setAnswer_number(answer_number);
				questionvos.add(qvo);
			}
		}
		return questionvos;
	}

	@Override
	public void hits(Integer question_id) {
		Question question = new Question();
		question = questionDao.findById(question_id);
		int hits;
		if (question.getHits() == null) {
			hits = 0;
		} else {
			hits = question.getHits();
		}
		question.setHits(hits + 1);
		questionDao.update(question);
	}

	@Override
	public String question_time(Integer question_id) {
		Date create_date = new Date();
		Date now_date = new Date();
		create_date = questionDao.findById(question_id).getCreate_time();
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
	public Question getQuestionById(int question_id) {
		return questionDao.findByProperty("model.question_id=" + question_id).get(0);
	}

	@Override
	public QuestionVo getQuestionVoByQuestionId(int question_id) {
		QuestionVo questionVo = new QuestionVo();
		questionVo.setAnswer_number(answerDao.findBySearch("question_id=" + question_id).size());
		Question q = getQuestionById(question_id);
		if(q!=null){
			questionVo.setQuestion(q);
			if (q.getQuestion_label() != null)
				questionVo.setLabels(Arrays.asList(q.getQuestion_label().split(",")));
		}
		return questionVo;
	}

	@Override
	public boolean updateAttentions(int question_id) {
		Question question = new Question();

		question = questionDao.findById(question_id);
		question.setAttentions((question.getAttentions() == null ? 0 : question.getAttentions() + 1));
		questionDao.update(question);
		return true;
	}

	@Override
	public int getQuestionCount() {
		return questionDao.findCount();
	}

	@Override
	public List<QuestionVo> getQuestionByPage(int kind, int page) {
		// 两种种类，1最热 2最新 page是传递进来的页数
		// 热门 按照点击量排序
		// 最新按照 提问时间 倒序
		List<Question> questions = new ArrayList<Question>();
		questions.clear();
		if (kind == 1) {
			questions = questionDao.findConditionByPage(page, "order by hits desc");
		} else if (kind == 2) {
			questions = questionDao.findConditionByPage(page, "order by create_time desc");
		}

		List<QuestionVo> questionvos = new ArrayList<QuestionVo>();
		if (questions != null) {
			for (int i = 0; i < questions.size(); i++) {
				Integer answer_number = answerDao.findBySearch("question_id=" + questions.get(i).getQuestion_id())
						.size();
				QuestionVo qvo = new QuestionVo();
				qvo.setQuestion(questions.get(i));
				qvo.setAnswer_number(answer_number);
				if (questions.get(i).getQuestion_label() != null)
					qvo.setLabels(Arrays.asList(questions.get(i).getQuestion_label().split(",")));
				questionvos.add(qvo);
			}
		}
		return questionvos;
	}

	@Override
	public List<QuestionVo> getFilterQuestionByPage(int kind, int page, String filterContent) {
		// 两种种类，1最热 2最新 page是传递进来的页数
		// 热门 按照点击量排序
		// 最新按照 提问时间 倒序
		
		List<Question> questions = new ArrayList<Question>();
		questions.clear();
		String[] s = filterContent.split(" ");
		String sql = " model.question_comment like '%" + s[0] + "%'";
		for (int i = 1; i < s.length; i++) {
			if (s[i].length() > 1) {
				sql += " or model.question_comment like '%" + s[i] + "%'";
			}
		}
		if (kind == 1) {
			questions = questionDao.findFilterConditionByPage(page, sql + "order by hits desc");
		} else if (kind == 2) {
			questions = questionDao.findFilterConditionByPage(page, sql + "order by create_time desc");
		}
		List<QuestionVo> questionvos = new ArrayList<QuestionVo>();
		if (questions != null) {
			for (int i = 0; i < questions.size(); i++) {
				Integer answer_number = answerDao.findBySearch("question_id=" + questions.get(i).getQuestion_id())
						.size();
				QuestionVo qvo = new QuestionVo();
				qvo.setQuestion(questions.get(i));
				qvo.setAnswer_number(answer_number);
				if (questions.get(i).getQuestion_label() != null)
					qvo.setLabels(Arrays.asList(questions.get(i).getQuestion_label().split(",")));
				questionvos.add(qvo);
			}
		}
		return questionvos;
	}

	@Override
	public List<QuestionVo> getSearchQuestionByPage(int kind, int page, String searchContent) {
		// 两种种类，1最热 2最新 page是传递进来的页数
		// 热门 按照点击量排序
		// 最新按照 提问时间 倒序
		List<Question> questions = new ArrayList<Question>();
		questions.clear();
		if (kind == 1) {
			questions = questionDao.findFilterConditionByPage(page,
					" model.question_comment ='" + searchContent + "'" + "order by hits desc");
			
		} else if (kind == 2) {
			questions = questionDao.findFilterConditionByPage(page,
					" model.question_comment ='" + searchContent+ "'" + "order by create_time asc" );
			
		}

		List<QuestionVo> questionvos = new ArrayList<QuestionVo>();
		if (questions != null) {
			for (int i = 0; i < questions.size(); i++) {
				Integer answer_number = answerDao.findBySearch("question_id=" + questions.get(i).getQuestion_id())
						.size();
				QuestionVo qvo = new QuestionVo();
				qvo.setQuestion(questions.get(i));
				qvo.setAnswer_number(answer_number);
				questionvos.add(qvo);
			}
		}
		return questionvos;
	}

	@Override
	public List<Question> getQuestionsByUserId(int user_id) {
		return questionDao.findByProperty("user_id='" + user_id + "'");
	}

	@Override
	public List<Question> getPageQuestionsByUserId(int user_id, int page) {
		return questionDao.findFilterConditionByPage(page, " model.user_id ='" + user_id + "'");
	}

	@Override
	public int getFilterQuestionCount(String filterContent) {
		String[] s = filterContent.split(" ");
		String sql = " model.question_comment like '%" + s[0] + "%'";
		for (int i = 1; i < s.length; i++) {
			if (s[i].length() > 1) {
				sql += " or model.question_comment like '%" + s[i] + "%'";
			}
		}
		int size = questionDao.getFilterQuestionCount(sql + "order by hits desc");
		return size;
	}

	@Override
	public List<String> getAuToList(String str) {
		List<String> list = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		questions = questionDao.findByProperty("model.question_comment like '%" + str + "%'");
		for (int i = 0; i < questions.size() && i < 5; i++) {
			list.add(questions.get(i).getQuestion_comment());
		}
		return list;
	}

	@Override
	public int getQuestionCountByUserId(int user_id) {
		return getQuestionsByUserId(user_id).size();
	}

	public boolean hitsCheck(int question_id , Integer coll_user_id) {
		// TODO Auto-generated method stub
		List<hitsCollect> questions; 
		questions= hitsCollectDao.findByProperty("model.coll_user_id ="+coll_user_id+"and model.coll_ques_id ="+question_id+" ");
		if(questions.size()==0){
			
			return true;
			
		}else{
			return false;
		}
	
	}
	@Override
	public boolean delete(String id) {
		
		try {
			questionDao.deleteByIds("data.question_id=" + id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	
	

}
