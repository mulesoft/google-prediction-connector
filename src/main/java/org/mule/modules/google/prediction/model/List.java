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
 * Created with IntelliJ IDEA.
 * User: albinkjellin
 * Date: 8/11/12
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class List extends BaseWrapper<com.google.api.services.prediction.model.List> {

    public List() {
        this(new com.google.api.services.prediction.model.List());
    }

    public List(com.google.api.services.prediction.model.List wrapped) {
        super(wrapped);
    }

    public java.util.List<Training> getItems() {
        return valueOf(this.wrapped.getItems(), Training.class);
    }

    public String getNextPageToken(){
        return wrapped.getNextPageToken();
    }

    public String getSelfLink() {
        return wrapped.getSelfLink();
    }

    public List setItems(java.util.List<Training> items) {
        return new List(wrapped.setItems(unwrapp(items, com.google.api.services.prediction.model.Training.class)));
    }

    public List setNextPageToken(String nextPageToken){
        return new List(wrapped.setNextPageToken(nextPageToken));
    }

    public void setSelfLink(String selfLink) {
        wrapped.setSelfLink(selfLink);
    }
}
