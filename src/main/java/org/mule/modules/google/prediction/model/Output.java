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

import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/8/12
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Output extends BaseWrapper<com.google.api.services.prediction.model.Output> {

    public Output() {
        this(new com.google.api.services.prediction.model.Output());
    }

    public Output(com.google.api.services.prediction.model.Output wrapped) {
        super(wrapped);
    }

    public String getId() {
        return wrapped.getId();
    }

    public String getOutputLabel() {
        return wrapped.getOutputLabel();
    }

    public List<OutputMulti> getOutputMulti() {
        return valueOf(wrapped.getOutputMulti(), OutputMulti.class);
    }

    public Double getOutputValue() {
        return wrapped.getOutputValue();
    }

    public String getSelfLink() {
        return wrapped.getSelfLink();
    }

    public void setOutputLabel(String outputLabel) {
        wrapped.setOutputLabel(outputLabel);
    }
    
    public void setOutputMulti(List<OutputMulti> outputMulti) {
        wrapped.setOutputMulti(unwrapp(outputMulti, com.google.api.services.prediction.model.Output.OutputMulti.class));
    }

    public void setSelfLink(String selfLink) {
        wrapped.setSelfLink(selfLink);
    }

}
