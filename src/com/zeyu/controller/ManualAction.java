package com.zeyu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeyu.entity.Manual;
import com.zeyu.entity.ManualArticle;
import com.zeyu.entity.Page;
import com.zeyu.entity.RequestFlag;
import com.zeyu.entity.User;
import com.zeyu.service.ManualService;

@Controller
public class ManualAction {
	
	@Autowired
	ManualService manualService;
	
	@RequestMapping(value="/display.action")
	public String display(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session,Integer flag,Integer page){
		
	 
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{
			if(flag==null){
				
			
		if(page==null){
				page=1;
			}
	
	//1	
		List<Manual> list= new ArrayList<Manual>();
			
			list=manualService.getcateSeach(1,page);
			model.addAttribute("background", list.get(0).getManual_backgroundimg());
			model.addAttribute("cate", list.get(0).getManual_lab());
			
			model.addAttribute("list", list);
			
			
			List<Page> pagesMyAnsQuestion = new ArrayList<>();
			int size = manualService.getManualCountByUserId(1);

			int maxPage = (int) Math.ceil(1.0 * size / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage) {
				page = maxPage;
			}

			pagesMyAnsQuestion = getPages(page, maxPage, 1);
			model.addAttribute("Pages1", pagesMyAnsQuestion);
			
	//2		

			List<Manual> list1= new ArrayList<Manual>();
			
			list1=manualService.getcateSeach(2,page);
			
			model.addAttribute("list1", list1);
		
			
			model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
		
			model.addAttribute("cate1", list1.get(0).getManual_lab());
			
			
			
			List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
			int size1 = manualService.getManualCountByUserId(2);

			int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage1) {
				page = maxPage1;
			}

			pagesMyAnsQuestion1 = getPages(page, maxPage1, 2);
			model.addAttribute("Pages2", pagesMyAnsQuestion1);
	//3		
			List<Manual> list2= new ArrayList<Manual>();
			
			list2=manualService.getcateSeach(3,page);
			
			model.addAttribute("list2", list2);
		
			
			model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
		
			model.addAttribute("cate2", list2.get(0).getManual_lab());
			
			
			
			List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
			int size2 = manualService.getManualCountByUserId(3);

			int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage2) {
				page = maxPage2;
			}

			pagesMyAnsQuestion2 = getPages(page, maxPage2, 3);
			model.addAttribute("Pages3", pagesMyAnsQuestion2);
	//4
			List<Manual> list3= new ArrayList<Manual>();
			
			list3=manualService.getcateSeach(4,page);
			
			model.addAttribute("list3", list3);
		
			
			model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
		
			model.addAttribute("cate3", list3.get(0).getManual_lab());
			
			
			
			List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
			int size3 = manualService.getManualCountByUserId(4);

			int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage3) {
				page = maxPage3;
			}

			pagesMyAnsQuestion3 = getPages(page, maxPage3, 4);
			model.addAttribute("Pages4", pagesMyAnsQuestion3);
		//5	
			List<Manual> list4= new ArrayList<Manual>();
			
			list4=manualService.getcateSeach(5,page);
			
			model.addAttribute("list4", list4);
		
			
			model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
		
			model.addAttribute("cate4", list4.get(0).getManual_lab());
			
			
			
			List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
			int size4 = manualService.getManualCountByUserId(5);

			int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage4) {
				page = maxPage4;
			}

			pagesMyAnsQuestion4 = getPages(page, maxPage4,5);
			model.addAttribute("Pages5", pagesMyAnsQuestion4);
		//6
			List<Manual> list5= new ArrayList<Manual>();
			
			list5=manualService.getcateSeach(6,page);
			
			model.addAttribute("list5", list5);
		
			
			model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
		
			model.addAttribute("cate5", list5.get(0).getManual_lab());
			
			
			
			List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
			int size5 = manualService.getManualCountByUserId(5);

			int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
			if (page == null || page < 1) {
				page = 1;
			} else if (page >= maxPage5) {
				page = maxPage5;
			}

			pagesMyAnsQuestion5 = getPages(page, maxPage5,6);
			model.addAttribute("Pages6", pagesMyAnsQuestion5);
			
			RequestFlag requestFlag = new RequestFlag();
			requestFlag.setMostNew("");
			requestFlag.setMostHot("class=\"active\"");
			requestFlag.setActiveHot("active");
			requestFlag.setActiveNew("");
			requestFlag.setActiveMyAnswer("");
			requestFlag.setActiveMyQuestion("");
		
			model.addAttribute("requestFlag1", requestFlag);
			
		
			}
			
			
			
			
			else if(flag==1){
				List<Manual> list= new ArrayList<Manual>();
				
				list=manualService.getcateSeach(1,page);
				model.addAttribute("background", list.get(0).getManual_backgroundimg());
				model.addAttribute("cate", list.get(0).getManual_lab());
				
				model.addAttribute("list", list);
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag1", requestFlag);
				
				List<Page> pagesMyAnsQuestion = new ArrayList<>();
				int size = manualService.getManualCountByUserId(1);

				int maxPage = (int) Math.ceil(1.0 * size / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage) {
					page = maxPage;
				}

				pagesMyAnsQuestion = getPages(page, maxPage, 1);
				model.addAttribute("Pages1", pagesMyAnsQuestion);
				
				
				
				
				
				
				//2		

						List<Manual> list1= new ArrayList<Manual>();
						
						list1=manualService.getcateSeach(2,1);
						
						model.addAttribute("list1", list1);
					
						
						model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
					
						model.addAttribute("cate1", list1.get(0).getManual_lab());
						
						
						
						List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
						int size1 = manualService.getManualCountByUserId(2);

						int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
					
						pagesMyAnsQuestion1 = getPages(1, maxPage1, 2);
						model.addAttribute("Pages2", pagesMyAnsQuestion1);
				//3		
						List<Manual> list2= new ArrayList<Manual>();
						
						list2=manualService.getcateSeach(3,1);
						
						model.addAttribute("list2", list2);
					
						
						model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
					
						model.addAttribute("cate2", list2.get(0).getManual_lab());
						
						
						
						List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
						int size2 = manualService.getManualCountByUserId(3);

						int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
				

						pagesMyAnsQuestion2 = getPages(1, maxPage2, 3);
						model.addAttribute("Pages3", pagesMyAnsQuestion2);
				//4
						List<Manual> list3= new ArrayList<Manual>();
						
						list3=manualService.getcateSeach(4,1);
						
						model.addAttribute("list3", list3);
					
						
						model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
					
						model.addAttribute("cate3", list3.get(0).getManual_lab());
						
						
						
						List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
						int size3 = manualService.getManualCountByUserId(4);

						int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
					

						pagesMyAnsQuestion3 = getPages(1, maxPage3, 4);
						model.addAttribute("Pages4", pagesMyAnsQuestion3);
					//5	
						List<Manual> list4= new ArrayList<Manual>();
						
						list4=manualService.getcateSeach(5,1);
						
						model.addAttribute("list4", list4);
					
						
						model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
					
						model.addAttribute("cate4", list4.get(0).getManual_lab());
						
						
						
						List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
						int size4 = manualService.getManualCountByUserId(5);

						int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
					

						pagesMyAnsQuestion4 = getPages(1, maxPage4,5);
						model.addAttribute("Pages5", pagesMyAnsQuestion4);
					//6
						List<Manual> list5= new ArrayList<Manual>();
						
						list5=manualService.getcateSeach(6,1);
						
						model.addAttribute("list5", list5);
					
						
						model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
					
						model.addAttribute("cate5", list5.get(0).getManual_lab());
						
						
						
						List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
						int size5 = manualService.getManualCountByUserId(5);

						int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
					

						pagesMyAnsQuestion5 = getPages(1, maxPage5,6);
						model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				
				
				
				

				
			}else if(flag==2){
				List<Manual> list1= new ArrayList<Manual>();
				
				list1=manualService.getcateSeach(2,page);
				
				model.addAttribute("list1", list1);
			
				
				model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate1", list1.get(0).getManual_lab());
				
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag2", requestFlag);
				
				
				List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
				int size1 = manualService.getManualCountByUserId(2);

				int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage1) {
					page = maxPage1;
				}

				pagesMyAnsQuestion1 = getPages(page, maxPage1, 2);
				model.addAttribute("Pages2", pagesMyAnsQuestion1);
				
				
				
				//1	
				List<Manual> list= new ArrayList<Manual>();
					
					list=manualService.getcateSeach(1,1);
					model.addAttribute("background", list.get(0).getManual_backgroundimg());
					model.addAttribute("cate", list.get(0).getManual_lab());
					
					model.addAttribute("list", list);
					
					
					List<Page> pagesMyAnsQuestion = new ArrayList<>();
					int size = manualService.getManualCountByUserId(1);

					int maxPage = (int) Math.ceil(1.0 * size / 5);
				

					pagesMyAnsQuestion = getPages(1, maxPage, 1);
					model.addAttribute("Pages1", pagesMyAnsQuestion);
				
				
				//3		
				List<Manual> list2= new ArrayList<Manual>();
				
				list2=manualService.getcateSeach(3,1);
				
				model.addAttribute("list2", list2);
			
				
				model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate2", list2.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
				int size2 = manualService.getManualCountByUserId(3);

				int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
			

				pagesMyAnsQuestion2 = getPages(1, maxPage2, 3);
				model.addAttribute("Pages3", pagesMyAnsQuestion2);
		//4
				List<Manual> list3= new ArrayList<Manual>();
				
				list3=manualService.getcateSeach(4,1);
				
				model.addAttribute("list3", list3);
			
				
				model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate3", list3.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
				int size3 = manualService.getManualCountByUserId(4);

				int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
			

				pagesMyAnsQuestion3 = getPages(1, maxPage3, 4);
				model.addAttribute("Pages4", pagesMyAnsQuestion3);
			//5	
				List<Manual> list4= new ArrayList<Manual>();
				
				list4=manualService.getcateSeach(5,1);
				
				model.addAttribute("list4", list4);
			
				
				model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate4", list4.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
				int size4 = manualService.getManualCountByUserId(5);

				int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
			

				pagesMyAnsQuestion4 = getPages(1, maxPage4,5);
				model.addAttribute("Pages5", pagesMyAnsQuestion4);
				//6
				List<Manual> list5= new ArrayList<Manual>();
				
				list5=manualService.getcateSeach(6,1);
				
				model.addAttribute("list5", list5);
			
				
				model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate5", list5.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
				int size5 = manualService.getManualCountByUserId(5);

				int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
			

				pagesMyAnsQuestion5 = getPages(1, maxPage5,6);
				model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				
				
				
				
				
				

			}else if(flag==3){
				List<Manual> list2= new ArrayList<Manual>();
				
				list2=manualService.getcateSeach(3,page);
				
				model.addAttribute("list2", list2);
			
				
				model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate2", list2.get(0).getManual_lab());
				
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag3", requestFlag);
				
				
				List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
				int size2 = manualService.getManualCountByUserId(3);

				int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage2) {
					page = maxPage2;
				}

				pagesMyAnsQuestion2 = getPages(page, maxPage2, 3);
				model.addAttribute("Pages3", pagesMyAnsQuestion2);
				
				
				
				//1	
				List<Manual> list= new ArrayList<Manual>();
					
					list=manualService.getcateSeach(1,1);
					model.addAttribute("background", list.get(0).getManual_backgroundimg());
					model.addAttribute("cate", list.get(0).getManual_lab());
					
					model.addAttribute("list", list);
					
					
					List<Page> pagesMyAnsQuestion = new ArrayList<>();
					int size = manualService.getManualCountByUserId(1);

					int maxPage = (int) Math.ceil(1.0 * size / 5);
				

					pagesMyAnsQuestion = getPages(1, maxPage, 1);
					model.addAttribute("Pages1", pagesMyAnsQuestion);
					
					
					//2		

					List<Manual> list1= new ArrayList<Manual>();
					
					list1=manualService.getcateSeach(2,1);
					
					model.addAttribute("list1", list1);
				
					
					model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate1", list1.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
					int size1 = manualService.getManualCountByUserId(2);

					int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
				
					pagesMyAnsQuestion1 = getPages(1, maxPage1, 2);
					model.addAttribute("Pages2", pagesMyAnsQuestion1);
				
				
				//4
				List<Manual> list3= new ArrayList<Manual>();
				
				list3=manualService.getcateSeach(4,1);
				
				model.addAttribute("list3", list3);
			
				
				model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate3", list3.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
				int size3 = manualService.getManualCountByUserId(4);

				int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
			

				pagesMyAnsQuestion3 = getPages(1, maxPage3, 4);
				model.addAttribute("Pages4", pagesMyAnsQuestion3);
			//5	
				List<Manual> list4= new ArrayList<Manual>();
				
				list4=manualService.getcateSeach(5,1);
				
				model.addAttribute("list4", list4);
			
				
				model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate4", list4.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
				int size4 = manualService.getManualCountByUserId(5);

				int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
			

				pagesMyAnsQuestion4 = getPages(1, maxPage4,5);
				model.addAttribute("Pages5", pagesMyAnsQuestion4);
			//6
				List<Manual> list5= new ArrayList<Manual>();
				
				list5=manualService.getcateSeach(6,1);
				
				model.addAttribute("list5", list5);
			
				
				model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate5", list5.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
				int size5 = manualService.getManualCountByUserId(5);

				int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
			

				pagesMyAnsQuestion5 = getPages(1, maxPage5,6);
				model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				
				
				
				
				
				
				
				
				
				
				
				

			}else if(flag==4){
				List<Manual> list3= new ArrayList<Manual>();
				
				list3=manualService.getcateSeach(4,page);
				
				model.addAttribute("list3", list3);
			
				
				model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate3", list3.get(0).getManual_lab());
				
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag4", requestFlag);
				
				
				List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
				int size3 = manualService.getManualCountByUserId(4);

				int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage3) {
					page = maxPage3;
				}

				pagesMyAnsQuestion3 = getPages(page, maxPage3, 4);
				model.addAttribute("Pages4", pagesMyAnsQuestion3);
				
				
				//1	
				List<Manual> list= new ArrayList<Manual>();
					
					list=manualService.getcateSeach(1,1);
					model.addAttribute("background", list.get(0).getManual_backgroundimg());
					model.addAttribute("cate", list.get(0).getManual_lab());
					
					model.addAttribute("list", list);
					
					
					List<Page> pagesMyAnsQuestion = new ArrayList<>();
					int size = manualService.getManualCountByUserId(1);

					int maxPage = (int) Math.ceil(1.0 * size / 5);
				

					pagesMyAnsQuestion = getPages(1, maxPage, 1);
					model.addAttribute("Pages1", pagesMyAnsQuestion);
					
					
					//2		

					List<Manual> list1= new ArrayList<Manual>();
					
					list1=manualService.getcateSeach(2,1);
					
					model.addAttribute("list1", list1);
				
					
					model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate1", list1.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
					int size1 = manualService.getManualCountByUserId(2);

					int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
				
					pagesMyAnsQuestion1 = getPages(1, maxPage1, 2);
					model.addAttribute("Pages2", pagesMyAnsQuestion1);
					
					
					//3		
					List<Manual> list2= new ArrayList<Manual>();
					
					list2=manualService.getcateSeach(3,1);
					
					model.addAttribute("list2", list2);
				
					
					model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate2", list2.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
					int size2 = manualService.getManualCountByUserId(3);

					int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
				

					pagesMyAnsQuestion2 = getPages(1, maxPage2, 3);
					model.addAttribute("Pages3", pagesMyAnsQuestion2);
					
				
				
	//5	
				List<Manual> list4= new ArrayList<Manual>();
				
				list4=manualService.getcateSeach(5,1);
				
				model.addAttribute("list4", list4);
			
				
				model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate4", list4.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
				int size4 = manualService.getManualCountByUserId(5);

				int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
			

				pagesMyAnsQuestion4 = getPages(1, maxPage4,5);
				model.addAttribute("Pages5", pagesMyAnsQuestion4);
			//6
				List<Manual> list5= new ArrayList<Manual>();
				
				list5=manualService.getcateSeach(6,1);
				
				model.addAttribute("list5", list5);
			
				
				model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate5", list5.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
				int size5 = manualService.getManualCountByUserId(5);

				int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
			

				pagesMyAnsQuestion5 = getPages(1, maxPage5,6);
				model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				
				
				
				
				
				

			}else if(flag==5){
				List<Manual> list4= new ArrayList<Manual>();
				
				list4=manualService.getcateSeach(5,page);
				
				model.addAttribute("list4", list4);
			
				
				model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate4", list4.get(0).getManual_lab());
				
				
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag5", requestFlag);
				
				List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
				int size4 = manualService.getManualCountByUserId(5);

				int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage4) {
					page = maxPage4;
				}

				pagesMyAnsQuestion4 = getPages(page, maxPage4,5);
				model.addAttribute("Pages5", pagesMyAnsQuestion4);
				
				
				

				//1	
				List<Manual> list= new ArrayList<Manual>();
					
					list=manualService.getcateSeach(1,1);
					model.addAttribute("background", list.get(0).getManual_backgroundimg());
					model.addAttribute("cate", list.get(0).getManual_lab());
					
					model.addAttribute("list", list);
					
					
					List<Page> pagesMyAnsQuestion = new ArrayList<>();
					int size = manualService.getManualCountByUserId(1);

					int maxPage = (int) Math.ceil(1.0 * size / 5);
				

					pagesMyAnsQuestion = getPages(1, maxPage, 1);
					model.addAttribute("Pages1", pagesMyAnsQuestion);
					
					
					//2		

					List<Manual> list1= new ArrayList<Manual>();
					
					list1=manualService.getcateSeach(2,1);
					
					model.addAttribute("list1", list1);
				
					
					model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate1", list1.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
					int size1 = manualService.getManualCountByUserId(2);

					int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
				
					pagesMyAnsQuestion1 = getPages(1, maxPage1, 2);
					model.addAttribute("Pages2", pagesMyAnsQuestion1);
					
					
					//3		
					List<Manual> list2= new ArrayList<Manual>();
					
					list2=manualService.getcateSeach(3,1);
					
					model.addAttribute("list2", list2);
				
					
					model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate2", list2.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
					int size2 = manualService.getManualCountByUserId(3);

					int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
				

					pagesMyAnsQuestion2 = getPages(1, maxPage2, 3);
					model.addAttribute("Pages3", pagesMyAnsQuestion2);
					
					
					//4
					List<Manual> list3= new ArrayList<Manual>();
					
					list3=manualService.getcateSeach(4,1);
					
					model.addAttribute("list3", list3);
				
					
					model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate3", list3.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
					int size3 = manualService.getManualCountByUserId(4);

					int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
				

					pagesMyAnsQuestion3 = getPages(1, maxPage3, 4);
					model.addAttribute("Pages4", pagesMyAnsQuestion3);

				

			//6
				List<Manual> list5= new ArrayList<Manual>();
				
				list5=manualService.getcateSeach(6,1);
				
				model.addAttribute("list5", list5);
			
				
				model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate5", list5.get(0).getManual_lab());
				
				
				
				List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
				int size5 = manualService.getManualCountByUserId(5);

				int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
			

				pagesMyAnsQuestion5 = getPages(1, maxPage5,6);
				model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				
				
				
				
				
				
				
				
				
			}else {
				List<Manual> list5= new ArrayList<Manual>();
				
				list5=manualService.getcateSeach(6,page);
				
				model.addAttribute("list5", list5);
			
				
				model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
			
				model.addAttribute("cate5", list5.get(0).getManual_lab());
				
				RequestFlag requestFlag = new RequestFlag();
				requestFlag.setMostNew("");
				requestFlag.setMostHot("class=\"active\"");
				requestFlag.setActiveHot("active");
				requestFlag.setActiveNew("");
				requestFlag.setActiveMyAnswer("");
				requestFlag.setActiveMyQuestion("");
			
				model.addAttribute("requestFlag6", requestFlag);
				
				
				List<Page> pagesMyAnsQuestion5 = new ArrayList<>();
				int size5 = manualService.getManualCountByUserId(5);

				int maxPage5 = (int) Math.ceil(1.0 * size5 / 5);
				if (page == null || page < 1) {
					page = 1;
				} else if (page >= maxPage5) {
					page = maxPage5;
				}

				pagesMyAnsQuestion5 = getPages(page, maxPage5,6);
				model.addAttribute("Pages6", pagesMyAnsQuestion5);
				
				//1	
				List<Manual> list= new ArrayList<Manual>();
					
					list=manualService.getcateSeach(1,1);
					model.addAttribute("background", list.get(0).getManual_backgroundimg());
					model.addAttribute("cate", list.get(0).getManual_lab());
					
					model.addAttribute("list", list);
					
					
					List<Page> pagesMyAnsQuestion = new ArrayList<>();
					int size = manualService.getManualCountByUserId(1);

					int maxPage = (int) Math.ceil(1.0 * size / 5);
				

					pagesMyAnsQuestion = getPages(1, maxPage, 1);
					model.addAttribute("Pages1", pagesMyAnsQuestion);
					
					
					//2		

					List<Manual> list1= new ArrayList<Manual>();
					
					list1=manualService.getcateSeach(2,1);
					
					model.addAttribute("list1", list1);
				
					
					model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate1", list1.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion1 = new ArrayList<>();
					int size1 = manualService.getManualCountByUserId(2);

					int maxPage1 = (int) Math.ceil(1.0 * size1 / 5);
				
					pagesMyAnsQuestion1 = getPages(1, maxPage1, 2);
					model.addAttribute("Pages2", pagesMyAnsQuestion1);
					
					
					//3		
					List<Manual> list2= new ArrayList<Manual>();
					
					list2=manualService.getcateSeach(3,1);
					
					model.addAttribute("list2", list2);
				
					
					model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate2", list2.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion2 = new ArrayList<>();
					int size2 = manualService.getManualCountByUserId(3);

					int maxPage2 = (int) Math.ceil(1.0 * size2 / 5);
				

					pagesMyAnsQuestion2 = getPages(1, maxPage2, 3);
					model.addAttribute("Pages3", pagesMyAnsQuestion2);
					
					
					//4
					List<Manual> list3= new ArrayList<Manual>();
					
					list3=manualService.getcateSeach(4,1);
					
					model.addAttribute("list3", list3);
				
					
					model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate3", list3.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion3 = new ArrayList<>();
					int size3 = manualService.getManualCountByUserId(4);

					int maxPage3 = (int) Math.ceil(1.0 * size3 / 5);
				

					pagesMyAnsQuestion3 = getPages(1, maxPage3, 4);
					model.addAttribute("Pages4", pagesMyAnsQuestion3);
				
					//5	
					List<Manual> list4= new ArrayList<Manual>();
					
					list4=manualService.getcateSeach(5,1);
					
					model.addAttribute("list4", list4);
				
					
					model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
				
					model.addAttribute("cate4", list4.get(0).getManual_lab());
					
					
					
					List<Page> pagesMyAnsQuestion4 = new ArrayList<>();
					int size4 = manualService.getManualCountByUserId(5);

					int maxPage4 = (int) Math.ceil(1.0 * size4 / 5);
				

					pagesMyAnsQuestion4 = getPages(1, maxPage4,5);
					model.addAttribute("Pages5", pagesMyAnsQuestion4);
				
				
				
				
				
				
			}
			
			
//			
//
//			
//			
//			List<Manual> list1= new ArrayList<Manual>();
//			
//			list1=manualService.getcateSeach(2,page);
//			
//			model.addAttribute("list1", list1);
//		
//			
//			model.addAttribute("background1", list1.get(0).getManual_backgroundimg());
//			
//			model.addAttribute("cate1", list1.get(0).getManual_lab());
//			
//		
//		
//			List<Manual> list2= new ArrayList<Manual>();
//			
//			list2=manualService.getcateSeach(3,page);
//		
//			model.addAttribute("list2", list2);
//			
//			model.addAttribute("background2", list2.get(0).getManual_backgroundimg());
//			model.addAttribute("cate2", list2.get(0).getManual_lab());
//		
//		
//			List<Manual> list3= new ArrayList<Manual>();
//			
//			list3=manualService.getcateSeach(4,page);
//			
//			model.addAttribute("cate3", list3.get(0).getManual_lab());
//			model.addAttribute("background3", list3.get(0).getManual_backgroundimg());
//		
//			model.addAttribute("list3", list3);
//			
//			List<Manual> list4= new ArrayList<Manual>();
//			
//			list4=manualService.getcateSeach(5,page);
//			model.addAttribute("cate4", list4.get(0).getManual_lab());
//			
//			model.addAttribute("background4", list4.get(0).getManual_backgroundimg());
//		
//			model.addAttribute("list4", list4);
//		
//			List<Manual> list5= new ArrayList<Manual>();
//			
//			list5=manualService.getcateSeach(6,page);
//		
//			model.addAttribute("background5", list5.get(0).getManual_backgroundimg());
//			
//			model.addAttribute("cate5", list5.get(0).getManual_lab());
//			
//			model.addAttribute("list5", list5);
		
		
		
			
			
		return "manual";
		}
		
	}
	@RequestMapping(value="/manualarticle.action")
	public String manualartcle(HttpSession session,Model model,HttpServletRequest request,HttpServletResponse response, Integer manualartcle_id){
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:./user/account.jsp";
		} else{	
		ManualArticle manual= manualService.findByIdArtcle(manualartcle_id);
			String date=manualService.ManualArticle_time(manualartcle_id);
		
			
			if("0分钟前".equals(date)){
				manual.setCreate_time("刚刚");
			}else{
				manual.setCreate_time(date);
			}
			model.addAttribute("manualarticle",manual);
			return "manualarticle";
		}
	}
	
	public List<Page> getPages(int page, int maxPage, int flag) {
		List<Page> pages = new ArrayList<>();
		Page f = new Page();
		f.setContent("上一页");
		f.setPageNum(page - 1);
		f.setStyle("");
		f.setFlag(flag);
		pages.add(f);
		for (int i = 1; i <= maxPage; i++) {
			Page p = new Page();
			if (i == page) {
				p.setFlag(flag);
				p.setStyle("class=\"active\"");
				p.setContent(i + "");
				p.setPageNum(page);
			} else {
				p.setFlag(flag);
				p.setContent("");
				p.setContent(i + "");
				p.setPageNum(i);
			}
			pages.add(p);
		}
		f = new Page();
		f.setContent("下一页");
		if (page + 1 < maxPage) {
			f.setPageNum(page + 1);
		} else {
			f.setPageNum(maxPage);
		}

		f.setStyle("");
		f.setFlag(flag);
		pages.add(f);
		return pages;
	}
}
