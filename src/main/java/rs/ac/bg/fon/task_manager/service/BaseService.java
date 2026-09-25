package rs.ac.bg.fon.task_manager.service;

import java.util.List;

public interface BaseService<Request,Response> {
    Response create(Request request);
    Response update(Long id, Request request);
    Response getById(Long id);
    List<Response> getAll();
    void delete(Long id);
}
