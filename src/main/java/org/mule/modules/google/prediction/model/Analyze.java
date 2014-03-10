/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.prediction.model;

import java.util.Map;

import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Analyze extends BaseWrapper<com.google.api.services.prediction.model.Analyze> {

    public Analyze() {
        this(new com.google.api.services.prediction.model.Analyze());
    }

    public Analyze(com.google.api.services.prediction.model.Analyze wrapped) {
        super(wrapped);
    }

    public DataDescription getDataDescription() {
        return new DataDescription(wrapped.getDataDescription());
    }

    public java.util.List<Map<String,String>> getErrors(){
        return wrapped.getErrors();
    }

    public String getId() {
        return wrapped.getId();
    }

    public ModelDescription getModelDescription(){
        return new ModelDescription(wrapped.getModelDescription());
    }

    public String getSelfLink() {
        return wrapped.getSelfLink();
    }

    public void setDataDescription(DataDescription dataDescription) {
        this.wrapped.setDataDescription(dataDescription.wrapped());
    }

    public void setErrors(java.util.List<Map<String,String>> errors){
        this.wrapped.setErrors(errors);
    }

    public void setId(String id) {
        this.wrapped.setId(id);
    }

    public void setKind(String kind) {
        this.wrapped.setKind(kind);
    }

    public void setModelDescription(ModelDescription modelDescription) {
        this.wrapped.setModelDescription(modelDescription.wrapped());
    }

    public void setSelfLink(String selfLink) {
        wrapped.setSelfLink(selfLink);
    }

}
