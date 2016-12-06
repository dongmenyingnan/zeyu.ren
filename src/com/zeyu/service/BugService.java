package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.Bug;

public interface BugService {
	public List<Bug> searchBug(String str);
	public List<Bug> searchAbnormal(String str);
	public List<Bug> getLabelsByKind(int kind);
	public Bug getLabelContent(String label,int kind);
}
