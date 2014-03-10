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

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class OutputMulti extends BaseWrapper<com.google.api.services.prediction.model.Output.OutputMulti> {

	public OutputMulti() {
		super(new com.google.api.services.prediction.model.Output.OutputMulti());
	}
	
	public OutputMulti(com.google.api.services.prediction.model.Output.OutputMulti wrapped) {
		super(wrapped);
	}
	
	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}

	public Double getScore() {
		return wrapped.getScore();
	}

	public void setScore(Double score) {
		this.wrapped.setScore(score);
	}

	public String getLabel() {
		return wrapped.getLabel();
	}

	public void setLabel(String label) {
		this.wrapped.setLabel(label);
	}
}
