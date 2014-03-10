/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.prediction.model;

import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModelInfo extends BaseWrapper<com.google.api.services.prediction.model.Training.ModelInfo> {
    
	public ModelInfo() {
        this(new com.google.api.services.prediction.model.Training.ModelInfo());
    }

    public ModelInfo(com.google.api.services.prediction.model.Training.ModelInfo wrapped) {
        super(wrapped);
    }

    public Double getClassificationAccuracy(){
        return wrapped.getClassificationAccuracy();
    }

    public Double getClassWeightedAccuracy(){
        return wrapped.getClassWeightedAccuracy();
    }

    public Double getMeanSquaredError(){
        return wrapped.getMeanSquaredError();
    }

    public String getModelType(){
        return wrapped.getModelType();
    }

    public Long getNumberInstances(){
        return wrapped.getNumberInstances();
    }

    public Long getNumberLabels(){
        return wrapped.getNumberLabels();
    }

    public void setClassificationAccuracy(Double classificationAccuracy){
        this.wrapped.setClassificationAccuracy(classificationAccuracy);
    }

    public void setClassWeightedAccuracy(Double classWeightedAccuracy){
        this.wrapped.setClassWeightedAccuracy(classWeightedAccuracy);
    }

    public void setMeanSquaredError(Double meanSquaredError){
        this.wrapped.setMeanSquaredError(meanSquaredError);
    }

    public void setModelType(String modelType){
        this.wrapped.setModelType(modelType);
    }

    public void setNumberInstances(Long numberInstances){
        this.wrapped.setNumberInstances(numberInstances);
    }

    public void setNumberLabels(Long numberLabels){
        this.wrapped.setNumberLabels(numberLabels);
    }
}
