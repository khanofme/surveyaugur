package com.stackroute.survey_engine.Controllers;


import com.stackroute.survey_engine.Models.ActiveSurveys;
import com.stackroute.survey_engine.Models.ResponseEnvelope;
import com.stackroute.survey_engine.Services.IActiveSurveysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("surveyengine/api/v1")
@Slf4j
public class ActiveSurveysController {

    @Autowired
    IActiveSurveysService activeSurveysService;

    public ActiveSurveysController(IActiveSurveysService activeSurveysService) {
        this.activeSurveysService = activeSurveysService;
    }




    @PostMapping("/surveys")
    public ResponseEntity saveActiveSurveys(@RequestBody ActiveSurveys activeSurveys) throws Exception {
        log.info("In Controller - Saving Active Surveys");
        ActiveSurveys saveActiveSurvey = activeSurveysService.saveActiveSurveys(activeSurveys);
        ResponseEnvelope response = new ResponseEnvelope();
        response.setResult(saveActiveSurvey);
        response.setCount(1);
        response.setError(null);
        response.setTotalCount((long) 1);
        response.setQuery(null);
        response.setStatus(200);
        response.setAsON(System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/surveys/{surveyId}")
    public ResponseEntity deactivateActiveSurveys(@RequestBody ActiveSurveys activeSurveys,@PathVariable("surveyId") UUID surveyId)throws Exception {
        log.info("In Controller - deactivating Active Surveys");
        ActiveSurveys deactivateActiveSurvey = activeSurveysService.deactivateActiveSurveys(activeSurveys,surveyId);

        ResponseEnvelope response = new ResponseEnvelope();
        response.setResult(deactivateActiveSurvey);
        response.setCount(1);
        response.setError(null);
        response.setTotalCount((long) 1);
        response.setQuery(null);
        response.setStatus(200);
        response.setAsON(System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/surveys/{surveyId}")
    public ResponseEntity getOneActiveSurveyByID(@PathVariable UUID surveyId)throws Exception {

        log.info("In Controller - retrieving Active Surveys");
        ActiveSurveys getOneActiveSurvey = activeSurveysService.getOneActiveSurveyByID(surveyId);

        ResponseEnvelope response = new ResponseEnvelope();
        response.setResult(getOneActiveSurvey);
        response.setCount(1);
        response.setError(null);
        response.setTotalCount((long) 1);
        response.setQuery(null);
        response.setStatus(200);
        response.setAsON(System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/surveys")
    public ResponseEntity<ResponseEnvelope> getAllActiveSurveys() throws Exception {

        List<ActiveSurveys> getAllActiveSurvey = activeSurveysService.getAllActiveSurveys();

        ResponseEnvelope response = new ResponseEnvelope();
        response.setResult(getAllActiveSurvey);
        response.setCount(1);
        response.setError(null);
        response.setTotalCount((long) 1);
        response.setQuery(null);
        response.setStatus(200);
        response.setAsON(System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/surveys/users/{createdBy}")
    public ResponseEntity getActiveSurveysByCreator(@PathVariable UUID createdBy)throws Exception {
        log.info("In Controller - retrieving Active Surveys by creator");
    ActiveSurveys getActiveSurveyByCreator = activeSurveysService.getOneActiveSurveyByID(createdBy);

    ResponseEnvelope response = new ResponseEnvelope();
        response.setResult(getActiveSurveyByCreator);
        response.setCount(1);
        response.setError(null);
        response.setTotalCount((long) 1);
        response.setQuery(null);
        response.setStatus(200);
        response.setAsON(System.currentTimeMillis());

        return ResponseEntity.ok(response);
   }


}
