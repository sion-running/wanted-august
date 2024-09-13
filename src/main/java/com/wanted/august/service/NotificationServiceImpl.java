package com.wanted.august.service;


import com.wanted.august.model.Notification;
import com.wanted.august.model.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final Map<String, SseEmitter> emitterMap = new ConcurrentHashMap<>();
    private static final long TIMEOUT = Long.MAX_VALUE;

    @Override
    public SseEmitter connect(String userName) {
        // 초기 연결시 데이터 전송해야 함
        SseEmitter sseEmitter = send(NotificationType.CONNECTION, userName);

        String eventId = getEventId(userName);
        emitterMap.put(eventId, sseEmitter);

        sseEmitter.onCompletion(() -> emitterMap.remove(eventId));
        sseEmitter.onTimeout(() -> emitterMap.remove(eventId));
        sseEmitter.onError((e) -> emitterMap.remove(eventId));

        return sseEmitter;
    }

    @Override
    public SseEmitter send(NotificationType type, String userName) {
        SseEmitter emitter = emitterMap.getOrDefault(getEventId(userName), new SseEmitter(TIMEOUT));

        try {
            emitter.send(SseEmitter.event()
                    .name(type.toString())
                    .data(type.getDesc()));

            return emitter;
        } catch (IOException e) {
            log.error("전송중 에러", e);
            throw new RuntimeException();
        }
    }

    public String getEventId(String userName) {
// TODO refactoring --- return userName + "_" + System.currentTimeMillis();
        return userName;
    }
}