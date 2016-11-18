/*
  GRANITE DATA SERVICES
  Copyright (C) 2007 ADEQUATE SYSTEMS SARL

  This file is part of Granite Data Services.

  Granite Data Services is free software; you can redistribute it and/or modify
  it under the terms of the GNU Lesser General Public License as published by
  the Free Software Foundation; either version 3 of the License, or (at your
  option) any later version.
 
  Granite Data Services is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
  for more details.
 
  You should have received a copy of the GNU Lesser General Public License
  along with this library; if not, see <http://www.gnu.org/licenses/>.
*/

package com.weedong.flex.messaging.messages;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Franck WOLFF
 */
public interface Message extends Serializable {

    public static final String DESTINATION_CLIENT_ID_HEADER = "DSDstClientId";
    public static final String ENDPOINT_HEADER = "DSEndpoint";
    public static final String REMOTE_CREDENTIALS_HEADER = "DSRemoteCredentials";
    public static final String DS_ID_HEADER = "DSId";
    
    /**
     *  A status code can provide context about the nature of a response
     *  message. For example, messages received from an HTTP based channel may
     *  need to report the HTTP response status code (if available).
     */
    String STATUS_CODE_HEADER = "DSStatusCode";

    public static final String HIDDEN_CREDENTIALS = "****** (credentials)";

    public Object getBody();
    public Object getClientId();
    public String getDestination();
    public Object getHeader(String name);
    public Map<String, Object> getHeaders();
    public String getMessageId();
    public long getTimestamp();
    public long getTimeToLive();
    public boolean headerExists(String name);
    public void setBody(Object value);
    public void setClientId(Object value);
    public void setDestination(String value);
    public void setHeader(String name, Object value);
    public void setHeaders(Map<String, Object> value);
    public void setMessageId(String value);
    public void setTimestamp(long value);
    public void setTimeToLive(long value);
    
    public String toString(String indent);
}
