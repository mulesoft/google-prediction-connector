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
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Numeric extends BaseWrapper<Analyze.DataDescription.Features.Numeric> {
   
	public Numeric() {
        this(new Analyze.DataDescription.Features.Numeric());
    }

    public Numeric(Analyze.DataDescription.Features.Numeric wrapped) {
        super(wrapped);
    }

    public Long getCount() {
        return wrapped.getCount();
    }

    public Double getMean() {
        return wrapped.getMean();
    }

    public Double getVariance() {
        return wrapped.getVariance();
    }

    public void setCount(Long count) {
        this.wrapped.setCount(count);
    }

    public void setMean(Double mean) {
        this.wrapped.setMean(mean);
    }

    public void setVariance(Double variance) {
        this.wrapped.setVariance(variance);
    }
}
