/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.prediction.model;

import java.util.List;
import java.util.Map;

import org.mule.modules.google.api.model.BaseWrapper;

import com.google.api.client.util.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/8/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Training extends BaseWrapper<com.google.api.services.prediction.model.Training> {

    public Training() {
        this(new com.google.api.services.prediction.model.Training());
    }

    public Training(com.google.api.services.prediction.model.Training wrapped) {
        super(wrapped);
    }

    public DateTime getCreated() {
        return wrapped.getCreated();
    }

    public String getId() {
        return wrapped.getId();
    }

    public ModelInfo getModelInfo(){
        return new ModelInfo(wrapped.getModelInfo());
    }

   public String getStorageDataLocation(){
       return wrapped.getStorageDataLocation();
   }

    public String getStoragePMMLLocation(){
        return wrapped.getStoragePMMLLocation();
    }

    public String getStoragePMMLModelLocation(){
        return wrapped.getStoragePMMLModelLocation();
    }

    public DateTime getTrainingComplete(){
        return  wrapped.getTrainingComplete();
    }

    public List<Map<String,Double>> getUtility(){
        return wrapped.getUtility();
    }

    public String getTrainingStatus(){
        return wrapped.getTrainingStatus();
    }

    public String getSelfLink() {
        return wrapped.getSelfLink();
    }

    public void setCreated(DateTime created) {
       this.wrapped.setCreated(created);
    }

    public void setId(String id) {
        this.wrapped.setId(id);
    }

    public void setModelInfo(ModelInfo modelInfo) {
        this.wrapped.setModelInfo(modelInfo.wrapped());
    }

    public void setSelfLink(String selfLink) {
        wrapped.setSelfLink(selfLink);
    }

    public void setStorageDataLocation(String storageDataLocation) {
        this.wrapped.setStorageDataLocation(storageDataLocation);
    }

    public void setStoragePMMLLocation(String storagePMMLLocation)  {
        this.wrapped.setStoragePMMLLocation(storagePMMLLocation);
    }

    public void setStoragePMMLModelLocation(String storagePMMLModelLocation)   {
        this.wrapped.setStoragePMMLModelLocation(storagePMMLModelLocation);
    }

    public void setTrainingComplete(DateTime trainingComplete)   {
        this.wrapped.setTrainingComplete(trainingComplete);
    }

    public void setTrainingStatus(String trainingStatus)   {
        this.wrapped.setTrainingStatus(trainingStatus);
    }
}
