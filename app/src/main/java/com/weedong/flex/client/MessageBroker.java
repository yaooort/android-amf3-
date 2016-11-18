/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  [2002] - [2007] Adobe Systems Incorporated
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

import java.util.HashMap;
import java.util.Map;

/**
 * The MessageBroker is the hub of message traffic in the
 * Flex system. It has a number of endpoints which send and
 * receive messages over the network, and it has a number of
 * services that are message destinations. The broker routes
 * decoded messages received by endpoints to services based
 * on the service destination specified in each message.
 * The broker also has a means of pushing messages back through
 * endpoints to clients.
 */
public class MessageBroker
{
    //--------------------------------------------------------------------------
    //
    // Public Static Constants
    //
    //--------------------------------------------------------------------------

    /**
     * Log category for <code>MessageBroker</code>.
     */
    public static final String LOG_CATEGORY = LogCategories.MESSAGE_GENERAL;

    /**
     * Log category that captures startup information for broker's destinations.
     */
    public static final String LOG_CATEGORY_STARTUP_SERVICE = LogCategories.STARTUP_SERVICE;

    /** @exclude */
    public static final String TYPE = "MessageBroker";

    //--------------------------------------------------------------------------
    //
    // Package Protected Static Constants
    //
    //--------------------------------------------------------------------------
    /** The default message broker id when one is not specified in web.xml. */
    static final String DEFAULT_BROKER_ID = "__default__";

    /** A map of currently available message brokers indexed by message broker id. */
    static final Map<String, MessageBroker> messageBrokers = new HashMap<String, MessageBroker>();

    //--------------------------------------------------------------------------
    //
    // Private Static Constants
    //
    //--------------------------------------------------------------------------

    private static final String LOG_MANAGER_ID = "log";
    private static final Integer INTEGER_ONE = 1;

    // Error numbers
    private static final int ERR_MSG_NO_SERVICE_FOR_DEST = 10004;
    private static final int ERR_MSG_DESTINATION_UNACCESSIBLE = 10005;
    private static final int ERR_MSG_UNKNOWN_REMOTE_CREDENTIALS_FORMAT = 10020;
    private static final int ERR_MSG_NULL_MESSAGE_ID = 10029;
    private static final int ERR_MSG_CANNOT_SERVICE_STOPPED = 10038;
    private static final int ERR_MSG_NULL_ENDPOINT_URL = 10128;
    private static final int ERR_MSG_SERVICE_CMD_NOT_SUPPORTED = 10451;
    private static final int ERR_MSG_URI_ALREADY_REGISTERED = 11109;

    private static ThreadLocal<SystemSettings> systemSettingsThreadLocal = new ThreadLocal<SystemSettings>();


    /** @exclude */
    public static SystemSettings getSystemSettings()
    {
        SystemSettings ss = systemSettingsThreadLocal.get();
        if (ss == null)
        {
            ss = new SystemSettings();
            systemSettingsThreadLocal.set(ss);
        }
        return ss;
    }


    /** @exclude */
    public void clearSystemSettingsThreadLocal()
    {
        systemSettingsThreadLocal.remove();
    }

    /** @exclude */
    public static void releaseThreadLocalObjects()
    {
        systemSettingsThreadLocal = null;
    }

    /** @exclude */
    public static void createThreadLocalObjects()
    {
        if (systemSettingsThreadLocal == null)
            systemSettingsThreadLocal = new ThreadLocal<SystemSettings>();
    }

   
   
}