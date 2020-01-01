package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.entity.Epic;
import com.pluralsight.repository.EpicRepository;
@Service
public class EpicServiceImpl implements EpicService {

	@Autowired
	private EpicRepository epicRepo;
	@Override
	public List<Epic> listEpics() {
		// TODO Auto-generated method stub
		return (List<Epic>) epicRepo.findAll();
	}

}
