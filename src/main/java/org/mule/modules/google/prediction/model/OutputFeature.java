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
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutputFeature extends BaseWrapper<Analyze.DataDescription.OutputFeature> {

    public OutputFeature() {
        this(new Analyze.DataDescription.OutputFeature());
    }

    public OutputFeature(Analyze.DataDescription.OutputFeature wrapped) {
        super(wrapped);
    }

    public OutputNumeric getNumeric(){
        return new OutputNumeric(wrapped.getNumeric());
    }

    public java.util.List<OutputText> getText(){
        return valueOf(this.wrapped.getText(), OutputText.class);
    }

    public void setNumeric(Analyze.DataDescription.OutputFeature.Numeric numeric){
        wrapped.setNumeric(numeric);
    }

    public void setText(java.util.List<OutputText> text){
        wrapped.setText(unwrapp(text, com.google.api.services.prediction.model.Analyze.DataDescription.OutputFeature.Text.class));
    }
}
