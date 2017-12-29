package com.song.samples.archetype.dao;

import com.song.samples.archetype.model.bo.Hello;
import org.springframework.stereotype.Repository;

/**
 * @author Auto generated, DO NOT EDIT
 */
@Repository
public interface HelloDao {

    Hello getHello(String q);
}
