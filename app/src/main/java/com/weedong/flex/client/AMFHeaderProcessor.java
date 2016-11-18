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

import com.weedong.flex.amf.AMF0Header;

/**
 * An AMF connection may have an AMF header processor where AMF headers can be
 * passed to as they are encountered in AMF response messages.
 */
public interface AMFHeaderProcessor
{
    /**
     * The method that will be invoked by the AMF connection when an AMF header
     * is encountered.
     *
     * @param header The AMF header.
     */
    void processHeader(AMF0Header header);
}
