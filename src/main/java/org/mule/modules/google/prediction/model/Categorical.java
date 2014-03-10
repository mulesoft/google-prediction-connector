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
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Categorical extends BaseWrapper<Analyze.DataDescription.Features.Categorical> {
    public Categorical() {
        this(new Analyze.DataDescription.Features.Categorical());
    }

    public Categorical(Analyze.DataDescription.Features.Categorical wrapped) {
        super(wrapped);
    }

    public Long getCount(){
        return wrapped.getCount();
    }

    public java.util.List<Values> getValues(){
        return valueOf(this.wrapped.getValues(), Values.class);
    }

    public void setCount(Long count){
        this.wrapped.setCount(count);
    }

    public void setValues(java.util.List<Values> values) {
        this.wrapped.setValues(unwrapp(values, Analyze.DataDescription.Features.Categorical.Values.class));
    }

}
