/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  Copyright 2002 - 2007 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/
package com.weedong.flex.client;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import com.weedong.flex.amf.AMF0Body;
import com.weedong.flex.amf.AMF0Message;

/**
 * A context for reading and writing messages.
 * @exclude
 */
public class ActionContext implements Serializable
{
    static final long serialVersionUID = 2300156738426801921L;
    private int messageNumber;
    private AMF0Message requestMessage;
    private AMF0Message responseMessage;
    private ByteArrayOutputStream outBuffer;

    private int status;
    private int version;

    private boolean legacy;
    public boolean isPush;
    public boolean isDebug;

    /**
     * @exclude
     * Performance metrics related field, keeps track of bytes deserialized using this context
     */
    private int deserializedBytes;

    /**
     * @exclude
     * Performance metrics related field, keeps track of bytes serialized using this context
     */
    private int serializedBytes;

    /**
     * @exclude
     * Performance metrics related field, recordMessageSizes flag
     */
    private boolean recordMessageSizes;

    /**
     * @exclude
     * Performance metrics related field, recordMessageTimes flag
     */
    private boolean recordMessageTimes;

    /**
     * @exclude
     * Performance metrics related field, incoming MPI object, will only be populated when one of
     * the record-message-* params is enabled
     */
    private MessagePerformanceInfo mpii;

    /**
     * @exclude
     * Performance metrics related field, outgoing MPI object, will only be populated when one of
     * the record-message-* params is enabled
     */
    private MessagePerformanceInfo mpio;

    public ActionContext()
    {
        status = MessageIOConstants.STATUS_OK;
    }

    public boolean isLegacy()
    {
        return legacy;
    }

    public void setLegacy(boolean legacy)
    {
        this.legacy = legacy;
    }

    public int getMessageNumber()
    {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber)
    {
        this.messageNumber = messageNumber;
    }

    public AMF0Body getRequestMessageBody()
    {
        return requestMessage.getBody(messageNumber);
    }

    public AMF0Message getRequestMessage()
    {
        return requestMessage;
    }

    public void setRequestMessage(AMF0Message requestMessage)
    {
        this.requestMessage = requestMessage;
    }

    public AMF0Message getResponseMessage()
    {
        return responseMessage;
    }

    public AMF0Body getResponseMessageBody()
    {
        return responseMessage.getBody(messageNumber);
    }

    public void setResponseMessage(AMF0Message responseMessage)
    {
        this.responseMessage = responseMessage;
    }

    public void setResponseOutput(ByteArrayOutputStream out)
    {
        outBuffer = out;
    }

    public ByteArrayOutputStream getResponseOutput()
    {
        return outBuffer;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public void setVersion(int v)
    {
        version = v;
    }

    public int getVersion()
    {
        return version;
    }

    public void incrementMessageNumber()
    {
        messageNumber++;
    }

    public int getDeserializedBytes()
    {
        return deserializedBytes;
    }

    public void setDeserializedBytes(int deserializedBytes)
    {
        this.deserializedBytes = deserializedBytes;
    }

    public int getSerializedBytes()
    {
        return serializedBytes;
    }

    public void setSerializedBytes(int serializedBytes)
    {
        this.serializedBytes = serializedBytes;
    }

    public MessagePerformanceInfo getMPII()
    {
        return mpii;
    }

    public void setMPII(MessagePerformanceInfo mpii)
    {
        this.mpii = mpii;
    }

    public MessagePerformanceInfo getMPIO()
    {
        return mpio;
    }

    public void setMPIO(MessagePerformanceInfo mpio)
    {
        this.mpio = mpio;
    }

    public boolean isRecordMessageSizes()
    {
        return recordMessageSizes;
    }

    public void setRecordMessageSizes(boolean recordMessageSizes)
    {
        this.recordMessageSizes = recordMessageSizes;
    }

    public boolean isRecordMessageTimes()
    {
        return recordMessageTimes;
    }

    public boolean isMPIenabled()
    {
        return recordMessageTimes || recordMessageSizes;
    }

    public void setRecordMessageTimes(boolean recordMessageTimes)
    {
        this.recordMessageTimes = recordMessageTimes;
    }

}
