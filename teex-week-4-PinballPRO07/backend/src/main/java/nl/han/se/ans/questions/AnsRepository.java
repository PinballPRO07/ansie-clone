package nl.han.se.ans.questions;

import java.util.List;

public interface AnsRepository<T,ID> {
    int save(T object);

    int update(T object);

    T findById(ID id);

    int deleteById(ID id);

    List<T> findAll();

    List<T> findByPublished(boolean published);

    List<T> findByTitleContaining(String title);

    int deleteAll();
}
