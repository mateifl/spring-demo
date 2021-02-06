package ro.mfl.r2dbc.demo.handler;

import java.io.Serializable;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.r2dbc.demo.entities.IdentityOwner;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractHandler<
    Id extends Serializable,
    Entity extends IdentityOwner,
    Repository extends ReactiveCrudRepository<Entity, Integer>> {

  private final Repository repository;

  public Mono<ServerResponse> getEntities(ServerRequest request) {
    log.info("loading all " + prototype().getClass().getName());
    Flux<Entity> entities = repository.findAll();

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(entities, prototype().getClass());
  }

  public Mono<ServerResponse> getEntity(ServerRequest request) {
    final Integer id = Integer.valueOf(request.pathVariable("id"));
    Mono<Entity> orderMono = getRepository().findById(id);
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(orderMono, prototype().getClass());
  }

  protected abstract Entity prototype();

  protected Repository getRepository() {
    return repository;
  }
}
