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

import com.google.api.services.prediction.model.Analyze;

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataDescription extends BaseWrapper<Analyze.DataDescription> {
    public DataDescription() {
        this(new com.google.api.services.prediction.model.Analyze.DataDescription());
    }

    public DataDescription(Analyze  .DataDescription wrapped) {
        super(wrapped);
    }

    public java.util.List<Features> getFeatures() {
        return valueOf(this.wrapped.getFeatures(), Features.class);
    }

    public OutputFeature getOutputFeature()  {
        return new OutputFeature(wrapped.getOutputFeature());
    }

    public void setFeatures(java.util.List<Features> features) {
        this.wrapped.setFeatures(unwrapp(features, com.google.api.services.prediction.model.Analyze.DataDescription.Features.class));
    }

    public void setOutputFeature(OutputFeature outputFeature) {
        this.wrapped.setOutputFeature(outputFeature.wrapped());
    }
}
