package com.app.service.impl;

import com.app.model.Movie;
import com.app.repository.TitleRepository;
import com.app.repository.impl.TitleRepositoryImpl;
import com.app.service.TitleService;

import java.util.List;

public class TitleServiceImpl implements TitleService {
    private TitleRepository titleRepository;

    public TitleServiceImpl() {
        titleRepository = new TitleRepositoryImpl();
    }


    @Override
    public List<Movie> getListOfTitles() {

        return titleRepository.getTitleList();
    }
}
