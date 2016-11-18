/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  2008 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/

package com.weedong.flex.client;
import com.weedong.flex.client.AMFConnection.HttpResponseInfo;

/**
 * Server status exceptions are thrown by the AMF connection when a server side
 * error is encountered.
 */
public class ServerStatusException extends Exception
{
    private static final long serialVersionUID = -5441048669770997132L;

    private Object data;
    private HttpResponseInfo httpResponseInfo;

    /**
     * Creates a server status exception with the supplied message and data.
     *
     * @param message The message of the exception.
     * @param data The data of the exception which is usually an AMF result or
     * status message.
     */
    public ServerStatusException(String message, Object data)
    {
        this(message, data, null);
    }

    /**
     * Creates a server status exception with the supplied message, data, and
     * HTTP response info object.
     *
     * @param message The message of the exception.
     * @param data The data of the exception which is usually an AMF result or
     * status message.
     * @param httpResponseInfo The HTTP response info object that represents
     * the HTTP response returned with the exception.
     */
    public ServerStatusException(String message, Object data, HttpResponseInfo httpResponseInfo)
    {
        super(message);
        this.data = data;
        this.httpResponseInfo = httpResponseInfo;
    }

    /**
     * Returns the data of the exception.
     *
     * @return The data of the exception.
     */
    public Object getData()
    {
        return data;
    }

    /**
     * Returns the HTTP response info of the exception.
     *
     * @return The HTTP response info of the exception.
     */
    public HttpResponseInfo getHttpResponseInfo()
    {
        return httpResponseInfo;
    }

    /**
     * Returns a String representation of the exception.
     *
     * @return A String that represents the exception.
     */
    @Override
    public String toString()
    {
        String temp = "ServerStatusException " + "\n\tdata: " + data;
        if (httpResponseInfo != null)
            temp += "\n\tHttpResponseInfo: " + httpResponseInfo;
        return temp;
    }
}
