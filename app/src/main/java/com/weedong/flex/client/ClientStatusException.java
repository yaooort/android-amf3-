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
 * Client status exceptions are thrown by the AMF connection when a client side
 * error is encountered such as when a connect or call attempt fails due to
 * wrong url on the client.
 */
public class ClientStatusException extends Exception
{
    private static final long serialVersionUID = 1412675397183129614L;

    /**
     * Exception codes.
     */
    public static final String AMF_CALL_FAILED_CODE = "AMFConnection.Call.Failed";
    public static final String AMF_CONNECT_FAILED_CODE = "AMFConnection.Connect.Failed";

    private String code;
    private HttpResponseInfo httpResponseInfo;

    /**
     * Creates a client status exception with the supplied throwable and code.
     *
     * @param t The throwable instance used to create the exception.
     * @param code The code of the exception.
     */
    public ClientStatusException(Throwable t, String code)
    {
        super(t);
        this.code = code;
    }

    /**
     * Creates a client status exception with the supplied message and code.
     *
     * @param message The message of the exception.
     * @param code The code of the exception.
     */
    public ClientStatusException(String message, String code)
    {
        super(message);
        this.code = code;
    }

    /**
     * Creates a client status exception with the supplied message, code,
     * and http response info.
     *
     * @param message The message of the exception.
     * @param code The code of the exception.
     * @param httpResponseInfo The HTTP response info object that represents
     * the HTTP response returned with the exception.
     */
    public ClientStatusException(String message, String code, HttpResponseInfo httpResponseInfo)
    {
        this(message, code);
        this.httpResponseInfo = httpResponseInfo;
    }

    /**
     * Creates a client status exception with the supplied message, code,
     * and http response info.
     *
     * @param t The throwable instance used to create the exception.
     * @param code The code of the exception.
     * @param httpResponseInfo The HTTP response info object that represents
     * the HTTP response returned with the exception.
     */
    public ClientStatusException(Throwable t, String code, HttpResponseInfo httpResponseInfo)
    {
        this(t, code);
        this.httpResponseInfo = httpResponseInfo;
    }

    /**
     * Returns the code of the exception.
     *
     * @return The code of the exception.
     */
    public String getCode()
    {
        return code;
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
        return "ClientStatusException "
        + "\n\tmessage: " + getMessage()
        + "\n\tcode: " + code;
    }
}
