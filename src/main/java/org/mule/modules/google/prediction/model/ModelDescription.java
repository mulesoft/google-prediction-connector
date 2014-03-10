/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.prediction.model;

import com.google.api.services.prediction.model.Analyze;
import org.mule.modules.google.api.model.BaseWrapper;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModelDescription extends BaseWrapper<Analyze.ModelDescription>  {

    public ModelDescription() {
        this(new Analyze.ModelDescription());
    }

    public ModelDescription(Analyze.ModelDescription wrapped) {
        super(wrapped);
    }


    public Map<String,Map<String,Double>> getConfusionMatrix(){
        return wrapped.getConfusionMatrix();
    }

    public Map<String,Double> getConfusionMatrixRowTotals(){
        return wrapped.getConfusionMatrixRowTotals();
    }

    public Training getModelInfo(){
        return new Training(wrapped.getModelinfo());
    }

    public void setConfusionMatrix(Map<String,Map<String,Double>> confusionMatrix){
        this.wrapped.setConfusionMatrix(confusionMatrix);
    }

    public void setConfusionMatrixRowTotals(Map<String,Double> confusionMatrixRowTotals){
        this.wrapped.setConfusionMatrixRowTotals(confusionMatrixRowTotals);
    }

    public void setModelInfo(Training training){
        this.wrapped.setModelinfo(training.wrapped());
    }

}
