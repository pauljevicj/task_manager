package rs.ac.bg.fon.task_manager.converter;

public interface Converter<Entity,Request,Response> {
    Response toResponse(Entity e);
    Entity toEntity(Request r);
}
