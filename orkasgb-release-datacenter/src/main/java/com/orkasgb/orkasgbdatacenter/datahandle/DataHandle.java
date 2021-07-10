package com.orkasgb.orkasgbdatacenter.datahandle;

import com.orkasgb.orkasgbserver.server.datahandle.DataHandleService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class DataHandle implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    DataHandleService dataHandleService;

    public void startDataHandle() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.scheduleAtFixedRate(this::downloadDataHandle, 0, 5, TimeUnit.MINUTES);
        executor.scheduleAtFixedRate(this::accessDataHandle, 0, 5, TimeUnit.MINUTES);
    }

    private void accessDataHandle() {
        try {
            dataHandleService.accessDataHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadDataHandle() {
        try {
            dataHandleService.downloadDataHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        startDataHandle();
    }
}
