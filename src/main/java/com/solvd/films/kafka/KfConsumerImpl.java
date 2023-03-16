package com.solvd.films.kafka;

import com.solvd.films.service.FilmService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.KafkaReceiver;

@Slf4j
@Component
@RequiredArgsConstructor
public class KfConsumerImpl implements KfConsumer{

    private final KafkaReceiver<String, String> kafkaReceiver;
    private final FilmService filmService;

    @Override
    @PostConstruct
    public void fetch() {
        this.kafkaReceiver.receive()
                .subscribe(r -> {
                    log.info("Message is: {}", r.value());
                    filmService.updateStatus(Long.parseLong(r.value())).subscribe();
                    r.receiverOffset().acknowledge();
                });
    }

}
