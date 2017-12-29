package it.pkg.dao;

import it.pkg.model.bo.Hello;
import org.springframework.stereotype.Repository;

/**
 * @author Auto generated, DO NOT EDIT
 */
@Repository
public interface HelloDao {

    Hello getHello(String q);
}
