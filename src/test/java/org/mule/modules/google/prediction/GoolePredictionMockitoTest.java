/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.prediction;

import com.google.api.client.util.DateTime;
import com.google.api.services.prediction.Prediction;
import com.google.api.services.prediction.model.Input;
import com.google.api.services.prediction.model.Update;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mule.modules.google.prediction.model.Analyze;
import org.mule.modules.google.prediction.model.Output;
import org.mule.modules.google.prediction.model.Training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/12/12
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class GoolePredictionMockitoTest extends TestCase {


    private static final String CONSUMER_KEY = "CONSUMER_KEY";
    private static final String CONSUMER_SECRET = "CONSUMER_SECRET";
    private static final String SCOPE = "http://www.muletest.com/cellFeed";
    private static final String APPLICATION_NAME = "APPLICATION_NAME";

    private GooglePredictionConnector connector;

    private Prediction predictionClient;

    private Prediction.Trainedmodels trainedmodels;



    private com.google.api.services.prediction.model.Training training;

    private java.util.List<com.google.api.services.prediction.model.Training> trainingList;


    com.google.api.services.prediction.model.List predictionList;


    private Prediction.Trainedmodels.List trainedModelList;

    private Prediction.Trainedmodels.Predict trainedModelPredict;
    private Prediction.Trainedmodels.Insert trainedModelInsert;
    private Prediction.Trainedmodels.Update trainedModelUpdate;
    private Prediction.Trainedmodels.Delete trainedModelDelete;
    private Prediction.Trainedmodels.Analyze trainedModelAnalyze;
    private Prediction.Trainedmodels.Get trainedModelGet;

    private com.google.api.services.prediction.model.Output output;
    private com.google.api.services.prediction.model.Analyze analyze;


    @Test
    public void testCreate() throws Exception {
        Training trainingResult = this.connector.create("temp", "dummy/path",null,null);
        assertEquals("temp", trainingResult.getId());
        assertEquals(50.0, trainingResult.getModelInfo().getClassificationAccuracy());

    }

    @Test
    public void testList() throws Exception {
        List<Training> trainingListResult = this.connector.list();
        assertEquals(1,trainingListResult.size());
        assertEquals("temp", trainingListResult.get(0).getId());

    }

    @Test
    public void testUpdate() throws Exception {
        List<Object> input = new ArrayList<Object>();
        input.add("Is this english?");
        Training trainingResult = this.connector.update("temp","English",input);
        assertEquals("temp", trainingResult.getId());
        assertEquals(50.0, trainingResult.getModelInfo().getClassificationAccuracy());

    }

    @Test
    public void testPredict() throws Exception {
        List<Object> input = new ArrayList<Object>();
        input.add("Is this english?");
        Output outputResult = this.connector.predict("temp",input);

        assertEquals("temp",outputResult.getId());
        assertEquals("English",outputResult.getOutputLabel());
        assertEquals(1,outputResult.getOutputMulti().size());
        assertEquals("English",outputResult.getOutputMulti().get(0).getLabel());
        assertEquals(50.0,outputResult.getOutputMulti().get(0).getScore());



    }

    @Test
    public void testAnalyze() throws Exception {
        Analyze analyzeResult = this.connector.analyze("temp");

        assertEquals("temp",analyzeResult.getId());
        assertEquals(null,analyzeResult.getErrors());
        assertEquals(1,analyzeResult.getDataDescription().getFeatures().size());

        assertEquals(new Long(1),analyzeResult.getDataDescription().getFeatures().get(0).getCategorical().getCount());
        assertEquals(1,analyzeResult.getDataDescription().getFeatures().get(0).getCategorical().getValues().size());
        assertEquals("Value",analyzeResult.getDataDescription().getFeatures().get(0).getCategorical().getValues().get(0).getValue());
        assertEquals(new Long(1),analyzeResult.getDataDescription().getFeatures().get(0).getCategorical().getValues().get(0).getCount());

        assertEquals(new Long(1),analyzeResult.getDataDescription().getFeatures().get(0).getIndex());
        assertEquals(new Long(1),analyzeResult.getDataDescription().getFeatures().get(0).getNumeric().getCount());
        assertEquals(50.0,analyzeResult.getDataDescription().getFeatures().get(0).getNumeric().getMean());
        assertEquals(50.0,analyzeResult.getDataDescription().getFeatures().get(0).getNumeric().getVariance());

        assertEquals(new Long(1),analyzeResult.getDataDescription().getOutputFeature().getNumeric().getCount());
        assertEquals(50.0,analyzeResult.getDataDescription().getOutputFeature().getNumeric().getMean());
        assertEquals(50.0,analyzeResult.getDataDescription().getOutputFeature().getNumeric().getVariance());

        assertEquals(1,analyzeResult.getDataDescription().getOutputFeature().getText().size());
        assertEquals(new Long(1),analyzeResult.getDataDescription().getOutputFeature().getText().get(0).getCount());


    }

    @Test
    public void testGet() throws Exception {
        Training trainingResult = this.connector.get("temp");
        assertEquals("temp", trainingResult.getId());
        assertEquals(50.0, trainingResult.getModelInfo().getClassificationAccuracy());

    }

    @Test
    public void testTrainingComplete() throws Exception {
        Boolean trainingCompleteResult = this.connector.trainingComplete("temp");
        assertFalse(trainingCompleteResult);

    }

    @Test
    public void testDelete() throws Exception {
        this.connector.delete("temp");

    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.initTraining();
        this.initTrainingList();


        this.initOutput();
        this.initAnalyze();
        this.initTrainedModel();

        this.trainedmodels = mock(Prediction.Trainedmodels.class);
        this.predictionClient = mock(Prediction.class);
        this.connector = spy(new GooglePredictionConnector());

        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) throws Throwable {
                GooglePredictionConnector connector = (GooglePredictionConnector) invocation.getMock();
                connector.setClient(predictionClient);
                return null;
            }
        }).when(this.connector).postAuth();

        this.connector.setConsumerKey(CONSUMER_KEY);
        this.connector.setConsumerSecret(CONSUMER_SECRET);
        this.connector.setApplicationName(APPLICATION_NAME);
        this.connector.setScope(SCOPE);
        this.connector.postAuth();

        when(this.predictionClient.trainedmodels()).thenReturn(this.trainedmodels);
        when(this.predictionClient.trainedmodels().list()).thenReturn(this.trainedModelList);
        when(this.predictionClient.trainedmodels().list().execute()).thenReturn(this.predictionList);

        when(this.predictionClient.trainedmodels().predict(any(String.class), any(Input.class))).thenReturn(this.trainedModelPredict);
        when(this.predictionClient.trainedmodels().predict(any(String.class), any(Input.class)).execute()).thenReturn(this.output);

        when(this.predictionClient.trainedmodels().insert(any(com.google.api.services.prediction.model.Training.class))).thenReturn(this.trainedModelInsert);
        when(this.predictionClient.trainedmodels().insert(any(com.google.api.services.prediction.model.Training.class)).execute()).thenReturn(this.training);

        when(this.predictionClient.trainedmodels().update(any(String.class), any(Update.class))).thenReturn(this.trainedModelUpdate);
        when(this.predictionClient.trainedmodels().update(any(String.class), any(Update.class)).execute()).thenReturn(this.training);

        when(this.predictionClient.trainedmodels().analyze(any(String.class))).thenReturn(this.trainedModelAnalyze);
        when(this.predictionClient.trainedmodels().analyze(any(String.class)).execute()).thenReturn(this.analyze);

        when(this.predictionClient.trainedmodels().get(any(String.class))).thenReturn(this.trainedModelGet);
        when(this.predictionClient.trainedmodels().get(any(String.class)).execute()).thenReturn(this.training);

        when(this.predictionClient.trainedmodels().delete(any(String.class))).thenReturn(this.trainedModelDelete);

    }


    private void initTrainingList() {
        this.trainingList = new ArrayList<com.google.api.services.prediction.model.Training>();
        trainingList.add(this.training);


    }


    private void initTraining() {
        com.google.api.services.prediction.model.Training.ModelInfo modelInfo = new com.google.api.services.prediction.model.Training.ModelInfo();
        modelInfo.setClassificationAccuracy(50.0);
        modelInfo.setClassWeightedAccuracy(50.0);
        modelInfo.setMeanSquaredError(50.0);
        modelInfo.setModelType("Category");
        modelInfo.setNumberInstances(new Long(1));
        modelInfo.setNumberLabels(new Long(1));

        this.training = new com.google.api.services.prediction.model.Training();
        this.training.setCreated(new DateTime(new Date()));
        this.training.setId("temp");
        this.training.setKind("Category");
        this.training.setModelInfo(modelInfo);
        this.training.setStorageDataLocation("test/path");
        this.training.setTrainingComplete(new DateTime(new Date()));
        this.training.setTrainingStatus("COMPLETED");


    }

    private void initOutput() {


        com.google.api.services.prediction.model.Output.OutputMulti outputMulti = new com.google.api.services.prediction.model.Output.OutputMulti();

        outputMulti.setLabel("English");
        outputMulti.setScore(50.0);

        List<com.google.api.services.prediction.model.Output.OutputMulti> multiList = new ArrayList<com.google.api.services.prediction.model.Output.OutputMulti>();
        multiList.add(outputMulti);

        this.output = new com.google.api.services.prediction.model.Output();
        this.output.setId("temp");
        this.output.setKind("Category");
        this.output.setOutputLabel("English");
        this.output.setOutputMulti(multiList);
    }

    private void initAnalyze() {
        this.analyze = new com.google.api.services.prediction.model.Analyze();

        com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical.Values values = new com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical.Values();
        values.setCount(new Long(1));
        values.setValue("Value");
        List<com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical.Values> valueList = new ArrayList<com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical.Values>();
        valueList.add(values);

        com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical categorical = new com.google.api.services.prediction.model.Analyze.DataDescription.Features.Categorical();
        categorical.setCount(new Long(1));
        categorical.setValues(valueList);

        com.google.api.services.prediction.model.Analyze.DataDescription.Features.Numeric numeric = new com.google.api.services.prediction.model.Analyze.DataDescription.Features.Numeric();
        numeric.setMean(50.0);
        numeric.setVariance(50.0);
        numeric.setCount(new Long(1));

        com.google.api.services.prediction.model.Analyze.DataDescription.Features.Text text = new com.google.api.services.prediction.model.Analyze.DataDescription.Features.Text();
        text.setCount(new Long(1));

        com.google.api.services.prediction.model.Analyze.DataDescription.Features features = new com.google.api.services.prediction.model.Analyze.DataDescription.Features();
        features.setCategorical(categorical);
        features.setIndex(new Long(1));
        features.setNumeric(numeric);
        features.setText(text);

        List<com.google.api.services.prediction.model.Analyze.DataDescription.Features> featuresList = new ArrayList<com.google.api.services.prediction.model.Analyze.DataDescription.Features>();
        featuresList.add(features);


        com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Text outPutText = new com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Text();
        outPutText.setCount(new Long(1));
        outPutText.setValue("output value");

        List<com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Text> outputTextList = new ArrayList<com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Text>();
        outputTextList.add(outPutText);

        com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Numeric outputNumeric = new com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Numeric();
        outputNumeric.setCount(new Long(1));
        outputNumeric.setMean(50.0);
        outputNumeric.setVariance(50.0);

        com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature outputFeature = new com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature();
        outputFeature.setNumeric(outputNumeric);
        outputFeature.setText(outputTextList);

        com.google.api.services.prediction.model.Analyze.DataDescription dataDescription = new com.google.api.services.prediction.model.Analyze.DataDescription();
        dataDescription.setFeatures(featuresList);
        dataDescription.setOutputFeature(outputFeature);

        this.analyze.setDataDescription(dataDescription);
        this.analyze.setId("temp");
        this.analyze.setKind("Category");

    }

    private void initTrainedModel() {

        this.predictionList = new com.google.api.services.prediction.model.List();
        predictionList.setKind("test");
        predictionList.setItems(this.trainingList);


        this.trainedModelList = mock(Prediction.Trainedmodels.List.class);

        this.trainedModelPredict = mock(Prediction.Trainedmodels.Predict.class);
        this.trainedModelInsert = mock(Prediction.Trainedmodels.Insert.class);
        this.trainedModelUpdate = mock(Prediction.Trainedmodels.Update.class);
        this.trainedModelDelete = mock(Prediction.Trainedmodels.Delete.class);
        this.trainedModelAnalyze = mock(Prediction.Trainedmodels.Analyze.class);
        this.trainedModelGet = mock(Prediction.Trainedmodels.Get.class);



    }

}
