package com.stackroute.survey_engine.Services;

import com.stackroute.survey_engine.Enums.SurveyType;
import com.stackroute.survey_engine.Exceptions.ServiceException;
import com.stackroute.survey_engine.Models.ActiveSurveys;
import com.stackroute.survey_engine.Repositories.ActiveSurveysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ActiveSurveysServiceImpl implements IActiveSurveysService{

    public ActiveSurveysRepository activeSurveysRepository;

    @Autowired
    public ActiveSurveysServiceImpl(ActiveSurveysRepository activeSurveysRepository) {
        this.activeSurveysRepository = activeSurveysRepository;
    }

    @Override
    public ActiveSurveys saveActiveSurveys(ActiveSurveys activeSurveys) throws ServiceException {
        try {
            if (activeSurveysRepository.findBySurveyId(activeSurveys.getSurveyId()) != null) {
                throw new ServiceException("Survey Already Exist");
            }
            else
            {
                activeSurveys.setSurveyId(UUID.randomUUID());
               // activeSurveys.setCreatedBy(UUID.randomUUID());
                activeSurveys.setSurveyType(SurveyType.FLAT);
                activeSurveys.setActivatedOn(new Date(System.currentTimeMillis()));
                activeSurveys.setCreatedOn(new Date(System.currentTimeMillis()));
                activeSurveys.setActiveTime(3600);

                return activeSurveysRepository.save(activeSurveys);
            }
        }catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ActiveSurveys deactivateActiveSurveys(ActiveSurveys activeSurveys,UUID surveyId) throws ServiceException {
        try {
            if((activeSurveysRepository.findBySurveyId(activeSurveys.getSurveyId()) != null) &&
                    ((activeSurveysRepository.findBySurveyId(activeSurveys.getSurveyId())).getSurveyId().equals(surveyId) ))
            {
            ActiveSurveys delActiveSurveys=getOneActiveSurveyByID(surveyId);
            activeSurveysRepository.delete(delActiveSurveys);
                return delActiveSurveys;
            }
            else
            {
                throw new ServiceException("Active Survey doesn't Exist");
            }
        }catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<ActiveSurveys> getAllActiveSurveys() throws ServiceException {
        try {
            return activeSurveysRepository.findAll();
        }catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ActiveSurveys getOneActiveSurveyByID(UUID surveyId) throws ServiceException {
        try {
            ActiveSurveys activeSurveys=activeSurveysRepository.findBySurveyId(surveyId);

                return activeSurveys;
        }catch (Exception e){
                throw new ServiceException(e.getMessage());
            }
        }



    @Override
    public ActiveSurveys getActiveSurveysByCreator(UUID createdBy) throws ServiceException {
        try {
            ActiveSurveys activeSurveys;
            if (activeSurveysRepository.findByCreatedBy(createdBy) == null) {
                throw new ServiceException("Active Survey doesn't Exist");
            } else {
                activeSurveys = activeSurveysRepository.findByCreatedBy(createdBy);

                return activeSurveys;
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
