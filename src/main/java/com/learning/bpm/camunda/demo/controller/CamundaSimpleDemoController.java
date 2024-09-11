package com.learning.bpm.camunda.demo.controller;

import com.learning.bpm.camunda.demo.model.DateResponseDto;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CamundaSimpleDemoController {

    public static final String BPMN_ASK_FOR_A_DATE = "Process_AskForADate";

    private final RuntimeService runtimeService;

    public CamundaSimpleDemoController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/start-process/{businessKey}")
    public ResponseEntity<String> startProcess(@PathVariable String businessKey) {
        ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey(BPMN_ASK_FOR_A_DATE, businessKey);
        return ResponseEntity.ok()
                .body("Started process instance: " + processInstance.getBusinessKey());
    }

    @PostMapping("/send-response/{businessKey}")
    public ResponseEntity<Void> sendResponse(@RequestBody DateResponseDto dateResponse, @PathVariable String businessKey) {
        this.runtimeService.correlateMessage("Message_Response",
                businessKey,
                Map.of("response", dateResponse.getResponse(),
                        "message", dateResponse.getMessage()));

        return ResponseEntity.ok().build();
    }
}
