package com.midland.web.dao;

import com.midland.web.model.FilmLibrary;

public interface FilmLibraryMapper {
    int insert(FilmLibrary record);

    int insertSelective(FilmLibrary record);
}