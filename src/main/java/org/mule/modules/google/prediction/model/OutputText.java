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
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutputText extends BaseWrapper<Analyze.DataDescription.OutputFeature.Text> {
   
	public OutputText() {
        this(new Analyze.DataDescription.OutputFeature.Text());
    }

    public OutputText(Analyze.DataDescription.OutputFeature.Text wrapped) {
        super(wrapped);
    }

    public Long getCount() {
        return wrapped.getCount();
    }

    public void setCount(Long count) {
        this.wrapped.setCount(count);

    }

}
