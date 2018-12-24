package pl.java.scalatech.dataConsumer.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.dataConsumer.event.CreatedEvent;
import pl.java.scalatech.dataConsumer.event.ModifiedEvent;
@Slf4j
public class Listener {
    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'CREATE_DOMAIN'")
    public void receiveGranted(@Payload CreatedEvent createdEvent) {
        log.info("\nCREATED [" + createdEvent.payload() + "] !!!! \n\n");
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'EVENT_MODIFIED_DOMAIN'")
    public void receiveRejected(@Payload ModifiedEvent eventModified) {
        log.error("\nMODIFIED [" + eventModified.payload() + "] !!!! \n\n");
    }
}
