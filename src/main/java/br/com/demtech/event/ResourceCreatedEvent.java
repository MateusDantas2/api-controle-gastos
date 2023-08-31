package br.com.demtech.event;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Mateus Dantas
 */
@Getter
public class ResourceCreatedEvent extends ApplicationEvent {

    private final HttpServletResponse response;
    private final Long id;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
