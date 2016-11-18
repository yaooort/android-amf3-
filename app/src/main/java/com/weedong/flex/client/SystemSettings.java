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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @exclude
 */
public class SystemSettings
{
    private ResourceLoader resourceLoader;
    private Locale defaultLocale;
    private boolean enforceEndpointValidation;
    private boolean manageable;
    private boolean redeployEnabled;
    private int watchInterval;
    private List watches;
    private List touches;

    public SystemSettings()
    {
        enforceEndpointValidation = false;
        manageable = true;
        redeployEnabled = false;
        resourceLoader = new PropertyStringResourceLoader();
        touches = new ArrayList();
        watches = new ArrayList();
        watchInterval = 20;
    }

    public void setDefaultLocale(Locale locale)
    {
        defaultLocale = locale;
        resourceLoader.setDefaultLocale(defaultLocale);
    }

    public Locale getDefaultLocale()
    {
        return defaultLocale;
    }

    public boolean isManageable()
    {
        return manageable;
    }

    public void setManageable(String manageable)
    {
        manageable = manageable.toLowerCase();
        if (manageable.startsWith("f"))
            this.manageable = false;
    }

    public boolean isEnforceEndpointValidation()
    {
        return enforceEndpointValidation;
    }

    public void setEnforceEndpointValidation(String enforceEndpointValidation)
    {
        if (enforceEndpointValidation == null || enforceEndpointValidation.length() == 0)
            return;
        if (enforceEndpointValidation.toLowerCase().startsWith("t"))
            this.enforceEndpointValidation = true;
    }

    public ResourceLoader getResourceLoader()
    {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader)
    {
        this.resourceLoader = resourceLoader;
    }

    public void setRedeployEnabled(String enabled)
    {
        enabled = enabled.toLowerCase();
        if (enabled.startsWith("t"))
            this.redeployEnabled = true;
    }

    public boolean getRedeployEnabled()
    {
        return redeployEnabled;
    }

    public void setWatchInterval(String interval)
    {
        this.watchInterval = Integer.parseInt(interval);
    }

    public int getWatchInterval()
    {
        return watchInterval;
    }

    public void addWatchFile(String watch)
    {
        this.watches.add(watch);
    }

    public List getWatchFiles()
    {
        return watches;
    }

    public void addTouchFile(String touch)
    {
        this.touches.add(touch);
    }

    public List getTouchFiles()
    {
        return touches;
    }

   
    /**
     * Clean up static member variables.
     */
    public void clear()
    {
        resourceLoader = null;
        defaultLocale = null;
        watches = null;
        touches = null;
    }

}
