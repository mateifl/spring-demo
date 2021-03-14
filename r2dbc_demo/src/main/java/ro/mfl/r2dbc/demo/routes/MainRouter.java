package ro.mfl.r2dbc.demo.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import ro.mfl.r2dbc.demo.handler.CategoryHandler;
import ro.mfl.r2dbc.demo.handler.InformationHandler;
import ro.mfl.r2dbc.demo.handler.OrderHandler;
import ro.mfl.r2dbc.demo.handler.ProductHandler;

@Configuration
public class MainRouter {

	@Bean
	RouterFunction<ServerResponse> ordersRoutes(OrderHandler orderHandler) {
		return route(GET("/orders"), orderHandler::getEntities)
				.and(route(GET("/orders/{id}"), orderHandler::getEntity))
				.and(route(POST("/orders"), orderHandler::createOrder));
	}

	@Bean
	RouterFunction<ServerResponse> productsRoutes(ProductHandler productHandler) {
		return route(GET("/products"), productHandler::getEntities)
				.and(route(GET("/products/{id}"), productHandler::getEntity));
	}

	@Bean
	RouterFunction<ServerResponse> categoriesRoutes(CategoryHandler categoryHandler) {
		return route(GET("/categories"), categoryHandler::getEntities)
				.and(route(GET("/categories/{id}"), categoryHandler::getEntity));
	}

	@Bean
	RouterFunction<ServerResponse> informationRoutes(InformationHandler informationHandler) {
		return route(GET("/info"), informationHandler::getEntities);
	}

}
