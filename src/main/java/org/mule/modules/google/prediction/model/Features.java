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

/**
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Features extends BaseWrapper<Analyze.DataDescription.Features> {

    public Features() {
        this(new Analyze.DataDescription.Features());
    }

    public Features(Analyze.DataDescription.Features wrapped) {
        super(wrapped);
    }

    public Categorical getCategorical(){
        return new Categorical(wrapped.getCategorical());
    }

    public Long getIndex(){
        return wrapped.getIndex();
    }

    public Numeric getNumeric(){
        return new Numeric(wrapped.getNumeric());
    }

    public Text getText(){
        return new Text(wrapped.getText());
    }

    public void setCategorical(Categorical categorical) {
        this.wrapped.setCategorical(categorical.wrapped());
    }

    public void setIndex(Long index){
        this.wrapped.setIndex(index);
    }

    public void setNumeric(Numeric numeric) {
        this.wrapped.setNumeric(numeric.wrapped());
    }

    public void setText(Text text) {
        this.wrapped.setText(text.wrapped());
    }
}
