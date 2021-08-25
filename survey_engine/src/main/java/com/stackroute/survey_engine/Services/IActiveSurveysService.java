package com.stackroute.survey_engine.Services;


import com.stackroute.survey_engine.Exceptions.ServiceException;
import com.stackroute.survey_engine.Models.ActiveSurveys;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IActiveSurveysService {

    ActiveSurveys saveActiveSurveys(ActiveSurveys activeSurveys) throws ServiceException;
    ActiveSurveys deactivateActiveSurveys(ActiveSurveys activeSurveys,UUID surveyId) throws ServiceException;
    List<ActiveSurveys> getAllActiveSurveys() throws ServiceException;
    ActiveSurveys getOneActiveSurveyByID(UUID surveyId) throws ServiceException;
    ActiveSurveys getActiveSurveysByCreator(UUID createdBy) throws ServiceException;
}


