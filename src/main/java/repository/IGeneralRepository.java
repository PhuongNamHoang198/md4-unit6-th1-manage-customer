package repository;
// repository là một package chứa các interface quan trọng trong spring data
// như là repository, ...
// repository là một package chứa các interface quan trọng trong hibernate
// như là session, ...

import java.util.List;

public interface IGeneralRepository <T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);

}

